package com.bytedance.android.shopping.store.search.viewmodel;

import android.view.View;
import androidx.lifecycle.LiveData;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.core.arch.viewmodel.BaseViewModel;
import com.bytedance.android.ec.store.common.param.StoreV2RequestParam;
import com.bytedance.android.ec.store.product.holder.LayoutTypes;
import com.bytedance.android.ec.store.repository.vo.StoreV2ProductItemVO;
import com.bytedance.android.ec.store.repository.vo.StoreV2ProductListResponseVO;
import com.bytedance.android.ec.store.repository.vo.p;
import com.bytedance.android.ec.store.repository.vo.q;
import com.bytedance.android.ec.store.repository.vo.r;
import com.bytedance.android.ec.store.search.datasource.SearchResultDataSourceFactory;
import com.bytedance.android.ec.store.setting.SettingKeys;
import com.bytedance.android.ec.store.shopping.paging.LoadStatus;
import com.bytedance.android.shopping.store.search.datasource.ShopSearchDataSourceFactory;
import com.bytedance.android.shopping.store.search.router.ECShopSearchParam;
import com.ss.android.ugc.aweme.discover.model.commodity.select.RenderLine;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import s83.f;
import s83.g;
import xm.c;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000Ô\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\t¢\u0006\u0006\b\u0090\u0001\u0010\u0091\u0001J\u0014\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0019\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J \u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0017\u001a\u00020\u0016J\u0006\u0010\u0019\u001a\u00020\u0006J!\u0010\u001d\u001a\u00020\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u001d\u0010\u001eJ\u0006\u0010 \u001a\u00020\u001fJ\u0006\u0010!\u001a\u00020\u0006J\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020#0\"R\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0014\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0017\u0010+\u001a\u00020*8\u0006¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R$\u0010\u0015\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001d\u00106\u001a\b\u0012\u0004\u0012\u000205048\u0006¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109R#\u0010=\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020<0;0:8\u0006¢\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@R#\u0010B\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020A0;0:8\u0006¢\u0006\f\n\u0004\bB\u0010>\u001a\u0004\bC\u0010@R%\u0010E\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060D0:8\u0006¢\u0006\f\n\u0004\bE\u0010>\u001a\u0004\bF\u0010@R#\u0010G\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160D0:8\u0006¢\u0006\f\n\u0004\bG\u0010>\u001a\u0004\bH\u0010@R\u001d\u0010I\u001a\b\u0012\u0004\u0012\u00020\u001f0:8\u0006¢\u0006\f\n\u0004\bI\u0010>\u001a\u0004\bJ\u0010@R\u0016\u0010\u0017\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010KR\"\u0010L\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bL\u0010K\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\u0017\u0010P\u001a\u00020\u001f8\u0006¢\u0006\f\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010SR'\u0010V\u001a\u0012\u0012\u0004\u0012\u00020\u001f0Tj\b\u0012\u0004\u0012\u00020\u001f`U8\u0006¢\u0006\f\n\u0004\bV\u0010W\u001a\u0004\bX\u0010YR?\u0010^\u001a\u001f\u0012\u0013\u0012\u00110\b¢\u0006\f\b[\u0012\b\b\\\u0012\u0004\b\b(]\u0012\u0004\u0012\u00020\u0006\u0018\u00010Z8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b^\u0010_\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR\u001d\u0010e\u001a\b\u0012\u0004\u0012\u00020d0:8\u0006¢\u0006\f\n\u0004\be\u0010>\u001a\u0004\bf\u0010@R$\u0010h\u001a\u0004\u0018\u00010g8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bh\u0010i\u001a\u0004\bj\u0010k\"\u0004\bl\u0010mR\"\u0010n\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bn\u0010K\u001a\u0004\bo\u0010M\"\u0004\bp\u0010OR\"\u0010q\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bq\u0010K\u001a\u0004\br\u0010M\"\u0004\bs\u0010OR\u0017\u0010u\u001a\u00020t8\u0006¢\u0006\f\n\u0004\bu\u0010v\u001a\u0004\bw\u0010xR\u0016\u0010z\u001a\u00020y8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bz\u0010{R0\u0010|\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00028\u0006@\u0006X\u0086.¢\u0006\u0014\n\u0004\b|\u0010}\u001a\u0004\b~\u0010\u007f\"\u0006\b\u0080\u0001\u0010\u0081\u0001R(\u0010\u0082\u0001\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060D0:8\u0006¢\u0006\u000e\n\u0005\b\u0082\u0001\u0010>\u001a\u0005\b\u0083\u0001\u0010@R,\u0010\u0085\u0001\u001a\u0005\u0018\u00010\u0084\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0085\u0001\u0010\u0086\u0001\u001a\u0006\b\u0087\u0001\u0010\u0088\u0001\"\u0006\b\u0089\u0001\u0010\u008a\u0001R \u0010\u008b\u0001\u001a\b\u0012\u0004\u0012\u00020\r0:8\u0006¢\u0006\u000e\n\u0005\b\u008b\u0001\u0010>\u001a\u0005\b\u008c\u0001\u0010@R\u0018\u0010\u008d\u0001\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u008d\u0001\u0010KR&\u0010\u008e\u0001\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u008e\u0001\u0010K\u001a\u0005\b\u008e\u0001\u0010M\"\u0005\b\u008f\u0001\u0010O¨\u0006\u0092\u0001"}, d2 = {"Lcom/bytedance/android/shopping/store/search/viewmodel/ShopSearchFragmentProductViewModel;", "Lcom/bytedance/android/ec/core/arch/viewmodel/BaseViewModel;", "Landroidx/lifecycle/LiveData;", "Landroidx/paging/PagedList;", "Len/b;", "makeLivePageList", "", "initDataSource", "", "typeFromServer", "setLayoutTypeIfNeedOnce", "(Ljava/lang/Integer;)V", RenderLine.STRATEGY_SERVER, "Lcom/bytedance/android/ec/store/product/holder/LayoutTypes;", "getRealLayoutType", "(Ljava/lang/Integer;)Lcom/bytedance/android/ec/store/product/holder/LayoutTypes;", "Lcom/bytedance/android/ec/store/repository/vo/StoreV2ProductListResponseVO;", "response", "getVideoData", "Lcom/bytedance/android/shopping/store/search/router/ECShopSearchParam;", "searchParam", "initialData", "", "showSortBar", "init", "refresh", "", "sortType", "sort", "refreshBySortAndSortType", "(Ljava/lang/Long;Ljava/lang/Integer;)V", "", "getPublicityText", "stopPlayVideo", "", "", "getAdParams", "Lcom/bytedance/android/shopping/store/search/router/ECShopSearchParam;", "getSearchParam", "()Lcom/bytedance/android/shopping/store/search/router/ECShopSearchParam;", "setSearchParam", "(Lcom/bytedance/android/shopping/store/search/router/ECShopSearchParam;)V", "Lcom/bytedance/android/ec/store/common/param/StoreV2RequestParam;", "requestParam", "Lcom/bytedance/android/ec/store/common/param/StoreV2RequestParam;", "getRequestParam", "()Lcom/bytedance/android/ec/store/common/param/StoreV2RequestParam;", "Lcom/bytedance/android/ec/store/repository/vo/StoreV2ProductListResponseVO;", "getInitialData", "()Lcom/bytedance/android/ec/store/repository/vo/StoreV2ProductListResponseVO;", "setInitialData", "(Lcom/bytedance/android/ec/store/repository/vo/StoreV2ProductListResponseVO;)V", "Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QLiveData;", "Lcom/bytedance/android/ec/store/shopping/paging/LoadStatus;", "loadStatus", "Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QLiveData;", "getLoadStatus", "()Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QLiveData;", "Ljm/a;", "", "Lcom/bytedance/android/ec/store/repository/vo/q;", "goodTypes", "Ljm/a;", "getGoodTypes", "()Ljm/a;", "Lcom/bytedance/android/ec/store/repository/vo/r;", "sortTypes", "getSortTypes", "Lrg/a;", "updateVideoDataAction", "getUpdateVideoDataAction", "playVideoAction", "getPlayVideoAction", "materialTitle", "getMaterialTitle", "Z", "isPlayingVideo", "()Z", "setPlayingVideo", "(Z)V", "sessionId", "Ljava/lang/String;", "getSessionId", "()Ljava/lang/String;", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "idRecords", "Ljava/util/HashSet;", "getIdRecords", "()Ljava/util/HashSet;", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "count", "myCartListener", "Lkotlin/jvm/functions/Function1;", "getMyCartListener", "()Lkotlin/jvm/functions/Function1;", "setMyCartListener", "(Lkotlin/jvm/functions/Function1;)V", "Lcom/bytedance/android/ec/store/repository/vo/p;", "cartsInfo", "getCartsInfo", "Landroid/view/View;", "destView", "Landroid/view/View;", "getDestView", "()Landroid/view/View;", "setDestView", "(Landroid/view/View;)V", "observeFlag", "getObserveFlag", "setObserveFlag", "reportFlag", "getReportFlag", "setReportFlag", "Lxm/c;", "tagPools", "Lxm/c;", "getTagPools", "()Lxm/c;", "Lcom/bytedance/android/ec/store/search/datasource/SearchResultDataSourceFactory;", "dataSourceFactory", "Lcom/bytedance/android/ec/store/search/datasource/SearchResultDataSourceFactory;", "products", "Landroidx/lifecycle/LiveData;", "getProducts", "()Landroidx/lifecycle/LiveData;", "setProducts", "(Landroidx/lifecycle/LiveData;)V", "refreshAction", "getRefreshAction", "Lcom/bytedance/android/ec/store/repository/vo/StoreV2ProductItemVO;", "currentPlayingItem", "Lcom/bytedance/android/ec/store/repository/vo/StoreV2ProductItemVO;", "getCurrentPlayingItem", "()Lcom/bytedance/android/ec/store/repository/vo/StoreV2ProductItemVO;", "setCurrentPlayingItem", "(Lcom/bytedance/android/ec/store/repository/vo/StoreV2ProductItemVO;)V", "layoutType", "getLayoutType", "layoutSet", "isExchangeLayout", "setExchangeLayout", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShopSearchFragmentProductViewModel extends BaseViewModel {
    private final jm.a<p> cartsInfo;
    private StoreV2ProductItemVO currentPlayingItem;
    private SearchResultDataSourceFactory dataSourceFactory;
    private View destView;
    private final jm.a<List<q>> goodTypes;
    private final HashSet<String> idRecords;
    private StoreV2ProductListResponseVO initialData;
    private boolean isExchangeLayout;
    private boolean isPlayingVideo;
    private boolean layoutSet;
    private final jm.a<LayoutTypes> layoutType;
    private final QLiveData<LoadStatus> loadStatus;
    private final jm.a<String> materialTitle;
    private Function1<? super Integer, Unit> myCartListener;
    private boolean observeFlag;
    private final jm.a<rg.a<Boolean>> playVideoAction;
    public LiveData<PagedList<en.b>> products;
    private final jm.a<rg.a<Unit>> refreshAction;
    private boolean reportFlag;
    private final StoreV2RequestParam requestParam;
    public ECShopSearchParam searchParam;
    private final String sessionId;
    private boolean showSortBar;
    private final jm.a<List<r>> sortTypes;
    private final c tagPools;
    private final jm.a<rg.a<Unit>> updateVideoDataAction;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ShopSearchFragmentProductViewModel f186135a;

        public a(ShopSearchFragmentProductViewModel r100) {
            this.f186135a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Boolean r101 = (Boolean) r100;
            this.f186135a.getUpdateVideoDataAction().c(new rg.a(null));
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f186136a = null;

        static {
            f186136a = new b();
        }

        public b() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            ((Throwable) r100).printStackTrace();
        }
    }

    public ShopSearchFragmentProductViewModel() {
        super(null, null, 3, null);
        this.requestParam = new StoreV2RequestParam();
        this.loadStatus = new QLiveData();
        this.goodTypes = new jm.a(7);
        this.sortTypes = new jm.a(7);
        this.updateVideoDataAction = new jm.a(7);
        this.playVideoAction = new jm.a(7);
        this.materialTitle = new jm.a(7);
        this.showSortBar = true;
        this.sessionId = UUID.randomUUID().toString();
        this.idRecords = new HashSet();
        this.cartsInfo = new jm.a(7);
        this.tagPools = new c();
        this.refreshAction = new jm.a(7);
        jm.a<LayoutTypes> r100 = new jm.a(7);
        r100.setValue(LayoutTypes.RECYCLER_VIEW_ITEM_DOUBLE);
        Unit r101 = Unit.INSTANCE;
        this.layoutType = r100;
    }

    public final Map<String, Object> getAdParams() {
        Pair[] r100 = new Pair[6];
        ECShopSearchParam r101 = this.searchParam;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("searchParam");
    L5:
        r100[0] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_SHOP_ID, r101.getShopId());
        r100[1] = TuplesKt.to("category", "umeng");
        ECShopSearchParam r102 = this.searchParam;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("searchParam");
    L8:
        r100[2] = TuplesKt.to("room_id", r102.getRoomId());
        ECShopSearchParam r103 = this.searchParam;
        if (r103 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("searchParam");
    L11:
        r100[3] = TuplesKt.to("anchor_id", r103.getAnchorId());
        String r104 = this.requestParam.getSearchId();
        if (r104 != null) goto L14;
        r104 = "";
    L14:
        r100[4] = TuplesKt.to("search_id", r104);
        ECShopSearchParam r105 = this.searchParam;
        if (r105 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("searchParam");
    L17:
        r100[5] = TuplesKt.to("search_keyword", r105.getSearchKeyword());
        return MapsKt.mutableMapOf(r100);
    }

    private final void initDataSource() {
        StoreV2RequestParam r100 = this.requestParam;
        ECShopSearchParam r101 = this.searchParam;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("searchParam");
    L5:
        this.dataSourceFactory = new ShopSearchDataSourceFactory(r100, r101, this.goodTypes, this.sortTypes, this.loadStatus, this.materialTitle, this, new AnonymousClass1(this));
        this.products = makeLivePageList();
    }

    private final LiveData<PagedList<en.b>> makeLivePageList() {
        PagedList.Config.Builder r100 = new PagedList.Config.Builder();
        r100.setPageSize(this.requestParam.getSize());
        r100.setInitialLoadSizeHint(this.requestParam.getSize());
        r100.setPrefetchDistance(this.requestParam.getSize());
        r100.setEnablePlaceholders(false);
        PagedList.Config r101 = r100.build();
        SearchResultDataSourceFactory r102 = this.dataSourceFactory;
        if (r102 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("dataSourceFactory");
    L6:
        return new LivePagedListBuilder(r102, r101).build();
    }

    public final LiveData<PagedList<en.b>> getProducts() {
        LiveData<PagedList<en.b>> r100 = this.products;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("products");
    L5:
        return r100;
    }

    public final ECShopSearchParam getSearchParam() {
        ECShopSearchParam r100 = this.searchParam;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("searchParam");
    L5:
        return r100;
    }

    public final void refresh() {
        this.requestParam.setGoodsType(2L);
        this.refreshAction.setValue(new rg.a(null));
        SearchResultDataSourceFactory r100 = this.dataSourceFactory;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("dataSourceFactory");
    L5:
        r100.a();
        this.idRecords.clear();
        this.requestParam.setHasMore(true);
        stopPlayVideo();
    }

    public final void stopPlayVideo() {
        StoreV2ProductItemVO r100 = this.currentPlayingItem;
        if (r100 == null) goto L8;
        QLiveData<StoreV2ProductItemVO.b> r101 = r100.f48437q;
        if (r101 == null) goto L9;
        r101.g(new StoreV2ProductItemVO.b(0));
        return;
    L9:
        return;
    }

    public final String getPublicityText() {
        return StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(SettingKeys.getSTORE_V2_PUBLICITY_TEXT(), "newline_placeholder", "\n", false, 4, null), "\\n", "\n", false, 4, null), "name_placeholder", "", false, 4, null);
    }

    public final jm.a<p> getCartsInfo() {
        return this.cartsInfo;
    }

    public final StoreV2ProductItemVO getCurrentPlayingItem() {
        return this.currentPlayingItem;
    }

    public final View getDestView() {
        return this.destView;
    }

    public final jm.a<List<q>> getGoodTypes() {
        return this.goodTypes;
    }

    public final HashSet<String> getIdRecords() {
        return this.idRecords;
    }

    public final StoreV2ProductListResponseVO getInitialData() {
        return this.initialData;
    }

    public final jm.a<LayoutTypes> getLayoutType() {
        return this.layoutType;
    }

    public final QLiveData<LoadStatus> getLoadStatus() {
        return this.loadStatus;
    }

    public final jm.a<String> getMaterialTitle() {
        return this.materialTitle;
    }

    public final Function1<Integer, Unit> getMyCartListener() {
        return this.myCartListener;
    }

    public final boolean getObserveFlag() {
        return this.observeFlag;
    }

    public final jm.a<rg.a<Boolean>> getPlayVideoAction() {
        return this.playVideoAction;
    }

    public final jm.a<rg.a<Unit>> getRefreshAction() {
        return this.refreshAction;
    }

    public final boolean getReportFlag() {
        return this.reportFlag;
    }

    public final StoreV2RequestParam getRequestParam() {
        return this.requestParam;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final jm.a<List<r>> getSortTypes() {
        return this.sortTypes;
    }

    public final c getTagPools() {
        return this.tagPools;
    }

    public final jm.a<rg.a<Unit>> getUpdateVideoDataAction() {
        return this.updateVideoDataAction;
    }

    public final boolean isExchangeLayout() {
        return this.isExchangeLayout;
    }

    public final boolean isPlayingVideo() {
        return this.isPlayingVideo;
    }

    public static final /* synthetic */ boolean access$getLayoutSet$p(ShopSearchFragmentProductViewModel r100) {
        return r100.layoutSet;
    }

    private final LayoutTypes getRealLayoutType(Integer r100) {
        LayoutTypes r101 = LayoutTypes.RECYCLER_VIEW_ITEM_SINGLE;
        int r102 = r101.getType();
        if (r100 != null) goto L6;
    L8:
        r101 = LayoutTypes.RECYCLER_VIEW_ITEM_DOUBLE;
        r101.getType();
        if (r100 == null) goto L12;
        r100.intValue();
    L12:
        return r101;
    L6:
        if (r100.intValue() != r102) goto L8;
        goto L8
    }

    private final void getVideoData(StoreV2ProductListResponseVO r100) {
        List<StoreV2ProductItemVO> r101 = r100.getProducts();
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L8;
        String r104 = ((StoreV2ProductItemVO) r103.next()).f48432l;
        if (r104 == null) goto L4;
        r102.add(r104);
        goto L4
    L8:
        Observable<Boolean> r105 = null;
        if ((!r102.isEmpty()) == true) goto L12;
        r102 = null;
    L12:
        if (r102 != null) goto L14;
        return;
    L14:
        boolean r106 = ECServiceManager.f42805a;
        f r107 = ((g) ECServiceManager.c(g.class)).p();
        if (r107 == null) goto L17;
        r105 = r107.l(r102);
    L17:
        com.bytedance.android.ec.core.async.a.a(Single.fromObservable(r105).subscribeOn(Schedulers.io()).observeOn(Schedulers.io()).subscribe(new a(this), b.f186136a), this);
    }

    private final void setLayoutTypeIfNeedOnce(Integer r100) {
        LayoutTypes r101 = getRealLayoutType(r100);
        if (this.layoutType.getValue() == r101) goto L6;
        this.layoutType.c(r101);
        return;
    }

    public final void setCurrentPlayingItem(StoreV2ProductItemVO r100) {
        this.currentPlayingItem = r100;
    }

    public final void setDestView(View r100) {
        this.destView = r100;
    }

    public final void setExchangeLayout(boolean r100) {
        this.isExchangeLayout = r100;
    }

    public final void setInitialData(StoreV2ProductListResponseVO r100) {
        this.initialData = r100;
    }

    public final void setMyCartListener(Function1<? super Integer, Unit> r100) {
        this.myCartListener = r100;
    }

    public final void setObserveFlag(boolean r100) {
        this.observeFlag = r100;
    }

    public final void setPlayingVideo(boolean r100) {
        this.isPlayingVideo = r100;
    }

    public final void setProducts(LiveData<PagedList<en.b>> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.products = r100;
    }

    public final void setReportFlag(boolean r100) {
        this.reportFlag = r100;
    }

    public final void setSearchParam(ECShopSearchParam r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.searchParam = r100;
    }

    public static final /* synthetic */ void access$getVideoData(ShopSearchFragmentProductViewModel r100, StoreV2ProductListResponseVO r101) {
        r100.getVideoData(r101);
    }

    public static final /* synthetic */ void access$setLayoutSet$p(ShopSearchFragmentProductViewModel r100, boolean r101) {
        r100.layoutSet = r101;
    }

    public static final /* synthetic */ void access$setLayoutTypeIfNeedOnce(ShopSearchFragmentProductViewModel r100, Integer r101) {
        r100.setLayoutTypeIfNeedOnce(r101);
    }

    public final void refreshBySortAndSortType(Long r100, Integer r101) {
        this.requestParam.setSort(r101);
        this.requestParam.setSortType(r100);
        refresh();
    }

    public final void init(ECShopSearchParam r100, StoreV2ProductListResponseVO r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "searchParam");
        this.searchParam = r100;
        this.initialData = r101;
        this.showSortBar = r102;
        StoreV2RequestParam r103 = this.requestParam;
        r103.setStore(true);
        r103.setSecShopId(r100.getSecShopId());
        r103.setTmpId(r100.getProductBasicRequestParam().getTmpId());
        r103.setToken(r100.getProductBasicRequestParam().getToken());
        r103.setMaterialId(r100.getProductBasicRequestParam().getMaterialId());
        r103.setCustom(r100.getProductBasicRequestParam().isCustom());
        r103.setEntrances(r100.getProductBasicRequestParam().getEntrances());
        r103.setCustomIds(r100.getProductBasicRequestParam().getCustomIds());
        r103.setCustomIdType(r100.getProductBasicRequestParam().getCustomIdType());
        r103.setCursor(Long.valueOf(r100.getProductBasicRequestParam().getCursor()));
        r103.setKeyWord(r100.getSearchKeyword());
        r103.setHistory(r100.isHistory());
        r103.setPassThroughParams(r100.getPassThroughParams());
        r103.setAuthorID(r100.getAuthorId());
        r103.setEntranceInfo(r100.getEntranceInfo());
        Integer r104 = r100.getFollowStatus();
        if (r104 != null) goto L6;
    L8:
        String r105 = "1";
    L9:
        r103.setFollowStatus(r105);
        r103.setFromSug(r100.isFromSug());
        r103.setGroupId(r100.getGroupId());
        r103.setSearchSource(r100.getSearchSource());
        initDataSource();
        this.requestParam.setGoodsType(2L);
        return;
    L6:
        if (r104.intValue() != (-1)) goto L8;
        r105 = "0";
        goto L9
    }
}
