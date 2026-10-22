package com.bytedance.android.shopping.abilities.pdp;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.model.ECAdInfo;
import com.bytedance.android.ec.model.ECAdLogParams;
import com.bytedance.android.ec.model.promotion.ECFindSimilarConfig;
import com.bytedance.android.livehostapi.business.base.IBaseHostShare;
import com.bytedance.android.livehostapi.business.depend.livead.MiniAppConstants;
import com.bytedance.android.shopping.extensions.d;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.ugc.aweme.search.vision.model.data.PhotoEnterModel;
import df.p;
import df.q;
import df.r;
import ih3.g;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class a {
    public static final r b(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        String r101 = UriProtector.getQueryParameter(r100, "promotion_id");
        String r102 = "";
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        JSONObject r103 = k.w(UriProtector.getQueryParameter(r100, com.bytedance.android.ec.core.event.a.KEY_REQUEST_ADDITIONS));
        String r104 = a2.d(UriProtector.getQueryParameter(r100, "source_page"));
        if (r104 != null) goto L12;
        if (r103 == null) goto L9;
        r104 = r103.optString("enter_from");
    L10:
        if (r104 != null) goto L12;
    L14:
        return new r(r101, r102);
    L9:
        r104 = null;
    L12:
        r102 = r104;
        goto L14
    }

    public static final p a(Uri r610, boolean r611, boolean r612) {
        Intrinsics.checkNotNullParameter(r610, "uri");
        JSONObject r100 = k.w(UriProtector.getQueryParameter(r610, com.bytedance.android.ec.core.event.a.KEY_REQUEST_ADDITIONS));
        String r101 = a2.d(UriProtector.getQueryParameter(r610, "source_page"));
        if (r101 != null) goto L9;
        if (r100 == null) goto L6;
        r101 = r100.optString("enter_from");
    L7:
        if (r101 != null) goto L9;
        r101 = "";
        goto L9
    L6:
        r101 = null;
    L9:
        JSONObject r110 = k.w(UriProtector.getQueryParameter(r610, "v3_events_additions"));
        String r102 = UriProtector.getQueryParameter(r610, "log_extra");
        if (r102 != null) goto L12;
        r102 = "";
    L12:
        JSONObject r103 = k.w(UriProtector.getQueryParameter(r610, "meta_params"));
        if (r103 != null) goto L15;
        r103 = new JSONObject();
    L15:
        JSONObject r111 = r103;
        Object r104 = UriProtector.getQueryParameter(r610, "clear_screen_upon");
        if (r104 == null) goto L18;
        r111.put("clear_screen_upon", r104);
    L18:
        JSONObject r112 = k.w(r111.optString(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO));
        String r105 = a2.d(UriProtector.getQueryParameter(r610, com.bytedance.android.ec.core.event.a.KEY_ECOM_ENTRANCE_FORM));
        if (r105 != null) goto L21;
        r105 = UriProtector.getQueryParameter(r610, "carrier_type");
    L21:
        String r113 = r105;
        if (Intrinsics.areEqual(r101, "my_history") == false) goto L24;
    L25:
        if (r112 == null) goto L27;
        r112.put(com.bytedance.android.ec.core.event.a.KEY_SOURCE_METHOD, r113);
    L27:
        String r106 = UriProtector.getQueryParameter(r610, "creative_id");
        if (r106 != null) goto L30;
        String r114 = "";
    L31:
        g r107 = g.f489807b;
        ECAdInfo r108 = r107.A(null);
        if (r108 == null) goto L34;
        String r109 = r108.getLogExtra();
    L35:
        String r310 = UriProtector.getQueryParameter(r610, "mask_color");
        if (r114.length() <= 0) goto L38;
        boolean r115 = true;
    L39:
        if (r115 == true) goto L41;
    L47:
        if (r612 == false) goto L60;
        if (r112 == null) goto L60;
        String r116 = r112.optString(com.bytedance.android.ec.core.event.a.KEY_SHARE_CONTENT);
        if (r116 == null) goto L60;
        if (Intrinsics.areEqual(r116, com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_DETAIL) == false) goto L60;
        String r117 = r112.optString(com.bytedance.android.ec.core.event.a.KEY_SHARE_OBJECT);
        if (Intrinsics.areEqual(r117, "copy") == false) goto L56;
        JSONObject r118 = null;
        ih3.c.f489801b.a(r116, r117, false, null);
    L58:
        if (Intrinsics.areEqual(r117, IBaseHostShare.SHARE_TO_DAILY) == false) goto L60;
        ih3.c.f489801b.a(r116, r117, true, r118);
        goto L60
    L56:
        r118 = null;
    L60:
        String r119 = UriProtector.getQueryParameter(r610, "channel_id");
        if (r119 != null) goto L63;
        String r510 = r111.optString("channel_id");
    L64:
        int r120 = k.r(UriProtector.getQueryParameter(r610, WsConstants.KEY_CHANNEL_TYPE), 0);
        if (r120 != 0) goto L67;
        r120 = r111.optInt(WsConstants.KEY_CHANNEL_TYPE);
    L67:
        String r121 = UriProtector.getQueryParameter(r610, PhotoEnterModel.SOURCE_BTM_TOKEN);
        if (r100 == null) goto L70;
        String r122 = r100.optString("product_id");
    L71:
        if (r100 == null) goto L73;
        String r123 = r100.optString(com.bytedance.android.ec.core.event.a.KEY_RANK_ID);
    L74:
        String r124 = UriProtector.getQueryParameter(r610, "cover_img");
        String r125 = UriProtector.getQueryParameter(r610, "item_id");
        if (r125 != null) goto L77;
        String r126 = "";
    L78:
        String r127 = UriProtector.getQueryParameter(r610, com.bytedance.android.ec.core.event.a.KEY_KOL_ID);
        if (r127 != null) goto L81;
        String r210 = "";
    L82:
        if (r100 == null) goto L84;
        String r128 = r100.optString("sec_author_id");
    L85:
        if (r128 != null) goto L87;
        String r211 = "";
    L89:
        if (r110 == null) goto L99;
        Integer r212 = Integer.valueOf(r110.optInt("follow_status", -1));
        String r213 = "";
        if (r212.intValue() == (-1)) goto L93;
        boolean r129 = true;
    L94:
        if (r129 == true) goto L97;
        r212 = null;
    L97:
        if (r212 == null) goto L100;
    L108:
        Boolean r214 = Boolean.valueOf(k.n(UriProtector.getQueryParameter(r610, "fullscreen"), true));
        String r130 = UriProtector.getQueryParameter(r610, ECFindSimilarConfig.HEIGHT_PERCENT);
        if (r130 == null) goto L113;
        Float r131 = StringsKt.toFloatOrNull(r130);
        if (r131 == null) goto L113;
        Integer r311 = Integer.valueOf((int) r131.floatValue());
    L114:
        Integer r312 = Integer.valueOf(k.r(UriProtector.getQueryParameter(r610, "pdp_half_2026_height_type"), 0));
        String r132 = UriProtector.getQueryParameter(r610, "show_sku_panel");
        if (r132 == null) goto L128;
        int r133 = r132.hashCode();
        if (r133 == 49) goto L126;
        if (r133 != 50) goto L128;
        if (r132.equals("2") == false) goto L128;
        int r134 = 2;
    L129:
        Integer r215 = Integer.valueOf(r134);
        Boolean r216 = Boolean.valueOf(k.n(UriProtector.getQueryParameter(r610, com.bytedance.android.ec.core.event.a.KEY_IS_LUBAN), false));
        if (r100 == null) goto L132;
        String r135 = r100.optString(com.bytedance.android.ec.core.event.a.KEY_PAGE_ID);
    L133:
        if (r135 != null) goto L135;
        String r313 = r213;
    L136:
        if (r100 == null) goto L138;
        String r136 = r100.optString("source_type");
    L139:
        if (r136 != null) goto L141;
        String r314 = r213;
    L142:
        if (r100 == null) goto L144;
        String r137 = r100.optString("qianchuan_ab");
    L145:
        if (r137 != null) goto L147;
        String r315 = r213;
    L148:
        String r138 = UriProtector.getQueryParameter(r610, "enter_method");
        if (r138 != null) goto L151;
        String r316 = r213;
    L152:
        String r410 = UriProtector.getQueryParameter(r610, com.bytedance.android.ec.core.event.a.KEY_LABEL_NAME_LIVE);
        String r317 = UriProtector.getQueryParameter(r610, "label_name_from_live");
        String r411 = UriProtector.getQueryParameter(r610, com.bytedance.android.ec.core.event.a.KEY_BASE_VERIFIED_CATEGORY);
        String r139 = UriProtector.getQueryParameter(r610, com.bytedance.android.ec.core.event.a.KEY_THREE_D);
        if (r139 != null) goto L155;
        String r412 = r213;
    L156:
        q r318 = new q(r317, r411, r410, r412, 71);
        if (r112 == null) goto L159;
        String r413 = r112.optString(com.bytedance.android.ec.core.event.a.KEY_MODULE_LABEL);
    L160:
        Boolean r319 = Boolean.valueOf(k.n(UriProtector.getQueryParameter(r610, "disable_live_window"), false));
        String r140 = UriProtector.getQueryParameter(r610, "live_window_room_id");
        if (r140 != null) goto L163;
        String r320 = r213;
    L165:
        if (r112 == null) goto L167;
        String r414 = r112.optString(com.bytedance.android.ec.core.event.a.KEY_ECOM_ICON);
    L168:
        if (r112 == null) goto L170;
        String r415 = r112.optString("action_type");
    L171:
        boolean r416 = k.n(UriProtector.getQueryParameter(r610, "small_window_mute"), true);
        boolean r417 = k.n(UriProtector.getQueryParameter(r610, "small_window_priority"), true);
        String r141 = UriProtector.getQueryParameter(r610, "user_addr_id");
        Boolean r418 = Boolean.valueOf(r611);
        String r142 = r111.optString(MiniAppConstants.KEY_MINI_APP_LIVE_ROOM_ID);
        if (r142 != null) goto L174;
        String r419 = r213;
    L175:
        String r143 = UriProtector.getQueryParameter(r610, "domain_params");
        if (r143 != null) goto L178;
        String r511 = r213;
    L179:
        String r144 = UriProtector.getQueryParameter(r610, "is_from_ad");
        if (r144 == null) goto L182;
        Integer r145 = Integer.valueOf(k.r(r144, 0));
    L183:
        String r146 = UriProtector.getQueryParameter(r610, "enable_common_ad_track");
        if (r146 != null) goto L186;
        r146 = r213;
    L186:
        ECAdLogParams r147 = new ECAdLogParams(r145, r146);
        String r148 = UriProtector.getQueryParameter(r610, "ad_ui_control_params");
        if (r148 != null) goto L189;
        String r512 = r213;
    L191:
        if (k.c(r102) == false) goto L193;
        String r513 = UriProtector.getQueryParameter(r610, "ad_extra_data");
    L195:
        if (k.c(r102) == false) goto L197;
        String r514 = r102;
    L201:
        String r149 = UriProtector.getQueryParameter(r610, "fraction_listener_id");
        if (r149 != null) goto L205;
        r149 = r213;
    L205:
        return new p(r122, null, r123, r124, r141, r210, r211, r212, r126, r419, null, r214, r215, null, r112, r121, r111, r100, r216, r313, r314, r315, r316, r113, r110, r318, r319, r415, r320, null, r311, r312, r416, r417, r310, null, null, r114, r514, r513, r512, r511, r147, r418, null, r413, r414, r149, r510, Integer.valueOf(r120), 536880130, 4120);
    L197:
        String r150 = null;
        ECAdInfo r151 = r107.A(null);
        if (r151 == null) goto L200;
        r150 = r151.getLogExtra();
    L200:
        r514 = r150;
        goto L201
    L193:
        r513 = null;
        goto L195
    L189:
        r512 = r148;
        goto L191
    L182:
        r145 = null;
        goto L183
    L178:
        r511 = r143;
        goto L179
    L174:
        r419 = r142;
        goto L175
    L170:
        r415 = null;
        goto L171
    L167:
        r414 = null;
        goto L168
    L163:
        r320 = r140;
        goto L165
    L159:
        r413 = null;
        goto L160
    L155:
        r412 = r139;
        goto L156
    L151:
        r316 = r138;
        goto L152
    L147:
        r315 = r137;
        goto L148
    L144:
        r137 = null;
        goto L145
    L141:
        r314 = r136;
        goto L142
    L138:
        r136 = null;
        goto L139
    L135:
        r313 = r135;
        goto L136
    L132:
        r135 = null;
        goto L133
    L126:
        if (r132.equals("1") == false) goto L128;
        r134 = 1;
    L128:
        r134 = 0;
    L113:
        r311 = null;
    L100:
        if (r112 == null) goto L107;
        Integer r152 = Integer.valueOf(r112.optInt("follow_status"));
        if (r152.intValue() == (-1)) goto L104;
        boolean r153 = true;
    L105:
        if (r153 == false) goto L107;
        r212 = r152;
        goto L108
    L104:
        r153 = false;
    L107:
        r212 = null;
        goto L108
    L93:
        r129 = false;
        goto L94
    L99:
        r213 = "";
        goto L100
    L87:
        r211 = r128;
        goto L89
    L84:
        r128 = null;
        goto L85
    L81:
        r210 = r127;
        goto L82
    L77:
        r126 = r125;
        goto L78
    L73:
        r123 = null;
        goto L74
    L70:
        r122 = null;
        goto L71
    L63:
        r510 = r119;
        goto L64
    L41:
        if (TextUtils.isEmpty(r109) == true) goto L47;
        if (r112 == null) goto L44;
        d.b(r112, "log_extra", r109);
        Unit r154 = Unit.INSTANCE;
    L44:
        if (r112 == null) goto L46;
        d.b(r112, "creative_id", r114);
        Unit r155 = Unit.INSTANCE;
    L46:
        r111.put(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO, r112);
        goto L47
    L38:
        r115 = false;
        goto L39
    L34:
        r109 = null;
        goto L35
    L30:
        r114 = r106;
        goto L31
    L24:
        if (Intrinsics.areEqual(r101, "shopping_cart_tag") == false) goto L27;
        goto L25
    }
}
