package com.bytedance.bdinstall;

import android.content.Context;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: compiled from: BdInstallInstance.java */
/* JADX INFO: loaded from: classes.dex */
public class l implements aa {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Map<String, l> f6366b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final AtomicInteger f6367c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.bdinstall.a.b f6368a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile an f6369d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile g f6370e;
    private volatile com.bytedance.bdinstall.c.c f;
    private volatile com.bytedance.bdinstall.c.a g;
    private final aq h;
    private final AtomicBoolean i;
    private final AtomicBoolean j;
    private final j k;
    private final com.bytedance.bdinstall.j.i<com.bytedance.bdinstall.g.b> l;
    private f m;
    private com.bytedance.bdinstall.j.b n;
    private final com.bytedance.bdinstall.j.r<am> o;

    @Override // com.bytedance.bdinstall.aa
    public void b(Context r1, u r2, long r3, as r5) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.aiagent.plugin");
        as r4 = (as) ZeusTransformUtils.wrapperContextForParams(r5, as.class, "com.obric.aiagent.plugin");
    }

    @Override // com.bytedance.bdinstall.aa
    public void c(u r1) {
    }

    static {
        f6366b = new ConcurrentHashMap();
        f6367c = new AtomicInteger(0);
    }

    public static l a(String r2) {
        return (l) ZeusTransformUtils.preCheckCast(f6366b.get(r2), l.class, "com.obric.aiagent.plugin");
    }

    public aq a() {
        return this.h;
    }

    public f b() {
        return this.m;
    }

    public com.bytedance.bdinstall.j.b c() {
        return this.n;
    }

    public l() {
        this.f6369d = null;
        this.g = new com.bytedance.bdinstall.c.a.C0145a();
        this.h = new aq();
        this.i = new AtomicBoolean(false);
        this.j = new AtomicBoolean(false);
        this.k = new j();
        this.l = new AnonymousClass1(this);
        this.o = new AnonymousClass2(this);
        f6367c.incrementAndGet();
        this.m = new f(this);
        this.n = new com.bytedance.bdinstall.j.b();
        this.f6368a = new com.bytedance.bdinstall.a.b();
    }

    private boolean o() {
        if (i.a(this) == false) goto L6;
        return true;
    L6:
        if (this.f6369d != null) goto L10;
        return false;
    L10:
        return true;
    }

    @Override // com.bytedance.bdinstall.aa
    public void a(an r8, u r9) {
        monitor-enter(this);
        if (r8 == null) goto L26;
        if (f6366b.containsKey(String.valueOf(r8.a())) == true) goto L21;
        t.a("instance init " + r8.a());     // Catch: Throwable -> L23
        f6366b.put(String.valueOf(r8.a()), this);     // Catch: Throwable -> L23
        r8.a(i.a(this));     // Catch: Throwable -> L23
        this.f6369d = r8;     // Catch: Throwable -> L23
        this.f6368a.a(this.f6369d.b());     // Catch: Throwable -> L23
        com.bytedance.bdinstall.c.c r0 = r8.R();     // Catch: Throwable -> L23
        if (r0 == null) goto L10;
        this.f = r0;     // Catch: Throwable -> L23
    L10:
        if (r8.Q() == null) goto L12;
        this.g = r8.Q();     // Catch: Throwable -> L23
    L12:
        al r1 = r8.L();     // Catch: Throwable -> L23
        if (r1 == null) goto L16;
        ay.a(String.valueOf(r8.a()), r1);     // Catch: Throwable -> L23
    L16:
        if (r8.Y() == false) goto L18;
        this.m.a(com.bytedance.bdinstall.j.m.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")));     // Catch: Throwable -> L23
        com.bytedance.bdinstall.j.m.a();     // Catch: Throwable -> L23
    L18:
        ((com.bytedance.bdinstall.g.b) ZeusTransformUtils.preCheckCast(this.l.c(new Object[]{(Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")}), com.bytedance.bdinstall.g.b.class, "com.obric.aiagent.plugin")).a(r8, r9);     // Catch: Throwable -> L23
        this.i.set(true);     // Catch: Throwable -> L23
        if (this.j.get() == false) goto L21;
        h();     // Catch: Throwable -> L23
    L21:
        monitor-exit(this);     // Catch: Throwable -> L23
        return;
    L26:
        throw new IllegalStateException("options must not be null!");     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.bdinstall.aa
    public void d() {
        if (this.f6369d != null) goto L5;
        return;
    L5:
        ((com.bytedance.bdinstall.g.b) ZeusTransformUtils.preCheckCast(this.l.c(new Object[]{(Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f6369d.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")}), com.bytedance.bdinstall.g.b.class, "com.obric.aiagent.plugin")).a();
        com.bytedance.bdinstall.oaid.j.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f6369d.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).a(this.f6369d);
        com.bytedance.bdinstall.oaid.j.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f6369d.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).a(this.f6368a);
        com.bytedance.bdinstall.oaid.j.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f6369d.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).b();
    }

    @Override // com.bytedance.bdinstall.aa
    public u e() {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L7;
        return null;
    L7:
        return ((com.bytedance.bdinstall.g.b) ZeusTransformUtils.preCheckCast(this.l.c(new Object[]{r0}), com.bytedance.bdinstall.g.b.class, "com.obric.aiagent.plugin")).e();
    }

    @Override // com.bytedance.bdinstall.aa
    public void a(u r5) {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
        return;
    L5:
        ((com.bytedance.bdinstall.g.b) ZeusTransformUtils.preCheckCast(this.l.c(new Object[]{r0}), com.bytedance.bdinstall.g.b.class, "com.obric.aiagent.plugin")).b(r5);
    }

    @Override // com.bytedance.bdinstall.aa
    public void a(v r1, String r2) {
        w.a(r2, r1);
    }

    @Override // com.bytedance.bdinstall.aa
    public String a(Context r7, StringBuilder r8, boolean r9, ar r10) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        if (o() == true) goto L5;
        return null;
    L5:
        return this.m.a(r1, r8, null, r9, r10);
    }

    @Override // com.bytedance.bdinstall.aa
    public void a(Context r9, Map<String, String> r10, boolean r11, ar r12) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        Map<String, String> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r10, Map.class, "com.obric.aiagent.plugin");
        if (o() == false) goto L6;
        this.m.a(r3, r11, null, r6, r12);
        return;
    }

    @Override // com.bytedance.bdinstall.aa
    public void a(af r3) {
        af r4 = (af) ZeusTransformUtils.wrapperContextForParams(r3, af.class, "com.obric.aiagent.plugin");
        if (o() == false) goto L6;
        this.m.a(r4);
        return;
    }

    @Override // com.bytedance.bdinstall.aa
    public void a(boolean r3, ag r4) {
        ag r5 = (ag) ZeusTransformUtils.wrapperContextForParams(r4, ag.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L5;
        return;
    L5:
        this.f6368a.a(r3, new com.bytedance.bdinstall.a.f(r5));
    }

    @Override // com.bytedance.bdinstall.aa
    public void a(ag r3) {
        ag r4 = (ag) ZeusTransformUtils.wrapperContextForParams(r3, ag.class, "com.obric.aiagent.plugin");
        this.f6368a.a(r4);
    }

    @Override // com.bytedance.bdinstall.aa
    public void a(boolean r3, y r4) {
        y r5 = (y) ZeusTransformUtils.wrapperContextForParams(r4, y.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L5;
        return;
    L5:
        this.f6368a.a(r3, new com.bytedance.bdinstall.a.e(r5));
    }

    @Override // com.bytedance.bdinstall.aa
    public void a(ac r3) {
        ac r4 = (ac) ZeusTransformUtils.wrapperContextForParams(r3, ac.class, "com.obric.aiagent.plugin");
        this.n.a(r4);
    }

    @Override // com.bytedance.bdinstall.aa
    public void a(Context r5, String r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        HashMap r0 = new HashMap();
        r0.put("user_unique_id", r6);
        ((com.bytedance.bdinstall.g.b) ZeusTransformUtils.preCheckCast(this.l.c(new Object[]{r7}), com.bytedance.bdinstall.g.b.class, "com.obric.aiagent.plugin")).a(r7, r0, true, true);
    }

    @Override // com.bytedance.bdinstall.aa
    public void a(Context r4, JSONObject r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        HashMap r0 = new HashMap();
        r0.put(MonitorConstants.CUSTOM, r5);
        ((com.bytedance.bdinstall.g.b) ZeusTransformUtils.preCheckCast(this.l.c(new Object[]{r6}), com.bytedance.bdinstall.g.b.class, "com.obric.aiagent.plugin")).a(r6, r0);
    }

    @Override // com.bytedance.bdinstall.aa
    public void a(Context r4, String r5, String r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        HashMap r0 = new HashMap();
        r0.put("app_language", r5);
        r0.put("app_region", r6);
        ((com.bytedance.bdinstall.g.b) ZeusTransformUtils.preCheckCast(this.l.c(new Object[]{r7}), com.bytedance.bdinstall.g.b.class, "com.obric.aiagent.plugin")).a(r7, r0, true, true);
    }

    @Override // com.bytedance.bdinstall.aa
    public void b(Context r5, String r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L6;
        t.c("context is null when setUserAgent");
        return;
    L6:
        HashMap r0 = new HashMap();
        r0.put("user_agent", r6);
        ((com.bytedance.bdinstall.g.b) ZeusTransformUtils.preCheckCast(this.l.c(new Object[]{r7}), com.bytedance.bdinstall.g.b.class, "com.obric.aiagent.plugin")).a(r7, r0, true, false);
    }

    @Override // com.bytedance.bdinstall.aa
    public boolean a(JSONObject r5) {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L10;
        return false;
    L10:
        return ((com.bytedance.bdinstall.g.b) ZeusTransformUtils.preCheckCast(this.l.c(new Object[]{r0}), com.bytedance.bdinstall.g.b.class, "com.obric.aiagent.plugin")).a(r5);
    L7:
        th = move-exception;
        th.printStackTrace();
        return false;
    }

    @Override // com.bytedance.bdinstall.aa
    public am f() {
        if (this.f6369d != null) goto L5;
    L9:
        t.c("BDInstall#getInstallInfo error, not init yet!");
        return a(m());
    L5:
        if (((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f6369d.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) == null) goto L9;
        return ((com.bytedance.bdinstall.g.b) ZeusTransformUtils.preCheckCast(this.l.c(new Object[]{(Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f6369d.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")}), com.bytedance.bdinstall.g.b.class, "com.obric.aiagent.plugin")).b();
    }

    @Override // com.bytedance.bdinstall.aa
    public String g() {
        if (this.f6369d != null) goto L5;
    L9:
        t.c("BDInstall#getDid error, not init yet!");
        am r5 = a(m());
        if (r5 != null) goto L13;
        return null;
    L13:
        return r5.f();
    L5:
        if (((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f6369d.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) == null) goto L9;
        return ((com.bytedance.bdinstall.g.b) ZeusTransformUtils.preCheckCast(this.l.c(new Object[]{(Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f6369d.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")}), com.bytedance.bdinstall.g.b.class, "com.obric.aiagent.plugin")).c();
    }

    @Override // com.bytedance.bdinstall.aa
    public void a(am r5) {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
        return;
    L5:
        ((com.bytedance.bdinstall.g.b) ZeusTransformUtils.preCheckCast(this.l.c(new Object[]{r0}), com.bytedance.bdinstall.g.b.class, "com.obric.aiagent.plugin")).a(r5);
    }

    public am a(g r4) {
        g r5 = (g) ZeusTransformUtils.wrapperContextForParams(r4, g.class, "com.obric.aiagent.plugin");
        Context r6 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L7;
        return null;
    L7:
        return (am) ZeusTransformUtils.preCheckCast(this.o.c(new Object[]{r6}), am.class, "com.obric.aiagent.plugin");
    }

    public boolean h() {
        if (this.i.get() == true) goto L6;
        this.j.set(true);
        return false;
    L6:
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L10;
        return false;
    L10:
        return ((com.bytedance.bdinstall.g.b) ZeusTransformUtils.preCheckCast(this.l.c(new Object[]{r0}), com.bytedance.bdinstall.g.b.class, "com.obric.aiagent.plugin")).d();
    }

    @Override // com.bytedance.bdinstall.aa
    public boolean i() {
        Integer r3 = p();
        if (r3 != null) goto L5;
        return false;
    L5:
        com.bytedance.bdinstall.g.c r4 = (com.bytedance.bdinstall.g.c) ZeusTransformUtils.preCheckCast(com.bytedance.bdinstall.g.d.a(com.bytedance.bdinstall.g.c.class, String.valueOf(r3)), com.bytedance.bdinstall.g.c.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L8;
        return false;
    L8:
        return r4.a();
    }

    @Override // com.bytedance.bdinstall.aa
    public com.bytedance.bdinstall.c.c j() {
        return this.f;
    }

    @Override // com.bytedance.bdinstall.aa
    public com.bytedance.bdinstall.c.a k() {
        return this.g;
    }

    @Override // com.bytedance.bdinstall.aa
    public an l() {
        return this.f6369d;
    }

    @Override // com.bytedance.bdinstall.aa
    public g m() {
        return this.f6370e;
    }

    @Override // com.bytedance.bdinstall.aa
    public void b(u r5) {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
        return;
    L5:
        ((com.bytedance.bdinstall.g.b) ZeusTransformUtils.preCheckCast(this.l.c(new Object[]{r0}), com.bytedance.bdinstall.g.b.class, "com.obric.aiagent.plugin")).a(r5);
    }

    @Override // com.bytedance.bdinstall.aa
    public void a(Context r9, u r10, long r11, as r13) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        as r7 = (as) ZeusTransformUtils.wrapperContextForParams(r13, as.class, "com.obric.aiagent.plugin");
        Context r12 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (r12 != null) goto L5;
        return;
    L5:
        ((com.bytedance.bdinstall.g.b) ZeusTransformUtils.preCheckCast(this.l.c(new Object[]{r12}), com.bytedance.bdinstall.g.b.class, "com.obric.aiagent.plugin")).a(r3, r10, r11, r7);
    }

    private Context getContext() {
        if (this.f6369d == null) goto L9;
        if (((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f6369d.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) == null) goto L9;
        return (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f6369d.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
    L9:
        if (this.f6370e == null) goto L15;
        if (((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f6370e.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) == null) goto L15;
        return (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f6370e.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
    L15:
        return (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(BDInstallProvider.getFallbackContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
    }

    private Integer p() {
        if (this.f6369d == null) goto L7;
        return Integer.valueOf(this.f6369d.a());
    L7:
        if (this.f6370e != null) goto L9;
        return null;
    L9:
        return Integer.valueOf(this.f6370e.h());
    }

    @Override // com.bytedance.bdinstall.aa
    public j n() {
        return this.k;
    }
}
