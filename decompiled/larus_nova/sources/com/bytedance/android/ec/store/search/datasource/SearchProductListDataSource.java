package com.bytedance.android.ec.store.search.datasource;

import an.d;
import an.e;
import an.f;
import android.app.Activity;
import androidx.paging.PositionalDataSource;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.ec.model.api.CommerceBaseResponse;
import com.bytedance.android.ec.model.promotion.ECFindSimilarConfig;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ec.store.common.param.StoreV2RequestParam;
import com.bytedance.android.ec.store.monitor.ErrorCode;
import com.bytedance.android.ec.store.monitor.ErrorDomain;
import com.bytedance.android.ec.store.repository.dto.StoreV2ProductListResponseDTO;
import com.bytedance.android.ec.store.repository.vo.StoreV2ProductItemVO;
import com.bytedance.android.ec.store.repository.vo.StoreV2ProductListResponseVO;
import com.bytedance.android.ec.store.repository.vo.q;
import com.bytedance.android.ec.store.repository.vo.r;
import com.bytedance.android.ec.store.search.repository.dto.LogPbDTO;
import com.bytedance.android.ec.store.search.repository.vo.SearchProductListResponseVO;
import com.bytedance.android.ec.store.shopping.paging.ListStatusPositionalDataSource;
import com.bytedance.android.ec.store.shopping.paging.ListStatusPositionalLoadInitialCallback;
import com.bytedance.android.ec.store.shopping.paging.ListStatusPositionalLoadRangeCallback;
import com.bytedance.android.ec.store.shopping.paging.LoadStatus;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.store.repository.dto.StoreV3SearchResponseExpDTO;
import com.bytedance.android.shopping.store.search.router.ECShopSearchParam;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import s83.g;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/ec/store/search/datasource/SearchProductListDataSource;", "Lcom/bytedance/android/ec/store/shopping/paging/ListStatusPositionalDataSource;", "Len/b;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class SearchProductListDataSource extends ListStatusPositionalDataSource<en.b> {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f48512m = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f48513b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public en.c f48514c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f48515d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f48516e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final StoreV2RequestParam f48517f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ECShopSearchParam f48518g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final jm.a<List<q>> f48519h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final jm.a<List<r>> f48520i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final jm.a<String> f48521j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final com.bytedance.android.ec.core.async.b f48522k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Function1<StoreV2ProductListResponseVO, Unit> f48523l;

    public static final class a {
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SearchProductListDataSource f48524a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ListStatusPositionalLoadInitialCallback f48525b;

        public b(SearchProductListDataSource r100, ListStatusPositionalLoadInitialCallback r101) {
            this.f48524a = r100;
            this.f48525b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            CommerceBaseResponse r101 = (CommerceBaseResponse) r100;
            if (r101.getStatusCode() == 0) goto L5;
            SearchProductListDataSource r102 = this.f48524a;
            int r103 = SearchProductListDataSource.f48512m;
            r102.k("0", false);
            ListStatusPositionalLoadInitialCallback r104 = this.f48525b;
            ErrorDomain.NET.getCode();
            r101.getStatusCode();
            r101.getStatusMsg();
            r104.a();
            return;
        L5:
            String r105 = null;
            if ((r101 instanceof StoreV2ProductListResponseDTO) == false) goto L9;
            StoreV2ProductListResponseVO.Companion.getClass();
            StoreV2ProductListResponseVO r106 = StoreV2ProductListResponseVO.a.a((StoreV2ProductListResponseDTO) r101, false);
        L13:
            if ((r101 instanceof StoreV3SearchResponseExpDTO) == true) goto L15;
            CommerceBaseResponse r107 = null;
        L17:
            if (((StoreV3SearchResponseExpDTO) r107) == null) goto L22;
            StoreV3SearchResponseExpDTO r108 = (StoreV3SearchResponseExpDTO) r101;
            this.f48524a.o(r108);
            StoreV2RequestParam r109 = this.f48524a.f48517f;
            LogPbDTO r110 = r108.getLogPb();
            if (r110 == null) goto L21;
            r105 = r110.getImprId();
        L21:
            r109.setSearchId(r105);
        L22:
            SearchProductListDataSource r111 = this.f48524a;
            int r112 = SearchProductListDataSource.f48512m;
            r111.k("1", false);
            if (r106 == null) goto L27;
            this.f48524a.f48517f.setCursor(Long.valueOf(r106.getCursor()));
            this.f48524a.j(r106, this.f48525b, true);
            return;
        L27:
            return;
        L15:
            r107 = r101;
            goto L17
        L9:
            if ((r101 instanceof StoreV3SearchResponseExpDTO) == false) goto L11;
            SearchProductListResponseVO.Companion.getClass();
            r106 = SearchProductListResponseVO.a.a((StoreV3SearchResponseExpDTO) r101);
            goto L13
        L11:
            r106 = null;
            goto L13
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ListStatusPositionalLoadInitialCallback f48526a;

        public c(ListStatusPositionalLoadInitialCallback r100) {
            this.f48526a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            ListStatusPositionalLoadInitialCallback r101 = this.f48526a;
            ErrorDomain.NATIVE.getCode();
            ErrorCode.NATIVE_COMMON.getCode();
            ((Throwable) r100).getMessage();
            r101.a();
        }
    }

    static {
    }

    public abstract String h(Integer r100, Integer r101);

    @Override // androidx.paging.DataSource
    public final void invalidate() {
        this.f48513b = 0;
        String r100 = this.f48515d;
        if (r100 == null) goto L5;
        this.f48517f.setKeyWord(r100);
    L5:
        this.f48517f.setFilterProductIds(null);
        this.f48517f.setCursor(0L);
        this.f48514c = null;
        this.f48517f.setFirstInit(false);
        super.invalidate();
    }

    public abstract Observable<StoreV2ProductListResponseDTO> l(Long r100, long r101);

    public abstract Observable<? extends CommerceBaseResponse> m(Long r100, long r101, String r102, String r103);

    @Override // com.bytedance.android.ec.store.shopping.paging.ListStatusPositionalDataSource
    public final boolean e() {
        return !this.f48516e;
    }

    public final void o(StoreV3SearchResponseExpDTO r100) {
        Intrinsics.checkNotNullParameter(r100, "response");
        r100.getLogPb();
        this.f48517f.setLogPb(r100.getLogPb());
    }

    @Override // com.bytedance.android.ec.store.shopping.paging.ListStatusPositionalDataSource
    public void f(PositionalDataSource.LoadInitialParams r100, ListStatusPositionalLoadInitialCallback<en.b> r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        boolean r102 = ECServiceManager.f42805a;
        String r103 = ((g) ECServiceManager.c(g.class)).getCurrentBcmChain();
        if (k.c(r103) == true) goto L6;
        r103 = null;
    L6:
        com.bytedance.android.ec.core.async.a.a(m(0L, r100.pageSize, null, r103).subscribe(new b(this, r101), new c(r101)), this.f48522k);
    }

    @Override // com.bytedance.android.ec.store.shopping.paging.ListStatusPositionalDataSource
    public void g(PositionalDataSource.LoadRangeParams r100, ListStatusPositionalLoadRangeCallback<en.b> r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        if (this.f48517f.getHasMore() == false) goto L14;
        boolean r102 = true;
        if ((this.f48513b & 1) == 1) goto L8;
        r102 = false;
    L8:
        if (r102 == true) goto L10;
        com.bytedance.android.ec.core.async.a.a(m(this.f48517f.getCursor(), r100.loadSize, this.f48517f.getSearchId(), null).subscribe(new d(this, r101, r100), new e(r101)), this.f48522k);
        return;
    L10:
        if (this.f48516e == false) goto L12;
        this.f48516e = false;
    L12:
        com.bytedance.android.ec.core.async.a.a(l(this.f48517f.getCursor(), r100.loadSize).subscribe(new an.b(this, r101, r100), new an.c(r101)), this.f48522k);
        return;
    L14:
        r101.onResult(new ArrayList());
    }

    public final void k(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "state");
        boolean r102 = ((Boolean) this.f48517f.getPassThroughParam("is_store_hot_search")).booleanValue();
        bn.a r103 = new bn.a();
        if (this.f48517f.isStore() == false) goto L5;
        String r104 = "search_store";
    L6:
        r103.f19673a = r104;
        r103.f19674b = "search_store";
        r103.f19679g = this.f48517f.getKeyWord();
        r103.f19680h = r100;
        Long r105 = this.f48517f.getSortType();
        PageFinder r106 = null;
        if (r105 == null) goto L9;
        Integer r107 = Integer.valueOf((int) r105.longValue());
    L10:
        r103.f19682j = h(r107, this.f48517f.getSort());
        LogPbDTO r108 = this.f48517f.getLogPb();
        if (r108 == null) goto L13;
        String r109 = r108.getImprId();
    L14:
        r103.f19676d = r109;
        r103.f19684l = this.f48517f.getAuthorID();
        r103.f19685m = this.f48517f.getEntranceInfo();
        r103.f19686n = this.f48517f.getFollowStatus();
        r103.f19678f = "ecom_shop_search";
        if (this.f48517f.isStore() == false) goto L17;
        String r110 = "shop";
    L18:
        r103.f19681i = r110;
        r103.f19688p = (String) this.f48517f.getPassThroughParam(com.bytedance.android.ec.core.event.a.KEY_SHOP_ID);
        r103.f19675c = u0.d(this.f48517f.getLogPb());
        if (r102 == false) goto L25;
        r103.f19677e = "shop_hot_search";
        String r111 = (String) this.f48517f.getPassThroughParam(ECFindSimilarConfig.ENTER_FROM_SECOND);
        if (k.c(r111) == false) goto L23;
        r103.f19687o = r111;
    L23:
        r103.f19678f = (String) this.f48517f.getPassThroughParam("page_name");
    L25:
        if (this.f48517f.isFromSug() == false) goto L27;
        r103.f19689q = this.f48517f.getGroupId();
        r103.f19690r = "normal_sug";
        r103.f19677e = "search_sug";
    L27:
        LogPbDTO r112 = this.f48517f.getLogPb();
        if (r112 == null) goto L30;
        String r113 = r112.getImprId();
    L31:
        r103.f19691s = r113;
        r103.f19694v = this.f48518g.getEnterMethod();
        r103.f19677e = this.f48518g.getEnterMethod();
        r103.f19692t = this.f48518g.getHotSearchMethod();
        r103.f19693u = this.f48518g.getHotSearchIconType();
        if (r101 == false) goto L34;
        String r114 = "1";
    L35:
        r103.f19695w = r114;
        Activity r115 = ECAppInfoService.f48114e.getCurrentActivity();
        if (r115 == null) goto L38;
        r106 = PageFinder.via(r115);
    L38:
        r103.post(r106, "a1.b8121.c478706.d826529");
        return;
    L34:
        r114 = "0";
        goto L35
    L30:
        r113 = null;
        goto L31
    L17:
        r110 = LiveEndPageData.TAG_WINDOW;
        goto L18
    L13:
        r109 = null;
        goto L14
    L9:
        r107 = null;
        goto L10
    L5:
        r104 = "search_window";
        goto L6
    }

    public final List<en.b> n(List<? extends StoreV2ProductItemVO> r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "products");
        List<? extends StoreV2ProductItemVO> r102 = r100;
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator<T> r104 = r102.iterator();
    L4:
        if (r104.hasNext() == false) goto L10;
        StoreV2ProductItemVO r105 = (StoreV2ProductItemVO) r104.next();
        if (r101 == false) goto L8;
        en.b r106 = new en.d(r105);
    L9:
        r103.add(r106);
        goto L4
    L8:
        r106 = new en.e(r105);
        goto L9
    L10:
        List<en.b> r107 = CollectionsKt.toMutableList(r103);
        en.c r108 = this.f48514c;
        if (r108 != null) goto L13;
    L16:
        return r107;
    L13:
        if ((!r107.isEmpty()) == false) goto L15;
        ListProtector.add(r107, 0, r108);
    L15:
        this.f48514c = null;
        goto L16
    }

    public final void i(StoreV2ProductListResponseVO r100, PositionalDataSource.LoadRangeParams r101, ListStatusPositionalLoadRangeCallback<en.b> r102) {
        Intrinsics.checkNotNullParameter(r100, "response");
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        Function1<StoreV2ProductListResponseVO, Unit> r103 = this.f48523l;
        if (r103 == null) goto L5;
        Unit r104 = r103.invoke(r100);
    L5:
        boolean r105 = true;
        if ((!r100.getProducts().isEmpty()) == false) goto L22;
        int r106 = this.f48513b;
        if ((r106 & 1) != 1) goto L10;
        boolean r107 = true;
    L11:
        if (r107 == false) goto L22;
        if ((r106 & 2) != 2) goto L15;
        boolean r108 = true;
    L16:
        if (r108 == true) goto L22;
        this.f48513b = r106 | 2;
        if (r101.startPosition != 0) goto L20;
        boolean r109 = true;
    L21:
        this.f48514c = new en.c(r109, true);
        goto L22
    L20:
        r109 = false;
        goto L21
    L15:
        r108 = false;
        goto L16
    L10:
        r107 = false;
    L22:
        List<StoreV2ProductItemVO> r110 = r100.getProducts();
        String r111 = this.f48517f.getKeyWord();
        if (r111 != null) goto L25;
    L28:
        r102.onResult(n(r110, r105));
        this.f48517f.setHasMore(r100.getHasMore());
        this.f48517f.setCursor(Long.valueOf(r100.getCursor()));
        return;
    L25:
        if (r111.length() == 0) goto L28;
        r105 = false;
        goto L28
    }

    public final void j(StoreV2ProductListResponseVO r100, ListStatusPositionalLoadInitialCallback<en.b> r101, boolean r110) {
        Intrinsics.checkNotNullParameter(r100, "response");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Function1<StoreV2ProductListResponseVO, Unit> r102 = this.f48523l;
        if (r102 == null) goto L5;
        Unit r103 = r102.invoke(r100);
    L5:
        jm.a<List<q>> r104 = this.f48519h;
        if (r104 == null) goto L8;
        List<q> r105 = r104.getValue();
    L9:
        if (r105 != null) goto L13;
        jm.a<List<q>> r106 = this.f48519h;
        if (r106 == null) goto L13;
        r106.c(r100.getGoodTypes());
    L13:
        jm.a<List<r>> r107 = this.f48520i;
        if (r107 == null) goto L16;
        List<r> r108 = r107.getValue();
    L17:
        if (r108 != null) goto L22;
        jm.a<List<r>> r109 = this.f48520i;
        if (r109 == null) goto L22;
        r109.c(r100.getSortTypes());
    L22:
        if (k.c(r100.getMaterialTitle()) == false) goto L32;
        jm.a<String> r111 = this.f48521j;
        if (r111 == null) goto L26;
        String r112 = r111.getValue();
    L27:
        if (r112 != null) goto L32;
        jm.a<String> r113 = this.f48521j;
        if (r113 == null) goto L32;
        r113.c(r100.getMaterialTitle());
        goto L32
    L26:
        r112 = null;
    L32:
        if ((!r100.getProducts().isEmpty()) == true) goto L34;
    L48:
        this.f48517f.setHasMore(r100.getHasMore());
        StoreV2RequestParam r114 = this.f48517f;
        List<q> r115 = r100.getGoodTypes();
        if (r115 == null) goto L60;
        Iterator<T> r116 = r115.iterator();
    L52:
        if (r116.hasNext() == false) goto L56;
        Object r117 = r116.next();
        if (((q) r117).f48478b == false) goto L52;
    L57:
        q r118 = (q) r117;
        if (r118 == null) goto L60;
        Long r119 = Long.valueOf(r118.f48477a);
    L61:
        r114.setGoodsType(r119);
        if (r110 == false) goto L95;
        List<StoreV2ProductItemVO> r120 = r100.getProducts();
        LoadEvent.a r121 = LoadEvent.Companion;
        int r122 = r120.size();
        r121.getClass();
        if (r122 != 0) goto L66;
        LoadEvent r123 = LoadEvent.RECOMMEND_ON_NO_RESULT;
    L69:
        int r124 = an.a.f4478a[r123.ordinal()];
        if (r124 != 1) goto L72;
        return;
    L72:
        if (r124 != 2) goto L74;
    L76:
        this.f48515d = this.f48517f.getKeyWord();
        this.f48517f.setKeyWord(null);
        this.f48517f.setCursor(0L);
        this.f48517f.setHasMore(true);
        this.f48513b = 1;
    L77:
        int r125 = an.a.f4479b[r123.ordinal()];
        if (r125 == 1) goto L89;
        if (r125 == 2) goto L82;
        return;
    L82:
        if (r120.isEmpty() == true) goto L99;
        StringBuilder r126 = new StringBuilder();
        Iterator<T> r127 = r120.iterator();
    L86:
        if (r127.hasNext() == false) goto L88;
        r126.append(((StoreV2ProductItemVO) r127.next()).f48421a);
        r126.append(",");
        goto L86
    L88:
        r126.deleteCharAt(r126.length() - 1);
        this.f48517f.setFilterProductIds(r126.toString());
        return;
    L99:
        return;
    L89:
        com.bytedance.android.ec.core.async.a.a(l(0L, this.f48517f.getSize()).subscribe(new f(this, r101), new an.g(r101)), this.f48522k);
        return;
    L74:
        if (r124 == 3) goto L76;
    L66:
        if (r122 > 6) goto L68;
        r123 = LoadEvent.RECOMMEND_ON_LESS_RESULT;
        goto L69
    L68:
        r123 = LoadEvent.NORMAL;
        goto L69
    L95:
        return;
    L56:
        r117 = null;
    L60:
        r119 = null;
        goto L61
    L34:
        if (r110 == true) goto L36;
    L40:
        List<StoreV2ProductItemVO> r128 = r100.getProducts();
        String r129 = this.f48517f.getKeyWord();
        if (r129 != null) goto L43;
    L46:
        boolean r130 = true;
    L47:
        r101.onResult(n(r128, r130), 0);
        goto L48
    L43:
        if (r129.length() == 0) goto L46;
        r130 = false;
        goto L47
    L36:
        if (r100.getProducts().size() > 6) goto L38;
        boolean r131 = true;
    L39:
        this.f48516e = r131;
        goto L40
    L38:
        r131 = false;
        goto L39
    L16:
        r108 = null;
        goto L17
    L8:
        r105 = null;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SearchProductListDataSource(StoreV2RequestParam r100, ECShopSearchParam r101, jm.a<List<q>> r102, jm.a<List<r>> r103, QLiveData<LoadStatus> r104, jm.a<String> r105, com.bytedance.android.ec.core.async.b r106, Function1<? super StoreV2ProductListResponseVO, Unit> r107) {
        Intrinsics.checkNotNullParameter(r100, "reqParam");
        Intrinsics.checkNotNullParameter(r101, "searchParam");
        Intrinsics.checkNotNullParameter(r104, "loadStatus");
        Intrinsics.checkNotNullParameter(r106, "disposableScope");
        super(r104);
        this.f48517f = r100;
        this.f48518g = r101;
        this.f48519h = r102;
        this.f48520i = r103;
        this.f48521j = r105;
        this.f48522k = r106;
        this.f48523l = r107;
    }
}
