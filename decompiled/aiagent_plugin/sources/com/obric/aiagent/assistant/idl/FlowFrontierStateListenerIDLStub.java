package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: FlowFrontierStateListenerIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
final class FlowFrontierStateListenerIDLStub extends IFlowFrontierStateListenerIDL.Stub implements IFlowFrontierStateListenerIDL {
    private final /* synthetic */ IFlowFrontierStateListenerIDL $$delegate_0;

    @Override // com.obric.aiagent.assistant.idl.IFlowFrontierStateListenerIDL
    public void onStateChanged(int r1) {
        this.$$delegate_0.onStateChanged(r1);
    }

    public FlowFrontierStateListenerIDLStub() {
        Object r0 = (IFlowFrontierStateListenerIDLSPI) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IFlowFrontierStateListenerIDLSPI.class), IFlowFrontierStateListenerIDLSPI.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L6;
        r0 = new IFlowFrontierStateListenerIDL.Default();
    L6:
        this.$$delegate_0 = (IFlowFrontierStateListenerIDL) ZeusTransformUtils.preCheckCast(r0, IFlowFrontierStateListenerIDL.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowFrontierStateListenerIDL.Stub, android.os.IInterface
    public IBinder asBinder() {
        IBinder r1 = super.asBinder();
        d.h.b.o.c(r1, "asBinder(...)");
        return r1;
    }
}
