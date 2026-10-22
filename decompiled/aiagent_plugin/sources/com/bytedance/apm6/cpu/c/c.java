package com.bytedance.apm6.cpu.c;

/* JADX INFO: compiled from: CpuExceptionManager.java */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f5260a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private f f5261b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.bytedance.apm6.cpu.b.c f5262c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f5263d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f5264e;
    private com.bytedance.apm6.cpu.a.c f;
    private com.bytedance.apm6.cpu.a.b g;

    @Deprecated
    private boolean h;

    /* JADX INFO: renamed from: com.bytedance.apm6.cpu.c.c$1, reason: invalid class name */
    /* JADX INFO: compiled from: CpuExceptionManager.java */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: compiled from: CpuExceptionManager.java */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final c f5265a = null;

        static /* synthetic */ c a() {
            return f5265a;
        }

        static {
            f5265a = new c(null);
        }
    }

    /* synthetic */ c(AnonymousClass1 r1) {
        this();
    }

    private c() {
        this.f5261b = new com.bytedance.apm6.cpu.c.a.d();
    }

    public static c a() {
        return a.a();
    }

    public synchronized void a(com.bytedance.apm6.cpu.b.c r3) {
        monitor-enter(this);
        if (r3 != null) goto L28;
        monitor-exit(this);
        return;
    L28:
    L25:
        th = move-exception;
        throw th;
    L7:
        if (com.bytedance.apm6.foundation.context.a.e() == false) goto L9;
    L12:
        this.f5262c = r3;     // Catch: Throwable -> L25
        if (this.h == false) goto L20;
        if (this.f5260a == true) goto L17;
        this.f5260a = true;     // Catch: Throwable -> L25
        this.f5263d = r3.j();     // Catch: Throwable -> L25
        this.f5261b.a(r3);     // Catch: Throwable -> L25
    L17:
        monitor-exit(this);
        return;
    L20:
        if (r3.a() == false) goto L22;
        this.f5260a = true;     // Catch: Throwable -> L25
        this.f5263d = r3.j();     // Catch: Throwable -> L25
        this.f5261b.a(r3);     // Catch: Throwable -> L25
    L23:
        monitor-exit(this);
        return;
    L22:
        this.f5260a = false;     // Catch: Throwable -> L25
        this.f5261b.a();     // Catch: Throwable -> L25
        goto L23
    L9:
        if (r3.h() == true) goto L12;
        monitor-exit(this);
    }

    public synchronized boolean b() {
        monitor-enter(this);
        boolean r0 = this.f5263d;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public void a(long r1) {
        this.f5264e = r1;
    }

    public com.bytedance.apm6.cpu.a.c c() {
        return this.f;
    }

    public com.bytedance.apm6.cpu.a.b d() {
        return this.g;
    }
}
