package com.bytedance.android.shopping.anchorv3.auction;

import androidx.core.view.ViewCompat;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.ec.core.utils.y;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class AuctionOfferRecordItemPresenter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AuctionOfferRecordItemView f164437a;

    public AuctionOfferRecordItemPresenter(AuctionOfferRecordItemView r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        this.f164437a = r100;
    }

    public final void update(final j53.a r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        if (r101 != 0) goto L5;
        ViewCompat.setBackground(this.f164437a.getStateView(), com.bytedance.commerce.base.drawable.a.a(new AuctionOfferRecordItemPresenter$enableHighlightState$1(this)));
        this.f164437a.getStateView().setTextColor(th.a.f(this.f164437a.getContext()).getColor(R.color.commerce_color_FE2C55));
    L6:
        y.d(this.f164437a.getAvatarView(), r100.f497451b);
        this.f164437a.getUserNameView().setText(r100.f497450a);
        this.f164437a.getTimeView().setText(r100.f497453d);
        this.f164437a.getPriceView().C(new AnonymousClass1(r100));
        this.f164437a.getStateView().setText(r100.f497454e);
        return;
    L5:
        ViewCompat.setBackground(this.f164437a.getStateView(), com.bytedance.commerce.base.drawable.a.a(new AuctionOfferRecordItemPresenter$disableHighlightState$1(this)));
        this.f164437a.getStateView().setTextColor(th.a.f(this.f164437a.getContext()).getColor(R.color.shopping_std_text_black_4));
        goto L6
    }
}
