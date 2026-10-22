package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL;
import com.obric.aiagent.ipc.idl.IFileIDL;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: FlowIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
final class FlowIDLStub extends IFlowIDL.Stub implements IFlowIDL {
    private final /* synthetic */ IFlowIDL $$delegate_0;

    @Override // com.obric.aiagent.assistant.idl.IFlowIDL
    public IFlowAppIntentIDL getAppIntentIDL() {
        return this.$$delegate_0.getAppIntentIDL();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowIDL
    public IFlowAppLogIDL getAppLogIDL() {
        return this.$$delegate_0.getAppLogIDL();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowIDL
    public IFlowAppStateIDL getAppStateIDL() {
        return this.$$delegate_0.getAppStateIDL();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowIDL
    public IFlowAssistantStateIDL getAssistantStateIDL() {
        return this.$$delegate_0.getAssistantStateIDL();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowIDL
    public IFlowCocreationReviewIDL getCocreationReviewIDL() {
        return this.$$delegate_0.getCocreationReviewIDL();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowIDL
    public IFileIDL getFileIDL() {
        return this.$$delegate_0.getFileIDL();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowIDL
    public IFlowFeedbackIDL getFlowFeedbackIDL() {
        return this.$$delegate_0.getFlowFeedbackIDL();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowIDL
    public IFlowNetworkIDL getFlowNetworkIDL() {
        return this.$$delegate_0.getFlowNetworkIDL();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowIDL
    public IFlowPermissionIDL getFlowPermissionIDL() {
        return this.$$delegate_0.getFlowPermissionIDL();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowIDL
    public IFlowFrontierIDL getFrontierIDL() {
        return this.$$delegate_0.getFrontierIDL();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowIDL
    public IFlowMessageIDL getMessageIDL() {
        return this.$$delegate_0.getMessageIDL();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowIDL
    public IFlowSettingsIDL getSettingsIDL() {
        return this.$$delegate_0.getSettingsIDL();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowIDL
    public IFlowUiIDL getUiIDL() {
        return this.$$delegate_0.getUiIDL();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowIDL
    public IFlowVoiceInteractionIDL getVoiceInteractionIDL() {
        return this.$$delegate_0.getVoiceInteractionIDL();
    }

    public FlowIDLStub() {
        Object r0 = (IFlowIDLSPI) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IFlowIDLSPI.class), IFlowIDLSPI.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L6;
        r0 = new IFlowIDL.Default();
    L6:
        this.$$delegate_0 = (IFlowIDL) ZeusTransformUtils.preCheckCast(r0, IFlowIDL.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowIDL.Stub, android.os.IInterface
    public IBinder asBinder() {
        IBinder r1 = super.asBinder();
        d.h.b.o.c(r1, "asBinder(...)");
        return r1;
    }
}
