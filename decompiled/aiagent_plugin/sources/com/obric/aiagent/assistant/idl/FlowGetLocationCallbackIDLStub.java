package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.obric.aiagent.assistant.idl.bean.OLocationInfo;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: FlowGetLocationCallbackIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
final class FlowGetLocationCallbackIDLStub extends IFlowGetLocationCallbackIDL.Stub implements IFlowGetLocationCallbackIDL {
    private final /* synthetic */ IFlowGetLocationCallbackIDL $$delegate_0;

    @Override // com.obric.aiagent.assistant.idl.IFlowGetLocationCallbackIDL
    public void onLocationResult(boolean r1, OLocationInfo r2) {
        this.$$delegate_0.onLocationResult(r1, r2);
    }

    public FlowGetLocationCallbackIDLStub() {
        Object r0 = (IFlowGetLocationCallbackIDLSPI) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IFlowGetLocationCallbackIDLSPI.class), IFlowGetLocationCallbackIDLSPI.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L6;
        r0 = new IFlowGetLocationCallbackIDL.Default();
    L6:
        this.$$delegate_0 = (IFlowGetLocationCallbackIDL) ZeusTransformUtils.preCheckCast(r0, IFlowGetLocationCallbackIDL.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowGetLocationCallbackIDL.Stub, android.os.IInterface
    public IBinder asBinder() {
        IBinder r1 = super.asBinder();
        d.h.b.o.c(r1, "asBinder(...)");
        return r1;
    }
}
