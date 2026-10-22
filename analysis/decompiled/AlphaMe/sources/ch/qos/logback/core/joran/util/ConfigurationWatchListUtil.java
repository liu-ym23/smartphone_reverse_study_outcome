package ch.qos.logback.core.joran.util;

import ch.qos.logback.core.Context;
import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.joran.spi.ConfigurationWatchList;
import ch.qos.logback.core.status.InfoStatus;
import ch.qos.logback.core.status.Status;
import ch.qos.logback.core.status.StatusManager;
import ch.qos.logback.core.status.WarnStatus;
import java.net.URL;

/* loaded from: classes.dex */
public class ConfigurationWatchListUtil {
    static final ConfigurationWatchListUtil origin = new ConfigurationWatchListUtil();

    private ConfigurationWatchListUtil() {
    }

    public static void addInfo(Context context, String str) {
        addStatus(context, new InfoStatus(str, origin));
    }

    public static void addStatus(Context context, Status status) {
        if (context == null) {
            System.out.println("Null context in ".concat(ConfigurationWatchList.class.getName()));
            return;
        }
        StatusManager statusManager = context.getStatusManager();
        if (statusManager == null) {
            return;
        }
        statusManager.add(status);
    }

    public static void addToWatchList(Context context, URL url) {
        ConfigurationWatchList configurationWatchList = getConfigurationWatchList(context);
        if (configurationWatchList == null) {
            addWarn(context, "Null ConfigurationWatchList. Cannot add " + url);
        } else {
            addInfo(context, "Adding [" + url + "] to configuration watch list.");
            configurationWatchList.addToWatchList(url);
        }
    }

    public static void addWarn(Context context, String str) {
        addStatus(context, new WarnStatus(str, origin));
    }

    public static ConfigurationWatchList getConfigurationWatchList(Context context) {
        return (ConfigurationWatchList) context.getObject(CoreConstants.CONFIGURATION_WATCH_LIST);
    }

    public static URL getMainWatchURL(Context context) {
        ConfigurationWatchList configurationWatchList = getConfigurationWatchList(context);
        if (configurationWatchList == null) {
            return null;
        }
        return configurationWatchList.getMainURL();
    }

    public static void setConfigurationWatchListResetFlag(Context context, boolean z4) {
        context.putObject(CoreConstants.CONFIGURATION_WATCH_LIST_RESET, new Boolean(z4));
    }

    public static void setMainWatchURL(Context context, URL url) {
        ConfigurationWatchList configurationWatchList = getConfigurationWatchList(context);
        if (configurationWatchList == null) {
            configurationWatchList = new ConfigurationWatchList();
            configurationWatchList.setContext(context);
            context.putObject(CoreConstants.CONFIGURATION_WATCH_LIST, configurationWatchList);
        } else {
            configurationWatchList.clear();
        }
        setConfigurationWatchListResetFlag(context, true);
        configurationWatchList.setMainURL(url);
    }

    public static boolean wasConfigurationWatchListReset(Context context) {
        Object object = context.getObject(CoreConstants.CONFIGURATION_WATCH_LIST_RESET);
        if (object == null) {
            return false;
        }
        return ((Boolean) object).booleanValue();
    }
}
