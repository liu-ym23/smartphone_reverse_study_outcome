package com.stepos.statsapp.v3.utils.log;

import O6.l;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import com.stepos.statsapp.v3.InitConfig;
import com.stepos.statsapp.v3.utils.CommonUtils;

/* loaded from: classes2.dex */
public class Logger {
    private static final String GLOBAL_TAG = "[Cloud]Data";
    private static LogLevel sConsoleLogLevel = LogLevel.DEBUG;
    public static boolean sDebug = false;
    private static ILog sHook = null;
    private static Handler workHandler = null;
    private static final String workThreadName = "UsageStats_Logger";

    public static class LogInfo implements Runnable {
        private LogLevel mLogLevel;
        private String mMsg;
        private String mTag;
        private String mThreadName;
        private long mTid;

        public LogInfo(LogLevel logLevel, String str, String str2, long j10, String str3) {
            this.mLogLevel = logLevel;
            this.mTag = str;
            this.mMsg = str2;
            this.mTid = j10;
            this.mThreadName = str3;
        }

        private String getMessage() {
            return this.mThreadName + "|" + this.mMsg;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mLogLevel.ordinal() < Logger.sConsoleLogLevel.ordinal() || Logger.sHook == null) {
                return;
            }
            Logger.sHook.print(this.mLogLevel, this.mTag, getMessage(), this.mTid);
        }
    }

    static {
        sDebug = false;
        sDebug = CommonUtils.isPrintLog() | InitConfig.printLog;
        HandlerThread handlerThread = new HandlerThread(workThreadName);
        handlerThread.start();
        workHandler = new Handler(handlerThread.getLooper());
    }

    public static void d(String str, String str2) {
        Log.d(GLOBAL_TAG, getLogMsg(str, str2));
        workHandler.post(new LogInfo(LogLevel.DEBUG, getTag(str), str2, getThread(), getThreadName()));
    }

    public static void e(String str, String str2) {
        Log.e(GLOBAL_TAG, getLogMsg(str, str2));
        workHandler.post(new LogInfo(LogLevel.ERROR, getTag(str), str2, getThread(), getThreadName()));
    }

    private static String getLogMsg(String str, String str2) {
        Thread threadCurrentThread = Thread.currentThread();
        return "[" + threadCurrentThread.getName() + l.DATE_SEPARATOR + threadCurrentThread.getId() + "][" + str + "] " + str2;
    }

    private static String getTag(String str) {
        return str;
    }

    private static long getThread() {
        return Thread.currentThread().getId();
    }

    private static String getThreadName() {
        return Thread.currentThread().getName();
    }

    public static void i(String str, String str2) {
        Log.i(GLOBAL_TAG, getLogMsg(str, str2));
        workHandler.post(new LogInfo(LogLevel.INFO, getTag(str), str2, getThread(), getThreadName()));
    }

    public static void setHook(ILog iLog) {
        sHook = iLog;
    }

    public static void setLevel(LogLevel logLevel) {
        sConsoleLogLevel = logLevel;
    }

    public static void v(String str, String str2) {
        Log.v(GLOBAL_TAG, getLogMsg(str, str2));
        workHandler.post(new LogInfo(LogLevel.VERBOSE, getTag(str), str2, getThread(), getThreadName()));
    }

    public static void w(String str, String str2) {
        Log.w(GLOBAL_TAG, getLogMsg(str, str2));
        workHandler.post(new LogInfo(LogLevel.WARN, getTag(str), str2, getThread(), getThreadName()));
    }
}
