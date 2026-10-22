package com.bytedance.android.shopping.anchorv3.detail.widget;

import android.content.Context;
import android.view.View;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductBannerStruct;
import jd3.l0;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AnchorV3CommonBannerView f164907a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f164908b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ PromotionProductBannerStruct f164909c;

    public c(AnchorV3CommonBannerView r100, Function1 r101, PromotionProductBannerStruct r102) {
        this.f164907a = r100;
        this.f164908b = r101;
        this.f164909c = r102;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Function1 r101 = this.f164908b;
        if (r101 == null) goto L5;
        Unit r102 = (Unit) r101.invoke(this.f164907a.f164833c);
    L5:
        PromotionProductBannerStruct r103 = this.f164909c;
        if (r103 == null) goto L8;
        Integer r104 = r103.getBannerType();
    L9:
        if (r104 != null) goto L12;
        return;
    L12:
        if (r104.intValue() != 14) goto L15;
        int r105 = com.bytedance.android.ec.core.anchorv3.a.f43797a;
        Context r106 = this.f164907a.getContext();
        Intrinsics.checkNotNullParameter("security_source", "infoName");
        l0 r107 = new l0();
        Intrinsics.checkNotNullParameter("security_source", "<set-?>");
        r107.f498381a = "security_source";
        com.bytedance.android.ec.core.anchorv3.b.a(r107, r106, null);
        return;
    L15:
        return;
    L8:
        r104 = null;
        goto L9
    }
}
