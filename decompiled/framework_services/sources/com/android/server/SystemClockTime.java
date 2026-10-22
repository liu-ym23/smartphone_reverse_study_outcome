package com.android.server;

import android.os.Build;
import android.os.Environment;
import android.os.SystemProperties;
import android.util.LocalLog;
import android.util.Slog;
import java.io.PrintWriter;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes.dex */
public final class SystemClockTime {
    private static final String TAG = "SystemClockTime";
    public static final int TIME_CONFIDENCE_HIGH = 100;
    public static final int TIME_CONFIDENCE_LOW = 0;
    private static final long sNativeData = 0;
    private static int sTimeConfidence;
    private static final LocalLog sTimeDebugLog = null;

    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface TimeConfidence {
    }

    private static native long init();

    private static native int setTime(long r0, long r2);

    static {
        sTimeDebugLog = new LocalLog(30, false);
        sTimeConfidence = 0;
        sNativeData = init();
    }

    private SystemClockTime() {
    }

    public static void initializeIfRequired() {
        long systemBuildTime = Long.max(SystemProperties.getLong("ro.build.date.utc", -1) * 1000, Long.max(Environment.getRootDirectory().lastModified(), Build.TIME));
        long currentTimeMillis = getCurrentTimeMillis();
        if (currentTimeMillis >= systemBuildTime) goto L6;
        String logMsg = "Current time only " + currentTimeMillis + ", advancing to build time " + systemBuildTime;
        Slog.i(TAG, logMsg);
        setTimeAndConfidence(systemBuildTime, 0, logMsg);
        return;
    }

    public static void setTimeAndConfidence(long unixEpochMillis, int confidence, String logMsg) {
        monitor-enter(SystemClockTime.class);
        setTime(sNativeData, unixEpochMillis);     // Catch: Throwable -> L7
        sTimeConfidence = confidence;     // Catch: Throwable -> L7
        sTimeDebugLog.log(logMsg);     // Catch: Throwable -> L7
        monitor-exit(SystemClockTime.class);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static void setConfidence(int confidence, String logMsg) {
        monitor-enter(SystemClockTime.class);
        sTimeConfidence = confidence;     // Catch: Throwable -> L7
        sTimeDebugLog.log(logMsg);     // Catch: Throwable -> L7
        monitor-exit(SystemClockTime.class);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static long getCurrentTimeMillis() {
        return System.currentTimeMillis();
    }

    public static int getTimeConfidence() {
        monitor-enter(SystemClockTime.class);
        int r1 = sTimeConfidence;     // Catch: Throwable -> L7
        monitor-exit(SystemClockTime.class);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public static void addDebugLogEntry(String logMsg) {
        sTimeDebugLog.log(logMsg);
    }

    public static void dump(PrintWriter writer) {
        sTimeDebugLog.dump(writer);
    }
}
