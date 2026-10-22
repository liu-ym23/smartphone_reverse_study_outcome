package com.baidu.mshield.b.d;

import android.net.TrafficStats;

/* JADX INFO: loaded from: classes39.dex */
public class d {
    public static void a() {
        TrafficStats.clearThreadStatsTag();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        com.baidu.mshield.b.c.a.a(th);
    }

    public static void b() {
        TrafficStats.setThreadStatsTag(155648);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        com.baidu.mshield.b.c.a.a(th);
    }
}
