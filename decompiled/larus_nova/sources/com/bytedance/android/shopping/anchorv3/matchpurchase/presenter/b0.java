package com.bytedance.android.shopping.anchorv3.matchpurchase.presenter;

import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.shopping.anchorv3.matchpurchase.viewmodel.MatchPurchaseActivityModel;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QPresenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class b0 extends QPresenter {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public MatchPurchaseActivityModel f165141e;

    public b0() {
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QPresenter
    public final void A(QModel r100) {
        this.f165141e = (MatchPurchaseActivityModel) u().f(MatchPurchaseActivityModel.class);
        w().b(R.id.ic_close).a(new a0(this));
        MatchPurchaseActivityModel r101 = this.f165141e;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        r101.getShopBrandVO().c(ECQuickUtilKt.a(u()), new z(this), true);
    }
}
