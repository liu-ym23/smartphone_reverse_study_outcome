package ch.qos.logback.classic.selector.servlet;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.selector.ContextJNDISelector;
import ch.qos.logback.classic.selector.ContextSelector;
import ch.qos.logback.classic.util.ContextSelectorStaticBinder;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import n3.AbstractC0782c;

/* loaded from: classes.dex */
public class LoggerContextFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws ServletException, IOException {
        ContextJNDISelector contextJNDISelector;
        LoggerContext loggerContext = (LoggerContext) AbstractC0782c.c();
        ContextSelector contextSelector = ContextSelectorStaticBinder.getSingleton().getContextSelector();
        if (contextSelector instanceof ContextJNDISelector) {
            contextJNDISelector = (ContextJNDISelector) contextSelector;
            contextJNDISelector.setLocalContext(loggerContext);
        } else {
            contextJNDISelector = null;
        }
        try {
            filterChain.doFilter(servletRequest, servletResponse);
        } finally {
            if (contextJNDISelector != null) {
                contextJNDISelector.removeLocalContext();
            }
        }
    }

    public void init(FilterConfig filterConfig) throws ServletException {
    }
}
