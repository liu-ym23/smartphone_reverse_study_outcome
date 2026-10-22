package com.bytedance.android.livesdkapi;

import com.bytedance.android.livesdkapi.service.ISaaSInternalService;
import jc1.k;

/* JADX INFO: loaded from: classes12.dex */
public class LiveSaaSInternalService {
    private static volatile ITTLiveSDKProxy sLiveSDKProxy;

    public LiveSaaSInternalService() {
    }

    public static ISaaSInternalService getSaaSInternalService() {
        if (sLiveSDKProxy != null) goto L6;
        return null;
    L6:
        ISaaSInternalService r100 = (ISaaSInternalService) sLiveSDKProxy.getService(ISaaSInternalService.class);
        if (r100 == null) goto L10;
        return r100;
    L10:
        return (ISaaSInternalService) k.f(ISaaSInternalService.class);
    }

    public static void setSDKContext(ITTLiveSDKProxy r100) {
        sLiveSDKProxy = r100;
    }
}
