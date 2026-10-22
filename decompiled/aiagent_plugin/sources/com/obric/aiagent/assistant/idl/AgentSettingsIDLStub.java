package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AgentSettingsIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
final class AgentSettingsIDLStub extends IAgentSettingsIDL.Stub implements IAgentSettingsIDL {
    private final /* synthetic */ IAgentSettingsIDL $$delegate_0;

    @Override // com.obric.aiagent.assistant.idl.IAgentSettingsIDL
    public boolean isAutoGuiInstall() {
        return this.$$delegate_0.isAutoGuiInstall();
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentSettingsIDL
    public boolean isMemoryRecommendActivityEnabled() {
        return this.$$delegate_0.isMemoryRecommendActivityEnabled();
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentSettingsIDL
    public void setSystemProperty(String r1, String r2) {
        this.$$delegate_0.setSystemProperty(r1, r2);
    }

    public AgentSettingsIDLStub() {
        Object r0 = (IAgentSettingsIDLSPI) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAgentSettingsIDLSPI.class), IAgentSettingsIDLSPI.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L6;
        r0 = new IAgentSettingsIDL.Default();
    L6:
        this.$$delegate_0 = (IAgentSettingsIDL) ZeusTransformUtils.preCheckCast(r0, IAgentSettingsIDL.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentSettingsIDL.Stub, android.os.IInterface
    public IBinder asBinder() {
        IBinder r1 = super.asBinder();
        d.h.b.o.c(r1, "asBinder(...)");
        return r1;
    }
}
