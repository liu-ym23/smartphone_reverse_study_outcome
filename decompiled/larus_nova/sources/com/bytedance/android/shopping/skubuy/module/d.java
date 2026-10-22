package com.bytedance.android.shopping.skubuy.module;

import android.view.View;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.model.abscontainer.ISchemaModel;
import com.bytedance.android.ec.model.abscontainer.ISkuBuySchemaModel;
import com.bytedance.android.shopping.abscontainer.arch.core.starter.PageInfo;
import com.bytedance.android.shopping.abscontainer.common_biz.constant.ErrorMonitorType;
import com.bytedance.android.shopping.abscontainer.common_biz.constant.PageStartupStatus;
import com.bytedance.android.shopping.abscontainer.common_biz.constant.track.TradeCheckPoint$Node;
import com.bytedance.android.shopping.anchorv3.utils.a0;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.skubuy.constant.PageAvailability;
import com.bytedance.android.shopping.skubuy.constant.SkuBuyModuleName;
import com.bytedance.android.shopping.skubuy.starter.SkuBuyPageInfo;
import com.bytedance.android.shopping.track.TrackCatcher;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.tencent.open.SocialConstants;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.json.JSONObject;
import u33.a;
import v43.a;
import v43.b;
import v43.l;
import v43.n;
import v43.o;

/* JADX INFO: loaded from: classes13.dex */
public final class d<STATE extends o & v43.b & l & v43.a & n, PROPS extends u33.a> extends s33.b<STATE, PROPS> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f183132b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f183133c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f183134d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Stack<String> f183135e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f183136f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public PageAvailability f183137g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f183138h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Map<String, Pair<String, Map<String, Object>>> f183139i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final HashSet<String> f183140j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Long f183141k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Long f183142l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f183143m;

    @Override // s33.b
    public final void A() {
        long r100 = ((o) this.f540457a.f507247a).F();
        PageStartupStatus r101 = ((o) this.f540457a.f507247a).c();
        String r102 = ((o) this.f540457a.f507247a).K();
        Pair[] r103 = new Pair[6];
        int r104 = ai3.c.f3731a;
        a0 r105 = a0.f165301a;
        r103[0] = TuplesKt.to("page_hidden", 0);
        r103[1] = TuplesKt.to("return_method", r102);
        r103[2] = TuplesKt.to("startup_status", r101.getRawValue());
        r103[3] = TuplesKt.to("popup_codes", CollectionsKt.joinToString$default(this.f183135e, ",", null, null, 0, null, null, 62, null));
        int r106 = j43.d.f497356a;
        r103[4] = TuplesKt.to("duration", Long.valueOf(System.currentTimeMillis() - r100));
        Long r107 = this.f183142l;
        if (r107 == null) goto L5;
        long r108 = r107.longValue();
    L6:
        r103[5] = TuplesKt.to("stage2_delay", Long.valueOf(r108));
        Map<String, ? extends Object> r109 = MapsKt.mapOf(r103);
        this.f540457a.f507250d.a().b("order_submit_return", r109);
        y43.a r110 = ((v43.b) this.f540457a.f507247a).a().f558140a;
        if (r110 != null) goto L9;
    L11:
        C();
        Lazy r111 = TrackCatcher.f187025a;
        if (TrackCatcher.a.a() == null) goto L15;
        TrackCatcher.b("step_order");
        return;
    L15:
        return;
    L9:
        if (r110.f565988a != true) goto L11;
        ai3.a.a(this.f540457a.f507250d.a(), ErrorMonitorType.CLOSE_WITH_LOADING, "");
        goto L11
    L5:
        r108 = 0;
        goto L6
    }

    public final void C() {
        Iterator r100 = ((LinkedHashMap) this.f183139i).entrySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        Map.Entry r101 = (Map.Entry) r100.next();
        this.f540457a.f507250d.a().a((String) ((Pair) r101.getValue()).getFirst(), k.b((Map) ((Pair) r101.getValue()).getSecond()));
        goto L4
    L6:
        ((LinkedHashMap) this.f183139i).clear();
        this.f183140j.clear();
    }

    @Override // s33.b
    public final void b() {
        ((o) this.f540457a.f507247a).M(PageStartupStatus.RENDER_FINISH);
        this.f183141k = Long.valueOf(System.currentTimeMillis());
    }

    @Override // s33.b
    public final void c() {
        if (this.f183138h == true) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(this.f540457a.f507250d.c().e("async_two_stage"), 2) == false) goto L20;
        Long r100 = this.f183141k;
        Object r101 = null;
        if (r100 == null) goto L9;
        Long r102 = Long.valueOf(System.currentTimeMillis() - r100.longValue());
    L10:
        this.f183142l = r102;
        Object r103 = this.f540457a.f507250d.c().e("tracker_common_params");
        if ((r103 instanceof Map) == false) goto L14;
        r101 = r103;
    L14:
        Map<String, ? extends Object> r104 = (Map) r101;
        com.bytedance.android.shopping.abscontainer.arch.core.ability.impl.c r105 = this.f540457a.f507250d.a();
        if (r104 != null) goto L17;
        r104 = MapsKt.emptyMap();
    L17:
        r105.c(r104);
        D("page_view", MapsKt.mapOf(TuplesKt.to("availability", Integer.valueOf(this.f183137g.getRawValue()))));
        return;
    L9:
        r102 = null;
        goto L10
    }

    @Override // s33.b
    public final void y() {
        com.bytedance.android.shopping.abscontainer.arch.core.ability.impl.c r100 = this.f540457a.f507250d.a();
        ISchemaModel r101 = this.f540457a.f507249c.f548574a.getSchemaModel();
        String r102 = r101.getQueryParam("eztf_sdk_extra");
        Object r103 = null;
        if (r102 == null) goto L7;
        JSONObject r104 = k.w(r102);
        if (r104 == null) goto L7;
        Object r105 = r104.opt("source_page");
    L9:
        if ((r105 instanceof String) == false) goto L12;
        r103 = r105;
    L12:
        String r106 = (String) r103;
        String r107 = "";
        if (r106 != null) goto L15;
        r106 = "";
    L15:
        AtomicBoolean r108 = com.bytedance.android.shopping.skubuy.platform.helper.b.f183162a;
        long r109 = wh.a.a("ecom_buynow_card_template");
        String r110 = this.f540457a.f507249c.f548574a.getSchemaModel().getQueryParam("scene_type");
        if (r110 != null) goto L18;
        r110 = "";
    L18:
        String r111 = r101.getQueryParam(com.bytedance.android.ec.core.event.a.KEY_COMBO_ID);
        if (r111 != null) goto L21;
        r111 = "";
    L21:
        String r112 = r101.getQueryParam(com.bytedance.android.ec.core.event.a.KEY_SHOP_ID);
        if (r112 != null) goto L24;
        r112 = "";
    L24:
        String r113 = r101.getQueryParam("id");
        if (r113 == null) goto L29;
        r107 = r113;
    L29:
        if (Intrinsics.areEqual(r101.getQueryParam("is_cart_order"), "1") == false) goto L31;
        String r114 = "105";
    L32:
        String r115 = r101.getQueryParam(com.bytedance.android.ec.core.event.a.KEY_NEW_SOURCE_TYPE);
        if (r115 != null) goto L35;
        r115 = "0";
    L35:
        int r116 = e.f183144a;
        e.f183144a = r116 + 1;
        r100.c(MapsKt.mapOf(new Pair[]{TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_EVENT_ORIGIN_FEATURE, com.bytedance.android.ec.core.event.a.VALUE_TEMAI), TuplesKt.to("EVENT_PAGE_TECHNOLOGY", "YATA_Android"), TuplesKt.to("btm", this.f540457a.f507249c.f548575b.f535861a), TuplesKt.to("page_name", "submit_orders"), TuplesKt.to("log_id", this.f540457a.f507249c.f548574a.getSessionID()), TuplesKt.to("page_scene", "1"), TuplesKt.to("params_for_special", com.bytedance.android.ec.core.event.a.VALUE_PARAMS_FOR_SPECIAL), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_NEW_SOURCE_TYPE, r115), TuplesKt.to("area_type", r114), TuplesKt.to("page_type", "half_screen"), TuplesKt.to("product_id", r107), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_SHOP_ID, r112), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_SKU_ID, r111), TuplesKt.to("eztf_source_page", r106), TuplesKt.to("gecko_channel_version", Long.valueOf(r109)), TuplesKt.to("scene_type", r110), TuplesKt.to("arch_opt", 2), TuplesKt.to("start_count", Integer.valueOf(r116))}));
        this.f540457a.f507250d.a().a("trade_checkpoint", MapsKt.mapOf(TuplesKt.to("type", TradeCheckPoint$Node.ENTER_PAGE.getRawValue())));
        this.f540457a.f507250d.a().a("trade_checkpoint", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("type", TradeCheckPoint$Node.RENDER_REQUEST_START.getRawValue()), TuplesKt.to(SocialConstants.PARAM_APP_DESC, this.f183133c)}));
        ((v43.b) this.f540457a.f507247a).g().a(new b(this));
        ((l) this.f540457a.f507247a).o().a(new c(this));
        Lazy r117 = TrackCatcher.f187025a;
        if (TrackCatcher.a.a() == null) goto L39;
        TrackCatcher.a("step_order");
        return;
    L39:
        return;
    L31:
        r114 = "169";
    L7:
        r105 = null;
        goto L9
    }

    @Override // s33.b
    public final String j() {
        return this.f183132b;
    }

    public d(l33.b<STATE, PROPS> r100) {
        Intrinsics.checkNotNullParameter(r100, "containerContext");
        super(r100);
        this.f183132b = SkuBuyModuleName.PAGE_LIFECYCLE_TRACK_MODULE.getRawValue();
        this.f183133c = "/order/component/confirmOrder/";
        this.f183134d = "/order/component/confirmOrderEdit/";
        this.f183135e = new Stack();
        this.f183137g = PageAvailability.FAILED;
        ConcurrentHashMap<String, Object> r101 = a43.a.f1756a;
        Object r102 = l43.a.a("ec_buy_now_async_tracker_delay");
        if ((r102 instanceof Boolean) == true) goto L5;
        r102 = null;
    L5:
        this.f183138h = Intrinsics.areEqual((Boolean) r102, Boolean.TRUE);
        this.f183139i = new LinkedHashMap();
        this.f183140j = new HashSet();
    }

    public final void E(Map<String, ? extends Object> r100) {
        if (this.f183138h == false) goto L19;
        Object r101 = null;
        if (r100 == null) goto L7;
        Object r102 = r100.get("async_delay_list");
    L9:
        if ((r102 instanceof List) == false) goto L12;
        r101 = r102;
    L12:
        List r103 = (List) r101;
        if (r103 != null) goto L16;
        r103 = CollectionsKt.emptyList();
    L16:
        if (r103.contains("page_view") == false) goto L19;
        this.f183139i.put("page_view", TuplesKt.to("page_view", MapsKt.mapOf(TuplesKt.to("availability", Integer.valueOf(this.f183137g.getRawValue())))));
        return;
    L7:
        r102 = null;
    L19:
        this.f540457a.f507250d.a().b("page_view", MapsKt.mapOf(TuplesKt.to("availability", Integer.valueOf(this.f183137g.getRawValue()))));
    }

    @Override // s33.b
    public final void e(n33.c r100) {
        Intrinsics.checkNotNullParameter(r100, "response");
        this.f183137g = PageAvailability.FAILED;
        E(null);
        this.f540457a.f507250d.a().a("trade_checkpoint", MapsKt.mapOf(new Pair[]{TuplesKt.to("type", TradeCheckPoint$Node.RENDER_REQUEST_FAILED.getRawValue()), TuplesKt.to(SocialConstants.PARAM_APP_DESC, this.f183133c)}));
        if (((n) this.f540457a.f507247a).L() <= 0) goto L6;
        this.f540457a.f507250d.a().a("skubuy_query_retry_failed", MapsKt.mapOf(new Pair[]{TuplesKt.to("retry_count", Integer.valueOf(((n) this.f540457a.f507247a).L())), TuplesKt.to("is_auto_retry", Boolean.valueOf(((n) this.f540457a.f507247a).e()))}));
        return;
    }

    @Override // s33.b
    public final void f(n33.f r100) {
        Intrinsics.checkNotNullParameter(r100, "response");
        com.bytedance.kmp.ec.yata.common.protocol.data.c r101 = r100.f516920b.g();
        Map<String, Object> r102 = null;
        if (r101 == null) goto L7;
        Map<String, Object> r103 = r101.g();
        if (r103 == null) goto L7;
        Object r104 = r103.get("tracker_common_params");
    L9:
        if ((r104 instanceof Map) == true) goto L11;
        r104 = null;
    L11:
        Map<String, ? extends Object> r105 = (Map) r104;
        if (r105 != null) goto L14;
        r105 = MapsKt.emptyMap();
    L14:
        ISchemaModel r106 = this.f540457a.f507249c.f548574a.getSchemaModel();
        if ((r106 instanceof ISkuBuySchemaModel) == true) goto L17;
        r106 = null;
    L17:
        ISkuBuySchemaModel r107 = (ISkuBuySchemaModel) r106;
        if (r107 == null) goto L20;
        Map<String, Object> r108 = r107.getSkuLogData();
    L22:
        if (TypeIntrinsics.isMutableMap(r108) == true) goto L24;
        r108 = null;
    L24:
        if (r108 != null) goto L26;
        r108 = MapsKt.emptyMap();
    L26:
        if (r108 != null) goto L28;
        Map<String, ? extends Object> r109 = r105;
    L50:
        this.f540457a.f507250d.a().c(r109);
        if (mq.b.c(r105, "all_forbidden", false) == false) goto L53;
        PageAvailability r110 = PageAvailability.ALL_FOR_FORBIDDEN;
    L54:
        this.f183137g = r110;
        com.bytedance.kmp.ec.yata.common.protocol.data.c r111 = r100.f516920b.g();
        if (r111 == null) goto L57;
        r102 = r111.g();
    L57:
        E(r102);
        this.f540457a.f507250d.a().a("trade_checkpoint", MapsKt.mapOf(new Pair[]{TuplesKt.to("type", TradeCheckPoint$Node.RENDER_REQUEST_SUCCESS.getRawValue()), TuplesKt.to(SocialConstants.PARAM_APP_DESC, this.f183133c)}));
        ((o) this.f540457a.f507247a).M(PageStartupStatus.RENDERING);
        if (((n) this.f540457a.f507247a).L() <= 0) goto L61;
        this.f540457a.f507250d.a().a("skubuy_query_retry_success", MapsKt.mapOf(new Pair[]{TuplesKt.to("retry_count", Integer.valueOf(((n) this.f540457a.f507247a).L())), TuplesKt.to("is_auto_retry", Boolean.valueOf(((n) this.f540457a.f507247a).e()))}));
        return;
    L61:
        return;
    L53:
        r110 = PageAvailability.SUCCESS;
        goto L54
    L28:
        r109 = MapsKt.toMutableMap(r108);
        if (TypeIntrinsics.isMutableMap(r109) == true) goto L31;
        r109 = null;
    L31:
        if (r109 != null) goto L33;
        r109 = new LinkedHashMap();
    L33:
        B(r109, r108, r105);
        PageInfo r112 = this.f540457a.f507249c.f548574a;
        if ((r112 instanceof SkuBuyPageInfo) == true) goto L36;
        r112 = null;
    L36:
        SkuBuyPageInfo r113 = (SkuBuyPageInfo) r112;
        if (r113 == null) goto L50;
        String r114 = r113.f183207f;
        if (r114 == null) goto L50;
        String r115 = a2.d(r114);
        if (r115 == null) goto L50;
        r109.put(com.bytedance.android.ec.core.event.a.KEY_RECOMMEND_INFO, r115);
        Object r116 = r109.get(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO);
        if ((r116 instanceof String) == true) goto L45;
        r116 = null;
    L45:
        String r117 = (String) r116;
        if (r117 == null) goto L50;
        JSONObject r118 = k.w(r117);
        if (r118 == null) goto L50;
        KtSafeMethodExtensionKt.safePut(r118, com.bytedance.android.ec.core.event.a.KEY_RECOMMEND_INFO, r115);
        r109.put(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO, r118.toString());
        goto L50
    L20:
        r108 = null;
    L7:
        r104 = null;
        goto L9
    }

    @Override // s33.b
    public final void h(com.bytedance.kmp.ec.yata.common.biz.callback.a r100) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        com.bytedance.android.shopping.abscontainer.arch.core.ability.impl.c r101 = this.f540457a.f507250d.a();
        Pair[] r102 = new Pair[3];
        r102[0] = TuplesKt.to("type", TradeCheckPoint$Node.EDIT_REQUEST_START.getRawValue());
        r102[1] = TuplesKt.to(SocialConstants.PARAM_APP_DESC, this.f183134d);
        String r103 = r100.f251372c;
        if (r103 != null) goto L5;
        r103 = "";
    L5:
        r102[2] = TuplesKt.to("trigger_origin", r103);
        r101.a("trade_checkpoint", MapsKt.mapOf(r102));
        if (this.f183143m == true) goto L9;
        this.f183143m = true;
        this.f540457a.f507250d.a().c(MapsKt.mapOf(TuplesKt.to("edited", "1")));
        return;
    }

    @Override // s33.b
    public final q33.b o(com.bytedance.android.shopping.abscontainer.arch.core.lifecycle.b r100) {
        Intrinsics.checkNotNullParameter(r100, "info");
        if (com.bytedance.android.shopping.abscontainer.common_biz.helper.a.a(this.f540457a.f507250d.c(), null) == false) goto L7;
        return new q33.b(true, null);
    L7:
        if (this.f183138h == false) goto L60;
        String r101 = r100.f164136a;
        if (r101 != null) goto L11;
    L14:
        boolean r102 = true;
    L15:
        if (r102 == true) goto L58;
        Map<String, Object> r103 = r100.f164138c.q();
        if (r103 != null) goto L19;
    L22:
        boolean r104 = true;
    L23:
        if (r104 == true) goto L58;
        Map<String, Object> r105 = r100.f164138c.q();
        if (r105 == null) goto L28;
        Object r106 = r105.get("suffix_id");
    L29:
        String r107 = String.valueOf(r106);
        String r108 = r100.f164138c.k();
        StringBuilder r109 = new StringBuilder();
        r109.append(r108);
        r109.append('-');
        r109.append(r100.f164136a);
        r109.append('-');
        r109.append(r107);
        r109.append('-');
        Map<String, Object> r110 = r100.f164137b;
        if (r110 == null) goto L32;
        Object r111 = r110.get("level");
    L33:
        r109.append(r111);
        String r112 = r109.toString();
        String r113 = r100.f164136a;
        Object r114 = this.f540457a.f507250d.c().e("async_delay_list");
        if ((r114 instanceof List) == true) goto L36;
        r114 = null;
    L36:
        List r115 = (List) r114;
        if (r115 != null) goto L40;
        r115 = CollectionsKt.emptyList();
    L40:
        if (r115.contains(r113) == false) goto L46;
        String r116 = r100.f164136a;
        Map<String, Object> r117 = r100.f164137b;
        if (r117 != null) goto L44;
        r117 = MapsKt.emptyMap();
    L44:
        this.f183139i.put(r112, TuplesKt.to(r116, r117));
        return new q33.b(true, null);
    L46:
        if (Intrinsics.areEqual(this.f540457a.f507250d.c().e("async_two_stage"), 2) == false) goto L64;
        if (this.f183140j.contains(r112) == false) goto L51;
        return new q33.b(true, null);
    L51:
        if (this.f183139i.containsKey(r112) == false) goto L64;
        Map<String, ? extends Object> r118 = r100.f164137b;
        if (r118 != null) goto L55;
        r118 = MapsKt.emptyMap();
    L55:
        D(r112, r118);
        this.f183139i.remove(r112);
        this.f183140j.add(r112);
        return new q33.b(true, null);
    L64:
        return new q33.b(false, null);
    L32:
        r111 = null;
        goto L33
    L28:
        r106 = null;
        goto L29
    L19:
        if (r103.isEmpty() == true) goto L22;
        r104 = false;
    L58:
        return new q33.b(false, null);
    L11:
        if (r101.length() == 0) goto L14;
        r102 = false;
        goto L15
    L60:
        return new q33.b(false, null);
    }

    public final void D(String r100, Map<String, ? extends Object> r101) {
        Pair r102 = (Pair) ((LinkedHashMap) this.f183139i).get(r100);
        if (r102 == null) goto L6;
        Map r103 = MapsKt.toMutableMap((Map) r102.getSecond());
        r103.putAll(r101);
        this.f540457a.f507250d.a().a((String) r102.getFirst(), k.b(r103));
        Pair<String, Map<String, Object>> r104 = this.f183139i.remove(r100);
        return;
    }

    @Override // s33.b
    public final void g(com.bytedance.kmp.ec.yata.common.biz.callback.a r100, n33.c r101) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r101, "response");
        n33.a r102 = r101.f516914a;
        com.bytedance.android.shopping.abscontainer.arch.core.ability.impl.c r103 = this.f540457a.f507250d.a();
        Pair[] r104 = new Pair[3];
        r104[0] = TuplesKt.to("type", TradeCheckPoint$Node.EDIT_REQUEST_FAILED.getRawValue());
        r104[1] = TuplesKt.to(SocialConstants.PARAM_APP_DESC, this.f183133c);
        String r105 = r100.f251372c;
        if (r105 != null) goto L5;
        r105 = "";
    L5:
        r104[2] = TuplesKt.to("trigger_origin", r105);
        r103.a("trade_checkpoint", MapsKt.mapOf(r104));
    }

    @Override // s33.b
    public final void i(com.bytedance.kmp.ec.yata.common.biz.callback.a r100, n33.f r101) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r101, "response");
        com.bytedance.kmp.ec.yata.common.protocol.data.c r102 = r101.f516920b.g();
        Object r103 = null;
        if (r102 == null) goto L7;
        Map<String, Object> r104 = r102.g();
        if (r104 == null) goto L7;
        Object r105 = r104.get("tracker_common_params");
    L9:
        if ((r105 instanceof Map) == false) goto L12;
        r103 = r105;
    L12:
        Map<String, ? extends Object> r106 = (Map) r103;
        if (r106 != null) goto L15;
        r106 = MapsKt.emptyMap();
    L15:
        this.f540457a.f507250d.a().c(r106);
        com.bytedance.android.shopping.abscontainer.arch.core.ability.impl.c r107 = this.f540457a.f507250d.a();
        Pair[] r108 = new Pair[3];
        r108[0] = TuplesKt.to("type", TradeCheckPoint$Node.EDIT_REQUEST_SUCCESS.getRawValue());
        r108[1] = TuplesKt.to(SocialConstants.PARAM_APP_DESC, this.f183133c);
        String r109 = r100.f251372c;
        if (r109 != null) goto L18;
        r109 = "";
    L18:
        r108[2] = TuplesKt.to("trigger_origin", r109);
        r107.a("trade_checkpoint", MapsKt.mapOf(r108));
        return;
    L7:
        r105 = null;
        goto L9
    }

    @Override // s33.b
    public final q33.b m(String r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "params");
        Lazy r102 = TrackCatcher.f187025a;
        if (TrackCatcher.a.a() == null) goto L6;
        TrackCatcher.c("step_order", r100, "");
    L6:
        return new q33.b(false, null);
    }

    @Override // s33.b
    public final void q(int r100, int r101) {
        if (r100 > 0) goto L5;
        if (r101 > 0) goto L5;
        return;
    L5:
        if (this.f183136f == true) goto L9;
        this.f540457a.f507250d.a().a("order_submit_slide", MapsKt.emptyMap());
        this.f540457a.f507250d.a().c(MapsKt.mapOf(TuplesKt.to("open_status", "slide")));
        this.f183136f = true;
        return;
    }

    @Override // s33.b
    public final void t(z33.a r100, Map<String, ? extends View> r101) {
        Intrinsics.checkNotNullParameter(r101, "containerMap");
        if (this.f183135e.isEmpty() == true) goto L6;
        this.f183135e.pop();
        return;
    }

    @Override // s33.b
    public final void v(z33.a r100, Map<String, ? extends View> r101) {
        Intrinsics.checkNotNullParameter(r101, "containerMap");
        Object r102 = null;
        if (r100 == null) goto L7;
        Map<String, Object> r103 = r100.e();
        if (r103 == null) goto L7;
        Object r104 = r103.get("popup_code");
    L9:
        if ((r104 instanceof String) == false) goto L12;
        r102 = r104;
    L12:
        String r105 = (String) r102;
        if (r105 == null) goto L16;
        String r106 = this.f183135e.push(r105);
        return;
    L16:
        return;
    L7:
        r104 = null;
        goto L9
    }

    public static void B(Map r110, Map r111, Map r112) {
        Iterator r113 = r112.entrySet().iterator();
    L4:
        if (r113.hasNext() == false) goto L69;
        Map.Entry r100 = (Map.Entry) r113.next();
        Object r101 = r111.get(r100.getKey());
        if (r101 != null) goto L7;
        r110.put(r100.getKey(), r100.getValue());
        goto L4
    L7:
        Object r102 = null;
        if ((r101 instanceof Map) == true) goto L10;
        Object r103 = null;
    L12:
        if (((Map) r103) != null) goto L13;
        if ((r101 instanceof List) == true) goto L28;
        Object r104 = null;
    L30:
        if (((List) r104) != null) goto L31;
        r110.put(r100.getKey(), r100.getValue());
        goto L4
    L31:
        List r105 = CollectionsKt.toMutableList((Collection) r101);
        Object r106 = r100.getValue();
        if ((r106 instanceof List) == true) goto L35;
        r106 = null;
    L35:
        if (((List) r106) != null) goto L36;
        r110.put(r100.getKey(), r100.getValue());
        goto L4
    L36:
        Object r107 = r100.getValue();
        if (r107 == null) goto L65;
        Iterator r108 = ((List) r107).iterator();
        int r109 = 0;
    L40:
        if (r108.hasNext() == false) goto L63;
        Object r114 = r108.next();
        int r115 = r109 + 1;
        if (r109 >= 0) goto L44;
        CollectionsKt.throwIndexOverflow();
    L44:
        List r116 = (List) r101;
        if (r116.size() > r109) goto L47;
        r105.add(r114);
    L62:
        r109 = r115;
        goto L40
    L47:
        if ((r114 instanceof Map) == true) goto L49;
        Object r117 = null;
    L51:
        if (((Map) r117) == null) goto L60;
        Object r118 = CollectionsKt.getOrNull(r116, r109);
        if ((r118 instanceof Map) == true) goto L55;
        Object r119 = null;
    L57:
        if (((Map) r119) == null) goto L59;
        Map r120 = (Map) r118;
        Map r121 = MapsKt.toMutableMap(r120);
        B(r121, r120, (Map) r114);
        ListProtector.set(r105, r109, r121);
        goto L62
    L59:
        ListProtector.set(r105, r109, r114);
        goto L62
    L55:
        r119 = r118;
        goto L57
    L60:
        ListProtector.set(r105, r109, r114);
        goto L62
    L49:
        r117 = r114;
        goto L51
    L63:
        r110.put(r100.getKey(), r105);
        goto L4
    L65:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
    L28:
        r104 = r101;
        goto L30
    L13:
        Object r122 = r100.getValue();
        if ((r122 instanceof Map) == false) goto L18;
        r102 = r122;
    L18:
        if (((Map) r102) != null) goto L19;
        r110.put(r100.getKey(), r100.getValue());
        goto L4
    L19:
        Map r123 = (Map) r101;
        Map r124 = MapsKt.toMutableMap(r123);
        Object r125 = r100.getValue();
        if (r125 == null) goto L23;
        B(r124, r123, (Map) r125);
        r110.put(r100.getKey(), r124);
        goto L4
    L23:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any>");
    L10:
        r103 = r101;
        goto L12
    }
}
