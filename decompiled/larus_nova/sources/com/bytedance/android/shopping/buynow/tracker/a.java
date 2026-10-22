package com.bytedance.android.shopping.buynow.tracker;

import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.model.sku.DefaultSelect;
import com.bytedance.android.ec.model.sku.SkuParams;
import com.bytedance.android.shopping.api.ultimate.UltimateBuyParams;
import com.bytedance.android.shopping.base.event.EventActionImpl;
import com.bytedance.android.shopping.buynow.data.model.CheckPointType;
import com.bytedance.android.shopping.buynow.data.model.PageType;
import com.bytedance.android.shopping.buynow.viewmodel.BuyNowViewModel;
import com.bytedance.android.shopping.buynow.viewmodel.b;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.track.TrackCatcher;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.retrofit2.mime.TypedInput;
import com.ss.ugc.effectplatform.bridge.network.NetResponse;
import com.tencent.open.SocialConstants;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import nl.c;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f171170i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f171171a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile long f171172b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile long f171173c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final EventActionImpl f171174d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Set<String> f171175e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f171176f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<String> f171177g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final BuyNowViewModel f171178h;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.buynow.tracker.a$a, reason: collision with other inner class name */
    public static final class C2568a {
        @JvmStatic
        public static Map a(String r100, boolean r101, boolean r110, c r111, UltimateBuyParams r112) {
            int r102 = ja3.a.f497848a;
            String r103 = null;
            if (r111 == null) goto L5;
            String r104 = r111.getQueryParam("scene_type");
        L7:
            if ((r104 instanceof String) == true) goto L9;
            r104 = null;
        L9:
            Pair[] r105 = new Pair[17];
            r105[0] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_EVENT_ORIGIN_FEATURE, com.bytedance.android.ec.core.event.a.VALUE_TEMAI);
            r105[1] = TuplesKt.to("EVENT_PAGE_TECHNOLOGY", "YATA_Android");
            int r106 = com.bytedance.android.shopping.buynow.utils.c.f171206a;
            if (r110 == false) goto L12;
            String r107 = PageType.CONTINUEPAY;
        L13:
            r105[2] = TuplesKt.to("btm", com.bytedance.android.shopping.buynow.utils.c.a(r107));
            if (r110 == false) goto L16;
            String r113 = "pay_pad";
        L17:
            r105[3] = TuplesKt.to("page_name", r113);
            r105[4] = TuplesKt.to("log_id", r100);
            String r114 = "0";
            if (r101 == false) goto L20;
            Object r108 = "1";
        L21:
            r105[5] = TuplesKt.to("page_scene", r108);
            r105[6] = TuplesKt.to("params_for_special", com.bytedance.android.ec.core.event.a.VALUE_PARAMS_FOR_SPECIAL);
            if (r111 == null) goto L24;
            String r109 = r111.getQueryParam(com.bytedance.android.ec.core.event.a.KEY_NEW_SOURCE_TYPE);
        L26:
            if ((r109 instanceof String) == true) goto L28;
            r109 = null;
        L28:
            if (r109 == null) goto L31;
            r114 = r109;
        L31:
            r105[7] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_NEW_SOURCE_TYPE, r114);
            if (r111 == null) goto L34;
            String r115 = r111.getQueryParam("is_cart_order");
        L36:
            if (Intrinsics.areEqual(r115, "1") == false) goto L38;
            String r116 = "105";
        L39:
            r105[8] = TuplesKt.to("area_type", r116);
            if (ja3.a.c(r111) == true) goto L44;
            if (r101 == true) goto L44;
            String r117 = "full_screen";
        L45:
            r105[9] = TuplesKt.to("page_type", r117);
            String r118 = "";
            if (r101 == false) goto L61;
            if (r112 != null) goto L49;
        L50:
            if (r112 == null) goto L55;
            SkuParams r119 = r112.getSkuParams();
            if (r119 == null) goto L55;
            String r120 = r119.getProductId();
            if (r120 == null) goto L55;
        L66:
            r105[10] = TuplesKt.to("product_id", r120);
            if (r101 == false) goto L81;
            if (r112 != null) goto L70;
        L71:
            if (r112 == null) goto L76;
            SkuParams r121 = r112.getSkuParams();
            if (r121 == null) goto L76;
            String r122 = r121.getShopId();
            if (r122 == null) goto L76;
        L86:
            r105[11] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_SHOP_ID, r122);
            if (r101 == false) goto L106;
            if (r112 != null) goto L90;
        L91:
            if (r112 == null) goto L98;
            SkuParams r123 = r112.getSkuParams();
            if (r123 == null) goto L98;
            DefaultSelect r124 = r123.getDefaultSelect();
            if (r124 == null) goto L98;
            String r125 = r124.getLastSelectedSkuId();
            if (r125 == null) goto L98;
        L116:
            r105[12] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_SKU_ID, r125);
            if (r111 == null) goto L123;
            String r126 = r111.getQueryParam("eztf_sdk_extra");
            if (r126 == null) goto L123;
            JSONObject r127 = k.w(r126);
            if (r127 == null) goto L123;
            Object r128 = r127.get("source_page");
        L125:
            if ((r128 instanceof String) == true) goto L127;
            r128 = null;
        L127:
            r105[13] = TuplesKt.to("eztf_source_page", (String) r128);
            r105[14] = TuplesKt.to("gecko_channel_version", Long.valueOf(wh.a.a("ecom_buynow_card_template")));
            if (r101 == true) goto L130;
        L138:
            Integer r129 = null;
        L139:
            r105[15] = TuplesKt.to("arch_opt", r129);
            if (r111 == null) goto L142;
            r103 = r111.getQueryParam("check_optimize");
        L142:
            r105[16] = TuplesKt.to("check_optimize", r103);
            return MapsKt.mapOf(r105);
        L130:
            if (Intrinsics.areEqual(r104, "101") == false) goto L132;
        L137:
            r129 = 3;
            goto L139
        L132:
            if (Intrinsics.areEqual(r104, BDLocationException.ERROR_UID_IS_EMPTY) == true) goto L137;
            if (Intrinsics.areEqual(r104, "105") == true) goto L137;
            if (Intrinsics.areEqual(r104, BDLocationException.ERROR_BLUETOOTh_NOT_AVAILABLE) == false) goto L138;
        L123:
            r128 = null;
        L98:
            if (r111 == null) goto L100;
            String r130 = r111.getQueryParam(com.bytedance.android.ec.core.event.a.KEY_COMBO_ID);
        L102:
            if ((r130 instanceof String) == true) goto L104;
            r130 = null;
        L104:
            if (r130 == null) goto L115;
        L114:
            r118 = r130;
        L115:
            r125 = r118;
            goto L116
        L100:
            r130 = null;
            goto L102
        L90:
            if (r112.isSingleSku() != 1) goto L91;
        L106:
            if (r111 == null) goto L108;
            r130 = r111.getQueryParam(com.bytedance.android.ec.core.event.a.KEY_COMBO_ID);
        L110:
            if ((r130 instanceof String) == true) goto L112;
            r130 = null;
        L112:
            if (r130 != null) goto L114;
        L108:
            r130 = null;
        L76:
            if (r111 == null) goto L78;
            r122 = r111.getQueryParam(com.bytedance.android.ec.core.event.a.KEY_SHOP_ID);
        L79:
            if (r122 != null) goto L86;
        L80:
            r122 = "";
            goto L86
        L78:
            r122 = null;
            goto L79
        L70:
            if (r112.isSingleSku() != 1) goto L71;
        L81:
            if (r111 == null) goto L83;
            r122 = r111.getQueryParam(com.bytedance.android.ec.core.event.a.KEY_SHOP_ID);
        L84:
            if (r122 != null) goto L86;
        L83:
            r122 = null;
        L55:
            if (r111 == null) goto L57;
            String r131 = r111.getQueryParam("id");
        L58:
            if (r131 != null) goto L60;
        L59:
            r120 = "";
        L60:
            r120 = r131;
            goto L66
        L57:
            r131 = null;
            goto L58
        L49:
            if (r112.isSingleSku() != 1) goto L50;
        L61:
            if (r111 == null) goto L63;
            r131 = r111.getQueryParam("id");
        L64:
            if (r131 != null) goto L60;
        L63:
            r131 = null;
        L44:
            r117 = "half_screen";
            goto L45
        L38:
            r116 = "169";
            goto L39
        L34:
            r115 = null;
            goto L36
        L24:
            r109 = null;
            goto L26
        L20:
            r108 = "0";
            goto L21
        L16:
            r113 = "submit_orders";
            goto L17
        L12:
            r107 = PageType.BUYNOW;
            goto L13
        L5:
            r104 = null;
            goto L7
        }
    }

    static {
    }

    public final Map<String, Object> d() {
        Map<String, Object> r100 = MapsKt.toMutableMap(this.f171174d.c());
        r100.putAll(this.f171171a);
        return r100;
    }

    public a(BuyNowViewModel r100) {
        Intrinsics.checkNotNullParameter(r100, "viewModel");
        this.f171178h = r100;
        this.f171171a = new LinkedHashMap();
        this.f171174d = new EventActionImpl();
        this.f171175e = new LinkedHashSet();
        this.f171177g = CollectionsKt.listOf(new String[]{"a1.b2298.c0.d0", "a1.b4943.c0.d0", "a1.b31.c0.d0", "a1.b32.c0.d0", "a1.b6871.c0.d0"});
    }

    public static Map e(SsResponse r110) {
        LinkedHashMap r100 = new LinkedHashMap();
        Iterator<T> r101 = r110.raw().getHeaders().iterator();
    L4:
        if (r101.hasNext() == false) goto L11;
        Header r102 = (Header) r101.next();
        if (Intrinsics.areEqual(r102.getName(), NetResponse.HEADER_KEY_LOG_ID) == true) goto L7;
        if (Intrinsics.areEqual(r102.getName(), "content-length") == false) goto L4;
        r100.put("content_length", r102.getValue());
        goto L4
    L7:
        r100.put("log_id", r102.getValue());
        goto L4
    L11:
        TypedInput r111 = r110.raw().getBody();
        if ((r111 instanceof TypedByteArray) == true) goto L14;
        r111 = null;
    L14:
        TypedByteArray r112 = (TypedByteArray) r111;
        if (r112 == null) goto L19;
        byte[] r113 = r112.getBytes();
        if (r113 == null) goto L19;
        r100.put("content_body", ArraysKt.joinToString$default(Arrays.copyOf(r113, RangesKt.coerceAtMost(r113.length, 200)), ",", null, null, 0, null, null, 62, null));
    L19:
        return r100;
    }

    public final void a(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "customParams");
        this.f171174d.appendEventParams(r100);
    }

    public final void f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "triggerOrigin");
        b("trade_checkpoint", MapsKt.mapOf(new Pair[]{TuplesKt.to("type", CheckPointType.CHECK_ORDER_START), TuplesKt.to("trigger_origin", r100)}));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void i(boolean r100) {
        BtmSDK r101 = BtmSDK.INSTANCE;
        int r102 = com.bytedance.android.shopping.buynow.utils.c.f171206a;
        Boolean r103 = null;
        r101.willJumpToNextPage(new BtmItemBuilder(com.bytedance.android.shopping.buynow.utils.c.a(this.f171178h.getStaticState().f171233g), r103, 2, 0 == true ? 1 : 0).withPageFinder(this.f171178h.getStaticState().f171230d).setTargetPagesBtm(this.f171177g).build());
        if (r100 == false) goto L5;
        String r104 = "order_pay_success";
    L7:
        if (this.f171178h.getStaticState().b() == false) goto L9;
        String r105 = "a1.b25587.c5642.d1959";
    L10:
        b(r104, MapsKt.mapOf(TuplesKt.to("btm", r105)));
        if (this.f171178h.getStaticState().b() == false) goto L15;
        if (r100 == false) goto L16;
        b("WALLET_CASHIER_PAY_FINISH_PAGE_IMP", MapsKt.emptyMap());
        b("order_submit_success", MapsKt.emptyMap());
        return;
    L16:
        return;
    L15:
        return;
    L9:
        r105 = "c5642.d1959";
        goto L10
    L5:
        r104 = "order_pay_fail";
        goto L7
    }

    public final void b(String r100, Map<String, ? extends Object> r110) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r110, "params");
        if (this.f171178h.getStaticState().c() == false) goto L8;
        Lazy r101 = TrackCatcher.f187025a;
        if (TrackCatcher.a.a() == null) goto L12;
        TrackCatcher.c("step_order", r100, String.valueOf(r110.get("btm")));
    L12:
        EventActionImpl r102 = this.f171174d;
        PageFinder r103 = this.f171178h.getStaticState().f171230d;
        LinkedHashMap r104 = new LinkedHashMap();
        r104.putAll(this.f171171a);
        r104.putAll(r110);
        if (this.f171178h.getStaticState().c() == true) goto L16;
    L21:
        Unit r111 = Unit.INSTANCE;
        r102.doEventAction(r100, r103, r104);
        return;
    L16:
        if (Intrinsics.areEqual(r100, "sku_action") == false) goto L19;
        r104.put("sku_action_index", String.valueOf(this.f171172b));
        this.f171172b++;
        goto L21
    L19:
        if (Intrinsics.areEqual(r100, "sku_content_show") == false) goto L21;
        r104.put("sku_action_index", String.valueOf(this.f171173c));
        this.f171173c++;
        goto L21
    L8:
        if (this.f171178h.getStaticState().a() == false) goto L12;
        Lazy r105 = TrackCatcher.f187025a;
        if (TrackCatcher.a.a() == null) goto L12;
        TrackCatcher.c("normal_order", r100, String.valueOf(r110.get("btm")));
        goto L12
    }

    public final void c(String r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "params");
        if (this.f171175e.contains(r100) == true) goto L6;
        b(r100, r101);
        this.f171175e.add(r100);
        return;
    }

    public final void g(String r100, String r101) {
        Pair[] r102 = new Pair[3];
        int r103 = com.bytedance.android.shopping.buynow.utils.c.f171206a;
        String r104 = this.f171178h.getStaticState().f171233g;
        Intrinsics.checkNotNullParameter(r104, "pageType");
        if (r104.equals(PageType.CONTINUEPAY) == false) goto L5;
        String r105 = "a1.b25587.c0.d0";
    L6:
        r102[0] = TuplesKt.to("btm", r105);
        r102[1] = TuplesKt.to("button_name", r100);
        r102[2] = TuplesKt.to("button_action", r101);
        b("ecom_module_click", MapsKt.mapOf(r102));
        return;
    L5:
        r105 = "a1.b7411.c10310.d309439";
        goto L6
    }

    public final void h(Integer r100, String r101) {
        b("trade_checkpoint", MapsKt.mapOf(new Pair[]{TuplesKt.to("type", CheckPointType.ORDER_REQUEST_FAILED), TuplesKt.to(SocialConstants.PARAM_APP_DESC, b.a(this.f171178h.getStaticState())), TuplesKt.to("code", r100), TuplesKt.to("message", r101)}));
    }

    public final void k(String r100, Map<String, Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "params");
        r101.put("type", r100);
        b("trade_checkpoint", r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void j(String r100, String r101, Boolean r102) {
        Intrinsics.checkNotNullParameter(r101, "pageType");
        if ((!Intrinsics.areEqual(r102, Boolean.TRUE)) == false) goto L6;
        BtmSDK.INSTANCE.willJumpToNextPage(new BtmItemBuilder(com.bytedance.android.shopping.buynow.utils.c.a(r101), null, 2, 0 == true ? 1 : 0).withPageFinder(this.f171178h.getStaticState().f171230d).setTargetPagesBtm(CollectionsKt.listOf(new String[]{"a1.b2298", "a1.b4943", "a1.b31", "a1.b32"})).build());
        b("validate_rule_check_fail", MapsKt.mapOf(TuplesKt.to("fail_reason", k.j(r100))));
        JSONObject r103 = new JSONObject();
        r103.put("message", r100);
        r103.put("error_type", 2);
        r103.put("type", "ORDER_SUBMIT_ERROR");
        Unit r104 = Unit.INSTANCE;
        b("ies_ecommerce_fe_custom_log", MapsKt.mapOf(TuplesKt.to("detail", r103)));
        return;
    }
}
