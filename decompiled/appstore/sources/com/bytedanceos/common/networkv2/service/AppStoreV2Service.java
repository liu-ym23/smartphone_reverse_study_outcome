package com.bytedanceos.common.networkv2.service;

import com.google.gson.JsonObject;
import java.util.Map;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import rx.Observable;

/* JADX INFO: loaded from: classes2.dex */
public interface AppStoreV2Service {
    @GET("w/")
    Observable getUserInfoByTicket(@QueryMap Map<String, String> r10);

    @POST("tickets/")
    Observable login(@QueryMap Map<String, String> r10, @Body JsonObject r11);

    @POST("users/")
    Observable register(@QueryMap Map<String, String> r10, @Body JsonObject r11);

    @POST("cellphone/")
    Observable sendRegisterVerifyCode(@QueryMap Map<String, String> r10, @Body JsonObject r11);
}
