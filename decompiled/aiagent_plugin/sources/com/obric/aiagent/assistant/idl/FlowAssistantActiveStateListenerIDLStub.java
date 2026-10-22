package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: FlowAssistantActiveStateListenerIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
final class FlowAssistantActiveStateListenerIDLStub extends IFlowAssistantActiveStateListenerIDL.Stub implements IFlowAssistantActiveStateListenerIDL {
    private final /* synthetic */ IFlowAssistantActiveStateListenerIDL $$delegate_0;

    @Override // com.obric.aiagent.assistant.idl.IFlowAssistantActiveStateListenerIDL
    public void onChanged(boolean r1) {
        this.$$delegate_0.onChanged(r1);
    }

    public FlowAssistantActiveStateListenerIDLStub() {
        Object r0 = (IFlowAssistantActiveStateListenerIDLSPI) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IFlowAssistantActiveStateListenerIDLSPI.class), IFlowAssistantActiveStateListenerIDLSPI.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L6;
        r0 = new IFlowAssistantActiveStateListenerIDL.Default();
    L6:
        this.$$delegate_0 = (IFlowAssistantActiveStateListenerIDL) ZeusTransformUtils.preCheckCast(r0, IFlowAssistantActiveStateListenerIDL.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAssistantActiveStateListenerIDL.Stub, android.os.IInterface
    public IBinder asBinder() {
        IBinder r1 = super.asBinder();
        d.h.b.o.c(r1, "asBinder(...)");
        return r1;
    }
}
