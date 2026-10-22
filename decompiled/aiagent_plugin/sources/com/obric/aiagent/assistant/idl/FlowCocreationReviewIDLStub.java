package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: FlowCocreationReviewIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
final class FlowCocreationReviewIDLStub extends IFlowCocreationReviewIDL.Stub implements IFlowCocreationReviewIDL {
    private final /* synthetic */ IFlowCocreationReviewIDL $$delegate_0;

    @Override // com.obric.aiagent.assistant.idl.IFlowCocreationReviewIDL
    public void logOmniStep(String r14, long r15, String r17, int r18, String r19, String r20, boolean r21, boolean r22, long r23, String r25) {
        this.$$delegate_0.logOmniStep(r14, r15, r17, r18, r19, r20, r21, r22, r23, r25);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowCocreationReviewIDL
    public void logOmniUserStop(String r10, long r11, String r13, long r14, String r16, String r17) {
        this.$$delegate_0.logOmniUserStop(r10, r11, r13, r14, r16, r17);
    }

    public FlowCocreationReviewIDLStub() {
        Object r0 = (IFlowCocreationReviewIDLSPI) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IFlowCocreationReviewIDLSPI.class), IFlowCocreationReviewIDLSPI.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L6;
        r0 = new IFlowCocreationReviewIDL.Default();
    L6:
        this.$$delegate_0 = (IFlowCocreationReviewIDL) ZeusTransformUtils.preCheckCast(r0, IFlowCocreationReviewIDL.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowCocreationReviewIDL.Stub, android.os.IInterface
    public IBinder asBinder() {
        IBinder r1 = super.asBinder();
        d.h.b.o.c(r1, "asBinder(...)");
        return r1;
    }
}
