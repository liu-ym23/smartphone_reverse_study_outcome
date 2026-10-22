package com.bytedance.android.shopping.anchorv3.matchpurchase.presenter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.shopping.anchorv3.matchpurchase.MatchPurchaseHelper;
import com.bytedance.android.shopping.anchorv3.matchpurchase.viewmodel.MatchPurchaseGroupViewModel;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class p extends QFragmentPresenter {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public MatchPurchaseGroupViewModel f165164f;

    public p(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        super(r100);
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter
    public final void b0(QModel r100) {
        MatchPurchaseGroupViewModel r101 = (MatchPurchaseGroupViewModel) Y().g(MatchPurchaseGroupViewModel.class);
        this.f165164f = r101;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        ViewGroup.LayoutParams r102 = null;
        if (r101.isFullScreen() == false) goto L15;
        View r103 = Z().b(R.id.fl_mp_combination_skus_container).f();
        if (com.bytedance.android.shopping.anchorv3.detail.utils.a.a() == false) goto L24;
        ViewGroup.LayoutParams r104 = r103.getLayoutParams();
        if ((r104 instanceof ViewGroup.MarginLayoutParams) == true) goto L12;
        r104 = null;
    L12:
        ViewGroup.MarginLayoutParams r105 = (ViewGroup.MarginLayoutParams) r104;
        if (r105 == null) goto L24;
        r105.bottomMargin = com.bytedance.android.shopping.extensions.b.b(12);
        r103.setLayoutParams(r105);
    L24:
        if (MatchPurchaseHelper.a() == false) goto L32;
        View r106 = Z().b(R.id.match_purchase_buy_button_fl_container).f();
        ViewGroup.LayoutParams r107 = r106.getLayoutParams();
        if ((r107 instanceof ViewGroup.MarginLayoutParams) == false) goto L29;
        r102 = r107;
    L29:
        ViewGroup.MarginLayoutParams r108 = (ViewGroup.MarginLayoutParams) r102;
        if (r108 == null) goto L32;
        r108.leftMargin = 0;
        r108.rightMargin = 0;
        r108.setMarginStart(0);
        r108.setMarginEnd(0);
        r106.setLayoutParams(r108);
    L32:
        MatchPurchaseGroupViewModel r109 = this.f165164f;
        if (r109 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L35:
        r109.getCombinedCheckedResult().b(ECQuickUtilKt.a(Y()), new m(this));
        MatchPurchaseGroupViewModel r110 = this.f165164f;
        if (r110 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L38:
        r110.getDescTitleVO().c(ECQuickUtilKt.a(Y()), new n(this), true);
        MatchPurchaseGroupViewModel r111 = this.f165164f;
        if (r111 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L41:
        r111.getFirstBind().b(ECQuickUtilKt.a(Y()), new o(this));
        return;
    L15:
        Y().d().q(q63.c.class, 8);
        Z().b(R.id.fl_mp_header_picture_container).c();
        View r112 = Z().b(R.id.fl_mp_combination_skus_container).f();
        ViewGroup.LayoutParams r113 = r112.getLayoutParams();
        if ((r113 instanceof LinearLayout.LayoutParams) == true) goto L18;
        r113 = null;
    L18:
        LinearLayout.LayoutParams r114 = (LinearLayout.LayoutParams) r113;
        if (r114 == null) goto L21;
        r114.height = 0;
        r114.weight = 1.0f;
        r114.topMargin = com.bytedance.android.shopping.extensions.b.b(16);
        Unit r115 = Unit.INSTANCE;
    L22:
        r112.setLayoutParams(r114);
        goto L24
    L21:
        r114 = null;
        goto L22
    }
}
