package com.bytedance.android.shopping.store.search.presenter;

import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.core.utils.k1;
import com.bytedance.android.ec.core.widget.flow.FlowLayout;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.promotion.ECFindSimilarConfig;
import com.bytedance.android.ec.store.common.uiext.ExtensionsKt;
import com.bytedance.android.shopping.store.arch.ECStoreFoldPhoneHelper;
import com.bytedance.android.shopping.store.home.presenter.ShopSearchBasePresenter;
import com.bytedance.android.shopping.store.repository.vo.SearchSuggestWord;
import com.bytedance.android.shopping.store.search.activity.ShopSearchResultActivity;
import com.bytedance.android.shopping.store.search.router.ECShopSearchParam;
import com.bytedance.android.shopping.store.search.viewmodel.ShopSearchViewModel;
import com.bytedance.android.shopping.store.settings.ECShopABSettings;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QContext;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/store/search/presenter/ShopSearchHotViewPresenter;", "Lcom/bytedance/android/shopping/store/home/presenter/ShopSearchBasePresenter;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShopSearchHotViewPresenter extends ShopSearchBasePresenter {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f186015l = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f186016f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public List<SearchSuggestWord> f186017g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<SearchSuggestWord> f186018h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final QLiveData<List<SearchSuggestWord>> f186019i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final QLiveData<Integer> f186020j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public FlowLayout f186021k;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ShopSearchHotViewPresenter f186023a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function1 f186024b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ SearchSuggestWord f186025c;

        public b(ShopSearchHotViewPresenter r100, Function1 r101, SearchSuggestWord r102) {
            this.f186023a = r100;
            this.f186024b = r101;
            this.f186025c = r102;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r110) {
            String r111 = this.f186025c.getWord();
            String r100 = "";
            if (r111 != null) goto L5;
            r111 = "";
        L5:
            this.f186023a.E().getSearchParam().setSearchKeyword(r111);
            this.f186023a.E().getSearchParam().setStoreHotSearch(true);
            this.f186023a.E().getSearchParam().putPassThroughParam("is_store_hot_search", Boolean.TRUE);
            this.f186023a.E().getSearchParam().putPassThroughParam("page_name", "ecom_shop_search");
            this.f186023a.E().getSearchParam().setSearchSource("shop_hot_search");
            this.f186023a.E().getSearchParam().setFromSug(false);
            this.f186023a.E().getSearchParam().setHotSearchMethod("shop_search_page");
            ECShopSearchParam r101 = this.f186023a.E().getSearchParam();
            if (ECShopABSettings.getEC_SHOP_SEARCH_GUIDE_STYLE() == 2) goto L8;
        L10:
            r101.setHotSearchIconType(r100);
            this.f186023a.S(true, this.f186025c);
            Lazy r102 = ECStoreFoldPhoneHelper.f183487a;
            ECStoreFoldPhoneHelper.f(this.f186023a.D());
            int r103 = ShopSearchResultActivity.f185983m;
            QContext r104 = this.f186023a.u();
            FragmentActivity r105 = com.bytedance.android.ec.core.utils.l0.c(r104.c());
            if ((r105 instanceof FragmentActivity) == true) goto L13;
            r105 = null;
        L13:
            if (r105 != null) goto L15;
            r105 = r104.a();
        L15:
            ShopSearchResultActivity.a.a(r105, this.f186023a.E().getSearchParam(), 1, BtmSDK.createJumpSourceBtmToken$default(BtmSDK.INSTANCE, "a1.b8121.c369113.d675871_i" + (this.f186025c.getIndex() + 1), PageFinder.via(this.f186023a.y()), null, 4, null), 16);
            this.f186023a.E().getSearchContent().g(r111);
            this.f186023a.E().getPostKeyword().setValue(r111);
            return;
        L8:
            if (this.f186025c.getIcon() == null) goto L10;
            r100 = "hot_search_word_fire";
            goto L10
        }
    }

    static {
    }

    public final void I() {
        Map<String, String> r100 = qm.a.f533835a;
        qm.a.a("ec_perf_duration_shop_search", "render_start", System.currentTimeMillis());
        View r101 = w().b(R.id.commerce_store_hot_search_view).f();
        ViewGroup.LayoutParams r102 = r101.getLayoutParams();
        List<SearchSuggestWord> r103 = null;
        if ((r102 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
        r102 = null;
    L5:
        ViewGroup.MarginLayoutParams r104 = (ViewGroup.MarginLayoutParams) r102;
        if (r104 == null) goto L8;
        r104.setMarginStart(com.bytedance.android.shopping.extensions.b.a(16));
        r104.setMarginEnd(com.bytedance.android.shopping.extensions.b.a(16));
    L8:
        r101.requestLayout();
        FrameLayout r105 = (FrameLayout) w().b(R.id.ecommerce_store_hot_serach_list).f();
        if (ECShopABSettings.getEC_SHOP_SEARCH_GUIDE_STYLE() != 2) goto L11;
        FlowLayout r106 = new FlowLayout(u().c());
        this.f186021k = r106;
        r106.setMaxLine(3);
        int r107 = ExtensionsKt.a(8);
        int r108 = ExtensionsKt.a(8);
        r106.f46094g = r107;
        r106.f46093f = r108;
        ViewGroup.MarginLayoutParams r109 = new ViewGroup.MarginLayoutParams(-1, -1);
        r109.topMargin = ExtensionsKt.a(8);
        Unit r110 = Unit.INSTANCE;
        r106.setLayoutParams(r109);
        r105.addView(r106);
        this.f186019i.b(ECQuickUtilKt.a(u()), new i(r106, this, r105));
    L12:
        ((LinearLayout) w().b(R.id.commerce_store_hot_search_refresh_click).f()).setOnClickListener(new j(this));
        this.f186020j.b(ECQuickUtilKt.a(u()), new k(this));
        if (ECShopABSettings.getEC_SHOP_SEARCH_GUIDE_STYLE() == 2) goto L45;
        int r111 = ((k1.l() - (com.bytedance.android.shopping.extensions.b.a(16) * 2)) - com.bytedance.android.shopping.extensions.b.a(16)) / 2;
        Paint r112 = new Paint();
        r112.setTextSize(com.bytedance.android.shopping.extensions.b.a(Float.valueOf(17.0f)));
        List<SearchSuggestWord> r113 = this.f186017g;
        if (r113 == null) goto L45;
        Iterator<T> r114 = r113.iterator();
        int r115 = 0;
    L19:
        if (r114.hasNext() == false) goto L45;
        Object r116 = r114.next();
        int r117 = r115 + 1;
        if (r115 >= 0) goto L23;
        CollectionsKt.throwIndexOverflow();
    L23:
        SearchSuggestWord r118 = (SearchSuggestWord) r116;
        String r119 = r118.getWord();
        if (r119 == null) goto L44;
        ECUrlModel r120 = r118.getIcon();
        if (r120 == null) goto L32;
        List<String> r121 = r120.getUrlList();
        if (r121 == null) goto L32;
        if ((!r121.isEmpty()) != true) goto L32;
    L33:
        boolean r122 = true;
    L35:
        if (r122 == false) goto L37;
        int r123 = r111 - com.bytedance.android.shopping.extensions.b.a(18);
    L38:
        r118.setTrimWord(r119);
        int r124 = r119.length();
        int r125 = 5;
    L39:
        if (r125 >= r124) goto L44;
        if (r112.measureText(r119.substring(0, r125)) >= r123) goto L42;
        r125 = r125 + 1;
        goto L39
    L42:
        r118.setTrimWord(r119.substring(0, r125 - 1));
        goto L44
    L37:
        r123 = r111;
    L32:
        if (K(r118) != null) goto L33;
        r122 = false;
    L44:
        r115 = r117;
    L45:
        List<SearchSuggestWord> r126 = this.f186017g;
        if (r126 != null) goto L48;
    L52:
        Map<String, String> r127 = qm.a.f533835a;
        qm.a.a("ec_perf_duration_shop_search", "render_end", System.currentTimeMillis());
        qm.a.c("ec_perf_duration_shop_search");
        Q();
        return;
    L48:
        if ((!r126.isEmpty()) == false) goto L50;
        r103 = r126;
    L50:
        if (r103 == null) goto L52;
        ((FrameLayout) w().b(R.id.ec_store_search_hot_view_fl).f()).setVisibility(0);
        this.f186020j.g(Integer.valueOf(O()));
        this.f186019i.g(N());
        goto L52
    L11:
        zm.b r128 = new zm.b(u().c(), com.bytedance.android.shopping.extensions.b.a(16), new ShopSearchHotViewPresenter$initHotWordsContainer$$inlined$apply$lambda$1(this));
        r105.addView(r128);
        this.f186019i.b(ECQuickUtilKt.a(u()), new h(r128));
        goto L12
    }

    public final List<SearchSuggestWord> N() {
        ((ArrayList) this.f186018h).clear();
        List<SearchSuggestWord> r100 = this.f186017g;
        int r101 = 0;
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == true) goto L11;
        int r103 = this.f186016f;
        List<SearchSuggestWord> r104 = this.f186017g;
        Intrinsics.checkNotNull(r104);
        if (r103 < r104.size()) goto L16;
        this.f186016f = 0;
    L16:
        if (ECShopABSettings.getEC_SHOP_SEARCH_GUIDE_STYLE() != 2) goto L18;
        List<SearchSuggestWord> r105 = this.f186018h;
        List<SearchSuggestWord> r106 = this.f186017g;
        Intrinsics.checkNotNull(r106);
        int r107 = this.f186016f;
        List<SearchSuggestWord> r108 = this.f186017g;
        Intrinsics.checkNotNull(r108);
        ((ArrayList) r105).addAll(r106.subList(r107, r108.size()));
    L19:
        Iterator<T> r109 = this.f186018h.iterator();
    L21:
        if (r109.hasNext() == false) goto L27;
        Object r110 = r109.next();
        int r111 = r101 + 1;
        if (r101 >= 0) goto L25;
        CollectionsKt.throwIndexOverflow();
    L25:
        ((SearchSuggestWord) r110).setIndex(r101);
        r101 = r111;
        goto L21
    L27:
        return this.f186018h;
    L18:
        List<SearchSuggestWord> r112 = this.f186018h;
        List<SearchSuggestWord> r113 = this.f186017g;
        Intrinsics.checkNotNull(r113);
        int r114 = this.f186016f;
        List<SearchSuggestWord> r115 = this.f186017g;
        Intrinsics.checkNotNull(r115);
        ((ArrayList) r112).addAll(r113.subList(r114, RangesKt.coerceAtMost(r114 + 12, r115.size())));
        this.f186016f += 12;
        goto L19
    L11:
        return this.f186018h;
    L5:
        if (r100.isEmpty() == true) goto L8;
        r102 = false;
        goto L9
    }

    public final int O() {
        List<SearchSuggestWord> r100 = this.f186017g;
        List<SearchSuggestWord> r101 = r100;
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L10:
        if (r102 == false) goto L13;
        return 8;
    L13:
        if (ECShopABSettings.getEC_SHOP_SEARCH_GUIDE_STYLE() != 2) goto L22;
        int r103 = r100.size();
        FlowLayout r104 = this.f186021k;
        if (r104 == null) goto L17;
        int r105 = r104.getVisibleViewCount();
    L18:
        if (r103 > r105) goto L25;
        return 8;
    L25:
        return 0;
    L17:
        r105 = 0;
        goto L18
    L22:
        if (r100.size() > 12) goto L26;
        return 8;
    L26:
        return 0;
    L5:
        if (r101.isEmpty() == true) goto L8;
        r102 = false;
        goto L10
    }

    public ShopSearchHotViewPresenter() {
        this.f186018h = new ArrayList();
        this.f186019i = new QLiveData();
        this.f186020j = new QLiveData();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void Q() {
        E().doEventAction("trending_show", new Pair[]{TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_SHOP_ID, E().getSearchParam().getShopId()), TuplesKt.to("words_num", String.valueOf(com.bytedance.android.shopping.extensions.k.f(Integer.valueOf(((ArrayList) this.f186018h).size())))), TuplesKt.to("words_source", "shop_hot_search"), TuplesKt.to("enter_from", "search_store"), TuplesKt.to(ECFindSimilarConfig.ENTER_FROM_SECOND, E().getSearchParam().getEnterFromSecond()), TuplesKt.to("page_name", "ecom_shop_search"), TuplesKt.to("btm_id", new BtmItemBuilder("a1.b8121.c369113.d675871", null, 2, 0 == true ? 1 : 0).withPageFinder(PageFinder.via(y())).obtainEventBtmParams())});
    }

    public static Integer K(SearchSuggestWord r100) {
        String r101 = r100.getWordsType();
        if (r101 == null) goto L5;
        Integer r102 = StringsKt.toIntOrNull(r101);
    L6:
        if (r102 != null) goto L9;
    L11:
        if (r102 != null) goto L14;
    L16:
        if (r102 != null) goto L19;
        return null;
    L19:
        if (r102.intValue() == 17) goto L21;
        return null;
    L21:
        return Integer.valueOf(R.drawable.store_hot_serach_icon_coupon);
    L14:
        if (r102.intValue() != 2) goto L16;
        return Integer.valueOf(R.drawable.store_hot_serach_icon_hot);
    L9:
        if (r102.intValue() != 1) goto L11;
        return Integer.valueOf(R.drawable.store_hot_serach_icon_new);
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QPresenter
    public final void A(QModel r100) {
        th.a.c(u().c(), R.layout.ec_store_layout_search_hot_view, (ViewGroup) w().b(R.id.ec_store_search_hot_view_fl).f(), true);
        List<SearchSuggestWord> r101 = E().getSearchParam().getSearchSuggestWords();
        if (r101 != null) goto L5;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new ShopSearchHotViewPresenter$fillHotWordsByRequest$1(this, null), 3, null);
        return;
    L5:
        this.f186017g = CollectionsKt.toMutableList(r101);
        I();
    }

    public final View G(SearchSuggestWord r110, Function1<? super View, ? extends View> r111) {
        S(false, r110);
        ViewGroup.LayoutParams r100 = null;
        View r101 = LayoutInflater.from(u().c()).inflate(R.layout.ec_store_search_hot_item, null);
        View r102 = r111.invoke(r101);
        ECDraweeView r103 = (ECDraweeView) r101.findViewById(R.id.store_hot_search_item_icon);
        r103.setVisibility(0);
        ViewGroup.LayoutParams r104 = r103.getLayoutParams();
        if ((r104 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
        r104 = null;
    L5:
        ViewGroup.MarginLayoutParams r105 = (ViewGroup.MarginLayoutParams) r104;
        if (r105 == null) goto L9;
        r105.setMarginStart(r103.getDp(4));
    L9:
        if (r110.getIcon() == null) goto L11;
        com.bytedance.android.ec.core.imagex.h0.d(r103, r110.getIcon(), E().getImageCallerContext(), null, null, null, null, 120);
    L21:
        r101.setOnClickListener(new b(this, r111, r110));
        if (r102 != null) goto L25;
        return r101;
    L25:
        return r102;
    L11:
        Integer r106 = K(r110);
        if (r106 == null) goto L14;
        r103.setImageResource(r106.intValue());
        wg.a.i(r103, r103.getDp(14));
        goto L21
    L14:
        r103.setVisibility(8);
        ViewGroup.LayoutParams r107 = r103.getLayoutParams();
        if ((r107 instanceof ViewGroup.MarginLayoutParams) == false) goto L18;
        r100 = r107;
    L18:
        ViewGroup.MarginLayoutParams r108 = (ViewGroup.MarginLayoutParams) r100;
        if (r108 == null) goto L21;
        r108.setMarginStart(0);
        goto L21
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void S(boolean r100, SearchSuggestWord r101) {
        if (r100 == false) goto L4;
        String r102 = "trending_words_click";
    L5:
        ShopSearchViewModel r103 = E();
        Pair<String, String>[] r104 = new Pair[11];
        r104[0] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_SHOP_ID, E().getSearchParam().getShopId());
        r104[1] = TuplesKt.to("words_num", String.valueOf(com.bytedance.android.shopping.extensions.k.f(Integer.valueOf(((ArrayList) this.f186018h).size()))));
        int r105 = 2;
        r104[2] = TuplesKt.to("words_source", "shop_hot_search");
        r104[3] = TuplesKt.to("enter_from", "search_store");
        r104[4] = TuplesKt.to(ECFindSimilarConfig.ENTER_FROM_SECOND, E().getSearchParam().getEnterFromSecond());
        r104[5] = TuplesKt.to("page_name", "ecom_shop_search");
        r104[6] = TuplesKt.to("words_position", String.valueOf(r101.getIndex()));
        r104[7] = TuplesKt.to("words_content", r101.getWord());
        r104[8] = TuplesKt.to("group_id", r101.getId());
        if (r101.getIcon() == null) goto L8;
        String r106 = "1";
    L9:
        r104[9] = TuplesKt.to("hot_icon_type", r106);
        r104[10] = TuplesKt.to("btm_id", new BtmItemBuilder("a1.b8121.c369113.d675871_i" + (r101.getIndex() + 1), null, r105, 0 == true ? 1 : 0).withPageFinder(PageFinder.via(y())).obtainEventBtmParams());
        r103.doEventAction(r102, r104);
        return;
    L8:
        r106 = "0";
        goto L9
    L4:
        r102 = "trending_words_show";
        goto L5
    }
}
