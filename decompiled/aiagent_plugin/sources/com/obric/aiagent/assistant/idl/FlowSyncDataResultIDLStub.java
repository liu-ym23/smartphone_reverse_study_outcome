package com.obric.aiagent.assistant.idl;

import android.os.Bundle;
import android.os.IBinder;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: FlowSyncDataResultIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
final class FlowSyncDataResultIDLStub extends IFlowSyncDataResultIDL.Stub implements IFlowSyncDataResultIDL {
    private final /* synthetic */ IFlowSyncDataResultIDL $$delegate_0;

    @Override // com.obric.aiagent.assistant.idl.IFlowSyncDataResultIDL
    public void onSyncData(Bundle r1) {
        this.$$delegate_0.onSyncData(r1);
    }

    public FlowSyncDataResultIDLStub() {
        Object r0 = (IFlowSyncDataResultIDLSPI) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IFlowSyncDataResultIDLSPI.class), IFlowSyncDataResultIDLSPI.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L6;
        r0 = new IFlowSyncDataResultIDL.Default();
    L6:
        this.$$delegate_0 = (IFlowSyncDataResultIDL) ZeusTransformUtils.preCheckCast(r0, IFlowSyncDataResultIDL.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSyncDataResultIDL.Stub, android.os.IInterface
    public IBinder asBinder() {
        IBinder r1 = super.asBinder();
        d.h.b.o.c(r1, "asBinder(...)");
        return r1;
    }
}
