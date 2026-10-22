package com.bytedance.platform.godzilla.anr.monitor.idletask;

/* JADX INFO: compiled from: IdleHandlerCostTimeMonitor.java */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static b f9061b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bytedance.platform.godzilla.anr.monitor.a f9062a;

    private b() {
    }

    public static b a() {
        if (f9061b != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f9061b != null) goto L9;
        f9061b = new b();     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return f9061b;
    }

    public com.bytedance.platform.godzilla.anr.monitor.a b() {
        return this.f9062a;
    }
}
