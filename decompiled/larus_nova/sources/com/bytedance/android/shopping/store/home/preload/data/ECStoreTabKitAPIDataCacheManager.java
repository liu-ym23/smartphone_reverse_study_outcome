package com.bytedance.android.shopping.store.home.preload.data;

import android.util.LruCache;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.store.home.entity.ECShopHeadInfoBlock;
import com.bytedance.android.shopping.store.home.entity.ECStoreHomeTabResponseTabkit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Triple;

/* JADX INFO: loaded from: classes14.dex */
public final class ECStoreTabKitAPIDataCacheManager {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f183807d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ti3.c f183808a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LruCache<String, Triple<ECShopHeadInfoBlock, Long, fl.b>> f183809b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LruCache<String, Triple<ECStoreHomeTabResponseTabkit[], Long, fl.b>> f183810c;

    public static final class a {
    }

    static {
        f183807d = LazyKt.lazy(LazyThreadSafetyMode.NONE, ECStoreTabKitAPIDataCacheManager$Companion$instance$2.INSTANCE);
    }

    public ECStoreTabKitAPIDataCacheManager() {
        this.f183808a = new ti3.c();
        this.f183809b = new LruCache(10);
        this.f183810c = new LruCache(10);
    }

    public static boolean a(long r100, fl.b r101) {
        if ((r100 + ((long) (k.g(r101.f477676a, 0) * 1000))) >= System.currentTimeMillis()) goto L6;
        return true;
    L6:
        return false;
    }
}
