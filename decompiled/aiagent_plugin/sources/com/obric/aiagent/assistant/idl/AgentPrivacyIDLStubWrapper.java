package com.obric.aiagent.assistant.idl;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes2.dex */
class AgentPrivacyIDLStubWrapper extends IAgentPrivacyIDL.Stub {
    boolean log;
    final IAgentPrivacyIDL.Stub origin;

    AgentPrivacyIDLStubWrapper(IAgentPrivacyIDL.Stub r2) {
        this(r2, true);
    }

    AgentPrivacyIDLStubWrapper(IAgentPrivacyIDL.Stub r1, boolean r2) {
        this.origin = r1;
        this.log = r2;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentPrivacyIDL
    public String getPemCertChain(String r23, String r24) {
        long r7 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("AgentPrivacyIDLStub", "getPemCertChain(" + r23 + ", " + r24 + ")", e);
        com.obric.aiagent.ipc.utils.g r3 = new com.obric.aiagent.ipc.utils.g(e);
        long r19 = SystemClock.elapsedRealtimeNanos();
        long r6 = Math.max(0, r19 - r7) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentPrivacyIDLStub", "getPemCertChain(" + r23 + ", " + r24 + ") = fail", r3, r6);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentPrivacyIDLStub", "getPemCertChain", r3, r6, r19);
        throw r3;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AgentPrivacyIDLStub", "getPemCertChain(" + r23 + ", " + r24 + ")");     // Catch: Exception -> L11
    L6:
        String r13 = this.origin.getPemCertChain(r23, r24);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AgentPrivacyIDLStub", "getPemCertChain = " + r13);     // Catch: Exception -> L11
    L9:
        long r20 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r20 - r7) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentPrivacyIDLStub", "getPemCertChain(" + r23 + ", " + r24 + ") = " + r13, r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentPrivacyIDLStub", "getPemCertChain", r14, r20);     // Catch: Exception -> L11
        return r13;
    }
}
