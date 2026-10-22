package com.ttnet.org.chromium.net;

import android.net.TrafficStats;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes4.dex */
public class ThreadStatsUid {
    private static final Method sClearThreadStatsUid = null;
    private static final Method sSetThreadStatsUid = null;

    public ThreadStatsUid() {
    }

    static {
        sSetThreadStatsUid = TrafficStats.class.getMethod("setThreadStatsUid", new Class[]{Integer.TYPE});     // Catch: Throwable -> L4
        sClearThreadStatsUid = TrafficStats.class.getMethod("clearThreadStatsUid", new Class[0]);     // Catch: Throwable -> L4
        return;
    L4:
        e = move-exception;
        throw new RuntimeException("Unable to get TrafficStats methods", e);
    }

    public static void set(int r4) {
        sSetThreadStatsUid.invoke(null, new Object[]{Integer.valueOf(r4)});     // Catch: InvocationTargetException -> L5 IllegalAccessException -> L8
        return;
    L8:
        e = move-exception;
        throw new RuntimeException("TrafficStats.setThreadStatsUid failed", e);
    L5:
        e = move-exception;
        throw new RuntimeException("TrafficStats.setThreadStatsUid failed", e);
    }

    public static void clear() {
        sClearThreadStatsUid.invoke(null, new Object[0]);     // Catch: InvocationTargetException -> L5 IllegalAccessException -> L8
        return;
    L8:
        e = move-exception;
        throw new RuntimeException("TrafficStats.clearThreadStatsUid failed", e);
    L5:
        e = move-exception;
        throw new RuntimeException("TrafficStats.clearThreadStatsUid failed", e);
    }
}
