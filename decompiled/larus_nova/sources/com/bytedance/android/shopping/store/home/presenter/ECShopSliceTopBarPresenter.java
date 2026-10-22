package com.bytedance.android.shopping.store.home.presenter;

import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.shopping.store.home.slice.ECStoreHeaderInfoSliceConfig;
import com.bytedance.android.shopping.store.home.view.ECStoreCollapsibleTextView;
import com.bytedance.android.shopping.store.slicecard.ShopSlcCardFactory;
import com.bytedance.android.shopping.store.slicecard.ShopSliceUniqueId;
import com.bytedance.android.shopping.store.slicecard.SliceItemType;
import com.bytedance.android.shopping.store.slicecard.dto.ShopSliceItemConfig;
import com.bytedance.android.shopping.store.slicecard.dto.SliceTemplate;
import com.bytedance.android.ui.ec.widget.photodraweeview.ExtensionsKt;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class ECShopSliceTopBarPresenter extends ECShopBasePresenter {
    public static final /* synthetic */ int G = 0;
    public Map<String, Object> A;
    public final Map<String, Object> B;
    public Map<String, Object> C;
    public com.bytedance.android.ecom.arch.slice.render.context.a D;
    public final Lazy E;
    public boolean F;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public ViewGroup f184009u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public View f184010v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public View f184011w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public ECStoreCollapsibleTextView f184012x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public com.bytedance.android.ecom.arch.slice.render.r f184013y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Map<String, ? extends Object> f184014z;

    public static final class a {
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECShopSliceTopBarPresenter f184015a;

        public b(ECShopSliceTopBarPresenter r100) {
            this.f184015a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            com.bytedance.android.shopping.store.home.entity.n r101 = (com.bytedance.android.shopping.store.home.entity.n) r100;
            Intrinsics.checkNotNullParameter(r101, "headerArea");
            if (r101.d() == true) goto L5;
        L44:
            ViewGroup r102 = this.f184015a.f184009u;
            if (r102 == null) goto L49;
            ExtensionsKt.gone(r102);
            return;
        L49:
            return;
        L5:
            if (r101.c() == true) goto L44;
            ViewGroup r103 = this.f184015a.f184009u;
            if (r103 == null) goto L10;
            ExtensionsKt.visible(r103);
        L10:
            com.bytedance.android.shopping.store.home.slice.d r104 = r101.f183761o;
            if (r104 == null) goto L43;
            ECShopSliceTopBarPresenter r105 = this.f184015a;
            r105.T().getSliceService().d(com.bytedance.android.shopping.store.home.slice.f.a(r104));
            ShopSlcCardFactory r106 = r105.T().getSliceCardFactory();
            Map<String, ECStoreHeaderInfoSliceConfig> r107 = r104.f184505a;
            Map<String, Object> r108 = null;
            if (r107 == null) goto L23;
            ECStoreHeaderInfoSliceConfig r109 = r107.get(SliceItemType.SHOP_TOP_BAR.getType());
            if (r109 == null) goto L23;
            ShopSliceItemConfig r110 = r109.getSliceItemConfig();
            if (r110 == null) goto L23;
            List<SliceTemplate> r111 = r110.getTemplates();
            if (r111 == null) goto L23;
            SliceTemplate r112 = (SliceTemplate) CollectionsKt.firstOrNull(r111);
            if (r112 == null) goto L23;
            String r113 = r112.getName();
        L24:
            com.bytedance.android.ecom.arch.slice.render.r r114 = r106.g(r113);
            r105.f184013y = r114;
            if (r114 == null) goto L27;
            r114.b((com.bytedance.android.shopping.store.slicecard.e) r105.E.getValue());
        L27:
            ECShopSliceTopBarPresenter r115 = this.f184015a;
            com.bytedance.android.shopping.store.home.entity.d r116 = r101.f183749c;
            r115.getClass();
            r115.f184014z = r104.f184506b;
            Map<String, ECStoreHeaderInfoSliceConfig> r117 = r104.f184505a;
            if (r117 == null) goto L39;
            ECStoreHeaderInfoSliceConfig r118 = r117.get(SliceItemType.SHOP_TOP_BAR.getType());
            if (r118 == null) goto L39;
            Map<String, Object> r119 = r118.getSliceItemActions();
            if (r119 == null) goto L34;
            Map<String, Object> r120 = MapsKt.toMutableMap(r119);
        L35:
            r115.A = r120;
            Map<String, Object> r121 = r118.getSliceItemExtra();
            if (r121 == null) goto L38;
            r108 = MapsKt.toMutableMap(r121);
        L38:
            r115.C = r108;
            goto L39
        L34:
            r120 = null;
        L39:
            int r122 = com.bytedance.android.shopping.store.home.b0.f183607a;
            com.bytedance.android.shopping.store.home.b0.a(r115.B, com.bytedance.android.shopping.store.home.b0.b(r116));
            dm.a.a("ECShopInfoTotalAreaSlicePresenter").a("updateFollowStateFromAccountInfo, sliceItemStates: " + r115.B);
            ECShopSliceTopBarPresenter r123 = this.f184015a;
            if (r123.D != null) goto L42;
            c2 r124 = new c2(this);
            r123.T().getSliceService().f(r124);
            Unit r125 = Unit.INSTANCE;
            r123.D = r124;
        L42:
            ECShopSliceTopBarPresenter.q0(this.f184015a);
        L23:
            r113 = null;
        L43:
            this.f184015a.T().getFollowConfigLiveData().a(this.f184015a.W(), new d2(this), false);
            this.f184015a.T().getUpglideFactor().a(ECQuickUtilKt.a(this.f184015a.u()), new e2(this), false);
            this.f184015a.T().isProductListAllShowCrossShop().a(this.f184015a.W(), new f2(this), false);
            this.f184015a.T().getSelectedTabLocation().a(this.f184015a.W(), new g2(this), false);
            this.f184015a.T().getTopSearchInfo().a(this.f184015a.W(), new h2(this), false);
        }
    }

    static {
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QPresenter
    public final void C() {
        com.bytedance.android.ecom.arch.slice.render.context.a r100 = this.D;
        if (r100 == null) goto L5;
        T().getSliceService().h(r100);
    L5:
        this.D = null;
    }

    public ECShopSliceTopBarPresenter(final Fragment r100) {
        super(r100);
        this.B = new LinkedHashMap();
        this.E = LazyKt.lazy(new ECShopSliceTopBarPresenter$slcActionHandler$2(this, r100));
    }

    public static final void q0(ECShopSliceTopBarPresenter r100) {
        if (r100.f184014z == null) goto L23;
        LinkedHashMap r101 = new LinkedHashMap();
        r101.putAll(r100.B);
        r101.putAll(r100.T().getSliceService().a());
        r101.put("timestamp", Long.valueOf(System.currentTimeMillis()));
        if (r100.T().isCroppedStyle() == false) goto L8;
        String r102 = "seven_split";
    L9:
        r101.put("modal", r102);
        r101.put("is_split_mode", Boolean.valueOf(r100.T().getStoreParam().isSplitMode()));
        r101.put("is_split_top", Boolean.valueOf(r100.T().getStoreParam().isTopSplit()));
        LinkedHashMap r103 = new LinkedHashMap();
        Map<String, ? extends Object> r104 = r100.f184014z;
        if (r104 != null) goto L12;
        r104 = MapsKt.emptyMap();
    L12:
        r103.putAll(r104);
        r103.put("slice_item_actions", r100.A);
        r103.put("slice_item_states", r101);
        r103.put("slice_item_extra", r100.C);
        Unit r105 = Unit.INSTANCE;
        Map<String, ? extends Object> r106 = MapsKt.mapOf(TuplesKt.to("data", r103));
        dm.a.a("ECShopInfoTotalAreaSlicePresenter").a("bindData, sliceItemStates: " + r100.B);
        dm.a.b r107 = dm.a.a("ECShopInfoTotalAreaSlicePresenter");
        StringBuilder r108 = new StringBuilder("bindData, dataCtx sliceItemStates: ");
        Object r109 = r106.get("data");
        if (r109 == null) goto L17;
        Map<String, Object> r110 = com.bytedance.android.ecom.arch.slice.render.util.b.o(r109);
        if (r110 == null) goto L17;
        Object r111 = r110.get("slice_item_states");
    L18:
        r108.append(r111);
        r107.a(r108.toString());
        com.bytedance.android.ecom.arch.slice.render.r r112 = r100.f184013y;
        if (r112 == null) goto L22;
        r112.a(r106, ShopSliceUniqueId.SHOP_TOP_BAR.getId());
        return;
    L22:
        return;
    L17:
        r111 = null;
        goto L18
    L8:
        r102 = "";
        goto L9
    }

    public static final void r0(ECShopSliceTopBarPresenter r100) {
        if (Intrinsics.areEqual(r100.T().isProductListAllShowCrossShop().getValue(), Boolean.TRUE) == false) goto L10;
        ECStoreCollapsibleTextView r101 = r100.f184012x;
        if (r101 == null) goto L7;
        ExtensionsKt.gone(r101);
    L7:
        View r102 = r100.f184011w;
        if (r102 == null) goto L17;
        ExtensionsKt.gone(r102);
        return;
    L17:
        return;
    L10:
        View r103 = r100.f184011w;
        if (r103 == null) goto L13;
        ExtensionsKt.visible(r103);
    L13:
        ECStoreCollapsibleTextView r104 = r100.f184012x;
        if (r104 == null) goto L19;
        ExtensionsKt.visible(r104);
        return;
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QPresenter
    public final void A(QModel r100) {
        View r101 = y();
        if ((r101 instanceof ViewGroup) == true) goto L5;
        r101 = null;
    L5:
        this.f184009u = (ViewGroup) r101;
        T().getHeaderArea().a(W(), new b(this), false);
    }
}
