package com.bytedance.android.livesdkapi;

import com.bytedance.android.livesdkapi.service.ILiveService;

/* JADX INFO: loaded from: classes12.dex */
public interface ITTLiveSDKProxy extends ITTLiveSDKProxyMiddleWare {
    ILiveService getLiveService();

    <T> T getService(Class<T> r100);
}
