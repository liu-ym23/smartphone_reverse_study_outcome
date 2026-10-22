package ch.qos.logback.classic.selector.servlet;

import ch.qos.logback.classic.ClassicConstants;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.selector.ContextSelector;
import ch.qos.logback.classic.util.ContextSelectorStaticBinder;
import ch.qos.logback.classic.util.JNDIUtil;
import java.io.PrintStream;
import javax.naming.NamingException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/* loaded from: classes.dex */
public class ContextDetachingSCL implements ServletContextListener {
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        String strLookup;
        try {
            strLookup = JNDIUtil.lookup(JNDIUtil.getInitialContext(), ClassicConstants.JNDI_CONTEXT_NAME);
        } catch (NamingException unused) {
            strLookup = null;
        }
        if (strLookup != null) {
            PrintStream printStream = System.out;
            printStream.println("About to detach context named ".concat(strLookup));
            ContextSelector contextSelector = ContextSelectorStaticBinder.getSingleton().getContextSelector();
            if (contextSelector == null) {
                printStream.println("Selector is null, cannot detach context. Skipping.");
                return;
            }
            LoggerContext loggerContext = contextSelector.getLoggerContext(strLookup);
            if (loggerContext != null) {
                loggerContext.getLogger("ROOT").warn("Stopping logger context ".concat(strLookup));
                contextSelector.detachLoggerContext(strLookup);
                loggerContext.stop();
            } else {
                printStream.println("No context named " + strLookup + " was found.");
            }
        }
    }

    public void contextInitialized(ServletContextEvent servletContextEvent) {
    }
}
