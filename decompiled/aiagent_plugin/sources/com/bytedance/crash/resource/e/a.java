package com.bytedance.crash.resource.e;

/* JADX INFO: compiled from: TLSMonitorAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public class a extends com.bytedance.crash.resource.b {
    private static a h;
    private b i;

    static {
    }

    public a() {
    }

    public static a f() {
        if (h != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (h != null) goto L9;
        h = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return h;
    }

    public static void a(b r1) {
        a r0 = f();
        r0.i = r1;
        r0.a(r1);
    }
}
