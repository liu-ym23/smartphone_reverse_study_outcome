package com.obric.autogui.session.functions.impl.a;

import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.agents.vlm.models.impl.applist.black.g;
import com.obric.autogui.agents.vlm.models.omni.r;
import com.obric.autogui.common.api.agent.AutoActionAgent;
import com.obric.autogui.common.api.agent.BizStatus;
import com.obric.autogui.common.api.agent.blacklist.AppBlackListEvent;
import com.obric.autogui.common.api.agent.blacklist.AppBlackListEventHolder;
import com.obric.autogui.common.api.agent.blacklist.AppBlackListState;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.virtualdisplay.AutoActionVirtualDisplay;
import com.obric.autogui.common.api.virtualdisplay.VDTrackingApp;
import com.obric.autogui.common.e;
import com.obric.autogui.session.state.a.i;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.f;
import d.h.b.h;
import d.o;
import d.x;

/* JADX INFO: compiled from: ManualOperatingFunction.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends com.obric.autogui.session.functions.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C0849a f31033b = null;

    /* JADX INFO: renamed from: com.obric.autogui.session.functions.impl.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ManualOperatingFunction.kt */
    public static final class C0849a {
        public /* synthetic */ C0849a(h r1) {
            this();
        }

        private C0849a() {
        }
    }

    /* JADX INFO: compiled from: ManualOperatingFunction.kt */
    @f(b = "ManualOperatingFunction.kt", c = {196}, d = "awaitMutualOperating", e = "com.obric.autogui.session.functions.impl.manual.ManualOperatingFunction")
    static final class b extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f31034a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f31035b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f31036c;

        b(a r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31035b = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f31034a = r3;
            this.f31036c |= Integer.MIN_VALUE;
            return a.a(this.f31035b, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: ManualOperatingFunction.kt */
    @f(b = "ManualOperatingFunction.kt", c = {67, 85, 108}, d = "onStart", e = "com.obric.autogui.session.functions.impl.manual.ManualOperatingFunction")
    static final class c extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f31037a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f31038b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f31039c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ a f31040d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f31041e;

        c(a r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31040d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f31039c = r3;
            this.f31041e |= Integer.MIN_VALUE;
            return this.f31040d.c((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: ManualOperatingFunction.kt */
    @f(b = "ManualOperatingFunction.kt", c = {145, 163, 174}, d = "onStop", e = "com.obric.autogui.session.functions.impl.manual.ManualOperatingFunction")
    static final class d extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f31042a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f31043b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f31044c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f31045d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ a f31046e;
        int f;

        d(a r3, d.c.d<? super d> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31046e = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f31045d = r3;
            this.f |= Integer.MIN_VALUE;
            return this.f31046e.d((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        f31033b = new C0849a(null);
    }

    /* JADX INFO: renamed from: lambda$B00s5jYxKFqntntt6ElC-_lZY5k, reason: not valid java name */
    public static /* synthetic */ x m891lambda$B00s5jYxKFqntntt6ElC_lZY5k(long r0, Bundle r2) {
        return a(r0, r2);
    }

    public static /* synthetic */ x lambda$ujDuy1MnCwE1wmIeV8oiMvOWKFE(r r0) {
        return a(r0);
    }

    public static /* synthetic */ x lambda$xXeTePs_TsPY7heexd1OYIhZuak(int r0, Bundle r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ x lambda$yoNbbq7DuEJZi3fDRK1yMb1MPME(r r0) {
        return b(r0);
    }

    public a() {
        super("ManualOperating");
    }

    public static final /* synthetic */ Object a(a r2, d.c.d r3) {
        return r2.e((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.autogui.session.functions.a
    public e c() {
        if (b().K() == true) goto L7;
        return e.f29014b.b("session is not running; cannot enter ManualOperating mode.");
    L7:
        if (b().J().a() == false) goto L11;
        Loog.INSTANCE.w("ManualOperating", "cannot start ManualOperating; reached end-step.");
        return e.f29014b.b("session reach end step; cannot enter ManualOperating mode.");
    L11:
        if (AutoActionVirtualDisplay.INSTANCE.getVdOperatingApp().a() != null) goto L15;
        return e.f29014b.b("no apps inside the VD; cannot enter ManualOperating mode.");
    L15:
        return super.c();
    }

    @Override // com.obric.autogui.session.functions.a
    public Object c(d.c.d<? super e> r18) {
        a r1 = this;
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r18, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r2, c.class) == false) goto L7;
        c r4 = (c) ZeusTransformUtils.preCheckCast(r2, c.class, "com.obric.aiagent.plugin");
        if ((r4.f31041e & Integer.MIN_VALUE) == 0) goto L7;
        r4.f31041e -= Integer.MIN_VALUE;
    L8:
        Object r3 = r4.f31039c;
        Object r5 = d.c.a.b.a();
        int r6 = r4.f31041e;
        if (r6 == 0) goto L24;
        if (r6 == 1) goto L21;
        if (r6 == 2) goto L20;
        if (r6 != 3) goto L19;
        r1 = (a) ZeusTransformUtils.preCheckCast(r4.f31037a, a.class, "com.obric.aiagent.plugin");
        o.a(r3);     // Catch: Throwable -> L16
    L50:
    L44:
        return e.f29014b.a();
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        com.obric.autogui.session.state.b r7 = (com.obric.autogui.session.state.b) ZeusTransformUtils.preCheckCast(r4.f31038b, com.obric.autogui.session.state.b.class, "com.obric.aiagent.plugin");
        a r0 = (a) ZeusTransformUtils.preCheckCast(r4.f31037a, a.class, "com.obric.aiagent.plugin");
        o.a(r3);
        r1 = r0;
    L31:
        e r8 = (e) ZeusTransformUtils.preCheckCast(r3, e.class, "com.obric.aiagent.plugin");
        if (r8.g() == true) goto L35;
        Loog.INSTANCE.e(r1.a(), " - [ManualOp] cannot trigger SM change for ManualOp: " + r8);
        return r8;
    L35:
        r1.b().a($$Lambda$a$ujDuy1MnCwE1wmIeV8oiMvOWKFE.INSTANCE);
        com.obric.autogui.session.b.a r9 = r1.b().o();
        if (r9 == null) goto L38;
        r9.a("MANUAL_OPERATING");
    L38:
        com.obric.autogui.a.a.a.f26091a.a(r1.b());
        g r10 = g.f27362a;     // Catch: Throwable -> L16
        Context r11 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L16
        r4.f31037a = r1;     // Catch: Throwable -> L16
        r4.f31038b = null;     // Catch: Throwable -> L16
        r4.f31041e = 3;     // Catch: Throwable -> L16
        if (r10.a(r11, false, r4) != r5) goto L50;
        return r5;
    L21:
        r1 = (a) ZeusTransformUtils.preCheckCast(r4.f31037a, a.class, "com.obric.aiagent.plugin");
        o.a(r3);     // Catch: Throwable -> L45
    L28:
        Loog.INSTANCE.i(r1.a(), "entering ManualOperating mode.");
        final int r12 = r1.b().D().getInt("manual_operating_times", 0) + 1;
        Loog.INSTANCE.i(r1.a(), " - [MANUAL_OPERATING_TIMES] this is the " + r12 + "-th manual_operating within this session.");
        r1.b().D().putInt("manual_operating_times", r12);
        r1.b().J().a(new $$Lambda$a$xXeTePs_TsPY7heexd1OYIhZuak(r12));
        com.obric.autogui.session.state.b r13 = r1.b().m();
        BizStatus r14 = BizStatus.PAUSED;
        BizStatus.StatusChangedReasonStruct r15 = new BizStatus.StatusChangedReasonStruct(i.b.f31251e.a(), null, null, null, 14, null);
        r4.f31037a = r1;
        r4.f31038b = r13;
        r4.f31041e = 2;
        r3 = r13.a(r14, r15, r4);
        if (r3 != r5) goto L31;
        return r5;
    L24:
        o.a(r3);
        r4.f31037a = r1;     // Catch: Throwable -> L45
        r4.f31041e = 1;     // Catch: Throwable -> L45
        if (r1.e(r4) != r5) goto L28;
        return r5;
    L45:
        th = move-exception;
        Loog.INSTANCE.e(r1.a(), "awaitMutualOperating failed.", th);
        return e.f29014b.b("awaitMutualOperating failed. ManualOperating not started.");
    L16:
        th = move-exception;
        Loog.INSTANCE.e(r1.a(), "[Auth] failed to relax fwk blacklist in manual stage", th);
    L7:
        r4 = new c(r1, r2);
        goto L8
    }

    private static final x a(int r1, Bundle r2) {
        d.h.b.o.e(r2, "$this$withTaskEndReports");
        r2.putInt("manual_operating_times", r1);
        return x.f38692a;
    }

    private static final x a(r r2) {
        d.h.b.o.e(r2, "omniActionsHolder");
        r.a(r2, null, null, 3, null);
        return x.f38692a;
    }

    @Override // com.obric.autogui.session.functions.a
    public Object d(d.c.d<? super e> r22) {
        a r0 = this;
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r22, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r2, d.class) == false) goto L7;
        d r4 = (d) ZeusTransformUtils.preCheckCast(r2, d.class, "com.obric.aiagent.plugin");
        if ((r4.f & Integer.MIN_VALUE) == 0) goto L7;
        r4.f -= Integer.MIN_VALUE;
    L8:
        Object r3 = r4.f31045d;
        Object r5 = d.c.a.b.a();
        int r6 = r4.f;
        if (r6 == 0) goto L22;
        if (r6 == 1) goto L21;
        if (r6 == 2) goto L20;
        if (r6 != 3) goto L19;
        e r7 = (e) ZeusTransformUtils.preCheckCast(r4.f31043b, e.class, "com.obric.aiagent.plugin");
        a r1 = (a) ZeusTransformUtils.preCheckCast(r4.f31042a, a.class, "com.obric.aiagent.plugin");
        o.a(r3);     // Catch: Throwable -> L16
    L56:
        if (r1.b().J().e() == true) goto L60;
        com.obric.autogui.session.b.a r8 = r1.b().o();
        if (r8 == null) goto L60;
        r8.b("MANUAL_OPERATING");
    L60:
        return r7;
    L16:
        th = th;
    L54:
        Loog.INSTANCE.e(r1.a(), "[Auth] failed to restore fwk blacklist", th);
        goto L56
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        r0 = (a) ZeusTransformUtils.preCheckCast(r4.f31042a, a.class, "com.obric.aiagent.plugin");
        o.a(r3);
    L45:
        e r9 = (e) ZeusTransformUtils.preCheckCast(r3, e.class, "com.obric.aiagent.plugin");
    L47:
        e r10 = r9;
        r1 = r0;
        g r11 = g.f27362a;     // Catch: Throwable -> L52
        Context r12 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L52
        r4.f31042a = r1;     // Catch: Throwable -> L52
        r4.f31043b = r10;     // Catch: Throwable -> L52
        r4.f = 3;     // Catch: Throwable -> L52
        if (r11.a(r12, true, r4) != r5) goto L51;
        return r5;
    L51:
        r7 = r10;
    L52:
        th = th;
        r7 = r10;
        goto L54
    L21:
        String r13 = (String) ZeusTransformUtils.preCheckCast(r4.f31044c, String.class, "com.obric.aiagent.plugin");
        com.obric.autogui.session.state.b r14 = (com.obric.autogui.session.state.b) ZeusTransformUtils.preCheckCast(r4.f31043b, com.obric.autogui.session.state.b.class, "com.obric.aiagent.plugin");
        a r15 = (a) ZeusTransformUtils.preCheckCast(r4.f31042a, a.class, "com.obric.aiagent.plugin");
        o.a(r3);
        String r16 = r13;
        r0 = r15;
    L39:
        AppBlackListState r17 = (AppBlackListState) ZeusTransformUtils.preCheckCast(r3, AppBlackListState.class, "com.obric.aiagent.plugin");
        if (r17 != AppBlackListState.UserDefinedBlackList) goto L42;
        AppBlackListEventHolder.INSTANCE.setBlackListEvent(new AppBlackListEvent(new ComponentName(r16, "ManualOperating"), r17, 0, 0, false, 28, null));
        Loog.INSTANCE.i(r0.a(), " - [Auth] need re-grant: pkg=" + r16);
    L42:
        BizStatus r18 = BizStatus.OPERATING;
        BizStatus.StatusChangedReasonStruct r19 = new BizStatus.StatusChangedReasonStruct(com.obric.autogui.session.state.a.h.b.f31245e.a(), null, null, null, 14, null);
        r4.f31042a = r0;
        r4.f31043b = null;
        r4.f31044c = null;
        r4.f = 2;
        r3 = r14.a(r18, r19, r4);
        if (r3 != r5) goto L45;
        return r5;
    L22:
        o.a(r3);
        Loog.INSTANCE.i(a(), "exiting ManualOperating mode.");
        com.obric.autogui.a.a.a.f26091a.a("ManualOperating");
        final long r110 = b().D().getLong("manual_operating_duration", 0) + d();
        b().D().putLong("manual_operating_duration", r110);
        b().J().a(new $$Lambda$a$B00s5jYxKFqntntt6ElC_lZY5k(r110));
        Loog.INSTANCE.i(a(), " - [MANUAL_OPERATING_DURATION] this session spent " + r110 + " ms in manual operating.");
        b().a($$Lambda$a$yoNbbq7DuEJZi3fDRK1yMb1MPME.INSTANCE);
        r14 = b().m();
        if (b().J().e() == true) goto L46;
        e();
        VDTrackingApp r20 = (VDTrackingApp) ZeusTransformUtils.preCheckCast(AutoActionAgent.INSTANCE.getTrackingApp().a(), VDTrackingApp.class, "com.obric.aiagent.plugin");
        if (r20 == null) goto L27;
        r16 = r20.getPackageName();
    L28:
        CharSequence r21 = (CharSequence) ZeusTransformUtils.preCheckCast(r16, CharSequence.class, "com.obric.aiagent.plugin");
        if (r21 != null) goto L31;
    L34:
        boolean r23 = true;
    L35:
        if (r23 == true) goto L42;
        g r24 = g.f27362a;
        Context r111 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        r4.f31042a = r0;
        r4.f31043b = r14;
        r4.f31044c = r16;
        r4.f = 1;
        r3 = r24.a(r111, r16, r4);
        if (r3 != r5) goto L39;
        return r5;
    L31:
        if (d.o.o.d(r21) == true) goto L34;
        r23 = false;
        goto L35
    L27:
        r16 = null;
        goto L28
    L46:
        r9 = e.f29014b.a();
    L7:
        r4 = new d(r0, r2);
        goto L8
    }

    private static final x a(long r1, Bundle r3) {
        d.h.b.o.e(r3, "$this$withTaskEndReports");
        r3.putLong("manual_operating_duration", r1);
        return x.f38692a;
    }

    private static final x b(r r2) {
        d.h.b.o.e(r2, "it");
        r.b(r2, null, null, 3, null);
        return x.f38692a;
    }

    private final Object e(d.c.d<? super x> r5) {
        d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r6, b.class) == false) goto L7;
        b r0 = (b) ZeusTransformUtils.preCheckCast(r6, b.class, "com.obric.aiagent.plugin");
        if ((r0.f31036c & Integer.MIN_VALUE) == 0) goto L7;
        r0.f31036c -= Integer.MIN_VALUE;
    L8:
        Object r4 = r0.f31034a;
        Object r7 = d.c.a.b.a();
        int r2 = r0.f31036c;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        o.a(r4);
    L18:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r4, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == false) goto L22;
        return x.f38692a;
    L22:
        return x.f38692a;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r4);
        com.obric.autogui.operator.a.b.a r8 = com.obric.autogui.operator.a.b.f29284a;
        r0.f31036c = 1;
        r4 = r8.a(r0);
        if (r4 != r7) goto L18;
        return r7;
    L7:
        r0 = new b(this, r6);
        goto L8
    }

    private final void e() {
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
        String r5 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(b().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.agent_stepexec_user_operated, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_stepexec_user_operated"));
        d.h.b.o.c(r5, "getString(...)");
        r3.a(r4, r5);
        return;
    L5:
        r2 = null;
        goto L6
    }
}
