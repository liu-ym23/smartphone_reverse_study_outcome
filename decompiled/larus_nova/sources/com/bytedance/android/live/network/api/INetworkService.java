package com.bytedance.android.live.network.api;

import am3.c;
import android.view.View;
import com.bytedance.android.livehostapi.foundation.IHostNetwork;
import java.util.Map;
import py.k;

/* JADX INFO: loaded from: classes46.dex */
public interface INetworkService extends IHostNetwork, IMiddlewareNetworkService {
    void ensureFeedProtoInjected(Runnable r100);

    @Override // com.bytedance.android.live.network.api.IMiddlewareNetworkService
    void injectProtoDecoders(Map<Class, c> r100);

    @Override // com.bytedance.android.live.network.api.IMiddlewareNetworkService
    void loadNinePatchDrawable(k r100, View r101, boolean r102, Runnable r103);

    void putCommonParams(Map<String, String> r100);

    void setEnsureProtoDecodersInjected(Runnable r100);
}
