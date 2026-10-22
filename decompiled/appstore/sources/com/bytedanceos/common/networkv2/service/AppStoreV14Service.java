package com.bytedanceos.common.networkv2.service;

import java.util.Map;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;
import rx.Observable;

/* JADX INFO: loaded from: classes2.dex */
public interface AppStoreV14Service {
    @GET("category/apps/{categoryId}")
    Observable getCategoryApps(@Path("categoryId") String r10, @QueryMap Map<String, String> r11);

    @POST("stat/download/apps")
    Observable statDownloadApps(@HeaderMap Map<String, String> r10, @Body RequestBody r11);
}
