package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import android.os.SystemClock;
import com.obric.aiagent.assistant.idl.bean.FeatureConfigMap;
import com.obric.aiagent.assistant.idl.bean.OComplexTaskConfig;
import com.obric.aiagent.assistant.idl.bean.OModelConfig;
import com.obric.aiagent.assistant.idl.bean.ObricMemoryDataCollectConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
class FlowSettingsIDLIpcWrapper implements IFlowSettingsIDL {
    boolean log;
    final IFlowSettingsIDL origin;

    FlowSettingsIDLIpcWrapper(IFlowSettingsIDL r3) {
        this((IFlowSettingsIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowSettingsIDL.class, "com.obric.aiagent.plugin"), true);
    }

    FlowSettingsIDLIpcWrapper(IFlowSettingsIDL r3, boolean r4) {
        this.origin = (IFlowSettingsIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowSettingsIDL.class, "com.obric.aiagent.plugin");
        this.log = r4;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public int getAutoGuiEnabledScene() {
        long r3 = SystemClock.elapsedRealtimeNanos();
        int r9 = 0;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowSettingsIDLIPC", "getAutoGuiEnabledScene()", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r2 = Math.max(0, r17 - r3) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowSettingsIDLIPC", "getAutoGuiEnabledScene() = fail", r1, r2);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowSettingsIDLIPC", "getAutoGuiEnabledScene", r1, r2, r17);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowSettingsIDLIPC", "getAutoGuiEnabledScene()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowSettingsIDLIPC", "getAutoGuiEnabledScene()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r9 = this.origin.getAutoGuiEnabledScene();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowSettingsIDLIPC", "getAutoGuiEnabledScene = " + r9);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r16 - r3) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowSettingsIDLIPC", "getAutoGuiEnabledScene() = " + r9, r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowSettingsIDLIPC", "getAutoGuiEnabledScene", r14, r16);     // Catch: Exception -> L14 Throwable -> L17
        return r9;
    L16:
        return r9;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public void setAutoGuiEnabledScene(int r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowSettingsIDLIPC", "setAutoGuiEnabledScene(" + r21 + ")", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r4 = Math.max(0, r18 - r5) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowSettingsIDLIPC", "setAutoGuiEnabledScene(" + r21 + ") = fail", r2, r4);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowSettingsIDLIPC", "setAutoGuiEnabledScene", r2, r4, r18);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowSettingsIDLIPC", "setAutoGuiEnabledScene(" + r21 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowSettingsIDLIPC", "setAutoGuiEnabledScene(" + r21 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.setAutoGuiEnabledScene(r21);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowSettingsIDLIPC", "setAutoGuiEnabledScene = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowSettingsIDLIPC", "setAutoGuiEnabledScene(" + r21 + ") = void", r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowSettingsIDLIPC", "setAutoGuiEnabledScene", r14, r17);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public boolean getSemanticeScreenShotEnabled() {
        long r3 = SystemClock.elapsedRealtimeNanos();
        boolean r9 = false;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowSettingsIDLIPC", "getSemanticeScreenShotEnabled()", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r2 = Math.max(0, r17 - r3) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowSettingsIDLIPC", "getSemanticeScreenShotEnabled() = fail", r1, r2);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowSettingsIDLIPC", "getSemanticeScreenShotEnabled", r1, r2, r17);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowSettingsIDLIPC", "getSemanticeScreenShotEnabled()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowSettingsIDLIPC", "getSemanticeScreenShotEnabled()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r9 = this.origin.getSemanticeScreenShotEnabled();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowSettingsIDLIPC", "getSemanticeScreenShotEnabled = " + r9);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r16 - r3) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowSettingsIDLIPC", "getSemanticeScreenShotEnabled() = " + r9, r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowSettingsIDLIPC", "getSemanticeScreenShotEnabled", r14, r16);     // Catch: Exception -> L14 Throwable -> L17
        return r9;
    L16:
        return r9;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public void setSemanticScreenShotEnabled(boolean r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowSettingsIDLIPC", "setSemanticScreenShotEnabled(" + r21 + ")", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r4 = Math.max(0, r18 - r5) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowSettingsIDLIPC", "setSemanticScreenShotEnabled(" + r21 + ") = fail", r2, r4);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowSettingsIDLIPC", "setSemanticScreenShotEnabled", r2, r4, r18);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowSettingsIDLIPC", "setSemanticScreenShotEnabled(" + r21 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowSettingsIDLIPC", "setSemanticScreenShotEnabled(" + r21 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.setSemanticScreenShotEnabled(r21);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowSettingsIDLIPC", "setSemanticScreenShotEnabled = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowSettingsIDLIPC", "setSemanticScreenShotEnabled(" + r21 + ") = void", r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowSettingsIDLIPC", "setSemanticScreenShotEnabled", r14, r17);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public boolean getPersonalContextEnabled() {
        long r3 = SystemClock.elapsedRealtimeNanos();
        boolean r9 = false;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowSettingsIDLIPC", "getPersonalContextEnabled()", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r2 = Math.max(0, r17 - r3) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowSettingsIDLIPC", "getPersonalContextEnabled() = fail", r1, r2);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowSettingsIDLIPC", "getPersonalContextEnabled", r1, r2, r17);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowSettingsIDLIPC", "getPersonalContextEnabled()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowSettingsIDLIPC", "getPersonalContextEnabled()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r9 = this.origin.getPersonalContextEnabled();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowSettingsIDLIPC", "getPersonalContextEnabled = " + r9);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r16 - r3) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowSettingsIDLIPC", "getPersonalContextEnabled() = " + r9, r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowSettingsIDLIPC", "getPersonalContextEnabled", r14, r16);     // Catch: Exception -> L14 Throwable -> L17
        return r9;
    L16:
        return r9;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public int getIntentAuthStatus(String r22) {
        long r5 = SystemClock.elapsedRealtimeNanos();
        int r11 = 0;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowSettingsIDLIPC", "getIntentAuthStatus(" + r22 + ")", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r4 = Math.max(0, r19 - r5) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowSettingsIDLIPC", "getIntentAuthStatus(" + r22 + ") = fail", r2, r4);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowSettingsIDLIPC", "getIntentAuthStatus", r2, r4, r19);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowSettingsIDLIPC", "getIntentAuthStatus(" + r22 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowSettingsIDLIPC", "getIntentAuthStatus(" + r22 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r11 = this.origin.getIntentAuthStatus(r22);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowSettingsIDLIPC", "getIntentAuthStatus = " + r11);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r18 - r5) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowSettingsIDLIPC", "getIntentAuthStatus(" + r22 + ") = " + r11, r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowSettingsIDLIPC", "getIntentAuthStatus", r14, r18);     // Catch: Exception -> L14 Throwable -> L17
        return r11;
    L16:
        return r11;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public int getIntentUploadStrategyForDebug() {
        long r3 = SystemClock.elapsedRealtimeNanos();
        int r9 = 0;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowSettingsIDLIPC", "getIntentUploadStrategyForDebug()", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r2 = Math.max(0, r17 - r3) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowSettingsIDLIPC", "getIntentUploadStrategyForDebug() = fail", r1, r2);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowSettingsIDLIPC", "getIntentUploadStrategyForDebug", r1, r2, r17);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowSettingsIDLIPC", "getIntentUploadStrategyForDebug()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowSettingsIDLIPC", "getIntentUploadStrategyForDebug()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r9 = this.origin.getIntentUploadStrategyForDebug();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowSettingsIDLIPC", "getIntentUploadStrategyForDebug = " + r9);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r16 - r3) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowSettingsIDLIPC", "getIntentUploadStrategyForDebug() = " + r9, r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowSettingsIDLIPC", "getIntentUploadStrategyForDebug", r14, r16);     // Catch: Exception -> L14 Throwable -> L17
        return r9;
    L16:
        return r9;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public int getObricPowerLockTimeoutInSeconds() {
        long r3 = SystemClock.elapsedRealtimeNanos();
        int r9 = 0;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowSettingsIDLIPC", "getObricPowerLockTimeoutInSeconds()", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r2 = Math.max(0, r17 - r3) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowSettingsIDLIPC", "getObricPowerLockTimeoutInSeconds() = fail", r1, r2);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowSettingsIDLIPC", "getObricPowerLockTimeoutInSeconds", r1, r2, r17);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowSettingsIDLIPC", "getObricPowerLockTimeoutInSeconds()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowSettingsIDLIPC", "getObricPowerLockTimeoutInSeconds()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r9 = this.origin.getObricPowerLockTimeoutInSeconds();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowSettingsIDLIPC", "getObricPowerLockTimeoutInSeconds = " + r9);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r16 - r3) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowSettingsIDLIPC", "getObricPowerLockTimeoutInSeconds() = " + r9, r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowSettingsIDLIPC", "getObricPowerLockTimeoutInSeconds", r14, r16);     // Catch: Exception -> L14 Throwable -> L17
        return r9;
    L16:
        return r9;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public OComplexTaskConfig getObricComplexTaskConfig() {
        long r3 = SystemClock.elapsedRealtimeNanos();
        OComplexTaskConfig r9 = null;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowSettingsIDLIPC", "getObricComplexTaskConfig()", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r2 = Math.max(0, r17 - r3) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowSettingsIDLIPC", "getObricComplexTaskConfig() = fail", r1, r2);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowSettingsIDLIPC", "getObricComplexTaskConfig", r1, r2, r17);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowSettingsIDLIPC", "getObricComplexTaskConfig()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowSettingsIDLIPC", "getObricComplexTaskConfig()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r9 = this.origin.getObricComplexTaskConfig();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowSettingsIDLIPC", "getObricComplexTaskConfig = " + r9);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r16 - r3) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowSettingsIDLIPC", "getObricComplexTaskConfig() = " + r9, r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowSettingsIDLIPC", "getObricComplexTaskConfig", r14, r16);     // Catch: Exception -> L14 Throwable -> L17
        return r9;
    L16:
        return r9;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public OModelConfig getObricModelConfig() {
        long r3 = SystemClock.elapsedRealtimeNanos();
        OModelConfig r9 = null;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowSettingsIDLIPC", "getObricModelConfig()", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r2 = Math.max(0, r17 - r3) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowSettingsIDLIPC", "getObricModelConfig() = fail", r1, r2);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowSettingsIDLIPC", "getObricModelConfig", r1, r2, r17);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowSettingsIDLIPC", "getObricModelConfig()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowSettingsIDLIPC", "getObricModelConfig()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r9 = this.origin.getObricModelConfig();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowSettingsIDLIPC", "getObricModelConfig = " + r9);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r16 - r3) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowSettingsIDLIPC", "getObricModelConfig() = " + r9, r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowSettingsIDLIPC", "getObricModelConfig", r14, r16);     // Catch: Exception -> L14 Throwable -> L17
        return r9;
    L16:
        return r9;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public boolean isTtsPlayBackgroundEnabled() {
        long r3 = SystemClock.elapsedRealtimeNanos();
        boolean r9 = false;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowSettingsIDLIPC", "isTtsPlayBackgroundEnabled()", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r2 = Math.max(0, r17 - r3) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowSettingsIDLIPC", "isTtsPlayBackgroundEnabled() = fail", r1, r2);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowSettingsIDLIPC", "isTtsPlayBackgroundEnabled", r1, r2, r17);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowSettingsIDLIPC", "isTtsPlayBackgroundEnabled()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowSettingsIDLIPC", "isTtsPlayBackgroundEnabled()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r9 = this.origin.isTtsPlayBackgroundEnabled();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowSettingsIDLIPC", "isTtsPlayBackgroundEnabled = " + r9);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r16 - r3) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowSettingsIDLIPC", "isTtsPlayBackgroundEnabled() = " + r9, r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowSettingsIDLIPC", "isTtsPlayBackgroundEnabled", r14, r16);     // Catch: Exception -> L14 Throwable -> L17
        return r9;
    L16:
        return r9;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public FeatureConfigMap getFeatureConfigMap() {
        long r3 = SystemClock.elapsedRealtimeNanos();
        FeatureConfigMap r9 = null;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowSettingsIDLIPC", "getFeatureConfigMap()", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r2 = Math.max(0, r17 - r3) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowSettingsIDLIPC", "getFeatureConfigMap() = fail", r1, r2);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowSettingsIDLIPC", "getFeatureConfigMap", r1, r2, r17);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowSettingsIDLIPC", "getFeatureConfigMap()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowSettingsIDLIPC", "getFeatureConfigMap()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r9 = this.origin.getFeatureConfigMap();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowSettingsIDLIPC", "getFeatureConfigMap = " + r9);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r16 - r3) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowSettingsIDLIPC", "getFeatureConfigMap() = " + r9, r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowSettingsIDLIPC", "getFeatureConfigMap", r14, r16);     // Catch: Exception -> L14 Throwable -> L17
        return r9;
    L16:
        return r9;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public ObricMemoryDataCollectConfig getObricMemoryDataCollectConfig() {
        long r3 = SystemClock.elapsedRealtimeNanos();
        ObricMemoryDataCollectConfig r9 = null;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowSettingsIDLIPC", "getObricMemoryDataCollectConfig()", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r2 = Math.max(0, r17 - r3) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowSettingsIDLIPC", "getObricMemoryDataCollectConfig() = fail", r1, r2);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowSettingsIDLIPC", "getObricMemoryDataCollectConfig", r1, r2, r17);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowSettingsIDLIPC", "getObricMemoryDataCollectConfig()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowSettingsIDLIPC", "getObricMemoryDataCollectConfig()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r9 = this.origin.getObricMemoryDataCollectConfig();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowSettingsIDLIPC", "getObricMemoryDataCollectConfig = " + r9);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r16 - r3) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowSettingsIDLIPC", "getObricMemoryDataCollectConfig() = " + r9, r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowSettingsIDLIPC", "getObricMemoryDataCollectConfig", r14, r16);     // Catch: Exception -> L14 Throwable -> L17
        return r9;
    L16:
        return r9;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public String getObricFlowSettingsJson(String r22) {
        long r5 = SystemClock.elapsedRealtimeNanos();
        String r11 = null;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowSettingsIDLIPC", "getObricFlowSettingsJson(" + r22 + ")", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r4 = Math.max(0, r19 - r5) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowSettingsIDLIPC", "getObricFlowSettingsJson(" + r22 + ") = fail", r2, r4);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowSettingsIDLIPC", "getObricFlowSettingsJson", r2, r4, r19);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowSettingsIDLIPC", "getObricFlowSettingsJson(" + r22 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowSettingsIDLIPC", "getObricFlowSettingsJson(" + r22 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r11 = this.origin.getObricFlowSettingsJson(r22);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowSettingsIDLIPC", "getObricFlowSettingsJson = " + r11);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r18 - r5) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowSettingsIDLIPC", "getObricFlowSettingsJson(" + r22 + ") = " + r11, r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowSettingsIDLIPC", "getObricFlowSettingsJson", r14, r18);     // Catch: Exception -> L14 Throwable -> L17
        return r11;
    L16:
        return r11;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public String getObricCloudConfig(String r22) {
        long r5 = SystemClock.elapsedRealtimeNanos();
        String r11 = null;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowSettingsIDLIPC", "getObricCloudConfig(" + r22 + ")", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r4 = Math.max(0, r19 - r5) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowSettingsIDLIPC", "getObricCloudConfig(" + r22 + ") = fail", r2, r4);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowSettingsIDLIPC", "getObricCloudConfig", r2, r4, r19);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowSettingsIDLIPC", "getObricCloudConfig(" + r22 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowSettingsIDLIPC", "getObricCloudConfig(" + r22 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r11 = this.origin.getObricCloudConfig(r22);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowSettingsIDLIPC", "getObricCloudConfig = " + r11);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r18 - r5) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowSettingsIDLIPC", "getObricCloudConfig(" + r22 + ") = " + r11, r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowSettingsIDLIPC", "getObricCloudConfig", r14, r18);     // Catch: Exception -> L14 Throwable -> L17
        return r11;
    L16:
        return r11;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public void setOUseMemoryEnabled(boolean r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowSettingsIDLIPC", "setOUseMemoryEnabled(" + r21 + ")", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r4 = Math.max(0, r18 - r5) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowSettingsIDLIPC", "setOUseMemoryEnabled(" + r21 + ") = fail", r2, r4);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowSettingsIDLIPC", "setOUseMemoryEnabled", r2, r4, r18);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowSettingsIDLIPC", "setOUseMemoryEnabled(" + r21 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowSettingsIDLIPC", "setOUseMemoryEnabled(" + r21 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.setOUseMemoryEnabled(r21);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowSettingsIDLIPC", "setOUseMemoryEnabled = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowSettingsIDLIPC", "setOUseMemoryEnabled(" + r21 + ") = void", r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowSettingsIDLIPC", "setOUseMemoryEnabled", r14, r17);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public boolean getOUseMemoryEnabled() {
        long r3 = SystemClock.elapsedRealtimeNanos();
        boolean r9 = false;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowSettingsIDLIPC", "getOUseMemoryEnabled()", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r2 = Math.max(0, r17 - r3) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowSettingsIDLIPC", "getOUseMemoryEnabled() = fail", r1, r2);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowSettingsIDLIPC", "getOUseMemoryEnabled", r1, r2, r17);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowSettingsIDLIPC", "getOUseMemoryEnabled()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowSettingsIDLIPC", "getOUseMemoryEnabled()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r9 = this.origin.getOUseMemoryEnabled();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowSettingsIDLIPC", "getOUseMemoryEnabled = " + r9);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r16 - r3) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowSettingsIDLIPC", "getOUseMemoryEnabled() = " + r9, r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowSettingsIDLIPC", "getOUseMemoryEnabled", r14, r16);     // Catch: Exception -> L14 Throwable -> L17
        return r9;
    L16:
        return r9;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public boolean isLarkKnowledgeAuthorizationEnable() {
        long r3 = SystemClock.elapsedRealtimeNanos();
        boolean r9 = false;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowSettingsIDLIPC", "isLarkKnowledgeAuthorizationEnable()", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r2 = Math.max(0, r17 - r3) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowSettingsIDLIPC", "isLarkKnowledgeAuthorizationEnable() = fail", r1, r2);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowSettingsIDLIPC", "isLarkKnowledgeAuthorizationEnable", r1, r2, r17);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowSettingsIDLIPC", "isLarkKnowledgeAuthorizationEnable()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowSettingsIDLIPC", "isLarkKnowledgeAuthorizationEnable()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r9 = this.origin.isLarkKnowledgeAuthorizationEnable();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowSettingsIDLIPC", "isLarkKnowledgeAuthorizationEnable = " + r9);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r16 - r3) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowSettingsIDLIPC", "isLarkKnowledgeAuthorizationEnable() = " + r9, r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowSettingsIDLIPC", "isLarkKnowledgeAuthorizationEnable", r14, r16);     // Catch: Exception -> L14 Throwable -> L17
        return r9;
    L16:
        return r9;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public void setLarkKnowledgeAuthorizationEnabled(boolean r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowSettingsIDLIPC", "setLarkKnowledgeAuthorizationEnabled(" + r21 + ")", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r4 = Math.max(0, r18 - r5) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowSettingsIDLIPC", "setLarkKnowledgeAuthorizationEnabled(" + r21 + ") = fail", r2, r4);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowSettingsIDLIPC", "setLarkKnowledgeAuthorizationEnabled", r2, r4, r18);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowSettingsIDLIPC", "setLarkKnowledgeAuthorizationEnabled(" + r21 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowSettingsIDLIPC", "setLarkKnowledgeAuthorizationEnabled(" + r21 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.setLarkKnowledgeAuthorizationEnabled(r21);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowSettingsIDLIPC", "setLarkKnowledgeAuthorizationEnabled = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowSettingsIDLIPC", "setLarkKnowledgeAuthorizationEnabled(" + r21 + ") = void", r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowSettingsIDLIPC", "setLarkKnowledgeAuthorizationEnabled", r14, r17);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public boolean getAutoImageUploadEnabled() {
        long r3 = SystemClock.elapsedRealtimeNanos();
        boolean r9 = false;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowSettingsIDLIPC", "getAutoImageUploadEnabled()", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r2 = Math.max(0, r17 - r3) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowSettingsIDLIPC", "getAutoImageUploadEnabled() = fail", r1, r2);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowSettingsIDLIPC", "getAutoImageUploadEnabled", r1, r2, r17);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowSettingsIDLIPC", "getAutoImageUploadEnabled()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowSettingsIDLIPC", "getAutoImageUploadEnabled()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r9 = this.origin.getAutoImageUploadEnabled();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowSettingsIDLIPC", "getAutoImageUploadEnabled = " + r9);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r16 - r3) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowSettingsIDLIPC", "getAutoImageUploadEnabled() = " + r9, r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowSettingsIDLIPC", "getAutoImageUploadEnabled", r14, r16);     // Catch: Exception -> L14 Throwable -> L17
        return r9;
    L16:
        return r9;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public void setAutoImageUploadEnabled(boolean r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowSettingsIDLIPC", "setAutoImageUploadEnabled(" + r21 + ")", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r4 = Math.max(0, r18 - r5) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowSettingsIDLIPC", "setAutoImageUploadEnabled(" + r21 + ") = fail", r2, r4);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowSettingsIDLIPC", "setAutoImageUploadEnabled", r2, r4, r18);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowSettingsIDLIPC", "setAutoImageUploadEnabled(" + r21 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowSettingsIDLIPC", "setAutoImageUploadEnabled(" + r21 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.setAutoImageUploadEnabled(r21);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowSettingsIDLIPC", "setAutoImageUploadEnabled = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowSettingsIDLIPC", "setAutoImageUploadEnabled(" + r21 + ") = void", r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowSettingsIDLIPC", "setAutoImageUploadEnabled", r14, r17);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public boolean isLarkSendConfirmEnabled() {
        long r3 = SystemClock.elapsedRealtimeNanos();
        boolean r9 = false;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowSettingsIDLIPC", "isLarkSendConfirmEnabled()", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r2 = Math.max(0, r17 - r3) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowSettingsIDLIPC", "isLarkSendConfirmEnabled() = fail", r1, r2);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowSettingsIDLIPC", "isLarkSendConfirmEnabled", r1, r2, r17);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowSettingsIDLIPC", "isLarkSendConfirmEnabled()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowSettingsIDLIPC", "isLarkSendConfirmEnabled()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r9 = this.origin.isLarkSendConfirmEnabled();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowSettingsIDLIPC", "isLarkSendConfirmEnabled = " + r9);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r16 - r3) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowSettingsIDLIPC", "isLarkSendConfirmEnabled() = " + r9, r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowSettingsIDLIPC", "isLarkSendConfirmEnabled", r14, r16);     // Catch: Exception -> L14 Throwable -> L17
        return r9;
    L16:
        return r9;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public void setVoicePrintAuthenticateAutoGuiEnabled(boolean r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowSettingsIDLIPC", "setVoicePrintAuthenticateAutoGuiEnabled(" + r21 + ")", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r4 = Math.max(0, r18 - r5) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowSettingsIDLIPC", "setVoicePrintAuthenticateAutoGuiEnabled(" + r21 + ") = fail", r2, r4);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowSettingsIDLIPC", "setVoicePrintAuthenticateAutoGuiEnabled", r2, r4, r18);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowSettingsIDLIPC", "setVoicePrintAuthenticateAutoGuiEnabled(" + r21 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowSettingsIDLIPC", "setVoicePrintAuthenticateAutoGuiEnabled(" + r21 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.setVoicePrintAuthenticateAutoGuiEnabled(r21);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowSettingsIDLIPC", "setVoicePrintAuthenticateAutoGuiEnabled = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowSettingsIDLIPC", "setVoicePrintAuthenticateAutoGuiEnabled(" + r21 + ") = void", r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowSettingsIDLIPC", "setVoicePrintAuthenticateAutoGuiEnabled", r14, r17);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public boolean isVoicePrintAuthenticateAutoGuiEnabled() {
        long r3 = SystemClock.elapsedRealtimeNanos();
        boolean r9 = false;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowSettingsIDLIPC", "isVoicePrintAuthenticateAutoGuiEnabled()", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r2 = Math.max(0, r17 - r3) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowSettingsIDLIPC", "isVoicePrintAuthenticateAutoGuiEnabled() = fail", r1, r2);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowSettingsIDLIPC", "isVoicePrintAuthenticateAutoGuiEnabled", r1, r2, r17);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowSettingsIDLIPC", "isVoicePrintAuthenticateAutoGuiEnabled()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowSettingsIDLIPC", "isVoicePrintAuthenticateAutoGuiEnabled()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r9 = this.origin.isVoicePrintAuthenticateAutoGuiEnabled();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowSettingsIDLIPC", "isVoicePrintAuthenticateAutoGuiEnabled = " + r9);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r16 - r3) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowSettingsIDLIPC", "isVoicePrintAuthenticateAutoGuiEnabled() = " + r9, r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowSettingsIDLIPC", "isVoicePrintAuthenticateAutoGuiEnabled", r14, r16);     // Catch: Exception -> L14 Throwable -> L17
        return r9;
    L16:
        return r9;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public boolean getOAutoUseClipboardEnabled() {
        long r3 = SystemClock.elapsedRealtimeNanos();
        boolean r9 = false;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowSettingsIDLIPC", "getOAutoUseClipboardEnabled()", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r2 = Math.max(0, r17 - r3) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowSettingsIDLIPC", "getOAutoUseClipboardEnabled() = fail", r1, r2);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowSettingsIDLIPC", "getOAutoUseClipboardEnabled", r1, r2, r17);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowSettingsIDLIPC", "getOAutoUseClipboardEnabled()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowSettingsIDLIPC", "getOAutoUseClipboardEnabled()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r9 = this.origin.getOAutoUseClipboardEnabled();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowSettingsIDLIPC", "getOAutoUseClipboardEnabled = " + r9);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r16 - r3) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowSettingsIDLIPC", "getOAutoUseClipboardEnabled() = " + r9, r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowSettingsIDLIPC", "getOAutoUseClipboardEnabled", r14, r16);     // Catch: Exception -> L14 Throwable -> L17
        return r9;
    L16:
        return r9;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public int getAuthenticationTypeOnLockScreen(String r22) {
        long r5 = SystemClock.elapsedRealtimeNanos();
        int r11 = 0;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowSettingsIDLIPC", "getAuthenticationTypeOnLockScreen(" + r22 + ")", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r4 = Math.max(0, r19 - r5) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowSettingsIDLIPC", "getAuthenticationTypeOnLockScreen(" + r22 + ") = fail", r2, r4);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowSettingsIDLIPC", "getAuthenticationTypeOnLockScreen", r2, r4, r19);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowSettingsIDLIPC", "getAuthenticationTypeOnLockScreen(" + r22 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowSettingsIDLIPC", "getAuthenticationTypeOnLockScreen(" + r22 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r11 = this.origin.getAuthenticationTypeOnLockScreen(r22);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowSettingsIDLIPC", "getAuthenticationTypeOnLockScreen = " + r11);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r18 - r5) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowSettingsIDLIPC", "getAuthenticationTypeOnLockScreen(" + r22 + ") = " + r11, r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowSettingsIDLIPC", "getAuthenticationTypeOnLockScreen", r14, r18);     // Catch: Exception -> L14 Throwable -> L17
        return r11;
    L16:
        return r11;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public Map getAutoExecuteAuthorizationStatusMap() {
        long r3 = SystemClock.elapsedRealtimeNanos();
        Map r9 = null;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowSettingsIDLIPC", "getAutoExecuteAuthorizationStatusMap()", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r2 = Math.max(0, r17 - r3) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowSettingsIDLIPC", "getAutoExecuteAuthorizationStatusMap() = fail", r1, r2);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowSettingsIDLIPC", "getAutoExecuteAuthorizationStatusMap", r1, r2, r17);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowSettingsIDLIPC", "getAutoExecuteAuthorizationStatusMap()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowSettingsIDLIPC", "getAutoExecuteAuthorizationStatusMap()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r9 = this.origin.getAutoExecuteAuthorizationStatusMap();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowSettingsIDLIPC", "getAutoExecuteAuthorizationStatusMap = " + r9);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r16 - r3) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowSettingsIDLIPC", "getAutoExecuteAuthorizationStatusMap() = " + r9, r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowSettingsIDLIPC", "getAutoExecuteAuthorizationStatusMap", r14, r16);     // Catch: Exception -> L14 Throwable -> L17
        return r9;
    L16:
        return r9;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
    public String getAutoGuiFastModeUseSettings() {
        long r3 = SystemClock.elapsedRealtimeNanos();
        String r9 = null;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowSettingsIDLIPC", "getAutoGuiFastModeUseSettings()", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r2 = Math.max(0, r17 - r3) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowSettingsIDLIPC", "getAutoGuiFastModeUseSettings() = fail", r1, r2);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowSettingsIDLIPC", "getAutoGuiFastModeUseSettings", r1, r2, r17);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowSettingsIDLIPC", "getAutoGuiFastModeUseSettings()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowSettingsIDLIPC", "getAutoGuiFastModeUseSettings()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r9 = this.origin.getAutoGuiFastModeUseSettings();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowSettingsIDLIPC", "getAutoGuiFastModeUseSettings = " + r9);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r16 - r3) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowSettingsIDLIPC", "getAutoGuiFastModeUseSettings() = " + r9, r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowSettingsIDLIPC", "getAutoGuiFastModeUseSettings", r14, r16);     // Catch: Exception -> L14 Throwable -> L17
        return r9;
    L16:
        return r9;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.origin.asBinder();
    }
}
