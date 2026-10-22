package ch.qos.logback.classic.util;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.spi.ContextAware;
import ch.qos.logback.core.spi.LifeCycle;
import ch.qos.logback.core.status.OnConsoleStatusListener;
import ch.qos.logback.core.status.StatusListener;
import ch.qos.logback.core.util.OptionHelper;

/* loaded from: classes.dex */
public class StatusListenerConfigHelper {
    private static void addStatusListener(LoggerContext loggerContext, String str) {
        initListener(loggerContext, ContextInitializer.SYSOUT.equalsIgnoreCase(str) ? new OnConsoleStatusListener() : createListenerPerClassName(loggerContext, str));
    }

    private static StatusListener createListenerPerClassName(LoggerContext loggerContext, String str) {
        try {
            return (StatusListener) OptionHelper.instantiateByClassName(str, (Class<?>) StatusListener.class, loggerContext);
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }

    private static void initListener(LoggerContext loggerContext, StatusListener statusListener) {
        if (statusListener != null) {
            if (statusListener instanceof ContextAware) {
                ((ContextAware) statusListener).setContext(loggerContext);
            }
            if (statusListener instanceof LifeCycle) {
                ((LifeCycle) statusListener).start();
            }
            loggerContext.getStatusManager().add(statusListener);
        }
    }

    public static void installIfAsked(LoggerContext loggerContext) {
        String systemProperty = OptionHelper.getSystemProperty(ContextInitializer.STATUS_LISTENER_CLASS);
        if (OptionHelper.isEmpty(systemProperty)) {
            return;
        }
        addStatusListener(loggerContext, systemProperty);
    }
}
