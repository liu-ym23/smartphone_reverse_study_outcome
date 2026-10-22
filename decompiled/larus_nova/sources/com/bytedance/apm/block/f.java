package com.bytedance.apm.block;

/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile f f190344b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f190345a;

    public static f a() {
        if (f190344b != null) goto L15;
        monitor-enter(f.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f190344b != null) goto L9;
        f190344b = new f();     // Catch: Throwable -> L11
    L9:
        monitor-exit(f.class);     // Catch: Throwable -> L11
    L15:
        return f190344b;
    }

    public f() {
        this.f190345a = 0;
    }
}
