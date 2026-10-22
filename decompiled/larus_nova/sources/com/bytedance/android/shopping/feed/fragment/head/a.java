package com.bytedance.android.shopping.feed.fragment.head;

import android.content.Context;
import com.bytedance.android.ec.model.response.anchorv3.CouponUrgeInfo;
import com.bytedance.android.shopping.anchorv3.AnchorV3Param;
import com.bytedance.android.shopping.feed.view.CouponView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a implements CouponView.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CouponUrgeInfo f175064a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CouponView f175065b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Context f175066c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ AnchorV3Param f175067d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ CouponView f175068e;

    @Override // com.bytedance.android.shopping.feed.view.CouponView.b
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "couponInfo");
        Intrinsics.checkNotNullParameter(r100, "couponInfo");
    }

    @Override // com.bytedance.android.shopping.feed.view.CouponView.b
    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "couponInfo");
        int r101 = nd3.b.f518778a;
        Context r102 = this.f175066c;
        String r103 = String.valueOf(this.f175064a.getCouponId());
        String r104 = String.valueOf(this.f175064a.getCouponType());
        String r105 = this.f175067d.getVideoId();
        String r106 = this.f175067d.getProductId();
        nd3.c r107 = new nd3.c();
        r107.f518770a = com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_FLOW_PAGE;
        r107.f518771b = r103;
        r107.f518772c = r104;
        r107.f518773d = r100;
        r107.f518774e = null;
        r107.f518775f = null;
        r107.f518776g = r105;
        r107.f518777h = r106;
        com.bytedance.android.shopping.feed.event.g.c(r107, r102, null);
        this.f175065b.setVisibility(8);
        CouponView r108 = this.f175068e;
        if (r108 == null) goto L6;
        r108.setVisibility(8);
        return;
    }

    public a(CouponUrgeInfo r100, CouponView r101, Context r102, AnchorV3Param r103, CouponView r104) {
        this.f175064a = r100;
        this.f175065b = r101;
        this.f175066c = r102;
        this.f175067d = r103;
        this.f175068e = r104;
    }
}
