package com.bytedance.android.live.openplatform.impl.base.utils;

import com.bytedance.android.live.network.impl.utils.RetrofitProvider;
import com.bytedance.retrofit2.Retrofit;

/* JADX INFO: loaded from: classes46.dex */
public final class d extends RetrofitProvider {

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.network.impl.utils.RetrofitProvider, com.bytedance.android.live.a
    public final Retrofit getRetrofitInstance() {
        return getRetrofitInstance("https://game-distribution.zijieapi.com");
    }

    public d() {
    }
}
