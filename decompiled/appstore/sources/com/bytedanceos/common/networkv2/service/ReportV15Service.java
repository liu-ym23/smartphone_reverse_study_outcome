package com.bytedanceos.common.networkv2.service;

import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

/* JADX INFO: loaded from: classes2.dex */
public interface ReportV15Service {
    @POST("Report/ReportLog")
    Observable reportLog(@Body RequestBody r10);
}
