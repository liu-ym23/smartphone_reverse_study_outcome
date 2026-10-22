package com.stepos.launcher.assistant.utils;

import android.util.Log;

/* loaded from: classes.dex */
public class XLog {
    private static final boolean sEnablePrint = true;

    public static void d(String str, String str2) {
        Log.d(str, str2);
    }

    public static void e(String str, String str2) {
        Log.e(str, str2);
    }

    public static String getTag() {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
        return "[" + stackTraceElement.getFileName() + " | " + stackTraceElement.getLineNumber() + " | " + stackTraceElement.getMethodName() + "]";
    }

    public static void i(String str, String str2) {
        Log.i(str, str2);
    }

    public static void v(String str, String str2) {
        Log.v(str, str2);
    }

    public static void w(String str, String str2) {
        Log.w(str, str2);
    }
}
