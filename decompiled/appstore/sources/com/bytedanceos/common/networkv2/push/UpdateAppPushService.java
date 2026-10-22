package com.bytedanceos.common.networkv2.push;

import retrofit2.http.GET;
import retrofit2.http.Url;
import rx.Observable;

/* JADX INFO: loaded from: classes2.dex */
public interface UpdateAppPushService {
    @GET
    Observable getUpdateAppPush(@Url String r10);
}
