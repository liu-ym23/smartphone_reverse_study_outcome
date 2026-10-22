package com.bytedance.applog.b;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.applog.p;
import com.bytedance.bdinstall.aa;
import com.bytedance.bdinstall.ae;
import com.bytedance.bdinstall.af;
import com.bytedance.bdinstall.ag;
import com.bytedance.bdinstall.ah;
import com.bytedance.bdinstall.am;
import com.bytedance.bdinstall.an;
import com.bytedance.bdinstall.ar;
import com.bytedance.bdinstall.as;
import com.bytedance.bdinstall.i;
import com.bytedance.bdinstall.m;
import com.bytedance.bdinstall.u;
import com.bytedance.bdinstall.v;
import com.bytedance.bdinstall.y;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: BdInstallImpl.java */
/* JADX INFO: loaded from: classes.dex */
public final class b implements d, ag {
    private static volatile boolean k = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile m f5514a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile an f5515b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile c f5516c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.bytedance.applog.c f5517d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile aa f5518e;
    private final ConcurrentHashMap<String, Object> f;
    private am g;
    private String h;
    private String i;
    private String j;

    /* JADX INFO: compiled from: BdInstallImpl.java */
    private static class a implements ag, y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ag f5534a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final InterfaceC0134b f5535b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private JSONObject f5536c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private am f5537d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f5538e;

        public a(ag r3, InterfaceC0134b r4) {
            ag r5 = (ag) ZeusTransformUtils.wrapperContextForParams(r3, ag.class, "com.obric.aiagent.plugin");
            InterfaceC0134b r6 = (InterfaceC0134b) ZeusTransformUtils.wrapperContextForParams(r4, InterfaceC0134b.class, "com.obric.aiagent.plugin");
            this.f5538e = false;
            this.f5534a = r5;
            this.f5535b = r6;
        }

        @Override // com.bytedance.bdinstall.y
        public void a(JSONObject r1) {
            this.f5536c = r1;
            a();
        }

        private void a() {
            monitor-enter(this);
        L13:
            th = move-exception;
            throw th;
        L4:
            if (this.f5538e == false) goto L6;
            this.f5535b.b(this.f5536c, this.f5537d);     // Catch: Throwable -> L13
        L11:
            monitor-exit(this);     // Catch: Throwable -> L13
            return;
        L6:
            JSONObject r0 = this.f5536c;     // Catch: Throwable -> L13
            if (r0 == null) goto L11;
            am r1 = this.f5537d;     // Catch: Throwable -> L13
            if (r1 == null) goto L11;
            this.f5538e = true;     // Catch: Throwable -> L13
            this.f5535b.a(r0, r1);     // Catch: Throwable -> L13
            goto L11
        }

        @Override // com.bytedance.bdinstall.ag
        public void a(am r2) {
            this.f5534a.a(r2);
            this.f5537d = r2;
            a();
        }
    }

    /* JADX INFO: renamed from: com.bytedance.applog.b.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BdInstallImpl.java */
    public interface InterfaceC0134b {
        void a(JSONObject r1, am r2);

        void b(JSONObject r1, am r2);
    }

    static {
    }

    static /* synthetic */ com.bytedance.applog.c a(b r0) {
        return r0.f5517d;
    }

    static /* synthetic */ String a(b r0, String r1) {
        r0.h = r1;
        return r1;
    }

    static /* synthetic */ String b(b r0, String r1) {
        r0.i = r1;
        return r1;
    }

    static /* synthetic */ String c(b r0, String r1) {
        r0.j = r1;
        return r1;
    }

    public b(com.bytedance.applog.c r2) {
        this.f5514a = new m();
        this.f = new ConcurrentHashMap();
        this.f5517d = r2;
    }

    @Override // com.bytedance.applog.b.d
    public void a(com.bytedance.applog.j.b r8, u r9, Looper r10, com.bytedance.applog.d r11) {
        com.bytedance.applog.d r12 = (com.bytedance.applog.d) ZeusTransformUtils.wrapperContextForParams(r11, com.bytedance.applog.d.class, "com.obric.aiagent.plugin");
        final p r0 = r8.c();
        this.f5516c = new c(this.f5517d, h());
        if (this.f.isEmpty() == true) goto L6;
        this.f5516c.a(this.f);
        this.f.clear();
    L6:
        if (k == false) goto L8;
        final Handler r1 = new Handler(r10);
        v r2 = new v();
        r2.f6449a = new AnonymousClass1(this, r1);
        r2.f6451c = r10;
        h().a(r2, r0.f());
    L8:
        ae r13 = new AnonymousClass2(this);
        if (this.f5517d.am() == false) goto L11;
        ah r3 = new AnonymousClass3(this);
    L12:
        this.f5514a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f5517d.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).a(r0.p()).a(r0.B()).a(Integer.parseInt(r0.f())).b(r0.n()).h(r0.h()).i(r0.i()).a(r0.r()).a(r13).a(r3).b(r0.g()).g(r0.t()).f(r0.o()).i(r0.u()).a(r0.I()).a(r0.G()).c(false).e(this.f5517d.k()).a(r0.d()).a(new com.bytedance.applog.b.a(this.f5517d)).c(r0.x()).b(r0.v()).f(r0.s()).a(r0.w()).c(r0.y()).d(r0.c()).g(r0.A()).j(r0.F()).k(r0.z()).h(r0.k()).d(r8.q()).a(r0.H()).a(this.f5516c).a(r0.L()).k(r0.N()).a(r0.a()).a(r0.R()).m(r0.S()).j(r0.T()).a(r0.V()).l(r0.U());
        if (r0.m() == null) goto L15;
        this.f5514a.a(new AnonymousClass4(this, r0));
    L15:
        if (r12 == null) goto L18;
        r12.a(this.f5514a);
    L18:
        monitor-enter(b.class);
        an r14 = this.f5514a.a();     // Catch: Throwable -> L24
        h().a(r14, r9);     // Catch: Throwable -> L24
        this.f5514a = null;     // Catch: Throwable -> L24
        this.f5515b = r14;     // Catch: Throwable -> L24
        monitor-exit(b.class);     // Catch: Throwable -> L24
        if (r12 == null) goto L29;
        r12.a();
        return;
    L29:
        return;
    L24:
        th = move-exception;
        throw th;
    L11:
        r3 = null;
        goto L12
    }

    @Override // com.bytedance.applog.b.d
    public void a() {
        h().d();
    }

    @Override // com.bytedance.applog.b.d
    public am b() {
        if (this.g != null) goto L6;
        this.g = h().f();
    L6:
        return this.g;
    }

    @Override // com.bytedance.applog.b.d
    public String c() {
        if (TextUtils.isEmpty(this.h) == false) goto L6;
        this.h = h().g();
    L6:
        return this.h;
    }

    @Override // com.bytedance.applog.b.d
    public String d() {
        if (TextUtils.isEmpty(this.i) == false) goto L10;
        am r0 = b();
        if (r0 == null) goto L7;
        String r1 = r0.c();
    L8:
        this.i = r1;
        goto L10
    L7:
        r1 = null;
    L10:
        return this.i;
    }

    @Override // com.bytedance.applog.b.d
    public String e() {
        if (TextUtils.isEmpty(this.j) == false) goto L10;
        am r0 = b();
        if (r0 == null) goto L7;
        String r1 = r0.g();
    L8:
        this.j = r1;
        goto L10
    L7:
        r1 = null;
    L10:
        return this.j;
    }

    @Override // com.bytedance.applog.b.d
    public void a(InterfaceC0134b r3) {
        a r0 = new a(this, (InterfaceC0134b) ZeusTransformUtils.wrapperContextForParams(r3, InterfaceC0134b.class, "com.obric.aiagent.plugin"));
        h().a(true, r0);
        h().a(true, r0);
    }

    @Override // com.bytedance.applog.b.d
    public void a(Context r3, String r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        monitor-enter(b.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.f5514a == null) goto L7;
        this.f5514a.e(r4);     // Catch: Throwable -> L10
    L8:
        monitor-exit(b.class);     // Catch: Throwable -> L10
        return;
    L7:
        h().b(r5, r4);     // Catch: Throwable -> L10
        goto L8
    }

    @Override // com.bytedance.applog.b.d
    public void a(Context r3, String r4, String r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        h().a(r6, r4, r5);
    }

    @Override // com.bytedance.applog.b.d
    public void a(u r1) {
        h().a(r1);
    }

    @Override // com.bytedance.applog.b.d
    public void a(Application r3, String r4) {
        Application r5 = (Application) ZeusTransformUtils.wrapperContextForParams(r3, Application.class, "com.obric.aiagent.plugin");
        h().a(r5, r4);
    }

    @Override // com.bytedance.applog.b.d
    public boolean a(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        return h().i();
    }

    @Override // com.bytedance.applog.b.d
    public void a(HashMap<String, Object> r2) {
        if (this.f5516c == null) goto L5;
        this.f5516c.a(r2);
        return;
    L5:
        this.f.putAll(r2);
    }

    @Override // com.bytedance.applog.b.d
    public an f() {
        return this.f5515b;
    }

    @Override // com.bytedance.applog.b.d
    public String a(Context r3, StringBuilder r4, boolean r5, ar r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        return h().a(r7, r4, r5, r6);
    }

    @Override // com.bytedance.applog.b.d
    public void a(af r3) {
        af r4 = (af) ZeusTransformUtils.wrapperContextForParams(r3, af.class, "com.obric.aiagent.plugin");
        h().a(r4);
    }

    @Override // com.bytedance.applog.b.d
    public boolean a(JSONObject r1) {
        return h().a(r1);
    }

    @Override // com.bytedance.applog.b.d
    public void g() {
        h().a(new AnonymousClass5(this));
    }

    @Override // com.bytedance.bdinstall.ag
    public void a(am r1) {
        this.g = r1;
    }

    @Override // com.bytedance.applog.b.d
    public void b(u r1) {
        h().c(r1);
    }

    @Override // com.bytedance.applog.b.d
    public void a(Context r9, u r10, long r11, as r13) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        as r7 = (as) ZeusTransformUtils.wrapperContextForParams(r13, as.class, "com.obric.aiagent.plugin");
        h().b(r3, r10, r11, r7);
    }

    @Override // com.bytedance.applog.b.d
    public void c(u r1) {
        h().b(r1);
    }

    @Override // com.bytedance.applog.b.d
    public void b(Context r9, u r10, long r11, as r13) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        as r7 = (as) ZeusTransformUtils.wrapperContextForParams(r13, as.class, "com.obric.aiagent.plugin");
        h().a(r3, r10, r11, r7);
    }

    private aa h() {
        if (this.f5518e != null) goto L17;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L6:
        if (this.f5518e == null) goto L8;
    L11:
        monitor-exit(this);     // Catch: Throwable -> L13
        goto L17
    L8:
        if (com.bytedance.applog.b.a(this.f5517d) == false) goto L10;
        this.f5518e = i.a();     // Catch: Throwable -> L13
        goto L11
    L10:
        this.f5518e = i.b();     // Catch: Throwable -> L13
    L17:
        return this.f5518e;
    }
}
