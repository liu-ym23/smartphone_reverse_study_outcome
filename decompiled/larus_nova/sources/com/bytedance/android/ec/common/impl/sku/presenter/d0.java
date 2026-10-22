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
public final class d0 extends QFragmentPresenter implements View.OnClickListener {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public SkuViewModel f43195f;

    public d0(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        super(r100);
    }

    public static final void d0(d0 r100) {
        SkuViewModel r101 = r100.f43195f;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        long r102 = r101.getCurrentCount();
        SkuViewModel r103 = r100.f43195f;
        if (r103 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L9:
        if (r102 >= r103.getLowerLimit()) goto L14;
        SkuViewModel r104 = r100.f43195f;
        if (r104 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L13:
        long r105 = r104.getLowerLimit();
    L33:
        r100.Z().b(R.id.iv_sku_select_minus).f().setVisibility(0);
        r100.Z().b(R.id.iv_sku_select_plus).f().setVisibility(0);
        ((TextView) r100.Z().b(R.id.tv_sku_select_count).f()).setText(String.valueOf(r105));
        ImageView r106 = (ImageView) r100.Z().b(R.id.iv_sku_select_minus).f();
        SkuViewModel r107 = r100.f43195f;
        if (r107 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L37:
        if (r105 > r107.getLowerLimit()) goto L39;
        int r108 = R.drawable.shopping_sku_count_minus_disable;
    L40:
        r106.setImageResource(r108);
        ImageView r109 = (ImageView) r100.Z().b(R.id.iv_sku_select_plus).f();
        SkuViewModel r110 = r100.f43195f;
        if (r110 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L44:
        if (r105 < r110.getUpperLimit()) goto L46;
        int r111 = R.drawable.shopping_sku_count_plus_disable;
    L47:
        r109.setImageResource(r111);
        SkuViewModel r112 = r100.f43195f;
        if (r112 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L51:
        if (r105 == r112.getCurrentCount()) goto L60;
        SkuViewModel r113 = r100.f43195f;
        if (r113 != null) goto L55;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L55:
        r113.setClickCountUnConsumed(true);
        SkuViewModel r114 = r100.f43195f;
        if (r114 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L58:
        r114.m8147getCurrentCount().g(Long.valueOf(r105));
        return;
    L60:
        return;
    L46:
        r111 = R.drawable.shopping_sku_count_plus;
        goto L47
    L39:
        r108 = R.drawable.shopping_sku_count_minus;
        goto L40
    L14:
        SkuViewModel r115 = r100.f43195f;
        if (r115 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L17:
        long r116 = r115.getCurrentCount();
        SkuViewModel r117 = r100.f43195f;
        if (r117 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L21:
        if (r116 <= r117.getUpperLimit()) goto L29;
        SkuViewModel r118 = r100.f43195f;
        if (r118 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L25:
        long r119 = r118.getLowerLimit();
        SkuViewModel r120 = r100.f43195f;
        if (r120 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L28:
        r105 = RangesKt.coerceAtLeast(r119, r120.getUpperLimit());
        goto L33
    L29:
        SkuViewModel r121 = r100.f43195f;
        if (r121 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L32:
        r105 = r121.getCurrentCount();
        goto L33
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter
    public final void b0(QModel r100) {
        this.f43195f = (SkuViewModel) Y().g(SkuViewModel.class);
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
        SkuViewModel r105 = this.f43195f;
        if (r105 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        r105.m8147getCurrentCount().b(ECQuickUtilKt.a(Y()), new y(this));
        SkuViewModel r106 = this.f43195f;
        if (r106 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L8:
        r106.m8151getUpperLimit().b(ECQuickUtilKt.a(Y()), new z(this));
        SkuViewModel r107 = this.f43195f;
        if (r107 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L11:
        r107.m8149getLowerLimit().b(ECQuickUtilKt.a(Y()), new a0(this));
        SkuViewModel r108 = this.f43195f;
        if (r108 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L14:
        r108.getLimitText().b(ECQuickUtilKt.a(Y()), new b0(this));
        SkuViewModel r109 = this.f43195f;
        if (r109 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L17:
        r109.getStockDesc().b(ECQuickUtilKt.a(Y()), new c0(this));
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r210) {
        if (r210 != null) goto L5;
        return;
    L5:
        int r100 = r210.getId();
        if (r100 != R.id.iv_sku_select_plus) goto L86;
        SkuViewModel r101 = this.f43195f;
        if (r101 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L10:
        long r102 = r101.getCurrentCount();
        SkuViewModel r103 = this.f43195f;
        if (r103 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L14:
        if (r102 >= r103.getUpperLimit()) goto L54;
        SkuViewModel r104 = this.f43195f;
        if (r104 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L18:
        r104.setClickCountUnConsumed(true);
        SkuViewModel r105 = this.f43195f;
        if (r105 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L21:
        QLiveData<Long> r106 = r105.m8147getCurrentCount();
        SkuViewModel r107 = this.f43195f;
        if (r107 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L24:
        r106.g(Long.valueOf(r107.getCurrentCount() + 1));
        SkuViewModel r108 = this.f43195f;
        if (r108 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L27:
        SkuInfoVO r109 = r108.getSkuInfo().a();
        if (r109 == null) goto L30;
        Boolean r110 = r109.getHasGivenProduct();
    L32:
        if (Intrinsics.areEqual(r110, Boolean.TRUE) == false) goto L52;
        SkuViewModel r111 = this.f43195f;
        if (r111 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L36:
        Long r112 = r111.m8147getCurrentCount().a();
        if (r112 == null) goto L39;
        Integer r113 = Integer.valueOf((int) r112.longValue());
    L40:
        SkuViewModel r114 = this.f43195f;
        if (r114 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L43:
        SkuInfoVO r115 = r114.getSkuInfo().a();
        if (r115 == null) goto L48;
        Integer r116 = r115.getGivenProductStock();
        if (r116 == null) goto L48;
        Integer r117 = Integer.valueOf(r116.intValue() + 1);
    L50:
        if (Intrinsics.areEqual(r113, r117) == false) goto L52;
        String r118 = th.a.g(Y().c(), R.string.shopping_sku_not_enough_given_product);
        UIUtils.displayToast(Y().c(), r118);
    L53:
        int r119 = 1;
    L78:
        SkuViewModel r120 = this.f43195f;
        if (r120 != null) goto L81;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L81:
        Pair[] r121 = new Pair[4];
        r121[0] = TuplesKt.to("module_name", "spec_num_plus");
        r121[1] = TuplesKt.to("toast_content", r118);
        r121[2] = TuplesKt.to("is_success", String.valueOf(r119));
        SkuViewModel r122 = this.f43195f;
        if (r122 != null) goto L84;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L84:
        r121[3] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_COMBO_ID, r122.getComboId());
        SkuViewModel.doSkuEventAction$default(r120, "sku_panel_module_click", r121, null, null, null, 28, null);
        return;
    L48:
        r117 = null;
        goto L50
    L39:
        r113 = null;
    L52:
        r118 = null;
        goto L53
    L30:
        r110 = null;
        goto L32
    L54:
        SkuViewModel r123 = this.f43195f;
        if (r123 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L57:
        SkuLimit r124 = r123.m8151getUpperLimit().a();
        if (r124 == null) goto L63;
        String r125 = r124.getToast();
        if (r125 == null) goto L63;
    L62:
        r118 = r125;
        SkuViewModel r126 = this.f43195f;
        if (r126 != null) goto L71;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L71:
        if (r126.getSkuParams().isFromAnchorV3() == false) goto L73;
        String r127 = com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_DETAIL;
    L74:
        SkuViewModel r128 = this.f43195f;
        if (r128 != null) goto L77;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L77:
        SkuViewModel.doSkuEventAction$default(r128, "livesdk_toast_show", new Pair[]{TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_EVENT_ORIGIN_FEATURE, com.bytedance.android.ec.core.event.a.VALUE_TEMAI), TuplesKt.to("page_name", r127)}, null, null, null, 28, null);
        UIUtils.displayToast(Y().c(), r118);
        r119 = 0;
        goto L78
    L73:
        r127 = "live_room_sku";
    L63:
        Context r129 = Y().c();
        Object[] r130 = new Object[1];
        SkuViewModel r131 = this.f43195f;
        if (r131 != null) goto L66;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L66:
        r130[0] = Long.valueOf(r131.getUpperLimit());
        r125 = th.a.h(r129, R.string.shopping_sku_buy_maximum, r130);
        goto L62
    L86:
        if (r100 != R.id.iv_sku_select_minus) goto L134;
        SkuViewModel r132 = this.f43195f;
        if (r132 != null) goto L90;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L90:
        long r133 = r132.getCurrentCount();
        SkuViewModel r134 = this.f43195f;
        if (r134 != null) goto L94;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L94:
        if (r133 <= r134.getLowerLimit()) goto L105;
        SkuViewModel r135 = this.f43195f;
        if (r135 != null) goto L98;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L98:
        r135.setClickCountUnConsumed(true);
        SkuViewModel r136 = this.f43195f;
        if (r136 != null) goto L101;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L101:
        QLiveData<Long> r137 = r136.m8147getCurrentCount();
        SkuViewModel r138 = this.f43195f;
        if (r138 != null) goto L104;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L104:
        r137.g(Long.valueOf(r138.getCurrentCount() - 1));
        int r139 = 1;
        String r140 = null;
    L125:
        SkuViewModel r141 = this.f43195f;
        if (r141 != null) goto L128;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L128:
        Pair[] r142 = new Pair[4];
        r142[0] = TuplesKt.to("module_name", "spec_num_minus");
        r142[1] = TuplesKt.to("toast_content", r140);
        r142[2] = TuplesKt.to("is_success", String.valueOf(r139));
        SkuViewModel r143 = this.f43195f;
        if (r143 != null) goto L131;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L131:
        r142[3] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_COMBO_ID, r143.getComboId());
        SkuViewModel.doSkuEventAction$default(r141, "sku_panel_module_click", r142, null, null, null, 28, null);
        return;
    L105:
        SkuViewModel r144 = this.f43195f;
        if (r144 != null) goto L108;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L108:
        SkuLimit r145 = r144.m8149getLowerLimit().a();
        if (r145 == null) goto L114;
        String r146 = r145.getToast();
        if (r146 == null) goto L114;
    L113:
        r140 = r146;
        UIUtils.displayToast(Y().c(), r140);
        r139 = 0;
    L114:
        SkuViewModel r147 = this.f43195f;
        if (r147 != null) goto L118;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L118:
        if (r147.getLowerLimit() != 0) goto L120;
        r146 = Y().c().getString(R.string.shopping_sku_no_stock);
        goto L113
    L120:
        Context r148 = Y().c();
        Object[] r149 = new Object[1];
        SkuViewModel r150 = this.f43195f;
        if (r150 != null) goto L123;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L123:
        r149[0] = Long.valueOf(r150.getLowerLimit());
        r146 = th.a.h(r148, R.string.shopping_sku_buy_minimum, r149);
        goto L113
    }
}
