package com.bytedance.android.livesdk.livecommerce.promotionlist.viewholder;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.livesdk.livecommerce.iron.ui.ECPromotionListHintBannerView;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f151277a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ECPromotionListHintBannerView f151278b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f151279c;

    public d(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        this.f151277a = th.a.c(r100.getContext(), R.layout.shopping_layout_iron_promotion_list_hint_banner_item_view, r100, false);
    }
}
