package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.obric.aiagent.assistant.idl.bean.FeatureConfigMap;
import com.obric.aiagent.assistant.idl.bean.OComplexTaskConfig;
import com.obric.aiagent.assistant.idl.bean.OModelConfig;
import com.obric.aiagent.assistant.idl.bean.ObricMemoryDataCollectConfig;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: compiled from: FlowSettingsIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
final class FlowSettingsIDLStub extends IFlowSettingsIDL.Stub implements IFlowSettingsIDL {
    private final /* synthetic */ IFlowSettingsIDL $$delegate_0;

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public int getAuthenticationTypeOnLockScreen(String r1) {
        return this.$$delegate_0.getAuthenticationTypeOnLockScreen(r1);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public Map getAutoExecuteAuthorizationStatusMap() {
        return this.$$delegate_0.getAutoExecuteAuthorizationStatusMap();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public int getAutoGuiEnabledScene() {
        return this.$$delegate_0.getAutoGuiEnabledScene();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public String getAutoGuiFastModeUseSettings() {
        return this.$$delegate_0.getAutoGuiFastModeUseSettings();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public boolean getAutoImageUploadEnabled() {
        return this.$$delegate_0.getAutoImageUploadEnabled();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public FeatureConfigMap getFeatureConfigMap() {
        return this.$$delegate_0.getFeatureConfigMap();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public int getIntentAuthStatus(String r1) {
        return this.$$delegate_0.getIntentAuthStatus(r1);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public int getIntentUploadStrategyForDebug() {
        return this.$$delegate_0.getIntentUploadStrategyForDebug();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public boolean getOAutoUseClipboardEnabled() {
        return this.$$delegate_0.getOAutoUseClipboardEnabled();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public boolean getOUseMemoryEnabled() {
        return this.$$delegate_0.getOUseMemoryEnabled();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public String getObricCloudConfig(String r1) {
        return this.$$delegate_0.getObricCloudConfig(r1);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public OComplexTaskConfig getObricComplexTaskConfig() {
        return this.$$delegate_0.getObricComplexTaskConfig();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public String getObricFlowSettingsJson(String r1) {
        return this.$$delegate_0.getObricFlowSettingsJson(r1);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public ObricMemoryDataCollectConfig getObricMemoryDataCollectConfig() {
        return this.$$delegate_0.getObricMemoryDataCollectConfig();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public OModelConfig getObricModelConfig() {
        return this.$$delegate_0.getObricModelConfig();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public int getObricPowerLockTimeoutInSeconds() {
        return this.$$delegate_0.getObricPowerLockTimeoutInSeconds();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public boolean getPersonalContextEnabled() {
        return this.$$delegate_0.getPersonalContextEnabled();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public boolean getSemanticeScreenShotEnabled() {
        return this.$$delegate_0.getSemanticeScreenShotEnabled();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public boolean isLarkKnowledgeAuthorizationEnable() {
        return this.$$delegate_0.isLarkKnowledgeAuthorizationEnable();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public boolean isLarkSendConfirmEnabled() {
        return this.$$delegate_0.isLarkSendConfirmEnabled();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public boolean isTtsPlayBackgroundEnabled() {
        return this.$$delegate_0.isTtsPlayBackgroundEnabled();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public boolean isVoicePrintAuthenticateAutoGuiEnabled() {
        return this.$$delegate_0.isVoicePrintAuthenticateAutoGuiEnabled();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public void setAutoGuiEnabledScene(int r1) {
        this.$$delegate_0.setAutoGuiEnabledScene(r1);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public void setAutoImageUploadEnabled(boolean r1) {
        this.$$delegate_0.setAutoImageUploadEnabled(r1);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public void setLarkKnowledgeAuthorizationEnabled(boolean r1) {
        this.$$delegate_0.setLarkKnowledgeAuthorizationEnabled(r1);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public void setOUseMemoryEnabled(boolean r1) {
        this.$$delegate_0.setOUseMemoryEnabled(r1);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public void setSemanticScreenShotEnabled(boolean r1) {
        this.$$delegate_0.setSemanticScreenShotEnabled(r1);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public void setVoicePrintAuthenticateAutoGuiEnabled(boolean r1) {
        this.$$delegate_0.setVoicePrintAuthenticateAutoGuiEnabled(r1);
    }

    public FlowSettingsIDLStub() {
        Object r0 = (IFlowSettingsIDLSPI) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IFlowSettingsIDLSPI.class), IFlowSettingsIDLSPI.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L6;
        r0 = new IFlowSettingsIDL.Default();
    L6:
        this.$$delegate_0 = (IFlowSettingsIDL) ZeusTransformUtils.preCheckCast(r0, IFlowSettingsIDL.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL.Stub, android.os.IInterface
    public IBinder asBinder() {
        IBinder r1 = super.asBinder();
        d.h.b.o.c(r1, "asBinder(...)");
        return r1;
    }
}
