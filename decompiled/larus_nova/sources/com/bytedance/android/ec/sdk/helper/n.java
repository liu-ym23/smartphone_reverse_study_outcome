package com.bytedance.android.ec.sdk.helper;

import android.content.Context;
import com.bytedance.retrofit2.Converter;
import com.google.gson.Gson;
import java.util.Map;

/* JADX INFO: loaded from: classes44.dex */
public final class n implements bj.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f48128a = null;

    public n() {
    }

    static {
        f48128a = new n();
    }

    @Override // bj.a
    public final String getNetworkAccessType(Context r100) {
        return d.f48119b.getIECHostNetService().getNetworkAccessType(r100);
    }

    @Override // bj.a
    public final <T> T create(String r100, Class<T> r101) {
        return (T) d.f48119b.getIECHostNetService().create(r100, r101);
    }

    @Override // bj.a
    public final Object a(String r100, Class r101, Converter.Factory r102, Gson r103) {
        return d.f48119b.getIECHostNetService().a(r100, r101, null, r103);
    }

    @Override // bj.a
    public final <T> T create(String r100, Class<T> r101, Converter.Factory r102, Map<String, Object> r103) {
        return (T) d.f48119b.getIECHostNetService().create(r100, r101, r102, r103);
    }
}
