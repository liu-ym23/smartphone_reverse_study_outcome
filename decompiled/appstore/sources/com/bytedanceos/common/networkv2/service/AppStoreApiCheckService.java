package com.bytedanceos.common.networkv2.service;

import retrofit2.Call;
import retrofit2.http.GET;

/* JADX INFO: loaded from: classes2.dex */
public interface AppStoreApiCheckService {
    @GET("pong")
    Call<Void> checkApiConnected();
}
