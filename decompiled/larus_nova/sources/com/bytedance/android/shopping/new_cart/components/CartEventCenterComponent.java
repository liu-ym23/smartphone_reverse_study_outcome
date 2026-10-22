package com.bytedance.android.shopping.new_cart.components;

import androidx.camera.video.AudioStats;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.android.shopping.new_cart.container.CartObjectContainer;
import com.bytedance.android.shopping.new_cart.eventcenter.event.CartSelfRecommendReset;
import com.bytedance.android.shopping.new_cart.eventcenter.event.OpenDiscountPanelFunction;
import com.bytedance.android.shopping.new_cart.eventcenter.event.SelfAnchorScroll;
import com.bytedance.android.shopping.new_cart.eventcenter.event.SelfCartCloseHybridPopupView;
import com.bytedance.android.shopping.new_cart.eventcenter.event.SelfOpenHalfHybridView;
import com.bytedance.android.shopping.new_cart.eventcenter.event.SelfSubscribeBridgeEvent;
import com.bytedance.android.shopping.new_cart.eventcenter.event.m;
import com.bytedance.android.shopping.new_cart.eventcenter.event.n;
import com.bytedance.android.shopping.new_cart.eventcenter.event.o;
import com.bytedance.android.shopping.new_cart.eventcenter.event.s;
import com.bytedance.android.shopping.new_cart.utils.CartSettingUtils;
import com.bytedance.android.shopping.new_cart.viewmodel.CartViewModel;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import com.bytedance.kmp.ec.yata.event.core.YataEventCenter;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class CartEventCenterComponent extends com.bytedance.android.shopping.new_cart.components.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CartViewModel f178698b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap<String, String> f178699c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.android.shopping.new_cart.components.e f178700d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f178701e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f178702f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final CartEventCenterComponent$applyMarketingCoupon$1 f178703g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final d f178704h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final CartEventCenterComponent$addCartSubscriber$1 f178705i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final c f178706j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final CartEventCenterComponent$deleteCartId$1 f178707k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final CartEventCenterComponent$deleteShops$1 f178708l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final b f178709m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final e f178710n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final CartObjectContainer f178711o;

    public static final class a {
    }

    public static final class b implements ti.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CartEventCenterComponent f178714a;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ AndroidYaTaInstance f178715a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f178716b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Map f178717c;

            public a(AndroidYaTaInstance r100, String r101, Map r102) {
                this.f178715a = r100;
                this.f178716b = r101;
                this.f178717c = r102;
            }

            @Override // java.lang.Runnable
            public final void run() {
                YataEventCenter r100 = this.f178715a.k();     // Catch: Throwable -> L8
                com.bytedance.kmp.ec.yata.event.common.e.a r101 = com.bytedance.kmp.ec.yata.event.common.e.f251660a;     // Catch: Throwable -> L8
                AndroidYaTaInstance r102 = this.f178715a;     // Catch: Throwable -> L8
                String r103 = this.f178716b;     // Catch: Throwable -> L8
                Map r104 = this.f178717c;     // Catch: Throwable -> L8
                if (r104 == null) goto L5;
                Map<String, ? extends Object> r105 = MapsKt.toMap(r104);     // Catch: Throwable -> L8
            L6:
                r100.d(r101.a(r102, null, r103, "cartChangeSku", r105, "cartChangeSkuSubscriber"));     // Catch: Throwable -> L8
                return;
            L5:
                r105 = null;
            L8:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L12;
                return;
            L12:
                throw th;
            }
        }

        public b(CartEventCenterComponent r100) {
            this.f178714a = r100;
        }

        @Override // ti.j
        public final void a(JSONObject r100) {
            Intrinsics.checkNotNullParameter(r100, "params");
            String r101 = r100.optString("uri", "");
            String r102 = r100.optString("skuInfo", "");
            boolean r103 = false;
            if (r101.length() != 0) goto L5;
            boolean r104 = true;
        L6:
            if (r104 == false) goto L8;
            return;
        L8:
            if (r102.length() != 0) goto L10;
            boolean r105 = true;
        L11:
            if (r105 == true) goto L32;
            JSONObject r106 = com.bytedance.android.ec.hybrid.list.util.k.c(r102);
            if (r106 != null) goto L16;
            return;
        L16:
            String r107 = this.f178714a.f178699c.get(r101);
            String r108 = r106.optString(com.bytedance.android.ec.core.event.a.KEY_SKU_ID, "");
            if (r107 == null) goto L30;
            if (r108 == null) goto L31;
            String r109 = r107;
            if (r108.length() != 0) goto L22;
            r103 = true;
        L22:
            if (r103 == false) goto L24;
            return;
        L24:
            Map<String, Object> r110 = com.bytedance.android.shopping.extensions.k.z(r100.optString("skuInfo"));
            if (r110 == null) goto L27;
            r110.put(com.bytedance.android.ec.core.event.a.KEY_COMBO_ID, r108);
        L27:
            AndroidYaTaInstance r111 = this.f178714a.f178711o.f178935e.f178983d.invoke();
            bg3.a r112 = com.bytedance.android.shopping.new_cart.utils.a.f179357a;
            com.bytedance.android.shopping.new_cart.utils.a.c(this.f178714a.f178698b, "cartChangeSkuSubscriber", new a(r111, r109, r110), null);
            return;
        L31:
            return;
        L30:
            return;
        L32:
            return;
        L10:
            r105 = false;
            goto L11
        L5:
            r104 = false;
            goto L6
        }
    }

    public static final class c implements ti.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CartEventCenterComponent f178718a;

        public c(CartEventCenterComponent r100) {
            this.f178718a = r100;
        }

        @Override // ti.j
        public final void a(JSONObject r100) {
            Intrinsics.checkNotNullParameter(r100, "params");
            double r101 = r100.optDouble("slot_top_to_viewport_top_distance", AudioStats.AUDIO_AMPLITUDE_NONE);
            float r102 = (float) r101;
            this.f178718a.f178711o.f178935e.f178980a = r102;
        }
    }

    public static final class d implements ti.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CartEventCenterComponent f178719a;

        public d(CartEventCenterComponent r100) {
            this.f178719a = r100;
        }

        @Override // ti.j
        public final void a(JSONObject r100) {
            Intrinsics.checkNotNullParameter(r100, "params");
            String r101 = null;
            String r102 = r100.optString("cart_ids", null);
            if (r102 != null) goto L5;
            return;
        L5:
            if (com.bytedance.android.shopping.extensions.k.c(r102) == false) goto L7;
            r101 = r102;
        L7:
            if (r101 == null) goto L11;
            this.f178719a.f178711o.f178935e.f178985f.add(r101);
            return;
        }
    }

    public static final class e implements ti.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CartEventCenterComponent f178722a;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ AndroidYaTaInstance f178723a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f178724b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ String f178725c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ Map f178726d;

            public a(AndroidYaTaInstance r100, String r101, String r102, Map r103) {
                this.f178723a = r100;
                this.f178724b = r101;
                this.f178725c = r102;
                this.f178726d = r103;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f178723a.k().d(com.bytedance.kmp.ec.yata.event.common.e.f251660a.a(this.f178723a, null, this.f178724b, this.f178725c, this.f178726d, "nextPageEventSubScribe"));     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public e(CartEventCenterComponent r100) {
            this.f178722a = r100;
        }

        @Override // ti.j
        public final void a(JSONObject r100) {
            Intrinsics.checkNotNullParameter(r100, "params");
            JSONObject r101 = r100.optJSONObject(SlcCommonAction.KEY_PARAMS);
            if (r101 == null) goto L5;
            Map<String, Object> r102 = z1.k(r101);
        L6:
            JSONObject r103 = z1.f(r100.optString("session_params"));
            if ((!Intrinsics.areEqual(r103.optString("session_id", "none"), this.f178722a.f178711o.f178935e.f178992m)) == false) goto L9;
            return;
        L9:
            String r104 = r100.optString("type", "");
            String r105 = r103.optString("node_id", "");
            String r106 = r100.optString("cart_id", "");
            if (com.bytedance.android.shopping.extensions.k.c(r106) == true) goto L13;
            r106 = null;
        L13:
            if (r106 == null) goto L15;
            this.f178722a.f178711o.f178935e.f178985f.add(r106);
        L15:
            AndroidYaTaInstance r107 = this.f178722a.f178711o.f178935e.f178983d.invoke();
            bg3.a r108 = com.bytedance.android.shopping.new_cart.utils.a.f179357a;
            com.bytedance.android.shopping.new_cart.utils.a.c(this.f178722a.f178698b, "nextPageEventSubScribe", new a(r107, r105, r104, r102), null);
            return;
        L5:
            r102 = null;
            goto L6
        }
    }

    static {
    }

    @Override // com.bytedance.android.shopping.new_cart.components.a
    public final void l() {
        this.f178701e = true;
    }

    @Override // com.bytedance.android.shopping.new_cart.components.a
    public final void m() {
        this.f178701e = false;
    }

    @Override // com.bytedance.android.shopping.new_cart.components.a
    public final void h() {
        ECLiveHybridUtil.m("edit_select_cart_ids", this.f178704h);
        ECLiveHybridUtil.m("cartListRefresh", this.f178703g);
        Lazy r100 = CartSettingUtils.f179349a;
        Function0<Unit> r101 = new CartEventCenterComponent$registerJsEvents$1(this);
        Intrinsics.checkNotNullParameter(r101, "action");
        r101.invoke();
        ECLiveHybridUtil.m("cart_change_sku", this.f178709m);
        ECLiveHybridUtil.m("next_page_event", this.f178710n);
        this.f178711o.f178935e.f178994o.put("edit_select_cart_ids", this.f178704h);
        this.f178711o.f178935e.f178994o.put("cartListRefresh", this.f178703g);
        this.f178711o.f178935e.f178994o.put("ecom.sku.add.cart", this.f178705i);
        this.f178711o.f178935e.f178994o.put("cart_change_sku", this.f178709m);
        this.f178711o.f178935e.f178994o.put("next_page_event", this.f178710n);
        c r102 = this.f178706j;
        ECLiveHybridUtil.m("coudan_slot_info", r102);
        this.f178711o.f178935e.f178994o.put("coudan_slot_info", r102);
        CartEventCenterComponent$deleteCartId$1 r103 = this.f178707k;
        ECLiveHybridUtil.m("edit_unselect_cart_ids", r103);
        this.f178711o.f178935e.f178994o.put("edit_unselect_cart_ids", r103);
        CartEventCenterComponent$deleteShops$1 r104 = this.f178708l;
        ECLiveHybridUtil.m("edit_unselect_shop_ids", r104);
        this.f178711o.f178935e.f178994o.put("edit_unselect_shop_ids", r104);
        AndroidYaTaInstance r105 = this.f178711o.f178935e.f178983d.invoke();
        r105.B("selfRecommendShowProduct", new com.bytedance.android.shopping.new_cart.eventcenter.event.invalidrecommend.e(this.f178698b));
        r105.B("selfRecommendFindMore", new com.bytedance.android.shopping.new_cart.eventcenter.event.invalidrecommend.b(this.f178711o));
        r105.B("selfRecommendAddToCart", new com.bytedance.android.shopping.new_cart.eventcenter.event.invalidrecommend.a(this.f178711o));
        r105.B("selfRecommendProductCardClick", new com.bytedance.android.shopping.new_cart.eventcenter.event.invalidrecommend.d(this.f178711o));
        r105.B("selfQuitCart", new m(this.f178711o));
        r105.B("selfCartRefresh", new com.bytedance.android.shopping.new_cart.eventcenter.event.c(this.f178698b));
        r105.B("selfCartModifyNetworkParam", new com.bytedance.android.shopping.new_cart.eventcenter.event.l(this.f178698b));
        r105.B("selfOpenSkuPanel", new com.bytedance.android.shopping.new_cart.eventcenter.event.k(this.f178700d, this.f178711o));
        r105.B("selfScrollToTop", new com.bytedance.android.shopping.new_cart.eventcenter.event.f(this.f178698b, this.f178711o));
        r105.B("selfOpenCrossShopDiscount", new com.bytedance.android.shopping.new_cart.eventcenter.event.j(this.f178711o));
        r105.B("selfOpenDiscountPanel", new OpenDiscountPanelFunction(this.f178711o));
        r105.B("selfChangeCounterActive", new com.bytedance.android.shopping.new_cart.eventcenter.event.b(this.f178698b, r105));
        r105.A("selfShopSelectedWhenSelectCart", new xf3.a());
        r105.B("selfGetStorage", new ib3.c());
        r105.B("selfDeleteSearchWord", new ib3.a());
        r105.B("selfSetStorage", new ib3.d());
        r105.A("selfSaveSearchWord", new ib3.b());
        r105.B("selfAppendParamsToSchema", new n(this.f178711o));
        r105.B("selfOpenHybridPopupView", new SelfOpenHalfHybridView(this.f178711o));
        r105.B("selfCartCloseHybridPopupView", new SelfCartCloseHybridPopupView(this.f178711o));
        r105.B("selfPublishEvent", new com.bytedance.android.shopping.new_cart.eventcenter.event.g(this.f178698b));
        r105.B("selfRecommendReset", new CartSelfRecommendReset(this.f178711o));
        r105.B("selfSubscribeBridgeEvent", new SelfSubscribeBridgeEvent(this.f178711o));
        r105.B("selfUnsubscribeBridgeEvent", new s(this.f178711o));
        r105.B("selfAnchorScroll", new SelfAnchorScroll(this.f178711o));
        r105.B("cartHeaderTabChange", new o());
    }

    @Override // com.bytedance.android.shopping.new_cart.components.a
    public final void i() {
        ECLiveHybridUtil.p("edit_select_cart_ids", this.f178704h);
        ECLiveHybridUtil.p("cartListRefresh", this.f178703g);
        Lazy r100 = CartSettingUtils.f179349a;
        Function0<Unit> r101 = new CartEventCenterComponent$unregisterJsEvents$1(this);
        Intrinsics.checkNotNullParameter(r101, "action");
        r101.invoke();
        ECLiveHybridUtil.p("cart_change_sku", this.f178709m);
        ECLiveHybridUtil.p("next_page_event", this.f178710n);
        Iterator<Map.Entry<String, ti.j>> r102 = this.f178711o.f178935e.f178994o.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        Map.Entry<String, ti.j> r103 = r102.next();
        ECLiveHybridUtil.p(r103.getKey(), r103.getValue());
        goto L4
    L6:
        this.f178711o.f178935e.f178994o.clear();
    }

    public CartEventCenterComponent(CartObjectContainer r100) {
        Intrinsics.checkNotNullParameter(r100, "objectContainer");
        super(r100);
        this.f178711o = r100;
        this.f178698b = this.f178820a.f178934d;
        this.f178699c = new ConcurrentHashMap();
        this.f178700d = new com.bytedance.android.shopping.new_cart.components.e(new CartEventCenterComponent$actions$1(this));
        this.f178702f = LazyKt.lazy(new CartEventCenterComponent$bodyComponent$2(this));
        this.f178703g = new CartEventCenterComponent$applyMarketingCoupon$1(this);
        this.f178704h = new d(this);
        this.f178705i = new CartEventCenterComponent$addCartSubscriber$1(this);
        this.f178706j = new c(this);
        this.f178707k = new CartEventCenterComponent$deleteCartId$1(this);
        this.f178708l = new CartEventCenterComponent$deleteShops$1(this);
        this.f178709m = new b(this);
        this.f178710n = new e(this);
    }

    public static final void n(CartEventCenterComponent r100, JSONObject r101, Function0 r102) {
        r100.getClass();
        if ((!Intrinsics.areEqual(z1.f(r101.optString("session_params")).optString("session_id", "none"), r100.f178711o.f178935e.f178992m)) == true) goto L7;
        r102.invoke();
        return;
    }
}
