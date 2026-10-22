package com.bytedance.android.shopping.sku.common.controller;

import android.util.LruCache;
import com.bytedance.android.shopping.sku.common.monitor.error.SkuRunCatchExtKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class SkuCommonBigPicCacheController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f182622a = null;

    public static final class a extends LruCache<String, b> {
        public a() {
            super(10);
        }
    }

    static {
        f182622a = new a();
    }

    public static b a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "productId");
        return f182622a.get(r100);
    }

    public static void b(final String r100, final boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "productId");
        SkuRunCatchExtKt.a(null, "SkuCommonBigPicCacheController", new SkuCommonBigPicCacheController$putCurrentBigPicMode$1(r100, r101));
    }
}
