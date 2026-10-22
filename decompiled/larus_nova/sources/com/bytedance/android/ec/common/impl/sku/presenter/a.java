package com.bytedance.android.ec.common.impl.sku.presenter;

import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.common.impl.sku.SkuViewModel;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a extends QFragmentPresenter {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public SkuViewModel f43169f;

    /* JADX INFO: renamed from: com.bytedance.android.ec.common.impl.sku.presenter.a$a, reason: collision with other inner class name */
    public static final class C0785a {
    }

    static {
    }

    public a(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        super(r100);
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter
    public final void b0(QModel r100) {
        SkuViewModel r101 = (SkuViewModel) Y().g(SkuViewModel.class);
        this.f43169f = r101;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        r101.getSkuInfo().b(ECQuickUtilKt.a(Y()), new c(this));
    }
}
