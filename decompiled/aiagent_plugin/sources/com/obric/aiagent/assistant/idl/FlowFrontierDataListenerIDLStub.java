package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: FlowFrontierDataListenerIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
final class FlowFrontierDataListenerIDLStub extends IFlowFrontierDataListenerIDL.Stub implements IFlowFrontierDataListenerIDL {
    private final /* synthetic */ IFlowFrontierDataListenerIDL $$delegate_0;

    @Override // com.obric.aiagent.assistant.idl.IFlowFrontierDataListenerIDL
    public void onReceiveData(byte[] r1) {
        this.$$delegate_0.onReceiveData(r1);
    }

    public FlowFrontierDataListenerIDLStub() {
        Object r0 = (IFlowFrontierDataListenerIDLSPI) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IFlowFrontierDataListenerIDLSPI.class), IFlowFrontierDataListenerIDLSPI.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L6;
        r0 = new IFlowFrontierDataListenerIDL.Default();
    L6:
        this.$$delegate_0 = (IFlowFrontierDataListenerIDL) ZeusTransformUtils.preCheckCast(r0, IFlowFrontierDataListenerIDL.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowFrontierDataListenerIDL.Stub, android.os.IInterface
    public IBinder asBinder() {
        IBinder r1 = super.asBinder();
        d.h.b.o.c(r1, "asBinder(...)");
        return r1;
    }
}
