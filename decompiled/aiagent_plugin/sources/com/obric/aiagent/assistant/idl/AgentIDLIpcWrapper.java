package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import android.os.SystemClock;
import com.obric.aiagent.ipc.idl.IFileIDL;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
class AgentIDLIpcWrapper implements IAgentIDL {
    boolean log;
    final IAgentIDL origin;

    AgentIDLIpcWrapper(IAgentIDL r3) {
        this((IAgentIDL) ZeusTransformUtils.wrapperContextForParams(r3, IAgentIDL.class, "com.obric.aiagent.plugin"), true);
    }

    AgentIDLIpcWrapper(IAgentIDL r3, boolean r4) {
        this.origin = (IAgentIDL) ZeusTransformUtils.wrapperContextForParams(r3, IAgentIDL.class, "com.obric.aiagent.plugin");
        this.log = r4;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentIDL
    public void registerFlowIDL(IFlowIDL r21) {
        IFlowIDL r4 = (IFlowIDL) ZeusTransformUtils.wrapperContextForParams(r21, IFlowIDL.class, "com.obric.aiagent.plugin");
        long r6 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentIDLIPC", "registerFlowIDL(" + r4 + ")", e);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L43
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r5 = Math.max(0, r18 - r6) / 1000;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentIDLIPC", "registerFlowIDL(" + r4 + ") = fail", r1, r5);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentIDLIPC", "registerFlowIDL", r1, r5, r18);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentIDLIPC", "registerFlowIDL(" + r4 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j r12 = com.obric.aiagent.ipc.utils.j.f18676a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r14 = new StringBuilder().append("registerFlowIDL(");     // Catch: Exception -> L40 Throwable -> L43
        if (r4 != null) goto L12;
    L20:
        IFlowIDL r15 = r4;
    L21:
        r12.a("IAgentIDLIPC", r14.append(r15).append(")").toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if (ZeusTransformUtils.instanceOf(r4, FlowIDLIpcWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r4, FlowIDLStubWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r4, IFlowIDL.Stub.class) == false) goto L19;
        r15 = ag.a((IFlowIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IFlowIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r15 = ag.b(r4, true);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IAgentIDL r13 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r4 != null) goto L26;
    L34:
        IFlowIDL r7 = r4;
    L35:
        r13.registerFlowIDL(r7);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IAgentIDLIPC", "registerFlowIDL = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r16 = Math.max(0, r17 - r6) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentIDLIPC", "registerFlowIDL(" + r4 + ") = void", r16);     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentIDLIPC", "registerFlowIDL", r16, r17);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L46
    L26:
        if (ZeusTransformUtils.instanceOf(r4, FlowIDLIpcWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r4, FlowIDLStubWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r4, IFlowIDL.Stub.class) == false) goto L33;
        r7 = ag.a((IFlowIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IFlowIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r7 = ag.b(r4, true);     // Catch: Exception -> L40 Throwable -> L43
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentIDL
    public IFileIDL getFileIDL() {
        long r3 = SystemClock.elapsedRealtimeNanos();
        IFileIDL r9 = null;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentIDLIPC", "getFileIDL()", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r2 = Math.max(0, r17 - r3) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentIDLIPC", "getFileIDL() = fail", r1, r2);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentIDLIPC", "getFileIDL", r1, r2, r17);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentIDLIPC", "getFileIDL()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentIDLIPC", "getFileIDL()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r9 = this.origin.getFileIDL();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IAgentIDLIPC", "getFileIDL = " + r9);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r16 - r3) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentIDLIPC", "getFileIDL() = " + r9, r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentIDLIPC", "getFileIDL", r14, r16);     // Catch: Exception -> L14 Throwable -> L17
        return r9;
    L16:
        return r9;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentIDL
    public IAgentAppIntentIDL getAppIntentIDL() {
        long r3 = SystemClock.elapsedRealtimeNanos();
        IAgentAppIntentIDL r9 = null;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentIDLIPC", "getAppIntentIDL()", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r2 = Math.max(0, r17 - r3) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentIDLIPC", "getAppIntentIDL() = fail", r1, r2);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentIDLIPC", "getAppIntentIDL", r1, r2, r17);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentIDLIPC", "getAppIntentIDL()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentIDLIPC", "getAppIntentIDL()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r9 = this.origin.getAppIntentIDL();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IAgentIDLIPC", "getAppIntentIDL = " + r9);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r16 - r3) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentIDLIPC", "getAppIntentIDL() = " + r9, r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentIDLIPC", "getAppIntentIDL", r14, r16);     // Catch: Exception -> L14 Throwable -> L17
        return r9;
    L16:
        return r9;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentIDL
    public IAgentVoiceInteractionIDL getVoiceInteractionIDL() {
        long r3 = SystemClock.elapsedRealtimeNanos();
        IAgentVoiceInteractionIDL r9 = null;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentIDLIPC", "getVoiceInteractionIDL()", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r2 = Math.max(0, r17 - r3) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentIDLIPC", "getVoiceInteractionIDL() = fail", r1, r2);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentIDLIPC", "getVoiceInteractionIDL", r1, r2, r17);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentIDLIPC", "getVoiceInteractionIDL()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentIDLIPC", "getVoiceInteractionIDL()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r9 = this.origin.getVoiceInteractionIDL();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IAgentIDLIPC", "getVoiceInteractionIDL = " + r9);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r16 - r3) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentIDLIPC", "getVoiceInteractionIDL() = " + r9, r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentIDLIPC", "getVoiceInteractionIDL", r14, r16);     // Catch: Exception -> L14 Throwable -> L17
        return r9;
    L16:
        return r9;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentIDL
    public IAgentSettingsIDL getSettingsIDL() {
        long r3 = SystemClock.elapsedRealtimeNanos();
        IAgentSettingsIDL r9 = null;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentIDLIPC", "getSettingsIDL()", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r2 = Math.max(0, r17 - r3) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentIDLIPC", "getSettingsIDL() = fail", r1, r2);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentIDLIPC", "getSettingsIDL", r1, r2, r17);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentIDLIPC", "getSettingsIDL()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentIDLIPC", "getSettingsIDL()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r9 = this.origin.getSettingsIDL();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IAgentIDLIPC", "getSettingsIDL = " + r9);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r16 - r3) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentIDLIPC", "getSettingsIDL() = " + r9, r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentIDLIPC", "getSettingsIDL", r14, r16);     // Catch: Exception -> L14 Throwable -> L17
        return r9;
    L16:
        return r9;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentIDL
    public IAgentMessageIDL getMessageIDL() {
        long r3 = SystemClock.elapsedRealtimeNanos();
        IAgentMessageIDL r9 = null;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentIDLIPC", "getMessageIDL()", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r2 = Math.max(0, r17 - r3) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentIDLIPC", "getMessageIDL() = fail", r1, r2);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentIDLIPC", "getMessageIDL", r1, r2, r17);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentIDLIPC", "getMessageIDL()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentIDLIPC", "getMessageIDL()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r9 = this.origin.getMessageIDL();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IAgentIDLIPC", "getMessageIDL = " + r9);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r16 - r3) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentIDLIPC", "getMessageIDL() = " + r9, r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentIDLIPC", "getMessageIDL", r14, r16);     // Catch: Exception -> L14 Throwable -> L17
        return r9;
    L16:
        return r9;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentIDL
    public IAgentAssistantStateIDL getAssistantStateIDL() {
        long r3 = SystemClock.elapsedRealtimeNanos();
        IAgentAssistantStateIDL r9 = null;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentIDLIPC", "getAssistantStateIDL()", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r2 = Math.max(0, r17 - r3) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentIDLIPC", "getAssistantStateIDL() = fail", r1, r2);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentIDLIPC", "getAssistantStateIDL", r1, r2, r17);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentIDLIPC", "getAssistantStateIDL()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentIDLIPC", "getAssistantStateIDL()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r9 = this.origin.getAssistantStateIDL();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IAgentIDLIPC", "getAssistantStateIDL = " + r9);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r16 - r3) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentIDLIPC", "getAssistantStateIDL() = " + r9, r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentIDLIPC", "getAssistantStateIDL", r14, r16);     // Catch: Exception -> L14 Throwable -> L17
        return r9;
    L16:
        return r9;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentIDL
    public IAgentNetworkIDL getAgentNetworkIDL() {
        long r3 = SystemClock.elapsedRealtimeNanos();
        IAgentNetworkIDL r9 = null;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentIDLIPC", "getAgentNetworkIDL()", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r2 = Math.max(0, r17 - r3) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentIDLIPC", "getAgentNetworkIDL() = fail", r1, r2);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentIDLIPC", "getAgentNetworkIDL", r1, r2, r17);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentIDLIPC", "getAgentNetworkIDL()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentIDLIPC", "getAgentNetworkIDL()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r9 = this.origin.getAgentNetworkIDL();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IAgentIDLIPC", "getAgentNetworkIDL = " + r9);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r16 - r3) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentIDLIPC", "getAgentNetworkIDL() = " + r9, r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentIDLIPC", "getAgentNetworkIDL", r14, r16);     // Catch: Exception -> L14 Throwable -> L17
        return r9;
    L16:
        return r9;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentIDL
    public IPlatformApiIDL getPlatformApiIDL() {
        long r3 = SystemClock.elapsedRealtimeNanos();
        IPlatformApiIDL r9 = null;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentIDLIPC", "getPlatformApiIDL()", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r2 = Math.max(0, r17 - r3) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentIDLIPC", "getPlatformApiIDL() = fail", r1, r2);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentIDLIPC", "getPlatformApiIDL", r1, r2, r17);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentIDLIPC", "getPlatformApiIDL()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentIDLIPC", "getPlatformApiIDL()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r9 = this.origin.getPlatformApiIDL();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IAgentIDLIPC", "getPlatformApiIDL = " + r9);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r16 - r3) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentIDLIPC", "getPlatformApiIDL() = " + r9, r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentIDLIPC", "getPlatformApiIDL", r14, r16);     // Catch: Exception -> L14 Throwable -> L17
        return r9;
    L16:
        return r9;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentIDL
    public IAgentDMStateManagerIDL getAgentDMStateManagerIDL() {
        long r3 = SystemClock.elapsedRealtimeNanos();
        IAgentDMStateManagerIDL r9 = null;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentIDLIPC", "getAgentDMStateManagerIDL()", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r2 = Math.max(0, r17 - r3) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentIDLIPC", "getAgentDMStateManagerIDL() = fail", r1, r2);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentIDLIPC", "getAgentDMStateManagerIDL", r1, r2, r17);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentIDLIPC", "getAgentDMStateManagerIDL()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentIDLIPC", "getAgentDMStateManagerIDL()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r9 = this.origin.getAgentDMStateManagerIDL();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IAgentIDLIPC", "getAgentDMStateManagerIDL = " + r9);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r16 - r3) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentIDLIPC", "getAgentDMStateManagerIDL() = " + r9, r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentIDLIPC", "getAgentDMStateManagerIDL", r14, r16);     // Catch: Exception -> L14 Throwable -> L17
        return r9;
    L16:
        return r9;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentIDL
    public IAgentPrivacyIDL getPrivacyIDL() {
        long r3 = SystemClock.elapsedRealtimeNanos();
        IAgentPrivacyIDL r9 = null;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentIDLIPC", "getPrivacyIDL()", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r2 = Math.max(0, r17 - r3) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentIDLIPC", "getPrivacyIDL() = fail", r1, r2);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentIDLIPC", "getPrivacyIDL", r1, r2, r17);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentIDLIPC", "getPrivacyIDL()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentIDLIPC", "getPrivacyIDL()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r9 = this.origin.getPrivacyIDL();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IAgentIDLIPC", "getPrivacyIDL = " + r9);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r16 - r3) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentIDLIPC", "getPrivacyIDL() = " + r9, r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentIDLIPC", "getPrivacyIDL", r14, r16);     // Catch: Exception -> L14 Throwable -> L17
        return r9;
    L16:
        return r9;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentIDL
    public IAgentTaskAppIDL getTaskAppIDL() {
        long r3 = SystemClock.elapsedRealtimeNanos();
        IAgentTaskAppIDL r9 = null;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentIDLIPC", "getTaskAppIDL()", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r2 = Math.max(0, r17 - r3) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentIDLIPC", "getTaskAppIDL() = fail", r1, r2);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentIDLIPC", "getTaskAppIDL", r1, r2, r17);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentIDLIPC", "getTaskAppIDL()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentIDLIPC", "getTaskAppIDL()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r9 = this.origin.getTaskAppIDL();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IAgentIDLIPC", "getTaskAppIDL = " + r9);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r16 - r3) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentIDLIPC", "getTaskAppIDL() = " + r9, r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentIDLIPC", "getTaskAppIDL", r14, r16);     // Catch: Exception -> L14 Throwable -> L17
        return r9;
    L16:
        return r9;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentIDL
    public IAgentSkillManagerIDL getSkillManagerIDL() {
        long r3 = SystemClock.elapsedRealtimeNanos();
        IAgentSkillManagerIDL r9 = null;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentIDLIPC", "getSkillManagerIDL()", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r2 = Math.max(0, r17 - r3) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentIDLIPC", "getSkillManagerIDL() = fail", r1, r2);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentIDLIPC", "getSkillManagerIDL", r1, r2, r17);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentIDLIPC", "getSkillManagerIDL()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentIDLIPC", "getSkillManagerIDL()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r9 = this.origin.getSkillManagerIDL();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IAgentIDLIPC", "getSkillManagerIDL = " + r9);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r16 - r3) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentIDLIPC", "getSkillManagerIDL() = " + r9, r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentIDLIPC", "getSkillManagerIDL", r14, r16);     // Catch: Exception -> L14 Throwable -> L17
        return r9;
    L16:
        return r9;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.origin.asBinder();
    }
}
