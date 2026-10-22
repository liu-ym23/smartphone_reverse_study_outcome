package com.android.server.hdmi;

import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import android.util.Slog;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
final class HdmiLogger {
    private static final boolean DEBUG = false;
    private static final long ERROR_LOG_DURATION_MILLIS = 20000;
    private static final String TAG = "HDMI";
    private static final ThreadLocal<HdmiLogger> sLogger = null;
    private final HashMap<String, Pair<Long, Integer>> mErrorTimingCache;
    private final HashMap<String, Pair<Long, Integer>> mWarningTimingCache;

    static {
        DEBUG = Log.isLoggable("HDMI", 3);
        sLogger = new ThreadLocal();
    }

    private HdmiLogger() {
        this.mWarningTimingCache = new HashMap();
        this.mErrorTimingCache = new HashMap();
    }

    static final void warning(String logMessage, Object... objs) {
        getLogger().warningInternal(toLogString(logMessage, objs));
    }

    private void warningInternal(String logMessage) {
        String log = updateLog(this.mWarningTimingCache, logMessage);
        if (log.isEmpty() == true) goto L6;
        Slog.w("HDMI", log);
        return;
    }

    static final void error(String logMessage, Object... objs) {
        getLogger().errorInternal(toLogString(logMessage, objs));
    }

    static final void error(String logMessage, Exception e, Object... objs) {
        getLogger().errorInternal(toLogString(logMessage + e, objs));
    }

    private void errorInternal(String logMessage) {
        String log = updateLog(this.mErrorTimingCache, logMessage);
        if (log.isEmpty() == true) goto L6;
        Slog.e("HDMI", log);
        return;
    }

    static final void debug(String logMessage, Object... objs) {
        getLogger().debugInternal(toLogString(logMessage, objs));
    }

    private void debugInternal(String logMessage) {
        if (DEBUG == false) goto L6;
        Slog.d("HDMI", logMessage);
        return;
    }

    private static final String toLogString(String logMessage, Object[] objs) {
        if (objs.length > 0) goto L5;
        return logMessage;
    L5:
        return String.format(logMessage, objs);
    }

    private static HdmiLogger getLogger() {
        HdmiLogger logger = sLogger.get();
        if (logger != null) goto L6;
        HdmiLogger logger2 = new HdmiLogger();
        sLogger.set(logger2);
        return logger2;
    L6:
        return logger;
    }

    private static String updateLog(HashMap<String, Pair<Long, Integer>> cache, String logMessage) {
        long curTime = SystemClock.uptimeMillis();
        Pair<Long, Integer> timing = cache.get(logMessage);
        if (shouldLogNow(timing, curTime) == false) goto L6;
        String log = buildMessage(logMessage, timing);
        cache.put(logMessage, new Pair(Long.valueOf(curTime), 1));
        return log;
    L6:
        increaseLogCount(cache, logMessage);
        return "";
    }

    private static String buildMessage(String message, Pair<Long, Integer> timing) {
        StringBuilder r0 = new StringBuilder();
        r0.append("[");
        if (timing != null) goto L5;
        int r1 = 1;
    L6:
        r0.append(r1);
        r0.append("]:");
        r0.append(message);
        return r0.toString();
    L5:
        r1 = ((Integer) timing.second).intValue();
        goto L6
    }

    private static void increaseLogCount(HashMap<String, Pair<Long, Integer>> cache, String message) {
        Pair<Long, Integer> timing = cache.get(message);
        if (timing == null) goto L6;
        cache.put(message, new Pair((Long) timing.first, Integer.valueOf(((Integer) timing.second).intValue() + 1)));
        return;
    }

    private static boolean shouldLogNow(Pair<Long, Integer> timing, long curTime) {
        if (timing != null) goto L4;
    L7:
        return true;
    L4:
        if ((curTime - ((Long) timing.first).longValue()) > ERROR_LOG_DURATION_MILLIS) goto L7;
        return false;
    }
}
