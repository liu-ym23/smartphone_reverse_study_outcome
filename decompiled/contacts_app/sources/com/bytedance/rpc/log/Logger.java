package com.bytedance.rpc.log;

import android.util.Log;
import com.bytedance.rpc.internal.RpcUtils;

/* JADX INFO: loaded from: classes2.dex */
public class Logger {
    private static Loggable sLogDelegate = null;
    private static LogInterceptor sLogIntercept = null;
    private static LogLevel sLogLevel = null;
    private static String sTag = "tt-rpc";

    public Logger() {
    }

    static {
        sLogLevel = LogLevel.DEBUG;
    }

    public static void setLogDelegate(Loggable r0) {
        sLogDelegate = r0;
    }

    public static void setLogIntercept(LogInterceptor r0) {
        sLogIntercept = r0;
    }

    public static void setLogLevel(LogLevel r0) {
        if (r0 == null) goto L5;
        sLogLevel = r0;
        return;
    }

    public static void setLogTag(String r0) {
        sTag = r0;
    }

    public static void v(CharSequence r1) {
        v(null, r1);
    }

    public static void d(CharSequence r1) {
        d(null, r1);
    }

    public static void i(CharSequence r1) {
        i(null, r1);
    }

    public static void w(CharSequence r1) {
        w(null, r1);
    }

    public static void e(CharSequence r1) {
        e(null, r1);
    }

    public static void v(String r2, CharSequence r3) {
        if (shouldLog(LogLevel.VERBOSE) == true) goto L5;
        return;
    L5:
        if (RpcUtils.isVisible(r3) == false) goto L16;
        String r4 = tag(r2);
        LogInterceptor r0 = sLogIntercept;
        if (r0 != null) goto L9;
    L10:
        Loggable r1 = sLogDelegate;
        if (r1 != null) goto L13;
        Log.v(r4, r3.toString());
        return;
    L13:
        r1.v(r4, r3.toString());
        return;
    L9:
        if (r0.onInterceptLog(r4, r3, LogLevel.VERBOSE) == false) goto L10;
        return;
    }

    public static void d(String r2, CharSequence r3) {
        if (shouldLog(LogLevel.DEBUG) == true) goto L5;
        return;
    L5:
        if (RpcUtils.isVisible(r3) == false) goto L16;
        String r4 = tag(r2);
        LogInterceptor r0 = sLogIntercept;
        if (r0 != null) goto L9;
    L10:
        Loggable r1 = sLogDelegate;
        if (r1 != null) goto L13;
        Log.d(r4, r3.toString());
        return;
    L13:
        r1.d(r4, r3.toString());
        return;
    L9:
        if (r0.onInterceptLog(r4, r3, LogLevel.DEBUG) == false) goto L10;
        return;
    }

    public static void i(String r2, CharSequence r3) {
        if (shouldLog(LogLevel.INFO) == true) goto L5;
        return;
    L5:
        if (RpcUtils.isVisible(r3) == false) goto L16;
        String r4 = tag(r2);
        LogInterceptor r0 = sLogIntercept;
        if (r0 != null) goto L9;
    L10:
        Loggable r1 = sLogDelegate;
        if (r1 != null) goto L13;
        Log.i(r4, r3.toString());
        return;
    L13:
        r1.i(r4, r3.toString());
        return;
    L9:
        if (r0.onInterceptLog(r4, r3, LogLevel.INFO) == false) goto L10;
        return;
    }

    public static void w(String r2, CharSequence r3) {
        if (shouldLog(LogLevel.WARN) == true) goto L5;
        return;
    L5:
        if (RpcUtils.isVisible(r3) == false) goto L16;
        String r4 = tag(r2);
        LogInterceptor r0 = sLogIntercept;
        if (r0 != null) goto L9;
    L10:
        Loggable r1 = sLogDelegate;
        if (r1 != null) goto L13;
        Log.w(r4, r3.toString());
        return;
    L13:
        r1.w(r4, r3.toString());
        return;
    L9:
        if (r0.onInterceptLog(r4, r3, LogLevel.WARN) == false) goto L10;
        return;
    }

    public static void e(String r2, CharSequence r3) {
        if (shouldLog(LogLevel.ERROR) == true) goto L5;
        return;
    L5:
        if (RpcUtils.isVisible(r3) == false) goto L16;
        String r4 = tag(r2);
        LogInterceptor r0 = sLogIntercept;
        if (r0 != null) goto L9;
    L10:
        Loggable r1 = sLogDelegate;
        if (r1 != null) goto L13;
        Log.e(r4, r3.toString());
        return;
    L13:
        r1.e(r4, r3.toString());
        return;
    L9:
        if (r0.onInterceptLog(r4, r3, LogLevel.ERROR) == false) goto L10;
        return;
    }

    public static void e(Throwable r1) {
        e(r1, false);
    }

    public static void e(Throwable r1, boolean r2) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (shouldLog(LogLevel.ERROR) == false) goto L18;
        LogInterceptor r0 = sLogIntercept;
        if (r0 != null) goto L8;
    L9:
        Loggable r3 = sLogDelegate;
        if (r3 != null) goto L15;
        String r4 = tag(null);
        if (r4 != null) goto L14;
        r4 = "error";
    L14:
        e(r4, DefaultErrorFormatter.get().getDescription(r1));
        return;
    L15:
        r3.e(r1, r2);
        return;
    L8:
        if (r0.onInterceptError(r1, r2) == false) goto L9;
        return;
    }

    private static String tag(String r5) {
        if (RpcUtils.isInvisible(r5) == false) goto L24;
        if (r5 == null) goto L6;
    L9:
        StackTraceElement[] r0 = new Throwable().getStackTrace();
        int r1 = 2;
    L11:
        if (r1 >= 4) goto L26;
        StackTraceElement r2 = r0[r1];
        if (Logger.class.getName().equals(r2.getClassName()) == false) goto L15;
        r1 = r1 + 1;
        goto L11
    L15:
        String r6 = r2.getFileName();
        if (r6 != null) goto L18;
        int r3 = -1;
    L19:
        if (r3 > 0) goto L21;
        return r6;
    L21:
        return r6.substring(0, r3);
    L18:
        r3 = r6.lastIndexOf(46);
        goto L19
    L26:
        return r5;
    L6:
        if (RpcUtils.isVisible(sTag) == false) goto L9;
        return sTag;
    L24:
        return r5;
    }

    public static final boolean isLoggable() {
        return sLogLevel.log();
    }

    public static final boolean isLoggableV() {
        return shouldLog(LogLevel.VERBOSE);
    }

    public static final boolean isLoggableD() {
        return shouldLog(LogLevel.DEBUG);
    }

    public static final boolean isLoggableI() {
        return shouldLog(LogLevel.INFO);
    }

    public static final boolean isLoggableW() {
        return shouldLog(LogLevel.WARN);
    }

    public static final boolean isLoggableE() {
        return shouldLog(LogLevel.ERROR);
    }

    private static boolean shouldLog(LogLevel r2) {
        if (r2 != null) goto L5;
    L14:
        return false;
    L5:
        if (isLoggable() == false) goto L14;
        Loggable r1 = sLogDelegate;
        if (r1 != null) goto L13;
        if (sLogLevel.ordinal() > r2.ordinal()) goto L15;
        return true;
    L15:
        return false;
    L13:
        return r1.isLoggable(r2);
    }
}
