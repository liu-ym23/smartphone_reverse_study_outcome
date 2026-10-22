package com.bytedanceos.common.networkv2.service;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/* JADX INFO: loaded from: classes2.dex */
public interface AppStoreOAuthService {
    @GET("users/info")
    Observable getUserInfoByToken(@Query("access_token") String r10);
}
