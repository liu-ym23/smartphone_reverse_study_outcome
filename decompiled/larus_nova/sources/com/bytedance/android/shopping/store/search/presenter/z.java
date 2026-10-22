package com.bytedance.android.shopping.store.search.presenter;

import android.content.Context;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.store.status.LazyStatusView;
import com.bytedance.android.ec.store.status.StoreSearchProductLoadingStatusView;
import com.bytedance.android.shopping.store.search.viewmodel.ShopSearchFragmentProductViewModel;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class z extends QFragmentPresenter {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ShopSearchFragmentProductViewModel f186117f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f186118g;

    public z(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        super(r100);
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter
    public final void b0(QModel r100) {
        this.f186117f = (ShopSearchFragmentProductViewModel) Y().g(ShopSearchFragmentProductViewModel.class);
        Context r101 = Y().c();
        ViewGroup r102 = (ViewGroup) Z().b(R.id.sv_product_list_status).f();
        final LazyStatusView r103 = new LazyStatusView(r101, null);
        r102.addView(r103);
        r103.setCreators(MapsKt.mapOf(new Pair[]{TuplesKt.to(com.bytedance.android.ec.store.status.b.a.f48651a, new com.bytedance.android.ec.store.status.c(new ShopSearchStatusPresenter$initOptStatusView$1(this, r103), null, 6)), TuplesKt.to(com.bytedance.android.ec.store.status.b.C0841b.f48652a, new com.bytedance.android.ec.store.status.c(new ShopSearchStatusPresenter$initOptStatusView$2(this, r103), null, 6))}));
        r103.a(new StoreSearchProductLoadingStatusView(r101).a());
        ShopSearchFragmentProductViewModel r104 = this.f186117f;
        if (r104 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        r104.getLoadStatus().b(ECQuickUtilKt.a(Y()), new y(this, r102, r103, r101));
    }
}
