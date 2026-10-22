package com.bytedance.android.shopping.anchorv3.matchpurchase.presenter;

import androidx.fragment.app.Fragment;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.shopping.anchorv3.matchpurchase.view.FloatingTagLayout;
import com.bytedance.android.shopping.anchorv3.matchpurchase.viewmodel.MatchPurchaseGroupViewModel;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class i extends QFragmentPresenter {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public MatchPurchaseGroupViewModel f165154f;

    public i(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        super(r100);
    }

    public static final BtmItemBuilder d0(i r100) {
        FloatingTagLayout r101 = (FloatingTagLayout) r100.Z().b(R.id.header_layout).f();
        return new BtmItemBuilder("a1.b7324.c04535.d21086", Boolean.FALSE).withView(r101);
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter
    public final void b0(QModel r100) {
        MatchPurchaseGroupViewModel r101 = (MatchPurchaseGroupViewModel) Y().g(MatchPurchaseGroupViewModel.class);
        this.f165154f = r101;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        r101.getHeaderPictureVO().c(ECQuickUtilKt.a(Y()), new g(this), true);
        MatchPurchaseGroupViewModel r102 = this.f165154f;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L8:
        r102.getHeaderPicture().c(ECQuickUtilKt.a(Y()), new h(this), true);
    }
}
