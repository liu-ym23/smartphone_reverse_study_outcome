package com.obric.aiagent.assistant.idl;

import android.os.Bundle;
import android.os.IBinder;
import com.obric.aiagent.assistant.idl.bean.OSkill;
import com.obric.aiagent.assistant.idl.bean.OSkillManagerConfig;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: compiled from: AgentSkillManagerIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
final class AgentSkillManagerIDLStub extends IAgentSkillManagerIDL.Stub implements IAgentSkillManagerIDL {
    private final /* synthetic */ IAgentSkillManagerIDL $$delegate_0;

    @Override // com.obric.aiagent.assistant.idl.IAgentSkillManagerIDL
    public long getSkillListVersion() {
        return this.$$delegate_0.getSkillListVersion();
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentSkillManagerIDL
    public OSkillManagerConfig getSkillManagerConfig() {
        return this.$$delegate_0.getSkillManagerConfig();
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentSkillManagerIDL
    public String getSkillManagerStatus(String r1) {
        return this.$$delegate_0.getSkillManagerStatus(r1);
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentSkillManagerIDL
    public List<OSkill> listSkills() {
        return this.$$delegate_0.listSkills();
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentSkillManagerIDL
    public void registerSkillObserver(IAgentSkillManagerObserverIDL r3) {
        IAgentSkillManagerObserverIDL r4 = (IAgentSkillManagerObserverIDL) ZeusTransformUtils.wrapperContextForParams(r3, IAgentSkillManagerObserverIDL.class, "com.obric.aiagent.plugin");
        this.$$delegate_0.registerSkillObserver(r4);
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentSkillManagerIDL
    public boolean setSkillManagerConfigValues(Bundle r1) {
        return this.$$delegate_0.setSkillManagerConfigValues(r1);
    }

    public AgentSkillManagerIDLStub() {
        Object r0 = (IAgentSkillManagerIDLSPI) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAgentSkillManagerIDLSPI.class), IAgentSkillManagerIDLSPI.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L6;
        r0 = new IAgentSkillManagerIDL.Default();
    L6:
        this.$$delegate_0 = (IAgentSkillManagerIDL) ZeusTransformUtils.preCheckCast(r0, IAgentSkillManagerIDL.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentSkillManagerIDL.Stub, android.os.IInterface
    public IBinder asBinder() {
        IBinder r1 = super.asBinder();
        d.h.b.o.c(r1, "asBinder(...)");
        return r1;
    }
}
