package com.bytedance.android.ec.core.hybrid.utils;

import android.net.Uri;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.common.impl.order.OrderSchema;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.monitor.ECMonitorService;
import com.bytedance.android.ec.core.monitor.MetricNames;
import com.bytedance.android.ec.core.monitor.MonitorScenes;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.model.order.IOrderSchema;
import com.bytedance.android.ecom.bcm.track.api.EcomBcmTracker;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.services.apm.api.EnsureManager;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap<String, JSONObject> f44312a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f44313b = null;

    public j() {
    }

    static {
        f44312a = new HashMap();
        f44313b = new String[]{"meta_params", com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO, "log_data", "cid", "creative_id", "log_extra", com.bytedance.android.ec.core.event.a.KEY_CJ_INFO};
    }

    public static void a(IOrderSchema r100) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        if (r100.x1() == false) goto L30;
        OrderSchema.b r101 = r100.P0();
        gl.a r102 = r100.P();
        if (r101 == null) goto L7;
        r101.c(r102);
    L7:
        Object r103 = r100.Q();
        if ((r103 instanceof String) == true) goto L10;
        r103 = null;
    L10:
        String r104 = (String) r103;
        int r105 = 0;
        if (r104 != null) goto L13;
    L16:
        boolean r106 = true;
    L18:
        if (r106 == false) goto L20;
        r104 = r100.getQueryParam(com.bytedance.android.ec.core.event.a.KEY_CJ_INFO);
    L20:
        r100.t0(com.bytedance.android.ec.core.event.a.KEY_CJ_INFO, r104);
        JSONObject r107 = r100.q1();
        if (r107 == null) goto L26;
        Iterator<String> r108 = r107.keys();
    L24:
        if (r108.hasNext() == false) goto L26;
        String r109 = r108.next();
        r100.t0(r109, r107.opt(r109));
    L26:
        String[] r110 = f44313b;
        int r111 = r110.length;
    L27:
        if (r105 >= r111) goto L29;
        r100.c(r110[r105]);
        r105 = r105 + 1;
        goto L27
    L29:
        return;
    L13:
        if (r104.length() == 0) goto L16;
        r106 = false;
        goto L18
    L30:
        r100.m1(r100.A0());
        a(r100);
    }

    public static JSONObject d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "id");
        return f44312a.get(r100);
    }

    public static boolean e(String r100) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if (r100.length() <= 0) goto L6;
        return true;
    }

    public static JSONObject i(String r100) {
    L6:
        e = move-exception;
        ECExceptionMonitor.f(e, "json_format_error");
        return null;
    L3:
        if (e(r100) == false) goto L12;
        return new JSONObject(r100);
    L12:
        return null;
    }

    public static String f(String r100, String r101) {
        JSONObject r102 = i(r101);
        if (r102 == null) goto L14;
        JSONObject r103 = i(r100);
        if (r103 == null) goto L12;
        Iterator<String> r104 = r102.keys();
    L8:
        if (r104.hasNext() == false) goto L15;
        String r105 = r104.next();
        r103.put(r105, r102.get(r105));
        goto L8
    L15:
        return r103.toString();
    L12:
        return r102.toString();
    L14:
        return r100;
    }

    public static void h(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "id");
        if (r101 == null) goto L5;
        f44312a.put(r100, r101);
        return;
    L5:
        JSONObject r102 = f44312a.remove(r100);
    }

    public static /* synthetic */ String c(String r100, boolean r101, int r102) {
        if ((r102 & 2) == 0) goto L5;
        boolean r103 = true;
    L7:
        if ((r102 & 4) == 0) goto L9;
        String r104 = "";
    L11:
        if ((r102 & 8) == 0) goto L14;
        r101 = false;
    L14:
        return b(r100, r103, r104, r101);
    L9:
        r104 = null;
        goto L11
    L5:
        r103 = false;
        goto L7
    }

    public static void g(JSONObject r100, String r101, String r102) {
        if (r102 != null) goto L4;
    L7:
        boolean r103 = true;
    L8:
        if (r103 == false) goto L10;
        return;
    L10:
        r100.put(r101, r102);
        return;
    L4:
        if (r102.length() == 0) goto L7;
        r103 = false;
        goto L8
    }

    public static String b(String r210, boolean r211, String r212, boolean r213) {
        String r100 = r210;
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r212, "passThroughMonitorId");
        int r101 = 0;
        if (r212.length() != 0) goto L5;
        boolean r102 = true;
    L7:
        if (r102 == false) goto L9;
        Map<String, com.bytedance.android.ec.core.monitor.a> r103 = com.bytedance.android.ec.core.monitor.c.f45142a;
        String r104 = com.bytedance.android.ec.core.monitor.c.c(MonitorScenes.EC_JSON_DEAL_DURATION, null);
        com.bytedance.android.ec.core.monitor.c.e(r104, "type", "mega_object");
        com.bytedance.android.ec.core.monitor.c.f(r104, "url", r100);
        com.bytedance.android.ec.core.monitor.c.h(r104, MetricNames.DEAL_DURATION, null);
    L10:
        if (r211 == false) goto L12;
        String r105 = com.bytedance.android.ec.core.event.a.KEY_RIFLE_MEGA_OBJECT;
        String r110 = "rifle_mega_object_id";
    L14:
        if (StringsKt.contains$default(r100, r105, false, 2, null) == false) goto L271;
        Uri r106 = UriProtector.parse(r210);
        String r111 = UriProtector.getQueryParameter(r106, r105);
        if (r111 == null) goto L270;
        JSONObject r112 = i(r111);
        if (r112 == null) goto L270;
        JSONObject r113 = new JSONObject(r112.toString());
        String r107 = r112.optString(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO);
        String r114 = UriProtector.getQueryParameter(r106, com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO);
        if (r114 != null) goto L23;
    L31:
        String r115 = EcomBcmTracker.b(null, r107);
        String r116 = r112.optString("log_data");
        String r108 = UriProtector.getQueryParameter(r106, "log_data");
        if (r108 != null) goto L34;
    L42:
        int r109 = com.bytedance.android.ec.core.opt.ab.a.f45222a;
        int r117 = com.bytedance.android.ec.core.opt.ab.o.f45242a;
        Object r118 = 1;
        boolean r119 = ECServiceManager.f42805a;
        Object r120 = ((IAdapterService) ECServiceManager.c(IAdapterService.class)).getLiveSettingsValue("ec_fix_log_data", r118);
        if (r120 == null) goto L47;
        r118 = r120;
    L47:
        if (((Number) r118).intValue() != 1) goto L49;
        boolean r121 = true;
    L50:
        if (r121 == false) goto L65;
        if (r116 != null) goto L53;
    L56:
        boolean r122 = true;
    L57:
        if (r122 == true) goto L65;
        if (r213 == true) goto L65;
        JSONObject r123 = new JSONObject(r116);     // Catch: Exception -> L63
        if (r123.has(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO) == false) goto L65;
        r123.remove(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO);     // Catch: Exception -> L63
        r123.toString();     // Catch: Exception -> L63
    L63:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L65
    L53:
        if (r116.length() == 0) goto L56;
        r122 = false;
    L65:
        String r124 = r112.optString("log_extra");
        String r125 = r112.optString("cid");
        String r126 = r112.optString("ad_extra_data");
        String r214 = r104;
        String r127 = r112.optString(com.bytedance.android.ec.core.event.a.KEY_CJ_INFO);
        if (r127 != null) goto L68;
    L71:
        boolean r128 = true;
    L72:
        if (r128 == false) goto L74;
        r127 = UriProtector.getQueryParameter(r106, com.bytedance.android.ec.core.event.a.KEY_CJ_INFO);
    L74:
        String r129 = r110;
        String r130 = r112.optString("creative_id");
        String r215 = r105;
        Uri r216 = r106;
        String r131 = r112.optString("ecom_live_lynx_log_data");
        String r132 = r112.optString("ecom_live_lynx_data");
        g(r113, com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO, r115);
        g(r113, "log_extra", r124);
        g(r113, "cid", r125);
        g(r113, "ad_extra_data", r126);
        g(r113, com.bytedance.android.ec.core.event.a.KEY_CJ_INFO, r127);
        g(r113, "creative_id", r130);
        g(r113, "ecom_live_lynx_log_data", r131);
        g(r113, "ecom_live_lynx_data", r132);
        String r133 = r112.optString("adinfojson");
        if (r133 == null) goto L85;
        JSONObject r134 = i(r133);
        if (r134 == null) goto L85;
        Iterator<String> r135 = r134.keys();
    L285:
    L83:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L85
    L80:
        if (r135.hasNext() == false) goto L85;
        String r136 = r135.next();     // Catch: Exception -> L83
        r113.put(r136, r134.opt(r136));     // Catch: Exception -> L83
    L85:
        String[] r137 = f44313b;
        Set<String> r138 = UriProtector.getQueryParameterNames(r216);
        Uri.Builder r139 = r216.buildUpon().clearQuery();
        Iterator<String> r140 = r138.iterator();
    L87:
        if (r140.hasNext() == false) goto L95;
        String r141 = r140.next();
        String r142 = r215;
        if ((!Intrinsics.areEqual(r141, r142)) == true) goto L91;
    L93:
        Uri r143 = r216;
    L94:
        r216 = r143;
        r215 = r142;
        goto L87
    L91:
        if (ArraysKt.contains(r137, r141) == true) goto L93;
        r143 = r216;
        r139.appendQueryParameter(r141, UriProtector.getQueryParameter(r143, r141));
        goto L94
    L95:
        Uri r144 = r139.build();
        String r145 = UUID.randomUUID().toString();
        Uri.Builder r146 = r144.buildUpon();
        r146.appendQueryParameter(r129, r145);
        int r147 = zg.a.f571786a;
        int r148 = com.bytedance.android.ec.core.opt.ab.n.f45241a;
        boolean r149 = false;
        Object r150 = 0;
        int r151 = com.bytedance.android.ec.base.settings.a.f42813a;
        Result.Companion r152 = Result.Companion;     // Catch: Throwable -> L250
        Object r153 = com.bytedance.android.ec.base.settings.d.f42818c.get("ec_mega_object_inject");     // Catch: Throwable -> L146
        if (r153 != null) goto L101;
    L143:
        Object r154 = null;
    L144:
        Object r155 = Result.m9449constructorimpl(r154);     // Catch: Throwable -> L146
    L148:
        Throwable r156 = Result.m9452exceptionOrNullimpl(r155);     // Catch: Throwable -> L250
        if (r156 == null) goto L152;
        EnsureManager.ensureNotReachHere(r156);     // Catch: Throwable -> L250
    L152:
        if (Result.m9455isFailureimpl(r155) == false) goto L155;
        r155 = null;
    L155:
        if ((r155 instanceof Integer) == true) goto L157;
        r155 = null;
    L157:
        Object r157 = (Integer) r155;     // Catch: Throwable -> L250
        if (r157 != null) goto L164;
        Object r158 = com.bytedance.android.ec.base.settings.d.f42816a.get("ec_mega_object_inject");     // Catch: Throwable -> L250
        if ((r158 instanceof Integer) == true) goto L163;
        r158 = null;
    L163:
        r157 = (Integer) r158;     // Catch: Throwable -> L250
    L164:
        if (r157 != null) goto L260;
        int r159 = com.bytedance.android.ec.base.settings.c.f42815a;     // Catch: Throwable -> L250
        Object r160 = com.bytedance.android.ec.base.settings.d.f42818c.get("ec_mega_object_inject");     // Catch: Throwable -> L216
        if (r160 != null) goto L171;
    L213:
        Object r161 = null;
    L214:
        Object r162 = Result.m9449constructorimpl(r161);     // Catch: Throwable -> L216
    L218:
        Throwable r163 = Result.m9452exceptionOrNullimpl(r162);     // Catch: Throwable -> L241
        if (r163 == null) goto L222;
        EnsureManager.ensureNotReachHere(r163);     // Catch: Throwable -> L241
    L222:
        if (Result.m9455isFailureimpl(r162) == false) goto L225;
        r162 = null;
    L225:
        if ((r162 instanceof Integer) == true) goto L227;
        r162 = null;
    L227:
        r157 = (Integer) r162;     // Catch: Throwable -> L241
        if (r157 != null) goto L248;
        IHybridHostService r164 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L241
        if (r164 == null) goto L233;
        Object r165 = r164.getHostABValue("ec_mega_object_inject", r150);     // Catch: Throwable -> L241
    L234:
        if (r165 != null) goto L236;
    L247:
        r157 = r150;
        goto L248
    L236:
        if ((r165 instanceof Integer) == true) goto L238;
        r165 = null;
    L238:
        r157 = (Integer) r165;     // Catch: Throwable -> L241
        if (r157 != null) goto L248;
    L241:
        th = move-exception;
        Result.Companion r166 = Result.Companion;     // Catch: Throwable -> L250
        r157 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L250
        Throwable r167 = Result.m9452exceptionOrNullimpl(r157);     // Catch: Throwable -> L250
        if (r167 == null) goto L246;
        EnsureManager.ensureNotReachHere(r167);     // Catch: Throwable -> L250
    L246:
        if (Result.m9455isFailureimpl(r157) == false) goto L248;
    L233:
        r165 = null;
    L248:
        com.bytedance.android.ec.base.settings.d.d("ec_mega_object_inject", r157);     // Catch: Throwable -> L250
        goto L260
    L171:
        if ((r160 instanceof Integer) == true) goto L173;
        Object r168 = null;
    L174:
        r161 = (Integer) r168;     // Catch: Throwable -> L216
        if (r161 != null) goto L214;
        if ((r160 instanceof Number) == false) goto L201;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L186;
        Float r169 = Float.valueOf(((Number) r160).floatValue());     // Catch: Throwable -> L216
        if ((r169 instanceof Integer) == true) goto L184;
        r169 = null;
    L184:
        r161 = (Integer) r169;     // Catch: Throwable -> L216
        goto L214
    L186:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L192;
        Double r170 = Double.valueOf(((Number) r160).doubleValue());     // Catch: Throwable -> L216
        if ((r170 instanceof Integer) == true) goto L190;
        r170 = null;
    L190:
        r161 = (Integer) r170;     // Catch: Throwable -> L216
        goto L214
    L192:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L195;
        r161 = Integer.valueOf(((Number) r160).intValue());     // Catch: Throwable -> L216
        goto L214
    L195:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L201;
        Long r171 = Long.valueOf(((Number) r160).longValue());     // Catch: Throwable -> L216
        if ((r171 instanceof Integer) == true) goto L199;
        r171 = null;
    L199:
        r161 = (Integer) r171;     // Catch: Throwable -> L216
    L201:
        if ((r160 instanceof JSONObject) == false) goto L203;
    L289:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L209
        Object r172 = SDKSettingsCacheManager.a().fromJson(r160.toString(), Integer.class);     // Catch: Throwable -> L209
        if ((r172 instanceof Integer) == true) goto L207;
        r172 = null;
    L207:
        Object r173 = Result.m9449constructorimpl((Integer) r172);     // Catch: Throwable -> L209
    L211:
        r161 = r173;
        if (Result.m9455isFailureimpl(r161) == false) goto L214;
    L209:
        th = move-exception;
        Result.Companion r174 = Result.Companion;     // Catch: Throwable -> L216
        r173 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L216
        goto L211
    L203:
        if ((r160 instanceof JSONArray) == false) goto L213;
    L173:
        r168 = r160;
    L216:
        th = move-exception;
        Result.Companion r175 = Result.Companion;     // Catch: Throwable -> L241
        r162 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L241
    L260:
        if (((Number) r157).intValue() != 1) goto L262;
        boolean r176 = true;
    L263:
        if (r176 == false) goto L265;
        r146.appendQueryParameter("mega_object", r113.toString());
    L265:
        f44312a.put(r145, r113);
        r100 = r146.toString();
        JSONObject r177 = new JSONObject();
        r177.put("url", r100);
        r177.put(r129, r145);
        int r178 = ECMonitorService.f45110b;
        ECMonitorService.a.a("ec_rifle_mega_object", r177, null, null);
        if (r214.length() <= 0) goto L268;
        r149 = true;
    L268:
        if (r149 == false) goto L270;
        Map<String, com.bytedance.android.ec.core.monitor.a> r179 = com.bytedance.android.ec.core.monitor.c.f45142a;
        com.bytedance.android.ec.core.monitor.c.j(r214, MetricNames.DEAL_DURATION);
        com.bytedance.android.ec.core.monitor.c.d(r214);
        goto L270
    L262:
        r176 = false;
        goto L263
    L101:
        if ((r153 instanceof Integer) == true) goto L103;
        Object r180 = null;
    L104:
        r154 = (Integer) r180;     // Catch: Throwable -> L146
        if (r154 != null) goto L144;
        if ((r153 instanceof Number) == false) goto L131;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L116;
        Float r181 = Float.valueOf(((Number) r153).floatValue());     // Catch: Throwable -> L146
        if ((r181 instanceof Integer) == true) goto L114;
        r181 = null;
    L114:
        r154 = (Integer) r181;     // Catch: Throwable -> L146
        goto L144
    L116:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L122;
        Double r182 = Double.valueOf(((Number) r153).doubleValue());     // Catch: Throwable -> L146
        if ((r182 instanceof Integer) == true) goto L120;
        r182 = null;
    L120:
        r154 = (Integer) r182;     // Catch: Throwable -> L146
        goto L144
    L122:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L125;
        r154 = Integer.valueOf(((Number) r153).intValue());     // Catch: Throwable -> L146
        goto L144
    L125:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L131;
        Long r183 = Long.valueOf(((Number) r153).longValue());     // Catch: Throwable -> L146
        if ((r183 instanceof Integer) == true) goto L129;
        r183 = null;
    L129:
        r154 = (Integer) r183;     // Catch: Throwable -> L146
    L131:
        if ((r153 instanceof JSONObject) == false) goto L133;
    L287:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L139
        Object r184 = SDKSettingsCacheManager.a().fromJson(r153.toString(), Integer.class);     // Catch: Throwable -> L139
        if ((r184 instanceof Integer) == true) goto L137;
        r184 = null;
    L137:
        Object r185 = Result.m9449constructorimpl((Integer) r184);     // Catch: Throwable -> L139
    L141:
        r154 = r185;
        if (Result.m9455isFailureimpl(r154) == false) goto L144;
    L139:
        th = move-exception;
        Result.Companion r186 = Result.Companion;     // Catch: Throwable -> L146
        r185 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L146
        goto L141
    L133:
        if ((r153 instanceof JSONArray) == false) goto L143;
    L103:
        r180 = r153;
    L146:
        th = move-exception;
        Result.Companion r187 = Result.Companion;     // Catch: Throwable -> L250
        r155 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L250
    L250:
        th = move-exception;
        Result.Companion r188 = Result.Companion;
        Object r189 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r190 = Result.m9452exceptionOrNullimpl(r189);
        if (r190 == null) goto L255;
        EnsureManager.ensureNotReachHere(r190);
    L255:
        if (Result.m9455isFailureimpl(r189) == true) goto L258;
        r150 = r189;
    L258:
        r157 = r150;
        goto L260
    L68:
        if (r127.length() == 0) goto L71;
        r128 = false;
        goto L72
    L49:
        r121 = false;
        goto L50
    L34:
        if (r108.length() <= 0) goto L36;
        boolean r191 = true;
    L37:
        if (r191 == true) goto L40;
        r108 = null;
    L40:
        if (r108 == null) goto L42;
        r116 = f(r116, r108);
        goto L42
    L36:
        r191 = false;
        goto L37
    L23:
        if (r114.length() <= 0) goto L25;
        boolean r192 = true;
    L26:
        if (r192 == true) goto L29;
        r114 = null;
    L29:
        if (r114 == null) goto L31;
        r107 = f(r107, r114);
        goto L31
    L25:
        r192 = false;
    L270:
        return r100;
    L271:
        JSONObject r193 = new JSONObject();
        Uri r194 = UriProtector.parse(r210);
        String[] r195 = f44313b;
        int r196 = r195.length;
    L272:
        if (r101 >= r196) goto L277;
        String r197 = r195[r101];
        String r198 = UriProtector.getQueryParameter(r194, r197);
        if (r198 == null) goto L276;
        r193.put(r197, r198);
    L276:
        r101 = r101 + 1;
        goto L272
    L277:
        Set<String> r199 = UriProtector.getQueryParameterNames(r194);
        Uri.Builder r200 = r194.buildUpon().clearQuery();
        Iterator<String> r201 = r199.iterator();
    L279:
        if (r201.hasNext() == false) goto L283;
        String r202 = r201.next();
        if (ArraysKt.contains(f44313b, r202) == true) goto L279;
        r200.appendQueryParameter(r202, UriProtector.getQueryParameter(r194, r202));
        goto L279
    L283:
        r200.appendQueryParameter(r105, r193.toString());
        return b(r200.toString(), r211, r104, r213);
    L12:
        r110 = "mega_object_id";
        r105 = "mega_object";
        goto L14
    L9:
        r104 = r212;
        goto L10
    L5:
        r102 = false;
        goto L7
    }
}
