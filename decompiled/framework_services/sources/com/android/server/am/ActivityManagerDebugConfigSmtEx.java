package com.android.server.am;

/* JADX INFO: loaded from: classes.dex */
public class ActivityManagerDebugConfigSmtEx {
    static boolean DEBUG_3RD_BG_APP = false;
    static boolean DEBUG_CHAINBOOT_BLACKLIST = false;
    static boolean DEBUG_CPU_TRACK = false;
    public static boolean DEBUG_FREEZE = false;
    public static String DEBUG_INTELLIGENTENGINE = null;
    static boolean DEBUG_LOCK_PACKAGE = false;
    public static boolean DEBUG_MULTIWINDOW_RC = false;
    public static boolean DEBUG_POWER_KILL = false;
    static boolean DEBUG_WIFI_UPLOAD = false;
    static final String POSTFIX_FREEZE = "";

    public ActivityManagerDebugConfigSmtEx() {
    }

    static {
        DEBUG_FREEZE = true;
        DEBUG_POWER_KILL = true;
        DEBUG_3RD_BG_APP = false;
        DEBUG_CPU_TRACK = false;
        DEBUG_LOCK_PACKAGE = false;
        DEBUG_CHAINBOOT_BLACKLIST = false;
        DEBUG_WIFI_UPLOAD = false;
        DEBUG_MULTIWINDOW_RC = true;
        DEBUG_INTELLIGENTENGINE = IActivityManagerDebugConfigOpt.DEBUG_INTELLIGENTENGINE;
    }

    public static void reset() {
        DEBUG_3RD_BG_APP = false;
        DEBUG_CPU_TRACK = false;
        DEBUG_LOCK_PACKAGE = false;
        DEBUG_CHAINBOOT_BLACKLIST = false;
        DEBUG_WIFI_UPLOAD = false;
    }
}
