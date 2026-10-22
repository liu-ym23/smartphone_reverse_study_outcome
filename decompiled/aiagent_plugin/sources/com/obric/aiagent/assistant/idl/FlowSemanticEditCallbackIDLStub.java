package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: FlowSemanticEditCallbackIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
final class FlowSemanticEditCallbackIDLStub extends IFlowSemanticEditCallbackIDL.Stub implements IFlowSemanticEditCallbackIDL {
    private final /* synthetic */ IFlowSemanticEditCallbackIDL $$delegate_0;

    @Override // com.obric.aiagent.assistant.idl.IFlowSemanticEditCallbackIDL
    public void onFail(int r1) {
        this.$$delegate_0.onFail(r1);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSemanticEditCallbackIDL
    public void onSuccess() {
        this.$$delegate_0.onSuccess();
    }

    public FlowSemanticEditCallbackIDLStub() {
        Object r0 = (IFlowSemanticEditCallbackIDLSPI) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IFlowSemanticEditCallbackIDLSPI.class), IFlowSemanticEditCallbackIDLSPI.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L6;
        r0 = new IFlowSemanticEditCallbackIDL.Default();
    L6:
        this.$$delegate_0 = (IFlowSemanticEditCallbackIDL) ZeusTransformUtils.preCheckCast(r0, IFlowSemanticEditCallbackIDL.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSemanticEditCallbackIDL.Stub, android.os.IInterface
    public IBinder asBinder() {
        IBinder r1 = super.asBinder();
        d.h.b.o.c(r1, "asBinder(...)");
        return r1;
    }
}
