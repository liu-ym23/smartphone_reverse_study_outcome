package ch.qos.logback.classic.helpers;

import ch.qos.logback.classic.ClassicConstants;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import n3.AbstractC0783d;

/* loaded from: classes.dex */
public class MDCInsertingServletFilter implements Filter {
    public void clearMDC() {
        AbstractC0783d.b(ClassicConstants.REQUEST_REMOTE_HOST_MDC_KEY);
        AbstractC0783d.b(ClassicConstants.REQUEST_REQUEST_URI);
        AbstractC0783d.b(ClassicConstants.REQUEST_QUERY_STRING);
        AbstractC0783d.b(ClassicConstants.REQUEST_REQUEST_URL);
        AbstractC0783d.b(ClassicConstants.REQUEST_USER_AGENT_MDC_KEY);
        AbstractC0783d.b(ClassicConstants.REQUEST_X_FORWARDED_FOR);
    }

    public void destroy() {
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws ServletException, IOException {
        insertIntoMDC(servletRequest);
        try {
            filterChain.doFilter(servletRequest, servletResponse);
        } finally {
            clearMDC();
        }
    }

    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void insertIntoMDC(ServletRequest servletRequest) {
        AbstractC0783d.a(ClassicConstants.REQUEST_REMOTE_HOST_MDC_KEY, servletRequest.getRemoteHost());
        if (servletRequest instanceof HttpServletRequest) {
            HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
            AbstractC0783d.a(ClassicConstants.REQUEST_REQUEST_URI, httpServletRequest.getRequestURI());
            StringBuffer requestURL = httpServletRequest.getRequestURL();
            if (requestURL != null) {
                AbstractC0783d.a(ClassicConstants.REQUEST_REQUEST_URL, requestURL.toString());
            }
            AbstractC0783d.a(ClassicConstants.REQUEST_QUERY_STRING, httpServletRequest.getQueryString());
            AbstractC0783d.a(ClassicConstants.REQUEST_USER_AGENT_MDC_KEY, httpServletRequest.getHeader("User-Agent"));
            AbstractC0783d.a(ClassicConstants.REQUEST_X_FORWARDED_FOR, httpServletRequest.getHeader("X-Forwarded-For"));
        }
    }
}
