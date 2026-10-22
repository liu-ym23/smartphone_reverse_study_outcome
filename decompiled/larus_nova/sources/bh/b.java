package bh;

import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.base.settings.g;
import com.bytedance.android.ec.base.settings.h;
import com.bytedance.android.ec.core.abtest.j;
import com.bytedance.android.ec.core.hybrid.model.ECPreProcessorJsbOptConfig;
import com.bytedance.android.ec.core.hybrid.prefetch.NativePrefetch;
import com.bytedance.android.ec.core.hybrid.prefetch.NativePrefetchUtil;
import com.bytedance.android.ec.core.hybrid.prefetch.u;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.hybrid.hostapi.IECHybridKevaService;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.services.apm.api.EnsureManager;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import nj.d;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f18989a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f18990b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f18991c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f18992d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f18993e;

    public final Integer b() {
        String r100 = this.f18989a;
        boolean r101 = false;
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L12;
        a(false);
        return -100;
    L12:
        ECPreProcessorJsbOptConfig.a r103 = ECPreProcessorJsbOptConfig.Companion;
        String r104 = this.f18989a;
        r103.getClass();
        Integer r105 = ECPreProcessorJsbOptConfig.access$getCONFIG$cp().getOpen();
        if (r105 == null) goto L15;
        int r106 = r105.intValue();
    L17:
        if (r106 <= 0) goto L28;
        List<String> r107 = ECPreProcessorJsbOptConfig.access$getCONFIG$cp().getBlackList();
        if (r107 == null) goto L29;
        Iterator<T> r108 = r107.iterator();
    L23:
        if (r108.hasNext() == false) goto L29;
        String r109 = (String) r108.next();
        if (r104 == null) goto L23;
        if (StringsKt.contains$default(r104, r109, false, 2, null) != true) goto L23;
    L29:
        boolean r110 = true;
    L30:
        if (r110 == true) goto L34;
        a(false);
        return 100;
    L34:
        if ((this.f18993e & 1) <= 0) goto L37;
        ECLiveHybridUtil.a r111 = ECLiveHybridUtil.f44277a;
        ECLiveHybridUtil.l(this.f18989a, true);
        this.f18991c = true;
    L37:
        if ((this.f18993e & 2) <= 0) goto L266;
        String r112 = this.f18990b;
        if (r112 != null) goto L41;
    L44:
        boolean r113 = true;
    L45:
        if (r113 == false) goto L48;
        a(false);
        return 101;
    L48:
        String r114 = this.f18989a;
        if (r114 != null) goto L51;
        r114 = "";
    L51:
        String r115 = r114;
        int r116 = zg.a.f571786a;
        int r117 = j.f43647a;
        Object r118 = Boolean.TRUE;
        int r119 = com.bytedance.android.ec.base.settings.b.f42814a;
        Result.Companion r120 = Result.Companion;     // Catch: Throwable -> L219
        h.a();     // Catch: Throwable -> L219
        SDKSettingsCacheManager r121 = SDKSettingsCacheManager.f42812e;     // Catch: Throwable -> L219
        r121.getClass();     // Catch: Throwable -> L107
        Object r122 = SDKSettingsCacheManager.f42809b.get("ec_fold_prefetch_opt_disable");     // Catch: Throwable -> L107
        if (r122 != null) goto L59;
    L104:
        Object r123 = null;
    L105:
        Object r124 = Result.m9449constructorimpl(r123);     // Catch: Throwable -> L107
    L109:
        Throwable r125 = Result.m9452exceptionOrNullimpl(r124);     // Catch: Throwable -> L219
        if (r125 == null) goto L113;
        EnsureManager.ensureNotReachHere(r125);     // Catch: Throwable -> L219
    L113:
        if (Result.m9455isFailureimpl(r124) == false) goto L116;
        r124 = null;
    L116:
        if ((r124 instanceof Boolean) == true) goto L118;
        r124 = null;
    L118:
        Object r126 = (Boolean) r124;     // Catch: Throwable -> L219
        if (r126 != null) goto L125;
        r121.getClass();     // Catch: Throwable -> L219
        Object r127 = SDKSettingsCacheManager.f42808a.get("ec_fold_prefetch_opt_disable");     // Catch: Throwable -> L219
        if ((r127 instanceof Boolean) == true) goto L124;
        r127 = null;
    L124:
        r126 = (Boolean) r127;     // Catch: Throwable -> L219
    L125:
        if (r126 != null) goto L229;
        int r128 = g.f42821a;     // Catch: Throwable -> L219
    L206:
        th = move-exception;
        Result.Companion r129 = Result.Companion;     // Catch: Throwable -> L219
        Object r130 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L219
    L209:
        if (Result.m9452exceptionOrNullimpl(r130) != null) goto L268;
    L216:
        r126 = r130;
    L217:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L219
        SDKSettingsCacheManager.e("ec_fold_prefetch_opt_disable", r126);     // Catch: Throwable -> L219
        goto L229
    L268:
        r130 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ec_fold_prefetch_opt_disable", Boolean.class, r118);     // Catch: Throwable -> L213
    L214:
        if (r130 != null) goto L216;
        r126 = r118;
    L213:
        r130 = r118;
        goto L214
    L276:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L181
        Object r131 = SDKSettingsCacheManager.f42809b.get("ec_fold_prefetch_opt_disable");     // Catch: Throwable -> L181
        if (r131 != null) goto L133;
    L178:
        Object r132 = null;
    L179:
        Object r133 = Result.m9449constructorimpl(r132);     // Catch: Throwable -> L181
    L183:
        Throwable r134 = Result.m9452exceptionOrNullimpl(r133);     // Catch: Throwable -> L206
        if (r134 == null) goto L187;
        EnsureManager.ensureNotReachHere(r134);     // Catch: Throwable -> L206
    L187:
        if (Result.m9455isFailureimpl(r133) == false) goto L190;
        r133 = null;
    L190:
        if ((r133 instanceof Boolean) == true) goto L192;
        r133 = null;
    L192:
        r130 = (Boolean) r133;     // Catch: Throwable -> L206
        if (r130 != null) goto L216;
        jj4.b r135 = jj4.b.f499326b;     // Catch: Throwable -> L206
        Object r136 = jj4.a.a("ec_fold_prefetch_opt_disable", Boolean.class, r118, false);     // Catch: Throwable -> L206
        if (r136 != null) goto L199;
        Intrinsics.throwNpe();     // Catch: Throwable -> L206
    L199:
        if ((r136 instanceof Boolean) == true) goto L201;
        r136 = null;
    L201:
        Object r137 = (Boolean) r136;     // Catch: Throwable -> L206
        if (r137 != null) goto L204;
        r137 = r118;
    L204:
        r130 = Result.m9449constructorimpl(r137);     // Catch: Throwable -> L206
    L133:
        if ((r131 instanceof Boolean) == true) goto L135;
        Object r138 = null;
    L136:
        r132 = (Boolean) r138;     // Catch: Throwable -> L181
        if (r132 != null) goto L179;
        if ((r131 instanceof Number) == false) goto L166;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L148;
        Float r139 = Float.valueOf(((Number) r131).floatValue());     // Catch: Throwable -> L181
        if ((r139 instanceof Boolean) == true) goto L146;
        r139 = null;
    L146:
        r132 = (Boolean) r139;     // Catch: Throwable -> L181
        goto L179
    L148:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L154;
        Double r140 = Double.valueOf(((Number) r131).doubleValue());     // Catch: Throwable -> L181
        if ((r140 instanceof Boolean) == true) goto L152;
        r140 = null;
    L152:
        r132 = (Boolean) r140;     // Catch: Throwable -> L181
        goto L179
    L154:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L160;
        Integer r141 = Integer.valueOf(((Number) r131).intValue());     // Catch: Throwable -> L181
        if ((r141 instanceof Boolean) == true) goto L158;
        r141 = null;
    L158:
        r132 = (Boolean) r141;     // Catch: Throwable -> L181
        goto L179
    L160:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L166;
        Long r142 = Long.valueOf(((Number) r131).longValue());     // Catch: Throwable -> L181
        if ((r142 instanceof Boolean) == true) goto L164;
        r142 = null;
    L164:
        r132 = (Boolean) r142;     // Catch: Throwable -> L181
    L166:
        if ((r131 instanceof JSONObject) == false) goto L168;
    L272:
        Object r143 = SDKSettingsCacheManager.a().fromJson(r131.toString(), Boolean.class);     // Catch: Throwable -> L174
        if ((r143 instanceof Boolean) == true) goto L172;
        r143 = null;
    L172:
        Object r144 = Result.m9449constructorimpl((Boolean) r143);     // Catch: Throwable -> L174
    L176:
        r132 = r144;
        if (Result.m9455isFailureimpl(r132) == false) goto L179;
    L174:
        th = move-exception;
        Result.Companion r145 = Result.Companion;     // Catch: Throwable -> L181
        r144 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L181
        goto L176
    L168:
        if ((r131 instanceof JSONArray) == false) goto L178;
    L135:
        r138 = r131;
    L181:
        th = move-exception;
        Result.Companion r146 = Result.Companion;     // Catch: Throwable -> L206
        r133 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L206
    L229:
        if (((Boolean) r126).booleanValue() == true) goto L231;
    L235:
        ConcurrentHashMap<String, NativePrefetch> r147 = NativePrefetchUtil.f44218a;
        String r148 = this.f18990b;
        Intrinsics.checkNotNullParameter(r115, "url");
        Result.Companion r149 = Result.Companion;     // Catch: Throwable -> L261
        if (r148 != null) goto L239;
    L242:
        boolean r150 = true;
    L243:
        if (r150 == true) goto L263;
        String r151 = UriProtector.getQueryParameter(UriProtector.parse(r115), "ec_request_id");     // Catch: Throwable -> L261
        if (r151 != null) goto L248;
    L251:
        boolean r152 = true;
    L252:
        if (r152 == false) goto L263;
        if (NativePrefetchUtil.l(r148) == false) goto L258;
        u.b(r115, false);     // Catch: Throwable -> L261
        goto L263
    L258:
        if (NativePrefetchUtil.b(r115, false, 6) == false) goto L263;
        r101 = true;
        goto L263
    L248:
        if (StringsKt.isBlank(r151) == true) goto L251;
        r152 = false;
    L263:
        if (r101 == false) goto L265;
        ConcurrentHashMap<String, NativePrefetch> r153 = NativePrefetchUtil.f44218a;
        NativePrefetchUtil.n(r115, new JSONObject(), this.f18990b, true, true, true, 64);
    L265:
        this.f18992d = true;
        goto L266
    L239:
        if (StringsKt.isBlank(r148) == true) goto L242;
        r150 = false;
    L261:
        th = move-exception;
        Result.Companion r154 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L263
    L231:
        if (ECSdk.c() == false) goto L235;
        d r155 = com.bytedance.android.ec.sdk.helper.d.f48119b.getPadSplitService();
        if (r155 == null) goto L235;
        r155.isFold();
        goto L235
    L59:
        if ((r122 instanceof Boolean) == true) goto L61;
        Object r156 = null;
    L62:
        r123 = (Boolean) r156;     // Catch: Throwable -> L107
        if (r123 != null) goto L105;
        if ((r122 instanceof Number) == false) goto L92;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L74;
        Float r157 = Float.valueOf(((Number) r122).floatValue());     // Catch: Throwable -> L107
        if ((r157 instanceof Boolean) == true) goto L72;
        r157 = null;
    L72:
        r123 = (Boolean) r157;     // Catch: Throwable -> L107
        goto L105
    L74:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L80;
        Double r158 = Double.valueOf(((Number) r122).doubleValue());     // Catch: Throwable -> L107
        if ((r158 instanceof Boolean) == true) goto L78;
        r158 = null;
    L78:
        r123 = (Boolean) r158;     // Catch: Throwable -> L107
        goto L105
    L80:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L86;
        Integer r159 = Integer.valueOf(((Number) r122).intValue());     // Catch: Throwable -> L107
        if ((r159 instanceof Boolean) == true) goto L84;
        r159 = null;
    L84:
        r123 = (Boolean) r159;     // Catch: Throwable -> L107
        goto L105
    L86:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L92;
        Long r160 = Long.valueOf(((Number) r122).longValue());     // Catch: Throwable -> L107
        if ((r160 instanceof Boolean) == true) goto L90;
        r160 = null;
    L90:
        r123 = (Boolean) r160;     // Catch: Throwable -> L107
    L92:
        if ((r122 instanceof JSONObject) == false) goto L94;
    L274:
        Object r161 = SDKSettingsCacheManager.a().fromJson(r122.toString(), Boolean.class);     // Catch: Throwable -> L100
        if ((r161 instanceof Boolean) == true) goto L98;
        r161 = null;
    L98:
        Object r162 = Result.m9449constructorimpl((Boolean) r161);     // Catch: Throwable -> L100
    L102:
        r123 = r162;
        if (Result.m9455isFailureimpl(r123) == false) goto L105;
    L100:
        th = move-exception;
        Result.Companion r163 = Result.Companion;     // Catch: Throwable -> L107
        r162 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L107
        goto L102
    L94:
        if ((r122 instanceof JSONArray) == false) goto L104;
    L61:
        r156 = r122;
    L107:
        th = move-exception;
        Result.Companion r164 = Result.Companion;     // Catch: Throwable -> L219
        r124 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L219
    L219:
        th = move-exception;
        Result.Companion r165 = Result.Companion;
        Object r166 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r167 = Result.m9452exceptionOrNullimpl(r166);
        if (r167 == null) goto L224;
        EnsureManager.ensureNotReachHere(r167);
    L224:
        if (Result.m9455isFailureimpl(r166) == true) goto L227;
        r118 = r166;
    L227:
        r126 = r118;
        goto L229
    L41:
        if (StringsKt.isBlank(r112) == true) goto L44;
        r113 = false;
    L266:
        a(true);
        return null;
    L28:
        r110 = false;
        goto L30
    L15:
        r106 = 0;
        goto L17
    L5:
        if (StringsKt.isBlank(r100) == true) goto L8;
        r102 = false;
        goto L9
    }

    public b(int r100) {
        this.f18993e = r100;
    }

    public final void a(boolean r100) {
        com.bytedance.android.ec.sdk.helper.g r101 = com.bytedance.android.ec.sdk.helper.g.f48122a;
        JSONObject r102 = new JSONObject();
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L24
        String r104 = this.f18989a;     // Catch: Throwable -> L24
        String r105 = "";
        if (r104 == null) goto L10;
        String r106 = StringsKt.substringBefore(r104, "?", "");     // Catch: Throwable -> L24
        if (r106 == null) goto L10;
        r105 = r106;
    L10:
        r102.putOpt("url", r105);     // Catch: Throwable -> L24
        int r107 = 1;
        if (this.f18991c == false) goto L13;
        int r108 = 1;
    L14:
        r102.putOpt("enable_preload_gecko", Integer.valueOf(r108));     // Catch: Throwable -> L24
        if (this.f18992d == false) goto L17;
        int r109 = 1;
    L18:
        r102.putOpt("enable_native_prefetch", Integer.valueOf(r109));     // Catch: Throwable -> L24
        if (r100 == true) goto L22;
        r107 = 0;
    L22:
        Result.m9449constructorimpl(r102.putOpt("success", Integer.valueOf(r107)));     // Catch: Throwable -> L24
    L26:
        Unit r110 = Unit.INSTANCE;
        r101.logV3("ies_ecommerce_perf_preprocessor_jsb_monitor", r102);
        return;
    L17:
        r109 = 0;
        goto L18
    L13:
        r108 = 0;
    L24:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L26
    }
}
