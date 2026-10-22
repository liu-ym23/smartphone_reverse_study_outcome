package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: FlowOnAppStateChangedListenerIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
final class FlowOnAppStateChangedListenerIDLStub extends IFlowOnAppStateChangedListenerIDL.Stub implements IFlowOnAppStateChangedListenerIDL {
    private final /* synthetic */ IFlowOnAppStateChangedListenerIDL $$delegate_0;

    @Override // com.obric.aiagent.assistant.idl.IFlowOnAppStateChangedListenerIDL
    public void onAllActivityDestroyed() {
        this.$$delegate_0.onAllActivityDestroyed();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowOnAppStateChangedListenerIDL
    public void onAppBackground() {
        this.$$delegate_0.onAppBackground();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowOnAppStateChangedListenerIDL
    public void onAppForeground() {
        this.$$delegate_0.onAppForeground();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowOnAppStateChangedListenerIDL
    public void onMainBotChatPageResume(boolean r1, boolean r2) {
        this.$$delegate_0.onMainBotChatPageResume(r1, r2);
    }

    public FlowOnAppStateChangedListenerIDLStub() {
        Object r0 = (IFlowOnAppStateChangedListenerIDLSPI) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IFlowOnAppStateChangedListenerIDLSPI.class), IFlowOnAppStateChangedListenerIDLSPI.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L6;
        r0 = new IFlowOnAppStateChangedListenerIDL.Default();
    L6:
        this.$$delegate_0 = (IFlowOnAppStateChangedListenerIDL) ZeusTransformUtils.preCheckCast(r0, IFlowOnAppStateChangedListenerIDL.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowOnAppStateChangedListenerIDL.Stub, android.os.IInterface
    public IBinder asBinder() {
        IBinder r1 = super.asBinder();
        d.h.b.o.c(r1, "asBinder(...)");
        return r1;
    }
}
