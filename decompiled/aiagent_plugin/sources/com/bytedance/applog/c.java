package com.bytedance.applog;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.applog.collector.Navigator;
import com.bytedance.applog.engine.Engine;
import com.bytedance.applog.monitor.v3.MonitorV3Helper;
import com.bytedance.applog.priority.PriorityCallbackImpl;
import com.bytedance.applog.priority.PriorityWrapper;
import com.bytedance.bdinstall.af;
import com.bytedance.bdinstall.ai;
import com.bytedance.bdinstall.am;
import com.bytedance.bdinstall.ar;
import com.bytedance.bdinstall.as;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.Proxy;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: compiled from: AppLogInstance.java */
/* JADX INFO: loaded from: classes.dex */
public final class c implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final List<c> f5544a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final AtomicInteger f5545b = null;
    private volatile boolean A;
    private volatile boolean B;
    private final AtomicInteger C;
    private volatile boolean D;
    private volatile boolean E;
    private volatile boolean F;
    private volatile boolean G;
    private volatile boolean H;
    private volatile int I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private volatile int f5546J;
    private volatile boolean K;
    private volatile boolean L;
    private volatile boolean M;
    private volatile boolean N;
    private volatile boolean O;
    private volatile int P;
    private volatile com.bytedance.applog.l.b Q;
    private final com.bytedance.applog.monitor.a R;
    private final MonitorV3Helper S;
    private volatile Long T;
    private volatile Integer U;
    private volatile m V;
    private volatile IBDAccountCallback W;
    private final com.bytedance.applog.h.b X;
    private volatile boolean Y;
    private volatile com.bytedance.applog.i.a Z;
    private volatile com.bytedance.applog.i.c aa;
    private volatile JSONObject ab;
    private volatile com.bytedance.applog.g.a ac;
    private PriorityWrapper ad;
    private volatile boolean ae;
    private volatile boolean af;
    private volatile boolean ag;
    private final com.bytedance.applog.log.f ah;
    private final List<String> ai;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.bytedance.applog.h.c f5547c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.bytedance.applog.h.a f5548d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.bytedance.applog.j.a f5549e;
    private final com.bytedance.applog.k.b f;
    private final com.bytedance.applog.k.a g;
    private final ai h;
    private final int i;
    private int j;
    private String k;
    private volatile Application l;
    private volatile com.bytedance.applog.j.b m;
    private volatile com.bytedance.applog.j.c n;
    private volatile Engine o;
    private final Navigator p;
    private volatile boolean q;
    private volatile k r;
    private volatile com.bytedance.applog.e.a s;
    private com.bytedance.applog.util.c t;
    private volatile Proxy u;
    private volatile boolean v;
    private final com.bytedance.applog.b.d w;
    private volatile g x;
    private volatile boolean y;
    private volatile boolean z;

    static /* synthetic */ boolean a(c r0) {
        return r0.v;
    }

    static /* synthetic */ Integer b(c r0) {
        return r0.U;
    }

    static /* synthetic */ Proxy c(c r0) {
        return r0.u;
    }

    static {
        f5544a = new CopyOnWriteArrayList();
        f5545b = new AtomicInteger(0);
    }

    public c() {
        this.f5547c = new com.bytedance.applog.h.c();
        this.f5548d = new com.bytedance.applog.h.a();
        this.j = 0;
        this.k = "";
        this.l = null;
        this.v = true;
        this.y = false;
        this.z = false;
        this.A = true;
        this.B = false;
        this.C = new AtomicInteger(0);
        this.D = false;
        this.E = false;
        this.F = false;
        this.G = true;
        this.H = false;
        this.I = 5;
        this.f5546J = 200;
        this.K = false;
        this.L = false;
        this.M = false;
        this.N = false;
        this.O = false;
        this.P = 8;
        this.Q = null;
        this.R = new com.bytedance.applog.monitor.a();
        this.Y = false;
        this.ab = null;
        this.ac = null;
        this.ad = null;
        this.ae = false;
        this.af = false;
        this.ag = false;
        this.ai = new CopyOnWriteArrayList();
        this.i = f5545b.getAndIncrement();
        this.ah = new com.bytedance.applog.log.m();
        this.g = new com.bytedance.applog.k.a(this);
        this.X = new com.bytedance.applog.h.b(this);
        this.f = new com.bytedance.applog.k.b(this);
        this.h = new com.bytedance.applog.util.e(this);
        f5544a.add(this);
        this.f5549e = new com.bytedance.applog.j.a(this);
        this.w = new com.bytedance.applog.b.b(this);
        this.p = new Navigator(this);
        this.S = new MonitorV3Helper();
    }

    public String toString() {
        return "AppLogInstance{id:" + this.i + ";appId:" + this.k + "}@" + hashCode();
    }

    public static List<c> a() {
        return f5544a;
    }

    @Override // com.bytedance.applog.h
    public String b() {
        return this.k;
    }

    @Override // com.bytedance.applog.h
    public Context getContext() {
        return this.l;
    }

    @Override // com.bytedance.applog.h
    public void a(Context r15, p r16) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r15, Context.class, "com.obric.aiagent.plugin");
        monitor-enter(c.class);
    L52:
        th = move-exception;
        throw th;
    L5:
        if (TextUtils.isEmpty(r16.f()) == true) goto L51;
        if (b.a(r16.f()) == true) goto L49;
        Z().a(r16.f());     // Catch: Throwable -> L52
        this.k = r16.f();     // Catch: Throwable -> L52
        this.l = (Application) ZeusTransformUtils.preCheckCast((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r9.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L52
        if (r16.O() == true) goto L11;
    L14:
        Z().c("App:{} init begin...", new Object[]{this.k});     // Catch: Throwable -> L52
        if (TextUtils.isEmpty(r16.F()) == false) goto L17;
        r16.d(b.a(this, "applog_stats"));     // Catch: Throwable -> L52
    L17:
        a(r16);     // Catch: Throwable -> L52
        this.m = new com.bytedance.applog.j.b(this, this.l, r16);     // Catch: Throwable -> L52
        as();     // Catch: Throwable -> L52
        this.n = new com.bytedance.applog.j.c(this, this.m, this.w);     // Catch: Throwable -> L52
        this.o = new Engine(this, this.m, this.n, this.w, r16.M(), this.f5549e);     // Catch: Throwable -> L52
        if (r16.C() == false) goto L20;
        this.l.registerActivityLifecycleCallbacks(this.p);     // Catch: Throwable -> L52
    L20:
        this.j = 1;     // Catch: Throwable -> L52
        this.q = r16.b();     // Catch: Throwable -> L52
        if (this.T == null) goto L24;
        a(this.T.longValue());     // Catch: Throwable -> L52
        this.T = null;     // Catch: Throwable -> L52
    L24:
        if (B() == false) goto L31;
        String[] r1 = this.o.getUriConfig().c();     // Catch: Throwable -> L52
        String r4 = this.k;     // Catch: Throwable -> L52
        if (r1.length <= 0) goto L28;
        String r2 = r1[0];     // Catch: Throwable -> L52
    L29:
        this.ad = new PriorityWrapper(r9, r4, r2, r16.O(), new PriorityCallbackImpl(this));     // Catch: Throwable -> L52
        goto L31
    L28:
        r2 = "";
    L31:
        if (r16.D() == false) goto L34;
        N().setFeature("congestion_enable", 1);     // Catch: Throwable -> L52
    L34:
        if (r16.A() == false) goto L37;
        N().setFeature("silence_in_background", 1);     // Catch: Throwable -> L52
    L37:
        if (r16.J() == false) goto L40;
        N().setFeature("event_filter_enable", 1);     // Catch: Throwable -> L52
    L40:
        if (r16.Q() == false) goto L43;
        N().setFeature("stop_on_enter_background", 1);     // Catch: Throwable -> L52
    L43:
        if (r16.C() == false) goto L45;
        N().setFeature("handle_lifecycle_enable", 1);     // Catch: Throwable -> L52
    L45:
        com.bytedance.applog.log.l.a("init_end", this.k);     // Catch: Throwable -> L52
        Z().c("App:{} init end.", new Object[]{this.k});     // Catch: Throwable -> L52
        this.m.E();     // Catch: Throwable -> L52
        monitor-exit(c.class);     // Catch: Throwable -> L52
        return;
    L11:
        if (r16.a() == null) goto L13;
        com.bytedance.applog.log.k.a(this.k, new com.bytedance.applog.log.d(r16.a()));     // Catch: Throwable -> L52
        goto L14
    L13:
        com.bytedance.applog.log.k.a(this.k, new com.bytedance.applog.log.c(this));     // Catch: Throwable -> L52
        goto L14
    L49:
        throw new IllegalStateException("The app id is init already!");     // Catch: Throwable -> L52
    L51:
        throw new IllegalStateException("App id must not be empty!");     // Catch: Throwable -> L52
    }

    @Override // com.bytedance.applog.h
    public void c() {
        if (this.q == true) goto L6;
        this.q = true;
        this.o.start();
        Z().c("System start!", new Object[0]);
        return;
    }

    @Override // com.bytedance.applog.h
    public void d() {
        Z().c("System stop!", new Object[0]);
        if (this.q == false) goto L6;
        this.q = false;
        return;
    }

    public boolean e() {
        return this.q;
    }

    public p f() {
        if (this.m != null) goto L7;
        return null;
    L7:
        return this.m.c();
    }

    public void g() {
        if (this.G == false) goto L7;
        h();
        return;
    L7:
        if (this.o == null) goto L9;
        this.o.process(null, true);
    L9:
        N().increaseStats(com.bytedance.applog.monitor.v3.j.F);
    }

    public void h() {
        if (this.o == null) goto L5;
        this.o.sendImmediately();
    L5:
        N().increaseStats(com.bytedance.applog.monitor.v3.j.F);
    }

    public void a(long r3) {
        if (this.o != null) goto L5;
    L9:
        this.T = Long.valueOf(r3);
        return;
    L5:
        if (this.o.getSession() == null) goto L9;
        if (this.o.getSession().d() == r3) goto L11;
        this.o.getSession().a(r3);
        return;
    }

    @Override // com.bytedance.applog.h
    public String a(Context r3, String r4, boolean r5, ar r6) {
        return a((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), new StringBuilder(r4), r5, r6);
    }

    public String a(Context r3, StringBuilder r4, boolean r5, ar r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        return this.w.a(r7, r4, r5, r6);
    }

    @Override // com.bytedance.applog.h
    public void a(af r3) {
        af r4 = (af) ZeusTransformUtils.wrapperContextForParams(r3, af.class, "com.obric.aiagent.plugin");
        this.w.a(r4);
    }

    @Override // com.bytedance.applog.h
    public void a(String r2, Object r3) {
        if (TextUtils.isEmpty(r2) == true) goto L6;
        HashMap<String, Object> r0 = new HashMap();
        r0.put(r2, r3);
        this.w.a(r0);
        return;
    }

    public String i() {
        if (this.o != null) goto L6;
        return null;
    L6:
        long r0 = this.o.getSession().d();
        IBDAccountCallback r2 = w();
        if (r2 == null) goto L10;
        r0 = ((Long) ZeusTransformUtils.preCheckCast(r2.getOdinUserInfo().second, Long.class, "com.obric.aiagent.plugin")).longValue();
    L10:
        return a(String.valueOf(r0));
    }

    public String a(String r2) {
        g r0 = this.x;
        if (r0 == null) goto L7;
        return r0.a(r2);
    L7:
        if (this.n != null) goto L9;
        return null;
    L9:
        return this.n.f();
    }

    public String j() {
        return b();
    }

    @Override // com.bytedance.applog.h
    public void b(String r4) {
        this.w.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r4);
    }

    @Override // com.bytedance.applog.h
    public void a(String r1, JSONObject r2) {
        b(r1, r2);
    }

    public void a(String r1, String r2) {
        b(r1, r2);
    }

    @Override // com.bytedance.applog.h
    public void a(String r6, Bundle r7) {
        JSONObject r0 = null;
        if (r7 != null) goto L21;
    L17:
        b(r6, r0);
        return;
    L21:
    L15:
        th = th;
    L16:
        Z().a("parse bundle params failed", th, new Object[0]);
        N().increaseStats(com.bytedance.applog.monitor.v3.j.P);
        goto L17
    L5:
        if (r7.isEmpty() == true) goto L17;
        JSONObject r1 = new JSONObject();     // Catch: Throwable -> L15
        Iterator<String> r2 = r7.keySet().iterator();     // Catch: Throwable -> L13
    L9:
        if (r2.hasNext() == false) goto L12;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L13
        r1.put(r3, r7.get(r3));     // Catch: Throwable -> L13
        goto L9
    L12:
        r0 = r1;
    L13:
        th = th;
        r0 = r1;
        goto L16
    }

    @Override // com.bytedance.applog.h
    public void a(boolean r3) {
        this.v = r3;
        MonitorV3Helper r2 = N();
        if (r3 == false) goto L5;
        long r0 = 1;
    L6:
        r2.setFeature("encrypt_enable", r0);
        return;
    L5:
        r0 = 0;
        goto L6
    }

    public boolean k() {
        return this.v;
    }

    @Override // com.bytedance.applog.h
    public String l() {
        return this.w.c();
    }

    @Override // com.bytedance.applog.h
    public String m() {
        return this.w.d();
    }

    @Override // com.bytedance.applog.h
    public String n() {
        return this.w.e();
    }

    @Override // com.bytedance.applog.h
    public String o() {
        if (this.n != null) goto L5;
        return "";
    L5:
        return this.n.d();
    }

    @Override // com.bytedance.applog.h
    public String p() {
        if (this.o != null) goto L7;
        return null;
    L7:
        return String.valueOf(this.o.getSession().d());
    }

    @Override // com.bytedance.applog.h
    public boolean a(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        return this.w.a(r4);
    }

    @Override // com.bytedance.applog.h
    public void a(Map<String, String> r3) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        am r2 = this.w.b();
        if (r2 == null) goto L17;
        String r0 = r2.f();
        if (TextUtils.isEmpty(r0) == true) goto L7;
        r4.put("device_id", r0);
    L7:
        String r1 = r2.c();
        if (TextUtils.isEmpty(r1) == true) goto L10;
        r4.put("install_id", r1);
    L10:
        String r5 = r2.d();
        if (TextUtils.isEmpty(r5) == true) goto L13;
        r4.put("openudid", r5);
    L13:
        String r6 = r2.e();
        if (TextUtils.isEmpty(r6) == true) goto L18;
        r4.put("clientudid", r6);
        return;
    L18:
        return;
    }

    @Override // com.bytedance.applog.h
    public synchronized void a(i r3) {
        monitor-enter(this);
        i r4 = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L9
        if (this.t != null) goto L6;
        this.t = new com.bytedance.applog.util.c();     // Catch: Throwable -> L9
    L6:
        this.t.a(r4);     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public ai q() {
        ai r0 = this.m.c().q();
        if (r0 == null) goto L6;
        return r0;
    L6:
        return this.h;
    }

    @Override // com.bytedance.applog.h
    public JSONObject r() {
        if (this.n != null) goto L7;
        Z().e("Init first please to get header", new Object[0]);
        return null;
    L7:
        return this.n.a();
    }

    public k s() {
        return this.r;
    }

    public com.bytedance.applog.e.a t() {
        return this.s;
    }

    @Override // com.bytedance.applog.h
    public String u() {
        if (this.o != null) goto L7;
        return null;
    L7:
        return this.o.getSessionId();
    }

    public boolean v() {
        return this.y;
    }

    @Override // com.bytedance.applog.h
    public IBDAccountCallback w() {
        return this.W;
    }

    public boolean x() {
        return this.z;
    }

    public boolean y() {
        return this.A;
    }

    public boolean z() {
        return this.B;
    }

    @Override // com.bytedance.applog.h
    public void b(boolean r3) {
        if (r3 == false) goto L4;
        AtomicInteger r0 = this.C;
        r0.set(r0.get() | 1);
    L5:
        b(com.bytedance.applog.log.j.u, Boolean.valueOf(r3));
        N().setFeature("normal_sample_enable", r3);
        return;
    L4:
        AtomicInteger r1 = this.C;
        r1.set(r1.get() & (-2));
        goto L5
    }

    public boolean A() {
        return this.D;
    }

    public boolean B() {
        return this.E;
    }

    public int C() {
        return this.j;
    }

    public void a(int r1) {
        this.j = r1;
    }

    public com.bytedance.applog.e.f D() {
        if (this.o != null) goto L7;
        return null;
    L7:
        return this.o.getEventSampling();
    }

    @Override // com.bytedance.applog.h
    public void c(boolean r2) {
        this.F = r2;
        N().setFeature("bg_session_enable", r2);
    }

    public boolean E() {
        if (f() == null) goto L9;
        if (f().Q() == false) goto L9;
        return false;
    L9:
        return this.F;
    }

    public boolean F() {
        return this.Y;
    }

    public com.bytedance.applog.i.a G() {
        return this.Z;
    }

    public com.bytedance.applog.i.c H() {
        return this.aa;
    }

    public JSONObject I() {
        return this.ab;
    }

    public JSONObject J() {
        if (this.m != null) goto L7;
        Z().e("call getLogback after init plz.", new Object[0]);
        return null;
    L7:
        return this.m.B();
    }

    @Override // com.bytedance.applog.h
    public void d(boolean r2) {
        if (this.o == null) goto L5;
        this.o.clearWhenSwitchChildMode(r2);
    L5:
        N().setFeature("child_mode", r2);
    }

    @Override // com.bytedance.applog.h
    public void a(Context r3, boolean r4, long r5, as r7) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        as r8 = (as) ZeusTransformUtils.wrapperContextForParams(r7, as.class, "com.obric.aiagent.plugin");
        if (this.o == null) goto L5;
        this.o.resetDidWhenSwitchChildMode(r4, r5, r8);
    L5:
        N().setFeature("child_mode", r4);
    }

    @Override // com.bytedance.applog.h
    public void a(long r3, as r5) {
        as r6 = (as) ZeusTransformUtils.wrapperContextForParams(r5, as.class, "com.obric.aiagent.plugin");
        if (this.o == null) goto L6;
        this.o.resetAndReInstall(r3, r6);
        return;
    }

    public Integer K() {
        return this.U;
    }

    public void a(m r3) {
        this.V = (m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.aiagent.plugin");
    }

    public m L() {
        return this.V;
    }

    public void a(com.bytedance.applog.store.a r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        r5.a(b());
        if (ZeusTransformUtils.instanceOf(r5, com.bytedance.applog.store.d.class) == false) goto L7;
    L10:
        N().increaseStats(com.bytedance.applog.monitor.v3.j.f5824a);
        r5.s = com.bytedance.applog.monitor.c.c(N(), r5);
        if (r5.s <= 0) goto L13;
        com.bytedance.applog.monitor.c.a(N(), com.bytedance.applog.monitor.v3.a.f5771e, r5);
    L13:
        c(r5);
        if (this.o != null) goto L18;
        this.f5549e.a(r5);
        if (r5.s <= 0) goto L20;
        com.bytedance.applog.monitor.c.a(N(), com.bytedance.applog.monitor.v3.a.f, r5);
    L20:
        if (r5.i() <= 1048576) goto L22;
        N().sendError("receive data too big (>1MB)", new Throwable(r5.toString()));
    L22:
        com.bytedance.applog.log.l.a("event_receive", r5);
        return;
    L18:
        this.o.receive(r5);
        goto L20
    L7:
        if (ZeusTransformUtils.instanceOf(r5, com.bytedance.applog.store.b.class) == true) goto L10;
        if (ZeusTransformUtils.instanceOf(r5, com.bytedance.applog.store.c.class) == false) goto L13;
        goto L10
    }

    public void a(String[] r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.length == 0) goto L17;
        StringBuilder r0 = new StringBuilder();
        int r1 = r5.length;
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L10;
        r0.append(r5[r2]);
        r0.append(",");
        r2 = r2 + 1;
        goto L7
    L10:
        if (this.o != null) goto L12;
        this.f5549e.a(r5);
        return;
    L12:
        this.o.receive(r5);
        return;
    }

    public boolean M() {
        return this.H;
    }

    @Override // com.bytedance.applog.h
    public void e(boolean r1) {
        this.O = r1;
    }

    @Override // com.bytedance.applog.h
    public void f(boolean r2) {
        N().getConfigManager().a(r2);
        N().setFeature("monitor_debug_mode", r2);
    }

    @Override // com.bytedance.applog.h
    public void g(boolean r2) {
        this.N = r2;
        N().setFeature("bdinstall_event_enable", r2);
    }

    public MonitorV3Helper N() {
        return this.S;
    }

    @Override // com.bytedance.applog.h
    public void a(com.bytedance.applog.collector.a r3) {
        com.bytedance.applog.collector.a r4 = (com.bytedance.applog.collector.a) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.applog.collector.a.class, "com.obric.aiagent.plugin");
        this.p.setCallback(r4);
    }

    private void c(com.bytedance.applog.store.a r11) {
        if (this.f5548d.a(1) == false) goto L20;
        return;
    L20:
    L16:
        th = move-exception;
        Z().a(4, "notify event observer before receive failed", th, new Object[0]);
        N().sendError("notify event observer before receive failed", th);
        return;
    L7:
        if (ZeusTransformUtils.instanceOf(r11, com.bytedance.applog.store.b.class) == false) goto L10;
        com.bytedance.applog.store.b r12 = (com.bytedance.applog.store.b) ZeusTransformUtils.preCheckCast(r11, com.bytedance.applog.store.b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L16
        this.f5548d.a(1, r12.u, r12.v, r12.w, r12.y, r12.z, r12.x);     // Catch: Throwable -> L16
    L19:
        return;
    L10:
        if (ZeusTransformUtils.instanceOf(r11, com.bytedance.applog.store.d.class) == false) goto L13;
        com.bytedance.applog.store.d r13 = (com.bytedance.applog.store.d) ZeusTransformUtils.preCheckCast(r11, com.bytedance.applog.store.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L16
        this.f5548d.a(1, r13.s(), r13.n());     // Catch: Throwable -> L16
        goto L19
    L13:
        if (ZeusTransformUtils.instanceOf(r11, com.bytedance.applog.store.c.class) == false) goto L19;
        com.bytedance.applog.store.c r14 = (com.bytedance.applog.store.c) ZeusTransformUtils.preCheckCast(r11, com.bytedance.applog.store.c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L16
        this.f5548d.b(1, r14.r(), r14.n());     // Catch: Throwable -> L16
        goto L19
    }

    private void as() {
        if (L() != null) goto L6;
        a(new com.bytedance.applog.util.f(this, this.m));
        return;
    }

    private String a(com.bytedance.applog.monitor.v3.i r13, String r14, String r15, JSONObject r16) {
        if (r16 != null) goto L48;
        return null;
    L48:
        return r16.toString();
    L7:
        th = move-exception;
        Z().a("event toString failed " + r14 + ", label: " + r15, th, new Object[0]);
        JSONObject r0 = com.bytedance.applog.util.p.a(r16);
        if (r0 == null) goto L45;
        p r2 = f();
        if (r2 != null) goto L13;
    L15:
        boolean r3 = false;
    L50:
    L54:
        return r0.toString();
    L27:
        e = move-exception;
        N().increaseStats(com.bytedance.applog.monitor.v3.j.H);
        if (r3 == true) goto L31;
        Z().a("event toString OOM tag: " + r14 + ", label: " + r15, e, new Object[0]);
        return null;
    L31:
        if (N().isEventMaybeAccepted(r14) == false) goto L34;
        N().stageEvent(com.bytedance.applog.monitor.v3.a.f5769c, r14, com.bytedance.applog.monitor.v3.f.c(), System.currentTimeMillis(), com.bytedance.applog.monitor.v3.i.f5806a);
    L34:
        throw new RuntimeException("event toString OOM tag: " + r14 + ", label: " + r15, e);
    L18:
        e = move-exception;
        N().increaseStats(com.bytedance.applog.monitor.v3.j.O);
        if (r3 == true) goto L22;
        Z().a("event toString stack overflow tag: " + r14 + ", label: " + r15, e, new Object[0]);
        return null;
    L22:
        if (N().isEventMaybeAccepted(r14) == false) goto L25;
        N().stageEvent(com.bytedance.applog.monitor.v3.a.f5769c, r14, com.bytedance.applog.monitor.v3.f.c(), System.currentTimeMillis(), r13);
    L25:
        throw new RuntimeException("event toString stack overflow tag: " + r14 + ", label: " + r15, e);
    L36:
        N().increaseStats(com.bytedance.applog.monitor.v3.j.N);
        return r0.toString();
    L39:
        th = move-exception;
        if (N().isEventMaybeAccepted(r14) == false) goto L44;
        N().stageEvent(com.bytedance.applog.monitor.v3.a.f5769c, r14, com.bytedance.applog.monitor.v3.f.c(), System.currentTimeMillis(), r13);
    L44:
        throw new RuntimeException("event params exception tag: " + r14 + ", label: " + r15, th);
    L13:
        if ("local_test".equalsIgnoreCase(r2.g()) == false) goto L15;
        r3 = true;
        goto L50
    L45:
        return null;
    }

    private void b(String r6, JSONObject r7) {
        if (TextUtils.isEmpty(r6) == false) goto L6;
        Z().e("event name is empty", new Object[0]);
        return;
    L6:
        a(new com.bytedance.applog.store.d(this.k, r6, false, a(com.bytedance.applog.monitor.v3.i.f5806a, r6, null, r7)));
    }

    private void b(String r4, String r5) {
        if (TextUtils.isEmpty(r4) == false) goto L6;
        Z().e("event name is empty", new Object[0]);
        return;
    L6:
        a(new com.bytedance.applog.store.d(this.k, r4, false, r5));
    }

    public int O() {
        return this.I;
    }

    public int P() {
        return this.f5546J;
    }

    public com.bytedance.applog.util.c Q() {
        return this.t;
    }

    public com.bytedance.applog.h.c R() {
        return this.f5547c;
    }

    public com.bytedance.applog.h.a S() {
        return this.f5548d;
    }

    public com.bytedance.applog.h.b T() {
        return this.X;
    }

    public com.bytedance.applog.k.b U() {
        return this.f;
    }

    public com.bytedance.applog.k.a V() {
        return this.g;
    }

    public com.bytedance.applog.store.h W() {
        return this.p.getCurPage();
    }

    public Proxy X() {
        return this.u;
    }

    public com.bytedance.applog.l.b Y() {
        if (this.Q != null) goto L7;
        return com.bytedance.applog.l.a.a();
    L7:
        return this.Q;
    }

    public com.bytedance.applog.log.f Z() {
        return this.ah;
    }

    public long aa() {
        if (this.o != null) goto L7;
        return 0;
    L7:
        return this.o.getSession().g();
    }

    public void b(com.bytedance.applog.store.a r2) {
        if (this.o != null) goto L5;
        return;
    L5:
        this.o.getSession().b(r2);
    }

    public boolean ab() {
        return this.K;
    }

    public boolean ac() {
        return this.L;
    }

    public int ad() {
        return this.P;
    }

    public com.bytedance.applog.monitor.a ae() {
        return this.R;
    }

    public com.bytedance.applog.g.a af() {
        return this.ac;
    }

    public boolean ag() {
        return this.ae;
    }

    public com.bytedance.applog.f.a ah() {
        if (this.m != null) goto L7;
        return null;
    L7:
        return this.m.D();
    }

    public com.bytedance.applog.priority.a ai() {
        if (this.m != null) goto L7;
        return null;
    L7:
        return this.m.x();
    }

    public int aj() {
        return this.C.get();
    }

    public boolean ak() {
        return this.M;
    }

    public boolean al() {
        return this.N;
    }

    public boolean am() {
        p r0 = f();
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.O();
    }

    public boolean an() {
        return this.O;
    }

    public List<String> ao() {
        return this.ai;
    }

    public boolean ap() {
        return this.af;
    }

    public boolean aq() {
        return this.ag;
    }

    public PriorityWrapper ar() {
        if (B() == true) goto L7;
        return null;
    L7:
        return this.ad;
    }

    private void a(final p r2) {
        if (com.bytedance.applog.log.l.a() == false) goto L5;
        return;
    L5:
        com.bytedance.applog.log.l.a("init_begin", new AnonymousClass1(this, r2));
    }

    private void b(final String r2, final Object r3) {
        if (com.bytedance.applog.log.l.a() == false) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(j()) == true) goto L9;
        com.bytedance.applog.log.l.a("update_config", new AnonymousClass2(this, r2, r3));
        return;
    }
}
