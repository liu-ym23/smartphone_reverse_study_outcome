package com.bytedance.apm.internal;

import android.app.Application;
import android.content.Context;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.apm.ApmAgent;
import com.bytedance.apm.MonitorCoreExceptionManager;
import com.bytedance.apm.agent.tracing.AutoLaunchTraceHelper;
import com.bytedance.apm.agent.tracing.AutoPageTraceHelper;
import com.bytedance.apm.alog.net.AlogUploadService;
import com.bytedance.apm.config.SlardarConfigManagerImpl;
import com.bytedance.apm.constant.CommonConsts;
import com.bytedance.apm.constant.SlardarSettingsConsts;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm.core.IQueryParams;
import com.bytedance.apm.doctor.DoctorManager;
import com.bytedance.apm.impl.ApmAgentServiceImpl;
import com.bytedance.apm.impl.LaunchTraceImpl;
import com.bytedance.apm.listener.IApmStartListener;
import com.bytedance.apm.thread.AsyncEventManager;
import com.bytedance.apm.trace.ITraceListener;
import com.bytedance.apm.util.ListUtils;
import com.bytedance.apm.util.t;
import com.bytedance.apm6.hub.Apm;
import com.bytedance.apm6.memory.MemoryCollector;
import com.bytedance.crash.NpthApi;
import com.bytedance.monitor.collector.LooperMonitor;
import com.bytedance.monitor.collector.PerfMonitorManager;
import com.bytedance.news.common.service.manager.ServiceCreator;
import com.bytedance.perf.monitor.IBlockListener;
import com.bytedance.services.apm.api.IApmAgent;
import com.bytedance.services.apm.api.IEncrypt;
import com.bytedance.services.apm.api.IHttpService;
import com.bytedance.services.apm.api.ILaunchTrace;
import com.bytedance.services.apm.api.IWidget;
import com.bytedance.services.apm.api.IZstdCompress;
import com.bytedance.services.apm.api.IZstdDict;
import com.bytedance.services.slardar.config.IConfigListener;
import com.bytedance.services.slardar.config.IConfigManager;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ApmDelegate implements IConfigListener {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static long f6461q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static boolean f6462r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static boolean f6463s;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public h1.b f6464a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ITraceListener f6465b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public h1.c f6466c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public IApmStartListener f6467d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public IEncrypt f6468e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public SlardarConfigManagerImpl f6469f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile boolean f6470g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile boolean f6471h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile boolean f6472i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f6473j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Set f6474k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f6475l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f6476m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public List f6477n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public List f6478o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public List f6479p;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ApmDelegate f6480a;

        public a(ApmDelegate r10) {
            this.f6480a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            LooperMonitor.h();
        }
    }

    public class b implements ServiceCreator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ApmDelegate f6481a;

        public b(ApmDelegate r10) {
            this.f6481a = r10;
        }

        public IApmAgent a() {
            return new ApmAgentServiceImpl();
        }

        @Override // com.bytedance.news.common.service.manager.ServiceCreator
        public /* bridge */ /* synthetic */ Object create() {
            return a();
        }
    }

    public class c implements ServiceCreator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ApmDelegate f6482a;

        public c(ApmDelegate r10) {
            this.f6482a = r10;
        }

        public ILaunchTrace a() {
            return new LaunchTraceImpl();
        }

        @Override // com.bytedance.news.common.service.manager.ServiceCreator
        public /* bridge */ /* synthetic */ Object create() {
            return a();
        }
    }

    public class d implements ServiceCreator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ApmDelegate f6483a;

        public d(ApmDelegate r10) {
            this.f6483a = r10;
        }

        public IZstdCompress a() {
            return new w0.i();
        }

        @Override // com.bytedance.news.common.service.manager.ServiceCreator
        public /* bridge */ /* synthetic */ Object create() {
            return a();
        }
    }

    public class e implements ServiceCreator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ApmDelegate f6484a;

        public e(ApmDelegate r10) {
            this.f6484a = r10;
        }

        public IZstdDict a() {
            return (IZstdDict) o3.a.a(IZstdDict.class);
        }

        @Override // com.bytedance.news.common.service.manager.ServiceCreator
        public /* bridge */ /* synthetic */ Object create() {
            return a();
        }
    }

    public class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ApmDelegate f6485a;

        public f(ApmDelegate r10) {
            this.f6485a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            PerfMonitorManager.o().D();
        }
    }

    public class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ApmDelegate f6486a;

        public g(ApmDelegate r10) {
            this.f6486a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            PerfMonitorManager.o().A();
        }
    }

    public class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h1.b f6487a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f6488b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Runnable f6489c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ ApmDelegate f6490d;

        public h(ApmDelegate r10, h1.b r11, Context r12, Runnable r13) {
            this.f6490d = r10;
            this.f6487a = r11;
            this.f6488b = r12;
            this.f6489c = r13;
        }

        @Override // java.lang.Runnable
        public void run() {
            ApmDelegate.a(this.f6490d).registerConfigListener(ApmDelegate.j());
            com.bytedance.apm.trace.a.f(this.f6487a.l());
            com.bytedance.apm.trace.a.g(this.f6487a.k());
            com.bytedance.apm.internal.a.d(this.f6488b);
            w0.c.w();
            if (ApmDelegate.b(this.f6490d) == false) goto L17;
            g1.d.A().R();
            g5.d.a r10 = new g5.d.a();
            g5.d.a r11 = r10.g(com.bytedance.apm.internal.a.a());
            if (com.bytedance.apm.internal.a.a() != 0) goto L7;
        L9:
            boolean r12 = false;
        L10:
            g5.d.a r13 = r11.i(r12);
            if (this.f6487a.r() == true) goto L13;
        L15:
            boolean r14 = false;
        L16:
            r13.j(r14).m(com.bytedance.apm.internal.a.c(64)).k(false).l(!ApmDelegate.c(this.f6490d).u()).n(com.bytedance.apm.internal.a.b());
            PerfMonitorManager.o().t(w0.c.g(), r10.h());
            PerfMonitorManager.o().A();
            PerfMonitorManager.o().y(ApmDelegate.c(this.f6490d).s());
        L18:
            com.bytedance.apm.block.f.a().d();
            Runnable r15 = this.f6489c;
            if (r15 == null) goto L22;
            r15.run();
        L22:
            if (w0.c.B() == false) goto L29;
            DoctorManager r16 = DoctorManager.getInstance();
            if (ApmDelegate.b(this.f6490d) == false) goto L26;
            String r17 = "APM_INIT_ASYNC";
        L27:
            r16.b(r17, "done");
            return;
        L26:
            r17 = "APM_INIT_ASYNC_OTHER_PROCESS";
            goto L27
        L29:
            return;
        L13:
            if (com.bytedance.apm.internal.a.c(2) == false) goto L15;
            r14 = true;
            goto L16
        L7:
            if (com.bytedance.apm.internal.a.c(2) == false) goto L9;
            r12 = true;
            goto L10
        L17:
            PerfMonitorManager.v(w0.c.g());
            goto L18
        }
    }

    public static class i implements DoctorManager.ApmListener {
        public i() {
        }

        public final void a(String r10, String r11, boolean r12) {
            int r13 = 3995 - r10.length();
            if (r11.length() > r13) goto L8;
            if (r12 == false) goto L6;
            s1.c.c("APM-Doctor-Log", new String[]{r10, " " + r11});
            return;
        L6:
            s1.c.d("APM-Doctor-Log", new String[]{r10, " " + r11});
            return;
        L8:
            int r14 = 0;
        L10:
            if (r14 >= r11.length()) goto L19;
            int r15 = r14 + r13;
            if (r15 >= r11.length()) goto L14;
            String r16 = r11.substring(r14, r15);
        L15:
            if (r12 == false) goto L17;
            s1.c.c("APM-Doctor-Log", new String[]{r10, " " + r16});
        L18:
            r14 = r15;
            goto L10
        L17:
            s1.c.d("APM-Doctor-Log", new String[]{r10, " " + r16});
            goto L18
        L14:
            r16 = r11.substring(r14);
            goto L15
        }

        @Override // com.bytedance.apm.doctor.DoctorManager.ApmListener
        public void onDataEvent(int r10, String r11, JSONObject r12) {
            if (TextUtils.equals(r11, "DATA_CACHE") == false) goto L5;
            return;
        L5:
            if (TextUtils.equals(r11, "DATA_SEND_END") == false) goto L7;
            return;
        L7:
            if (TextUtils.equals(r11, "DATA_SEND_RESPONSE") == false) goto L10;
            return;
        L10:
            if (TextUtils.equals(r11, "DATA_RECEIVE") == true) goto L12;
        L14:
            a("onDataEvent[" + r10 + "] " + r11 + " [service:" + r12.optString("service") + "|logType:" + r12.optString("log_type") + "] = ", r12.toString(), r11.contains("ERROR"));
            return;
        L12:
            if (r12.optJSONObject("DATA_DOCTOR").optBoolean("DATA_SAMPLE") == true) goto L14;
            r11 = "DATA_NOT_SAMPLED";
            goto L14
        }

        @Override // com.bytedance.apm.doctor.DoctorManager.ApmListener
        public void onEvent(String r10, String r11) {
            a("onEvent key=" + r10, r11, false);
        }
    }

    public class j implements IBlockListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g1.b f6491a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ApmDelegate f6492b;

        public j(ApmDelegate r10, g1.b r11) {
            this.f6492b = r10;
            this.f6491a = r11;
        }

        @Override // com.bytedance.perf.monitor.IBlockListener
        public void doBlock(long r10, boolean r11) {
            this.f6491a.k(r10, r11);
        }
    }

    public class k implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ApmDelegate f6493a;

        public k(ApmDelegate r10) {
            this.f6493a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            ApmDelegate.d(this.f6493a);
        }
    }

    public class l implements MonitorCoreExceptionManager.ExceptionCallBack {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ApmDelegate f6494a;

        public l(ApmDelegate r10) {
            this.f6494a = r10;
        }

        @Override // com.bytedance.apm.MonitorCoreExceptionManager.ExceptionCallBack
        public void directReportError(Throwable r10, String r11) {
            i6.a.f(5, r10, r11, false);
        }

        @Override // com.bytedance.apm.MonitorCoreExceptionManager.ExceptionCallBack
        public void ensureNotReachHere(Throwable r10, String r11) {
            i6.a.d(r10, r11);
        }

        @Override // com.bytedance.apm.MonitorCoreExceptionManager.ExceptionCallBack
        public void ensureNotReachHere(String r10) {
            i6.a.a(r10);
        }

        @Override // com.bytedance.apm.MonitorCoreExceptionManager.ExceptionCallBack
        public void ensureNotReachHere(Throwable r10, String r11, Map r12) {
            i6.a.e(r10, r11, r12);
        }
    }

    public class m implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ApmDelegate f6495a;

        public class a implements IQueryParams {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ m f6496a;

            public a(m r10) {
                this.f6496a = r10;
            }

            @Override // com.bytedance.apm.core.IQueryParams
            public Map getQueryParams() {
                return w0.c.x();
            }
        }

        public m(ApmDelegate r10) {
            this.f6495a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            ApmDelegate.a(this.f6495a).initParams(ApmDelegate.e(this.f6495a).A(), new a(this), ApmDelegate.e(this.f6495a).t());
            if (ApmDelegate.e(this.f6495a).B() == true) goto L5;
        L7:
            ApmDelegate.a(this.f6495a).fetchConfig();
            return;
        L5:
            if (w0.c.F() == false) goto L7;
            ApmDelegate.a(this.f6495a).forceUpdateFromRemote(null, null);
        }
    }

    public static class n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ApmDelegate f6497a = null;

        static {
            f6497a = new ApmDelegate(null);
        }

        public static /* synthetic */ ApmDelegate a() {
            return f6497a;
        }
    }

    public /* synthetic */ ApmDelegate(h r10) {
        this();
    }

    public static /* synthetic */ SlardarConfigManagerImpl a(ApmDelegate r10) {
        return r10.f6469f;
    }

    public static /* synthetic */ boolean b(ApmDelegate r10) {
        return r10.f6473j;
    }

    public static /* synthetic */ h1.b c(ApmDelegate r10) {
        return r10.f6464a;
    }

    public static /* synthetic */ void d(ApmDelegate r10) {
        r10.C();
    }

    public static /* synthetic */ h1.c e(ApmDelegate r10) {
        return r10.f6466c;
    }

    private void initEvilMethodTraceInject() {
    }

    private static void initTraceEvilMethod() {
        o5.a.j(f6461q);
        o5.a.k(f6462r);
        o5.a.f22500n = true;
        g1.d.A().C();
        g1.e.E().K();
        new o5.a(f6463s).m();
        PerfMonitorManager.o().z(true);
    }

    public static ApmDelegate j() {
        return n.a();
    }

    public static void q() {
        String r10 = NpthApi.a();     // Catch: Throwable -> L6
        if (TextUtils.isEmpty(r10) == true) goto L11;
        w0.c.k().put("bytrace_id", r10);     // Catch: Throwable -> L6
        w0.c.k().put("pid", String.valueOf(Process.myPid()));     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
    }

    public static void v() {
        if (w0.c.B() == true) goto L5;
        return;
    L5:
        DoctorManager.getInstance().registerApmListener(new i());
    }

    public void A() {
        Set r10 = this.f6474k;
        if (r10 != null) goto L5;
        return;
    L5:
        Iterator r11 = r10.iterator();
    L7:
        if (r11.hasNext() == false) goto L11;
        ((IWidget) r11.next()).start();     // Catch: Throwable -> L12
        goto L7
    }

    public final void B() {
        com.bytedance.apm.internal.b.a();
        w0.c.g0(System.currentTimeMillis());
        w0.c.d0(this.f6466c.s());
        l3.a.f(this.f6466c.o());
        g();
        b2.b.g(new a2.a());
        MonitorCoreExceptionManager.e().f(new l(this));
        w0.c.Q(this.f6466c.m());
        w0.c.P(this.f6466c.i());
        w0.c.R(this.f6466c.n());
        w0.c.e0(this.f6466c.t());
        w0.c.J(this.f6466c.b());
        this.f6468e = this.f6466c.j();
        this.f6474k = this.f6466c.x();
        s();
        u1.a.b().a(this.f6466c.c());
        l1.a.p().j();
        l1.b.t().j();
        l1.b.t().J(this.f6466c.q());
        x0.a.a(w0.c.g(), this.f6464a.c());
        q();
        long r10 = this.f6466c.h();
        m r11 = new m(this);
        if (r10 > 0) goto L5;
        AsyncEventManager.e().h(r11);
    L7:
        if (w0.c.B() == false) goto L10;
        s1.a.d("apm_debug", "delayRequestSeconds:" + r10);
    L10:
        if (this.f6473j == false) goto L12;
        f();
    L12:
        o(w0.c.g());
        i6.d r12 = new i6.d();
        r12.b(this.f6466c.g());
        u(r12);
        A();
        AsyncEventManager.e().g(this.f6466c.l());
        t(this.f6466c);
        IApmStartListener r13 = this.f6466c.d();
        this.f6467d = r13;
        if (r13 == null) goto L15;
        r13.onStartComplete();
    L15:
        AutoLaunchTraceHelper.reportStats();
        n5.b.d(IHttpService.class, new AnonymousClass7(this));
        if (w0.c.B() == false) goto L23;
        DoctorManager r14 = DoctorManager.getInstance();
        if (this.f6473j == false) goto L20;
        String r15 = "APM_START";
    L21:
        r14.b(r15, this.f6466c.toString());
        goto L23
    L20:
        r15 = "APM_START_OTHER_PROCESS";
    L23:
        if (s1.a.c() == null) goto L26;
        s1.a.c().i("apm_debug", "APM_START");
        return;
    L26:
        return;
    L5:
        AsyncEventManager.e().j(r11, 1000 * r10);
        goto L7
    }

    public final void C() {
        long r10 = System.nanoTime();     // Catch: Throwable -> L6
        d3.a.E(this.f6466c.r());     // Catch: Throwable -> L6
        B();     // Catch: Throwable -> L6
        if (this.f6473j == false) goto L20;
        w0.c.f0(System.nanoTime() - r10);     // Catch: Throwable -> L6
        x();     // Catch: Throwable -> L6
        return;
    L20:
        return;
    L6:
        th = move-exception;
        if (w0.c.B() == false) goto L11;
        th.printStackTrace();
        DoctorManager.getInstance().b("APM_START_ERROR", t.a(th));
    L11:
        if (s1.a.c() == null) goto L18;
        s1.a.c().i("apm_debug", "APM_START_ERROR:" + t.a(th));
    L18:
        AsyncEventManager.e().m();     // Catch: Throwable -> L15
        return;
    }

    public void D() {
        AsyncEventManager.e().h(new f(this));
        AsyncEventManager.e().m();
        Apm.f();
    }

    public final void f() {
        String r10 = com.bytedance.apm.internal.b.a().d("update_version_code");
        String r11 = w0.c.k().optString("update_version_code");
        if (TextUtils.equals(r10, r11) == true) goto L5;
        w0.c.c0(1);
        com.bytedance.apm.internal.b.a().g("update_version_code", r11);
        return;
    L5:
        w0.c.c0(2);
    }

    public final void g() {
        if (ListUtils.b(this.f6466c.t()) == false) goto L8;
        if (ListUtils.b(this.f6477n) == true) goto L8;
        this.f6466c.J(this.f6477n);
    L8:
        if (ListUtils.b(this.f6466c.g()) == false) goto L13;
        if (ListUtils.b(this.f6478o) == true) goto L13;
        this.f6466c.H(this.f6478o);
    L13:
        if (ListUtils.b(this.f6466c.k()) == true) goto L15;
        return;
    L15:
        if (ListUtils.b(this.f6479p) == true) goto L19;
        this.f6466c.I(this.f6479p);
        return;
    }

    public h1.b h() {
        h1.b r10 = this.f6464a;
        if (r10 == null) goto L5;
        return r10;
    L5:
        return h1.b.a().E();
    }

    public IEncrypt i() {
        return this.f6468e;
    }

    public boolean k(String r10) {
        if (this.f6470g == false) goto L9;
        SlardarConfigManagerImpl r11 = this.f6469f;
        if (r11 != null) goto L8;
        return false;
    L8:
        return r11.getLogTypeSwitch(r10);
    L9:
        return false;
    }

    public boolean l(String r10) {
        if (this.f6470g == false) goto L9;
        SlardarConfigManagerImpl r11 = this.f6469f;
        if (r11 != null) goto L8;
        return false;
    L8:
        return r11.getMetricTypeSwitch(r10);
    L9:
        return false;
    }

    public boolean m(String r10) {
        if (this.f6470g == false) goto L9;
        SlardarConfigManagerImpl r11 = this.f6469f;
        if (r11 != null) goto L8;
        return false;
    L8:
        return r11.getServiceSwitch(r10);
    L9:
        return false;
    }

    public void n(Context r10, h1.b r11) {
        if (this.f6471h == true) goto L32;
        long r12 = System.nanoTime();
        this.f6471h = true;
        w0.c.z();
        w0.c.Y(System.currentTimeMillis());
        w0.c.Z(System.currentTimeMillis() - SystemClock.uptimeMillis());
        this.f6464a = r11;
        com.bytedance.apm.util.k.d(r11.f());
        ITraceListener r13 = this.f6465b;
        if (r13 == null) goto L7;
        this.f6464a.B(r13);
    L7:
        k1.a.n(r11.d());
        k1.a.o(r11.y());
        k2.a.m(r11.y());
        Application r14 = com.bytedance.apm.util.a.a(r10);
        w0.c.L(r14);
        ActivityLifeObserver.init(r14);
        w0.c.T(System.nanoTime() - r12);
        w();
        v();
        w0.c.U(System.nanoTime() - r12);
        w0.c.w();
        w0.c.M(r11.j());
        this.f6473j = w0.c.F();
        Runnable r15 = j2.a.b(r10);
        w0.c.V(System.nanoTime() - r12);
        AsyncEventManager.e().h(new h(this, r11, r10, r15));
        w0.c.W(System.nanoTime() - r12);
        if (this.f6473j == false) goto L21;
        this.f6464a.b();
        w1.a.a(r14, null);
        if (r11.A() == false) goto L12;
        new e2.b().k(r11.i(), true);
    L12:
        AutoPageTraceHelper.setMaxValidTimeMs(r11.i());
        AutoLaunchTraceHelper.setMaxValidTimeMs(r11.h());
        r(r14);
        f6463s = r11.x();
        f6461q = r11.e();
        f6462r = r11.z();
        g1.b.n(r11.n());
        boolean r16 = r11.w();
        boolean r17 = r11.q();
        g1.d.A().C();
        g1.d.A().O(r11.o());
        g1.d.A().M(r11.s());
        g1.d.A().N(r11.u());
        g5.h.f19951c = this.f6464a.t();
        if (r16 == false) goto L19;
        if (r17 == true) goto L19;
        g1.b r18 = new g1.b();
        com.bytedance.apm.trace.fps.a.w(r18);
        o5.a.i(new j(this, r18));
        if (this.f6464a.u() == true) goto L18;
        g1.d.A().u(r18);
    L18:
        g1.d.A().P(r18);
    L19:
        initEvilMethodTraceInject();
        com.bytedance.apm.launch.evil.b.a();
        r1.a.b().f(r11.g());
        w0.c.S(System.nanoTime() - r12);
        w0.c.O(r11.p());
        w0.c.i0(r11.C());
    L21:
        if (w0.c.B() == false) goto L28;
        DoctorManager r19 = DoctorManager.getInstance();
        if (this.f6473j == false) goto L25;
        String r20 = "APM_INIT";
    L26:
        r19.b(r20, r11.toString());
        goto L28
    L25:
        r20 = "APM_INIT_OTHER_PROCESS";
    L28:
        if (s1.a.c() == null) goto L30;
        s1.a.c().i("apm_debug", "apm_init");
    L30:
        w0.c.b0(true);
        w0.c.X(System.nanoTime() - r12);
        return;
    }

    public final void o(Context r10) {
        Set r11 = this.f6474k;
        if (r11 != null) goto L5;
        return;
    L5:
        Iterator r12 = r11.iterator();
    L7:
        if (r12.hasNext() == false) goto L11;
        ((IWidget) r12.next()).init(r10);     // Catch: Throwable -> L12
        goto L7
    }

    @Override // com.bytedance.services.slardar.config.IConfigListener
    public void onReady() {
        this.f6470g = true;
        IApmStartListener r10 = this.f6467d;
        if (r10 == null) goto L5;
        r10.onReady();
    L5:
        JSONObject r11 = this.f6469f.getConfig();
        if (this.f6473j == false) goto L11;
        new v1.h().c();
        if (com.bytedance.apm.util.i.f(r11, "performance_modules", "traffic", "enable_collect") != 1) goto L11;
        y1.e.n().c();
    L11:
        if (this.f6466c.E() == false) goto L32;
        if (com.bytedance.apm.util.i.f(r11, "performance_modules", "battery", "enable_upload") != 1) goto L15;
        boolean r12 = true;
    L16:
        if (r12 == false) goto L18;
        y0.e.b();
    L18:
        if (r12 == false) goto L20;
    L21:
        y0.e.a(this.f6466c.y());
    L23:
        if (com.bytedance.apm.util.i.f(r11, "performance_modules", "battery", SlardarSettingsConsts.PER_POWER_MONITOR_ENABLE) != 1) goto L26;
        y0.e.d();
    L26:
        if (com.bytedance.apm.util.i.f(r11, "performance_modules", "battery", SlardarSettingsConsts.PERF_KEY_BATTERY_TEMPERATURE_ENABLE_UPLOAD) != 1) goto L29;
    L30:
        y0.e.c(this.f6466c.D());
        goto L32
    L29:
        if (this.f6466c.D() == false) goto L32;
    L20:
        if (this.f6466c.y() == false) goto L23;
    L15:
        r12 = false;
    L32:
        if (this.f6466c.z() == true) goto L34;
        return;
    L34:
        if (v1.c.a().d("block_monitor") == false) goto L38;
        p();
        return;
    }

    @Override // com.bytedance.services.slardar.config.IConfigListener
    public void onRefresh(JSONObject r10, boolean r11) {
        JSONObject r12 = r10.optJSONObject("general");
        if (r12 == null) goto L5;
        this.f6476m = r12.optBoolean(SlardarSettingsConsts.ENABLE_ACTIVE_UPLOAD_ALOG, true);
        return;
    L5:
        this.f6476m = true;
    }

    public final void p() {
        if (this.f6475l == false) goto L5;
        return;
    L5:
        this.f6475l = true;
        d2.a.a().post(new a(this));
        com.bytedance.apm.block.b r10 = new com.bytedance.apm.block.b();
        r10.h(this.f6466c.f());
        r10.k(this.f6466c.G());
        r10.i(this.f6466c.C());
        r10.g(this.f6466c.e());
        r10.f();
        if (ActivityLifeObserver.getInstance().isForeground() == false) goto L8;
        r10.l();
    L8:
        r10.j(this.f6464a.v());
    }

    public final void r(Application r10) {
    }

    public final void s() {
        MemoryCollector.getInstance().initGCInfo();
        if (this.f6473j == false) goto L5;
        v1.f r10 = new v1.f();
        r10.P(this.f6466c.u());
        r10.c();
    L5:
        y1.e.p(this.f6466c.w());
        y2.a.d().f(this.f6466c.u());
        MemoryCollector.getInstance().registerReachTopListener(this.f6466c.p());
        if (this.f6466c.F() == true) goto L8;
        return;
    L8:
        if (this.f6466c.z() == true) goto L12;
        p();
        return;
    }

    public final void t(h1.c r10) {
        List r11 = r10.g();
        if (ListUtils.b(r11) == true) goto L15;
        int r12 = 0;
        String r13 = new URL((String) r11.get(0)).getHost();     // Catch: MalformedURLException -> L19
        z1.a.b(r13);     // Catch: MalformedURLException -> L19
        z1.a.a(r13);     // Catch: MalformedURLException -> L19
        AlogUploadService.a(r13);     // Catch: MalformedURLException -> L19
    L6:
        ArrayList r14 = new ArrayList(2);
        int r15 = r11.size();
    L7:
        if (r12 >= r15) goto L14;
        String r16 = new URL((String) r11.get(r12)).getHost();     // Catch: Exception -> L20
        if (TextUtils.isEmpty(r16) == true) goto L13;
        if (r16.indexOf(46) <= 0) goto L13;
        r14.add("https://" + r16 + "/monitor/collect/batch/");     // Catch: Exception -> L20
    L13:
        r12 = r12 + 1;
        goto L7
    L14:
        com.bytedance.apm6.consumer.slardar.send.b.e().q(r14);
    L15:
        com.bytedance.apm6.consumer.slardar.send.b.e().r(i1.a.f20486c);
        com.bytedance.apm6.consumer.slardar.send.b.e().p(i1.a.f20487d);
        com.bytedance.apm6.consumer.slardar.send.b.e().p(r10.k());
        List r17 = r10.v();
        if (ListUtils.b(r17) == true) goto L29;
        com.bytedance.apm6.consumer.slardar.send.b.e().r(r17);
        return;
    }

    public void u(i6.d r10) {
        Set r11 = this.f6474k;
        if (r11 != null) goto L5;
        return;
    L5:
        Iterator r12 = r11.iterator();
    L7:
        if (r12.hasNext() == false) goto L11;
        ((IWidget) r12.next()).notifyParams(r10);     // Catch: Throwable -> L12
        goto L7
    }

    public final void w() {
        SlardarConfigManagerImpl r10 = new SlardarConfigManagerImpl();
        this.f6469f = r10;
        r10.registerConfigListener(this);
        n5.b.d(IConfigManager.class, this.f6469f);
        n5.b.c(IApmAgent.class, new b(this));
        n5.b.c(ILaunchTrace.class, new c(this));
        n5.b.c(IZstdCompress.class, new d(this));
        n5.b.c(IZstdDict.class, new e(this));
    }

    public final void x() {
        JSONObject r10 = new JSONObject();     // Catch: JSONException -> L4
        r10.put("init", w0.c.m());     // Catch: JSONException -> L4
        r10.put(CommonConsts.APM_INNER_EVENT_COST_INIT_INCLUDING_APM6, w0.c.n());     // Catch: JSONException -> L4
        r10.put(CommonConsts.APM_INNER_EVENT_COST_INIT_STEP2, w0.c.o());     // Catch: JSONException -> L4
        r10.put(CommonConsts.APM_INNER_EVENT_COST_INIT_STEP3, w0.c.p());     // Catch: JSONException -> L4
        r10.put(CommonConsts.APM_INNER_EVENT_COST_INIT_STEP4, w0.c.q());     // Catch: JSONException -> L4
        r10.put(CommonConsts.APM_INNER_EVENT_COST_INIT_STEP5, w0.c.r());     // Catch: JSONException -> L4
        r10.put("start", w0.c.y());     // Catch: JSONException -> L4
        JSONObject r11 = new JSONObject();     // Catch: JSONException -> L4
        r11.put("is_main_process", this.f6473j);     // Catch: JSONException -> L4
        ApmAgent.h("apm_cost", r11, r10, null);     // Catch: JSONException -> L4
        return;
    }

    public void y() {
        AsyncEventManager.e().l();
        AsyncEventManager.e().h(new g(this));
        Apm.g();
    }

    public void z(h1.c r10) {
        if (s1.a.c() == null) goto L6;
        s1.a.c().i("apm_debug", "start");     // Catch: Exception -> L17
    L6:
        if (this.f6471h == false) goto L16;
        if (r10 == null) goto L14;
        if (this.f6472i == false) goto L11;
        return;
    L11:
        AsyncEventManager.e().l();
        this.f6472i = true;
        this.f6466c = r10;
        AsyncEventManager.e().h(new k(this));
        return;
    L14:
        throw new IllegalArgumentException("startConfig must not be allowed");
    L16:
        throw new IllegalArgumentException("You must call Apm.getInstance().init() on Application.onCreate from version 5.x.x, pls call init() before start().");
    }

    public ApmDelegate() {
        this.f6475l = false;
        this.f6476m = true;
    }
}
