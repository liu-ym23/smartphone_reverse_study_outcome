package com.bytedance.android.shopping.store.home.preload.data;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes14.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECStoreTabKitAPIDataCacheManager f183817a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f183818b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ fl.b f183819c;

    public d(ECStoreTabKitAPIDataCacheManager r100, String r101, fl.b r102) {
        this.f183817a = r100;
        this.f183818b = r101;
        this.f183819c = r102;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ((com.bytedance.android.chunkstreamprediction.network.b) r100).a(new c(this));
    }
}
