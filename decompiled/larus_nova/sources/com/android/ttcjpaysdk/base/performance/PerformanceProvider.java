package com.android.ttcjpaysdk.base.performance;

import android.content.Context;
import com.android.ttcjpaysdk.base.performance.applog.AppLogManager;
import com.android.ttcjpaysdk.base.performance.crash.CrashCatchManager;
import com.android.ttcjpaysdk.base.performance.keep.PageKeepManager;
import com.android.ttcjpaysdk.base.performance.monitor.ApmMonitorManager;
import com.android.ttcjpaysdk.base.service.ICJPayPerformanceService;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class PerformanceProvider implements ICJPayPerformanceService {
    public PerformanceProvider() {
    }

    @Override // com.android.ttcjpaysdk.base.service.ICJPayService
    public String getPackageName() {
        return null;
    }

    @Override // com.android.ttcjpaysdk.base.service.ICJPayPerformanceService
    public void startFpsTrace(String r100, boolean r101) {
    }

    @Override // com.android.ttcjpaysdk.base.service.ICJPayPerformanceService
    public void startFpsTraceForDelayStop(String r100, boolean r101, long r102) {
    }

    @Override // com.android.ttcjpaysdk.base.service.ICJPayPerformanceService
    public void stopFpsTrace(String r100) {
    }

    @Override // com.android.ttcjpaysdk.base.service.ICJPayPerformanceService
    public boolean isInstallApmMonitor() {
        return ApmMonitorManager.getInstance().isInstall();
    }

    @Override // com.android.ttcjpaysdk.base.service.ICJPayPerformanceService
    public boolean isInstallAppLog() {
        return AppLogManager.getInstance().isInstall();
    }

    @Override // com.android.ttcjpaysdk.base.service.ICJPayPerformanceService
    public void endKeepPage(String r100) {
        PageKeepManager.endKeep(r100);
    }

    @Override // com.android.ttcjpaysdk.base.service.ICJPayPerformanceService
    public void init(Context r100) {
        CrashCatchManager.getInstance().init();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        CJBasicCommonUtils.reportCatchException("PerformanceProvider#init", th);
        CJBasicCommonUtils.logCatch("CJCatch", "PerformanceProvider#init", th);
    }

    @Override // com.android.ttcjpaysdk.base.service.ICJPayPerformanceService
    public void initModule(String r100) {
        CrashCatchManager.getInstance().initModule(r100);
    }

    @Override // com.android.ttcjpaysdk.base.service.ICJPayPerformanceService
    public void startKeepPage(String r100) {
        PageKeepManager.startKeep(r100);
    }

    @Override // com.android.ttcjpaysdk.base.service.ICJPayPerformanceService
    public void onAppLogEvent(String r100, JSONObject r101) {
        AppLogManager.getInstance().onEvent(r100, r101);
    }

    @Override // com.android.ttcjpaysdk.base.service.ICJPayPerformanceService
    public void onApmMonitorEvent(String r100, JSONObject r101, JSONObject r102, JSONObject r103) {
        ApmMonitorManager.getInstance().onApmMonitorEvent(r100, r101, r102, r103);
    }
}
