package com.android.ttcjpaysdk.base.performance.applog;

import com.android.ttcjpaysdk.base.performance.CompileOnlyManager;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.bytedance.caijing.sdk.infra.base.api.applog.AppLogService;
import org.json.JSONObject;
import ve4.a;

/* JADX INFO: loaded from: classes28.dex */
public class AppLogManager extends CompileOnlyManager {
    private static volatile AppLogManager instance;

    public static AppLogManager getInstance() {
        if (instance != null) goto L15;
        monitor-enter(AppLogManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (instance != null) goto L9;
        instance = new AppLogManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(AppLogManager.class);     // Catch: Throwable -> L11
    L15:
        return instance;
    }

    @Override // com.android.ttcjpaysdk.base.performance.CompileOnlyManager
    public boolean checkInstall() {
        a.f554342a.getClass();
        return ((AppLogService) a.a(AppLogService.class)).checkInstall();
    }

    private AppLogManager() {
    }

    public void onEvent(String r100, JSONObject r101) {
        if (isInstall() == false) goto L11;
        a.f554342a.getClass();     // Catch: Throwable -> L6
        ((AppLogService) a.a(AppLogService.class)).onEventV3(r100, r101);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        CJBasicCommonUtils.reportCatchException("AppLogManager#onEvent", th);
        CJBasicCommonUtils.logCatch("CJCatch", "AppLogManager#onEvent", th);
        return;
    }
}
