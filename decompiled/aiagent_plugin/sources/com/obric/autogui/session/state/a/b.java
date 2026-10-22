package com.obric.autogui.session.state.a;

import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.common.api.agent.remote.IAutoActionRemoteAgentApi;
import com.obric.autogui.common.api.logging.LogUtil;
import com.obric.autogui.common.api.logging.Loog;
import com.ss.android.ugc.aweme.framework.services.DynamicProxy;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AutoActionRemoteAgent.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b implements IAutoActionRemoteAgentApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f31222a = null;

    /* JADX INFO: compiled from: AutoActionRemoteAgent.kt */
    @d.c.b.a.f(b = "AutoActionRemoteAgent.kt", c = {45}, d = "checkNetworkLinkage", e = "com.obric.autogui.session.state.impl.AutoActionRemoteAgent")
    static final class a extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f31223a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f31224b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ b f31225c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f31226d;

        a(b r3, d.c.d<? super a> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31225c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f31224b = r3;
            this.f31226d |= Integer.MIN_VALUE;
            return this.f31225c.checkNetworkLinkage((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.autogui.session.state.a.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AutoActionRemoteAgent.kt */
    @d.c.b.a.f(b = "AutoActionRemoteAgent.kt", c = {36}, d = "enterQueueState", e = "com.obric.autogui.session.state.impl.AutoActionRemoteAgent")
    static final class C0854b extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f31227a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f31228b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f31229c;

        C0854b(b r3, d.c.d<? super C0854b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31228b = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f31227a = r3;
            this.f31229c |= Integer.MIN_VALUE;
            return this.f31228b.enterQueueState(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        f31222a = new b();
    }

    private b() {
    }

    private final IAutoActionRemoteAgentApi a() {
        IAutoActionRemoteAgentApi r0 = (IAutoActionRemoteAgentApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAutoActionRemoteAgentApi.class), IAutoActionRemoteAgentApi.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
    L7:
        Loog.INSTANCE.e(LogUtil.INSTANCE.getCLAZZ_TAG(this), "cannot acquire remote-agent API.");
        return null;
    L5:
        if (ZeusTransformUtils.instanceOf(r0, DynamicProxy.class) == true) goto L7;
        return r0;
    }

    static /* synthetic */ com.obric.autogui.common.e a(b r0, int r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = ZeusTransformUtils.mapRes(R.string.agent_internal_error, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_internal_error");
    L6:
        return r0.a(r1);
    }

    private final com.obric.autogui.common.e a(int r3) {
        return new com.obric.autogui.common.e(false, "", r3);
    }

    @Override // com.obric.autogui.common.api.agent.remote.IAutoActionRemoteAgentApi
    public Object enterQueueState(IAutoActionRemoteAgentApi.QueueStateUpdateListener r8, d.c.d<? super IAutoActionRemoteAgentApi.QueueStateEnteringResult> r9) {
        IAutoActionRemoteAgentApi.QueueStateUpdateListener r10 = (IAutoActionRemoteAgentApi.QueueStateUpdateListener) ZeusTransformUtils.wrapperContextForParams(r8, IAutoActionRemoteAgentApi.QueueStateUpdateListener.class, "com.obric.aiagent.plugin");
        d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r11, C0854b.class) == false) goto L7;
        C0854b r0 = (C0854b) ZeusTransformUtils.preCheckCast(r11, C0854b.class, "com.obric.aiagent.plugin");
        if ((r0.f31229c & Integer.MIN_VALUE) == 0) goto L7;
        r0.f31229c -= Integer.MIN_VALUE;
    L8:
        Object r12 = r0.f31227a;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f31229c;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        d.o.a(r12);
    L19:
        IAutoActionRemoteAgentApi.QueueStateEnteringResult r7 = (IAutoActionRemoteAgentApi.QueueStateEnteringResult) ZeusTransformUtils.preCheckCast(r12, IAutoActionRemoteAgentApi.QueueStateEnteringResult.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L23;
        return r7;
    L23:
        return new IAutoActionRemoteAgentApi.QueueStateEnteringResult(IAutoActionRemoteAgentApi.ErrorType.ClientError, null, false, 0, 14, null);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r12);
        IAutoActionRemoteAgentApi r13 = a();
        if (r13 == null) goto L23;
        r0.f31229c = 1;
        r12 = r13.enterQueueState(r10, r0);
        if (r12 != r2) goto L19;
        return r2;
    L7:
        r0 = new C0854b(this, r11);
        goto L8
    }

    @Override // com.obric.autogui.common.api.agent.remote.IAutoActionRemoteAgentApi
    public Object checkNetworkLinkage(d.c.d<? super com.obric.autogui.common.e> r6) {
        d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r7, a.class) == false) goto L7;
        a r0 = (a) ZeusTransformUtils.preCheckCast(r7, a.class, "com.obric.aiagent.plugin");
        if ((r0.f31226d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f31226d -= Integer.MIN_VALUE;
    L8:
        Object r8 = r0.f31224b;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f31226d;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        b this = (b) ZeusTransformUtils.preCheckCast(r0.f31223a, b.class, "com.obric.aiagent.plugin");
        d.o.a(r8);
    L19:
        com.obric.autogui.common.e r9 = (com.obric.autogui.common.e) ZeusTransformUtils.preCheckCast(r8, com.obric.autogui.common.e.class, "com.obric.aiagent.plugin");
        if (r9 == null) goto L23;
        return r9;
    L23:
        return a(this, 0, 1, null);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r8);
        IAutoActionRemoteAgentApi r10 = a();
        if (r10 == null) goto L23;
        r0.f31223a = this;
        r0.f31226d = 1;
        r8 = r10.checkNetworkLinkage(r0);
        if (r8 != r2) goto L19;
        return r2;
    L7:
        r0 = new a(this, r7);
        goto L8
    }
}
