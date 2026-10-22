package com.bytedance.privacy.utils;

import android.util.Log;

/* JADX INFO: loaded from: classes2.dex */
public class LogUtils {
    private static final boolean LOG_DEBUG = false;

    public LogUtils() {
    }

    static {
        LOG_DEBUG = PrivacyConfig.isDebug();
    }

    public static void d(String r0, String r1, Throwable r2) {
        if (LOG_DEBUG == false) goto L6;
        Log.i(r0, r1);
        return;
    }

    public static void i(String r0, String r1, Throwable r2) {
        Log.i(r0, r1);
    }

    public static void e(String r0, String r1, Throwable r2) {
        Log.e(r0, r1, r2);
    }

    public static void d(String r1, String r2) {
        if (LOG_DEBUG == false) goto L6;
        Log.i(r1, r2);
        return;
    }

    public static void i(String r0, String r1) {
        Log.i(r0, r1);
    }

    public static void w(String r0, String r1) {
        Log.w(r0, r1);
    }

    public static void e(String r0, String r1) {
        Log.e(r0, r1);
    }
}
