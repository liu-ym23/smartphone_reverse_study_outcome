package com.bytedance.android.ecom.live.adapter.impl;

import android.content.Context;
import com.bytedance.android.ec.adapter.api.net.IECNetMonitorService;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.retrofit2.Converter;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.bytedance.retrofit2.rxjava2.adapter.RxJava2CallAdapterFactory;
import com.bytedance.ttnet.utils.RetrofitUtils;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes44.dex */
public final class l implements bj.a {
    public l() {
    }

    @Override // bj.a
    public final String getNetworkAccessType(Context r100) {
        return NetworkUtils.getNetworkAccessType(r100);
    }

    @Override // bj.a
    public final <T> T create(String r100, Class<T> r101) {
        return (T) a(r100, r101, null, null);
    }

    @Override // bj.a
    public final Object a(String r100, Class r101, Converter.Factory r102, Gson r103) {
        j r104 = new j(r100);
        ArrayList r105 = new ArrayList();
        r105.addAll(CollectionsKt.listOf(new Interceptor[]{new k(this), r104}));
        boolean r106 = ECServiceManager.f42805a;
        IECNetMonitorService r107 = (IECNetMonitorService) ECServiceManager.c(IECNetMonitorService.class);
        if (r107 == null) goto L13;
        List<Object> r108 = r107.interceptors();
        if (r108 == null) goto L13;
        ArrayList r109 = new ArrayList();
        Iterator<T> r110 = r108.iterator();
    L8:
        if (r110.hasNext() == false) goto L12;
        Object r111 = r110.next();
        if ((r111 instanceof Interceptor) == false) goto L8;
        r109.add(r111);
        goto L8
    L12:
        r105.addAll(r109);
    L13:
        Unit r112 = Unit.INSTANCE;
        return RetrofitUtils.createService(RetrofitUtils.createSsRetrofit(r100, r105, r102, RxJava2CallAdapterFactory.create()), r101);
    }

    @Override // bj.a
    public final <T> T create(String r100, Class<T> r101, Converter.Factory r102, Map<String, ? extends Object> r103) {
        return (T) a(r100, r101, r102, null);
    }
}
