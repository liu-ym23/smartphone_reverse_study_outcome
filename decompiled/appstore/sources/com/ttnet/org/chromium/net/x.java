package com.ttnet.org.chromium.net;

import android.net.TrafficStats;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes4.dex */
public abstract class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Method f18983a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Method f18984b = null;

    static {
        f18983a = TrafficStats.class.getMethod("setThreadStatsUid", new Class[]{Integer.TYPE});     // Catch: Throwable -> L5
        f18984b = TrafficStats.class.getMethod("clearThreadStatsUid", null);     // Catch: Throwable -> L5
        return;
    L5:
        e = move-exception;
        throw new RuntimeException("Unable to get TrafficStats methods", e);
    }

    public static void a() {
        f18984b.invoke(null, null);     // Catch: InvocationTargetException -> L5 IllegalAccessException -> L7
        return;
    L7:
        e = move-exception;
        throw new RuntimeException("TrafficStats.clearThreadStatsUid failed", e);
    L5:
        e = move-exception;
        throw new RuntimeException("TrafficStats.clearThreadStatsUid failed", e);
    }

    public static void b(int r10) {
        f18983a.invoke(null, new Object[]{Integer.valueOf(r10)});     // Catch: InvocationTargetException -> L5 IllegalAccessException -> L7
        return;
    L7:
        e = move-exception;
        throw new RuntimeException("TrafficStats.setThreadStatsUid failed", e);
    L5:
        e = move-exception;
        throw new RuntimeException("TrafficStats.setThreadStatsUid failed", e);
    }
}
