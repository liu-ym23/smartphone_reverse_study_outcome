package com.bytedance.apm.internal;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.apm.agent.tracing.AutoPageTraceHelper;
import com.bytedance.apm.block.trace.f;
import com.bytedance.apm.block.trace.g;
import com.bytedance.apm.config.SlardarConfigManagerImpl;
import com.bytedance.apm.config.c;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm.doctor.DoctorManager;
import com.bytedance.apm.perf.h;
import com.bytedance.apm.trace.d;
import com.bytedance.apm.trace.fps.RealFpsTracer;
import com.bytedance.apm.util.i;
import com.bytedance.apm.util.m;
import com.bytedance.apm.util.u;
import com.bytedance.crash.aa;
import com.bytedance.crash.dumper.Scraps;
import com.bytedance.monitor.collector.k;
import com.bytedance.monitor.collector.o;
import com.bytedance.services.apm.api.IApmAgent;
import com.bytedance.services.apm.api.IHttpService;
import com.bytedance.services.apm.api.ILaunchTrace;
import com.bytedance.services.apm.api.e;
import com.bytedance.services.apm.api.j;
import com.bytedance.services.apm.api.l;
import com.bytedance.services.slardar.config.IConfigManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ApmDelegate implements com.bytedance.services.slardar.config.a {
    private static long m;
    private static boolean n;
    private static boolean o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f4671a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.bytedance.apm.config.b f4672b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.bytedance.apm.trace.a f4673c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private d f4674d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private c f4675e;
    private com.bytedance.apm.g.b f;
    private e g;
    private SlardarConfigManagerImpl h;
    private volatile boolean i;
    private volatile boolean j;
    private volatile boolean k;
    private boolean l;
    private Set<j> p;
    private boolean q;
    private List<String> r;
    private List<String> s;
    private List<String> t;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final ApmDelegate f4696a = null;

        static /* synthetic */ ApmDelegate a() {
            return f4696a;
        }

        static {
            f4696a = new ApmDelegate(null);
        }
    }

    private void a(Application r2) {
        Application r1 = (Application) ZeusTransformUtils.wrapperContextForParams(r2, Application.class, "com.obric.aiagent.plugin");
    }

    private void initEvilMethodTraceInject() {
    }

    /* synthetic */ ApmDelegate(AnonymousClass1 r1) {
        this();
    }

    static /* synthetic */ SlardarConfigManagerImpl a(ApmDelegate r0) {
        return r0.h;
    }

    static /* synthetic */ boolean b(ApmDelegate r0) {
        return r0.l;
    }

    static /* synthetic */ com.bytedance.apm.config.b c(ApmDelegate r0) {
        return r0.f4672b;
    }

    static /* synthetic */ void d(ApmDelegate r0) {
        r0.e();
    }

    static /* synthetic */ c e(ApmDelegate r0) {
        return r0.f4675e;
    }

    private ApmDelegate() {
        this.f4671a = false;
        this.q = true;
    }

    public static ApmDelegate a() {
        return a.a();
    }

    public void a(Context r9, final com.bytedance.apm.config.b r10) {
        final Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        if (this.j == true) goto L40;
        long r2 = System.nanoTime();
        this.j = true;
        com.bytedance.apm.c.g();
        com.bytedance.apm.c.i(System.currentTimeMillis());
        com.bytedance.apm.c.j(System.currentTimeMillis() - SystemClock.uptimeMillis());
        this.f4672b = r10;
        m.a(r10.A());
        com.bytedance.apm.trace.a r4 = this.f4673c;
        if (r4 == null) goto L7;
        this.f4672b.a(r4);
    L7:
        d r5 = this.f4674d;
        if (r5 == null) goto L10;
        this.f4672b.a(r5.c());
        this.f4672b.a(this.f4674d.b());
        this.f4672b.b(this.f4674d.a());
        this.f4672b.b(this.f4674d.d());
    L10:
        com.bytedance.apm.d.a.a(r10.a());
        com.bytedance.apm.d.a.a(r10.t());
        com.bytedance.apm6.commonevent.a.a(r10.t());
        Application r1 = (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm.util.a.a(r11), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin");
        com.bytedance.apm.c.a(r1);
        ActivityLifeObserver.init(r1);
        com.bytedance.apm.c.c(System.nanoTime() - r2);
        l();
        n();
        com.bytedance.apm.c.d(System.nanoTime() - r2);
        com.bytedance.apm.d r6 = com.bytedance.apm.c.b();
        if (r6 == null) goto L13;
        r6.a();
    L13:
        com.bytedance.apm.c.a(r10.u());
        this.l = com.bytedance.apm.c.d();
        final Runnable r7 = com.bytedance.apm6.a.a(r11);
        com.bytedance.apm.c.e(System.nanoTime() - r2);
        com.bytedance.apm.thread.b.a().a(new AnonymousClass1(this, r10, r11, r7));
        com.bytedance.apm.c.f(System.nanoTime() - r2);
        if (this.l == false) goto L29;
        com.bytedance.apm.perf.memory.a.a(r1, this.f4672b.p());
        if (r10.b() == false) goto L18;
        new com.bytedance.apm.trace.c().a(r10.c(), true);
    L18:
        AutoPageTraceHelper.a(r10.c());
        com.bytedance.apm.agent.tracing.a.a(r10.q());
        a(r1);
        o = r10.g();
        m = r10.f();
        n = r10.e();
        com.bytedance.apm.block.trace.b.a(r10.n());
        boolean r12 = r10.h();
        boolean r3 = r10.i();
        f.a().c();
        f.a().b(r10.j());
        f.a().c(r10.k());
        f.a().d(r10.l());
        f.a().e(r10.m());
        o.f9028c = this.f4672b.z();
        if (r12 == false) goto L27;
        if (r3 == true) goto L27;
        final com.bytedance.apm.block.trace.b r13 = new com.bytedance.apm.block.trace.b();
        RealFpsTracer.a(r13);
        com.bytedance.perf.monitor.a.a(new AnonymousClass9(this, r13));
        if (Build.VERSION.SDK_INT >= 24) goto L24;
    L25:
        f.a().a(r13);
    L26:
        f.a().c(r13);
        goto L27
    L24:
        if (this.f4672b.m() == true) goto L26;
    L27:
        initEvilMethodTraceInject();
        com.bytedance.apm.f.a.b.c();
        com.bytedance.apm.f.a.a().a(r10.v());
        com.bytedance.apm.c.a(System.nanoTime() - r2);
        com.bytedance.apm.c.e(r10.y());
        com.bytedance.apm.c.d(r10.x());
    L29:
        if (com.bytedance.apm.c.i() == false) goto L36;
        DoctorManager r14 = DoctorManager.getInstance();
        if (this.l == false) goto L33;
        String r8 = "APM_INIT";
    L34:
        r14.a(r8, r10.toString());
        goto L36
    L33:
        r8 = "APM_INIT_OTHER_PROCESS";
    L36:
        if (com.bytedance.apm.h.a.c() == null) goto L38;
        com.bytedance.apm.h.a.c().c("apm_debug", "apm_init");
    L38:
        com.bytedance.apm.c.a(true);
        com.bytedance.apm.c.b(System.nanoTime() - r2);
        return;
    }

    private static void initTraceEvilMethod() {
        com.bytedance.perf.monitor.a.a(m);
        com.bytedance.perf.monitor.a.a(n);
        com.bytedance.perf.monitor.a.f9044a = true;
        f.a().c();
        g.a().b();
        new com.bytedance.perf.monitor.a(o).b();
        k.a().b(true);
    }

    public void a(c r4) {
        if (com.bytedance.apm.h.a.c() == null) goto L6;
        com.bytedance.apm.h.a.c().c("apm_debug", "start");     // Catch: Exception -> L17
    L6:
        if (this.j == false) goto L16;
        if (r4 == null) goto L14;
        if (this.k == false) goto L11;
        return;
    L11:
        com.bytedance.apm.thread.b.a().d();
        this.k = true;
        this.f4675e = r4;
        com.bytedance.apm.thread.b.a().a(new AnonymousClass11(this));
        return;
    L14:
        throw new IllegalArgumentException("startConfig must not be allowed");
    L16:
        throw new IllegalArgumentException("You must call Apm.getInstance().init() on Application.onCreate from version 5.x.x, pls call init() before start().");
    }

    private void e() {
        long r0 = System.nanoTime();     // Catch: Throwable -> L6
        com.bytedance.apm6.foundation.context.a.a(this.f4675e.b());     // Catch: Throwable -> L6
        f();     // Catch: Throwable -> L6
        if (this.l == false) goto L20;
        com.bytedance.apm.c.g(System.nanoTime() - r0);     // Catch: Throwable -> L6
        m();     // Catch: Throwable -> L6
        return;
    L20:
        return;
    L6:
        th = move-exception;
        if (com.bytedance.apm.c.i() == false) goto L11;
        th.printStackTrace();
        DoctorManager.getInstance().a("APM_START_ERROR", u.a(th));
    L11:
        if (com.bytedance.apm.h.a.c() == null) goto L18;
        com.bytedance.apm.h.a.c().c("apm_debug", "APM_START_ERROR:" + u.a(th));
    L18:
        com.bytedance.apm.thread.b.a().c();     // Catch: Throwable -> L15
        return;
    }

    private void f() {
        b.a();
        com.bytedance.apm.c.k(System.currentTimeMillis());
        com.bytedance.apm.c.a(this.f4675e.c());
        com.bytedance.apm6.monitor.a.a(this.f4675e.H());
        j();
        com.bytedance.apm.m.c.a(new com.bytedance.apm.l.a());
        com.bytedance.apm.j.a().a(new AnonymousClass12(this));
        com.bytedance.apm.c.a(this.f4675e.l());
        com.bytedance.apm.c.a(this.f4675e.d());
        com.bytedance.apm.c.a(this.f4675e.m());
        com.bytedance.apm.c.a(this.f4675e.n());
        com.bytedance.apm.c.a(this.f4675e.f());
        com.bytedance.apm.c.b(this.f4675e.E());
        this.g = this.f4675e.C();
        this.p = this.f4675e.o();
        h();
        com.bytedance.apm.j.a.a().a(this.f4675e.z());
        com.bytedance.apm.d.a.a.c().a();
        com.bytedance.apm.d.a.d.c().a();
        com.bytedance.apm.d.a.d.c().b(this.f4675e.D());
        com.bytedance.apm.b.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm.c.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), this.f4672b.w());
        g();
        long r2 = this.f4675e.u();
        Runnable r0 = new AnonymousClass13(this);
        if (r2 > 0) goto L5;
        com.bytedance.apm.thread.b.a().a(r0);
    L7:
        if (com.bytedance.apm.c.i() == false) goto L10;
        com.bytedance.apm.h.a.b("apm_debug", "delayRequestSeconds:" + r2);
    L10:
        if (this.l == false) goto L12;
        k();
    L12:
        a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm.c.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        com.bytedance.services.apm.api.m r1 = new com.bytedance.services.apm.api.m();
        r1.a(this.f4675e.i());
        a(r1);
        b();
        com.bytedance.apm.thread.b.a().a(this.f4675e.B());
        b(this.f4675e);
        com.bytedance.apm.g.b r3 = this.f4675e.y();
        this.f = r3;
        if (r3 == null) goto L15;
        r3.a();
    L15:
        com.bytedance.apm.agent.tracing.a.d();
        com.bytedance.news.common.service.manager.d.a(IHttpService.class, new AnonymousClass7(this));
        if (com.bytedance.apm.c.i() == false) goto L23;
        DoctorManager r4 = DoctorManager.getInstance();
        if (this.l == false) goto L20;
        String r5 = "APM_START";
    L21:
        r4.a(r5, this.f4675e.toString());
        goto L23
    L20:
        r5 = "APM_START_OTHER_PROCESS";
    L23:
        if (com.bytedance.apm.h.a.c() == null) goto L26;
        com.bytedance.apm.h.a.c().c("apm_debug", "APM_START");
        return;
    L26:
        return;
    L5:
        com.bytedance.apm.thread.b.a().a(r0, 1000 * r2);
        goto L7
    }

    private static void g() {
        String r0 = aa.c();     // Catch: Throwable -> L6
        if (TextUtils.isEmpty(r0) == true) goto L11;
        com.bytedance.apm.c.p().put("bytrace_id", r0);     // Catch: Throwable -> L6
        com.bytedance.apm.c.p().put("pid", String.valueOf(Process.myPid()));     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
    }

    private void b(c r8) {
        List<String> r0 = r8.i();
        if (com.bytedance.apm.util.j.a(r0) == true) goto L15;
        int r1 = 0;
        String r2 = new URL((String) ZeusTransformUtils.preCheckCast(r0.get(0), String.class, "com.obric.aiagent.plugin")).getHost();     // Catch: MalformedURLException -> L19
        com.bytedance.apm.k.a.a(r2);     // Catch: MalformedURLException -> L19
        com.bytedance.apm.k.a.b(r2);     // Catch: MalformedURLException -> L19
        com.bytedance.apm.b.a.a.a(r2);     // Catch: MalformedURLException -> L19
    L6:
        ArrayList r3 = new ArrayList(2);
        int r4 = r0.size();
    L7:
        if (r1 >= r4) goto L14;
        String r5 = new URL((String) ZeusTransformUtils.preCheckCast(r0.get(r1), String.class, "com.obric.aiagent.plugin")).getHost();     // Catch: Exception -> L20
        if (TextUtils.isEmpty(r5) == true) goto L13;
        if (r5.indexOf(46) <= 0) goto L13;
        r3.add("https://" + r5 + "/monitor/collect/batch/");     // Catch: Exception -> L20
    L13:
        r1 = r1 + 1;
        goto L7
    L14:
        com.bytedance.apm6.consumer.slardar.d.c.a().a(r3);
    L15:
        com.bytedance.apm6.consumer.slardar.d.c.a().c(com.bytedance.apm.c.a.f4462c);
        com.bytedance.apm6.consumer.slardar.d.c.a().b(com.bytedance.apm.c.a.f4463d);
        com.bytedance.apm6.consumer.slardar.d.c.a().b(r8.j());
        List<String> r7 = r8.k();
        if (com.bytedance.apm.util.j.a(r7) == true) goto L29;
        com.bytedance.apm6.consumer.slardar.d.c.a().c(r7);
        return;
    }

    private void h() {
        com.bytedance.apm6.a.b.a().c();
        if (this.l == false) goto L5;
        com.bytedance.apm.perf.f r0 = new com.bytedance.apm.perf.f();
        r0.a(this.f4675e.A());
        r0.j();
    L5:
        com.bytedance.apm.perf.a.f.a(this.f4675e.F());
        com.bytedance.apm6.disk.a.a().a(this.f4675e.A());
        com.bytedance.apm6.a.b.a().a(this.f4675e.e());
        if (this.f4675e.p() == true) goto L8;
        return;
    L8:
        if (this.f4675e.q() == true) goto L12;
        i();
        return;
    }

    private void i() {
        if (this.f4671a == false) goto L5;
        return;
    L5:
        this.f4671a = true;
        com.bytedance.apm.thread.a.a().post(new AnonymousClass2(this));
        com.bytedance.apm.block.b r0 = new com.bytedance.apm.block.b();
        r0.a(this.f4675e.t());
        r0.b(this.f4675e.r());
        r0.c(this.f4675e.s());
        r0.a(this.f4675e.G());
        r0.b();
        if (ActivityLifeObserver.getInstance().isForeground() == false) goto L8;
        r0.c();
    L8:
        r0.a(this.f4672b.C());
    }

    private void j() {
        if (com.bytedance.apm.util.j.a(this.f4675e.f()) == false) goto L8;
        if (com.bytedance.apm.util.j.a(this.r) == true) goto L8;
        this.f4675e.b(this.r);
    L8:
        if (com.bytedance.apm.util.j.a(this.f4675e.i()) == false) goto L13;
        if (com.bytedance.apm.util.j.a(this.s) == true) goto L13;
        this.f4675e.a(this.s);
    L13:
        if (com.bytedance.apm.util.j.a(this.f4675e.j()) == true) goto L15;
        return;
    L15:
        if (com.bytedance.apm.util.j.a(this.t) == true) goto L19;
        this.f4675e.c(this.t);
        return;
    }

    private void k() {
        String r2 = b.a().a("update_version_code");
        String r1 = com.bytedance.apm.c.p().optString("update_version_code");
        if (TextUtils.equals(r2, r1) == true) goto L5;
        com.bytedance.apm.c.a(1);
        b.a().a("update_version_code", r1);
        return;
    L5:
        com.bytedance.apm.c.a(2);
    }

    private void a(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        Set<j> r3 = this.p;
        if (r3 != null) goto L5;
        return;
    L5:
        Iterator<j> r6 = r3.iterator();
    L7:
        if (r6.hasNext() == false) goto L11;
        ((j) ZeusTransformUtils.preCheckCast(r6.next(), j.class, "com.obric.aiagent.plugin")).init(r5);     // Catch: Throwable -> L12
        goto L7
    }

    public void a(com.bytedance.services.apm.api.m r4) {
        Set<j> r3 = this.p;
        if (r3 != null) goto L5;
        return;
    L5:
        Iterator<j> r5 = r3.iterator();
    L7:
        if (r5.hasNext() == false) goto L11;
        ((j) ZeusTransformUtils.preCheckCast(r5.next(), j.class, "com.obric.aiagent.plugin")).notifyParams(r4);     // Catch: Throwable -> L12
        goto L7
    }

    public void b() {
        Set<j> r3 = this.p;
        if (r3 != null) goto L5;
        return;
    L5:
        Iterator<j> r4 = r3.iterator();
    L7:
        if (r4.hasNext() == false) goto L11;
        ((j) ZeusTransformUtils.preCheckCast(r4.next(), j.class, "com.obric.aiagent.plugin")).start();     // Catch: Throwable -> L12
        goto L7
    }

    private void l() {
        SlardarConfigManagerImpl r0 = new SlardarConfigManagerImpl();
        this.h = r0;
        r0.registerConfigListener(this);
        com.bytedance.news.common.service.manager.d.a(IConfigManager.class, this.h);
        com.bytedance.news.common.service.manager.d.a(IApmAgent.class, new AnonymousClass3(this));
        com.bytedance.news.common.service.manager.d.a(ILaunchTrace.class, new AnonymousClass4(this));
        com.bytedance.news.common.service.manager.d.a(com.bytedance.services.apm.api.k.class, new AnonymousClass5(this));
        com.bytedance.news.common.service.manager.d.a(l.class, new AnonymousClass6(this));
    }

    public com.bytedance.apm.config.b c() {
        com.bytedance.apm.config.b r0 = this.f4672b;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return com.bytedance.apm.config.b.B().a();
    }

    @Override // com.bytedance.services.slardar.config.a
    public void onRefresh(JSONObject r2, boolean r3) {
        JSONObject r4 = r2.optJSONObject("general");
        if (r4 == null) goto L5;
        this.q = r4.optBoolean("enable_active_upload_alog", true);
        return;
    L5:
        this.q = true;
    }

    @Override // com.bytedance.services.slardar.config.a
    public void onReady() {
        boolean r0 = true;
        this.i = true;
        com.bytedance.apm.g.b r1 = this.f;
        if (r1 == null) goto L5;
        r1.b();
    L5:
        JSONObject r2 = this.h.getConfig();
        if (this.l == false) goto L14;
        new h().j();
        if (i.a(r2, "performance_modules", "traffic", "enable_collect") != 1) goto L10;
        boolean r3 = true;
    L11:
        if (r3 == false) goto L14;
        com.bytedance.apm.perf.a.f.a().j();
        goto L14
    L10:
        r3 = false;
    L14:
        if (this.f4675e.v() == false) goto L40;
        if (i.a(r2, "performance_modules", Scraps.BATTERY, "enable_upload") != 1) goto L18;
        boolean r5 = true;
    L19:
        if (r5 == false) goto L21;
        com.bytedance.apm.battery.e.a();
    L21:
        if (r5 == false) goto L23;
    L24:
        com.bytedance.apm.battery.e.a(this.f4675e.w());
    L26:
        if (i.a(r2, "performance_modules", Scraps.BATTERY, "power_monitor_enable") != 1) goto L28;
        boolean r6 = true;
    L29:
        if (r6 == false) goto L32;
        com.bytedance.apm.battery.e.b();
    L32:
        if (i.a(r2, "performance_modules", Scraps.BATTERY, "temperature_enable_upload") == 1) goto L35;
        r0 = false;
    L35:
        if (r0 == false) goto L37;
    L38:
        com.bytedance.apm.battery.e.b(this.f4675e.x());
        goto L40
    L37:
        if (this.f4675e.x() == false) goto L40;
    L28:
        r6 = false;
        goto L29
    L23:
        if (this.f4675e.w() == false) goto L26;
    L18:
        r5 = false;
    L40:
        if (this.f4675e.q() == true) goto L42;
        return;
    L42:
        if (com.bytedance.apm.perf.c.a().b("block_monitor") == false) goto L46;
        i();
        return;
    }

    public boolean a(String r2) {
        if (this.i == false) goto L9;
        SlardarConfigManagerImpl r1 = this.h;
        if (r1 != null) goto L8;
        return false;
    L8:
        return r1.getLogTypeSwitch(r2);
    L9:
        return false;
    }

    public boolean b(String r2) {
        if (this.i == false) goto L9;
        SlardarConfigManagerImpl r1 = this.h;
        if (r1 != null) goto L8;
        return false;
    L8:
        return r1.getServiceSwitch(r2);
    L9:
        return false;
    }

    public boolean c(String r2) {
        if (this.i == false) goto L9;
        SlardarConfigManagerImpl r1 = this.h;
        if (r1 != null) goto L8;
        return false;
    L8:
        return r1.getMetricTypeSwitch(r2);
    L9:
        return false;
    }

    public e d() {
        return this.g;
    }

    public void a(final String r14, final long r15, final long r17, final String r19, com.bytedance.apm.b.e r20, com.bytedance.apm.b.d r21) {
        final com.bytedance.apm.b.e r10 = (com.bytedance.apm.b.e) ZeusTransformUtils.wrapperContextForParams(r20, com.bytedance.apm.b.e.class, "com.obric.aiagent.plugin");
        final com.bytedance.apm.b.d r11 = (com.bytedance.apm.b.d) ZeusTransformUtils.wrapperContextForParams(r21, com.bytedance.apm.b.d.class, "com.obric.aiagent.plugin");
        if (this.q == false) goto L5;
        com.bytedance.apm.thread.b.a().c(new AnonymousClass8(this, r14, r15, r17, r19, r10, r11));
        return;
    L5:
        if (r11 == null) goto L9;
        r11.onCallback(false, com.bytedance.apm.b.b.a(false, 9, null, null));
        return;
    }

    private void m() {
        JSONObject r0 = new JSONObject();     // Catch: JSONException -> L4
        r0.put("init", com.bytedance.apm.c.w());     // Catch: JSONException -> L4
        r0.put("init_finish", com.bytedance.apm.c.x());     // Catch: JSONException -> L4
        r0.put("init_step2", com.bytedance.apm.c.y());     // Catch: JSONException -> L4
        r0.put("init_step3", com.bytedance.apm.c.z());     // Catch: JSONException -> L4
        r0.put("init_step4", com.bytedance.apm.c.A());     // Catch: JSONException -> L4
        r0.put("init_step5", com.bytedance.apm.c.B());     // Catch: JSONException -> L4
        r0.put("start", com.bytedance.apm.c.C());     // Catch: JSONException -> L4
        JSONObject r1 = new JSONObject();     // Catch: JSONException -> L4
        r1.put("is_main_process", this.l);     // Catch: JSONException -> L4
        com.bytedance.apm.b.a("apm_cost", r1, r0, null);     // Catch: JSONException -> L4
        return;
    }

    private static void n() {
        if (com.bytedance.apm.c.i() == true) goto L5;
        return;
    L5:
        DoctorManager.getInstance().registerApmListener(new AnonymousClass10());
    }
}
