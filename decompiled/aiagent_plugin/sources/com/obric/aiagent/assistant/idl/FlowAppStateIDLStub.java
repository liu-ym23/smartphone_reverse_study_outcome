package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: FlowAppStateIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
final class FlowAppStateIDLStub extends IFlowAppStateIDL.Stub implements IFlowAppStateIDL {
    private final /* synthetic */ IFlowAppStateIDL $$delegate_0;

    @Override // com.obric.aiagent.assistant.idl.IFlowAppStateIDL
    public String getCurrentActivity() {
        return this.$$delegate_0.getCurrentActivity();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAppStateIDL
    public boolean isAppBackground() {
        return this.$$delegate_0.isAppBackground();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAppStateIDL
    public boolean isAppPaused() {
        return this.$$delegate_0.isAppPaused();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAppStateIDL
    public void registerAppStateListener(IFlowOnAppStateChangedListenerIDL r3) {
        IFlowOnAppStateChangedListenerIDL r4 = (IFlowOnAppStateChangedListenerIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowOnAppStateChangedListenerIDL.class, "com.obric.aiagent.plugin");
        this.$$delegate_0.registerAppStateListener(r4);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAppStateIDL
    public void unregisterAppStateListener(IFlowOnAppStateChangedListenerIDL r3) {
        IFlowOnAppStateChangedListenerIDL r4 = (IFlowOnAppStateChangedListenerIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowOnAppStateChangedListenerIDL.class, "com.obric.aiagent.plugin");
        this.$$delegate_0.unregisterAppStateListener(r4);
    }

    public FlowAppStateIDLStub() {
        Object r0 = (IFlowAppStateIDLSPI) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IFlowAppStateIDLSPI.class), IFlowAppStateIDLSPI.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L6;
        r0 = new IFlowAppStateIDL.Default();
    L6:
        this.$$delegate_0 = (IFlowAppStateIDL) ZeusTransformUtils.preCheckCast(r0, IFlowAppStateIDL.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAppStateIDL.Stub, android.os.IInterface
    public IBinder asBinder() {
        IBinder r1 = super.asBinder();
        d.h.b.o.c(r1, "asBinder(...)");
        return r1;
    }
}
