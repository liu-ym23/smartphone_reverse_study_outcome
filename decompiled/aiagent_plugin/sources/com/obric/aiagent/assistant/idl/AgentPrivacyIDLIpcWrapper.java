package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import android.os.SystemClock;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
class AgentPrivacyIDLIpcWrapper implements IAgentPrivacyIDL {
    boolean log;
    final IAgentPrivacyIDL origin;

    AgentPrivacyIDLIpcWrapper(IAgentPrivacyIDL r3) {
        this((IAgentPrivacyIDL) ZeusTransformUtils.wrapperContextForParams(r3, IAgentPrivacyIDL.class, "com.obric.aiagent.plugin"), true);
    }

    AgentPrivacyIDLIpcWrapper(IAgentPrivacyIDL r3, boolean r4) {
        this.origin = (IAgentPrivacyIDL) ZeusTransformUtils.wrapperContextForParams(r3, IAgentPrivacyIDL.class, "com.obric.aiagent.plugin");
        this.log = r4;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentPrivacyIDL
    public String getPemCertChain(String r23, String r24) {
        long r7 = SystemClock.elapsedRealtimeNanos();
        String r13 = null;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentPrivacyIDLIPC", "getPemCertChain(" + r23 + ", " + r24 + ")", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r3 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r20 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r6 = Math.max(0, r20 - r7) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentPrivacyIDLIPC", "getPemCertChain(" + r23 + ", " + r24 + ") = fail", r3, r6);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentPrivacyIDLIPC", "getPemCertChain", r3, r6, r20);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentPrivacyIDLIPC", "getPemCertChain(" + r23 + ", " + r24 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentPrivacyIDLIPC", "getPemCertChain(" + r23 + ", " + r24 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r13 = this.origin.getPemCertChain(r23, r24);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IAgentPrivacyIDLIPC", "getPemCertChain = " + r13);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r21 - r7) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentPrivacyIDLIPC", "getPemCertChain(" + r23 + ", " + r24 + ") = " + r13, r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentPrivacyIDLIPC", "getPemCertChain", r14, r21);     // Catch: Exception -> L14 Throwable -> L17
        return r13;
    L16:
        return r13;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.origin.asBinder();
    }
}
