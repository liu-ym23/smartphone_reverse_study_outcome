package com.bytedance.android.shopping.feed.repository;

import com.bytedance.android.shopping.anchorv3.repository.api.AnchorV3PromotionRequestParam;
import com.bytedance.android.shopping.anchorv3.repository.dto.PromotionPackResponse;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AnchorV3PromotionRequestParam f175157a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f175158b;

    public a(AnchorV3PromotionRequestParam r100, String r101) {
        this.f175157a = r100;
        this.f175158b = r101;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        PromotionPackResponse r101 = (PromotionPackResponse) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        AnchorV3Repository.a(AnchorV3Repository.f175156g, this.f175157a, this.f175158b, r101);
        c.a(r101);
        return r101;
    }
}
