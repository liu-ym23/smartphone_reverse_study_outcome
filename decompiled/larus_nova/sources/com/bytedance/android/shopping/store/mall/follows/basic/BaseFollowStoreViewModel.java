package com.bytedance.android.shopping.store.mall.follows.basic;

import android.content.Context;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.arch.viewmodel.BaseViewModel;
import com.bytedance.android.ec.core.opt.ab.p;
import com.bytedance.android.ec.core.utils.k0;
import com.bytedance.android.ec.core.utils.t0;
import com.bytedance.android.ec.store.setting.ECStoreSettings;
import com.bytedance.android.ec.store.shopping.paging.LoadStatus;
import com.bytedance.android.shopping.store.mall.follows.DisplayType;
import com.bytedance.android.shopping.store.mall.follows.FollowStoreResponse;
import com.bytedance.android.shopping.store.mall.follows.PageLoadStatus;
import com.bytedance.android.shopping.store.mall.follows.ThemeStatus;
import com.bytedance.android.shopping.store.mall.follows.apidata.FollowStoreApiDataCacheKey;
import com.bytedance.android.shopping.store.mall.follows.apidata.FollowStoreApiDataManager;
import com.bytedance.android.shopping.store.moments.dto.HybridListDTO;
import com.bytedance.android.shopping.store.moments.dto.ItemDTO;
import com.bytedance.android.shopping.store.moments.dto.SectionDTO;
import com.bytedance.locallife.dito.data.DitoNode;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.discover.commodity.api.v3.FeedSection;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0016\u0018\u0000 o2\u00020\u0001:\u0001pB\u0007¢\u0006\u0004\bm\u0010nJI\u0010\r\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022#\u0010\n\u001a\u001f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u0005H\u0002J \u0010\u0012\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0005H\u0002J>\u0010\u001d\u001a\u00020\t2\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00132\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u0005H\u0002J\u001e\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u001f2\u0006\u0010\u001e\u001a\u00020\u0005H\u0002JB\u0010'\u001a\u00020\t2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u00132\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u00132\b\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010&\u001a\u00020%H\u0016J\u001c\u0010(\u001a\u00020\t2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013H\u0016J\u0006\u0010)\u001a\u00020\u0005J\u0014\u0010*\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0013JK\u0010-\u001a\u00020\t2\u0006\u0010,\u001a\u00020+2\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00052%\b\u0002\u0010\n\u001a\u001f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004R$\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R0\u00100\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u0010/\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u0017\u00106\u001a\u0002058\u0006¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109R(\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0:8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u0016\u0010A\u001a\u00020@8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\"\u0010\u0011\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR(\u0010H\u001a\b\u0012\u0004\u0012\u00020+0:8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bH\u0010;\u001a\u0004\bI\u0010=\"\u0004\bJ\u0010?R(\u0010L\u001a\b\u0012\u0004\u0012\u00020K0:8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bL\u0010;\u001a\u0004\bM\u0010=\"\u0004\bN\u0010?R(\u0010O\u001a\b\u0012\u0004\u0012\u00020\u00050:8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bO\u0010;\u001a\u0004\bP\u0010=\"\u0004\bQ\u0010?R\u0016\u0010R\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bR\u0010CR\u0017\u0010S\u001a\u00020\u00148\u0006¢\u0006\f\n\u0004\bS\u0010T\u001a\u0004\bU\u0010VR.\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u001f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010/\u001a\u0004\bW\u00102\"\u0004\bX\u00104R \u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010/R\u0018\u0010Z\u001a\u0004\u0018\u00010Y8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bZ\u0010[R$\u0010]\u001a\u0004\u0018\u00010\\8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR\u001d\u0010h\u001a\u0004\u0018\u00010c8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bd\u0010e\u001a\u0004\bf\u0010gR\u001d\u0010l\u001a\u0004\u0018\u00010@8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bi\u0010e\u001a\u0004\bj\u0010k¨\u0006q"}, d2 = {"Lcom/bytedance/android/shopping/store/mall/follows/basic/BaseFollowStoreViewModel;", "Lcom/bytedance/android/ec/core/arch/viewmodel/BaseViewModel;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "", "callback", "enableCache", "requestAfterCache", "fetchTab", "Lcom/bytedance/android/shopping/store/mall/follows/FollowStoreResponse;", "response", "firstFrame", "hasMore", "preprocessListData", "", "", "", "bizConfig", "Lcom/bytedance/android/shopping/store/moments/dto/ItemDTO;", "itemDTO", "", "displayType", "index", "isCacheData", "appendDisplayType", DitoNode.LOAD_MORE, "", "apiConfig", "pageParams", "reqParams", "Lorg/json/JSONObject;", "perfParams", "Lcom/bytedance/android/shopping/store/mall/follows/apidata/FollowStoreApiDataCacheKey;", "cacheKey", "init", "updatePageParams", "isDoubleRaw", "buildInitialData", "Lcom/bytedance/android/ec/store/shopping/paging/LoadStatus;", "status", "loadData", "passThroughParams", "Ljava/util/Map;", "paramsMap", "getParamsMap", "()Ljava/util/Map;", "setParamsMap", "(Ljava/util/Map;)V", "Lcom/bytedance/android/ec/hybrid/list/util/l;", "hybridListSession", "Lcom/bytedance/android/ec/hybrid/list/util/l;", "getHybridListSession", "()Lcom/bytedance/android/ec/hybrid/list/util/l;", "Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QLiveData;", "Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QLiveData;", "getResponse", "()Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QLiveData;", "setResponse", "(Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QLiveData;)V", "", EffectConfiguration.KEY_CURSOR, "J", "Z", "getHasMore", "()Z", "setHasMore", "(Z)V", "loadStatus", "getLoadStatus", "setLoadStatus", "Lcom/bytedance/android/shopping/store/mall/follows/ThemeStatus;", "themeStatus", "getThemeStatus", "setThemeStatus", "pageVisible", "getPageVisible", "setPageVisible", "fetchLock", "sceneId", "Ljava/lang/String;", "getSceneId", "()Ljava/lang/String;", "getPageParams", "setPageParams", "Lcom/bytedance/android/shopping/store/mall/follows/apidata/FollowStoreApiDataManager;", "dataManager", "Lcom/bytedance/android/shopping/store/mall/follows/apidata/FollowStoreApiDataManager;", "Lhj3/e;", "perfMonitor", "Lhj3/e;", "getPerfMonitor", "()Lhj3/e;", "setPerfMonitor", "(Lhj3/e;)V", "Lhj3/g;", "momentConfig$delegate", "Lkotlin/Lazy;", "getMomentConfig", "()Lhj3/g;", "momentConfig", "resourceVersion$delegate", "getResourceVersion", "()Ljava/lang/Long;", "resourceVersion", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class BaseFollowStoreViewModel extends BaseViewModel {
    public static final a Companion = null;
    public static final String KEY_APP_THEME = "app_theme";
    public static final String KEY_BTM_KEY = "btm_key";
    public static final String KEY_ECOM_SCENE_ID = "ecom_scene_id";
    public static final String KEY_PREVIOUS_PAGE = "previous_page";
    public static final String KEY_SKIN_INFO = "skin_info";
    public static final String KEY_TAB_ID = "tab_id";
    private long cursor;
    private FollowStoreApiDataManager dataManager;
    private boolean fetchLock;
    private boolean hasMore;
    private final com.bytedance.android.ec.hybrid.list.util.l hybridListSession;
    private QLiveData<LoadStatus> loadStatus;
    private final Lazy momentConfig$delegate;
    private Map<String, Object> pageParams;
    private QLiveData<Boolean> pageVisible;
    private Map<String, String> paramsMap;
    private Map<String, String> passThroughParams;
    private hj3.e perfMonitor;
    private final Map<String, Object> reqParams;
    private final Lazy resourceVersion$delegate;
    private QLiveData<FollowStoreResponse> response;
    private final String sceneId;
    private QLiveData<ThemeStatus> themeStatus;

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseFollowStoreViewModel f185581a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f185582b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Function1 f185583c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ boolean f185584d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ boolean f185585e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ boolean f185586f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ boolean f185587g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ boolean f185588h;

        public b(BaseFollowStoreViewModel r100, Context r101, Function1 r102, boolean r103, boolean r104, boolean r105, boolean r106, boolean r107) {
            this.f185581a = r100;
            this.f185582b = r101;
            this.f185583c = r102;
            this.f185584d = r103;
            this.f185585e = r104;
            this.f185586f = r105;
            this.f185587g = r106;
            this.f185588h = r107;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            FollowStoreResponse r101 = (FollowStoreResponse) r100;
            boolean r102 = false;
            if (r101.isCache() == false) goto L5;
            BaseFollowStoreViewModel.access$fetchTab(this.f185581a, this.f185582b, null, false, true);
        L5:
            hj3.e r103 = this.f185581a.getPerfMonitor();
            if (r103 == null) goto L8;
            r103.f485415d = Long.valueOf(System.currentTimeMillis());
        L8:
            Function1 r104 = this.f185583c;
            if (r104 == null) goto L12;
            Unit r105 = (Unit) r104.invoke(Boolean.TRUE);
        L12:
            if (r101.getStatusCode() == 0) goto L29;
            if (this.f185584d == false) goto L16;
        L22:
            LoadStatus r106 = LoadStatus.InitializeError;
        L23:
            this.f185581a.getLoadStatus().g(r106);
            if (this.f185584d == false) goto L50;
            hj3.e r107 = this.f185581a.getPerfMonitor();
            if (r107 == null) goto L51;
            r107.a(this.f185584d, PageLoadStatus.ERROR, Integer.valueOf(r101.getStatusCode()));
            return;
        L51:
            return;
        L50:
            return;
        L16:
            if (this.f185585e == true) goto L22;
            if (this.f185586f == false) goto L21;
            r106 = LoadStatus.RefreshError;
            goto L23
        L21:
            r106 = LoadStatus.LoadMoreError;
            goto L23
        L29:
            if (this.f185584d == true) goto L31;
        L37:
            BaseFollowStoreViewModel.access$setCursor$p(this.f185581a, r101.getCursor());
            this.f185581a.setHasMore(r101.getHasMore());
            r101.setFirstFrame(this.f185587g);
            r101.setInitFetch(this.f185584d);
            if (this.f185588h == false) goto L40;
        L41:
            r102 = true;
        L42:
            r101.setRequestAfterCache(r102);
            BaseFollowStoreViewModel.access$setPassThroughParams$p(this.f185581a, r101.getPassThroughParams());
            BaseFollowStoreViewModel r108 = this.f185581a;
            BaseFollowStoreViewModel.access$preprocessListData(r108, r101, this.f185587g, r108.getHasMore());
            this.f185581a.getResponse().g(r101);
            if (this.f185581a.getHasMore() == true) goto L46;
            this.f185581a.getLoadStatus().g(LoadStatus.LoadMoreEnd);
            return;
        L46:
            if (this.f185584d == false) goto L48;
            this.f185581a.getLoadStatus().g(LoadStatus.InitializeSuccess);
            return;
        L48:
            this.f185581a.getLoadStatus().g(LoadStatus.LoadMoreSuccess);
            return;
        L40:
            if (r101.isFeCache() == false) goto L42;
        L31:
            if (r101.isListEmpty() == false) goto L37;
            BaseFollowStoreViewModel.access$setFetchLock$p(this.f185581a, false);
            this.f185581a.getLoadStatus().g(LoadStatus.InitializeEmpty);
            if (this.f185584d == false) goto L53;
            hj3.e r109 = this.f185581a.getPerfMonitor();
            if (r109 == null) goto L54;
            r109.a(this.f185584d, PageLoadStatus.EMPTY, null);
            return;
        L54:
            return;
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseFollowStoreViewModel f185589a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function1 f185590b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f185591c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ boolean f185592d;

        public c(BaseFollowStoreViewModel r100, Function1 r101, boolean r102, boolean r103) {
            this.f185589a = r100;
            this.f185590b = r101;
            this.f185591c = r102;
            this.f185592d = r103;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            Function1 r102 = this.f185590b;
            if (r102 == null) goto L6;
            Unit r103 = (Unit) r102.invoke(Boolean.FALSE);
        L6:
            if (this.f185591c == false) goto L13;
            hj3.e r104 = this.f185589a.getPerfMonitor();
            if (r104 == null) goto L10;
            r104.f485415d = Long.valueOf(System.currentTimeMillis());
        L10:
            hj3.e r105 = this.f185589a.getPerfMonitor();
            if (r105 == null) goto L13;
            r105.a(this.f185591c, PageLoadStatus.ERROR, 100);
        L13:
            QLiveData<LoadStatus> r106 = this.f185589a.getLoadStatus();
            if (this.f185591c == false) goto L16;
        L19:
            LoadStatus r107 = LoadStatus.InitializeError;
        L20:
            r106.g(r107);
            BaseFollowStoreViewModel.access$setFetchLock$p(this.f185589a, false);
            return;
        L16:
            if (this.f185592d == true) goto L19;
            r107 = LoadStatus.LoadMoreError;
            goto L20
        }
    }

    public static final class d implements Action {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseFollowStoreViewModel f185593a;

        public d(BaseFollowStoreViewModel r100) {
            this.f185593a = r100;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            BaseFollowStoreViewModel.access$setFetchLock$p(this.f185593a, false);
            com.bytedance.android.ec.hybrid.list.util.l r100 = this.f185593a.getHybridListSession();
            r100.f47338d = Long.valueOf(System.currentTimeMillis());
        }
    }

    static {
        Companion = new a();
    }

    public BaseFollowStoreViewModel() {
        super(null, null, 3, null);
        this.hybridListSession = new com.bytedance.android.ec.hybrid.list.util.l();
        this.response = new QLiveData();
        this.hasMore = true;
        this.loadStatus = new QLiveData();
        this.themeStatus = new QLiveData();
        this.pageVisible = new QLiveData();
        this.sceneId = UUID.randomUUID().toString();
        this.pageParams = new LinkedHashMap();
        this.reqParams = new LinkedHashMap();
        this.momentConfig$delegate = LazyKt.lazy(BaseFollowStoreViewModel$momentConfig$2.INSTANCE);
        this.resourceVersion$delegate = LazyKt.lazy(new BaseFollowStoreViewModel$resourceVersion$2(this));
    }

    private final Long getResourceVersion() {
        return (Long) this.resourceVersion$delegate.getValue();
    }

    public final hj3.g getMomentConfig() {
        return (hj3.g) this.momentConfig$delegate.getValue();
    }

    public final Map<String, Object> buildInitialData() {
        LinkedHashMap r100 = new LinkedHashMap();
        r100.put("btm_ab", this.pageParams.get(KEY_BTM_KEY));
        r100.put("skin", this.pageParams.get(KEY_SKIN_INFO));
        r100.put("theme", this.pageParams.get(KEY_APP_THEME));
        JSONObject r101 = new JSONObject();
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L5
        r101.put("previous_page", this.pageParams.get("previous_page"));     // Catch: Throwable -> L5
        Object r103 = Result.m9449constructorimpl(r101.put("ecom_scene_id", this.pageParams.get("ecom_scene_id")));     // Catch: Throwable -> L5
    L7:
        JSONObject r104 = new JSONObject();
        if (Result.m9455isFailureimpl(r103) == false) goto L10;
        r103 = r104;
    L10:
        r100.put("log_extra", r103);
        return r100;
    L5:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public final boolean isDoubleRaw() {
        if (this.response.a() != null) goto L19;
        hj3.g r100 = getMomentConfig();
        if (r100 != null) goto L7;
        return true;
    L7:
        if (r100.j() != null) goto L9;
        return true;
    L9:
        if (r100.c() == null) goto L33;
        Long r101 = getResourceVersion();
        if (r101 == null) goto L13;
        long r102 = r101.longValue();
    L15:
        if (r102 >= r100.c().longValue()) goto L34;
        return false;
    L34:
        return true;
    L13:
        r102 = Long.MAX_VALUE;
        goto L15
    L33:
        return true;
    L19:
        FollowStoreResponse r103 = this.response.a();
        Object r104 = null;
        if (r103 == null) goto L24;
        Map<String, Object> r105 = r103.getBizConfig();
        if (r105 == null) goto L24;
        Object r106 = r105.get("card_column_style");
    L26:
        if ((r106 instanceof Double) == false) goto L30;
        r104 = r106;
    L30:
        return Intrinsics.areEqual((Double) r104, 1.0d);
    L24:
        r106 = null;
        goto L26
    }

    public final boolean getHasMore() {
        return this.hasMore;
    }

    public final com.bytedance.android.ec.hybrid.list.util.l getHybridListSession() {
        return this.hybridListSession;
    }

    public final QLiveData<LoadStatus> getLoadStatus() {
        return this.loadStatus;
    }

    public final Map<String, Object> getPageParams() {
        return this.pageParams;
    }

    public final QLiveData<Boolean> getPageVisible() {
        return this.pageVisible;
    }

    public final Map<String, String> getParamsMap() {
        return this.paramsMap;
    }

    public final hj3.e getPerfMonitor() {
        return this.perfMonitor;
    }

    public final QLiveData<FollowStoreResponse> getResponse() {
        return this.response;
    }

    public final String getSceneId() {
        return this.sceneId;
    }

    public final QLiveData<ThemeStatus> getThemeStatus() {
        return this.themeStatus;
    }

    public static final /* synthetic */ long access$getCursor$p(BaseFollowStoreViewModel r100) {
        return r100.cursor;
    }

    public static final /* synthetic */ boolean access$getFetchLock$p(BaseFollowStoreViewModel r100) {
        return r100.fetchLock;
    }

    public static final /* synthetic */ Map access$getPassThroughParams$p(BaseFollowStoreViewModel r100) {
        return r100.passThroughParams;
    }

    private final Map<String, Object> apiConfig(boolean r100) {
        LinkedHashMap r101 = new LinkedHashMap();
        if (r100 == false) goto L7;
        Map<String, String> r102 = this.passThroughParams;
        if (r102 == null) goto L7;
        r101.putAll(r102);
    L7:
        Map<String, String> r103 = this.paramsMap;
        if (r103 == null) goto L10;
        String r104 = r103.get("feed_back");
    L11:
        r101.put("feed_back", r104);
        return r101;
    L10:
        r104 = null;
        goto L11
    }

    public final void setHasMore(boolean r100) {
        this.hasMore = r100;
    }

    public final void setLoadStatus(QLiveData<LoadStatus> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.loadStatus = r100;
    }

    public final void setPageParams(Map<String, Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.pageParams = r100;
    }

    public final void setPageVisible(QLiveData<Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.pageVisible = r100;
    }

    public final void setParamsMap(Map<String, String> r100) {
        this.paramsMap = r100;
    }

    public final void setPerfMonitor(hj3.e r100) {
        this.perfMonitor = r100;
    }

    public final void setResponse(QLiveData<FollowStoreResponse> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.response = r100;
    }

    public final void setThemeStatus(QLiveData<ThemeStatus> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.themeStatus = r100;
    }

    public void updatePageParams(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "pageParams");
        this.pageParams.putAll(r100);
    }

    public static final /* synthetic */ void access$setCursor$p(BaseFollowStoreViewModel r100, long r101) {
        r100.cursor = r101;
    }

    public static final /* synthetic */ void access$setFetchLock$p(BaseFollowStoreViewModel r100, boolean r101) {
        r100.fetchLock = r101;
    }

    public static final /* synthetic */ void access$setPassThroughParams$p(BaseFollowStoreViewModel r100, Map r101) {
        r100.passThroughParams = r101;
    }

    private final void preprocessListData(FollowStoreResponse r110, boolean r111, boolean r112) {
        HybridListDTO r100 = r110.getHybridList();
        if (r100 == null) goto L46;
        List<SectionDTO> r101 = r100.getSections();
        if (r101 == null) goto L63;
        Iterator<T> r102 = r101.iterator();
    L8:
        if (r102.hasNext() == false) goto L64;
        SectionDTO r103 = (SectionDTO) r102.next();
        if (Intrinsics.areEqual(r103.getSectionId(), FeedSection.SECTION_FEED) == true) goto L11;
        ArrayList<ItemDTO> r104 = r103.getItems();
        if (r104 == null) goto L8;
        Iterator<T> r105 = r104.iterator();
        int r106 = 0;
    L41:
        if (r105.hasNext() == false) goto L8;
        Object r107 = r105.next();
        int r108 = r106 + 1;
        if (r106 >= 0) goto L45;
        CollectionsKt.throwIndexOverflow();
    L45:
        appendDisplayType(r110.getBizConfig(), (ItemDTO) r107, DisplayType.NORMAL.getValue(), r106, r110.isCache());
        r106 = r108;
        goto L41
    L11:
        ArrayList<ItemDTO> r109 = r103.getItems();
        if (r109 == null) goto L8;
        Iterator<T> r113 = r109.iterator();
        int r114 = 0;
    L15:
        if (r113.hasNext() == false) goto L8;
        Object r115 = r113.next();
        int r116 = r114 + 1;
        if (r114 >= 0) goto L19;
        CollectionsKt.throwIndexOverflow();
    L19:
        ItemDTO r117 = (ItemDTO) r115;
        if (r117.getItemType() != 50106) goto L25;
        if (r114 != 0) goto L25;
        if (r111 == false) goto L25;
        appendDisplayType(r110.getBizConfig(), r117, DisplayType.FILTER_CARD_FIRST.getValue(), r114, r110.isCache());
    L36:
        r114 = r116;
    L25:
        if (r117.getItemType() != 50106) goto L27;
    L31:
        if (r112 == false) goto L33;
    L35:
        appendDisplayType(r110.getBizConfig(), r117, DisplayType.NORMAL.getValue(), r114, r110.isCache());
        goto L36
    L33:
        if (r114 != (r109.size() - 1)) goto L35;
        appendDisplayType(r110.getBizConfig(), r117, DisplayType.CONTENT_CARD_LAST.getValue(), r114, r110.isCache());
        goto L36
    L27:
        if (r116 >= r109.size()) goto L31;
        if (((ItemDTO) ListProtector.get(r109, r116)).getItemType() != 50106) goto L31;
        appendDisplayType(r110.getBizConfig(), r117, DisplayType.CONTENT_CARD_BOTTOM_WITH_FILTER.getValue(), r114, r110.isCache());
        goto L36
    L64:
        return;
    L63:
        return;
    }

    public static final /* synthetic */ void access$preprocessListData(BaseFollowStoreViewModel r100, FollowStoreResponse r101, boolean r102, boolean r103) {
        r100.preprocessListData(r101, r102, r103);
    }

    private final void fetchTab(Context r110, Function1<? super Boolean, Unit> r210, boolean r211, boolean r212) {
        if (this.loadStatus.a() != LoadStatus.Refresh) goto L5;
        boolean r100 = true;
    L7:
        if (this.loadStatus.a() != LoadStatus.RefreshWhenError) goto L9;
        boolean r111 = true;
    L11:
        if (this.loadStatus.a() != LoadStatus.Initialize) goto L13;
        boolean r112 = true;
    L14:
        if (r100 == true) goto L19;
        if (r112 == true) goto L19;
        if (r111 == true) goto L19;
        boolean r101 = false;
    L20:
        if (r112 == false) goto L24;
        hj3.e r102 = this.perfMonitor;
        if (r102 == null) goto L24;
        r102.f485414c = Long.valueOf(System.currentTimeMillis());
    L24:
        Map<String, Object> r103 = apiConfig(!r101);
        r103.putAll(this.reqParams);
        r103.put("gecko_version", getResourceVersion());
        if (r101 == false) goto L27;
        r103.put("source", "mall_follow_tab_feed_follow");
        this.cursor = 0;
    L27:
        FollowStoreApiDataManager r104 = this.dataManager;
        if (r104 == null) goto L146;
        long r113 = this.cursor;
        HashMap<String, Object> r105 = (HashMap) r103;
        Intrinsics.checkNotNullParameter(r105, "apiConfig");
        if (r211 == false) goto L139;
        String r106 = r104.f185537e.getFeData();
        if (r106 == null) goto L75;
        if ((!StringsKt.isBlank(r106)) == true) goto L37;
        r106 = null;
    L37:
        if (r106 == null) goto L75;
        Result.Companion r114 = Result.Companion;     // Catch: Throwable -> L53
        Object r107 = new com.bytedance.android.shopping.store.mall.follows.apidata.b(r110).a(r106);     // Catch: Throwable -> L51
        if (r107 != null) goto L43;
    L48:
        FollowStoreResponse r108 = null;
    L49:
        Object r109 = Result.m9449constructorimpl(r108);     // Catch: Throwable -> L51
    L57:
        if (Result.m9455isFailureimpl(r109) == false) goto L59;
        r109 = null;
    L59:
        FollowStoreResponse r115 = (FollowStoreResponse) r109;
        if (r115 == null) goto L75;
        Lazy r116 = ECStoreSettings.f48572a;
        int r117 = p.f45243a;
        jj4.b r118 = jj4.b.f499326b;     // Catch: Throwable -> L64
        Object r119 = jj4.a.a("follow_shop_remove_storage_configs", com.bytedance.android.ec.store.setting.b.class, null, false);     // Catch: Throwable -> L64
    L69:
        if (r104.a((com.bytedance.android.ec.store.setting.b) r119, Long.valueOf(System.currentTimeMillis())) == false) goto L75;
        r115.setFeCache(true);
        hj3.e r120 = r104.f185536d;
        if (r120 == null) goto L73;
        r120.b(0, k0.b(r115));
    L73:
        Observable<FollowStoreResponse> r121 = Observable.just(r115);
    L76:
        if (r121 == null) goto L139;
        r104.f185533a = null;
    L128:
        if (r121 == null) goto L147;
        Observable r122 = bg4.b.b(r121);
        if (r122 == null) goto L148;
        Disposable r123 = r122.subscribe(new b(this, r110, r210, r112, r111, r100, r101, r212), new c(this, r210, r112, r111), new d(this));
        if (r123 == null) goto L149;
        com.bytedance.android.ec.core.async.a.a(r123, this);
        return;
    L149:
        return;
    L148:
        return;
    L147:
        return;
    L64:
        th = move-exception;
        Result.Companion r124 = Result.Companion;
        r119 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r119) == false) goto L69;
        r119 = null;
        goto L69
    L43:
        if ((r107 instanceof String) == true) goto L45;
        r107 = null;
    L45:
        String r125 = (String) r107;     // Catch: Throwable -> L51
        if (r125 == null) goto L48;
        int r126 = t0.f45720a;     // Catch: Throwable -> L51
        r108 = (FollowStoreResponse) t0.a.f45721a.fromJson(r125, FollowStoreResponse.class);     // Catch: Throwable -> L51
    L51:
        th = th;
    L55:
        Result.Companion r127 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L53:
        th = th;
    L75:
        r121 = null;
    L139:
        Result.Companion r128 = Result.Companion;     // Catch: Throwable -> L92
        io.reactivex.internal.observers.h<FollowStoreResponse> r129 = r104.f185533a;     // Catch: Throwable -> L92
        if (r129 != null) goto L82;
    L90:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L92
    L94:
        if (r211 == true) goto L96;
    L122:
        io.reactivex.internal.observers.h<FollowStoreResponse> r130 = r104.f185533a;
        if (r130 != null) goto L125;
    L127:
        r121 = r104.b(r113, r105);
        goto L128
    L125:
        if (r130.isCancelled() == true) goto L127;
        r121 = Observable.fromFuture(r104.f185533a);
        r104.f185533a = null;
        goto L128
    L96:
        if (ECSettingKeys.h0() == 0) goto L119;
        String r131 = com.bytedance.android.shopping.store.mall.follows.apidata.a.f185540a.query(r104.c());
        if (r131 == null) goto L119;
        int r132 = t0.f45720a;     // Catch: Throwable -> L102
        Object r133 = Result.m9449constructorimpl((FollowStoreResponse) t0.a.f45721a.fromJson(r131, FollowStoreResponse.class));     // Catch: Throwable -> L102
    L105:
        if (Result.m9455isFailureimpl(r133) == false) goto L107;
        r133 = null;
    L107:
        FollowStoreResponse r134 = (FollowStoreResponse) r133;
        if (r134 == null) goto L119;
        Lazy r135 = ECStoreSettings.f48572a;
        int r136 = p.f45243a;
        jj4.b r137 = jj4.b.f499326b;     // Catch: Throwable -> L112
        Object r138 = jj4.a.a("follow_page_remove_storage_configs", com.bytedance.android.ec.store.setting.b.class, null, false);     // Catch: Throwable -> L112
    L117:
        if (r104.a((com.bytedance.android.ec.store.setting.b) r138, null) == false) goto L119;
        r134.setCache(true);
        r121 = Observable.just(r134);
    L120:
        if (r121 == null) goto L122;
    L112:
        th = move-exception;
        Result.Companion r139 = Result.Companion;
        r138 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r138) == false) goto L117;
        r138 = null;
    L102:
        th = move-exception;
        Result.Companion r140 = Result.Companion;
        r133 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L119:
        r121 = null;
        goto L120
    L82:
        if (r129.isDone() != true) goto L90;
        io.reactivex.internal.observers.h<FollowStoreResponse> r141 = r104.f185533a;     // Catch: Throwable -> L92
        if (r141 == null) goto L90;
        FollowStoreResponse r142 = r141.get();     // Catch: Throwable -> L92
        if (r142 == null) goto L90;
        if (r142.getStatusCode() != 0) goto L90;
        r121 = Observable.fromFuture(r104.f185533a);     // Catch: Throwable -> L92
        r104.f185533a = null;     // Catch: Throwable -> L92
    L92:
        th = move-exception;
        Result.Companion r143 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L94
    L146:
        return;
    L19:
        r101 = true;
        goto L20
    L13:
        r112 = false;
        goto L14
    L9:
        r111 = false;
        goto L11
    L5:
        r100 = false;
        goto L7
    }

    public void init(Map<String, ? extends Object> r100, Map<String, ? extends Object> r101, JSONObject r102, FollowStoreApiDataCacheKey r103) {
        Intrinsics.checkNotNullParameter(r100, "pageParams");
        Intrinsics.checkNotNullParameter(r101, "reqParams");
        Intrinsics.checkNotNullParameter(r103, "cacheKey");
        this.pageParams.clear();
        this.reqParams.clear();
        this.pageParams.putAll(r100);
        this.reqParams.putAll(r101);
        this.loadStatus.g(LoadStatus.Initialize);
        hj3.e r104 = new hj3.e(r102);
        this.perfMonitor = r104;
        this.dataManager = new FollowStoreApiDataManager(r104, r103);
        if (ECSettingKeys.h0() != 1) goto L13;
        FollowStoreApiDataManager r105 = this.dataManager;
        if (r105 == null) goto L14;
        Intrinsics.checkNotNullParameter(r101, "reqParams");
        io.reactivex.internal.observers.h<FollowStoreResponse> r106 = new io.reactivex.internal.observers.h();
        HashMap<String, Object> r107 = new HashMap();
        r107.put("source", "mall_follow_tab_feed_follow");
        r107.put("gecko_version", (Long) r105.f185535c.getValue());
        r107.putAll(r101);
        Unit r108 = Unit.INSTANCE;
        Observable<FollowStoreResponse> r109 = r105.b(0, r107);
        if (r109 == null) goto L11;
        Observable<FollowStoreResponse> r110 = r109.subscribeOn(Schedulers.io());
        if (r110 == null) goto L11;
        r110.subscribe(r106);
    L11:
        r105.f185533a = r106;
        return;
    L14:
        return;
    }

    public final void loadData(LoadStatus r100, Context r110, boolean r111, Function1<? super Boolean, Unit> r112) {
        Intrinsics.checkNotNullParameter(r100, "status");
        if (this.fetchLock == false) goto L7;
        if (r112 == null) goto L9;
        Unit r101 = r112.invoke(Boolean.FALSE);
        return;
    L9:
        return;
    L7:
        this.fetchLock = true;
        this.loadStatus.g(r100);
        com.bytedance.android.ec.hybrid.list.util.l r102 = this.hybridListSession;
        r102.f47337c = Long.valueOf(System.currentTimeMillis());
        fetchTab$default(this, r110, r112, r111, false, 8, null);
    }

    public static final /* synthetic */ void access$fetchTab(BaseFollowStoreViewModel r100, Context r101, Function1 r102, boolean r103, boolean r104) {
        r100.fetchTab(r101, r102, r103, r104);
    }

    private final void appendDisplayType(Map<String, ? extends Object> r100, ItemDTO r101, int r102, int r103, boolean r110) {
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L40
        JSONObject r105 = new JSONObject(r101.getItemData());     // Catch: Throwable -> L40
        r105.put("card_display_type", r102);     // Catch: Throwable -> L40
        r105.put("index", r103);     // Catch: Throwable -> L40
        r105.put("item_id", r101.getItemId());     // Catch: Throwable -> L40
        if (r103 != 0) goto L6;
        boolean r106 = true;
    L7:
        r105.put("is_first_card", r106);     // Catch: Throwable -> L40
        String r107 = "1";
        if (r110 == false) goto L11;
        Object r108 = "1";
    L12:
        r105.put("is_cache_data", r108);     // Catch: Throwable -> L40
        if (r100 == null) goto L45;
        Iterator<Map.Entry<String, ? extends Object>> r109 = r100.entrySet().iterator();     // Catch: Throwable -> L40
    L16:
        if (r109.hasNext() == false) goto L45;
        Map.Entry<String, ? extends Object> r111 = r109.next();     // Catch: Throwable -> L40
        r105.put(r111.getKey(), r111.getValue());     // Catch: Throwable -> L40
    L45:
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L21
        Object r113 = Result.m9449constructorimpl(JSONObjectProtectorUtils.getJSONObject(r105, "log_extra"));     // Catch: Throwable -> L21
    L23:
        JSONObject r114 = new JSONObject();     // Catch: Throwable -> L40
        if (Result.m9455isFailureimpl(r113) == false) goto L26;
        r113 = r114;
    L26:
        JSONObject r115 = (JSONObject) r113;     // Catch: Throwable -> L40
        if (r110 == true) goto L30;
        r107 = "0";
    L30:
        r115.put("is_cache_data", r107);     // Catch: Throwable -> L40
        r105.put("log_extra", r115);     // Catch: Throwable -> L40
        Map<String, String> r116 = this.passThroughParams;     // Catch: Throwable -> L36
        if (r116 != null) goto L34;
        r116 = MapsKt.emptyMap();     // Catch: Throwable -> L36
    L34:
        Result.m9449constructorimpl(r105.put("pass_through_params", new JSONObject(r116)));     // Catch: Throwable -> L36
    L38:
        Unit r117 = Unit.INSTANCE;     // Catch: Throwable -> L40
        r101.setItemData(r105.toString());     // Catch: Throwable -> L40
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L40
        return;
    L36:
        th = move-exception;
        Result.Companion r118 = Result.Companion;     // Catch: Throwable -> L40
        Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L40
        goto L38
    L21:
        th = move-exception;
        Result.Companion r119 = Result.Companion;     // Catch: Throwable -> L40
        r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L40
        goto L23
    L11:
        r108 = "0";
        goto L12
    L6:
        r106 = false;
    L40:
        th = move-exception;
        Result.Companion r120 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public static /* synthetic */ void fetchTab$default(BaseFollowStoreViewModel r100, Context r101, Function1 r102, boolean r103, boolean r104, int r105, Object r106) {
        if (r106 != null) goto L9;
        if ((r105 & 8) == 0) goto L6;
        r104 = false;
    L6:
        r100.fetchTab(r101, r102, r103, r104);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fetchTab");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void loadData$default(BaseFollowStoreViewModel r100, LoadStatus r101, Context r102, boolean r103, Function1 r104, int r105, Object r106) {
        if (r106 != null) goto L15;
        if ((r105 & 2) == 0) goto L7;
        r102 = null;
    L7:
        if ((r105 & 4) == 0) goto L10;
        r103 = false;
    L10:
        if ((r105 & 8) == 0) goto L12;
        r104 = null;
    L12:
        r100.loadData(r101, r102, r103, r104);
        return;
    L15:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadData");
    }
}
