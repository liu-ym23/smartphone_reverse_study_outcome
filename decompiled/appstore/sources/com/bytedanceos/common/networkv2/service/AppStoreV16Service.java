package com.bytedanceos.common.networkv2.service;

import java.util.Map;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;
import rx.Observable;

/* JADX INFO: loaded from: classes2.dex */
public interface AppStoreV16Service {
    @GET("AppManager/{pathName}")
    Observable getAppManagerRecommendApps(@Path("pathName") String r10, @QueryMap Map<String, String> r11);

    @POST("app/GetCountForMyapp")
    Observable getCountData(@QueryMap Map<String, String> r10);

    @POST("firstRecommend/list")
    Observable getFirstRecommendList(@QueryMap Map<String, String> r10);

    @GET("GameSubcribe/List")
    Observable getGameSubcribeList(@QueryMap Map<String, String> r10);

    @GET("AppManager/gamebooking")
    Observable getManagerSubList(@QueryMap Map<String, String> r10);
}
