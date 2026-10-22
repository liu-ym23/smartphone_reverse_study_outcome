package com.apm.lite;

/* JADX INFO: loaded from: classes39.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile c f29906a;

    public c() {
    }

    public static void a() {
        if (f29906a == null) goto L5;
        return;
    L5:
        monitor-enter(c.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f29906a != null) goto L9;
        f29906a = new c();     // Catch: Throwable -> L11
    L9:
        monitor-exit(c.class);     // Catch: Throwable -> L11
    }
}
