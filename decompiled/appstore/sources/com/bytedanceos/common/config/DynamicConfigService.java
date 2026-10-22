package com.bytedanceos.common.config;

import android.app.IntentService;
import android.content.Intent;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.toolbox.j;
import h8.b;
import j8.a;

/* JADX INFO: loaded from: classes2.dex */
public class DynamicConfigService extends IntentService {
    public DynamicConfigService() {
        super("DynamicConfigService");
    }

    @Override // android.app.IntentService, android.app.Service
    public void onCreate() {
        super.onCreate();
        BaseApplication.u("DynamicConfigService", false);
    }

    @Override // android.app.IntentService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        BaseApplication.u("DynamicConfigService", true);
    }

    @Override // android.app.IntentService
    public void onHandleIntent(Intent r10) {
        if (r10 != null) goto L5;
        j.n("intent params is null");
        return;
    L5:
        int r11 = r10.getIntExtra("dynamic_config_type", 0);
        if (r11 != 129) goto L8;
        b.b().syncSettingData();
        i8.b.a().syncSettingData();
        return;
    L8:
        if (r11 != 131) goto L14;
        a.a().syncSettingData();
        return;
    }
}
