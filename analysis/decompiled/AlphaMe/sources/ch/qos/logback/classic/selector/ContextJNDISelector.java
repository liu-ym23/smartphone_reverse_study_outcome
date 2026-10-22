package ch.qos.logback.classic.selector;

import B0.g;
import ch.qos.logback.classic.ClassicConstants;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.classic.util.ContextInitializer;
import ch.qos.logback.classic.util.JNDIUtil;
import ch.qos.logback.core.joran.spi.JoranException;
import ch.qos.logback.core.status.InfoStatus;
import ch.qos.logback.core.status.StatusManager;
import ch.qos.logback.core.status.StatusUtil;
import ch.qos.logback.core.status.WarnStatus;
import ch.qos.logback.core.util.Loader;
import ch.qos.logback.core.util.StatusPrinter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.naming.Context;
import javax.naming.NamingException;

/* loaded from: classes.dex */
public class ContextJNDISelector implements ContextSelector {
    private static final ThreadLocal<LoggerContext> threadLocal = new ThreadLocal<>();
    private final LoggerContext defaultContext;
    private final Map<String, LoggerContext> synchronizedContextMap = Collections.synchronizedMap(new HashMap());

    public ContextJNDISelector(LoggerContext loggerContext) {
        this.defaultContext = loggerContext;
    }

    private void configureLoggerContextByURL(LoggerContext loggerContext, URL url) throws IOException {
        try {
            JoranConfigurator joranConfigurator = new JoranConfigurator();
            loggerContext.reset();
            joranConfigurator.setContext(loggerContext);
            joranConfigurator.doConfigure(url);
        } catch (JoranException unused) {
        }
        StatusPrinter.printInCaseOfErrorsOrWarnings(loggerContext);
    }

    private String conventionalConfigFileName(String str) {
        return g.n("logback-", str, ".xml");
    }

    private URL findConfigFileURL(Context context, LoggerContext loggerContext) {
        StatusManager statusManager = loggerContext.getStatusManager();
        String strLookup = JNDIUtil.lookup(context, ClassicConstants.JNDI_CONFIGURATION_RESOURCE);
        if (strLookup == null) {
            return urlByResourceName(statusManager, conventionalConfigFileName(loggerContext.getName()));
        }
        statusManager.add(new InfoStatus(g.n("Searching for [", strLookup, "]"), this));
        URL urlUrlByResourceName = urlByResourceName(statusManager, strLookup);
        if (urlUrlByResourceName == null) {
            StringBuilder sbW = g.w("The jndi resource [", strLookup, "] for context [");
            sbW.append(loggerContext.getName());
            sbW.append("] does not lead to a valid file");
            statusManager.add(new WarnStatus(sbW.toString(), this));
        }
        return urlUrlByResourceName;
    }

    private URL urlByResourceName(StatusManager statusManager, String str) {
        statusManager.add(new InfoStatus(g.n("Searching for [", str, "]"), this));
        URL resource = Loader.getResource(str, Loader.getTCL());
        return resource != null ? resource : Loader.getResourceBySelfClassLoader(str);
    }

    @Override // ch.qos.logback.classic.selector.ContextSelector
    public LoggerContext detachLoggerContext(String str) {
        return this.synchronizedContextMap.remove(str);
    }

    @Override // ch.qos.logback.classic.selector.ContextSelector
    public List<String> getContextNames() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.synchronizedContextMap.keySet());
        return arrayList;
    }

    public int getCount() {
        return this.synchronizedContextMap.size();
    }

    @Override // ch.qos.logback.classic.selector.ContextSelector
    public LoggerContext getDefaultLoggerContext() {
        return this.defaultContext;
    }

    @Override // ch.qos.logback.classic.selector.ContextSelector
    public LoggerContext getLoggerContext() throws IllegalStateException, IOException {
        Context initialContext;
        LoggerContext loggerContext = threadLocal.get();
        if (loggerContext != null) {
            return loggerContext;
        }
        String strLookup = null;
        try {
            initialContext = JNDIUtil.getInitialContext();
            try {
                strLookup = JNDIUtil.lookup(initialContext, ClassicConstants.JNDI_CONTEXT_NAME);
            } catch (NamingException unused) {
            }
        } catch (NamingException unused2) {
            initialContext = null;
        }
        if (strLookup == null) {
            return this.defaultContext;
        }
        LoggerContext loggerContext2 = this.synchronizedContextMap.get(strLookup);
        if (loggerContext2 == null) {
            loggerContext2 = new LoggerContext();
            loggerContext2.setName(strLookup);
            this.synchronizedContextMap.put(strLookup, loggerContext2);
            URL urlFindConfigFileURL = findConfigFileURL(initialContext, loggerContext2);
            if (urlFindConfigFileURL != null) {
                configureLoggerContextByURL(loggerContext2, urlFindConfigFileURL);
            } else {
                try {
                    new ContextInitializer(loggerContext2).autoConfig();
                } catch (JoranException unused3) {
                }
            }
            if (!StatusUtil.contextHasStatusListener(loggerContext2)) {
                StatusPrinter.printInCaseOfErrorsOrWarnings(loggerContext2);
            }
        }
        return loggerContext2;
    }

    public void removeLocalContext() {
        threadLocal.remove();
    }

    public void setLocalContext(LoggerContext loggerContext) {
        threadLocal.set(loggerContext);
    }

    @Override // ch.qos.logback.classic.selector.ContextSelector
    public LoggerContext getLoggerContext(String str) {
        return this.synchronizedContextMap.get(str);
    }
}
