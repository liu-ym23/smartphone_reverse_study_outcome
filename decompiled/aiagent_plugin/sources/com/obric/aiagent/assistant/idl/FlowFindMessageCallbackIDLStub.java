package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.obric.aiagent.assistant.idl.bean.IMMessage;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: FlowFindMessageCallbackIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
final class FlowFindMessageCallbackIDLStub extends IFlowFindMessageCallbackIDL.Stub implements IFlowFindMessageCallbackIDL {
    private final /* synthetic */ IFlowFindMessageCallbackIDL $$delegate_0;

    @Override // com.obric.aiagent.assistant.idl.IFlowFindMessageCallbackIDL
    public void onFail() {
        this.$$delegate_0.onFail();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowFindMessageCallbackIDL
    public void onSuccess(IMMessage r1) {
        this.$$delegate_0.onSuccess(r1);
    }

    public FlowFindMessageCallbackIDLStub() {
        Object r0 = (IFlowFindMessageCallbackIDLSPI) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IFlowFindMessageCallbackIDLSPI.class), IFlowFindMessageCallbackIDLSPI.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L6;
        r0 = new IFlowFindMessageCallbackIDL.Default();
    L6:
        this.$$delegate_0 = (IFlowFindMessageCallbackIDL) ZeusTransformUtils.preCheckCast(r0, IFlowFindMessageCallbackIDL.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowFindMessageCallbackIDL.Stub, android.os.IInterface
    public IBinder asBinder() {
        IBinder r1 = super.asBinder();
        d.h.b.o.c(r1, "asBinder(...)");
        return r1;
    }
}
