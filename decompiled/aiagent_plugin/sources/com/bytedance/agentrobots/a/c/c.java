package com.bytedance.agentrobots.a.c;

import com.obric.security.agentmanager.AgentProof;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ObricAgentProofAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public class c implements com.bytedance.agentrobots.a.a.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AgentProof f3993a;

    public c(AgentProof r3) {
        this.f3993a = (AgentProof) ZeusTransformUtils.wrapperContextForParams(r3, AgentProof.class, "com.obric.aiagent.plugin");
    }

    @Override // com.bytedance.agentrobots.a.a.c
    public String a() {
        return this.f3993a.getAgentUuid();
    }

    @Override // com.bytedance.agentrobots.a.a.c
    public byte[] b() {
        return this.f3993a.getAgentData();
    }

    @Override // com.bytedance.agentrobots.a.a.c
    public byte[] c() {
        return this.f3993a.getAgentHash();
    }

    @Override // com.bytedance.agentrobots.a.a.c
    public byte[] d() {
        return this.f3993a.getDeviceStatus();
    }

    @Override // com.bytedance.agentrobots.a.a.c
    public byte[] e() {
        return this.f3993a.getCertChain();
    }

    @Override // com.bytedance.agentrobots.a.a.c
    public byte[] f() {
        return this.f3993a.getSignature();
    }
}
