package ch.qos.logback.classic.gaffer;

import ch.qos.logback.classic.ClassicConstants;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.status.ErrorStatus;
import ch.qos.logback.core.status.StatusManager;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;

/* loaded from: classes.dex */
public class GafferUtil {
    private static String ERROR_MSG = "Failed to instantiate ch.qos.logback.classic.gaffer.GafferConfigurator";

    private static void addError(LoggerContext loggerContext, Object obj, String str) {
        addError(loggerContext, obj, str, null);
    }

    private static GafferConfigurator newGafferConfiguratorInstance(LoggerContext loggerContext, Object obj) {
        try {
            return (GafferConfigurator) Class.forName(ClassicConstants.GAFFER_CONFIGURATOR_FQCN).getConstructor(LoggerContext.class).newInstance(loggerContext);
        } catch (ClassNotFoundException e4) {
            addError(loggerContext, obj, ERROR_MSG, e4);
            return null;
        } catch (IllegalAccessException e5) {
            addError(loggerContext, obj, ERROR_MSG, e5);
            return null;
        } catch (InstantiationException e6) {
            addError(loggerContext, obj, ERROR_MSG, e6);
            return null;
        } catch (NoSuchMethodException e7) {
            addError(loggerContext, obj, ERROR_MSG, e7);
            return null;
        } catch (InvocationTargetException e8) {
            addError(loggerContext, obj, ERROR_MSG, e8);
            return null;
        }
    }

    public static void runGafferConfiguratorOn(LoggerContext loggerContext, Object obj, File file) {
        GafferConfigurator gafferConfiguratorNewGafferConfiguratorInstance = newGafferConfiguratorInstance(loggerContext, obj);
        if (gafferConfiguratorNewGafferConfiguratorInstance != null) {
            gafferConfiguratorNewGafferConfiguratorInstance.run(file);
        }
    }

    private static void addError(LoggerContext loggerContext, Object obj, String str, Throwable th) {
        StatusManager statusManager = loggerContext.getStatusManager();
        if (statusManager == null) {
            return;
        }
        statusManager.add(new ErrorStatus(str, obj, th));
    }

    public static void runGafferConfiguratorOn(LoggerContext loggerContext, Object obj, URL url) {
        GafferConfigurator gafferConfiguratorNewGafferConfiguratorInstance = newGafferConfiguratorInstance(loggerContext, obj);
        if (gafferConfiguratorNewGafferConfiguratorInstance != null) {
            gafferConfiguratorNewGafferConfiguratorInstance.run(url);
        }
    }
}
