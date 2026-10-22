package com.bytedance.android.ec.common.impl.sku.presenter;

import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.common.impl.sku.SkuViewModel;
import com.bytedance.android.ec.common.impl.sku.view.SkuBenefitLabelGroupLayout;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.model.PromotionBenefitLabel;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class k0 extends QFragmentPresenter {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public SkuViewModel f43243f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f43244g;

    public k0(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        super(r100);
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter
    public final void b0(QModel r100) {
        this.f43243f = (SkuViewModel) Y().g(SkuViewModel.class);
        if (this.f43244g == true) goto L19;
        this.f43244g = true;
        Z().b(R.id.ll_sku_benefit_label).f().setVisibility(0);
        SkuViewModel r101 = this.f43243f;
        if (r101 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L7:
        List<PromotionBenefitLabel> r102 = r101.getSkuParams().getBenefitLabels();
        if (r102 == null) goto L19;
        if ((true ^ r102.isEmpty()) == true) goto L13;
        r102 = null;
    L13:
        if (r102 == null) goto L19;
        SkuBenefitLabelGroupLayout r103 = (SkuBenefitLabelGroupLayout) Z().b(R.id.ll_sku_benefit_label).f();
        Intrinsics.checkNotNullParameter(r102, "benefitLabelList");
        ((ArrayList) r103.f43408a).clear();
        ((ArrayList) r103.f43409b).clear();
        Iterator<T> r104 = r102.iterator();
    L16:
        if (r104.hasNext() == false) goto L18;
        PromotionBenefitLabel r105 = (PromotionBenefitLabel) r104.next();
        ((ArrayList) r103.f43408a).add(r105);
        ((ArrayList) r103.f43409b).add(r105);
        goto L16
    L18:
        r103.a();
        com.bytedance.android.ec.core.widget.f.c(a0(), null, null, new CouponPresenter$initViews$$inlined$apply$lambda$1(this), 3);
    L19:
        SkuViewModel r106 = this.f43243f;
        if (r106 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L22:
        r106.getCurrentBenefitLabel().b(ECQuickUtilKt.a(Y()), new j0(this));
    }
}
