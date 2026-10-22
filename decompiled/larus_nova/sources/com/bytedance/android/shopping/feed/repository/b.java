package com.bytedance.android.shopping.feed.repository;

import com.bytedance.android.shopping.anchorv3.repository.api.AnchorV3PromotionRequestParam;
import com.bytedance.android.shopping.anchorv3.repository.dto.PromotionPackResponse;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class b<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AnchorV3PromotionRequestParam f175176a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f175177b;

    public b(AnchorV3PromotionRequestParam r100, String r101) {
        this.f175176a = r100;
        this.f175177b = r101;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        PromotionPackResponse r101 = (PromotionPackResponse) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        AnchorV3Repository.a(AnchorV3Repository.f175156g, this.f175176a, this.f175177b, r101);
        c.a(r101);
        return r101;
    }
}
