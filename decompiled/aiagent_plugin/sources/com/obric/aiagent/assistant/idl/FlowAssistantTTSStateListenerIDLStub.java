package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.obric.aiagent.assistant.idl.bean.TtsInfo;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: FlowAssistantTTSStateListenerIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
final class FlowAssistantTTSStateListenerIDLStub extends IFlowAssistantTTSStateListenerIDL.Stub implements IFlowAssistantTTSStateListenerIDL {
    private final /* synthetic */ IFlowAssistantTTSStateListenerIDL $$delegate_0;

    @Override // com.obric.aiagent.assistant.idl.IFlowAssistantTTSStateListenerIDL
    public void onChanged(TtsInfo r1) {
        this.$$delegate_0.onChanged(r1);
    }

    public FlowAssistantTTSStateListenerIDLStub() {
        Object r0 = (IFlowAssistantTTSStateListenerIDLSPI) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IFlowAssistantTTSStateListenerIDLSPI.class), IFlowAssistantTTSStateListenerIDLSPI.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L6;
        r0 = new IFlowAssistantTTSStateListenerIDL.Default();
    L6:
        this.$$delegate_0 = (IFlowAssistantTTSStateListenerIDL) ZeusTransformUtils.preCheckCast(r0, IFlowAssistantTTSStateListenerIDL.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAssistantTTSStateListenerIDL.Stub, android.os.IInterface
    public IBinder asBinder() {
        IBinder r1 = super.asBinder();
        d.h.b.o.c(r1, "asBinder(...)");
        return r1;
    }
}
