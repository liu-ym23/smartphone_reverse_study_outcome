package com.ttnet.org.chromium.net;

import android.net.TrafficStats;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: ThreadStatsUid.java */
/* JADX INFO: loaded from: classes4.dex */
public class af {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Method f37888a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Method f37889b = null;

    static {
        f37888a = TrafficStats.class.getMethod("setThreadStatsUid", new Class[]{Integer.TYPE});     // Catch: Throwable -> L4
        f37889b = TrafficStats.class.getMethod("clearThreadStatsUid", new Class[0]);     // Catch: Throwable -> L4
        return;
    L4:
        e = move-exception;
        throw new RuntimeException("Unable to get TrafficStats methods", e);
    }

    public static void a(int r5) {
        f37888a.invoke(null, new Object[]{Integer.valueOf(r5)});     // Catch: InvocationTargetException -> L5 IllegalAccessException -> L8
        return;
    L8:
        e = move-exception;
        throw new RuntimeException("TrafficStats.setThreadStatsUid failed", e);
    L5:
        e = move-exception;
        throw new RuntimeException("TrafficStats.setThreadStatsUid failed", e);
    }

    public static void a() {
        f37889b.invoke(null, new Object[0]);     // Catch: InvocationTargetException -> L5 IllegalAccessException -> L8
        return;
    L8:
        e = move-exception;
        throw new RuntimeException("TrafficStats.clearThreadStatsUid failed", e);
    L5:
        e = move-exception;
        throw new RuntimeException("TrafficStats.clearThreadStatsUid failed", e);
    }
}
