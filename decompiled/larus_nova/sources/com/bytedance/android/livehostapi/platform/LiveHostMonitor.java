package com.bytedance.android.livehostapi.platform;

import com.bytedance.android.live.core.utils.JsonUtil;
import com.bytedance.android.live.saas.middleware.BDLiveSdk;
import com.bytedance.android.live.saas.middleware.monitor.IMonitorReport;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public class LiveHostMonitor implements IHostMonitor {
    public LiveHostMonitor() {
    }

    @Override // com.bytedance.android.livehostapi.platform.IHostMonitor
    public boolean isNotHitSampled(String r100) {
        return false;
    }

    @Override // com.bytedance.android.livehostapi.platform.IHostMonitor
    public void monitorOppoOptScene(String r100) {
    }

    @Override // com.bytedance.android.livehostapi.platform.IHostMonitor
    public void setBusiness() {
    }

    @Override // com.bytedance.android.livehostapi.platform.IHostMonitor
    public void setCpuSceneInfo(String r100) {
    }

    @Override // com.bytedance.android.livehostapi.platform.IHostMonitor
    public final /* synthetic */ void uploadALog(long r100, long r101, String r102) {
        IHostMonitor.CC.$default$uploadALog(this, r100, r101, r102);
    }

    @Override // com.bytedance.android.livehostapi.platform.IHostMonitor
    public void monitorDebugReal(String r100) {
        IMonitorReport r101 = BDLiveSdk.getMonitor();
        if (r101 == null) goto L6;
        r101.monitorDebugReal(r100);
        return;
    }

    @Override // com.bytedance.android.livehostapi.platform.IHostMonitor
    public void ensureNotReachHere(Throwable r100, String r101) {
        IMonitorReport r102 = BDLiveSdk.getMonitor();
        if (r102 == null) goto L6;
        r102.ensureNotReachHere(r100, r101);
        return;
    }

    @Override // com.bytedance.android.livehostapi.platform.IHostMonitor
    public void monitorCommonLog(String r100, JSONObject r101) {
        IMonitorReport r102 = BDLiveSdk.getMonitor();
        if (r102 == null) goto L6;
        r102.monitorCommonLog(r100, r101);
        return;
    }

    @Override // com.bytedance.android.livehostapi.platform.IHostMonitor
    public void monitorDebugReal(String r100, String r101) {
        IMonitorReport r102 = BDLiveSdk.getMonitor();
        if (r102 == null) goto L6;
        r102.monitorDebugReal(r100, r101);
        return;
    }

    @Override // com.bytedance.android.livehostapi.platform.IHostMonitor
    public void monitorOnCount(String r100, String r101) {
        IMonitorReport r102 = BDLiveSdk.getMonitor();
        if (r102 == null) goto L6;
        r102.monitorOnCount(r100, r101);
        return;
    }

    @Override // com.bytedance.android.livehostapi.platform.IHostMonitor
    public void monitorCommonLog(String r100, String r101, JSONObject r102) {
        IMonitorReport r103 = BDLiveSdk.getMonitor();
        if (r103 == null) goto L6;
        r103.monitorCommonLog(r100, r101, r102);
        return;
    }

    @Override // com.bytedance.android.livehostapi.platform.IHostMonitor
    public void monitorDirectOnCount(String r100, String r101, float r102) {
        IMonitorReport r103 = BDLiveSdk.getMonitor();
        if (r103 == null) goto L6;
        r103.monitorDirectOnCount(r100, r101, r102);
        return;
    }

    @Override // com.bytedance.android.livehostapi.platform.IHostMonitor
    public void monitorDirectOnTimer(String r100, String r101, float r102) {
        IMonitorReport r103 = BDLiveSdk.getMonitor();
        if (r103 == null) goto L6;
        r103.monitorDirectOnTimer(r100, r101, r102);
        return;
    }

    @Override // com.bytedance.android.livehostapi.platform.IHostMonitor
    public void monitorDuration(String r100, JSONObject r101, JSONObject r102) {
        IMonitorReport r103 = BDLiveSdk.getMonitor();
        if (r103 == null) goto L6;
        r103.monitorDuration(r100, r101, r102);
        return;
    }

    @Override // com.bytedance.android.livehostapi.platform.IHostMonitor
    public void monitorOnCount(String r100, String r101, float r102) {
        IMonitorReport r103 = BDLiveSdk.getMonitor();
        if (r103 == null) goto L6;
        r103.monitorOnCount(r100, r101, r102);
        return;
    }

    @Override // com.bytedance.android.livehostapi.platform.IHostMonitor
    public void monitorOnStore(String r100, String r101, float r102) {
        IMonitorReport r103 = BDLiveSdk.getMonitor();
        if (r103 == null) goto L6;
        r103.monitorOnStore(r100, r101, r102);
        return;
    }

    @Override // com.bytedance.android.livehostapi.platform.IHostMonitor
    public void monitorOnTimer(String r100, String r101, float r102) {
        IMonitorReport r103 = BDLiveSdk.getMonitor();
        if (r103 == null) goto L6;
        r103.monitorOnTimer(r100, r101, r102);
        return;
    }

    @Override // com.bytedance.android.livehostapi.platform.IHostMonitor
    public void monitorStatusRate(String r100, int r101, JSONObject r102) {
        IMonitorReport r103 = BDLiveSdk.getMonitor();
        if (r103 == null) goto L10;
        r102 = JsonUtil.copyJson2(r102);     // Catch: JSONException -> L7
    L5:
        r103.monitorStatusRate(r100, r101, r102);
        return;
    }

    @Override // com.bytedance.android.livehostapi.platform.IHostMonitor
    public void monitorEvent(String r100, JSONObject r101, JSONObject r102, JSONObject r103) {
        IMonitorReport r104 = BDLiveSdk.getMonitor();
        if (r104 == null) goto L6;
        r104.monitorEvent(r100, r101, r102, r103);
        return;
    }

    @Override // com.bytedance.android.livehostapi.platform.IHostMonitor
    public void monitorStatusAndDuration(String r100, int r101, JSONObject r102, JSONObject r103) {
        IMonitorReport r104 = BDLiveSdk.getMonitor();
        if (r104 == null) goto L6;
        r104.monitorStatusAndDuration(r100, r101, r102, r103);
        return;
    }

    @Override // com.bytedance.android.livehostapi.platform.IHostMonitor
    public void monitorApiError(long r110, long r111, String r112, String r113, String r114, int r115, JSONObject r116) {
        IMonitorReport r100 = BDLiveSdk.getMonitor();
        if (r100 == null) goto L6;
        r100.monitorApiError(r110, r111, r112, r113, r114, r115, r116);
        return;
    }

    @Override // com.bytedance.android.livehostapi.platform.IHostMonitor
    public void monitorSLA(long r110, long r111, String r112, String r113, String r114, int r115, JSONObject r116) {
        IMonitorReport r100 = BDLiveSdk.getMonitor();
        if (r100 == null) goto L6;
        r100.monitorSLA(r110, r111, r112, r113, r114, r115, r116);
        return;
    }
}
