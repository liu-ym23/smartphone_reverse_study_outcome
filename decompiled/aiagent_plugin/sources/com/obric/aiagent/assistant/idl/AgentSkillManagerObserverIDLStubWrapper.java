package com.obric.aiagent.assistant.idl;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes2.dex */
class AgentSkillManagerObserverIDLStubWrapper extends IAgentSkillManagerObserverIDL.Stub {
    boolean log;
    final IAgentSkillManagerObserverIDL.Stub origin;

    AgentSkillManagerObserverIDLStubWrapper(IAgentSkillManagerObserverIDL.Stub r2) {
        this(r2, true);
    }

    AgentSkillManagerObserverIDLStubWrapper(IAgentSkillManagerObserverIDL.Stub r1, boolean r2) {
        this.origin = r1;
        this.log = r2;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentSkillManagerObserverIDL
    public void onSkillListChanged(long r22) {
        long r6 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("AgentSkillManagerObserverIDLStub", "onSkillListChanged(" + r22 + ")", e);
        com.obric.aiagent.ipc.utils.g r3 = new com.obric.aiagent.ipc.utils.g(e);
        long r19 = SystemClock.elapsedRealtimeNanos();
        long r5 = Math.max(0, r19 - r6) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentSkillManagerObserverIDLStub", "onSkillListChanged(" + r22 + ") = fail", r3, r5);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentSkillManagerObserverIDLStub", "onSkillListChanged", r3, r5, r19);
        throw r3;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AgentSkillManagerObserverIDLStub", "onSkillListChanged(" + r22 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.onSkillListChanged(r22);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AgentSkillManagerObserverIDLStub", "onSkillListChanged = void");     // Catch: Exception -> L11
    L9:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r18 - r6) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentSkillManagerObserverIDLStub", "onSkillListChanged(" + r22 + ") = void", r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentSkillManagerObserverIDLStub", "onSkillListChanged", r14, r18);     // Catch: Exception -> L11
    }
}
