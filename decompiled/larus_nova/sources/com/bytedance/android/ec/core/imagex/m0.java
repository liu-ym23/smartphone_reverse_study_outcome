package com.bytedance.android.ec.core.imagex;

import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.hybrid.hostapi.IECHybridKevaService;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.services.apm.api.EnsureManager;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f44690a;

    public static boolean a() {
        int r100 = com.bytedance.android.ec.base.settings.b.f42814a;
        Object r101 = Boolean.FALSE;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L172
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L172
        SDKSettingsCacheManager r103 = SDKSettingsCacheManager.f42812e;     // Catch: Throwable -> L172
        Object r104 = null;
        r103.getClass();     // Catch: Throwable -> L59
        Object r105 = SDKSettingsCacheManager.f42809b.get("ec_image_event_monitor");     // Catch: Throwable -> L59
        if (r105 != null) goto L11;
    L56:
        Object r106 = null;
    L57:
        Object r107 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L59
    L61:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);     // Catch: Throwable -> L172
        if (r108 == null) goto L65;
        EnsureManager.ensureNotReachHere(r108);     // Catch: Throwable -> L172
    L65:
        if (Result.m9455isFailureimpl(r107) == false) goto L68;
        r107 = null;
    L68:
        if ((r107 instanceof Boolean) == true) goto L70;
        r107 = null;
    L70:
        Object r109 = (Boolean) r107;     // Catch: Throwable -> L172
        if (r109 != null) goto L77;
        r103.getClass();     // Catch: Throwable -> L172
        Object r110 = SDKSettingsCacheManager.f42808a.get("ec_image_event_monitor");     // Catch: Throwable -> L172
        if ((r110 instanceof Boolean) == true) goto L76;
        r110 = null;
    L76:
        r109 = (Boolean) r110;     // Catch: Throwable -> L172
    L77:
        if (r109 != null) goto L182;
        int r111 = com.bytedance.android.ec.base.settings.g.f42821a;     // Catch: Throwable -> L172
    L159:
        th = move-exception;
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L172
        Object r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L172
    L162:
        if (Result.m9452exceptionOrNullimpl(r113) != null) goto L185;
    L169:
        r109 = r113;
    L170:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L172
        SDKSettingsCacheManager.e("ec_image_event_monitor", r109);     // Catch: Throwable -> L172
        goto L182
    L185:
        r113 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ec_image_event_monitor", Boolean.class, r101);     // Catch: Throwable -> L166
    L167:
        if (r113 != null) goto L169;
        r109 = r101;
    L166:
        r113 = r101;
        goto L167
    L191:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L133
        Object r114 = SDKSettingsCacheManager.f42809b.get("ec_image_event_monitor");     // Catch: Throwable -> L133
        if (r114 != null) goto L85;
    L130:
        Object r115 = null;
    L131:
        Object r116 = Result.m9449constructorimpl(r115);     // Catch: Throwable -> L133
    L135:
        Throwable r117 = Result.m9452exceptionOrNullimpl(r116);     // Catch: Throwable -> L159
        if (r117 == null) goto L139;
        EnsureManager.ensureNotReachHere(r117);     // Catch: Throwable -> L159
    L139:
        if (Result.m9455isFailureimpl(r116) == false) goto L142;
        r116 = null;
    L142:
        if ((r116 instanceof Boolean) == true) goto L144;
        r116 = null;
    L144:
        r113 = (Boolean) r116;     // Catch: Throwable -> L159
        if (r113 != null) goto L169;
        jj4.b r118 = jj4.b.f499326b;     // Catch: Throwable -> L159
        Object r119 = jj4.a.a("ec_image_event_monitor", Boolean.class, r101, false);     // Catch: Throwable -> L159
        if (r119 != null) goto L151;
        Intrinsics.throwNpe();     // Catch: Throwable -> L159
    L151:
        if ((r119 instanceof Boolean) == false) goto L154;
        r104 = r119;
    L154:
        Object r120 = (Boolean) r104;     // Catch: Throwable -> L159
        if (r120 != null) goto L157;
        r120 = r101;
    L157:
        r113 = Result.m9449constructorimpl(r120);     // Catch: Throwable -> L159
    L85:
        if ((r114 instanceof Boolean) == true) goto L87;
        Object r121 = null;
    L88:
        r115 = (Boolean) r121;     // Catch: Throwable -> L133
        if (r115 != null) goto L131;
        if ((r114 instanceof Number) == false) goto L118;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L100;
        Float r122 = Float.valueOf(((Number) r114).floatValue());     // Catch: Throwable -> L133
        if ((r122 instanceof Boolean) == true) goto L98;
        r122 = null;
    L98:
        r115 = (Boolean) r122;     // Catch: Throwable -> L133
        goto L131
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L106;
        Double r123 = Double.valueOf(((Number) r114).doubleValue());     // Catch: Throwable -> L133
        if ((r123 instanceof Boolean) == true) goto L104;
        r123 = null;
    L104:
        r115 = (Boolean) r123;     // Catch: Throwable -> L133
        goto L131
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L112;
        Integer r124 = Integer.valueOf(((Number) r114).intValue());     // Catch: Throwable -> L133
        if ((r124 instanceof Boolean) == true) goto L110;
        r124 = null;
    L110:
        r115 = (Boolean) r124;     // Catch: Throwable -> L133
        goto L131
    L112:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L118;
        Long r125 = Long.valueOf(((Number) r114).longValue());     // Catch: Throwable -> L133
        if ((r125 instanceof Boolean) == true) goto L116;
        r125 = null;
    L116:
        r115 = (Boolean) r125;     // Catch: Throwable -> L133
    L118:
        if ((r114 instanceof JSONObject) == false) goto L120;
    L183:
        Object r126 = SDKSettingsCacheManager.a().fromJson(r114.toString(), Boolean.class);     // Catch: Throwable -> L126
        if ((r126 instanceof Boolean) == true) goto L124;
        r126 = null;
    L124:
        Object r127 = Result.m9449constructorimpl((Boolean) r126);     // Catch: Throwable -> L126
    L128:
        r115 = r127;
        if (Result.m9455isFailureimpl(r115) == false) goto L131;
    L126:
        th = move-exception;
        Result.Companion r128 = Result.Companion;     // Catch: Throwable -> L133
        r127 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L133
        goto L128
    L120:
        if ((r114 instanceof JSONArray) == false) goto L130;
    L87:
        r121 = r114;
    L133:
        th = move-exception;
        Result.Companion r129 = Result.Companion;     // Catch: Throwable -> L159
        r116 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L159
    L182:
        return ((Boolean) r109).booleanValue();
    L11:
        if ((r105 instanceof Boolean) == true) goto L13;
        Object r130 = null;
    L14:
        r106 = (Boolean) r130;     // Catch: Throwable -> L59
        if (r106 != null) goto L57;
        if ((r105 instanceof Number) == false) goto L44;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r131 = Float.valueOf(((Number) r105).floatValue());     // Catch: Throwable -> L59
        if ((r131 instanceof Boolean) == true) goto L24;
        r131 = null;
    L24:
        r106 = (Boolean) r131;     // Catch: Throwable -> L59
        goto L57
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r132 = Double.valueOf(((Number) r105).doubleValue());     // Catch: Throwable -> L59
        if ((r132 instanceof Boolean) == true) goto L30;
        r132 = null;
    L30:
        r106 = (Boolean) r132;     // Catch: Throwable -> L59
        goto L57
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L38;
        Integer r133 = Integer.valueOf(((Number) r105).intValue());     // Catch: Throwable -> L59
        if ((r133 instanceof Boolean) == true) goto L36;
        r133 = null;
    L36:
        r106 = (Boolean) r133;     // Catch: Throwable -> L59
        goto L57
    L38:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L44;
        Long r134 = Long.valueOf(((Number) r105).longValue());     // Catch: Throwable -> L59
        if ((r134 instanceof Boolean) == true) goto L42;
        r134 = null;
    L42:
        r106 = (Boolean) r134;     // Catch: Throwable -> L59
    L44:
        if ((r105 instanceof JSONObject) == false) goto L46;
    L189:
        Object r135 = SDKSettingsCacheManager.a().fromJson(r105.toString(), Boolean.class);     // Catch: Throwable -> L52
        if ((r135 instanceof Boolean) == true) goto L50;
        r135 = null;
    L50:
        Object r136 = Result.m9449constructorimpl((Boolean) r135);     // Catch: Throwable -> L52
    L54:
        r106 = r136;
        if (Result.m9455isFailureimpl(r106) == false) goto L57;
    L52:
        th = move-exception;
        Result.Companion r137 = Result.Companion;     // Catch: Throwable -> L59
        r136 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L59
        goto L54
    L46:
        if ((r105 instanceof JSONArray) == false) goto L56;
    L13:
        r130 = r105;
    L59:
        th = move-exception;
        Result.Companion r138 = Result.Companion;     // Catch: Throwable -> L172
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L172
    L172:
        th = move-exception;
        Result.Companion r139 = Result.Companion;
        Object r140 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r141 = Result.m9452exceptionOrNullimpl(r140);
        if (r141 == null) goto L177;
        EnsureManager.ensureNotReachHere(r141);
    L177:
        if (Result.m9455isFailureimpl(r140) == true) goto L180;
        r101 = r140;
    L180:
        r109 = r101;
        goto L182
    }

    public static boolean b() {
        int r100 = com.bytedance.android.ec.base.settings.b.f42814a;
        Object r101 = Boolean.FALSE;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L172
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L172
        SDKSettingsCacheManager r103 = SDKSettingsCacheManager.f42812e;     // Catch: Throwable -> L172
        Object r104 = null;
        r103.getClass();     // Catch: Throwable -> L59
        Object r105 = SDKSettingsCacheManager.f42809b.get("ec_image_perf_opt");     // Catch: Throwable -> L59
        if (r105 != null) goto L11;
    L56:
        Object r106 = null;
    L57:
        Object r107 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L59
    L61:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);     // Catch: Throwable -> L172
        if (r108 == null) goto L65;
        EnsureManager.ensureNotReachHere(r108);     // Catch: Throwable -> L172
    L65:
        if (Result.m9455isFailureimpl(r107) == false) goto L68;
        r107 = null;
    L68:
        if ((r107 instanceof Boolean) == true) goto L70;
        r107 = null;
    L70:
        Object r109 = (Boolean) r107;     // Catch: Throwable -> L172
        if (r109 != null) goto L77;
        r103.getClass();     // Catch: Throwable -> L172
        Object r110 = SDKSettingsCacheManager.f42808a.get("ec_image_perf_opt");     // Catch: Throwable -> L172
        if ((r110 instanceof Boolean) == true) goto L76;
        r110 = null;
    L76:
        r109 = (Boolean) r110;     // Catch: Throwable -> L172
    L77:
        if (r109 != null) goto L182;
        int r111 = com.bytedance.android.ec.base.settings.g.f42821a;     // Catch: Throwable -> L172
    L159:
        th = move-exception;
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L172
        Object r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L172
    L162:
        if (Result.m9452exceptionOrNullimpl(r113) != null) goto L185;
    L169:
        r109 = r113;
    L170:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L172
        SDKSettingsCacheManager.e("ec_image_perf_opt", r109);     // Catch: Throwable -> L172
        goto L182
    L185:
        r113 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ec_image_perf_opt", Boolean.class, r101);     // Catch: Throwable -> L166
    L167:
        if (r113 != null) goto L169;
        r109 = r101;
    L166:
        r113 = r101;
        goto L167
    L191:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L133
        Object r114 = SDKSettingsCacheManager.f42809b.get("ec_image_perf_opt");     // Catch: Throwable -> L133
        if (r114 != null) goto L85;
    L130:
        Object r115 = null;
    L131:
        Object r116 = Result.m9449constructorimpl(r115);     // Catch: Throwable -> L133
    L135:
        Throwable r117 = Result.m9452exceptionOrNullimpl(r116);     // Catch: Throwable -> L159
        if (r117 == null) goto L139;
        EnsureManager.ensureNotReachHere(r117);     // Catch: Throwable -> L159
    L139:
        if (Result.m9455isFailureimpl(r116) == false) goto L142;
        r116 = null;
    L142:
        if ((r116 instanceof Boolean) == true) goto L144;
        r116 = null;
    L144:
        r113 = (Boolean) r116;     // Catch: Throwable -> L159
        if (r113 != null) goto L169;
        jj4.b r118 = jj4.b.f499326b;     // Catch: Throwable -> L159
        Object r119 = jj4.a.a("ec_image_perf_opt", Boolean.class, r101, false);     // Catch: Throwable -> L159
        if (r119 != null) goto L151;
        Intrinsics.throwNpe();     // Catch: Throwable -> L159
    L151:
        if ((r119 instanceof Boolean) == false) goto L154;
        r104 = r119;
    L154:
        Object r120 = (Boolean) r104;     // Catch: Throwable -> L159
        if (r120 != null) goto L157;
        r120 = r101;
    L157:
        r113 = Result.m9449constructorimpl(r120);     // Catch: Throwable -> L159
    L85:
        if ((r114 instanceof Boolean) == true) goto L87;
        Object r121 = null;
    L88:
        r115 = (Boolean) r121;     // Catch: Throwable -> L133
        if (r115 != null) goto L131;
        if ((r114 instanceof Number) == false) goto L118;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L100;
        Float r122 = Float.valueOf(((Number) r114).floatValue());     // Catch: Throwable -> L133
        if ((r122 instanceof Boolean) == true) goto L98;
        r122 = null;
    L98:
        r115 = (Boolean) r122;     // Catch: Throwable -> L133
        goto L131
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L106;
        Double r123 = Double.valueOf(((Number) r114).doubleValue());     // Catch: Throwable -> L133
        if ((r123 instanceof Boolean) == true) goto L104;
        r123 = null;
    L104:
        r115 = (Boolean) r123;     // Catch: Throwable -> L133
        goto L131
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L112;
        Integer r124 = Integer.valueOf(((Number) r114).intValue());     // Catch: Throwable -> L133
        if ((r124 instanceof Boolean) == true) goto L110;
        r124 = null;
    L110:
        r115 = (Boolean) r124;     // Catch: Throwable -> L133
        goto L131
    L112:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L118;
        Long r125 = Long.valueOf(((Number) r114).longValue());     // Catch: Throwable -> L133
        if ((r125 instanceof Boolean) == true) goto L116;
        r125 = null;
    L116:
        r115 = (Boolean) r125;     // Catch: Throwable -> L133
    L118:
        if ((r114 instanceof JSONObject) == false) goto L120;
    L183:
        Object r126 = SDKSettingsCacheManager.a().fromJson(r114.toString(), Boolean.class);     // Catch: Throwable -> L126
        if ((r126 instanceof Boolean) == true) goto L124;
        r126 = null;
    L124:
        Object r127 = Result.m9449constructorimpl((Boolean) r126);     // Catch: Throwable -> L126
    L128:
        r115 = r127;
        if (Result.m9455isFailureimpl(r115) == false) goto L131;
    L126:
        th = move-exception;
        Result.Companion r128 = Result.Companion;     // Catch: Throwable -> L133
        r127 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L133
        goto L128
    L120:
        if ((r114 instanceof JSONArray) == false) goto L130;
    L87:
        r121 = r114;
    L133:
        th = move-exception;
        Result.Companion r129 = Result.Companion;     // Catch: Throwable -> L159
        r116 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L159
    L182:
        return ((Boolean) r109).booleanValue();
    L11:
        if ((r105 instanceof Boolean) == true) goto L13;
        Object r130 = null;
    L14:
        r106 = (Boolean) r130;     // Catch: Throwable -> L59
        if (r106 != null) goto L57;
        if ((r105 instanceof Number) == false) goto L44;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r131 = Float.valueOf(((Number) r105).floatValue());     // Catch: Throwable -> L59
        if ((r131 instanceof Boolean) == true) goto L24;
        r131 = null;
    L24:
        r106 = (Boolean) r131;     // Catch: Throwable -> L59
        goto L57
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r132 = Double.valueOf(((Number) r105).doubleValue());     // Catch: Throwable -> L59
        if ((r132 instanceof Boolean) == true) goto L30;
        r132 = null;
    L30:
        r106 = (Boolean) r132;     // Catch: Throwable -> L59
        goto L57
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L38;
        Integer r133 = Integer.valueOf(((Number) r105).intValue());     // Catch: Throwable -> L59
        if ((r133 instanceof Boolean) == true) goto L36;
        r133 = null;
    L36:
        r106 = (Boolean) r133;     // Catch: Throwable -> L59
        goto L57
    L38:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L44;
        Long r134 = Long.valueOf(((Number) r105).longValue());     // Catch: Throwable -> L59
        if ((r134 instanceof Boolean) == true) goto L42;
        r134 = null;
    L42:
        r106 = (Boolean) r134;     // Catch: Throwable -> L59
    L44:
        if ((r105 instanceof JSONObject) == false) goto L46;
    L189:
        Object r135 = SDKSettingsCacheManager.a().fromJson(r105.toString(), Boolean.class);     // Catch: Throwable -> L52
        if ((r135 instanceof Boolean) == true) goto L50;
        r135 = null;
    L50:
        Object r136 = Result.m9449constructorimpl((Boolean) r135);     // Catch: Throwable -> L52
    L54:
        r106 = r136;
        if (Result.m9455isFailureimpl(r106) == false) goto L57;
    L52:
        th = move-exception;
        Result.Companion r137 = Result.Companion;     // Catch: Throwable -> L59
        r136 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L59
        goto L54
    L46:
        if ((r105 instanceof JSONArray) == false) goto L56;
    L13:
        r130 = r105;
    L59:
        th = move-exception;
        Result.Companion r138 = Result.Companion;     // Catch: Throwable -> L172
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L172
    L172:
        th = move-exception;
        Result.Companion r139 = Result.Companion;
        Object r140 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r141 = Result.m9452exceptionOrNullimpl(r140);
        if (r141 == null) goto L177;
        EnsureManager.ensureNotReachHere(r141);
    L177:
        if (Result.m9455isFailureimpl(r140) == true) goto L180;
        r101 = r140;
    L180:
        r109 = r101;
        goto L182
    }

    static {
    }

    public static void c(String r100) {
        if (ECAppInfoService.f48114e.i() == true) goto L5;
        return;
    L5:
        a();
        b();
        if (f44690a == true) goto L9;
        f44690a = true;
        return;
    }
}
