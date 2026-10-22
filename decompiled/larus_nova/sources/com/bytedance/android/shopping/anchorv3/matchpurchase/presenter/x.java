package com.bytedance.android.shopping.anchorv3.matchpurchase.presenter;

import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.shopping.anchorv3.matchpurchase.viewmodel.MatchPurchaseGroupViewModel;
import com.bytedance.android.shopping.widget.buybutton.ShoppingPurchaseButton;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class x extends QFragmentPresenter {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public MatchPurchaseGroupViewModel f165172f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ShoppingPurchaseButton f165173g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Boolean f165174h;

    public x(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        super(r100);
    }

    public static final /* synthetic */ ShoppingPurchaseButton d0(x r100) {
        ShoppingPurchaseButton r101 = r100.f165173g;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("purchaseButton");
    L5:
        return r101;
    }

    public static final /* synthetic */ MatchPurchaseGroupViewModel e0(x r100) {
        MatchPurchaseGroupViewModel r101 = r100.f165172f;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        return r101;
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter
    public final void b0(QModel r100) {
        this.f165172f = (MatchPurchaseGroupViewModel) Y().g(MatchPurchaseGroupViewModel.class);
        ShoppingPurchaseButton r101 = (ShoppingPurchaseButton) Z().b(R.id.match_purchase_button).f();
        this.f165173g = r101;
        w r102 = new w(this);
        Intrinsics.checkNotNullParameter(r102, "service");
        com.bytedance.android.shopping.widget.buybutton.g r103 = r101.f187270f;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r102, "service");
        r103.f187297b = r102;
        MatchPurchaseGroupViewModel r104 = this.f165172f;
        if (r104 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        r104.getPurchaseButtonVO().c(ECQuickUtilKt.a(Y()), new u(this), true);
        MatchPurchaseGroupViewModel r105 = this.f165172f;
        if (r105 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L8:
        r105.getSelectAllButtonCheckStatus().b(ECQuickUtilKt.a(Y()), new v(this));
    }
}
