package com.bytedance.android.ec.core.abtest;

import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.core.opt.ab.n;
import com.bytedance.android.ec.core.opt.ab.p;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.services.apm.api.EnsureManager;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f43644a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static ECSettingsConfig f43645b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Boolean f43646c;

    static {
        new ConcurrentHashMap();
    }

    public static boolean a() {
        if (f43646c != null) goto L176;
        int r100 = com.bytedance.android.ec.core.opt.ab.c.f45223a;
        int r101 = n.f45241a;
        Object r102 = 0;
        int r103 = com.bytedance.android.ec.base.settings.a.f42813a;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L162
        Object r105 = null;
        Object r106 = com.bytedance.android.ec.base.settings.d.f42818c.get("ecom_host_settings_opt_enable");     // Catch: Throwable -> L56
        if (r106 != null) goto L11;
    L53:
        Object r107 = null;
    L54:
        Object r108 = Result.m9449constructorimpl(r107);     // Catch: Throwable -> L56
    L58:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);     // Catch: Throwable -> L162
        if (r109 == null) goto L62;
        EnsureManager.ensureNotReachHere(r109);     // Catch: Throwable -> L162
    L62:
        if (Result.m9455isFailureimpl(r108) == false) goto L65;
        r108 = null;
    L65:
        if ((r108 instanceof Integer) == true) goto L67;
        r108 = null;
    L67:
        Object r110 = (Integer) r108;     // Catch: Throwable -> L162
        if (r110 != null) goto L74;
        Object r111 = com.bytedance.android.ec.base.settings.d.f42816a.get("ecom_host_settings_opt_enable");     // Catch: Throwable -> L162
        if ((r111 instanceof Integer) == true) goto L73;
        r111 = null;
    L73:
        r110 = (Integer) r111;     // Catch: Throwable -> L162
    L74:
        if (r110 != null) goto L172;
        int r112 = com.bytedance.android.ec.base.settings.c.f42815a;     // Catch: Throwable -> L162
        Object r113 = com.bytedance.android.ec.base.settings.d.f42818c.get("ecom_host_settings_opt_enable");     // Catch: Throwable -> L126
        if (r113 != null) goto L81;
    L123:
        Object r114 = null;
    L124:
        Object r115 = Result.m9449constructorimpl(r114);     // Catch: Throwable -> L126
    L128:
        Throwable r116 = Result.m9452exceptionOrNullimpl(r115);     // Catch: Throwable -> L152
        if (r116 == null) goto L132;
        EnsureManager.ensureNotReachHere(r116);     // Catch: Throwable -> L152
    L132:
        if (Result.m9455isFailureimpl(r115) == false) goto L135;
        r115 = null;
    L135:
        if ((r115 instanceof Integer) == true) goto L137;
        r115 = null;
    L137:
        r110 = (Integer) r115;     // Catch: Throwable -> L152
        if (r110 != null) goto L160;
        IHybridHostService r117 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L152
        if (r117 == null) goto L143;
        Object r118 = r117.getHostABValue("ecom_host_settings_opt_enable", r102);     // Catch: Throwable -> L152
    L144:
        if (r118 != null) goto L146;
    L151:
        r110 = r102;
        goto L160
    L146:
        if ((r118 instanceof Integer) == false) goto L149;
        r105 = r118;
    L149:
        Object r119 = (Integer) r105;     // Catch: Throwable -> L152
        if (r119 == null) goto L151;
    L159:
        r110 = r119;
        goto L160
    L143:
        r118 = null;
    L160:
        com.bytedance.android.ec.base.settings.d.d("ecom_host_settings_opt_enable", r110);     // Catch: Throwable -> L162
        goto L172
    L81:
        if ((r113 instanceof Integer) == true) goto L83;
        Object r120 = null;
    L84:
        r114 = (Integer) r120;     // Catch: Throwable -> L126
        if (r114 != null) goto L124;
        if ((r113 instanceof Number) == false) goto L111;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L96;
        Float r121 = Float.valueOf(((Number) r113).floatValue());     // Catch: Throwable -> L126
        if ((r121 instanceof Integer) == true) goto L94;
        r121 = null;
    L94:
        r114 = (Integer) r121;     // Catch: Throwable -> L126
        goto L124
    L96:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L102;
        Double r122 = Double.valueOf(((Number) r113).doubleValue());     // Catch: Throwable -> L126
        if ((r122 instanceof Integer) == true) goto L100;
        r122 = null;
    L100:
        r114 = (Integer) r122;     // Catch: Throwable -> L126
        goto L124
    L102:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L105;
        r114 = Integer.valueOf(((Number) r113).intValue());     // Catch: Throwable -> L126
        goto L124
    L105:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L111;
        Long r123 = Long.valueOf(((Number) r113).longValue());     // Catch: Throwable -> L126
        if ((r123 instanceof Integer) == true) goto L109;
        r123 = null;
    L109:
        r114 = (Integer) r123;     // Catch: Throwable -> L126
    L111:
        if ((r113 instanceof JSONObject) == false) goto L113;
    L186:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L119
        Object r124 = SDKSettingsCacheManager.a().fromJson(r113.toString(), Integer.class);     // Catch: Throwable -> L119
        if ((r124 instanceof Integer) == true) goto L117;
        r124 = null;
    L117:
        Object r125 = Result.m9449constructorimpl((Integer) r124);     // Catch: Throwable -> L119
    L121:
        r114 = r125;
        if (Result.m9455isFailureimpl(r114) == false) goto L124;
    L119:
        th = move-exception;
        Result.Companion r126 = Result.Companion;     // Catch: Throwable -> L126
        r125 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L126
        goto L121
    L113:
        if ((r113 instanceof JSONArray) == false) goto L123;
    L83:
        r120 = r113;
    L152:
        th = move-exception;
        Result.Companion r127 = Result.Companion;     // Catch: Throwable -> L162
        r119 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L162
        Throwable r128 = Result.m9452exceptionOrNullimpl(r119);     // Catch: Throwable -> L162
        if (r128 == null) goto L157;
        EnsureManager.ensureNotReachHere(r128);     // Catch: Throwable -> L162
    L157:
        if (Result.m9455isFailureimpl(r119) == false) goto L159;
        r119 = r102;
    L126:
        th = move-exception;
        Result.Companion r129 = Result.Companion;     // Catch: Throwable -> L152
        r115 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L152
    L172:
        if (((Number) r110).intValue() != 1) goto L174;
        boolean r130 = true;
    L175:
        f43646c = Boolean.valueOf(r130);
        goto L176
    L174:
        r130 = false;
        goto L175
    L11:
        if ((r106 instanceof Integer) == true) goto L13;
        Object r131 = null;
    L14:
        r107 = (Integer) r131;     // Catch: Throwable -> L56
        if (r107 != null) goto L54;
        if ((r106 instanceof Number) == false) goto L41;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r132 = Float.valueOf(((Number) r106).floatValue());     // Catch: Throwable -> L56
        if ((r132 instanceof Integer) == true) goto L24;
        r132 = null;
    L24:
        r107 = (Integer) r132;     // Catch: Throwable -> L56
        goto L54
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r133 = Double.valueOf(((Number) r106).doubleValue());     // Catch: Throwable -> L56
        if ((r133 instanceof Integer) == true) goto L30;
        r133 = null;
    L30:
        r107 = (Integer) r133;     // Catch: Throwable -> L56
        goto L54
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L35;
        r107 = Integer.valueOf(((Number) r106).intValue());     // Catch: Throwable -> L56
        goto L54
    L35:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L41;
        Long r134 = Long.valueOf(((Number) r106).longValue());     // Catch: Throwable -> L56
        if ((r134 instanceof Integer) == true) goto L39;
        r134 = null;
    L39:
        r107 = (Integer) r134;     // Catch: Throwable -> L56
    L41:
        if ((r106 instanceof JSONObject) == false) goto L43;
    L184:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L49
        Object r135 = SDKSettingsCacheManager.a().fromJson(r106.toString(), Integer.class);     // Catch: Throwable -> L49
        if ((r135 instanceof Integer) == true) goto L47;
        r135 = null;
    L47:
        Object r136 = Result.m9449constructorimpl((Integer) r135);     // Catch: Throwable -> L49
    L51:
        r107 = r136;
        if (Result.m9455isFailureimpl(r107) == false) goto L54;
    L49:
        th = move-exception;
        Result.Companion r137 = Result.Companion;     // Catch: Throwable -> L56
        r136 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L56
        goto L51
    L43:
        if ((r106 instanceof JSONArray) == false) goto L53;
    L13:
        r131 = r106;
    L56:
        th = move-exception;
        Result.Companion r138 = Result.Companion;     // Catch: Throwable -> L162
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L162
    L162:
        th = move-exception;
        Result.Companion r139 = Result.Companion;
        Object r140 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r141 = Result.m9452exceptionOrNullimpl(r140);
        if (r141 == null) goto L167;
        EnsureManager.ensureNotReachHere(r141);
    L167:
        if (Result.m9455isFailureimpl(r140) == true) goto L170;
        r102 = r140;
    L170:
        r110 = r102;
    L176:
        ECSettingsConfig r142 = b();
        if (r142 != null) goto L179;
        return false;
    L179:
        if (r142.getPreloadEnable() == true) goto L181;
        return false;
    L181:
        if (Intrinsics.areEqual(f43646c, Boolean.TRUE) == false) goto L197;
        return true;
    L197:
        return false;
    }

    public static ECSettingsConfig b() {
        if (f43645b != null) goto L19;
        if (f43644a == false) goto L19;
        Lazy r100 = ECSettingKeys.f43616a;
        int r101 = p.f45243a;
        Object r110 = new ECSettingsConfig(false, false, 0, 0, 0, 31, null);
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L11
        jj4.b r103 = jj4.b.f499326b;     // Catch: Throwable -> L11
        Object r104 = jj4.a.a("ecom_shop_settings_opt_config", ECSettingsConfig.class, r110, false);     // Catch: Throwable -> L11
        if (r104 != null) goto L17;
        Intrinsics.throwNpe();     // Catch: Throwable -> L11
    L17:
        f43645b = (ECSettingsConfig) r104;
    L11:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Object r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r106) == true) goto L16;
        r110 = r106;
    L16:
        r104 = r110;
    L19:
        return f43645b;
    }
}
