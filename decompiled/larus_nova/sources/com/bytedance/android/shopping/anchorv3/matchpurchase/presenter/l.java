package com.bytedance.android.shopping.anchorv3.matchpurchase.presenter;

import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.shopping.anchorv3.matchpurchase.model.MatchPurchaseParams;
import com.bytedance.android.shopping.anchorv3.matchpurchase.viewmodel.MatchPurchaseActivityModel;
import com.bytedance.android.shopping.commentfeed.widget.VerticalViewPager;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QPresenter;

/* JADX INFO: loaded from: classes12.dex */
public final class l extends QPresenter {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public MatchPurchaseActivityModel f165158e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public VerticalViewPager f165159f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public MatchPurchaseParams f165160g;

    public l() {
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QPresenter
    public final void A(QModel r100) {
        MatchPurchaseActivityModel r101 = (MatchPurchaseActivityModel) u().f(MatchPurchaseActivityModel.class);
        this.f165158e = r101;
        if ((r100 instanceof MatchPurchaseParams) == true) goto L5;
        r100 = null;
    L5:
        MatchPurchaseParams r102 = (MatchPurchaseParams) r100;
        this.f165160g = r102;
        if (r101 == null) goto L8;
        r101.initData(r102);
    L8:
        this.f165159f = (VerticalViewPager) w().b(R.id.pager).f();
        MatchPurchaseActivityModel r103 = this.f165158e;
        if (r103 == null) goto L13;
        r103.getPageClosed().b(ECQuickUtilKt.a(u()), new j(this, r103));
        r103.getPageCount().c(ECQuickUtilKt.a(u()), new k(this), true);
        return;
    }
}
