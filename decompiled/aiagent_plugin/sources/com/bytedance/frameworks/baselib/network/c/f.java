package com.bytedance.frameworks.baselib.network.c;

/* JADX INFO: compiled from: RequestQueue.java */
/* JADX INFO: loaded from: classes.dex */
public class f implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f8027a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile g f8028b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile f f8029c;

    static {
    }

    public static synchronized void a(boolean r2) {
        monitor-enter(f.class);
        f8027a = r2;     // Catch: Throwable -> L9
        if (f8028b == null) goto L7;
        f8028b.a(f8027a);     // Catch: Throwable -> L9
    L7:
        monitor-exit(f.class);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public static synchronized g a() {
        monitor-enter(f.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f8028b != null) goto L7;
        f8028b = g.q().a(8, 8).b(8, 8).a(30).c(10).b(10).a(true).a();     // Catch: Throwable -> L10
    L7:
        g r1 = f8028b;     // Catch: Throwable -> L10
        monitor-exit(f.class);
        return r1;
    }

    @Deprecated
    public static f b() {
        if (f8029c != null) goto L15;
        monitor-enter(f.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f8029c != null) goto L9;
        f8029c = new f();     // Catch: Throwable -> L11
    L9:
        monitor-exit(f.class);     // Catch: Throwable -> L11
    L15:
        return f8029c;
    }

    public f() {
        this(8, 8);
    }

    @Deprecated
    public f(int r1, int r2) {
        if (f8028b != null) goto L6;
        f8028b = g.q().a(8, 8).b(8, 8).a(30).c(10).b(10).a(true).a();
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.c.d
    public synchronized void a(b r2) {
        monitor-enter(this);
        if (r2 != null) goto L11;
    L9:
        monitor-exit(this);
        return;
    L11:
        e.f8015a.a(r2);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.frameworks.baselib.network.c.d
    public synchronized void b(b r2) {
        monitor-enter(this);
        if (r2 != null) goto L11;
    L9:
        monitor-exit(this);
        return;
    L11:
        e.f8015a.b(r2);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }
}
