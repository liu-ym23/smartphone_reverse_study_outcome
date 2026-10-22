package com.obric.aiagent.assistant.idl;

import android.os.SystemClock;
import com.obric.aiagent.assistant.idl.bean.FeatureConfigMap;
import com.obric.aiagent.assistant.idl.bean.OComplexTaskConfig;
import com.obric.aiagent.assistant.idl.bean.OModelConfig;
import com.obric.aiagent.assistant.idl.bean.ObricMemoryDataCollectConfig;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
class FlowSettingsIDLStubWrapper extends IFlowSettingsIDL.Stub {
    boolean log;
    final IFlowSettingsIDL.Stub origin;

    FlowSettingsIDLStubWrapper(IFlowSettingsIDL.Stub r2) {
        this(r2, true);
    }

    FlowSettingsIDLStubWrapper(IFlowSettingsIDL.Stub r1, boolean r2) {
        this.origin = r1;
        this.log = r2;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public int getAutoGuiEnabledScene() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowSettingsIDLStub", "getAutoGuiEnabledScene()", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r2 = Math.max(0, r16 - r3) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowSettingsIDLStub", "getAutoGuiEnabledScene() = fail", r1, r2);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowSettingsIDLStub", "getAutoGuiEnabledScene", r1, r2, r16);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowSettingsIDLStub", "getAutoGuiEnabledScene()");     // Catch: Exception -> L11
    L6:
        int r9 = this.origin.getAutoGuiEnabledScene();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowSettingsIDLStub", "getAutoGuiEnabledScene = " + r9);     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r3) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowSettingsIDLStub", "getAutoGuiEnabledScene() = " + r9, r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowSettingsIDLStub", "getAutoGuiEnabledScene", r14, r17);     // Catch: Exception -> L11
        return r9;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public void setAutoGuiEnabledScene(int r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowSettingsIDLStub", "setAutoGuiEnabledScene(" + r21 + ")", e);
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r4 = Math.max(0, r18 - r5) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowSettingsIDLStub", "setAutoGuiEnabledScene(" + r21 + ") = fail", r2, r4);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowSettingsIDLStub", "setAutoGuiEnabledScene", r2, r4, r18);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowSettingsIDLStub", "setAutoGuiEnabledScene(" + r21 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.setAutoGuiEnabledScene(r21);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowSettingsIDLStub", "setAutoGuiEnabledScene = void");     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowSettingsIDLStub", "setAutoGuiEnabledScene(" + r21 + ") = void", r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowSettingsIDLStub", "setAutoGuiEnabledScene", r14, r17);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public boolean getSemanticeScreenShotEnabled() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowSettingsIDLStub", "getSemanticeScreenShotEnabled()", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r2 = Math.max(0, r16 - r3) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowSettingsIDLStub", "getSemanticeScreenShotEnabled() = fail", r1, r2);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowSettingsIDLStub", "getSemanticeScreenShotEnabled", r1, r2, r16);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowSettingsIDLStub", "getSemanticeScreenShotEnabled()");     // Catch: Exception -> L11
    L6:
        boolean r9 = this.origin.getSemanticeScreenShotEnabled();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowSettingsIDLStub", "getSemanticeScreenShotEnabled = " + r9);     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r3) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowSettingsIDLStub", "getSemanticeScreenShotEnabled() = " + r9, r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowSettingsIDLStub", "getSemanticeScreenShotEnabled", r14, r17);     // Catch: Exception -> L11
        return r9;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public void setSemanticScreenShotEnabled(boolean r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowSettingsIDLStub", "setSemanticScreenShotEnabled(" + r21 + ")", e);
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r4 = Math.max(0, r18 - r5) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowSettingsIDLStub", "setSemanticScreenShotEnabled(" + r21 + ") = fail", r2, r4);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowSettingsIDLStub", "setSemanticScreenShotEnabled", r2, r4, r18);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowSettingsIDLStub", "setSemanticScreenShotEnabled(" + r21 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.setSemanticScreenShotEnabled(r21);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowSettingsIDLStub", "setSemanticScreenShotEnabled = void");     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowSettingsIDLStub", "setSemanticScreenShotEnabled(" + r21 + ") = void", r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowSettingsIDLStub", "setSemanticScreenShotEnabled", r14, r17);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public boolean getPersonalContextEnabled() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowSettingsIDLStub", "getPersonalContextEnabled()", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r2 = Math.max(0, r16 - r3) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowSettingsIDLStub", "getPersonalContextEnabled() = fail", r1, r2);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowSettingsIDLStub", "getPersonalContextEnabled", r1, r2, r16);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowSettingsIDLStub", "getPersonalContextEnabled()");     // Catch: Exception -> L11
    L6:
        boolean r9 = this.origin.getPersonalContextEnabled();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowSettingsIDLStub", "getPersonalContextEnabled = " + r9);     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r3) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowSettingsIDLStub", "getPersonalContextEnabled() = " + r9, r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowSettingsIDLStub", "getPersonalContextEnabled", r14, r17);     // Catch: Exception -> L11
        return r9;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public int getIntentAuthStatus(String r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowSettingsIDLStub", "getIntentAuthStatus(" + r21 + ")", e);
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r4 = Math.max(0, r18 - r5) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowSettingsIDLStub", "getIntentAuthStatus(" + r21 + ") = fail", r2, r4);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowSettingsIDLStub", "getIntentAuthStatus", r2, r4, r18);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowSettingsIDLStub", "getIntentAuthStatus(" + r21 + ")");     // Catch: Exception -> L11
    L6:
        int r11 = this.origin.getIntentAuthStatus(r21);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowSettingsIDLStub", "getIntentAuthStatus = " + r11);     // Catch: Exception -> L11
    L9:
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r19 - r5) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowSettingsIDLStub", "getIntentAuthStatus(" + r21 + ") = " + r11, r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowSettingsIDLStub", "getIntentAuthStatus", r14, r19);     // Catch: Exception -> L11
        return r11;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public int getIntentUploadStrategyForDebug() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowSettingsIDLStub", "getIntentUploadStrategyForDebug()", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r2 = Math.max(0, r16 - r3) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowSettingsIDLStub", "getIntentUploadStrategyForDebug() = fail", r1, r2);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowSettingsIDLStub", "getIntentUploadStrategyForDebug", r1, r2, r16);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowSettingsIDLStub", "getIntentUploadStrategyForDebug()");     // Catch: Exception -> L11
    L6:
        int r9 = this.origin.getIntentUploadStrategyForDebug();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowSettingsIDLStub", "getIntentUploadStrategyForDebug = " + r9);     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r3) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowSettingsIDLStub", "getIntentUploadStrategyForDebug() = " + r9, r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowSettingsIDLStub", "getIntentUploadStrategyForDebug", r14, r17);     // Catch: Exception -> L11
        return r9;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public int getObricPowerLockTimeoutInSeconds() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowSettingsIDLStub", "getObricPowerLockTimeoutInSeconds()", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r2 = Math.max(0, r16 - r3) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowSettingsIDLStub", "getObricPowerLockTimeoutInSeconds() = fail", r1, r2);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowSettingsIDLStub", "getObricPowerLockTimeoutInSeconds", r1, r2, r16);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowSettingsIDLStub", "getObricPowerLockTimeoutInSeconds()");     // Catch: Exception -> L11
    L6:
        int r9 = this.origin.getObricPowerLockTimeoutInSeconds();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowSettingsIDLStub", "getObricPowerLockTimeoutInSeconds = " + r9);     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r3) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowSettingsIDLStub", "getObricPowerLockTimeoutInSeconds() = " + r9, r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowSettingsIDLStub", "getObricPowerLockTimeoutInSeconds", r14, r17);     // Catch: Exception -> L11
        return r9;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public OComplexTaskConfig getObricComplexTaskConfig() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowSettingsIDLStub", "getObricComplexTaskConfig()", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r2 = Math.max(0, r16 - r3) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowSettingsIDLStub", "getObricComplexTaskConfig() = fail", r1, r2);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowSettingsIDLStub", "getObricComplexTaskConfig", r1, r2, r16);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowSettingsIDLStub", "getObricComplexTaskConfig()");     // Catch: Exception -> L11
    L6:
        OComplexTaskConfig r9 = this.origin.getObricComplexTaskConfig();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowSettingsIDLStub", "getObricComplexTaskConfig = " + r9);     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r3) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowSettingsIDLStub", "getObricComplexTaskConfig() = " + r9, r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowSettingsIDLStub", "getObricComplexTaskConfig", r14, r17);     // Catch: Exception -> L11
        return r9;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public OModelConfig getObricModelConfig() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowSettingsIDLStub", "getObricModelConfig()", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r2 = Math.max(0, r16 - r3) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowSettingsIDLStub", "getObricModelConfig() = fail", r1, r2);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowSettingsIDLStub", "getObricModelConfig", r1, r2, r16);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowSettingsIDLStub", "getObricModelConfig()");     // Catch: Exception -> L11
    L6:
        OModelConfig r9 = this.origin.getObricModelConfig();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowSettingsIDLStub", "getObricModelConfig = " + r9);     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r3) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowSettingsIDLStub", "getObricModelConfig() = " + r9, r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowSettingsIDLStub", "getObricModelConfig", r14, r17);     // Catch: Exception -> L11
        return r9;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public boolean isTtsPlayBackgroundEnabled() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowSettingsIDLStub", "isTtsPlayBackgroundEnabled()", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r2 = Math.max(0, r16 - r3) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowSettingsIDLStub", "isTtsPlayBackgroundEnabled() = fail", r1, r2);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowSettingsIDLStub", "isTtsPlayBackgroundEnabled", r1, r2, r16);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowSettingsIDLStub", "isTtsPlayBackgroundEnabled()");     // Catch: Exception -> L11
    L6:
        boolean r9 = this.origin.isTtsPlayBackgroundEnabled();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowSettingsIDLStub", "isTtsPlayBackgroundEnabled = " + r9);     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r3) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowSettingsIDLStub", "isTtsPlayBackgroundEnabled() = " + r9, r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowSettingsIDLStub", "isTtsPlayBackgroundEnabled", r14, r17);     // Catch: Exception -> L11
        return r9;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public FeatureConfigMap getFeatureConfigMap() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowSettingsIDLStub", "getFeatureConfigMap()", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r2 = Math.max(0, r16 - r3) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowSettingsIDLStub", "getFeatureConfigMap() = fail", r1, r2);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowSettingsIDLStub", "getFeatureConfigMap", r1, r2, r16);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowSettingsIDLStub", "getFeatureConfigMap()");     // Catch: Exception -> L11
    L6:
        FeatureConfigMap r9 = this.origin.getFeatureConfigMap();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowSettingsIDLStub", "getFeatureConfigMap = " + r9);     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r3) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowSettingsIDLStub", "getFeatureConfigMap() = " + r9, r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowSettingsIDLStub", "getFeatureConfigMap", r14, r17);     // Catch: Exception -> L11
        return r9;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public ObricMemoryDataCollectConfig getObricMemoryDataCollectConfig() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowSettingsIDLStub", "getObricMemoryDataCollectConfig()", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r2 = Math.max(0, r16 - r3) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowSettingsIDLStub", "getObricMemoryDataCollectConfig() = fail", r1, r2);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowSettingsIDLStub", "getObricMemoryDataCollectConfig", r1, r2, r16);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowSettingsIDLStub", "getObricMemoryDataCollectConfig()");     // Catch: Exception -> L11
    L6:
        ObricMemoryDataCollectConfig r9 = this.origin.getObricMemoryDataCollectConfig();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowSettingsIDLStub", "getObricMemoryDataCollectConfig = " + r9);     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r3) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowSettingsIDLStub", "getObricMemoryDataCollectConfig() = " + r9, r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowSettingsIDLStub", "getObricMemoryDataCollectConfig", r14, r17);     // Catch: Exception -> L11
        return r9;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public String getObricFlowSettingsJson(String r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowSettingsIDLStub", "getObricFlowSettingsJson(" + r21 + ")", e);
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r4 = Math.max(0, r18 - r5) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowSettingsIDLStub", "getObricFlowSettingsJson(" + r21 + ") = fail", r2, r4);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowSettingsIDLStub", "getObricFlowSettingsJson", r2, r4, r18);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowSettingsIDLStub", "getObricFlowSettingsJson(" + r21 + ")");     // Catch: Exception -> L11
    L6:
        String r11 = this.origin.getObricFlowSettingsJson(r21);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowSettingsIDLStub", "getObricFlowSettingsJson = " + r11);     // Catch: Exception -> L11
    L9:
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r19 - r5) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowSettingsIDLStub", "getObricFlowSettingsJson(" + r21 + ") = " + r11, r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowSettingsIDLStub", "getObricFlowSettingsJson", r14, r19);     // Catch: Exception -> L11
        return r11;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public String getObricCloudConfig(String r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowSettingsIDLStub", "getObricCloudConfig(" + r21 + ")", e);
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r4 = Math.max(0, r18 - r5) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowSettingsIDLStub", "getObricCloudConfig(" + r21 + ") = fail", r2, r4);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowSettingsIDLStub", "getObricCloudConfig", r2, r4, r18);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowSettingsIDLStub", "getObricCloudConfig(" + r21 + ")");     // Catch: Exception -> L11
    L6:
        String r11 = this.origin.getObricCloudConfig(r21);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowSettingsIDLStub", "getObricCloudConfig = " + r11);     // Catch: Exception -> L11
    L9:
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r19 - r5) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowSettingsIDLStub", "getObricCloudConfig(" + r21 + ") = " + r11, r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowSettingsIDLStub", "getObricCloudConfig", r14, r19);     // Catch: Exception -> L11
        return r11;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public void setOUseMemoryEnabled(boolean r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowSettingsIDLStub", "setOUseMemoryEnabled(" + r21 + ")", e);
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r4 = Math.max(0, r18 - r5) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowSettingsIDLStub", "setOUseMemoryEnabled(" + r21 + ") = fail", r2, r4);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowSettingsIDLStub", "setOUseMemoryEnabled", r2, r4, r18);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowSettingsIDLStub", "setOUseMemoryEnabled(" + r21 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.setOUseMemoryEnabled(r21);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowSettingsIDLStub", "setOUseMemoryEnabled = void");     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowSettingsIDLStub", "setOUseMemoryEnabled(" + r21 + ") = void", r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowSettingsIDLStub", "setOUseMemoryEnabled", r14, r17);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public boolean getOUseMemoryEnabled() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowSettingsIDLStub", "getOUseMemoryEnabled()", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r2 = Math.max(0, r16 - r3) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowSettingsIDLStub", "getOUseMemoryEnabled() = fail", r1, r2);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowSettingsIDLStub", "getOUseMemoryEnabled", r1, r2, r16);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowSettingsIDLStub", "getOUseMemoryEnabled()");     // Catch: Exception -> L11
    L6:
        boolean r9 = this.origin.getOUseMemoryEnabled();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowSettingsIDLStub", "getOUseMemoryEnabled = " + r9);     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r3) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowSettingsIDLStub", "getOUseMemoryEnabled() = " + r9, r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowSettingsIDLStub", "getOUseMemoryEnabled", r14, r17);     // Catch: Exception -> L11
        return r9;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public boolean isLarkKnowledgeAuthorizationEnable() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowSettingsIDLStub", "isLarkKnowledgeAuthorizationEnable()", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r2 = Math.max(0, r16 - r3) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowSettingsIDLStub", "isLarkKnowledgeAuthorizationEnable() = fail", r1, r2);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowSettingsIDLStub", "isLarkKnowledgeAuthorizationEnable", r1, r2, r16);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowSettingsIDLStub", "isLarkKnowledgeAuthorizationEnable()");     // Catch: Exception -> L11
    L6:
        boolean r9 = this.origin.isLarkKnowledgeAuthorizationEnable();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowSettingsIDLStub", "isLarkKnowledgeAuthorizationEnable = " + r9);     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r3) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowSettingsIDLStub", "isLarkKnowledgeAuthorizationEnable() = " + r9, r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowSettingsIDLStub", "isLarkKnowledgeAuthorizationEnable", r14, r17);     // Catch: Exception -> L11
        return r9;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public void setLarkKnowledgeAuthorizationEnabled(boolean r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowSettingsIDLStub", "setLarkKnowledgeAuthorizationEnabled(" + r21 + ")", e);
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r4 = Math.max(0, r18 - r5) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowSettingsIDLStub", "setLarkKnowledgeAuthorizationEnabled(" + r21 + ") = fail", r2, r4);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowSettingsIDLStub", "setLarkKnowledgeAuthorizationEnabled", r2, r4, r18);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowSettingsIDLStub", "setLarkKnowledgeAuthorizationEnabled(" + r21 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.setLarkKnowledgeAuthorizationEnabled(r21);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowSettingsIDLStub", "setLarkKnowledgeAuthorizationEnabled = void");     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowSettingsIDLStub", "setLarkKnowledgeAuthorizationEnabled(" + r21 + ") = void", r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowSettingsIDLStub", "setLarkKnowledgeAuthorizationEnabled", r14, r17);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public boolean getAutoImageUploadEnabled() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowSettingsIDLStub", "getAutoImageUploadEnabled()", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r2 = Math.max(0, r16 - r3) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowSettingsIDLStub", "getAutoImageUploadEnabled() = fail", r1, r2);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowSettingsIDLStub", "getAutoImageUploadEnabled", r1, r2, r16);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowSettingsIDLStub", "getAutoImageUploadEnabled()");     // Catch: Exception -> L11
    L6:
        boolean r9 = this.origin.getAutoImageUploadEnabled();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowSettingsIDLStub", "getAutoImageUploadEnabled = " + r9);     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r3) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowSettingsIDLStub", "getAutoImageUploadEnabled() = " + r9, r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowSettingsIDLStub", "getAutoImageUploadEnabled", r14, r17);     // Catch: Exception -> L11
        return r9;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public void setAutoImageUploadEnabled(boolean r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowSettingsIDLStub", "setAutoImageUploadEnabled(" + r21 + ")", e);
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r4 = Math.max(0, r18 - r5) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowSettingsIDLStub", "setAutoImageUploadEnabled(" + r21 + ") = fail", r2, r4);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowSettingsIDLStub", "setAutoImageUploadEnabled", r2, r4, r18);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowSettingsIDLStub", "setAutoImageUploadEnabled(" + r21 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.setAutoImageUploadEnabled(r21);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowSettingsIDLStub", "setAutoImageUploadEnabled = void");     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowSettingsIDLStub", "setAutoImageUploadEnabled(" + r21 + ") = void", r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowSettingsIDLStub", "setAutoImageUploadEnabled", r14, r17);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public boolean isLarkSendConfirmEnabled() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowSettingsIDLStub", "isLarkSendConfirmEnabled()", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r2 = Math.max(0, r16 - r3) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowSettingsIDLStub", "isLarkSendConfirmEnabled() = fail", r1, r2);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowSettingsIDLStub", "isLarkSendConfirmEnabled", r1, r2, r16);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowSettingsIDLStub", "isLarkSendConfirmEnabled()");     // Catch: Exception -> L11
    L6:
        boolean r9 = this.origin.isLarkSendConfirmEnabled();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowSettingsIDLStub", "isLarkSendConfirmEnabled = " + r9);     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r3) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowSettingsIDLStub", "isLarkSendConfirmEnabled() = " + r9, r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowSettingsIDLStub", "isLarkSendConfirmEnabled", r14, r17);     // Catch: Exception -> L11
        return r9;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public void setVoicePrintAuthenticateAutoGuiEnabled(boolean r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowSettingsIDLStub", "setVoicePrintAuthenticateAutoGuiEnabled(" + r21 + ")", e);
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r4 = Math.max(0, r18 - r5) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowSettingsIDLStub", "setVoicePrintAuthenticateAutoGuiEnabled(" + r21 + ") = fail", r2, r4);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowSettingsIDLStub", "setVoicePrintAuthenticateAutoGuiEnabled", r2, r4, r18);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowSettingsIDLStub", "setVoicePrintAuthenticateAutoGuiEnabled(" + r21 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.setVoicePrintAuthenticateAutoGuiEnabled(r21);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowSettingsIDLStub", "setVoicePrintAuthenticateAutoGuiEnabled = void");     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowSettingsIDLStub", "setVoicePrintAuthenticateAutoGuiEnabled(" + r21 + ") = void", r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowSettingsIDLStub", "setVoicePrintAuthenticateAutoGuiEnabled", r14, r17);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public boolean isVoicePrintAuthenticateAutoGuiEnabled() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowSettingsIDLStub", "isVoicePrintAuthenticateAutoGuiEnabled()", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r2 = Math.max(0, r16 - r3) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowSettingsIDLStub", "isVoicePrintAuthenticateAutoGuiEnabled() = fail", r1, r2);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowSettingsIDLStub", "isVoicePrintAuthenticateAutoGuiEnabled", r1, r2, r16);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowSettingsIDLStub", "isVoicePrintAuthenticateAutoGuiEnabled()");     // Catch: Exception -> L11
    L6:
        boolean r9 = this.origin.isVoicePrintAuthenticateAutoGuiEnabled();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowSettingsIDLStub", "isVoicePrintAuthenticateAutoGuiEnabled = " + r9);     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r3) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowSettingsIDLStub", "isVoicePrintAuthenticateAutoGuiEnabled() = " + r9, r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowSettingsIDLStub", "isVoicePrintAuthenticateAutoGuiEnabled", r14, r17);     // Catch: Exception -> L11
        return r9;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public boolean getOAutoUseClipboardEnabled() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowSettingsIDLStub", "getOAutoUseClipboardEnabled()", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r2 = Math.max(0, r16 - r3) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowSettingsIDLStub", "getOAutoUseClipboardEnabled() = fail", r1, r2);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowSettingsIDLStub", "getOAutoUseClipboardEnabled", r1, r2, r16);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowSettingsIDLStub", "getOAutoUseClipboardEnabled()");     // Catch: Exception -> L11
    L6:
        boolean r9 = this.origin.getOAutoUseClipboardEnabled();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowSettingsIDLStub", "getOAutoUseClipboardEnabled = " + r9);     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r3) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowSettingsIDLStub", "getOAutoUseClipboardEnabled() = " + r9, r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowSettingsIDLStub", "getOAutoUseClipboardEnabled", r14, r17);     // Catch: Exception -> L11
        return r9;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public int getAuthenticationTypeOnLockScreen(String r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowSettingsIDLStub", "getAuthenticationTypeOnLockScreen(" + r21 + ")", e);
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r4 = Math.max(0, r18 - r5) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowSettingsIDLStub", "getAuthenticationTypeOnLockScreen(" + r21 + ") = fail", r2, r4);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowSettingsIDLStub", "getAuthenticationTypeOnLockScreen", r2, r4, r18);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowSettingsIDLStub", "getAuthenticationTypeOnLockScreen(" + r21 + ")");     // Catch: Exception -> L11
    L6:
        int r11 = this.origin.getAuthenticationTypeOnLockScreen(r21);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowSettingsIDLStub", "getAuthenticationTypeOnLockScreen = " + r11);     // Catch: Exception -> L11
    L9:
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r19 - r5) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowSettingsIDLStub", "getAuthenticationTypeOnLockScreen(" + r21 + ") = " + r11, r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowSettingsIDLStub", "getAuthenticationTypeOnLockScreen", r14, r19);     // Catch: Exception -> L11
        return r11;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public Map getAutoExecuteAuthorizationStatusMap() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowSettingsIDLStub", "getAutoExecuteAuthorizationStatusMap()", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r2 = Math.max(0, r16 - r3) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowSettingsIDLStub", "getAutoExecuteAuthorizationStatusMap() = fail", r1, r2);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowSettingsIDLStub", "getAutoExecuteAuthorizationStatusMap", r1, r2, r16);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowSettingsIDLStub", "getAutoExecuteAuthorizationStatusMap()");     // Catch: Exception -> L11
    L6:
        Map r9 = this.origin.getAutoExecuteAuthorizationStatusMap();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowSettingsIDLStub", "getAutoExecuteAuthorizationStatusMap = " + r9);     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r3) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowSettingsIDLStub", "getAutoExecuteAuthorizationStatusMap() = " + r9, r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowSettingsIDLStub", "getAutoExecuteAuthorizationStatusMap", r14, r17);     // Catch: Exception -> L11
        return r9;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public String getAutoGuiFastModeUseSettings() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowSettingsIDLStub", "getAutoGuiFastModeUseSettings()", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r2 = Math.max(0, r16 - r3) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowSettingsIDLStub", "getAutoGuiFastModeUseSettings() = fail", r1, r2);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowSettingsIDLStub", "getAutoGuiFastModeUseSettings", r1, r2, r16);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowSettingsIDLStub", "getAutoGuiFastModeUseSettings()");     // Catch: Exception -> L11
    L6:
        String r9 = this.origin.getAutoGuiFastModeUseSettings();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowSettingsIDLStub", "getAutoGuiFastModeUseSettings = " + r9);     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r3) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowSettingsIDLStub", "getAutoGuiFastModeUseSettings() = " + r9, r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowSettingsIDLStub", "getAutoGuiFastModeUseSettings", r14, r17);     // Catch: Exception -> L11
        return r9;
    }
}
