package com.bytedance.android.shopping.store.home.preload.data;

import com.bytedance.android.shopping.store.home.entity.ECShopHeadInfoBlock;
import io.reactivex.functions.Consumer;
import kotlin.Triple;

/* JADX INFO: loaded from: classes14.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECStoreTabKitAPIDataCacheManager f183812a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f183813b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ fl.b f183814c;

    public b(ECStoreTabKitAPIDataCacheManager r100, String r101, fl.b r102) {
        this.f183812a = r100;
        this.f183813b = r101;
        this.f183814c = r102;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ECShopHeadInfoBlock r101 = (ECShopHeadInfoBlock) r100;
        if (r101.getStatusCode() != 0) goto L6;
        this.f183812a.f183809b.put(this.f183813b, new Triple(r101, Long.valueOf(System.currentTimeMillis()), this.f183814c));
        return;
    }
}
