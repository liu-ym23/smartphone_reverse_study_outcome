package com.obric.aiagent.flow.applog.idl;

import android.os.IBinder;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: FlowAppLogEventObserverIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
final class FlowAppLogEventObserverIDLStub extends IFlowAppLogEventObserverIDL.Stub implements IFlowAppLogEventObserverIDL {
    private final /* synthetic */ IFlowAppLogEventObserverIDL $$delegate_0;

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogEventObserverIDL
    public void onEventV3(String r1, String r2) {
        this.$$delegate_0.onEventV3(r1, r2);
    }

    public FlowAppLogEventObserverIDLStub() {
        Object r0 = (IFlowAppLogEventObserverIDLSPI) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IFlowAppLogEventObserverIDLSPI.class), IFlowAppLogEventObserverIDLSPI.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L6;
        r0 = new IFlowAppLogEventObserverIDL.Default();
    L6:
        this.$$delegate_0 = (IFlowAppLogEventObserverIDL) ZeusTransformUtils.preCheckCast(r0, IFlowAppLogEventObserverIDL.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogEventObserverIDL.Stub, android.os.IInterface
    public IBinder asBinder() {
        IBinder r1 = super.asBinder();
        o.c(r1, "asBinder(...)");
        return r1;
    }
}
