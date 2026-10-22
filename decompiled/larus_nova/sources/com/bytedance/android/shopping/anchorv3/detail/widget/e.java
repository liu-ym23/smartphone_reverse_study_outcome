package com.bytedance.android.shopping.anchorv3.detail.widget;

import android.app.Activity;
import android.view.View;
import com.bytedance.android.ec.core.hybrid.utils.r;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductBannerStruct;
import com.bytedance.android.shopping.anchorv3.utils.d0;

/* JADX INFO: loaded from: classes12.dex */
public final class e implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f164912a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AnchorV3ProductBottomBannerLayout f164913b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ PromotionProductBannerStruct f164914c;

    public e(String r100, AnchorV3ProductBottomBannerLayout r101, PromotionProductBannerStruct r102) {
        this.f164912a = r100;
        this.f164913b = r101;
        this.f164914c = r102;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Activity r101 = d0.f165305a.getActivity(this.f164913b.getContext());
        if (r101 == null) goto L5;
        r.a(this.f164912a, r101);
    L5:
        Integer r102 = this.f164914c.getBannerType();
        if (r102 != null) goto L9;
        return;
    L9:
        if (r102.intValue() != 19) goto L12;
        int r103 = com.bytedance.android.ec.core.anchorv3.a.f43797a;
        int r104 = a63.a.f1951a;
        int r105 = com.bytedance.android.ec.core.opt.ab.c.f45223a;
        jd3.d r106 = new jd3.d();
        r106.f498271a = com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_DETAIL;
        r106.f498272b = "百亿补贴";
        r106.f498273c = com.bytedance.android.ec.core.event.a.VALUE_EXPLOSIVE_SUBSIDY;
        r106.post(null, null);
        return;
    }
}
