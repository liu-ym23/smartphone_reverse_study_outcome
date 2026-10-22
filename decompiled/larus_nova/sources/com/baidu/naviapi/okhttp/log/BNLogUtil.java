package com.baidu.naviapi.okhttp.log;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes39.dex */
public class BNLogUtil {
    private static final String TAG = "BNLogUtil";
    private static boolean debug;
    private static String logPath;
    private static boolean writable;

    public BNLogUtil() {
    }

    public static boolean isWritable() {
        return writable;
    }

    private static String getDateStr(String r100) {
        return new SimpleDateFormat(r100).format(new Date(System.currentTimeMillis()));
    }

    public static void logI(String r100) {
        if (debug == true) goto L6;
        return;
    L6:
        if (writable == false) goto L9;
        saveLog("i BNLogUtil", r100);
        return;
    }

    public static void printStack(String r100) {
        if (writable == true) goto L5;
        return;
    L5:
        if (debug == false) goto L13;
        StackTraceElement[] r101 = ThreadMethodProxy.currentThread().getStackTrace();
        AtomicReference r102 = new AtomicReference(new StringBuffer());
        ((StringBuffer) r102.get()).append(r100);
        int r103 = r101.length;
        int r104 = 0;
    L7:
        if (r104 >= r103) goto L9;
        StackTraceElement r105 = r101[r104];
        ((StringBuffer) r102.get()).append(r105.toString());
        r104 = r104 + 1;
        goto L7
    L9:
        logE(TAG, ((StringBuffer) r102.get()).toString());
        return;
    }

    public static void setLogPath(String r100) {
        logPath = r100 + "/bnalog";
    }

    public static void setLogable(boolean r100) {
        debug = r100;
    }

    public static void setWritable(boolean r100) {
        writable = r100;
    }

    public static void logE(String r100, String r101) {
        if (debug == true) goto L6;
        return;
    L6:
        if (writable == true) goto L8;
        return;
    L8:
        if (r101 == null) goto L10;
        saveLog("e BNLogUtil", r100 + " " + r101);
        return;
    L10:
        saveLog("e BNLogUtil", r100);
    }

    public static void logI(String r100, String r101) {
        if (debug == true) goto L6;
        return;
    L6:
        if (writable == false) goto L9;
        saveLog("i " + r100, r101);
        return;
    }

    private static void saveLog(String r100, String r101) {
        StringBuilder r102 = new StringBuilder();
        long r103 = ThreadMethodProxy.currentThread().getId();
        r102.append(getDateStr("yyyy-MM-dd HH:mm:ss.SSS"));
        r102.append(" ");
        r102.append(r103);
        r102.append(" ");
        r102.append(r100);
        r102.append(" ");
        r102.append(r101);
        SDKDebugFileUtil.get(logPath, getDateStr("yyyy-MM-dd-HH"), false, false).asyncAdd(r102.toString());
    }

    public static void logE(String r100, Throwable r101) {
        if (debug == true) goto L6;
        return;
    L6:
        if (writable == true) goto L8;
        return;
    L8:
        if (r101 == null) goto L10;
        saveLog("e BNLogUtil", r100 + r101);
        return;
    L10:
        saveLog("e BNLogUtil", r100);
    }

    public static void logE(String r100, String r101, Throwable r102) {
        if (debug == true) goto L6;
        return;
    L6:
        if (writable == true) goto L8;
        return;
    L8:
        if (r102 == null) goto L10;
        saveLog("e " + r100, r101 + r102);
        return;
    L10:
        saveLog("e " + r100, r101);
    }
}
