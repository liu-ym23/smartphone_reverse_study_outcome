package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.obric.aiagent.ipc.idl.IFileIDL;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AgentIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
final class AgentIDLStub extends IAgentIDL.Stub implements IAgentIDL {
    private final /* synthetic */ IAgentIDL $$delegate_0;

    @Override // com.obric.aiagent.assistant.idl.IAgentIDL
    public IAgentDMStateManagerIDL getAgentDMStateManagerIDL() {
        return this.$$delegate_0.getAgentDMStateManagerIDL();
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentIDL
    public IAgentNetworkIDL getAgentNetworkIDL() {
        return this.$$delegate_0.getAgentNetworkIDL();
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentIDL
    public IAgentAppIntentIDL getAppIntentIDL() {
        return this.$$delegate_0.getAppIntentIDL();
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentIDL
    public IAgentAssistantStateIDL getAssistantStateIDL() {
        return this.$$delegate_0.getAssistantStateIDL();
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentIDL
    public IFileIDL getFileIDL() {
        return this.$$delegate_0.getFileIDL();
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentIDL
    public IAgentMessageIDL getMessageIDL() {
        return this.$$delegate_0.getMessageIDL();
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentIDL
    public IPlatformApiIDL getPlatformApiIDL() {
        return this.$$delegate_0.getPlatformApiIDL();
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentIDL
    public IAgentPrivacyIDL getPrivacyIDL() {
        return this.$$delegate_0.getPrivacyIDL();
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentIDL
    public IAgentSettingsIDL getSettingsIDL() {
        return this.$$delegate_0.getSettingsIDL();
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentIDL
    public IAgentSkillManagerIDL getSkillManagerIDL() {
        return this.$$delegate_0.getSkillManagerIDL();
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentIDL
    public IAgentTaskAppIDL getTaskAppIDL() {
        return this.$$delegate_0.getTaskAppIDL();
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentIDL
    public IAgentVoiceInteractionIDL getVoiceInteractionIDL() {
        return this.$$delegate_0.getVoiceInteractionIDL();
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentIDL
    public void registerFlowIDL(IFlowIDL r3) {
        IFlowIDL r4 = (IFlowIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowIDL.class, "com.obric.aiagent.plugin");
        this.$$delegate_0.registerFlowIDL(r4);
    }

    public AgentIDLStub() {
        Object r0 = (IAgentIDLSPI) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAgentIDLSPI.class), IAgentIDLSPI.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L6;
        r0 = new IAgentIDL.Default();
    L6:
        this.$$delegate_0 = (IAgentIDL) ZeusTransformUtils.preCheckCast(r0, IAgentIDL.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentIDL.Stub, android.os.IInterface
    public IBinder asBinder() {
        IBinder r1 = super.asBinder();
        d.h.b.o.c(r1, "asBinder(...)");
        return r1;
    }
}
