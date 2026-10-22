package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: FlowBackgroundInterceptStateListenerIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
final class FlowBackgroundInterceptStateListenerIDLStub extends IFlowBackgroundInterceptStateListenerIDL.Stub implements IFlowBackgroundInterceptStateListenerIDL {
    private final /* synthetic */ IFlowBackgroundInterceptStateListenerIDL $$delegate_0;

    @Override // com.obric.aiagent.assistant.idl.IFlowBackgroundInterceptStateListenerIDL
    public void onChanged(boolean r1) {
        this.$$delegate_0.onChanged(r1);
    }

    public FlowBackgroundInterceptStateListenerIDLStub() {
        Object r0 = (IFlowBackgroundInterceptStateListenerIDLSPI) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IFlowBackgroundInterceptStateListenerIDLSPI.class), IFlowBackgroundInterceptStateListenerIDLSPI.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L6;
        r0 = new IFlowBackgroundInterceptStateListenerIDL.Default();
    L6:
        this.$$delegate_0 = (IFlowBackgroundInterceptStateListenerIDL) ZeusTransformUtils.preCheckCast(r0, IFlowBackgroundInterceptStateListenerIDL.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowBackgroundInterceptStateListenerIDL.Stub, android.os.IInterface
    public IBinder asBinder() {
        IBinder r1 = super.asBinder();
        d.h.b.o.c(r1, "asBinder(...)");
        return r1;
    }
}
