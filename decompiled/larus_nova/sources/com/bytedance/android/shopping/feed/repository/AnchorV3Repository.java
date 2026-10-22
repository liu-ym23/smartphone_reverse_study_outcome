package com.bytedance.android.shopping.feed.repository;

import com.bytedance.android.ec.model.response.anchorv3.PromotionProductBaseStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.shopping.anchorv3.repository.api.AnchorV3PromotionRequestParam;
import com.bytedance.android.shopping.anchorv3.repository.dto.PromotionPackResponse;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.jedi.model.combine.Combine;
import com.bytedance.jedi.model.combine.Combine$applyStrategy$1;
import com.bytedance.jedi.model.combine.CombineExtensionsKt;
import com.bytedance.jedi.model.combine.Strategies;
import com.bytedance.jedi.model.repository.Repository;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class AnchorV3Repository extends Repository {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f175151b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f175152c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f175153d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f175154e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Lazy f175155f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final AnchorV3Repository f175156g = null;

    static {
        f175156g = new AnchorV3Repository();
        f175151b = new d();
        f175152c = LazyKt.lazy(AnchorV3Repository$promotionFetcher$2.INSTANCE);
        f175153d = LazyKt.lazy(AnchorV3Repository$autoApplyCouponFetcher$2.INSTANCE);
        f175154e = LazyKt.lazy(AnchorV3Repository$reportCpsTrackFetcher$2.INSTANCE);
        f175155f = LazyKt.lazy(AnchorV3Repository$searchSuggestWordFetcher$2.INSTANCE);
    }

    public AnchorV3Repository() {
    }

    public static Observable b(AnchorV3Repository r100, AnchorV3PromotionRequestParam r101, String r102) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "requestParam");
        d r103 = f175151b;
        if (r103.i(r101) == null) goto L5;
        com.bytedance.android.shopping.monitor.d r104 = com.bytedance.android.shopping.monitor.d.f178665h;
        return ((ud3.a) f175152c.getValue()).a(r101).subscribeOn(Schedulers.io()).map(new a(r101, r102));
    L5:
        com.bytedance.android.shopping.monitor.d r105 = com.bytedance.android.shopping.monitor.d.f178665h;
        Combine r106 = CombineExtensionsKt.a((ud3.a) f175152c.getValue(), r103);
        Strategies.f251059a.getClass();
        Function2 r107 = Strategies.a();
        Intrinsics.checkNotNullParameter(r107, BdpAppEventConstant.PARAMS_STRATEGY_NAME);
        return new Combine$applyStrategy$1(r107, r106).a(r101).subscribeOn(Schedulers.io()).map(new b(r101, r102));
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
        f175151b.c(r101, r103);
        return;
    L17:
        return;
    L11:
        r107 = null;
        goto L13
    }
}
