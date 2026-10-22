package com.bytedance.android.shopping.anchorv3.repository;

import com.bytedance.android.shopping.anchorv3.repository.api.AnchorV3PromotionRequestParam;
import com.bytedance.android.shopping.anchorv3.repository.dto.PromotionPackResponse;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class b<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AnchorV3PromotionRequestParam f165271a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f165272b;

    public b(AnchorV3PromotionRequestParam r100, String r101) {
        this.f165271a = r100;
        this.f165272b = r101;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        PromotionPackResponse r101 = (PromotionPackResponse) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        AnchorV3Repository.a(AnchorV3Repository.f165261h, this.f165271a, this.f165272b, r101);
        com.bytedance.android.shopping.monitor.a.b(r101);
        return r101;
    }
}
