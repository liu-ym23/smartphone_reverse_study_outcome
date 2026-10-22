package com.stepos.activeview.utils;

import android.util.Log;

/* loaded from: classes.dex */
public class LogUtil {
    public static final String ATTIRBUTE_LOG_LEVEL = "debug.activeview";
    private static boolean SHOW_ERR_WNR_LOG = true;
    private static boolean SHOW_INFO_DEBUG_LOG = true;
    private static final String TAG = "LogUtil";

    private LogUtil() {
    }

    private static boolean canLogDebug() {
        return Log.isLoggable(ATTIRBUTE_LOG_LEVEL, 3);
    }

    private static boolean canLogError() {
        return Log.isLoggable(ATTIRBUTE_LOG_LEVEL, 6);
    }

    private static boolean canLogInfo() {
        return Log.isLoggable(ATTIRBUTE_LOG_LEVEL, 4);
    }

    private static boolean canLogWarn() {
        return Log.isLoggable(ATTIRBUTE_LOG_LEVEL, 5);
    }

    public static void closeLog() {
        SHOW_INFO_DEBUG_LOG = false;
        SHOW_ERR_WNR_LOG = false;
    }

    public static void d(String str) {
        if (SHOW_INFO_DEBUG_LOG && canLogDebug()) {
            Log.d(TAG, str);
        }
    }

    public static void e(String str) {
        if (SHOW_ERR_WNR_LOG && canLogError()) {
            Log.e(TAG, str);
        }
    }

    public static void enableInfoLog(boolean z4) {
        SHOW_INFO_DEBUG_LOG = z4;
    }

    public static void i(String str) {
        if (SHOW_INFO_DEBUG_LOG && canLogInfo()) {
            Log.i(TAG, str);
        }
    }

    public static String makeLogTag(Class cls) {
        return "stepos".concat(cls.getSimpleName());
    }

    public static void w(String str) {
        if (SHOW_ERR_WNR_LOG && canLogWarn()) {
            Log.w(TAG, str);
        }
    }

    public static void d(String str, String str2) {
        if (SHOW_INFO_DEBUG_LOG && canLogDebug()) {
            Log.d(str, str2);
        }
    }

    public static void e(String str, String str2) {
        if (SHOW_ERR_WNR_LOG && canLogError()) {
            Log.e(str, str2);
        }
    }

    public static void i(String str, String str2) {
        if (SHOW_INFO_DEBUG_LOG && canLogInfo()) {
            Log.i(str, str2);
        }
    }

    public static void w(String str, String str2) {
        if (SHOW_ERR_WNR_LOG && canLogWarn()) {
            Log.w(str, str2);
        }
    }

    public static void w(Exception exc) {
        if (SHOW_ERR_WNR_LOG) {
            exc.printStackTrace();
        }
    }
}
