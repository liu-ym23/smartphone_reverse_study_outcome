package com.bytedance.agentrobots.a.b;

import com.aiassistant.security.agentmanager.AgentProof;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AssistantAgentProofAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public class c implements com.bytedance.agentrobots.a.a.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AgentProof f3989a;

    public c(AgentProof r3) {
        this.f3989a = (AgentProof) ZeusTransformUtils.wrapperContextForParams(r3, AgentProof.class, "com.obric.aiagent.plugin");
    }

    @Override // com.bytedance.agentrobots.a.a.c
    public String a() {
        return this.f3989a.getAgentUuid();
    }

    @Override // com.bytedance.agentrobots.a.a.c
    public byte[] b() {
        return this.f3989a.getAgentData();
    }

    @Override // com.bytedance.agentrobots.a.a.c
    public byte[] c() {
        return this.f3989a.getAgentHash();
    }

    @Override // com.bytedance.agentrobots.a.a.c
    public byte[] d() {
        return this.f3989a.getDeviceStatus();
    }

    @Override // com.bytedance.agentrobots.a.a.c
    public byte[] e() {
        return this.f3989a.getCertChain();
    }

    @Override // com.bytedance.agentrobots.a.a.c
    public byte[] f() {
        return this.f3989a.getSignature();
    }
}
