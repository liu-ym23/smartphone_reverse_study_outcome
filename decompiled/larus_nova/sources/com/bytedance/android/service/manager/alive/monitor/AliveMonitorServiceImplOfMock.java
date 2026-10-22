package com.bytedance.android.service.manager.alive.monitor;

import android.content.Context;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public class AliveMonitorServiceImplOfMock implements AliveMonitorService {
    public AliveMonitorServiceImplOfMock() {
    }

    @Override // com.bytedance.android.service.manager.alive.monitor.AliveMonitorService
    public boolean curProcessIsFirstProcess(Context r100) {
        return false;
    }

    @Override // com.bytedance.android.service.manager.alive.monitor.AliveMonitorService
    public JSONObject getProcessStartInfoObject(Context r100) {
        return null;
    }

    @Override // com.bytedance.android.service.manager.alive.monitor.AliveMonitorService
    public boolean hasHookActivityManagerSuccess(Context r100) {
        return false;
    }

    @Override // com.bytedance.android.service.manager.alive.monitor.AliveMonitorService
    public boolean hasHookActivityTaskManagerSuccess(Context r100) {
        return false;
    }

    @Override // com.bytedance.android.service.manager.alive.monitor.AliveMonitorService
    public void monitorAssociationStart(Context r100) {
    }

    @Override // com.bytedance.android.service.manager.alive.monitor.AliveMonitorService
    public void monitorAssociationStart(Context r100, IMonitorCallback r101) {
    }

    @Override // com.bytedance.android.service.manager.alive.monitor.AliveMonitorService
    public void onUserActive() {
    }

    @Override // com.bytedance.android.service.manager.alive.monitor.AliveMonitorService
    public void startDetectProcessLaunchReason(Context r100) {
    }
}
