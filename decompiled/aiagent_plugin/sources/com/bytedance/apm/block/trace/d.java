package com.bytedance.apm.block.trace;

/* JADX INFO: compiled from: JankTracer.java */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile d f4419b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile boolean f4420c = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile a f4421a;

    /* JADX INFO: compiled from: JankTracer.java */
    public interface a {
        void a(long r1, long[] r3);

        boolean a();

        void b();
    }

    static {
    }

    static /* synthetic */ a a(d r0) {
        return r0.f4421a;
    }

    private d() {
    }

    public static d a() {
        if (f4419b != null) goto L15;
        monitor-enter(d.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f4419b != null) goto L9;
        f4419b = new d();     // Catch: Throwable -> L11
    L9:
        monitor-exit(d.class);     // Catch: Throwable -> L11
    L15:
        return f4419b;
    }

    public void a(final long[] r3, final long r4) {
        if (this.f4421a != null) goto L6;
        return;
    L6:
        if (this.f4421a.a() == true) goto L9;
        f.a().f4429b.a(new AnonymousClass1(this, r4, r3));
        f4420c = true;
        return;
    L9:
        if (f4420c == false) goto L13;
        f.a().f4429b.a(new AnonymousClass2(this));
        f4420c = false;
        return;
    }
}
