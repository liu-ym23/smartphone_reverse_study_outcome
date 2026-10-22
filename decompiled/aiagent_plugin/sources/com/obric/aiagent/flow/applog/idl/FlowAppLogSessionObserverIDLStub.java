package com.obric.aiagent.flow.applog.idl;

import android.os.IBinder;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: FlowAppLogSessionObserverIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
final class FlowAppLogSessionObserverIDLStub extends IFlowAppLogSessionObserverIDL.Stub implements IFlowAppLogSessionObserverIDL {
    private final /* synthetic */ IFlowAppLogSessionObserverIDL $$delegate_0;

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogSessionObserverIDL
    public void onSessionBatchEvent(long r1, String r3) {
        this.$$delegate_0.onSessionBatchEvent(r1, r3);
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogSessionObserverIDL
    public void onSessionStart(long r1, String r3) {
        this.$$delegate_0.onSessionStart(r1, r3);
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogSessionObserverIDL
    public void onSessionTerminate(long r1, String r3) {
        this.$$delegate_0.onSessionTerminate(r1, r3);
    }

    public FlowAppLogSessionObserverIDLStub() {
        Object r0 = (IFlowAppLogSessionObserverIDLSPI) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IFlowAppLogSessionObserverIDLSPI.class), IFlowAppLogSessionObserverIDLSPI.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L6;
        r0 = new IFlowAppLogSessionObserverIDL.Default();
    L6:
        this.$$delegate_0 = (IFlowAppLogSessionObserverIDL) ZeusTransformUtils.preCheckCast(r0, IFlowAppLogSessionObserverIDL.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogSessionObserverIDL.Stub, android.os.IInterface
    public IBinder asBinder() {
        IBinder r1 = super.asBinder();
        o.c(r1, "asBinder(...)");
        return r1;
    }
}
