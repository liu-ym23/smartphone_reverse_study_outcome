package com.bytedance.android.livesdk.livecommerce.promotion.card.presenter;

import com.bytedance.android.livesdk.livecommerce.promotion.card.UpdateType;
import com.bytedance.android.livesdk.livecommerce.promotion.card.model.LivePromotionCardArgs;
import com.bytedance.android.livesdk.livecommerce.promotion.card.module.ListItemGuideModule;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QPresenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class h extends QPresenter {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f150199e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.bytedance.android.livesdk.livecommerce.promotion.card.i f150200f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LivePromotionCardArgs f150201g;

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QPresenter
    public final void C() {
    }

    public h(LivePromotionCardArgs r100) {
        Intrinsics.checkNotNullParameter(r100, "argument");
        this.f150201g = r100;
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QPresenter
    public final void A(QModel r100) {
        if ((r100 instanceof com.bytedance.android.livesdk.livecommerce.promotion.card.i) == true) goto L5;
        r100 = null;
    L5:
        com.bytedance.android.livesdk.livecommerce.promotion.card.i r101 = (com.bytedance.android.livesdk.livecommerce.promotion.card.i) r100;
        if (r101 != null) goto L8;
        return;
    L8:
        if (this.f150199e == true) goto L11;
        this.f150199e = true;
        ((ListItemGuideModule) w().b(R.id.ligm_promotion_guide).f()).setArgument(this.f150201g);
    L11:
        this.f150200f = r101;
        ListItemGuideModule r102 = (ListItemGuideModule) w().b(R.id.ligm_promotion_guide).f();
        com.bytedance.android.livesdk.livecommerce.promotion.card.i r103 = this.f150200f;
        if (r103 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("promotionCardItem");
    L14:
        r102.f(r103.f150059a, new ListItemRootPresenter$updateGuideArea$1(this));
        UpdateType r104 = UpdateType.UPDATE_ALL;
    }
}
