package com.bytedance.android.livesdk.livecommerce.promotion.card.presenter;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.livesdk.livecommerce.promotion.card.model.LivePromotionCardArgs;
import com.bytedance.android.livesdk.livecommerce.promotion.card.module.ListItemBottomBlockView;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QPresenter;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class c extends QPresenter {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f150191e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LivePromotionCardArgs f150192f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final w83.d<?> f150193g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy<w83.i> f150194h;

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QPresenter
    public final void A(QModel r100) {
        if ((r100 instanceof com.bytedance.android.livesdk.livecommerce.promotion.card.i) == true) goto L5;
        r100 = null;
    L5:
        com.bytedance.android.livesdk.livecommerce.promotion.card.i r101 = (com.bytedance.android.livesdk.livecommerce.promotion.card.i) r100;
        if (r101 != null) goto L8;
        return;
    L8:
        if (this.f150191e == true) goto L11;
        this.f150191e = true;
        ListItemBottomBlockView r102 = (ListItemBottomBlockView) w().f();
        LivePromotionCardArgs r103 = this.f150192f;
        Lazy<w83.i> r104 = this.f150194h;
        Intrinsics.checkNotNullParameter(r103, "argument");
        r102.f150100a = r104;
        r102.getClass();
    L11:
        ListItemBottomBlockView r105 = (ListItemBottomBlockView) w().f();
        Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(LivePromotionCardArgs r100, w83.d<?> r101, Lazy<? extends w83.i> r102) {
        Intrinsics.checkNotNullParameter(r100, "argument");
        Intrinsics.checkNotNullParameter(r102, "ligoViewManager");
        this.f150192f = r100;
        this.f150193g = r101;
        this.f150194h = r102;
    }
}
