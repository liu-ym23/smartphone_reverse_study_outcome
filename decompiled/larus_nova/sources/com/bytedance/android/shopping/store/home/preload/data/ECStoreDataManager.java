package com.bytedance.android.shopping.store.home.preload.data;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;

/* JADX INFO: loaded from: classes14.dex */
public final class ECStoreDataManager {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f183804c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f183805a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f183806b;

    public static final class a {
        public static ECStoreDataManager a() {
            return (ECStoreDataManager) ECStoreDataManager.f183804c.getValue();
        }
    }

    public final ECStoreTabKitAPIDataCacheManager a() {
        return (ECStoreTabKitAPIDataCacheManager) this.f183805a.getValue();
    }

    public final ECStoreDataFutureManager b() {
        return (ECStoreDataFutureManager) this.f183806b.getValue();
    }

    static {
        f183804c = LazyKt.lazy(LazyThreadSafetyMode.NONE, ECStoreDataManager$Companion$instance$2.INSTANCE);
    }

    public ECStoreDataManager() {
        this.f183805a = LazyKt.lazy(ECStoreDataManager$cacheManager$2.INSTANCE);
        this.f183806b = LazyKt.lazy(ECStoreDataManager$futureManager$2.INSTANCE);
    }
}
