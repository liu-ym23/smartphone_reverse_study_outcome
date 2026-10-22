package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.obric.aiagent.assistant.idl.bean.IMMessage;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: FlowStreamObserverIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
final class FlowStreamObserverIDLStub extends IFlowStreamObserverIDL.Stub implements IFlowStreamObserverIDL {
    private final /* synthetic */ IFlowStreamObserverIDL $$delegate_0;

    @Override // com.obric.aiagent.assistant.idl.IFlowStreamObserverIDL
    public void onStreamBegin(IMMessage r1) {
        this.$$delegate_0.onStreamBegin(r1);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowStreamObserverIDL
    public void onStreamEnd(IMMessage r1) {
        this.$$delegate_0.onStreamEnd(r1);
    }

    public FlowStreamObserverIDLStub() {
        Object r0 = (IFlowStreamObserverIDLSPI) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IFlowStreamObserverIDLSPI.class), IFlowStreamObserverIDLSPI.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L6;
        r0 = new IFlowStreamObserverIDL.Default();
    L6:
        this.$$delegate_0 = (IFlowStreamObserverIDL) ZeusTransformUtils.preCheckCast(r0, IFlowStreamObserverIDL.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowStreamObserverIDL.Stub, android.os.IInterface
    public IBinder asBinder() {
        IBinder r1 = super.asBinder();
        d.h.b.o.c(r1, "asBinder(...)");
        return r1;
    }
}
