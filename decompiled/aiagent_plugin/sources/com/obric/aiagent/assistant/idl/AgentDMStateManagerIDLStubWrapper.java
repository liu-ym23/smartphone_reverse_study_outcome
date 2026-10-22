package com.obric.aiagent.assistant.idl;

import android.os.SystemClock;
import com.obric.aiagent.assistant.idl.bean.DMStateInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
class AgentDMStateManagerIDLStubWrapper extends IAgentDMStateManagerIDL.Stub {
    boolean log;
    final IAgentDMStateManagerIDL.Stub origin;

    AgentDMStateManagerIDLStubWrapper(IAgentDMStateManagerIDL.Stub r2) {
        this(r2, true);
    }

    AgentDMStateManagerIDLStubWrapper(IAgentDMStateManagerIDL.Stub r1, boolean r2) {
        this.origin = r1;
        this.log = r2;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentDMStateManagerIDL
    public void registerDMStateListener(IAgentDMStateListenerIDL r21) {
        IAgentDMStateListenerIDL r4 = (IAgentDMStateListenerIDL) ZeusTransformUtils.wrapperContextForParams(r21, IAgentDMStateListenerIDL.class, "com.obric.aiagent.plugin");
        long r6 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("AgentDMStateManagerIDLStub", "registerDMStateListener(" + r4 + ")", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r5 = Math.max(0, r18 - r6) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentDMStateManagerIDLStub", "registerDMStateListener(" + r4 + ") = fail", r1, r5);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentDMStateManagerIDLStub", "registerDMStateListener", r1, r5, r18);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AgentDMStateManagerIDLStub", "registerDMStateListener(" + r4 + ")");     // Catch: Exception -> L24
    L6:
        IAgentDMStateManagerIDL.Stub r12 = this.origin;     // Catch: Exception -> L24
        if (r4 != null) goto L10;
    L18:
        IAgentDMStateListenerIDL r7 = r4;
    L19:
        r12.registerDMStateListener(r7);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AgentDMStateManagerIDLStub", "registerDMStateListener = void");     // Catch: Exception -> L24
    L22:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r14 = Math.max(0, r17 - r6) / 1000;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentDMStateManagerIDLStub", "registerDMStateListener(" + r4 + ") = void", r14);     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentDMStateManagerIDLStub", "registerDMStateListener", r14, r17);     // Catch: Exception -> L24
        return;
    L10:
        if (ZeusTransformUtils.instanceOf(r4, AgentDMStateListenerIDLIpcWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r4, AgentDMStateListenerIDLStubWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r4, IAgentDMStateListenerIDL.Stub.class) == false) goto L17;
        r7 = c.a((IAgentDMStateListenerIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IAgentDMStateListenerIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L24
        goto L19
    L17:
        r7 = c.a(r4, true);     // Catch: Exception -> L24
        goto L19
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentDMStateManagerIDL
    public void unRegisterDMStateListener(IAgentDMStateListenerIDL r21) {
        IAgentDMStateListenerIDL r4 = (IAgentDMStateListenerIDL) ZeusTransformUtils.wrapperContextForParams(r21, IAgentDMStateListenerIDL.class, "com.obric.aiagent.plugin");
        long r6 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("AgentDMStateManagerIDLStub", "unRegisterDMStateListener(" + r4 + ")", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r5 = Math.max(0, r18 - r6) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentDMStateManagerIDLStub", "unRegisterDMStateListener(" + r4 + ") = fail", r1, r5);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentDMStateManagerIDLStub", "unRegisterDMStateListener", r1, r5, r18);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AgentDMStateManagerIDLStub", "unRegisterDMStateListener(" + r4 + ")");     // Catch: Exception -> L24
    L6:
        IAgentDMStateManagerIDL.Stub r12 = this.origin;     // Catch: Exception -> L24
        if (r4 != null) goto L10;
    L18:
        IAgentDMStateListenerIDL r7 = r4;
    L19:
        r12.unRegisterDMStateListener(r7);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AgentDMStateManagerIDLStub", "unRegisterDMStateListener = void");     // Catch: Exception -> L24
    L22:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r14 = Math.max(0, r17 - r6) / 1000;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentDMStateManagerIDLStub", "unRegisterDMStateListener(" + r4 + ") = void", r14);     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentDMStateManagerIDLStub", "unRegisterDMStateListener", r14, r17);     // Catch: Exception -> L24
        return;
    L10:
        if (ZeusTransformUtils.instanceOf(r4, AgentDMStateListenerIDLIpcWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r4, AgentDMStateListenerIDLStubWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r4, IAgentDMStateListenerIDL.Stub.class) == false) goto L17;
        r7 = c.a((IAgentDMStateListenerIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IAgentDMStateListenerIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L24
        goto L19
    L17:
        r7 = c.a(r4, true);     // Catch: Exception -> L24
        goto L19
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentDMStateManagerIDL
    public DMStateInfo getCurrentDMSteate() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("AgentDMStateManagerIDLStub", "getCurrentDMSteate()", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r2 = Math.max(0, r16 - r3) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentDMStateManagerIDLStub", "getCurrentDMSteate() = fail", r1, r2);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentDMStateManagerIDLStub", "getCurrentDMSteate", r1, r2, r16);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AgentDMStateManagerIDLStub", "getCurrentDMSteate()");     // Catch: Exception -> L11
    L6:
        DMStateInfo r9 = this.origin.getCurrentDMSteate();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AgentDMStateManagerIDLStub", "getCurrentDMSteate = " + r9);     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r3) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentDMStateManagerIDLStub", "getCurrentDMSteate() = " + r9, r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentDMStateManagerIDLStub", "getCurrentDMSteate", r14, r17);     // Catch: Exception -> L11
        return r9;
    }
}
