package com.bytedanceos.common.ad.net;

import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

/* JADX INFO: loaded from: classes2.dex */
public interface SnsSdkService {
    @POST("api/ad/union/event_report/")
    Observable reportEvent(@Body RequestBody r10);
}
