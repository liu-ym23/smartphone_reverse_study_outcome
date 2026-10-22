package com.bytedanceos.common.ad.net;

import retrofit2.http.GET;
import retrofit2.http.Url;
import rx.Observable;

/* JADX INFO: loaded from: classes2.dex */
public interface AdDyncService {
    @GET
    Observable reportAd(@Url String r10);
}
