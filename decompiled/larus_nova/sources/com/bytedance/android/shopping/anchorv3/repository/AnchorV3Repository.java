package com.bytedance.android.shopping.anchorv3.repository;

import com.bytedance.android.ec.model.response.anchorv3.PromotionProductBaseStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.shopping.anchorv3.repository.api.AnchorV3PromotionRequestParam;
import com.bytedance.android.shopping.anchorv3.repository.dto.PromotionPackResponse;
import com.bytedance.jedi.model.repository.Repository;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class AnchorV3Repository extends Repository {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f165255b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f165256c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f165257d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f165258e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Lazy f165259f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Lazy f165260g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final AnchorV3Repository f165261h = null;

    static {
        f165261h = new AnchorV3Repository();
        f165255b = new c();
        f165256c = LazyKt.lazy(AnchorV3Repository$promotionFetcher$2.INSTANCE);
        f165257d = LazyKt.lazy(AnchorV3Repository$autoApplyCouponFetcher$2.INSTANCE);
        f165258e = LazyKt.lazy(AnchorV3Repository$productDetailFetcher$2.INSTANCE);
        f165259f = LazyKt.lazy(AnchorV3Repository$reportCpsTrackFetcher$2.INSTANCE);
        f165260g = LazyKt.lazy(AnchorV3Repository$searchSuggestWordFetcher$2.INSTANCE);
    }

    public AnchorV3Repository() {
    }

    public static final void a(AnchorV3Repository r100, AnchorV3PromotionRequestParam r101, String r102, PromotionPackResponse r103) {
        r100.getClass();
        if (r103.isValid() == false) goto L16;
        List<PromotionProductStruct> r104 = r103.getPromotions();
        if (r104 == null) goto L11;
        PromotionProductStruct r105 = (PromotionProductStruct) CollectionsKt.firstOrNull(r104);
        if (r105 == null) goto L11;
        PromotionProductBaseStruct r106 = r105.getBaseInfo();
        if (r106 == null) goto L11;
        String r107 = r106.getPromotionId();
    L13:
        if (Intrinsics.areEqual(r102, r107) == false) goto L17;
        f165255b.c(r101, r103);
        return;
    L17:
        return;
    L11:
        r107 = null;
        goto L13
    }
}
