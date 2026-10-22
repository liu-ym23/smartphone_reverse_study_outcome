package com.bytedance.android.shopping.buynow.cache;

import com.bytedance.android.ec.core.utils.b2;
import com.bytedance.retrofit2.SsResponse;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes13.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ nl.b f170726a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f170727b;

    public b(nl.b r100, boolean r101) {
        this.f170726a = r100;
        this.f170727b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        final SsResponse r101 = (SsResponse) r100;
        b2.b(new WithCacheKt$putCache$1$1(this, r101));
    }
}
