package com.obric.autogui.session.state.a;

import com.obric.autogui.common.api.agent.remote.IAutoActionRemoteAgentApi;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AADebugRemoteAgentImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a implements IAutoActionRemoteAgentApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IAutoActionRemoteAgentApi.QueueStateUpdateListener f31221a;

    public a() {
    }

    @Override // com.obric.autogui.common.api.agent.remote.IAutoActionRemoteAgentApi
    public Object enterQueueState(IAutoActionRemoteAgentApi.QueueStateUpdateListener r8, d.c.d<? super IAutoActionRemoteAgentApi.QueueStateEnteringResult> r9) {
        IAutoActionRemoteAgentApi.QueueStateUpdateListener r10 = (IAutoActionRemoteAgentApi.QueueStateUpdateListener) ZeusTransformUtils.wrapperContextForParams(r8, IAutoActionRemoteAgentApi.QueueStateUpdateListener.class, "com.obric.aiagent.plugin");
        d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
        this.f31221a = r10;
        return new IAutoActionRemoteAgentApi.QueueStateEnteringResult(null, "test-session-id", true, 0, 9, null);
    }

    @Override // com.obric.autogui.common.api.agent.remote.IAutoActionRemoteAgentApi
    public Object checkNetworkLinkage(d.c.d<? super com.obric.autogui.common.e> r2) {
        d.c.d r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin");
        return com.obric.autogui.session.state.c.f31395a.a();
    }
}
