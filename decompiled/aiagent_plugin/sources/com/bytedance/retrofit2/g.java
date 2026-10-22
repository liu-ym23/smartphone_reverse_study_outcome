package com.bytedance.retrofit2;

import android.util.Log;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: CallServerInterceptor.java */
/* JADX INFO: loaded from: classes.dex */
public class g<T> implements com.bytedance.retrofit2.f.b, q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final aa<T> f9550a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile com.bytedance.retrofit2.b.e f9551b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.bytedance.retrofit2.b.c f9552c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile boolean f9553d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Throwable f9554e;
    private volatile boolean f;
    private volatile long g;

    @Override // com.bytedance.retrofit2.q
    public void f() {
    }

    public g(aa<T> r1) {
        this.f9550a = r1;
    }

    @Override // com.bytedance.retrofit2.d.b
    public ak a(com.bytedance.retrofit2.d.b.a r7) {
        com.bytedance.retrofit2.b.c r8 = ((com.bytedance.retrofit2.d.b.a) ZeusTransformUtils.wrapperContextForParams(r7, com.bytedance.retrofit2.d.b.a.class, "com.obric.aiagent.plugin")).a();
        this.f9552c = r8;
        r8.p().Z();
        this.f9552c.p().d(this.f9552c.f());
        af r9 = this.f9552c.p();
        r9.an = this.f9552c.g();
        monitor-enter(this);
    L60:
        th = move-exception;
        throw th;
    L5:
        if (this.f == true) goto L59;
        this.f = true;     // Catch: Throwable -> L60
        monitor-exit(this);     // Catch: Throwable -> L60
        Throwable r0 = this.f9554e;
        if (r0 != null) goto L11;
        com.bytedance.retrofit2.b.d r1 = null;
        if (this.f9550a.n == null) goto L19;
        r1 = this.f9550a.n.a(this.f9552c);
    L19:
        if (r1 == null) goto L22;
        this.f9552c.p().c();
        this.f9552c.p().X();
    L22:
        if (r1 == null) goto L66;
    L53:
        List<com.bytedance.retrofit2.b.b> r10 = r1.b("content-encoding");
        if (r10 == null) goto L57;
        af r2 = this.f9552c.p();
        r2.ao = ((com.bytedance.retrofit2.b.b) ZeusTransformUtils.preCheckCast(r10.get(0), com.bytedance.retrofit2.b.b.class, "com.obric.aiagent.plugin")).b();
    L57:
        return a(r1, this.f9552c.p());
    L66:
        this.f9551b = a(this.f9552c);     // Catch: Throwable -> L43 Throwable -> L50
        if (this.g <= 0) goto L27;
        this.f9551b.a(this.g);     // Catch: Throwable -> L43 Throwable -> L50
    L27:
        if (this.f9553d == false) goto L29;
        this.f9551b.n();
    L29:
        List<com.bytedance.retrofit2.b.b> r3 = this.f9552c.b("content-encoding");
        if (r3 != null) goto L32;
    L63:
        this.f9552c.p().c();     // Catch: Throwable -> L40
        this.f9552c.p().X();     // Catch: Throwable -> L40
        this.f9552c.p().g();     // Catch: Throwable -> L40
        r1 = a(this.f9551b);     // Catch: Throwable -> L40
        this.f9552c.p().h();
        this.f9552c.p().Y();
        this.f9552c.p().b(this);
        this.f9552c.p().aE.j.f9424a = true;
        if (this.f9550a.n == null) goto L53;
        com.bytedance.retrofit2.b.d r11 = this.f9550a.n.a(this.f9552c, r1);
        if (r11 == null) goto L53;
        r1 = r11;
    L40:
        th = move-exception;
        this.f9552c.p().h();
        this.f9552c.p().Y();
        this.f9552c.p().b(this);
        throw th;
    L32:
        if (r3.size() <= 0) goto L63;
        af r4 = this.f9552c.p();
        r4.ap = ((com.bytedance.retrofit2.b.b) ZeusTransformUtils.preCheckCast(this.f9552c.b("content-encoding").get(0), com.bytedance.retrofit2.b.b.class, "com.obric.aiagent.plugin")).b();
    L50:
        e = move-exception;
        this.f9554e = e;
        throw e;
    L43:
        th = move-exception;
        this.f9554e = th;
        if (ZeusTransformUtils.instanceOf(th, Exception.class) == false) goto L49;
        throw ((Exception) ZeusTransformUtils.preCheckCast(th, Exception.class, "com.obric.aiagent.plugin"));
    L49:
        throw new Exception(th);
    L11:
        if (ZeusTransformUtils.instanceOf(r0, IOException.class) == false) goto L15;
        throw ((IOException) ZeusTransformUtils.preCheckCast(this.f9554e, IOException.class, "com.obric.aiagent.plugin"));
    L15:
        throw new Exception(this.f9554e);
    L59:
        throw new IllegalStateException("Already executed.");     // Catch: Throwable -> L60
    }

    private com.bytedance.retrofit2.b.e a(com.bytedance.retrofit2.b.c r1) {
        return this.f9550a.f9379b.a().a(r1);
    }

    private com.bytedance.retrofit2.b.d a(com.bytedance.retrofit2.b.e r2) {
        return ((com.bytedance.retrofit2.b.e) ZeusTransformUtils.wrapperContextForParams(r2, com.bytedance.retrofit2.b.e.class, "com.obric.aiagent.plugin")).m();
    }

    ak<T> a(com.bytedance.retrofit2.b.d r4, af r5) {
        if (r4 == null) goto L36;
        com.bytedance.retrofit2.e.i r0 = r4.d();
        int r1 = r4.b();
        if (r1 < 200) goto L34;
        if (r1 >= 300) goto L34;
        if (r1 == 204) goto L32;
        if (r1 == 205) goto L32;
        if (r5 == null) goto L38;
        r5.T();     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        if (r5 == null) goto L29;
        r5.ai = false;
    L29:
        a("ToResponseLog", "toResponse failed");
        throw th;
    L38:
        T r3 = this.f9550a.a(r0);     // Catch: Throwable -> L23
        if (r5 == null) goto L22;
        r5.U();     // Catch: Throwable -> L16
    L22:
        return ak.a(r3, r4);
    L23:
        th = move-exception;
        if (r5 == null) goto L26;
        r5.U();     // Catch: Throwable -> L16
    L26:
        throw th;     // Catch: Throwable -> L16
    L32:
        return ak.a(null, r4);
    L34:
        return ak.a(r0, r4);
    L36:
        throw new IOException("SsResponse is null");
    }

    public com.bytedance.retrofit2.b.c a() {
        return this.f9552c;
    }

    public synchronized boolean b() {
        monitor-enter(this);
        boolean r0 = this.f;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void c() {
        monitor-enter(this);
        this.f = false;     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void d() {
        this.f9553d = true;
        if (this.f9551b == null) goto L6;
        this.f9551b.n();
        return;
    }

    public boolean e() {
        return this.f9553d;
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.i(r1, r2);
    }
}
