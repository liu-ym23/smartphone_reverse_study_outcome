package com.bytedanceos.appstore.download.service;

import android.annotation.TargetApi;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.core.install.AbstractInstallService;

/* JADX INFO: loaded from: classes2.dex */
@TargetApi(9)
public class AppsInstallService extends AbstractInstallService {
    public AppsInstallService() {
    }

    @Override // com.bytedanceos.common.core.install.AbstractInstallService, android.app.Service
    public void onCreate() {
        super.onCreate();
        BaseApplication.u("AppsInstallService ", false);
    }

    @Override // com.bytedanceos.common.core.install.AbstractInstallService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        BaseApplication.u("AppsInstallService ", true);
    }
}
