package com.obric.aiagent.assistant.idl;

import android.os.SystemClock;
import com.obric.aiagent.assistant.idl.bean.RequestRestrictRule;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
class AgentNetworkIDLStubWrapper extends IAgentNetworkIDL.Stub {
    boolean log;
    final IAgentNetworkIDL.Stub origin;

    AgentNetworkIDLStubWrapper(IAgentNetworkIDL.Stub r2) {
        this(r2, true);
    }

    AgentNetworkIDLStubWrapper(IAgentNetworkIDL.Stub r1, boolean r2) {
        this.origin = r1;
        this.log = r2;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentNetworkIDL
    public void notifyRequestStatus(boolean r22, Map r23) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r23, Map.class, "com.obric.aiagent.plugin");
        long r7 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("AgentNetworkIDLStub", "notifyRequestStatus(" + r22 + ", " + r6 + ")", e);
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);
        long r19 = SystemClock.elapsedRealtimeNanos();
        long r8 = Math.max(0, r19 - r7) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentNetworkIDLStub", "notifyRequestStatus(" + r22 + ", " + r6 + ") = fail", r2, r8);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentNetworkIDLStub", "notifyRequestStatus", r2, r8, r19);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AgentNetworkIDLStub", "notifyRequestStatus(" + r22 + ", " + r6 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.notifyRequestStatus(r22, r6);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AgentNetworkIDLStub", "notifyRequestStatus = void");     // Catch: Exception -> L11
    L9:
        long r110 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r13 = Math.max(0, r110 - r7) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentNetworkIDLStub", "notifyRequestStatus(" + r22 + ", " + r6 + ") = void", r13);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentNetworkIDLStub", "notifyRequestStatus", r13, r110);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentNetworkIDL
    public void updateExcludeRules(RequestRestrictRule r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("AgentNetworkIDLStub", "updateExcludeRules(" + r21 + ")", e);
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r4 = Math.max(0, r18 - r5) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentNetworkIDLStub", "updateExcludeRules(" + r21 + ") = fail", r2, r4);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentNetworkIDLStub", "updateExcludeRules", r2, r4, r18);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AgentNetworkIDLStub", "updateExcludeRules(" + r21 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.updateExcludeRules(r21);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AgentNetworkIDLStub", "updateExcludeRules = void");     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentNetworkIDLStub", "updateExcludeRules(" + r21 + ") = void", r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentNetworkIDLStub", "updateExcludeRules", r14, r17);     // Catch: Exception -> L11
    }
}
