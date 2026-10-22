package com.android.server.am;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public interface IActivityManagerDebugConfigOpt {
    public static final boolean DEBUG_3RD_BG_APP = false;
    public static final boolean DEBUG_CHAINBOOT_BLACKLIST = false;
    public static final boolean DEBUG_CPU_TRACK = false;
    public static final boolean DEBUG_FREEZE = true;
    public static final String DEBUG_INTELLIGENTENGINE = "DEBUG_INTELLIGENTENGINE";
    public static final boolean DEBUG_LOCK_PACKAGE = false;
    public static final boolean DEBUG_POWER_KILL = true;
    public static final boolean DEBUG_WIFI_UPLOAD = false;
    public static final String POSTFIX_FREEZE = "";

    static {
        DEBUG_3RD_BG_APP = Log.isLoggable("Bg3rdApp", 3);
        DEBUG_CPU_TRACK = Log.isLoggable("CpuTracker", 3);
    }
}
