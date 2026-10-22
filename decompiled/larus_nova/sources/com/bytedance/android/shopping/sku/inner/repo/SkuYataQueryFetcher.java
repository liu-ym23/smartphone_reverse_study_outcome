package com.bytedance.android.shopping.sku.inner.repo;

import android.content.res.Resources;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.standard.home.BaseStandardHomeFragment;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.buynow.BuyNowPerformanceOpt;
import com.bytedance.android.ec.core.monitor.ECProcessMonitor;
import com.bytedance.android.ec.core.opt.ab.p;
import com.bytedance.android.ec.core.sku.SkuPerformanceOpt;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.utils.g0;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.hybrid.list.util.k;
import com.bytedance.android.ec.model.ECAdLogExtra;
import com.bytedance.android.ec.model.ECBoltParam;
import com.bytedance.android.ec.model.PromotionBenefitLabel;
import com.bytedance.android.ec.model.promotion.ECFindSimilarConfig;
import com.bytedance.android.ec.model.sku.CpsParams;
import com.bytedance.android.ec.model.sku.DefaultSelect;
import com.bytedance.android.ec.model.sku.SkuExtraData;
import com.bytedance.android.ec.model.sku.SkuParams;
import com.bytedance.android.ec.model.sku.SkuPoiInfo;
import com.bytedance.android.ec.model.sku.SkuRestoreState;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ecom.bcm.track.api.EcomBcmTracker;
import com.bytedance.android.livehostapi.business.depend.livead.MiniAppConstants;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.android.shopping.api.address.IAddressService;
import com.bytedance.android.shopping.sku.common.monitor.chain.SkuYataAptChain;
import com.bytedance.android.shopping.sku.common.monitor.chain.SkuYataOpenSkuChain;
import com.bytedance.android.shopping.sku.common.monitor.chain.SkuYataPageShowChain;
import com.bytedance.android.shopping.sku.common.monitor.duration.SkuYataFirstScreenDurationMonitor;
import com.bytedance.android.shopping.sku.common.monitor.duration.SkuYataFirstScreenPoint;
import com.bytedance.android.shopping.sku.common.monitor.error.SkuErrorMonitorType;
import com.bytedance.android.shopping.sku.common.utils.SkuCommonLog;
import com.bytedance.android.shopping.sku.inner.container.SkuYataQueryFrom;
import com.bytedance.android.shopping.sku.inner.container.SkuYataSkeletonLoadingStatus;
import com.bytedance.android.shopping.sku.inner.container.f0;
import com.bytedance.android.shopping.sku.inner.container.o;
import com.bytedance.android.shopping.sku.inner.controller.SkuYataSelfSaveBizFieldsCacheController;
import com.bytedance.android.shopping.sku.inner.repo.composer.SkuYataExParamsComposer;
import com.bytedance.android.shopping.sku.inner.repo.model.SkuPassThroughItem;
import com.bytedance.android.shopping.sku.inner.tracker.SkuYataTracker;
import com.bytedance.android.shopping.sku.params.schema.SkuSchemaParams;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.kmp.ec.yata.common.init.PackYataSdkConfig;
import com.bytedance.kmp.ec.yata.common.protocol.data.f;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.retrofit2.SsResponse;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.ttm.player.MediaPlayer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class SkuYataQueryFetcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f182934a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SkuYataTracker f182935b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f182936c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function1<? super com.bytedance.android.shopping.sku.inner.repo.b, Unit> f182937d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Disposable f182938e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f182939f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public WeakReference<Object> f182940g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile com.bytedance.android.shopping.sku.inner.repo.b f182941h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f182942i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final SkuParams f182943j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final PageFinder f182944k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final SkuSchemaParams f182945l;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SkuYataQueryFetcher f182946a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SkuYataQueryFrom f182947b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ph3.b f182948c;

        public a(SkuYataQueryFetcher r100, SkuYataQueryFrom r101, ph3.b r102) {
            this.f182946a = r100;
            this.f182947b = r101;
            this.f182948c = r102;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r110) {
            Pair r111 = (Pair) r110;
            mh3.a r100 = this.f182946a.a();
            if (r100 == null) goto L11;
            SkuYataFirstScreenDurationMonitor r101 = r100.f513940a;
            if (r101 == null) goto L11;
            Object r102 = ((SsResponse) r111.getSecond()).raw().getExtraInfo();
            hd3.d r103 = ((com.bytedance.android.shopping.sku.inner.repo.a) r111.getFirst()).h();
            if (r101.f182747f != null) goto L10;
            if (r102 == null) goto L10;
            r101.f182747f = r102;
        L10:
            r101.f182748g = r103;
        L11:
            com.bytedance.android.shopping.sku.inner.repo.a r112 = (com.bytedance.android.shopping.sku.inner.repo.a) r111.getFirst();
            int r104 = 0;
            if (f.d(r112) == false) goto L53;
            mh3.a r105 = this.f182946a.a();
            if (r105 == null) goto L16;
            r105.a(f.b(r112));
        L16:
            Lazy r106 = SkuCommonLog.f182771a;
            SkuCommonLog.c("SkuYataQueryFetcher", this.f182947b.getValue() + ":接口请求成功  logId:" + f.b(r112));
            mh3.a r107 = this.f182946a.a();
            if (r107 == null) goto L21;
            SkuYataFirstScreenDurationMonitor r108 = r107.f513940a;
            if (r108 == null) goto L21;
            SkuYataFirstScreenDurationMonitor.b(r108, SkuYataFirstScreenPoint.REQUEST_END);
        L21:
            SkuYataQueryFetcher r109 = this.f182946a;
            r109.getClass();
            com.bytedance.kmp.ec.yata.common.protocol.data.c r113 = r112.i();
            if (r113 == null) goto L32;
            Map<String, Object> r114 = r113.g();
            if (r114 == null) goto L26;
            Object r115 = r114.get("track_common_info");
        L28:
            if ((r115 instanceof Map) == true) goto L30;
            r115 = null;
        L30:
            Map<String, ? extends Object> r116 = (Map) r115;
            if (r116 == null) goto L32;
        L33:
            r109.f182935b.f(r116, true, r109.f182944k);
            Object r117 = r116.get(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO);
            if ((r117 instanceof String) == true) goto L36;
            r117 = null;
        L36:
            String r118 = (String) r117;
            if (r118 == null) goto L44;
            SkuPerformanceOpt.a();
            String r119 = EcomBcmTracker.b(r109.f182944k, r118);
            if (r119 == null) goto L42;
            r118 = r119;
        L42:
            r109.f182935b.e(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO, r118)}));
        L44:
            if (r116.isEmpty() == false) goto L50;
            mh3.a r120 = r109.a();
            if (r120 == null) goto L50;
            com.bytedance.android.shopping.sku.common.monitor.error.a r121 = r120.f513942c;
            if (r121 == null) goto L50;
            SkuErrorMonitorType r122 = SkuErrorMonitorType.SERVER_BUSINESS_ERROR;
            Map<String, com.bytedance.android.shopping.sku.common.monitor.error.a> r123 = com.bytedance.android.shopping.sku.common.monitor.error.a.f182753b;
            r121.a(r122, "首屏请求track_common_info为空", null);
        L50:
            SkuYataQueryFetcher r124 = this.f182946a;
            com.bytedance.android.shopping.sku.inner.repo.b r125 = new com.bytedance.android.shopping.sku.inner.repo.b(new f0(this.f182947b, r112), new o(SkuYataSkeletonLoadingStatus.SUCCESS, 0, 0));
            r124.f182941h = r125;
            Function1<? super com.bytedance.android.shopping.sku.inner.repo.b, Unit> r126 = r124.f182937d;
            if (r126 == null) goto L71;
            Unit r127 = r126.invoke(r125);
        L71:
            mh3.a r128 = this.f182946a.a();
            if (r128 == null) goto L76;
            SkuYataAptChain r129 = r128.f513945f;
            if (r129 == null) goto L76;
            r129.e(r112);
        L76:
            mh3.a r130 = this.f182946a.a();
            if (r130 == null) goto L81;
            SkuYataOpenSkuChain r131 = r130.f513947h;
            if (r131 == null) goto L81;
            r131.c(this.f182948c, r112, null);
        L81:
            mh3.a r132 = this.f182946a.a();
            if (r132 == null) goto L87;
            SkuYataPageShowChain r133 = r132.f513946g;
            if (r133 == null) goto L88;
            r133.b(this.f182948c, r112, null);
            return;
        L88:
            return;
        L87:
            return;
        L26:
            r115 = null;
        L32:
            r116 = MapsKt.emptyMap();
            goto L33
        L53:
            Lazy r134 = SkuCommonLog.f182771a;
            StringBuilder r135 = new StringBuilder();
            r135.append(this.f182947b.getValue() + ":接口请求失败  statusCode:" + r112.a() + "  statusmsg:" + r112.b() + "  logId:" + f.b(r112));
            Unit r136 = Unit.INSTANCE;
            SkuCommonLog.b("SkuYataQueryFetcher", r135.toString());
            SkuYataQueryFetcher r137 = this.f182946a;
            f0 r138 = new f0(this.f182947b, r112);
            SkuYataSkeletonLoadingStatus r139 = SkuYataSkeletonLoadingStatus.ERROR;
            Integer r140 = r112.a();
            if (r140 == null) goto L56;
            int r141 = r140.intValue();
        L57:
            String r142 = r112.g();
            if (r142 == null) goto L60;
            r104 = CastIntegerProtector.parseInt(r142);
        L60:
            com.bytedance.android.shopping.sku.inner.repo.b r143 = new com.bytedance.android.shopping.sku.inner.repo.b(r138, new o(r139, r141, r104));
            r137.f182941h = r143;
            Function1<? super com.bytedance.android.shopping.sku.inner.repo.b, Unit> r144 = r137.f182937d;
            if (r144 == null) goto L63;
            Unit r145 = r144.invoke(r143);
        L63:
            mh3.a r146 = this.f182946a.a();
            if (r146 == null) goto L71;
            com.bytedance.android.shopping.sku.common.monitor.error.a r147 = r146.f513942c;
            if (r147 == null) goto L71;
            SkuErrorMonitorType r148 = SkuErrorMonitorType.SKU_QUERY_API_ERROR;
            String r149 = "code:" + r112.a() + "   msg:" + r112.b();
            JSONObject r150 = new JSONObject();
            r150.put("error_code", String.valueOf(r112.a()));
            String r151 = r112.b();
            if (r151 != null) goto L70;
            r151 = "";
        L70:
            r150.put("error_msg", r151);
            r150.put("log_id", f.b(r112));
            r147.a(r148, r149, r150);
            goto L71
        L56:
            r141 = 0;
            goto L57
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SkuYataQueryFetcher f182949a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SkuYataQueryFrom f182950b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ph3.b f182951c;

        public b(SkuYataQueryFetcher r100, SkuYataQueryFrom r101, ph3.b r102) {
            this.f182949a = r100;
            this.f182950b = r101;
            this.f182951c = r102;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            Lazy r102 = SkuCommonLog.f182771a;
            SkuCommonLog.b("SkuYataQueryFetcher", this.f182950b.getValue() + ":接口请求网络异常  " + r101);
            SkuYataQueryFetcher r103 = this.f182949a;
            com.bytedance.android.shopping.sku.inner.repo.b r104 = new com.bytedance.android.shopping.sku.inner.repo.b(null, new o(SkuYataSkeletonLoadingStatus.ERROR, 0, 0));
            r103.f182941h = r104;
            Function1<? super com.bytedance.android.shopping.sku.inner.repo.b, Unit> r105 = r103.f182937d;
            if (r105 == null) goto L5;
            Unit r106 = r105.invoke(r104);
        L5:
            mh3.a r107 = this.f182949a.a();
            if (r107 == null) goto L10;
            SkuYataOpenSkuChain r108 = r107.f513947h;
            if (r108 == null) goto L10;
            r108.c(this.f182951c, null, r101);
        L10:
            mh3.a r109 = this.f182949a.a();
            if (r109 == null) goto L16;
            SkuYataPageShowChain r110 = r109.f513946g;
            if (r110 == null) goto L17;
            r110.b(this.f182951c, null, r101);
            return;
        L17:
            return;
        }
    }

    public final mh3.a a() {
        return (mh3.a) this.f182936c.getValue();
    }

    public final void b(SkuYataQueryFrom r310) {
        Intrinsics.checkNotNullParameter(r310, "queryFrom");
        if (r310 == SkuYataQueryFrom.FIRST_SCREEN) goto L5;
    L8:
        this.f182939f = true;
        if (r310 != SkuYataQueryFrom.ERROR_RETRY) goto L11;
        Set<String> r100 = ECProcessMonitor.f45118a;
        ECProcessMonitor.p().f45182j.invoke();
        ECProcessMonitor.p().f45171f = "retry_page";
        ECProcessMonitor.p().k();
    L11:
        Lazy r101 = SkuCommonLog.f182771a;
        SkuCommonLog.c("SkuYataQueryFetcher", r310.getValue() + ":开始请求接口");
        mh3.a r102 = a();
        if (r102 == null) goto L16;
        SkuYataFirstScreenDurationMonitor r103 = r102.f513940a;
        if (r103 == null) goto L16;
        SkuYataFirstScreenDurationMonitor.b(r103, SkuYataFirstScreenPoint.REQUEST_START);
    L16:
        SkuYataExParamsComposer r104 = new SkuYataExParamsComposer(this.f182943j, this.f182942i, this.f182945l, this.f182940g);
        Pair[] r105 = new Pair[4];
        if (Intrinsics.areEqual(r104.f182956b, "forDiff") == true) goto L19;
        Map r106 = MapsKt.emptyMap();
    L47:
        SkuSchemaParams r107 = r104.f182957c;
        if (r107 == null) goto L53;
        com.bytedance.android.shopping.sku.inner.repo.composer.b r108 = new com.bytedance.android.shopping.sku.inner.repo.composer.b(r107, r104.f182955a);
        List<SkuPassThroughItem> r109 = r104.a();
        Intrinsics.checkNotNullParameter(r109, "passThrough");
        Map r110 = MapsKt.toMutableMap(MapsKt.mapOf(new Pair[]{TuplesKt.to("product_info", r108.f182960a.getProductInfo().getMap()), TuplesKt.to("biz_context", r108.f182960a.getBizContext().getMap()), TuplesKt.to("user_info", r108.f182960a.getUserInfo().getMap()), TuplesKt.to("client_params", r108.f182960a.getClientParams().getMap()), TuplesKt.to("chain_info", r108.f182960a.getChainInfo().getMap()), TuplesKt.to("custom_params", r108.f182960a.getCustomParams().getMap()), TuplesKt.to("platform_params", r108.f182960a.getPlatformParams().getMap()), TuplesKt.to("pass_through", r109), TuplesKt.to("order_params", com.bytedance.android.shopping.sku.outer.business.ultimate.c.a(r108.f182961b, false))}));
        Iterator r111 = r106.entrySet().iterator();
    L51:
        if (r111.hasNext() == false) goto L261;
        Map.Entry r112 = (Map.Entry) r111.next();
        r110.put(r112.getKey(), r112.getValue());
    L261:
        r105[0] = TuplesKt.to("sku_schema_param", r110);
        int r113 = ECSdk.f48106a;
        IAddressService r114 = (IAddressService) ECSdk.a(IAddressService.class);
        if (r114 == null) goto L270;
        WeakReference<Object> r115 = r104.f182958d;
        if (r115 == null) goto L266;
        Object r116 = r115.get();
    L267:
        o83.a r117 = IAddressService.a.a(r114, r116, "a1.b5267.c0.d0", 4);
        if (r117 == null) goto L270;
        char r118 = 1;
        String r119 = r117.a(true, null, null).toString();
    L271:
        r105[r118] = TuplesKt.to("address_detail", r119);
        LinkedHashMap r120 = new LinkedHashMap();
        com.bytedance.android.ec.core.abtest.d r121 = com.bytedance.android.ec.core.abtest.d.f43639a;
        jj4.b r122 = jj4.b.f499326b;
        Object r123 = jj4.a.a("iesec_sku_ab_keys_ab_sdk", List.class, new ArrayList(), false);
        if (r123 != null) goto L274;
        Intrinsics.throwNpe();
    L274:
        Iterator r124 = ((List) r123).iterator();
    L276:
        if (r124.hasNext() == false) goto L294;
        String r125 = (String) r124.next();
        if (r125.length() <= 0) goto L280;
        boolean r126 = true;
    L281:
        if (r126 == false) goto L276;
        String r127 = "ab_sdk_".concat(r125);
        int r128 = p.f45243a;
        Object r129 = 0;
        Result.Companion r130 = Result.Companion;     // Catch: Throwable -> L287
        jj4.b r131 = jj4.b.f499326b;     // Catch: Throwable -> L287
        Object r132 = jj4.a.a(r125, Integer.class, r129, false);     // Catch: Throwable -> L287
        if (r132 != null) goto L293;
        Intrinsics.throwNpe();     // Catch: Throwable -> L287
    L293:
        r120.put(r127, r132);
    L287:
        th = move-exception;
        Result.Companion r133 = Result.Companion;
        Object r134 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r134) == true) goto L292;
        r129 = r134;
    L292:
        r132 = r129;
        goto L293
    L280:
        r126 = false;
        goto L281
    L294:
        r105[2] = TuplesKt.to(AppConstants.BUNDLE_ACTIVITY_AB_PARAMS_KEYS, k.d(r120));
        r105[3] = TuplesKt.to("sku_unique_id", r104.f182956b);
        Map r135 = MapsKt.mutableMapOf(r105);
        int r136 = g0.f45598a;
        ECAppInfoService r137 = ECAppInfoService.f48114e;
        boolean r138 = true;
        r135.putAll(MapsKt.mapOf(new Pair[]{TuplesKt.to("gps_on", Integer.valueOf(g0.a(r137.getApplicationContext()) ? 1 : 0)), TuplesKt.to("is_auth", Boolean.valueOf(g0.a(r137.getApplicationContext()))), TuplesKt.to("biz_identifier", r104.f182955a.getBizIdentifier())}));
        PackYataSdkConfig r139 = com.bytedance.kmp.ec.yata.common.init.b.f251424a;
        ph3.b r140 = new ph3.b(r135, "1.23.7", 2);
        mh3.a r141 = a();
        if (r141 == null) goto L299;
        SkuYataAptChain r142 = r141.f513945f;
        if (r142 == null) goto L299;
        r142.d(r140);
    L299:
        mh3.a r143 = a();
        if (r143 == null) goto L304;
        SkuYataFirstScreenDurationMonitor r144 = r143.f513940a;
        if (r144 == null) goto L304;
        SkuYataFirstScreenDurationMonitor.b(r144, SkuYataFirstScreenPoint.QUERY_NET_START);
    L304:
        Disposable r145 = this.f182938e;
        if (r145 == null) goto L307;
        r145.dispose();
    L307:
        c r146 = (c) this.f182934a.getValue();
        if (r310 == SkuYataQueryFrom.FIRST_SCREEN) goto L311;
        r138 = false;
    L311:
        this.f182938e = r146.query(r138, r140, new SkuYataQueryFetcher$requestQuery$1(this), new SkuYataQueryFetcher$requestQuery$2(this)).subscribeOn(Schedulers.computation()).subscribe(new a(this, r310, r140), new b(this, r310, r140));
        return;
    L266:
        r116 = null;
    L270:
        r118 = 1;
        r119 = null;
        goto L271
    L53:
        Pair[] r147 = new Pair[9];
        Pair[] r148 = new Pair[7];
        String r149 = r104.f182955a.getProductId();
        if ((r149 instanceof String) == true) goto L56;
        r149 = null;
    L56:
        r148[0] = TuplesKt.to("product_id", r149);
        String r150 = r104.f182955a.getPromotionId();
        Map r210 = r106;
        if (r150 == null) goto L322;
        r148[1] = TuplesKt.to("promotion_id", r150);
        String r151 = r104.f182955a.getCommodityType();
        if (r151 == null) goto L61;
        Integer r152 = StringsKt.toIntOrNull(r151);
    L63:
        if ((r152 instanceof Integer) == true) goto L65;
        r152 = null;
    L65:
        r148[2] = TuplesKt.to(PdpOpenThirdParam.KEY_PROMOTION_SOURCE, r152);
        r148[3] = TuplesKt.to("is_multi", Boolean.valueOf(r104.f182955a.isMulti()));
        String r153 = r104.f182955a.getShopId();
        if ((r153 instanceof String) == true) goto L68;
        r153 = null;
    L68:
        r148[4] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_SHOP_ID, r153);
        String r154 = r104.f182955a.getCombinationId();
        if ((r154 instanceof String) == true) goto L71;
        r154 = null;
    L71:
        r148[5] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_COMBINATION_ID, r154);
        DefaultSelect r155 = r104.f182955a.getDefaultSelect();
        if (r155 == null) goto L74;
        String r156 = r155.getSkuId();
    L76:
        if ((r156 instanceof String) == true) goto L78;
        r156 = null;
    L78:
        r148[6] = TuplesKt.to("hot_sale_sku_id", r156);
        r147[0] = TuplesKt.to("product_info", MapsKt.mapOf(r148));
        Pair[] r157 = new Pair[19];
        String r158 = r104.f182955a.getAuthorId();
        if (r158 == null) goto L320;
        r157[0] = TuplesKt.to("author_id", r158);
        String r159 = r104.f182955a.getSecAuthorId();
        if (r159 == null) goto L318;
        r157[1] = TuplesKt.to("sec_author_id", r159);
        String r160 = r104.f182955a.getItemId();
        if ((r160 instanceof String) == true) goto L85;
        r160 = null;
    L85:
        r157[2] = TuplesKt.to("item_id", r160);
        String r161 = r104.f182955a.getRoomId();
        if ((r161 instanceof String) == true) goto L88;
        r161 = null;
    L88:
        r157[3] = TuplesKt.to(MiniAppConstants.KEY_MINI_APP_LIVE_ROOM_ID, r161);
        r157[4] = TuplesKt.to("is_group_buy", Boolean.valueOf(r104.f182955a.isGroupingBuy()));
        String r162 = String.valueOf(r104.f182955a.getActionType());
        if (r162 == null) goto L316;
        r157[5] = TuplesKt.to("action_type", r162);
        String r163 = String.valueOf(r104.f182955a.getSceneType());
        if (r163 == null) goto L314;
        r157[6] = TuplesKt.to("scene_type", r163);
        DefaultSelect r164 = r104.f182955a.getDefaultSelect();
        if (r164 == null) goto L95;
        String r165 = r164.getLastSelectedSkuId();
    L97:
        if ((r165 instanceof String) == true) goto L99;
        r165 = null;
    L99:
        r157[7] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_SKU_ID, r165);
        DefaultSelect r166 = r104.f182955a.getDefaultSelect();
        if (r166 == null) goto L102;
        Integer r167 = r166.getType();
    L104:
        if ((r167 instanceof Integer) == true) goto L106;
        r167 = null;
    L106:
        r157[8] = TuplesKt.to("hot_sale_type", r167);
        Lazy r168 = SkuPerformanceOpt.f45320a;
        BuyNowPerformanceOpt.l();
        r157[9] = TuplesKt.to("order_url", null);
        String r169 = r104.f182955a.getDetailUrl();
        if ((r169 instanceof String) == true) goto L109;
        r169 = null;
    L109:
        r157[10] = TuplesKt.to("detail_url", r169);
        r157[11] = TuplesKt.to("auto_apply_coupon", Boolean.FALSE);
        List<PromotionBenefitLabel> r170 = r104.f182955a.getBenefitLabels();
        if ((r170 instanceof List) == true) goto L112;
        r170 = null;
    L112:
        r157[12] = TuplesKt.to("coupon_tags", r170);
        JSONObject r171 = new JSONObject();
        r171.put(PdpOpenThirdParam.KEY_PROMOTION_SOURCE, r104.f182955a.getCommodityType());
        r171.put("product_id", r104.f182955a.getProductId());
        r171.put("promotion_id", r104.f182955a.getPromotionId());
        Unit r172 = Unit.INSTANCE;
        r157[13] = TuplesKt.to("live_product_raw_data", r171.toString());
        String r173 = r104.f182955a.getSelectCarId();
        if ((r173 instanceof String) == true) goto L115;
        r173 = null;
    L115:
        r157[14] = TuplesKt.to("car_id", r173);
        r157[15] = TuplesKt.to("ngroup_buy_token", r104.f182955a.getNGroupBuyToken());
        r157[16] = TuplesKt.to("biz_identifier", r104.f182955a.getBizIdentifier());
        r157[17] = TuplesKt.to("warehouse_list_id", r104.f182955a.getWarehouseListID());
        r157[18] = TuplesKt.to("live_shop_mode", r104.f182955a.getLiveShopMode());
        r147[1] = TuplesKt.to("biz_context", MapsKt.mapOf(r157));
        String r174 = r104.f182955a.getReceiveAddressId();
        if ((r174 instanceof String) == true) goto L118;
        r174 = null;
    L118:
        r147[2] = TuplesKt.to("user_info", MapsKt.mapOf(TuplesKt.to("user_addr_id", r174)));
        ECSettingKeys.f43625j.getClass();
        if (ECSettingKeys.V() == false) goto L121;
        int r175 = MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_MAX_CRYPTO_RETRANSMISSION_TIME_MS;
    L125:
        int r176 = r104.f182955a.getHeightPercent();
        String r177 = String.valueOf(r104.f182955a.getSceneType());
        Integer r178 = r104.f182955a.getForceHeight();
        if (BuyNowPerformanceOpt.m() == false) goto L129;
        r176 = 88;
    L151:
        Pair[] r179 = new Pair[16];
        SkuRestoreState r180 = r104.f182955a.getSkuState();
        if (r180 == null) goto L154;
        String[] r181 = r180.getSelectSkuKeys();
    L156:
        if ((r181 instanceof String[]) == true) goto L158;
        r181 = null;
    L158:
        r179[0] = TuplesKt.to("default_spec_id", r181);
        DefaultSelect r182 = r104.f182955a.getDefaultSelect();
        if (r182 == null) goto L161;
        Long r183 = r182.getBuyNum();
    L163:
        if ((r183 instanceof Long) == true) goto L165;
        r183 = null;
    L165:
        r179[1] = TuplesKt.to("default_count", r183);
        SkuPoiInfo r184 = r104.f182955a.getPoiInfo();
        if ((r184 instanceof SkuPoiInfo) == true) goto L168;
        r184 = null;
    L168:
        r179[2] = TuplesKt.to("poi_info", r184);
        Boolean r185 = r104.f182955a.getPopOnWindow();
        if ((r185 instanceof Boolean) == true) goto L171;
        r185 = null;
    L171:
        r179[3] = TuplesKt.to("pop_on_window", r185);
        String r186 = r104.f182955a.getSkuSessionId();
        if ((r186 instanceof String) == true) goto L174;
        r186 = null;
    L174:
        r179[4] = TuplesKt.to("sku_session_id", r186);
        r179[5] = TuplesKt.to("scroll_to_installment", Boolean.valueOf(r104.f182955a.getScrollToDouInstallment()));
        String r187 = r104.f182955a.getMaskBackgroundColor();
        if ((r187 instanceof String) == true) goto L177;
        r187 = null;
    L177:
        r179[6] = TuplesKt.to("mask_background_color", r187);
        DefaultSelect r188 = r104.f182955a.getDefaultSelect();
        if (r188 == null) goto L180;
        Boolean r189 = Boolean.valueOf(r188.getDisableServerSpecsDefaultSelect());
    L182:
        if ((r189 instanceof Boolean) == true) goto L184;
        r189 = null;
    L184:
        r179[7] = TuplesKt.to("disable_server_specs_default_select", r189);
        Integer r190 = r104.f182955a.getTermCount();
        if (r190 == null) goto L187;
        String r191 = String.valueOf(r190.intValue());
    L189:
        if ((r191 instanceof String) == true) goto L191;
        r191 = null;
    L191:
        r179[8] = TuplesKt.to("dou_installment_term", r191);
        Integer r192 = r104.f182955a.getSpecMode();
        if ((r192 instanceof Integer) == true) goto L194;
        r192 = null;
    L194:
        r179[9] = TuplesKt.to("spec_mode", r192);
        Long r193 = r104.f182955a.getSpecModeTime();
        if (r193 == null) goto L197;
        String r194 = String.valueOf(r193.longValue());
    L199:
        if ((r194 instanceof String) == true) goto L201;
        r194 = null;
    L201:
        r179[10] = TuplesKt.to("spec_mode_time", r194);
        SkuYataSelfSaveBizFieldsCacheController.a r195 = SkuYataSelfSaveBizFieldsCacheController.f182886a;
        Map r196 = SkuYataSelfSaveBizFieldsCacheController.a(r104.f182955a.getPromotionId());
        if (r196 != null) goto L205;
        r196 = null;
    L205:
        r179[11] = TuplesKt.to("sku_last_biz_fields", k.d(r196));
        r179[12] = TuplesKt.to(ECFindSimilarConfig.HEIGHT_PERCENT, r176);
        r179[13] = TuplesKt.to("force_height", r178);
        r179[14] = TuplesKt.to("panel_width", Integer.valueOf(r175));
        int r197 = com.bytedance.android.shopping.sku.common.utils.c.f182779a;
        Integer r198 = Integer.valueOf(com.bytedance.android.shopping.sku.common.utils.c.a(ECAppInfoService.f48114e.getCurrentActivity()).f182787b);
        List<String> r199 = com.bytedance.android.shopping.sku.inner.repo.composer.a.f182959a;
        Resources r200 = Resources.getSystem();
        float r201 = WindowDisplayMetricsOverride.apply(r200, r200.getDisplayMetrics()).density;
        if (r201 == 0.0f) goto L208;
        int r202 = (int) (r198.floatValue() / r201);
    L209:
        r179[15] = TuplesKt.to(BaseStandardHomeFragment.KEY_PANEL_HEIGHT, Integer.valueOf(r202));
        r147[3] = TuplesKt.to("client_params", MapsKt.mapOf(r179));
        Pair[] r203 = new Pair[8];
        SkuExtraData r204 = r104.f182955a.getSkuExtraData();
        if (r204 == null) goto L212;
        String r1100 = r204.getMarketChannel();
    L214:
        if ((r1100 instanceof String) == true) goto L216;
        r1100 = null;
    L216:
        r203[0] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_MARKET_CHANNEL, r1100);
        String r1101 = r104.f182955a.getEnterFrom();
        if ((r1101 instanceof String) == true) goto L219;
        r1101 = null;
    L219:
        r203[1] = TuplesKt.to("enter_from", r1101);
        String r1102 = r104.f182955a.getChannelId();
        if ((r1102 instanceof String) == true) goto L222;
        r1102 = null;
    L222:
        r203[2] = TuplesKt.to("channel_id", r1102);
        Integer r205 = r104.f182955a.getChannelType();
        if (r205 == null) goto L225;
        String r1103 = String.valueOf(r205.intValue());
    L227:
        if ((r1103 instanceof String) == true) goto L229;
        r1103 = null;
    L229:
        r203[3] = TuplesKt.to(WsConstants.KEY_CHANNEL_TYPE, r1103);
        Integer r206 = r104.f182955a.getTouTiaoAppId();
        if (r206 == null) goto L232;
        String r1104 = String.valueOf(r206.intValue());
    L234:
        if ((r1104 instanceof String) == true) goto L236;
        r1104 = null;
    L236:
        r203[4] = TuplesKt.to("toutiao_app_id", r1104);
        String r1105 = r104.f182955a.getEcomEntranceForm();
        if ((r1105 instanceof String) == true) goto L239;
        r1105 = null;
    L239:
        r203[5] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_ECOM_ENTRANCE_FORM, r1105);
        String r1106 = r104.f182955a.getProductSourcePage();
        if ((r1106 instanceof String) == true) goto L242;
        r1106 = null;
    L242:
        r203[6] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_PRODUCT_SOURCE_PAGE, r1106);
        String r1107 = r104.f182955a.getBizCampaignType();
        if ((r1107 instanceof String) == true) goto L245;
        r1107 = null;
    L245:
        r203[7] = TuplesKt.to("biz_campaign_type", r1107);
        r147[4] = TuplesKt.to("chain_info", MapsKt.mapOf(r203));
        Pair[] r207 = new Pair[3];
        ECAdLogExtra r1108 = r104.f182955a.getAdLogExtra();
        if ((r1108 instanceof ECAdLogExtra) == true) goto L248;
        r1108 = null;
    L248:
        r207[0] = TuplesKt.to("ad_params", r1108);
        ECBoltParam r1109 = r104.f182955a.getBoltParam();
        if ((r1109 instanceof ECBoltParam) == true) goto L251;
        r1109 = null;
    L251:
        r207[1] = TuplesKt.to("bolt_param", r1109);
        CpsParams r1110 = r104.f182955a.getCpsParams();
        if ((r1110 instanceof CpsParams) == true) goto L254;
        r1110 = null;
    L254:
        r207[2] = TuplesKt.to("cps_params", r1110);
        r147[5] = TuplesKt.to("custom_params", MapsKt.mapOf(r207));
        Boolean r1111 = r104.f182955a.getOpenWithSass();
        if ((r1111 instanceof Boolean) == true) goto L257;
        r1111 = null;
    L257:
        r147[6] = TuplesKt.to("platform_params", MapsKt.mapOf(TuplesKt.to("open_with_saas", r1111)));
        r147[7] = TuplesKt.to("pass_through", r104.a());
        r147[8] = TuplesKt.to("order_params", com.bytedance.android.shopping.sku.outer.business.ultimate.c.a(r104.f182955a, false));
        r110 = MapsKt.toMutableMap(MapsKt.mapOf(r147));
        Iterator r208 = r210.entrySet().iterator();
    L259:
        if (r208.hasNext() == false) goto L261;
        Map.Entry r209 = (Map.Entry) r208.next();
        r110.put(r209.getKey(), r209.getValue());
        goto L259
    L232:
        r1104 = null;
        goto L234
    L225:
        r1103 = null;
        goto L227
    L212:
        r1100 = null;
        goto L214
    L208:
        r202 = 0;
        goto L209
    L197:
        r194 = null;
        goto L199
    L187:
        r191 = null;
        goto L189
    L180:
        r189 = null;
        goto L182
    L161:
        r183 = null;
        goto L163
    L154:
        r181 = null;
        goto L156
    L129:
        if (BuyNowPerformanceOpt.p() == false) goto L134;
        if (ECSettingKeys.W().contains(r177) == false) goto L151;
        r176 = 88;
        goto L151
    L134:
        if (BuyNowPerformanceOpt.o() == false) goto L139;
        if (ECSettingKeys.W().contains(r177) == true) goto L151;
        r176 = 88;
        goto L151
    L139:
        if (BuyNowPerformanceOpt.n() == false) goto L146;
        if (r178 != null) goto L143;
    L144:
        r176 = 88;
        goto L151
    L143:
        if (r178.intValue() == 1) goto L151;
    L146:
        if (r178 == null) goto L151;
        if (r178.intValue() != 1) goto L151;
        r176 = 88;
        goto L151
    L121:
        int r211 = com.bytedance.android.shopping.sku.common.utils.c.f182779a;
        Integer r212 = Integer.valueOf(com.bytedance.android.shopping.sku.common.utils.c.a(ECAppInfoService.f48114e.getCurrentActivity()).f182786a);
        List<String> r213 = com.bytedance.android.shopping.sku.inner.repo.composer.a.f182959a;
        Resources r214 = Resources.getSystem();
        float r215 = WindowDisplayMetricsOverride.apply(r214, r214.getDisplayMetrics()).density;
        if (r215 == 0.0f) goto L124;
        r175 = (int) (r212.floatValue() / r215);
        goto L125
    L124:
        r175 = 0;
        goto L125
    L102:
        r167 = null;
        goto L104
    L95:
        r165 = null;
        goto L97
    L314:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    L316:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    L318:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    L320:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    L74:
        r156 = null;
        goto L76
    L61:
        r152 = null;
        goto L63
    L322:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    L19:
        if (Intrinsics.areEqual(r104.f182956b, "forDiff") == true) goto L21;
    L44:
        String r216 = r104.f182955a.getTrackExtra();
    L45:
        String r217 = r104.f182955a.getEventParams().get(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO);
        int r218 = com.bytedance.android.ec.core.hybrid.utils.k.f44314a;
        r106 = MapsKt.mapOf(new Pair[]{TuplesKt.to("api_add_extra", r216), TuplesKt.to("track_client_entrance_info", r217), TuplesKt.to("track_client", com.bytedance.android.ec.core.hybrid.utils.k.b(r104.f182955a.getEventParams()).toString()), TuplesKt.to("api_sku_entrance_info", r104.f182955a.getEntranceInfo())});
        goto L47
    L21:
        if (a2.b(r104.f182955a.getAddCartEntranceInfo()) == false) goto L44;
        JSONObject r219 = z1.g(r104.f182955a.getTrackExtra());
        if (r219 == null) goto L43;
        JSONObject r1112 = com.bytedance.android.shopping.extensions.k.u(r219.optString("cart_track"));
        SkuExtraData r1113 = r104.f182955a.getSkuExtraData();
        if (r1113 == null) goto L34;
        String r1114 = r1113.getTransitionTrackerData();
        if (r1114 == null) goto L34;
        JSONObject r1115 = z1.g(r1114);
        if (r1115 == null) goto L34;
        Iterator<String> r1116 = r1115.keys();
    L32:
        if (r1116.hasNext() == false) goto L34;
        String r1117 = r1116.next();
        r1112.put(r1117, r1115.optString(r1117));
    L34:
        String r1118 = r104.f182955a.getAddCartEntranceInfo();
        if (r1118 == null) goto L42;
        JSONObject r1119 = z1.g(r1118);
        if (r1119 == null) goto L42;
        Iterator<String> r1120 = r1119.keys();
    L40:
        if (r1120.hasNext() == false) goto L42;
        String r1121 = r1120.next();
        r1112.put(r1121, r1119.optString(r1121));
    L42:
        KtSafeMethodExtensionKt.safePut(r219, "cart_track", r1112.toString());
        r216 = r219.toString();
        goto L45
    L43:
        r216 = null;
        goto L45
    L5:
        if (this.f182939f == false) goto L8;
        SkuCommonLog.c("SkuYataQueryFetcher", "hasStartFirstQuery so return");
    }

    public SkuYataQueryFetcher(String r100, SkuParams r101, PageFinder r102, SkuSchemaParams r103) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        Intrinsics.checkNotNullParameter(r101, "skuParams");
        this.f182942i = r100;
        this.f182943j = r101;
        this.f182944k = r102;
        this.f182945l = r103;
        this.f182934a = LazyKt.lazy(SkuYataQueryFetcher$repository$2.INSTANCE);
        this.f182935b = new SkuYataTracker(r101);
        this.f182936c = LazyKt.lazy(new SkuYataQueryFetcher$monitorManager$2(this));
        this.f182941h = new com.bytedance.android.shopping.sku.inner.repo.b(null, new o(SkuYataSkeletonLoadingStatus.LOADING, 0, 0));
        SkuYataQueryFetcherHolder.INSTANCE.put(r100, this);
        r101.setEntranceInfo(EcomBcmTracker.b(r102, r101.getEntranceInfo()));
        SkuPerformanceOpt.a();
        SkuCommonLog.c("SkuYataQueryFetcher", "enableClientSkuOpt so not append");
    }
}
