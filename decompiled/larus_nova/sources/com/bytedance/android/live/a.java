package com.bytedance.android.live;

import com.bytedance.android.livesdkapi.network.ILiveRetrofitWrapper;
import com.bytedance.retrofit2.Retrofit;

/* JADX INFO: loaded from: classes45.dex */
public interface a {
    Retrofit getRetrofitInstance();

    ILiveRetrofitWrapper getRetrofitInstanceV2();
}
