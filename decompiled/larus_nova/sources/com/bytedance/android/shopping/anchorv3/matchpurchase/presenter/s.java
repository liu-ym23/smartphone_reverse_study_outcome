package com.bytedance.android.shopping.anchorv3.matchpurchase.presenter;

import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.shopping.anchorv3.matchpurchase.MatchPurchaseHelper;
import com.bytedance.android.shopping.anchorv3.matchpurchase.model.MatchPurchaseParams;
import com.bytedance.android.shopping.anchorv3.matchpurchase.viewmodel.MatchPurchaseGroupViewModel;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class s extends QFragmentPresenter {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public MatchPurchaseGroupViewModel f165167f;

    public s(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        super(r100);
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter
    public final void b0(QModel r100) {
        MatchPurchaseGroupViewModel r101 = (MatchPurchaseGroupViewModel) Y().g(MatchPurchaseGroupViewModel.class);
        this.f165167f = r101;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L6:
        if ((r100 instanceof MatchPurchaseParams) == true) goto L8;
        r100 = null;
    L8:
        r101.initData((MatchPurchaseParams) r100);
        if (MatchPurchaseHelper.a() == false) goto L11;
        Z().b(R.id.match_purchase_fragment_title).c();
        Z().b(R.id.match_purchase_fragment_title_v2_layout).g(0);
        Z().b(R.id.match_purchase_fragment_close).a(new r(this));
    L11:
        MatchPurchaseGroupViewModel r102 = this.f165167f;
        if (r102 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L14:
        r102.getLivePanelTitle().b(ECQuickUtilKt.a(Y()), new q(this));
    }
}
