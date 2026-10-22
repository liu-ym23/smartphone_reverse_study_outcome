package com.bytedance.android.shopping.store.router.hybridpage.presenter.page;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.hybrid.bridge.LynxStatefulBridgeProxy;
import com.bytedance.android.ec.hybrid.card.api.ECLynxLoadParam;
import com.bytedance.android.ec.hybrid.card.impl.ECLynxCard;
import com.bytedance.android.ec.hybrid.list.entity.ECHybridListItemVO;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.shopping.store.router.hybridpage.event.PageCardEventManager;
import com.bytedance.android.shopping.store.router.hybridpage.setting.HybridPageConfigSetting;
import com.bytedance.android.shopping.store.router.hybridpage.viewmodel.HybridPageViewModel;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.google.gson.Gson;
import com.lynx.tasm.LynxView;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005J\b\u0010\u0004\u001a\u00020\u0003H\u0007¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/shopping/store/router/hybridpage/presenter/page/HybridPageCardPresenter;", "Lcom/ss/android/ugc/aweme/kiwi/presenter/QFragmentPresenter;", "Landroidx/lifecycle/LifecycleObserver;", "", "onResume", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class HybridPageCardPresenter extends QFragmentPresenter implements LifecycleObserver {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f185906m = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ECLynxCard f185907f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ViewGroup f185908g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Gson f185909h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f185910i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List<Function0<Unit>> f185911j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f185912k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final HybridPageCardPresenter$pageCardEventListener$1 f185913l;

    public static final class a {
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HybridPageCardPresenter f185914a;

        public b(HybridPageCardPresenter r100) {
            this.f185914a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r110) {
            JSONObject r111 = (JSONObject) r110;
            dm.a.b r100 = dm.a.a("HybridPageCardPresenter");
            StringBuilder r101 = new StringBuilder("configJson observed, template=");
            r101.append(this.f185914a.i0());
            r101.append(", notNull=");
            if (r111 == null) goto L5;
            boolean r112 = true;
        L6:
            r101.append(r112);
            r100.i(r101.toString());
            final HybridPageCardPresenter r113 = this.f185914a;
            String r102 = r113.j0().getPageCardUrl();
            if (r102 == null) goto L43;
            dm.a.b r103 = dm.a.a("HybridPageCardPresenter");
            StringBuilder r104 = new StringBuilder("initLynxCard, schema=");
            r104.append(r102);
            r104.append(", template=");
            r104.append(r113.i0());
            r104.append(", configJsonNotNull=");
            if (r113.j0().getConfigJson().getValue() == null) goto L12;
            boolean r105 = true;
        L13:
            r104.append(r105);
            r104.append(", routerQueryKeys=");
            Map<String, Object> r106 = r113.j0().getRouterQuery();
            View r107 = null;
            if (r106 == null) goto L16;
            Set<String> r108 = r106.keySet();
        L17:
            r104.append(r108);
            r104.append(", abParams=");
            r104.append(r113.h0());
            r103.i(r104.toString());
            View r109 = r113.a0();
            if (r109 == null) goto L46;
            r113.f185908g = (ViewGroup) r109;
            FrameLayout r114 = new FrameLayout(r113.a0().getContext());
            r114.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            ViewGroup r115 = r113.f185908g;
            if (r115 != null) goto L22;
            Intrinsics.throwUninitializedPropertyAccessException("lynxContainer");
        L22:
            r115.addView(r114);
            r113.f185907f = new ECLynxCard();
            ECLynxLoadParam.a r116 = new ECLynxLoadParam.a(r113.a0().getContext(), r102, r114);
            r116.j(2000);
            c r117 = new c(r113, r102);
            Intrinsics.checkNotNullParameter(r117, NewBroadcastMonitor.STAGE.LIFECYCLE);
            r116.f46350o = r117;
            r116.h(r113.j0().getSceneId());
            r116.d(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("hybridPage.bindSliceDataSource", new LynxStatefulBridgeProxy(new HybridPageCardPresenter$makeJsBridgeMap$1(r113), "hybridPage.bindSliceDataSource")), TuplesKt.to("hybridPage.getHybridListData", new LynxStatefulBridgeProxy(new HybridPageCardPresenter$makeJsBridgeMap$2(r113), "hybridPage.getHybridListData"))}));
            LinkedHashMap r118 = new LinkedHashMap();
            Map<String, Object> r119 = r113.j0().getRouterQuery();
            if (r119 != null) goto L25;
            r119 = new LinkedHashMap();
        L25:
            r118.put("router_query", r119);
            Object r120 = (JSONObject) r113.j0().getConfigJson().getValue();
            if (r120 != null) goto L28;
            r120 = new LinkedHashMap();
        L28:
            r118.put(LynxMonitorService.KEY_PAGE_CONFIG, r120);
            r118.put(AppConstants.BUNDLE_ACTIVITY_AB_PARAMS_KEYS, r113.h0());
            Unit r121 = Unit.INSTANCE;
            Intrinsics.checkNotNullParameter(r118, "ecGlobalProps");
            r116.f46351p = r118;
            ECLynxLoadParam r122 = new ECLynxLoadParam(r116);
            ECLynxCard r123 = r113.f185907f;
            if (r123 == null) goto L31;
            View r124 = r123.i();
        L33:
            if ((r124 instanceof LynxView) == false) goto L36;
            r107 = r124;
        L36:
            LynxView r125 = (LynxView) r107;
            if (r125 == null) goto L39;
            r125.addLynxViewClient(new com.bytedance.android.shopping.store.router.hybridpage.presenter.page.b());
        L39:
            ECLynxCard r126 = r113.f185907f;
            if (r126 == null) goto L42;
            r126.j(r122);
        L42:
            r114.setVisibility(8);
            goto L43
        L31:
            r124 = null;
            goto L33
        L46:
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
        L16:
            r108 = null;
            goto L17
        L12:
            r105 = false;
        L43:
            this.f185914a.k0();
            return;
        L5:
            r112 = false;
            goto L6
        }
    }

    static {
    }

    public abstract String i0();

    public final HybridPageViewModel j0() {
        return (HybridPageViewModel) this.f185912k.getValue();
    }

    public void k0() {
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter
    public final void c0() {
        ReentrantReadWriteLock r100 = PageCardEventManager.f185868a;
        PageCardEventManager.l(j0().getSceneId());
        String r101 = j0().getSceneId();
        HybridPageCardPresenter$pageCardEventListener$1 r102 = this.f185913l;
        Intrinsics.checkNotNullParameter(r101, "sceneId");
        Intrinsics.checkNotNullParameter(r102, "listener");
        ReentrantReadWriteLock r103 = PageCardEventManager.f185868a;
        ReentrantReadWriteLock.ReadLock r104 = r103.readLock();
        int r105 = 0;
        if (r103.getWriteHoldCount() != 0) goto L5;
        int r106 = r103.getReadHoldCount();
    L6:
        int r107 = 0;
    L7:
        if (r107 >= r106) goto L9;
        r104.unlock();
        r107 = r107 + 1;
        goto L7
    L9:
        ReentrantReadWriteLock.WriteLock r108 = r103.writeLock();
        r108.lock();
        Lazy r109 = PageCardEventManager.f185869b;     // Catch: Throwable -> L16
        Set r110 = (Set) ((Map) r109.getValue()).get(r101);     // Catch: Throwable -> L16
        if (r110 == null) goto L18;
        r110.remove(r102);     // Catch: Throwable -> L16
        if (r110.isEmpty() == false) goto L18;
        ((Map) r109.getValue()).remove(r101);     // Catch: Throwable -> L16
    L18:
        Unit r111 = Unit.INSTANCE;     // Catch: Throwable -> L16
    L19:
        if (r105 >= r106) goto L21;
        r104.lock();
        r105 = r105 + 1;
        goto L19
    L21:
        r108.unlock();
        return;
    L16:
        th = move-exception;
    L23:
        if (r105 >= r106) goto L25;
        r104.lock();
        r105 = r105 + 1;
        goto L23
    L25:
        r108.unlock();
        throw th;
    L5:
        r106 = 0;
        goto L6
    }

    public Map<String, Object> h0() {
        LinkedHashMap r100 = new LinkedHashMap();
        r100.put("ec_shop_search_result_hybrid_refactor", Integer.valueOf(((Number) HybridPageConfigSetting.f185951c.getValue()).intValue()));
        return r100;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        ReentrantReadWriteLock r100 = PageCardEventManager.f185868a;
        PageCardEventManager.k(j0().getSceneId(), false);
    }

    public HybridPageCardPresenter(final Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        super(r100);
        this.f185909h = new Gson();
        this.f185911j = new ArrayList();
        this.f185912k = LazyKt.lazy(new HybridPageCardPresenter$viewModel$2(this, r100));
        this.f185913l = new HybridPageCardPresenter$pageCardEventListener$1(this);
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter
    public final void b0(QModel r100) {
        LifecycleOwner r101 = this.f450897e;
        if (r101 != null) goto L6;
        r101 = ECQuickUtilKt.a(Y());
    L6:
        Lifecycle r102 = r101.getLifecycle();
        if (r102 == null) goto L9;
        r102.addObserver(this);
    L9:
        ReentrantReadWriteLock r103 = PageCardEventManager.f185868a;
        String r104 = j0().getSceneId();
        HybridPageCardPresenter$pageCardEventListener$1 r105 = this.f185913l;
        Intrinsics.checkNotNullParameter(r104, "sceneId");
        Intrinsics.checkNotNullParameter(r105, "listener");
        ReentrantReadWriteLock r106 = PageCardEventManager.f185868a;
        ReentrantReadWriteLock.ReadLock r107 = r106.readLock();
        int r108 = 0;
        if (r106.getWriteHoldCount() != 0) goto L12;
        int r109 = r106.getReadHoldCount();
    L13:
        int r110 = 0;
    L14:
        if (r110 >= r109) goto L16;
        r107.unlock();
        r110 = r110 + 1;
        goto L14
    L16:
        ReentrantReadWriteLock.WriteLock r111 = r106.writeLock();
        r111.lock();
        Map r112 = (Map) PageCardEventManager.f185869b.getValue();     // Catch: Throwable -> L26
        Object r113 = r112.get(r104);     // Catch: Throwable -> L26
        if (r113 != null) goto L20;
        r113 = new LinkedHashSet();     // Catch: Throwable -> L26
        r112.put(r104, r113);     // Catch: Throwable -> L26
    L20:
        ((Set) r113).add(r105);     // Catch: Throwable -> L26
        int r114 = 0;
    L22:
        if (r114 >= r109) goto L24;
        r107.lock();
        r114 = r114 + 1;
        goto L22
    L24:
        r111.unlock();
        j0().getConfigJson().a(this.f450897e, new b(this), false);
        ReentrantReadWriteLock r115 = PageCardEventManager.f185868a;
        PageCardEventManager.k(j0().getSceneId(), true);
        return;
    L26:
        th = move-exception;
    L27:
        if (r108 >= r109) goto L29;
        r107.lock();
        r108 = r108 + 1;
        goto L27
    L29:
        r111.unlock();
        throw th;
    L12:
        r109 = 0;
        goto L13
    }

    public static final JSONObject d0(HybridPageCardPresenter r100, ECHybridListItemVO r101) {
        r100.getClass();
        JSONObject r102 = new JSONObject();
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L32
        JSONObject r104 = new JSONObject();     // Catch: Throwable -> L32
        String r105 = r101.f47029d;     // Catch: Throwable -> L32
        String r106 = "";
        if (r105 != null) goto L7;
        r105 = "";
    L7:
        r104.put("item_id", r105);     // Catch: Throwable -> L32
        Integer r107 = r101.f47028c;     // Catch: Throwable -> L32
        int r108 = 0;
        if (r107 == null) goto L10;
        int r109 = r107.intValue();     // Catch: Throwable -> L32
    L11:
        r104.put(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ITEM_TYPE, r109);     // Catch: Throwable -> L32
        String r110 = r101.g();     // Catch: Throwable -> L32
        if (r110 != null) goto L14;
        r110 = "";
    L14:
        r104.put("item_data", r110);     // Catch: Throwable -> L32
        Integer r111 = r101.i();     // Catch: Throwable -> L32
        if (r111 == null) goto L17;
        r108 = r111.intValue();     // Catch: Throwable -> L32
    L17:
        r104.put("span_size", r108);     // Catch: Throwable -> L32
        Gson r112 = r100.f185909h;     // Catch: Throwable -> L32
        Object r113 = r112.fromJson(r112.toJson(r101.c()), Map.class);     // Catch: Throwable -> L32
        if ((r113 instanceof Map) == true) goto L20;
        r113 = null;
    L20:
        Object r114 = (Map) r113;     // Catch: Throwable -> L32
        if (r114 != null) goto L23;
        r114 = new LinkedHashMap();     // Catch: Throwable -> L32
    L23:
        r104.put("extra", r114);     // Catch: Throwable -> L32
        r104.put("item_operation_type", r101.f47042p);     // Catch: Throwable -> L32
        String r115 = r101.f47044r;     // Catch: Throwable -> L32
        if (r115 == null) goto L27;
        r106 = r115;
    L27:
        r104.put("section_id", r106);     // Catch: Throwable -> L32
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L30
        return r104;
    L30:
        th = th;
        r102 = r104;
    L33:
        Result.Companion r116 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return r102;
    L10:
        r109 = 0;
    L32:
        th = th;
        goto L33
    }

    public static final void e0(HybridPageCardPresenter r100, Function0 r101) {
        if (r100.f185910i == false) goto L5;
        r101.invoke();
        return;
    L5:
        ((ArrayList) r100.f185911j).add(r101);
    }
}
