package com.bytedance.android.shopping.store.home.preload.data;

import com.bytedance.android.shopping.store.home.api.ECStoreParam;
import com.bytedance.android.shopping.store.home.entity.ECShopHeadInfoBlock;
import com.bytedance.android.shopping.store.home.entity.ECStoreHomeTabResponseTabkit;
import com.bytedance.android.shopping.store.hybrid.entity.ECStorePreloadInfoResponse;
import io.reactivex.internal.observers.h;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class ECStoreDataFutureManager {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Lazy f183797g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ti3.c f183798a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ECStoreParam f183799b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public h<ECShopHeadInfoBlock> f183800c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public h<ECStorePreloadInfoResponse> f183801d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public h<ECStoreHomeTabResponseTabkit> f183802e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public h<com.bytedance.android.chunkstreamprediction.network.b<ECStoreHomeTabResponseTabkit>> f183803f;

    public static final class a {
        public static ECStoreDataFutureManager a() {
            return (ECStoreDataFutureManager) ECStoreDataFutureManager.f183797g.getValue();
        }
    }

    static {
        f183797g = LazyKt.lazy(LazyThreadSafetyMode.NONE, ECStoreDataFutureManager$Companion$instance$2.INSTANCE);
    }

    public ECStoreDataFutureManager() {
        this.f183798a = new ti3.c();
    }

    public final boolean a(ECStoreParam r100) {
        Intrinsics.checkNotNullParameter(r100, "storeParam");
        String r101 = r100.getSecShopId();
        ECStoreParam r102 = this.f183799b;
        if (r102 == null) goto L5;
        String r103 = r102.getSecShopId();
    L7:
        if (Intrinsics.areEqual(r101, r103) == false) goto L14;
        h<ECShopHeadInfoBlock> r104 = this.f183800c;
        if (r104 == null) goto L14;
        if (r104 == null) goto L14;
        if (r104.isCancelled() == true) goto L14;
        return true;
    L14:
        return false;
    L5:
        r103 = null;
        goto L7
    }
}
