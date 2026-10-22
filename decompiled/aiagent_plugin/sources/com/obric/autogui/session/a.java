package com.obric.autogui.session;

import android.content.Context;
import android.os.Bundle;
import com.obric.autogui.agents.vlm.models.omni.intent.j;
import com.obric.autogui.agents.vlm.models.omni.r;
import com.obric.autogui.agents.vlm.models.omni.t;
import com.obric.autogui.agents.vlm.models.omni.upload.v;
import com.obric.autogui.common.AutoOperateTask;
import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.agent.IAutoActionAgentEventListener;
import com.obric.autogui.common.api.agent.blacklist.AppBlackListEventHolder;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.device.AODeviceInfo;
import com.obric.autogui.common.api.platform.display.DisplayedAppInfo;
import com.obric.autogui.common.api.platform.input.InjectEventContext;
import com.obric.autogui.common.api.space.AOOperatingSpace;
import com.obric.autogui.common.api.threading.AOThreadingTools;
import com.obric.autogui.session.d.l;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.f;
import d.g;
import d.h.b.h;
import d.h.b.o;
import d.h.b.z;
import d.m;
import d.n;
import d.x;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import kotlinx.coroutines.ca;

/* JADX INFO: compiled from: AOSession.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    private static final String TAG = "AO-Session";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f30702a = null;
    private com.obric.autogui.session.a.d A;
    private final Object[] B;
    private final Bundle C;
    private final com.obric.autogui.session.b D;
    private final Map<String, Object> E;
    private DisplayedAppInfo F;
    private final com.obric.autogui.session.state.termination.a G;
    private final AtomicInteger H;
    private com.obric.autogui.session.c.a I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private final f f30703J;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f30704b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AutoOperateTask f30705c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f30706d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f30707e;
    private final f f;
    private final Date g;
    private long h;
    private long i;
    private final AOThreadingTools.SingleThreadCoroutineScopeWrapper j;
    private AOThreadingTools.LaunchedJob k;
    private final l l;
    private final AtomicReference<AOOperatingSpace> m;
    private final com.obric.autogui.session.state.b n;
    private com.obric.autogui.session.functions.c o;
    private final f p;
    private final List<com.obric.autogui.operator.e> q;
    private final Set<IAutoActionAgentEventListener.OperatingAppInfo> r;
    private com.obric.autogui.operator.e s;
    private int t;
    private int u;
    private volatile String v;
    private boolean w;
    private boolean x;
    private int y;
    private boolean z;

    /* JADX INFO: renamed from: com.obric.autogui.session.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AOSession.kt */
    public static final class C0830a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final a f30708a;

        public C0830a() {
            this.f30708a = new a();
        }

        public final C0830a a(AutoOperateTask r2) {
            o.e(r2, "task");
            a.a(this.f30708a, r2);
            return this;
        }

        public final C0830a a(Context r3) {
            Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            o.e(r4, "context");
            this.f30708a.a(r4);
            return this;
        }

        public final a a() {
            this.f30708a.G();
            return this.f30708a;
        }
    }

    /* JADX INFO: compiled from: AOSession.kt */
    public static final class b {
        public /* synthetic */ b(h r1) {
            this();
        }

        private b() {
        }
    }

    /* JADX INFO: compiled from: AOSession.kt */
    public interface c {
        String a();

        long b();
    }

    /* JADX INFO: compiled from: AOSession.kt */
    public static final class d implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f30709a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f30710b;

        d(a r4) {
            this.f30709a = AODeviceInfo.INSTANCE.getRpDid();
            Bundle r5 = r4.l().getTaskExtras();
            long r0 = -1;
            if (r5 == null) goto L5;
            r0 = r5.getLong("doubao_message_id", -1);
        L5:
            this.f30710b = r0;
        }

        @Override // com.obric.autogui.session.a.c
        public String a() {
            return this.f30709a;
        }

        @Override // com.obric.autogui.session.a.c
        public long b() {
            return this.f30710b;
        }
    }

    static {
        f30702a = new b(null);
    }

    /* JADX INFO: renamed from: lambda$9oVRNebm02aa-s0tfyNPAgPDqGE, reason: not valid java name */
    public static /* synthetic */ x m880lambda$9oVRNebm02aas0tfyNPAgPDqGE(r r0) {
        return a(r0);
    }

    /* JADX INFO: renamed from: lambda$E0uwsU3ynhF-NaHGlZd4MRNtcnA, reason: not valid java name */
    public static /* synthetic */ ConcurrentHashMap m881lambda$E0uwsU3ynhFNaHGlZd4MRNtcnA() {
        return V();
    }

    public static /* synthetic */ d lambda$Uv1yLWEKoFRNs39t7scAhjPqERs(a r0) {
        return d(r0);
    }

    public static /* synthetic */ com.obric.autogui.session.b.a lambda$_Ln4SpAf5NWz_0VWwW6LBGtBvwA(a r0) {
        return b(r0);
    }

    public static /* synthetic */ x lambda$hqKtOwtuRr5AqVnqnny0SqJF8hg(a r0) {
        return c(r0);
    }

    public static /* synthetic */ File lambda$j8o6tu0AMMUheVHwqQZWGFnBJcQ(a r0) {
        return a(r0);
    }

    public static /* synthetic */ x lambda$xOx0Xdx63qy3NMNd3CInp0jzU5s(z.f r0, z.f r1, z.f r2, z.f r3, z.f r4, z.f r5, r r6) {
        return a(r0, r1, r2, r3, r4, r5, r6);
    }

    public a() {
        this.f30706d = AOSystemTools.INSTANCE.randomId();
        this.f30707e = "";
        this.f = g.a($$Lambda$a$E0uwsU3ynhFNaHGlZd4MRNtcnA.INSTANCE);
        this.g = new Date();
        this.j = AOThreadingTools.INSTANCE.createSingleThreadCoroutineScope("ao-ses-th/" + this.f30706d, true);
        this.l = new l(this);
        this.m = new AtomicReference();
        this.n = new com.obric.autogui.session.state.b(this);
        this.o = (com.obric.autogui.session.functions.c) ZeusTransformUtils.preCheckCast(new com.obric.autogui.session.functions.b(this), com.obric.autogui.session.functions.c.class, "com.obric.aiagent.plugin");
        this.p = g.a(new $$Lambda$a$_Ln4SpAf5NWz_0VWwW6LBGtBvwA(this));
        this.q = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        this.r = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.aiagent.plugin");
        this.u = -1;
        this.z = true;
        this.B = new Object[com.obric.autogui.agents.a.EnumC0655a.values().length];
        this.C = new Bundle();
        this.D = new com.obric.autogui.session.b();
        this.E = (Map) ZeusTransformUtils.preCheckCast(new HashMap(), Map.class, "com.obric.aiagent.plugin");
        this.G = new com.obric.autogui.session.state.termination.a(this);
        this.H = new AtomicInteger(0);
        this.I = new com.obric.autogui.session.c.a();
        this.f30703J = g.a(new $$Lambda$a$Uv1yLWEKoFRNs39t7scAhjPqERs(this));
    }

    public static final /* synthetic */ void a(a r0, AutoOperateTask r1) {
        r0.c(r1);
    }

    public final String a() {
        return this.f30706d;
    }

    public final String b() {
        return this.f30707e;
    }

    public final void a(String r2) {
        o.e(r2, "value");
        a(r2, false);
    }

    private final ConcurrentHashMap<String, Object> T() {
        return (ConcurrentHashMap) ZeusTransformUtils.preCheckCast(this.f.b(), ConcurrentHashMap.class, "com.obric.aiagent.plugin");
    }

    private static final ConcurrentHashMap V() {
        return new ConcurrentHashMap();
    }

    public final boolean c() {
        return l().isOmni();
    }

    public final void a(d.h.a.b<? super r, x> r3) {
        d.h.a.b r4 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
        o.e(r4, "block");
        if (c() == false) goto L10;
        r r0 = t.f28523a.a(b());
        if (r0 != null) goto L8;
        Loog.INSTANCE.e(TAG, "[ses/" + this.f30706d + "] - OmniActionsHolder is null for sessionId=" + b());
        return;
    L8:
        r4.invoke(r0);
        return;
    }

    public final void a(String r5, boolean r6) {
        o.e(r5, "value");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(this.f30707e, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == true) goto L11;
        if (r6 == true) goto L11;
        Loog.INSTANCE.w(TAG, "[ses/" + this.f30706d + "] - cannot reset SessionId to `" + r5 + "`; already set to `" + r5 + '`');
        return;
    L11:
        Loog.INSTANCE.i(TAG, "[ses/" + this.f30706d + "] - SessionId=" + r5 + " (forced=" + r6 + ')');
        this.f30707e = r5;
        return;
    L5:
        r0 = false;
        goto L7
    }

    public final IAutoActionAgentEventListener.SessionInfo d() {
        final z.f r8 = new z.f();
        final z.f r9 = new z.f();
        final z.f r10 = new z.f();
        final z.f r11 = new z.f();
        r11.f38504a = "";
        final z.f r12 = new z.f();
        final z.f r13 = new z.f();
        a(new $$Lambda$a$xOx0Xdx63qy3NMNd3CInp0jzU5s(r8, r9, r10, r11, r12, r13));
        Date r1 = this.g;
        AutoOperateTask r17 = l();
        String r2 = this.f30706d;
        String r19 = b();
        int r3 = this.u;
        boolean r4 = this.w;
        boolean r5 = this.x;
        f r23 = g.a(new $$Lambda$a$j8o6tu0AMMUheVHwqQZWGFnBJcQ(this));
        boolean r24 = U();
        String r25 = (String) ZeusTransformUtils.preCheckCast(r8.f38504a, String.class, "com.obric.aiagent.plugin");
        String r26 = (String) ZeusTransformUtils.preCheckCast(r9.f38504a, String.class, "com.obric.aiagent.plugin");
        String r27 = (String) ZeusTransformUtils.preCheckCast(r10.f38504a, String.class, "com.obric.aiagent.plugin");
        String r30 = (String) ZeusTransformUtils.preCheckCast(r11.f38504a, String.class, "com.obric.aiagent.plugin");
        return new IAutoActionAgentEventListener.SessionInfo(r1, r17, r2, r19, r3, r4, r5, r23, r24, r25, r26, r27, (String) ZeusTransformUtils.preCheckCast(r12.f38504a, String.class, "com.obric.aiagent.plugin"), (Long) ZeusTransformUtils.preCheckCast(r13.f38504a, Long.class, "com.obric.aiagent.plugin"), r30);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3, types: [T] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [T] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r2v10, types: [T] */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13, types: [T] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v20, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v29 */
    /* JADX WARN: Type inference failed for: r2v3, types: [T] */
    /* JADX WARN: Type inference failed for: r2v30 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6, types: [T] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    private static final x a(z.f r2, z.f r3, z.f r4, z.f r5, z.f r6, z.f r7, r r8) {
        o.e(r8, "omniSession");
        com.obric.autogui.agents.vlm.models.omni.l r0 = r8.f();
        ?? r1 = 0;
        r1 = 0;
        if (r0 == null) goto L7;
        com.obric.autogui.agents.vlm.models.omni.intent.g r9 = r0.a();
        if (r9 == null) goto L7;
        ?? r10 = r9.g();
    L8:
        r2.f38504a = r10;
        com.obric.autogui.agents.vlm.models.omni.l r11 = r8.f();
        if (r11 == null) goto L13;
        com.obric.autogui.agents.vlm.models.omni.intent.g r12 = r11.a();
        if (r12 == null) goto L13;
        ?? r13 = r12.h();
    L14:
        r3.f38504a = r13;
        com.obric.autogui.agents.vlm.models.omni.l r14 = r8.f();
        if (r14 == null) goto L19;
        com.obric.autogui.agents.vlm.models.omni.intent.g r15 = r14.a();
        if (r15 == null) goto L19;
        ?? r16 = r15.i();
    L20:
        r4.f38504a = r16;
        com.obric.autogui.agents.vlm.models.omni.l r17 = r8.f();
        if (r17 == null) goto L25;
        com.obric.autogui.agents.vlm.models.omni.intent.g r18 = r17.a();
        if (r18 == null) goto L25;
        ?? r19 = r18.o();
    L26:
        if (r19 != 0) goto L28;
        r19 = "";
    L28:
        r5.f38504a = r19;
        com.obric.autogui.agents.vlm.models.omni.l r20 = r8.f();
        if (r20 == null) goto L35;
        com.obric.autogui.agents.vlm.models.omni.intent.g r21 = r20.a();
        if (r21 == null) goto L35;
        j r22 = r21.c();
        if (r22 == null) goto L35;
        ?? r23 = r22.a();
    L36:
        r6.f38504a = r23;
        com.obric.autogui.agents.vlm.models.omni.l r24 = r8.f();
        if (r24 == null) goto L41;
        com.obric.autogui.agents.vlm.models.omni.intent.g r25 = r24.a();
        if (r25 == null) goto L41;
        r1 = r25.a();
    L41:
        r7.f38504a = r1;
        return x.f38692a;
    L35:
        r23 = 0;
    L25:
        r19 = 0;
    L19:
        r16 = 0;
    L13:
        r13 = 0;
    L7:
        r10 = 0;
        goto L8
    }

    private static final File a(a r2) {
        if (r2.c() == false) goto L6;
        File r3 = com.obric.autogui.session.a.c.f30720a.b(r2);
        r3.mkdirs();
        return r3;
    L6:
        return (File) ZeusTransformUtils.preCheckCast(com.obric.autogui.session.a.c.f30720a.c(r2).a(), File.class, "com.obric.aiagent.plugin");
    }

    private final boolean U() {
        n.a r2 = n.f38560a;     // Catch: Throwable -> L34
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(((a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin")).p(), Iterable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L34
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L34
        Iterator r7 = r6.iterator();     // Catch: Throwable -> L34
    L5:
        if (r7.hasNext() == false) goto L16;
        com.obric.autogui.operator.e r4 = (com.obric.autogui.operator.e) ZeusTransformUtils.preCheckCast(r7.next(), com.obric.autogui.operator.e.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L34
        if (ZeusTransformUtils.instanceOf(r4, com.obric.autogui.agents.vlm.models.a.d.class) == true) goto L10;
        m r5 = null;
    L14:
        if (r5 == null) goto L5;
        r3.add(r5);     // Catch: Throwable -> L34
        goto L5
    L10:
        if (ZeusTransformUtils.instanceOf(r4, com.obric.autogui.agents.vlm.models.a.b.class) == false) goto L12;
        String r8 = ((com.obric.autogui.agents.vlm.models.a.b) ZeusTransformUtils.preCheckCast(r4, com.obric.autogui.agents.vlm.models.a.b.class, "com.obric.aiagent.plugin")).f();     // Catch: Throwable -> L34
    L13:
        r5 = new m(r8, ((com.obric.autogui.agents.vlm.models.a.d) ZeusTransformUtils.preCheckCast(r4, com.obric.autogui.agents.vlm.models.a.d.class, "com.obric.aiagent.plugin")).C());     // Catch: Throwable -> L34
        goto L14
    L12:
        r8 = "";
        goto L13
    L16:
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L34
        boolean r10 = true;
        if (ZeusTransformUtils.instanceOf(r9, Collection.class) == true) goto L19;
    L21:
        Iterator r11 = r9.iterator();     // Catch: Throwable -> L34
    L23:
        if (r11.hasNext() == false) goto L32;
        m r12 = (m) ZeusTransformUtils.preCheckCast(r11.next(), m.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L34
        String r13 = (String) ZeusTransformUtils.preCheckCast(r12.c(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L34
        if (((com.obric.autogui.agents.vlm.models.a.d.b) ZeusTransformUtils.preCheckCast(r12.d(), com.obric.autogui.agents.vlm.models.a.d.b.class, "com.obric.aiagent.plugin")) == com.obric.autogui.agents.vlm.models.a.d.b.f27243b) goto L27;
    L29:
        boolean r14 = false;
    L30:
        if (r14 == false) goto L23;
        r10 = false;
        goto L32
    L27:
        if (o.a(r13, "stop") == true) goto L29;
        r14 = true;
    L32:
        Object r15 = n.f(Boolean.valueOf(r10));     // Catch: Throwable -> L34
    L36:
        Throwable r16 = n.c(r15);
        if (r16 == null) goto L40;
        Loog.INSTANCE.e(TAG, "error on get sessionInfo no action", r16);
    L40:
        if (n.b(r15) == false) goto L43;
        r15 = false;
    L43:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r15, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    L19:
        if (((Collection) ZeusTransformUtils.preCheckCast(r9, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L21;
    L34:
        th = move-exception;
        n.a r17 = n.f38560a;
        r15 = n.f(d.o.a(th));
        goto L36
    }

    public final void a(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "<set-?>");
        this.f30704b = ZeusTransformUtils.wrapperContext(r4, "com.obric.aiagent.plugin");
    }

    public final Context getContext() {
        Context r0 = this.f30704b;
        if (r0 == null) goto L5;
        return r0;
    L5:
        o.c("context");
        return null;
    }

    public final Date e() {
        return this.g;
    }

    public final void a(long r1) {
        this.h = r1;
    }

    public final long f() {
        return this.h;
    }

    public final void b(long r1) {
        this.i = r1;
    }

    public final long g() {
        return this.i;
    }

    public final AOThreadingTools.SingleThreadCoroutineScopeWrapper h() {
        return this.j;
    }

    public final void a(AOThreadingTools.LaunchedJob r3) {
        this.k = (AOThreadingTools.LaunchedJob) ZeusTransformUtils.wrapperContextForParams(r3, AOThreadingTools.LaunchedJob.class, "com.obric.aiagent.plugin");
    }

    public final AOThreadingTools.LaunchedJob i() {
        return this.k;
    }

    public final void j() {
        AOThreadingTools.LaunchedJob r0 = this.k;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.getJob().b() == false) goto L8;
        a($$Lambda$a$9oVRNebm02aas0tfyNPAgPDqGE.INSTANCE);
    L8:
        r0.cancel();
    }

    private static final x a(r r1) {
        o.e(r1, "omniSession");
        r1.k();
        return x.f38692a;
    }

    public final l k() {
        return this.l;
    }

    public final void a(AOOperatingSpace r3) {
        AOOperatingSpace r4 = (AOOperatingSpace) ZeusTransformUtils.wrapperContextForParams(r3, AOOperatingSpace.class, "com.obric.aiagent.plugin");
        o.e(r4, "space");
        this.m.set(r4);
    }

    public final boolean b(AOOperatingSpace r3) {
        AOOperatingSpace r4 = (AOOperatingSpace) ZeusTransformUtils.wrapperContextForParams(r3, AOOperatingSpace.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L5;
    L7:
        return false;
    L5:
        if (this.m.get() != r4) goto L7;
        return true;
    }

    public final void a(AutoOperateTask r2) {
        o.e(r2, "<set-?>");
        this.f30705c = r2;
    }

    public final AutoOperateTask l() {
        AutoOperateTask r0 = this.f30705c;
        if (r0 == null) goto L5;
        return r0;
    L5:
        o.c("associatedTask");
        return null;
    }

    public final com.obric.autogui.session.state.b m() {
        return this.n;
    }

    public final com.obric.autogui.session.functions.c n() {
        return this.o;
    }

    public final com.obric.autogui.session.b.a o() {
        return (com.obric.autogui.session.b.a) ZeusTransformUtils.preCheckCast(this.p.b(), com.obric.autogui.session.b.a.class, "com.obric.aiagent.plugin");
    }

    private static final com.obric.autogui.session.b.a b(a r1) {
        return com.obric.autogui.session.b.a.f30744a.a(r1);
    }

    public final List<com.obric.autogui.operator.e> p() {
        return this.q;
    }

    public final Set<IAutoActionAgentEventListener.OperatingAppInfo> q() {
        return this.r;
    }

    public final void a(IAutoActionAgentEventListener.OperatingAppInfo r2) {
        o.e(r2, "appInfo");
        this.r.add(r2);
    }

    public final void a(com.obric.autogui.operator.e r1) {
        this.s = r1;
    }

    public final com.obric.autogui.operator.e r() {
        return this.s;
    }

    public final void a(int r1) {
        this.t = r1;
    }

    public final int s() {
        return this.t;
    }

    public final int t() {
        return this.q.size();
    }

    public final void b(int r1) {
        this.u = r1;
    }

    public final int u() {
        return this.u;
    }

    public final void b(String r1) {
        this.v = r1;
    }

    public final String v() {
        return this.v;
    }

    public final void a(boolean r1) {
        this.w = r1;
    }

    public final void b(boolean r1) {
        this.x = r1;
    }

    public final void c(int r1) {
        this.y = r1;
    }

    public final int w() {
        return this.y;
    }

    public final void c(boolean r1) {
        this.z = r1;
    }

    public final boolean x() {
        return this.z;
    }

    public final com.obric.autogui.session.a.d y() {
        com.obric.autogui.session.a.d r0 = this.A;
        if (r0 == null) goto L8;
        int r1 = r0.a();
        int r4 = this.t;
        if (r1 == r4) goto L7;
        r0.a(r4);
    L7:
        return r0;
    L8:
        com.obric.autogui.session.a.c r2 = new com.obric.autogui.session.a.c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), this);
        r2.a(this.t);
        this.A = (com.obric.autogui.session.a.d) ZeusTransformUtils.preCheckCast(r2, com.obric.autogui.session.a.d.class, "com.obric.aiagent.plugin");
        return (com.obric.autogui.session.a.d) ZeusTransformUtils.preCheckCast(r2, com.obric.autogui.session.a.d.class, "com.obric.aiagent.plugin");
    }

    public final com.obric.autogui.session.a.d z() {
        return this.A;
    }

    public final com.obric.autogui.session.a.d A() {
        com.obric.autogui.session.a.d r0 = this.A;
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.a() != this.t) goto L9;
        return r0;
    L9:
        return null;
    }

    public final void a(com.obric.autogui.agents.a r2, Object r3) {
        o.e(r2, "forAgent");
        o.e(r3, "extension");
        this.B[r2.getType().a()] = r3;
    }

    public final Object a(com.obric.autogui.agents.a r2) {
        o.e(r2, "forAgent");
        return this.B[r2.getType().a()];
    }

    public final Object a(com.obric.autogui.agents.a.EnumC0655a r2) {
        o.e(r2, "forAgentType");
        return this.B[r2.a()];
    }

    public final com.obric.autogui.agents.vlm.b.C0677b B() {
        Object r2 = a(com.obric.autogui.agents.a.EnumC0655a.f26120b);
        if (ZeusTransformUtils.instanceOf(r2, com.obric.autogui.agents.vlm.b.C0677b.class) == true) goto L7;
        return null;
    L7:
        return (com.obric.autogui.agents.vlm.b.C0677b) ZeusTransformUtils.preCheckCast(r2, com.obric.autogui.agents.vlm.b.C0677b.class, "com.obric.aiagent.plugin");
    }

    public final String C() {
        com.obric.autogui.operator.e r2 = (com.obric.autogui.operator.e) ZeusTransformUtils.preCheckCast(p.n(p()), com.obric.autogui.operator.e.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L13;
        IAutoActionAgentEventListener.AgentStepInfo r3 = r2.T();
        if (r3 == null) goto L13;
        String r4 = r3.getActionProtocolType();
        if (r4 == null) goto L13;
        String r5 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        if (r5 == null) goto L13;
        String r6 = r5.toLowerCase(Locale.ROOT);
        o.c(r6, "toLowerCase(...)");
        if (r6 == null) goto L13;
        return r6;
    L13:
        return "";
    }

    public final Bundle D() {
        return this.C;
    }

    public final com.obric.autogui.session.b E() {
        return this.D;
    }

    public final Map<String, Object> F() {
        return this.E;
    }

    public final void G() {
        this.l.f();
    }

    public final DisplayedAppInfo H() {
        return this.F;
    }

    private final void c(AutoOperateTask r4) {
        a(r4);
        if (r4.isOmni() == false) goto L14;
        Bundle r0 = r4.getTaskExtras();
        if (r0 == null) goto L14;
        String r1 = r0.getString("session_id");
        if (r1 == null) goto L14;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L12;
        r1 = null;
    L12:
        if (r1 == null) goto L14;
        a(r1, true);
    L14:
        d(r4);
    }

    private final void d(AutoOperateTask r6) {
        Bundle r7 = r6.getTaskExtras();
        boolean r0 = true;
        if (r7 != null) goto L5;
    L7:
        r0 = false;
    L9:
        if (r0 == true) goto L12;
        this.F = null;
        Loog.INSTANCE.d(TAG, "[ses/" + this.f30706d + "] - [BringTask] start_in_place disabled; skip candidate capture.");
        return;
    L12:
        this.F = e.f30963a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        Loog.INSTANCE.i(TAG, "[ses/" + this.f30706d + "] - [BringTask] captured candidate=" + this.F);
        return;
    L5:
        if (r7.getBoolean("start_in_place") != true) goto L7;
        goto L7
    }

    public final void b(AutoOperateTask r2) {
        o.e(r2, "task");
        c(r2);
        G();
    }

    public final void I() {
        this.l.h();
    }

    public final void c(String r4) {
        o.e(r4, "reason");
        Loog.INSTANCE.i(TAG, "disposeAllPreloaders key=" + this.f30706d + ", reason=" + r4);
        this.l.g();
    }

    public final com.obric.autogui.session.state.termination.a J() {
        return this.G;
    }

    public final boolean K() {
        if (this.G.d() == false) goto L5;
    L7:
        return false;
    L5:
        if (M() == true) goto L7;
        return true;
    }

    public final boolean L() {
        return ZeusTransformUtils.instanceOf(this.n.e(), com.obric.autogui.session.state.a.c.class);
    }

    public final boolean M() {
        return ZeusTransformUtils.instanceOf(this.n.e(), com.obric.autogui.session.state.a.d.class);
    }

    public final AtomicInteger N() {
        return this.H;
    }

    public final com.obric.autogui.session.c.a O() {
        return this.I;
    }

    public final void P() {
        Loog.INSTANCE.i(TAG, "[ses/" + this.f30706d + "] - the session is being cleansed.");
        this.A = null;
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(this.q, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.obric.autogui.operator.e) ZeusTransformUtils.preCheckCast(r0.next(), com.obric.autogui.operator.e.class, "com.obric.aiagent.plugin")).x();
        goto L4
    L6:
        this.q.clear();
        com.obric.autogui.agents.b.f26789a.a(this);
        AppBlackListEventHolder.INSTANCE.clearBlackListEvent();
        AppBlackListEventHolder.INSTANCE.clearHolder();
        com.obric.autogui.agents.scripted.impl.l.f27011a.c(b());
        InjectEventContext.INSTANCE.clearSessionDelayed(b(), new $$Lambda$a$hqKtOwtuRr5AqVnqnny0SqJF8hg(this));
        Loog.INSTANCE.i(TAG, "[ses/" + this.f30706d + "] - the session cleansed");
    }

    private static final x c(a r1) {
        if (r1.c() == false) goto L6;
        v.f28855a.d(r1.b());
    L6:
        return x.f38692a;
    }

    public final void Q() {
        this.n.a().shutdown();
        this.j.shutdown();
        Loog.INSTANCE.i(TAG, "[ses/" + this.f30706d + "] - the session is now dead.");
    }

    public final void d(String r13) {
        o.e(r13, "reason");
        Loog r4 = Loog.INSTANCE;
        StringBuilder r5 = new StringBuilder().append("[ses/").append(this.f30706d).append("] - force shutdown begin, reason=").append(r13).append(", id=").append(b()).append(", state=").append(this.n.e().b()).append(", pendingState=").append(this.n.c()).append(", terminated=").append(this.G.d()).append(",hasReachedEndStep=").append(this.G.a()).append(", loopActive=");
        AOThreadingTools.LaunchedJob r7 = this.k;
        if (r7 == null) goto L7;
        ca r8 = r7.getJob();
        if (r8 == null) goto L7;
        Boolean r9 = Boolean.valueOf(r8.b());
    L8:
        r4.w(TAG, r5.append(r9).append(", worker={").append(this.j.describeState()).append("}, stateThread={").append(this.n.a().describeState()).append('}').toString());
        Loog.INSTANCE.w(TAG, "[ses/" + this.f30706d + "] - force shutdown thread trace, reason=" + r13 + ", workerTrace=" + AOThreadingTools.SingleThreadCoroutineScopeWrapper.captureThreadDiagnosticsOneLine$default(this.j, 0, 1, null) + ", stateTrace=" + AOThreadingTools.SingleThreadCoroutineScopeWrapper.captureThreadDiagnosticsOneLine$default(this.n.a(), 0, 1, null));
        n.a r6 = n.f38560a;     // Catch: Throwable -> L11
        ((a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin")).j();     // Catch: Throwable -> L11
        Object r10 = n.f(x.f38692a);     // Catch: Throwable -> L11
    L13:
        Throwable r11 = n.c(r10);
        if (r11 == null) goto L32;
        Loog.INSTANCE.e(TAG, "[ses/" + this.f30706d + "] - failed to cancel current loop job", r11);
    L32:
        n.a r12 = n.f38560a;     // Catch: Throwable -> L18
        a r14 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L18
        r14.j.forceShutdown("session=" + r14.f30706d + ", reason=" + r13);     // Catch: Throwable -> L18
        Object r15 = n.f(x.f38692a);     // Catch: Throwable -> L18
    L20:
        Throwable r16 = n.c(r15);
        if (r16 == null) goto L34;
        Loog.INSTANCE.e(TAG, "[ses/" + this.f30706d + "] - failed to force shutdown worker", r16);
    L34:
        n.a r17 = n.f38560a;     // Catch: Throwable -> L25
        a r2 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        r2.n.a().forceShutdown("session=" + r2.f30706d + ", reason=" + r13);     // Catch: Throwable -> L25
        Object r0 = n.f(x.f38692a);     // Catch: Throwable -> L25
    L27:
        Throwable r1 = n.c(r0);
        if (r1 == null) goto L30;
        Loog.INSTANCE.e(TAG, "[ses/" + this.f30706d + "] - failed to force shutdown state thread", r1);
    L30:
        Loog.INSTANCE.w(TAG, "[ses/" + this.f30706d + "] - force shutdown requested, reason=" + r13);
        return;
    L25:
        th = move-exception;
        n.a r3 = n.f38560a;
        r0 = n.f(d.o.a(th));
    L18:
        th = move-exception;
        n.a r18 = n.f38560a;
        r15 = n.f(d.o.a(th));
    L11:
        th = move-exception;
        n.a r19 = n.f38560a;
        r10 = n.f(d.o.a(th));
    L7:
        r9 = null;
        goto L8
    }

    public String toString() {
        if (com.obric.autogui.common.b.b.f29001a.a() == false) goto L7;
        return "AOSes[" + this.f30706d + "][" + b() + "]/(" + l() + ')';
    L7:
        return "AOSes[" + this.f30706d + "][" + b() + ']';
    }

    public final c R() {
        return (c) ZeusTransformUtils.preCheckCast(this.f30703J.b(), c.class, "com.obric.aiagent.plugin");
    }

    private static final d d(a r1) {
        return new d(r1);
    }

    public final void e(String r3) {
        o.e(r3, "ability");
        ((Map) ZeusTransformUtils.preCheckCast(T(), Map.class, "com.obric.aiagent.plugin")).put(r3, 1);
    }

    public final Set<String> S() {
        Set<String> r1 = T().keySet();
        o.c(r1, "<get-keys>(...)");
        return r1;
    }
}
