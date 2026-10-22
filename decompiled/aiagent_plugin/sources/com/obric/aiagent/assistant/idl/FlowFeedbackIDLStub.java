package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.obric.aiagent.assistant.idl.bean.FeedbackBean;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: FlowFeedbackIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
final class FlowFeedbackIDLStub extends IFlowFeedbackIDL.Stub implements IFlowFeedbackIDL {
    private final /* synthetic */ IFlowFeedbackIDL $$delegate_0;

    @Override // com.obric.aiagent.assistant.idl.IFlowFeedbackIDL
    public void onFeedback(FeedbackBean r1) {
        this.$$delegate_0.onFeedback(r1);
    }

    public FlowFeedbackIDLStub() {
        Object r0 = (IFlowFeedbackIDLSPI) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IFlowFeedbackIDLSPI.class), IFlowFeedbackIDLSPI.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L6;
        r0 = new IFlowFeedbackIDL.Default();
    L6:
        this.$$delegate_0 = (IFlowFeedbackIDL) ZeusTransformUtils.preCheckCast(r0, IFlowFeedbackIDL.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowFeedbackIDL.Stub, android.os.IInterface
    public IBinder asBinder() {
        IBinder r1 = super.asBinder();
        d.h.b.o.c(r1, "asBinder(...)");
        return r1;
    }
}
