package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: compiled from: FlowNetworkResultCallbackIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
final class FlowNetworkResultCallbackIDLStub extends IFlowNetworkResultCallbackIDL.Stub implements IFlowNetworkResultCallbackIDL {
    private final /* synthetic */ IFlowNetworkResultCallbackIDL $$delegate_0;

    @Override // com.obric.aiagent.assistant.idl.IFlowNetworkResultCallbackIDL
    public void onResult(boolean r3, Map r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        this.$$delegate_0.onResult(r3, r5);
    }

    public FlowNetworkResultCallbackIDLStub() {
        Object r0 = (IFlowNetworkResultCallbackIDLSPI) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IFlowNetworkResultCallbackIDLSPI.class), IFlowNetworkResultCallbackIDLSPI.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L6;
        r0 = new IFlowNetworkResultCallbackIDL.Default();
    L6:
        this.$$delegate_0 = (IFlowNetworkResultCallbackIDL) ZeusTransformUtils.preCheckCast(r0, IFlowNetworkResultCallbackIDL.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowNetworkResultCallbackIDL.Stub, android.os.IInterface
    public IBinder asBinder() {
        IBinder r1 = super.asBinder();
        d.h.b.o.c(r1, "asBinder(...)");
        return r1;
    }
}
