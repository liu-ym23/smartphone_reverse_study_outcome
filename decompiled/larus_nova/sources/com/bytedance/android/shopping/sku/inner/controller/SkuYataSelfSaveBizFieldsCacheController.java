package com.bytedance.android.shopping.sku.inner.controller;

import android.util.LruCache;
import com.bytedance.android.shopping.sku.common.monitor.error.SkuRunCatchExtKt;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class SkuYataSelfSaveBizFieldsCacheController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f182886a = null;

    public static final class a extends LruCache<String, HashMap<String, Object>> {
        public a() {
            super(10);
        }
    }

    static {
        f182886a = new a();
    }

    public static Map a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "promotionId");
        return f182886a.get(r100);
    }

    public static void b(final String r100, final Map r101) {
        Intrinsics.checkNotNullParameter(r100, "promotionId");
        Intrinsics.checkNotNullParameter(r101, "map");
        SkuRunCatchExtKt.a(null, "SkuYataTradeModeCacheController", new SkuYataSelfSaveBizFieldsCacheController$putCurrentSaveData$1(r100, r101));
    }
}
