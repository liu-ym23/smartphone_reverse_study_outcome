package com.bytedance.agentrobots.a.b;

import com.aiassistant.security.agentmanager.AgentProof;
import com.aiassistant.security.agentmanager.AgentRegRes;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AssistantAgentRegResAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public class d implements com.bytedance.agentrobots.a.a.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AgentRegRes f3990a;

    public d(AgentRegRes r3) {
        this.f3990a = (AgentRegRes) ZeusTransformUtils.wrapperContextForParams(r3, AgentRegRes.class, "com.obric.aiagent.plugin");
    }

    @Override // com.bytedance.agentrobots.a.a.d
    public int a() {
        return this.f3990a.getResultCode();
    }

    @Override // com.bytedance.agentrobots.a.a.d
    public com.bytedance.agentrobots.a.a.c b() {
        AgentProof r1 = this.f3990a.getAgentProof();
        if (r1 != null) goto L7;
        return null;
    L7:
        return new c(r1);
    }
}
