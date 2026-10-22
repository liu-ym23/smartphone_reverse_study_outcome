package com.android.ttcjpaysdk.base.performance.monitor;

import com.android.ttcjpaysdk.base.performance.CompileOnlyManager;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.bytedance.caijing.sdk.infra.base.api.monitor.MonitorService;
import org.json.JSONObject;
import ve4.a;

/* JADX INFO: loaded from: classes28.dex */
public class ApmMonitorManager extends CompileOnlyManager {
    private static volatile ApmMonitorManager instance;

    public static ApmMonitorManager getInstance() {
        if (instance != null) goto L15;
        monitor-enter(ApmMonitorManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (instance != null) goto L9;
        instance = new ApmMonitorManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(ApmMonitorManager.class);     // Catch: Throwable -> L11
    L15:
        return instance;
    }

    @Override // com.android.ttcjpaysdk.base.performance.CompileOnlyManager
    public boolean checkInstall() {
        a.f554342a.getClass();
        MonitorService r100 = (MonitorService) a.a(MonitorService.class);
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.checkInstallAPM();
    }

    private ApmMonitorManager() {
    }

    public void onApmMonitorEvent(String r100, JSONObject r101, JSONObject r102, JSONObject r103) {
        if (isInstall() == false) goto L13;
        a.f554342a.getClass();     // Catch: Throwable -> L8
        MonitorService r104 = (MonitorService) a.a(MonitorService.class);     // Catch: Throwable -> L8
        if (r104 == null) goto L14;
        r104.onApmMonitorEvent(r100, r101, r102, r103);     // Catch: Throwable -> L8
        return;
    L14:
        return;
    L8:
        th = move-exception;
        CJBasicCommonUtils.reportCatchException("ApmMonitorManager#onApmMonitorEvent", th);
        CJBasicCommonUtils.logCatch("CJCatch", "ApmMonitorManager#onApmMonitorEvent", th);
        return;
    }
}
