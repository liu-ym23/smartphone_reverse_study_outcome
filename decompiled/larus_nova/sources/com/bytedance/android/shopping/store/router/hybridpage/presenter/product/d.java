package com.bytedance.android.shopping.store.router.hybridpage.presenter.product;

import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.store.product.holder.LayoutTypes;
import com.bytedance.android.ecom.arch.slice.render.r;
import com.bytedance.android.shopping.store.hybridproduct.presenter.ShopSlicedProductCardBasePresenter;
import com.bytedance.android.shopping.store.router.hybridpage.viewmodel.HybridPageViewModel;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class d extends ShopSlicedProductCardBasePresenter {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final HybridPageViewModel f185948x;

    public d(Fragment r100, r r101, LayoutTypes r102, HybridPageViewModel r103) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r102, "layoutTypes");
        Intrinsics.checkNotNullParameter(r103, "viewModel");
        super(r100, r101, r102);
        this.f185948x = r103;
    }
}
