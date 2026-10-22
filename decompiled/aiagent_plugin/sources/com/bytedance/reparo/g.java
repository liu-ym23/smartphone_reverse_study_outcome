package com.bytedance.reparo;

import android.app.Application;
import android.os.SystemClock;
import com.bytedance.reparo.core.i;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: Reparo.java */
/* JADX INFO: loaded from: classes.dex */
public class g {
    private static final String TAG = "Reparo";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static long f9360b = 5000;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile g f9361c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    volatile boolean f9362a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile long f9363d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private IReparoConfig f9364e;
    private final d f;
    private final b g;
    private com.bytedance.reparo.core.e h;
    private Application i;
    private volatile boolean j;
    private int k;
    private volatile boolean l;
    private boolean m;
    private String n;
    private i.a o;

    static {
    }

    static /* synthetic */ boolean a(g r0) {
        return r0.j;
    }

    private g() {
        this.j = false;
        this.k = 1;
        this.l = false;
        this.m = true;
        this.n = com.bytedance.reparo.core.BuildConfig.SERVICE_URL;
        this.f = d.a();
        this.g = b.a();
    }

    public static g a() {
        if (f9361c != null) goto L15;
        monitor-enter(g.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f9361c != null) goto L9;
        f9361c = new g();     // Catch: Throwable -> L11
    L9:
        monitor-exit(g.class);     // Catch: Throwable -> L11
    L15:
        return f9361c;
    }

    public synchronized void a(IReparoConfig r7) {
        monitor-enter(this);
    L31:
        th = move-exception;
        throw th;
    L4:
        if (r7.autoFetchPatch() == false) goto L7;
        b(r7);     // Catch: Throwable -> L31
    L7:
        if (r7.enable() == true) goto L11;
        monitor-exit(this);
        return;
    L11:
        if (r7.autoFailThenSyncMode() == false) goto L13;
        com.bytedance.reparo.core.i.a.f9272a = true;     // Catch: Throwable -> L31
    L13:
        long r2 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L31
        com.bytedance.reparo.c.b r0 = new com.bytedance.reparo.c.b(r7);     // Catch: Throwable -> L31
        if (r0.isMainProcess() == true) goto L20;
        if (this.m == true) goto L20;
        monitor-exit(this);
        return;
    L20:
        if (this.j == false) goto L34;
        monitor-exit(this);
        return;
    L34:
        c(r0);     // Catch: Throwable -> L27
        this.j = true;     // Catch: Throwable -> L31
        com.bytedance.reparo.c.c.a(TAG, r2);     // Catch: Throwable -> L31
        this.f.b().execute(new AnonymousClass1(this));     // Catch: Throwable -> L31
        monitor-exit(this);
        return;
    L27:
        th = move-exception;
        com.bytedance.reparo.c.e.a(TAG, "init failed. ", th);     // Catch: Throwable -> L31
        com.bytedance.reparo.c.c.b(TAG, new com.bytedance.reparo.core.b.d("init failed. ", th, 0), r2);     // Catch: Throwable -> L31
    }

    private synchronized void b(final IReparoConfig r5) {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.l == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        this.g.a((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L10
        this.g.a(new AnonymousClass2(this, r5));     // Catch: Throwable -> L10
        this.l = true;     // Catch: Throwable -> L10
        monitor-exit(this);
    }

    private synchronized void c(IReparoConfig r9) {
        monitor-enter(this);
        d(r9);     // Catch: Throwable -> L6
        this.f9364e = r9;     // Catch: Throwable -> L6
        Application r0 = (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r9.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L6
        this.i = r0;     // Catch: Throwable -> L6
        com.bytedance.reparo.c.i.a(r0, r9, this.f.b());     // Catch: Throwable -> L6
        this.f.a(this.i, r9, r9.isMainProcess(), r9.getUpdateVersionCode(), h());     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private com.bytedance.reparo.core.e h() {
        if (this.h != null) goto L6;
        this.h = new com.bytedance.reparo.core.e();
    L6:
        return this.h;
    }

    public String b() {
        return this.n;
    }

    public void a(long r1) {
        f9360b = r1;
    }

    public void c() {
        if (this.j == true) goto L5;
        return;
    L5:
        long r0 = System.currentTimeMillis();
        com.bytedance.reparo.c.e.a(TAG, "now = " + r0 + ", last = " + this.f9363d + " inter = " + f9360b);
        if ((r0 - this.f9363d) <= f9360b) goto L8;
        this.f9363d = r0;
        this.f.update();
        return;
    L8:
        com.bytedance.reparo.c.e.a(TAG, " not load");
    }

    public void d() {
        if (this.j == true) goto L5;
        return;
    L5:
        this.f.b().execute(new AnonymousClass3(this));
    }

    public i.a e() {
        return this.o;
    }

    public boolean f() {
        if (this.j == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f.c() == false) goto L7;
        return true;
    }

    public void g() {
        this.f.e();
    }

    private void d(IReparoConfig r3) {
        if (r3 == null) goto L13;
        if (((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")) == null) goto L11;
        if (r3.getUpdateVersionCode() == null) goto L9;
        return;
    L9:
        throw new IllegalArgumentException("IFrankieConfig.getUpdateVersionCode() can not be null!");
    L11:
        throw new IllegalArgumentException("IFrankieConfig.getApplication() can not be null!");
    L13:
        throw new IllegalArgumentException("IFrankieConfig can not be null!");
    }
}
