package com.obric.agent;

import android.os.IBinder;
import com.obric.aiagent.assistant.idl.IAgentSettingsIDLSPI;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AgentSettingsIDLStub.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AgentSettingsIDLStub implements IAgentSettingsIDLSPI {
    private final d.f service$delegate;

    /* JADX INFO: renamed from: lambda$2jjkq2j4PHWbn6Xrix_OjpvH-NQ, reason: not valid java name */
    public static /* synthetic */ IAgentService m56lambda$2jjkq2j4PHWbn6Xrix_OjpvHNQ() {
        return service_delegate$lambda$0();
    }

    public AgentSettingsIDLStub() {
        this.service$delegate = d.g.a($$Lambda$AgentSettingsIDLStub$2jjkq2j4PHWbn6Xrix_OjpvHNQ.INSTANCE);
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentSettingsIDLSPI, android.os.IInterface
    public IBinder asBinder() {
        return IAgentSettingsIDLSPI.b.a(this);
    }

    private final IAgentService getService() {
        return (IAgentService) ZeusTransformUtils.preCheckCast(this.service$delegate.b(), IAgentService.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentSettingsIDL
    public boolean isAutoGuiInstall() {
        IAgentService r0 = getService();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isAutoGuiInstall();
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentSettingsIDL
    public boolean isMemoryRecommendActivityEnabled() {
        IAgentService r0 = getService();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isMemoryRecommendActivityEnable();
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentSettingsIDL
    public void setSystemProperty(String r1, String r2) {
        IAgentService r0 = getService();
        if (r0 == null) goto L6;
        r0.setSystemProperty(r1, r2);
        return;
    }

    private static final IAgentService service_delegate$lambda$0() {
        return (IAgentService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAgentService.class), IAgentService.class, "com.obric.aiagent.plugin");
    }
}
