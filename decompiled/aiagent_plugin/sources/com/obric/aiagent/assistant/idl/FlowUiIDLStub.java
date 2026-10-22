package com.obric.aiagent.assistant.idl;

import android.os.Bundle;
import android.os.IBinder;
import com.obric.aiagent.assistant.idl.bean.Authentication;
import com.obric.aiagent.assistant.idl.bean.StateInfo;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: FlowUiIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
final class FlowUiIDLStub extends IFlowUiIDL.Stub implements IFlowUiIDL {
    private final /* synthetic */ IFlowUiIDL $$delegate_0;

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void addCustomBarAction(String r7, String r8, String r9, long r10) {
        this.$$delegate_0.addCustomBarAction(r7, r8, r9, r10);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void closeAssistantInputPanel(String r1) {
        this.$$delegate_0.closeAssistantInputPanel(r1);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void dismissKeyguard() {
        this.$$delegate_0.dismissKeyguard();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void finishChatPage() {
        this.$$delegate_0.finishChatPage();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public String getCurrentDisplayModel() {
        return this.$$delegate_0.getCurrentDisplayModel();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public String getTaskSkillModelJson() {
        return this.$$delegate_0.getTaskSkillModelJson();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public int getWindowState() {
        return this.$$delegate_0.getWindowState();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void handleObricAction(String r3, String r4, IObricActionResultCallbackIDL r5) {
        IObricActionResultCallbackIDL r6 = (IObricActionResultCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r5, IObricActionResultCallbackIDL.class, "com.obric.aiagent.plugin");
        this.$$delegate_0.handleObricAction(r3, r4, r6);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public boolean isAssistantRequestFromAIKey() {
        return this.$$delegate_0.isAssistantRequestFromAIKey();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public boolean isAudioMessage(String r1) {
        return this.$$delegate_0.isAudioMessage(r1);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public boolean isAuthenticationPass() {
        return this.$$delegate_0.isAuthenticationPass();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public boolean isAuthenticationPassV2(String r1) {
        return this.$$delegate_0.isAuthenticationPassV2(r1);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public Authentication isAuthenticationPassV3(String r1) {
        return this.$$delegate_0.isAuthenticationPassV3(r1);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public boolean isWindowMode() {
        return this.$$delegate_0.isWindowMode();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public boolean isWindowShowing() {
        return this.$$delegate_0.isWindowShowing();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void notifyAssistantState(String r1, boolean r2, StateInfo r3) {
        this.$$delegate_0.notifyAssistantState(r1, r2, r3);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void notifyMessageInAutoGui(String r1) {
        this.$$delegate_0.notifyMessageInAutoGui(r1);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void notifyOAutoDied() {
        this.$$delegate_0.notifyOAutoDied();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void openAssistantInputPanel(String r1, StateInfo r2, boolean r3) {
        this.$$delegate_0.openAssistantInputPanel(r1, r2, r3);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void openChatActivity(int r1) {
        this.$$delegate_0.openChatActivity(r1);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void openRealtimeCall(int r3, IOpenRealTimeCallCallbackIDL r4) {
        IOpenRealTimeCallCallbackIDL r5 = (IOpenRealTimeCallCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r4, IOpenRealTimeCallCallbackIDL.class, "com.obric.aiagent.plugin");
        this.$$delegate_0.openRealtimeCall(r3, r5);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void popWindow() {
        this.$$delegate_0.popWindow();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void processRequiresAuthentication() {
        this.$$delegate_0.processRequiresAuthentication();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void requestBiometricAuthentication(IRequestAuthenticationCallbackIDL r3, boolean r4, Bundle r5) {
        IRequestAuthenticationCallbackIDL r6 = (IRequestAuthenticationCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r3, IRequestAuthenticationCallbackIDL.class, "com.obric.aiagent.plugin");
        this.$$delegate_0.requestBiometricAuthentication(r6, r4, r5);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void requestDeviceCredentialAuthentication(IRequestAuthenticationCallbackIDL r3, Bundle r4) {
        IRequestAuthenticationCallbackIDL r5 = (IRequestAuthenticationCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r3, IRequestAuthenticationCallbackIDL.class, "com.obric.aiagent.plugin");
        this.$$delegate_0.requestDeviceCredentialAuthentication(r5, r4);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void requestVoicePrintAuthentication(IRequestAuthenticationCallbackIDL r3, Bundle r4) {
        IRequestAuthenticationCallbackIDL r5 = (IRequestAuthenticationCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r3, IRequestAuthenticationCallbackIDL.class, "com.obric.aiagent.plugin");
        this.$$delegate_0.requestVoicePrintAuthentication(r5, r4);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void setAssistantInteractionListener(String r3, IAssistantInteractionListenerIDL r4) {
        IAssistantInteractionListenerIDL r5 = (IAssistantInteractionListenerIDL) ZeusTransformUtils.wrapperContextForParams(r4, IAssistantInteractionListenerIDL.class, "com.obric.aiagent.plugin");
        this.$$delegate_0.setAssistantInteractionListener(r3, r5);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void setAutoIncreaseWindow(boolean r1) {
        this.$$delegate_0.setAutoIncreaseWindow(r1);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void shouldDowngradeAuthForDora(int r3, IDowngradeAuthForDoraCallbackIDL r4) {
        IDowngradeAuthForDoraCallbackIDL r5 = (IDowngradeAuthForDoraCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r4, IDowngradeAuthForDoraCallbackIDL.class, "com.obric.aiagent.plugin");
        this.$$delegate_0.shouldDowngradeAuthForDora(r3, r5);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void showToast(String r1) {
        this.$$delegate_0.showToast(r1);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void showWindow() {
        this.$$delegate_0.showWindow();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void suspendDismissKeyguard(String r7, String[] r8, IDismissKeyguardCallbackIDL r9, boolean r10, Bundle r11) {
        IDismissKeyguardCallbackIDL r3 = (IDismissKeyguardCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r9, IDismissKeyguardCallbackIDL.class, "com.obric.aiagent.plugin");
        this.$$delegate_0.suspendDismissKeyguard(r7, r8, r3, r10, r11);
    }

    public FlowUiIDLStub() {
        Object r0 = (IFlowUiIDLSPI) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IFlowUiIDLSPI.class), IFlowUiIDLSPI.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L6;
        r0 = new IFlowUiIDL.Default();
    L6:
        this.$$delegate_0 = (IFlowUiIDL) ZeusTransformUtils.preCheckCast(r0, IFlowUiIDL.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL.Stub, android.os.IInterface
    public IBinder asBinder() {
        IBinder r1 = super.asBinder();
        d.h.b.o.c(r1, "asBinder(...)");
        return r1;
    }
}
