package com.stepos.activeview.utils;

import android.content.Context;
import com.stepos.activeview.version.Version;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class ActiveUsageStatsUtils {
    public static final String APP_PACKAGE_NAME = "_app_package_name_";
    public static final String APP_PACKAGE_VERSION_NAME = "_app_package_version_name_";
    public static final String EVENT_APP_PACKAGE_INFO = "event_app_package_info";
    public static final String EVENT_CLICK = "active_click";
    public static final String EVENT_DOWNLOAD = "download_resource_file";
    public static final String EVENT_EXCEPTION = "active_exception";
    public static final String EVENT_LOAD_ACT_FILE = "load_act_file";
    public static final String EVENT_LOAD_IMAGE_FILE = "load_image_file";
    public static final String EVENT_UPGRADE = "active_upgrade_result";
    public static final String EVENT_UPGRADE_REQUEST = "active_upgrade_request";
    public static final String EVENT_VERSION_FREQUENCY = "version_frequency";
    public static final String EXCEPTION_DESCRIPTION = "active_exception_description";
    public static final String FILE_URL = "_file_url_";
    public static final String RES_TYPE = "_resource_type_";
    public static final String RES_TYPE_ANIM = "res_type_animation";
    public static final String RES_TYPE_STATIC = "res_type_static";
    public static final String STATE = "_state_";
    public static final String STATE_FAIL = "state_fail";
    public static final String STATE_INFO = "_state_info_";
    public static final String STATE_SUCCESS = "state_success";
    public static final String UPGRADE_PROPERTY_ACT_VERSION = "upgrade_act_file_version";
    public static final String UPGRADE_PROPERTY_JAR_VERSION = "upgrade_jar_file_version";
    public static final String UPGRADE_PROPERTY_LOCAL_VERSION = "upgrade_local_version";
    public static final String UPGRADE_VERSION_NUMBER = "_upgrade_version_number_";
    public static final String VERSION_NUMBER = "_version_number_";
    private static String appPackageName;
    private static String appPackageVersion;
    private static ActiveUsageStatsUtils mActiveUsageStatsUtilsInstance;

    private ActiveUsageStatsUtils(Context context) {
        appPackageName = Utility.getAppPackageName(context);
        appPackageVersion = Utility.getAppVersionName(context);
    }

    public static ActiveUsageStatsUtils getInstance() {
        return mActiveUsageStatsUtilsInstance;
    }

    private static void initInstance(Context context) {
        if (mActiveUsageStatsUtilsInstance == null) {
            synchronized (ActiveUsageStatsUtils.class) {
                try {
                    if (mActiveUsageStatsUtilsInstance == null && context != null) {
                        mActiveUsageStatsUtilsInstance = new ActiveUsageStatsUtils(context.getApplicationContext());
                    }
                } finally {
                }
            }
        }
    }

    public static void initialize(Context context) {
        initInstance(context);
    }

    public static boolean isResTypeAnim(String str) {
        return str != null && (str.endsWith(".zip") || str.endsWith(".act"));
    }

    public static void recordClickEvent(String str) {
        if (getInstance() == null || str == null) {
            return;
        }
        HashMap map = new HashMap();
        map.put(APP_PACKAGE_NAME, appPackageName);
        map.put(APP_PACKAGE_VERSION_NAME, appPackageVersion);
        String str2 = Version.sRealVersion;
        String str3 = Version.VERSION;
        if (!str2.equals(Version.VERSION)) {
            str3 = Version.sRealVersion;
        }
        map.put(VERSION_NUMBER, str3);
        map.put(RES_TYPE, isResTypeAnim(str) ? RES_TYPE_ANIM : RES_TYPE_STATIC);
        getInstance().recordEvent(EVENT_CLICK, "", map);
    }

    public static void recordException(String str, String str2) {
        ActiveUsageStatsUtils activeUsageStatsUtils = getInstance();
        if (activeUsageStatsUtils != null) {
            LogUtil.e("Exception", "Exception: " + str2);
            HashMap map = new HashMap();
            map.put(APP_PACKAGE_NAME, appPackageName);
            map.put(APP_PACKAGE_VERSION_NAME, appPackageVersion);
            map.put(VERSION_NUMBER, Version.VERSION);
            if (!Version.sRealVersion.equals(Version.VERSION)) {
                map.put(UPGRADE_VERSION_NUMBER, Version.sRealVersion);
            }
            map.put(FILE_URL, str);
            map.put(EXCEPTION_DESCRIPTION, str2);
            activeUsageStatsUtils.recordEvent(EVENT_EXCEPTION, "", map);
        }
    }

    public static void recordUseEvent(String str, String str2, String str3) {
        if (getInstance() != null) {
            HashMap map = new HashMap();
            map.put(STATE, str3);
            map.put(FILE_URL, str2);
            getInstance().recordEvent(str, "", map);
        }
    }

    @Deprecated
    public void onEvent(String str, String str2, String str3) {
    }

    public void recordEvent(String str, String str2, String str3) {
        mActiveUsageStatsUtilsInstance.onEvent(str, str2, str3);
    }

    @Deprecated
    public void setEnableUploaded(boolean z4) {
    }

    public void onEvent(String str, String str2, Map map) {
    }

    public void recordEvent(String str, String str2, Map map) {
        mActiveUsageStatsUtilsInstance.onEvent(str, str2, map);
    }
}
