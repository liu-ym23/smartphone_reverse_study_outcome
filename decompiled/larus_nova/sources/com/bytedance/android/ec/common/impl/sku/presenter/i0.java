package com.bytedance.android.ec.common.impl.sku.presenter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.common.impl.sku.SkuViewModel;
import com.bytedance.android.ec.common.impl.sku.model.SkuInfoVO;
import com.bytedance.android.ec.common.impl.sku.model.SkuLimit;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.shopping.api.accessibility.AccessibilityDelegateCompatImpl;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes43.dex */
public final class i0 extends QFragmentPresenter implements View.OnClickListener {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public SkuViewModel f43235f;

    public i0(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        super(r100);
    }

    public static final void d0(i0 r100) {
        SkuViewModel r101 = r100.f43235f;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        long r102 = r101.getCurrentCount();
        SkuViewModel r103 = r100.f43235f;
        if (r103 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L9:
        if (r102 >= r103.getLowerLimit()) goto L14;
        SkuViewModel r104 = r100.f43235f;
        if (r104 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L13:
        long r105 = r104.getLowerLimit();
    L33:
        r100.Z().b(R.id.iv_sku_select_minus).f().setVisibility(0);
        r100.Z().b(R.id.iv_sku_select_plus).f().setVisibility(0);
        ((TextView) r100.Z().b(R.id.tv_sku_select_count).f()).setText(String.valueOf(r105));
        ImageView r106 = (ImageView) r100.Z().b(R.id.iv_sku_select_minus).f();
        SkuViewModel r107 = r100.f43235f;
        if (r107 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L37:
        if (r105 > r107.getLowerLimit()) goto L39;
        int r108 = R.drawable.shopping_ic_sku_panel_un_minus;
    L40:
        r106.setImageResource(r108);
        ImageView r109 = (ImageView) r100.Z().b(R.id.iv_sku_select_plus).f();
        SkuViewModel r110 = r100.f43235f;
        if (r110 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L44:
        if (r105 < r110.getUpperLimit()) goto L46;
        int r111 = R.drawable.shopping_ic_sku_panel_un_plus;
    L47:
        r109.setImageResource(r111);
        SkuViewModel r112 = r100.f43235f;
        if (r112 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L51:
        if (r105 == r112.getCurrentCount()) goto L57;
        SkuViewModel r113 = r100.f43235f;
        if (r113 != null) goto L55;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L55:
        r113.m8147getCurrentCount().g(Long.valueOf(r105));
        return;
    L57:
        return;
    L46:
        r111 = R.drawable.shopping_ic_sku_panel_plus;
        goto L47
    L39:
        r108 = R.drawable.shopping_ic_sku_panel_minus;
        goto L40
    L14:
        SkuViewModel r114 = r100.f43235f;
        if (r114 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L17:
        long r115 = r114.getCurrentCount();
        SkuViewModel r116 = r100.f43235f;
        if (r116 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L21:
        if (r115 <= r116.getUpperLimit()) goto L29;
        SkuViewModel r117 = r100.f43235f;
        if (r117 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L25:
        long r118 = r117.getLowerLimit();
        SkuViewModel r119 = r100.f43235f;
        if (r119 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L28:
        r105 = RangesKt.coerceAtLeast(r118, r119.getUpperLimit());
        goto L33
    L29:
        SkuViewModel r120 = r100.f43235f;
        if (r120 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L32:
        r105 = r120.getCurrentCount();
        goto L33
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter
    public final void b0(QModel r100) {
        this.f43235f = (SkuViewModel) Y().g(SkuViewModel.class);
        Z().b(R.id.iv_sku_select_plus).f().setOnClickListener(this);
        View r101 = Z().b(R.id.iv_sku_select_plus).f();
        AccessibilityDelegateCompatImpl r102 = new AccessibilityDelegateCompatImpl(r101);
        r102.f170190b = th.a.f(Y().c()).getString(R.string.ec_plus_count);
        ViewCompat.setAccessibilityDelegate(r101, r102);
        Z().b(R.id.iv_sku_select_minus).f().setOnClickListener(this);
        View r103 = Z().b(R.id.iv_sku_select_minus).f();
        AccessibilityDelegateCompatImpl r104 = new AccessibilityDelegateCompatImpl(r103);
        r104.f170190b = th.a.f(Y().c()).getString(R.string.ec_minus_count);
        ViewCompat.setAccessibilityDelegate(r103, r104);
        SkuViewModel r105 = this.f43235f;
        if (r105 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        r105.m8147getCurrentCount().b(ECQuickUtilKt.a(Y()), new e0(this));
        SkuViewModel r106 = this.f43235f;
        if (r106 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L8:
        r106.m8151getUpperLimit().b(ECQuickUtilKt.a(Y()), new f0(this));
        SkuViewModel r107 = this.f43235f;
        if (r107 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L11:
        r107.m8149getLowerLimit().b(ECQuickUtilKt.a(Y()), new g0(this));
        SkuViewModel r108 = this.f43235f;
        if (r108 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L14:
        r108.getLimitText().b(ECQuickUtilKt.a(Y()), new h0(this));
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r110) {
        if (r110 != null) goto L4;
        return;
    L4:
        int r111 = r110.getId();
        if (r111 != R.id.iv_sku_select_plus) goto L70;
        SkuViewModel r112 = this.f43235f;
        if (r112 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L9:
        long r100 = r112.getCurrentCount();
        SkuViewModel r113 = this.f43235f;
        if (r113 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L13:
        if (r100 >= r113.getUpperLimit()) goto L47;
        SkuViewModel r114 = this.f43235f;
        if (r114 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L17:
        QLiveData<Long> r115 = r114.m8147getCurrentCount();
        SkuViewModel r101 = this.f43235f;
        if (r101 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L20:
        r115.g(Long.valueOf(r101.getCurrentCount() + 1));
        SkuViewModel r116 = this.f43235f;
        if (r116 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L23:
        SkuInfoVO r117 = r116.getSkuInfo().a();
        Integer r102 = null;
        if (r117 == null) goto L26;
        Boolean r118 = r117.getHasGivenProduct();
    L28:
        if (Intrinsics.areEqual(r118, Boolean.TRUE) == false) goto L99;
        SkuViewModel r119 = this.f43235f;
        if (r119 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L32:
        Long r120 = r119.m8147getCurrentCount().a();
        if (r120 == null) goto L35;
        Integer r121 = Integer.valueOf((int) r120.longValue());
    L36:
        SkuViewModel r103 = this.f43235f;
        if (r103 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L39:
        SkuInfoVO r104 = r103.getSkuInfo().a();
        if (r104 == null) goto L45;
        Integer r105 = r104.getGivenProductStock();
        if (r105 == null) goto L45;
        r102 = Integer.valueOf(r105.intValue() + 1);
    L45:
        if (Intrinsics.areEqual(r121, r102) == false) goto L100;
        UIUtils.displayToast(Y().c(), R.string.shopping_sku_not_enough_given_product);
        return;
    L100:
        return;
    L35:
        r121 = null;
        goto L36
    L99:
        return;
    L26:
        r118 = null;
        goto L28
    L47:
        SkuViewModel r122 = this.f43235f;
        if (r122 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L50:
        SkuLimit r123 = r122.m8151getUpperLimit().a();
        if (r123 == null) goto L54;
        String r124 = r123.getToast();
        if (r124 == null) goto L54;
    L58:
        SkuViewModel r106 = this.f43235f;
        if (r106 != null) goto L62;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L62:
        if (r106.getSkuParams().isFromAnchorV3() == false) goto L64;
        String r107 = com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_DETAIL;
    L65:
        SkuViewModel r108 = this.f43235f;
        if (r108 != null) goto L68;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L68:
        SkuViewModel.doSkuEventAction$default(r108, "livesdk_toast_show", new Pair[]{TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_EVENT_ORIGIN_FEATURE, com.bytedance.android.ec.core.event.a.VALUE_TEMAI), TuplesKt.to("page_name", r107)}, null, null, null, 28, null);
        UIUtils.displayToast(Y().c(), r124);
        return;
    L64:
        r107 = "live_room_sku";
    L54:
        Context r125 = Y().c();
        Object[] r109 = new Object[1];
        SkuViewModel r126 = this.f43235f;
        if (r126 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L57:
        r109[0] = Long.valueOf(r126.getUpperLimit());
        r124 = th.a.h(r125, R.string.shopping_sku_buy_maximum, r109);
        goto L58
    L70:
        if (r111 != R.id.iv_sku_select_minus) goto L103;
        SkuViewModel r127 = this.f43235f;
        if (r127 != null) goto L74;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L74:
        long r128 = r127.getCurrentCount();
        SkuViewModel r129 = this.f43235f;
        if (r129 != null) goto L78;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L78:
        if (r128 <= r129.getLowerLimit()) goto L86;
        SkuViewModel r130 = this.f43235f;
        if (r130 != null) goto L82;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L82:
        QLiveData<Long> r131 = r130.m8147getCurrentCount();
        SkuViewModel r132 = this.f43235f;
        if (r132 != null) goto L85;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L85:
        r131.g(Long.valueOf(r132.getCurrentCount() - 1));
        return;
    L86:
        SkuViewModel r133 = this.f43235f;
        if (r133 != null) goto L89;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L89:
        SkuLimit r134 = r133.m8149getLowerLimit().a();
        if (r134 == null) goto L93;
        String r135 = r134.getToast();
        if (r135 == null) goto L93;
    L97:
        UIUtils.displayToast(Y().c(), r135);
        return;
    L93:
        Context r136 = Y().c();
        Object[] r137 = new Object[1];
        SkuViewModel r138 = this.f43235f;
        if (r138 != null) goto L96;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L96:
        r137[0] = Long.valueOf(r138.getLowerLimit());
        r135 = th.a.h(r136, R.string.shopping_sku_buy_minimum, r137);
        goto L97
    }
}
