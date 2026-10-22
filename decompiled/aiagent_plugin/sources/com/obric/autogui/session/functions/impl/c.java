package com.obric.autogui.session.functions.impl;

import android.os.Bundle;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.agents.vlm.models.omni.intent.g;
import com.obric.autogui.agents.vlm.models.omni.r;
import com.obric.autogui.common.api.AOBizTracking;
import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.agent.BizStatus;
import com.obric.autogui.common.api.agent.model.ClarifyFunctionParams;
import com.obric.autogui.common.api.logging.LogUtil;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.tracking.IAutoActionTrackingApi;
import com.obric.autogui.common.e;
import com.obric.autogui.session.state.a.i;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.c.b.a.f;
import d.c.b.a.l;
import d.h.a.m;
import d.h.b.h;
import d.n;
import d.o;
import d.s;
import d.x;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: ClarifyFunction.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c extends com.obric.autogui.session.functions.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f31068b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f31069c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f31070d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ConcurrentHashMap<String, Object> f31071e;
    private ClarifyFunctionParams f;
    private String g;
    private Map<String, String> h;
    private final com.obric.autogui.session.functions.impl.a i;
    private m<? super com.obric.autogui.session.a, ? super String, Boolean> j;

    /* JADX INFO: compiled from: ClarifyFunction.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: ClarifyFunction.kt */
    @f(b = "ClarifyFunction.kt", c = {}, d = "invokeSuspend", e = "com.obric.autogui.session.functions.impl.ClarifyFunction$mAutoCancelHelper$1")
    static final class b extends l implements d.h.a.b<d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f31072a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ c f31073b;

        b(c r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31073b = r3;
            super(1, r5);
        }

        public final Object a(d.c.d<? super x> r3) {
            return ((b) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.f31073b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d.c.d<? super x> r3) {
            return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            d.c.a.b.a();
            if (this.f31072a != 0) goto L7;
            o.a(r8);
            Loog.INSTANCE.w(c.a(this.f31073b), " - [UserClarify] auto-cancelled!");
            com.obric.autogui.session.state.termination.a.a(this.f31073b.b().J(), e.a.a(e.f29014b, ZeusTransformUtils.mapRes(R.string.agent_task_terminated_unconfirmed_for_too_long, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_task_terminated_unconfirmed_for_too_long"), null, 2, null), 112004, null, null, 12, null);
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.obric.autogui.session.functions.impl.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ClarifyFunction.kt */
    @f(b = "ClarifyFunction.kt", c = {95}, d = "onStart", e = "com.obric.autogui.session.functions.impl.ClarifyFunction")
    static final class C0852c extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f31074a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f31075b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f31076c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ c f31077d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f31078e;

        C0852c(c r3, d.c.d<? super C0852c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31077d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f31076c = r3;
            this.f31078e |= Integer.MIN_VALUE;
            return this.f31077d.c((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: ClarifyFunction.kt */
    @f(b = "ClarifyFunction.kt", c = {163}, d = "onStop", e = "com.obric.autogui.session.functions.impl.ClarifyFunction")
    static final class d extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f31079a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f31080b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f31081c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ c f31082d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f31083e;

        d(c r3, d.c.d<? super d> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31082d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f31081c = r3;
            this.f31083e |= Integer.MIN_VALUE;
            return this.f31082d.d((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        f31068b = new a(null);
    }

    /* JADX INFO: renamed from: lambda$00RBHKojGru7rrB-pif1KcSlO80, reason: not valid java name */
    public static /* synthetic */ x m894lambda$00RBHKojGru7rrBpif1KcSlO80(long r0, Bundle r2) {
        return a(r0, r2);
    }

    public static /* synthetic */ x lambda$1Ll40lXRHFdZJVLEsPXqh2rtnvM(int r0, Bundle r1) {
        return a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$V9AhUpPTDQtu-t3xKDi9DLwbbkE, reason: not valid java name */
    public static /* synthetic */ x m895lambda$V9AhUpPTDQtut3xKDi9DLwbbkE(long r0, r r2) {
        return a(r0, r2);
    }

    public static /* synthetic */ String lambda$nxJ20iaJE1DTzM4njEBY8YG9U0M(String r0) {
        return d(r0);
    }

    public c() {
        super("Clarify");
        this.f31071e = new ConcurrentHashMap();
        this.h = ao.b();
        this.i = new com.obric.autogui.session.functions.impl.a((com.obric.autogui.session.functions.a) ZeusTransformUtils.preCheckCast(this, com.obric.autogui.session.functions.a.class, "com.obric.aiagent.plugin"), 600000, (d.h.a.b) ZeusTransformUtils.preCheckCast(new b(this, null), d.h.a.b.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ String a(c r0) {
        return r0.a();
    }

    public final void a(String r1) {
        this.f31070d = r1;
    }

    public final ConcurrentHashMap<String, Object> e() {
        return this.f31071e;
    }

    public final void a(ClarifyFunctionParams r1) {
        this.f = r1;
    }

    public final void b(String r1) {
        this.g = r1;
    }

    public final void a(Map<String, String> r3) {
        Map<String, String> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "<set-?>");
        this.h = r4;
    }

    @Override // com.obric.autogui.session.functions.a
    public Object c(d.c.d<? super e> r13) {
        d.c.d r14 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r13, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r14, C0852c.class) == false) goto L7;
        C0852c r0 = (C0852c) ZeusTransformUtils.preCheckCast(r14, C0852c.class, "com.obric.aiagent.plugin");
        if ((r0.f31078e & Integer.MIN_VALUE) == 0) goto L7;
        r0.f31078e -= Integer.MIN_VALUE;
    L8:
        Object r15 = r0.f31076c;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f31078e;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        com.obric.autogui.session.a r12 = (com.obric.autogui.session.a) ZeusTransformUtils.preCheckCast(r0.f31075b, com.obric.autogui.session.a.class, "com.obric.aiagent.plugin");
        c r1 = (c) ZeusTransformUtils.preCheckCast(r0.f31074a, c.class, "com.obric.aiagent.plugin");
        o.a(r15);
    L20:
        e r16 = (e) ZeusTransformUtils.preCheckCast(r15, e.class, "com.obric.aiagent.plugin");
        if (r16.g() == false) goto L25;
        com.obric.autogui.a.a.a.f26091a.a(r12);
        r1.i.c();
        return r16;
    L25:
        return r16;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r15);
        Loog.INSTANCE.i(a(), "entering Clarify mode.");
        com.obric.autogui.session.a r17 = b();
        if (r17 == null) goto L23;
        this.f31069c = AOSystemTools.INSTANCE.nowTimeMillis();
        final int r4 = b().D().getInt("clarify_times", 0) + 1;
        Loog.INSTANCE.i(a(), " - [CLARIFY] this is the " + r4 + "-th clarify within this session.");
        b().D().putInt("clarify_times", r4);
        b().J().a(new $$Lambda$c$1Ll40lXRHFdZJVLEsPXqh2rtnvM(r4));
        com.obric.autogui.session.state.b r5 = r17.m();
        BizStatus r6 = BizStatus.PAUSED;
        BizStatus.StatusChangedReasonStruct r7 = new BizStatus.StatusChangedReasonStruct(i.b.f31250d.a(), this.g, this.f, this.h);
        r0.f31074a = this;
        r0.f31075b = r17;
        r0.f31078e = 1;
        Object r8 = r5.a(r6, r7, r0);
        if (r8 != r2) goto L19;
        return r2;
    L19:
        r1 = this;
        r12 = r17;
        r15 = r8;
        goto L20
    L23:
        Loog.INSTANCE.e(a(), "onStart, no ongoing session.");
        return e.f29014b.b("Clarify onStart, no ongoing session.");
    L7:
        r0 = new C0852c(this, r14);
        goto L8
    }

    private static final x a(int r1, Bundle r2) {
        d.h.b.o.e(r2, "$this$withTaskEndReports");
        r2.putInt("clarify_times", r1);
        return x.f38692a;
    }

    @Override // com.obric.autogui.session.functions.a
    public e c() {
        if (b() != null) goto L7;
        Loog.INSTANCE.e(a(), "canStart, no ongoing session.");
        return e.f29014b.b("Clarify canStart, no ongoing session.");
    L7:
        return e.f29014b.a();
    }

    @Override // com.obric.autogui.session.functions.a
    public Object d(d.c.d<? super e> r14) {
        d.c.d r15 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r14, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r15, d.class) == false) goto L7;
        d r0 = (d) ZeusTransformUtils.preCheckCast(r15, d.class, "com.obric.aiagent.plugin");
        if ((r0.f31083e & Integer.MIN_VALUE) == 0) goto L7;
        r0.f31083e -= Integer.MIN_VALUE;
    L8:
        Object r16 = r0.f31081c;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f31083e;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        String r13 = (String) ZeusTransformUtils.preCheckCast(r0.f31080b, String.class, "com.obric.aiagent.plugin");
        c r1 = (c) ZeusTransformUtils.preCheckCast(r0.f31079a, c.class, "com.obric.aiagent.plugin");
        o.a(r16);
        String r4 = r13;
        c this = r1;
    L27:
        e r17 = (e) ZeusTransformUtils.preCheckCast(r16, e.class, "com.obric.aiagent.plugin");
        this.c(r4);
        if (r17.g() == true) goto L31;
        return r17;
    L31:
        return e.f29014b.a();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r16);
        Object r18 = b().a(com.obric.autogui.agents.b.f26789a.a());
        if (ZeusTransformUtils.instanceOf(r18, com.obric.autogui.agents.vlm.b.C0677b.class) == false) goto L17;
        com.obric.autogui.agents.vlm.b.C0677b r19 = (com.obric.autogui.agents.vlm.b.C0677b) ZeusTransformUtils.preCheckCast(r18, com.obric.autogui.agents.vlm.b.C0677b.class, "com.obric.aiagent.plugin");
    L18:
        if (r19 != null) goto L21;
        Loog.INSTANCE.e(a(), "- [UserClarify] failed to get extension for VLM. currently, only VLM supports UserClarify.");
        return e.a.a(e.f29014b, ZeusTransformUtils.mapRes(R.string.agent_task_user_addition_not_supported_at_this_state, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_task_user_addition_not_supported_at_this_state"), null, 2, null);
    L21:
        com.obric.autogui.a.a.a.f26091a.a("user-addition stop");
        this.i.d();
        final long r5 = b().D().getLong("clarify_duration", 0) + d();
        b().D().putLong("clarify_duration", r5);
        b().J().a(new $$Lambda$c$00RBHKojGru7rrBpif1KcSlO80(r5));
        Loog.INSTANCE.i(a(), " - [CLARIFY] this session spent " + r5 + " ms in clarify.");
        r4 = this.f31070d;
        if (r4 == null) goto L24;
        a(r19, r4);
    L24:
        Loog.INSTANCE.i(a(), "- [UserClarify] try to resume job...");
        com.obric.autogui.session.state.b r110 = b().m();
        BizStatus.StatusChangedReasonStruct r12 = new BizStatus.StatusChangedReasonStruct(com.obric.autogui.session.state.a.h.b.f31242b.a(), this.f31070d, null, null, 12, null);
        r0.f31079a = this;
        r0.f31080b = r4;
        r0.f31083e = 1;
        r16 = r110.a(r12, r0);
        if (r16 != r2) goto L27;
        return r2;
    L17:
        r19 = null;
    L7:
        r0 = new d(this, r15);
        goto L8
    }

    private static final x a(long r1, Bundle r3) {
        d.h.b.o.e(r3, "$this$withTaskEndReports");
        r3.putLong("clarify_duration", r1);
        return x.f38692a;
    }

    private final void c(String r15) {
        if (b().m().e().b() != BizStatus.TERMINATED) goto L9;
        com.obric.autogui.session.state.a.l r16 = (com.obric.autogui.session.state.a.l) ZeusTransformUtils.preCheckCast(b().m().a(BizStatus.TERMINATED), com.obric.autogui.session.state.a.l.class, "com.obric.aiagent.plugin");
        if (r16 == null) goto L7;
        int r17 = r16.a();
    L8:
        d.m r18 = s.a("failed", Integer.valueOf(r17));
    L10:
        String r0 = (String) ZeusTransformUtils.preCheckCast(r18.c(), String.class, "com.obric.aiagent.plugin");
        Integer r19 = (Integer) ZeusTransformUtils.preCheckCast(r18.d(), Integer.class, "com.obric.aiagent.plugin");
        n.a r2 = n.f38560a;     // Catch: Throwable -> L17
        c r3 = (c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L17
        final long r4 = AOSystemTools.INSTANCE.nowTimeMillis() - r3.f31069c;     // Catch: Throwable -> L17
        IAutoActionTrackingApi r6 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L17
        JSONObject r8 = new JSONObject();     // Catch: Throwable -> L17
        r8.put("duration", r4);     // Catch: Throwable -> L17
        r8.put("result", r0);     // Catch: Throwable -> L17
        r8.put("fail_reason", r19);     // Catch: Throwable -> L17
        com.obric.autogui.session.c.b.a(r8, r3.b());     // Catch: Throwable -> L17
        Iterator r110 = ((Map) ZeusTransformUtils.preCheckCast(r3.f31071e, Map.class, "com.obric.aiagent.plugin")).entrySet().iterator();     // Catch: Throwable -> L17
    L13:
        if (r110.hasNext() == false) goto L15;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r110.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L17
        r8.put((String) ZeusTransformUtils.preCheckCast(r1.getKey(), String.class, "com.obric.aiagent.plugin"), r1.getValue());     // Catch: Throwable -> L17
        goto L13
    L15:
        x r111 = x.f38692a;     // Catch: Throwable -> L17
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r6, "posted_clarify", r8, false, false, null, 28, null);     // Catch: Throwable -> L17
        r3.b().a(new $$Lambda$c$V9AhUpPTDQtut3xKDi9DLwbbkE(r4));     // Catch: Throwable -> L17
        Object r112 = n.f(x.f38692a);     // Catch: Throwable -> L17
    L19:
        Throwable r113 = n.c(r112);
        if (r113 == null) goto L26;
        Loog.INSTANCE.e(LogUtil.INSTANCE.getCLAZZ_TAG(this), "failed to report clarify result: " + r113);
        return;
    L26:
        return;
    L17:
        th = move-exception;
        n.a r5 = n.f38560a;
        r112 = n.f(o.a(th));
        goto L19
    L7:
        r17 = -1;
        goto L8
    L9:
        r18 = s.a("success", null);
        goto L10
    }

    private static final x a(long r2, r r4) {
        d.h.b.o.e(r4, "omniSession");
        com.obric.autogui.agents.vlm.models.omni.l r5 = r4.f();
        if (r5 == null) goto L10;
        g r6 = r5.a();
        if (r6 == null) goto L10;
        Long r7 = r6.a();
        if (r7 == null) goto L10;
        long r0 = ((Number) ZeusTransformUtils.preCheckCast(r7, Number.class, "com.obric.aiagent.plugin")).longValue();
        com.obric.autogui.session.functions.impl.b.a.f31063a.b(String.valueOf(r0), r2);
    L10:
        return x.f38692a;
    }

    public final void a(m<? super com.obric.autogui.session.a, ? super String, Boolean> r3) {
        this.j = (m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.aiagent.plugin");
    }

    private final void a(com.obric.autogui.agents.vlm.b.C0677b r5, final String r6) {
        m<? super com.obric.autogui.session.a, ? super String, Boolean> r0 = this.j;
        Loog.INSTANCE.dp(a(), new $$Lambda$c$nxJ20iaJE1DTzM4njEBY8YG9U0M(r6));
        if (r0 == null) goto L9;
        if (((Boolean) ZeusTransformUtils.preCheckCast(r0.invoke(r5.a(), r6), Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == true) goto L9;
        Loog.INSTANCE.w(a(), "- [UserClarify] Intercepted before being sent to Model.");
        return;
    L9:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L12;
        r5.o().a(com.obric.autogui.agents.vlm.b.C0677b.a.EnumC0679b.f27122b, r6);
        return;
    }

    private static final String d(String r2) {
        return "- [UserClarify] ClarifiedText=" + r2;
    }
}
