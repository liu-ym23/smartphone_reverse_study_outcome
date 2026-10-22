package com.bytedance.android.ecom.live.adapter.impl;

import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.intercept.Interceptor;
import java.net.URL;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes44.dex */
public final class k implements Interceptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f51180a;

    public k(l r100) {
        this.f51180a = r100;
    }

    @Override // com.bytedance.retrofit2.intercept.Interceptor
    public final SsResponse<Object> intercept(Interceptor.Chain r100) {
        HttpUrl r101 = HttpUrl.parse(r100.request().getUrl());
        this.f51180a.getClass();
        String r102 = null;
        if (ECAppInfoService.f48114e.n() == false) goto L13;
        if (r101 == null) goto L6;
        String r103 = r101.host();
    L8:
        if (Intrinsics.areEqual(r103, "sdk.jinritemai.com") == false) goto L13;
        HttpUrl.a r104 = r101.newBuilder();
        r104.c("saas.ecombdapi.com");
        HttpUrl r105 = r104.b();
        Request.Builder r106 = r100.request().newBuilder();
        URL r107 = r105.url();
        if (r107 == null) goto L25;
        r102 = r107.toString();
    L25:
        return r100.proceed(r106.url(r102).build());
    L6:
        r103 = null;
    L13:
        if (r101 == null) goto L15;
        String r108 = r101.host();
    L17:
        if (Intrinsics.areEqual(r108, "sdk.jinritemai.com") == false) goto L24;
        HttpUrl.a r109 = r101.newBuilder();
        r109.c("isaas.ecombdapi.com");
        HttpUrl r110 = r109.b();
        Request.Builder r111 = r100.request().newBuilder();
        URL r112 = r110.url();
        if (r112 == null) goto L22;
        r102 = r112.toString();
    L22:
        return r100.proceed(r111.url(r102).build());
    L24:
        return r100.proceed(r100.request());
    L15:
        r108 = null;
        goto L17
    }
}
