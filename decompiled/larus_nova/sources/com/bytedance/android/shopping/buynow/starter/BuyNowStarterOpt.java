package com.bytedance.android.shopping.buynow.starter;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.common.impl.order.OrderSchema;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.buynow.BuyNowBizCode;
import com.bytedance.android.ec.core.buynow.BuyNowPerformanceOpt;
import com.bytedance.android.ec.core.monitor.MonitorScenes;
import com.bytedance.android.ec.core.monitor.param.ECParamTracker;
import com.bytedance.android.ec.core.monitor.param.ECParamTrackerCenter;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.hybrid.ECHybridExtensionsKt;
import com.bytedance.android.ec.model.order.IOrderSchema;
import com.bytedance.android.ec.model.promotion.ECFindSimilarConfig;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.shopping.api.ultimate.UltimateBuyStyleParams;
import com.bytedance.android.shopping.base.event.EventActionImpl;
import com.bytedance.android.shopping.buynow.cache.UltimateBuyCacheHelper;
import com.bytedance.android.shopping.buynow.cache.UltimateBuyCacheQueryHelper;
import com.bytedance.android.shopping.buynow.container.BuyNowFullscreenActivity;
import com.bytedance.android.shopping.buynow.container.BuyNowHalfScreenDialogFragment;
import com.bytedance.android.shopping.buynow.container.BuyNowSplitScreenFragment;
import com.bytedance.android.shopping.buynow.controller.s;
import com.bytedance.android.shopping.buynow.data.model.BuyNowOrderSchema;
import com.bytedance.android.shopping.buynow.data.model.PageType;
import com.bytedance.android.shopping.buynow.monitor.firstscreen.BuyNowFirstScreenMonitor;
import com.bytedance.android.shopping.buynow.monitor.param.BuyNowFirstScreenNode;
import com.bytedance.android.shopping.buynow.slice.BuyNowTemplateMgr;
import com.bytedance.android.shopping.buynow.tracker.BuyNowLog;
import com.bytedance.android.shopping.sku.common.utils.SkuBuyNowPanelHeightHelper;
import com.bytedance.kmp.ec.yata.common.biz.YataPageInfo;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.bytedance.pia.core.metrics.ErrorType;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.search.vision.model.data.PhotoEnterModel;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import ma3.q;
import ma3.r;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class BuyNowStarterOpt implements n, c53.d {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ int f171113q = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f171114a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final YataPageInfo f171115b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public s f171116c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final pa3.a f171117d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, ? extends Object> f171118e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public d f171119f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Function1<? super d, Unit> f171120g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f171121h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Function0<Unit> f171122i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f171123j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final IOrderSchema f171124k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final sc3.b f171125l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final la3.e f171126m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f171127n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f171128o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final /* synthetic */ c53.b f171129p;

    public static final class a {
        public a() {
        }

        public static BuyNowStarterOpt a(IOrderSchema r100, com.bytedance.android.shopping.buynow.monitor.firstscreen.a r101, String r102, String r110, boolean r111, int r112) {
            int r103 = BuyNowStarterOpt.f171113q;
            if ((r112 & 4) == 0) goto L6;
            r102 = null;
        L6:
            if ((r112 & 32) == 0) goto L8;
            boolean r104 = false;
        L9:
            Intrinsics.checkNotNullParameter(r100, "orderSchema");
            if (r102 != null) goto L13;
            r102 = UUID.randomUUID().toString();
        L13:
            return new BuyNowStarterOpt(r102, r100, r101, null, r110, r104);
        L8:
            r104 = r111;
            goto L9
        }
    }

    static {
        new a();
    }

    @Override // c53.d
    public final Disposable add(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "disposable");
        this.f171129p.add(r100);
        return r100;
    }

    @Override // c53.d
    public final void doClear() {
        this.f171129p.doClear();
    }

    @Override // c53.d
    public final void remove(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "disposable");
        this.f171129p.remove(r100);
    }

    @Override // com.bytedance.android.shopping.buynow.starter.n
    public final boolean f() {
        return Intrinsics.areEqual(this.f171124k.getHost(), "continue_pay");
    }

    public final UltimateBuyStyleParams l() {
        int r100 = com.bytedance.android.shopping.extensions.k.r(this.f171124k.getQueryParam(ECFindSimilarConfig.HEIGHT_PERCENT), 0);
        String r101 = this.f171124k.getQueryParam("scene_type");
        Float r102 = Float.valueOf(com.bytedance.android.shopping.extensions.k.p(this.f171124k.getQueryParam("mask_alpha"), 0.5f));
        Lazy r103 = SkuBuyNowPanelHeightHelper.f182769a;
        return new UltimateBuyStyleParams(SkuBuyNowPanelHeightHelper.a(r101, Integer.valueOf(r100)), r102);
    }

    public final BuyNowBizCode n() {
        if (this.f171124k.C() == false) goto L6;
        return BuyNowBizCode.YATA_SKUBUY;
    L6:
        if (f() == false) goto L9;
        return BuyNowBizCode.CONTINUE_PAY;
    L9:
        return BuyNowBizCode.BUY;
    }

    public final void q() {
        pa3.a r100 = this.f171117d;
        if (r100 == null) goto L10;
        BuyNowFirstScreenMonitor r101 = r100.f528357a;
        if (r101 == null) goto L10;
        Intrinsics.checkNotNullParameter(MonitorScenes.EC_PERF_PAGE_START_BUY_NOW, "scene");
        if (r101.f171003f == true) goto L10;
        r101.f171003f = true;
    L10:
        pa3.a r102 = this.f171117d;
        if (r102 == null) goto L16;
        BuyNowFirstScreenMonitor r103 = r102.f528357a;
        if (r103 == null) goto L17;
        r103.a(BuyNowFirstScreenNode.INITIAL, System.currentTimeMillis());
        return;
    L17:
        return;
    }

    public final void r() {
        Map<String, ECParamTracker> r100 = ECParamTrackerCenter.f45189a;
        if (this.f171124k.C() == false) goto L5;
        String r101 = "UltimateBuy";
    L6:
        ECParamTrackerCenter.d(r101, this.f171123j);
        String r102 = this.f171123j;
        IOrderSchema r103 = this.f171124k;
        r103.B();
        com.bytedance.android.shopping.buynow.utils.a.a(r102, r103);
        EventActionImpl r104 = new EventActionImpl();
        LinkedHashMap r105 = new LinkedHashMap();
        IOrderSchema r106 = this.f171124k;
        if (r106 == null) goto L11;
        Map<String, String> r107 = r106.b();
        if (r107 == null) goto L11;
        r105.putAll(r107);
    L11:
        r105.put("buynow_session_id", this.f171123j);
        int r108 = com.bytedance.android.ec.core.buynow.d.f43913a;
        com.bytedance.android.ec.core.buynow.d.b(this.f171124k);
        Object r109 = null;
        r105.put("EVENT_PAGE_TECHNOLOGY", null);
        IOrderSchema r110 = this.f171124k;
        if (r110 == null) goto L18;
        String r111 = r110.getQueryParam("eztf_sdk_extra");
        if (r111 == null) goto L18;
        JSONObject r112 = z1.g(r111);
        if (r112 == null) goto L18;
        r109 = r112.get("source_page");
    L18:
        r105.put("eztf_source_page", r109);
        r104.doEventAction("enter_buynow_page", r105);
        if (this.f171124k.C() == false) goto L22;
        new EventActionImpl().doEventAction("enter_submit_orders", MapsKt.mapOf(new Pair[]{TuplesKt.to("page_scene", "1"), TuplesKt.to("scene_type", this.f171124k.getQueryParam("scene_type"))}));
        return;
    L22:
        return;
    L5:
        r101 = "BuyNow";
        goto L6
    }

    @Override // com.bytedance.android.shopping.buynow.starter.n
    public final void release() {
        Lazy r100 = BuyNowLog.f171168a;
        BuyNowLog.a("BuyNowStarter", "BuyNowStarter release " + this.f171123j);
        doClear();
        Map<String, UltimateBuyCacheQueryHelper> r101 = UltimateBuyCacheHelper.f170708b;
        String r102 = this.f171123j;
        Intrinsics.checkNotNullParameter(r102, "sessionId");
        Map<String, UltimateBuyCacheQueryHelper> r103 = UltimateBuyCacheHelper.f170708b;
        UltimateBuyCacheQueryHelper r104 = (UltimateBuyCacheQueryHelper) ((LinkedHashMap) r103).get(r102);
        if (r104 == null) goto L7;
        Disposable r105 = r104.f170711c;
        if (r105 == null) goto L7;
        r105.dispose();
    L7:
        r103.remove(r102);
    }

    @Override // com.bytedance.android.shopping.buynow.starter.n
    public final nl.c a() {
        return this.f171124k;
    }

    @Override // com.bytedance.android.shopping.buynow.starter.n
    public final s b() {
        return this.f171116c;
    }

    @Override // com.bytedance.android.shopping.buynow.starter.n
    public final boolean g() {
        return this.f171121h;
    }

    @Override // com.bytedance.android.shopping.buynow.starter.n
    public final YataPageInfo getPageInfo() {
        return this.f171115b;
    }

    @Override // com.bytedance.android.shopping.buynow.starter.n
    public final String getSourceBtmToken() {
        return this.f171127n;
    }

    @Override // com.bytedance.android.shopping.buynow.starter.n
    public final d h() {
        return this.f171119f;
    }

    @Override // com.bytedance.android.shopping.buynow.starter.n
    public final Map<String, Object> j() {
        return this.f171118e;
    }

    @Override // com.bytedance.android.shopping.buynow.starter.n
    public final void d(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "btmNode");
        c r101 = this.f171114a;
        r101.f171138c = new WeakReference(r100);
    }

    @Override // com.bytedance.android.shopping.buynow.starter.n
    public final void e(Function1<? super d, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f171120g = r100;
    }

    @Override // c53.d
    public final Disposable ignore(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "disposable");
        this.f171129p.getClass();
        Intrinsics.checkNotNullParameter(r100, "disposable");
        return r100;
    }

    @Override // com.bytedance.android.shopping.buynow.starter.n
    public final void k(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f171122i = r100;
    }

    public final void m(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f171124k.replaceOrAppendParam("check_parallel_type", ErrorType.PREFETCH);
        if (this.f171124k.C() == true) goto L5;
        return;
    L5:
        c r101 = this.f171114a;
        h43.a.a(r100);
        r101.f171139d = false;
        c r102 = this.f171114a;
        com.bytedance.android.shopping.buynow.cache.a r103 = null;
        if ((r100 instanceof FragmentActivity) == true) goto L8;
        Context r104 = null;
    L9:
        FragmentActivity r105 = (FragmentActivity) r104;
        nj.d r106 = h43.a.b();
        if (r106 == null) goto L12;
        r106.g();
    L12:
        r102.f171140e = false;
        int r107 = ECSdk.f48106a;
        cj.b r108 = (cj.b) ECSdk.a(cj.b.class);
        if (r108 == null) goto L15;
        r108.e(r100);
    L15:
        OrderSchema.b r109 = this.f171124k.P0();
        if (r109 != null) goto L19;
        r109 = this.f171124k.P();
    L19:
        if (this.f171116c != null) goto L21;
        this.f171116c = new s();
    L21:
        s r110 = this.f171116c;
        if (r110 != null) goto L24;
    L30:
        int r111 = o43.b.f521962a;
        if (r109 == null) goto L33;
        JSONObject r112 = r109.e();
    L34:
        Intrinsics.checkNotNullParameter(PageType.BUYNOW, "pageType");
        this.f171124k.T(r112);
        if (this.f171128o == false) goto L68;
        this.f171124k.replaceOrAppendParam("check_parallel_type", "diff");
        na3.g r113 = na3.g.f518461a;
        e r114 = new e(this.f171124k, this.f171114a, true);
        Intrinsics.checkNotNullParameter(r114, "requestBuilder");
        int r115 = com.bytedance.android.shopping.buynow.opt.d.f171032a;
        com.bytedance.android.shopping.buynow.cache.a r116 = com.bytedance.android.shopping.buynow.opt.d.a(r114.f171151c);
        Map<String, UltimateBuyCacheQueryHelper> r117 = UltimateBuyCacheHelper.f170708b;
        IOrderSchema r118 = r114.f171151c;
        c r119 = r114.f171152d;
        if (r119 == null) goto L39;
        String r120 = r119.f171136a;
    L40:
        if (r120 != null) goto L42;
        r120 = "";
    L42:
        UltimateBuyCacheQueryHelper r121 = UltimateBuyCacheHelper.d(r118, r120);
        if (UltimateBuyCacheHelper.c(r116) == null) goto L45;
        r114.f171151c.replaceOrAppendParam("has_used_client_cache", "true");
    L45:
        ma3.f r122 = r114.a(false);
        ma3.m r123 = r114.f171149a;
        if ((r123 instanceof r) == true) goto L48;
        r123 = null;
    L48:
        r r124 = (r) r123;
        if (r124 == null) goto L59;
        if (r121 == null) goto L59;
        if ((r116 instanceof com.bytedance.android.shopping.buynow.cache.a) == false) goto L55;
        r103 = r116;
    L55:
        Object r125 = r114.f171150b;
        if (r125 != null) goto L58;
        r125 = new LinkedHashMap();
    L58:
        Pair<r, ? extends Map<String, String>> r126 = new Pair(r124, r125);
        Intrinsics.checkNotNullParameter(r126, "ultimateBuyRequestPair");
        r121.f170710b = r103;
        r121.f170709a = r126;
    L59:
        Observable r127 = na3.g.c(r122, r114.f());
        if (r127 == null) goto L70;
        Observable r128 = r127.subscribeOn(Schedulers.newThread());
        if (r128 == null) goto L71;
        Observable r129 = r128.observeOn(Schedulers.io());
        if (r129 == null) goto L72;
        Disposable r130 = r129.subscribe(na3.a.f518446a, na3.b.f518447a);
        if (r130 == null) goto L73;
        Intrinsics.checkNotNullParameter(r130, "$this$globalScope");
        return;
    L73:
        return;
    L72:
        return;
    L71:
        return;
    L70:
        return;
    L39:
        r120 = null;
        goto L40
    L68:
        int r131 = k.f171164a;
        k.b(this.f171123j, this, true);
        i(r100, true);
        return;
    L33:
        r112 = null;
        goto L34
    L24:
        if (r109 == null) goto L26;
        String r132 = r109.getString(com.bytedance.android.ec.core.event.a.KEY_RECOMMEND_INFO);
    L27:
        r110.f170869b = r132;
        if (r109 == null) goto L30;
        r109.delete(new String[]{com.bytedance.android.ec.core.event.a.KEY_RECOMMEND_INFO});
        goto L30
    L26:
        r132 = null;
        goto L27
    L8:
        r104 = r100;
        goto L9
    }

    public final void o(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r101 = k.f171164a;
        k.b(this.f171123j, this, false);
        if (BuyNowPerformanceOpt.f() == false) goto L5;
        return;
    L5:
        com.bytedance.android.ec.sdk.helper.d r102 = com.bytedance.android.ec.sdk.helper.d.f48119b;
        nj.d r103 = r102.getPadSplitService();
        c r104 = this.f171114a;
        if (r103 == null) goto L8;
        r103.l();
    L8:
        r104.f171139d = false;
        c r105 = this.f171114a;
        nj.d r106 = r102.getPadSplitService();
        JSONObject r107 = null;
        if (r106 != null) goto L11;
    L15:
        r105.f171140e = false;
        int r108 = ECSdk.f48106a;
        cj.b r109 = (cj.b) ECSdk.a(cj.b.class);
        if (r109 == null) goto L18;
        r109.e(r100);
    L18:
        q();
        pa3.a r110 = this.f171117d;
        if (r110 == null) goto L23;
        BuyNowFirstScreenMonitor r111 = r110.f528357a;
        if (r111 == null) goto L23;
        r111.a(BuyNowFirstScreenNode.PRELOAD_TEMPLATE_START, System.currentTimeMillis());
    L23:
        pa3.a r112 = this.f171117d;
        if (r112 == null) goto L28;
        BuyNowFirstScreenMonitor r113 = r112.f528357a;
        if (r113 == null) goto L28;
        r113.a(BuyNowFirstScreenNode.PRELOAD_TEMPLATE_END, System.currentTimeMillis());
    L28:
        OrderSchema.b r114 = this.f171124k.P0();
        if (r114 != null) goto L32;
        r114 = this.f171124k.P();
    L32:
        if (BuyNowPerformanceOpt.b() == true) goto L34;
    L47:
        int r115 = o43.b.f521962a;
        if (r114 == null) goto L50;
        r107 = r114.e();
    L50:
        Intrinsics.checkNotNullParameter(PageType.BUYNOW, "pageType");
        this.f171124k.T(r107);
        i(r100, true);
        int r116 = BuyNowTemplateMgr.f171040a;
        BuyNowTemplateMgr.a(r100, n(), true);
        if (ja3.a.c(this.f171124k) == false) goto L53;
        com.bytedance.android.shopping.buynow.opt.a.a(r100);
    L53:
        p(r100, this.f171124k);
        r();
        return;
    L34:
        if (this.f171124k.C() == false) goto L47;
        if (this.f171116c != null) goto L38;
        this.f171116c = new s();
    L38:
        s r117 = this.f171116c;
        if (r117 == null) goto L47;
        if (r114 == null) goto L43;
        String r118 = r114.getString(com.bytedance.android.ec.core.event.a.KEY_RECOMMEND_INFO);
    L44:
        r117.f170869b = r118;
        if (r114 == null) goto L47;
        r114.delete(new String[]{com.bytedance.android.ec.core.event.a.KEY_RECOMMEND_INFO});
        goto L47
    L43:
        r118 = null;
        goto L44
    L11:
        if ((r100 instanceof FragmentActivity) == true) goto L13;
        Context r119 = null;
    L14:
        FragmentActivity r120 = (FragmentActivity) r119;
        r106.g();
        goto L15
    L13:
        r119 = r100;
        goto L14
    }

    @Override // com.bytedance.android.shopping.buynow.starter.n
    public final void c(Context r100, com.bytedance.android.shopping.sku.common.data.e r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "nextData");
        if (this.f171124k.C() == false) goto L8;
        boolean r102 = Intrinsics.areEqual(String.valueOf(this.f171124k.getQueryParam("enter_from_live_saas")), "1");
        int r103 = ja3.a.a(this.f171124k);
        Map<String, UltimateBuyCacheQueryHelper> r104 = UltimateBuyCacheHelper.f170708b;
        UltimateBuyCacheQueryHelper r105 = UltimateBuyCacheHelper.d(this.f171124k, this.f171123j);
        if (r105 == null) goto L9;
        r105.query(r102, r101, r103, new BuyNowStarterOpt$reFetchQueryByCacheOperation$1(this));
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.shopping.buynow.starter.n
    public final void i(Context r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        pa3.a r112 = this.f171117d;
        if (r112 == null) goto L7;
        BuyNowFirstScreenMonitor r113 = r112.f528357a;
        if (r113 == null) goto L7;
        r113.a(BuyNowFirstScreenNode.REQUEST_START, System.currentTimeMillis());
    L7:
        e r114 = new e(this.f171124k, this.f171114a, r111);
        na3.g r100 = na3.g.f518461a;
        pa3.a r101 = this.f171117d;
        Intrinsics.checkNotNullParameter(r114, "requestBuilder");
        if (r101 == null) goto L12;
        BuyNowFirstScreenMonitor r102 = r101.f528357a;
        if (r102 == null) goto L12;
        r102.a(BuyNowFirstScreenNode.QUERY_PARAM_START, System.currentTimeMillis());
    L12:
        int r103 = com.bytedance.android.shopping.buynow.opt.d.f171032a;
        com.bytedance.android.shopping.buynow.cache.a r104 = com.bytedance.android.shopping.buynow.opt.d.a(r114.f171151c);
        dm.a.a("BuyNowPrefetcher").a("queryBuyNow cache key " + r104);
        Map<String, UltimateBuyCacheQueryHelper> r105 = UltimateBuyCacheHelper.f170708b;
        IOrderSchema r106 = r114.f171151c;
        c r107 = r114.f171152d;
        com.bytedance.android.shopping.buynow.cache.a r108 = null;
        if (r107 == null) goto L15;
        String r109 = r107.f171136a;
    L16:
        if (r109 != null) goto L18;
        r109 = "";
    L18:
        UltimateBuyCacheQueryHelper r115 = UltimateBuyCacheHelper.d(r106, r109);
        q r116 = UltimateBuyCacheHelper.c(r104);
        if (r116 == null) goto L21;
        r114.f171151c.replaceOrAppendParam("has_used_client_cache", "true");
    L21:
        ma3.f r117 = r114.a(false);
        ma3.m r118 = r114.f171149a;
        if ((r118 instanceof r) == true) goto L24;
        r118 = null;
    L24:
        r r119 = (r) r118;
        if (r119 == null) goto L35;
        if (r115 == null) goto L35;
        if ((r104 instanceof com.bytedance.android.shopping.buynow.cache.a) == false) goto L31;
        r108 = r104;
    L31:
        Object r120 = r114.f171150b;
        if (r120 != null) goto L34;
        r120 = new LinkedHashMap();
    L34:
        Pair<r, ? extends Map<String, String>> r121 = new Pair(r119, r120);
        Intrinsics.checkNotNullParameter(r121, "ultimateBuyRequestPair");
        r115.f170710b = r108;
        r115.f170709a = r121;
    L35:
        if (r101 == null) goto L39;
        BuyNowFirstScreenMonitor r122 = r101.f528357a;
        if (r122 == null) goto L39;
        r122.a(BuyNowFirstScreenNode.QUERY_PARAM_END, System.currentTimeMillis());
    L39:
        if (r101 == null) goto L43;
        BuyNowFirstScreenMonitor r123 = r101.f528357a;
        if (r123 == null) goto L43;
        BuyNowFirstScreenMonitor.b(r123, BuyNowFirstScreenNode.FETCH_START);
    L43:
        if (r101 == null) goto L47;
        BuyNowFirstScreenMonitor r124 = r101.f528357a;
        if (r124 == null) goto L47;
        r124.a(BuyNowFirstScreenNode.NATIVE_NET_START, System.currentTimeMillis());
    L47:
        Observable.merge(Observable.create(new na3.f(r117, r114, null, r104, r115, r101)), Observable.defer(new na3.e(r116, r115, r114))).observeOn(AndroidSchedulers.mainThread()).subscribe(new l(this, r111));
        return;
    L15:
        r109 = null;
        goto L16
    }

    public final void p(Context r110, IOrderSchema r111) {
        BuyNowLog.a("BuyNowStarter", "presentNativeBuyNow");
        int r100 = ECSdk.f48106a;
        IAdapterService r101 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r101 == null) goto L7;
        com.bytedance.android.ec.adapter.api.j r102 = r101.getLiveWindowService();
        if (r102 == null) goto L7;
        r102.stopShowFloatInNextLifecycle();
    L7:
        pa3.a r103 = this.f171117d;
        if (r103 == null) goto L12;
        BuyNowFirstScreenMonitor r104 = r103.f528357a;
        if (r104 == null) goto L12;
        r104.a(BuyNowFirstScreenNode.CONTAINER_INIT_START, System.currentTimeMillis());
    L12:
        String r105 = null;
        if (this.f171124k.C() == false) goto L25;
        if (this.f171114a.f171139d == false) goto L23;
        int r106 = BuyNowSplitScreenFragment.f170771f;
        String r107 = this.f171123j;
        UltimateBuyStyleParams r108 = l();
        la3.e r109 = this.f171126m;
        String r112 = this.f171127n;
        BuyNowOrderSchema r113 = la3.a.a(this.f171124k);
        int r114 = com.bytedance.android.shopping.extensions.k.r(this.f171124k.getQueryParam("ultimate_buy_ab"), 0);
        Intrinsics.checkNotNullParameter(r107, "sessionId");
        BuyNowSplitScreenFragment r115 = new BuyNowSplitScreenFragment();
        Bundle r116 = new Bundle();
        r116.putString("PrefetchSessionId", r107);
        r116.putString(PhotoEnterModel.SOURCE_BTM_TOKEN, r112);
        r116.putFloat("HeightPercent", r108.getHeightPercent() / 100.0f);
        Float r117 = r108.getMaskAlpha();
        if (r117 == null) goto L19;
        float r118 = r117.floatValue();
    L20:
        r116.putFloat("MaskAlpha", r118);
        r116.putSerializable("ultimate_buy_params", null);
        r116.putParcelable("Schema", null);
        r116.putParcelable("OrderSchema", r113);
        r116.putInt("ultimate_buy_ab", r114);
        r116.putString("SplitScreenType", "sku_buy");
        Unit r119 = Unit.INSTANCE;
        r115.setArguments(r116);
        r115.f170773e = r109;
        nj.d r120 = com.bytedance.android.ec.sdk.helper.d.f48119b.getPadSplitService();
        if (r120 == null) goto L50;
        ECHybridExtensionsKt.a(r110);
        r120.k();
        return;
    L50:
        return;
    L19:
        r118 = 0.5f;
        goto L20
    L23:
        int r121 = BuyNowHalfScreenDialogFragment.f170765f;
        BuyNowHalfScreenDialogFragment.a.c(r110, null, this.f171123j, l(), this.f171126m, this.f171127n, null, la3.a.a(this.f171124k), com.bytedance.android.shopping.extensions.k.r(this.f171124k.getQueryParam("ultimate_buy_ab"), 0), 2);
        return;
    L25:
        if (ja3.a.c(r111) == false) goto L44;
        if (this.f171114a.f171139d == true) goto L44;
        int r122 = BuyNowHalfScreenDialogFragment.f170765f;
        String r123 = this.f171123j;
        if (r111 == null) goto L33;
        String r124 = r111.getQueryParam("mask_alpha");
        if (r124 == null) goto L33;
        Float r125 = Float.valueOf(CastFloatProtector.parseFloat(r124));
    L34:
        BuyNowOrderSchema r126 = la3.a.a(this.f171124k);
        if (r111 == null) goto L37;
        String r127 = r111.getQueryParam(ECFindSimilarConfig.HEIGHT_PERCENT);
    L39:
        if ((r127 instanceof String) == false) goto L42;
        r105 = r127;
    L42:
        BuyNowHalfScreenDialogFragment.a.b(r110, r123, null, r125, r126, com.bytedance.android.shopping.extensions.k.p(r105, 73.0f) / 100.0f, this.f171127n);
        return;
    L37:
        r127 = null;
    L33:
        r125 = null;
    L44:
        if (this.f171114a.f171139d == false) goto L48;
        int r128 = BuyNowSplitScreenFragment.f170771f;
        BuyNowSplitScreenFragment.a.a(this.f171123j, null, la3.a.a(this.f171124k), this.f171127n);
        nj.d r129 = com.bytedance.android.ec.sdk.helper.d.f48119b.getPadSplitService();
        if (r129 == null) goto L54;
        ECHybridExtensionsKt.a(r110);
        r129.k();
        return;
    L54:
        return;
    L48:
        int r130 = BuyNowFullscreenActivity.f170763k;
        BuyNowFullscreenActivity.a.a(r110, this.f171123j, null, la3.a.a(this.f171124k), this.f171127n);
    }

    public BuyNowStarterOpt(String r100, IOrderSchema r101, com.bytedance.android.shopping.buynow.monitor.firstscreen.a r102, la3.e r103, String r104, boolean r110) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        Intrinsics.checkNotNullParameter(r101, "orderSchema");
        this.f171129p = new c53.b();
        this.f171123j = r100;
        this.f171124k = r101;
        this.f171125l = r102;
        this.f171126m = r103;
        this.f171127n = r104;
        this.f171128o = r110;
        boolean r105 = ECSettingKeys.d();
        if (r101.C() == false) goto L9;
        Map r106 = BuyNowPerformanceOpt.g();
        if (r106 == null) goto L7;
        Object r107 = r106.get("ec_sku_buy_disable_compress");
    L8:
        boolean r108 = Intrinsics.areEqual(r107, 1);
    L10:
        c r109 = new c(r100, new YataPageInfo(r105, r108, r100));
        this.f171114a = r109;
        this.f171115b = r109.f171137b;
        r101.replaceOrAppendParam("use_new_self_event", String.valueOf(ECSettingKeys.k()));
        long r111 = System.currentTimeMillis();
        int r112 = com.bytedance.android.shopping.buynow.tracker.a.f171170i;
        this.f171118e = com.bytedance.android.shopping.buynow.tracker.a.C2568a.a(r100, r101.C(), f(), r101, null);
        BuyNowPerformanceOpt.l();
        if (r101.C() == false) goto L13;
        s r113 = new s();
        this.f171116c = r113;
        r113.a(r101);
    L13:
        long r114 = System.currentTimeMillis();
        if (r110 == true) goto L16;
        this.f171117d = pa3.a.f528356d.b(r100, n().getValue(), r101, r102);
    L16:
        pa3.a r115 = this.f171117d;
        if (r115 == null) goto L21;
        BuyNowFirstScreenMonitor r116 = r115.f528357a;
        if (r116 == null) goto L21;
        r116.a(BuyNowFirstScreenNode.PARSE_SCHEMA_START, r111);
    L21:
        pa3.a r117 = this.f171117d;
        if (r117 == null) goto L27;
        BuyNowFirstScreenMonitor r118 = r117.f528357a;
        if (r118 == null) goto L28;
        r118.a(BuyNowFirstScreenNode.PARSE_SCHEMA_END, r114);
        return;
    L28:
        return;
    L27:
        return;
    L7:
        r107 = null;
        goto L8
    L9:
        r108 = false;
        goto L10
    }
}
