package com.bytedance.android.shopping.store.aggregate.classification;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.PagerAdapter;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.store.product.presenter.utils.f;
import com.bytedance.android.shopping.store.aggregate.AggregatePageTypes;
import com.bytedance.android.shopping.store.aggregate.ShopAggregatePageFragment;
import com.bytedance.android.shopping.store.aggregate.ShopAggregateParam;
import com.bytedance.android.shopping.store.aggregate.ShopAggregateProductListFragment;
import com.bytedance.android.shopping.store.aggregate.viewmodel.ShopAggregatePageViewModel;
import com.bytedance.android.shopping.store.router.hybridpage.setting.HybridPageConfigSetting;
import com.bytedance.android.shopping.store.tabkit.e;
import com.bytedance.android.shopping.store.tabkit.view.ScrollableViewPager;
import com.bytedance.android.ui.base.widget.tablayout.ECTabLayout;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QPresenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class ShopClassificationFilterPresenter extends QPresenter {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f183369e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f183370f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f183371g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f183372h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ECTabLayout f183373i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ScrollableViewPager f183374j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f183375k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final b f183376l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final a f183377m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ShopAggregatePageFragment f183378n;

    public static final class a implements View.OnScrollChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ShopClassificationFilterPresenter f183379a;

        public a(ShopClassificationFilterPresenter r100) {
            this.f183379a = r100;
        }

        @Override // android.view.View.OnScrollChangeListener
        public final void onScrollChange(View r100, int r101, int r102, int r103, int r104) {
            ShopClassificationFilterPresenter.D(this.f183379a);
        }
    }

    public static final class b implements ECTabLayout.OnTabSelectedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ShopClassificationFilterPresenter f183380a;

        @Override // com.bytedance.android.ui.base.widget.tablayout.ECTabLayout.BaseOnTabSelectedListener
        public final void onTabReselected(ECTabLayout.Tab r100) {
            Intrinsics.checkNotNullParameter(r100, "tab");
        }

        @Override // com.bytedance.android.ui.base.widget.tablayout.ECTabLayout.BaseOnTabSelectedListener
        public final void onTabSelected(ECTabLayout.Tab r100) {
        }

        @Override // com.bytedance.android.ui.base.widget.tablayout.ECTabLayout.BaseOnTabSelectedListener
        public final void onTabUnselected(ECTabLayout.Tab r100) {
            Intrinsics.checkNotNullParameter(r100, "tab");
        }

        public b(ShopClassificationFilterPresenter r100) {
            this.f183380a = r100;
        }

        @Override // com.bytedance.android.ui.base.widget.tablayout.ECTabLayout.BaseOnTabSelectedListener
        public final void onTabSelected(ECTabLayout.Tab r100, boolean r101) {
            if (r100 != null) goto L4;
            return;
        L4:
            dm.a.b r102 = dm.a.f469202a;
            dm.a.a(this.f183380a.f183369e).a("onTabSelect, position: " + r100.getPosition() + ", isClicked: " + r101);
            ScrollableViewPager r103 = this.f183380a.f183374j;     // Catch: Exception -> L44
            if (r103 == null) goto L8;
            r103.setCurrentItem(r100.getPosition());     // Catch: Exception -> L44
        L8:
            if (r101 == false) goto L52;
            ScrollableViewPager r104 = this.f183380a.f183374j;     // Catch: Exception -> L44
            if (r104 == null) goto L12;
            PagerAdapter r105 = r104.getAdapter();     // Catch: Exception -> L44
        L14:
            if ((r105 instanceof ShopClassificationViewPagerAdapter) == true) goto L16;
            r105 = null;
        L16:
            ShopClassificationViewPagerAdapter r106 = (ShopClassificationViewPagerAdapter) r105;     // Catch: Exception -> L44
            if (r106 == null) goto L19;
            Fragment r107 = r106.getItem(r100.getPosition());     // Catch: Exception -> L44
        L21:
            if ((r107 instanceof ShopAggregateProductListFragment) == true) goto L23;
            r107 = null;
        L23:
            ShopAggregateProductListFragment r108 = (ShopAggregateProductListFragment) r107;     // Catch: Exception -> L44
            if (r108 != null) goto L26;
            return;
        L26:
            if (r108.isAdded() == false) goto L49;
            boolean r109 = true;
            if (r108.isDetached() != true) goto L30;
            return;
        L30:
            if (r108.getFragmentManager() == null) goto L51;
            this.f183380a.F().getOnPageSelect().setValue(Unit.INSTANCE);     // Catch: Exception -> L44
            Object r110 = r100.getTag();     // Catch: Exception -> L44
            if ((r110 instanceof Map) == true) goto L35;
            r110 = null;
        L35:
            Map<String, String> r111 = (Map) r110;     // Catch: Exception -> L44
            if (r111 == null) goto L53;
            ShopClassificationFilterPresenter r112 = this.f183380a;     // Catch: Exception -> L44
            if (r100.getPosition() == 0) goto L41;
            r109 = false;
        L41:
            r112.G(r111, "click", r109);     // Catch: Exception -> L44
            return;
        L53:
            return;
        L51:
            return;
        L49:
            return;
        L19:
            r107 = null;
            goto L21
        L12:
            r105 = null;
            goto L14
        L52:
            return;
        L44:
            e = move-exception;
            dm.a.b r113 = dm.a.f469202a;
            dm.a.a(this.f183380a.f183369e).b("onTabSelect, error:: " + e, null);
        }
    }

    public final ShopAggregatePageViewModel F() {
        return (ShopAggregatePageViewModel) this.f183370f.getValue();
    }

    public ShopClassificationFilterPresenter(ShopAggregatePageFragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        this.f183378n = r100;
        this.f183369e = "ShopClassificationFilterPresenter";
        this.f183370f = LazyKt.lazy(new ShopClassificationFilterPresenter$viewModel$2(this));
        this.f183376l = new b(this);
        this.f183377m = new a(this);
    }

    public static final void D(ShopClassificationFilterPresenter r110) {
        ECTabLayout r100 = r110.f183373i;
        if (r100 == null) goto L38;
        Iterator r101 = ((ArrayList) e.k(r100)).iterator();
        int r102 = 0;
    L6:
        if (r101.hasNext() == false) goto L44;
        Object r103 = r101.next();
        int r104 = r102 + 1;
        if (r102 >= 0) goto L10;
        CollectionsKt.throwIndexOverflow();
    L10:
        ECTabLayout.Tab r105 = (ECTabLayout.Tab) r103;
        View r106 = r105.getCustomView();
        String r107 = null;
        if ((r106 instanceof CategoryTabItemView) == true) goto L13;
        r106 = null;
    L13:
        CategoryTabItemView r108 = (CategoryTabItemView) r106;
        if (r108 == null) goto L37;
        ShopAggregatePageViewModel r109 = r110.F();
        ShopAggregateParam r111 = r110.F().getStoreParam();
        Object r112 = r105.getTag();
        if ((r112 instanceof Map) == true) goto L18;
        r112 = null;
    L18:
        Map r113 = (Map) r112;
        if (r102 != 0) goto L21;
        boolean r114 = true;
    L22:
        Intrinsics.checkNotNullParameter(r109, "eventAction");
        Intrinsics.checkNotNullParameter(r111, "storeParam");
        if (r108.f183368b == true) goto L37;
        if (wg.a.b(r108) <= 0.5d) goto L37;
        PageFinder r115 = PageFinder.via(r108);
        Pair<String, String>[] r116 = new Pair[3];
        r116[0] = TuplesKt.to("sec_shop_id", r111.getSecShopId());
        if (r113 == null) goto L30;
        String r117 = com.bytedance.android.ecom.arch.slice.render.util.b.v(r113, "category_id", null);
    L31:
        r116[1] = TuplesKt.to("category_id", r117);
        if (r114 == false) goto L34;
        r107 = "全部";
    L36:
        r116[2] = TuplesKt.to("category_name", r107);
        r109.doEventAction("shop_classification_category_show", "a1.b56317.c27743.d19191", r115, r116);
        r108.f183368b = true;
        goto L37
    L34:
        if (r113 == null) goto L36;
        r107 = com.bytedance.android.ecom.arch.slice.render.util.b.v(r113, "category_name", null);
        goto L36
    L30:
        r117 = null;
        goto L31
    L21:
        r114 = false;
    L37:
        r102 = r104;
        goto L6
    L44:
        return;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QPresenter
    public final void A(QModel r110) {
        if (Intrinsics.areEqual(F().getStoreParam().getPageType(), AggregatePageTypes.CLASSIFICATION.getType()) == true) goto L5;
    L7:
        boolean r111 = false;
    L8:
        if (r111 == false) goto L10;
        return;
    L10:
        CategoryInfo r112 = F().getStoreParam().getCategoryInfo();
        if (r112 != null) goto L13;
        return;
    L13:
        if (r112.canClassificationPageShowFilterTab() != true) goto L95;
        y().findViewById(R.id.multi_classification_container).setVisibility(0);
        this.f183371g = f.a(w().b(R.id.classification_filter_tab_container));
        this.f183372h = f.a(w().b(R.id.classification_filter_view_pager));
        this.f183373i = (ECTabLayout) f.a(w().b(R.id.classification_filter_tab));
        this.f183374j = (ScrollableViewPager) f.a(w().b(R.id.classification_filter_view_pager));
        ECTabLayout r113 = this.f183373i;
        if (r113 == null) goto L53;
        r113.setSelectedTabIndicatorFixedWidth(com.bytedance.android.shopping.extensions.b.b(20));
        CategoryInfo r100 = F().getStoreParam().getCategoryInfo();
        if (r100 == null) goto L53;
        List<Map<String, String>> r101 = r100.getSubCategoryList();
        if (r101 == null) goto L53;
        CategoryInfo r102 = F().getStoreParam().getCategoryInfo();
        if (r102 == null) goto L27;
        String r103 = r102.getAnchorSubCategoryId();
        if (r103 == null) goto L27;
    L28:
        List<Map<String, String>> r104 = r101;
        Iterator<T> r105 = r104.iterator();
        int r106 = 0;
    L30:
        if (r105.hasNext() == false) goto L38;
        Object r107 = r105.next();
        int r108 = r106 + 1;
        if (r106 >= 0) goto L35;
        CollectionsKt.throwIndexOverflow();
    L35:
        if (Intrinsics.areEqual(com.bytedance.android.ecom.arch.slice.render.util.b.v((Map) r107, "category_id", null), r103) == false) goto L37;
        this.f183375k = r108;
    L37:
        r106 = r108;
        goto L30
    L38:
        ECTabLayout.Tab r109 = r113.newTab();
        CategoryTabItemView r114 = new CategoryTabItemView(r113.getContext(), null, 6, 0);
        r114.setText("全部");
        Unit r115 = Unit.INSTANCE;
        r109.setCustomView(r114);
        CategoryInfo r116 = F().getStoreParam().getCategoryInfo();
        if (r116 == null) goto L41;
        Map<String, String> r117 = r116.getMainCategoryItem();
    L42:
        r109.setTag(r117);
        r113.addTab(r109, false);
        Iterator<T> r118 = r104.iterator();
        int r119 = 0;
    L44:
        if (r118.hasNext() == false) goto L52;
        Object r120 = r118.next();
        int r121 = r119 + 1;
        if (r119 >= 0) goto L48;
        CollectionsKt.throwIndexOverflow();
    L48:
        Map r122 = (Map) r120;
        CategoryTabItemView r123 = new CategoryTabItemView(r113.getContext(), null, 6, 0);
        String r124 = com.bytedance.android.ecom.arch.slice.render.util.b.v(r122, "category_name", null);
        if (r124 != null) goto L51;
        r124 = "";
    L51:
        r123.setText(r124);
        ECTabLayout.Tab r125 = r113.newTab();
        r125.setCustomView(r123);
        r125.setTag(r122);
        r113.addTab(r125, false);
        r119 = r121;
        goto L44
    L52:
        r113.addOnTabSelectedListener(this.f183376l);
        r113.setOnScrollChangeListener(this.f183377m);
        r113.post(new com.bytedance.android.shopping.store.aggregate.classification.b(this, r113));
        goto L53
    L41:
        r117 = null;
    L27:
        r103 = "";
    L53:
        CategoryInfo r126 = F().getStoreParam().getCategoryInfo();
        if (r126 == null) goto L90;
        final List<Map<String, String>> r127 = r126.getSubCategoryList();
        if (r127 == null) goto L96;
        CategoryInfo r128 = F().getStoreParam().getCategoryInfo();
        if (r128 == null) goto L91;
        final Map<String, String> r129 = r128.getMainCategoryItem();
        if (r129 == null) goto L97;
        FragmentManager r130 = this.f183378n.getChildFragmentManager();
        if (r130 == null) goto L98;
        ShopClassificationViewPagerAdapter r131 = new ShopClassificationViewPagerAdapter(r130);
        ((ArrayList) r131.f183384a).add(E(r129));
        Iterator<T> r132 = r127.iterator();
    L68:
        if (r132.hasNext() == false) goto L70;
        Map r133 = (Map) r132.next();
        ((ArrayList) r131.f183384a).add(E(r133));
        goto L68
    L70:
        ScrollableViewPager r134 = this.f183374j;
        if (r134 == null) goto L92;
        r134.setOffscreenPageLimit(r131.getCount());
        r134.setAdapter(r131);
        PagerAdapter r135 = r134.getAdapter();
        if (r135 == null) goto L75;
        r135.notifyDataSetChanged();
    L75:
        r134.addOnPageChangeListener(new ShopClassificationFilterPresenter$initViewPager$$inlined$apply$lambda$1(this, r129, r127));
        r134.setCurrentItem(this.f183375k);
        int r136 = this.f183375k;
        if (r136 != 0) goto L78;
        G(r129, "default", true);
        return;
    L78:
        Map<String, String> r137 = (Map) CollectionsKt.getOrNull(r127, r136 - 1);
        if (r137 == null) goto L94;
        G(r137, "default", false);
        return;
    L94:
        return;
    L92:
        return;
    L98:
        return;
    L97:
        return;
    L91:
        return;
    L96:
        return;
    L90:
        return;
    L95:
        return;
    L5:
        if (HybridPageConfigSetting.f185954f == false) goto L7;
        r111 = true;
        goto L8
    }

    public final ShopAggregateProductListFragment E(Map r100) {
        ShopAggregateParam r101 = F().getStoreParam().deepCopy();
        r101.setShowCategoryTab(true);
        r101.getProductBasicRequestParam().setExtraParamMap(r100);
        int r102 = ShopAggregateProductListFragment.f183355g;
        Intrinsics.checkNotNullParameter(r101, "storeParam");
        ShopAggregateProductListFragment r103 = new ShopAggregateProductListFragment();
        Bundle r104 = new Bundle();
        r104.putSerializable("store_param", r101);
        Unit r105 = Unit.INSTANCE;
        r103.setArguments(r104);
        return r103;
    }

    public final void G(Map<String, String> r100, String r101, boolean r102) {
        ShopAggregatePageViewModel r103 = F();
        PageFinder r104 = PageFinder.via(this.f183378n);
        Pair<String, String>[] r105 = new Pair[4];
        r105[0] = TuplesKt.to("sec_shop_id", F().getStoreParam().getSecShopId());
        r105[1] = TuplesKt.to("switch_type", r101);
        r105[2] = TuplesKt.to("category_id", com.bytedance.android.ecom.arch.slice.render.util.b.v(r100, "category_id", null));
        if (r102 == false) goto L5;
        String r106 = "全部";
    L6:
        r105[3] = TuplesKt.to("category_name", r106);
        r103.doEventAction("shop_classification_category_switch", "a1.b56317.c27743.d19191", r104, r105);
        return;
    L5:
        r106 = com.bytedance.android.ecom.arch.slice.render.util.b.v(r100, "category_name", null);
        goto L6
    }
}
