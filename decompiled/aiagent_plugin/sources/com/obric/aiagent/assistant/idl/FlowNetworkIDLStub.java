package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.obric.aiagent.assistant.idl.bean.OPushEvent;
import com.obric.aiagent.assistant.idl.bean.ObricConditionalTaskSweepRequest;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: FlowNetworkIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
final class FlowNetworkIDLStub extends IFlowNetworkIDL.Stub implements IFlowNetworkIDL {
    private final /* synthetic */ IFlowNetworkIDL $$delegate_0;

    @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
    public void clearOmniTasks(Map r3, IFlowNetworkResultCallbackIDL r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        IFlowNetworkResultCallbackIDL r6 = (IFlowNetworkResultCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r4, IFlowNetworkResultCallbackIDL.class, "com.obric.aiagent.plugin");
        this.$$delegate_0.clearOmniTasks(r5, r6);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
    public void createConditionalTask(String r18, String r19, String r20, String r21, String r22, String r23, String r24, String r25, String r26, String r27, String r28, String r29, String r30, String r31, Map r32, IFlowNetworkResultCallbackIDL r33) {
        Map r0 = (Map) ZeusTransformUtils.wrapperContextForParams(r32, Map.class, "com.obric.aiagent.plugin");
        IFlowNetworkResultCallbackIDL r16 = (IFlowNetworkResultCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r33, IFlowNetworkResultCallbackIDL.class, "com.obric.aiagent.plugin");
        this.$$delegate_0.createConditionalTask(r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r0, r16);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
    public void deleteConditionalTask(String r3, Map r4, IFlowNetworkResultCallbackIDL r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        IFlowNetworkResultCallbackIDL r7 = (IFlowNetworkResultCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r5, IFlowNetworkResultCallbackIDL.class, "com.obric.aiagent.plugin");
        this.$$delegate_0.deleteConditionalTask(r3, r6, r7);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
    public int getCurrentNetworkStatus() {
        return this.$$delegate_0.getCurrentNetworkStatus();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
    public void notifyStopComplexTaskByHttp(long r1) {
        this.$$delegate_0.notifyStopComplexTaskByHttp(r1);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
    public void notifyStopComplexTaskByHttpWithScene(long r1, String r3) {
        this.$$delegate_0.notifyStopComplexTaskByHttpWithScene(r1, r3);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
    public void notifyStopOmniTaskByHttp(String r3, Map r4, IFlowNetworkResultCallbackIDL r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        IFlowNetworkResultCallbackIDL r7 = (IFlowNetworkResultCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r5, IFlowNetworkResultCallbackIDL.class, "com.obric.aiagent.plugin");
        this.$$delegate_0.notifyStopOmniTaskByHttp(r3, r6, r7);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
    public void notifyUserOperateQueue(String r3, IFlowNetworkResultCallbackIDL r4) {
        IFlowNetworkResultCallbackIDL r5 = (IFlowNetworkResultCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r4, IFlowNetworkResultCallbackIDL.class, "com.obric.aiagent.plugin");
        this.$$delegate_0.notifyUserOperateQueue(r3, r5);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
    public void sendIntentResultForAsyncNotifyByHttp(List<OPushEvent> r3, boolean r4, IFlowNetworkResultCallbackIDL r5) {
        List<OPushEvent> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        IFlowNetworkResultCallbackIDL r7 = (IFlowNetworkResultCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r5, IFlowNetworkResultCallbackIDL.class, "com.obric.aiagent.plugin");
        this.$$delegate_0.sendIntentResultForAsyncNotifyByHttp(r6, r4, r7);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
    public void sendIntentResultForCompensationByHttp(List<OPushEvent> r3, boolean r4, IFlowNetworkResultCallbackIDL r5) {
        List<OPushEvent> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        IFlowNetworkResultCallbackIDL r7 = (IFlowNetworkResultCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r5, IFlowNetworkResultCallbackIDL.class, "com.obric.aiagent.plugin");
        this.$$delegate_0.sendIntentResultForCompensationByHttp(r6, r4, r7);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
    public void sendNormalRouterByHttp(String r3, String r4, IFlowNetworkResultCallbackIDL r5) {
        IFlowNetworkResultCallbackIDL r6 = (IFlowNetworkResultCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r5, IFlowNetworkResultCallbackIDL.class, "com.obric.aiagent.plugin");
        this.$$delegate_0.sendNormalRouterByHttp(r3, r4, r6);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
    public void sendReplyAskUserByHttp(String r9, String r10, String r11, Map r12, IFlowNetworkResultCallbackIDL r13) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.aiagent.plugin");
        IFlowNetworkResultCallbackIDL r7 = (IFlowNetworkResultCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r13, IFlowNetworkResultCallbackIDL.class, "com.obric.aiagent.plugin");
        this.$$delegate_0.sendReplyAskUserByHttp(r9, r10, r11, r6, r7);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
    public void sweepConditionalTask(ObricConditionalTaskSweepRequest r3, IFlowNetworkResultCallbackIDL r4) {
        IFlowNetworkResultCallbackIDL r5 = (IFlowNetworkResultCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r4, IFlowNetworkResultCallbackIDL.class, "com.obric.aiagent.plugin");
        this.$$delegate_0.sweepConditionalTask(r3, r5);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
    public void uploadOmniDataFeedbackByHttp(String r19, String r20, int r21, String r22, String r23, String r24, String r25, String r26, String r27, String r28, String r29, List<String> r30, String r31, String r32, IFlowNetworkResultCallbackIDL r33) {
        List<String> r14 = (List) ZeusTransformUtils.wrapperContextForParams(r30, List.class, "com.obric.aiagent.plugin");
        IFlowNetworkResultCallbackIDL r17 = (IFlowNetworkResultCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r33, IFlowNetworkResultCallbackIDL.class, "com.obric.aiagent.plugin");
        this.$$delegate_0.uploadOmniDataFeedbackByHttp(r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r14, r31, r32, r17);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
    public void uploadOmniDataFeedbackByHttpV2(String r18, String r19, int r20, String r21, String r22, String r23, String r24, String r25, String r26, String r27, String r28, List<String> r29, String r30, String r31, boolean r32, IFlowNetworkResultCallbackIDL r33) {
        List<String> r0 = (List) ZeusTransformUtils.wrapperContextForParams(r29, List.class, "com.obric.aiagent.plugin");
        IFlowNetworkResultCallbackIDL r16 = (IFlowNetworkResultCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r33, IFlowNetworkResultCallbackIDL.class, "com.obric.aiagent.plugin");
        this.$$delegate_0.uploadOmniDataFeedbackByHttpV2(r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r0, r30, r31, r32, r16);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
    public void uploadOmniScreenshotByHttp(String r15, String r16, int r17, String r18, String r19, String r20, String r21, List<String> r22, String r23, String r24, IFlowNetworkResultCallbackIDL r25) {
        List<String> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r22, List.class, "com.obric.aiagent.plugin");
        IFlowNetworkResultCallbackIDL r13 = (IFlowNetworkResultCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r25, IFlowNetworkResultCallbackIDL.class, "com.obric.aiagent.plugin");
        this.$$delegate_0.uploadOmniScreenshotByHttp(r15, r16, r17, r18, r19, r20, r21, r10, r23, r24, r13);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
    public void uploadOmniScreenshotByHttpV2(String r16, String r17, int r18, String r19, String r20, String r21, String r22, List<String> r23, String r24, String r25, boolean r26, IFlowNetworkResultCallbackIDL r27) {
        List<String> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r23, List.class, "com.obric.aiagent.plugin");
        IFlowNetworkResultCallbackIDL r14 = (IFlowNetworkResultCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r27, IFlowNetworkResultCallbackIDL.class, "com.obric.aiagent.plugin");
        this.$$delegate_0.uploadOmniScreenshotByHttpV2(r16, r17, r18, r19, r20, r21, r22, r10, r24, r25, r26, r14);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
    public void uploadUserTakeOverByHttp(String r11, String r12, String r13, long r14, Map r16, IFlowNetworkResultCallbackIDL r17) {
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r16, Map.class, "com.obric.aiagent.plugin");
        IFlowNetworkResultCallbackIDL r9 = (IFlowNetworkResultCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r17, IFlowNetworkResultCallbackIDL.class, "com.obric.aiagent.plugin");
        this.$$delegate_0.uploadUserTakeOverByHttp(r11, r12, r13, r14, r8, r9);
    }

    public FlowNetworkIDLStub() {
        Object r0 = (IFlowNetworkIDLSPI) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IFlowNetworkIDLSPI.class), IFlowNetworkIDLSPI.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L6;
        r0 = new IFlowNetworkIDL.Default();
    L6:
        this.$$delegate_0 = (IFlowNetworkIDL) ZeusTransformUtils.preCheckCast(r0, IFlowNetworkIDL.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL.Stub, android.os.IInterface
    public IBinder asBinder() {
        IBinder r1 = super.asBinder();
        d.h.b.o.c(r1, "asBinder(...)");
        return r1;
    }
}
