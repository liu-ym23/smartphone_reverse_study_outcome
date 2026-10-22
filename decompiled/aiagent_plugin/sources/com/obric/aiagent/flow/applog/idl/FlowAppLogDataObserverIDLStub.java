package com.obric.aiagent.flow.applog.idl;

import android.os.IBinder;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: FlowAppLogDataObserverIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
final class FlowAppLogDataObserverIDLStub extends IFlowAppLogDataObserverIDL.Stub implements IFlowAppLogDataObserverIDL {
    private final /* synthetic */ IFlowAppLogDataObserverIDL $$delegate_0;

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogDataObserverIDL
    public void onIdLoaded(String r1, String r2, String r3) {
        this.$$delegate_0.onIdLoaded(r1, r2, r3);
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogDataObserverIDL
    public void onRemoteIdGet(boolean r9, String r10, String r11, String r12, String r13, String r14, String r15) {
        this.$$delegate_0.onRemoteIdGet(r9, r10, r11, r12, r13, r14, r15);
    }

    public FlowAppLogDataObserverIDLStub() {
        Object r0 = (IFlowAppLogDataObserverIDLSPI) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IFlowAppLogDataObserverIDLSPI.class), IFlowAppLogDataObserverIDLSPI.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L6;
        r0 = new IFlowAppLogDataObserverIDL.Default();
    L6:
        this.$$delegate_0 = (IFlowAppLogDataObserverIDL) ZeusTransformUtils.preCheckCast(r0, IFlowAppLogDataObserverIDL.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogDataObserverIDL.Stub, android.os.IInterface
    public IBinder asBinder() {
        IBinder r1 = super.asBinder();
        o.c(r1, "asBinder(...)");
        return r1;
    }
}
