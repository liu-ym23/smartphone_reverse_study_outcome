package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.obric.aiagent.assistant.idl.bean.IMMessage;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: FlowMessageIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
final class FlowMessageIDLStub extends IFlowMessageIDL.Stub implements IFlowMessageIDL {
    private final /* synthetic */ IFlowMessageIDL $$delegate_0;

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void addMessage(IMMessage r1, String r2, String r3) {
        this.$$delegate_0.addMessage(r1, r2, r3);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void appendMessageExt(String r3, Map r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        this.$$delegate_0.appendMessageExt(r3, r5);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void deleteMessage(String r3, IFlowDeleteMessageCallbackIDL r4) {
        IFlowDeleteMessageCallbackIDL r5 = (IFlowDeleteMessageCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r4, IFlowDeleteMessageCallbackIDL.class, "com.obric.aiagent.plugin");
        this.$$delegate_0.deleteMessage(r3, r5);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void deleteRemoteResource(List<String> r3) {
        List<String> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        this.$$delegate_0.deleteRemoteResource(r4);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void fetchLatestMessages(int r3, IFlowFindMessagesCallbackIDL r4) {
        IFlowFindMessagesCallbackIDL r5 = (IFlowFindMessagesCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r4, IFlowFindMessagesCallbackIDL.class, "com.obric.aiagent.plugin");
        this.$$delegate_0.fetchLatestMessages(r3, r5);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void findAnswersbyQueryId(String r3, IFlowFindMessagesCallbackIDL r4) {
        IFlowFindMessagesCallbackIDL r5 = (IFlowFindMessagesCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r4, IFlowFindMessagesCallbackIDL.class, "com.obric.aiagent.plugin");
        this.$$delegate_0.findAnswersbyQueryId(r3, r5);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void findMessagebyId(String r3, IFlowFindMessageCallbackIDL r4) {
        IFlowFindMessageCallbackIDL r5 = (IFlowFindMessageCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r4, IFlowFindMessageCallbackIDL.class, "com.obric.aiagent.plugin");
        this.$$delegate_0.findMessagebyId(r3, r5);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public String generateLocalMessageId() {
        return this.$$delegate_0.generateLocalMessageId();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void getMainTxtContentForMessage(String r3, IFlowMessageMainTextBlockCallbackIDL r4) {
        IFlowMessageMainTextBlockCallbackIDL r5 = (IFlowMessageMainTextBlockCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r4, IFlowMessageMainTextBlockCallbackIDL.class, "com.obric.aiagent.plugin");
        this.$$delegate_0.getMainTxtContentForMessage(r3, r5);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public String getMainTxtContentFromMessage(IMMessage r1) {
        return this.$$delegate_0.getMainTxtContentFromMessage(r1);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void imageXUpload(String r3, IImageXUploadCallbackIDL r4) {
        IImageXUploadCallbackIDL r5 = (IImageXUploadCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r4, IImageXUploadCallbackIDL.class, "com.obric.aiagent.plugin");
        this.$$delegate_0.imageXUpload(r3, r5);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public boolean isConversationTtsEnabled(String r1) {
        return this.$$delegate_0.isConversationTtsEnabled(r1);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void isMessageLocalInterrupted(String r3, IFlowIsMessageInterruptedCallbackIDL r4) {
        IFlowIsMessageInterruptedCallbackIDL r5 = (IFlowIsMessageInterruptedCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r4, IFlowIsMessageInterruptedCallbackIDL.class, "com.obric.aiagent.plugin");
        this.$$delegate_0.isMessageLocalInterrupted(r3, r5);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void notifySemanticUserEditEvent(String r3, String r4, Map r5, IFlowSemanticEditCallbackIDL r6) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        IFlowSemanticEditCallbackIDL r8 = (IFlowSemanticEditCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r6, IFlowSemanticEditCallbackIDL.class, "com.obric.aiagent.plugin");
        this.$$delegate_0.notifySemanticUserEditEvent(r3, r4, r7, r8);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void notifySemanticUserEditEventWithIdentifier(String r9, String r10, String r11, Map r12, IFlowSemanticEditCallbackIDL r13) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.aiagent.plugin");
        IFlowSemanticEditCallbackIDL r7 = (IFlowSemanticEditCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r13, IFlowSemanticEditCallbackIDL.class, "com.obric.aiagent.plugin");
        this.$$delegate_0.notifySemanticUserEditEventWithIdentifier(r9, r10, r11, r6, r7);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void notifySemanticUserEditEventWithUri(String r9, String r10, String r11, Map r12, IFlowSemanticEditCallbackIDL r13) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.aiagent.plugin");
        IFlowSemanticEditCallbackIDL r7 = (IFlowSemanticEditCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r13, IFlowSemanticEditCallbackIDL.class, "com.obric.aiagent.plugin");
        this.$$delegate_0.notifySemanticUserEditEventWithUri(r9, r10, r11, r6, r7);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void refreshLatestMessages(String r1, int r2) {
        this.$$delegate_0.refreshLatestMessages(r1, r2);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void registerCallback(IFlowMessageCallbackIDL r3) {
        IFlowMessageCallbackIDL r4 = (IFlowMessageCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowMessageCallbackIDL.class, "com.obric.aiagent.plugin");
        this.$$delegate_0.registerCallback(r4);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void registerCallbackWithEvents(IFlowMessageCallbackIDL r3, int r4) {
        IFlowMessageCallbackIDL r5 = (IFlowMessageCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowMessageCallbackIDL.class, "com.obric.aiagent.plugin");
        this.$$delegate_0.registerCallbackWithEvents(r5, r4);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void registerSendMessageExtCallback(IFlowSendMessageExtCallbackIDL r3) {
        IFlowSendMessageExtCallbackIDL r4 = (IFlowSendMessageExtCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowSendMessageExtCallbackIDL.class, "com.obric.aiagent.plugin");
        this.$$delegate_0.registerSendMessageExtCallback(r4);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void registerStreamObserver(IFlowStreamObserverIDL r3) {
        IFlowStreamObserverIDL r4 = (IFlowStreamObserverIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowStreamObserverIDL.class, "com.obric.aiagent.plugin");
        this.$$delegate_0.registerStreamObserver(r4);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void retryFetchMessage(IMMessage r1) {
        this.$$delegate_0.retryFetchMessage(r1);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void sendMessage(String r1, String r2, String r3, String r4) {
        this.$$delegate_0.sendMessage(r1, r2, r3, r4);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void sendMessageWithExtra(String r7, String r8, String r9, String r10, Map r11) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.aiagent.plugin");
        this.$$delegate_0.sendMessageWithExtra(r7, r8, r9, r10, r5);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void unregisterCallback(IFlowMessageCallbackIDL r3) {
        IFlowMessageCallbackIDL r4 = (IFlowMessageCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowMessageCallbackIDL.class, "com.obric.aiagent.plugin");
        this.$$delegate_0.unregisterCallback(r4);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void unregisterSendMessageExtCallback(IFlowSendMessageExtCallbackIDL r3) {
        IFlowSendMessageExtCallbackIDL r4 = (IFlowSendMessageExtCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowSendMessageExtCallbackIDL.class, "com.obric.aiagent.plugin");
        this.$$delegate_0.unregisterSendMessageExtCallback(r4);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void unregisterStreamObserver(IFlowStreamObserverIDL r3) {
        IFlowStreamObserverIDL r4 = (IFlowStreamObserverIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowStreamObserverIDL.class, "com.obric.aiagent.plugin");
        this.$$delegate_0.unregisterStreamObserver(r4);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void updateMessageExt(String r3, Map r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        this.$$delegate_0.updateMessageExt(r3, r5);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void updateMutableMessageContent(String r1, String r2) {
        this.$$delegate_0.updateMutableMessageContent(r1, r2);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void updateMutableWidgetRenderData(String r1, String r2, String r3) {
        this.$$delegate_0.updateMutableWidgetRenderData(r1, r2, r3);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void uploadImage(String r3, String r4, IImageXUploadCallbackIDL r5) {
        IImageXUploadCallbackIDL r6 = (IImageXUploadCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r5, IImageXUploadCallbackIDL.class, "com.obric.aiagent.plugin");
        this.$$delegate_0.uploadImage(r3, r4, r6);
    }

    public FlowMessageIDLStub() {
        Object r0 = (IFlowMessageIDLSPI) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IFlowMessageIDLSPI.class), IFlowMessageIDLSPI.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L6;
        r0 = new IFlowMessageIDL.Default();
    L6:
        this.$$delegate_0 = (IFlowMessageIDL) ZeusTransformUtils.preCheckCast(r0, IFlowMessageIDL.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL.Stub, android.os.IInterface
    public IBinder asBinder() {
        IBinder r1 = super.asBinder();
        d.h.b.o.c(r1, "asBinder(...)");
        return r1;
    }
}
