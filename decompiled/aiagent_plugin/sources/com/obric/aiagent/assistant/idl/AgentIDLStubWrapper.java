package com.obric.aiagent.assistant.idl;

import android.os.SystemClock;
import com.obric.aiagent.ipc.idl.IFileIDL;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
class AgentIDLStubWrapper extends IAgentIDL.Stub {
    boolean log;
    final IAgentIDL.Stub origin;

    AgentIDLStubWrapper(IAgentIDL.Stub r2) {
        this(r2, true);
    }

    AgentIDLStubWrapper(IAgentIDL.Stub r1, boolean r2) {
        this.origin = r1;
        this.log = r2;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentIDL
    public void registerFlowIDL(IFlowIDL r21) {
        IFlowIDL r4 = (IFlowIDL) ZeusTransformUtils.wrapperContextForParams(r21, IFlowIDL.class, "com.obric.aiagent.plugin");
        long r6 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("AgentIDLStub", "registerFlowIDL(" + r4 + ")", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r5 = Math.max(0, r18 - r6) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentIDLStub", "registerFlowIDL(" + r4 + ") = fail", r1, r5);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentIDLStub", "registerFlowIDL", r1, r5, r18);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AgentIDLStub", "registerFlowIDL(" + r4 + ")");     // Catch: Exception -> L24
    L6:
        IAgentIDL.Stub r12 = this.origin;     // Catch: Exception -> L24
        if (r4 != null) goto L10;
    L18:
        IFlowIDL r7 = r4;
    L19:
        r12.registerFlowIDL(r7);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AgentIDLStub", "registerFlowIDL = void");     // Catch: Exception -> L24
    L22:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r14 = Math.max(0, r17 - r6) / 1000;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentIDLStub", "registerFlowIDL(" + r4 + ") = void", r14);     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentIDLStub", "registerFlowIDL", r14, r17);     // Catch: Exception -> L24
        return;
    L10:
        if (ZeusTransformUtils.instanceOf(r4, FlowIDLIpcWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r4, FlowIDLStubWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r4, IFlowIDL.Stub.class) == false) goto L17;
        r7 = ag.a((IFlowIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IFlowIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L24
        goto L19
    L17:
        r7 = ag.b(r4, true);     // Catch: Exception -> L24
        goto L19
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentIDL
    public IFileIDL getFileIDL() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("AgentIDLStub", "getFileIDL()", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r2 = Math.max(0, r16 - r3) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentIDLStub", "getFileIDL() = fail", r1, r2);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentIDLStub", "getFileIDL", r1, r2, r16);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AgentIDLStub", "getFileIDL()");     // Catch: Exception -> L11
    L6:
        IFileIDL r9 = this.origin.getFileIDL();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AgentIDLStub", "getFileIDL = " + r9);     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r3) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentIDLStub", "getFileIDL() = " + r9, r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentIDLStub", "getFileIDL", r14, r17);     // Catch: Exception -> L11
        return r9;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentIDL
    public IAgentAppIntentIDL getAppIntentIDL() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("AgentIDLStub", "getAppIntentIDL()", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r2 = Math.max(0, r16 - r3) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentIDLStub", "getAppIntentIDL() = fail", r1, r2);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentIDLStub", "getAppIntentIDL", r1, r2, r16);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AgentIDLStub", "getAppIntentIDL()");     // Catch: Exception -> L11
    L6:
        IAgentAppIntentIDL r9 = this.origin.getAppIntentIDL();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AgentIDLStub", "getAppIntentIDL = " + r9);     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r3) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentIDLStub", "getAppIntentIDL() = " + r9, r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentIDLStub", "getAppIntentIDL", r14, r17);     // Catch: Exception -> L11
        return r9;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentIDL
    public IAgentVoiceInteractionIDL getVoiceInteractionIDL() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("AgentIDLStub", "getVoiceInteractionIDL()", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r2 = Math.max(0, r16 - r3) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentIDLStub", "getVoiceInteractionIDL() = fail", r1, r2);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentIDLStub", "getVoiceInteractionIDL", r1, r2, r16);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AgentIDLStub", "getVoiceInteractionIDL()");     // Catch: Exception -> L11
    L6:
        IAgentVoiceInteractionIDL r9 = this.origin.getVoiceInteractionIDL();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AgentIDLStub", "getVoiceInteractionIDL = " + r9);     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r3) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentIDLStub", "getVoiceInteractionIDL() = " + r9, r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentIDLStub", "getVoiceInteractionIDL", r14, r17);     // Catch: Exception -> L11
        return r9;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentIDL
    public IAgentSettingsIDL getSettingsIDL() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("AgentIDLStub", "getSettingsIDL()", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r2 = Math.max(0, r16 - r3) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentIDLStub", "getSettingsIDL() = fail", r1, r2);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentIDLStub", "getSettingsIDL", r1, r2, r16);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AgentIDLStub", "getSettingsIDL()");     // Catch: Exception -> L11
    L6:
        IAgentSettingsIDL r9 = this.origin.getSettingsIDL();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AgentIDLStub", "getSettingsIDL = " + r9);     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r3) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentIDLStub", "getSettingsIDL() = " + r9, r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentIDLStub", "getSettingsIDL", r14, r17);     // Catch: Exception -> L11
        return r9;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentIDL
    public IAgentMessageIDL getMessageIDL() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("AgentIDLStub", "getMessageIDL()", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r2 = Math.max(0, r16 - r3) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentIDLStub", "getMessageIDL() = fail", r1, r2);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentIDLStub", "getMessageIDL", r1, r2, r16);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AgentIDLStub", "getMessageIDL()");     // Catch: Exception -> L11
    L6:
        IAgentMessageIDL r9 = this.origin.getMessageIDL();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AgentIDLStub", "getMessageIDL = " + r9);     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r3) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentIDLStub", "getMessageIDL() = " + r9, r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentIDLStub", "getMessageIDL", r14, r17);     // Catch: Exception -> L11
        return r9;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentIDL
    public IAgentAssistantStateIDL getAssistantStateIDL() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("AgentIDLStub", "getAssistantStateIDL()", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r2 = Math.max(0, r16 - r3) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentIDLStub", "getAssistantStateIDL() = fail", r1, r2);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentIDLStub", "getAssistantStateIDL", r1, r2, r16);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AgentIDLStub", "getAssistantStateIDL()");     // Catch: Exception -> L11
    L6:
        IAgentAssistantStateIDL r9 = this.origin.getAssistantStateIDL();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AgentIDLStub", "getAssistantStateIDL = " + r9);     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r3) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentIDLStub", "getAssistantStateIDL() = " + r9, r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentIDLStub", "getAssistantStateIDL", r14, r17);     // Catch: Exception -> L11
        return r9;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentIDL
    public IAgentNetworkIDL getAgentNetworkIDL() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("AgentIDLStub", "getAgentNetworkIDL()", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r2 = Math.max(0, r16 - r3) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentIDLStub", "getAgentNetworkIDL() = fail", r1, r2);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentIDLStub", "getAgentNetworkIDL", r1, r2, r16);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AgentIDLStub", "getAgentNetworkIDL()");     // Catch: Exception -> L11
    L6:
        IAgentNetworkIDL r9 = this.origin.getAgentNetworkIDL();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AgentIDLStub", "getAgentNetworkIDL = " + r9);     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r3) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentIDLStub", "getAgentNetworkIDL() = " + r9, r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentIDLStub", "getAgentNetworkIDL", r14, r17);     // Catch: Exception -> L11
        return r9;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentIDL
    public IPlatformApiIDL getPlatformApiIDL() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("AgentIDLStub", "getPlatformApiIDL()", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r2 = Math.max(0, r16 - r3) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentIDLStub", "getPlatformApiIDL() = fail", r1, r2);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentIDLStub", "getPlatformApiIDL", r1, r2, r16);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AgentIDLStub", "getPlatformApiIDL()");     // Catch: Exception -> L11
    L6:
        IPlatformApiIDL r9 = this.origin.getPlatformApiIDL();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AgentIDLStub", "getPlatformApiIDL = " + r9);     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r3) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentIDLStub", "getPlatformApiIDL() = " + r9, r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentIDLStub", "getPlatformApiIDL", r14, r17);     // Catch: Exception -> L11
        return r9;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentIDL
    public IAgentDMStateManagerIDL getAgentDMStateManagerIDL() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("AgentIDLStub", "getAgentDMStateManagerIDL()", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r2 = Math.max(0, r16 - r3) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentIDLStub", "getAgentDMStateManagerIDL() = fail", r1, r2);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentIDLStub", "getAgentDMStateManagerIDL", r1, r2, r16);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AgentIDLStub", "getAgentDMStateManagerIDL()");     // Catch: Exception -> L11
    L6:
        IAgentDMStateManagerIDL r9 = this.origin.getAgentDMStateManagerIDL();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AgentIDLStub", "getAgentDMStateManagerIDL = " + r9);     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r3) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentIDLStub", "getAgentDMStateManagerIDL() = " + r9, r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentIDLStub", "getAgentDMStateManagerIDL", r14, r17);     // Catch: Exception -> L11
        return r9;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentIDL
    public IAgentPrivacyIDL getPrivacyIDL() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("AgentIDLStub", "getPrivacyIDL()", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r2 = Math.max(0, r16 - r3) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentIDLStub", "getPrivacyIDL() = fail", r1, r2);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentIDLStub", "getPrivacyIDL", r1, r2, r16);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AgentIDLStub", "getPrivacyIDL()");     // Catch: Exception -> L11
    L6:
        IAgentPrivacyIDL r9 = this.origin.getPrivacyIDL();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AgentIDLStub", "getPrivacyIDL = " + r9);     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r3) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentIDLStub", "getPrivacyIDL() = " + r9, r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentIDLStub", "getPrivacyIDL", r14, r17);     // Catch: Exception -> L11
        return r9;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentIDL
    public IAgentTaskAppIDL getTaskAppIDL() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("AgentIDLStub", "getTaskAppIDL()", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r2 = Math.max(0, r16 - r3) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentIDLStub", "getTaskAppIDL() = fail", r1, r2);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentIDLStub", "getTaskAppIDL", r1, r2, r16);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AgentIDLStub", "getTaskAppIDL()");     // Catch: Exception -> L11
    L6:
        IAgentTaskAppIDL r9 = this.origin.getTaskAppIDL();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AgentIDLStub", "getTaskAppIDL = " + r9);     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r3) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentIDLStub", "getTaskAppIDL() = " + r9, r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentIDLStub", "getTaskAppIDL", r14, r17);     // Catch: Exception -> L11
        return r9;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentIDL
    public IAgentSkillManagerIDL getSkillManagerIDL() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("AgentIDLStub", "getSkillManagerIDL()", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r2 = Math.max(0, r16 - r3) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentIDLStub", "getSkillManagerIDL() = fail", r1, r2);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentIDLStub", "getSkillManagerIDL", r1, r2, r16);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AgentIDLStub", "getSkillManagerIDL()");     // Catch: Exception -> L11
    L6:
        IAgentSkillManagerIDL r9 = this.origin.getSkillManagerIDL();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AgentIDLStub", "getSkillManagerIDL = " + r9);     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r3) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentIDLStub", "getSkillManagerIDL() = " + r9, r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentIDLStub", "getSkillManagerIDL", r14, r17);     // Catch: Exception -> L11
        return r9;
    }
}
