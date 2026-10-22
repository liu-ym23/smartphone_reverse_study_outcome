package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: FlowNightModeChangeListenerIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
final class FlowNightModeChangeListenerIDLStub extends IFlowNightModeChangeListenerIDL.Stub implements IFlowNightModeChangeListenerIDL {
    private final /* synthetic */ IFlowNightModeChangeListenerIDL $$delegate_0;

    @Override // com.obric.aiagent.assistant.idl.IFlowNightModeChangeListenerIDL
    public void onChanged(int r1) {
        this.$$delegate_0.onChanged(r1);
    }

    public FlowNightModeChangeListenerIDLStub() {
        Object r0 = (IFlowNightModeChangeListenerIDLSPI) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IFlowNightModeChangeListenerIDLSPI.class), IFlowNightModeChangeListenerIDLSPI.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L6;
        r0 = new IFlowNightModeChangeListenerIDL.Default();
    L6:
        this.$$delegate_0 = (IFlowNightModeChangeListenerIDL) ZeusTransformUtils.preCheckCast(r0, IFlowNightModeChangeListenerIDL.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowNightModeChangeListenerIDL.Stub, android.os.IInterface
    public IBinder asBinder() {
        IBinder r1 = super.asBinder();
        d.h.b.o.c(r1, "asBinder(...)");
        return r1;
    }
}
