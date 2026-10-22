package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.obric.aiagent.assistant.idl.bean.RequestRestrictRule;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: compiled from: AgentNetworkIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
final class AgentNetworkIDLStub extends IAgentNetworkIDL.Stub implements IAgentNetworkIDL {
    private final /* synthetic */ IAgentNetworkIDL $$delegate_0;

    @Override // com.obric.aiagent.assistant.idl.IAgentNetworkIDL
    public void notifyRequestStatus(boolean r3, Map r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        this.$$delegate_0.notifyRequestStatus(r3, r5);
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentNetworkIDL
    public void updateExcludeRules(RequestRestrictRule r1) {
        this.$$delegate_0.updateExcludeRules(r1);
    }

    public AgentNetworkIDLStub() {
        Object r0 = (IAgentNetworkIDLSPI) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAgentNetworkIDLSPI.class), IAgentNetworkIDLSPI.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L6;
        r0 = new IAgentNetworkIDL.Default();
    L6:
        this.$$delegate_0 = (IAgentNetworkIDL) ZeusTransformUtils.preCheckCast(r0, IAgentNetworkIDL.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentNetworkIDL.Stub, android.os.IInterface
    public IBinder asBinder() {
        IBinder r1 = super.asBinder();
        d.h.b.o.c(r1, "asBinder(...)");
        return r1;
    }
}
