package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AgentSkillManagerObserverIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
final class AgentSkillManagerObserverIDLStub extends IAgentSkillManagerObserverIDL.Stub implements IAgentSkillManagerObserverIDL {
    private final /* synthetic */ IAgentSkillManagerObserverIDL $$delegate_0;

    @Override // com.obric.aiagent.assistant.idl.IAgentSkillManagerObserverIDL
    public void onSkillListChanged(long r1) {
        this.$$delegate_0.onSkillListChanged(r1);
    }

    public AgentSkillManagerObserverIDLStub() {
        Object r0 = (IAgentSkillManagerObserverIDLSPI) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAgentSkillManagerObserverIDLSPI.class), IAgentSkillManagerObserverIDLSPI.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L6;
        r0 = new IAgentSkillManagerObserverIDL.Default();
    L6:
        this.$$delegate_0 = (IAgentSkillManagerObserverIDL) ZeusTransformUtils.preCheckCast(r0, IAgentSkillManagerObserverIDL.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentSkillManagerObserverIDL.Stub, android.os.IInterface
    public IBinder asBinder() {
        IBinder r1 = super.asBinder();
        d.h.b.o.c(r1, "asBinder(...)");
        return r1;
    }
}
