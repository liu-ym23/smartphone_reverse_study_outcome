package com.obric.aiagent.assistant.idl;

import android.graphics.Bitmap;
import android.os.IBinder;
import android.os.ParcelFileDescriptor;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: compiled from: FlowFrontierIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
final class FlowFrontierIDLStub extends IFlowFrontierIDL.Stub implements IFlowFrontierIDL {
    private final /* synthetic */ IFlowFrontierIDL $$delegate_0;

    @Override // com.obric.aiagent.assistant.idl.IFlowFrontierIDL
    public void cacheScreenshot(int r3, Bitmap r4, Map r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        this.$$delegate_0.cacheScreenshot(r3, r4, r6);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowFrontierIDL
    public void cacheScreenshotFd(int r3, String r4, ParcelFileDescriptor r5, Map r6) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin");
        this.$$delegate_0.cacheScreenshotFd(r3, r4, r5, r7);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowFrontierIDL
    public int getState() {
        return this.$$delegate_0.getState();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowFrontierIDL
    public void registerDataListener(int r3, IFlowFrontierDataListenerIDL r4) {
        IFlowFrontierDataListenerIDL r5 = (IFlowFrontierDataListenerIDL) ZeusTransformUtils.wrapperContextForParams(r4, IFlowFrontierDataListenerIDL.class, "com.obric.aiagent.plugin");
        this.$$delegate_0.registerDataListener(r3, r5);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowFrontierIDL
    public void registerStateListener(int r3, IFlowFrontierStateListenerIDL r4) {
        IFlowFrontierStateListenerIDL r5 = (IFlowFrontierStateListenerIDL) ZeusTransformUtils.wrapperContextForParams(r4, IFlowFrontierStateListenerIDL.class, "com.obric.aiagent.plugin");
        this.$$delegate_0.registerStateListener(r3, r5);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowFrontierIDL
    public void sendData(int r3, byte[] r4, Map r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        this.$$delegate_0.sendData(r3, r4, r6);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowFrontierIDL
    public void unregisterDataListener(int r3, IFlowFrontierDataListenerIDL r4) {
        IFlowFrontierDataListenerIDL r5 = (IFlowFrontierDataListenerIDL) ZeusTransformUtils.wrapperContextForParams(r4, IFlowFrontierDataListenerIDL.class, "com.obric.aiagent.plugin");
        this.$$delegate_0.unregisterDataListener(r3, r5);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowFrontierIDL
    public void unregisterStateListener(int r3, IFlowFrontierStateListenerIDL r4) {
        IFlowFrontierStateListenerIDL r5 = (IFlowFrontierStateListenerIDL) ZeusTransformUtils.wrapperContextForParams(r4, IFlowFrontierStateListenerIDL.class, "com.obric.aiagent.plugin");
        this.$$delegate_0.unregisterStateListener(r3, r5);
    }

    public FlowFrontierIDLStub() {
        Object r0 = (IFlowFrontierIDLSPI) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IFlowFrontierIDLSPI.class), IFlowFrontierIDLSPI.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L6;
        r0 = new IFlowFrontierIDL.Default();
    L6:
        this.$$delegate_0 = (IFlowFrontierIDL) ZeusTransformUtils.preCheckCast(r0, IFlowFrontierIDL.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowFrontierIDL.Stub, android.os.IInterface
    public IBinder asBinder() {
        IBinder r1 = super.asBinder();
        d.h.b.o.c(r1, "asBinder(...)");
        return r1;
    }
}
