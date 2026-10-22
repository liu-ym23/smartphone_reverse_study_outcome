package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: FlowMessageMainTextBlockCallbackIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
final class FlowMessageMainTextBlockCallbackIDLStub extends IFlowMessageMainTextBlockCallbackIDL.Stub implements IFlowMessageMainTextBlockCallbackIDL {
    private final /* synthetic */ IFlowMessageMainTextBlockCallbackIDL $$delegate_0;

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageMainTextBlockCallbackIDL
    public void onResult(String r1) {
        this.$$delegate_0.onResult(r1);
    }

    public FlowMessageMainTextBlockCallbackIDLStub() {
        Object r0 = (IFlowMessageMainTextBlockCallbackIDLSPI) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IFlowMessageMainTextBlockCallbackIDLSPI.class), IFlowMessageMainTextBlockCallbackIDLSPI.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L6;
        r0 = new IFlowMessageMainTextBlockCallbackIDL.Default();
    L6:
        this.$$delegate_0 = (IFlowMessageMainTextBlockCallbackIDL) ZeusTransformUtils.preCheckCast(r0, IFlowMessageMainTextBlockCallbackIDL.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageMainTextBlockCallbackIDL.Stub, android.os.IInterface
    public IBinder asBinder() {
        IBinder r1 = super.asBinder();
        d.h.b.o.c(r1, "asBinder(...)");
        return r1;
    }
}
