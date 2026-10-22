package com.bytedance.android.shopping.store.home.slice;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.store.view.ECAutoScrollHorizontalScrollView;
import com.bytedance.android.ec.store.view.ECScrollTagListView;
import com.bytedance.android.ec.store.view.ECTagListView;
import com.bytedance.android.ecom.arch.slice.render.context.SlcRenderContext;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.SlcElementContainer;
import com.bytedance.android.ecom.arch.slice.render.r;
import com.bytedance.android.livesdk.ec.adapter.api.FloatWindowState;
import com.bytedance.android.livesdk.ec.adapter.api.Scene;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.store.home.a0;
import com.bytedance.android.shopping.store.home.b0;
import com.bytedance.android.shopping.store.home.entity.n;
import com.bytedance.android.shopping.store.home.presenter.ECShopBasePresenter;
import com.bytedance.android.shopping.store.home.view.ECShopMarqueeTextView;
import com.bytedance.android.shopping.store.lifecycle.m;
import com.bytedance.android.shopping.store.slicecard.ShopSlcCardFactory;
import com.bytedance.android.shopping.store.slicecard.ShopSliceKey;
import com.bytedance.android.shopping.store.slicecard.ShopSliceUniqueId;
import com.bytedance.android.shopping.store.slicecard.SliceItemType;
import com.bytedance.android.shopping.store.slicecard.dto.ShopSliceItemConfig;
import com.bytedance.android.shopping.store.slicecard.dto.SliceTemplate;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.ttvideoengine.ITTVideoEngineEventSource;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0006J\b\u0010\u0004\u001a\u00020\u0003H\u0007J\b\u0010\u0005\u001a\u00020\u0003H\u0007¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/shopping/store/home/slice/ECShopSliceProfilePresenter;", "Lcom/bytedance/android/shopping/store/home/presenter/ECShopBasePresenter;", "Landroidx/lifecycle/LifecycleObserver;", "", "onResume", "onPause", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECShopSliceProfilePresenter extends ECShopBasePresenter implements LifecycleObserver {
    public static final /* synthetic */ int D = 0;
    public Map<String, Object> A;
    public final Lazy B;
    public boolean C;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public r f184489u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public ECScrollTagListView f184490v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public View f184491w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Map<String, ? extends Object> f184492x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Map<String, Object> f184493y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Map<String, Object> f184494z;

    public static final class a {
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECShopSliceProfilePresenter f184495a;

        public b(ECShopSliceProfilePresenter r100) {
            this.f184495a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            n r101 = (n) r100;
            Intrinsics.checkNotNullParameter(r101, "headerArea");
            com.bytedance.android.shopping.store.home.slice.d r102 = r101.f183761o;
            if (r102 == null) goto L115;
            Map<Long, m> r103 = com.bytedance.android.shopping.store.lifecycle.a.f185441a;
            m r104 = com.bytedance.android.shopping.store.lifecycle.a.a(Long.valueOf(this.f184495a.T().getStoreParam().getLifecycleMonitorId()));
            if (r104 == null) goto L7;
            r104.t();
        L7:
            ECShopSliceProfilePresenter r105 = this.f184495a;
            r105.T().getSliceService().d(com.bytedance.android.shopping.store.home.slice.f.a(r102));
            ShopSlcCardFactory r106 = r105.T().getSliceCardFactory();
            Map<String, ECStoreHeaderInfoSliceConfig> r107 = r102.f184505a;
            View r108 = null;
            if (r107 == null) goto L18;
            ECStoreHeaderInfoSliceConfig r109 = r107.get(SliceItemType.SHOP_PROFILE.getType());
            if (r109 == null) goto L18;
            ShopSliceItemConfig r110 = r109.getSliceItemConfig();
            if (r110 == null) goto L18;
            List<SliceTemplate> r111 = r110.getTemplates();
            if (r111 == null) goto L18;
            SliceTemplate r112 = (SliceTemplate) CollectionsKt.firstOrNull(r111);
            if (r112 == null) goto L18;
            String r113 = r112.getName();
        L19:
            r r114 = r106.c(r113);
            r105.f184489u = r114;
            if (r114 == null) goto L22;
            r114.b((com.bytedance.android.shopping.store.slicecard.e) r105.B.getValue());
        L22:
            r r115 = r105.f184489u;
            if (r115 == null) goto L27;
            SlcTemplateContext r116 = r115.f50700b;
            if (r116 == null) goto L27;
            r116.s(ShopSliceUniqueId.SHOP_PROFILE.getId(), new ECShopSliceProfilePresenter$initViewInfo$1(r105));
        L27:
            ECShopSliceProfilePresenter.s0(this.f184495a, r102, r101.f183749c);
            ECShopSliceProfilePresenter.q0(this.f184495a);
            com.bytedance.android.shopping.store.lifecycle.a.a(Long.valueOf(this.f184495a.T().getStoreParam().getLifecycleMonitorId()));
            m r117 = com.bytedance.android.shopping.store.lifecycle.a.a(Long.valueOf(this.f184495a.T().getStoreParam().getLifecycleMonitorId()));
            if (r117 == null) goto L30;
            r117.T();
        L30:
            final ECShopSliceProfilePresenter r118 = this.f184495a;
            r r119 = r118.f184489u;
            if (r119 == null) goto L113;
            View r120 = r119.f50701c;
            if (r120 == null) goto L113;
            FrameLayout.LayoutParams r121 = new FrameLayout.LayoutParams(-1, -2);
            View r122 = r118.y();
            if ((r122 instanceof ViewGroup) == true) goto L37;
            r122 = null;
        L37:
            ViewGroup r123 = (ViewGroup) r122;
            if (r123 == null) goto L40;
            r123.addView(r120, r121);
        L40:
            r r124 = r118.f184489u;
            if (r124 == null) goto L47;
            SlcTemplateContext r125 = r124.f50700b;
            if (r125 == null) goto L47;
            if (r125.f50235w == null) goto L47;
            View r126 = SlcRenderContext.f(r120, ShopSliceKey.SHORT_TERM_INDICATORS.getKey());
        L49:
            if ((r126 instanceof SlcElementContainer) == true) goto L51;
            r126 = null;
        L51:
            SlcElementContainer r127 = (SlcElementContainer) r126;
            if (r127 == null) goto L54;
            View r128 = r127.getContentView();
        L56:
            if ((r128 instanceof ECTagListView) == true) goto L58;
            r128 = null;
        L58:
            ECTagListView r129 = (ECTagListView) r128;
            r r130 = r118.f184489u;
            if (r130 == null) goto L65;
            SlcTemplateContext r131 = r130.f50700b;
            if (r131 == null) goto L65;
            if (r131.f50235w == null) goto L65;
            View r132 = SlcRenderContext.f(r120, ShopSliceKey.LONG_TERM_INDICATORS.getKey());
        L67:
            if ((r132 instanceof SlcElementContainer) == true) goto L69;
            r132 = null;
        L69:
            SlcElementContainer r133 = (SlcElementContainer) r132;
            if (r133 == null) goto L72;
            View r134 = r133.getContentView();
        L74:
            if ((r134 instanceof ECScrollTagListView) == true) goto L76;
            r134 = null;
        L76:
            r118.f184490v = (ECScrollTagListView) r134;
            r r135 = r118.f184489u;
            if (r135 == null) goto L83;
            SlcTemplateContext r136 = r135.f50700b;
            if (r136 == null) goto L83;
            if (r136.f50235w == null) goto L83;
            View r137 = SlcRenderContext.f(r120, ShopSliceKey.SHOP_NAME.getKey());
        L85:
            if ((r137 instanceof SlcElementContainer) == true) goto L87;
            r137 = null;
        L87:
            SlcElementContainer r138 = (SlcElementContainer) r137;
            if (r138 == null) goto L90;
            View r139 = r138.getContentView();
        L92:
            if ((r139 instanceof ECShopMarqueeTextView) == true) goto L94;
            r139 = null;
        L94:
            ECShopMarqueeTextView r140 = (ECShopMarqueeTextView) r139;
            if (r140 == null) goto L97;
            r140.setOnScrollEndAction(new ECShopSliceProfilePresenter$initViews$$inlined$let$lambda$1(r118));
        L97:
            r r141 = r118.f184489u;
            if (r141 == null) goto L104;
            SlcTemplateContext r142 = r141.f50700b;
            if (r142 == null) goto L104;
            if (r142.f50235w == null) goto L104;
            View r143 = SlcRenderContext.f(r120, ShopSliceKey.SHOP_LOGO.getKey());
        L105:
            r118.f184491w = r143;
            ECStoreViewModel r144 = r118.T();
            r r145 = r118.f184489u;
            if (r145 == null) goto L112;
            SlcTemplateContext r146 = r145.f50700b;
            if (r146 == null) goto L112;
            if (r146.f50235w == null) goto L112;
            r108 = SlcRenderContext.f(r120, ShopSliceKey.FOLLOW_BUTTON.getKey());
        L112:
            r144.setSliceHeaderFollowButtonView(new WeakReference(r108));
        L104:
            r143 = null;
            goto L105
        L90:
            r139 = null;
        L83:
            r137 = null;
            goto L85
        L72:
            r134 = null;
        L65:
            r132 = null;
            goto L67
        L54:
            r128 = null;
        L47:
            r126 = null;
        L113:
            r118.T().getViewTransitShipment().d(Reflection.getOrCreateKotlinClass(com.bytedance.android.shopping.store.viewmodel.d.class), new com.bytedance.android.shopping.store.home.slice.b(r118));
            return;
        L18:
            r113 = null;
            goto L19
        }
    }

    public static final class c<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECShopSliceProfilePresenter f184496a;

        public c(ECShopSliceProfilePresenter r100) {
            this.f184496a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            a0 r101 = (a0) r100;
            Intrinsics.checkNotNullParameter(r101, "followConfig");
            h.a(this.f184496a.f184494z, r101, "ECShopInfoTotalAreaSlicePresenter");
            ECShopSliceProfilePresenter.q0(this.f184496a);
        }
    }

    public static final class d<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECShopSliceProfilePresenter f184497a;

        public d(ECShopSliceProfilePresenter r100) {
            this.f184497a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            ((Number) r100).floatValue();
            ECShopSliceProfilePresenter r101 = this.f184497a;
            if (r101.U() == false) goto L5;
            float r102 = 1.0f;
        L6:
            this.f184497a.f184494z.put("media_scroll_percent", Float.valueOf(r102));
            ECShopSliceProfilePresenter.q0(this.f184497a);
            ECShopSliceProfilePresenter.r0(this.f184497a);
            return;
        L5:
            r102 = r101.b0();
            goto L6
        }
    }

    public static final class e<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECShopSliceProfilePresenter f184498a;

        public e(ECShopSliceProfilePresenter r100) {
            this.f184498a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Map<String, Object> r101 = this.f184498a.f184494z;
            r101.put("profile_scroll_percent", (Float) r100);
            ECShopSliceProfilePresenter.q0(this.f184498a);
            ECShopSliceProfilePresenter.r0(this.f184498a);
        }
    }

    public static final class f<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECShopSliceProfilePresenter f184499a;

        public f(ECShopSliceProfilePresenter r100) {
            this.f184499a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Boolean r101 = (Boolean) r100;
            ECScrollTagListView r102 = this.f184499a.f184490v;
            if (r102 == null) goto L5;
            r102.setHasShopNameScrollEnd(true);
        L5:
            ECShopSliceProfilePresenter.r0(this.f184499a);
        }
    }

    static {
    }

    public ECShopSliceProfilePresenter() {
        this(null);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void onPause() {
        this.C = true;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        if (this.C == false) goto L9;
        T().refreshHeaderArea(new AnonymousClass1(this));
        int r100 = ECSdk.f48106a;
        IAdapterService r101 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r101 == null) goto L9;
        wu1.a r102 = r101.getECLiveStateController();
        if (r102 == null) goto L9;
        r102.a(Scene.SHOP);
    L9:
        this.C = false;
    }

    public ECShopSliceProfilePresenter(Fragment r100) {
        super(r100);
        this.f184494z = new LinkedHashMap();
        this.B = LazyKt.lazy(new ECShopSliceProfilePresenter$slcActionHandler$2(this));
    }

    public static final void q0(ECShopSliceProfilePresenter r100) {
        if (r100.f184492x == null) goto L35;
        Map<String, Object> r101 = r100.f184494z;
        if (r100.T().getStoreParam().getStoreUIParam().getLiveDefaultMute() == false) goto L8;
        String r102 = ITTVideoEngineEventSource.KEY_MUTE;
    L12:
        r101.put("shop_live_volume_state", r102);
        int r103 = ECSdk.f48106a;
        IAdapterService r104 = (IAdapterService) ECSdk.a(IAdapterService.class);
        Object r105 = null;
        if (r104 == null) goto L15;
        wu1.a r106 = r104.getECLiveStateController();
    L17:
        if (r100.T().canShowLiveIcon() == true) goto L19;
    L22:
        LinkedHashMap r107 = new LinkedHashMap();
        r107.putAll(r100.f184494z);
        r107.putAll(r100.T().getSliceService().a());
        LinkedHashMap r108 = new LinkedHashMap();
        Map<String, ? extends Object> r109 = r100.f184492x;
        if (r109 != null) goto L25;
        r109 = MapsKt.emptyMap();
    L25:
        r108.putAll(r109);
        r108.put("slice_item_actions", r100.f184493y);
        r108.put("slice_item_states", r107);
        r108.put("slice_item_extra", r100.A);
        Unit r110 = Unit.INSTANCE;
        Map<String, ? extends Object> r111 = MapsKt.mapOf(TuplesKt.to("data", r108));
        dm.a.a("ECShopInfoTotalAreaSlicePresenter").a("bindData, sliceItemStates: " + r100.f184494z);
        dm.a.b r112 = dm.a.a("ECShopInfoTotalAreaSlicePresenter");
        StringBuilder r113 = new StringBuilder("bindData, dataCtx sliceItemStates: ");
        Object r114 = r111.get("data");
        if (r114 == null) goto L30;
        Map<String, Object> r115 = com.bytedance.android.ecom.arch.slice.render.util.b.o(r114);
        if (r115 == null) goto L30;
        r105 = r115.get("slice_item_states");
    L30:
        r113.append(r105);
        r112.a(r113.toString());
        r r116 = r100.f184489u;
        if (r116 == null) goto L34;
        r116.a(r111, ShopSliceUniqueId.SHOP_PROFILE.getId());
        return;
    L34:
        return;
    L19:
        if (r100.T().getStoreParam().getStoreUIParam().getCanShowFloatLive() == false) goto L22;
        if (r106 == null) goto L22;
        FloatWindowState r117 = FloatWindowState.OPEN;
        Scene r118 = Scene.LIVE;
        r106.b(r117);
        goto L22
    L15:
        r106 = null;
        goto L17
    L8:
        int r119 = ECSdk.f48106a;
        IAdapterService r120 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r120 == null) goto L11;
        r120.muteLiveRoom();
    L11:
        r102 = "unmute";
        goto L12
    }

    public static final void r0(ECShopSliceProfilePresenter r100) {
        if (r100.T().getUseNewSign() == true) goto L5;
    L13:
        ECScrollTagListView r101 = r100.f184490v;
        if (r101 != null) goto L16;
        return;
    L16:
        if (r101.getVisibility() != 0) goto L26;
        ECAutoScrollHorizontalScrollView r102 = r101.f48727d;
        if (r102 == null) goto L25;
        r102.f48703a.forceFinished(true);
        return;
    L25:
        return;
    L26:
        return;
    L5:
        if (Intrinsics.areEqual(r100.T().getHeaderAreaStartScrollTag().getValue(), Boolean.TRUE) == false) goto L13;
        if (k.e(r100.T().getUpglideFactor().getValue(), 0.0f) > 0.0f) goto L13;
        if (k.e(r100.T().getCollapseFactor().getValue(), 1.0f) < 1.0f) goto L13;
        ECScrollTagListView r103 = r100.f184490v;
        if (r103 == null) goto L22;
        r103.a();
        return;
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QPresenter
    public final void A(QModel r100) {
        Lifecycle r101 = W().getLifecycle();
        if (r101 == null) goto L5;
        r101.addObserver(this);
    L5:
        T().getHeaderArea().a(W(), new b(this), false);
        T().getFollowConfigLiveData().a(W(), new c(this), false);
        T().getCollapseFactor().a(ECQuickUtilKt.a(u()), new d(this), false);
        T().getUpglideFactor().a(ECQuickUtilKt.a(u()), new e(this), false);
        T().getHeaderAreaStartScrollTag().a(ECQuickUtilKt.a(u()), new f(this), false);
    }

    public static final void s0(ECShopSliceProfilePresenter r100, com.bytedance.android.shopping.store.home.slice.d r101, com.bytedance.android.shopping.store.home.entity.d r102) {
        r100.getClass();
        r100.f184492x = r101.f184506b;
        Map<String, ECStoreHeaderInfoSliceConfig> r103 = r101.f184505a;
        if (r103 == null) goto L17;
        ECStoreHeaderInfoSliceConfig r104 = r103.get(SliceItemType.SHOP_PROFILE.getType());
        if (r104 == null) goto L17;
        Map<String, Object> r105 = r104.getSliceItemActions();
        Map<String, Object> r106 = null;
        if (r105 == null) goto L9;
        Map<String, Object> r107 = MapsKt.toMutableMap(r105);
    L10:
        r100.f184493y = r107;
        Map<String, Object> r108 = r104.getSliceItemExtra();
        if (r108 == null) goto L13;
        r106 = MapsKt.toMutableMap(r108);
    L13:
        r100.A = r106;
        Map<String, Object> r109 = r100.f184494z;
        Map<String, Object> r110 = r104.getSliceItemStates();
        if (r110 != null) goto L16;
        r110 = MapsKt.emptyMap();
    L16:
        r109.putAll(r110);
        goto L17
    L9:
        r107 = null;
    L17:
        int r111 = b0.f183607a;
        b0.a(r100.f184494z, b0.b(r102));
        dm.a.a("ECShopInfoTotalAreaSlicePresenter").a("updateFollowStateFromAccountInfo, sliceItemStates: " + r100.f184494z);
    }
}
