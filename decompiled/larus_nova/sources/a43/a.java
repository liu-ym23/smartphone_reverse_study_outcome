package a43;

import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.base.settings.c;
import com.bytedance.android.ec.base.settings.d;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.opt.ab.n;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.services.apm.api.EnsureManager;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONArray;
import org.json.JSONObject;
import s83.g;

/* JADX INFO: loaded from: classes12.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Object> f1756a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f1757b = null;

    public a() {
    }

    static {
        f1757b = new a();
        f1756a = new ConcurrentHashMap();
    }

    public final Object a(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if (r101 == false) goto L7;
        Object r102 = f1756a.get(r100);
        if (r102 == null) goto L7;
        return r102;
    L7:
        Object r103 = null;
        switch(r100.hashCode()) {
            case -783054986: goto L197;
            case -294035433: goto L193;
            case -108245287: goto L189;
            case 258261456: goto L185;
            case 1093375108: goto L15;
            case 1777600998: goto L11;
            default: goto L200;
        };
    L200:
        boolean r104 = ECServiceManager.f42805a;
        s83.a r105 = ((g) ECServiceManager.c(g.class)).q();
        if (r105 == null) goto L203;
        r103 = r105.getValue(r100);
    L203:
        if (r103 == null) goto L205;
        f1756a.put(r100, r103);
    L205:
        return r103;
    L11:
        if (r100.equals("ultimate_buy_cache_config") == false) goto L200;
        return ECSettingKeys.M0();
    L15:
        if (r100.equals("legou_sku_buy_layout_opt") == false) goto L200;
        ECSettingKeys.f43625j.getClass();
        int r106 = n.f45241a;
        Object r107 = 0;
        int r108 = com.bytedance.android.ec.base.settings.a.f42813a;
        Result.Companion r109 = Result.Companion;     // Catch: Throwable -> L173
        Object r110 = d.f42818c.get("legou_sku_buy_layout_opt");     // Catch: Throwable -> L67
        if (r110 != null) goto L22;
    L64:
        Object r111 = null;
    L65:
        Object r112 = Result.m9449constructorimpl(r111);     // Catch: Throwable -> L67
    L69:
        Throwable r113 = Result.m9452exceptionOrNullimpl(r112);     // Catch: Throwable -> L173
        if (r113 == null) goto L73;
        EnsureManager.ensureNotReachHere(r113);     // Catch: Throwable -> L173
    L73:
        if (Result.m9455isFailureimpl(r112) == false) goto L76;
        r112 = null;
    L76:
        if ((r112 instanceof Integer) == true) goto L78;
        r112 = null;
    L78:
        Object r114 = (Integer) r112;     // Catch: Throwable -> L173
        if (r114 != null) goto L85;
        Object r115 = d.f42816a.get("legou_sku_buy_layout_opt");     // Catch: Throwable -> L173
        if ((r115 instanceof Integer) == true) goto L84;
        r115 = null;
    L84:
        r114 = (Integer) r115;     // Catch: Throwable -> L173
    L85:
        if (r114 != null) goto L183;
        int r116 = c.f42815a;     // Catch: Throwable -> L173
        Object r117 = d.f42818c.get("legou_sku_buy_layout_opt");     // Catch: Throwable -> L137
        if (r117 != null) goto L92;
    L134:
        Object r118 = null;
    L135:
        Object r119 = Result.m9449constructorimpl(r118);     // Catch: Throwable -> L137
    L139:
        Throwable r120 = Result.m9452exceptionOrNullimpl(r119);     // Catch: Throwable -> L163
        if (r120 == null) goto L143;
        EnsureManager.ensureNotReachHere(r120);     // Catch: Throwable -> L163
    L143:
        if (Result.m9455isFailureimpl(r119) == false) goto L146;
        r119 = null;
    L146:
        if ((r119 instanceof Integer) == true) goto L148;
        r119 = null;
    L148:
        r114 = (Integer) r119;     // Catch: Throwable -> L163
        if (r114 != null) goto L171;
        IHybridHostService r121 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L163
        if (r121 == null) goto L154;
        Object r122 = r121.getHostABValue("legou_sku_buy_layout_opt", r107);     // Catch: Throwable -> L163
    L155:
        if (r122 != null) goto L157;
    L162:
        r114 = r107;
        goto L171
    L157:
        if ((r122 instanceof Integer) == false) goto L160;
        r103 = r122;
    L160:
        Object r123 = (Integer) r103;     // Catch: Throwable -> L163
        if (r123 == null) goto L162;
    L170:
        r114 = r123;
        goto L171
    L154:
        r122 = null;
    L171:
        d.d("legou_sku_buy_layout_opt", r114);     // Catch: Throwable -> L173
        goto L183
    L92:
        if ((r117 instanceof Integer) == true) goto L94;
        Object r124 = null;
    L95:
        r118 = (Integer) r124;     // Catch: Throwable -> L137
        if (r118 != null) goto L135;
        if ((r117 instanceof Number) == false) goto L122;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L107;
        Float r125 = Float.valueOf(((Number) r117).floatValue());     // Catch: Throwable -> L137
        if ((r125 instanceof Integer) == true) goto L105;
        r125 = null;
    L105:
        r118 = (Integer) r125;     // Catch: Throwable -> L137
        goto L135
    L107:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L113;
        Double r126 = Double.valueOf(((Number) r117).doubleValue());     // Catch: Throwable -> L137
        if ((r126 instanceof Integer) == true) goto L111;
        r126 = null;
    L111:
        r118 = (Integer) r126;     // Catch: Throwable -> L137
        goto L135
    L113:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L116;
        r118 = Integer.valueOf(((Number) r117).intValue());     // Catch: Throwable -> L137
        goto L135
    L116:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L122;
        Long r127 = Long.valueOf(((Number) r117).longValue());     // Catch: Throwable -> L137
        if ((r127 instanceof Integer) == true) goto L120;
        r127 = null;
    L120:
        r118 = (Integer) r127;     // Catch: Throwable -> L137
    L122:
        if ((r117 instanceof JSONObject) == false) goto L124;
    L208:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L130
        Object r128 = SDKSettingsCacheManager.a().fromJson(r117.toString(), Integer.class);     // Catch: Throwable -> L130
        if ((r128 instanceof Integer) == true) goto L128;
        r128 = null;
    L128:
        Object r129 = Result.m9449constructorimpl((Integer) r128);     // Catch: Throwable -> L130
    L132:
        r118 = r129;
        if (Result.m9455isFailureimpl(r118) == false) goto L135;
    L130:
        th = move-exception;
        Result.Companion r130 = Result.Companion;     // Catch: Throwable -> L137
        r129 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L137
        goto L132
    L124:
        if ((r117 instanceof JSONArray) == false) goto L134;
    L94:
        r124 = r117;
    L163:
        th = move-exception;
        Result.Companion r131 = Result.Companion;     // Catch: Throwable -> L173
        r123 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L173
        Throwable r132 = Result.m9452exceptionOrNullimpl(r123);     // Catch: Throwable -> L173
        if (r132 == null) goto L168;
        EnsureManager.ensureNotReachHere(r132);     // Catch: Throwable -> L173
    L168:
        if (Result.m9455isFailureimpl(r123) == false) goto L170;
        r123 = r107;
    L137:
        th = move-exception;
        Result.Companion r133 = Result.Companion;     // Catch: Throwable -> L163
        r119 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
    L183:
        return Integer.valueOf(((Number) r114).intValue());
    L22:
        if ((r110 instanceof Integer) == true) goto L24;
        Object r134 = null;
    L25:
        r111 = (Integer) r134;     // Catch: Throwable -> L67
        if (r111 != null) goto L65;
        if ((r110 instanceof Number) == false) goto L52;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L37;
        Float r135 = Float.valueOf(((Number) r110).floatValue());     // Catch: Throwable -> L67
        if ((r135 instanceof Integer) == true) goto L35;
        r135 = null;
    L35:
        r111 = (Integer) r135;     // Catch: Throwable -> L67
        goto L65
    L37:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L43;
        Double r136 = Double.valueOf(((Number) r110).doubleValue());     // Catch: Throwable -> L67
        if ((r136 instanceof Integer) == true) goto L41;
        r136 = null;
    L41:
        r111 = (Integer) r136;     // Catch: Throwable -> L67
        goto L65
    L43:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L46;
        r111 = Integer.valueOf(((Number) r110).intValue());     // Catch: Throwable -> L67
        goto L65
    L46:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L52;
        Long r137 = Long.valueOf(((Number) r110).longValue());     // Catch: Throwable -> L67
        if ((r137 instanceof Integer) == true) goto L50;
        r137 = null;
    L50:
        r111 = (Integer) r137;     // Catch: Throwable -> L67
    L52:
        if ((r110 instanceof JSONObject) == false) goto L54;
    L206:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L60
        Object r138 = SDKSettingsCacheManager.a().fromJson(r110.toString(), Integer.class);     // Catch: Throwable -> L60
        if ((r138 instanceof Integer) == true) goto L58;
        r138 = null;
    L58:
        Object r139 = Result.m9449constructorimpl((Integer) r138);     // Catch: Throwable -> L60
    L62:
        r111 = r139;
        if (Result.m9455isFailureimpl(r111) == false) goto L65;
    L60:
        th = move-exception;
        Result.Companion r140 = Result.Companion;     // Catch: Throwable -> L67
        r139 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L67
        goto L62
    L54:
        if ((r110 instanceof JSONArray) == false) goto L64;
    L24:
        r134 = r110;
    L67:
        th = move-exception;
        Result.Companion r141 = Result.Companion;     // Catch: Throwable -> L173
        r112 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L173
    L173:
        th = move-exception;
        Result.Companion r142 = Result.Companion;
        Object r143 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r144 = Result.m9452exceptionOrNullimpl(r143);
        if (r144 == null) goto L178;
        EnsureManager.ensureNotReachHere(r144);
    L178:
        if (Result.m9455isFailureimpl(r143) == true) goto L181;
        r107 = r143;
    L181:
        r114 = r107;
        goto L183
    L185:
        if (r100.equals("ec_sku_height_percent") == false) goto L200;
        ECSettingKeys.f43625j.getClass();
        return Integer.valueOf(ECSettingKeys.X());
    L189:
        if (r100.equals("ec_sku_height_imp_scene_list") == false) goto L200;
        ECSettingKeys.f43625j.getClass();
        return ECSettingKeys.W();
    L193:
        if (r100.equals("legou_sku_buy_layout_opt_v2") == false) goto L200;
        ECSettingKeys.f43625j.getClass();
        return Integer.valueOf(ECSettingKeys.U());
    L197:
        if (r100.equals("ec_buy_now_async_tracker_delay") == false) goto L200;
        ECSettingKeys.f43625j.getClass();
        return Boolean.valueOf(ECSettingKeys.o());
    }
}
