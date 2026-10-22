package com.bytedance.android.ec.common.impl.sku.presenter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.common.impl.sku.SkuViewModel;
import com.bytedance.android.ec.common.impl.sku.model.SkuDiscountInfo;
import com.bytedance.android.ec.common.impl.sku.model.SkuInfoVO;
import com.bytedance.android.ec.common.impl.sku.model.SkuInstallmentItemInfo;
import com.bytedance.android.ec.common.impl.sku.model.SkuTermInfo;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.model.response.ECPromotion;
import com.bytedance.android.ec.model.response.ProductSelectPoiInfo;
import com.bytedance.android.ec.model.sku.DisplayConfig;
import com.bytedance.android.ec.model.sku.SkuPoiInfo;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class w2 extends QFragmentPresenter {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public SkuViewModel f43308f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextView f43309g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f43310h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TextView f43311i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f43312j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f43313k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public View f43314l;

    public static final class a extends com.bytedance.android.ec.core.widget.d {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ w2 f43315g;

        public a(w2 r100) {
            this.f43315g = r100;
            super(null, null, 3);
        }

        @Override // com.bytedance.android.ec.core.widget.d
        public final void a(View r110) {
            Intrinsics.checkNotNullParameter(r110, BaseSwitches.V);
            w2 r100 = this.f43315g;
            String r101 = r100.f43313k;
            if (r101 == null) goto L22;
            int r102 = jg.e.f498944a;
            int r103 = com.bytedance.android.ec.core.utils.g0.f45598a;
            View r104 = r100.f43314l;
            if (r104 == null) goto L7;
            Context r105 = r104.getContext();
        L9:
            if (com.bytedance.android.ec.core.utils.g0.a(r105) == false) goto L11;
            String r106 = "1";
        L12:
            String r107 = jg.e.b(r101, "gpsOn", r106);
            String r108 = this.f43315g.f43312j;
            if (r108 != null) goto L15;
            r108 = "";
        L15:
            jg.e.b(r107, "selectedShopId", r108);
            Unit r109 = Unit.INSTANCE;
            Activity r111 = jg.h.f498946a.getActivity(r110.getContext());
            if (r111 == null) goto L18;
            com.bytedance.android.ec.core.hybrid.utils.r.a(r107, r111);
        L18:
            SkuViewModel r112 = this.f43315g.f43308f;
            if (r112 != null) goto L21;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        L21:
            SkuViewModel.doSkuEventAction$default(r112, "click_offline_store_entrance", new Pair[]{TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_LOCATION, ECPromotion.SKU)}, null, null, null, 28, null);
            goto L22
        L11:
            r106 = "0";
            goto L12
        L7:
            r105 = null;
        L22:
            SkuViewModel r113 = this.f43315g.f43308f;
            if (r113 != null) goto L25;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        L25:
            SkuViewModel.doSkuEventAction$default(r113, "sku_panel_module_click", new Pair[]{TuplesKt.to("module_name", "shop_choose")}, null, null, null, 28, null);
        }
    }

    public w2(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        super(r100);
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter
    public final void b0(QModel r110) {
        SkuViewModel r111 = (SkuViewModel) Y().g(SkuViewModel.class);
        this.f43308f = r111;
        if (r111 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L6:
        if (r111.getSkuParams().isFromInsuranceApply() == false) goto L9;
        Y().d().q(dg.s.class, 8);
        return;
    L9:
        SkuViewModel r100 = this.f43308f;
        if (r100 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L12:
        SkuViewModel.doSkuEventAction$default(r100, "sku_panel_module_show", new Pair[]{TuplesKt.to("module_name", "shop_choose")}, null, null, null, 28, null);
        this.f43309g = (TextView) Z().b(R.id.common_sku_tv_shop_name).f();
        this.f43311i = (TextView) Z().b(R.id.common_sku_tv_shop_address).f();
        this.f43314l = Z().b(R.id.common_sku_shop_info_container).f();
        this.f43310h = Z().b(R.id.common_sku_poi_divider).f();
        a r112 = new a(this);
        View r101 = this.f43314l;
        if (r101 == null) goto L15;
        r101.setOnClickListener(r112);
    L15:
        ProductSelectPoiInfo r113 = com.bytedance.android.ec.core.utils.d1.f45575a;
        SkuPoiInfo r102 = null;
        Long r103 = null;
        r103 = null;
        if (r113 != null) goto L21;
        SkuPoiInfo r114 = com.bytedance.android.ec.core.utils.d1.f45576b;
        if (r114 == null) goto L20;
        r113 = r114.getSelectedPoiInfo();
        goto L21
    L20:
        r113 = null;
    L21:
        if (r113 == null) goto L39;
        SkuViewModel r104 = this.f43308f;
        if (r104 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L25:
        SkuInfoVO r105 = r104.getSkuInfo().a();
        if (r105 == null) goto L30;
        SkuPoiInfo r106 = r105.getPoiInfo();
        if (r106 == null) goto L30;
        r106.setSelectedPoiInfo(r113);
    L30:
        SkuPoiInfo r107 = new SkuPoiInfo();
        SkuViewModel r108 = this.f43308f;
        if (r108 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L33:
        SkuInfoVO r109 = r108.getSkuInfo().a();
        if (r109 == null) goto L38;
        SkuPoiInfo r115 = r109.getPoiInfo();
        if (r115 == null) goto L38;
        r103 = r115.getTotal();
    L38:
        r107.setTotal(r103);
        r107.setSelectedPoiInfo(r113);
        Unit r116 = Unit.INSTANCE;
        e0(r107);
    L46:
        SkuViewModel r117 = this.f43308f;
        if (r117 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L49:
        r117.getSelectPoiInfo().b(Y().e(), new u2(this));
        SkuViewModel r118 = this.f43308f;
        if (r118 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L52:
        r118.getSkuInfo().b(ECQuickUtilKt.a(Y()), new v2(this));
        return;
    L39:
        SkuViewModel r119 = this.f43308f;
        if (r119 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L42:
        SkuInfoVO r120 = r119.getSkuInfo().a();
        if (r120 == null) goto L45;
        r102 = r120.getPoiInfo();
    L45:
        e0(r102);
        goto L46
    }

    public final void d0(ProductSelectPoiInfo r110) {
        SkuViewModel r100 = this.f43308f;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        SkuViewModel.doSkuEventAction$default(r100, "show_offline_store_entrance", new Pair[]{TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_LOCATION, ECPromotion.SKU)}, null, null, null, 28, null);
        SkuInstallmentItemInfo r101 = null;
        if (r110 == null) goto L8;
        String r102 = r110.getPoiId();
    L9:
        this.f43312j = r102;
        Z().b(R.id.common_sku_shop_info_root).f().setVisibility(0);
        if (r110 != null) goto L12;
    L41:
        TextView r111 = this.f43309g;
        if (r111 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("tvShopName");
    L44:
        r111.setVisibility(0);
        TextView r112 = this.f43311i;
        if (r112 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("tvShopAddress");
    L47:
        r112.setVisibility(8);
        TextView r113 = this.f43309g;
        if (r113 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("tvShopName");
    L50:
        TextView r103 = this.f43309g;
        if (r103 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("tvShopName");
    L53:
        r113.setTextColor(th.a.f(r103.getContext()).getColor(R.color.ec_color_fffe3824));
        int r114 = com.bytedance.android.ec.core.utils.g0.f45598a;
        TextView r115 = this.f43309g;
        if (r115 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("tvShopName");
    L57:
        if (com.bytedance.android.ec.core.utils.g0.a(r115.getContext()) == true) goto L65;
        TextView r116 = this.f43309g;
        if (r116 != null) goto L61;
        Intrinsics.throwUninitializedPropertyAccessException("tvShopName");
    L61:
        TextView r104 = this.f43309g;
        if (r104 != null) goto L64;
        Intrinsics.throwUninitializedPropertyAccessException("tvShopName");
    L64:
        r116.setText(th.a.f(r104.getContext()).getString(R.string.shopping_sku_gps_not_available_opt));
    L72:
        SkuViewModel r117 = this.f43308f;
        if (r117 != null) goto L75;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L75:
        SkuInfoVO r118 = r117.getSkuInfo().a();
        if (r118 == null) goto L78;
        r101 = r118.getInstallmentInfo();
    L78:
        h0(r101);
        return;
    L65:
        TextView r119 = this.f43309g;
        if (r119 != null) goto L68;
        Intrinsics.throwUninitializedPropertyAccessException("tvShopName");
    L68:
        TextView r105 = this.f43309g;
        if (r105 != null) goto L71;
        Intrinsics.throwUninitializedPropertyAccessException("tvShopName");
    L71:
        r119.setText(th.a.f(r105.getContext()).getString(R.string.shopping_sku_no_poi_info_opt));
        goto L72
    L12:
        if (com.bytedance.android.ec.core.utils.a2.b(r110.getPoiName()) == true) goto L15;
        r110 = null;
    L15:
        if (r110 == null) goto L41;
        String r106 = "已选：" + r110.getPoiName();
        TextView r107 = this.f43309g;
        if (r107 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("tvShopName");
    L19:
        r107.setText(r106);
        TextView r108 = this.f43309g;
        if (r108 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("tvShopName");
    L22:
        r108.setVisibility(0);
        TextView r109 = this.f43309g;
        if (r109 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("tvShopName");
    L25:
        TextView r120 = this.f43309g;
        if (r120 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("tvShopName");
    L28:
        r109.setTextColor(th.a.f(r120.getContext()).getColor(R.color.ec_color_99161823));
        if (com.bytedance.android.ec.core.utils.a2.b(r110.getAddress()) == false) goto L37;
        TextView r121 = this.f43311i;
        if (r121 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("tvShopAddress");
    L33:
        r121.setText(r110.getAddress());
        TextView r122 = this.f43311i;
        if (r122 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("tvShopAddress");
    L36:
        r122.setVisibility(0);
        goto L72
    L37:
        TextView r123 = this.f43311i;
        if (r123 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("tvShopAddress");
    L40:
        r123.setVisibility(8);
        goto L72
    L8:
        r102 = null;
        goto L9
    }

    public final void e0(SkuPoiInfo r100) {
        String r101 = null;
        if (r100 == null) goto L5;
        Long r102 = r100.getTotal();
    L6:
        SkuViewModel r103 = this.f43308f;
        if (r103 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L9:
        SkuInfoVO r104 = r103.getSkuInfo().a();
        if (r104 == null) goto L14;
        SkuPoiInfo r105 = r104.getPoiInfo();
        if (r105 == null) goto L14;
        r101 = r105.getNavLink();
    L14:
        this.f43313k = r101;
        if (r102 != null) goto L17;
    L20:
        Z().b(R.id.common_sku_shop_info_root).f().setVisibility(8);
        return;
    L17:
        if (r102.longValue() <= 0) goto L20;
        d0(r100.getSelectedPoiInfo());
        return;
    L5:
        r102 = null;
        goto L6
    }

    public final void h0(SkuInstallmentItemInfo r100) {
        SkuViewModel r101 = this.f43308f;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        SkuInfoVO r102 = r101.getSkuInfo().a();
        SkuDiscountInfo r103 = null;
        if (r102 == null) goto L10;
        DisplayConfig r104 = r102.getDisplayConfig();
        if (r104 == null) goto L10;
        Boolean r105 = r104.getShowDouInstallment();
    L11:
        int r106 = 0;
        if (Intrinsics.areEqual(r105, Boolean.TRUE) == false) goto L21;
        if (r100 == null) goto L15;
        SkuTermInfo r107 = r100.getTermInfo();
    L16:
        if (r107 != null) goto L20;
        if (r100 == null) goto L19;
        r103 = r100.getDiscountInfo();
    L19:
        if (r103 == null) goto L21;
    L20:
        boolean r108 = true;
    L22:
        if (r108 == true) goto L25;
        r106 = 8;
    L25:
        View r109 = this.f43310h;
        if (r109 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("divierView");
    L29:
        if (r109.getVisibility() == r106) goto L35;
        View r110 = this.f43310h;
        if (r110 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("divierView");
    L33:
        r110.setVisibility(r106);
        return;
    L35:
        return;
    L15:
        r107 = null;
    L21:
        r108 = false;
    L10:
        r105 = null;
        goto L11
    }
}
