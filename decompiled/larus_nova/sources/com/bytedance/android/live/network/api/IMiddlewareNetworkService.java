package com.bytedance.android.live.network.api;

import am3.c;
import android.view.View;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.livehostapi.foundation.IMiddlewareHostNetwork;
import com.google.gson.Gson;
import java.util.Map;
import py.k;

/* JADX INFO: loaded from: classes46.dex */
public interface IMiddlewareNetworkService extends IService, IMiddlewareHostNetwork {
    @Override // com.bytedance.android.livehostapi.foundation.IMiddlewareHostNetwork
    Map<String, String> getCommonParams();

    <T> c<T> getProtoDecoder(Class<T> r100);

    void injectProtoDecoders(Map<Class, c> r100);

    void interceptResponseBody(String r100, Object r101, String r102, String r103, String r104) throws Exception;

    void loadNinePatchDrawable(k r100, View r101, boolean r102, Runnable r103);

    Gson provideNetworkGson();

    Gson provideUploadLinkGson();
}
