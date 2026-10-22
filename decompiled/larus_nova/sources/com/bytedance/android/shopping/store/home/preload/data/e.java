package com.bytedance.android.shopping.store.home.preload.data;

import com.bytedance.android.shopping.store.home.entity.ECStoreHomeTabResponseTabkit;
import io.reactivex.functions.Consumer;
import kotlin.Triple;

/* JADX INFO: loaded from: classes14.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECStoreTabKitAPIDataCacheManager f183820a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f183821b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ fl.b f183822c;

    public e(ECStoreTabKitAPIDataCacheManager r100, String r101, fl.b r102) {
        this.f183820a = r100;
        this.f183821b = r101;
        this.f183822c = r102;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ECStoreHomeTabResponseTabkit r101 = (ECStoreHomeTabResponseTabkit) r100;
        if (r101.getStatusCode() != 0) goto L6;
        this.f183820a.f183810c.put(this.f183821b, new Triple(new ECStoreHomeTabResponseTabkit[]{r101}, Long.valueOf(System.currentTimeMillis()), this.f183822c));
        return;
    }
}
