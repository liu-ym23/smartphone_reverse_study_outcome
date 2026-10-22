package com.obric.autogui.agents.scripted.impl;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.SystemClock;
import com.bytedance.apm.battery.dao.DBHelper;
import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.resourcemanage.aa;
import com.obric.autogui.resourcemanage.ae;
import com.obric.autogui.resourcemanage.af;
import com.obric.autogui.resourcemanage.y;
import com.obric.autogui.resourcemanage.z;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ax;
import d.x;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: ScriptResourceDownloader.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class s implements com.obric.autogui.agents.scripted.api.b {
    private static final String TAG = "Script-ScriptResourceDownloader";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f27088a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d.h.a.a<x> f27089b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final d.h.a.a<x> f27090c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final d.f f27091d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final d.f f27092e;
    private final AtomicBoolean f;
    private final AtomicBoolean g;
    private final AtomicBoolean h;
    private final ae i;
    private final Object j;
    private final LinkedHashSet<com.obric.autogui.resourcemanage.k> k;
    private ScheduledFuture<?> l;
    private ScheduledFuture<?> m;
    private Long n;
    private boolean o;
    private com.obric.autogui.resourcemanage.k p;
    private aa q;
    private long r;
    private final d.f s;
    private final d.f t;
    private final d.f u;

    /* JADX INFO: compiled from: ScriptResourceDownloader.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: ScriptResourceDownloader.kt */
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f27093a = null;

        static {
            int[] r0 = new int[af.values().length];
            r0[af.f30600b.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[af.f30601c.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[af.f30599a.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f27093a = r0;
        }
    }

    /* JADX INFO: compiled from: ScriptResourceDownloader.kt */
    /* synthetic */ class c extends d.h.b.l implements d.h.a.b<com.obric.autogui.resourcemanage.k, Boolean> {
        c(Object r8) {
            super(1, r8, s.class, "isSceneEnabled", "isSceneEnabled(Lcom/obric/autogui/resourcemanage/RequestScene;)Z", 0);
        }

        public final Boolean a(com.obric.autogui.resourcemanage.k r3) {
            d.h.b.o.e(r3, "p0");
            return Boolean.valueOf(s.a((s) ZeusTransformUtils.preCheckCast(this.receiver, s.class, "com.obric.aiagent.plugin"), r3));
        }

        @Override // d.h.a.b
        public /* synthetic */ Boolean invoke(com.obric.autogui.resourcemanage.k r3) {
            return a((com.obric.autogui.resourcemanage.k) ZeusTransformUtils.preCheckCast(r3, com.obric.autogui.resourcemanage.k.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: ScriptResourceDownloader.kt */
    /* synthetic */ class d extends d.h.b.l implements d.h.a.b<com.obric.autogui.resourcemanage.k, Boolean> {
        d(Object r8) {
            super(1, r8, s.class, "isSceneEnabled", "isSceneEnabled(Lcom/obric/autogui/resourcemanage/RequestScene;)Z", 0);
        }

        public final Boolean a(com.obric.autogui.resourcemanage.k r3) {
            d.h.b.o.e(r3, "p0");
            return Boolean.valueOf(s.a((s) ZeusTransformUtils.preCheckCast(this.receiver, s.class, "com.obric.aiagent.plugin"), r3));
        }

        @Override // d.h.a.b
        public /* synthetic */ Boolean invoke(com.obric.autogui.resourcemanage.k r3) {
            return a((com.obric.autogui.resourcemanage.k) ZeusTransformUtils.preCheckCast(r3, com.obric.autogui.resourcemanage.k.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: ScriptResourceDownloader.kt */
    /* synthetic */ class e extends d.h.b.l implements d.h.a.b<Context, x> {
        e(Object r8) {
            super(1, r8, s.class, "completeRound", "completeRound(Landroid/content/Context;)V", 0);
        }

        public final void a(Context r3) {
            Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r4, "p0");
            s.a((s) ZeusTransformUtils.preCheckCast(this.receiver, s.class, "com.obric.aiagent.plugin"), r4);
        }

        @Override // d.h.a.b
        public /* synthetic */ x invoke(Context r3) {
            a((Context) ZeusTransformUtils.preCheckCast(r3, Context.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }
    }

    static {
        f27088a = new a(null);
    }

    /* JADX INFO: renamed from: lambda$-9-h_AgeJT-oqDGgTk30mNzYsAc, reason: not valid java name */
    public static /* synthetic */ ScriptResourceDownloader$networkCallback$2$1 m733lambda$9h_AgeJToqDGgTk30mNzYsAc(s r0) {
        return e(r0);
    }

    public static /* synthetic */ com.obric.aiagent.utils.a.b.a lambda$4i5ZTRNKjUcyXW4VngubjfpfCaM(s r0) {
        return c(r0);
    }

    public static /* synthetic */ ScheduledExecutorService lambda$CEbEudGUkHI0ZNAGfYiQecF03xQ() {
        return l();
    }

    public static /* synthetic */ com.obric.autogui.util.doubao.settings.c.a lambda$G1CN7Mwn7KnhO2YgWQB2tHZSqZ0(s r0) {
        return d(r0);
    }

    public static /* synthetic */ void lambda$LFqxMb1pU6KNnc93VijCw5Bo00M(s r0, long r1) {
        a(r0, r1);
    }

    public static /* synthetic */ void lambda$N346NCfbKtaAFOQZieDwYRYi7uA(s r0, Context r1) {
        b(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$QMG0yE_-V8F2UldpDdbupSQ3Lmw, reason: not valid java name */
    public static /* synthetic */ void m734lambda$QMG0yE_V8F2UldpDdbupSQ3Lmw(s r0, boolean r1) {
        a(r0, r1);
    }

    public static /* synthetic */ v lambda$XJev5fLeqdyDnSdPh9w8dzGIkpE(s r0) {
        return b(r0);
    }

    public static /* synthetic */ x lambda$YTlGgLK2SWxkhTTutobrDPMWKs8(s r0, com.obric.autogui.resourcemanage.k r1) {
        return b(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$pweaSoJ3BTD4Ul68K-dW86wsiGE, reason: not valid java name */
    public static /* synthetic */ void m735lambda$pweaSoJ3BTD4Ul68KdW86wsiGE(s r0) {
        f(r0);
    }

    public s(d.h.a.a<x> r3, d.h.a.a<x> r4) {
        d.h.a.a<x> r5 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.a.a<x> r6 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "onEngineResourceUpdated");
        d.h.b.o.e(r6, "onScriptResourceUpdated");
        this.f27089b = r5;
        this.f27090c = r6;
        this.f27091d = d.g.a($$Lambda$s$CEbEudGUkHI0ZNAGfYiQecF03xQ.INSTANCE);
        this.f27092e = d.g.a(new $$Lambda$s$XJev5fLeqdyDnSdPh9w8dzGIkpE(this));
        this.f = new AtomicBoolean(false);
        this.g = new AtomicBoolean(false);
        this.h = new AtomicBoolean(false);
        this.i = new ae(false, 1, null);
        this.j = new Object();
        this.k = new LinkedHashSet();
        this.s = d.g.a(new $$Lambda$s$4i5ZTRNKjUcyXW4VngubjfpfCaM(this));
        this.t = d.g.a(new $$Lambda$s$G1CN7Mwn7KnhO2YgWQB2tHZSqZ0(this));
        this.u = d.g.a(new $$Lambda$s$9h_AgeJToqDGgTk30mNzYsAc(this));
    }

    public static final /* synthetic */ void a(s r0) {
        r0.g();
    }

    public static final /* synthetic */ void a(s r2, Context r3) {
        r2.c((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ void a(s r2, Context r3, boolean r4) {
        r2.a((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), r4);
    }

    public static final /* synthetic */ boolean a(s r0, com.obric.autogui.resourcemanage.k r1) {
        return r0.a(r1);
    }

    private final ScheduledExecutorService b() {
        return (ScheduledExecutorService) ZeusTransformUtils.preCheckCast(this.f27091d.b(), ScheduledExecutorService.class, "com.obric.aiagent.plugin");
    }

    private static final ScheduledExecutorService l() {
        return Executors.newSingleThreadScheduledExecutor();
    }

    private final v c() {
        return (v) ZeusTransformUtils.preCheckCast(this.f27092e.b(), v.class, "com.obric.aiagent.plugin");
    }

    private static final v b(s r7) {
        d.h.a.a<x> r1 = r7.f27089b;
        d.h.a.a<x> r2 = r7.f27090c;
        ScheduledExecutorService r3 = r7.b();
        d.h.b.o.c(r3, "<get-scheduledExecutor>(...)");
        return new v(r1, r2, r3, (d.h.a.b) ZeusTransformUtils.preCheckCast(new d(r7), d.h.a.b.class, "com.obric.aiagent.plugin"), (d.h.a.b) ZeusTransformUtils.preCheckCast(new e(r7), d.h.a.b.class, "com.obric.aiagent.plugin"));
    }

    private final com.obric.aiagent.utils.a.b.a d() {
        return (com.obric.aiagent.utils.a.b.a) ZeusTransformUtils.preCheckCast(this.s.b(), com.obric.aiagent.utils.a.b.a.class, "com.obric.aiagent.plugin");
    }

    private static final com.obric.aiagent.utils.a.b.a c(final s r1) {
        return new $$Lambda$s$QMG0yE_V8F2UldpDdbupSQ3Lmw(r1);
    }

    private static final void a(s r7, boolean r8) {
        if (r8 == false) goto L4;
        return;
    L4:
        if (r7.a(com.obric.autogui.resourcemanage.k.f30633c) == false) goto L10;
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContextOrNull(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L11;
        a(r7, r1, com.obric.autogui.resourcemanage.k.f30633c, 0, 4, null);
        return;
    L11:
        return;
    }

    private final com.obric.autogui.util.doubao.settings.c.a e() {
        return (com.obric.autogui.util.doubao.settings.c.a) ZeusTransformUtils.preCheckCast(this.t.b(), com.obric.autogui.util.doubao.settings.c.a.class, "com.obric.aiagent.plugin");
    }

    private static final com.obric.autogui.util.doubao.settings.c.a d(final s r1) {
        return new $$Lambda$s$LFqxMb1pU6KNnc93VijCw5Bo00M(r1);
    }

    private static final void a(s r9, long r10) {
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContextOrNull(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        aa r4 = r9.k();
        aa r3 = r9.q;
        r9.q = r4;
        Object r0 = r9.j;
        monitor-enter(r0);
    L31:
        th = move-exception;
        throw th;
    L5:
        if (r9.o == false) goto L8;
        com.obric.autogui.resourcemanage.k r1 = r9.p;     // Catch: Throwable -> L31
    L9:
        com.obric.autogui.resourcemanage.k r8 = r1;
        monitor-exit(r0);
        if (r2 != null) goto L14;
    L16:
        boolean r5 = false;
    L17:
        y r6 = z.a(r3, r4, r5, r9.g.get(), !com.obric.aiagent.utils.a.b.f22307a.a(), r8);
        com.obric.autogui.agents.scripted.c.d r7 = com.obric.autogui.agents.scripted.c.b.f26918a.h();
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L20;
        Loog.INSTANCE.d(TAG, "Settings applied. version=" + r10 + ", replay=" + r6.a() + ", cancel=" + r6.b() + ", periodic=" + r6.c() + ", strategy=" + r7);
    L20:
        r9.a(r6.c());
        if (r2 != null) goto L24;
        return;
    L24:
        if (r6.d() == false) goto L27;
        r9.i();
    L27:
        if (r6.b() == false) goto L29;
        r9.j();
    L29:
        r9.a(r2);
        a(r9, r2, r6.a(), 0, 4, null);
        return;
    L14:
        if (com.obric.autogui.resourcemanage.g.f30624a.b(r2) == false) goto L16;
        r5 = true;
        goto L17
    L8:
        r1 = null;
        goto L9
    }

    private final ScriptResourceDownloader$networkCallback$2$1 f() {
        return (ScriptResourceDownloader$networkCallback$2$1) ZeusTransformUtils.preCheckCast(this.u.b(), ScriptResourceDownloader$networkCallback$2$1.class, "com.obric.aiagent.plugin");
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.obric.autogui.agents.scripted.impl.ScriptResourceDownloader$networkCallback$2$1] */
    private static final ScriptResourceDownloader$networkCallback$2$1 e(final s r1) {
        return new ScriptResourceDownloader$networkCallback$2$1(r1);
    }

    public void a() {
        if (this.f.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        com.obric.aiagent.utils.a.b.f22307a.a(d());
        com.obric.autogui.util.doubao.settings.c.f31526a.a(e());
        a(this, false, 1, null);
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContextOrNull(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L9;
        a(r0);
    L9:
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L12;
        Loog.INSTANCE.d(TAG, "Resource update listeners registered");
        return;
    }

    static /* synthetic */ void a(s r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = z.a(com.obric.autogui.resourcemanage.k.f30634d, r0.k());
    L5:
        r0.a(r1);
    }

    private final void a(boolean r10) {
        long r5 = com.obric.autogui.agents.scripted.c.b.f26918a.h().d();
        Object r0 = this.j;
        monitor-enter(r0);
        Object r8 = null;
        if (r10 == true) goto L12;
        ScheduledFuture<?> r11 = this.m;     // Catch: Throwable -> L41
        if (r11 == null) goto L9;
        r11.cancel(false);     // Catch: Throwable -> L41
    L9:
        this.m = null;     // Catch: Throwable -> L41
        this.n = null;     // Catch: Throwable -> L41
        monitor-exit(r0);
        return;
    L12:
        ScheduledFuture<?> r12 = this.m;     // Catch: Throwable -> L41
        Long r2 = this.n;     // Catch: Throwable -> L41
        if (r2 != null) goto L16;
    L24:
        if (r12 == null) goto L26;
        r12.cancel(false);     // Catch: Throwable -> L41
    L26:
        this.n = Long.valueOf(r5);     // Catch: Throwable -> L41
        d.n.a r13 = d.n.f38560a;     // Catch: Throwable -> L29
        final s r14 = (s) ZeusTransformUtils.preCheckCast(this, s.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L29
        Object r15 = d.n.f(r14.b().scheduleAtFixedRate(new $$Lambda$s$pweaSoJ3BTD4Ul68KdW86wsiGE(r14), r5, r5, TimeUnit.MILLISECONDS));     // Catch: Throwable -> L29
    L31:
        Throwable r1 = d.n.c(r15);     // Catch: Throwable -> L41
        if (r1 == null) goto L35;
        com.obric.autogui.agents.scripted.c.c.a(TAG, "Failed to schedule periodic resource refresh", r1);     // Catch: Throwable -> L41
    L35:
        if (d.n.b(r15) == true) goto L38;
        r8 = r15;
    L38:
        this.m = (ScheduledFuture) ZeusTransformUtils.preCheckCast(r8, ScheduledFuture.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L41
        x r9 = x.f38692a;     // Catch: Throwable -> L41
        monitor-exit(r0);
        return;
    L29:
        th = move-exception;
        d.n.a r3 = d.n.f38560a;     // Catch: Throwable -> L41
        r15 = d.n.f(d.o.a(th));     // Catch: Throwable -> L41
        goto L31
    L16:
        if (r2.longValue() != r5) goto L24;
        if (r12 == null) goto L24;
        if (r12.isCancelled() == true) goto L24;
        if (r12.isDone() == true) goto L24;
        monitor-exit(r0);
        return;
    L41:
        th = move-exception;
        throw th;
    }

    private static final void f(s r8) {
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContextOrNull(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L6;
        a(r8, r2, com.obric.autogui.resourcemanage.k.f30634d, 0, 4, null);
        return;
    }

    private final void a(Context r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        if (this.h.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        Context r8 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r7.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        Object r0 = r8.getSystemService("connectivity");
        if (ZeusTransformUtils.instanceOf(r0, ConnectivityManager.class) == false) goto L8;
        ConnectivityManager r1 = (ConnectivityManager) ZeusTransformUtils.preCheckCast(r0, ConnectivityManager.class, "com.obric.aiagent.plugin");
    L9:
        if (r1 != null) goto L12;
        this.h.set(false);
        return;
    L12:
        ae r3 = this.i;
        com.obric.autogui.resourcemanage.g r4 = com.obric.autogui.resourcemanage.g.f30624a;
        d.h.b.o.a(r8);
        r3.a(r4.b(r8));
        d.n.a r9 = d.n.f38560a;     // Catch: Throwable -> L15
        r1.registerDefaultNetworkCallback((ConnectivityManager.NetworkCallback) ZeusTransformUtils.preCheckCast(((s) ZeusTransformUtils.preCheckCast(this, s.class, "com.obric.aiagent.plugin")).f(), ConnectivityManager.NetworkCallback.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L15
        Object r10 = d.n.f(x.f38692a);     // Catch: Throwable -> L15
    L17:
        Throwable r11 = d.n.c(r10);
        if (r11 == null) goto L23;
        this.h.set(false);
        com.obric.autogui.agents.scripted.c.c.a(TAG, "Failed to register network callback", r11);
        return;
    L23:
        return;
    L15:
        th = move-exception;
        d.n.a r2 = d.n.f38560a;
        r10 = d.n.f(d.o.a(th));
        goto L17
    L8:
        r1 = null;
        goto L9
    }

    private final void g() {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContextOrNull(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
        return;
    L5:
        a(r0, com.obric.autogui.resourcemanage.g.f30624a.b(r0));
    }

    private final void a(Context r3, boolean r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        af r6 = this.i.update(r4);
        int r7 = b.f27093a[r6.ordinal()];
        if (r7 == 1) goto L16;
        if (r7 == 2) goto L12;
        if (r7 != 3) goto L10;
        return;
    L10:
        throw new d.k();
    L12:
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L14;
        Loog.INSTANCE.d(TAG, "Eligible Wi-Fi was lost; canceling active resource work");
    L14:
        c().b();
        return;
    L16:
        if (com.obric.autogui.agents.scripted.c.b.f26918a.e() == true) goto L19;
        return;
    L19:
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L21;
        Loog.INSTANCE.d(TAG, "Eligible Wi-Fi became available");
    L21:
        long r0 = com.obric.autogui.agents.scripted.c.b.f26918a.h().c();
        a(r5, com.obric.autogui.resourcemanage.k.f30635e, r0);
    }

    public final void a(Context r8, com.obric.autogui.resourcemanage.k r9) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r1, "context");
        d.h.b.o.e(r9, DBHelper.BATTERY_COL_SCENE);
        a(this, r1, r9, 0, 4, null);
    }

    static /* synthetic */ void a(s r1, Context r2, com.obric.autogui.resourcemanage.k r3, long r4, int r6, Object r7) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if ((r6 & 4) == 0) goto L5;
        r4 = 0;
    L5:
        r1.a(r5, r3, r4);
    }

    private final void a(Context r3, com.obric.autogui.resourcemanage.k r4, long r5) {
        a((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), ax.a(r4), r5);
    }

    static /* synthetic */ void a(s r1, Context r2, Set r3, long r4, int r6, Object r7) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        Set<? extends com.obric.autogui.resourcemanage.k> r8 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.aiagent.plugin");
        if ((r6 & 4) == 0) goto L5;
        r4 = 0;
    L5:
        r1.a(r5, r8, r4);
    }

    private final void a(Context r5, Set<? extends com.obric.autogui.resourcemanage.k> r6, long r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        Set r9 = (Set) ZeusTransformUtils.wrapperContextForParams(r6, Set.class, "com.obric.aiagent.plugin");
        if (r9.isEmpty() == false) goto L5;
        return;
    L5:
        Context r10 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        Object r0 = this.j;
        monitor-enter(r0);
        d.a.p.a((Collection) ZeusTransformUtils.preCheckCast(this.k, Collection.class, "com.obric.aiagent.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L19
        if (r9.contains(com.obric.autogui.resourcemanage.k.f30635e) == false) goto L13;
        if (r7 <= 0) goto L13;
        this.r = SystemClock.elapsedRealtime() + r7;     // Catch: Throwable -> L19
    L13:
        if (this.o == false) goto L16;
        monitor-exit(r0);
        return;
    L16:
        d.h.b.o.a(r10);     // Catch: Throwable -> L19
        a(r10, h());     // Catch: Throwable -> L19
        x r4 = x.f38692a;     // Catch: Throwable -> L19
        monitor-exit(r0);
        return;
    L19:
        th = move-exception;
        throw th;
    }

    private final long h() {
        return z.a((Set) ZeusTransformUtils.preCheckCast(this.k, Set.class, "com.obric.aiagent.plugin"), this.r, SystemClock.elapsedRealtime());
    }

    private final void a(Context r6, long r7) {
        final Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        ScheduledFuture<?> r0 = this.l;
        if (r0 != null) goto L5;
    L8:
        this.l = b().schedule(new $$Lambda$s$N346NCfbKtaAFOQZieDwYRYi7uA(this, r8), r7, TimeUnit.MILLISECONDS);
        return;
    L5:
        if (d.l.n.a(r0.getDelay(TimeUnit.MILLISECONDS), 0) != r7) goto L7;
        return;
    L7:
        r0.cancel(false);
        goto L8
    }

    private static final void b(s r2, Context r3) {
        r2.b((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"));
    }

    private final void i() {
        Object r0 = this.j;
        monitor-enter(r0);
        this.k.clear();     // Catch: Throwable -> L10
        ScheduledFuture<?> r1 = this.l;     // Catch: Throwable -> L10
        if (r1 == null) goto L7;
        r1.cancel(false);     // Catch: Throwable -> L10
    L7:
        this.l = null;     // Catch: Throwable -> L10
        this.r = 0;     // Catch: Throwable -> L10
        x r3 = x.f38692a;     // Catch: Throwable -> L10
        monitor-exit(r0);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private final void j() {
        c().a();
    }

    private final aa k() {
        return new aa(com.obric.autogui.agents.scripted.c.b.f26918a.a(), com.obric.autogui.agents.scripted.c.b.f26918a.b(), com.obric.autogui.agents.scripted.c.b.f26918a.c(), com.obric.autogui.agents.scripted.c.b.f26918a.d(), com.obric.autogui.agents.scripted.c.b.f26918a.e(), com.obric.autogui.agents.scripted.c.b.f26918a.f());
    }

    private final void b(Context r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        Object r0 = this.j;
        monitor-enter(r0);
        this.l = null;     // Catch: Throwable -> L27
        if (this.o == false) goto L9;
        monitor-exit(r0);
        return;
    L9:
        Set<? extends com.obric.autogui.resourcemanage.k> r1 = d.a.p.q((Iterable) ZeusTransformUtils.preCheckCast(this.k, Iterable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L27
        this.k.clear();     // Catch: Throwable -> L27
        this.o = true;     // Catch: Throwable -> L27
        monitor-exit(r0);
        com.obric.autogui.resourcemanage.k r2 = a(r1);
        if (r2 != null) goto L19;
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L16;
        Loog.INSTANCE.d(TAG, "All coalesced resource triggers are disabled. scenes=" + r1);
    L16:
        c(r7);
        return;
    L19:
        if (com.obric.autogui.resourcemanage.g.f30624a.b(r7) == false) goto L21;
        b(r7, r2);
        return;
    L21:
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L23;
        Loog.INSTANCE.d(TAG, "Skip resource round without validated unmetered Wi-Fi. scene=" + r2);
    L23:
        c(r7);
        return;
    L27:
        th = move-exception;
        throw th;
    }

    private final com.obric.autogui.resourcemanage.k a(Set<? extends com.obric.autogui.resourcemanage.k> r3) {
        return t.a((Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.aiagent.plugin"), (d.h.a.b) ZeusTransformUtils.preCheckCast(new c(this), d.h.a.b.class, "com.obric.aiagent.plugin"));
    }

    private final boolean a(com.obric.autogui.resourcemanage.k r1) {
        return z.a(r1, k());
    }

    private final void b(Context r3, final com.obric.autogui.resourcemanage.k r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        if (a(r4) == true) goto L6;
        c(r5);
        return;
    L6:
        c().a(r5, r4, new $$Lambda$s$YTlGgLK2SWxkhTTutobrDPMWKs8(this, r4));
    }

    private static final x b(s r1, com.obric.autogui.resourcemanage.k r2) {
        Object r0 = r1.j;
        monitor-enter(r0);
        r1.p = r2;     // Catch: Throwable -> L8
        x r3 = x.f38692a;     // Catch: Throwable -> L8
        monitor-exit(r0);
        return x.f38692a;
    L8:
        th = move-exception;
        throw th;
    }

    private final void c(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        Object r0 = this.j;
        monitor-enter(r0);
        this.p = null;     // Catch: Throwable -> L11
        this.o = false;     // Catch: Throwable -> L11
        if ((!((Collection) ZeusTransformUtils.preCheckCast(this.k, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L8;
        a(r6, h());     // Catch: Throwable -> L11
    L8:
        x r4 = x.f38692a;     // Catch: Throwable -> L11
        monitor-exit(r0);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.autogui.agents.scripted.api.b
    public Object onFoundationReady(Context r10, d.c.d<? super x> r11) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        d.c.d r12 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
        this.g.set(true);
        a(r3);
        LinkedHashSet r13 = new LinkedHashSet();
        if (com.obric.autogui.resourcemanage.g.f30624a.b(r3) == true) goto L5;
    L7:
        ((Collection) ZeusTransformUtils.preCheckCast(r13, Collection.class, "com.obric.aiagent.plugin")).add(com.obric.autogui.resourcemanage.k.f30631a);
        a(this, r3, (Set) ZeusTransformUtils.preCheckCast(r13, Set.class, "com.obric.aiagent.plugin"), 0, 4, null);
        return x.f38692a;
    L5:
        if (a(com.obric.autogui.resourcemanage.k.f) == false) goto L7;
        ((Collection) ZeusTransformUtils.preCheckCast(r13, Collection.class, "com.obric.aiagent.plugin")).add(com.obric.autogui.resourcemanage.k.f);
        goto L7
    }
}
