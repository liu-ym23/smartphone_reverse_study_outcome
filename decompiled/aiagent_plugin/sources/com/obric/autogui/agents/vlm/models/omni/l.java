package com.obric.autogui.agents.vlm.models.omni;

import com.obric.autogui.common.api.AOAgentRobotsTools;
import com.obric.autogui.common.api.AOSystemTools;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.oui.orecyclerview.widget.ItemTouchHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlinx.coroutines.am;
import kotlinx.coroutines.au;
import kotlinx.coroutines.dg;

/* JADX INFO: compiled from: OmniSession.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.obric.autogui.agents.vlm.models.omni.intent.g f28423a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final DispatchContext f28424b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f28425c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.obric.autogui.agents.vlm.models.omni.b.b f28426d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f28427e;
    private final String f;
    private final String g;
    private final c h;
    private final z i;
    private volatile Boolean j;
    private volatile com.obric.autogui.agents.vlm.models.impl.c k;
    private volatile Boolean l;
    private final Object m;
    private y n;
    private volatile x o;
    private volatile AOAgentRobotsTools.TargetAppGrant p;
    private volatile boolean q;

    /* JADX INFO: compiled from: OmniSession.kt */
    @d.c.b.a.f(b = "OmniSession.kt", c = {ItemTouchHelper.a.DEFAULT_SWIPE_ANIMATION_DURATION}, d = "resolvePostActionWhiteScreenState$operator_release", e = "com.obric.autogui.agents.vlm.models.omni.OmniAction")
    static final class a extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f28428a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f28429b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f28430c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        long f28431d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        /* synthetic */ Object f28432e;
        final /* synthetic */ l f;
        int g;

        a(l r3, d.c.d<? super a> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r4) {
            this.f28432e = r4;
            this.g |= Integer.MIN_VALUE;
            return this.f.a(null, 0, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: OmniSession.kt */
    @d.c.b.a.f(b = "OmniSession.kt", c = {251}, d = "invokeSuspend", e = "com.obric.autogui.agents.vlm.models.omni.OmniAction$resolvePostActionWhiteScreenState$isWhiteScreen$1$1")
    static final class b extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super Boolean>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f28433a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ y f28434b;

        b(y r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f28434b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super Boolean> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.f28434b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super Boolean> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f28433a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r5);
        L11:
            return r5;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r5);
            au<Boolean> r6 = this.f28434b.b();
            d.c.d<? super Boolean> r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f28433a = 1;
            r5 = r6.a(r2);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, l.class) == true) goto L8;
        return false;
    L8:
        l r6 = (l) ZeusTransformUtils.preCheckCast(r5, l.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f28423a, r6.f28423a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f28424b, r6.f28424b) == true) goto L15;
        return false;
    L15:
        if (this.f28425c == r6.f28425c) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.f28426d, r6.f28426d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r0 = ((((this.f28423a.hashCode() * 31) + this.f28424b.hashCode()) * 31) + Boolean.hashCode(this.f28425c)) * 31;
        com.obric.autogui.agents.vlm.models.omni.b.b r2 = this.f28426d;
        if (r2 != null) goto L5;
        int r3 = 0;
    L7:
        return r0 + r3;
    L5:
        r3 = r2.hashCode();
        goto L7
    }

    public String toString() {
        return "OmniAction(action=" + this.f28423a + ", dispatchContext=" + this.f28424b + ", isMockInit=" + this.f28425c + ", toolTrace=" + this.f28426d + ')';
    }

    public l(com.obric.autogui.agents.vlm.models.omni.intent.g r9, DispatchContext r10, boolean r11, com.obric.autogui.agents.vlm.models.omni.b.b r12) {
        d.h.b.o.e(r9, "action");
        d.h.b.o.e(r10, "dispatchContext");
        this.f28423a = r9;
        this.f28424b = r10;
        this.f28425c = r11;
        this.f28426d = r12;
        int r13 = com.obric.autogui.agents.vlm.models.omni.intent.b.a(r9);
        this.f28427e = r13;
        this.f = com.obric.autogui.agents.vlm.models.omni.intent.b.b(r9);
        this.g = s.a(r9.c(), r9.d());
        this.h = new c(r13);
        this.i = new z(r13);
        this.k = new com.obric.autogui.agents.vlm.models.impl.c(false, false, 0, false, 15, null);
        this.m = new Object();
    }

    public /* synthetic */ l(com.obric.autogui.agents.vlm.models.omni.intent.g r1, DispatchContext r2, boolean r3, com.obric.autogui.agents.vlm.models.omni.b.b r4, int r5, d.h.b.h r6) {
        if ((r5 & 4) == 0) goto L6;
        r3 = false;
    L6:
        if ((r5 & 8) == 0) goto L8;
        r4 = null;
    L8:
        this(r1, r2, r3, r4);
    }

    public final com.obric.autogui.agents.vlm.models.omni.intent.g a() {
        return this.f28423a;
    }

    public final DispatchContext b() {
        return this.f28424b;
    }

    public final boolean c() {
        return this.f28425c;
    }

    public final com.obric.autogui.agents.vlm.models.omni.b.b d() {
        return this.f28426d;
    }

    public final int e() {
        return this.f28427e;
    }

    public final String f() {
        return this.f;
    }

    public final String g() {
        return this.g;
    }

    public final c h() {
        return this.h;
    }

    public final z i() {
        return this.i;
    }

    public final Boolean j() {
        return this.j;
    }

    public final void a(Boolean r1) {
        this.j = r1;
    }

    public final com.obric.autogui.agents.vlm.models.impl.c k() {
        return this.k;
    }

    public final void a(com.obric.autogui.agents.vlm.models.impl.c r2) {
        d.h.b.o.e(r2, "snapshot");
        this.k = r2;
    }

    public final Boolean l() {
        return this.l;
    }

    public final x m() {
        return this.o;
    }

    public final void a(String r10, Long r11, long r12) {
        d.h.b.o.e(r10, "screenshotStepId");
        this.o = new x(r10, r11, r12, null, 8, null);
    }

    public final void a(String r3, au<Boolean> r4) {
        au r5 = (au) ZeusTransformUtils.wrapperContextForParams(r4, au.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "screenshotStepId");
        d.h.b.o.e(r5, "result");
        Object r0 = this.m;
        monitor-enter(r0);
        this.l = null;     // Catch: Throwable -> L8
        this.n = new y(r3, r5);     // Catch: Throwable -> L8
        d.x r2 = d.x.f38692a;     // Catch: Throwable -> L8
        monitor-exit(r0);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Type inference failed for: r2v10, types: [T, java.lang.Long] */
    /* JADX WARN: Type inference failed for: r4v9, types: [T, java.lang.Long] */
    public final Object a(String r20, long r21, d.c.d<? super Boolean> r23) {
        l r0 = this;
        String r1 = r20;
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r23, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r2, a.class) == false) goto L7;
        a r3 = (a) ZeusTransformUtils.preCheckCast(r2, a.class, "com.obric.aiagent.plugin");
        if ((r3.g & Integer.MIN_VALUE) == 0) goto L7;
        r3.g -= Integer.MIN_VALUE;
    L8:
        Object r4 = r3.f28432e;
        Object r5 = d.c.a.b.a();
        int r6 = r3.g;
        if (r6 == 0) goto L18;
        if (r6 != 1) goto L17;
        long r7 = r3.f28431d;
        d.h.b.z.f r8 = (d.h.b.z.f) ZeusTransformUtils.preCheckCast(r3.f28430c, d.h.b.z.f.class, "com.obric.aiagent.plugin");
        String r9 = (String) ZeusTransformUtils.preCheckCast(r3.f28429b, String.class, "com.obric.aiagent.plugin");
        l r10 = (l) ZeusTransformUtils.preCheckCast(r3.f28428a, l.class, "com.obric.aiagent.plugin");
        d.o.a(r4);     // Catch: Throwable -> L14
        r1 = r9;
        r0 = r10;
        Object r11 = r4;
        d.h.b.z.f r12 = r8;
    L60:
        Boolean r13 = (Boolean) ZeusTransformUtils.preCheckCast(r11, Boolean.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L40
        r12.f38504a = d.c.b.a.b.a(d.l.n.a(AOSystemTools.INSTANCE.bootTimeMillis() - r7, 0));
    L47:
        x r14 = r0.o;
        if (r14 != null) goto L50;
    L55:
        r0.b(r13);
        return r13;
    L50:
        if (d.h.b.o.a(r14.a(), r1) == false) goto L52;
        x r15 = r14;
    L53:
        if (r15 == null) goto L55;
        r0.o = x.a(r15, null, null, 0, (Long) ZeusTransformUtils.preCheckCast(r12.f38504a, Long.class, "com.obric.aiagent.plugin"), 7, null);
        goto L55
    L52:
        r15 = null;
    L40:
        th = th;
        r8 = r12;
    L44:
        r8.f38504a = d.c.b.a.b.a(d.l.n.a(AOSystemTools.INSTANCE.bootTimeMillis() - r7, 0));
        throw th;
    L14:
        th = th;
        goto L44
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        d.o.a(r4);
        Object r16 = r0.m;
        monitor-enter(r16);
        y r17 = r0.n;     // Catch: Throwable -> L57
        if (r1 == null) goto L29;
        if (r17 == null) goto L24;
        String r18 = r17.a();     // Catch: Throwable -> L57
    L26:
        if (d.h.b.o.a(r18, r1) == false) goto L29;
        r0.n = null;     // Catch: Throwable -> L57
    L30:
        monitor-exit(r16);
        r12 = new d.h.b.z.f();
        if (r17 == null) goto L46;
        long r19 = AOSystemTools.INSTANCE.bootTimeMillis();
        long r110 = d.l.n.a(r21, 1);     // Catch: Throwable -> L42
        d.h.a.m r22 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new b(r17, null), d.h.a.m.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L42
        r3.f28428a = r0;     // Catch: Throwable -> L42
        r3.f28429b = r1;     // Catch: Throwable -> L42
        r3.f28430c = r12;     // Catch: Throwable -> L42
        r3.f28431d = r19;     // Catch: Throwable -> L42
        r3.g = 1;     // Catch: Throwable -> L42
        r11 = dg.b(r110, r22, r3);     // Catch: Throwable -> L42
        if (r11 != r5) goto L37;
        return r5;
    L37:
        r7 = r19;
    L42:
        th = th;
        r8 = r12;
        r7 = r19;
        goto L44
    L46:
        r13 = null;
        goto L47
    L24:
        r18 = null;
    L29:
        r17 = null;
    L57:
        th = move-exception;
        throw th;
    L7:
        r3 = new a(r0, r2);
        goto L8
    }

    public final void b(Boolean r1) {
        this.l = r1;
    }

    public final AOAgentRobotsTools.TargetAppGrant n() {
        return this.p;
    }

    public final boolean a(String r5, String r6, AOAgentRobotsTools.TargetAppGrantStatus r7) {
        d.h.b.o.e(r7, "status");
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L21;
        CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L13;
    L16:
        boolean r3 = true;
    L17:
        if (r3 == true) goto L21;
        this.p = new AOAgentRobotsTools.TargetAppGrant(r5, r6, r7);
        return true;
    L13:
        if (d.o.o.d(r2) == true) goto L16;
        r3 = false;
    L21:
        return false;
    L5:
        if (d.o.o.d(r0) == true) goto L8;
        r1 = false;
        goto L9
    }

    public final void a(boolean r1) {
        this.q = r1;
    }

    public final boolean o() {
        return this.q;
    }
}
