package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: FlowAssistantStateIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
final class FlowAssistantStateIDLStub extends IFlowAssistantStateIDL.Stub implements IFlowAssistantStateIDL {
    private final /* synthetic */ IFlowAssistantStateIDL $$delegate_0;

    @Override // com.obric.aiagent.assistant.idl.IFlowAssistantStateIDL
    public int getCurrentNightMode() {
        return this.$$delegate_0.getCurrentNightMode();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAssistantStateIDL
    public boolean isActive() {
        return this.$$delegate_0.isActive();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAssistantStateIDL
    public boolean isBackgroundIntercepting() {
        return this.$$delegate_0.isBackgroundIntercepting();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAssistantStateIDL
    public void registerActiveStateListener(IFlowAssistantActiveStateListenerIDL r3) {
        IFlowAssistantActiveStateListenerIDL r4 = (IFlowAssistantActiveStateListenerIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowAssistantActiveStateListenerIDL.class, "com.obric.aiagent.plugin");
        this.$$delegate_0.registerActiveStateListener(r4);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAssistantStateIDL
    public void registerBackgroundInterceptingListener(IFlowBackgroundInterceptStateListenerIDL r3) {
        IFlowBackgroundInterceptStateListenerIDL r4 = (IFlowBackgroundInterceptStateListenerIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowBackgroundInterceptStateListenerIDL.class, "com.obric.aiagent.plugin");
        this.$$delegate_0.registerBackgroundInterceptingListener(r4);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAssistantStateIDL
    public void registerNightModeListener(IFlowNightModeChangeListenerIDL r3) {
        IFlowNightModeChangeListenerIDL r4 = (IFlowNightModeChangeListenerIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowNightModeChangeListenerIDL.class, "com.obric.aiagent.plugin");
        this.$$delegate_0.registerNightModeListener(r4);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAssistantStateIDL
    public void registerTTSStateListener(IFlowAssistantTTSStateListenerIDL r3) {
        IFlowAssistantTTSStateListenerIDL r4 = (IFlowAssistantTTSStateListenerIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowAssistantTTSStateListenerIDL.class, "com.obric.aiagent.plugin");
        this.$$delegate_0.registerTTSStateListener(r4);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAssistantStateIDL
    public void unregisterActiveStateListener(IFlowAssistantActiveStateListenerIDL r3) {
        IFlowAssistantActiveStateListenerIDL r4 = (IFlowAssistantActiveStateListenerIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowAssistantActiveStateListenerIDL.class, "com.obric.aiagent.plugin");
        this.$$delegate_0.unregisterActiveStateListener(r4);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAssistantStateIDL
    public void unregisterBackgroundInterceptingListener(IFlowBackgroundInterceptStateListenerIDL r3) {
        IFlowBackgroundInterceptStateListenerIDL r4 = (IFlowBackgroundInterceptStateListenerIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowBackgroundInterceptStateListenerIDL.class, "com.obric.aiagent.plugin");
        this.$$delegate_0.unregisterBackgroundInterceptingListener(r4);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAssistantStateIDL
    public void unregisterNightModeListener(IFlowNightModeChangeListenerIDL r3) {
        IFlowNightModeChangeListenerIDL r4 = (IFlowNightModeChangeListenerIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowNightModeChangeListenerIDL.class, "com.obric.aiagent.plugin");
        this.$$delegate_0.unregisterNightModeListener(r4);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAssistantStateIDL
    public void unregisterTTSStateListener(IFlowAssistantTTSStateListenerIDL r3) {
        IFlowAssistantTTSStateListenerIDL r4 = (IFlowAssistantTTSStateListenerIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowAssistantTTSStateListenerIDL.class, "com.obric.aiagent.plugin");
        this.$$delegate_0.unregisterTTSStateListener(r4);
    }

    public FlowAssistantStateIDLStub() {
        Object r0 = (IFlowAssistantStateIDLSPI) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IFlowAssistantStateIDLSPI.class), IFlowAssistantStateIDLSPI.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L6;
        r0 = new IFlowAssistantStateIDL.Default();
    L6:
        this.$$delegate_0 = (IFlowAssistantStateIDL) ZeusTransformUtils.preCheckCast(r0, IFlowAssistantStateIDL.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAssistantStateIDL.Stub, android.os.IInterface
    public IBinder asBinder() {
        IBinder r1 = super.asBinder();
        d.h.b.o.c(r1, "asBinder(...)");
        return r1;
    }
}
