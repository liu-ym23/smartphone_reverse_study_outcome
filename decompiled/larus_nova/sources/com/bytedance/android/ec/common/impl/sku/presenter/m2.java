package com.bytedance.android.ec.common.impl.sku.presenter;

import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.common.impl.sku.SkuViewModel;
import com.bytedance.android.ec.core.data.ActionObserver;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.core.widget.StatusView;
import com.bytedance.android.shopping.api.accessibility.AccessibilityDelegateCompatImpl;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes43.dex */
public final class m2 extends QFragmentPresenter {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public SkuViewModel f43257f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public com.bytedance.android.ec.common.impl.sku.view.f f43258g;

    public m2(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        super(r100);
    }

    public static final /* synthetic */ SkuViewModel d0(m2 r100) {
        SkuViewModel r101 = r100.f43257f;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        return r101;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v13, types: [T, android.view.View] */
    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter
    public final void b0(QModel r110) {
        this.f43257f = (SkuViewModel) Y().g(SkuViewModel.class);
        View r111 = Z().b(R.id.iv_sku_close).f();
        AccessibilityDelegateCompatImpl r100 = new AccessibilityDelegateCompatImpl(r111);
        r100.f170190b = "关闭";
        ViewCompat.setAccessibilityDelegate(r111, r100);
        Z().b(R.id.iv_sku_close).f().setOnClickListener(new SkuPanelGroupOptimizePresenter$initViews$2(this));
        SkuViewModel r112 = this.f43257f;
        if (r112 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        String r113 = r112.getSkuParams().getDetailUrl();
        if (r113 != null) goto L8;
    L11:
        boolean r114 = true;
    L13:
        if (r114 == false) goto L21;
        Z().b(R.id.iv_sku_close).f().setVisibility(0);
        Z().b(R.id.v_sku_close_bar).f().setVisibility(8);
        View r115 = Z().b(R.id.fl_sku_header_container).f();
        ViewGroup.LayoutParams r101 = r115.getLayoutParams();
        if ((r101 instanceof ViewGroup.MarginLayoutParams) == true) goto L17;
        r101 = null;
    L17:
        ViewGroup.MarginLayoutParams r102 = (ViewGroup.MarginLayoutParams) r101;
        if (r102 == null) goto L37;
        Resources r103 = Resources.getSystem();
        r102.bottomMargin = MathKt.roundToInt(TypedValue.applyDimension(1, 0, WindowDisplayMetricsOverride.apply(r103, r103.getDisplayMetrics())));
        r115.setLayoutParams(r102);
    L37:
        final Ref.ObjectRef r116 = new Ref.ObjectRef();
        r116.element = null;
        StatusView r104 = (StatusView) Z().b(R.id.sv_sku_status_view).f();
        ?? r105 = th.a.c(Y().c(), R.layout.ec_common_layout_error, r104, false);
        r116.element = r105;
        if (r105 == 0) goto L42;
        View r106 = r105.findViewById(R.id.tv_ec_common_refresh);
        if (r106 == null) goto L42;
        com.bytedance.android.ec.core.widget.f.c(r106, null, null, new SkuPanelGroupOptimizePresenter$initStatusView$$inlined$apply$lambda$1(this, r116), 3);
    L42:
        SkuViewModel r107 = this.f43257f;
        if (r107 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L45:
        String r108 = r107.getSkuParams().getDetailUrl();
        if (r108 != null) goto L48;
    L51:
        boolean r109 = true;
    L53:
        if (r109 == false) goto L56;
        View r117 = th.a.c(Y().c(), R.layout.shopping_layout_sku_loading_optimize_2, r104, false);
    L62:
        r104.b(r117, (View) r116.element, false);
        Z().b(R.id.ll_sku_panel_container).f().setVisibility(4);
        r104.showLoading();
        SkuViewModel r118 = this.f43257f;
        if (r118 != null) goto L65;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L65:
        r118.getLoadStatus().b(ECQuickUtilKt.a(Y()), new h2(this, r116));
        SkuViewModel r119 = this.f43257f;
        if (r119 != null) goto L68;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L68:
        r119.getDisplayToast().b(ECQuickUtilKt.a(Y()), new ActionObserver(new SkuPanelGroupOptimizePresenter$initSubscribe$1(this)));
        SkuViewModel r120 = this.f43257f;
        if (r120 != null) goto L71;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L71:
        r120.getSkuInfo().b(ECQuickUtilKt.a(Y()), new j2(this));
        SkuViewModel r121 = this.f43257f;
        if (r121 != null) goto L74;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L74:
        r121.getSkuInfo().b(ECQuickUtilKt.a(Y()), new l2(this));
        return;
    L56:
        if (com.bytedance.android.ec.core.abtest.d.F() != 1) goto L58;
    L61:
        r117 = th.a.c(Y().c(), R.layout.shopping_layout_sku_loading_optimize_1, r104, false);
        goto L62
    L58:
        if (com.bytedance.android.ec.core.abtest.d.F() == 2) goto L61;
        r117 = th.a.c(Y().c(), R.layout.shopping_layout_sku_loading_optimize_2, r104, false);
        goto L62
    L48:
        if (r108.length() == 0) goto L51;
        r109 = false;
        goto L53
    L21:
        if (com.bytedance.android.ec.core.abtest.d.F() != 1) goto L23;
    L31:
        Z().b(R.id.iv_sku_close).f().setVisibility(8);
        Z().b(R.id.v_sku_close_bar).f().setVisibility(0);
        View r122 = Z().b(R.id.fl_sku_header_container).f();
        ViewGroup.LayoutParams r123 = r122.getLayoutParams();
        if ((r123 instanceof ViewGroup.MarginLayoutParams) == true) goto L34;
        r123 = null;
    L34:
        ViewGroup.MarginLayoutParams r124 = (ViewGroup.MarginLayoutParams) r123;
        if (r124 == null) goto L37;
        Resources r125 = Resources.getSystem();
        r124.bottomMargin = MathKt.roundToInt(TypedValue.applyDimension(1, 12, WindowDisplayMetricsOverride.apply(r125, r125.getDisplayMetrics())));
        r122.setLayoutParams(r124);
        goto L37
    L23:
        if (com.bytedance.android.ec.core.abtest.d.F() == 2) goto L31;
        Z().b(R.id.iv_sku_close).f().setVisibility(0);
        Z().b(R.id.v_sku_close_bar).f().setVisibility(8);
        View r126 = Z().b(R.id.fl_sku_header_container).f();
        ViewGroup.LayoutParams r127 = r126.getLayoutParams();
        if ((r127 instanceof ViewGroup.MarginLayoutParams) == true) goto L28;
        r127 = null;
    L28:
        ViewGroup.MarginLayoutParams r128 = (ViewGroup.MarginLayoutParams) r127;
        if (r128 == null) goto L37;
        Resources r129 = Resources.getSystem();
        r128.bottomMargin = MathKt.roundToInt(TypedValue.applyDimension(1, 0, WindowDisplayMetricsOverride.apply(r129, r129.getDisplayMetrics())));
        r126.setLayoutParams(r128);
        goto L37
    L8:
        if (r113.length() == 0) goto L11;
        r114 = false;
        goto L13
    }
}
