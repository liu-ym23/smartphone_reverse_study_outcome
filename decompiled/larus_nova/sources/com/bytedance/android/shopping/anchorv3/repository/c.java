package com.bytedance.android.shopping.anchorv3.repository;

import com.amap.api.col.s.ce;
import com.bytedance.android.shopping.anchorv3.repository.api.AnchorV3PromotionRequestParam;
import com.bytedance.android.shopping.anchorv3.repository.dto.PromotionPackResponse;
import com.bytedance.jedi.model.ext.cache.guava.LruCache;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class c extends LruCache<AnchorV3PromotionRequestParam, PromotionPackResponse> {
    public c() {
    }

    @Override // com.bytedance.jedi.model.cache.AbstractCache
    public final /* bridge */ /* synthetic */ Object b(Object r100) {
        return i((AnchorV3PromotionRequestParam) r100);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final PromotionPackResponse i(AnchorV3PromotionRequestParam r100) {
        Intrinsics.checkNotNullParameter(r100, ce.f26396k);
        return (PromotionPackResponse) this.f251069b.f251068a.getIfPresent((K) r100);
    }
}
