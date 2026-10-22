package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.obric.aiagent.assistant.idl.bean.IMMessage;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: compiled from: FlowMessageCallbackIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
final class FlowMessageCallbackIDLStub extends IFlowMessageCallbackIDL.Stub implements IFlowMessageCallbackIDL {
    private final /* synthetic */ IFlowMessageCallbackIDL $$delegate_0;

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageCallbackIDL
    public void onInsertMessageList(List<IMMessage> r3) {
        List<IMMessage> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        this.$$delegate_0.onInsertMessageList(r4);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageCallbackIDL
    public void onReceiveMessage(IMMessage r1) {
        this.$$delegate_0.onReceiveMessage(r1);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageCallbackIDL
    public void onRegenMessage(IMMessage r1) {
        this.$$delegate_0.onRegenMessage(r1);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageCallbackIDL
    public void onSendMessage(IMMessage r1) {
        this.$$delegate_0.onSendMessage(r1);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageCallbackIDL
    public void onUpdateMessage(IMMessage r1) {
        this.$$delegate_0.onUpdateMessage(r1);
    }

    public FlowMessageCallbackIDLStub() {
        Object r0 = (IFlowMessageCallbackIDLSPI) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IFlowMessageCallbackIDLSPI.class), IFlowMessageCallbackIDLSPI.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L6;
        r0 = new IFlowMessageCallbackIDL.Default();
    L6:
        this.$$delegate_0 = (IFlowMessageCallbackIDL) ZeusTransformUtils.preCheckCast(r0, IFlowMessageCallbackIDL.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageCallbackIDL.Stub, android.os.IInterface
    public IBinder asBinder() {
        IBinder r1 = super.asBinder();
        d.h.b.o.c(r1, "asBinder(...)");
        return r1;
    }
}
