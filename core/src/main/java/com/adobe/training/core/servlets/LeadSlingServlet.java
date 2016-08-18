package com.adobe.training.core.servlets;

import java.io.IOException;
import javax.jcr.Repository;
import javax.servlet.ServletException;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;

@SlingServlet(resourceTypes="/apps/geometrixx/components/lead", extensions="html", selectors="lead-sling-servlet")

public class LeadSlingServlet extends SlingSafeMethodsServlet {
    private static final long serialVersionUID = 6165211752185245787L;

    @Reference
    private Repository repository;
    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Content-Type", "text/html");
        String[] keys = repository.getDescriptorKeys();
        response.getWriter().print("<br><table border='1'><th>Repository Descriptor</th><th>Value</th>");
        for (int i = 0; i< keys.length; i++) {
            try{
                response.getWriter().print("<tr><td>" + keys[i] + "</td><td>" + repository.getDescriptor(keys[i]) + "</td></tr>");
            }
            finally {
            }
        }
        response.getWriter().print("</table>");

    }
}
