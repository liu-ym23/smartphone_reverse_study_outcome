package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: FlowIsMessageInterruptedCallbackIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
final class FlowIsMessageInterruptedCallbackIDLStub extends IFlowIsMessageInterruptedCallbackIDL.Stub implements IFlowIsMessageInterruptedCallbackIDL {
    private final /* synthetic */ IFlowIsMessageInterruptedCallbackIDL $$delegate_0;

    @Override // com.obric.aiagent.assistant.idl.IFlowIsMessageInterruptedCallbackIDL
    public void onResult(boolean r1) {
        this.$$delegate_0.onResult(r1);
    }

    public FlowIsMessageInterruptedCallbackIDLStub() {
        Object r0 = (IFlowIsMessageInterruptedCallbackIDLSPI) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IFlowIsMessageInterruptedCallbackIDLSPI.class), IFlowIsMessageInterruptedCallbackIDLSPI.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L6;
        r0 = new IFlowIsMessageInterruptedCallbackIDL.Default();
    L6:
        this.$$delegate_0 = (IFlowIsMessageInterruptedCallbackIDL) ZeusTransformUtils.preCheckCast(r0, IFlowIsMessageInterruptedCallbackIDL.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowIsMessageInterruptedCallbackIDL.Stub, android.os.IInterface
    public IBinder asBinder() {
        IBinder r1 = super.asBinder();
        d.h.b.o.c(r1, "asBinder(...)");
        return r1;
    }
}
