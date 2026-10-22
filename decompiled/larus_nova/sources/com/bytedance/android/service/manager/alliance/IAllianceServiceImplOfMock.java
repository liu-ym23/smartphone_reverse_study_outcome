package com.bytedance.android.service.manager.alliance;

import android.app.Application;
import android.content.Context;
import org.json.JSONObject;
import p67.a;

/* JADX INFO: loaded from: classes3.dex */
public class IAllianceServiceImplOfMock implements IAllianceService {
    public IAllianceServiceImplOfMock() {
    }

    @Override // com.bytedance.android.service.manager.alliance.IAllianceService
    public boolean allowStartOthersProcessFromSmp() {
        return false;
    }

    @Override // com.bytedance.android.service.manager.alliance.IAllianceService
    public boolean allowSyncInSmpWhenProcessIsolate() {
        return false;
    }

    @Override // com.bytedance.android.service.manager.alliance.IAllianceService
    public boolean depthsInMainProcess(Context r100) {
        return false;
    }

    @Override // com.bytedance.android.service.manager.alliance.IAllianceService
    public void doAfterProcessIsolationProtected(Runnable r100) {
    }

    @Override // com.bytedance.android.service.manager.alliance.IAllianceService
    public boolean hasWaked() {
        return false;
    }

    @Override // com.bytedance.android.service.manager.alliance.IAllianceService
    public String isRiskDevice(Context r100, a r101) {
        return "";
    }

    @Override // com.bytedance.android.service.manager.alliance.IAllianceService
    public boolean isRiskDevice(Context r100, boolean r101) {
        return false;
    }

    @Override // com.bytedance.android.service.manager.alliance.IAllianceService
    public boolean isStartByAlliance(Context r100) {
        return false;
    }

    @Override // com.bytedance.android.service.manager.alliance.IAllianceService
    public IsSupportWakeUp isSupportWakeUp(Context r100) {
        return null;
    }

    @Override // com.bytedance.android.service.manager.alliance.IAllianceService
    public void onApplicationInit(String r100, Context r101) {
    }

    @Override // com.bytedance.android.service.manager.alliance.IAllianceService
    public void onAttachBaseContext(Application r100) {
    }

    @Override // com.bytedance.android.service.manager.alliance.IAllianceService
    public void onBackgroundProcessAlive(String r100) {
    }

    @Override // com.bytedance.android.service.manager.alliance.IAllianceService
    public void onEventV3(boolean r100, String r101, JSONObject r102) {
    }

    @Override // com.bytedance.android.service.manager.alliance.IAllianceService
    public void onEventV3WithHttp(boolean r100, String r101, JSONObject r102) {
    }

    @Override // com.bytedance.android.service.manager.alliance.IAllianceService
    public void onInitOnProcessIsolationProtectedMode() {
    }

    @Override // com.bytedance.android.service.manager.alliance.IAllianceService
    public void onMainProcessStart() {
    }

    @Override // com.bytedance.android.service.manager.alliance.IAllianceService
    public void onSmpProcessStart(Context r100, Object r101, String r102, SmpProcessInitCallback r103) {
    }

    @Override // com.bytedance.android.service.manager.alliance.IAllianceService
    public void onWorkerApplicationStart() {
    }

    @Override // com.bytedance.android.service.manager.alliance.IAllianceService
    public void reportEventByHttpNow(Context r100, String r101, JSONObject r102) {
    }

    @Override // com.bytedance.android.service.manager.alliance.IAllianceService
    public void startClientAccountRetryTask(String r100) {
    }

    @Override // com.bytedance.android.service.manager.alliance.IAllianceService
    public void updateSettings(Context r100, JSONObject r101) {
    }

    @Override // com.bytedance.android.service.manager.alliance.IAllianceService
    public boolean verifySign(String r100, String r101) {
        return false;
    }

    @Override // com.bytedance.android.service.manager.alliance.IAllianceService
    public void wakeUpTargetPartner(JSONObject r100) {
    }

    @Override // com.bytedance.android.service.manager.alliance.IAllianceService
    public ICommonInstrumentation getInstrumentationService() {
        return new ICommonInstrumentationImplOfMock();
    }
}
