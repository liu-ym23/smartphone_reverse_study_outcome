package com.bytedance.android.shopping.anchorv3.matchpurchase;

import android.content.Context;
import android.net.Uri;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.base.settings.d;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.opt.ab.c;
import com.bytedance.android.ec.core.opt.ab.m;
import com.bytedance.android.ec.core.opt.ab.n;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.model.promotion.ECFindSimilarConfig;
import com.bytedance.android.ec.monitor.duration.i;
import com.bytedance.android.shopping.anchorv3.matchpurchase.model.MatchPurchaseParams;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.services.apm.api.EnsureManager;
import com.ss.android.ugc.aweme.search.vision.model.data.PhotoEnterModel;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import o63.b;
import org.json.JSONArray;
import org.json.JSONObject;
import s83.a;
import s83.g;

/* JADX INFO: loaded from: classes12.dex */
public final class MatchPurchaseHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f165132a;

    static {
        f165132a = "";
    }

    public static boolean a() {
        int r100 = c.f45223a;
        int r101 = m.f45240a;
        Object r102 = 0;
        boolean r103 = ECServiceManager.f42805a;
        g r104 = (g) ECServiceManager.c(g.class);
        if (r104 == null) goto L8;
        a r105 = r104.q();
        if (r105 == null) goto L8;
        Object r106 = r105.e("combination_optimization");
        if (r106 == null) goto L8;
    L175:
        if (((Number) r106).intValue() == 0) goto L190;
        return true;
    L190:
        return false;
    L8:
        int r107 = n.f45241a;
        int r108 = com.bytedance.android.ec.base.settings.a.f42813a;
        Result.Companion r109 = Result.Companion;     // Catch: Throwable -> L165
        Object r110 = null;
        Object r111 = d.f42818c.get("combination_optimization");     // Catch: Throwable -> L60
        if (r111 != null) goto L15;
    L57:
        Object r112 = null;
    L58:
        Object r113 = Result.m9449constructorimpl(r112);     // Catch: Throwable -> L60
    L62:
        Throwable r114 = Result.m9452exceptionOrNullimpl(r113);     // Catch: Throwable -> L165
        if (r114 == null) goto L66;
        EnsureManager.ensureNotReachHere(r114);     // Catch: Throwable -> L165
    L66:
        if (Result.m9455isFailureimpl(r113) == false) goto L69;
        r113 = null;
    L69:
        if ((r113 instanceof Integer) == true) goto L71;
        r113 = null;
    L71:
        Integer r115 = (Integer) r113;     // Catch: Throwable -> L165
        if (r115 != null) goto L78;
        Object r116 = d.f42816a.get("combination_optimization");     // Catch: Throwable -> L165
        if ((r116 instanceof Integer) == true) goto L77;
        r116 = null;
    L77:
        r115 = (Integer) r116;     // Catch: Throwable -> L165
    L78:
        if (r115 == null) goto L80;
        r106 = r115;
        goto L175
    L80:
        int r117 = com.bytedance.android.ec.base.settings.c.f42815a;     // Catch: Throwable -> L165
        Object r118 = d.f42818c.get("combination_optimization");     // Catch: Throwable -> L130
        if (r118 != null) goto L85;
    L127:
        Object r119 = null;
    L128:
        Object r120 = Result.m9449constructorimpl(r119);     // Catch: Throwable -> L130
    L132:
        Throwable r121 = Result.m9452exceptionOrNullimpl(r120);     // Catch: Throwable -> L156
        if (r121 == null) goto L136;
        EnsureManager.ensureNotReachHere(r121);     // Catch: Throwable -> L156
    L136:
        if (Result.m9455isFailureimpl(r120) == false) goto L139;
        r120 = null;
    L139:
        if ((r120 instanceof Integer) == true) goto L141;
        r120 = null;
    L141:
        Integer r122 = (Integer) r120;     // Catch: Throwable -> L156
        if (r122 == null) goto L144;
        r106 = r122;
    L163:
        d.d("combination_optimization", r106);     // Catch: Throwable -> L165
        goto L175
    L144:
        IHybridHostService r123 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L156
        if (r123 == null) goto L147;
        Object r124 = r123.getHostABValue("combination_optimization", r102);     // Catch: Throwable -> L156
    L148:
        if (r124 != null) goto L150;
    L162:
        r106 = r102;
        goto L163
    L150:
        if ((r124 instanceof Integer) == false) goto L153;
        r110 = r124;
    L153:
        r106 = (Integer) r110;     // Catch: Throwable -> L156
        if (r106 != null) goto L163;
    L156:
        th = move-exception;
        Result.Companion r125 = Result.Companion;     // Catch: Throwable -> L165
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L165
        Throwable r126 = Result.m9452exceptionOrNullimpl(r106);     // Catch: Throwable -> L165
        if (r126 == null) goto L161;
        EnsureManager.ensureNotReachHere(r126);     // Catch: Throwable -> L165
    L161:
        if (Result.m9455isFailureimpl(r106) == false) goto L163;
    L147:
        r124 = null;
        goto L148
    L85:
        if ((r118 instanceof Integer) == true) goto L87;
        Object r127 = null;
    L88:
        r119 = (Integer) r127;     // Catch: Throwable -> L130
        if (r119 != null) goto L128;
        if ((r118 instanceof Number) == false) goto L115;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L100;
        Float r128 = Float.valueOf(((Number) r118).floatValue());     // Catch: Throwable -> L130
        if ((r128 instanceof Integer) == true) goto L98;
        r128 = null;
    L98:
        r119 = (Integer) r128;     // Catch: Throwable -> L130
        goto L128
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L106;
        Double r129 = Double.valueOf(((Number) r118).doubleValue());     // Catch: Throwable -> L130
        if ((r129 instanceof Integer) == true) goto L104;
        r129 = null;
    L104:
        r119 = (Integer) r129;     // Catch: Throwable -> L130
        goto L128
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L109;
        r119 = Integer.valueOf(((Number) r118).intValue());     // Catch: Throwable -> L130
        goto L128
    L109:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L115;
        Long r130 = Long.valueOf(((Number) r118).longValue());     // Catch: Throwable -> L130
        if ((r130 instanceof Integer) == true) goto L113;
        r130 = null;
    L113:
        r119 = (Integer) r130;     // Catch: Throwable -> L130
    L115:
        if ((r118 instanceof JSONObject) == false) goto L117;
    L188:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L123
        Object r131 = SDKSettingsCacheManager.a().fromJson(r118.toString(), Integer.class);     // Catch: Throwable -> L123
        if ((r131 instanceof Integer) == true) goto L121;
        r131 = null;
    L121:
        Object r132 = Result.m9449constructorimpl((Integer) r131);     // Catch: Throwable -> L123
    L125:
        r119 = r132;
        if (Result.m9455isFailureimpl(r119) == false) goto L128;
    L123:
        th = move-exception;
        Result.Companion r133 = Result.Companion;     // Catch: Throwable -> L130
        r132 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L130
        goto L125
    L117:
        if ((r118 instanceof JSONArray) == false) goto L127;
    L87:
        r127 = r118;
    L130:
        th = move-exception;
        Result.Companion r134 = Result.Companion;     // Catch: Throwable -> L156
        r120 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L156
        goto L132
    L15:
        if ((r111 instanceof Integer) == true) goto L17;
        Object r135 = null;
    L18:
        r112 = (Integer) r135;     // Catch: Throwable -> L60
        if (r112 != null) goto L58;
        if ((r111 instanceof Number) == false) goto L45;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L30;
        Float r136 = Float.valueOf(((Number) r111).floatValue());     // Catch: Throwable -> L60
        if ((r136 instanceof Integer) == true) goto L28;
        r136 = null;
    L28:
        r112 = (Integer) r136;     // Catch: Throwable -> L60
        goto L58
    L30:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L36;
        Double r137 = Double.valueOf(((Number) r111).doubleValue());     // Catch: Throwable -> L60
        if ((r137 instanceof Integer) == true) goto L34;
        r137 = null;
    L34:
        r112 = (Integer) r137;     // Catch: Throwable -> L60
        goto L58
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L39;
        r112 = Integer.valueOf(((Number) r111).intValue());     // Catch: Throwable -> L60
        goto L58
    L39:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L45;
        Long r138 = Long.valueOf(((Number) r111).longValue());     // Catch: Throwable -> L60
        if ((r138 instanceof Integer) == true) goto L43;
        r138 = null;
    L43:
        r112 = (Integer) r138;     // Catch: Throwable -> L60
    L45:
        if ((r111 instanceof JSONObject) == false) goto L47;
    L186:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L53
        Object r139 = SDKSettingsCacheManager.a().fromJson(r111.toString(), Integer.class);     // Catch: Throwable -> L53
        if ((r139 instanceof Integer) == true) goto L51;
        r139 = null;
    L51:
        Object r140 = Result.m9449constructorimpl((Integer) r139);     // Catch: Throwable -> L53
    L55:
        r112 = r140;
        if (Result.m9455isFailureimpl(r112) == false) goto L58;
    L53:
        th = move-exception;
        Result.Companion r141 = Result.Companion;     // Catch: Throwable -> L60
        r140 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L60
        goto L55
    L47:
        if ((r111 instanceof JSONArray) == false) goto L57;
    L17:
        r135 = r111;
    L60:
        th = move-exception;
        Result.Companion r142 = Result.Companion;     // Catch: Throwable -> L165
        r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L165
    L165:
        th = move-exception;
        Result.Companion r143 = Result.Companion;
        Object r144 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r145 = Result.m9452exceptionOrNullimpl(r144);
        if (r145 == null) goto L170;
        EnsureManager.ensureNotReachHere(r145);
    L170:
        if (Result.m9455isFailureimpl(r144) == true) goto L173;
        r102 = r144;
    L173:
        r106 = r102;
        goto L175
    }

    public static void b(final Context r410, Uri r411, boolean r412) {
        Intrinsics.checkNotNullParameter(r411, "uri");
        if ((r410 instanceof FragmentActivity) == true) goto L5;
        Context r100 = null;
    L6:
        final FragmentActivity r101 = (FragmentActivity) r100;
        if (r101 != null) goto L9;
        return;
    L9:
        String r110 = UriProtector.getQueryParameter(r411, "product_id");
        if (r110 != null) goto L12;
        String r111 = "";
    L13:
        String r112 = UriProtector.getQueryParameter(r411, "promotion_id");
        String r113 = UriProtector.getQueryParameter(r411, "combination_ids");
        if (r113 != null) goto L16;
        String r114 = "";
    L17:
        String r115 = UriProtector.getQueryParameter(r411, "enter_from");
        if (r115 != null) goto L20;
        r115 = "";
    L20:
        String r116 = UriProtector.getQueryParameter(r411, "source_page");
        if (r116 != null) goto L23;
        String r117 = "";
    L24:
        String r102 = UriProtector.getQueryParameter(r411, com.bytedance.android.ec.core.event.a.KEY_KOL_ID);
        if (r102 != null) goto L27;
        String r210 = "";
    L28:
        String r103 = UriProtector.getQueryParameter(r411, com.bytedance.android.ec.core.event.a.KEY_META_PARAM);
        String r118 = UriProtector.getQueryParameter(r411, "meta_params");
        if (r118 != null) goto L31;
        r118 = "";
    L31:
        String r104 = UriProtector.getQueryParameter(r411, com.bytedance.android.ec.core.event.a.KEY_REQUEST_ADDITIONS);
        if (r104 != null) goto L34;
        String r211 = "";
    L35:
        String r105 = UriProtector.getQueryParameter(r411, "cps_track");
        if (r105 != null) goto L38;
        String r212 = "";
    L39:
        String r106 = UriProtector.getQueryParameter(r411, com.bytedance.android.ec.core.event.a.KEY_MARKET_CHANNEL);
        if (r106 != null) goto L42;
        String r213 = "";
    L43:
        String r107 = UriProtector.getQueryParameter(r411, "is_fullscreen");
        String r108 = "1";
        if (r107 != null) goto L46;
        r107 = "1";
    L46:
        final String r310 = r115;
        String r119 = UriProtector.getQueryParameter(r411, "previous_source_page");
        String r214 = r111;
        if (r119 != null) goto L49;
        String r120 = "";
    L50:
        String r121 = UriProtector.getQueryParameter(r411, ECFindSimilarConfig.HEIGHT_PERCENT);
        if (r121 == null) goto L55;
        Float r122 = StringsKt.toFloatOrNull(r121);
        if (r122 == null) goto L55;
        Integer r215 = Integer.valueOf((int) r122.floatValue());
    L56:
        String r123 = UriProtector.getQueryParameter(r411, "is_pic_matching");
        if (r123 != null) goto L59;
        String r216 = "1";
    L60:
        String r124 = UriProtector.getQueryParameter(r411, PhotoEnterModel.SOURCE_BTM_TOKEN);
        if (r124 != null) goto L63;
        String r311 = "";
    L64:
        String r125 = UriProtector.getQueryParameter(r411, "combination_promotion_list");
        if (r125 != null) goto L67;
        String r312 = "";
    L68:
        boolean r126 = false;
        if (Intrinsics.areEqual(r120, "product_detail_page") == false) goto L71;
    L74:
        int r217 = 0;
    L75:
        boolean r109 = Intrinsics.areEqual(r107, "1");
        Map<String, String> r127 = t63.a.f544661a;     // Catch: Exception -> L131
        if (r118.length() <= 0) goto L79;
        boolean r128 = true;
    L80:
        if (r128 == true) goto L207;
        String r129 = null;
    L85:
        if (k.c(r103) == false) goto L92;
        String r218 = r118;
        String r130 = new JSONObject(r103).optString(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO);     // Catch: Exception -> L90
    L93:
        if (r130 != null) goto L205;
    L119:
        String r313 = "1";
        boolean r314 = r109;
    L120:
        if (r129 != null) goto L123;
        r129 = "";
    L123:
        if (r129.length() != 0) goto L125;
        boolean r131 = true;
    L126:
        if (r131 == false) goto L128;
        JSONObject r132 = new JSONObject();     // Catch: Exception -> L195
    L129:
        r132.put("previous_source_page", r120);     // Catch: Exception -> L195
        r132.put(com.bytedance.android.ec.core.event.a.KEY_COMBINATION_ID, r114);     // Catch: Exception -> L195
        r132.put("pd_click_page_name", "combination_page");     // Catch: Exception -> L195
        String r133 = r132.toString();     // Catch: Exception -> L195
    L133:
        if (r103 != null) goto L204;
        r103 = r218;
    L204:
    L140:
        JSONObject r134 = new JSONObject();
    L142:
        if (k.c(r133) == false) goto L144;
        r134.put(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO, r133);
    L144:
        Map<String, String> r135 = b.f522175c;
        String r136 = r120;
        String r315 = r114;
        JSONObject r219 = r134;
        Intrinsics.checkNotNullParameter(r133, "actualEntranceInfo");
        Intrinsics.checkNotNullParameter(r411, "uri");
    L191:
        e = e;
    L192:
        ECExceptionMonitor.e(e);
    L193:
        int r137 = r217;
        String r220 = r133;
        final MatchPurchaseParams r138 = new MatchPurchaseParams(r214, r112, r315, r137, 0, r310, r117, r210, r219.toString(), r211, r220, r212, r213, r136, r215, Intrinsics.areEqual(r216, r313), r314, r311, r312);
        f165132a = i.f47987a.create("ec_perf_duration_b08434");
        final boolean r139 = r314;
        com.bytedance.android.ec.core.utils.n.b(r410, r412, null, new MatchPurchaseHelper$startFromSchema$1(r310, r139, r410, r138, r101), MatchPurchaseHelper$startFromSchema$2.INSTANCE);
        return;
    L146:
        if (r133.length() != 0) goto L148;
        r126 = true;
    L148:
        if (r126 == false) goto L150;
        JSONObject r140 = new JSONObject();     // Catch: Exception -> L191
    L151:
        LinkedHashMap r141 = (LinkedHashMap) b.f522175c;     // Catch: Exception -> L191
        r141.clear();     // Catch: Exception -> L191
        String r142 = UriProtector.getQueryParameter(r411, com.bytedance.android.ec.core.event.a.KEY_ECOM_GROUP_TYPE);     // Catch: Exception -> L191
        if (r142 != null) goto L154;
        r142 = r140.optString(com.bytedance.android.ec.core.event.a.KEY_ECOM_GROUP_TYPE);     // Catch: Exception -> L191
    L154:
        String r413 = r133;
        r141.put(com.bytedance.android.ec.core.event.a.KEY_ECOM_GROUP_TYPE, r142);     // Catch: Exception -> L189
        String r143 = UriProtector.getQueryParameter(r411, "source_page");     // Catch: Exception -> L189
        if (r143 != null) goto L158;
        r143 = r140.optString("source_page");     // Catch: Exception -> L189
    L158:
        r141.put("source_page", r143);     // Catch: Exception -> L189
        String r144 = UriProtector.getQueryParameter(r411, com.bytedance.android.ec.core.event.a.KEY_ECOM_ENTRANCE_FORM);     // Catch: Exception -> L189
        if (r144 != null) goto L161;
        r144 = r140.optString(com.bytedance.android.ec.core.event.a.KEY_ECOM_ENTRANCE_FORM);     // Catch: Exception -> L189
    L161:
        r141.put(com.bytedance.android.ec.core.event.a.KEY_ECOM_ENTRANCE_FORM, r144);     // Catch: Exception -> L189
        String r145 = UriProtector.getQueryParameter(r411, "author_id");     // Catch: Exception -> L189
        if (r145 != null) goto L164;
        r145 = r140.optString("author_id");     // Catch: Exception -> L189
    L164:
        r141.put("author_id", r145);     // Catch: Exception -> L189
        String r146 = UriProtector.getQueryParameter(r411, "group_id");     // Catch: Exception -> L189
        if (r146 != null) goto L167;
        r146 = r140.optString("group_id");     // Catch: Exception -> L189
    L167:
        r141.put("group_id", r146);     // Catch: Exception -> L189
        String r147 = UriProtector.getQueryParameter(r411, "follow_status");     // Catch: Exception -> L189
        if (r147 != null) goto L170;
        r147 = r140.optString("follow_status");     // Catch: Exception -> L189
    L170:
        r141.put("follow_status", r147);     // Catch: Exception -> L189
        String r148 = UriProtector.getQueryParameter(r411, "product_id");     // Catch: Exception -> L189
        if (r148 != null) goto L173;
        r148 = r140.optString("product_id");     // Catch: Exception -> L189
    L173:
        r141.put("product_id", r148);     // Catch: Exception -> L189
        String r149 = UriProtector.getQueryParameter(r411, com.bytedance.android.ec.core.event.a.KEY_COMMODITY_TYPE);     // Catch: Exception -> L189
        if (r149 != null) goto L176;
        r149 = r140.optString(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_TYPE);     // Catch: Exception -> L189
    L176:
        r141.put(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_TYPE, r149);     // Catch: Exception -> L189
        String r150 = a2.d(r140.optString("room_id"));     // Catch: Exception -> L189
        if (r150 == null) goto L179;
        String r151 = (String) r141.put("room_id", r150);     // Catch: Exception -> L189
    L179:
        String r152 = a2.d(r140.optString("previous_source_page"));     // Catch: Exception -> L189
        if (r152 == null) goto L182;
        String r153 = (String) r141.put("previous_source_page", r152);     // Catch: Exception -> L189
    L182:
        String r154 = a2.d(UriProtector.getQueryParameter(r411, "track_additions"));     // Catch: Exception -> L189
        if (r154 == null) goto L185;
        JSONObject r155 = new JSONObject(r154);     // Catch: Exception -> L189
        r141.put(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_TYPE, r155.optString(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_TYPE));     // Catch: Exception -> L189
        String r156 = (String) r141.put(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_ID, r155.optString(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_ID));     // Catch: Exception -> L189
    L185:
        r141.put(com.bytedance.android.ec.core.event.a.KEY_COMBINATION_ID, r140.optString(com.bytedance.android.ec.core.event.a.KEY_COMBINATION_ID));     // Catch: Exception -> L189
        r141.put("pd_click_page_name", "combination_page");     // Catch: Exception -> L189
        r133 = r413;
        String r157 = (String) r141.put(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO, r133);     // Catch: Exception -> L191
    L189:
        e = e;
        r133 = r413;
        goto L192
    L150:
        r140 = new JSONObject(r133);     // Catch: Exception -> L191
        goto L151
    L136:
        if (k.c(r103) == false) goto L138;
        r134 = new JSONObject(r103);     // Catch: Exception -> L140
        goto L142
    L138:
        r134 = new JSONObject();     // Catch: Exception -> L140
    L132:
        r133 = "";
        goto L133
    L128:
        r132 = new JSONObject(r129);     // Catch: Exception -> L195
        goto L129
    L125:
        r131 = false;
        goto L126
    L205:
    L118:
        r313 = "1";
        r314 = r109;
        goto L132
    L95:
        if (r130.length() != 0) goto L97;
        boolean r316 = true;
    L98:
        if (r316 == true) goto L119;
        if (r129 == null) goto L117;
        if (r129.length() != 0) goto L104;
        boolean r317 = true;
    L105:
        if (r317 == true) goto L117;
        r314 = r109;
        JSONObject r158 = new JSONObject(r129);     // Catch: Exception -> L115
        JSONObject r159 = new JSONObject(r130);     // Catch: Exception -> L115
        Iterator<String> r160 = r159.keys();     // Catch: Exception -> L115
    L110:
        if (r160.hasNext() == false) goto L114;
        Iterator<String> r318 = r160;
        String r161 = r160.next();     // Catch: Exception -> L115
        r313 = r108;
        r158.put(r161, r159.optString(r161));     // Catch: Exception -> L195
        r108 = r313;
        r160 = r318;
        goto L110
    L114:
        r313 = r108;
        r129 = r158.toString();     // Catch: Exception -> L195
    L115:
        r313 = r108;
        goto L132
    L104:
        r317 = false;
    L117:
        r313 = "1";
        r314 = r109;
        r129 = r130;
        goto L120
    L97:
        r316 = false;
    L91:
        r313 = "1";
        r314 = r109;
        goto L132
    L92:
        r218 = r118;
        r130 = null;
        goto L93
    L207:
        r129 = new JSONObject(r118).optString(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO);     // Catch: Exception -> L83
    L83:
        r218 = r118;
        goto L91
    L79:
        r128 = false;
    L131:
        r313 = "1";
        r314 = r109;
        r218 = r118;
        goto L132
    L71:
        if (Intrinsics.areEqual(r120, "store_page") == true) goto L74;
        r217 = 1;
        goto L75
    L67:
        r312 = r125;
        goto L68
    L63:
        r311 = r124;
        goto L64
    L59:
        r216 = r123;
    L55:
        r215 = null;
        goto L56
    L49:
        r120 = r119;
        goto L50
    L42:
        r213 = r106;
        goto L43
    L38:
        r212 = r105;
        goto L39
    L34:
        r211 = r104;
        goto L35
    L27:
        r210 = r102;
        goto L28
    L23:
        r117 = r116;
        goto L24
    L16:
        r114 = r113;
        goto L17
    L12:
        r111 = r110;
        goto L13
    L5:
        r100 = r410;
        goto L6
    }
}
