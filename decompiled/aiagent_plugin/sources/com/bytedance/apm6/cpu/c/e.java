package com.bytedance.apm6.cpu.c;

import com.bytedance.monitor.collector.k;

/* JADX INFO: compiled from: CpuLoadCollector.java */
/* JADX INFO: loaded from: classes.dex */
public class e {
    public static double a() {
        long r0 = System.currentTimeMillis();
        long r2 = k.a().m();
        Thread.sleep(360);     // Catch: InterruptedException -> L6
    L5:
        return (((k.a().m() - r2) * 1000.0d) / (System.currentTimeMillis() - r0)) / com.bytedance.apm.util.b.a(100);
    }
}
