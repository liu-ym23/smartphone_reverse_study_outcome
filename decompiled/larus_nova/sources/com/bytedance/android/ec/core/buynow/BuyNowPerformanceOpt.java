package com.bytedance.android.ec.core.buynow;

import android.content.Context;
import com.alipay.sdk.m.u.i;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.base.settings.g;
import com.bytedance.android.ec.base.settings.h;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.abtest.j;
import com.bytedance.android.ec.core.utils.t0;
import com.bytedance.android.ec.hybrid.hostapi.IECHybridKevaService;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ecom.slice.ext.template.gecko.SlcGeckoTemplateMgr;
import com.bytedance.services.apm.api.EnsureManager;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class BuyNowPerformanceOpt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Boolean f43905a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f43906b = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f43907a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f43908b;

        public a(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "sceneName");
            Intrinsics.checkNotNullParameter(r101, "fallbackSceneName");
            this.f43907a = r100;
            this.f43908b = r101;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\b\u0005\u0018\u00002\u00020\u0001R<\u0010\u0005\u001a$\u0012\u0004\u0012\u00020\u0003\u0012\u0018\u0012\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00020\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/ec/core/buynow/BuyNowPerformanceOpt$b;", "", "", "", "", "map", "Ljava/util/Map;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/Map;", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b {

        @SerializedName("map")
        @JsonAdapter(FieldsAdapter.class)
        private final Map<String, List<Map<String, Object>>> map;

        public final Map<String, List<Map<String, Object>>> a() {
            return this.map;
        }
    }

    public static Map g() {
        return (Map) f43906b.getValue();
    }

    static {
        f43906b = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, BuyNowPerformanceOpt$performanceAB$2.INSTANCE);
    }

    public static boolean a() {
        Lazy r100 = ECAppInfoService.f48110a;
        Object r101 = null;
        if (ECAppInfoService.h() == false) goto L8;
        Map r102 = g();
        if (r102 == null) goto L197;
        r101 = r102.get("iesec_enable_cache_detail_url");
    L197:
        return Intrinsics.areEqual(r101, 1);
    L8:
        com.bytedance.android.ec.core.abtest.d r103 = com.bytedance.android.ec.core.abtest.d.f43639a;
        int r104 = j.f43647a;
        Object r105 = 0;
        int r106 = com.bytedance.android.ec.base.settings.b.f42814a;
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L169
        h.a();     // Catch: Throwable -> L169
        SDKSettingsCacheManager r108 = SDKSettingsCacheManager.f42812e;     // Catch: Throwable -> L169
        r108.getClass();     // Catch: Throwable -> L59
        Object r109 = SDKSettingsCacheManager.f42809b.get("iesec_enable_cache_detail_url");     // Catch: Throwable -> L59
        if (r109 != null) goto L14;
    L56:
        Object r110 = null;
    L57:
        Object r111 = Result.m9449constructorimpl(r110);     // Catch: Throwable -> L59
    L61:
        Throwable r112 = Result.m9452exceptionOrNullimpl(r111);     // Catch: Throwable -> L169
        if (r112 == null) goto L65;
        EnsureManager.ensureNotReachHere(r112);     // Catch: Throwable -> L169
    L65:
        if (Result.m9455isFailureimpl(r111) == false) goto L68;
        r111 = null;
    L68:
        if ((r111 instanceof Integer) == true) goto L70;
        r111 = null;
    L70:
        Object r113 = (Integer) r111;     // Catch: Throwable -> L169
        if (r113 != null) goto L77;
        r108.getClass();     // Catch: Throwable -> L169
        Object r114 = SDKSettingsCacheManager.f42808a.get("iesec_enable_cache_detail_url");     // Catch: Throwable -> L169
        if ((r114 instanceof Integer) == true) goto L76;
        r114 = null;
    L76:
        r113 = (Integer) r114;     // Catch: Throwable -> L169
    L77:
        if (r113 != null) goto L179;
        int r115 = g.f42821a;     // Catch: Throwable -> L169
    L156:
        th = move-exception;
        Result.Companion r116 = Result.Companion;     // Catch: Throwable -> L169
        Object r117 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L169
    L159:
        if (Result.m9452exceptionOrNullimpl(r117) != null) goto L187;
    L166:
        r113 = r117;
    L167:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L169
        SDKSettingsCacheManager.e("iesec_enable_cache_detail_url", r113);     // Catch: Throwable -> L169
        goto L179
    L187:
        r117 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("iesec_enable_cache_detail_url", Integer.class, r105);     // Catch: Throwable -> L163
    L164:
        if (r117 != null) goto L166;
        r113 = r105;
    L163:
        r117 = r105;
        goto L164
    L193:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L130
        Object r118 = SDKSettingsCacheManager.f42809b.get("iesec_enable_cache_detail_url");     // Catch: Throwable -> L130
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
        r113 = r122;
        goto L167
    L144:
        jj4.b r123 = jj4.b.f499326b;     // Catch: Throwable -> L156
        Object r124 = jj4.a.a("iesec_enable_cache_detail_url", Integer.class, r105, false);     // Catch: Throwable -> L156
        if (r124 != null) goto L148;
        Intrinsics.throwNpe();     // Catch: Throwable -> L156
    L148:
        if ((r124 instanceof Integer) == false) goto L151;
        r101 = r124;
    L151:
        Object r125 = (Integer) r101;     // Catch: Throwable -> L156
        if (r125 != null) goto L154;
        r125 = r105;
    L154:
        r117 = Result.m9449constructorimpl(r125);     // Catch: Throwable -> L156
    L85:
        if ((r118 instanceof Integer) == true) goto L87;
        Object r126 = null;
    L88:
        r119 = (Integer) r126;     // Catch: Throwable -> L130
        if (r119 != null) goto L128;
        if ((r118 instanceof Number) == false) goto L115;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L100;
        Float r127 = Float.valueOf(((Number) r118).floatValue());     // Catch: Throwable -> L130
        if ((r127 instanceof Integer) == true) goto L98;
        r127 = null;
    L98:
        r119 = (Integer) r127;     // Catch: Throwable -> L130
        goto L128
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L106;
        Double r128 = Double.valueOf(((Number) r118).doubleValue());     // Catch: Throwable -> L130
        if ((r128 instanceof Integer) == true) goto L104;
        r128 = null;
    L104:
        r119 = (Integer) r128;     // Catch: Throwable -> L130
        goto L128
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L109;
        r119 = Integer.valueOf(((Number) r118).intValue());     // Catch: Throwable -> L130
        goto L128
    L109:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L115;
        Long r129 = Long.valueOf(((Number) r118).longValue());     // Catch: Throwable -> L130
        if ((r129 instanceof Integer) == true) goto L113;
        r129 = null;
    L113:
        r119 = (Integer) r129;     // Catch: Throwable -> L130
    L115:
        if ((r118 instanceof JSONObject) == false) goto L117;
    L185:
        Object r130 = SDKSettingsCacheManager.a().fromJson(r118.toString(), Integer.class);     // Catch: Throwable -> L123
        if ((r130 instanceof Integer) == true) goto L121;
        r130 = null;
    L121:
        Object r131 = Result.m9449constructorimpl((Integer) r130);     // Catch: Throwable -> L123
    L125:
        r119 = r131;
        if (Result.m9455isFailureimpl(r119) == false) goto L128;
    L123:
        th = move-exception;
        Result.Companion r132 = Result.Companion;     // Catch: Throwable -> L130
        r131 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L130
        goto L125
    L117:
        if ((r118 instanceof JSONArray) == false) goto L127;
    L87:
        r126 = r118;
    L130:
        th = move-exception;
        Result.Companion r133 = Result.Companion;     // Catch: Throwable -> L156
        r120 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L156
    L179:
        if (((Number) r113).intValue() == 1) goto L198;
        return false;
    L198:
        return true;
    L14:
        if ((r109 instanceof Integer) == true) goto L16;
        Object r134 = null;
    L17:
        r110 = (Integer) r134;     // Catch: Throwable -> L59
        if (r110 != null) goto L57;
        if ((r109 instanceof Number) == false) goto L44;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L29;
        Float r135 = Float.valueOf(((Number) r109).floatValue());     // Catch: Throwable -> L59
        if ((r135 instanceof Integer) == true) goto L27;
        r135 = null;
    L27:
        r110 = (Integer) r135;     // Catch: Throwable -> L59
        goto L57
    L29:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L35;
        Double r136 = Double.valueOf(((Number) r109).doubleValue());     // Catch: Throwable -> L59
        if ((r136 instanceof Integer) == true) goto L33;
        r136 = null;
    L33:
        r110 = (Integer) r136;     // Catch: Throwable -> L59
        goto L57
    L35:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L38;
        r110 = Integer.valueOf(((Number) r109).intValue());     // Catch: Throwable -> L59
        goto L57
    L38:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L44;
        Long r137 = Long.valueOf(((Number) r109).longValue());     // Catch: Throwable -> L59
        if ((r137 instanceof Integer) == true) goto L42;
        r137 = null;
    L42:
        r110 = (Integer) r137;     // Catch: Throwable -> L59
    L44:
        if ((r109 instanceof JSONObject) == false) goto L46;
    L183:
        Object r138 = SDKSettingsCacheManager.a().fromJson(r109.toString(), Integer.class);     // Catch: Throwable -> L52
        if ((r138 instanceof Integer) == true) goto L50;
        r138 = null;
    L50:
        Object r139 = Result.m9449constructorimpl((Integer) r138);     // Catch: Throwable -> L52
    L54:
        r110 = r139;
        if (Result.m9455isFailureimpl(r110) == false) goto L57;
    L52:
        th = move-exception;
        Result.Companion r140 = Result.Companion;     // Catch: Throwable -> L59
        r139 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L59
        goto L54
    L46:
        if ((r109 instanceof JSONArray) == false) goto L56;
    L16:
        r134 = r109;
    L59:
        th = move-exception;
        Result.Companion r141 = Result.Companion;     // Catch: Throwable -> L169
        r111 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L169
    L169:
        th = move-exception;
        Result.Companion r142 = Result.Companion;
        Object r143 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r144 = Result.m9452exceptionOrNullimpl(r143);
        if (r144 == null) goto L174;
        EnsureManager.ensureNotReachHere(r144);
    L174:
        if (Result.m9455isFailureimpl(r143) == true) goto L177;
        r105 = r143;
    L177:
        r113 = r105;
        goto L179
    }

    public static boolean b() {
        Lazy r100 = ECAppInfoService.f48110a;
        Object r101 = null;
        if (ECAppInfoService.h() == false) goto L8;
        Map r102 = g();
        if (r102 == null) goto L197;
        r101 = r102.get("iesec_enable_cache_recommend_info");
    L197:
        return Intrinsics.areEqual(r101, 1);
    L8:
        com.bytedance.android.ec.core.abtest.d r103 = com.bytedance.android.ec.core.abtest.d.f43639a;
        int r104 = j.f43647a;
        Object r105 = 0;
        int r106 = com.bytedance.android.ec.base.settings.b.f42814a;
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L169
        h.a();     // Catch: Throwable -> L169
        SDKSettingsCacheManager r108 = SDKSettingsCacheManager.f42812e;     // Catch: Throwable -> L169
        r108.getClass();     // Catch: Throwable -> L59
        Object r109 = SDKSettingsCacheManager.f42809b.get("iesec_enable_cache_recommend_info");     // Catch: Throwable -> L59
        if (r109 != null) goto L14;
    L56:
        Object r110 = null;
    L57:
        Object r111 = Result.m9449constructorimpl(r110);     // Catch: Throwable -> L59
    L61:
        Throwable r112 = Result.m9452exceptionOrNullimpl(r111);     // Catch: Throwable -> L169
        if (r112 == null) goto L65;
        EnsureManager.ensureNotReachHere(r112);     // Catch: Throwable -> L169
    L65:
        if (Result.m9455isFailureimpl(r111) == false) goto L68;
        r111 = null;
    L68:
        if ((r111 instanceof Integer) == true) goto L70;
        r111 = null;
    L70:
        Object r113 = (Integer) r111;     // Catch: Throwable -> L169
        if (r113 != null) goto L77;
        r108.getClass();     // Catch: Throwable -> L169
        Object r114 = SDKSettingsCacheManager.f42808a.get("iesec_enable_cache_recommend_info");     // Catch: Throwable -> L169
        if ((r114 instanceof Integer) == true) goto L76;
        r114 = null;
    L76:
        r113 = (Integer) r114;     // Catch: Throwable -> L169
    L77:
        if (r113 != null) goto L179;
        int r115 = g.f42821a;     // Catch: Throwable -> L169
    L156:
        th = move-exception;
        Result.Companion r116 = Result.Companion;     // Catch: Throwable -> L169
        Object r117 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L169
    L159:
        if (Result.m9452exceptionOrNullimpl(r117) != null) goto L187;
    L166:
        r113 = r117;
    L167:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L169
        SDKSettingsCacheManager.e("iesec_enable_cache_recommend_info", r113);     // Catch: Throwable -> L169
        goto L179
    L187:
        r117 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("iesec_enable_cache_recommend_info", Integer.class, r105);     // Catch: Throwable -> L163
    L164:
        if (r117 != null) goto L166;
        r113 = r105;
    L163:
        r117 = r105;
        goto L164
    L193:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L130
        Object r118 = SDKSettingsCacheManager.f42809b.get("iesec_enable_cache_recommend_info");     // Catch: Throwable -> L130
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
        r113 = r122;
        goto L167
    L144:
        jj4.b r123 = jj4.b.f499326b;     // Catch: Throwable -> L156
        Object r124 = jj4.a.a("iesec_enable_cache_recommend_info", Integer.class, r105, false);     // Catch: Throwable -> L156
        if (r124 != null) goto L148;
        Intrinsics.throwNpe();     // Catch: Throwable -> L156
    L148:
        if ((r124 instanceof Integer) == false) goto L151;
        r101 = r124;
    L151:
        Object r125 = (Integer) r101;     // Catch: Throwable -> L156
        if (r125 != null) goto L154;
        r125 = r105;
    L154:
        r117 = Result.m9449constructorimpl(r125);     // Catch: Throwable -> L156
    L85:
        if ((r118 instanceof Integer) == true) goto L87;
        Object r126 = null;
    L88:
        r119 = (Integer) r126;     // Catch: Throwable -> L130
        if (r119 != null) goto L128;
        if ((r118 instanceof Number) == false) goto L115;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L100;
        Float r127 = Float.valueOf(((Number) r118).floatValue());     // Catch: Throwable -> L130
        if ((r127 instanceof Integer) == true) goto L98;
        r127 = null;
    L98:
        r119 = (Integer) r127;     // Catch: Throwable -> L130
        goto L128
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L106;
        Double r128 = Double.valueOf(((Number) r118).doubleValue());     // Catch: Throwable -> L130
        if ((r128 instanceof Integer) == true) goto L104;
        r128 = null;
    L104:
        r119 = (Integer) r128;     // Catch: Throwable -> L130
        goto L128
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L109;
        r119 = Integer.valueOf(((Number) r118).intValue());     // Catch: Throwable -> L130
        goto L128
    L109:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L115;
        Long r129 = Long.valueOf(((Number) r118).longValue());     // Catch: Throwable -> L130
        if ((r129 instanceof Integer) == true) goto L113;
        r129 = null;
    L113:
        r119 = (Integer) r129;     // Catch: Throwable -> L130
    L115:
        if ((r118 instanceof JSONObject) == false) goto L117;
    L185:
        Object r130 = SDKSettingsCacheManager.a().fromJson(r118.toString(), Integer.class);     // Catch: Throwable -> L123
        if ((r130 instanceof Integer) == true) goto L121;
        r130 = null;
    L121:
        Object r131 = Result.m9449constructorimpl((Integer) r130);     // Catch: Throwable -> L123
    L125:
        r119 = r131;
        if (Result.m9455isFailureimpl(r119) == false) goto L128;
    L123:
        th = move-exception;
        Result.Companion r132 = Result.Companion;     // Catch: Throwable -> L130
        r131 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L130
        goto L125
    L117:
        if ((r118 instanceof JSONArray) == false) goto L127;
    L87:
        r126 = r118;
    L130:
        th = move-exception;
        Result.Companion r133 = Result.Companion;     // Catch: Throwable -> L156
        r120 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L156
    L179:
        if (((Number) r113).intValue() == 1) goto L198;
        return false;
    L198:
        return true;
    L14:
        if ((r109 instanceof Integer) == true) goto L16;
        Object r134 = null;
    L17:
        r110 = (Integer) r134;     // Catch: Throwable -> L59
        if (r110 != null) goto L57;
        if ((r109 instanceof Number) == false) goto L44;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L29;
        Float r135 = Float.valueOf(((Number) r109).floatValue());     // Catch: Throwable -> L59
        if ((r135 instanceof Integer) == true) goto L27;
        r135 = null;
    L27:
        r110 = (Integer) r135;     // Catch: Throwable -> L59
        goto L57
    L29:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L35;
        Double r136 = Double.valueOf(((Number) r109).doubleValue());     // Catch: Throwable -> L59
        if ((r136 instanceof Integer) == true) goto L33;
        r136 = null;
    L33:
        r110 = (Integer) r136;     // Catch: Throwable -> L59
        goto L57
    L35:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L38;
        r110 = Integer.valueOf(((Number) r109).intValue());     // Catch: Throwable -> L59
        goto L57
    L38:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L44;
        Long r137 = Long.valueOf(((Number) r109).longValue());     // Catch: Throwable -> L59
        if ((r137 instanceof Integer) == true) goto L42;
        r137 = null;
    L42:
        r110 = (Integer) r137;     // Catch: Throwable -> L59
    L44:
        if ((r109 instanceof JSONObject) == false) goto L46;
    L183:
        Object r138 = SDKSettingsCacheManager.a().fromJson(r109.toString(), Integer.class);     // Catch: Throwable -> L52
        if ((r138 instanceof Integer) == true) goto L50;
        r138 = null;
    L50:
        Object r139 = Result.m9449constructorimpl((Integer) r138);     // Catch: Throwable -> L52
    L54:
        r110 = r139;
        if (Result.m9455isFailureimpl(r110) == false) goto L57;
    L52:
        th = move-exception;
        Result.Companion r140 = Result.Companion;     // Catch: Throwable -> L59
        r139 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L59
        goto L54
    L46:
        if ((r109 instanceof JSONArray) == false) goto L56;
    L16:
        r134 = r109;
    L59:
        th = move-exception;
        Result.Companion r141 = Result.Companion;     // Catch: Throwable -> L169
        r111 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L169
    L169:
        th = move-exception;
        Result.Companion r142 = Result.Companion;
        Object r143 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r144 = Result.m9452exceptionOrNullimpl(r143);
        if (r144 == null) goto L174;
        EnsureManager.ensureNotReachHere(r144);
    L174:
        if (Result.m9455isFailureimpl(r143) == true) goto L177;
        r105 = r143;
    L177:
        r113 = r105;
        goto L179
    }

    public static boolean d() {
        Lazy r100 = ECAppInfoService.f48110a;
        Object r101 = null;
        if (ECAppInfoService.h() == false) goto L8;
        Map r102 = g();
        if (r102 == null) goto L197;
        r101 = r102.get("iesec_enable_yata_ultimate_buy_response_cache");
    L197:
        return Intrinsics.areEqual(r101, 1);
    L8:
        com.bytedance.android.ec.core.abtest.d r103 = com.bytedance.android.ec.core.abtest.d.f43639a;
        int r104 = j.f43647a;
        Object r105 = 0;
        int r106 = com.bytedance.android.ec.base.settings.b.f42814a;
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L169
        h.a();     // Catch: Throwable -> L169
        SDKSettingsCacheManager r108 = SDKSettingsCacheManager.f42812e;     // Catch: Throwable -> L169
        r108.getClass();     // Catch: Throwable -> L59
        Object r109 = SDKSettingsCacheManager.f42809b.get("iesec_enable_yata_ultimate_buy_response_cache");     // Catch: Throwable -> L59
        if (r109 != null) goto L14;
    L56:
        Object r110 = null;
    L57:
        Object r111 = Result.m9449constructorimpl(r110);     // Catch: Throwable -> L59
    L61:
        Throwable r112 = Result.m9452exceptionOrNullimpl(r111);     // Catch: Throwable -> L169
        if (r112 == null) goto L65;
        EnsureManager.ensureNotReachHere(r112);     // Catch: Throwable -> L169
    L65:
        if (Result.m9455isFailureimpl(r111) == false) goto L68;
        r111 = null;
    L68:
        if ((r111 instanceof Integer) == true) goto L70;
        r111 = null;
    L70:
        Object r113 = (Integer) r111;     // Catch: Throwable -> L169
        if (r113 != null) goto L77;
        r108.getClass();     // Catch: Throwable -> L169
        Object r114 = SDKSettingsCacheManager.f42808a.get("iesec_enable_yata_ultimate_buy_response_cache");     // Catch: Throwable -> L169
        if ((r114 instanceof Integer) == true) goto L76;
        r114 = null;
    L76:
        r113 = (Integer) r114;     // Catch: Throwable -> L169
    L77:
        if (r113 != null) goto L179;
        int r115 = g.f42821a;     // Catch: Throwable -> L169
    L156:
        th = move-exception;
        Result.Companion r116 = Result.Companion;     // Catch: Throwable -> L169
        Object r117 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L169
    L159:
        if (Result.m9452exceptionOrNullimpl(r117) != null) goto L187;
    L166:
        r113 = r117;
    L167:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L169
        SDKSettingsCacheManager.e("iesec_enable_yata_ultimate_buy_response_cache", r113);     // Catch: Throwable -> L169
        goto L179
    L187:
        r117 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("iesec_enable_yata_ultimate_buy_response_cache", Integer.class, r105);     // Catch: Throwable -> L163
    L164:
        if (r117 != null) goto L166;
        r113 = r105;
    L163:
        r117 = r105;
        goto L164
    L193:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L130
        Object r118 = SDKSettingsCacheManager.f42809b.get("iesec_enable_yata_ultimate_buy_response_cache");     // Catch: Throwable -> L130
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
        r113 = r122;
        goto L167
    L144:
        jj4.b r123 = jj4.b.f499326b;     // Catch: Throwable -> L156
        Object r124 = jj4.a.a("iesec_enable_yata_ultimate_buy_response_cache", Integer.class, r105, false);     // Catch: Throwable -> L156
        if (r124 != null) goto L148;
        Intrinsics.throwNpe();     // Catch: Throwable -> L156
    L148:
        if ((r124 instanceof Integer) == false) goto L151;
        r101 = r124;
    L151:
        Object r125 = (Integer) r101;     // Catch: Throwable -> L156
        if (r125 != null) goto L154;
        r125 = r105;
    L154:
        r117 = Result.m9449constructorimpl(r125);     // Catch: Throwable -> L156
    L85:
        if ((r118 instanceof Integer) == true) goto L87;
        Object r126 = null;
    L88:
        r119 = (Integer) r126;     // Catch: Throwable -> L130
        if (r119 != null) goto L128;
        if ((r118 instanceof Number) == false) goto L115;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L100;
        Float r127 = Float.valueOf(((Number) r118).floatValue());     // Catch: Throwable -> L130
        if ((r127 instanceof Integer) == true) goto L98;
        r127 = null;
    L98:
        r119 = (Integer) r127;     // Catch: Throwable -> L130
        goto L128
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L106;
        Double r128 = Double.valueOf(((Number) r118).doubleValue());     // Catch: Throwable -> L130
        if ((r128 instanceof Integer) == true) goto L104;
        r128 = null;
    L104:
        r119 = (Integer) r128;     // Catch: Throwable -> L130
        goto L128
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L109;
        r119 = Integer.valueOf(((Number) r118).intValue());     // Catch: Throwable -> L130
        goto L128
    L109:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L115;
        Long r129 = Long.valueOf(((Number) r118).longValue());     // Catch: Throwable -> L130
        if ((r129 instanceof Integer) == true) goto L113;
        r129 = null;
    L113:
        r119 = (Integer) r129;     // Catch: Throwable -> L130
    L115:
        if ((r118 instanceof JSONObject) == false) goto L117;
    L185:
        Object r130 = SDKSettingsCacheManager.a().fromJson(r118.toString(), Integer.class);     // Catch: Throwable -> L123
        if ((r130 instanceof Integer) == true) goto L121;
        r130 = null;
    L121:
        Object r131 = Result.m9449constructorimpl((Integer) r130);     // Catch: Throwable -> L123
    L125:
        r119 = r131;
        if (Result.m9455isFailureimpl(r119) == false) goto L128;
    L123:
        th = move-exception;
        Result.Companion r132 = Result.Companion;     // Catch: Throwable -> L130
        r131 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L130
        goto L125
    L117:
        if ((r118 instanceof JSONArray) == false) goto L127;
    L87:
        r126 = r118;
    L130:
        th = move-exception;
        Result.Companion r133 = Result.Companion;     // Catch: Throwable -> L156
        r120 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L156
    L179:
        if (((Number) r113).intValue() == 1) goto L198;
        return false;
    L198:
        return true;
    L14:
        if ((r109 instanceof Integer) == true) goto L16;
        Object r134 = null;
    L17:
        r110 = (Integer) r134;     // Catch: Throwable -> L59
        if (r110 != null) goto L57;
        if ((r109 instanceof Number) == false) goto L44;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L29;
        Float r135 = Float.valueOf(((Number) r109).floatValue());     // Catch: Throwable -> L59
        if ((r135 instanceof Integer) == true) goto L27;
        r135 = null;
    L27:
        r110 = (Integer) r135;     // Catch: Throwable -> L59
        goto L57
    L29:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L35;
        Double r136 = Double.valueOf(((Number) r109).doubleValue());     // Catch: Throwable -> L59
        if ((r136 instanceof Integer) == true) goto L33;
        r136 = null;
    L33:
        r110 = (Integer) r136;     // Catch: Throwable -> L59
        goto L57
    L35:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L38;
        r110 = Integer.valueOf(((Number) r109).intValue());     // Catch: Throwable -> L59
        goto L57
    L38:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L44;
        Long r137 = Long.valueOf(((Number) r109).longValue());     // Catch: Throwable -> L59
        if ((r137 instanceof Integer) == true) goto L42;
        r137 = null;
    L42:
        r110 = (Integer) r137;     // Catch: Throwable -> L59
    L44:
        if ((r109 instanceof JSONObject) == false) goto L46;
    L183:
        Object r138 = SDKSettingsCacheManager.a().fromJson(r109.toString(), Integer.class);     // Catch: Throwable -> L52
        if ((r138 instanceof Integer) == true) goto L50;
        r138 = null;
    L50:
        Object r139 = Result.m9449constructorimpl((Integer) r138);     // Catch: Throwable -> L52
    L54:
        r110 = r139;
        if (Result.m9455isFailureimpl(r110) == false) goto L57;
    L52:
        th = move-exception;
        Result.Companion r140 = Result.Companion;     // Catch: Throwable -> L59
        r139 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L59
        goto L54
    L46:
        if ((r109 instanceof JSONArray) == false) goto L56;
    L16:
        r134 = r109;
    L59:
        th = move-exception;
        Result.Companion r141 = Result.Companion;     // Catch: Throwable -> L169
        r111 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L169
    L169:
        th = move-exception;
        Result.Companion r142 = Result.Companion;
        Object r143 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r144 = Result.m9452exceptionOrNullimpl(r143);
        if (r144 == null) goto L174;
        EnsureManager.ensureNotReachHere(r144);
    L174:
        if (Result.m9455isFailureimpl(r143) == true) goto L177;
        r105 = r143;
    L177:
        r113 = r105;
        goto L179
    }

    public static boolean h() {
        Lazy r100 = ECAppInfoService.f48110a;
        Object r101 = null;
        if (ECAppInfoService.h() == false) goto L8;
        Map r102 = g();
        if (r102 == null) goto L197;
        r101 = r102.get("iesec_buy_finance_risk_post");
    L197:
        return Intrinsics.areEqual(r101, 1);
    L8:
        com.bytedance.android.ec.core.abtest.d r103 = com.bytedance.android.ec.core.abtest.d.f43639a;
        int r104 = j.f43647a;
        Object r105 = 0;
        int r106 = com.bytedance.android.ec.base.settings.b.f42814a;
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L169
        h.a();     // Catch: Throwable -> L169
        SDKSettingsCacheManager r108 = SDKSettingsCacheManager.f42812e;     // Catch: Throwable -> L169
        r108.getClass();     // Catch: Throwable -> L59
        Object r109 = SDKSettingsCacheManager.f42809b.get("iesec_buy_finance_risk_post");     // Catch: Throwable -> L59
        if (r109 != null) goto L14;
    L56:
        Object r110 = null;
    L57:
        Object r111 = Result.m9449constructorimpl(r110);     // Catch: Throwable -> L59
    L61:
        Throwable r112 = Result.m9452exceptionOrNullimpl(r111);     // Catch: Throwable -> L169
        if (r112 == null) goto L65;
        EnsureManager.ensureNotReachHere(r112);     // Catch: Throwable -> L169
    L65:
        if (Result.m9455isFailureimpl(r111) == false) goto L68;
        r111 = null;
    L68:
        if ((r111 instanceof Integer) == true) goto L70;
        r111 = null;
    L70:
        Object r113 = (Integer) r111;     // Catch: Throwable -> L169
        if (r113 != null) goto L77;
        r108.getClass();     // Catch: Throwable -> L169
        Object r114 = SDKSettingsCacheManager.f42808a.get("iesec_buy_finance_risk_post");     // Catch: Throwable -> L169
        if ((r114 instanceof Integer) == true) goto L76;
        r114 = null;
    L76:
        r113 = (Integer) r114;     // Catch: Throwable -> L169
    L77:
        if (r113 != null) goto L179;
        int r115 = g.f42821a;     // Catch: Throwable -> L169
    L156:
        th = move-exception;
        Result.Companion r116 = Result.Companion;     // Catch: Throwable -> L169
        Object r117 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L169
    L159:
        if (Result.m9452exceptionOrNullimpl(r117) != null) goto L187;
    L166:
        r113 = r117;
    L167:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L169
        SDKSettingsCacheManager.e("iesec_buy_finance_risk_post", r113);     // Catch: Throwable -> L169
        goto L179
    L187:
        r117 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("iesec_buy_finance_risk_post", Integer.class, r105);     // Catch: Throwable -> L163
    L164:
        if (r117 != null) goto L166;
        r113 = r105;
    L163:
        r117 = r105;
        goto L164
    L193:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L130
        Object r118 = SDKSettingsCacheManager.f42809b.get("iesec_buy_finance_risk_post");     // Catch: Throwable -> L130
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
        r113 = r122;
        goto L167
    L144:
        jj4.b r123 = jj4.b.f499326b;     // Catch: Throwable -> L156
        Object r124 = jj4.a.a("iesec_buy_finance_risk_post", Integer.class, r105, false);     // Catch: Throwable -> L156
        if (r124 != null) goto L148;
        Intrinsics.throwNpe();     // Catch: Throwable -> L156
    L148:
        if ((r124 instanceof Integer) == false) goto L151;
        r101 = r124;
    L151:
        Object r125 = (Integer) r101;     // Catch: Throwable -> L156
        if (r125 != null) goto L154;
        r125 = r105;
    L154:
        r117 = Result.m9449constructorimpl(r125);     // Catch: Throwable -> L156
    L85:
        if ((r118 instanceof Integer) == true) goto L87;
        Object r126 = null;
    L88:
        r119 = (Integer) r126;     // Catch: Throwable -> L130
        if (r119 != null) goto L128;
        if ((r118 instanceof Number) == false) goto L115;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L100;
        Float r127 = Float.valueOf(((Number) r118).floatValue());     // Catch: Throwable -> L130
        if ((r127 instanceof Integer) == true) goto L98;
        r127 = null;
    L98:
        r119 = (Integer) r127;     // Catch: Throwable -> L130
        goto L128
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L106;
        Double r128 = Double.valueOf(((Number) r118).doubleValue());     // Catch: Throwable -> L130
        if ((r128 instanceof Integer) == true) goto L104;
        r128 = null;
    L104:
        r119 = (Integer) r128;     // Catch: Throwable -> L130
        goto L128
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L109;
        r119 = Integer.valueOf(((Number) r118).intValue());     // Catch: Throwable -> L130
        goto L128
    L109:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L115;
        Long r129 = Long.valueOf(((Number) r118).longValue());     // Catch: Throwable -> L130
        if ((r129 instanceof Integer) == true) goto L113;
        r129 = null;
    L113:
        r119 = (Integer) r129;     // Catch: Throwable -> L130
    L115:
        if ((r118 instanceof JSONObject) == false) goto L117;
    L185:
        Object r130 = SDKSettingsCacheManager.a().fromJson(r118.toString(), Integer.class);     // Catch: Throwable -> L123
        if ((r130 instanceof Integer) == true) goto L121;
        r130 = null;
    L121:
        Object r131 = Result.m9449constructorimpl((Integer) r130);     // Catch: Throwable -> L123
    L125:
        r119 = r131;
        if (Result.m9455isFailureimpl(r119) == false) goto L128;
    L123:
        th = move-exception;
        Result.Companion r132 = Result.Companion;     // Catch: Throwable -> L130
        r131 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L130
        goto L125
    L117:
        if ((r118 instanceof JSONArray) == false) goto L127;
    L87:
        r126 = r118;
    L130:
        th = move-exception;
        Result.Companion r133 = Result.Companion;     // Catch: Throwable -> L156
        r120 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L156
    L179:
        if (((Number) r113).intValue() == 1) goto L198;
        return false;
    L198:
        return true;
    L14:
        if ((r109 instanceof Integer) == true) goto L16;
        Object r134 = null;
    L17:
        r110 = (Integer) r134;     // Catch: Throwable -> L59
        if (r110 != null) goto L57;
        if ((r109 instanceof Number) == false) goto L44;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L29;
        Float r135 = Float.valueOf(((Number) r109).floatValue());     // Catch: Throwable -> L59
        if ((r135 instanceof Integer) == true) goto L27;
        r135 = null;
    L27:
        r110 = (Integer) r135;     // Catch: Throwable -> L59
        goto L57
    L29:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L35;
        Double r136 = Double.valueOf(((Number) r109).doubleValue());     // Catch: Throwable -> L59
        if ((r136 instanceof Integer) == true) goto L33;
        r136 = null;
    L33:
        r110 = (Integer) r136;     // Catch: Throwable -> L59
        goto L57
    L35:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L38;
        r110 = Integer.valueOf(((Number) r109).intValue());     // Catch: Throwable -> L59
        goto L57
    L38:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L44;
        Long r137 = Long.valueOf(((Number) r109).longValue());     // Catch: Throwable -> L59
        if ((r137 instanceof Integer) == true) goto L42;
        r137 = null;
    L42:
        r110 = (Integer) r137;     // Catch: Throwable -> L59
    L44:
        if ((r109 instanceof JSONObject) == false) goto L46;
    L183:
        Object r138 = SDKSettingsCacheManager.a().fromJson(r109.toString(), Integer.class);     // Catch: Throwable -> L52
        if ((r138 instanceof Integer) == true) goto L50;
        r138 = null;
    L50:
        Object r139 = Result.m9449constructorimpl((Integer) r138);     // Catch: Throwable -> L52
    L54:
        r110 = r139;
        if (Result.m9455isFailureimpl(r110) == false) goto L57;
    L52:
        th = move-exception;
        Result.Companion r140 = Result.Companion;     // Catch: Throwable -> L59
        r139 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L59
        goto L54
    L46:
        if ((r109 instanceof JSONArray) == false) goto L56;
    L16:
        r134 = r109;
    L59:
        th = move-exception;
        Result.Companion r141 = Result.Companion;     // Catch: Throwable -> L169
        r111 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L169
    L169:
        th = move-exception;
        Result.Companion r142 = Result.Companion;
        Object r143 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r144 = Result.m9452exceptionOrNullimpl(r143);
        if (r144 == null) goto L174;
        EnsureManager.ensureNotReachHere(r144);
    L174:
        if (Result.m9455isFailureimpl(r143) == true) goto L177;
        r105 = r143;
    L177:
        r113 = r105;
        goto L179
    }

    public static boolean c() {
        Map r100 = g();
        if (r100 == null) goto L5;
        Object r101 = r100.get("iesec_enable_pass_through_deprecated");
    L7:
        return Intrinsics.areEqual(r101, 1);
    L5:
        r101 = null;
        goto L7
    }

    public static boolean e() {
        Map r100 = g();
        if (r100 == null) goto L5;
        Object r101 = r100.get("buy_now_entrance_simplify");
    L7:
        return Intrinsics.areEqual(r101, 2);
    L5:
        r101 = null;
        goto L7
    }

    public static boolean f() {
        Map r100 = g();
        if (r100 == null) goto L5;
        Object r101 = r100.get("buy_now_entrance_simplify");
    L7:
        return Intrinsics.areEqual(r101, 1);
    L5:
        r101 = null;
        goto L7
    }

    public static boolean i() {
        Map r100 = g();
        if (r100 == null) goto L5;
        Object r101 = r100.get("ab_buy_now_precreate_slice_view");
    L7:
        return Intrinsics.areEqual(r101, 1);
    L5:
        r101 = null;
        goto L7
    }

    public static boolean j() {
        Map r100 = g();
        if (r100 == null) goto L5;
        Object r101 = r100.get("buy_now_render_simplify");
    L7:
        return Intrinsics.areEqual(r101, 1);
    L5:
        r101 = null;
        goto L7
    }

    public static boolean k() {
        Map r100 = g();
        if (r100 == null) goto L5;
        Object r101 = r100.get("buy_now_replace_host_v2");
    L7:
        return Intrinsics.areEqual(r101, 1);
    L5:
        r101 = null;
        goto L7
    }

    public static void l() {
        Map r100 = g();
        if (r100 == null) goto L5;
        Object r101 = r100.get("iesec_enable_yata_sku_params_simplify");
    L6:
        Intrinsics.areEqual(r101, 1);
        return;
    L5:
        r101 = null;
        goto L6
    }

    public static boolean m() {
        Map r100 = g();
        if (r100 == null) goto L5;
        Object r101 = r100.get("ec_sku_height_imp_all");
    L7:
        return Intrinsics.areEqual(r101, 1);
    L5:
        r101 = null;
        goto L7
    }

    public static boolean n() {
        Map r100 = g();
        if (r100 == null) goto L5;
        Object r101 = r100.get("ec_sku_height_imp_card");
    L7:
        return Intrinsics.areEqual(r101, 1);
    L5:
        r101 = null;
        goto L7
    }

    public static boolean o() {
        Map r100 = g();
        if (r100 == null) goto L5;
        Object r101 = r100.get("ec_sku_height_imp_force_type");
    L7:
        return Intrinsics.areEqual(r101, 2);
    L5:
        r101 = null;
        goto L7
    }

    public static boolean p() {
        Map r100 = g();
        if (r100 == null) goto L5;
        Object r101 = r100.get("ec_sku_height_imp_force_type");
    L7:
        return Intrinsics.areEqual(r101, 1);
    L5:
        r101 = null;
        goto L7
    }

    public static boolean q() {
        Map r100 = g();
        if (r100 == null) goto L5;
        Object r101 = r100.get("buy_now_slice_template_config_opt");
    L7:
        return Intrinsics.areEqual(r101, 1);
    L5:
        r101 = null;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v4, types: [java.util.ArrayList] */
    public static void r(BuyNowBizCode r110) {
        Intrinsics.checkNotNullParameter(r110, "buynowBizCode");
        Context r100 = ECAppInfoService.f48114e.getApplicationContext();
        if (r100 != null) goto L5;
        return;
    L5:
        String r101 = r110.getValue();
        BuyNowBizCode r102 = BuyNowBizCode.YATA_SKUBUY;
        if (Intrinsics.areEqual(r101, r102.getValue()) == false) goto L11;
        if (q() == false) goto L11;
        a r103 = new a("performance_opt_ultimate_buynow", "ultimate_buynow");
    L22:
        z43.b r104 = ECSettingKeys.f();
        Map r105 = null;
        Object r106 = null;
        if (r104.b() == true) goto L26;
        r104 = null;
    L26:
        if (r104 == null) goto L63;
        Map<String, List<z43.a>> r107 = r104.c();
        if (r107 == null) goto L31;
        List<z43.a> r108 = r107.get(r103.f43907a);
        if (r108 == null) goto L31;
    L35:
        if (r108 == null) goto L50;
        ArrayList r109 = new ArrayList();
        Iterator r111 = r108.iterator();
    L38:
        if (r111.hasNext() == false) goto L49;
        z43.a r112 = (z43.a) r111.next();
        int r113 = r112.b();
        Map<String, List<com.bytedance.android.ecom.slice.ext.template.gecko.j>> r114 = r104.a();
        if (r114 == null) goto L47;
        List<com.bytedance.android.ecom.slice.ext.template.gecko.j> r115 = r114.get(r112.a());
        if (r115 == null) goto L47;
        List<com.bytedance.android.ecom.slice.ext.template.gecko.j> r116 = r115;
        ?? r117 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r116, 10));
        Iterator r118 = r116.iterator();
    L45:
        if (r118.hasNext() == false) goto L48;
        com.bytedance.android.ecom.slice.ext.template.gecko.j r119 = (com.bytedance.android.ecom.slice.ext.template.gecko.j) r118.next();
        r117.add(new com.bytedance.android.ecom.slice.ext.template.gecko.j(r119.a(), r119.c(), r119.b() * r113));
    L48:
        CollectionsKt.addAll(r109, (Iterable) r117);
    L47:
        r117 = CollectionsKt.emptyList();
        goto L48
    L49:
        List r120 = CollectionsKt.toList(r109);
    L51:
        String r121 = ECSettingKeys.e();
        if (r121 != null) goto L66;
    L62:
        final com.bytedance.android.ecom.slice.ext.template.gecko.g r122 = new com.bytedance.android.ecom.slice.ext.template.gecko.g(r120, r105, i());
    L64:
        SlcGeckoTemplateMgr.f(SlcGeckoTemplateMgr.f51232l, r110.getValue(), "ecom_buynow_card_template", wh.a.b(r100), new BuyNowPerformanceOpt$preloadTemplate$1(r122));
        return;
    L66:
        Result.Companion r123 = Result.Companion;     // Catch: Throwable -> L55
        int r124 = t0.f45720a;     // Catch: Throwable -> L55
        Object r125 = Result.m9449constructorimpl(((b) t0.a.f45721a.fromJson("{\"map\":" + r121 + i.f25855d, b.class)).a());     // Catch: Throwable -> L55
    L58:
        if (Result.m9455isFailureimpl(r125) == true) goto L61;
        r106 = r125;
    L61:
        r105 = (Map) r106;
    L55:
        th = move-exception;
        Result.Companion r126 = Result.Companion;
        r125 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L58
    L50:
        r120 = null;
    L31:
        Map<String, List<z43.a>> r127 = r104.c();
        if (r127 == null) goto L34;
        r108 = r127.get(r103.f43908b);
        goto L35
    L34:
        r108 = null;
        goto L35
    L63:
        r122 = new com.bytedance.android.ecom.slice.ext.template.gecko.g(null, 7);
    L11:
        if (Intrinsics.areEqual(r110.getValue(), r102.getValue()) == false) goto L16;
        if (q() == true) goto L16;
        r103 = new a("ultimate_buynow", "ultimate_buynow");
    L16:
        if (Intrinsics.areEqual(r110.getValue(), BuyNowBizCode.CONTINUE_PAY.getValue()) == false) goto L19;
        r103 = new a("continue_pay", "continue_pay");
        goto L22
    L19:
        if (q() == false) goto L21;
        r103 = new a("performance_opt_single_product", "single_normal_product");
        goto L22
    L21:
        r103 = new a("single_normal_product", "single_normal_product");
        goto L22
    }
}
