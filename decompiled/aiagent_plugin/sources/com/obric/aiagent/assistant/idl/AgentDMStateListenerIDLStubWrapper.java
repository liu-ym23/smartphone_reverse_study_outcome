package com.obric.aiagent.assistant.idl;

import android.os.SystemClock;
import com.obric.aiagent.assistant.idl.bean.DMStateInfo;
import com.obric.aiagent.assistant.idl.bean.DMTaskInfo;
import com.obric.aiagent.assistant.idl.bean.DMTaskState;

/* JADX INFO: loaded from: classes2.dex */
class AgentDMStateListenerIDLStubWrapper extends IAgentDMStateListenerIDL.Stub {
    boolean log;
    final IAgentDMStateListenerIDL.Stub origin;

    AgentDMStateListenerIDLStubWrapper(IAgentDMStateListenerIDL.Stub r2) {
        this(r2, true);
    }

    AgentDMStateListenerIDLStubWrapper(IAgentDMStateListenerIDL.Stub r1, boolean r2) {
        this.origin = r1;
        this.log = r2;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentDMStateListenerIDL
    public void onDMStateChanged(DMStateInfo r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("AgentDMStateListenerIDLStub", "onDMStateChanged(" + r21 + ")", e);
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r4 = Math.max(0, r18 - r5) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentDMStateListenerIDLStub", "onDMStateChanged(" + r21 + ") = fail", r2, r4);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentDMStateListenerIDLStub", "onDMStateChanged", r2, r4, r18);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AgentDMStateListenerIDLStub", "onDMStateChanged(" + r21 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.onDMStateChanged(r21);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AgentDMStateListenerIDLStub", "onDMStateChanged = void");     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentDMStateListenerIDLStub", "onDMStateChanged(" + r21 + ") = void", r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentDMStateListenerIDLStub", "onDMStateChanged", r14, r17);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentDMStateListenerIDL
    public void onTaskAdded(DMTaskInfo r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("AgentDMStateListenerIDLStub", "onTaskAdded(" + r21 + ")", e);
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r4 = Math.max(0, r18 - r5) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentDMStateListenerIDLStub", "onTaskAdded(" + r21 + ") = fail", r2, r4);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentDMStateListenerIDLStub", "onTaskAdded", r2, r4, r18);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AgentDMStateListenerIDLStub", "onTaskAdded(" + r21 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.onTaskAdded(r21);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AgentDMStateListenerIDLStub", "onTaskAdded = void");     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentDMStateListenerIDLStub", "onTaskAdded(" + r21 + ") = void", r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentDMStateListenerIDLStub", "onTaskAdded", r14, r17);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentDMStateListenerIDL
    public void onTaskEnd(DMTaskInfo r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("AgentDMStateListenerIDLStub", "onTaskEnd(" + r21 + ")", e);
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r4 = Math.max(0, r18 - r5) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentDMStateListenerIDLStub", "onTaskEnd(" + r21 + ") = fail", r2, r4);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentDMStateListenerIDLStub", "onTaskEnd", r2, r4, r18);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AgentDMStateListenerIDLStub", "onTaskEnd(" + r21 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.onTaskEnd(r21);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AgentDMStateListenerIDLStub", "onTaskEnd = void");     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentDMStateListenerIDLStub", "onTaskEnd(" + r21 + ") = void", r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentDMStateListenerIDLStub", "onTaskEnd", r14, r17);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentDMStateListenerIDL
    public void onTaskStateChanged(DMTaskInfo r23, DMTaskState r24, DMTaskState r25) {
        long r8 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("AgentDMStateListenerIDLStub", "onTaskStateChanged(" + r23 + ", " + r24 + ", " + r25 + ")", e);
        com.obric.aiagent.ipc.utils.g r4 = new com.obric.aiagent.ipc.utils.g(e);
        long r20 = SystemClock.elapsedRealtimeNanos();
        long r9 = Math.max(0, r20 - r8) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentDMStateListenerIDLStub", "onTaskStateChanged(" + r23 + ", " + r24 + ", " + r25 + ") = fail", r4, r9);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentDMStateListenerIDLStub", "onTaskStateChanged", r4, r9, r20);
        throw r4;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AgentDMStateListenerIDLStub", "onTaskStateChanged(" + r23 + ", " + r24 + ", " + r25 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.onTaskStateChanged(r23, r24, r25);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AgentDMStateListenerIDLStub", "onTaskStateChanged = void");     // Catch: Exception -> L11
    L9:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r21 - r8) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentDMStateListenerIDLStub", "onTaskStateChanged(" + r23 + ", " + r24 + ", " + r25 + ") = void", r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentDMStateListenerIDLStub", "onTaskStateChanged", r14, r21);     // Catch: Exception -> L11
    }
}
