package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AgentPrivacyIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
final class AgentPrivacyIDLStub extends IAgentPrivacyIDL.Stub implements IAgentPrivacyIDL {
    private final /* synthetic */ IAgentPrivacyIDL $$delegate_0;

    @Override // com.obric.aiagent.assistant.idl.IAgentPrivacyIDL
    public String getPemCertChain(String r1, String r2) {
        return this.$$delegate_0.getPemCertChain(r1, r2);
    }

    public AgentPrivacyIDLStub() {
        Object r0 = (IAgentPrivacyIDLSPI) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAgentPrivacyIDLSPI.class), IAgentPrivacyIDLSPI.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L6;
        r0 = new IAgentPrivacyIDL.Default();
    L6:
        this.$$delegate_0 = (IAgentPrivacyIDL) ZeusTransformUtils.preCheckCast(r0, IAgentPrivacyIDL.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentPrivacyIDL.Stub, android.os.IInterface
    public IBinder asBinder() {
        IBinder r1 = super.asBinder();
        d.h.b.o.c(r1, "asBinder(...)");
        return r1;
    }
}
