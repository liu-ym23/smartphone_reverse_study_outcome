package com.bytedance.android.livesdkapi;

import com.bytedance.android.livesdkapi.service.IMiddlewareLiveService;

/* JADX INFO: loaded from: classes12.dex */
public class TTLiveServiceMiddleware {
    private static volatile ITTLiveSDKProxyMiddleWare sLiveSDKProxy;

    public TTLiveServiceMiddleware() {
    }

    public static IMiddlewareLiveService getLiveService() {
        if (sLiveSDKProxy != null) goto L7;
        return null;
    L7:
        return sLiveSDKProxy.getMiddlewareLiveService();
    }

    public static void setSDKContext(ITTLiveSDKProxyMiddleWare r100) {
        sLiveSDKProxy = r100;
    }
}
