package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import android.os.SystemClock;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
class AgentSkillManagerObserverIDLIpcWrapper implements IAgentSkillManagerObserverIDL {
    boolean log;
    final IAgentSkillManagerObserverIDL origin;

    AgentSkillManagerObserverIDLIpcWrapper(IAgentSkillManagerObserverIDL r3) {
        this((IAgentSkillManagerObserverIDL) ZeusTransformUtils.wrapperContextForParams(r3, IAgentSkillManagerObserverIDL.class, "com.obric.aiagent.plugin"), true);
    }

    AgentSkillManagerObserverIDLIpcWrapper(IAgentSkillManagerObserverIDL r3, boolean r4) {
        this.origin = (IAgentSkillManagerObserverIDL) ZeusTransformUtils.wrapperContextForParams(r3, IAgentSkillManagerObserverIDL.class, "com.obric.aiagent.plugin");
        this.log = r4;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentSkillManagerObserverIDL
    public void onSkillListChanged(long r22) {
        long r6 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentSkillManagerObserverIDLIPC", "onSkillListChanged(" + r22 + ")", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r3 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r5 = Math.max(0, r19 - r6) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentSkillManagerObserverIDLIPC", "onSkillListChanged(" + r22 + ") = fail", r3, r5);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentSkillManagerObserverIDLIPC", "onSkillListChanged", r3, r5, r19);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentSkillManagerObserverIDLIPC", "onSkillListChanged(" + r22 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentSkillManagerObserverIDLIPC", "onSkillListChanged(" + r22 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.onSkillListChanged(r22);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IAgentSkillManagerObserverIDLIPC", "onSkillListChanged = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r18 - r6) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentSkillManagerObserverIDLIPC", "onSkillListChanged(" + r22 + ") = void", r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentSkillManagerObserverIDLIPC", "onSkillListChanged", r14, r18);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.origin.asBinder();
    }
}
