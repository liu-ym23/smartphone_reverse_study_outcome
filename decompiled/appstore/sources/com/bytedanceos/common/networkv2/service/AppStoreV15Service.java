package com.bytedanceos.common.networkv2.service;

import java.util.Map;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import rx.Observable;

/* JADX INFO: loaded from: classes2.dex */
public interface AppStoreV15Service {
    @GET("GameSubcribe/subcribe")
    Observable doSubcribe(@QueryMap Map<String, String> r10);

    @GET("app/info")
    Observable getAppInfo(@QueryMap Map<String, String> r10);

    @GET("category/apps")
    Observable getCategoryApps(@QueryMap Map<String, String> r10);

    @GET("GameSubcribe/Info")
    Observable getGameSubcribeInfo(@QueryMap Map<String, String> r10);

    @GET("GameSubcribe/MySub")
    Observable getMySubList(@QueryMap Map<String, String> r10);

    @GET("GameSubcribe/ReportUserInfo")
    Observable reportUserInfo(@QueryMap Map<String, String> r10);
}
