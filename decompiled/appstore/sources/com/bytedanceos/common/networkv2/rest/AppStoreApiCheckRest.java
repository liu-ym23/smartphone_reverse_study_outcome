package com.bytedanceos.common.networkv2.rest;

import com.bytedanceos.common.networkv2.service.AppStoreApiCheckService;
import retrofit2.Response;

/* JADX INFO: loaded from: classes2.dex */
public class AppStoreApiCheckRest extends AbstractRest {
    private static volatile AppStoreApiCheckRest sInstance;
    private AppStoreApiCheckService mService;

    private AppStoreApiCheckRest() {
        init();
    }

    public static AppStoreApiCheckRest instance() {
        if (sInstance != null) goto L16;
        monitor-enter(AppStoreApiCheckRest.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L11;
        sInstance = new AppStoreApiCheckRest();     // Catch: Throwable -> L9
    L11:
        monitor-exit(AppStoreApiCheckRest.class);     // Catch: Throwable -> L9
    L16:
        return sInstance;
    }

    public Response<Void> checkApiConnected() throws Exception {
        return this.mService.checkApiConnected().execute();
    }

    @Override // com.bytedanceos.common.networkv2.rest.AbstractRest
    public String getBaseUrl() {
        return "";
    }

    @Override // com.bytedanceos.common.networkv2.rest.AbstractRest
    public void setService() {
        this.mService = (AppStoreApiCheckService) this.retrofit.d(AppStoreApiCheckService.class);
    }
}
