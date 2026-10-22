package com.bytedance.android.shopping.sameproduct.viewmodel;

import android.text.TextUtils;
import com.bytedance.android.ec.core.async.DisposableScope;
import com.bytedance.android.ec.core.async.b;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.ec.model.sku.SkuRestoreState;
import com.bytedance.android.shopping.anchorv3.repository.api.AnchorV3PromotionRequestParam;
import com.bytedance.android.shopping.anchorv3.repository.dto.InnerFlowPageStyleDTO;
import com.bytedance.android.shopping.feed.model.InflowGuessFeedResponse;
import com.bytedance.android.shopping.feed.repository.api.InnerGuessULikeApi;
import com.bytedance.android.shopping.feed.utils.d0;
import com.bytedance.android.shopping.feed.utils.g;
import com.bytedance.android.shopping.feed.utils.m;
import com.bytedance.android.shopping.sameproduct.model.SameProductPageParams;
import com.bytedance.jedi.arch.JediViewModel;
import com.bytedance.jedi.arch.State;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;
import rd3.l;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 _2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001`B\u0007¢\u0006\u0004\b]\u0010^J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0014J\u0010\u0010\n\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004J\u0006\u0010\f\u001a\u00020\tJ\u000e\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u0010\u001a\u00020\tJ\u0011\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0096\u0001J\t\u0010\u0014\u001a\u00020\tH\u0096\u0001J\t\u0010\u0016\u001a\u00020\u0015H\u0096\u0001J\u0011\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0011H\u0096\u0001R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R$\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010!\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001c\u0010)\u001a\b\u0012\u0004\u0012\u00020(0'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010,\u001a\u00020+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010-R\u0018\u0010/\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0017\u00102\u001a\u0002018\u0006¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\"\u00106\u001a\u00020+8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b6\u0010-\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R$\u0010<\u001a\u0004\u0018\u00010;8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR$\u0010B\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\"\u0010I\u001a\u00020H8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bI\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\"\u0010O\u001a\u00020H8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bO\u0010J\u001a\u0004\bO\u0010L\"\u0004\bP\u0010NR2\u0010S\u001a\u0012\u0012\u0004\u0012\u00020\u00060Qj\b\u0012\u0004\u0012\u00020\u0006`R8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bS\u0010T\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\"\u0010Y\u001a\u00020H8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bY\u0010J\u001a\u0004\bY\u0010L\"\u0004\bZ\u0010NR\"\u0010[\u001a\u00020H8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b[\u0010J\u001a\u0004\b[\u0010L\"\u0004\b\\\u0010N¨\u0006a"}, d2 = {"Lcom/bytedance/android/shopping/sameproduct/viewmodel/SameProductViewModel;", "Lcom/bytedance/jedi/arch/JediViewModel;", "Lcom/bytedance/android/shopping/sameproduct/viewmodel/SameProductState;", "Lcom/bytedance/android/ec/core/async/b;", "Lcom/bytedance/android/shopping/sameproduct/model/SameProductPageParams;", "params", "", "getFilterProductIds", "defaultState", "", "setPageParams", "getPageParams", "loadMainProductCard", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductStruct;", "promotionResult", "updatePromotion", "loadSameProductList", "Lio/reactivex/disposables/Disposable;", "disposable", "add", "clearDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "compositeDisposable", "remove", "sameProductPageParams", "Lcom/bytedance/android/shopping/sameproduct/model/SameProductPageParams;", "Lcom/bytedance/android/shopping/anchorv3/repository/dto/InnerFlowPageStyleDTO;", "innerFlowPageStyle", "Lcom/bytedance/android/shopping/anchorv3/repository/dto/InnerFlowPageStyleDTO;", "getInnerFlowPageStyle", "()Lcom/bytedance/android/shopping/anchorv3/repository/dto/InnerFlowPageStyleDTO;", "setInnerFlowPageStyle", "(Lcom/bytedance/android/shopping/anchorv3/repository/dto/InnerFlowPageStyleDTO;)V", "mainCardPromotion", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductStruct;", "getMainCardPromotion", "()Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductStruct;", "setMainCardPromotion", "(Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductStruct;)V", "", "", "productHeaderList", "Ljava/util/List;", "", "listPage", "I", "listCursor", "sameProductListDisposable", "Lio/reactivex/disposables/Disposable;", "Lcom/bytedance/android/shopping/feed/utils/m;", "filterProductHelper", "Lcom/bytedance/android/shopping/feed/utils/m;", "getFilterProductHelper", "()Lcom/bytedance/android/shopping/feed/utils/m;", "productListStyle", "getProductListStyle", "()I", "setProductListStyle", "(I)V", "Lcom/bytedance/android/ec/model/sku/SkuRestoreState;", "skuPanelState", "Lcom/bytedance/android/ec/model/sku/SkuRestoreState;", "getSkuPanelState", "()Lcom/bytedance/android/ec/model/sku/SkuRestoreState;", "setSkuPanelState", "(Lcom/bytedance/android/ec/model/sku/SkuRestoreState;)V", "ecomSceneId", "Ljava/lang/String;", "getEcomSceneId", "()Ljava/lang/String;", "setEcomSceneId", "(Ljava/lang/String;)V", "", "hasFirstLoadedProductList", "Z", "getHasFirstLoadedProductList", "()Z", "setHasFirstLoadedProductList", "(Z)V", "isFirstLoadList", "setFirstLoadList", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "showedProductIds", "Ljava/util/HashSet;", "getShowedProductIds", "()Ljava/util/HashSet;", "setShowedProductIds", "(Ljava/util/HashSet;)V", "isMainProductApiError", "setMainProductApiError", "isProductListApiError", "setProductListApiError", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SameProductViewModel extends JediViewModel<SameProductState> implements b {
    public static final a Companion = null;
    public static final int INTERNAL_FEED_PAGE_SIZE = 6;
    private final /* synthetic */ DisposableScope $$delegate_0;
    private String ecomSceneId;
    private final m filterProductHelper;
    private boolean hasFirstLoadedProductList;
    private InnerFlowPageStyleDTO innerFlowPageStyle;
    private boolean isFirstLoadList;
    private boolean isMainProductApiError;
    private boolean isProductListApiError;
    private int listCursor;
    private int listPage;
    private PromotionProductStruct mainCardPromotion;
    private List<? extends Object> productHeaderList;
    private int productListStyle;
    private Disposable sameProductListDisposable;
    private SameProductPageParams sameProductPageParams;
    private HashSet<String> showedProductIds;
    private SkuRestoreState skuPanelState;

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.shopping.sameproduct.viewmodel.SameProductViewModel$loadSameProductList$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/bytedance/android/shopping/sameproduct/viewmodel/SameProductState;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
    public static final class C103971 extends Lambda implements Function1<SameProductState, Unit> {
        final /* synthetic */ String $mainProductId;
        final /* synthetic */ SameProductViewModel this$0;

        /* JADX INFO: renamed from: com.bytedance.android.shopping.sameproduct.viewmodel.SameProductViewModel$loadSameProductList$1$2, reason: invalid class name */
        public static final class AnonymousClass2 implements Observer<InflowGuessFeedResponse> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ C103971 f182451a;

            @Override // io.reactivex.Observer
            public final void onComplete() {
                SameProductViewModel.access$setSameProductListDisposable$p(this.f182451a.this$0, null);
            }

            public AnonymousClass2(C103971 r100) {
                this.f182451a = r100;
            }

            @Override // io.reactivex.Observer
            public final void onError(Throwable r100) {
                Intrinsics.checkNotNullParameter(r100, "e");
                if (this.f182451a.this$0.isFirstLoadList() == false) goto L5;
                this.f182451a.this$0.setHasFirstLoadedProductList(true);
                this.f182451a.this$0.setFirstLoadList(false);
            L5:
                SameProductViewModel.access$setState(this.f182451a.this$0, SameProductViewModel$loadSameProductList$1$2$onError$1.INSTANCE);
                this.f182451a.this$0.setProductListApiError(true);
                ECExceptionMonitor.e(r100);
            }

            @Override // io.reactivex.Observer
            public final void onNext(InflowGuessFeedResponse r100) {
                final InflowGuessFeedResponse r101 = r100;
                Intrinsics.checkNotNullParameter(r101, "resp");
                SameProductViewModel.access$setState(this.f182451a.this$0, new SameProductViewModel$loadSameProductList$1$2$onNext$1(this, r101));
                int r102 = 0;
                this.f182451a.this$0.setProductListApiError(false);
                if (this.f182451a.this$0.isFirstLoadList() == false) goto L5;
                this.f182451a.this$0.setHasFirstLoadedProductList(true);
                this.f182451a.this$0.setFirstLoadList(false);
            L5:
                SameProductViewModel r103 = this.f182451a.this$0;
                l r104 = r101.getPage();
                if (r104 == null) goto L10;
                Integer r105 = r104.a();
                if (r105 == null) goto L10;
                r102 = r105.intValue();
            L10:
                SameProductViewModel.access$setListCursor$p(r103, r102);
                this.f182451a.this$0.getFilterProductHelper().b(r101.getFeedItemAnchors());
                SameProductViewModel r106 = this.f182451a.this$0;
                SameProductViewModel.access$setListPage$p(r106, SameProductViewModel.access$getListPage$p(r106) + 1);
            }

            @Override // io.reactivex.Observer
            public final void onSubscribe(Disposable r100) {
                Intrinsics.checkNotNullParameter(r100, "d");
                com.bytedance.android.ec.core.async.a.a(r100, this.f182451a.this$0);
                SameProductViewModel.access$setSameProductListDisposable$p(this.f182451a.this$0, r100);
            }
        }

        public C103971(SameProductViewModel r100, String r101) {
            this.this$0 = r100;
            this.$mainProductId = r101;
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SameProductState r310) {
            Intrinsics.checkNotNullParameter(r310, "it");
            if (r310.f182445d == false) goto L5;
            return;
        L5:
            if (r310.f182446e == false) goto L44;
            Disposable r100 = SameProductViewModel.access$getSameProductListDisposable$p(this.this$0);
            if (r100 == null) goto L9;
            r100.dispose();
        L9:
            SameProductViewModel.access$setState(this.this$0, C27151.INSTANCE);
            InnerGuessULikeApi.f175171a.getClass();
            InnerGuessULikeApi r101 = InnerGuessULikeApi.a.f175172a;
            if (r101 == null) goto L45;
            String r102 = this.$mainProductId;
            int r103 = SameProductViewModel.access$getListPage$p(this.this$0);
            int r104 = SameProductViewModel.access$getListCursor$p(this.this$0);
            String r105 = g.a();
            SameProductViewModel r106 = this.this$0;
            String r107 = SameProductViewModel.access$getFilterProductIds(r106, SameProductViewModel.access$getSameProductPageParams$p(r106));
            SameProductPageParams r108 = SameProductViewModel.access$getSameProductPageParams$p(this.this$0);
            if (r108 == null) goto L16;
            AnchorV3PromotionRequestParam r109 = r108.getMainCardRequestParam();
            if (r109 == null) goto L16;
            String r110 = r109.getMetaParam();
        L17:
            SameProductPageParams r111 = SameProductViewModel.access$getSameProductPageParams$p(this.this$0);
            if (r111 == null) goto L20;
            String r112 = r111.getAuthorId();
        L21:
            SameProductPageParams r113 = SameProductViewModel.access$getSameProductPageParams$p(this.this$0);
            if (r113 == null) goto L24;
            String r114 = r113.getShopId();
        L25:
            SameProductPageParams r115 = SameProductViewModel.access$getSameProductPageParams$p(this.this$0);
            if (r115 == null) goto L28;
            String r116 = r115.getVideoId();
        L29:
            String r117 = d0.a();
            SameProductPageParams r118 = SameProductViewModel.access$getSameProductPageParams$p(this.this$0);
            if (r118 == null) goto L34;
            AnchorV3PromotionRequestParam r119 = r118.getMainCardRequestParam();
            if (r119 == null) goto L34;
            Integer r210 = r119.getSameProductScene();
        L35:
            Observable r120 = InnerGuessULikeApi.b.a(r101, r102, 6, r103, com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_FLOW_PAGE, r104, r105, r107, "from_internal_feed", 7, r110, r112, null, r114, r116, r117, null, null, r210, null, null, null, null, null, false, false, null, 66947072);
            if (r120 == null) goto L46;
            Observable r121 = r120.subscribeOn(Schedulers.io());
            if (r121 == null) goto L47;
            Observable r122 = r121.observeOn(AndroidSchedulers.mainThread());
            if (r122 == null) goto L48;
            r122.subscribe(new AnonymousClass2(this));
            return;
        L48:
            return;
        L47:
            return;
        L46:
            return;
        L34:
            r210 = null;
            goto L35
        L28:
            r116 = null;
            goto L29
        L24:
            r114 = null;
            goto L25
        L20:
            r112 = null;
        L16:
            r110 = null;
            goto L17
        L45:
            return;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SameProductState r100) {
            invoke2(r100);
            return Unit.INSTANCE;
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.android.ec.core.async.b, fa3.d
    public Disposable add(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "disposable");
        this.$$delegate_0.add(r100);
        return r100;
    }

    @Override // com.bytedance.android.ec.core.async.b
    public void clearDisposable() {
        this.$$delegate_0.clearDisposable();
    }

    @Override // com.bytedance.android.ec.core.async.b
    public void remove(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "disposable");
        this.$$delegate_0.remove(r100);
    }

    @Override // com.bytedance.android.ec.core.async.b
    public CompositeDisposable compositeDisposable() {
        return this.$$delegate_0.a();
    }

    @Override // com.bytedance.jedi.arch.JediViewModel
    public SameProductState defaultState() {
        return new SameProductState(0);
    }

    public final void loadMainProductCard() {
        SameProductPageParams r100 = this.sameProductPageParams;
        if (r100 == null) goto L5;
        final String r101 = r100.getMainPromotionId();
    L7:
        if (TextUtils.isEmpty(r101) == false) goto L9;
        return;
    L9:
        SameProductPageParams r102 = this.sameProductPageParams;
        if (r102 == null) goto L16;
        final AnchorV3PromotionRequestParam r103 = r102.getMainCardRequestParam();
        if (r103 == null) goto L17;
        withState(new AnonymousClass1(this, r103, r101));
        return;
    L17:
        return;
    L16:
        return;
    L5:
        r101 = null;
        goto L7
    }

    public final void loadSameProductList() {
        SameProductPageParams r100 = this.sameProductPageParams;
        if (r100 == null) goto L6;
        String r101 = r100.getMainProductId();
        if (r101 == null) goto L6;
    L8:
        if (TextUtils.isEmpty(r101) == false) goto L10;
        return;
    L10:
        withState(new C103971(this, r101));
        return;
    L6:
        r101 = "";
        goto L8
    }

    public SameProductViewModel() {
        this.$$delegate_0 = new DisposableScope();
        this.productHeaderList = CollectionsKt.emptyList();
        this.listPage = 1;
        this.filterProductHelper = new m();
        this.isFirstLoadList = true;
        this.showedProductIds = new HashSet();
    }

    public final String getEcomSceneId() {
        return this.ecomSceneId;
    }

    public final m getFilterProductHelper() {
        return this.filterProductHelper;
    }

    public final boolean getHasFirstLoadedProductList() {
        return this.hasFirstLoadedProductList;
    }

    public final InnerFlowPageStyleDTO getInnerFlowPageStyle() {
        return this.innerFlowPageStyle;
    }

    public final PromotionProductStruct getMainCardPromotion() {
        return this.mainCardPromotion;
    }

    public final SameProductPageParams getPageParams() {
        return this.sameProductPageParams;
    }

    public final int getProductListStyle() {
        return this.productListStyle;
    }

    public final HashSet<String> getShowedProductIds() {
        return this.showedProductIds;
    }

    public final SkuRestoreState getSkuPanelState() {
        return this.skuPanelState;
    }

    public final boolean isFirstLoadList() {
        return this.isFirstLoadList;
    }

    public final boolean isMainProductApiError() {
        return this.isMainProductApiError;
    }

    public final boolean isProductListApiError() {
        return this.isProductListApiError;
    }

    @Override // com.bytedance.jedi.arch.JediViewModel
    public /* bridge */ /* synthetic */ State defaultState() {
        return defaultState();
    }

    public static final /* synthetic */ int access$getListCursor$p(SameProductViewModel r100) {
        return r100.listCursor;
    }

    public static final /* synthetic */ int access$getListPage$p(SameProductViewModel r100) {
        return r100.listPage;
    }

    public static final /* synthetic */ List access$getProductHeaderList$p(SameProductViewModel r100) {
        return r100.productHeaderList;
    }

    public static final /* synthetic */ Disposable access$getSameProductListDisposable$p(SameProductViewModel r100) {
        return r100.sameProductListDisposable;
    }

    public static final /* synthetic */ SameProductPageParams access$getSameProductPageParams$p(SameProductViewModel r100) {
        return r100.sameProductPageParams;
    }

    private final String getFilterProductIds(SameProductPageParams r100) {
        StringBuilder r101 = new StringBuilder();
        ArrayList<String> r102 = this.filterProductHelper.f175458b;
        if (r100 == null) goto L6;
        List<String> r103 = r100.getFilterProductIds();
        if (r103 == null) goto L6;
    L7:
        ArrayList r104 = new ArrayList();
        r104.addAll(r103);
        r104.addAll(r102);
        int r105 = 0;
        if ((r102.size() + r103.size()) <= 100) goto L10;
        r104.removeAll(r104.subList(0, (r102.size() + r103.size()) - 100));
    L10:
        Iterator r106 = r104.iterator();
    L12:
        if (r106.hasNext() == false) goto L21;
        Object r107 = r106.next();
        int r108 = r105 + 1;
        if (r105 >= 0) goto L16;
        CollectionsKt.throwIndexOverflow();
    L16:
        r101.append((String) r107);
        if (r105 >= (r104.size() - 1)) goto L19;
        r101.append(",");
    L19:
        r105 = r108;
        goto L12
    L21:
        return r101.toString();
    L6:
        r103 = new ArrayList();
        goto L7
    }

    public final void setEcomSceneId(String r100) {
        this.ecomSceneId = r100;
    }

    public final void setFirstLoadList(boolean r100) {
        this.isFirstLoadList = r100;
    }

    public final void setHasFirstLoadedProductList(boolean r100) {
        this.hasFirstLoadedProductList = r100;
    }

    public final void setInnerFlowPageStyle(InnerFlowPageStyleDTO r100) {
        this.innerFlowPageStyle = r100;
    }

    public final void setMainCardPromotion(PromotionProductStruct r100) {
        this.mainCardPromotion = r100;
    }

    public final void setMainProductApiError(boolean r100) {
        this.isMainProductApiError = r100;
    }

    public final void setPageParams(SameProductPageParams r100) {
        this.sameProductPageParams = r100;
        if (r100 == null) goto L5;
        String r101 = r100.getEntranceInfo();
    L6:
        JSONObject r102 = z1.g(r101);
        if (r102 == null) goto L10;
        this.ecomSceneId = r102.optString("ecom_scene_id");
        return;
    L10:
        return;
    L5:
        r101 = null;
        goto L6
    }

    public final void setProductListApiError(boolean r100) {
        this.isProductListApiError = r100;
    }

    public final void setProductListStyle(int r100) {
        this.productListStyle = r100;
    }

    public final void setShowedProductIds(HashSet<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.showedProductIds = r100;
    }

    public final void setSkuPanelState(SkuRestoreState r100) {
        this.skuPanelState = r100;
    }

    public final void updatePromotion(PromotionProductStruct r100) {
        Intrinsics.checkNotNullParameter(r100, "promotionResult");
        this.mainCardPromotion = r100;
        if (this.productHeaderList.isEmpty() == false) goto L8;
        ArrayList r101 = new ArrayList();
        PromotionProductStruct r102 = this.mainCardPromotion;
        if (r102 == null) goto L7;
        r101.add(r102);
    L7:
        Unit r103 = Unit.INSTANCE;
        this.productHeaderList = r101;
    L8:
        setState(new AnonymousClass2(this));
    }

    public static final /* synthetic */ String access$getFilterProductIds(SameProductViewModel r100, SameProductPageParams r101) {
        return r100.getFilterProductIds(r101);
    }

    public static final /* synthetic */ void access$setListCursor$p(SameProductViewModel r100, int r101) {
        r100.listCursor = r101;
    }

    public static final /* synthetic */ void access$setListPage$p(SameProductViewModel r100, int r101) {
        r100.listPage = r101;
    }

    public static final /* synthetic */ void access$setProductHeaderList$p(SameProductViewModel r100, List r101) {
        r100.productHeaderList = r101;
    }

    public static final /* synthetic */ void access$setSameProductListDisposable$p(SameProductViewModel r100, Disposable r101) {
        r100.sameProductListDisposable = r101;
    }

    public static final /* synthetic */ void access$setSameProductPageParams$p(SameProductViewModel r100, SameProductPageParams r101) {
        r100.sameProductPageParams = r101;
    }

    public static final /* synthetic */ void access$setState(SameProductViewModel r100, Function1 r101) {
        r100.setState(r101);
    }
}
