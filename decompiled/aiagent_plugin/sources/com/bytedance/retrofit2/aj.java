package com.bytedance.retrofit2;

import com.bytedance.common.utility.Logger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: SsHttpCall.java */
/* JADX INFO: loaded from: classes.dex */
public class aj<T> implements e<T>, q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static com.bytedance.retrofit2.f.a f9453a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static c f9454b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static b f9455c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static d f9456e;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.bytedance.retrofit2.b.c f9457d;
    private final aa<T> f;
    private final Object[] g;
    private com.bytedance.retrofit2.b.c h;
    private final g i;
    private final af j;
    private Throwable k;

    /* JADX INFO: compiled from: SsHttpCall.java */
    class a implements al {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ aj f9458a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final h<T> f9459b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final n f9460c;

        @Override // com.bytedance.retrofit2.al
        public int c() {
            return 0;
        }

        a(aj r3, h<T> r4) {
            h<T> r5 = (h) ZeusTransformUtils.wrapperContextForParams(r4, h.class, "com.obric.aiagent.plugin");
            this.f9458a = r3;
            this.f9459b = r5;
            if (ZeusTransformUtils.instanceOf(r5, n.class) == false) goto L5;
            n r6 = (n) ZeusTransformUtils.preCheckCast(r5, n.class, "com.obric.aiagent.plugin");
        L6:
            this.f9460c = r6;
            return;
        L5:
            r6 = null;
            goto L6
        }

        @Override // java.lang.Runnable
        public void run() {
            aj.a(this.f9458a).e();     // Catch: Throwable -> L15
            ak r0 = this.f9458a.j();     // Catch: Throwable -> L15
            if (aj.k() == null) goto L6;
            aj.k().b(aj.b(this.f9458a));
        L6:
            aj.a(this.f9458a).i();
            aj.a(this.f9458a).D();
        L12:
            th = move-exception;
            aj.a(this.f9458a).E();
            throw th;
        L8:
            if (aj.c(this.f9458a) == null) goto L10;
            a(aj.c(this.f9458a));     // Catch: Throwable -> L12
        L53:
        L11:
            aj.a(this.f9458a).E();
            aj.a(this.f9458a).aF();
            return;
        L10:
            a(r0);     // Catch: Throwable -> L12
        L15:
            th = move-exception;
            aj.a(this.f9458a, th);     // Catch: Throwable -> L31
            ad.d r2 = aj.a(this.f9458a).aE.j;     // Catch: Throwable -> L31
            r2.f9428e = new WeakReference(th);     // Catch: Throwable -> L31
            if (aj.k() == null) goto L21;
            aj.k().b(aj.b(this.f9458a));
        L21:
            aj.a(this.f9458a).i();
            aj.a(this.f9458a).D();
        L28:
            th = move-exception;
            aj.a(this.f9458a).E();
            throw th;
        L23:
            if (aj.c(this.f9458a) == null) goto L25;
            a(aj.c(this.f9458a));     // Catch: Throwable -> L28
        L50:
            goto L11
        L25:
            a(null);     // Catch: Throwable -> L28
        L31:
            th = move-exception;
            if (aj.k() == null) goto L35;
            aj.k().b(aj.b(this.f9458a));
        L35:
            aj.a(this.f9458a).i();
            aj.a(this.f9458a).D();
        L42:
            th = move-exception;
            aj.a(this.f9458a).E();
            throw th;
        L37:
            if (aj.c(this.f9458a) == null) goto L39;
            a(aj.c(this.f9458a));     // Catch: Throwable -> L42
        L40:
            aj.a(this.f9458a).E();
            aj.a(this.f9458a).aF();
            throw th;
        L39:
            a(null);     // Catch: Throwable -> L42
            goto L40
        }

        @Override // com.bytedance.retrofit2.al
        public int a() {
            if (aj.l() == null) goto L9;
            int r0 = aj.l().c(aj.d(this.f9458a));
            if (r0 == (-999)) goto L9;
            aj.a(this.f9458a).d(r0);
            return r0;
        L9:
            if (aj.m() == null) goto L15;
            if (aj.d(this.f9458a) == null) goto L15;
            int r1 = aj.m().a(aj.d(this.f9458a).o(), aj.e(this.f9458a).f9382e);
            aj.a(this.f9458a).d(r1);
            return r1;
        L15:
            if (aj.d(this.f9458a) == null) goto L19;
            return aj.d(this.f9458a).f();
        L19:
            return aj.e(this.f9458a).f9382e;
        }

        @Override // com.bytedance.retrofit2.al
        public boolean b() {
            return aj.f(this.f9458a).booleanValue();
        }

        @Override // com.bytedance.retrofit2.al
        public af d() {
            return this.f9458a.i();
        }

        private void a(Throwable r2) {
            this.f9459b.a(this.f9458a, r2);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            th.printStackTrace();
        }

        private void a(ak<T> r3) {
            this.f9459b.a(this.f9458a, r3);     // Catch: Throwable -> L6
            n r0 = this.f9460c;     // Catch: Throwable -> L6
            if (r0 == null) goto L11;
            r0.b(this.f9458a, r3);     // Catch: Throwable -> L6
            return;
        L11:
            return;
        L6:
            th = move-exception;
            th.printStackTrace();
        }
    }

    /* JADX INFO: compiled from: SsHttpCall.java */
    public interface b {
        List<com.bytedance.retrofit2.d.b> a(com.bytedance.retrofit2.b.c r1, List<com.bytedance.retrofit2.d.b> r2);
    }

    /* JADX INFO: compiled from: SsHttpCall.java */
    public interface c {
        int a(String r1, int r2);
    }

    /* JADX INFO: compiled from: SsHttpCall.java */
    public interface d {
        com.bytedance.retrofit2.b.c a(com.bytedance.retrofit2.b.c r1);

        boolean b(com.bytedance.retrofit2.b.c r1);

        int c(com.bytedance.retrofit2.b.c r1);

        boolean d(com.bytedance.retrofit2.b.c r1);
    }

    @Override // com.bytedance.retrofit2.q
    public void f() {
    }

    static /* synthetic */ af a(aj r0) {
        return r0.j;
    }

    static /* synthetic */ Throwable a(aj r0, Throwable r1) {
        r0.k = r1;
        return r1;
    }

    static /* synthetic */ com.bytedance.retrofit2.b.c b(aj r0) {
        return r0.f9457d;
    }

    static /* synthetic */ Throwable c(aj r0) {
        return r0.k;
    }

    static /* synthetic */ com.bytedance.retrofit2.b.c d(aj r0) {
        return r0.h;
    }

    static /* synthetic */ aa e(aj r0) {
        return r0.f;
    }

    static /* synthetic */ Boolean f(aj r0) {
        return r0.o();
    }

    static /* synthetic */ com.bytedance.retrofit2.f.a k() {
        return f9453a;
    }

    static /* synthetic */ d l() {
        return f9456e;
    }

    static /* synthetic */ c m() {
        return f9454b;
    }

    public /* synthetic */ Object clone() {
        return h();
    }

    @Override // com.bytedance.retrofit2.e
    public /* synthetic */ e d() {
        return h();
    }

    public static void a(com.bytedance.retrofit2.f.a r2) {
        f9453a = (com.bytedance.retrofit2.f.a) ZeusTransformUtils.wrapperContextForParams(r2, com.bytedance.retrofit2.f.a.class, "com.obric.aiagent.plugin");
    }

    public static void a(d r2) {
        f9456e = (d) ZeusTransformUtils.wrapperContextForParams(r2, d.class, "com.obric.aiagent.plugin");
    }

    aj(aa<T> r2, Object[] r3) {
        this.f9457d = null;
        this.k = null;
        this.f = r2;
        this.g = r3;
        this.i = new g(r2);
        af r4 = r2.a().a();
        this.j = r4;
        r4.d();
    }

    private synchronized void n() {
        monitor-enter(this);
    L19:
        th = move-exception;
        throw th;
    L4:
        if (this.h == null) goto L22;
        monitor-exit(this);
        return;
    L22:
        this.j.J();     // Catch: IOException -> L16 Throwable -> L19
        this.h = this.f.a(null, this.g);     // Catch: IOException -> L16 Throwable -> L19
        this.j.K();     // Catch: IOException -> L16 Throwable -> L19
        com.bytedance.retrofit2.b.c r0 = this.h;     // Catch: IOException -> L16 Throwable -> L19
        if (r0 == null) goto L15;
        r0.a(this.j);     // Catch: IOException -> L16 Throwable -> L19
        if (Logger.debug() == false) goto L12;
        Logger.d("ToRequestLog", "originalRequest build success, path: " + this.h.o());     // Catch: IOException -> L16 Throwable -> L19
    L12:
        monitor-exit(this);
        return;
    L15:
        throw new RuntimeException("Unable to create request.");     // Catch: IOException -> L16 Throwable -> L19
    L16:
        e = move-exception;
        throw new RuntimeException("Unable to create request.", e);     // Catch: Throwable -> L19
    }

    private Boolean o() {
        return Boolean.valueOf(this.f.h);
    }

    @Override // com.bytedance.retrofit2.e
    @Deprecated
    public ak<T> a() {
        this.j.b(false);
        n();
        com.bytedance.retrofit2.f.a r0 = f9453a;     // Catch: Throwable -> L12
        if (r0 == null) goto L6;
        com.bytedance.retrofit2.b.c r1 = r0.c(this.h);     // Catch: Throwable -> L12
        this.h = r1;     // Catch: Throwable -> L12
        this.f9457d = r1;     // Catch: Throwable -> L12
        f9453a.a(r1);     // Catch: Throwable -> L12
    L6:
        this.j.e();     // Catch: Throwable -> L12
        ak<T> r2 = j();     // Catch: Throwable -> L12
        com.bytedance.retrofit2.f.a r3 = f9453a;
        if (r3 == null) goto L10;
        r3.b(this.f9457d);
    L10:
        this.j.i();
        this.j.f();
        this.j.aF();
        return r2;
    L12:
        th = move-exception;
        this.k = th;     // Catch: Throwable -> L15
        ad.d r4 = this.j.aE.j;     // Catch: Throwable -> L15
        r4.f9428e = new WeakReference(th);     // Catch: Throwable -> L15
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        com.bytedance.retrofit2.f.a r5 = f9453a;
        if (r5 == null) goto L19;
        r5.b(this.f9457d);
    L19:
        this.j.i();
        this.j.f();
        this.j.aF();
        throw th;
    }

    @Override // com.bytedance.retrofit2.e
    public void a(h<T> r5) {
        h r6 = (h) ZeusTransformUtils.wrapperContextForParams(r5, h.class, "com.obric.aiagent.plugin");
        Objects.requireNonNull(r6, "callback == null");
        if (g() == true) goto L36;
        this.j.b(true);
        a r0 = new a(this, r6);
        n();     // Catch: Throwable -> L17
        com.bytedance.retrofit2.f.a r1 = f9453a;     // Catch: Throwable -> L17
        if (r1 == null) goto L13;
        com.bytedance.retrofit2.b.c r2 = r1.c(this.h);     // Catch: Throwable -> L17
        this.h = r2;     // Catch: Throwable -> L17
        this.f9457d = r2;     // Catch: Throwable -> L17
        if (f9453a.a(r2, this.f.f9381d, r0) == false) goto L13;
        this.j.f();
        if (this.k == null) goto L42;
        this.j.aE();
        this.j.aF();
        return;
    L42:
        return;
    L13:
        this.f.f9381d.execute(r0);     // Catch: Throwable -> L17
        this.j.f();
        if (this.k == null) goto L26;
    L16:
        this.j.aE();
        this.j.aF();
        return;
    L26:
        return;
    L17:
        th = move-exception;
        this.k = th;     // Catch: Throwable -> L30
        th.printStackTrace();     // Catch: Throwable -> L30
        ad.d r3 = this.j.aE.j;     // Catch: Throwable -> L30
        r3.f9428e = new WeakReference(th);     // Catch: Throwable -> L30
        this.j.D();     // Catch: Throwable -> L30
        r6.a(this, th);     // Catch: Throwable -> L27
        this.j.E();     // Catch: Throwable -> L30
        com.bytedance.retrofit2.f.a r7 = f9453a;     // Catch: Throwable -> L30
        if (r7 == null) goto L23;
        r7.b(this.f9457d);     // Catch: Throwable -> L30
    L23:
        this.j.f();
        if (this.k != null) goto L16;
        return;
    L27:
        th = move-exception;
        this.j.E();     // Catch: Throwable -> L30
        throw th;     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        this.j.f();
        if (this.k == null) goto L34;
        this.j.aE();
        this.j.aF();
    L34:
        throw th;
    L36:
        throw new IllegalStateException("Already executed.");
    }

    public synchronized boolean g() {
        monitor-enter(this);
        g r0 = this.i;     // Catch: Throwable -> L11
        if (r0 == null) goto L8;
        if (r0.b() == false) goto L8;
        boolean r1 = true;
    L9:
        monitor-exit(this);
        return r1;
    L8:
        r1 = false;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.retrofit2.e
    public void b() {
        g r0 = this.i;
        if (r0 == null) goto L6;
        r0.d();
        return;
    }

    @Override // com.bytedance.retrofit2.e
    public boolean c() {
        g r0 = this.i;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.e() == false) goto L7;
        return true;
    }

    public aj<T> h() {
        return new aj(this.f, this.g);
    }

    @Override // com.bytedance.retrofit2.e
    public com.bytedance.retrofit2.b.c e() {
        g r0 = this.i;
        if (r0 == null) goto L7;
        com.bytedance.retrofit2.b.c r1 = r0.a();
        if (r1 == null) goto L7;
        return r1;
    L7:
        n();
        return this.h;
    }

    public af i() {
        return this.j;
    }

    ak j() {
        if (Logger.debug() == false) goto L5;
        Logger.d("SsHttpCall", "real send " + this.h.o());
    L5:
        List<com.bytedance.retrofit2.d.b> r0 = p();
        if (Logger.debug() == false) goto L8;
        this.h = a(this.h);
    L8:
        com.bytedance.retrofit2.d.c r1 = new com.bytedance.retrofit2.d.c(r0, 0, this.h, this);
        if (com.bytedance.retrofit2.d.c.b() == false) goto L11;
        ak r2 = r1.b(this.h);
    L12:
        r2.a(this.j);
        return r2;
    L11:
        r2 = r1.a(this.h);
        goto L12
    }

    private com.bytedance.retrofit2.b.c a(com.bytedance.retrofit2.b.c r5) {
        if (r5.p().B < 0) goto L6;
        com.bytedance.retrofit2.b.c.a r4 = r5.m();
        ArrayList r0 = new ArrayList();
        r0.addAll(r5.c());
        r0.add(new com.bytedance.retrofit2.b.b("state-delay", String.valueOf(r5.p().B)));
        r4.a(r0);
        return r4.b();
    L6:
        return r5;
    }

    private List<com.bytedance.retrofit2.d.b> p() {
        LinkedList r0 = new LinkedList();
        d r1 = f9456e;
        if (r1 == null) goto L6;
        this.h = r1.a(this.h);
    L6:
        if (f9455c == null) goto L15;
        d r2 = f9456e;
        if (r2 == null) goto L15;
        if (r2.d(this.h) == false) goto L15;
        List<com.bytedance.retrofit2.d.b> r3 = f9455c.a(this.h, this.f.f9380c);
        if (r3 == null) goto L20;
        r0.addAll(r3);
    L20:
        r0.add(this.i);
        return r0;
    L15:
        if (b(this.h) == false) goto L18;
        r0.addAll(this.f.f9380c);
        goto L20
    L18:
        if (this.h.t() == false) goto L20;
        a(r0, this.f.f9380c);
        goto L20
    }

    private static void a(List<com.bytedance.retrofit2.d.b> r3, List<com.bytedance.retrofit2.d.b> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L5;
        return;
    L5:
        if (r6.isEmpty() == true) goto L23;
        Iterator r7 = r6.iterator();
    L9:
        if (r7.hasNext() == false) goto L24;
        com.bytedance.retrofit2.d.b r0 = (com.bytedance.retrofit2.d.b) ZeusTransformUtils.preCheckCast(r7.next(), com.bytedance.retrofit2.d.b.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r0, com.bytedance.retrofit2.d.a.class) == false) goto L9;
        if (((com.bytedance.retrofit2.d.a) ZeusTransformUtils.preCheckCast(r0, com.bytedance.retrofit2.d.a.class, "com.obric.aiagent.plugin")).a() == false) goto L9;
        r5.add(r0);
        goto L9
    L24:
        return;
    }

    private boolean b(com.bytedance.retrofit2.b.c r3) {
        if (r3.t() == false) goto L5;
        return false;
    L5:
        d r2 = f9456e;
        if (r2 == null) goto L10;
        if (r2.b(r3) == false) goto L10;
        return false;
    L10:
        return true;
    }
}
