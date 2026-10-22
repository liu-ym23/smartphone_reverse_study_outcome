package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.obric.aiagent.assistant.idl.bean.IMMessage;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: compiled from: FlowFindMessagesCallbackIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
final class FlowFindMessagesCallbackIDLStub extends IFlowFindMessagesCallbackIDL.Stub implements IFlowFindMessagesCallbackIDL {
    private final /* synthetic */ IFlowFindMessagesCallbackIDL $$delegate_0;

    @Override // com.obric.aiagent.assistant.idl.IFlowFindMessagesCallbackIDL
    public void onFail() {
        this.$$delegate_0.onFail();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowFindMessagesCallbackIDL
    public void onSuccess(List<IMMessage> r3) {
        List<IMMessage> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        this.$$delegate_0.onSuccess(r4);
    }

    public FlowFindMessagesCallbackIDLStub() {
        Object r0 = (IFlowFindMessagesCallbackIDLSPI) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IFlowFindMessagesCallbackIDLSPI.class), IFlowFindMessagesCallbackIDLSPI.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L6;
        r0 = new IFlowFindMessagesCallbackIDL.Default();
    L6:
        this.$$delegate_0 = (IFlowFindMessagesCallbackIDL) ZeusTransformUtils.preCheckCast(r0, IFlowFindMessagesCallbackIDL.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowFindMessagesCallbackIDL.Stub, android.os.IInterface
    public IBinder asBinder() {
        IBinder r1 = super.asBinder();
        d.h.b.o.c(r1, "asBinder(...)");
        return r1;
    }
}
