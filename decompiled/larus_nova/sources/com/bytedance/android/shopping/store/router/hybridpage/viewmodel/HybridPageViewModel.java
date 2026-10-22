package com.bytedance.android.shopping.store.router.hybridpage.viewmodel;

import android.content.Context;
import com.bytedance.android.ec.core.async.DisposableScope;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListDTO;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListItemDTO;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListSectionDTO;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListStyleDTO;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECListItemConfigDTO;
import com.bytedance.android.ec.hybrid.list.entity.k;
import com.bytedance.android.ec.store.common.param.StoreAccountParam;
import com.bytedance.android.ec.store.product.holder.LayoutTypes;
import com.bytedance.android.ec.store.shopping.paging.LoadStatus;
import com.bytedance.android.shopping.store.home.presenter.b4;
import com.bytedance.android.shopping.store.home.view.LottieAnimationViewWithPlayCount;
import com.bytedance.android.shopping.store.router.hybridpage.setting.HybridPageConfigSetting;
import com.bytedance.android.shopping.store.router.hybridpage.slice.HybridPageSlcTemplateManager;
import com.bytedance.android.shopping.store.router.hybridpage.slice.SliceProductCardData;
import com.bytedance.android.shopping.store.search.router.ECShopSearchParam;
import com.bytedance.android.shopping.store.settings.ECShopABSettings;
import com.bytedance.android.shopping.store.slicecard.SliceItemType;
import com.bytedance.android.shopping.store.slicecard.dto.ShopSliceItemConfig;
import com.bytedance.android.shopping.store.slicecard.dto.SliceTemplate;
import com.bytedance.android.shopping.store.slicecard.dto.SliceTemplateType;
import com.bytedance.commerce.base.json.JsonDslUtilKt;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import com.ss.android.ugc.aweme.search.vision.model.data.PhotoEnterModel;
import com.ss.android.ugc.effectmanager.effect.model.ComposerHelper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import jm.a;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import vj3.b;
import xm.c;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000Ð\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\t¢\u0006\u0006\b\u009f\u0001\u0010 \u0001J\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bJ\b\u0010\f\u001a\u0004\u0018\u00010\tJ\u0018\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u000fJ\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\bJ\u0010\u0010\u0015\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013J.\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00162\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00162\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016J\u0006\u0010\u001b\u001a\u00020\u0006J \u0010\u001d\u001a\u00020\u00062\u0018\b\u0002\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\bJ\u0006\u0010\u001e\u001a\u00020\u0006J\b\u0010\u001f\u001a\u00020\u0006H\u0014R\u001b\u0010%\u001a\u00020 8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001b\u0010*\u001a\u00020&8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\"\u001a\u0004\b(\u0010)R\u0017\u0010,\u001a\u00020+8\u0006¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u0017\u00100\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R$\u00104\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R,\u0010<\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010;\u0018\u00010:8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR*\u0010D\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010C0B8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR0\u0010K\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010J8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bK\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR$\u0010Q\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bQ\u00101\u001a\u0004\bR\u00103\"\u0004\bS\u0010TR$\u0010U\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bU\u00101\u001a\u0004\bV\u00103\"\u0004\bW\u0010TR(\u0010Z\u001a\b\u0012\u0004\u0012\u00020Y0X8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bZ\u0010[\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R$\u0010`\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b`\u00101\u001a\u0004\ba\u00103\"\u0004\bb\u0010TR(\u0010d\u001a\b\u0012\u0004\u0012\u00020c0B8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bd\u0010E\u001a\u0004\be\u0010G\"\u0004\bf\u0010IR$\u0010h\u001a\u0004\u0018\u00010g8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bh\u0010i\u001a\u0004\bj\u0010k\"\u0004\bl\u0010mR\u001d\u0010o\u001a\b\u0012\u0004\u0012\u00020n0B8\u0006¢\u0006\f\n\u0004\bo\u0010E\u001a\u0004\bp\u0010GR\u001d\u0010q\u001a\b\u0012\u0004\u0012\u00020n0B8\u0006¢\u0006\f\n\u0004\bq\u0010E\u001a\u0004\br\u0010GR2\u0010u\u001a\u0012\u0012\u0004\u0012\u00020\t0sj\b\u0012\u0004\u0012\u00020\t`t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bu\u0010v\u001a\u0004\bw\u0010x\"\u0004\by\u0010zR&\u0010|\u001a\u0004\u0018\u00010{8\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b|\u0010}\u001a\u0004\b~\u0010\u007f\"\u0006\b\u0080\u0001\u0010\u0081\u0001R+\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0082\u0001\u0010\u0083\u0001\u001a\u0006\b\u0084\u0001\u0010\u0085\u0001\"\u0006\b\u0086\u0001\u0010\u0087\u0001R(\u0010\u0088\u0001\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0088\u0001\u00101\u001a\u0005\b\u0089\u0001\u00103\"\u0005\b\u008a\u0001\u0010TR1\u0010\u008d\u0001\u001a\n\u0012\u0005\u0012\u00030\u008c\u00010\u008b\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u008d\u0001\u0010\u008e\u0001\u001a\u0006\b\u008f\u0001\u0010\u0090\u0001\"\u0006\b\u0091\u0001\u0010\u0092\u0001R,\u0010\u0094\u0001\u001a\u0005\u0018\u00010\u0093\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0094\u0001\u0010\u0095\u0001\u001a\u0006\b\u0096\u0001\u0010\u0097\u0001\"\u0006\b\u0098\u0001\u0010\u0099\u0001R6\u0010\u009a\u0001\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u009a\u0001\u0010L\u001a\u0005\b\u009b\u0001\u0010N\"\u0005\b\u009c\u0001\u0010PR\u001b\u0010\u009d\u0001\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009d\u0001\u0010\u009e\u0001¨\u0006¡\u0001"}, d2 = {"Lcom/bytedance/android/shopping/store/router/hybridpage/viewmodel/HybridPageViewModel;", "Lcom/bytedance/android/shopping/store/router/hybridpage/viewmodel/HybridPageBaseViewModel;", "", "hasDiscountSelected", "Lcom/bytedance/android/shopping/store/home/presenter/b4;", "listener", "", "setLynxCardEventListener", "", "", "", "getAdParams", "getPassThroughLogData", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lvj3/b;", "configSetting", "initData", "buildRouterQuery", "Lcom/bytedance/android/ec/hybrid/list/entity/dto/ECHybridListDTO;", "dto", "appendHybridListDTO", "", "Lcom/bytedance/android/ec/hybrid/list/entity/dto/ECHybridListSectionDTO;", "originSections", "addSections", "mergeSections", "clearHybridListDTO", "params", "reportInitializeError", "initEventParams", "onCleared", "Lcom/bytedance/android/shopping/store/slicecard/b;", "sliceService$delegate", "Lkotlin/Lazy;", "getSliceService", "()Lcom/bytedance/android/shopping/store/slicecard/b;", "sliceService", "Lcom/bytedance/android/shopping/store/router/hybridpage/slice/b;", "slcCardFactory$delegate", "getSlcCardFactory", "()Lcom/bytedance/android/shopping/store/router/hybridpage/slice/b;", "slcCardFactory", "Lxm/c;", "multiLeveViewCache", "Lxm/c;", "getMultiLeveViewCache", "()Lxm/c;", "sceneId", "Ljava/lang/String;", "getSceneId", "()Ljava/lang/String;", "sliceConfigSetting", "Lvj3/b;", "getSliceConfigSetting", "()Lvj3/b;", "setSliceConfigSetting", "(Lvj3/b;)V", "Ljava/lang/ref/WeakReference;", "Lcom/bytedance/android/shopping/store/home/view/LottieAnimationViewWithPlayCount;", "cartAnimationView", "Ljava/lang/ref/WeakReference;", "getCartAnimationView", "()Ljava/lang/ref/WeakReference;", "setCartAnimationView", "(Ljava/lang/ref/WeakReference;)V", "Ljm/a;", "Lorg/json/JSONObject;", "configJson", "Ljm/a;", "getConfigJson", "()Ljm/a;", "setConfigJson", "(Ljm/a;)V", "", "routeParams", "Ljava/util/Map;", "getRouteParams", "()Ljava/util/Map;", "setRouteParams", "(Ljava/util/Map;)V", "pageCardUrl", "getPageCardUrl", "setPageCardUrl", "(Ljava/lang/String;)V", "configJsonUrl", "getConfigJsonUrl", "setConfigJsonUrl", "Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QLiveData;", "Lcom/bytedance/android/ec/store/shopping/paging/LoadStatus;", "loadStatus", "Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QLiveData;", "getLoadStatus", "()Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QLiveData;", "setLoadStatus", "(Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QLiveData;)V", "loadNoMoreText", "getLoadNoMoreText", "setLoadNoMoreText", "Lcom/bytedance/android/ec/store/product/holder/LayoutTypes;", "layoutType", "getLayoutType", "setLayoutType", "Lcom/bytedance/android/shopping/store/router/hybridpage/slice/SliceProductCardData;", "sliceProductCardData", "Lcom/bytedance/android/shopping/store/router/hybridpage/slice/SliceProductCardData;", "getSliceProductCardData", "()Lcom/bytedance/android/shopping/store/router/hybridpage/slice/SliceProductCardData;", "setSliceProductCardData", "(Lcom/bytedance/android/shopping/store/router/hybridpage/slice/SliceProductCardData;)V", "", "productViewsNum", "getProductViewsNum", "totalProductNum", "getTotalProductNum", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "idRecords", "Ljava/util/HashSet;", "getIdRecords", "()Ljava/util/HashSet;", "setIdRecords", "(Ljava/util/HashSet;)V", "Lcom/bytedance/android/ec/hybrid/list/entity/k;", "hybridListVO", "Lcom/bytedance/android/ec/hybrid/list/entity/k;", "getHybridListVO", "()Lcom/bytedance/android/ec/hybrid/list/entity/k;", "setHybridListVO", "(Lcom/bytedance/android/ec/hybrid/list/entity/k;)V", "hybridListDTO", "Lcom/bytedance/android/ec/hybrid/list/entity/dto/ECHybridListDTO;", "getHybridListDTO", "()Lcom/bytedance/android/ec/hybrid/list/entity/dto/ECHybridListDTO;", "setHybridListDTO", "(Lcom/bytedance/android/ec/hybrid/list/entity/dto/ECHybridListDTO;)V", "sourceBtmToken", "getSourceBtmToken", "setSourceBtmToken", "", "Lcom/bytedance/android/ec/store/repository/dto/c;", "selectButtons", "Ljava/util/List;", "getSelectButtons", "()Ljava/util/List;", "setSelectButtons", "(Ljava/util/List;)V", "Lcom/bytedance/android/shopping/store/search/router/ECShopSearchParam;", "searchParam", "Lcom/bytedance/android/shopping/store/search/router/ECShopSearchParam;", "getSearchParam", "()Lcom/bytedance/android/shopping/store/search/router/ECShopSearchParam;", "setSearchParam", "(Lcom/bytedance/android/shopping/store/search/router/ECShopSearchParam;)V", "routerQuery", "getRouterQuery", "setRouterQuery", "lynxCardEventListener", "Lcom/bytedance/android/shopping/store/home/presenter/b4;", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HybridPageViewModel extends HybridPageBaseViewModel {
    private WeakReference<LottieAnimationViewWithPlayCount> cartAnimationView;
    private a<JSONObject> configJson;
    private String configJsonUrl;
    private ECHybridListDTO hybridListDTO;
    private k hybridListVO;
    private HashSet<String> idRecords;
    private a<LayoutTypes> layoutType;
    private String loadNoMoreText;
    private QLiveData<LoadStatus> loadStatus;
    private b4 lynxCardEventListener;
    private final c multiLeveViewCache;
    private String pageCardUrl;
    private final a<Integer> productViewsNum;
    private Map<String, ? extends Object> routeParams;
    private Map<String, Object> routerQuery;
    private final String sceneId;
    private ECShopSearchParam searchParam;
    private List<com.bytedance.android.ec.store.repository.dto.c> selectButtons;
    private final Lazy slcCardFactory$delegate;
    private b sliceConfigSetting;
    private SliceProductCardData sliceProductCardData;
    private final Lazy sliceService$delegate;
    private String sourceBtmToken;
    private final a<Integer> totalProductNum;

    /* JADX WARN: Multi-variable type inference failed */
    public HybridPageViewModel() {
        DisposableScope r100 = null;
        Object[] r101 = 0 == true ? 1 : 0;
        super(r100, r101, 3, 0 == true ? 1 : 0);
        this.sliceService$delegate = LazyKt.lazy(HybridPageViewModel$sliceService$2.INSTANCE);
        this.slcCardFactory$delegate = LazyKt.lazy(new HybridPageViewModel$slcCardFactory$2(this));
        this.multiLeveViewCache = new c();
        this.sceneId = UUID.randomUUID().toString();
        this.configJson = new a(7);
        this.loadStatus = new QLiveData();
        this.layoutType = new a(7);
        this.productViewsNum = new a(7);
        this.totalProductNum = new a(7);
        this.idRecords = new HashSet();
        this.selectButtons = new ArrayList();
    }

    public final void clearHybridListDTO() {
        this.hybridListDTO = null;
    }

    public final Map<String, Object> getAdParams() {
        Pair[] r100 = new Pair[2];
        SliceProductCardData r101 = this.sliceProductCardData;
        if (r101 == null) goto L5;
        String r102 = r101.getShopId();
    L6:
        if (r102 != null) goto L8;
        r102 = "";
    L8:
        r100[0] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_SHOP_ID, r102);
        r100[1] = TuplesKt.to("category", "umeng");
        return MapsKt.mutableMapOf(r100);
    L5:
        r102 = null;
        goto L6
    }

    public final String getPassThroughLogData() {
        com.bytedance.commerce.base.json.a[] r100 = new com.bytedance.commerce.base.json.a[6];
        r100[0] = JsonDslUtilKt.d(com.bytedance.android.ec.core.event.a.KEY_STORE_TYPE, "shop");
        SliceProductCardData r101 = this.sliceProductCardData;
        if (r101 == null) goto L5;
        String r102 = r101.getEntranceLocation();
    L6:
        String r103 = "";
        if (r102 != null) goto L9;
        r102 = "";
    L9:
        r100[1] = JsonDslUtilKt.d(com.bytedance.android.ec.core.event.a.KEY_PRODUCT_SOURCE_PAGE, r102);
        SliceProductCardData r104 = this.sliceProductCardData;
        if (r104 == null) goto L13;
        String r105 = r104.getStoreSourcePage();
        if (r105 == null) goto L13;
    L14:
        r100[2] = JsonDslUtilKt.d(com.bytedance.android.ec.core.event.a.KEY_STORE_SOURCE_PAGE, r105);
        SliceProductCardData r106 = this.sliceProductCardData;
        if (r106 == null) goto L18;
        String r107 = r106.getStoreSourceMethod();
        if (r107 == null) goto L18;
    L19:
        r100[3] = JsonDslUtilKt.d(com.bytedance.android.ec.core.event.a.KEY_STORE_SOURCE_METHOD, r107);
        SliceProductCardData r108 = this.sliceProductCardData;
        if (r108 == null) goto L25;
        String r109 = r108.getStoreGroupType();
        if (r109 == null) goto L25;
        r103 = r109;
    L25:
        r100[4] = JsonDslUtilKt.d(com.bytedance.android.ec.core.event.a.KEY_STORE_GROUP_TYPE, r103);
        r100[5] = JsonDslUtilKt.d("ecom_scene_id", "1003");
        return JsonDslUtilKt.a(r100).toString();
    L18:
        r107 = "";
    L13:
        r105 = "";
        goto L14
    L5:
        r102 = null;
        goto L6
    }

    public final com.bytedance.android.shopping.store.router.hybridpage.slice.b getSlcCardFactory() {
        return (com.bytedance.android.shopping.store.router.hybridpage.slice.b) this.slcCardFactory$delegate.getValue();
    }

    public final com.bytedance.android.shopping.store.slicecard.b getSliceService() {
        return (com.bytedance.android.shopping.store.slicecard.b) this.sliceService$delegate.getValue();
    }

    public final Map<String, Object> buildRouterQuery() {
        LinkedHashMap r100 = new LinkedHashMap();
        ECShopSearchParam r101 = this.searchParam;
        String r102 = "";
        if (r101 == null) goto L6;
        String r103 = r101.getSearchSource();
        if (r103 == null) goto L6;
    L7:
        r100.put("recent_search_type", r103);
        ECShopSearchParam r104 = this.searchParam;
        Integer r105 = null;
        if (r104 == null) goto L10;
        String r106 = r104.getSearchKeyword();
    L11:
        if (r106 != null) goto L13;
        r106 = "";
    L13:
        r100.put("inbound_search_keyword", r106);
        r100.put("inbound_search_placeholder", "");
        ECShopSearchParam r107 = this.searchParam;
        if (r107 == null) goto L16;
        String r108 = r107.getSourceBtmToken();
    L17:
        if (r108 != null) goto L19;
        r108 = "";
    L19:
        r100.put(PhotoEnterModel.SOURCE_BTM_TOKEN, r108);
        ECShopSearchParam r109 = this.searchParam;
        if (r109 == null) goto L22;
        String r110 = r109.getSearchSource();
    L23:
        if (r110 != null) goto L25;
        r110 = "";
    L25:
        r100.put("shop_search_enter_method", r110);
        ECShopSearchParam r111 = this.searchParam;
        if (r111 == null) goto L28;
        String r112 = r111.getHotSearchIconType();
    L29:
        if (r112 != null) goto L31;
        r112 = "";
    L31:
        r100.put("hot_search_icon_type", r112);
        ECShopSearchParam r113 = this.searchParam;
        if (r113 == null) goto L35;
        Map<String, Object> r114 = r113.getUriParams();
        if (r114 == null) goto L35;
    L36:
        r100.putAll(r114);
        LinkedHashMap r115 = new LinkedHashMap();
        ECShopSearchParam r116 = this.searchParam;
        if (r116 == null) goto L39;
        String r117 = r116.getTempId();
    L40:
        if (r117 != null) goto L42;
        r117 = "";
    L42:
        r115.put(com.bytedance.android.ec.core.event.a.KEY_TEMP_ID, r117);
        ECShopSearchParam r118 = this.searchParam;
        if (r118 == null) goto L45;
        String r119 = r118.getTabNameSecond();
    L46:
        if (r119 != null) goto L48;
        r119 = "";
    L48:
        r115.put("tab_name_second", r119);
        ECShopSearchParam r120 = this.searchParam;
        if (r120 == null) goto L51;
        String r121 = r120.getTabLabel();
    L52:
        if (r121 != null) goto L54;
        r121 = "";
    L54:
        r115.put("tab_label", r121);
        ECShopSearchParam r122 = this.searchParam;
        if (r122 == null) goto L57;
        String r123 = r122.getTabName();
    L58:
        if (r123 != null) goto L60;
        r123 = "";
    L60:
        r115.put(com.bytedance.android.ec.core.event.a.KEY_TAB_NAME, r123);
        r100.putAll(r115);
        r100.put("track_extra_params", r115);
        ECShopSearchParam r124 = this.searchParam;
        if (r124 == null) goto L63;
        String r125 = r124.getShopId();
    L64:
        if (r125 != null) goto L66;
        r125 = "";
    L66:
        r100.put(com.bytedance.android.ec.core.event.a.KEY_SHOP_ID, r125);
        ECShopSearchParam r126 = this.searchParam;
        if (r126 == null) goto L71;
        StoreAccountParam r127 = r126.getStoreAccountParam();
        if (r127 == null) goto L71;
        String r128 = r127.getUserId();
    L72:
        if (r128 != null) goto L74;
        r128 = "";
    L74:
        r100.put("anchor_id", r128);
        ECShopSearchParam r129 = this.searchParam;
        if (r129 == null) goto L77;
        Integer r130 = Integer.valueOf(r129.isFromAd());
    L78:
        r100.put("is_form_ad", r130);
        ECShopSearchParam r131 = this.searchParam;
        if (r131 == null) goto L81;
        String r132 = r131.getEnterFrom();
    L82:
        r100.put("enter_from", r132);
        ECShopSearchParam r133 = this.searchParam;
        if (r133 == null) goto L85;
        String r134 = r133.getSecShopId();
    L86:
        r100.put("sec_shop_id", r134);
        ECShopSearchParam r135 = this.searchParam;
        if (r135 == null) goto L89;
        Boolean r136 = Boolean.valueOf(r135.isPreview());
    L90:
        r100.put(com.bytedance.android.ec.core.event.a.KEY_IS_ENTER_PREVIEW, r136);
        r100.put(com.bytedance.android.ec.core.event.a.KEY_BRAND_VERIFIED, "");
        ECShopSearchParam r137 = this.searchParam;
        if (r137 == null) goto L93;
        String r138 = r137.getRoomId();
    L94:
        r100.put("live_window_room_id", r138);
        ECShopSearchParam r139 = this.searchParam;
        if (r139 == null) goto L97;
        String r140 = r139.getEntranceInfo();
    L98:
        r100.put(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO, r140);
        ECShopSearchParam r141 = this.searchParam;
        if (r141 == null) goto L101;
        String r142 = (String) r141.getPassThroughParam(com.bytedance.android.ec.core.event.a.KEY_PASS_THROUGH_API);
    L102:
        if (r142 != null) goto L104;
        r142 = "";
    L104:
        r100.put(com.bytedance.android.ec.core.event.a.KEY_PASS_THROUGH_API, r142);
        r100.put("track_extra_params", r115);
        r100.put("pre_enter_store_params", "");
        LinkedHashMap r143 = new LinkedHashMap();
        ECShopSearchParam r144 = this.searchParam;
        if (r144 == null) goto L107;
        boolean r145 = r144.isEcShare();
    L108:
        r143.put("is_ec_share", Boolean.valueOf(r145));
        ECShopSearchParam r146 = this.searchParam;
        if (r146 == null) goto L111;
        String r147 = r146.getShareContent();
    L112:
        if (r147 == null) goto L115;
        r102 = r147;
    L115:
        r143.put(com.bytedance.android.ec.core.event.a.KEY_SHARE_CONTENT, r102);
        ECShopSearchParam r148 = this.searchParam;
        if (r148 == null) goto L118;
        String r149 = r148.getShareObject();
    L119:
        r100.put(com.bytedance.android.ec.core.event.a.KEY_SHARE_OBJECT, r149);
        Unit r150 = Unit.INSTANCE;
        r100.put("ecom_share_track_params", r143);
        ECShopSearchParam r151 = this.searchParam;
        if (r151 == null) goto L124;
        StoreAccountParam r152 = r151.getStoreAccountParam();
        if (r152 == null) goto L124;
        String r153 = r152.getUserId();
    L125:
        r100.put("author_id", r153);
        ECShopSearchParam r154 = this.searchParam;
        if (r154 == null) goto L130;
        StoreAccountParam r155 = r154.getStoreAccountParam();
        if (r155 == null) goto L130;
        String r156 = r155.getSecUserId();
    L131:
        r100.put("sec_author_id", r156);
        ECShopSearchParam r157 = this.searchParam;
        if (r157 == null) goto L134;
        r105 = r157.getFollowStatus();
    L134:
        r100.put("follow_status", r105);
        return r100;
    L130:
        r156 = null;
    L124:
        r153 = null;
        goto L125
    L118:
        r149 = null;
        goto L119
    L111:
        r147 = null;
        goto L112
    L107:
        r145 = false;
        goto L108
    L101:
        r142 = null;
        goto L102
    L97:
        r140 = null;
        goto L98
    L93:
        r138 = null;
        goto L94
    L89:
        r136 = null;
        goto L90
    L85:
        r134 = null;
        goto L86
    L81:
        r132 = null;
        goto L82
    L77:
        r130 = null;
    L71:
        r128 = null;
        goto L72
    L63:
        r125 = null;
        goto L64
    L57:
        r123 = null;
        goto L58
    L51:
        r121 = null;
        goto L52
    L45:
        r119 = null;
        goto L46
    L39:
        r117 = null;
    L35:
        r114 = new LinkedHashMap();
        goto L36
    L28:
        r112 = null;
        goto L29
    L22:
        r110 = null;
        goto L23
    L16:
        r108 = null;
        goto L17
    L10:
        r106 = null;
    L6:
        r103 = "";
        goto L7
    }

    public final boolean hasDiscountSelected() {
        if ((!this.selectButtons.isEmpty()) == false) goto L17;
        List<com.bytedance.android.ec.store.repository.dto.c> r100 = this.selectButtons;
        if ((r100 instanceof Collection) == true) goto L7;
    L9:
        Iterator<T> r101 = r100.iterator();
    L11:
        if (r101.hasNext() == false) goto L8;
        if (Intrinsics.areEqual(((com.bytedance.android.ec.store.repository.dto.c) r101.next()).e(), Boolean.TRUE) == false) goto L11;
        boolean r102 = true;
    L15:
        if (r102 == false) goto L17;
        return true;
    L8:
        r102 = false;
        goto L15
    L7:
        if (r100.isEmpty() == false) goto L9;
    L17:
        return false;
    }

    public final void initEventParams() {
        Pair[] r100 = new Pair[13];
        ECShopSearchParam r101 = this.searchParam;
        String r102 = null;
        if (r101 == null) goto L7;
        StoreAccountParam r103 = r101.getStoreAccountParam();
        if (r103 == null) goto L7;
        String r104 = r103.getUserId();
    L8:
        r100[0] = TuplesKt.to("author_id", r104);
        ECShopSearchParam r105 = this.searchParam;
        if (r105 == null) goto L13;
        StoreAccountParam r106 = r105.getStoreAccountParam();
        if (r106 == null) goto L13;
        String r107 = r106.getSecUserId();
    L14:
        r100[1] = TuplesKt.to("sec_author_id", r107);
        ECShopSearchParam r108 = this.searchParam;
        if (r108 == null) goto L17;
        String r109 = r108.getShopId();
    L18:
        r100[2] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_SHOP_ID, r109);
        ECShopSearchParam r110 = this.searchParam;
        if (r110 == null) goto L21;
        String r111 = r110.getSecShopId();
    L22:
        r100[3] = TuplesKt.to("sec_shop_id", r111);
        ECShopSearchParam r112 = this.searchParam;
        if (r112 == null) goto L25;
        String r113 = r112.getEnterFrom();
    L26:
        r100[4] = TuplesKt.to("enter_from", r113);
        ECShopSearchParam r114 = this.searchParam;
        if (r114 == null) goto L29;
        String r115 = r114.getEntranceLocation();
    L30:
        r100[5] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_LOCATION, r115);
        ECShopSearchParam r116 = this.searchParam;
        if (r116 == null) goto L33;
        String r117 = r116.getStoreSourcePage();
    L34:
        r100[6] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_STORE_SOURCE_PAGE, r117);
        ECShopSearchParam r118 = this.searchParam;
        if (r118 == null) goto L37;
        String r119 = r118.getStoreSourceMethod();
    L38:
        r100[7] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_STORE_SOURCE_METHOD, r119);
        ECShopSearchParam r120 = this.searchParam;
        if (r120 == null) goto L41;
        String r121 = r120.getStoreGroupType();
    L42:
        r100[8] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_STORE_GROUP_TYPE, r121);
        ECShopSearchParam r122 = this.searchParam;
        if (r122 == null) goto L45;
        String r123 = r122.getPageName();
    L46:
        r100[9] = TuplesKt.to("page_name", r123);
        ECShopSearchParam r124 = this.searchParam;
        if (r124 == null) goto L49;
        String r125 = r124.getPageName();
    L50:
        r100[10] = TuplesKt.to("source_page", r125);
        ECShopSearchParam r126 = this.searchParam;
        if (r126 == null) goto L55;
        Integer r127 = r126.getFollowStatus();
        if (r127 == null) goto L55;
        r102 = String.valueOf(r127.intValue());
    L55:
        r100[11] = TuplesKt.to("follow_status", r102);
        ECShopSearchParam r128 = this.searchParam;
        if (r128 != null) goto L58;
    L60:
        String r129 = "0";
    L61:
        r100[12] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_IS_ENTER_PREVIEW, r129);
        initEventContext(MapsKt.mapOf(r100));
        return;
    L58:
        if (r128.isPreview() != true) goto L60;
        r129 = "1";
        goto L61
    L49:
        r125 = null;
        goto L50
    L45:
        r123 = null;
        goto L46
    L41:
        r121 = null;
        goto L42
    L37:
        r119 = null;
        goto L38
    L33:
        r117 = null;
        goto L34
    L29:
        r115 = null;
        goto L30
    L25:
        r113 = null;
        goto L26
    L21:
        r111 = null;
        goto L22
    L17:
        r109 = null;
    L13:
        r107 = null;
    L7:
        r104 = null;
        goto L8
    }

    @Override // com.bytedance.android.shopping.store.router.hybridpage.viewmodel.HybridPageBaseViewModel, com.ss.android.ugc.aweme.kiwi.viewmodel.QViewModel, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        getSliceService().e();
    }

    public final WeakReference<LottieAnimationViewWithPlayCount> getCartAnimationView() {
        return this.cartAnimationView;
    }

    public final a<JSONObject> getConfigJson() {
        return this.configJson;
    }

    public final String getConfigJsonUrl() {
        return this.configJsonUrl;
    }

    public final ECHybridListDTO getHybridListDTO() {
        return this.hybridListDTO;
    }

    public final k getHybridListVO() {
        return this.hybridListVO;
    }

    public final HashSet<String> getIdRecords() {
        return this.idRecords;
    }

    public final a<LayoutTypes> getLayoutType() {
        return this.layoutType;
    }

    public final String getLoadNoMoreText() {
        return this.loadNoMoreText;
    }

    public final QLiveData<LoadStatus> getLoadStatus() {
        return this.loadStatus;
    }

    public final c getMultiLeveViewCache() {
        return this.multiLeveViewCache;
    }

    public final String getPageCardUrl() {
        return this.pageCardUrl;
    }

    public final a<Integer> getProductViewsNum() {
        return this.productViewsNum;
    }

    public final Map<String, Object> getRouteParams() {
        return this.routeParams;
    }

    public final Map<String, Object> getRouterQuery() {
        return this.routerQuery;
    }

    public final String getSceneId() {
        return this.sceneId;
    }

    public final ECShopSearchParam getSearchParam() {
        return this.searchParam;
    }

    public final List<com.bytedance.android.ec.store.repository.dto.c> getSelectButtons() {
        return this.selectButtons;
    }

    public final b getSliceConfigSetting() {
        return this.sliceConfigSetting;
    }

    public final SliceProductCardData getSliceProductCardData() {
        return this.sliceProductCardData;
    }

    public final String getSourceBtmToken() {
        return this.sourceBtmToken;
    }

    public final a<Integer> getTotalProductNum() {
        return this.totalProductNum;
    }

    public final void appendHybridListDTO(ECHybridListDTO r100) {
        ECHybridListDTO r101 = this.hybridListDTO;
        if (r101 != null) goto L6;
        this.hybridListDTO = r100;
        return;
    L6:
        Map<String, String> r102 = null;
        if (r101 == null) goto L12;
        if (r100 == null) goto L10;
        ECHybridListStyleDTO r103 = r100.getListStyle();
    L11:
        r101.setListStyle(r103);
        goto L12
    L10:
        r103 = null;
    L12:
        if (r101 == null) goto L18;
        List<ECHybridListSectionDTO> r104 = r101.getSections();
        if (r100 == null) goto L16;
        List<ECHybridListSectionDTO> r105 = r100.getSections();
    L17:
        r101.setSections(mergeSections(r104, r105));
        goto L18
    L16:
        r105 = null;
    L18:
        if (r101 == null) goto L25;
        if (r100 == null) goto L21;
        Map<String, ECListItemConfigDTO> r106 = r100.getItemConfigs();
    L22:
        if (r106 != null) goto L24;
        r106 = MapsKt.emptyMap();
    L24:
        r101.setItemConfigs(r106);
        goto L25
    L21:
        r106 = null;
    L25:
        if (r101 == null) goto L32;
        if (r100 == null) goto L28;
        r102 = r100.getExtra();
    L28:
        if (r102 != null) goto L30;
        r102 = MapsKt.emptyMap();
    L30:
        r101.setExtra(r102);
        return;
    }

    public final void reportInitializeError(Map<String, String> r100) {
        LinkedHashMap r101 = new LinkedHashMap();
        if (r100 != null) goto L5;
        r100 = new LinkedHashMap();
    L5:
        r101.putAll(r100);
        Unit r102 = Unit.INSTANCE;
        doEventAction("search_hybrid_page_load_failed", r101, new Pair[0]);
    }

    public final void setCartAnimationView(WeakReference<LottieAnimationViewWithPlayCount> r100) {
        this.cartAnimationView = r100;
    }

    public final void setConfigJson(a<JSONObject> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.configJson = r100;
    }

    public final void setConfigJsonUrl(String r100) {
        this.configJsonUrl = r100;
    }

    public final void setHybridListDTO(ECHybridListDTO r100) {
        this.hybridListDTO = r100;
    }

    public final void setHybridListVO(k r100) {
        this.hybridListVO = r100;
    }

    public final void setIdRecords(HashSet<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.idRecords = r100;
    }

    public final void setLayoutType(a<LayoutTypes> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.layoutType = r100;
    }

    public final void setLoadNoMoreText(String r100) {
        this.loadNoMoreText = r100;
    }

    public final void setLoadStatus(QLiveData<LoadStatus> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.loadStatus = r100;
    }

    public final void setLynxCardEventListener(b4 r100) {
        this.lynxCardEventListener = r100;
    }

    public final void setPageCardUrl(String r100) {
        this.pageCardUrl = r100;
    }

    public final void setRouteParams(Map<String, ? extends Object> r100) {
        this.routeParams = r100;
    }

    public final void setRouterQuery(Map<String, Object> r100) {
        this.routerQuery = r100;
    }

    public final void setSearchParam(ECShopSearchParam r100) {
        this.searchParam = r100;
    }

    public final void setSelectButtons(List<com.bytedance.android.ec.store.repository.dto.c> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.selectButtons = r100;
    }

    public final void setSliceConfigSetting(b r100) {
        this.sliceConfigSetting = r100;
    }

    public final void setSliceProductCardData(SliceProductCardData r100) {
        this.sliceProductCardData = r100;
    }

    public final void setSourceBtmToken(String r100) {
        this.sourceBtmToken = r100;
    }

    public final void initData(Context r100, b r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "configSetting");
        this.sliceConfigSetting = r101;
        vj3.a r102 = com.bytedance.android.shopping.store.router.hybridpage.slice.c.f185962d;
        if (r101 == null) goto L5;
        vj3.a r103 = r101.a();
    L6:
        com.bytedance.android.shopping.store.router.hybridpage.slice.c.f185962d = r103;
        com.bytedance.android.shopping.store.slicecard.b r104 = getSliceService();
        boolean r105 = true;
        if (ECShopABSettings.e() == 1) goto L10;
        r105 = false;
    L10:
        r104.b(r100, r105);
        b r106 = this.sliceConfigSetting;
        if (r106 == null) goto L16;
        String r107 = r106.b();
        if (r107 == null) goto L16;
        boolean r108 = ak3.a.f3997a;
        this.pageCardUrl = ak3.a.c(r107, "page_card.js");
        this.configJsonUrl = ak3.a.c(r107, ComposerHelper.CONFIG_FILE_NAME);
    L16:
        if (HybridPageSlcTemplateManager.f185959e.isEmpty() == false) goto L41;
        long r109 = wh.a.a("ecom_shop_slice_template");
        List<com.bytedance.android.ec.store.setting.k> r110 = HybridPageSlcTemplateManager.f185955a;
        ArrayList r111 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r110, 10));
        Iterator<T> r112 = r110.iterator();
    L19:
        if (r112.hasNext() == false) goto L21;
        com.bytedance.android.ec.store.setting.k r113 = (com.bytedance.android.ec.store.setting.k) r112.next();
        SliceTemplate r114 = new SliceTemplate();
        r114.setName(r113.a());
        r114.setUrl(r113.c());
        r114.setVersion(String.valueOf(r109));
        r114.setType(SliceTemplateType.GECKO.getType());
        r111.add(r114);
        goto L19
    L21:
        ArrayList r115 = new ArrayList();
        ArrayList r116 = new ArrayList();
        ArrayList r117 = new ArrayList();
        Iterator r118 = r111.iterator();
    L23:
        if (r118.hasNext() == false) goto L33;
        SliceTemplate r119 = (SliceTemplate) r118.next();
        if (CollectionsKt.contains(HybridPageSlcTemplateManager.f185956b, r119.getName()) == false) goto L28;
        r116.add(r119);
    L28:
        if (CollectionsKt.contains(HybridPageSlcTemplateManager.f185957c, r119.getName()) == false) goto L31;
        r117.add(r119);
    L31:
        if (CollectionsKt.contains(HybridPageSlcTemplateManager.f185958d, r119.getName()) == false) goto L23;
        r115.add(r119);
        goto L23
    L33:
        ConcurrentHashMap<String, ShopSliceItemConfig> r120 = HybridPageSlcTemplateManager.f185959e;
        String r121 = SliceItemType.SHOP_PRODUCT_LIST_PRODUCT_CARD_CARDPACK.getType();
        ShopSliceItemConfig r122 = new ShopSliceItemConfig();
        r122.setTemplates(r115);
        Unit r123 = Unit.INSTANCE;
        r120.put(r121, r122);
        String r124 = SliceItemType.SHOP_SEARCH_RESULT_PAGE.getType();
        ShopSliceItemConfig r125 = new ShopSliceItemConfig();
        r125.setTemplates(r116);
        r120.put(r124, r125);
        String r126 = SliceItemType.SHOP_CLASSIFICATION_SECOND_PAGE.getType();
        ShopSliceItemConfig r127 = new ShopSliceItemConfig();
        r127.setTemplates(r117);
        r120.put(r126, r127);
        return;
    L41:
        return;
    L5:
        r103 = null;
        goto L6
    }

    public final List<ECHybridListSectionDTO> mergeSections(List<ECHybridListSectionDTO> r100, List<ECHybridListSectionDTO> r101) {
        if (r100 != null) goto L4;
        return r101;
    L4:
        List<ECHybridListSectionDTO> r102 = CollectionsKt.toMutableList(r100);
        if (r101 == null) goto L30;
        Iterator<T> r103 = r101.iterator();
    L8:
        if (r103.hasNext() == false) goto L30;
        ECHybridListSectionDTO r104 = (ECHybridListSectionDTO) r103.next();
        ArrayList r105 = new ArrayList();
        Iterator<T> r106 = r100.iterator();
    L11:
        if (r106.hasNext() == false) goto L16;
        Object r107 = r106.next();
        if (Intrinsics.areEqual(((ECHybridListSectionDTO) r107).getSectionId(), r104.getSectionId()) == false) goto L11;
        r105.add(r107);
        goto L11
    L16:
        if ((!r105.isEmpty()) == true) goto L19;
        r105 = null;
    L19:
        if (r105 != null) goto L20;
        r102.add(r104);
        goto L8
    L20:
        Iterator r108 = r105.iterator();
    L22:
        if (r108.hasNext() == false) goto L8;
        ArrayList<ECHybridListItemDTO> r109 = ((ECHybridListSectionDTO) r108.next()).getItems();
        if (r109 == null) goto L22;
        Collection<? extends ECHybridListItemDTO> r110 = r104.getItems();
        if (r110 != null) goto L28;
        r110 = CollectionsKt.emptyList();
    L28:
        r109.addAll(r110);
    L30:
        return r102;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void reportInitializeError$default(HybridPageViewModel r100, Map r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L5;
        r101 = null;
    L5:
        r100.reportInitializeError(r101);
    }

    public static void initData$default(HybridPageViewModel r100, Context r101, b r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L5;
        r102 = (b) HybridPageConfigSetting.f185949a.getValue();
    L5:
        r100.initData(r101, r102);
    }
}
