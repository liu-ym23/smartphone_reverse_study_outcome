package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AssistantInteractionListenerIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
final class AssistantInteractionListenerIDLStub extends IAssistantInteractionListenerIDL.Stub implements IAssistantInteractionListenerIDL {
    private final /* synthetic */ IAssistantInteractionListenerIDL $$delegate_0;

    @Override // com.obric.aiagent.assistant.idl.IAssistantInteractionListenerIDL
    public void onAssistantDied() {
        this.$$delegate_0.onAssistantDied();
    }

    @Override // com.obric.aiagent.assistant.idl.IAssistantInteractionListenerIDL
    public void onAssistantTakeOver() {
        this.$$delegate_0.onAssistantTakeOver();
    }

    @Override // com.obric.aiagent.assistant.idl.IAssistantInteractionListenerIDL
    public void onPanelCancel() {
        this.$$delegate_0.onPanelCancel();
    }

    @Override // com.obric.aiagent.assistant.idl.IAssistantInteractionListenerIDL
    public void onPanelHeightChanged(int r1) {
        this.$$delegate_0.onPanelHeightChanged(r1);
    }

    @Override // com.obric.aiagent.assistant.idl.IAssistantInteractionListenerIDL
    public void onPanelShow(int r1) {
        this.$$delegate_0.onPanelShow(r1);
    }

    @Override // com.obric.aiagent.assistant.idl.IAssistantInteractionListenerIDL
    public void onReply(String r1) {
        this.$$delegate_0.onReply(r1);
    }

    @Override // com.obric.aiagent.assistant.idl.IAssistantInteractionListenerIDL
    public void requestToShowInputPanel() {
        this.$$delegate_0.requestToShowInputPanel();
    }

    @Override // com.obric.aiagent.assistant.idl.IAssistantInteractionListenerIDL
    public void requestToShowInputPanelWithMeta(String r1) {
        this.$$delegate_0.requestToShowInputPanelWithMeta(r1);
    }

    public AssistantInteractionListenerIDLStub() {
        Object r0 = (IAssistantInteractionListenerIDLSPI) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAssistantInteractionListenerIDLSPI.class), IAssistantInteractionListenerIDLSPI.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L6;
        r0 = new IAssistantInteractionListenerIDL.Default();
    L6:
        this.$$delegate_0 = (IAssistantInteractionListenerIDL) ZeusTransformUtils.preCheckCast(r0, IAssistantInteractionListenerIDL.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.assistant.idl.IAssistantInteractionListenerIDL.Stub, android.os.IInterface
    public IBinder asBinder() {
        IBinder r1 = super.asBinder();
        d.h.b.o.c(r1, "asBinder(...)");
        return r1;
    }
}
