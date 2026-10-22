package com.bytedance.android.livesdk.vscore_impl.paidlive.util.preload;

import com.bytedance.android.live.network.impl.utils.RetrofitProvider;
import com.bytedance.retrofit2.Retrofit;

/* JADX INFO: loaded from: classes11.dex */
public final class a extends RetrofitProvider {

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.vscore_impl.paidlive.util.preload.a$a, reason: collision with other inner class name */
    public static final class C2460a {
    }

    static {
    }

    @Override // com.bytedance.android.live.network.impl.utils.RetrofitProvider, com.bytedance.android.live.a
    public final Retrofit getRetrofitInstance() {
        return getRetrofitInstance("https://aweme.snssdk.com/", false);
    }

    public a() {
    }
}
