package com.bytedance.android.shopping.widget.buybutton;

import android.net.Uri;
import com.bytedance.android.ec.common.api.IECCommonService;
import com.bytedance.android.ec.core.buynow.BuyNowPerformanceOpt;
import com.bytedance.android.ec.core.monitor.MetricNames;
import com.bytedance.android.ec.core.monitor.MonitorScenes;
import com.bytedance.android.ec.core.utils.k2;
import com.bytedance.android.ec.core.utils.p0;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.model.ButtonType;
import com.bytedance.android.ec.model.ClickButtonParam;
import com.bytedance.android.ec.model.SingleClickParam;
import com.bytedance.android.ec.model.response.anchorv3.PromotionDiscountLabel;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductLink;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ecom.bcm.track.api.EcomBcmTracker;
import com.bytedance.android.shopping.utils.p;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jd3.b0;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class e {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final /* synthetic */ int f187274u = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f187275a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f187276b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f187277c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f187278d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f187279e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f187280f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f187281g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f187282h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f187283i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f187284j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f187285k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f187286l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f187287m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f187288n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f187289o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f187290p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final String f187291q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final String f187292r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final List<PromotionDiscountLabel> f187293s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final List<k> f187294t;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L46;
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f187275a, r101.f187275a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f187276b, r101.f187276b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f187277c, r101.f187277c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f187278d, r101.f187278d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f187279e, r101.f187279e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f187280f, r101.f187280f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f187281g, r101.f187281g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f187282h, r101.f187282h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f187283i, r101.f187283i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f187284j, r101.f187284j) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.f187285k, r101.f187285k) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.f187286l, r101.f187286l) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f187287m, r101.f187287m) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.f187288n, r101.f187288n) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.f187289o, r101.f187289o) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f187290p, r101.f187290p) == true) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.f187291q, r101.f187291q) == true) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.f187292r, r101.f187292r) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f187293s, r101.f187293s) == true) goto L44;
        return false;
    L44:
        if (Intrinsics.areEqual(this.f187294t, r101.f187294t) == true) goto L70;
        return false;
    L70:
        return true;
    L46:
        return false;
    }

    public final int hashCode() {
        d r100 = this.f187275a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f187276b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f187277c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f187278d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f187279e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f187280f;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.f187281g;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.f187282h;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.f187283i;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.f187284j;
        if (r128 == null) goto L41;
        int r129 = r128.hashCode();
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.f187285k;
        if (r131 == null) goto L45;
        int r132 = r131.hashCode();
    L46:
        int r133 = (r130 + r132) * 31;
        String r134 = this.f187286l;
        if (r134 == null) goto L49;
        int r135 = r134.hashCode();
    L50:
        int r136 = (r133 + r135) * 31;
        String r137 = this.f187287m;
        if (r137 == null) goto L53;
        int r138 = r137.hashCode();
    L54:
        int r139 = (r136 + r138) * 31;
        String r140 = this.f187288n;
        if (r140 == null) goto L57;
        int r141 = r140.hashCode();
    L58:
        int r142 = (r139 + r141) * 31;
        String r143 = this.f187289o;
        if (r143 == null) goto L61;
        int r144 = r143.hashCode();
    L62:
        int r145 = (r142 + r144) * 31;
        String r146 = this.f187290p;
        if (r146 == null) goto L65;
        int r147 = r146.hashCode();
    L66:
        int r148 = (r145 + r147) * 31;
        String r149 = this.f187291q;
        if (r149 == null) goto L69;
        int r150 = r149.hashCode();
    L70:
        int r151 = (r148 + r150) * 31;
        String r152 = this.f187292r;
        if (r152 == null) goto L73;
        int r153 = r152.hashCode();
    L74:
        int r154 = (r151 + r153) * 31;
        List<PromotionDiscountLabel> r155 = this.f187293s;
        if (r155 == null) goto L77;
        int r156 = r155.hashCode();
    L78:
        int r157 = (r154 + r156) * 31;
        List<k> r158 = this.f187294t;
        if (r158 == null) goto L82;
        r101 = r158.hashCode();
    L82:
        return r157 + r101;
    L77:
        r156 = 0;
        goto L78
    L73:
        r153 = 0;
        goto L74
    L69:
        r150 = 0;
        goto L70
    L65:
        r147 = 0;
        goto L66
    L61:
        r144 = 0;
        goto L62
    L57:
        r141 = 0;
        goto L58
    L53:
        r138 = 0;
        goto L54
    L49:
        r135 = 0;
        goto L50
    L45:
        r132 = 0;
        goto L46
    L41:
        r129 = 0;
        goto L42
    L37:
        r126 = 0;
        goto L38
    L33:
        r123 = 0;
        goto L34
    L29:
        r120 = 0;
        goto L30
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ShoppingPurchaseButtonModel(presenter=" + this.f187275a + ", name=" + this.f187276b + ", schema=" + this.f187277c + ", productId=" + this.f187278d + ", promotionId=" + this.f187279e + ", shopId=" + this.f187280f + ", authorId=" + this.f187281g + ", secAuthorId=" + this.f187282h + ", groupId=" + this.f187283i + ", marketingChannel=" + this.f187284j + ", roomId=" + this.f187285k + ", itemId=" + this.f187286l + ", metaParams=" + this.f187287m + ", entranceInfo=" + this.f187288n + ", promotionSource=" + this.f187289o + ", enterFrom=" + this.f187290p + ", logExtra=" + this.f187291q + ", trackAdditions=" + this.f187292r + ", discountLabels=" + this.f187293s + ", buttonModelList=" + this.f187294t + ")";
    }

    public static Map b(String r100) {
        if (r100 != null) goto L4;
    L14:
        JSONObject r101 = new JSONObject();
    L15:
        LinkedHashMap r102 = new LinkedHashMap();
        Iterator<String> r103 = r101.keys();
    L17:
        if (r103.hasNext() == false) goto L19;
        String r104 = r103.next();
        r102.put(r104, r101.optString(r104));
        goto L17
    L19:
        return r102;
    L4:
        if (r100.length() <= 0) goto L6;
        boolean r105 = true;
    L7:
        if (r105 == true) goto L10;
        r100 = null;
    L10:
        if (r100 == null) goto L14;
        r101 = new JSONObject(r100);     // Catch: JSONException -> L13
    L13:
        r101 = new JSONObject();
        goto L15
    L6:
        r105 = false;
        goto L7
    }

    public static String a(int r210, ClickButtonParam r211) {
        Intrinsics.checkNotNullParameter(r211, "param");
        SingleClickParam r100 = (SingleClickParam) CollectionsKt.getOrNull(r211.getSingleClickParams(), r210);
        if (r100 == null) goto L7;
        PromotionProductLink r101 = r100.getLinks();
        if (r101 == null) goto L7;
        String r110 = r101.getH5Url();
    L8:
        SingleClickParam r102 = (SingleClickParam) CollectionsKt.getOrNull(r211.getSingleClickParams(), r210);
        if (r102 == null) goto L13;
        ButtonType r103 = r102.getButtonType();
        if (r103 == null) goto L13;
        Boolean r104 = Boolean.valueOf(com.bytedance.android.ec.model.b.a(r103));
    L15:
        if (Intrinsics.areEqual(r104, Boolean.TRUE) == false) goto L19;
        Uri.Builder r105 = UriProtector.parse(r110).buildUpon();
        JSONObject r106 = new JSONObject();
        r106.put(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO, EcomBcmTracker.b(null, r211.getEntranceInfo()));
        Unit r107 = Unit.INSTANCE;
        r105.appendQueryParameter("mega_object", r106.toString());
        return r105.build().toString();
    L19:
        if (r110 == null) goto L119;
        int r108 = ECSdk.f48106a;
        IECCommonService r109 = (IECCommonService) ECSdk.a(IECCommonService.class);
        if (r109 == null) goto L26;
        mf.a r111 = r109.getOpenOrderSchemaHelper(m.class, ShoppingPurchaseButtonModel$buildNewOrderSchema$1.INSTANCE);
        if (r111 == null) goto L26;
        String r112 = r111.a(r110, new nl.e(null, null, null, false, null, r210, r211, null, 415));
        if (r112 == null) goto L26;
    L27:
        Map<String, com.bytedance.android.ec.core.monitor.a> r113 = com.bytedance.android.ec.core.monitor.c.f45142a;
        String r114 = com.bytedance.android.ec.core.monitor.c.c(MonitorScenes.EC_JSON_DEAL_DURATION, null);
        com.bytedance.android.ec.core.monitor.c.e(r114, "type", com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO);
        com.bytedance.android.ec.core.monitor.c.e(r114, "scene", "video");
        com.bytedance.android.ec.core.monitor.c.f(r114, "url", r110);
        com.bytedance.android.ec.core.monitor.c.h(r114, MetricNames.DEAL_DURATION, null);
        Intrinsics.checkNotNullParameter(r211, "param");
        JSONObject r115 = new JSONObject(r211.getEntranceInfo());
        SingleClickParam r116 = com.bytedance.android.ec.model.c.a(r211, r210);
        r115.put(com.bytedance.android.ec.core.event.a.KEY_THREE_D, r211.getEnterFrom());
        r115.put(com.bytedance.android.ec.core.event.a.KEY_AUTO_APPLY_COUPON, r116.getApplyCoupon() ? 1 : 0);
        r115.put("coupon_id", r116.getApplyCouponIds());
        if (r116.getNeedCheckSku() == false) goto L30;
        Object r117 = "1";
    L31:
        r115.put(com.bytedance.android.ec.core.event.a.KEY_WITH_SKU, r117);
        r115.put(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_ID, r211.getPromotionId());
        r115.put(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_TYPE, r211.getPromotionSource());
        r115.put("product_id", r211.getProductId());
        ButtonType r118 = r116.getButtonType();
        Intrinsics.checkNotNullParameter(r118, "$this$isSecKillProduct");
        String r119 = r112;
        boolean r120 = false;
        if (r118 != ButtonType.Seckill) goto L34;
        boolean r121 = true;
    L35:
        if (r121 == true) goto L37;
        Object r122 = null;
    L41:
        r115.put(com.bytedance.android.ec.core.event.a.KEY_PRODUCT_ACTIVITY_TYPE, r122);
        Intrinsics.checkNotNullParameter(r211, "param");
        SingleClickParam r123 = com.bytedance.android.ec.model.c.a(r211, r210);
        JSONObject r124 = new JSONObject();
        r124.put(com.bytedance.android.ec.core.event.a.KEY_AUTO_APPLY_COUPON, r123.getApplyCoupon() ? 1 : 0);
        r124.put("coupon_id", r123.getApplyCouponIds());
        List<PromotionDiscountLabel> r125 = r211.getDiscountLabels();
        if (r125 != null) goto L44;
    L55:
        Object r126 = null;
    L56:
        r124.put(com.bytedance.android.ec.core.event.a.KEY_CASH_REBATE, r126);
        if (r123.getNeedCheckSku() == false) goto L59;
        Object r127 = "1";
    L60:
        r124.put(com.bytedance.android.ec.core.event.a.KEY_WITH_SKU, r127);
        ButtonType r128 = r123.getButtonType();
        Intrinsics.checkNotNullParameter(r128, "$this$isGroupBuy");
        if (r128 != ButtonType.GroupBuy) goto L63;
        boolean r129 = true;
    L64:
        if (r129 == false) goto L66;
        Object r130 = "1";
    L67:
        r124.put(com.bytedance.android.ec.core.event.a.KEY_IS_GROUP_BUYING, r130);
        r124.put(com.bytedance.android.ec.core.event.a.KEY_IS_EXPLAIN_APPLY, z1.f(r211.getEntranceInfo()).optString(com.bytedance.android.ec.core.event.a.KEY_IS_EXPLAIN_APPLY, "0"));
        r124.put("author_id", r211.getAuthorId());
        r124.put("item_id", r211.getItemId());
        List<PromotionDiscountLabel> r131 = r211.getDiscountLabels();
        StringBuilder r132 = new StringBuilder();
        if (r131 == null) goto L78;
        Iterator<T> r133 = r131.iterator();
    L71:
        if (r133.hasNext() == false) goto L78;
        PromotionDiscountLabel r134 = (PromotionDiscountLabel) r133.next();
        if (r134.getType() != 1) goto L71;
        if (r134.getId() == null) goto L71;
        r132.append(Intrinsics.stringPlus(r134.getId(), ","));
    L78:
        if (r132.length() != 0) goto L80;
        boolean r135 = true;
    L81:
        if (r135 == false) goto L83;
        String r136 = r132.toString();
    L84:
        r124.put("coupon_id", r136);
        if (BuyNowPerformanceOpt.j() == true) goto L87;
        JSONObject r137 = new JSONObject();
        r137.put(com.bytedance.android.ec.core.event.a.KEY_BIOMETRIC_PARAMS, "1");
        int r138 = p.f187156a;
        r137.put(com.bytedance.android.ec.core.event.a.KEY_IS_JAILBREAK, "2");
        r137.put(com.bytedance.android.ec.core.event.a.KEY_CJ_SDK, p.b());
        r137.put(com.bytedance.android.ec.core.event.a.KEY_BIO_TYPE, "1");
    L89:
        if (UriProtector.getQueryParameter(UriProtector.parse(r110), com.bytedance.android.ec.core.event.a.KEY_RIFLE_MEGA_OBJECT) == null) goto L91;
        boolean r212 = true;
    L92:
        int r139 = p0.f45664a;
        String r140 = p0.g(p0.g(r110, com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO, r115.toString()), "log_data", r124.toString());
        if (r137 == null) goto L95;
        String r141 = p0.g(r140, com.bytedance.android.ec.core.event.a.KEY_CJ_INFO, r137.toString());
    L96:
        Map<String, com.bytedance.android.ec.core.monitor.a> r142 = com.bytedance.android.ec.core.monitor.c.f45142a;
        com.bytedance.android.ec.core.monitor.c.j(r114, MetricNames.DEAL_DURATION);
        com.bytedance.android.ec.core.monitor.c.d(r114);
        String r213 = r115.toString();
        String r143 = r211.getGroupId();
        if (r143 == null) goto L99;
        Long r214 = StringsKt.toLongOrNull(r143);
    L100:
        String r144 = com.bytedance.android.shopping.anchorv3.utils.k.a(r141, null, null, r213, r214, r212);
        String r145 = k2.a(r144, null);
        if (r145 == null) goto L104;
        r144 = r145;
    L104:
        String r146 = r211.getMarketingChannel();
        if (r146 != null) goto L107;
        r146 = "";
    L107:
        String r147 = p0.d(r144, com.bytedance.android.ec.core.event.a.KEY_MARKET_CHANNEL, r146);
        int r148 = com.bytedance.android.shopping.anchorv3.track.b.f165294a;
        b0 r149 = new b0();
        r149.f498266a = r119;
        r149.f498267b = r147;
        r149.f498268c = "3d";
        r149.post(null, null);
        if (zg.a.a() == 1) goto L110;
    L115:
        if (r120 == true) goto L118;
        return r147;
    L118:
        return r119;
    L110:
        if (r119.length() <= 0) goto L112;
        boolean r150 = true;
    L113:
        if (r150 == false) goto L115;
        r120 = true;
        goto L115
    L112:
        r150 = false;
        goto L113
    L99:
        r214 = null;
        goto L100
    L95:
        r141 = r140;
        goto L96
    L91:
        r212 = false;
        goto L92
    L87:
        r137 = null;
        goto L89
    L83:
        r136 = r132.substring(0, r132.length() - 1);
        goto L84
    L80:
        r135 = false;
        goto L81
    L66:
        r130 = "0";
        goto L67
    L63:
        r129 = false;
        goto L64
    L59:
        r127 = "0";
        goto L60
    L44:
        if ((!r125.isEmpty()) == true) goto L47;
        r125 = null;
    L47:
        if (r125 == null) goto L55;
        int r151 = ((PromotionDiscountLabel) ListProtector.get(r125, 0)).getType();
        if (r151 != 2) goto L51;
        r126 = "1";
        goto L56
    L51:
        if (r151 == 3) goto L53;
        r126 = "0";
        goto L56
    L53:
        r126 = "2";
        goto L56
    L37:
        if (r116.isInSecKillActivity() == false) goto L39;
        r122 = "seckill";
        goto L41
    L39:
        r122 = com.bytedance.android.ec.core.event.a.VALUE_PRE_SECKILL;
        goto L41
    L34:
        r121 = false;
        goto L35
    L30:
        r117 = "0";
    L26:
        r112 = "";
        goto L27
    L119:
        return "";
    L13:
        r104 = null;
    L7:
        r110 = null;
        goto L8
    }

    public e(d r110, String r111, String r112, String r113, String r114, String r115, String r116, String r117, String r118, String r210, String r211, String r212, String r213, String r214, String r215, String r216, String r217, String r218, List<PromotionDiscountLabel> r219, List<k> r310) {
        Intrinsics.checkNotNullParameter(r110, "presenter");
        Intrinsics.checkNotNullParameter(r113, "productId");
        Intrinsics.checkNotNullParameter(r114, "promotionId");
        Intrinsics.checkNotNullParameter(r115, "shopId");
        Intrinsics.checkNotNullParameter(r116, "authorId");
        Intrinsics.checkNotNullParameter(r117, "secAuthorId");
        Intrinsics.checkNotNullParameter(r210, "marketingChannel");
        Intrinsics.checkNotNullParameter(r310, "buttonModelList");
        this.f187275a = r110;
        this.f187276b = r111;
        this.f187277c = r112;
        this.f187278d = r113;
        this.f187279e = r114;
        this.f187280f = r115;
        this.f187281g = r116;
        this.f187282h = r117;
        this.f187283i = r118;
        this.f187284j = r210;
        this.f187285k = r211;
        this.f187286l = r212;
        this.f187287m = r213;
        this.f187288n = r214;
        this.f187289o = r215;
        this.f187290p = r216;
        this.f187291q = r217;
        this.f187292r = r218;
        this.f187293s = r219;
        this.f187294t = r310;
    }
}
