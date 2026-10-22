package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AgentAssistantStateIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
final class AgentAssistantStateIDLStub extends IAgentAssistantStateIDL.Stub implements IAgentAssistantStateIDL {
    private final /* synthetic */ IAgentAssistantStateIDL $$delegate_0;

    public AgentAssistantStateIDLStub() {
        Object r0 = (IAgentAssistantStateIDLSPI) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAgentAssistantStateIDLSPI.class), IAgentAssistantStateIDLSPI.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L6;
        r0 = new IAgentAssistantStateIDL.Default();
    L6:
        this.$$delegate_0 = (IAgentAssistantStateIDL) ZeusTransformUtils.preCheckCast(r0, IAgentAssistantStateIDL.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAssistantStateIDL.Stub, android.os.IInterface
    public IBinder asBinder() {
        IBinder r1 = super.asBinder();
        d.h.b.o.c(r1, "asBinder(...)");
        return r1;
    }
}
