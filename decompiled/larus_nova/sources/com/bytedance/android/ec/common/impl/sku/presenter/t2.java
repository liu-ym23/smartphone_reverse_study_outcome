package com.bytedance.android.ec.common.impl.sku.presenter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.common.impl.sku.SkuViewModel;
import com.bytedance.android.ec.core.data.ActionObserver;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.core.widget.StatusView;
import com.bytedance.android.shopping.api.accessibility.AccessibilityDelegateCompatImpl;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class t2 extends QFragmentPresenter {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public SkuViewModel f43296f;

    public t2(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        super(r100);
    }

    public static final /* synthetic */ SkuViewModel d0(t2 r100) {
        SkuViewModel r101 = r100.f43296f;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        return r101;
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter
    public final void b0(QModel r100) {
        this.f43296f = (SkuViewModel) Y().g(SkuViewModel.class);
        View r101 = Z().b(R.id.iv_sku_close).f();
        AccessibilityDelegateCompatImpl r102 = new AccessibilityDelegateCompatImpl(r101);
        r102.f170190b = "关闭";
        ViewCompat.setAccessibilityDelegate(r101, r102);
        Z().b(R.id.iv_sku_close).f().setOnClickListener(new r2(this));
        SkuViewModel r103 = this.f43296f;
        if (r103 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        r103.getDisplayToast().b(ECQuickUtilKt.a(Y()), new ActionObserver(new SkuPanelGroupPresenter$initSubscribe$1(this)));
        SkuViewModel r104 = this.f43296f;
        if (r104 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L8:
        r104.getSkuInfo().b(ECQuickUtilKt.a(Y()), new q2(this));
        StatusView r105 = (StatusView) Z().b(R.id.sv_sku_status_view).f();
        View r106 = th.a.c(Y().c(), R.layout.shopping_layout_sku_default, r105, false);
        r106.findViewById(R.id.tv_sku_refresh).setOnClickListener(new o2(this));
        ImageView r107 = new ImageView(r105.getContext());
        r107.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        r107.setBackgroundResource(R.drawable.shopping_ic_sku_panel_skele);
        r105.b(r107, r106, false);
        SkuViewModel r108 = this.f43296f;
        if (r108 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L11:
        r108.getLoadStatus().b(ECQuickUtilKt.a(Y()), new p2(this));
        int r109 = jg.f.f498945a;
        SkuViewModel r110 = this.f43296f;
        if (r110 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L15:
        if (jg.f.a(r110) == false) goto L22;
        SkuViewModel r111 = this.f43296f;
        if (r111 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L20:
        r111.getLoadStatus().b(Y().e(), new s2(this));
        return;
    }
}
