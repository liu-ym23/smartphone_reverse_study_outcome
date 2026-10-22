package com.obric.autogui.session.functions.impl;

import android.os.Bundle;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.applog.IAppLog;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.agents.vlm.models.omni.intent.g;
import com.obric.autogui.agents.vlm.models.omni.l;
import com.obric.autogui.agents.vlm.models.omni.r;
import com.obric.autogui.common.api.AOBizTracking;
import com.obric.autogui.common.api.agent.BizStatus;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.tracking.IAutoActionTrackingApi;
import com.obric.autogui.common.e;
import com.obric.autogui.session.state.a.i;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.f;
import d.h.b.h;
import d.o;
import d.x;
import org.json.JSONObject;

/* JADX INFO: compiled from: UserAdditionFunction.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d extends com.obric.autogui.session.functions.a {
    private static final String TAG = "Fun-UserAddi";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f31084b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f31085c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f31086d;

    /* JADX INFO: compiled from: UserAdditionFunction.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: UserAdditionFunction.kt */
    @f(b = "UserAdditionFunction.kt", c = {78}, d = "onStart", e = "com.obric.autogui.session.functions.impl.UserAdditionFunction")
    static final class b extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f31087a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f31088b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ d f31089c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f31090d;

        b(d r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31089c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f31088b = r3;
            this.f31090d |= Integer.MIN_VALUE;
            return this.f31089c.c((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: UserAdditionFunction.kt */
    @f(b = "UserAdditionFunction.kt", c = {163}, d = "onStop", e = "com.obric.autogui.session.functions.impl.UserAdditionFunction")
    static final class c extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f31091a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d f31092b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f31093c;

        c(d r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31092b = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f31091a = r3;
            this.f31093c |= Integer.MIN_VALUE;
            return this.f31092b.d((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        f31084b = new a(null);
    }

    private static final String g() {
        return "- [UserAddition] user-addition=";
    }

    public static /* synthetic */ x lambda$9epCm0jDK2UDT9EZlGZD2St5ehw(long r0, Bundle r2) {
        return a(r0, r2);
    }

    /* JADX INFO: renamed from: lambda$ANDQGEFu7Z6O9wLWt_GO-f2DrJQ, reason: not valid java name */
    public static /* synthetic */ String m896lambda$ANDQGEFu7Z6O9wLWt_GOf2DrJQ() {
        return g();
    }

    /* JADX INFO: renamed from: lambda$DEsW2Imkq2d-LlagEn-AuXBAbIA, reason: not valid java name */
    public static /* synthetic */ x m897lambda$DEsW2Imkq2dLlagEnAuXBAbIA(long r0, r r2) {
        return a(r0, r2);
    }

    /* JADX INFO: renamed from: lambda$RLjB_PqezHcLQ9pU-D0IKA87F_U, reason: not valid java name */
    public static /* synthetic */ String m898lambda$RLjB_PqezHcLQ9pUD0IKA87F_U(String r0) {
        return b(r0);
    }

    /* JADX INFO: renamed from: lambda$kpjOVwfnrqGJTwcvn2-_Du0IxpU, reason: not valid java name */
    public static /* synthetic */ x m899lambda$kpjOVwfnrqGJTwcvn2_Du0IxpU(int r0, Bundle r1) {
        return a(r0, r1);
    }

    public d() {
        super("UserAddition");
    }

    public final void a(String r1) {
        this.f31086d = r1;
    }

    private final com.obric.autogui.session.state.a e() {
        return b().m().e();
    }

    private final e f() {
        com.obric.autogui.session.state.a r0 = e();
        if (r0.b() == BizStatus.OPERATING) goto L7;
        Loog.INSTANCE.w(TAG, "cannot start UserAddition; current-state: " + r0);
        return e.f29014b.a(ZeusTransformUtils.mapRes(R.string.agent_task_user_addition_not_supported_at_this_state, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_task_user_addition_not_supported_at_this_state"), "UserAddition is not supported at this state -- (" + r0.b() + ')');
    L7:
        if (b().J().a() == false) goto L11;
        Loog.INSTANCE.w(TAG, "cannot start UserAddition; reached end-step.");
        return e.f29014b.a(ZeusTransformUtils.mapRes(R.string.agent_task_user_addition_not_supported_task_is_ended, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_task_user_addition_not_supported_task_is_ended"), "UserAddition is not supported; the task has reached its end step.");
    L11:
        return e.f29014b.a();
    }

    @Override // com.obric.autogui.session.functions.a
    public Object c(d.c.d<? super e> r14) {
        d.c.d r15 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r14, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r15, b.class) == false) goto L7;
        b r0 = (b) ZeusTransformUtils.preCheckCast(r15, b.class, "com.obric.aiagent.plugin");
        if ((r0.f31090d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f31090d -= Integer.MIN_VALUE;
    L8:
        Object r16 = r0.f31088b;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f31090d;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        d this = (d) ZeusTransformUtils.preCheckCast(r0.f31087a, d.class, "com.obric.aiagent.plugin");
        o.a(r16);
    L20:
        e r17 = (e) ZeusTransformUtils.preCheckCast(r16, e.class, "com.obric.aiagent.plugin");
        if (r17.g() == true) goto L23;
        return r17;
    L23:
        this.f31085c = true;
        com.obric.autogui.a.a.a.f26091a.a(this.b());
        return e.f29014b.a();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r16);
        e r18 = f();
        if (r18.g() == true) goto L17;
        return r18;
    L17:
        Loog.INSTANCE.i(a(), "- [UserAddition] entering `PAUSE`...");
        com.obric.autogui.session.state.b r19 = b().m();
        BizStatus r4 = BizStatus.PAUSED;
        BizStatus.StatusChangedReasonStruct r12 = new BizStatus.StatusChangedReasonStruct(i.b.f31249c.a(), null, null, null, 14, null);
        r0.f31087a = this;
        r0.f31090d = 1;
        r16 = r19.a(r4, r12, r0);
        if (r16 != r2) goto L20;
        return r2;
    L7:
        r0 = new b(this, r15);
        goto L8
    }

    @Override // com.obric.autogui.session.functions.a
    public e c() {
        e r1 = f();
        if (r1.g() == true) goto L6;
        return r1;
    L6:
        return e.f29014b.a();
    }

    @Override // com.obric.autogui.session.functions.a
    public Object d(d.c.d<? super e> r20) {
        d.c.d r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r20, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r1, c.class) == false) goto L7;
        c r3 = (c) ZeusTransformUtils.preCheckCast(r1, c.class, "com.obric.aiagent.plugin");
        if ((r3.f31093c & Integer.MIN_VALUE) == 0) goto L7;
        r3.f31093c -= Integer.MIN_VALUE;
    L8:
        Object r2 = r3.f31091a;
        Object r4 = d.c.a.b.a();
        int r5 = r3.f31093c;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        o.a(r2);
    L33:
        e r0 = (e) ZeusTransformUtils.preCheckCast(r2, e.class, "com.obric.aiagent.plugin");
        if (r0.g() == true) goto L37;
        return r0;
    L37:
        return e.f29014b.a();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r2);
        Object r6 = b().a(com.obric.autogui.agents.b.f26789a.a());
        if (ZeusTransformUtils.instanceOf(r6, com.obric.autogui.agents.vlm.b.C0677b.class) == false) goto L17;
        com.obric.autogui.agents.vlm.b.C0677b r7 = (com.obric.autogui.agents.vlm.b.C0677b) ZeusTransformUtils.preCheckCast(r6, com.obric.autogui.agents.vlm.b.C0677b.class, "com.obric.aiagent.plugin");
    L18:
        if (r7 != null) goto L21;
        Loog.INSTANCE.e(a(), "- [UserAddition] failed to get extension for VLM. currently, only VLM supports UserAddition.");
        return e.a.a(e.f29014b, ZeusTransformUtils.mapRes(R.string.agent_task_user_addition_not_supported_at_this_state, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_task_user_addition_not_supported_at_this_state"), null, 2, null);
    L21:
        com.obric.autogui.a.a.a.f26091a.a("user-addition stop");
        final long r8 = b().D().getLong("user_addition_duration", 0) + d();
        b().D().putLong("user_addition_duration", r8);
        b().J().a(new $$Lambda$d$9epCm0jDK2UDT9EZlGZD2St5ehw(r8));
        b().a(new $$Lambda$d$DEsW2Imkq2dLlagEnAuXBAbIA(r8));
        Loog.INSTANCE.i(a(), " - [UserAddition] this session spent " + r8 + " ms in user-addition.");
        final String r9 = this.f31086d;
        CharSequence r10 = (CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin");
        if (r10 != null) goto L24;
    L27:
        boolean r11 = true;
    L28:
        if (r11 == true) goto L30;
        Loog.INSTANCE.dp(a(), new $$Lambda$d$RLjB_PqezHcLQ9pUD0IKA87F_U(r9), $$Lambda$d$ANDQGEFu7Z6O9wLWt_GOf2DrJQ.INSTANCE);
        r7.o().a(com.obric.autogui.agents.vlm.b.C0677b.a.EnumC0679b.f27121a, r9);
        IAutoActionTrackingApi r12 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");
        JSONObject r13 = new JSONObject();
        com.obric.autogui.session.c.b.a(r13, b());
        x r14 = x.f38692a;
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r12, "posted_user_addition", r13, false, false, null, 28, null);
        final int r15 = b().D().getInt("user_addition_times", 0) + 1;
        Loog.INSTANCE.i(TAG, " - [UserAddition] this is the " + r15 + "-th user-addition within this session.");
        b().D().putInt("user_addition_times", r15);
        b().J().a(new $$Lambda$d$kpjOVwfnrqGJTwcvn2_Du0IxpU(r15));
        a(r8);
    L30:
        Loog.INSTANCE.i(a(), "- [UserAddition] trying to resume job...");
        com.obric.autogui.session.state.b r16 = b().m();
        BizStatus.StatusChangedReasonStruct r17 = new BizStatus.StatusChangedReasonStruct(com.obric.autogui.session.state.a.h.b.f31244d.a(), this.f31086d, null, null, 12, null);
        r3.f31093c = 1;
        r2 = r16.a(r17, r3);
        if (r2 != r4) goto L33;
        return r4;
    L24:
        if (d.o.o.d(r10) == true) goto L27;
        r11 = false;
        goto L28
    L17:
        r7 = null;
    L7:
        r3 = new c(this, r1);
        goto L8
    }

    private static final x a(long r1, Bundle r3) {
        d.h.b.o.e(r3, "$this$withTaskEndReports");
        r3.putLong("user_addition_duration", r1);
        return x.f38692a;
    }

    private static final x a(long r2, r r4) {
        d.h.b.o.e(r4, "omniSession");
        l r5 = r4.f();
        if (r5 == null) goto L10;
        g r6 = r5.a();
        if (r6 == null) goto L10;
        Long r7 = r6.a();
        if (r7 == null) goto L10;
        long r0 = ((Number) ZeusTransformUtils.preCheckCast(r7, Number.class, "com.obric.aiagent.plugin")).longValue();
        com.obric.autogui.session.functions.impl.b.a.f31063a.c(String.valueOf(r0), r2);
    L10:
        return x.f38692a;
    }

    private static final String b(String r2) {
        return "- [UserAddition] user-addition=" + r2;
    }

    private static final x a(int r1, Bundle r2) {
        d.h.b.o.e(r2, "$this$withTaskEndReports");
        r2.putInt("user_addition_times", r1);
        return x.f38692a;
    }

    private final void a(long r12) {
        IAutoActionTrackingApi r3 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");
        JSONObject r5 = new JSONObject();
        r5.put("duration", r12);
        IAppLog r13 = (IAppLog) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppLog.class), IAppLog.class, "com.obric.aiagent.plugin");
        if (r13 == null) goto L5;
        String r14 = r13.getFlowDid();
    L6:
        r5.put("device_id", r14);
        com.obric.autogui.session.c.b.a(r5, b());
        x r11 = x.f38692a;
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r3, "obric_omni_user_addition_finish", r5, false, false, null, 16, null);
        return;
    L5:
        r14 = null;
        goto L6
    }
}
