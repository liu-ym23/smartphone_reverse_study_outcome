package com.byted.cast.mediacommon.utils;

import com.byted.cast.common.CastLogger;
import com.byted.cast.common.api.ILogger;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes39.dex */
public class Logger {
    private static ArrayList<CastLogger> CastLoggers = null;
    private static int LOG_LEVEL = 4;
    private static String TAG = "MediaCapture";
    private static final Object mLoggerLock = null;
    private static ILogger sLogger;

    public Logger() {
    }

    static {
        mLoggerLock = new Object();
        CastLoggers = new ArrayList();
    }

    public static void addLogger(CastLogger r100) {
        Object r101 = mLoggerLock;
        monitor-enter(r101);
        ArrayList<CastLogger> r102 = CastLoggers;     // Catch: Throwable -> L16
        if (r102 == null) goto L14;
        Iterator<CastLogger> r103 = r102.iterator();     // Catch: Throwable -> L16
    L8:
        if (r103.hasNext() == false) goto L13;
        if (r103.next() != r100) goto L8;
        monitor-exit(r101);     // Catch: Throwable -> L16
        return;
    L13:
        CastLoggers.add(r100);     // Catch: Throwable -> L16
    L14:
        monitor-exit(r101);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        throw th;
    }

    private static String prefix(String r100) {
        if (r100 != null) goto L5;
        return "";
    L5:
        if ("".equals(r100) == false) goto L7;
        return "";
    L7:
        return r100.concat(":");
    }

    public static void removeLogger(CastLogger r100) {
        Object r101 = mLoggerLock;
        monitor-enter(r101);
        ArrayList<CastLogger> r102 = CastLoggers;     // Catch: Throwable -> L16
        if (r102 == null) goto L14;
        Iterator<CastLogger> r103 = r102.iterator();     // Catch: Throwable -> L16
    L8:
        if (r103.hasNext() == false) goto L14;
        CastLogger r104 = r103.next();     // Catch: Throwable -> L16
        if (r104 != r100) goto L8;
        CastLoggers.remove(r104);     // Catch: Throwable -> L16
        monitor-exit(r101);     // Catch: Throwable -> L16
        return;
    L14:
        monitor-exit(r101);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        throw th;
    }

    public static void setLogLevel(int r100) {
        LOG_LEVEL = r100;
    }

    public static void setLogger(ILogger r100) {
        sLogger = r100;
    }

    public static void d(String r100, String r101) {
        if (LOG_LEVEL <= 3) goto L5;
        return;
    L5:
        Object r102 = mLoggerLock;
        monitor-enter(r102);
        ArrayList<CastLogger> r103 = CastLoggers;     // Catch: Throwable -> L19
        if (r103 == null) goto L13;
        Iterator<CastLogger> r104 = r103.iterator();     // Catch: Throwable -> L19
    L11:
        if (r104.hasNext() == false) goto L13;
        r104.next().d(TAG, r101);     // Catch: Throwable -> L19
    L13:
        monitor-exit(r102);     // Catch: Throwable -> L19
        ILogger r105 = sLogger;
        if (r105 == null) goto L17;
        r105.onDebug(TAG, prefix(r100) + r101);
        return;
    L17:
        prefix(r100);
        return;
    L19:
        th = move-exception;
        throw th;
    }

    public static void e(String r100, String r101) {
        if (LOG_LEVEL <= 6) goto L5;
        return;
    L5:
        Object r102 = mLoggerLock;
        monitor-enter(r102);
        ArrayList<CastLogger> r103 = CastLoggers;     // Catch: Throwable -> L19
        if (r103 == null) goto L13;
        Iterator<CastLogger> r104 = r103.iterator();     // Catch: Throwable -> L19
    L11:
        if (r104.hasNext() == false) goto L13;
        r104.next().e(TAG, r101);     // Catch: Throwable -> L19
    L13:
        monitor-exit(r102);     // Catch: Throwable -> L19
        ILogger r105 = sLogger;
        if (r105 == null) goto L17;
        r105.onError(TAG, prefix(r100) + r101);
        return;
    L17:
        prefix(r100);
        return;
    L19:
        th = move-exception;
        throw th;
    }

    public static void i(String r100, String r101) {
        if (LOG_LEVEL <= 4) goto L5;
        return;
    L5:
        Object r102 = mLoggerLock;
        monitor-enter(r102);
        ArrayList<CastLogger> r103 = CastLoggers;     // Catch: Throwable -> L19
        if (r103 == null) goto L13;
        Iterator<CastLogger> r104 = r103.iterator();     // Catch: Throwable -> L19
    L11:
        if (r104.hasNext() == false) goto L13;
        r104.next().i(TAG, r101);     // Catch: Throwable -> L19
    L13:
        monitor-exit(r102);     // Catch: Throwable -> L19
        ILogger r105 = sLogger;
        if (r105 == null) goto L17;
        r105.onInfo(TAG, prefix(r100) + r101);
        return;
    L17:
        prefix(r100);
        return;
    L19:
        th = move-exception;
        throw th;
    }

    public static void v(String r100, String r101) {
        if (LOG_LEVEL <= 2) goto L5;
        return;
    L5:
        Object r102 = mLoggerLock;
        monitor-enter(r102);
        ArrayList<CastLogger> r103 = CastLoggers;     // Catch: Throwable -> L19
        if (r103 == null) goto L13;
        Iterator<CastLogger> r104 = r103.iterator();     // Catch: Throwable -> L19
    L11:
        if (r104.hasNext() == false) goto L13;
        r104.next().v(TAG, r101);     // Catch: Throwable -> L19
    L13:
        monitor-exit(r102);     // Catch: Throwable -> L19
        ILogger r105 = sLogger;
        if (r105 == null) goto L17;
        r105.onVerbose(TAG, prefix(r100) + r101);
        return;
    L17:
        prefix(r100);
        return;
    L19:
        th = move-exception;
        throw th;
    }

    public static void w(String r100, String r101) {
        if (LOG_LEVEL <= 5) goto L5;
        return;
    L5:
        Object r102 = mLoggerLock;
        monitor-enter(r102);
        ArrayList<CastLogger> r103 = CastLoggers;     // Catch: Throwable -> L19
        if (r103 == null) goto L13;
        Iterator<CastLogger> r104 = r103.iterator();     // Catch: Throwable -> L19
    L11:
        if (r104.hasNext() == false) goto L13;
        r104.next().w(TAG, r101);     // Catch: Throwable -> L19
    L13:
        monitor-exit(r102);     // Catch: Throwable -> L19
        ILogger r105 = sLogger;
        if (r105 == null) goto L17;
        r105.onWarn(TAG, prefix(r100) + r101);
        return;
    L17:
        prefix(r100);
        return;
    L19:
        th = move-exception;
        throw th;
    }
}
