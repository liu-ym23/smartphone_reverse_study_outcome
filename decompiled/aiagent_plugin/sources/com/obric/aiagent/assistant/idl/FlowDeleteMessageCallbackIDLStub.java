package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: FlowDeleteMessageCallbackIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
final class FlowDeleteMessageCallbackIDLStub extends IFlowDeleteMessageCallbackIDL.Stub implements IFlowDeleteMessageCallbackIDL {
    private final /* synthetic */ IFlowDeleteMessageCallbackIDL $$delegate_0;

    @Override // com.obric.aiagent.assistant.idl.IFlowDeleteMessageCallbackIDL
    public void onFail() {
        this.$$delegate_0.onFail();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowDeleteMessageCallbackIDL
    public void onSuccess() {
        this.$$delegate_0.onSuccess();
    }

    public FlowDeleteMessageCallbackIDLStub() {
        Object r0 = (IFlowDeleteMessageCallbackIDLSPI) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IFlowDeleteMessageCallbackIDLSPI.class), IFlowDeleteMessageCallbackIDLSPI.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L6;
        r0 = new IFlowDeleteMessageCallbackIDL.Default();
    L6:
        this.$$delegate_0 = (IFlowDeleteMessageCallbackIDL) ZeusTransformUtils.preCheckCast(r0, IFlowDeleteMessageCallbackIDL.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowDeleteMessageCallbackIDL.Stub, android.os.IInterface
    public IBinder asBinder() {
        IBinder r1 = super.asBinder();
        d.h.b.o.c(r1, "asBinder(...)");
        return r1;
    }
}
