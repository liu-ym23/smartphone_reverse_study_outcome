package com.stepos.pps.data.util;

import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import com.stepos.pps.reflect.SystemProperties;

/* loaded from: classes.dex */
public class LogUtil {
    private static LogLevel sConsoleLogLevel = LogLevel.DEBUG;
    public static boolean sDebug = false;
    private static Handler workHandler = null;
    private static final String workThreadName = "PPS_Logger";

    public enum LogLevel {
        VERBOSE,
        DEBUG,
        INFO,
        WARN,
        ERROR
    }

    private static String getTag(String str) {
        return str;
    }

    static {
        sDebug = false;
        sDebug = isPrintLog();
        HandlerThread handlerThread = new HandlerThread(workThreadName);
        handlerThread.start();
        workHandler = new Handler(handlerThread.getLooper());
    }

    public static void setLevel(LogLevel logLevel) {
        sConsoleLogLevel = logLevel;
    }

    public static void v(String str, String str2) {
        if (sDebug) {
            workHandler.post(new LogInfo(LogLevel.VERBOSE, getTag(str), str2, getThread(), getThreadName()));
        }
    }

    public static void d(String str, String str2) {
        if (sDebug) {
            workHandler.post(new LogInfo(LogLevel.DEBUG, getTag(str), str2, getThread(), getThreadName()));
        }
    }

    public static void i(String str, String str2) {
        if (sDebug) {
            workHandler.post(new LogInfo(LogLevel.INFO, getTag(str), str2, getThread(), getThreadName()));
        }
    }

    public static void w(String str, String str2) {
        if (sDebug) {
            workHandler.post(new LogInfo(LogLevel.WARN, getTag(str), str2, getThread(), getThreadName()));
        }
    }

    public static void e(String str, String str2) {
        workHandler.post(new LogInfo(LogLevel.ERROR, getTag(str), str2, getThread(), getThreadName()));
    }

    private static long getThread() {
        return Thread.currentThread().getId();
    }

    private static String getThreadName() {
        return Thread.currentThread().getName();
    }

    private static class LogInfo implements Runnable {
        private LogLevel mLogLevel;
        private String mMsg;
        private String mTag;
        private String mThreadName;
        private long mTid;

        public LogInfo(LogLevel logLevel, String str, String str2, long j, String str3) {
            this.mLogLevel = logLevel;
            this.mTag = str;
            this.mMsg = str2;
            this.mTid = j;
            this.mThreadName = str3;
        }

        private String getMessage() {
            return this.mThreadName + "|" + this.mMsg;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mLogLevel.ordinal() >= LogUtil.sConsoleLogLevel.ordinal()) {
                if (this.mLogLevel == LogLevel.DEBUG) {
                    Log.d(this.mTag, getMessage());
                    return;
                }
                if (this.mLogLevel == LogLevel.INFO) {
                    Log.i(this.mTag, getMessage());
                } else if (this.mLogLevel == LogLevel.WARN) {
                    Log.w(this.mTag, getMessage());
                } else if (this.mLogLevel == LogLevel.ERROR) {
                    Log.e(this.mTag, getMessage());
                }
            }
        }
    }

    private static boolean isPrintLog() {
        try {
            String str = SystemProperties.get("persist.stepos.pps.log", "false");
            if (str != null && str.equals("true")) {
                sDebug = true;
            } else {
                sDebug = false;
            }
        } catch (Exception unused) {
        }
        return sDebug;
    }
}
