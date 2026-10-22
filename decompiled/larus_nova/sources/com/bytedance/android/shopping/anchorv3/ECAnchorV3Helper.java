package com.bytedance.android.shopping.anchorv3;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.standard.home.BaseStandardHomeFragment;
import com.bytedance.android.ec.common.api.abilities.IShoppingAbilities;
import com.bytedance.android.ec.common.api.debugtool.IVisitUnit;
import com.bytedance.android.ec.common.api.debugtool.VisitActions;
import com.bytedance.android.ec.common.api.entranceinfo.IEntranceInfoService;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.anchorv3.o;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.core.vmsdk.VmSdkSetting;
import com.bytedance.android.ec.model.ECAdInfo;
import com.bytedance.android.ec.model.ECAdLogExtra;
import com.bytedance.android.ec.model.ECAdLogParams;
import com.bytedance.android.ec.model.ECBoltParam;
import com.bytedance.android.ec.model.entranceinfo.EntranceInfoScene;
import com.bytedance.android.ec.model.promotion.ECFindSimilarConfig;
import com.bytedance.android.ec.model.response.anchorv3.SourceType;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.livehostapi.business.depend.livead.MiniAppConstants;
import com.bytedance.android.shopping.anchorv3.utils.u;
import com.bytedance.android.shopping.anchorv4.perf.helper.PdpFastUriWrapper;
import com.bytedance.android.shopping.anchorv4.schemav2.PdpSchemaOld2NewConverter;
import com.bytedance.android.shopping.api.anchorv3.ECAwemeItemInfo;
import com.bytedance.android.shopping.api.anchorv3.ECLogExtraData;
import com.bytedance.android.shopping.api.anchorv3.ECLubanData;
import com.bytedance.android.shopping.api.anchorv3.ECProductDetailPageShowStyle;
import com.bytedance.android.shopping.api.anchorv3.ECProductInfo;
import com.bytedance.android.shopping.api.anchorv3.ECSceneTransitionData;
import com.bytedance.android.shopping.api.anchorv3.ECShareFission;
import com.bytedance.android.shopping.api.anchorv3.ECUIParam;
import com.bytedance.android.shopping.api.anchorv3.WireFrameSchemaInfo;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.feed.ProductFeedStarter;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.android.shopping.utils.y;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.search.vision.model.data.PhotoEnterModel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import n83.m;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class ECAnchorV3Helper implements p83.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ECAnchorV3Helper f164389a = null;

    public ECAnchorV3Helper() {
    }

    static {
        f164389a = new ECAnchorV3Helper();
    }

    public static int c(String r100) {
        if (StringsKt.equals(r100, "true", true) == false) goto L5;
        return 1;
    L5:
        if (Intrinsics.areEqual(r100, "1") == true) goto L10;
        return 0;
    L10:
        return 1;
    }

    public static String d(Object r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "uriObj");
        Intrinsics.checkNotNullParameter(r101, "metaParam");
        if ((r100 instanceof PdpFastUriWrapper) == false) goto L6;
        Uri r102 = ((PdpFastUriWrapper) r100).f167189b;
    L8:
        String r103 = UriProtector.getQueryParameter(r102, "channel_id");
        if (a.b(r103) == false) goto L12;
        return r103;
    L12:
        return r101.optString("channel_id");
    L6:
        if ((r100 instanceof Uri) == false) goto L13;
        r102 = (Uri) r100;
        goto L8
    L13:
        return null;
    }

    public static int e(Object r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "uriObj");
        Intrinsics.checkNotNullParameter(r101, "metaParam");
        if ((r100 instanceof PdpFastUriWrapper) == false) goto L6;
        Uri r102 = ((PdpFastUriWrapper) r100).f167189b;
    L8:
        int r103 = k.r(UriProtector.getQueryParameter(r102, WsConstants.KEY_CHANNEL_TYPE), 0);
        if (r103 == 0) goto L12;
        return r103;
    L12:
        return k.r(r101.optString(WsConstants.KEY_CHANNEL_TYPE), 0);
    L6:
        if ((r100 instanceof Uri) == false) goto L13;
        r102 = (Uri) r100;
        goto L8
    L13:
        return 0;
    }

    public static void b(JSONObject r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$appendParam");
        Intrinsics.checkNotNullParameter(r101, "key");
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        com.bytedance.android.ec.core.event.a.b.C0794a.C0795a r103 = com.bytedance.android.ec.core.event.a.b.C0794a.f44003a;
        if (r102 == null) goto L6;
        r100.put(r101, r103.a(r102));
        return;
    }

    public static void i(Context r610, String r611, boolean r612) {
        Intrinsics.checkNotNullParameter(r610, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r611, "url");
        System.currentTimeMillis();
        PdpFastUriWrapper r100 = new PdpFastUriWrapper(UriProtector.parse(r611));
        String r101 = r100.a("target_uid");
        if (r101 != null) goto L5;
        String r310 = "";
    L6:
        String r102 = r100.a("sec_target_uid");
        if (r102 != null) goto L9;
        String r311 = "";
    L86:
        JSONObject r103 = new JSONObject(r100.a(com.bytedance.android.ec.core.event.a.KEY_META_PARAM));     // Catch: Exception -> L12
    L13:
        JSONObject r104 = r103;
        ECBoltParam r105 = new ECBoltParam(r100.a("activity_id"), r100.a("new_source_id"));
        String r106 = r100.a("creative_id");
        String r107 = null;
        if (r106 == null) goto L27;
        String r108 = a2.d(r106);
        if (r108 == null) goto L27;
        ECAdLogExtra r109 = new ECAdLogExtra(null, null, null, null, 15, null);
        r109.setCreativeId(r108);
        String r110 = r100.a("log_extra");
        if (r110 != null) goto L20;
        r110 = "";
    L20:
        r109.setLogExtra(r110);
        String r111 = r100.a("ad_extra_data");
        if (r111 != null) goto L23;
        r111 = "";
    L23:
        r109.setAdExtraData(r111);
        String r112 = r100.a("group_id");
        if (r112 != null) goto L26;
        r112 = "";
    L26:
        r109.setGroupId(r112);
    L28:
        String r113 = r100.a("source_page");
        if (r113 != null) goto L31;
        r113 = "open_url";
    L31:
        String r114 = r100.a("enter_method");
        if (r114 != null) goto L34;
        r114 = "click_open_url";
    L34:
        String r115 = r100.a(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO);
        if (r115 != null) goto L88;
    L39:
        JSONObject r116 = new JSONObject();     // Catch: Exception -> L64
    L40:
        String r117 = r116.optString(com.bytedance.android.ec.core.event.a.KEY_CARRIER_SOURCE);     // Catch: Exception -> L64
        boolean r118 = true;
        if (r117 != null) goto L43;
    L46:
        boolean r119 = true;
    L47:
        if (r119 == true) goto L50;
        r117 = null;
    L50:
        if (r117 == null) goto L52;
        r116.put(com.bytedance.android.ec.core.event.a.KEY_CARRIER_SOURCE, r113);     // Catch: Exception -> L64
    L52:
        String r120 = r116.optString(com.bytedance.android.ec.core.event.a.KEY_SOURCE_METHOD);     // Catch: Exception -> L64
        if (r120 != null) goto L55;
    L58:
        if (r118 == false) goto L60;
        r107 = r120;
    L60:
        if (r107 == null) goto L62;
        r116.put(com.bytedance.android.ec.core.event.a.KEY_SOURCE_METHOD, u.a(r114));     // Catch: Exception -> L64
    L62:
        String r121 = r116.toString();     // Catch: Exception -> L64
    L66:
        String r410 = r100.a("cover_img");
        String r122 = r100.a(com.bytedance.android.ec.core.event.a.KEY_REQUEST_ADDITIONS);
        if (r122 == null) goto L70;
        JSONObject r123 = z1.g(r122);
        if (r123 == null) goto L70;
    L71:
        String r124 = r100.a("cps_track");
        if (r124 != null) goto L74;
        r124 = "";
    L74:
        r123.put("cps_track", r124);
        long r411 = k.y(r100.a(PdpOpenThirdParam.KEY_PROMOTION_SOURCE), SourceType.UNKNOWN.getType());
        int r125 = e(r100, r104);
        String r510 = d(r100, r104);
        String r126 = r100.a("promotion_id");
        if (r126 != null) goto L77;
        String r312 = "";
    L78:
        String r127 = r121;
        JSONObject r128 = r123;
        final AnchorV3Starter r129 = new AnchorV3Starter(r610, new ECProductInfo(r312, r100.a("product_id"), null, null, 0, null, r410, null, r411, 0, null, null, null, null, null, null, null, r510, Integer.valueOf(r125), null, null, null, null, 7995068, null), new ECAwemeItemInfo(r100.a("ad_item_id"), r310, r311, null, false, null, false, 0, null, null, null, null, false, false, null, null, null, null, null, false, 1048568, null), r104, r109, r105, r127, null, null, new ECProductDetailPageShowStyle(true, false, 0, false, 14, null), null, new ECLogExtraData(r113, r114, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 262140, null), r128, null, r612, null, null, null, null, null, null, null, null, null, r100.f167189b, r100.a("bcm"), null, null, null, 486516096);
        int r130 = o.f43817a;
        if (o.a(32) == false) goto L82;
        new PdpSchemaOld2NewConverter(r129).d("ECAnchorV3Helper.startFromOldSchema");
        return;
    L82:
        if (com.bytedance.android.ec.core.abtest.d.h() == false) goto L84;
        Function0<Unit> r131 = new ECAnchorV3Helper$startFromOldSchema$5$1(r129);
        Intrinsics.checkNotNullParameter(r131, "cb");
        r129.f164364e = r131;
    L84:
        r129.I();
        return;
    L77:
        r312 = r126;
    L70:
        r123 = new JSONObject();
    L64:
        e = move-exception;
        ECExceptionMonitor.e(e);
        r121 = r115;
        goto L66
    L55:
        if (r120.length() == 0) goto L58;
        r118 = false;
        goto L58
    L43:
        if (r117.length() == 0) goto L46;
        r119 = false;
        goto L47
    L88:
        String r132 = a2.d(r115);     // Catch: Exception -> L64
        if (r132 == null) goto L39;
        r116 = new JSONObject(r132);     // Catch: Exception -> L64
    L27:
        r109 = null;
    L12:
        r103 = new JSONObject();
        goto L13
    L9:
        r311 = r102;
        goto L86
    L5:
        r310 = r101;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void k(Context r121, final String r122, boolean r123, final boolean r124) {
        Intrinsics.checkNotNullParameter(r121, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r122, "url");
        System.currentTimeMillis();
        if (com.bytedance.android.ec.core.opt.ab.u.d() != 1) goto L5;
        boolean r100 = true;
    L7:
        if (r100 == false) goto L20;
        if (r124 == true) goto L20;
        int r101 = ECSdk.f48106a;
        IVisitUnit r102 = (IVisitUnit) ECSdk.a(IVisitUnit.class);
        if (r102 == null) goto L12;
        r102.hookToSchema(VisitActions.PDP_IN_URL.getKey(), new ECAnchorV3Helper$startWithShoppingAbilities$1(r122));
    L12:
        int r103 = com.bytedance.android.ec.core.monitor.d.f45144a;
        Intrinsics.checkNotNullParameter(r122, "schema");
        HashMap r104 = new HashMap();
        r104.put("schema", r122);
        com.bytedance.android.ec.core.monitor.d.e("iesec_schema_product_detail", r104);
        com.bytedance.android.ec.core.monitor.o r105 = (com.bytedance.android.ec.core.monitor.o) ECSdk.a(com.bytedance.android.ec.core.monitor.o.class);
        if (r105 == null) goto L15;
        com.bytedance.android.ec.core.monitor.o.a.a(r105, r121, "page", r122, VmSdkSetting.a().e());
    L15:
        Uri r106 = UriProtector.parse(r122);
        IShoppingAbilities r107 = (IShoppingAbilities) ECSdk.a(IShoppingAbilities.class);
        if (r107 == null) goto L310;
        r107.openPDP(r121, com.bytedance.android.shopping.abilities.pdp.a.b(r106), com.bytedance.android.shopping.abilities.pdp.a.a(r106, r123, true), null);
        return;
    L310:
        return;
    L20:
        if (r124 == true) goto L25;
        int r108 = ECSdk.f48106a;
        IVisitUnit r109 = (IVisitUnit) ECSdk.a(IVisitUnit.class);
        if (r109 == null) goto L24;
        r109.hookToSchema(VisitActions.PDP_IN_URL.getKey(), new ECAnchorV3Helper$startFromSchema$1(r122));
        Unit r110 = Unit.INSTANCE;
    L24:
        int r111 = com.bytedance.android.ec.core.monitor.d.f45144a;
        Intrinsics.checkNotNullParameter(r122, "schema");
        HashMap r112 = new HashMap();
        r112.put("schema", r122);
        com.bytedance.android.ec.core.monitor.d.e("iesec_schema_product_detail", r112);
    L25:
        PdpFastUriWrapper r113 = new PdpFastUriWrapper(UriProtector.parse(r122));
        JSONObject r114 = z1.g(r113.a("meta_params"));
        if (r114 != null) goto L28;
        r114 = new JSONObject();
    L28:
        JSONObject r115 = r114;
        int r116 = ECSdk.f48106a;
        IEntranceInfoService r117 = (IEntranceInfoService) ECSdk.a(IEntranceInfoService.class);
        if (r117 == null) goto L31;
        gl.a r118 = r117.initEntranceInfo(new EntranceInfoScene("productDetail", "schemaParse"), r115.optString(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO));
    L32:
        String r119 = r113.a("clear_screen_upon");
        if (r119 == null) goto L35;
        r115.put("clear_screen_upon", r119);
    L35:
        String r310 = d(r113, r115);
        int r120 = e(r113, r115);
        JSONObject r125 = z1.g(r113.a(com.bytedance.android.ec.core.event.a.KEY_REQUEST_ADDITIONS));
        final String r126 = a2.d(r113.a("source_page"));
        if (r126 != null) goto L42;
        if (r125 == null) goto L39;
        r126 = r125.optString("enter_from");
    L40:
        if (r126 != null) goto L42;
        r126 = "";
        goto L42
    L39:
        r126 = null;
    L42:
        String r127 = r113.a("enter_method");
        if (r127 != null) goto L45;
        r127 = "";
    L45:
        String r128 = a2.d(r113.a(com.bytedance.android.ec.core.event.a.KEY_ECOM_ENTRANCE_FORM));
        if (r128 != null) goto L48;
        r128 = r113.a("carrier_type");
    L48:
        String r129 = r113.a("item_id");
        if (r129 != null) goto L51;
        r129 = "";
    L51:
        String r130 = r113.a("show_sku_panel");
        String r131 = r113.a(com.bytedance.android.ec.core.event.a.KEY_LABEL_NAME_LIVE);
        String r132 = r113.a("label_name_from_live");
        String r133 = r113.a(com.bytedance.android.ec.core.event.a.KEY_BASE_VERIFIED_CATEGORY);
        String r134 = r113.a("log_extra");
        if (r134 != null) goto L54;
        String r135 = "";
    L55:
        String r136 = r113.a("creative_id");
        if (r136 != null) goto L58;
        String r210 = "";
    L59:
        String r137 = r113.a("live_window_room_id");
        if (r137 != null) goto L62;
        String r710 = "";
    L63:
        String r211 = r113.a("cover_img");
        String r138 = r115.optString(MiniAppConstants.KEY_MINI_APP_LIVE_ROOM_ID);
        if (r138 != null) goto L66;
        String r1010 = "";
    L67:
        String r711 = r113.a("elastic_title");
        String r1011 = r113.a("mask_color");
        String r139 = r113.a("is_from_ad");
        if (r139 != null) goto L73;
        String r610 = r133;
        JSONObject r140 = z1.g(r115.optString(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO));
        if (r140 == null) goto L72;
        String r141 = r140.optString("is_from_ad");
    L74:
        int r142 = k.r(r141, 0);
        String r143 = r113.a("enable_common_ad_track");
        if (r143 != null) goto L77;
        r143 = "";
    L77:
        String r144 = r113.a("fraction_listener_id");
        if (r144 != null) goto L80;
        String r810 = "";
    L81:
        String r811 = r113.a("page_state_listener_id");
        String r910 = r113.a("page_state_listener_extra");
        String r1012 = r113.a("preload_extra");
        ECAdLogParams r145 = new ECAdLogParams(Integer.valueOf(r142), r143);
        ECAdInfo r146 = ih3.g.f489807b.A(null);
        if (r146 == null) goto L84;
        String r147 = r146.getLogExtra();
    L86:
        if (r118 == null) goto L89;
        r118.b(new Pair[]{TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_SOURCE_METHOD, r128)}, new ECAnchorV3Helper$startFromSchema$3(r126));
        Unit r148 = Unit.INSTANCE;
    L89:
        if (r210.length() <= 0) goto L91;
        boolean r149 = true;
    L93:
        if (r149 == true) goto L95;
    L103:
        String r150 = r210;
    L105:
        if (TextUtils.isEmpty(r150) == true) goto L110;
        if (TextUtils.isEmpty(r135) == true) goto L110;
        String r151 = r113.a("ad_extra_data");
        int r152 = com.bytedance.android.shopping.anchorv3.utils.b.f165302a;
        ECAdLogExtra r153 = com.bytedance.android.shopping.anchorv3.utils.b.b(r150, r135, r151, r129);
        String r154 = null;
    L115:
        String r155 = r113.a("promotion_id");
        if (r155 != null) goto L118;
        r155 = "";
    L118:
        String r156 = r113.a(com.bytedance.android.ec.core.event.a.KEY_KOL_ID);
        if (r156 != null) goto L121;
        String r410 = "";
    L122:
        if (r125 == null) goto L124;
        String r157 = r125.optString("sec_author_id");
    L125:
        if (r157 != null) goto L127;
        String r411 = "";
    L128:
        boolean r212 = k.n(r113.a("fullscreen"), true);
        String r812 = String.valueOf(r113.a("half_pdp_opt_type"));
        String r158 = r113.a(BaseStandardHomeFragment.KEY_PANEL_HEIGHT);
        if (r158 == null) goto L131;
        Integer r813 = StringsKt.toIntOrNull(r158);
    L132:
        boolean r159 = k.n(r113.a(com.bytedance.android.ec.core.event.a.KEY_IS_LUBAN), false);
        if (r125 == null) goto L135;
        String r160 = r125.optString(com.bytedance.android.ec.core.event.a.KEY_PAGE_ID);
    L136:
        if (r160 != null) goto L138;
        r160 = "";
    L138:
        if (r125 == null) goto L140;
        String r161 = r125.optString("product_id");
    L141:
        if (r161 != null) goto L143;
        r161 = "";
    L143:
        if (r125 == null) goto L145;
        String r162 = r125.optString("source_type");
    L146:
        if (r162 != null) goto L148;
        r162 = "";
    L148:
        if (r125 == null) goto L150;
        String r163 = r125.optString("qianchuan_ab");
    L151:
        if (r163 != null) goto L153;
        r163 = "";
    L153:
        JSONObject r164 = z1.g(r113.a("v3_events_additions"));
        String r712 = r128;
        if (r164 == null) goto L165;
        String r713 = r127;
        Integer r165 = Integer.valueOf(r164.optInt("follow_status", -1));
        String r714 = r126;
        if (r165.intValue() == (-1)) goto L158;
        boolean r166 = true;
    L159:
        if (r166 == true) goto L162;
        r165 = null;
    L162:
        if (r165 == null) goto L166;
        Integer r412 = r165;
    L176:
        boolean r213 = k.n(r113.a("open_with_activity"), false);
        if (r130 != null) goto L179;
        String r715 = r162;
        JSONObject r716 = r164;
    L190:
        int r214 = 0;
    L191:
        ECProductDetailPageShowStyle r167 = new ECProductDetailPageShowStyle(r212, r213, r214, false, 8, null);
        String r168 = r113.a("request_page");
        if (r168 != null) goto L194;
        r168 = "";
    L194:
        boolean r169 = k.n(r113.a("disable_live_window"), false);
        if (r125 == null) goto L197;
        String r170 = r125.optString(com.bytedance.android.ec.core.event.a.KEY_RANK_ID);
    L198:
        if (r170 != null) goto L200;
        r170 = "";
    L200:
        String r171 = r113.a(com.bytedance.android.ec.core.event.a.KEY_THREE_D);
        if (r171 != null) goto L203;
        r171 = "";
    L203:
        String r1110 = r113.a("user_addr_id");
        if (r118 == null) goto L206;
        String r172 = r118.getString(com.bytedance.android.ec.core.event.a.KEY_MODULE_LABEL);
    L207:
        if (r118 == null) goto L209;
        String r173 = r118.getString(com.bytedance.android.ec.core.event.a.KEY_ECOM_ICON);
    L210:
        if (r118 == null) goto L212;
        String r814 = r118.getString("action_type");
    L213:
        String r815 = r163;
        String r816 = r171;
        long r215 = k.y(r113.a(PdpOpenThirdParam.KEY_PROMOTION_SOURCE), SourceType.UNKNOWN.getType());
        String r174 = r113.a("ad_ui_control_params");
        if (r174 != null) goto L216;
        String r1111 = "";
    L217:
        String r175 = r113.a("domain_params");
        if (r175 != null) goto L220;
        String r1112 = "";
    L221:
        boolean r176 = k.n(r113.a("small_window_mute"), false);
        boolean r177 = k.n(r113.a("small_window_priority"), true);
        String r178 = r113.a("share_scene");
        if (r178 != null) goto L224;
        String r1113 = "";
    L225:
        String r179 = r113.a("sec_activity_info");
        if (r179 != null) goto L228;
        String r1114 = "";
    L229:
        float r1013 = k.p(r113.a("half_head_scale"), 0.0f);
        String r180 = r113.a("half_head_space");
        if (r180 != null) goto L232;
        r180 = "";
    L232:
        String r181 = r113.a("product_pre_info");
        if (r181 != null) goto L235;
        r181 = "";
    L235:
        String r911 = r113.a("first_cid");
        String r912 = r113.a("live_hot_sale_component");
        String r182 = r113.a("share_element_transition_name");
        String r913 = r180;
        String r183 = r113.a("share_element_view_id");
        if (r183 == null) goto L238;
        Integer r184 = StringsKt.toIntOrNull(r183);
    L239:
        String r185 = r113.a(PhotoEnterModel.SOURCE_BTM_TOKEN);
        if (r185 != null) goto L242;
        String r1115 = "";
    L243:
        boolean r914 = k.n(r113.a("client_cache_disable"), false);
        String r186 = r113.a("header_config");
        if (r186 != null) goto L246;
        r186 = "";
    L246:
        String r1116 = r113.a("pendant_params");
        String r187 = r113.a("pre_page_click_start");
        if (r187 == null) goto L249;
        Long r1014 = StringsKt.toLongOrNull(r187);
    L250:
        String r1210 = r186;
        boolean r915 = k.n(r113.a("auto_buy_now"), false);
        boolean r916 = k.n(r113.a("auto_add_to_cart"), false);
        String r917 = r113.a(com.bytedance.android.ec.core.event.a.KEY_SKU_ID);
        if (r125 == null) goto L259;
        String r188 = r125.optString("ecom_scene_id");
        if (r188 == null) goto L259;
        List r189 = StringsKt.split$default(r188, new String[]{","}, false, 0, 6, null);
        if (r189 == null) goto L259;
        String r190 = (String) CollectionsKt.last(r189);
        if (r190 == null) goto L259;
        Integer r191 = StringsKt.toIntOrNull(r190);
    L260:
        String r192 = r113.a(ECFindSimilarConfig.HEIGHT_PERCENT);
        if (r192 == null) goto L265;
        Float r193 = StringsKt.toFloatOrNull(r192);
        if (r193 == null) goto L265;
        Integer r194 = Integer.valueOf((int) r193.floatValue());
    L266:
        if (r194 == null) goto L282;
        int r195 = y.f187160a;
        int r196 = r194.intValue();
        String r197 = String.valueOf(r191);
        if (r1013 != 0.0f) goto L270;
        float r198 = ECSettingKeys.A0().c();
    L271:
        Float r216 = Float.valueOf(r198);
        if (r118 == null) goto L274;
        String r199 = r118.getString("is_explaining");
    L275:
        s73.a r200 = new s73.a(r197, r911, r216, r812, Intrinsics.areEqual(r199, "1"));
        Intrinsics.checkNotNullParameter(r200, "styleParams");
        if (s73.b.a(r200) == true) goto L278;
    L280:
        int r201 = r196;
    L281:
        r194 = Integer.valueOf(r201);
        goto L282
    L278:
        if (Intrinsics.areEqual(r200.f540920d, "2") == false) goto L280;
        r201 = 80;
        goto L281
    L274:
        r199 = null;
        goto L275
    L270:
        r198 = r1013;
    L282:
        ECProductInfo r1100 = new ECProductInfo(r155, r161, r170, null, 0, null, r211, null, r215, 0, null, null, null, null, null, null, null, r310, Integer.valueOf(r120), null, r113.a("biz_campaign_type"), r113.a("ngroup_buy_token"), null, 4849336, null);
        ECAwemeItemInfo r202 = new ECAwemeItemInfo(r129, r410, r411, r412, false, null, false, 0, null, null, null, null, false, false, null, null, null, null, null, false, 1048560, null);
        if (r118 == null) goto L285;
        String r203 = r118.h();
    L286:
        String r217 = r113.a("bcm");
        ECLubanData r204 = new ECLubanData(r159, r160, r715, r815);
        if (r716 == null) goto L289;
        String r413 = r716.toString();
    L290:
        ECLogExtraData r1101 = new ECLogExtraData(r714, r713, r712, r413, null, null, null, null, r172, r132, r610, r131, null, r816, null, null, r113.a("ecom_share_track_params"), r113.a("share_group_info"), 53488, null);
        String r205 = r113.a("inflow_feed_card_layout_pos");
        if (r205 == null) goto L293;
        Integer r206 = StringsKt.toIntOrNull(r205);
    L294:
        if (r184 == null) goto L296;
        ECSceneTransitionData r611 = new ECSceneTransitionData(r182, r184);
    L297:
        final AnchorV3Starter r1102 = new AnchorV3Starter(r121, r1100, r202, r115, r153, null, r203, r1115, null, r167, r204, r1101, r125, new ECUIParam(r168, r169, false, r814, null, r173, r710, null, null, r711, r206, r813, null, r176, r177, null, r611, r812, r810, r811, r910, (WireFrameSchemaInfo) p83.a.a(r181, WireFrameSchemaInfo.class), r194, r911, r912, r1210, r914, r915, r916, r917, r1013, c(r913), r1014, 37268, 0, null), r123, r1010, r1110, null, r1111, r1112, null, r1011, new ECShareFission(r1113, r1114), r145, r113.f167189b, r217, r1116, null, r1012, 135397664);
        int r207 = o.f43817a;
        if (o.a(128) == false) goto L304;
        if (r124 == false) goto L302;
        new PdpSchemaOld2NewConverter(r1102).c("ECAnchorV3Helper.startFromSchemaPreload");
        return;
    L302:
        new PdpSchemaOld2NewConverter(r1102).d("ECAnchorV3Helper.startFromSchema");
        return;
    L304:
        if (com.bytedance.android.ec.core.abtest.d.h() == false) goto L306;
        Function0<Unit> r208 = new ECAnchorV3Helper$startFromSchema$$inlined$also$lambda$1(r1102, r124);
        Intrinsics.checkNotNullParameter(r208, "cb");
        r1102.f164364e = r208;
    L306:
        if (r124 == false) goto L308;
        r1102.G();
        return;
    L308:
        r1102.I();
        return;
    L296:
        r611 = null;
        goto L297
    L293:
        r206 = null;
        goto L294
    L289:
        r413 = null;
        goto L290
    L285:
        r203 = null;
    L265:
        r194 = null;
    L259:
        r191 = null;
        goto L260
    L249:
        r1014 = null;
        goto L250
    L242:
        r1115 = r185;
        goto L243
    L238:
        r184 = null;
        goto L239
    L228:
        r1114 = r179;
        goto L229
    L224:
        r1113 = r178;
        goto L225
    L220:
        r1112 = r175;
        goto L221
    L216:
        r1111 = r174;
        goto L217
    L212:
        r814 = null;
        goto L213
    L209:
        r173 = null;
        goto L210
    L206:
        r172 = null;
        goto L207
    L197:
        r170 = null;
        goto L198
    L179:
        r716 = r164;
        int r209 = r130.hashCode();
        r715 = r162;
        if (r209 == 49) goto L188;
        if (r209 != 50) goto L190;
        if (r130.equals("2") == false) goto L190;
        r214 = 2;
        goto L191
    L188:
        if (r130.equals("1") == false) goto L190;
        r214 = 1;
    L166:
        if (r118 == null) goto L175;
        Integer r218 = r118.a();
        if (r218 == null) goto L175;
        if (r218.intValue() == (-1)) goto L172;
        boolean r1103 = true;
    L173:
        if (r1103 == false) goto L175;
        r412 = r218;
        goto L176
    L172:
        r1103 = false;
    L175:
        r412 = null;
        goto L176
    L158:
        r166 = false;
        goto L159
    L165:
        r714 = r126;
        r713 = r127;
        goto L166
    L150:
        r163 = null;
        goto L151
    L145:
        r162 = null;
        goto L146
    L140:
        r161 = null;
        goto L141
    L135:
        r160 = r154;
        goto L136
    L131:
        r813 = r154;
        goto L132
    L127:
        r411 = r157;
        goto L128
    L124:
        r157 = r154;
        goto L125
    L121:
        r410 = r156;
    L110:
        if (TextUtils.isEmpty(r150) == false) goto L112;
    L114:
        r154 = null;
        r153 = null;
        goto L115
    L112:
        if (TextUtils.isEmpty(r147) == true) goto L114;
        int r219 = com.bytedance.android.shopping.anchorv3.utils.b.f165302a;
        r154 = null;
        r153 = com.bytedance.android.shopping.anchorv3.utils.b.b(r150, r147, null, r129);
        goto L115
    L95:
        if (TextUtils.isEmpty(r147) == true) goto L103;
        if (r118 == null) goto L98;
        r150 = r210;
        r118.b(new Pair[]{TuplesKt.to("log_extra", r147), TuplesKt.to("creative_id", r150)}, ECAnchorV3Helper$startFromSchema$4.INSTANCE);
        Unit r220 = Unit.INSTANCE;
    L99:
        if (r118 == null) goto L101;
        String r221 = r118.h();
    L102:
        KtSafeMethodExtensionKt.safePut(r115, com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO, r221);
        goto L105
    L101:
        r221 = null;
        goto L102
    L98:
        r150 = r210;
        goto L99
    L91:
        r149 = false;
        goto L93
    L84:
        r147 = null;
        goto L86
    L80:
        r810 = r144;
        goto L81
    L72:
        r141 = null;
        goto L74
    L73:
        r610 = r133;
        r141 = r139;
        goto L74
    L66:
        r1010 = r138;
        goto L67
    L62:
        r710 = r137;
        goto L63
    L58:
        r210 = r136;
        goto L59
    L54:
        r135 = r134;
        goto L55
    L31:
        r118 = null;
        goto L32
    L5:
        r100 = false;
        goto L7
    }

    public static void f(String r100, Long r101, Integer r102, String r103, Context r104) {
        Intrinsics.checkNotNullParameter(r104, PerfLog.PARAM_KEY_CONTEXT_ID);
        bf.a.c(r104, UriProtector.parse("sslocal://ec_comment_detail").buildUpon().appendQueryParameter("product_id", r100).appendQueryParameter("comment_id", String.valueOf(r101)).appendQueryParameter("comment_cursor", String.valueOf(r102)).appendQueryParameter(com.bytedance.android.ec.core.event.a.KEY_COMMENT_ENTRANCE, r103).build(), false, false);
    }

    public static void j(Context r101, String r102, String r103, long r104, String r106, String r107, String r108, String r109, Function0 r110) {
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_DETAIL, "enterFrom");
        Intrinsics.checkNotNullParameter("rec_in_shop_product", "enterMethod");
        if (r102 != null) goto L6;
        return;
    L6:
        if (z53.b.a(1001, 800) == true) goto L16;
        final AnchorV3Starter r100 = new AnchorV3Starter(r101, new ECProductInfo(r102, r103, null, null, 0, null, null, null, r104, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, 8388280, null), new ECAwemeItemInfo(null, null, null, null, false, null, false, 0, null, null, null, null, false, false, null, null, null, null, null, false, 1048575, null), new JSONObject(), null, null, r106, r109, null, new ECProductDetailPageShowStyle(true, false, 0, false, 14, null), null, new ECLogExtraData(com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_DETAIL, "rec_in_shop_product", com.bytedance.android.ec.core.event.a.VALUE_STORE_RECOMMEND, null, null, r107, r108, null, null, null, null, null, null, null, null, null, null, null, 262040, null), null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 1073722672);
        int r105 = o.f43817a;
        if (o.a(64) == false) goto L11;
        new PdpSchemaOld2NewConverter(r100).d("ECAnchorV3Helper.startFromRecommendInShop");
    L14:
        Unit r111 = (Unit) r110.invoke();
        return;
    L11:
        if (com.bytedance.android.ec.core.abtest.d.h() == false) goto L13;
        Function0<Unit> r112 = new ECAnchorV3Helper$startFromRecommendInShop$1$1(r100);
        Intrinsics.checkNotNullParameter(r112, "cb");
        r100.f164364e = r112;
    L13:
        r100.I();
        goto L14
    }

    public static void h(Context r710, final String r711, final String r712, final String r810, final String r811, final long r812, final String r813, final String r814, final String r815, final String r816, final String r817, String r818, final Long r910, final String r911) {
        final String r100 = com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_DETAIL;
        final String r110 = "click_guess_you_like_product";
        final String r111 = null;
        final String r210 = null;
        Intrinsics.checkNotNullParameter(r710, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_DETAIL, "enterFrom");
        Intrinsics.checkNotNullParameter("click_guess_you_like_product", "enterMethod");
        Intrinsics.checkNotNullParameter(r712, "userId");
        Intrinsics.checkNotNullParameter(r810, "secUid");
        System.currentTimeMillis();
        if (r711 == null) goto L108;
        int r101 = ECSdk.f48106a;
        IVisitUnit r112 = (IVisitUnit) ECSdk.a(IVisitUnit.class);
        if (r112 == null) goto L10;
        r112.hookToRequest(VisitActions.PDP_GUL_TO_PDP.getKey(), new ECAnchorV3Helper$startFromGuessULike$1(r711, r100, r110, r712, r810, r811, r812, r813, r814, r815, r816, r817, r111, r910, r210, r911));
        Unit r102 = Unit.INSTANCE;
    L10:
        if (z53.b.a(1001, 800) == true) goto L106;
        String r103 = null;
        if (Intrinsics.areEqual(com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_DETAIL, com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_FLOW_PAGE) == false) goto L23;
        if (r813 == null) goto L21;
        JSONObject r104 = z1.g(r813);
        if (r104 == null) goto L21;
        Iterator<String> r105 = com.bytedance.android.shopping.feed.f.f175010a.iterator();
    L18:
        if (r105.hasNext() == false) goto L20;
        r104.remove(r105.next());
        goto L18
    L20:
        Unit r106 = Unit.INSTANCE;
    L22:
        String r410 = String.valueOf(r104);
    L103:
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L97
        if (r911 == null) goto L33;
        String r108 = a2.d(r911);     // Catch: Throwable -> L97
        if (r108 == null) goto L33;
        JSONObject r109 = z1.g(r108);     // Catch: Throwable -> L97
        if (r109 == null) goto L33;
        JSONObject r113 = r109.optJSONObject("raw_ad_data");     // Catch: Throwable -> L97
        if (r113 == null) goto L33;
        JSONObject r114 = r113.optJSONObject("ad_open_url_params");     // Catch: Throwable -> L97
    L34:
        if (r114 == null) goto L36;
        JSONObject r115 = r114.optJSONObject("ad_request_additions");     // Catch: Throwable -> L97
    L38:
        if (r114 == null) goto L43;
        String r116 = r114.optString("promotion_id");     // Catch: Throwable -> L97
        if (r116 == null) goto L43;
        String r411 = r116;
    L44:
        if (r114 == null) goto L49;
        String r117 = r114.optString("product_id");     // Catch: Throwable -> L97
        if (r117 == null) goto L49;
        String r510 = r117;
    L50:
        ECProductInfo r713 = new ECProductInfo(r411, r510, r815, null, k.h(r910), null, r817, null, r812, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, 8388264, null);     // Catch: Throwable -> L97
        if (r114 == null) goto L56;
        String r118 = r114.optString(com.bytedance.android.ec.core.event.a.KEY_KOL_ID);     // Catch: Throwable -> L97
        if (r118 == null) goto L56;
        String r211 = r118;
    L57:
        if (r114 == null) goto L62;
        String r119 = r114.optString("item_id");     // Catch: Throwable -> L97
        if (r119 == null) goto L62;
        String r212 = r119;
    L63:
        ECAwemeItemInfo r412 = new ECAwemeItemInfo(r212, r211, r810, null, false, null, false, 0, null, null, null, null, false, false, null, null, null, null, null, false, 1048568, null);     // Catch: Throwable -> L97
        if (r114 == null) goto L67;
        JSONObject r120 = r114.optJSONObject("meta_params");     // Catch: Throwable -> L97
        if (r120 == null) goto L67;
    L68:
        JSONObject r213 = r120;
        ECProductDetailPageShowStyle r310 = new ECProductDetailPageShowStyle(true, false, 0, false, 14, null);     // Catch: Throwable -> L97
        if (r114 != null) goto L71;
        ECLubanData r311 = null;
    L82:
        if (r115 == null) goto L87;
        String r121 = r115.optString("enter_from");     // Catch: Throwable -> L97
        if (r121 == null) goto L87;
        String r122 = r121;
    L88:
        String r312 = r410;
        final AnchorV3Starter r123 = new AnchorV3Starter(r710, r713, r412, r213, null, null, r312, r818, null, r310, r311, new ECLogExtraData(r122, "click_guess_you_like_product", null, null, null, r814, r816, null, "guess_you_like_product", null, null, null, null, null, null, null, null, null, 257692, null), r115, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 536846640);     // Catch: Throwable -> L97
        int r124 = o.f43817a;     // Catch: Throwable -> L97
        if (o.a(16) == false) goto L92;
        new PdpSchemaOld2NewConverter(r123).d("ECAnchorV3Helper.startFromGuessULike");     // Catch: Throwable -> L97
    L95:
        Object r125 = Result.m9449constructorimpl(r123);     // Catch: Throwable -> L97
    L99:
        Throwable r126 = Result.m9452exceptionOrNullimpl(r125);
        if (r126 == null) goto L107;
        ECExceptionMonitor.e(r126);
        return;
    L107:
        return;
    L92:
        if (com.bytedance.android.ec.core.abtest.d.h() == false) goto L94;
        Function0<Unit> r127 = new ECAnchorV3Helper$startFromGuessULike$3$2$1(r123);     // Catch: Throwable -> L97
        Intrinsics.checkNotNullParameter(r127, "cb");     // Catch: Throwable -> L97
        r123.f164364e = r127;     // Catch: Throwable -> L97
    L94:
        r123.I();     // Catch: Throwable -> L97
    L87:
        r122 = com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_DETAIL;
        goto L88
    L71:
        if (r114.optInt(com.bytedance.android.ec.core.event.a.KEY_IS_LUBAN) != 1) goto L73;
        boolean r128 = true;
    L74:
        if (r115 == null) goto L76;
        String r129 = r115.optString(com.bytedance.android.ec.core.event.a.KEY_PAGE_ID);     // Catch: Throwable -> L97
    L77:
        if (r115 == null) goto L79;
        r103 = r115.optString("source_type");     // Catch: Throwable -> L97
    L79:
        r311 = new ECLubanData(r128, r129, r103, null, 8, null);     // Catch: Throwable -> L97
        goto L82
    L76:
        r129 = null;
        goto L77
    L73:
        r128 = false;
    L67:
        r120 = new JSONObject();     // Catch: Throwable -> L97
    L62:
        r212 = null;
    L56:
        r211 = r712;
    L49:
        r510 = r811;
    L43:
        r411 = r711;
        goto L44
    L36:
        r115 = null;
    L33:
        r114 = null;
    L97:
        th = move-exception;
        Result.Companion r130 = Result.Companion;
        r125 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L21:
        r104 = null;
        goto L22
    L23:
        r410 = r813;
        goto L103
    L106:
        return;
    }

    public static void g(Context r410, ECProductInfo r411, ECAwemeItemInfo r412, JSONObject r413, ECAdLogExtra r414, ECBoltParam r415, String r510, String r511, String r512, String r513, ECProductDetailPageShowStyle r514, ECLubanData r515, ECLogExtraData r516, JSONObject r517, ECUIParam r518, Boolean r519, m r610, Boolean r611) {
        Intrinsics.checkNotNullParameter(r410, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r411, "productInfo");
        Intrinsics.checkNotNullParameter(r412, "awemeInfo");
        Intrinsics.checkNotNullParameter(r413, "metaParam");
        Intrinsics.checkNotNullParameter(r514, "detailPageStyle");
        Intrinsics.checkNotNullParameter(r516, "logExtraData");
        boolean r100 = false;
        if (r412.getShouldEnterProductFeed() == false) goto L9;
        if (r519 == null) goto L7;
        r100 = r519.booleanValue();
    L7:
        new ProductFeedStarter(r410, r411, r412, r413, r510, r511, r513, r514, r516, r517, r518, false, Boolean.valueOf(r100), r610).h();
        return;
    L9:
        if (r519 == null) goto L11;
        r100 = r519.booleanValue();
    L11:
        final AnchorV3Starter r101 = new AnchorV3Starter(r410, r411, r412, r413, r414, r415, r510, r511, r513, r514, r515, r516, r517, r518, false, null, null, Boolean.valueOf(r100), null, null, r610, null, null, null, null, r512, null, r611, null, 904757248);
        int r102 = o.f43817a;
        if (o.a(8) == false) goto L15;
        new PdpSchemaOld2NewConverter(r101).d("ECAnchorV3Helper.start");
        return;
    L15:
        if (com.bytedance.android.ec.core.abtest.d.h() == false) goto L17;
        Function0<Unit> r103 = new ECAnchorV3Helper$start$1$1(r101);
        Intrinsics.checkNotNullParameter(r103, "cb");
        r101.f164364e = r103;
    L17:
        r101.I();
    }

    @Override // p83.e
    public final void a(Context r910, String r911, String r912, String r913, String r914, String r100, String r101, Integer r102, String r103, String r104, String r105, String r106, String r107, JSONObject r108, String r109, boolean r110, String r111, String r112, long r113, Boolean r115, String r116, Integer r117, String r118, Integer r119, String r120, String r121, String r122) {
        Intrinsics.checkNotNullParameter(r910, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r911, "currentPromotionId");
        Intrinsics.checkNotNullParameter(r912, "enterFrom");
        Intrinsics.checkNotNullParameter("click_store_product", "enterMethod");
        Intrinsics.checkNotNullParameter(r914, "kolId");
        Intrinsics.checkNotNullParameter(r100, "secKolId");
        Intrinsics.checkNotNullParameter(r106, "metaParamsEntranceInfo");
        System.currentTimeMillis();
        ECProductInfo r410 = new ECProductInfo(r911, r101, null, null, 0, null, r109, null, r113, 0, null, null, null, null, null, null, null, r116, r117, null, null, null, null, 7995068, null);
        JSONObject r114 = new JSONObject(r105);
        String r123 = r114.optString("ecom_scene_id");
        if (r123 != null) goto L5;
    L8:
        boolean r124 = true;
    L9:
        if (r124 == true) goto L11;
    L17:
        r114.put(com.bytedance.android.ec.core.event.a.KEY_ECOM_GROUP_TYPE, "product_card");
        Unit r125 = Unit.INSTANCE;
        String r126 = r114.toString();
        ECAwemeItemInfo r127 = new ECAwemeItemInfo(r913, r914, r100, r102, false, null, false, 0, null, null, null, null, false, false, null, null, null, null, null, false, 1048560, null);
        JSONObject r128 = new JSONObject();
        r128.put("small_video_id", r913);
        r128.put(MiniAppConstants.KEY_MINI_APP_LIVE_ROOM_ID, r111);
        r128.put(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO, r106);
        if (r122 == null) goto L20;
        r128.put("header_config", r122);
    L20:
        ECProductDetailPageShowStyle r129 = new ECProductDetailPageShowStyle(r110, Intrinsics.areEqual(r115, Boolean.TRUE), 0, false, 12, null);
        JSONObject r130 = new JSONObject();
        r130.put("search_params", r107);
        final AnchorV3Starter r131 = new AnchorV3Starter(r910, r410, r127, r128, null, null, r126, r121, null, r129, null, new ECLogExtraData(r912, "click_store_product", r103, r130.toString(), r104, null, null, null, null, null, null, null, null, null, null, null, null, null, 262112, null), r108, new ECUIParam(null, false, false, null, null, null, r112, null, null, null, null, null, null, false, false, null, null, null, null, null, null, (WireFrameSchemaInfo) p83.a.a(r120, WireFrameSchemaInfo.class), r119, null, null, null, false, false, false, null, 0.0f, 0, null, -6291521, 1, null), false, r111, null, null, null, null, null, r118, null, null, null, null, null, null, null, 534709552);
        int r132 = o.f43817a;
        if (o.a(256) == false) goto L24;
        new PdpSchemaOld2NewConverter(r131).d("ECAnchorV3Helper.startFromStore");
        return;
    L24:
        if (com.bytedance.android.ec.core.abtest.d.h() == false) goto L26;
        Function0<Unit> r133 = new ECAnchorV3Helper$startFromStore$4$1(r131);
        Intrinsics.checkNotNullParameter(r133, "cb");
        r131.f164364e = r133;
    L26:
        r131.I();
        return;
    L11:
        if (a.b(r914) == false) goto L17;
        if (Intrinsics.areEqual(r114.optString(com.bytedance.android.ec.core.event.a.KEY_STORE_TYPE), "shop") == false) goto L15;
        String r134 = "1003";
    L16:
        r114.put("ecom_scene_id", r134);
        goto L17
    L15:
        r134 = "1004";
        goto L16
    L5:
        if (r123.length() == 0) goto L8;
        r124 = false;
        goto L9
    }
}
