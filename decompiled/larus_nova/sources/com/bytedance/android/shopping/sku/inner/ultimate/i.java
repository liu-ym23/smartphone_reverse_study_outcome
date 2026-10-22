package com.bytedance.android.shopping.sku.inner.ultimate;

import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.standard.home.BaseStandardHomeFragment;
import com.bytedance.android.ec.core.buynow.BuyNowPerformanceOpt;
import com.bytedance.android.ec.core.hybrid.utils.k;
import com.bytedance.android.ec.core.sku.SkuPerformanceOpt;
import com.bytedance.android.ec.core.utils.a2;
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
import com.bytedance.android.livehostapi.business.depend.livead.MiniAppConstants;
import com.bytedance.android.shopping.sku.inner.repo.model.SkuPassThroughItem;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.common.wschannel.WsConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SkuParams f182995a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f182996b;

    public final Map<String, Object> a() {
        if (this.f182996b == false) goto L5;
        int r100 = k.f44314a;
        Map r101 = MapsKt.mapOf(new Pair[]{TuplesKt.to("track_client_entrance_info", this.f182995a.getEventParams().get(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO)), TuplesKt.to("track_client", k.b(this.f182995a.getEventParams()).toString()), TuplesKt.to("api_sku_entrance_info", this.f182995a.getEntranceInfo())});
    L6:
        Pair[] r102 = new Pair[1];
        Pair[] r103 = new Pair[9];
        Pair[] r110 = new Pair[7];
        String r111 = this.f182995a.getProductId();
        if ((r111 instanceof String) == true) goto L9;
        r111 = null;
    L9:
        r110[0] = TuplesKt.to("product_id", r111);
        String r112 = this.f182995a.getPromotionId();
        if (r112 == null) goto L207;
        r110[1] = TuplesKt.to("promotion_id", r112);
        String r113 = this.f182995a.getCommodityType();
        if (r113 == null) goto L14;
        Integer r114 = StringsKt.toIntOrNull(r113);
    L16:
        if ((r114 instanceof Integer) == true) goto L18;
        r114 = null;
    L18:
        r110[2] = TuplesKt.to(PdpOpenThirdParam.KEY_PROMOTION_SOURCE, r114);
        r110[3] = TuplesKt.to("is_multi", Boolean.valueOf(this.f182995a.isMulti()));
        String r115 = this.f182995a.getShopId();
        if ((r115 instanceof String) == true) goto L21;
        r115 = null;
    L21:
        r110[4] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_SHOP_ID, r115);
        String r116 = this.f182995a.getCombinationId();
        if ((r116 instanceof String) == true) goto L24;
        r116 = null;
    L24:
        r110[5] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_COMBINATION_ID, r116);
        DefaultSelect r117 = this.f182995a.getDefaultSelect();
        if (r117 == null) goto L27;
        String r118 = r117.getSkuId();
    L29:
        if ((r118 instanceof String) == true) goto L31;
        r118 = null;
    L31:
        r110[6] = TuplesKt.to("hot_sale_sku_id", r118);
        r103[0] = TuplesKt.to("product_info", MapsKt.mapOf(r110));
        Pair[] r119 = new Pair[16];
        String r120 = this.f182995a.getAuthorId();
        if (r120 == null) goto L205;
        r119[0] = TuplesKt.to("author_id", r120);
        String r121 = this.f182995a.getSecAuthorId();
        if (r121 == null) goto L203;
        r119[1] = TuplesKt.to("sec_author_id", r121);
        String r122 = this.f182995a.getItemId();
        if ((r122 instanceof String) == true) goto L38;
        r122 = null;
    L38:
        r119[2] = TuplesKt.to("item_id", r122);
        String r123 = this.f182995a.getRoomId();
        if ((r123 instanceof String) == true) goto L41;
        r123 = null;
    L41:
        r119[3] = TuplesKt.to(MiniAppConstants.KEY_MINI_APP_LIVE_ROOM_ID, r123);
        r119[4] = TuplesKt.to("is_group_buy", Boolean.valueOf(this.f182995a.isGroupingBuy()));
        String r124 = String.valueOf(this.f182995a.getActionType());
        if (r124 == null) goto L201;
        r119[5] = TuplesKt.to("action_type", r124);
        String r125 = String.valueOf(this.f182995a.getSceneType());
        if (r125 == null) goto L199;
        r119[6] = TuplesKt.to("scene_type", r125);
        DefaultSelect r126 = this.f182995a.getDefaultSelect();
        if (r126 == null) goto L48;
        String r127 = r126.getLastSelectedSkuId();
    L50:
        if ((r127 instanceof String) == true) goto L52;
        r127 = null;
    L52:
        r119[7] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_SKU_ID, r127);
        DefaultSelect r128 = this.f182995a.getDefaultSelect();
        if (r128 == null) goto L55;
        Integer r129 = r128.getType();
    L57:
        if ((r129 instanceof Integer) == true) goto L59;
        r129 = null;
    L59:
        r119[8] = TuplesKt.to("hot_sale_type", r129);
        Lazy r130 = SkuPerformanceOpt.f45320a;
        BuyNowPerformanceOpt.l();
        r119[9] = TuplesKt.to("order_url", null);
        if (BuyNowPerformanceOpt.a() == false) goto L62;
        String r131 = null;
    L63:
        r119[10] = TuplesKt.to("detail_url", r131);
        r119[11] = TuplesKt.to("auto_apply_coupon", Boolean.FALSE);
        List<PromotionBenefitLabel> r132 = this.f182995a.getBenefitLabels();
        if ((r132 instanceof List) == true) goto L66;
        r132 = null;
    L66:
        r119[12] = TuplesKt.to("coupon_tags", r132);
        JSONObject r133 = new JSONObject();
        r133.put(PdpOpenThirdParam.KEY_PROMOTION_SOURCE, this.f182995a.getCommodityType());
        r133.put("product_id", this.f182995a.getProductId());
        r133.put("promotion_id", this.f182995a.getPromotionId());
        Unit r104 = Unit.INSTANCE;
        r119[13] = TuplesKt.to("live_product_raw_data", r133.toString());
        String r105 = this.f182995a.getSelectCarId();
        if ((r105 instanceof String) == true) goto L69;
        r105 = null;
    L69:
        r119[14] = TuplesKt.to("car_id", r105);
        r119[15] = TuplesKt.to("ngroup_buy_token", this.f182995a.getNGroupBuyToken());
        r103[1] = TuplesKt.to("biz_context", MapsKt.mapOf(r119));
        String r106 = this.f182995a.getReceiveAddressId();
        if ((r106 instanceof String) == true) goto L72;
        r106 = null;
    L72:
        r103[2] = TuplesKt.to("user_info", MapsKt.mapOf(TuplesKt.to("user_addr_id", r106)));
        Pair[] r107 = new Pair[15];
        SkuRestoreState r134 = this.f182995a.getSkuState();
        if (r134 == null) goto L75;
        String[] r135 = r134.getSelectSkuKeys();
    L77:
        if ((r135 instanceof String[]) == true) goto L79;
        r135 = null;
    L79:
        r107[0] = TuplesKt.to("default_spec_id", r135);
        DefaultSelect r136 = this.f182995a.getDefaultSelect();
        if (r136 == null) goto L82;
        Long r137 = r136.getBuyNum();
    L84:
        if ((r137 instanceof Long) == true) goto L86;
        r137 = null;
    L86:
        r107[1] = TuplesKt.to("default_count", r137);
        SkuPoiInfo r138 = this.f182995a.getPoiInfo();
        if ((r138 instanceof SkuPoiInfo) == true) goto L89;
        r138 = null;
    L89:
        r107[2] = TuplesKt.to("poi_info", r138);
        Boolean r139 = this.f182995a.getPopOnWindow();
        if ((r139 instanceof Boolean) == true) goto L92;
        r139 = null;
    L92:
        r107[3] = TuplesKt.to("pop_on_window", r139);
        String r140 = this.f182995a.getSkuSessionId();
        if ((r140 instanceof String) == true) goto L95;
        r140 = null;
    L95:
        r107[4] = TuplesKt.to("sku_session_id", r140);
        r107[5] = TuplesKt.to("scroll_to_installment", Boolean.valueOf(this.f182995a.getScrollToDouInstallment()));
        String r141 = this.f182995a.getMaskBackgroundColor();
        if ((r141 instanceof String) == true) goto L98;
        r141 = null;
    L98:
        r107[6] = TuplesKt.to("mask_background_color", r141);
        DefaultSelect r142 = this.f182995a.getDefaultSelect();
        if (r142 == null) goto L101;
        Boolean r143 = Boolean.valueOf(r142.getDisableServerSpecsDefaultSelect());
    L103:
        if ((r143 instanceof Boolean) == true) goto L105;
        r143 = null;
    L105:
        r107[7] = TuplesKt.to("disable_server_specs_default_select", r143);
        Integer r144 = this.f182995a.getTermCount();
        if (r144 == null) goto L108;
        String r145 = String.valueOf(r144.intValue());
    L110:
        if ((r145 instanceof String) == true) goto L112;
        r145 = null;
    L112:
        r107[8] = TuplesKt.to("dou_installment_term", r145);
        Integer r146 = this.f182995a.getSpecMode();
        if ((r146 instanceof Integer) == true) goto L115;
        r146 = null;
    L115:
        r107[9] = TuplesKt.to("spec_mode", r146);
        Long r147 = this.f182995a.getSpecModeTime();
        if (r147 == null) goto L118;
        String r148 = String.valueOf(r147.longValue());
    L120:
        if ((r148 instanceof String) == true) goto L122;
        r148 = null;
    L122:
        r107[10] = TuplesKt.to("spec_mode_time", r148);
        r107[11] = TuplesKt.to("panel_width", Integer.valueOf(b.b(false)));
        r107[12] = TuplesKt.to(BaseStandardHomeFragment.KEY_PANEL_HEIGHT, Integer.valueOf(b.a()));
        r107[13] = TuplesKt.to(ECFindSimilarConfig.HEIGHT_PERCENT, this.f182995a.getHeightPercent());
        if (BuyNowPerformanceOpt.a() == false) goto L125;
        Boolean r149 = Boolean.valueOf(a2.b(this.f182995a.getDetailUrl()));
    L126:
        r107[14] = TuplesKt.to("show_detail_entrance", r149);
        r103[3] = TuplesKt.to("client_params", MapsKt.mutableMapOf(r107));
        Pair[] r108 = new Pair[8];
        SkuExtraData r150 = this.f182995a.getSkuExtraData();
        if (r150 == null) goto L129;
        String r151 = r150.getMarketChannel();
    L131:
        if ((r151 instanceof String) == true) goto L133;
        r151 = null;
    L133:
        r108[0] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_MARKET_CHANNEL, r151);
        String r152 = this.f182995a.getEnterFrom();
        if ((r152 instanceof String) == true) goto L136;
        r152 = null;
    L136:
        r108[1] = TuplesKt.to("enter_from", r152);
        String r153 = this.f182995a.getChannelId();
        if ((r153 instanceof String) == true) goto L139;
        r153 = null;
    L139:
        r108[2] = TuplesKt.to("channel_id", r153);
        Integer r154 = this.f182995a.getChannelType();
        if (r154 == null) goto L142;
        String r155 = String.valueOf(r154.intValue());
    L144:
        if ((r155 instanceof String) == true) goto L146;
        r155 = null;
    L146:
        r108[3] = TuplesKt.to(WsConstants.KEY_CHANNEL_TYPE, r155);
        Integer r156 = this.f182995a.getTouTiaoAppId();
        if (r156 == null) goto L149;
        String r157 = String.valueOf(r156.intValue());
    L151:
        if ((r157 instanceof String) == true) goto L153;
        r157 = null;
    L153:
        r108[4] = TuplesKt.to("toutiao_app_id", r157);
        String r158 = this.f182995a.getEcomEntranceForm();
        if ((r158 instanceof String) == true) goto L156;
        r158 = null;
    L156:
        r108[5] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_ECOM_ENTRANCE_FORM, r158);
        String r159 = this.f182995a.getProductSourcePage();
        if ((r159 instanceof String) == true) goto L159;
        r159 = null;
    L159:
        r108[6] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_PRODUCT_SOURCE_PAGE, r159);
        String r160 = this.f182995a.getBizCampaignType();
        if ((r160 instanceof String) == true) goto L162;
        r160 = null;
    L162:
        r108[7] = TuplesKt.to("biz_campaign_type", r160);
        r103[4] = TuplesKt.to("chain_info", MapsKt.mapOf(r108));
        Pair[] r109 = new Pair[3];
        ECAdLogExtra r161 = this.f182995a.getAdLogExtra();
        if ((r161 instanceof ECAdLogExtra) == true) goto L165;
        r161 = null;
    L165:
        r109[0] = TuplesKt.to("ad_params", r161);
        ECBoltParam r162 = this.f182995a.getBoltParam();
        if ((r162 instanceof ECBoltParam) == true) goto L168;
        r162 = null;
    L168:
        r109[1] = TuplesKt.to("bolt_param", r162);
        CpsParams r163 = this.f182995a.getCpsParams();
        if ((r163 instanceof CpsParams) == true) goto L171;
        r163 = null;
    L171:
        r109[2] = TuplesKt.to("cps_params", r163);
        r103[5] = TuplesKt.to("custom_params", MapsKt.mapOf(r109));
        Boolean r164 = this.f182995a.getOpenWithSass();
        if ((r164 instanceof Boolean) == true) goto L174;
        r164 = null;
    L174:
        r103[6] = TuplesKt.to("platform_params", MapsKt.mapOf(TuplesKt.to("open_with_saas", r164)));
        if (this.f182996b == false) goto L177;
        List r165 = CollectionsKt.emptyList();
    L192:
        r103[7] = TuplesKt.to("pass_through", r165);
        r103[8] = TuplesKt.to("order_params", com.bytedance.android.shopping.sku.outer.business.ultimate.c.a(this.f182995a, true));
        Map r166 = MapsKt.mutableMapOf(r103);
        Iterator r167 = r101.entrySet().iterator();
    L194:
        if (r167.hasNext() == false) goto L196;
        Map.Entry r168 = (Map.Entry) r167.next();
        r166.put(r168.getKey(), r168.getValue());
        goto L194
    L196:
        Unit r169 = Unit.INSTANCE;
        r102[0] = TuplesKt.to("sku_schema_param", r166);
        return MapsKt.mutableMapOf(r102);
    L177:
        String r170 = this.f182995a.getEventParams().get(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO);
        this.f182995a.getEventParams();
        LinkedHashMap r171 = new LinkedHashMap();
        BuyNowPerformanceOpt.l();
        r171.put("track.client", new UltimateBuySkuParamForMulti$getPassThrough$1(this).invoke());
        r171.put("api.sku.entrance_info", new UltimateBuySkuParamForMulti$getPassThrough$2(this).invoke());
        ArrayList r172 = new ArrayList(r171.size());
        Iterator r173 = r171.entrySet().iterator();
    L179:
        if (r173.hasNext() == false) goto L191;
        Map.Entry r174 = (Map.Entry) r173.next();
        if (Intrinsics.areEqual((String) r174.getKey(), "track.client") == false) goto L189;
        List r175 = CollectionsKt.listOf(r174.getKey());
        Object r176 = r174.getValue();
        if ((r176 instanceof String) == true) goto L185;
        r176 = null;
    L185:
        String r177 = (String) r176;
        Object r178 = r174.getValue();
        if ((r178 instanceof Map) == true) goto L188;
        r178 = null;
    L188:
        SkuPassThroughItem r179 = new SkuPassThroughItem(r175, r177, (Map) r178);
    L190:
        r172.add(r179);
        goto L179
    L189:
        r179 = new SkuPassThroughItem(CollectionsKt.listOf(r174.getKey()), String.valueOf(r174.getValue()), null, 4, null);
        goto L190
    L191:
        r165 = r172;
        goto L192
    L149:
        r157 = null;
        goto L151
    L142:
        r155 = null;
        goto L144
    L129:
        r151 = null;
        goto L131
    L125:
        r149 = null;
        goto L126
    L118:
        r148 = null;
        goto L120
    L108:
        r145 = null;
        goto L110
    L101:
        r143 = null;
        goto L103
    L82:
        r137 = null;
        goto L84
    L75:
        r135 = null;
        goto L77
    L62:
        r131 = this.f182995a.getDetailUrl();
        goto L63
    L55:
        r129 = null;
        goto L57
    L48:
        r127 = null;
        goto L50
    L199:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    L201:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    L203:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    L205:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    L27:
        r118 = null;
        goto L29
    L14:
        r114 = null;
        goto L16
    L207:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    L5:
        r101 = MapsKt.emptyMap();
        goto L6
    }

    public i(SkuParams r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "skuParams");
        this.f182995a = r100;
        this.f182996b = r101;
    }
}
