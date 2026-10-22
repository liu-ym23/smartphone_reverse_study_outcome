package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.obric.aiagent.assistant.idl.bean.DMStateInfo;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AgentDMStateManagerIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
final class AgentDMStateManagerIDLStub extends IAgentDMStateManagerIDL.Stub implements IAgentDMStateManagerIDL {
    private final /* synthetic */ IAgentDMStateManagerIDL $$delegate_0;

    @Override // com.obric.aiagent.assistant.idl.IAgentDMStateManagerIDL
    public DMStateInfo getCurrentDMSteate() {
        return this.$$delegate_0.getCurrentDMSteate();
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentDMStateManagerIDL
    public void registerDMStateListener(IAgentDMStateListenerIDL r3) {
        IAgentDMStateListenerIDL r4 = (IAgentDMStateListenerIDL) ZeusTransformUtils.wrapperContextForParams(r3, IAgentDMStateListenerIDL.class, "com.obric.aiagent.plugin");
        this.$$delegate_0.registerDMStateListener(r4);
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentDMStateManagerIDL
    public void unRegisterDMStateListener(IAgentDMStateListenerIDL r3) {
        IAgentDMStateListenerIDL r4 = (IAgentDMStateListenerIDL) ZeusTransformUtils.wrapperContextForParams(r3, IAgentDMStateListenerIDL.class, "com.obric.aiagent.plugin");
        this.$$delegate_0.unRegisterDMStateListener(r4);
    }

    public AgentDMStateManagerIDLStub() {
        Object r0 = (IAgentDMStateManagerIDLSPI) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAgentDMStateManagerIDLSPI.class), IAgentDMStateManagerIDLSPI.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L6;
        r0 = new IAgentDMStateManagerIDL.Default();
    L6:
        this.$$delegate_0 = (IAgentDMStateManagerIDL) ZeusTransformUtils.preCheckCast(r0, IAgentDMStateManagerIDL.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentDMStateManagerIDL.Stub, android.os.IInterface
    public IBinder asBinder() {
        IBinder r1 = super.asBinder();
        d.h.b.o.c(r1, "asBinder(...)");
        return r1;
    }
}
