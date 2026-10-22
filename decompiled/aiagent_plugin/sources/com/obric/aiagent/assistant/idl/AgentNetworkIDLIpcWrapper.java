package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import android.os.SystemClock;
import com.obric.aiagent.assistant.idl.bean.RequestRestrictRule;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
class AgentNetworkIDLIpcWrapper implements IAgentNetworkIDL {
    boolean log;
    final IAgentNetworkIDL origin;

    AgentNetworkIDLIpcWrapper(IAgentNetworkIDL r3) {
        this((IAgentNetworkIDL) ZeusTransformUtils.wrapperContextForParams(r3, IAgentNetworkIDL.class, "com.obric.aiagent.plugin"), true);
    }

    AgentNetworkIDLIpcWrapper(IAgentNetworkIDL r3, boolean r4) {
        this.origin = (IAgentNetworkIDL) ZeusTransformUtils.wrapperContextForParams(r3, IAgentNetworkIDL.class, "com.obric.aiagent.plugin");
        this.log = r4;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentNetworkIDL
    public void notifyRequestStatus(boolean r22, Map r23) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r23, Map.class, "com.obric.aiagent.plugin");
        long r7 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentNetworkIDLIPC", "notifyRequestStatus(" + r22 + ", " + r6 + ")", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r8 = Math.max(0, r19 - r7) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentNetworkIDLIPC", "notifyRequestStatus(" + r22 + ", " + r6 + ") = fail", r2, r8);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentNetworkIDLIPC", "notifyRequestStatus", r2, r8, r19);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentNetworkIDLIPC", "notifyRequestStatus(" + r22 + ", " + r6 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentNetworkIDLIPC", "notifyRequestStatus(" + r22 + ", " + r6 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.notifyRequestStatus(r22, r6);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IAgentNetworkIDLIPC", "notifyRequestStatus = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r110 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r13 = Math.max(0, r110 - r7) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentNetworkIDLIPC", "notifyRequestStatus(" + r22 + ", " + r6 + ") = void", r13);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentNetworkIDLIPC", "notifyRequestStatus", r13, r110);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentNetworkIDL
    public void updateExcludeRules(RequestRestrictRule r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentNetworkIDLIPC", "updateExcludeRules(" + r21 + ")", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r4 = Math.max(0, r18 - r5) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentNetworkIDLIPC", "updateExcludeRules(" + r21 + ") = fail", r2, r4);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentNetworkIDLIPC", "updateExcludeRules", r2, r4, r18);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentNetworkIDLIPC", "updateExcludeRules(" + r21 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentNetworkIDLIPC", "updateExcludeRules(" + r21 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.updateExcludeRules(r21);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IAgentNetworkIDLIPC", "updateExcludeRules = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentNetworkIDLIPC", "updateExcludeRules(" + r21 + ") = void", r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentNetworkIDLIPC", "updateExcludeRules", r14, r17);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.origin.asBinder();
    }
}
