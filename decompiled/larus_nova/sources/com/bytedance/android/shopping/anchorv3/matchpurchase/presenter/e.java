package com.bytedance.android.shopping.anchorv3.matchpurchase.presenter;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.shopping.anchorv3.matchpurchase.view.MatchPurchaseListAdapter;
import com.bytedance.android.shopping.anchorv3.matchpurchase.view.ProductListDecoration;
import com.bytedance.android.shopping.anchorv3.matchpurchase.viewmodel.MatchPurchaseGroupViewModel;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class e extends QFragmentPresenter {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public MatchPurchaseGroupViewModel f165147f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public RecyclerView f165148g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public MatchPurchaseListAdapter f165149h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f165150i;

    public e(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        super(r100);
        this.f165150i = true;
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter
    public final void b0(QModel r100) {
        this.f165147f = (MatchPurchaseGroupViewModel) Y().g(MatchPurchaseGroupViewModel.class);
        this.f165148g = (RecyclerView) Z().b(R.id.rv_combined_sku_list).f();
        Fragment r101 = Y().f450890a;
        if (r101 == null) goto L18;
        RecyclerView r102 = this.f165148g;
        if (r102 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L7:
        Context r103 = Y().c();
        MatchPurchaseGroupViewModel r104 = this.f165147f;
        if (r104 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L10:
        r102.setLayoutManager(new LinearLayoutManager(r103, !r104.isFullScreen() ? 1 : 0, false));
        MatchPurchaseGroupViewModel r105 = this.f165147f;
        if (r105 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L13:
        boolean r106 = r105.isFullScreen();
        MatchPurchaseListAdapter r107 = new MatchPurchaseListAdapter(r101, !r106);
        this.f165149h = r107;
        r102.setAdapter(r107);
        if (r106 == false) goto L16;
        float r108 = 5.0f;
    L17:
        r102.addItemDecoration(new ProductListDecoration(r108, r106 ? 1 : 0));
        goto L18
    L16:
        r108 = 24.0f;
    L18:
        MatchPurchaseGroupViewModel r109 = this.f165147f;
        if (r109 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L21:
        r109.getCombinationSkusVO().c(ECQuickUtilKt.a(Y()), new d(this), true);
    }
}
