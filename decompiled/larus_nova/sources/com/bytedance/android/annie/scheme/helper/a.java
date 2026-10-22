package com.bytedance.android.annie.scheme.helper;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.annie.scheme.vo.refactor.BaseHybridParamVoNew;
import com.bytedance.android.annie.scheme.vo.refactor.CardParamVoNew;
import com.bytedance.android.annie.scheme.vo.refactor.FragmentParamVoNew;
import com.bytedance.android.annie.scheme.vo.refactor.PageType;
import com.bytedance.android.annie.scheme.vo.refactor.PopupHybridParamVoNew;
import com.bytedance.android.ec.model.promotion.ECFindSimilarConfig;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.optimize.statistics.FrescoMonitorConst;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f39809a = 0;

    static {
    }

    public static void a(String r100, Object r101, CardParamVoNew r102) {
        b(r100, r101, r102);
        Boolean r103 = null;
        String r104 = null;
        String r105 = null;
        String r106 = null;
        Boolean r107 = null;
        Boolean r108 = null;
        PageType r109 = null;
        Boolean r110 = null;
        Boolean r111 = null;
        Boolean r112 = null;
        String r113 = null;
        Boolean r114 = null;
        String r115 = null;
        Boolean r116 = null;
        Boolean r117 = null;
        String r118 = null;
        Boolean r119 = null;
        switch(r100.hashCode()) {
            case -1786654558: goto L134;
            case -1763635643: goto L126;
            case -1547314257: goto L118;
            case -994846351: goto L110;
            case -12378297: goto L102;
            case 109254796: goto L94;
            case 143821548: goto L86;
            case 245002646: goto L78;
            case 513905088: goto L70;
            case 604333860: goto L62;
            case 732733489: goto L54;
            case 883893994: goto L46;
            case 1065093234: goto L38;
            case 1077502526: goto L30;
            case 1085069613: goto L22;
            case 1466602694: goto L14;
            case 1611307821: goto L6;
            default: goto L175;
        };
    L175:
        return;
    L6:
        if (r100.equals(AppConstants.BUNDLE_WAP_HEADERS) == true) goto L9;
        return;
    L9:
        if ((r101 instanceof String) == false) goto L11;
        r104 = (String) r101;
    L11:
        if (r104 == null) goto L142;
        r102.e1(r104);
        return;
    L142:
        return;
    L14:
        if (r100.equals("forest_session_id") == true) goto L17;
        return;
    L17:
        if ((r101 instanceof String) == false) goto L19;
        r105 = (String) r101;
    L19:
        if (r105 == null) goto L144;
        r102.d1(r105);
        return;
    L144:
        return;
    L22:
        if (r100.equals(AppConstants.BUNDLE_REFERER) == true) goto L25;
        return;
    L25:
        if ((r101 instanceof String) == false) goto L27;
        r106 = (String) r101;
    L27:
        if (r106 == null) goto L146;
        r102.o1(r106);
        return;
    L146:
        return;
    L30:
        if (r100.equals("screen_size_adaptation") == true) goto L33;
        return;
    L33:
        if ((r101 instanceof Boolean) == false) goto L35;
        r107 = (Boolean) r101;
    L35:
        if (r107 == null) goto L148;
        r102.s1(r107.booleanValue());
        return;
    L148:
        return;
    L38:
        if (r100.equals("create_view_sync") == true) goto L41;
        return;
    L41:
        if ((r101 instanceof Boolean) == false) goto L43;
        r108 = (Boolean) r101;
    L43:
        if (r108 == null) goto L150;
        r102.O0(r108.booleanValue());
        return;
    L150:
        return;
    L46:
        if (r100.equals("page_type") == true) goto L49;
        return;
    L49:
        if ((r101 instanceof PageType) == false) goto L51;
        r109 = (PageType) r101;
    L51:
        if (r109 == null) goto L152;
        r102.l1(r109);
        return;
    L152:
        return;
    L54:
        if (r100.equals("disable_thread_spread") == true) goto L57;
        return;
    L57:
        if ((r101 instanceof Boolean) == false) goto L59;
        r110 = (Boolean) r101;
    L59:
        if (r110 == null) goto L154;
        r102.S0(r110.booleanValue());
        return;
    L154:
        return;
    L62:
        if (r100.equals(AppConstants.BUNDLE_HIDE_POSTER) == true) goto L65;
        return;
    L65:
        if ((r101 instanceof Boolean) == false) goto L67;
        r111 = (Boolean) r101;
    L67:
        if (r111 == null) goto L156;
        r102.f1(r111.booleanValue());
        return;
    L156:
        return;
    L70:
        if (r100.equals(AppConstants.BUNDLE_LOAD_NO_CACHE) == true) goto L73;
        return;
    L73:
        if ((r101 instanceof Boolean) == false) goto L75;
        r112 = (Boolean) r101;
    L75:
        if (r112 == null) goto L158;
        r102.g1(r112.booleanValue());
        return;
    L158:
        return;
    L78:
        if (r100.equals("enable_font_scale") == true) goto L81;
        return;
    L81:
        if ((r101 instanceof String) == false) goto L83;
        r113 = (String) r101;
    L83:
        if (r113 == null) goto L160;
        r102.Z0(r113);
        return;
    L160:
        return;
    L86:
        if (r100.equals("enable_code_cache") == true) goto L89;
        return;
    L89:
        if ((r101 instanceof Boolean) == false) goto L91;
        r114 = (Boolean) r101;
    L91:
        if (r114 == null) goto L162;
        r102.X0(r114.booleanValue());
        return;
    L162:
        return;
    L94:
        if (r100.equals("scene") == true) goto L97;
        return;
    L97:
        if ((r101 instanceof String) == false) goto L99;
        r115 = (String) r101;
    L99:
        if (r115 == null) goto L164;
        r102.r1(r115);
        return;
    L164:
        return;
    L102:
        if (r100.equals("disable_host_jsb_method") == true) goto L105;
        return;
    L105:
        if ((r101 instanceof Boolean) == false) goto L107;
        r116 = (Boolean) r101;
    L107:
        if (r116 == null) goto L166;
        r102.R0(r116.booleanValue());
        return;
    L166:
        return;
    L110:
        if (r100.equals("enable_view_zoom") == true) goto L113;
        return;
    L113:
        if ((r101 instanceof Boolean) == false) goto L115;
        r117 = (Boolean) r101;
    L115:
        if (r117 == null) goto L168;
        r102.c1(r117.booleanValue());
        return;
    L168:
        return;
    L118:
        if (r100.equals("monitor_report_perf") == true) goto L121;
        return;
    L121:
        if ((r101 instanceof String) == false) goto L123;
        r118 = (String) r101;
    L123:
        if (r118 == null) goto L170;
        r102.h1(r118);
        return;
    L170:
        return;
    L126:
        if (r100.equals(AppConstants.BUNDLE_ENABLE_APP_CACHE) == true) goto L129;
        return;
    L129:
        if ((r101 instanceof Boolean) == false) goto L131;
        r119 = (Boolean) r101;
    L131:
        if (r119 == null) goto L172;
        r102.T0(r119.booleanValue());
        return;
    L172:
        return;
    L134:
        if (r100.equals("lock_resource") == true) goto L137;
        return;
    L137:
        if ((r101 instanceof Boolean) == false) goto L139;
        r103 = (Boolean) r101;
    L139:
        if (r103 == null) goto L174;
        r102.b1(r103.booleanValue());
        return;
    }

    public static void b(String r100, Object r101, BaseHybridParamVoNew r102) {
        Boolean r103 = null;
        Integer r104 = null;
        String r105 = null;
        Boolean r106 = null;
        String r107 = null;
        String r108 = null;
        Integer r109 = null;
        Boolean r110 = null;
        String r111 = null;
        String r112 = null;
        Boolean r113 = null;
        String r114 = null;
        Boolean r115 = null;
        String r116 = null;
        Integer r117 = null;
        String r118 = null;
        switch(r100.hashCode()) {
            case -1896450665: goto L126;
            case -1880523916: goto L118;
            case -1787150207: goto L110;
            case -1782949230: goto L102;
            case -1458885277: goto L94;
            case 116079: goto L86;
            case 204103253: goto L78;
            case 285033136: goto L70;
            case 292113626: goto L62;
            case 393688809: goto L54;
            case 460826418: goto L46;
            case 515866351: goto L38;
            case 620959543: goto L30;
            case 1447687381: goto L22;
            case 1886447384: goto L14;
            case 2024053914: goto L6;
            default: goto L165;
        };
    L165:
        return;
    L6:
        if (r100.equals("gradient_color_percent") == true) goto L9;
        return;
    L9:
        if ((r101 instanceof Integer) == false) goto L11;
        r104 = (Integer) r101;
    L11:
        if (r104 == null) goto L134;
        r102.N(r104.intValue());
        return;
    L134:
        return;
    L14:
        if (r100.equals("gradient_bg_color") == true) goto L17;
        return;
    L17:
        if ((r101 instanceof String) == false) goto L19;
        r105 = (String) r101;
    L19:
        if (r105 == null) goto L136;
        r102.M(r105);
        return;
    L136:
        return;
    L22:
        if (r100.equals("live_enable_view_remove") == true) goto L25;
        return;
    L25:
        if ((r101 instanceof Boolean) == false) goto L27;
        r106 = (Boolean) r101;
    L27:
        if (r106 == null) goto L138;
        r102.J(r106.booleanValue());
        return;
    L138:
        return;
    L30:
        if (r100.equals("loader_name") == true) goto L33;
        return;
    L33:
        if ((r101 instanceof String) == false) goto L35;
        r107 = (String) r101;
    L35:
        if (r107 == null) goto L140;
        r102.R(r107);
        return;
    L140:
        return;
    L38:
        if (r100.equals("_open_container_id") == true) goto L41;
        return;
    L41:
        if ((r101 instanceof String) == false) goto L43;
        r108 = (String) r101;
    L43:
        if (r108 == null) goto L142;
        r102.S(r108);
        return;
    L142:
        return;
    L46:
        if (r100.equals("lynx_thread") == true) goto L49;
        return;
    L49:
        if ((r101 instanceof Integer) == false) goto L51;
        r109 = (Integer) r101;
    L51:
        if (r109 == null) goto L144;
        r102.D = r109.intValue();
        return;
    L144:
        return;
    L54:
        if (r100.equals("is_out_url") == true) goto L57;
        return;
    L57:
        if ((r101 instanceof Boolean) == false) goto L59;
        r110 = (Boolean) r101;
    L59:
        if (r110 == null) goto L146;
        r102.W(Boolean.valueOf(r110.booleanValue()));
        return;
    L146:
        return;
    L62:
        if (r100.equals("origin_schema") == true) goto L65;
        return;
    L65:
        if ((r101 instanceof String) == false) goto L67;
        r111 = (String) r101;
    L67:
        if (r111 == null) goto L148;
        r102.U(r111);
        return;
    L148:
        return;
    L70:
        if (r100.equals("error_page_theme") == true) goto L73;
        return;
    L73:
        if ((r101 instanceof String) == false) goto L75;
        r112 = (String) r101;
    L75:
        if (r112 == null) goto L150;
        r102.K(r112);
        return;
    L150:
        return;
    L78:
        if (r100.equals(AppConstants.BUNDLE_PULL_DOWN_CLOSE) == true) goto L81;
        return;
    L81:
        if ((r101 instanceof Boolean) == false) goto L83;
        r113 = (Boolean) r101;
    L83:
        if (r113 == null) goto L152;
        r102.Y(r113.booleanValue());
        return;
    L152:
        return;
    L86:
        if (r100.equals("url") == true) goto L89;
        return;
    L89:
        if ((r101 instanceof String) == false) goto L91;
        r114 = (String) r101;
    L91:
        if (r114 == null) goto L154;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r114, "<set-?>");
        r102.f39814b = r114;
        return;
    L154:
        return;
    L94:
        if (r100.equals("hide_status_bar") == true) goto L97;
        return;
    L97:
        if ((r101 instanceof Boolean) == false) goto L99;
        r115 = (Boolean) r101;
    L99:
        if (r115 == null) goto L156;
        r102.O(r115.booleanValue());
        return;
    L156:
        return;
    L102:
        if (r100.equals("fallback_url") == true) goto L105;
        return;
    L105:
        if ((r101 instanceof String) == false) goto L107;
        r116 = (String) r101;
    L107:
        if (r116 == null) goto L158;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r116, "<set-?>");
        r102.f39815c = r116;
        return;
    L158:
        return;
    L110:
        if (r100.equals("preset_width_px") == true) goto L113;
        return;
    L113:
        if ((r101 instanceof Integer) == false) goto L115;
        r117 = (Integer) r101;
    L115:
        if (r117 == null) goto L160;
        r102.f39837y = r117.intValue();
        return;
    L160:
        return;
    L118:
        if (r100.equals("web_bg_color") == true) goto L121;
        return;
    L121:
        if ((r101 instanceof String) == false) goto L123;
        r118 = (String) r101;
    L123:
        if (r118 == null) goto L162;
        r102.a0(r118);
        return;
    L162:
        return;
    L126:
        if (r100.equals("_close_after_open_success") == true) goto L129;
        return;
    L129:
        if ((r101 instanceof Boolean) == false) goto L131;
        r103 = (Boolean) r101;
    L131:
        if (r103 == null) goto L164;
        r102.I(r103.booleanValue());
        return;
    }

    public static void c(String r100, Object r101, FragmentParamVoNew r102) {
        a(r100, r101, r102);
        Float r103 = null;
        Integer r104 = null;
        Boolean r105 = null;
        Integer r106 = null;
        Boolean r107 = null;
        Boolean r108 = null;
        Boolean r109 = null;
        Boolean r110 = null;
        String r111 = null;
        Boolean r112 = null;
        Boolean r113 = null;
        String r114 = null;
        Boolean r115 = null;
        String r116 = null;
        Boolean r117 = null;
        String r118 = null;
        Integer r119 = null;
        Boolean r120 = null;
        String r121 = null;
        String r122 = null;
        Boolean r123 = null;
        Boolean r124 = null;
        Boolean r125 = null;
        Boolean r126 = null;
        Boolean r127 = null;
        Boolean r128 = null;
        Boolean r129 = null;
        Boolean r130 = null;
        String r131 = null;
        Boolean r132 = null;
        Boolean r133 = null;
        switch(r100.hashCode()) {
            case -1933416097: goto L246;
            case -1907769275: goto L238;
            case -1903871767: goto L230;
            case -1707868953: goto L222;
            case -1377184773: goto L214;
            case -1344837085: goto L206;
            case -1120890771: goto L198;
            case -1102511297: goto L190;
            case -749844516: goto L182;
            case -672179027: goto L174;
            case -663792423: goto L166;
            case -518520834: goto L158;
            case -243025584: goto L150;
            case -230283601: goto L142;
            case -221187375: goto L134;
            case -153741693: goto L126;
            case 110371416: goto L118;
            case 290925818: goto L110;
            case 391608362: goto L102;
            case 575474545: goto L94;
            case 637387970: goto L86;
            case 798979869: goto L78;
            case 801943221: goto L70;
            case 859795946: goto L62;
            case 966266599: goto L54;
            case 1110780470: goto L46;
            case 1360639344: goto L38;
            case 1499312656: goto L30;
            case 1698019933: goto L22;
            case 1715384783: goto L14;
            case 1870141457: goto L6;
            default: goto L315;
        };
    L315:
        return;
    L6:
        if (r100.equals("bundle_web_bg_color") == true) goto L9;
        return;
    L9:
        if ((r101 instanceof Integer) == false) goto L11;
        r104 = (Integer) r101;
    L11:
        if (r104 == null) goto L254;
        r102.k2(r104.intValue());
        return;
    L254:
        return;
    L14:
        if (r100.equals("enable_card_cache") == true) goto L17;
        return;
    L17:
        if ((r101 instanceof Boolean) == false) goto L19;
        r105 = (Boolean) r101;
    L19:
        if (r105 == null) goto L256;
        r102.o2(r105.booleanValue());
        return;
    L256:
        return;
    L22:
        if (r100.equals("android_soft_input_mode") == true) goto L25;
        return;
    L25:
        if ((r101 instanceof Integer) == false) goto L27;
        r106 = (Integer) r101;
    L27:
        if (r106 == null) goto L258;
        r102.i2(r106.intValue());
        return;
    L258:
        return;
    L30:
        if (r100.equals("is_fullScreen") == true) goto L33;
        return;
    L33:
        if ((r101 instanceof Boolean) == false) goto L35;
        r107 = (Boolean) r101;
    L35:
        if (r107 == null) goto L260;
        r102.L(r107.booleanValue());
        return;
    L260:
        return;
    L38:
        if (r100.equals("is_real_full_screen") == true) goto L41;
        return;
    L41:
        if ((r101 instanceof Boolean) == false) goto L43;
        r108 = (Boolean) r101;
    L43:
        if (r108 == null) goto L262;
        r102.E2(r108.booleanValue());
        return;
    L262:
        return;
    L46:
        if (r100.equals(AppConstants.BUNDLE_SHOW_CLOSE) == true) goto L49;
        return;
    L49:
        if ((r101 instanceof Boolean) == false) goto L51;
        r109 = (Boolean) r101;
    L51:
        if (r109 == null) goto L264;
        r102.G2(r109.booleanValue());
        return;
    L264:
        return;
    L54:
        if (r100.equals("enable_pad_adapter") == true) goto L57;
        return;
    L57:
        if ((r101 instanceof Boolean) == false) goto L59;
        r110 = (Boolean) r101;
    L59:
        if (r110 == null) goto L266;
        r102.p2(r110.booleanValue());
        return;
    L266:
        return;
    L62:
        if (r100.equals(FrescoMonitorConst.PAGE_TAG) == true) goto L65;
        return;
    L65:
        if ((r101 instanceof String) == false) goto L67;
        r111 = (String) r101;
    L67:
        if (r111 == null) goto L268;
        r102.A2(r111);
        return;
    L268:
        return;
    L70:
        if (r100.equals("forbid_right_back") == true) goto L73;
        return;
    L73:
        if ((r101 instanceof Boolean) == false) goto L75;
        r112 = (Boolean) r101;
    L75:
        if (r112 == null) goto L270;
        r102.r2(r112.booleanValue());
        return;
    L270:
        return;
    L78:
        if (r100.equals(AppConstants.BUNDLE_SUPPORT_EXCHANGE_THEME) == true) goto L81;
        return;
    L81:
        if ((r101 instanceof Boolean) == false) goto L83;
        r113 = (Boolean) r101;
    L83:
        if (r113 == null) goto L272;
        r102.K2(r113.booleanValue());
        return;
    L272:
        return;
    L86:
        if (r100.equals(AppConstants.BUNDLE_STATUS_BAR_BG_COLOR) == true) goto L89;
        return;
    L89:
        if ((r101 instanceof String) == false) goto L91;
        r114 = (String) r101;
    L91:
        if (r114 == null) goto L274;
        r102.I2(r114);
        return;
    L274:
        return;
    L94:
        if (r100.equals("show_float_live") == true) goto L97;
        return;
    L97:
        if ((r101 instanceof Boolean) == false) goto L99;
        r115 = (Boolean) r101;
    L99:
        if (r115 == null) goto L276;
        r102.H2(r115.booleanValue());
        return;
    L276:
        return;
    L102:
        if (r100.equals(AppConstants.BUNDLE_STATUS_BAR_TEXT_COLOR) == true) goto L105;
        return;
    L105:
        if ((r101 instanceof String) == false) goto L107;
        r116 = (String) r101;
    L107:
        if (r116 == null) goto L278;
        r102.J2(r116);
        return;
    L278:
        return;
    L110:
        if (r100.equals("hide_nav_bar") == true) goto L113;
        return;
    L113:
        if ((r101 instanceof Boolean) == false) goto L115;
        r117 = (Boolean) r101;
    L115:
        if (r117 == null) goto L280;
        r102.t2(r117.booleanValue());
        return;
    L280:
        return;
    L118:
        if (r100.equals("title") == true) goto L121;
        return;
    L121:
        if ((r101 instanceof String) == false) goto L123;
        r118 = (String) r101;
    L123:
        if (r118 == null) goto L282;
        r102.L2(r118);
        return;
    L282:
        return;
    L126:
        if (r100.equals("icon_theme") == true) goto L129;
        return;
    L129:
        if ((r101 instanceof Integer) == false) goto L131;
        r119 = (Integer) r101;
    L131:
        if (r119 == null) goto L284;
        r102.v2(r119.intValue());
        return;
    L284:
        return;
    L134:
        if (r100.equals("lazy_load") == true) goto L137;
        return;
    L137:
        if ((r101 instanceof Boolean) == false) goto L139;
        r120 = (Boolean) r101;
    L139:
        if (r120 == null) goto L286;
        r102.y2(r120.booleanValue());
        return;
    L286:
        return;
    L142:
        if (r100.equals(AppbrandHostConstants.Schema_RESERVED_FIELD.LAUNCH_MOD) == true) goto L145;
        return;
    L145:
        if ((r101 instanceof String) == false) goto L147;
        r121 = (String) r101;
    L147:
        if (r121 == null) goto L288;
        r102.x2(r121);
        return;
    L288:
        return;
    L150:
        if (r100.equals(AppConstants.BUNDLE_PULL_DOWN_INDICATOR_COLOR) == true) goto L153;
        return;
    L153:
        if ((r101 instanceof String) == false) goto L155;
        r122 = (String) r101;
    L155:
        if (r122 == null) goto L290;
        r102.w2(r122);
        return;
    L290:
        return;
    L158:
        if (r100.equals("is_pop_up") == true) goto L161;
        return;
    L161:
        if ((r101 instanceof Boolean) == false) goto L163;
        r123 = (Boolean) r101;
    L163:
        if (r123 == null) goto L292;
        r102.B2(r123.booleanValue());
        return;
    L292:
        return;
    L166:
        if (r100.equals("disable_input_scroll") == true) goto L169;
        return;
    L169:
        if ((r101 instanceof Boolean) == false) goto L171;
        r124 = (Boolean) r101;
    L171:
        if (r124 == null) goto L294;
        r102.n2(r124.booleanValue());
        return;
    L294:
        return;
    L174:
        if (r100.equals("close_position_right") == true) goto L177;
        return;
    L177:
        if ((r101 instanceof Boolean) == false) goto L179;
        r125 = (Boolean) r101;
    L179:
        if (r125 == null) goto L296;
        r102.l2(r125.booleanValue());
        return;
    L296:
        return;
    L182:
        if (r100.equals(AppConstants.BUNDLE_PULL_DOWN_INDICATOR_NOT_SHOW) == true) goto L185;
        return;
    L185:
        if ((r101 instanceof Boolean) == false) goto L187;
        r126 = (Boolean) r101;
    L187:
        if (r126 == null) goto L298;
        r102.C2(r126.booleanValue());
        return;
    L298:
        return;
    L190:
        if (r100.equals("hide_loading") == true) goto L193;
        return;
    L193:
        if ((r101 instanceof Boolean) == false) goto L195;
        r127 = (Boolean) r101;
    L195:
        if (r127 == null) goto L300;
        r102.s2(r127.booleanValue());
        return;
    L300:
        return;
    L198:
        if (r100.equals("is_pull_up_popup") == true) goto L201;
        return;
    L201:
        if ((r101 instanceof Boolean) == false) goto L203;
        r128 = (Boolean) r101;
    L203:
        if (r128 == null) goto L302;
        r102.D2(r128.booleanValue());
        return;
    L302:
        return;
    L206:
        if (r100.equals(AppConstants.BUNDLE_ENABLE_SHARE) == true) goto L209;
        return;
    L209:
        if ((r101 instanceof Boolean) == false) goto L211;
        r129 = (Boolean) r101;
    L211:
        if (r129 == null) goto L304;
        r102.q2(r129.booleanValue());
        return;
    L304:
        return;
    L214:
        if (r100.equals(AppConstants.BUNDLE_USE_WEBVIEW_TITLE) == true) goto L217;
        return;
    L217:
        if ((r101 instanceof Boolean) == false) goto L219;
        r130 = (Boolean) r101;
    L219:
        if (r130 == null) goto L306;
        r130.booleanValue();
        r102.M2(((Boolean) r101).booleanValue());
        return;
    L306:
        return;
    L222:
        if (r100.equals("container_bg_color") == true) goto L225;
        return;
    L225:
        if ((r101 instanceof String) == false) goto L227;
        r131 = (String) r101;
    L227:
        if (r131 == null) goto L308;
        r102.m2(r131);
        return;
    L308:
        return;
    L230:
        if (r100.equals(AppConstants.BUNDLE_SHOW_BACK) == true) goto L233;
        return;
    L233:
        if ((r101 instanceof Boolean) == false) goto L235;
        r132 = (Boolean) r101;
    L235:
        if (r132 == null) goto L310;
        r102.F2(r132.booleanValue());
        return;
    L310:
        return;
    L238:
        if (r100.equals(AppConstants.BUNDLE_AUTO_SHOW_NAV_BAR) == true) goto L241;
        return;
    L241:
        if ((r101 instanceof Boolean) == false) goto L243;
        r133 = (Boolean) r101;
    L243:
        if (r133 == null) goto L312;
        r102.j2(r133.booleanValue());
        return;
    L312:
        return;
    L246:
        if (r100.equals("pad_ratio") == true) goto L249;
        return;
    L249:
        if ((r101 instanceof Float) == false) goto L251;
        r103 = (Float) r101;
    L251:
        if (r103 == null) goto L314;
        r102.z2(r103.floatValue());
        return;
    }

    @JvmStatic
    public static final void d(Object r100, String r101, Object r102) {
        Intrinsics.checkNotNullParameter(r101, "key");
        if (r100 != null) goto L5;
        return;
    L5:
        if ((r100 instanceof PopupHybridParamVoNew) == false) goto L378;
        PopupHybridParamVoNew r103 = (PopupHybridParamVoNew) r100;
        c(r101, r102, r103);
        Integer r104 = null;
        Integer r105 = null;
        Boolean r106 = null;
        Integer r107 = null;
        Integer r108 = null;
        Integer r109 = null;
        Integer r110 = null;
        Boolean r111 = null;
        Integer r112 = null;
        Boolean r113 = null;
        Integer r114 = null;
        Integer r115 = null;
        Integer r116 = null;
        String r117 = null;
        Integer r118 = null;
        Integer r119 = null;
        Boolean r120 = null;
        Integer r121 = null;
        Boolean r122 = null;
        Boolean r123 = null;
        Boolean r124 = null;
        Boolean r125 = null;
        Integer r126 = null;
        Boolean r127 = null;
        Integer r128 = null;
        Boolean r129 = null;
        Integer r130 = null;
        Boolean r131 = null;
        Integer r132 = null;
        Integer r133 = null;
        Integer r134 = null;
        Integer r135 = null;
        Integer r136 = null;
        Integer r137 = null;
        Boolean r138 = null;
        Boolean r139 = null;
        Integer r140 = null;
        Boolean r141 = null;
        Integer r142 = null;
        Integer r143 = null;
        Float r144 = null;
        Integer r145 = null;
        String r146 = null;
        Integer r147 = null;
        Integer r148 = null;
        Boolean r149 = null;
        switch(r101.hashCode()) {
            case -2128941634: goto L370;
            case -2127967371: goto L362;
            case -2126242710: goto L354;
            case -2126048564: goto L346;
            case -1910873363: goto L338;
            case -1885576152: goto L330;
            case -1623508405: goto L322;
            case -1568900271: goto L314;
            case -1567020219: goto L306;
            case -1371838820: goto L298;
            case -1369693265: goto L290;
            case -1362024143: goto L282;
            case -1319382654: goto L274;
            case -1221029593: goto L266;
            case -1198034453: goto L258;
            case -1130592979: goto L250;
            case -1114657387: goto L242;
            case -1081309778: goto L234;
            case -938578798: goto L226;
            case -886443644: goto L218;
            case -783420964: goto L210;
            case -573966911: goto L202;
            case -544400728: goto L194;
            case -502662633: goto L186;
            case -444571151: goto L178;
            case -442641634: goto L170;
            case -370010644: goto L162;
            case -338507706: goto L154;
            case -44574367: goto L146;
            case 113126854: goto L138;
            case 261938237: goto L130;
            case 280523342: goto L122;
            case 372533818: goto L114;
            case 420873502: goto L106;
            case 512141380: goto L98;
            case 543502411: goto L90;
            case 656597358: goto L82;
            case 847235192: goto L74;
            case 1082642850: goto L66;
            case 1235178289: goto L58;
            case 1318783681: goto L50;
            case 1365093645: goto L42;
            case 1630340454: goto L34;
            case 1956605077: goto L26;
            case 1993474684: goto L18;
            case 2115344153: goto L10;
            default: goto L483;
        };
    L483:
        return;
    L10:
        if (r101.equals("y_offset") == true) goto L13;
        return;
    L13:
        if ((r102 instanceof Integer) == false) goto L15;
        r105 = (Integer) r102;
    L15:
        if (r105 == null) goto L388;
        r103.z4(r105.intValue());
        return;
    L388:
        return;
    L18:
        if (r101.equals("landscape_custom_width") == true) goto L21;
        return;
    L21:
        if ((r102 instanceof Boolean) == false) goto L23;
        r106 = (Boolean) r102;
    L23:
        if (r106 == null) goto L390;
        r103.W3(r106.booleanValue());
        return;
    L390:
        return;
    L26:
        if (r101.equals("use_player_bottom_height") == true) goto L29;
        return;
    L29:
        if ((r102 instanceof Integer) == false) goto L31;
        r107 = (Integer) r102;
    L31:
        if (r107 == null) goto L392;
        r103.t4(r107.intValue());
        return;
    L392:
        return;
    L34:
        if (r101.equals("rate_height") == true) goto L37;
        return;
    L37:
        if ((r102 instanceof Integer) == false) goto L39;
        r108 = (Integer) r102;
    L39:
        if (r108 == null) goto L394;
        r103.k4(r108.intValue());
        return;
    L394:
        return;
    L42:
        if (r101.equals("horizontal_radius") == true) goto L45;
        return;
    L45:
        if ((r102 instanceof Integer) == false) goto L47;
        r109 = (Integer) r102;
    L47:
        if (r109 == null) goto L396;
        r103.R3(r109.intValue());
        return;
    L396:
        return;
    L50:
        if (r101.equals("pad_use_player_bottom_height") == true) goto L53;
        return;
    L53:
        if ((r102 instanceof Integer) == false) goto L55;
        r110 = (Integer) r102;
    L55:
        if (r110 == null) goto L398;
        r103.c4(r110.intValue());
        return;
    L398:
        return;
    L58:
        if (r101.equals("landscape_custom_height") == true) goto L61;
        return;
    L61:
        if ((r102 instanceof Boolean) == false) goto L63;
        r111 = (Boolean) r102;
    L63:
        if (r111 == null) goto L400;
        r103.V3(r111.booleanValue());
        return;
    L400:
        return;
    L66:
        if (r101.equals("horizontal_height") == true) goto L69;
        return;
    L69:
        if ((r102 instanceof Integer) == false) goto L71;
        r112 = (Integer) r102;
    L71:
        if (r112 == null) goto L402;
        r103.P3(r112.intValue());
        return;
    L402:
        return;
    L74:
        if (r101.equals("up_full_screen") == true) goto L77;
        return;
    L77:
        if ((r102 instanceof Boolean) == false) goto L79;
        r113 = (Boolean) r102;
    L79:
        if (r113 == null) goto L404;
        r103.L3(r113.booleanValue());
        return;
    L404:
        return;
    L82:
        if (r101.equals("radius_bottom_left") == true) goto L85;
        return;
    L85:
        if ((r102 instanceof Integer) == false) goto L87;
        r114 = (Integer) r102;
    L87:
        if (r114 == null) goto L406;
        r103.g4(r114.intValue());
        return;
    L406:
        return;
    L90:
        if (r101.equals("margin_right") == true) goto L93;
        return;
    L93:
        if ((r102 instanceof Integer) == false) goto L95;
        r115 = (Integer) r102;
    L95:
        if (r115 == null) goto L408;
        r103.Z3(r115.intValue());
        return;
    L408:
        return;
    L98:
        if (r101.equals("is_already_adaptation_ui") == true) goto L101;
        return;
    L101:
        if ((r102 instanceof Integer) == false) goto L103;
        r116 = (Integer) r102;
    L103:
        if (r116 == null) goto L410;
        r103.I3(r116.intValue());
        return;
    L410:
        return;
    L106:
        if (r101.equals("up_status_bar_bg_color") == true) goto L109;
        return;
    L109:
        if ((r102 instanceof String) == false) goto L111;
        r117 = (String) r102;
    L111:
        if (r117 == null) goto L412;
        r103.q4(r117);
        return;
    L412:
        return;
    L114:
        if (r101.equals("x_offset") == true) goto L117;
        return;
    L117:
        if ((r102 instanceof Integer) == false) goto L119;
        r118 = (Integer) r102;
    L119:
        if (r118 == null) goto L414;
        r103.y4(r118.intValue());
        return;
    L414:
        return;
    L122:
        if (r101.equals(GXTemplateKey.GAIAX_LAYER_GRAVITY) == true) goto L125;
        return;
    L125:
        if ((r102 instanceof Integer) == false) goto L127;
        r119 = (Integer) r102;
    L127:
        if (r119 == null) goto L416;
        r103.M3(r119.intValue());
        return;
    L416:
        return;
    L130:
        if (r101.equals(AppConstants.TRANS_STATUS_BAR) == true) goto L133;
        return;
    L133:
        if ((r102 instanceof Boolean) == false) goto L135;
        r120 = (Boolean) r102;
    L135:
        if (r120 == null) goto L418;
        r103.Z(r120.booleanValue());
        return;
    L418:
        return;
    L138:
        if (r101.equals("width") == true) goto L141;
        return;
    L141:
        if ((r102 instanceof Integer) == false) goto L143;
        r121 = (Integer) r102;
    L143:
        if (r121 == null) goto L420;
        r103.v4(r121.intValue());
        return;
    L420:
        return;
    L146:
        if (r101.equals("up_trans_status_bar") == true) goto L149;
        return;
    L149:
        if ((r102 instanceof Boolean) == false) goto L151;
        r122 = (Boolean) r102;
    L151:
        if (r122 == null) goto L422;
        r103.r4(r122.booleanValue());
        return;
    L422:
        return;
    L154:
        if (r101.equals("show_dim") == true) goto L157;
        return;
    L157:
        if ((r102 instanceof Boolean) == false) goto L159;
        r123 = (Boolean) r102;
    L159:
        if (r123 == null) goto L424;
        boolean r150 = r123.booleanValue();
        r103.l4(r150);
        r103.m4(r150);
        return;
    L424:
        return;
    L162:
        if (r101.equals("open_animate") == true) goto L165;
        return;
    L165:
        if ((r102 instanceof Boolean) == false) goto L167;
        r124 = (Boolean) r102;
    L167:
        if (r124 == null) goto L426;
        r103.b4(r124.booleanValue());
        return;
    L426:
        return;
    L170:
        if (r101.equals("mask_click_disable") == true) goto L173;
        return;
    L173:
        if ((r102 instanceof Boolean) == false) goto L175;
        r125 = (Boolean) r102;
    L175:
        if (r125 == null) goto L428;
        r103.J3(!r125.booleanValue());
        return;
    L428:
        return;
    L178:
        if (r101.equals("horizontal_width_percent") == true) goto L181;
        return;
    L181:
        if ((r102 instanceof Integer) == false) goto L183;
        r126 = (Integer) r102;
    L183:
        if (r126 == null) goto L430;
        r103.T3(r126.intValue());
        return;
    L430:
        return;
    L186:
        if (r101.equals("allowing_state_loss") == true) goto L189;
        return;
    L189:
        if ((r102 instanceof Boolean) == false) goto L191;
        r127 = (Boolean) r102;
    L191:
        if (r127 == null) goto L432;
        r103.H3(r127.booleanValue());
        return;
    L432:
        return;
    L194:
        if (r101.equals("horizontal_height_percent") == true) goto L197;
        return;
    L197:
        if ((r102 instanceof Integer) == false) goto L199;
        r128 = (Integer) r102;
    L199:
        if (r128 == null) goto L434;
        r103.Q3(r128.intValue());
        return;
    L434:
        return;
    L202:
        if (r101.equals("disable_nested_child_scroll") == true) goto L205;
        return;
    L205:
        if ((r102 instanceof Boolean) == false) goto L207;
        r129 = (Boolean) r102;
    L207:
        if (r129 == null) goto L436;
        r103.K3(r129.booleanValue());
        return;
    L436:
        return;
    L210:
        if (r101.equals("margin_bottom") == true) goto L213;
        return;
    L213:
        if ((r102 instanceof Integer) == false) goto L215;
        r130 = (Integer) r102;
    L215:
        if (r130 == null) goto L438;
        r103.Y3(r130.intValue());
        return;
    L438:
        return;
    L218:
        if (r101.equals("landscape_custom_gravity") == true) goto L221;
        return;
    L221:
        if ((r102 instanceof Boolean) == false) goto L223;
        r131 = (Boolean) r102;
    L223:
        if (r131 == null) goto L440;
        r103.U3(r131.booleanValue());
        return;
    L440:
        return;
    L226:
        if (r101.equals("radius") == true) goto L229;
        return;
    L229:
        if ((r102 instanceof Integer) == false) goto L231;
        r132 = (Integer) r102;
    L231:
        if (r132 == null) goto L442;
        r103.f4(r132.intValue());
        return;
    L442:
        return;
    L234:
        if (r101.equals(GXTemplateKey.FLEXBOX_MARGIN) == true) goto L237;
        return;
    L237:
        if ((r102 instanceof Integer) == false) goto L239;
        r133 = (Integer) r102;
    L239:
        if (r133 == null) goto L444;
        r103.X3(r133.intValue());
        return;
    L444:
        return;
    L242:
        if (r101.equals("radius_bottom_right") == true) goto L245;
        return;
    L245:
        if ((r102 instanceof Integer) == false) goto L247;
        r134 = (Integer) r102;
    L247:
        if (r134 == null) goto L446;
        r103.h4(r134.intValue());
        return;
    L446:
        return;
    L250:
        if (r101.equals(ECFindSimilarConfig.HEIGHT_PERCENT) == true) goto L253;
        return;
    L253:
        if ((r102 instanceof Integer) == false) goto L255;
        r135 = (Integer) r102;
    L255:
        if (r135 == null) goto L448;
        r103.O3(r135.intValue());
        return;
    L448:
        return;
    L258:
        if (r101.equals("horizontal_width") == true) goto L261;
        return;
    L261:
        if ((r102 instanceof Integer) == false) goto L263;
        r136 = (Integer) r102;
    L263:
        if (r136 == null) goto L450;
        r103.S3(r136.intValue());
        return;
    L450:
        return;
    L266:
        if (r101.equals("height") == true) goto L269;
        return;
    L269:
        if ((r102 instanceof Integer) == false) goto L271;
        r137 = (Integer) r102;
    L271:
        if (r137 == null) goto L452;
        r103.N3(r137.intValue());
        return;
    L452:
        return;
    L274:
        if (r101.equals(AppConstants.ARG_ABANDON_COORDINATE) == true) goto L277;
        return;
    L277:
        if ((r102 instanceof Boolean) == false) goto L279;
        r138 = (Boolean) r102;
    L279:
        if (r138 == null) goto L454;
        r103.G3(r138.booleanValue());
        return;
    L454:
        return;
    L282:
        if (r101.equals("use_real_screen_height") == true) goto L285;
        return;
    L285:
        if ((r102 instanceof Boolean) == false) goto L287;
        r139 = (Boolean) r102;
    L287:
        if (r139 == null) goto L456;
        r103.u4(r139.booleanValue());
        return;
    L456:
        return;
    L290:
        if (r101.equals("up_offset_height") == true) goto L293;
        return;
    L293:
        if ((r102 instanceof Integer) == false) goto L295;
        r140 = (Integer) r102;
    L295:
        if (r140 == null) goto L458;
        r103.p4(r140.intValue());
        return;
    L458:
        return;
    L298:
        if (r101.equals("use_bottom_close") == true) goto L301;
        return;
    L301:
        if ((r102 instanceof Boolean) == false) goto L303;
        r141 = (Boolean) r102;
    L303:
        if (r141 == null) goto L460;
        r103.s4(r141.booleanValue());
        return;
    L460:
        return;
    L306:
        if (r101.equals("radius_top_right") == true) goto L309;
        return;
    L309:
        if ((r102 instanceof Integer) == false) goto L311;
        r142 = (Integer) r102;
    L311:
        if (r142 == null) goto L462;
        r103.j4(r142.intValue());
        return;
    L462:
        return;
    L314:
        if (r101.equals("up_height_percent") == true) goto L317;
        return;
    L317:
        if ((r102 instanceof Integer) == false) goto L319;
        r143 = (Integer) r102;
    L319:
        if (r143 == null) goto L464;
        r103.o4(r143.intValue());
        return;
    L464:
        return;
    L322:
        if (r101.equals("mask_alpha") == true) goto L325;
        return;
    L325:
        if ((r102 instanceof Float) == false) goto L327;
        r144 = (Float) r102;
    L327:
        if (r144 == null) goto L466;
        r103.a4(r144.floatValue());
        return;
    L466:
        return;
    L330:
        if (r101.equals("close_icon_position") == true) goto L333;
        return;
    L333:
        if ((r102 instanceof Integer) == false) goto L335;
        r145 = (Integer) r102;
    L335:
        if (r145 == null) goto L468;
        r103.n4(r145.intValue());
        return;
    L468:
        return;
    L338:
        if (r101.equals("popup_type") == true) goto L341;
        return;
    L341:
        if ((r102 instanceof String) == false) goto L343;
        r146 = (String) r102;
    L343:
        if (r146 == null) goto L470;
        r103.d4(r146);
        return;
    L470:
        return;
    L346:
        if (r101.equals("width_percent") == true) goto L349;
        return;
    L349:
        if ((r102 instanceof Integer) == false) goto L351;
        r147 = (Integer) r102;
    L351:
        if (r147 == null) goto L472;
        r103.w4(r147.intValue());
        return;
    L472:
        return;
    L354:
        if (r101.equals(AppConstants.BUNDLE_PULL_DOWN_HEIGHT) == true) goto L357;
        return;
    L357:
        if ((r102 instanceof Integer) == false) goto L359;
        r148 = (Integer) r102;
    L359:
        if (r148 == null) goto L474;
        r103.e4(r148.intValue());
        return;
    L474:
        return;
    L362:
        if (r101.equals("window_floating") == true) goto L365;
        return;
    L365:
        if ((r102 instanceof Boolean) == false) goto L367;
        r149 = (Boolean) r102;
    L367:
        if (r149 == null) goto L476;
        r103.x4(r149.booleanValue());
        return;
    L476:
        return;
    L370:
        if (r101.equals("radius_top_left") == true) goto L373;
        return;
    L373:
        if ((r102 instanceof Integer) == false) goto L375;
        r104 = (Integer) r102;
    L375:
        if (r104 == null) goto L478;
        r103.i4(r104.intValue());
        return;
    L478:
        return;
    L378:
        if ((r100 instanceof FragmentParamVoNew) == false) goto L381;
        c(r101, r102, (FragmentParamVoNew) r100);
        return;
    L381:
        if ((r100 instanceof CardParamVoNew) == false) goto L384;
        a(r101, r102, (CardParamVoNew) r100);
        return;
    L384:
        if ((r100 instanceof BaseHybridParamVoNew) == false) goto L482;
        b(r101, r102, (BaseHybridParamVoNew) r100);
        return;
    }
}
