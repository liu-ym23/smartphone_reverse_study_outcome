package com.bytedance.ttnet.debug;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes2.dex */
public class DebugSetting {
    private static String KEY_LOG_SWITCHER = "log_switcher";
    private static String KEY_X86_SWITCHER = "x86_support";
    private static String TTNET_DEBUG_SETTING = "ttnet_debug_setting";

    static {
    }

    public DebugSetting() {
    }

    private static String getSharePref(Context r3, String r4) {
        if (r3 != null) goto L5;
        return null;
    L5:
        return r3.getSharedPreferences(TTNET_DEBUG_SETTING, 0).getString(r4, null);
    }

    private static void putSharePref(Context r2, String r3, String r4) {
        if (r2 == null) goto L5;
        SharedPreferences.Editor r5 = r2.getSharedPreferences(TTNET_DEBUG_SETTING, 0).edit();
        r5.putString(r3, r4);
        r5.apply();
        return;
    }

    public static void logSwitcher(Context r1, boolean r2) {
        putSharePref(r1, KEY_LOG_SWITCHER, String.valueOf(r2));
    }

    public static boolean isLogOpen(Context r1) {
        return "true".equals(getSharePref(r1, KEY_LOG_SWITCHER));
    }

    public static void x86Support(Context r1, boolean r2) {
        putSharePref(r1, KEY_X86_SWITCHER, String.valueOf(r2));
    }

    public static boolean isX86Support(Context r1) {
        return "true".equals(getSharePref(r1, KEY_X86_SWITCHER));
    }
}
