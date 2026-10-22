package com.bytedance.android.ec.common.impl.sku.presenter;

import android.content.Context;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.common.impl.sku.SkuViewModel;
import com.bytedance.android.ec.common.impl.sku.model.SkuBannerStruct;
import com.bytedance.android.ec.common.impl.sku.model.SkuInfoVO;
import com.bytedance.android.ec.common.impl.sku.model.SkuItemInfoVO;
import com.bytedance.android.ec.common.impl.sku.model.SkuLimit;
import com.bytedance.android.ec.common.impl.sku.model.SpecInfo;
import com.bytedance.android.ec.common.impl.sku.model.SpecInfoItem;
import com.bytedance.android.ec.common.impl.sku.view.SpecItemOptimizeGroupLayout;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.model.ProductPriceInfo;
import com.bytedance.android.ec.model.PromotionBenefitLabel;
import com.bytedance.android.ec.model.PromotionDiscountPrice;
import com.bytedance.android.ec.model.sku.CarAdaptComponent;
import com.bytedance.android.ec.model.sku.SkuProductDetailInfo;
import com.bytedance.android.ec.model.sku.SkuRestoreState;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class b2 extends QFragmentPresenter {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public SkuViewModel f43178f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public LinearLayout f43179g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public SpecItemOptimizeGroupLayout f43180h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f43181i;

    public static final class a implements SpecItemOptimizeGroupLayout.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b2 f43182a;

        @Override // com.bytedance.android.ec.common.impl.sku.view.SpecItemOptimizeGroupLayout.d
        public final void b() {
            cg.h r100 = b2.e0(this.f43182a).getSpecTitleEntryEventStruct();
            SkuViewModel r101 = b2.e0(this.f43182a);
            Pair[] r102 = new Pair[4];
            if (b2.e0(this.f43182a).getSkuParams().isFromAnchorV3() == false) goto L5;
            String r103 = com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_DETAIL;
        L6:
            r102[0] = TuplesKt.to("page_name", r103);
            r102[1] = TuplesKt.to("is_product_recommand", String.valueOf(r100.f23580b));
            r102[2] = TuplesKt.to("is_user_input", String.valueOf(r100.f23581c));
            r102[3] = TuplesKt.to("is_size_recommand", String.valueOf(r100.f23582d));
            SkuViewModel.doSkuEventAction$default(r101, "pd_size_chart_tab_click", r102, null, null, null, 28, null);
            return;
        L5:
            r103 = "live_room_sku";
            goto L6
        }

        public a(b2 r100) {
            this.f43182a = r100;
        }

        @Override // com.bytedance.android.ec.common.impl.sku.view.SpecItemOptimizeGroupLayout.d
        public final void a(int r110) {
            String r100 = "1";
            if (b2.e0(this.f43182a).isSizeTabExist() == false) goto L5;
            Object r101 = "1";
        L6:
            SkuInfoVO r102 = b2.e0(this.f43182a).getSkuInfo().a();
            if (r102 == null) goto L9;
            SkuBannerStruct r103 = r102.getSkuBanner();
        L10:
            if (r103 != null) goto L13;
            r100 = "0";
        L13:
            SkuViewModel r104 = b2.e0(this.f43182a);
            Pair[] r105 = new Pair[5];
            r105[0] = TuplesKt.to("previous_page", b2.e0(this.f43182a).getPreviousPage());
            r105[1] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_IS_EXIST_SIZE_TAB, r101);
            r105[2] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_THREE_D, b2.e0(this.f43182a).getSkuParams().getEventParams().get(com.bytedance.android.ec.core.event.a.KEY_THREE_D));
            r105[3] = TuplesKt.to("with_comment", r100);
            if (b2.e0(this.f43182a).isPresaleSkuSpec(r110) == false) goto L16;
            String r111 = "true";
        L17:
            r105[4] = TuplesKt.to("with_presell_sku", r111);
            SkuViewModel.doSkuEventAction$default(r104, "params_sku_click", r105, null, null, null, 28, null);
            return;
        L16:
            r111 = "false";
            goto L17
        L9:
            r103 = null;
            goto L10
        L5:
            r101 = "0";
            goto L6
        }
    }

    public static final class b implements SpecItemOptimizeGroupLayout.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b2 f43183a;

        public b(b2 r100) {
            this.f43183a = r100;
        }

        @Override // com.bytedance.android.ec.common.impl.sku.view.SpecItemOptimizeGroupLayout.b
        public final void a(String[] r210, boolean r211) {
            Intrinsics.checkNotNullParameter(r210, "checkIdArray");
            b2.h0(this.f43183a, r211);
            SkuRestoreState r100 = b2.e0(this.f43183a).getSkuPanelState();
            if (r100 == null) goto L5;
            r100.setSelectSkuKeys(r210);
        L5:
            b2.e0(this.f43183a).notifySkuChanged();
            Function1<SkuProductDetailInfo, Unit> r101 = b2.e0(this.f43183a).getRefreshDetailInfoCallback();
            if (r101 == null) goto L16;
            String r102 = b2.d0(this.f43183a).getCheckSkuImageUrl();
            Long r110 = b2.d0(this.f43183a).getCheckSkuPrice();
            Long r111 = b2.d0(this.f43183a).getCheckSkuOriginPrice();
            Long r103 = b2.d0(this.f43183a).getCheckSkuDiscountPrice();
            if (r103 == null) goto L10;
            long r104 = r103.longValue();
        L11:
            Long r212 = Long.valueOf(r104);
            String r105 = b2.d0(this.f43183a).getCheckSkuDiscountPriceText();
            if (r105 != null) goto L14;
            String r213 = "";
        L15:
            Unit r106 = r101.invoke(new SkuProductDetailInfo(r102, new ProductPriceInfo(r110, r111, new PromotionDiscountPrice(r212, null, r213, null, 10, null), null, null, 24, null), b2.d0(this.f43183a).getSelectEPInfo(), this.f43183a.f43181i, false, (String[]) Arrays.copyOf(r210, r210.length), false, 64, null));
            goto L16
        L14:
            r213 = r105;
            goto L15
        L10:
            r104 = 0;
        L16:
            SkuViewModel r107 = b2.e0(this.f43183a);
            Long r108 = b2.e0(this.f43183a).m8148getCurrentPrice().a();
            if (r108 == null) goto L19;
            long r109 = r108.longValue();
        L20:
            int r112 = 0;
            if (r109 <= 0) goto L23;
            boolean r113 = true;
        L24:
            r107.setHasRefreshDetailInfo(r113);
            JSONArray r114 = new JSONArray();
            int r115 = r210.length;
        L25:
            if (r112 >= r115) goto L30;
            String r116 = r210[r112];
            if (r116 != null) goto L29;
            r116 = "";
        L29:
            r114.put(r116);
            r112 = r112 + 1;
            goto L25
        L30:
            JSONObject r117 = new JSONObject();
            r117.put("sku_session_id", b2.e0(this.f43183a).getSkuParams().getSkuSessionId());
            r117.put("combo_num", b2.e0(this.f43183a).m8147getCurrentCount().a());
            r117.put("select_spec_ids", r114);
            ECLiveHybridUtil.f("ecom.sku.spec.change", r117);
            SkuRestoreState r118 = b2.e0(this.f43183a).getSkuPanelState();
            if (r118 == null) goto L37;
            r118.setSelectSkuKeys(r210);
            return;
        L37:
            return;
        L23:
            r113 = false;
            goto L24
        L19:
            r109 = 0;
            goto L20
        }
    }

    public final void i0() {
        SpecItemOptimizeGroupLayout r100 = this.f43180h;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L5:
        String r101 = r100.getCheckedId();
        SkuViewModel r102 = this.f43178f;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L8:
        SkuInfoVO r103 = r102.getSkuInfo().a();
        if (r103 == null) goto L17;
        Map<String, SkuItemInfoVO> r104 = r103.getSkuList();
        if (r104 == null) goto L17;
        SkuItemInfoVO r105 = r104.get(r101);
        if (r105 == null) goto L17;
        Map<String, String> r106 = r105.getShowEventTrack();
        if (r106 == null) goto L17;
    L20:
        Map<String, String> r107 = r106;
        SkuViewModel r108 = this.f43178f;
        if (r108 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L23:
        SkuViewModel.doSkuEventAction$default(r108, "sku_panel_module_show", new Pair[]{TuplesKt.to("module_name", "price")}, null, null, r107, 12, null);
        return;
    L17:
        if (r103 == null) goto L19;
        r106 = r103.getShowTrackParams();
        goto L20
    L19:
        r106 = null;
        goto L20
    }

    public final void k0() {
        SkuViewModel r100 = this.f43178f;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        SkuRestoreState r101 = r100.getSkuPanelState();
        if (r101 == null) goto L46;
        SpecItemOptimizeGroupLayout r102 = this.f43180h;
        if (r102 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L10:
        String[] r103 = r102.getCheckedIdArray();
        SkuViewModel r104 = this.f43178f;
        if (r104 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L13:
        Long r105 = Long.valueOf(r104.getCurrentCount());
        SkuViewModel r106 = this.f43178f;
        if (r106 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L16:
        String r107 = r106.getSelectedSkuId();
        SkuViewModel r108 = this.f43178f;
        if (r108 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L19:
        String r109 = r108.getCheckedNames().a();
        SkuViewModel r110 = this.f43178f;
        if (r110 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L22:
        String r111 = r110.getCurrentAvatar().a();
        if (r111 == null) goto L28;
        String r112 = com.bytedance.android.ec.core.utils.a2.d(r111);
        if (r112 == null) goto L28;
    L27:
        String r113 = r112;
        SkuViewModel r114 = this.f43178f;
        if (r114 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L38:
        Boolean r115 = r114.getCanAddCart();
        SkuViewModel r116 = this.f43178f;
        if (r116 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L41:
        SkuLimit r117 = r116.m8149getLowerLimit().a();
        if (r117 == null) goto L44;
        int r118 = (int) r117.getCount();
    L45:
        r101.saveSelectedSpec(r103, r105, r107, r109, r113, r115, r118);
        goto L46
    L44:
        r118 = 1;
    L28:
        SkuViewModel r119 = this.f43178f;
        if (r119 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L31:
        SkuInfoVO r120 = r119.getSkuInfo().a();
        if (r120 == null) goto L34;
        r112 = r120.getCover();
        goto L27
    L34:
        r112 = null;
    L46:
        SkuViewModel r121 = this.f43178f;
        if (r121 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L49:
        r121.saveAddCartGuideInfo();
    }

    public final void l0() {
        SkuViewModel r100 = this.f43178f;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        String r101 = r100.getUnCheckedName().a();
        boolean r102 = false;
        if (r101 != null) goto L8;
    L11:
        boolean r103 = true;
    L13:
        if (r103 == false) goto L21;
        SkuViewModel r104 = this.f43178f;
        if (r104 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L17:
        QLiveData<String> r105 = r104.getLimitText();
        SpecItemOptimizeGroupLayout r106 = this.f43180h;
        if (r106 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L20:
        r105.g(r106.getLimitText());
        return;
    L21:
        SpecItemOptimizeGroupLayout r107 = this.f43180h;
        if (r107 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L25:
        if (r107.getLimitText().length() != 0) goto L27;
        r102 = true;
    L27:
        if (r102 == false) goto L36;
        SkuViewModel r108 = this.f43178f;
        if (r108 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L31:
        SkuInfoVO r109 = r108.getSkuInfo().a();
        if (r109 == null) goto L35;
        String r110 = r109.getLimitText();
        if (r110 == null) goto L35;
    L40:
        SkuViewModel r111 = this.f43178f;
        if (r111 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L43:
        r111.getLimitText().g(r110);
        return;
    L35:
        r110 = "";
        goto L40
    L36:
        SpecItemOptimizeGroupLayout r112 = this.f43180h;
        if (r112 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L39:
        r110 = r112.getLimitText();
        goto L40
    L8:
        if (r101.length() == 0) goto L11;
        r103 = false;
        goto L13
    }

    public final void j0() {
        this.f43179g = (LinearLayout) Z().b(R.id.ll_sku_box).f();
        Context r100 = Y().c();
        SkuViewModel r101 = this.f43178f;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        SpecItemOptimizeGroupLayout r102 = new SpecItemOptimizeGroupLayout(r100, r101.getSkuStockDataOptimize());
        this.f43180h = r102;
        r102.setSpecGroupLogEventLogger(new a(this));
        SpecItemOptimizeGroupLayout r103 = this.f43180h;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L8:
        r103.setCheckedChangeListener(new b(this));
        LinearLayout r104 = this.f43179g;
        if (r104 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("skuBox");
    L11:
        r104.removeAllViews();
        LinearLayout r105 = this.f43179g;
        if (r105 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("skuBox");
    L14:
        SpecItemOptimizeGroupLayout r106 = this.f43180h;
        if (r106 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L17:
        r105.addView(r106);
    }

    public final void m0() {
        if (com.bytedance.android.ec.core.abtest.d.E() == false) goto L47;
        boolean r100 = true;
        SkuLimit r101 = new SkuLimit(Long.MAX_VALUE, th.a.h(Y().c(), R.string.shopping_sku_buy_maximum, new Object[]{Long.MAX_VALUE}));
        SkuViewModel r102 = this.f43178f;
        if (r102 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L7:
        String r103 = r102.getUnCheckedName().a();
        if (r103 != null) goto L10;
    L13:
        if (r100 == false) goto L25;
        SkuViewModel r104 = this.f43178f;
        if (r104 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L17:
        QLiveData<SkuLimit> r105 = r104.m8151getUpperLimit();
        SpecItemOptimizeGroupLayout r106 = this.f43180h;
        if (r106 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L20:
        SkuLimit r107 = r106.getCheckSkuMaxPurchaseCount();
        if (r107 == null) goto L24;
        r101 = r107;
    L24:
        r105.g(r101);
        return;
    L25:
        SpecItemOptimizeGroupLayout r108 = this.f43180h;
        if (r108 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L29:
        if (r108.getCheckSkuMaxPurchaseCount() != null) goto L39;
        SkuViewModel r109 = this.f43178f;
        if (r109 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L33:
        SkuInfoVO r110 = r109.getSkuInfo().a();
        if (r110 == null) goto L43;
        SkuLimit r111 = r110.getUpperLimit();
        if (r111 == null) goto L43;
        r101 = r111;
    L43:
        SkuViewModel r112 = this.f43178f;
        if (r112 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L46:
        r112.m8151getUpperLimit().g(r101);
        return;
    L39:
        SpecItemOptimizeGroupLayout r113 = this.f43180h;
        if (r113 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L42:
        r101 = r113.getCheckSkuMaxPurchaseCount();
        goto L43
    L10:
        if (r103.length() == 0) goto L13;
        r100 = false;
        goto L13
    L47:
        SkuViewModel r114 = this.f43178f;
        if (r114 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L50:
        QLiveData<SkuLimit> r115 = r114.m8151getUpperLimit();
        SpecItemOptimizeGroupLayout r116 = this.f43180h;
        if (r116 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L53:
        r115.g(r116.getCheckSkuMaxPurchaseCount());
    }

    public final void n0() {
        if (com.bytedance.android.ec.core.abtest.d.E() == false) goto L44;
        SkuLimit r100 = new SkuLimit(0, Y().c().getString(R.string.shopping_sku_no_stock));
        SkuViewModel r101 = this.f43178f;
        if (r101 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L7:
        String r102 = r101.getUnCheckedName().a();
        if (r102 != null) goto L10;
    L13:
        boolean r103 = true;
    L14:
        if (r103 == false) goto L22;
        SkuViewModel r104 = this.f43178f;
        if (r104 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L18:
        QLiveData<SkuLimit> r105 = r104.m8149getLowerLimit();
        SpecItemOptimizeGroupLayout r106 = this.f43180h;
        if (r106 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L21:
        r105.g(r106.getCheckSkuLeastPurchaseCount());
        return;
    L22:
        SpecItemOptimizeGroupLayout r107 = this.f43180h;
        if (r107 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L26:
        if (r107.getCheckSkuLeastPurchaseCount() != null) goto L36;
        SkuViewModel r108 = this.f43178f;
        if (r108 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L30:
        SkuInfoVO r109 = r108.getSkuInfo().a();
        if (r109 == null) goto L40;
        SkuLimit r110 = r109.getLowerLimit();
        if (r110 == null) goto L40;
        r100 = r110;
    L40:
        SkuViewModel r111 = this.f43178f;
        if (r111 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L43:
        r111.m8149getLowerLimit().g(r100);
        return;
    L36:
        SpecItemOptimizeGroupLayout r112 = this.f43180h;
        if (r112 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L39:
        r100 = r112.getCheckSkuLeastPurchaseCount();
        goto L40
    L10:
        if (r102.length() == 0) goto L13;
        r103 = false;
        goto L14
    L44:
        SkuViewModel r113 = this.f43178f;
        if (r113 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L47:
        QLiveData<SkuLimit> r114 = r113.m8149getLowerLimit();
        SpecItemOptimizeGroupLayout r115 = this.f43180h;
        if (r115 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L50:
        r114.g(r115.getCheckSkuLeastPurchaseCount());
    }

    public b2(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        super(r100);
    }

    public static final /* synthetic */ SpecItemOptimizeGroupLayout d0(b2 r100) {
        SpecItemOptimizeGroupLayout r101 = r100.f43180h;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L5:
        return r101;
    }

    public static final /* synthetic */ SkuViewModel e0(b2 r100) {
        SkuViewModel r101 = r100.f43178f;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        return r101;
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter
    public final void b0(QModel r100) {
        this.f43178f = (SkuViewModel) Y().g(SkuViewModel.class);
        j0();
        SkuViewModel r101 = this.f43178f;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        r101.getSkuInfo().b(ECQuickUtilKt.a(Y()), new u1(this));
        SkuViewModel r102 = this.f43178f;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L8:
        r102.m8147getCurrentCount().b(ECQuickUtilKt.a(Y()), new v1(this));
        SkuViewModel r103 = this.f43178f;
        if (r103 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L11:
        r103.getSaveState().b(ECQuickUtilKt.a(Y()), new w1(this));
        SkuViewModel r104 = this.f43178f;
        if (r104 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L14:
        r104.getCurrentAtmosphereStyle().b(ECQuickUtilKt.a(Y()), new x1(this));
        SkuViewModel r105 = this.f43178f;
        if (r105 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L17:
        r105.getUnCheckedName().b(ECQuickUtilKt.a(Y()), new y1(this));
        SkuViewModel r106 = this.f43178f;
        if (r106 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L20:
        r106.getHighLightUncheckSpec().b(ECQuickUtilKt.a(Y()), new z1(this));
        SkuViewModel r107 = this.f43178f;
        if (r107 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L23:
        r107.getImageSpecSelectIndex().b(ECQuickUtilKt.a(Y()), new a2(this));
    }

    public final void o0(boolean r110) {
        SpecItemOptimizeGroupLayout r100 = this.f43180h;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L5:
        Long r101 = r100.getCheckSkuPrice();
        if (r101 == null) goto L8;
        long r102 = r101.longValue();
    L9:
        String r103 = "";
        if (r102 != (-1)) goto L301;
        SkuViewModel r104 = this.f43178f;
        if (r104 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L14:
        long r105 = r104.getCurrentPriceWithDefault();
        SkuViewModel r106 = this.f43178f;
        if (r106 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L17:
        SkuInfoVO r107 = r106.getSkuInfo().a();
        Integer r111 = null;
        if (r107 == null) goto L20;
        Long r108 = Long.valueOf(r107.getMinPrice());
    L22:
        if (r105 != jg.g.b(r108, 0)) goto L47;
        SkuViewModel r109 = this.f43178f;
        if (r109 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L26:
        long r112 = r109.getCurrentOriginPrice();
        SkuViewModel r113 = this.f43178f;
        if (r113 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L29:
        SkuInfoVO r114 = r113.getSkuInfo().a();
        if (r114 == null) goto L32;
        Long r115 = Long.valueOf(r114.getMarketPrice());
    L34:
        if (r112 != jg.g.b(r115, 0)) goto L47;
        SkuViewModel r116 = this.f43178f;
        if (r116 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L38:
        long r117 = r116.getCurrentDiscountPrice();
        SkuViewModel r118 = this.f43178f;
        if (r118 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L41:
        SkuInfoVO r119 = r118.getSkuInfo().a();
        if (r119 == null) goto L44;
        Long r120 = r119.getDiscountPrice();
    L46:
        if (r117 != jg.g.b(r120, 0)) goto L47;
    L494:
        if (r110 == true) goto L497;
        i0();
        return;
    L497:
        return;
    L44:
        r120 = null;
        goto L46
    L32:
        r115 = null;
    L47:
        SkuViewModel r121 = this.f43178f;
        if (r121 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L50:
        SkuViewModel r122 = this.f43178f;
        if (r122 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L53:
        SkuInfoVO r123 = r122.getSkuInfo().a();
        if (r123 == null) goto L56;
        Long r124 = Long.valueOf(r123.getMinPrice());
    L57:
        r121.setCurrentPriceWithDefault(jg.g.b(r124, 0));
        SkuViewModel r125 = this.f43178f;
        if (r125 != null) goto L60;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L60:
        SkuViewModel r126 = this.f43178f;
        if (r126 != null) goto L63;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L63:
        SkuInfoVO r127 = r126.getSkuInfo().a();
        if (r127 == null) goto L66;
        Long r128 = Long.valueOf(r127.getMarketPrice());
    L67:
        r125.setCurrentOriginPrice(jg.g.b(r128, 0));
        SkuViewModel r129 = this.f43178f;
        if (r129 != null) goto L70;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L70:
        SkuViewModel r130 = this.f43178f;
        if (r130 != null) goto L73;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L73:
        SkuInfoVO r131 = r130.getSkuInfo().a();
        if (r131 == null) goto L76;
        Long r132 = r131.getDiscountPrice();
    L77:
        r129.setCurrentDiscountPrice(jg.g.b(r132, 0));
        SkuViewModel r133 = this.f43178f;
        if (r133 != null) goto L80;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L80:
        SpecItemOptimizeGroupLayout r134 = this.f43180h;
        if (r134 != null) goto L83;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L83:
        String r135 = r134.getCheckSkuDiscountPriceText();
        if (r135 != null) goto L86;
        r135 = "";
    L86:
        r133.setCurrentDiscountPriceText(r135);
        SkuViewModel r136 = this.f43178f;
        if (r136 != null) goto L89;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L89:
        SpecItemOptimizeGroupLayout r137 = this.f43180h;
        if (r137 != null) goto L92;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L92:
        String r138 = r137.getCheckSkuCampaignPriceHeader();
        if (r138 == null) goto L96;
        r103 = r138;
    L96:
        r136.setCurrentCampainPriceHeader(r103);
        SkuViewModel r139 = this.f43178f;
        if (r139 != null) goto L99;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L99:
        SpecItemOptimizeGroupLayout r140 = this.f43180h;
        if (r140 != null) goto L102;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L102:
        r139.setCurrentCampainPriceHeaderStyle(r140.getCheckSkuPriceHedaerStyle());
        SkuViewModel r141 = this.f43178f;
        if (r141 != null) goto L105;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L105:
        SpecItemOptimizeGroupLayout r142 = this.f43180h;
        if (r142 != null) goto L108;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L108:
        r141.setCurrentNewBonusText(r142.getNewBonusText());
        SkuViewModel r143 = this.f43178f;
        if (r143 != null) goto L111;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L111:
        SkuViewModel r144 = this.f43178f;
        if (r144 != null) goto L114;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L114:
        SkuInfoVO r145 = r144.getSkuInfo().a();
        if (r145 == null) goto L117;
        Long r146 = r145.getFirstPrice();
    L118:
        r143.setCurrentFirstPrice(r146);
        SkuViewModel r147 = this.f43178f;
        if (r147 != null) goto L121;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L121:
        SkuViewModel r148 = this.f43178f;
        if (r148 != null) goto L124;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L124:
        SkuInfoVO r149 = r148.getSkuInfo().a();
        if (r149 == null) goto L127;
        String r150 = r149.getFirstPricePrefix();
    L128:
        r147.setCurrentFirstPricePrefix(r150);
        SkuViewModel r151 = this.f43178f;
        if (r151 != null) goto L131;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L131:
        SkuViewModel r152 = this.f43178f;
        if (r152 != null) goto L134;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L134:
        SkuInfoVO r153 = r152.getSkuInfo().a();
        if (r153 == null) goto L137;
        String r154 = r153.getFirstPriceSuffix();
    L138:
        r151.setCurrentFirstPriceSuffix(r154);
        SkuViewModel r155 = this.f43178f;
        if (r155 != null) goto L141;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L141:
        SkuViewModel r156 = this.f43178f;
        if (r156 != null) goto L144;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L144:
        SkuInfoVO r157 = r156.getSkuInfo().a();
        if (r157 == null) goto L147;
        Boolean r158 = r157.getFirstPriceIsUnderline();
    L148:
        r155.setCurrentFirstPriceIsUnderline(r158);
        SkuViewModel r159 = this.f43178f;
        if (r159 != null) goto L151;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L151:
        SkuViewModel r160 = this.f43178f;
        if (r160 != null) goto L154;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L154:
        SkuInfoVO r161 = r160.getSkuInfo().a();
        if (r161 == null) goto L157;
        String r162 = r161.getFirstPriceSupplement();
    L158:
        r159.setCurrentFirstPriceSupplement(r162);
        SkuViewModel r163 = this.f43178f;
        if (r163 != null) goto L161;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L161:
        SkuViewModel r164 = this.f43178f;
        if (r164 != null) goto L164;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L164:
        SkuInfoVO r165 = r164.getSkuInfo().a();
        if (r165 == null) goto L167;
        Long r166 = r165.getSecondPrice();
    L168:
        r163.setCurrentSecondPrice(r166);
        SkuViewModel r167 = this.f43178f;
        if (r167 != null) goto L171;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L171:
        SkuViewModel r168 = this.f43178f;
        if (r168 != null) goto L174;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L174:
        SkuInfoVO r169 = r168.getSkuInfo().a();
        if (r169 == null) goto L177;
        String r170 = r169.getSecondPricePrefix();
    L178:
        r167.setCurrentSecondPricePrefix(r170);
        SkuViewModel r171 = this.f43178f;
        if (r171 != null) goto L181;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L181:
        SkuViewModel r172 = this.f43178f;
        if (r172 != null) goto L184;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L184:
        SkuInfoVO r173 = r172.getSkuInfo().a();
        if (r173 == null) goto L187;
        String r174 = r173.getSecondPriceSupplement();
    L188:
        r171.setCurrentSecondPriceSupplement(r174);
        SkuViewModel r175 = this.f43178f;
        if (r175 != null) goto L191;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L191:
        SkuViewModel r176 = this.f43178f;
        if (r176 != null) goto L194;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L194:
        SkuInfoVO r177 = r176.getSkuInfo().a();
        if (r177 == null) goto L197;
        String r178 = r177.getSecondPriceSuffix();
    L198:
        r175.setCurrentSecondPriceSuffix(r178);
        SkuViewModel r179 = this.f43178f;
        if (r179 != null) goto L201;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L201:
        SkuViewModel r180 = this.f43178f;
        if (r180 != null) goto L204;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L204:
        SkuInfoVO r181 = r180.getSkuInfo().a();
        if (r181 == null) goto L207;
        Boolean r182 = r181.getSecondPriceIsUnderline();
    L208:
        r179.setCurrentSecondPriceIsUnderline(r182);
        SkuViewModel r183 = this.f43178f;
        if (r183 != null) goto L211;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L211:
        SkuViewModel r184 = this.f43178f;
        if (r184 != null) goto L214;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L214:
        SkuInfoVO r185 = r184.getSkuInfo().a();
        if (r185 == null) goto L217;
        String r186 = r185.getRegularPriceSupplement();
    L218:
        r183.setCurrentRegularPriceSupplement(r186);
        SkuViewModel r187 = this.f43178f;
        if (r187 != null) goto L221;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L221:
        SkuViewModel r188 = this.f43178f;
        if (r188 != null) goto L224;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L224:
        SkuInfoVO r189 = r188.getSkuInfo().a();
        if (r189 == null) goto L227;
        Boolean r190 = r189.getSecondPriceIsReducePrice();
    L228:
        r187.setCurrentSecondPriceIsReducePrice(r190);
        SkuViewModel r191 = this.f43178f;
        if (r191 != null) goto L231;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L231:
        SkuViewModel r192 = this.f43178f;
        if (r192 != null) goto L234;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L234:
        SkuInfoVO r193 = r192.getSkuInfo().a();
        if (r193 == null) goto L237;
        Long r194 = r193.getRegularPrice();
    L238:
        r191.setCurrentRegularPrice(r194);
        SkuViewModel r195 = this.f43178f;
        if (r195 != null) goto L241;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L241:
        SkuViewModel r196 = this.f43178f;
        if (r196 != null) goto L244;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L244:
        SkuInfoVO r197 = r196.getSkuInfo().a();
        if (r197 == null) goto L247;
        String r198 = r197.getRegularPricePrefix();
    L248:
        r195.setCurrentRegularPricePrefix(r198);
        SkuViewModel r199 = this.f43178f;
        if (r199 != null) goto L251;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L251:
        SkuViewModel r200 = this.f43178f;
        if (r200 != null) goto L254;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L254:
        SkuInfoVO r201 = r200.getSkuInfo().a();
        if (r201 == null) goto L257;
        String r202 = r201.getRegularPriceSuffix();
    L258:
        r199.setCurrentRegularPriceSuffix(r202);
        SkuViewModel r203 = this.f43178f;
        if (r203 != null) goto L261;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L261:
        SkuViewModel r204 = this.f43178f;
        if (r204 != null) goto L264;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L264:
        SkuInfoVO r205 = r204.getSkuInfo().a();
        if (r205 == null) goto L267;
        Boolean r206 = r205.getRegularPriceIsUnderline();
    L268:
        r203.setCurrentRegularPriceIsUnderline(r206);
        SkuViewModel r207 = this.f43178f;
        if (r207 != null) goto L271;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L271:
        SkuViewModel r208 = this.f43178f;
        if (r208 != null) goto L274;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L274:
        SkuInfoVO r209 = r208.getSkuInfo().a();
        if (r209 == null) goto L277;
        Long r210 = r209.getHotMinPrice();
    L278:
        r207.setCurrentHotMinPrice(r210);
        SkuViewModel r211 = this.f43178f;
        if (r211 != null) goto L281;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L281:
        SkuViewModel r212 = this.f43178f;
        if (r212 != null) goto L284;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L284:
        SkuInfoVO r213 = r212.getSkuInfo().a();
        if (r213 == null) goto L287;
        Long r214 = r213.getHotMaxPrice();
    L288:
        r211.setCurrentHotMaxPrice(r214);
        SkuViewModel r215 = this.f43178f;
        if (r215 != null) goto L291;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L291:
        r215.m8148getCurrentPrice().g(Long.valueOf(r102));
        SkuViewModel r216 = this.f43178f;
        if (r216 != null) goto L294;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L294:
        QLiveData<Integer> r217 = r216.getCurrentAtmosphereStyle();
        SkuViewModel r218 = this.f43178f;
        if (r218 != null) goto L297;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L297:
        SkuInfoVO r219 = r218.getSkuInfo().a();
        if (r219 == null) goto L300;
        r111 = r219.getAtmosphereStyle();
    L300:
        r217.g(r111);
        goto L494
    L287:
        r214 = null;
        goto L288
    L277:
        r210 = null;
        goto L278
    L267:
        r206 = null;
        goto L268
    L257:
        r202 = null;
        goto L258
    L247:
        r198 = null;
        goto L248
    L237:
        r194 = null;
        goto L238
    L227:
        r190 = null;
        goto L228
    L217:
        r186 = null;
        goto L218
    L207:
        r182 = null;
        goto L208
    L197:
        r178 = null;
        goto L198
    L187:
        r174 = null;
        goto L188
    L177:
        r170 = null;
        goto L178
    L167:
        r166 = null;
        goto L168
    L157:
        r162 = null;
        goto L158
    L147:
        r158 = null;
        goto L148
    L137:
        r154 = null;
        goto L138
    L127:
        r150 = null;
        goto L128
    L117:
        r146 = null;
        goto L118
    L76:
        r132 = null;
        goto L77
    L66:
        r128 = null;
        goto L67
    L56:
        r124 = null;
        goto L57
    L20:
        r108 = null;
        goto L22
    L301:
        SkuViewModel r220 = this.f43178f;
        if (r220 != null) goto L304;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L304:
        Long r221 = r220.m8148getCurrentPrice().a();
        if (r221 != null) goto L308;
    L330:
        SkuViewModel r222 = this.f43178f;
        if (r222 != null) goto L333;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L333:
        r222.setCurrentPriceWithDefault(r102);
        SkuViewModel r223 = this.f43178f;
        if (r223 != null) goto L336;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L336:
        SpecItemOptimizeGroupLayout r224 = this.f43180h;
        if (r224 != null) goto L339;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L339:
        r223.setCurrentOriginPrice(jg.g.b(r224.getCheckSkuOriginPrice(), 0));
        SkuViewModel r225 = this.f43178f;
        if (r225 != null) goto L342;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L342:
        SpecItemOptimizeGroupLayout r226 = this.f43180h;
        if (r226 != null) goto L345;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L345:
        r225.setCurrentDiscountPrice(jg.g.b(r226.getCheckSkuDiscountPrice(), 0));
        SkuViewModel r227 = this.f43178f;
        if (r227 != null) goto L348;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L348:
        SpecItemOptimizeGroupLayout r228 = this.f43180h;
        if (r228 != null) goto L351;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L351:
        String r229 = r228.getCheckSkuDiscountPriceText();
        if (r229 != null) goto L354;
        r229 = "";
    L354:
        r227.setCurrentDiscountPriceText(r229);
        SkuViewModel r230 = this.f43178f;
        if (r230 != null) goto L357;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L357:
        SpecItemOptimizeGroupLayout r231 = this.f43180h;
        if (r231 != null) goto L360;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L360:
        String r232 = r231.getCheckSkuCampaignPriceHeader();
        if (r232 == null) goto L364;
        r103 = r232;
    L364:
        r230.setCurrentCampainPriceHeader(r103);
        SkuViewModel r233 = this.f43178f;
        if (r233 != null) goto L367;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L367:
        SpecItemOptimizeGroupLayout r234 = this.f43180h;
        if (r234 != null) goto L370;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L370:
        r233.setCurrentCampainPriceHeaderStyle(r234.getCheckSkuPriceHedaerStyle());
        SkuViewModel r235 = this.f43178f;
        if (r235 != null) goto L373;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L373:
        SpecItemOptimizeGroupLayout r236 = this.f43180h;
        if (r236 != null) goto L376;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L376:
        r235.setCurrentNewBonusText(r236.getNewBonusText());
        SkuViewModel r237 = this.f43178f;
        if (r237 != null) goto L379;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L379:
        SpecItemOptimizeGroupLayout r238 = this.f43180h;
        if (r238 != null) goto L382;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L382:
        r237.setCurrentFirstPrice(r238.getCheckSkuFirstPrice());
        SkuViewModel r239 = this.f43178f;
        if (r239 != null) goto L385;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L385:
        SpecItemOptimizeGroupLayout r240 = this.f43180h;
        if (r240 != null) goto L388;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L388:
        r239.setCurrentFirstPricePrefix(r240.getCheckSkuFirstPricePrefix());
        SkuViewModel r241 = this.f43178f;
        if (r241 != null) goto L391;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L391:
        SpecItemOptimizeGroupLayout r242 = this.f43180h;
        if (r242 != null) goto L394;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L394:
        r241.setCurrentFirstPriceSupplement(r242.getCheckSkuFirstPriceSpecDesc());
        SkuViewModel r243 = this.f43178f;
        if (r243 != null) goto L397;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L397:
        SpecItemOptimizeGroupLayout r244 = this.f43180h;
        if (r244 != null) goto L400;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L400:
        r243.setCurrentFirstPriceSuffix(r244.getCheckSkuFirstPriceSuffix());
        SkuViewModel r245 = this.f43178f;
        if (r245 != null) goto L403;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L403:
        SpecItemOptimizeGroupLayout r246 = this.f43180h;
        if (r246 != null) goto L406;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L406:
        r245.setCurrentFirstPriceIsUnderline(r246.getCheckSkuFirstPriceIsUnderline());
        SkuViewModel r247 = this.f43178f;
        if (r247 != null) goto L409;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L409:
        SpecItemOptimizeGroupLayout r248 = this.f43180h;
        if (r248 != null) goto L412;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L412:
        r247.setCurrentSecondPrice(r248.getCheckSkuSecondPrice());
        SkuViewModel r249 = this.f43178f;
        if (r249 != null) goto L415;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L415:
        SpecItemOptimizeGroupLayout r250 = this.f43180h;
        if (r250 != null) goto L418;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L418:
        r249.setCurrentSecondPricePrefix(r250.getCheckSkuSecondPricePrefix());
        SkuViewModel r251 = this.f43178f;
        if (r251 != null) goto L421;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L421:
        SpecItemOptimizeGroupLayout r252 = this.f43180h;
        if (r252 != null) goto L424;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L424:
        r251.setCurrentSecondPriceSuffix(r252.getCheckSkuSecondPriceSuffix());
        SkuViewModel r253 = this.f43178f;
        if (r253 != null) goto L427;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L427:
        SpecItemOptimizeGroupLayout r254 = this.f43180h;
        if (r254 != null) goto L430;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L430:
        r253.setCurrentSecondPriceSupplement(r254.getCheckSkuSecondPriceSpecDesc());
        SkuViewModel r255 = this.f43178f;
        if (r255 != null) goto L433;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L433:
        SpecItemOptimizeGroupLayout r256 = this.f43180h;
        if (r256 != null) goto L436;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L436:
        r255.setCurrentSecondPriceIsUnderline(r256.getCheckSkuSecondPriceIsUnderline());
        SkuViewModel r257 = this.f43178f;
        if (r257 != null) goto L439;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L439:
        SpecItemOptimizeGroupLayout r258 = this.f43180h;
        if (r258 != null) goto L442;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L442:
        r257.setCurrentSecondPriceIsReducePrice(r258.getCheckSkuSecondPriceIsReducePrice());
        SkuViewModel r259 = this.f43178f;
        if (r259 != null) goto L445;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L445:
        SpecItemOptimizeGroupLayout r260 = this.f43180h;
        if (r260 != null) goto L448;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L448:
        r259.setCurrentRegularPrice(r260.getCheckSkuRegularPrice());
        SkuViewModel r261 = this.f43178f;
        if (r261 != null) goto L451;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L451:
        SpecItemOptimizeGroupLayout r262 = this.f43180h;
        if (r262 != null) goto L454;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L454:
        r261.setCurrentRegularPriceSupplement(r262.getCheckSkuRegularPriceSpecDesc());
        SkuViewModel r263 = this.f43178f;
        if (r263 != null) goto L457;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L457:
        SpecItemOptimizeGroupLayout r264 = this.f43180h;
        if (r264 != null) goto L460;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L460:
        r263.setCurrentRegularPricePrefix(r264.getCheckSkuRegularPricePrefix());
        SkuViewModel r265 = this.f43178f;
        if (r265 != null) goto L463;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L463:
        SpecItemOptimizeGroupLayout r266 = this.f43180h;
        if (r266 != null) goto L466;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L466:
        r265.setCurrentRegularPriceSuffix(r266.getCheckSkuRegularPriceSuffix());
        SkuViewModel r267 = this.f43178f;
        if (r267 != null) goto L469;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L469:
        SpecItemOptimizeGroupLayout r268 = this.f43180h;
        if (r268 != null) goto L472;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L472:
        r267.setCurrentRegularPriceIsUnderline(r268.getCheckSkuRegularPriceIsUnderline());
        SkuViewModel r269 = this.f43178f;
        if (r269 != null) goto L475;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L475:
        SpecItemOptimizeGroupLayout r270 = this.f43180h;
        if (r270 != null) goto L478;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L478:
        r269.setCurrentHotMinPrice(r270.getCheckSkuHotMinPrice());
        SkuViewModel r271 = this.f43178f;
        if (r271 != null) goto L481;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L481:
        SpecItemOptimizeGroupLayout r272 = this.f43180h;
        if (r272 != null) goto L484;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L484:
        r271.setCurrentHotMaxPrice(r272.getCheckSkuHotMaxPrice());
        SkuViewModel r273 = this.f43178f;
        if (r273 != null) goto L487;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L487:
        r273.m8148getCurrentPrice().g(Long.valueOf(r102));
        SkuViewModel r274 = this.f43178f;
        if (r274 != null) goto L490;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L490:
        QLiveData<Integer> r275 = r274.getCurrentAtmosphereStyle();
        SpecItemOptimizeGroupLayout r276 = this.f43180h;
        if (r276 != null) goto L493;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L493:
        r275.g(r276.getCheckSkuAtmosphereStyle());
        goto L494
    L308:
        if (r102 != r221.longValue()) goto L330;
        SkuViewModel r277 = this.f43178f;
        if (r277 != null) goto L313;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L313:
        if (r277.getCurrentPriceWithDefault() != r102) goto L330;
        SkuViewModel r278 = this.f43178f;
        if (r278 != null) goto L317;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L317:
        long r279 = r278.getCurrentOriginPrice();
        SpecItemOptimizeGroupLayout r280 = this.f43180h;
        if (r280 != null) goto L321;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L321:
        if (r279 != jg.g.b(r280.getCheckSkuOriginPrice(), 0)) goto L330;
        SkuViewModel r281 = this.f43178f;
        if (r281 != null) goto L325;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L325:
        long r282 = r281.getCurrentDiscountPrice();
        SpecItemOptimizeGroupLayout r283 = this.f43180h;
        if (r283 != null) goto L329;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L329:
        if (r282 == jg.g.b(r283.getCheckSkuDiscountPrice(), 0)) goto L494;
    L8:
        r102 = 0;
        goto L9
    }

    public static final void h0(b2 r210, boolean r211) {
        SkuViewModel r100 = r210.f43178f;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        SpecItemOptimizeGroupLayout r101 = r210.f43180h;
        if (r101 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L8:
        r100.setSelectedSkuId(r101.getCheckedSkuId());
        SkuViewModel r102 = r210.f43178f;
        if (r102 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L11:
        SkuViewModel r103 = r210.f43178f;
        if (r103 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L14:
        SkuInfoVO r104 = r103.getSkuInfo().a();
        List<SpecInfo> r105 = null;
        if (r104 == null) goto L24;
        Map<String, SkuItemInfoVO> r106 = r104.getSkuList();
        if (r106 == null) goto L24;
        SpecItemOptimizeGroupLayout r107 = r210.f43180h;
        if (r107 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L21:
        SkuItemInfoVO r108 = r106.get(r107.getCheckedId());
        if (r108 == null) goto L24;
        String r109 = r108.getId();
    L25:
        String r110 = "";
        if (r109 != null) goto L28;
        r109 = "";
    L28:
        r102.setComboId(r109);
        SkuViewModel r111 = r210.f43178f;
        if (r111 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L31:
        SpecItemOptimizeGroupLayout r112 = r210.f43180h;
        if (r112 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L34:
        String[] r113 = r112.getCheckedIdArray();
        if (r113 == null) goto L38;
        List<String> r114 = ArraysKt.toMutableList(r113);
        if (r114 == null) goto L38;
    L39:
        r111.setCheckedIdArray(r114);
        SkuViewModel r115 = r210.f43178f;
        if (r115 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L42:
        SpecItemOptimizeGroupLayout r116 = r210.f43180h;
        if (r116 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L45:
        r115.setCurrentPos(r116.getCurrentPosition());
        int r117 = qf.a.f532712a;
        SkuViewModel r118 = r210.f43178f;
        if (r118 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L48:
        long r119 = 0;
        if (qf.a.e.a(r118.getSkuParams()) == false) goto L73;
        SpecItemOptimizeGroupLayout r120 = r210.f43180h;
        if (r120 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L53:
        String r121 = r120.getCheckSkuImageUrl();
        if (r121 == null) goto L58;
        r110 = r121;
    L58:
        if (r110.length() <= 0) goto L60;
        boolean r122 = true;
    L61:
        if (r122 == false) goto L68;
        SkuViewModel r123 = r210.f43178f;
        if (r123 != null) goto L66;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L66:
        if (Intrinsics.areEqual(r110, r123.getCurrentAvatar().a()) == false) goto L68;
    L72:
        r210.o0(r211);
    L506:
        SkuViewModel r124 = r210.f43178f;
        if (r124 != null) goto L509;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L509:
        QLiveData<Long> r125 = r124.getCurrentStock();
        SpecItemOptimizeGroupLayout r126 = r210.f43180h;
        if (r126 != null) goto L512;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L512:
        Long r127 = r126.getRealStock();
        if (r127 == null) goto L515;
        r119 = r127.longValue();
    L515:
        r125.g(Long.valueOf(r119));
        r210.m0();
        r210.n0();
        r210.l0();
        SkuViewModel r128 = r210.f43178f;
        if (r128 != null) goto L518;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L518:
        QLiveData<List<PromotionBenefitLabel>> r129 = r128.getCurrentBenefitLabel();
        SpecItemOptimizeGroupLayout r130 = r210.f43180h;
        if (r130 != null) goto L521;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L521:
        r129.g(r130.getSkuBenefitLabel());
        SpecItemOptimizeGroupLayout r131 = r210.f43180h;
        if (r131 != null) goto L524;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L524:
        String[] r132 = r131.getCheckedIdArray();
        if (r132 == null) goto L549;
        Integer r133 = Integer.valueOf(ArraysKt.indexOf(r132, null));
        if (r133.intValue() < 0) goto L529;
        boolean r134 = true;
    L530:
        if (r134 == true) goto L533;
        r133 = null;
    L533:
        if (r133 == null) goto L549;
        int r135 = r133.intValue();
        SkuViewModel r136 = r210.f43178f;
        if (r136 != null) goto L537;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L537:
        QLiveData<String> r137 = r136.getUnCheckedName();
        SkuViewModel r138 = r210.f43178f;
        if (r138 != null) goto L540;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L540:
        SkuInfoVO r139 = r138.getSkuInfo().a();
        if (r139 == null) goto L547;
        List<SpecInfo> r140 = r139.getSpecInfoList();
        if (r140 == null) goto L547;
        SpecInfo r141 = (SpecInfo) ListProtector.get(r140, r135);
        if (r141 == null) goto L547;
        String r142 = r141.getName();
    L548:
        r137.g(r142);
    L553:
        SkuViewModel r143 = r210.f43178f;
        if (r143 != null) goto L556;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L556:
        QLiveData<String> r144 = r143.getCheckedNames();
        StringBuilder r145 = new StringBuilder();
        SpecItemOptimizeGroupLayout r146 = r210.f43180h;
        if (r146 != null) goto L559;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L559:
        String[] r147 = r146.getCheckedIdArray();
        if (r147 == null) goto L570;
        int r148 = r147.length;
        int r149 = 0;
    L562:
        if (r149 >= r148) goto L570;
        String r150 = r147[r149];
        if (r150 == null) goto L566;
        boolean r151 = true;
    L567:
        if (r151 == true) goto L571;
        r149 = r149 + 1;
    L571:
        if (r150 == null) goto L616;
        int r152 = r147.length;
        int r153 = 0;
        int r154 = 0;
    L573:
        if (r153 >= r152) goto L615;
        String r155 = r147[r153];
        int r156 = r154 + 1;
        SkuViewModel r157 = r210.f43178f;
        if (r157 != null) goto L577;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L577:
        SkuInfoVO r158 = r157.getSkuInfo().a();
        if (r158 == null) goto L604;
        List<SpecInfo> r159 = r158.getSpecInfoList();
        if (r159 == null) goto L604;
        if (r159.size() <= r154) goto L584;
        boolean r160 = true;
    L585:
        if (r160 == true) goto L588;
        r159 = r105;
    L588:
        if (r159 == null) goto L604;
        SpecInfo r161 = (SpecInfo) ListProtector.get(r159, r154);
        if (r161 == null) goto L604;
        List<SpecInfoItem> r162 = r161.getSpecItems();
        if (r162 == null) goto L604;
        Iterator<T> r163 = r162.iterator();
    L595:
        if (r163.hasNext() == false) goto L600;
        Object r164 = r163.next();
        if (Intrinsics.areEqual(((SpecInfoItem) r164).getId(), r155) == false) goto L595;
    L601:
        SpecInfoItem r165 = (SpecInfoItem) r164;
        if (r165 == null) goto L604;
        r145.append(" " + r165.getName());
        r210.f43181i = r165.getName();
    L614:
        r153 = r153 + 1;
        r154 = r156;
        r105 = null;
        goto L573
    L600:
        r164 = null;
        goto L601
    L584:
        r160 = false;
    L604:
        SkuViewModel r166 = r210.f43178f;
        if (r166 != null) goto L607;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L607:
        SkuInfoVO r167 = r166.getSkuInfo().a();
        if (r167 == null) goto L614;
        List<SpecInfo> r168 = r167.getSpecInfoList();
        if (r168 == null) goto L614;
        SpecInfo r169 = (SpecInfo) ListProtector.get(r168, r154);
        if (r169 == null) goto L614;
        r169.getName();
        goto L614
    L615:
        String r170 = th.a.h(r210.Y().c(), R.string.shopping_sku_selected, new Object[]{r145.toString()});
    L626:
        r144.g(r170);
        SkuViewModel r171 = r210.f43178f;
        if (r171 != null) goto L629;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L629:
        SpecItemOptimizeGroupLayout r172 = r210.f43180h;
        if (r172 != null) goto L632;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L632:
        r171.setCanAddCart(r172.getCanAddCart());
        StringBuilder r173 = new StringBuilder();
        SpecItemOptimizeGroupLayout r174 = r210.f43180h;
        if (r174 != null) goto L635;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L635:
        String[] r175 = r174.getCheckedIdArray();
        SkuViewModel r176 = r210.f43178f;
        if (r176 != null) goto L639;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L639:
        if (r176.getSkuParams().isFromCartOrInsurance() == false) goto L696;
        if (r175 == null) goto L650;
        int r177 = r175.length;
        int r178 = 0;
    L642:
        if (r178 >= r177) goto L650;
        String r179 = r175[r178];
        if (r179 == null) goto L646;
        boolean r180 = true;
    L647:
        if (r180 == true) goto L651;
        r178 = r178 + 1;
    L651:
        if (r179 == null) goto L696;
        int r181 = r175.length;
        int r182 = 0;
        int r183 = 0;
    L653:
        if (r182 >= r181) goto L692;
        String r184 = r175[r182];
        int r185 = r183 + 1;
        SkuViewModel r186 = r210.f43178f;
        if (r186 != null) goto L657;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L657:
        SkuInfoVO r187 = r186.getSkuInfo().a();
        if (r187 == null) goto L691;
        List<SpecInfo> r188 = r187.getSpecInfoList();
        if (r188 == null) goto L691;
        if (r188.size() <= r183) goto L664;
        boolean r189 = true;
    L665:
        if (r189 == true) goto L668;
        r188 = null;
    L668:
        if (r188 == null) goto L691;
        SpecInfo r190 = (SpecInfo) ListProtector.get(r188, r183);
        if (r190 == null) goto L691;
        r173.append(r190.getName() + ':');
        Iterator<T> r191 = r190.getSpecItems().iterator();
    L673:
        if (r191.hasNext() == false) goto L677;
        Object r192 = r191.next();
        if (Intrinsics.areEqual(((SpecInfoItem) r192).getId(), r184) == false) goto L673;
    L678:
        SpecInfoItem r193 = (SpecInfoItem) r192;
        if (r193 == null) goto L681;
        r173.append(r193.getName() + ';');
        goto L691
    L681:
        SkuViewModel r194 = r210.f43178f;
        if (r194 != null) goto L684;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L684:
        SkuInfoVO r195 = r194.getSkuInfo().a();
        if (r195 == null) goto L691;
        List<SpecInfo> r196 = r195.getSpecInfoList();
        if (r196 == null) goto L691;
        SpecInfo r197 = (SpecInfo) ListProtector.get(r196, r183);
        if (r197 == null) goto L691;
        r197.getName();
        goto L691
    L677:
        r192 = null;
        goto L678
    L664:
        r189 = false;
    L691:
        r182 = r182 + 1;
        r183 = r185;
        goto L653
    L692:
        SkuViewModel r198 = r210.f43178f;
        if (r198 != null) goto L695;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L695:
        r198.setCartSelectedDes(r173.toString());
        goto L696
    L646:
        r180 = false;
    L650:
        r179 = null;
    L696:
        SkuViewModel r199 = r210.f43178f;
        if (r199 != null) goto L699;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L699:
        QLiveData<rg.a<String>> r200 = r199.getOnItemChange();
        SpecItemOptimizeGroupLayout r201 = r210.f43180h;
        if (r201 != null) goto L702;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L702:
        r200.g(new rg.a(r201.getCheckedId()));
        SkuViewModel r202 = r210.f43178f;
        if (r202 != null) goto L705;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L705:
        QLiveData<CarAdaptComponent> r203 = r202.getCurrentCarAdaptComponent();
        SpecItemOptimizeGroupLayout r204 = r210.f43180h;
        if (r204 != null) goto L708;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L708:
        r203.g(r204.getCheckSkuCarAdapt());
        SkuViewModel r205 = r210.f43178f;
        if (r205 != null) goto L711;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L711:
        QLiveData<String> r206 = r205.getStockDesc();
        SpecItemOptimizeGroupLayout r207 = r210.f43180h;
        if (r207 != null) goto L714;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L714:
        r206.g(r207.getStockDesc());
        r210.k0();
        return;
    L616:
        Context r208 = r210.Y().c();
        Object[] r209 = new Object[1];
        SkuViewModel r212 = r210.f43178f;
        if (r212 != null) goto L619;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L619:
        SkuInfoVO r213 = r212.getSkuInfo().a();
        if (r213 == null) goto L624;
        List<SpecInfo> r214 = r213.getSpecInfoList();
        if (r214 == null) goto L624;
        String r215 = CollectionsKt.joinToString$default(r214, " ", " ", null, 0, null, SelectOptimizePresenter$refreshTitleSpec$3.INSTANCE, 28, null);
    L625:
        r145.append(r215);
        r209[0] = r145.toString();
        r170 = th.a.h(r208, R.string.shopping_sku_select, r209);
    L624:
        r215 = null;
        goto L625
    L566:
        r151 = false;
    L570:
        r150 = null;
    L547:
        r142 = null;
        goto L548
    L529:
        r134 = false;
    L549:
        SkuViewModel r216 = r210.f43178f;
        if (r216 != null) goto L552;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L552:
        r216.getUnCheckedName().g(null);
    L68:
        SkuViewModel r217 = r210.f43178f;
        if (r217 != null) goto L71;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L71:
        r217.getCurrentAvatar().g(r110);
        goto L72
    L60:
        r122 = false;
        goto L61
    L73:
        SpecItemOptimizeGroupLayout r218 = r210.f43180h;
        if (r218 != null) goto L76;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L76:
        String r219 = r218.getCheckSkuImageUrl();
        SkuViewModel r1100 = r210.f43178f;
        if (r1100 != null) goto L79;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L79:
        QLiveData<String> r1101 = r1100.getCurrentAvatar();
        if (r219 != null) goto L82;
    L87:
        r219 = null;
    L88:
        if (r219 != null) goto L90;
        r219 = "";
    L90:
        r1101.g(r219);
        SpecItemOptimizeGroupLayout r220 = r210.f43180h;
        if (r220 != null) goto L93;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L93:
        Long r221 = r220.getCheckSkuPrice();
        if (r221 == null) goto L96;
        long r1102 = r221.longValue();
    L97:
        SkuViewModel r222 = r210.f43178f;
        if (r222 != null) goto L100;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L100:
        r222.m8148getCurrentPrice().g(Long.valueOf(r1102));
        SkuViewModel r223 = r210.f43178f;
        if (r223 != null) goto L103;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L103:
        SpecItemOptimizeGroupLayout r1103 = r210.f43180h;
        if (r1103 != null) goto L106;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L106:
        Long r1104 = r1103.getCheckSkuOriginPrice();
        if (r1104 == null) goto L109;
        long r1105 = r1104.longValue();
    L110:
        r223.setCurrentOriginPrice(r1105);
        SkuViewModel r224 = r210.f43178f;
        if (r224 != null) goto L113;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L113:
        SpecItemOptimizeGroupLayout r1106 = r210.f43180h;
        if (r1106 != null) goto L116;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L116:
        Long r1107 = r1106.getCheckSkuDiscountPrice();
        if (r1107 == null) goto L119;
        long r1108 = r1107.longValue();
    L120:
        r224.setCurrentDiscountPrice(r1108);
        SkuViewModel r225 = r210.f43178f;
        if (r225 != null) goto L123;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L123:
        SpecItemOptimizeGroupLayout r1109 = r210.f43180h;
        if (r1109 != null) goto L126;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L126:
        String r1110 = r1109.getCheckSkuDiscountPriceText();
        if (r1110 != null) goto L129;
        r1110 = "";
    L129:
        r225.setCurrentDiscountPriceText(r1110);
        SkuViewModel r226 = r210.f43178f;
        if (r226 != null) goto L132;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L132:
        SpecItemOptimizeGroupLayout r1111 = r210.f43180h;
        if (r1111 != null) goto L135;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L135:
        String r1112 = r1111.getCheckSkuCampaignPriceHeader();
        if (r1112 == null) goto L139;
        r110 = r1112;
    L139:
        r226.setCurrentCampainPriceHeader(r110);
        SkuViewModel r227 = r210.f43178f;
        if (r227 != null) goto L142;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L142:
        SpecItemOptimizeGroupLayout r228 = r210.f43180h;
        if (r228 != null) goto L145;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L145:
        r227.setCurrentCampainPriceHeaderStyle(r228.getCheckSkuPriceHedaerStyle());
        SkuViewModel r229 = r210.f43178f;
        if (r229 != null) goto L148;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L148:
        SpecItemOptimizeGroupLayout r230 = r210.f43180h;
        if (r230 != null) goto L151;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L151:
        r229.setCurrentNewBonusText(r230.getNewBonusText());
        if (r1102 != (-1)) goto L367;
        SkuViewModel r231 = r210.f43178f;
        if (r231 != null) goto L156;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L156:
        SkuViewModel r232 = r210.f43178f;
        if (r232 != null) goto L159;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L159:
        SkuInfoVO r233 = r232.getSkuInfo().a();
        if (r233 == null) goto L162;
        Long r234 = r233.getFirstPrice();
    L163:
        r231.setCurrentFirstPrice(r234);
        SkuViewModel r235 = r210.f43178f;
        if (r235 != null) goto L166;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L166:
        SkuViewModel r236 = r210.f43178f;
        if (r236 != null) goto L169;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L169:
        SkuInfoVO r237 = r236.getSkuInfo().a();
        if (r237 == null) goto L172;
        String r238 = r237.getFirstPricePrefix();
    L173:
        r235.setCurrentFirstPricePrefix(r238);
        SkuViewModel r239 = r210.f43178f;
        if (r239 != null) goto L176;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L176:
        SkuViewModel r240 = r210.f43178f;
        if (r240 != null) goto L179;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L179:
        SkuInfoVO r241 = r240.getSkuInfo().a();
        if (r241 == null) goto L182;
        String r242 = r241.getFirstPriceSuffix();
    L183:
        r239.setCurrentFirstPriceSuffix(r242);
        SkuViewModel r243 = r210.f43178f;
        if (r243 != null) goto L186;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L186:
        SkuViewModel r244 = r210.f43178f;
        if (r244 != null) goto L189;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L189:
        SkuInfoVO r245 = r244.getSkuInfo().a();
        if (r245 == null) goto L192;
        Boolean r246 = r245.getFirstPriceIsUnderline();
    L193:
        r243.setCurrentFirstPriceIsUnderline(r246);
        SkuViewModel r247 = r210.f43178f;
        if (r247 != null) goto L196;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L196:
        SkuViewModel r248 = r210.f43178f;
        if (r248 != null) goto L199;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L199:
        SkuInfoVO r249 = r248.getSkuInfo().a();
        if (r249 == null) goto L202;
        String r250 = r249.getFirstPriceSupplement();
    L203:
        r247.setCurrentFirstPriceSupplement(r250);
        SkuViewModel r251 = r210.f43178f;
        if (r251 != null) goto L206;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L206:
        SkuViewModel r252 = r210.f43178f;
        if (r252 != null) goto L209;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L209:
        SkuInfoVO r253 = r252.getSkuInfo().a();
        if (r253 == null) goto L212;
        Long r254 = r253.getSecondPrice();
    L213:
        r251.setCurrentSecondPrice(r254);
        SkuViewModel r255 = r210.f43178f;
        if (r255 != null) goto L216;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L216:
        SkuViewModel r256 = r210.f43178f;
        if (r256 != null) goto L219;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L219:
        SkuInfoVO r257 = r256.getSkuInfo().a();
        if (r257 == null) goto L222;
        String r258 = r257.getSecondPricePrefix();
    L223:
        r255.setCurrentSecondPricePrefix(r258);
        SkuViewModel r259 = r210.f43178f;
        if (r259 != null) goto L226;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L226:
        SkuViewModel r260 = r210.f43178f;
        if (r260 != null) goto L229;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L229:
        SkuInfoVO r261 = r260.getSkuInfo().a();
        if (r261 == null) goto L232;
        String r262 = r261.getSecondPriceSuffix();
    L233:
        r259.setCurrentSecondPriceSuffix(r262);
        SkuViewModel r263 = r210.f43178f;
        if (r263 != null) goto L236;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L236:
        SkuViewModel r264 = r210.f43178f;
        if (r264 != null) goto L239;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L239:
        SkuInfoVO r265 = r264.getSkuInfo().a();
        if (r265 == null) goto L242;
        Boolean r266 = r265.getSecondPriceIsUnderline();
    L243:
        r263.setCurrentSecondPriceIsUnderline(r266);
        SkuViewModel r267 = r210.f43178f;
        if (r267 != null) goto L246;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L246:
        SkuViewModel r268 = r210.f43178f;
        if (r268 != null) goto L249;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L249:
        SkuInfoVO r269 = r268.getSkuInfo().a();
        if (r269 == null) goto L252;
        Boolean r270 = r269.getSecondPriceIsReducePrice();
    L253:
        r267.setCurrentSecondPriceIsReducePrice(r270);
        SkuViewModel r271 = r210.f43178f;
        if (r271 != null) goto L256;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L256:
        SkuViewModel r272 = r210.f43178f;
        if (r272 != null) goto L259;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L259:
        SkuInfoVO r273 = r272.getSkuInfo().a();
        if (r273 == null) goto L262;
        String r274 = r273.getSecondPriceSupplement();
    L263:
        r271.setCurrentSecondPriceSupplement(r274);
        SkuViewModel r275 = r210.f43178f;
        if (r275 != null) goto L266;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L266:
        SkuViewModel r276 = r210.f43178f;
        if (r276 != null) goto L269;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L269:
        SkuInfoVO r277 = r276.getSkuInfo().a();
        if (r277 == null) goto L272;
        Long r278 = r277.getRegularPrice();
    L273:
        r275.setCurrentRegularPrice(r278);
        SkuViewModel r279 = r210.f43178f;
        if (r279 != null) goto L276;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L276:
        SkuViewModel r280 = r210.f43178f;
        if (r280 != null) goto L279;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L279:
        SkuInfoVO r281 = r280.getSkuInfo().a();
        if (r281 == null) goto L282;
        Long r282 = r281.getPriceType();
    L283:
        r279.setCurrentPriceType(r282);
        SkuViewModel r283 = r210.f43178f;
        if (r283 != null) goto L286;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L286:
        SkuViewModel r284 = r210.f43178f;
        if (r284 != null) goto L289;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L289:
        SkuInfoVO r285 = r284.getSkuInfo().a();
        if (r285 == null) goto L292;
        String r286 = r285.getRegularPricePrefix();
    L293:
        r283.setCurrentRegularPricePrefix(r286);
        SkuViewModel r287 = r210.f43178f;
        if (r287 != null) goto L296;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L296:
        SkuViewModel r288 = r210.f43178f;
        if (r288 != null) goto L299;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L299:
        SkuInfoVO r289 = r288.getSkuInfo().a();
        if (r289 == null) goto L302;
        String r290 = r289.getRegularPriceSuffix();
    L303:
        r287.setCurrentRegularPriceSuffix(r290);
        SkuViewModel r291 = r210.f43178f;
        if (r291 != null) goto L306;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L306:
        SkuViewModel r292 = r210.f43178f;
        if (r292 != null) goto L309;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L309:
        SkuInfoVO r293 = r292.getSkuInfo().a();
        if (r293 == null) goto L312;
        Boolean r294 = r293.getRegularPriceIsUnderline();
    L313:
        r291.setCurrentRegularPriceIsUnderline(r294);
        SkuViewModel r295 = r210.f43178f;
        if (r295 != null) goto L316;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L316:
        SkuViewModel r296 = r210.f43178f;
        if (r296 != null) goto L319;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L319:
        SkuInfoVO r297 = r296.getSkuInfo().a();
        if (r297 == null) goto L322;
        String r298 = r297.getRegularPriceSupplement();
    L323:
        r295.setCurrentRegularPriceSupplement(r298);
        SkuViewModel r299 = r210.f43178f;
        if (r299 != null) goto L326;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L326:
        SkuViewModel r300 = r210.f43178f;
        if (r300 != null) goto L329;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L329:
        SkuInfoVO r301 = r300.getSkuInfo().a();
        if (r301 == null) goto L332;
        Long r302 = r301.getHotMinPrice();
    L333:
        r299.setCurrentHotMinPrice(r302);
        SkuViewModel r303 = r210.f43178f;
        if (r303 != null) goto L336;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L336:
        SkuViewModel r304 = r210.f43178f;
        if (r304 != null) goto L339;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L339:
        SkuInfoVO r305 = r304.getSkuInfo().a();
        if (r305 == null) goto L342;
        Long r306 = r305.getHotMaxPrice();
    L343:
        r303.setCurrentHotMaxPrice(r306);
        SkuViewModel r307 = r210.f43178f;
        if (r307 != null) goto L346;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L346:
        SkuViewModel r308 = r210.f43178f;
        if (r308 != null) goto L349;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L349:
        SkuInfoVO r309 = r308.getSkuInfo().a();
        if (r309 == null) goto L352;
        String r310 = r309.getHotPricePrefix();
    L353:
        r307.setCurrentHotPricePrefix(r310);
        SkuViewModel r311 = r210.f43178f;
        if (r311 != null) goto L356;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L356:
        r311.m8148getCurrentPrice().g(Long.valueOf(r1102));
        SkuViewModel r312 = r210.f43178f;
        if (r312 != null) goto L359;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L359:
        QLiveData<Integer> r313 = r312.getCurrentAtmosphereStyle();
        SkuViewModel r314 = r210.f43178f;
        if (r314 != null) goto L362;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L362:
        SkuInfoVO r315 = r314.getSkuInfo().a();
        if (r315 == null) goto L365;
        Integer r316 = r315.getAtmosphereStyle();
    L366:
        r313.g(r316);
    L504:
        if (r211 == true) goto L506;
        r210.i0();
        goto L506
    L365:
        r316 = null;
        goto L366
    L352:
        r310 = null;
        goto L353
    L342:
        r306 = null;
        goto L343
    L332:
        r302 = null;
        goto L333
    L322:
        r298 = null;
        goto L323
    L312:
        r294 = null;
        goto L313
    L302:
        r290 = null;
        goto L303
    L292:
        r286 = null;
        goto L293
    L282:
        r282 = null;
        goto L283
    L272:
        r278 = null;
        goto L273
    L262:
        r274 = null;
        goto L263
    L252:
        r270 = null;
        goto L253
    L242:
        r266 = null;
        goto L243
    L232:
        r262 = null;
        goto L233
    L222:
        r258 = null;
        goto L223
    L212:
        r254 = null;
        goto L213
    L202:
        r250 = null;
        goto L203
    L192:
        r246 = null;
        goto L193
    L182:
        r242 = null;
        goto L183
    L172:
        r238 = null;
        goto L173
    L162:
        r234 = null;
        goto L163
    L367:
        SkuViewModel r317 = r210.f43178f;
        if (r317 != null) goto L370;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L370:
        SpecItemOptimizeGroupLayout r318 = r210.f43180h;
        if (r318 != null) goto L373;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L373:
        r317.setCurrentFirstPrice(r318.getCheckSkuFirstPrice());
        SkuViewModel r319 = r210.f43178f;
        if (r319 != null) goto L376;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L376:
        SpecItemOptimizeGroupLayout r320 = r210.f43180h;
        if (r320 != null) goto L379;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L379:
        r319.setCurrentPriceType(r320.getCheckSkuPriceType());
        SkuViewModel r321 = r210.f43178f;
        if (r321 != null) goto L382;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L382:
        SpecItemOptimizeGroupLayout r322 = r210.f43180h;
        if (r322 != null) goto L385;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L385:
        r321.setCurrentFirstPricePrefix(r322.getCheckSkuFirstPricePrefix());
        SkuViewModel r323 = r210.f43178f;
        if (r323 != null) goto L388;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L388:
        SpecItemOptimizeGroupLayout r324 = r210.f43180h;
        if (r324 != null) goto L391;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L391:
        r323.setCurrentFirstPriceSupplement(r324.getCheckSkuFirstPriceSpecDesc());
        SkuViewModel r325 = r210.f43178f;
        if (r325 != null) goto L394;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L394:
        SpecItemOptimizeGroupLayout r326 = r210.f43180h;
        if (r326 != null) goto L397;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L397:
        r325.setCurrentFirstPriceSuffix(r326.getCheckSkuFirstPriceSuffix());
        SkuViewModel r327 = r210.f43178f;
        if (r327 != null) goto L400;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L400:
        SpecItemOptimizeGroupLayout r328 = r210.f43180h;
        if (r328 != null) goto L403;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L403:
        r327.setCurrentFirstPriceIsUnderline(r328.getCheckSkuFirstPriceIsUnderline());
        SkuViewModel r329 = r210.f43178f;
        if (r329 != null) goto L406;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L406:
        SpecItemOptimizeGroupLayout r330 = r210.f43180h;
        if (r330 != null) goto L409;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L409:
        r329.setCurrentSecondPrice(r330.getCheckSkuSecondPrice());
        SkuViewModel r331 = r210.f43178f;
        if (r331 != null) goto L412;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L412:
        SpecItemOptimizeGroupLayout r332 = r210.f43180h;
        if (r332 != null) goto L415;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L415:
        r331.setCurrentSecondPricePrefix(r332.getCheckSkuSecondPricePrefix());
        SkuViewModel r333 = r210.f43178f;
        if (r333 != null) goto L418;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L418:
        SpecItemOptimizeGroupLayout r334 = r210.f43180h;
        if (r334 != null) goto L421;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L421:
        r333.setCurrentSecondPriceSuffix(r334.getCheckSkuSecondPriceSuffix());
        SkuViewModel r335 = r210.f43178f;
        if (r335 != null) goto L424;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L424:
        SpecItemOptimizeGroupLayout r336 = r210.f43180h;
        if (r336 != null) goto L427;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L427:
        r335.setCurrentSecondPriceIsUnderline(r336.getCheckSkuSecondPriceIsUnderline());
        SkuViewModel r337 = r210.f43178f;
        if (r337 != null) goto L430;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L430:
        SpecItemOptimizeGroupLayout r338 = r210.f43180h;
        if (r338 != null) goto L433;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L433:
        r337.setCurrentSecondPriceSupplement(r338.getCheckSkuSecondPriceSpecDesc());
        SkuViewModel r339 = r210.f43178f;
        if (r339 != null) goto L436;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L436:
        SpecItemOptimizeGroupLayout r340 = r210.f43180h;
        if (r340 != null) goto L439;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L439:
        r339.setCurrentSecondPriceIsReducePrice(r340.getCheckSkuSecondPriceIsReducePrice());
        SkuViewModel r341 = r210.f43178f;
        if (r341 != null) goto L442;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L442:
        SpecItemOptimizeGroupLayout r342 = r210.f43180h;
        if (r342 != null) goto L445;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L445:
        r341.setCurrentRegularPrice(r342.getCheckSkuRegularPrice());
        SkuViewModel r343 = r210.f43178f;
        if (r343 != null) goto L448;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L448:
        SpecItemOptimizeGroupLayout r344 = r210.f43180h;
        if (r344 != null) goto L451;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L451:
        r343.setCurrentRegularPricePrefix(r344.getCheckSkuRegularPricePrefix());
        SkuViewModel r345 = r210.f43178f;
        if (r345 != null) goto L454;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L454:
        SpecItemOptimizeGroupLayout r346 = r210.f43180h;
        if (r346 != null) goto L457;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L457:
        r345.setCurrentRegularPriceSuffix(r346.getCheckSkuRegularPriceSuffix());
        SkuViewModel r347 = r210.f43178f;
        if (r347 != null) goto L460;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L460:
        SpecItemOptimizeGroupLayout r348 = r210.f43180h;
        if (r348 != null) goto L463;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L463:
        r347.setCurrentRegularPriceIsUnderline(r348.getCheckSkuRegularPriceIsUnderline());
        SkuViewModel r349 = r210.f43178f;
        if (r349 != null) goto L466;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L466:
        SpecItemOptimizeGroupLayout r350 = r210.f43180h;
        if (r350 != null) goto L469;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L469:
        r349.setCurrentRegularPriceSupplement(r350.getCheckSkuRegularPriceSpecDesc());
        SkuViewModel r351 = r210.f43178f;
        if (r351 != null) goto L472;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L472:
        SpecItemOptimizeGroupLayout r352 = r210.f43180h;
        if (r352 != null) goto L475;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L475:
        r351.setCurrentHotMinPrice(r352.getCheckSkuHotMinPrice());
        SkuViewModel r353 = r210.f43178f;
        if (r353 != null) goto L478;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L478:
        SpecItemOptimizeGroupLayout r354 = r210.f43180h;
        if (r354 != null) goto L481;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L481:
        r353.setCurrentHotMaxPrice(r354.getCheckSkuHotMaxPrice());
        SkuViewModel r355 = r210.f43178f;
        if (r355 != null) goto L484;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L484:
        SpecItemOptimizeGroupLayout r356 = r210.f43180h;
        if (r356 != null) goto L487;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L487:
        r355.setCurrentHotPriceSupplement(r356.getCheckSkuFirstPricePrefix());
        SkuViewModel r357 = r210.f43178f;
        if (r357 != null) goto L490;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L490:
        SkuViewModel r358 = r210.f43178f;
        if (r358 != null) goto L493;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L493:
        SkuInfoVO r359 = r358.getSkuInfo().a();
        if (r359 == null) goto L496;
        String r360 = r359.getHotPricePrefix();
    L497:
        r357.setCurrentHotPricePrefix(r360);
        SkuViewModel r361 = r210.f43178f;
        if (r361 != null) goto L500;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L500:
        QLiveData<Integer> r362 = r361.getCurrentAtmosphereStyle();
        SpecItemOptimizeGroupLayout r363 = r210.f43180h;
        if (r363 != null) goto L503;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L503:
        r362.g(r363.getCheckSkuAtmosphereStyle());
        goto L504
    L496:
        r360 = null;
        goto L497
    L119:
        r1108 = 0;
        goto L120
    L109:
        r1105 = 0;
        goto L110
    L96:
        r1102 = 0;
        goto L97
    L82:
        if (r219.length() <= 0) goto L84;
        boolean r1113 = true;
    L85:
        if (r1113 == false) goto L87;
    L84:
        r1113 = false;
    L38:
        r114 = new ArrayList();
    L24:
        r109 = null;
        goto L25
    }
}
