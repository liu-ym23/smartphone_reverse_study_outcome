package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: compiled from: FlowSendMessageExtCallbackIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
final class FlowSendMessageExtCallbackIDLStub extends IFlowSendMessageExtCallbackIDL.Stub implements IFlowSendMessageExtCallbackIDL {
    private final /* synthetic */ IFlowSendMessageExtCallbackIDL $$delegate_0;

    @Override // com.obric.aiagent.assistant.idl.IFlowSendMessageExtCallbackIDL
    public Map getExt(Map r3, String r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        return this.$$delegate_0.getExt(r5, r4);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSendMessageExtCallbackIDL
    public String getScene() {
        return this.$$delegate_0.getScene();
    }

    public FlowSendMessageExtCallbackIDLStub() {
        Object r0 = (IFlowSendMessageExtCallbackIDLSPI) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IFlowSendMessageExtCallbackIDLSPI.class), IFlowSendMessageExtCallbackIDLSPI.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L6;
        r0 = new IFlowSendMessageExtCallbackIDL.Default();
    L6:
        this.$$delegate_0 = (IFlowSendMessageExtCallbackIDL) ZeusTransformUtils.preCheckCast(r0, IFlowSendMessageExtCallbackIDL.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSendMessageExtCallbackIDL.Stub, android.os.IInterface
    public IBinder asBinder() {
        IBinder r1 = super.asBinder();
        d.h.b.o.c(r1, "asBinder(...)");
        return r1;
    }
}
