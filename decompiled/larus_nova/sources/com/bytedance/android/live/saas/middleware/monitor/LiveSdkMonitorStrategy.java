package com.bytedance.android.live.saas.middleware.monitor;

import android.app.Application;
import android.text.TextUtils;
import com.bytedance.android.live.saas.middleware.BDLiveSdk;
import com.bytedance.android.live.saas.middleware.IAppInfo;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitor;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitorUtils;
import com.bytedance.services.apm.api.EnsureManager;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public class LiveSdkMonitorStrategy extends IMonitorReport {
    private static final String LIVE_SDK_AID = "1730";
    private static final String REPORT_URL = "https://mon.snssdk.com/monitor/collect/";
    private String hostAid;
    private SDKMonitor mSDKMonitor;

    private List<String> getConfigUrls() {
        LinkedList r100 = new LinkedList();
        r100.add("https://mon.snssdk.com/monitor/appmonitor/v2/settings");
        r100.add("https://monsetting.toutiao.com/monitor/appmonitor/v2/settings");
        return r100;
    }

    private List<String> getReportUrls() {
        LinkedList r100 = new LinkedList();
        r100.add("https://mon.snssdk.com/monitor/collect/");
        return r100;
    }

    public LiveSdkMonitorStrategy(String r100) {
        this.hostAid = r100;
    }

    public static /* synthetic */ String access$000(LiveSdkMonitorStrategy r100) {
        return r100.hostAid;
    }

    private void addHostId(JSONObject r100) {
        if (r100 != null) goto L10;
        r100 = new JSONObject();
    L10:
        r100.put("webcast_app_id", "" + BDLiveSdk.getAppInfo().appId());     // Catch: JSONException -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // com.bytedance.android.live.saas.middleware.monitor.IMonitorReport
    public void init(Application r100) {
        super.init(r100);
        JSONObject r101 = new JSONObject();
        IAppInfo r102 = BDLiveSdk.getAppInfo();     // Catch: JSONException -> L9
        if (TextUtils.isEmpty(this.hostAid) == false) goto L6;
        this.hostAid = r102.hostAppId();     // Catch: JSONException -> L9
    L6:
        r101.put("device_id", r102.devicesId());     // Catch: JSONException -> L9
        r101.put("host_aid", this.hostAid);     // Catch: JSONException -> L9
        r101.put("sdk_version", r102.sdkVersion());     // Catch: JSONException -> L9
        r101.put("channel", r102.channel());     // Catch: JSONException -> L9
        r101.put("app_version", r102.versionName());     // Catch: JSONException -> L9
        r101.put("update_version_code", r102.updateVersionCode());     // Catch: JSONException -> L9
        SDKMonitorUtils.setDefaultReportUrl(LIVE_SDK_AID, getReportUrls());
        SDKMonitorUtils.setConfigUrl(LIVE_SDK_AID, getConfigUrls());
        SDKMonitorUtils.initMonitor(r100, LIVE_SDK_AID, r101, new AnonymousClass1(this));
        this.mSDKMonitor = SDKMonitorUtils.getInstance(LIVE_SDK_AID);
        return;
    L9:
        e = move-exception;
        throw new IllegalStateException("bad json error", e);
    }

    @Override // com.bytedance.android.live.saas.middleware.monitor.IMonitorReport
    public void monitorDebugReal(String r100) {
        if (BDLiveSdk.getAppInfo().isDebug() == true) goto L6;
        return;
    L6:
        throw new RuntimeException("sdkmonitor unsupport this api");
    }

    @Override // com.bytedance.android.live.saas.middleware.monitor.IMonitorReport
    public void ensureNotReachHere(Throwable r100, String r101) {
        EnsureManager.ensureNotReachHere(r100, r101);
    }

    @Override // com.bytedance.android.live.saas.middleware.monitor.IMonitorReport
    public void monitorCommonLog(String r100, JSONObject r101) {
        addHostId(r101);
        SDKMonitor r102 = this.mSDKMonitor;
        if (r102 == null) goto L6;
        r102.monitorCommonLog(r100, r101);
        return;
    }

    @Override // com.bytedance.android.live.saas.middleware.monitor.IMonitorReport
    public void monitorDebugReal(String r100, String r101) {
        if (BDLiveSdk.getAppInfo().isDebug() == true) goto L6;
        return;
    L6:
        throw new RuntimeException("sdkmonitor unsupport this api");
    }

    @Override // com.bytedance.android.live.saas.middleware.monitor.IMonitorReport
    public void monitorOnCount(String r100, String r101) {
        if (BDLiveSdk.getAppInfo().isDebug() == true) goto L6;
        return;
    L6:
        throw new RuntimeException("sdkmonitor unsupport this api");
    }

    @Override // com.bytedance.android.live.saas.middleware.monitor.IMonitorReport
    public void monitorCommonLog(String r100, String r101, JSONObject r102) {
        addHostId(r102);
        if (r102 != null) goto L13;
        r102 = new JSONObject();
    L13:
    L9:
        e = move-exception;
        e.printStackTrace();
    L11:
        monitorCommonLog(r100, r102);
        return;
    L6:
        if (TextUtils.isEmpty(r101) == true) goto L11;
        r102.put("service", r101);     // Catch: JSONException -> L9
        goto L11
    }

    @Override // com.bytedance.android.live.saas.middleware.monitor.IMonitorReport
    public void monitorDirectOnCount(String r100, String r101, float r102) {
        if (BDLiveSdk.getAppInfo().isDebug() == true) goto L6;
        return;
    L6:
        throw new RuntimeException("sdkmonitor unsupport this api");
    }

    @Override // com.bytedance.android.live.saas.middleware.monitor.IMonitorReport
    public void monitorDirectOnTimer(String r100, String r101, float r102) {
        if (BDLiveSdk.getAppInfo().isDebug() == true) goto L6;
        return;
    L6:
        throw new RuntimeException("sdkmonitor unsupport this api");
    }

    @Override // com.bytedance.android.live.saas.middleware.monitor.IMonitorReport
    public void monitorDuration(String r100, JSONObject r101, JSONObject r102) {
        addHostId(r102);
        SDKMonitor r103 = this.mSDKMonitor;
        if (r103 == null) goto L6;
        r103.monitorDuration(r100, r101, r102);
        return;
    }

    @Override // com.bytedance.android.live.saas.middleware.monitor.IMonitorReport
    public void monitorOnCount(String r100, String r101, float r102) {
        if (BDLiveSdk.getAppInfo().isDebug() == true) goto L6;
        return;
    L6:
        throw new RuntimeException("sdkmonitor unsupport this api");
    }

    @Override // com.bytedance.android.live.saas.middleware.monitor.IMonitorReport
    public void monitorOnStore(String r100, String r101, float r102) {
        if (BDLiveSdk.getAppInfo().isDebug() == true) goto L6;
        return;
    L6:
        throw new RuntimeException("sdkmonitor unsupport this api");
    }

    @Override // com.bytedance.android.live.saas.middleware.monitor.IMonitorReport
    public void monitorOnTimer(String r100, String r101, float r102) {
        if (BDLiveSdk.getAppInfo().isDebug() == true) goto L6;
        return;
    L6:
        throw new RuntimeException("sdkmonitor unsupport this api");
    }

    @Override // com.bytedance.android.live.saas.middleware.monitor.IMonitorReport
    public void monitorStatusRate(String r100, int r101, JSONObject r102) {
        addHostId(r102);
        SDKMonitor r103 = this.mSDKMonitor;
        if (r103 == null) goto L6;
        r103.monitorStatusRate(r100, r101, r102);
        return;
    }

    @Override // com.bytedance.android.live.saas.middleware.monitor.IMonitorReport
    public void monitorEvent(String r100, JSONObject r101, JSONObject r102, JSONObject r103) {
        SDKMonitor r104 = this.mSDKMonitor;
        if (r104 == null) goto L6;
        r104.monitorEvent(r100, r101, r102, r103);
        return;
    }

    @Override // com.bytedance.android.live.saas.middleware.monitor.IMonitorReport
    public void monitorStatusAndDuration(String r100, int r101, JSONObject r102, JSONObject r103) {
        addHostId(r103);
        SDKMonitor r104 = this.mSDKMonitor;
        if (r104 == null) goto L6;
        r104.monitorStatusAndDuration(r100, r101, r102, r103);
        return;
    }

    @Override // com.bytedance.android.live.saas.middleware.monitor.IMonitorReport
    public void monitorApiError(long r110, long r111, String r112, String r113, String r114, int r115, JSONObject r210) {
        addHostId(r210);
        SDKMonitor r100 = this.mSDKMonitor;
        if (r100 == null) goto L6;
        r100.monitorApiError(r110, r111, r112, r113, r114, r115, r210);
        return;
    }

    @Override // com.bytedance.android.live.saas.middleware.monitor.IMonitorReport
    public void monitorSLA(long r110, long r111, String r112, String r113, String r114, int r115, JSONObject r210) {
        addHostId(r210);
        SDKMonitor r100 = this.mSDKMonitor;
        if (r100 == null) goto L6;
        r100.monitorSLA(r110, r111, r112, r113, r114, r115, r210);
        return;
    }
}
