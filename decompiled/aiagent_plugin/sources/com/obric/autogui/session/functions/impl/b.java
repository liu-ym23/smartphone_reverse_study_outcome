package com.obric.autogui.session.functions.impl;

import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.agents.vlm.models.impl.applist.black.g;
import com.obric.autogui.agents.vlm.models.omni.r;
import com.obric.autogui.common.api.AOBizTracking;
import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.agent.AutoActionAgent;
import com.obric.autogui.common.api.agent.BizStatus;
import com.obric.autogui.common.api.agent.blacklist.AppBlackListEvent;
import com.obric.autogui.common.api.agent.blacklist.AppBlackListEventHolder;
import com.obric.autogui.common.api.agent.blacklist.AppBlackListState;
import com.obric.autogui.common.api.agent.model.CallUserFunctionParams;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.tracking.IAutoActionTrackingApi;
import com.obric.autogui.common.api.virtualdisplay.VDTrackingApp;
import com.obric.autogui.common.e;
import com.obric.autogui.session.state.a.i;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.f;
import d.c.b.a.l;
import d.h.b.h;
import d.o;
import d.x;
import org.json.JSONObject;

/* JADX INFO: compiled from: CallUserFunction.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b extends com.obric.autogui.session.functions.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f31047b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f31048c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f31049d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.obric.autogui.session.functions.impl.a f31050e;
    private boolean f;
    private d.h.a.a<Boolean> g;
    private CallUserFunctionParams h;

    /* JADX INFO: compiled from: CallUserFunction.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: renamed from: com.obric.autogui.session.functions.impl.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CallUserFunction.kt */
    @f(b = "CallUserFunction.kt", c = {}, d = "invokeSuspend", e = "com.obric.autogui.session.functions.impl.CallUserFunction$mAutoCancelHelper$1")
    static final class C0850b extends l implements d.h.a.b<d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f31051a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f31052b;

        C0850b(b r3, d.c.d<? super C0850b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31052b = r3;
            super(1, r5);
        }

        public final Object a(d.c.d<? super x> r3) {
            return ((C0850b) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), C0850b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new C0850b(this.f31052b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d.c.d<? super x> r3) {
            return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            d.c.a.b.a();
            if (this.f31051a != 0) goto L7;
            o.a(r8);
            Loog.INSTANCE.w(b.a(this.f31052b), " - [CALL-USER] auto-cancelled!");
            com.obric.autogui.session.state.termination.a.a(this.f31052b.b().J(), e.a.a(e.f29014b, ZeusTransformUtils.mapRes(R.string.agent_task_terminated_unconfirmed_for_too_long, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_task_terminated_unconfirmed_for_too_long"), null, 2, null), 112005, null, null, 12, null);
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: CallUserFunction.kt */
    @f(b = "CallUserFunction.kt", c = {97, 110}, d = "onStart", e = "com.obric.autogui.session.functions.impl.CallUserFunction")
    static final class c extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f31053a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f31054b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f31055c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ b f31056d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f31057e;

        c(b r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31056d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f31055c = r3;
            this.f31057e |= Integer.MIN_VALUE;
            return this.f31056d.c((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: CallUserFunction.kt */
    @f(b = "CallUserFunction.kt", c = {182, 200, 210}, d = "onStop", e = "com.obric.autogui.session.functions.impl.CallUserFunction")
    static final class d extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f31058a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f31059b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f31060c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f31061d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ b f31062e;
        int f;

        d(b r3, d.c.d<? super d> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31062e = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f31061d = r3;
            this.f |= Integer.MIN_VALUE;
            return this.f31062e.d((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        f31047b = new a(null);
    }

    /* JADX INFO: renamed from: lambda$F2buGqXy6VR-nOatIMTY_qqOGNU, reason: not valid java name */
    public static /* synthetic */ x m892lambda$F2buGqXy6VRnOatIMTY_qqOGNU(long r0, r r2) {
        return a(r0, r2);
    }

    public static /* synthetic */ x lambda$_yiYKfKUtxVZH3D3BS6FISrxJVI(r r0) {
        return a(r0);
    }

    public static /* synthetic */ x lambda$fQvf8OuVNlSfxn73nYdZ5YwMo48(int r0, Bundle r1) {
        return a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$lMYTuC-5HpPBv0aMO9zHUreo6nk, reason: not valid java name */
    public static /* synthetic */ x m893lambda$lMYTuC5HpPBv0aMO9zHUreo6nk(b r0, r r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ x lambda$uEvb6EO57NieNxEZf2ArLB6ouX4(long r0, Bundle r2) {
        return a(r0, r2);
    }

    public b() {
        super("CallUser");
        this.f31050e = new com.obric.autogui.session.functions.impl.a((com.obric.autogui.session.functions.a) ZeusTransformUtils.preCheckCast(this, com.obric.autogui.session.functions.a.class, "com.obric.aiagent.plugin"), 600000, (d.h.a.b) ZeusTransformUtils.preCheckCast(new C0850b(this, null), d.h.a.b.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ String a(b r0) {
        return r0.a();
    }

    public final void e() {
        this.f = true;
        com.obric.autogui.session.b.a r0 = b().o();
        if (r0 == null) goto L5;
        r0.a("CALL_USER");
    L5:
        this.f31049d = AOSystemTools.INSTANCE.nowTimeMillis();
        this.f31050e.d();
        Loog.INSTANCE.i(a(), " - [CALL-USER] started=" + this.f31048c + ", entered=" + this.f31049d);
        Loog.INSTANCE.i(a(), " - [CALL-USER] await: " + (this.f31049d - this.f31048c) + "ms");
        b().a($$Lambda$b$_yiYKfKUtxVZH3D3BS6FISrxJVI.INSTANCE);
    }

    private static final x a(r r2) {
        d.h.b.o.e(r2, "omniActionsHolder");
        r.a(r2, null, null, 3, null);
        return x.f38692a;
    }

    @Override // com.obric.autogui.session.functions.a
    public Object c(d.c.d<? super e> r20) {
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r20, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r2, c.class) == false) goto L7;
        c r4 = (c) ZeusTransformUtils.preCheckCast(r2, c.class, "com.obric.aiagent.plugin");
        if ((r4.f31057e & Integer.MIN_VALUE) == 0) goto L7;
        r4.f31057e -= Integer.MIN_VALUE;
    L8:
        Object r3 = r4.f31055c;
        Object r5 = d.c.a.b.a();
        int r6 = r4.f31057e;
        if (r6 == 0) goto L20;
        if (r6 == 1) goto L19;
        if (r6 != 2) goto L18;
        e r7 = (e) ZeusTransformUtils.preCheckCast(r4.f31054b, e.class, "com.obric.aiagent.plugin");
        b r1 = (b) ZeusTransformUtils.preCheckCast(r4.f31053a, b.class, "com.obric.aiagent.plugin");
        o.a(r3);     // Catch: Throwable -> L15
    L44:
        return r7;
    L15:
        th = th;
    L35:
        Loog.INSTANCE.e(r1.a(), "[Auth] failed to relax fwk blacklist in CallUser", th);
        goto L44
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        com.obric.autogui.session.a r0 = (com.obric.autogui.session.a) ZeusTransformUtils.preCheckCast(r4.f31054b, com.obric.autogui.session.a.class, "com.obric.aiagent.plugin");
        r1 = (b) ZeusTransformUtils.preCheckCast(r4.f31053a, b.class, "com.obric.aiagent.plugin");
        o.a(r3);
    L26:
        e r8 = (e) ZeusTransformUtils.preCheckCast(r3, e.class, "com.obric.aiagent.plugin");
        if (r8.g() == false) goto L43;
        com.obric.autogui.a.a.a.f26091a.a(r0);
        r1.f31050e.c();
        g r9 = g.f27362a;     // Catch: Throwable -> L33
        Context r10 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L33
        r4.f31053a = r1;     // Catch: Throwable -> L33
        r4.f31054b = r8;     // Catch: Throwable -> L33
        r4.f31057e = 2;     // Catch: Throwable -> L33
        if (r9.a(r10, false, r4) != r5) goto L32;
        return r5;
    L32:
        r7 = r8;
    L33:
        th = th;
        r7 = r8;
        goto L35
    L43:
        return r8;
    L20:
        o.a(r3);
        Loog.INSTANCE.i(a(), "entering CallUser mode.");
        com.obric.autogui.session.a r11 = b();
        if (r11 == null) goto L37;
        this.f31048c = AOSystemTools.INSTANCE.nowTimeMillis();
        final int r12 = b().D().getInt("calluser_times", 0) + 1;
        Loog.INSTANCE.i(a(), " - [CALL-USER] this is the " + r12 + "-th call_user within this session.");
        b().D().putInt("calluser_times", r12);
        b().J().a(new $$Lambda$b$fQvf8OuVNlSfxn73nYdZ5YwMo48(r12));
        com.obric.autogui.session.state.b r13 = r11.m();
        BizStatus r14 = BizStatus.PAUSED;
        BizStatus.StatusChangedReasonStruct r15 = new BizStatus.StatusChangedReasonStruct(i.b.f31248b.a(), null, this.h, null, 10, null);
        r4.f31053a = this;
        r4.f31054b = r11;
        r4.f31057e = 1;
        r3 = r13.a(r14, r15, r4);
        if (r3 != r5) goto L25;
        return r5;
    L25:
        r1 = this;
        r0 = r11;
        goto L26
    L37:
        Loog.INSTANCE.e(a(), "onStart, no ongoing session.");
        return e.f29014b.b("CallUser onStart, no ongoing session.");
    L7:
        r4 = new c(this, r2);
        goto L8
    }

    private static final x a(int r1, Bundle r2) {
        d.h.b.o.e(r2, "$this$withTaskEndReports");
        r2.putInt("calluser_times", r1);
        return x.f38692a;
    }

    @Override // com.obric.autogui.session.functions.a
    public e c() {
        if (b() != null) goto L7;
        Loog.INSTANCE.e(a(), "canStart, no ongoing session.");
        return e.f29014b.b("CallUser canStart, no ongoing session.");
    L7:
        return e.f29014b.a();
    }

    @Override // com.obric.autogui.session.functions.a
    public Object d(d.c.d<? super e> r22) {
        final b r0 = this;
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r22, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r2, d.class) == false) goto L7;
        d r4 = (d) ZeusTransformUtils.preCheckCast(r2, d.class, "com.obric.aiagent.plugin");
        if ((r4.f & Integer.MIN_VALUE) == 0) goto L7;
        r4.f -= Integer.MIN_VALUE;
    L8:
        Object r3 = r4.f31061d;
        Object r5 = d.c.a.b.a();
        int r6 = r4.f;
        if (r6 == 0) goto L22;
        if (r6 == 1) goto L21;
        if (r6 == 2) goto L20;
        if (r6 != 3) goto L19;
        e r7 = (e) ZeusTransformUtils.preCheckCast(r4.f31059b, e.class, "com.obric.aiagent.plugin");
        b r1 = (b) ZeusTransformUtils.preCheckCast(r4.f31058a, b.class, "com.obric.aiagent.plugin");
        o.a(r3);     // Catch: Throwable -> L16
    L58:
        if (r1.f == true) goto L60;
        return r7;
    L60:
        if (r1.b().J().e() == true) goto L71;
        com.obric.autogui.session.b.a r8 = r1.b().o();
        if (r8 == null) goto L72;
        r8.b("CALL_USER");
        return r7;
    L72:
        return r7;
    L71:
        return r7;
    L16:
        th = th;
    L56:
        Loog.INSTANCE.e(r1.a(), "[Auth] failed to restore fwk blacklist", th);
        goto L58
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        r0 = (b) ZeusTransformUtils.preCheckCast(r4.f31058a, b.class, "com.obric.aiagent.plugin");
        o.a(r3);
    L47:
        e r9 = (e) ZeusTransformUtils.preCheckCast(r3, e.class, "com.obric.aiagent.plugin");
    L48:
        e r10 = r9;
        r1 = r0;
        g r11 = g.f27362a;     // Catch: Throwable -> L54
        Context r12 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L54
        r4.f31058a = r1;     // Catch: Throwable -> L54
        r4.f31059b = r10;     // Catch: Throwable -> L54
        r4.f = 3;     // Catch: Throwable -> L54
        if (r11.a(r12, true, r4) != r5) goto L53;
        return r5;
    L53:
        r7 = r10;
    L54:
        th = th;
        r7 = r10;
        goto L56
    L21:
        String r13 = (String) ZeusTransformUtils.preCheckCast(r4.f31060c, String.class, "com.obric.aiagent.plugin");
        com.obric.autogui.session.a r14 = (com.obric.autogui.session.a) ZeusTransformUtils.preCheckCast(r4.f31059b, com.obric.autogui.session.a.class, "com.obric.aiagent.plugin");
        b r15 = (b) ZeusTransformUtils.preCheckCast(r4.f31058a, b.class, "com.obric.aiagent.plugin");
        o.a(r3);
        String r16 = r13;
        r0 = r15;
    L41:
        AppBlackListState r17 = (AppBlackListState) ZeusTransformUtils.preCheckCast(r3, AppBlackListState.class, "com.obric.aiagent.plugin");
        if (r17 != AppBlackListState.UserDefinedBlackList) goto L44;
        AppBlackListEventHolder.INSTANCE.setBlackListEvent(new AppBlackListEvent(new ComponentName(r16, "CallUser"), r17, 0, 0, false, 28, null));
        Loog.INSTANCE.i(r0.a(), " - [Auth] need re-grant: pkg=" + r16);
    L44:
        com.obric.autogui.session.state.b r18 = r14.m();
        BizStatus r19 = BizStatus.OPERATING;
        BizStatus.StatusChangedReasonStruct r20 = new BizStatus.StatusChangedReasonStruct(com.obric.autogui.session.state.a.h.b.f31243c.a(), null, null, null, 14, null);
        r4.f31058a = r0;
        r4.f31059b = null;
        r4.f31060c = null;
        r4.f = 2;
        r3 = r18.a(r19, r20, r4);
        if (r3 != r5) goto L47;
        return r5;
    L22:
        o.a(r3);
        Loog.INSTANCE.i(a(), "exiting CallUser mode.");
        r0.a(AOSystemTools.INSTANCE.nowTimeMillis());
        final long r110 = b().D().getLong("calluser_duration", 0) + d();
        b().D().putLong("calluser_duration", r110);
        b().J().a(new $$Lambda$b$uEvb6EO57NieNxEZf2ArLB6ouX4(r110));
        b().a(new $$Lambda$b$F2buGqXy6VRnOatIMTY_qqOGNU(r110));
        Loog.INSTANCE.i(a(), " - [CALL-USER] this session spent " + r110 + " ms in call user.");
        b().a(new $$Lambda$b$lMYTuC5HpPBv0aMO9zHUreo6nk(r0));
        r14 = b();
        if (r14 == null) goto L64;
        com.obric.autogui.a.a.a.f26091a.a("calluser stop");
        r0.f31050e.d();
        if (b().J().e() == true) goto L49;
        h();
        VDTrackingApp r21 = (VDTrackingApp) ZeusTransformUtils.preCheckCast(AutoActionAgent.INSTANCE.getTrackingApp().a(), VDTrackingApp.class, "com.obric.aiagent.plugin");
        if (r21 == null) goto L29;
        r16 = r21.getPackageName();
    L30:
        CharSequence r23 = (CharSequence) ZeusTransformUtils.preCheckCast(r16, CharSequence.class, "com.obric.aiagent.plugin");
        if (r23 != null) goto L33;
    L36:
        boolean r24 = true;
    L37:
        if (r24 == true) goto L44;
        g r25 = g.f27362a;
        Context r111 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        r4.f31058a = r0;
        r4.f31059b = r14;
        r4.f31060c = r16;
        r4.f = 1;
        r3 = r25.a(r111, r16, r4);
        if (r3 != r5) goto L41;
        return r5;
    L33:
        if (d.o.o.d(r23) == true) goto L36;
        r24 = false;
        goto L37
    L29:
        r16 = null;
        goto L30
    L49:
        r9 = e.f29014b.a();
        goto L48
    L64:
        Loog.INSTANCE.e(a(), "onStop, no ongoing session.");
        return e.f29014b.b("CallUser onStop, no ongoing session.");
    L7:
        r4 = new d(r0, r2);
        goto L8
    }

    private static final x a(long r1, Bundle r3) {
        d.h.b.o.e(r3, "$this$withTaskEndReports");
        r3.putLong("calluser_duration", r1);
        return x.f38692a;
    }

    private static final x a(long r2, r r4) {
        d.h.b.o.e(r4, "omniSession");
        com.obric.autogui.agents.vlm.models.omni.l r5 = r4.f();
        if (r5 == null) goto L10;
        com.obric.autogui.agents.vlm.models.omni.intent.g r6 = r5.a();
        if (r6 == null) goto L10;
        Long r7 = r6.a();
        if (r7 == null) goto L10;
        long r0 = ((Number) ZeusTransformUtils.preCheckCast(r7, Number.class, "com.obric.aiagent.plugin")).longValue();
        com.obric.autogui.session.functions.impl.b.a.f31063a.a(String.valueOf(r0), r2);
    L10:
        return x.f38692a;
    }

    private static final x a(b r1, r r2) {
        d.h.b.o.e(r2, "it");
        if (r1.f == false) goto L6;
        r.b(r2, null, null, 3, null);
    L6:
        return x.f38692a;
    }

    private final void a(long r13) {
        Loog.INSTANCE.i(a(), " - [CALL-USER/Exited] started=" + this.f31048c + ", entered=" + this.f31049d + ", exited=" + r13);
        long r0 = this.f31049d;
        long r2 = this.f31048c;
        int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 < r2) goto L5;
        long r3 = r0 - r2;
        long r14 = r13 - r0;
    L6:
        IAutoActionTrackingApi r5 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");
        JSONObject r6 = new JSONObject();
        r6.put("calluser_user_operation", r14);
        r6.put("calluser_await_user", r3);
        CallUserFunctionParams r15 = this.h;
        if (r15 == null) goto L9;
        String r16 = r15.getReason();
    L10:
        r6.put("calluser_reason", r16);
        com.obric.autogui.session.c.b.a(r6, b());
        x r12 = x.f38692a;
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r5, "met_calluser", r6, false, false, null, 28, null);
        return;
    L9:
        r16 = null;
        goto L10
    L5:
        r3 = r13 - r2;
        r14 = 0;
        goto L6
    }

    public final void a(d.h.a.a<Boolean> r3) {
        this.g = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
    }

    public final void a(CallUserFunctionParams r1) {
        this.h = r1;
    }

    public final CallUserFunctionParams f() {
        return this.h;
    }

    public final boolean g() {
        d.h.a.a<Boolean> r2 = this.g;
        if (r2 != null) goto L7;
        return true;
    L7:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r2.invoke(), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    }

    private final void h() {
        com.obric.autogui.agents.a r0 = com.obric.autogui.agents.b.f26789a.a();
        Object r1 = b().a(r0);
        if (ZeusTransformUtils.instanceOf(r1, com.obric.autogui.agents.vlm.b.C0677b.class) == false) goto L5;
        com.obric.autogui.agents.vlm.b.C0677b r2 = (com.obric.autogui.agents.vlm.b.C0677b) ZeusTransformUtils.preCheckCast(r1, com.obric.autogui.agents.vlm.b.C0677b.class, "com.obric.aiagent.plugin");
    L6:
        if (r2 != null) goto L8;
        return;
    L8:
        com.obric.autogui.agents.vlm.b.C0677b.a r3 = r2.o();
        com.obric.autogui.agents.vlm.b.C0677b.a.EnumC0679b r4 = com.obric.autogui.agents.vlm.b.C0677b.a.EnumC0679b.f27123c;
        String r5 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(b().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.agent_stepexec_calluser_operated, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_stepexec_calluser_operated"));
        d.h.b.o.c(r5, "getString(...)");
        r3.a(r4, r5);
        return;
    L5:
        r2 = null;
        goto L6
    }
}
