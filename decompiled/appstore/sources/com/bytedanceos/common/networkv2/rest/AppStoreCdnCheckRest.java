package com.bytedanceos.common.networkv2.rest;

import com.bytedanceos.common.networkv2.service.AppStoreCdnCheckService;
import retrofit2.Response;

/* JADX INFO: loaded from: classes2.dex */
public class AppStoreCdnCheckRest extends AbstractRest {
    private static volatile AppStoreCdnCheckRest sInstance;
    private AppStoreCdnCheckService mService;

    private AppStoreCdnCheckRest() {
        init();
    }

    public static AppStoreCdnCheckRest instance() {
        if (sInstance != null) goto L16;
        monitor-enter(AppStoreCdnCheckRest.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L11;
        sInstance = new AppStoreCdnCheckRest();     // Catch: Throwable -> L9
    L11:
        monitor-exit(AppStoreCdnCheckRest.class);     // Catch: Throwable -> L9
    L16:
        return sInstance;
    }

    public Response<Void> checkCdnConnected() throws Exception {
        return this.mService.checkCdnConnected().execute();
    }

    @Override // com.bytedanceos.common.networkv2.rest.AbstractRest
    public String getBaseUrl() {
        return "";
    }

    @Override // com.bytedanceos.common.networkv2.rest.AbstractRest
    public void setService() {
        this.mService = (AppStoreCdnCheckService) this.retrofit.d(AppStoreCdnCheckService.class);
    }
}
