package com.bytedance.android.shopping.store.hybridproduct.presenter;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.store.product.holder.LayoutTypes;
import com.bytedance.android.ec.store.repository.vo.ECTagListDTO;
import com.bytedance.android.ec.store.utils.playable.controller.playcontrol.PlayControlStrategy;
import com.bytedance.android.ec.store.view.ECTagListView;
import com.bytedance.android.ecom.arch.slice.render.context.SlcRenderContext;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.SlcElementContainer;
import com.bytedance.android.shopping.store.home.datasource.ECShopDataStorageForRemote;
import com.bytedance.android.shopping.store.hybridproduct.ECShopHybridProductViewModel;
import com.bytedance.android.shopping.store.slicecard.ShopSliceKey;
import com.bytedance.android.shopping.store.slicecard.ShopSliceUniqueId;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class ShopSliceProductFilterPresenter extends QFragmentPresenter {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ int f185277q = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f185278f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f185279g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f185280h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public com.bytedance.android.ec.store.repository.vo.k f185281i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f185282j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f185283k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public dj3.c f185284l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public View f185285m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f185286n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final com.bytedance.android.ecom.arch.slice.render.r f185287o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final ECStoreViewModel f185288p;

    public static final class a {
    }

    public static final class b implements gk3.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ShopSliceProductFilterPresenter f185289a;

        @Override // gk3.a
        public final void d(ECTagListView r100) {
        }

        @Override // gk3.a
        public final LifecycleOwner getLifecycleOwner() {
            return null;
        }

        @Override // gk3.a
        public final ECStoreViewModel a() {
            return this.f185289a.f185288p;
        }

        @Override // gk3.a
        public final ECShopHybridProductViewModel c() {
            return this.f185289a.e0();
        }

        public b(ShopSliceProductFilterPresenter r100) {
            this.f185289a = r100;
        }

        @Override // gk3.a
        public final com.bytedance.android.ec.store.view.j b(ECTagListDTO r100) {
            Intrinsics.checkNotNullParameter(r100, "tagListVO");
            Intrinsics.checkNotNullParameter(r100, "tagListVO");
            return null;
        }

        @Override // gk3.a
        public final void e(ECTagListView r100, ECTagListDTO r101) {
            Intrinsics.checkNotNullParameter(r101, "tagListVO");
            Intrinsics.checkNotNullParameter(r101, "tagListVO");
        }

        @Override // gk3.a
        public final com.bytedance.android.ec.store.view.j f(ECTagListDTO r100, View r101) {
            Intrinsics.checkNotNullParameter(r100, "tagListVO");
            Intrinsics.checkNotNullParameter(r100, "tagListVO");
            return null;
        }
    }

    static {
    }

    public final ECShopHybridProductViewModel e0() {
        return (ECShopHybridProductViewModel) this.f185279g.getValue();
    }

    public final void d0() {
        com.bytedance.android.ecom.arch.slice.render.r r100 = this.f185287o;
        if (r100 == null) goto L14;
        com.bytedance.android.ec.store.repository.vo.k r101 = this.f185281i;
        if (r101 == null) goto L11;
        Map<String, Object> r102 = this.f185288p.getSliceService().a();
        LinkedHashMap r103 = new LinkedHashMap();
        r103.putAll(r101.f185017d);
        if (r102 == null) goto L9;
        r103.putAll(r102);
    L9:
        LinkedHashMap r104 = new LinkedHashMap();
        r104.putAll(r101.f185014a);
        r104.putAll(r101.f185015b);
        r104.putAll(r101.f185016c);
        r104.put("slice_item_states", r103);
        Unit r105 = Unit.INSTANCE;
        Map<String, ? extends Object> r106 = MapsKt.mapOf(TuplesKt.to("data", r104));
        if (r106 == null) goto L11;
    L12:
        r100.a(r106, ShopSliceUniqueId.SHOP_PRODUCT_TAB_FILTER.getId());
        return;
    L11:
        r106 = MapsKt.emptyMap();
        goto L12
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter
    public final void b0(QModel r110) {
        View r100 = null;
        if ((r110 instanceof com.bytedance.android.ec.store.repository.vo.k) == true) goto L5;
        r110 = null;
    L5:
        com.bytedance.android.ec.store.repository.vo.k r111 = (com.bytedance.android.ec.store.repository.vo.k) r110;
        if (r111 != null) goto L8;
        return;
    L8:
        dm.a.b r101 = dm.a.f469202a;
        dm.a.a(this.f185278f).a("onBind");
        this.f185281i = r111;
        ej3.f r112 = r111.f48471h;
        if (r112 == null) goto L37;
        Map<String, dj3.k> r113 = r112.f472864f;
        if (r113 == null) goto L37;
        if (r113.containsKey("clothes_preview_button") == false) goto L29;
        this.f185282j = true;
        dj3.k r102 = r113.get("clothes_preview_button");
        if (r102 != null) goto L18;
    L25:
        dj3.k r114 = r113.get("double_column_button");
        if (r114 == null) goto L36;
        h0(r114);
        this.f185283k = "double_column_button";
        e0().getCurrentPlayStrategy().setValue(PlayControlStrategy.ORDER_FIRST_IMAGE);
    L36:
        e0().doAnyEventActionWithBtm("a1.b6269.c2429.d57203", PageFinder.via(a0()), "store_product_form_switch_show", w.a(e0()), new Pair[0]);
        goto L37
    L18:
        if (r102.b() != true) goto L25;
        dj3.k r115 = r113.get("clothes_preview_button");
        if (r115 == null) goto L36;
        h0(r115);
        this.f185283k = "clothes_preview_button";
        dj3.c r116 = r115.a();
        if (r116 == null) goto L24;
        this.f185284l = r116;
    L24:
        e0().upDateSelectParams(r102.d());
        e0().isClothesSelected().setValue(Boolean.TRUE);
        e0().getCurrentPlayStrategy().setValue(PlayControlStrategy.ALL_SAME);
        goto L36
    L29:
        if (e0().getLayoutType().getValue() != LayoutTypes.RECYCLER_VIEW_ITEM_SINGLE) goto L33;
        dj3.k r117 = r113.get("single_column_button");
        if (r117 == null) goto L36;
        h0(r117);
        this.f185283k = "single_column_button";
        goto L36
    L33:
        dj3.k r118 = r113.get("double_column_button");
        if (r118 == null) goto L36;
        h0(r118);
        this.f185283k = "double_column_button";
    L37:
        com.bytedance.android.ec.store.repository.vo.k r119 = this.f185281i;
        if (r119 == null) goto L42;
        ej3.f r120 = r119.f48471h;
        if (r120 == null) goto L42;
        String r121 = r120.f472863e;
    L43:
        if (r121 != null) goto L45;
    L48:
        boolean r122 = true;
    L49:
        if (r122 == true) goto L52;
        e0().setShowSelectPanelEntry(true);
        this.f185288p.getSelectPanelState().a(ECQuickUtilKt.a(Y()), new z(this), false);
    L52:
        com.bytedance.android.ecom.arch.slice.render.r r123 = this.f185287o;
        if (r123 == null) goto L55;
        r123.b((ShopSliceProductFilterPresenter$slcActionHandler$2.a) this.f185286n.getValue());
    L55:
        com.bytedance.android.ecom.arch.slice.render.r r124 = this.f185287o;
        if (r124 == null) goto L60;
        SlcTemplateContext r125 = r124.f50700b;
        if (r125 == null) goto L60;
        r125.s(ShopSliceUniqueId.SHOP_PRODUCT_TAB_FILTER.getId(), new b(this));
    L60:
        d0();
        com.bytedance.android.ecom.arch.slice.render.r r126 = this.f185287o;
        if (r126 == null) goto L78;
        View r103 = r126.f50701c;
        if (r103 == null) goto L78;
        SlcTemplateContext r127 = r126.f50700b;
        if (r127 != null) goto L67;
    L69:
        View r128 = null;
    L71:
        if ((r128 instanceof SlcElementContainer) == true) goto L73;
        r128 = null;
    L73:
        SlcElementContainer r129 = (SlcElementContainer) r128;
        if (r129 == null) goto L76;
        r100 = r129.getContentView();
    L76:
        this.f185285m = r100;
        goto L78
    L67:
        if (r127.f50235w == null) goto L69;
        r128 = SlcRenderContext.f(r103, ShopSliceKey.SHORT_TERM_INDICATORS.getKey());
    L78:
        if (this.f185280h == true) goto L91;
        dj3.c r130 = this.f185284l;
        if (r130 == null) goto L92;
        View r104 = this.f185285m;
        if (r104 != null) goto L86;
        return;
    L86:
        if (r104.getVisibility() == 8) goto L93;
        r104.post(new a0(r104, this, r130));
        ECShopDataStorageForRemote.f183626b.d(r130.d());
        e0().refreshPassthroughApiForSql();
        this.f185280h = true;
        return;
    L93:
        return;
    L92:
        return;
    L91:
        return;
    L45:
        if (r121.length() == 0) goto L48;
        r122 = false;
    L42:
        r121 = null;
        goto L43
    }

    public final void h0(dj3.k r100) {
        Map<String, Object> r101 = com.bytedance.android.ec.store.utils.m.c(r100);
        if (r101 == null) goto L10;
        com.bytedance.android.ec.store.repository.vo.k r102 = this.f185281i;
        if (r102 == null) goto L11;
        Map<String, Object> r103 = r102.f185017d;
        if (r103 == null) goto L12;
        r103.put("switch_button", r101);
        return;
    L12:
        return;
    L11:
        return;
    }

    public ShopSliceProductFilterPresenter(Fragment r100, com.bytedance.android.ecom.arch.slice.render.r r101, ECStoreViewModel r102) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r102, "storeViewModel");
        super(r100);
        this.f185287o = r101;
        this.f185288p = r102;
        this.f185278f = "ShopSliceProductFilterPresenter";
        this.f185279g = LazyKt.lazy(new ShopSliceProductFilterPresenter$viewModel$2(this));
        this.f185286n = LazyKt.lazy(new ShopSliceProductFilterPresenter$slcActionHandler$2(this));
    }
}
