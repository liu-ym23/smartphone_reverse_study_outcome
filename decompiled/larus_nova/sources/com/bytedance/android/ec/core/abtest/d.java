package com.bytedance.android.ec.core.abtest;

import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.hybrid.hostapi.IECHybridKevaService;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.dataplatform.config.SettingPanel;
import com.bytedance.services.apm.api.EnsureManager;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f43639a = null;

    public d() {
    }

    static {
        f43639a = new d();
    }

    @SettingPanel("SaaS余额兑券")
    public static final int A() {
        int r100 = j.f43647a;
        Object r101 = 0;
        int r102 = com.bytedance.android.ec.base.settings.b.f42814a;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L166
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L166
        SDKSettingsCacheManager r104 = SDKSettingsCacheManager.f42812e;     // Catch: Throwable -> L166
        Object r105 = null;
        r104.getClass();     // Catch: Throwable -> L56
        Object r106 = SDKSettingsCacheManager.f42809b.get("iesec_saas_balance_exchange");     // Catch: Throwable -> L56
        if (r106 != null) goto L11;
    L53:
        Object r107 = null;
    L54:
        Object r108 = Result.m9449constructorimpl(r107);     // Catch: Throwable -> L56
    L58:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);     // Catch: Throwable -> L166
        if (r109 == null) goto L62;
        EnsureManager.ensureNotReachHere(r109);     // Catch: Throwable -> L166
    L62:
        if (Result.m9455isFailureimpl(r108) == false) goto L65;
        r108 = null;
    L65:
        if ((r108 instanceof Integer) == true) goto L67;
        r108 = null;
    L67:
        Object r110 = (Integer) r108;     // Catch: Throwable -> L166
        if (r110 != null) goto L74;
        r104.getClass();     // Catch: Throwable -> L166
        Object r111 = SDKSettingsCacheManager.f42808a.get("iesec_saas_balance_exchange");     // Catch: Throwable -> L166
        if ((r111 instanceof Integer) == true) goto L73;
        r111 = null;
    L73:
        r110 = (Integer) r111;     // Catch: Throwable -> L166
    L74:
        if (r110 != null) goto L176;
        int r112 = com.bytedance.android.ec.base.settings.g.f42821a;     // Catch: Throwable -> L166
    L153:
        th = move-exception;
        Result.Companion r113 = Result.Companion;     // Catch: Throwable -> L166
        Object r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
    L156:
        if (Result.m9452exceptionOrNullimpl(r114) != null) goto L183;
    L163:
        r110 = r114;
    L164:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L166
        SDKSettingsCacheManager.e("iesec_saas_balance_exchange", r110);     // Catch: Throwable -> L166
        goto L176
    L183:
        r114 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("iesec_saas_balance_exchange", Integer.class, r101);     // Catch: Throwable -> L160
    L161:
        if (r114 != null) goto L163;
        r110 = r101;
    L160:
        r114 = r101;
        goto L161
    L189:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L127
        Object r115 = SDKSettingsCacheManager.f42809b.get("iesec_saas_balance_exchange");     // Catch: Throwable -> L127
        if (r115 != null) goto L82;
    L124:
        Object r116 = null;
    L125:
        Object r117 = Result.m9449constructorimpl(r116);     // Catch: Throwable -> L127
    L129:
        Throwable r118 = Result.m9452exceptionOrNullimpl(r117);     // Catch: Throwable -> L153
        if (r118 == null) goto L133;
        EnsureManager.ensureNotReachHere(r118);     // Catch: Throwable -> L153
    L133:
        if (Result.m9455isFailureimpl(r117) == false) goto L136;
        r117 = null;
    L136:
        if ((r117 instanceof Integer) == true) goto L138;
        r117 = null;
    L138:
        Integer r119 = (Integer) r117;     // Catch: Throwable -> L153
        if (r119 == null) goto L141;
        r110 = r119;
        goto L164
    L141:
        jj4.b r120 = jj4.b.f499326b;     // Catch: Throwable -> L153
        Object r121 = jj4.a.a("iesec_saas_balance_exchange", Integer.class, r101, false);     // Catch: Throwable -> L153
        if (r121 != null) goto L145;
        Intrinsics.throwNpe();     // Catch: Throwable -> L153
    L145:
        if ((r121 instanceof Integer) == false) goto L148;
        r105 = r121;
    L148:
        Object r122 = (Integer) r105;     // Catch: Throwable -> L153
        if (r122 != null) goto L151;
        r122 = r101;
    L151:
        r114 = Result.m9449constructorimpl(r122);     // Catch: Throwable -> L153
    L82:
        if ((r115 instanceof Integer) == true) goto L84;
        Object r123 = null;
    L85:
        r116 = (Integer) r123;     // Catch: Throwable -> L127
        if (r116 != null) goto L125;
        if ((r115 instanceof Number) == false) goto L112;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r124 = Float.valueOf(((Number) r115).floatValue());     // Catch: Throwable -> L127
        if ((r124 instanceof Integer) == true) goto L95;
        r124 = null;
    L95:
        r116 = (Integer) r124;     // Catch: Throwable -> L127
        goto L125
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r125 = Double.valueOf(((Number) r115).doubleValue());     // Catch: Throwable -> L127
        if ((r125 instanceof Integer) == true) goto L101;
        r125 = null;
    L101:
        r116 = (Integer) r125;     // Catch: Throwable -> L127
        goto L125
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L106;
        r116 = Integer.valueOf(((Number) r115).intValue());     // Catch: Throwable -> L127
        goto L125
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L112;
        Long r126 = Long.valueOf(((Number) r115).longValue());     // Catch: Throwable -> L127
        if ((r126 instanceof Integer) == true) goto L110;
        r126 = null;
    L110:
        r116 = (Integer) r126;     // Catch: Throwable -> L127
    L112:
        if ((r115 instanceof JSONObject) == false) goto L114;
    L181:
        Object r127 = SDKSettingsCacheManager.a().fromJson(r115.toString(), Integer.class);     // Catch: Throwable -> L120
        if ((r127 instanceof Integer) == true) goto L118;
        r127 = null;
    L118:
        Object r128 = Result.m9449constructorimpl((Integer) r127);     // Catch: Throwable -> L120
    L122:
        r116 = r128;
        if (Result.m9455isFailureimpl(r116) == false) goto L125;
    L120:
        th = move-exception;
        Result.Companion r129 = Result.Companion;     // Catch: Throwable -> L127
        r128 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L127
        goto L122
    L114:
        if ((r115 instanceof JSONArray) == false) goto L124;
    L84:
        r123 = r115;
    L127:
        th = move-exception;
        Result.Companion r130 = Result.Companion;     // Catch: Throwable -> L153
        r117 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L153
    L176:
        return ((Number) r110).intValue();
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
    L179:
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
        Result.Companion r138 = Result.Companion;     // Catch: Throwable -> L166
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
    L166:
        th = move-exception;
        Result.Companion r139 = Result.Companion;
        Object r140 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r141 = Result.m9452exceptionOrNullimpl(r140);
        if (r141 == null) goto L171;
        EnsureManager.ensureNotReachHere(r141);
    L171:
        if (Result.m9455isFailureimpl(r140) == true) goto L174;
        r101 = r140;
    L174:
        r110 = r101;
        goto L176
    }

    @SettingPanel("SaaS支持讲解回放")
    public static final int B() {
        int r100 = j.f43647a;
        Object r101 = 0;
        int r102 = com.bytedance.android.ec.base.settings.b.f42814a;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L166
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L166
        SDKSettingsCacheManager r104 = SDKSettingsCacheManager.f42812e;     // Catch: Throwable -> L166
        Object r105 = null;
        r104.getClass();     // Catch: Throwable -> L56
        Object r106 = SDKSettingsCacheManager.f42809b.get("iesec_saas_live_replay");     // Catch: Throwable -> L56
        if (r106 != null) goto L11;
    L53:
        Object r107 = null;
    L54:
        Object r108 = Result.m9449constructorimpl(r107);     // Catch: Throwable -> L56
    L58:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);     // Catch: Throwable -> L166
        if (r109 == null) goto L62;
        EnsureManager.ensureNotReachHere(r109);     // Catch: Throwable -> L166
    L62:
        if (Result.m9455isFailureimpl(r108) == false) goto L65;
        r108 = null;
    L65:
        if ((r108 instanceof Integer) == true) goto L67;
        r108 = null;
    L67:
        Object r110 = (Integer) r108;     // Catch: Throwable -> L166
        if (r110 != null) goto L74;
        r104.getClass();     // Catch: Throwable -> L166
        Object r111 = SDKSettingsCacheManager.f42808a.get("iesec_saas_live_replay");     // Catch: Throwable -> L166
        if ((r111 instanceof Integer) == true) goto L73;
        r111 = null;
    L73:
        r110 = (Integer) r111;     // Catch: Throwable -> L166
    L74:
        if (r110 != null) goto L176;
        int r112 = com.bytedance.android.ec.base.settings.g.f42821a;     // Catch: Throwable -> L166
    L153:
        th = move-exception;
        Result.Companion r113 = Result.Companion;     // Catch: Throwable -> L166
        Object r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
    L156:
        if (Result.m9452exceptionOrNullimpl(r114) != null) goto L183;
    L163:
        r110 = r114;
    L164:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L166
        SDKSettingsCacheManager.e("iesec_saas_live_replay", r110);     // Catch: Throwable -> L166
        goto L176
    L183:
        r114 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("iesec_saas_live_replay", Integer.class, r101);     // Catch: Throwable -> L160
    L161:
        if (r114 != null) goto L163;
        r110 = r101;
    L160:
        r114 = r101;
        goto L161
    L189:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L127
        Object r115 = SDKSettingsCacheManager.f42809b.get("iesec_saas_live_replay");     // Catch: Throwable -> L127
        if (r115 != null) goto L82;
    L124:
        Object r116 = null;
    L125:
        Object r117 = Result.m9449constructorimpl(r116);     // Catch: Throwable -> L127
    L129:
        Throwable r118 = Result.m9452exceptionOrNullimpl(r117);     // Catch: Throwable -> L153
        if (r118 == null) goto L133;
        EnsureManager.ensureNotReachHere(r118);     // Catch: Throwable -> L153
    L133:
        if (Result.m9455isFailureimpl(r117) == false) goto L136;
        r117 = null;
    L136:
        if ((r117 instanceof Integer) == true) goto L138;
        r117 = null;
    L138:
        Integer r119 = (Integer) r117;     // Catch: Throwable -> L153
        if (r119 == null) goto L141;
        r110 = r119;
        goto L164
    L141:
        jj4.b r120 = jj4.b.f499326b;     // Catch: Throwable -> L153
        Object r121 = jj4.a.a("iesec_saas_live_replay", Integer.class, r101, false);     // Catch: Throwable -> L153
        if (r121 != null) goto L145;
        Intrinsics.throwNpe();     // Catch: Throwable -> L153
    L145:
        if ((r121 instanceof Integer) == false) goto L148;
        r105 = r121;
    L148:
        Object r122 = (Integer) r105;     // Catch: Throwable -> L153
        if (r122 != null) goto L151;
        r122 = r101;
    L151:
        r114 = Result.m9449constructorimpl(r122);     // Catch: Throwable -> L153
    L82:
        if ((r115 instanceof Integer) == true) goto L84;
        Object r123 = null;
    L85:
        r116 = (Integer) r123;     // Catch: Throwable -> L127
        if (r116 != null) goto L125;
        if ((r115 instanceof Number) == false) goto L112;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r124 = Float.valueOf(((Number) r115).floatValue());     // Catch: Throwable -> L127
        if ((r124 instanceof Integer) == true) goto L95;
        r124 = null;
    L95:
        r116 = (Integer) r124;     // Catch: Throwable -> L127
        goto L125
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r125 = Double.valueOf(((Number) r115).doubleValue());     // Catch: Throwable -> L127
        if ((r125 instanceof Integer) == true) goto L101;
        r125 = null;
    L101:
        r116 = (Integer) r125;     // Catch: Throwable -> L127
        goto L125
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L106;
        r116 = Integer.valueOf(((Number) r115).intValue());     // Catch: Throwable -> L127
        goto L125
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L112;
        Long r126 = Long.valueOf(((Number) r115).longValue());     // Catch: Throwable -> L127
        if ((r126 instanceof Integer) == true) goto L110;
        r126 = null;
    L110:
        r116 = (Integer) r126;     // Catch: Throwable -> L127
    L112:
        if ((r115 instanceof JSONObject) == false) goto L114;
    L181:
        Object r127 = SDKSettingsCacheManager.a().fromJson(r115.toString(), Integer.class);     // Catch: Throwable -> L120
        if ((r127 instanceof Integer) == true) goto L118;
        r127 = null;
    L118:
        Object r128 = Result.m9449constructorimpl((Integer) r127);     // Catch: Throwable -> L120
    L122:
        r116 = r128;
        if (Result.m9455isFailureimpl(r116) == false) goto L125;
    L120:
        th = move-exception;
        Result.Companion r129 = Result.Companion;     // Catch: Throwable -> L127
        r128 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L127
        goto L122
    L114:
        if ((r115 instanceof JSONArray) == false) goto L124;
    L84:
        r123 = r115;
    L127:
        th = move-exception;
        Result.Companion r130 = Result.Companion;     // Catch: Throwable -> L153
        r117 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L153
    L176:
        return ((Number) r110).intValue();
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
    L179:
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
        Result.Companion r138 = Result.Companion;     // Catch: Throwable -> L166
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
    L166:
        th = move-exception;
        Result.Companion r139 = Result.Companion;
        Object r140 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r141 = Result.m9452exceptionOrNullimpl(r140);
        if (r141 == null) goto L171;
        EnsureManager.ensureNotReachHere(r141);
    L171:
        if (Result.m9455isFailureimpl(r140) == true) goto L174;
        r101 = r140;
    L174:
        r110 = r101;
        goto L176
    }

    @SettingPanel("SaaS店铺推荐")
    public static final int C() {
        int r100 = j.f43647a;
        Object r101 = 0;
        int r102 = com.bytedance.android.ec.base.settings.b.f42814a;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L166
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L166
        SDKSettingsCacheManager r104 = SDKSettingsCacheManager.f42812e;     // Catch: Throwable -> L166
        Object r105 = null;
        r104.getClass();     // Catch: Throwable -> L56
        Object r106 = SDKSettingsCacheManager.f42809b.get("iesec_saas_shop_recommend");     // Catch: Throwable -> L56
        if (r106 != null) goto L11;
    L53:
        Object r107 = null;
    L54:
        Object r108 = Result.m9449constructorimpl(r107);     // Catch: Throwable -> L56
    L58:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);     // Catch: Throwable -> L166
        if (r109 == null) goto L62;
        EnsureManager.ensureNotReachHere(r109);     // Catch: Throwable -> L166
    L62:
        if (Result.m9455isFailureimpl(r108) == false) goto L65;
        r108 = null;
    L65:
        if ((r108 instanceof Integer) == true) goto L67;
        r108 = null;
    L67:
        Object r110 = (Integer) r108;     // Catch: Throwable -> L166
        if (r110 != null) goto L74;
        r104.getClass();     // Catch: Throwable -> L166
        Object r111 = SDKSettingsCacheManager.f42808a.get("iesec_saas_shop_recommend");     // Catch: Throwable -> L166
        if ((r111 instanceof Integer) == true) goto L73;
        r111 = null;
    L73:
        r110 = (Integer) r111;     // Catch: Throwable -> L166
    L74:
        if (r110 != null) goto L176;
        int r112 = com.bytedance.android.ec.base.settings.g.f42821a;     // Catch: Throwable -> L166
    L153:
        th = move-exception;
        Result.Companion r113 = Result.Companion;     // Catch: Throwable -> L166
        Object r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
    L156:
        if (Result.m9452exceptionOrNullimpl(r114) != null) goto L183;
    L163:
        r110 = r114;
    L164:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L166
        SDKSettingsCacheManager.e("iesec_saas_shop_recommend", r110);     // Catch: Throwable -> L166
        goto L176
    L183:
        r114 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("iesec_saas_shop_recommend", Integer.class, r101);     // Catch: Throwable -> L160
    L161:
        if (r114 != null) goto L163;
        r110 = r101;
    L160:
        r114 = r101;
        goto L161
    L189:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L127
        Object r115 = SDKSettingsCacheManager.f42809b.get("iesec_saas_shop_recommend");     // Catch: Throwable -> L127
        if (r115 != null) goto L82;
    L124:
        Object r116 = null;
    L125:
        Object r117 = Result.m9449constructorimpl(r116);     // Catch: Throwable -> L127
    L129:
        Throwable r118 = Result.m9452exceptionOrNullimpl(r117);     // Catch: Throwable -> L153
        if (r118 == null) goto L133;
        EnsureManager.ensureNotReachHere(r118);     // Catch: Throwable -> L153
    L133:
        if (Result.m9455isFailureimpl(r117) == false) goto L136;
        r117 = null;
    L136:
        if ((r117 instanceof Integer) == true) goto L138;
        r117 = null;
    L138:
        Integer r119 = (Integer) r117;     // Catch: Throwable -> L153
        if (r119 == null) goto L141;
        r110 = r119;
        goto L164
    L141:
        jj4.b r120 = jj4.b.f499326b;     // Catch: Throwable -> L153
        Object r121 = jj4.a.a("iesec_saas_shop_recommend", Integer.class, r101, false);     // Catch: Throwable -> L153
        if (r121 != null) goto L145;
        Intrinsics.throwNpe();     // Catch: Throwable -> L153
    L145:
        if ((r121 instanceof Integer) == false) goto L148;
        r105 = r121;
    L148:
        Object r122 = (Integer) r105;     // Catch: Throwable -> L153
        if (r122 != null) goto L151;
        r122 = r101;
    L151:
        r114 = Result.m9449constructorimpl(r122);     // Catch: Throwable -> L153
    L82:
        if ((r115 instanceof Integer) == true) goto L84;
        Object r123 = null;
    L85:
        r116 = (Integer) r123;     // Catch: Throwable -> L127
        if (r116 != null) goto L125;
        if ((r115 instanceof Number) == false) goto L112;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r124 = Float.valueOf(((Number) r115).floatValue());     // Catch: Throwable -> L127
        if ((r124 instanceof Integer) == true) goto L95;
        r124 = null;
    L95:
        r116 = (Integer) r124;     // Catch: Throwable -> L127
        goto L125
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r125 = Double.valueOf(((Number) r115).doubleValue());     // Catch: Throwable -> L127
        if ((r125 instanceof Integer) == true) goto L101;
        r125 = null;
    L101:
        r116 = (Integer) r125;     // Catch: Throwable -> L127
        goto L125
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L106;
        r116 = Integer.valueOf(((Number) r115).intValue());     // Catch: Throwable -> L127
        goto L125
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L112;
        Long r126 = Long.valueOf(((Number) r115).longValue());     // Catch: Throwable -> L127
        if ((r126 instanceof Integer) == true) goto L110;
        r126 = null;
    L110:
        r116 = (Integer) r126;     // Catch: Throwable -> L127
    L112:
        if ((r115 instanceof JSONObject) == false) goto L114;
    L181:
        Object r127 = SDKSettingsCacheManager.a().fromJson(r115.toString(), Integer.class);     // Catch: Throwable -> L120
        if ((r127 instanceof Integer) == true) goto L118;
        r127 = null;
    L118:
        Object r128 = Result.m9449constructorimpl((Integer) r127);     // Catch: Throwable -> L120
    L122:
        r116 = r128;
        if (Result.m9455isFailureimpl(r116) == false) goto L125;
    L120:
        th = move-exception;
        Result.Companion r129 = Result.Companion;     // Catch: Throwable -> L127
        r128 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L127
        goto L122
    L114:
        if ((r115 instanceof JSONArray) == false) goto L124;
    L84:
        r123 = r115;
    L127:
        th = move-exception;
        Result.Companion r130 = Result.Companion;     // Catch: Throwable -> L153
        r117 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L153
    L176:
        return ((Number) r110).intValue();
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
    L179:
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
        Result.Companion r138 = Result.Companion;     // Catch: Throwable -> L166
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
    L166:
        th = move-exception;
        Result.Companion r139 = Result.Companion;
        Object r140 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r141 = Result.m9452exceptionOrNullimpl(r140);
        if (r141 == null) goto L171;
        EnsureManager.ensureNotReachHere(r141);
    L171:
        if (Result.m9455isFailureimpl(r140) == true) goto L174;
        r101 = r140;
    L174:
        r110 = r101;
        goto L176
    }

    @SettingPanel("sku面板选择规格时商详刷新优化-已固化")
    public static final boolean D() {
        jj4.b r100 = jj4.b.f499326b;
        int r101 = e.f43640a;
        Object r102 = jj4.a.a("detail_sku_refresh_opt", Boolean.class, e.a(Boolean.TRUE, Boolean.FALSE), false);
        if (r102 != null) goto L6;
        Intrinsics.throwNpe();
    L6:
        return ((Boolean) r102).booleanValue();
    }

    @SettingPanel("SKU数量加减 最小值支持为0")
    public static final boolean E() {
        jj4.b r100 = jj4.b.f499326b;
        int r101 = e.f43640a;
        Object r102 = jj4.a.a("iesec_sku_count_lower_to_zero", Boolean.class, e.a(Boolean.TRUE, Boolean.FALSE), false);
        if (r102 != null) goto L6;
        Intrinsics.throwNpe();
    L6:
        return ((Boolean) r102).booleanValue();
    }

    @SettingPanel("SKU面板改版一期实验")
    public static final int F() {
        jj4.b r100 = jj4.b.f499326b;
        int r101 = e.f43640a;
        Object r102 = jj4.a.a("iesec_sku_optimize", Integer.class, e.a(5, 0), false);
        if (r102 != null) goto L6;
        Intrinsics.throwNpe();
    L6:
        return ((Number) r102).intValue();
    }

    @SettingPanel("西头直播间讲解卡展示时长优化开关")
    public static final boolean G() {
        jj4.b r100 = jj4.b.f499326b;
        Object r101 = jj4.a.a("iesec_live_card_duration_enable_ab", Integer.class, 0, false);
        if (r101 != null) goto L6;
        Intrinsics.throwNpe();
    L6:
        if (((Number) r101).intValue() != 1) goto L9;
        return true;
    L9:
        return false;
    }

    @SettingPanel("西头直播间讲解卡展示时长优化具体时长")
    public static final long H() {
        jj4.b r100 = jj4.b.f499326b;
        Object r101 = jj4.a.a("iesec_saas_live_card_show_duration", Long.class, 10000L, false);
        if (r101 != null) goto L5;
        Intrinsics.throwNpe();
    L5:
        long r102 = ((Number) r101).longValue();
        if (r102 >= 0) goto L9;
        return r102;
    L9:
        if (r102 < 10000) goto L12;
        return r102 / 1000;
    L12:
        return 10;
    }

    @SettingPanel("商详组件化")
    public static final boolean a() {
        Lazy r100 = ECAppInfoService.f48110a;
        Object r101 = null;
        if (ECAppInfoService.h() == false) goto L5;
    L186:
        int r102 = com.bytedance.android.ec.base.settings.a.f42813a;
        Object r103 = Boolean.FALSE;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L349
        Object r105 = com.bytedance.android.ec.base.settings.d.f42818c.get("ec_pdp_refactor_v2");     // Catch: Throwable -> L240
        if (r105 != null) goto L192;
    L237:
        Object r106 = null;
    L238:
        Object r107 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L240
    L242:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);     // Catch: Throwable -> L349
        if (r108 == null) goto L246;
        EnsureManager.ensureNotReachHere(r108);     // Catch: Throwable -> L349
    L246:
        if (Result.m9455isFailureimpl(r107) == false) goto L249;
        r107 = null;
    L249:
        if ((r107 instanceof Boolean) == true) goto L251;
        r107 = null;
    L251:
        Object r109 = (Boolean) r107;     // Catch: Throwable -> L349
        if (r109 != null) goto L258;
        Object r110 = com.bytedance.android.ec.base.settings.d.f42816a.get("ec_pdp_refactor_v2");     // Catch: Throwable -> L349
        if ((r110 instanceof Boolean) == true) goto L257;
        r110 = null;
    L257:
        r109 = (Boolean) r110;     // Catch: Throwable -> L349
    L258:
        if (r109 != null) goto L359;
        int r111 = com.bytedance.android.ec.base.settings.c.f42815a;     // Catch: Throwable -> L349
        Object r112 = com.bytedance.android.ec.base.settings.d.f42818c.get("ec_pdp_refactor_v2");     // Catch: Throwable -> L313
        if (r112 != null) goto L265;
    L310:
        Object r113 = null;
    L311:
        Object r114 = Result.m9449constructorimpl(r113);     // Catch: Throwable -> L313
    L315:
        Throwable r115 = Result.m9452exceptionOrNullimpl(r114);     // Catch: Throwable -> L339
        if (r115 == null) goto L319;
        EnsureManager.ensureNotReachHere(r115);     // Catch: Throwable -> L339
    L319:
        if (Result.m9455isFailureimpl(r114) == false) goto L322;
        r114 = null;
    L322:
        if ((r114 instanceof Boolean) == true) goto L324;
        r114 = null;
    L324:
        r109 = (Boolean) r114;     // Catch: Throwable -> L339
        if (r109 != null) goto L347;
        IHybridHostService r116 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L339
        if (r116 == null) goto L330;
        Object r117 = r116.getHostABValue("ec_pdp_refactor_v2", r103);     // Catch: Throwable -> L339
    L331:
        if (r117 != null) goto L333;
    L345:
        r109 = r103;
        goto L347
    L333:
        if ((r117 instanceof Boolean) == false) goto L336;
        r101 = r117;
    L336:
        Object r118 = (Boolean) r101;     // Catch: Throwable -> L339
        if (r118 == null) goto L345;
    L346:
        r109 = r118;
        goto L347
    L330:
        r117 = null;
    L347:
        com.bytedance.android.ec.base.settings.d.d("ec_pdp_refactor_v2", r109);     // Catch: Throwable -> L349
        goto L359
    L265:
        if ((r112 instanceof Boolean) == true) goto L267;
        Object r119 = null;
    L268:
        r113 = (Boolean) r119;     // Catch: Throwable -> L313
        if (r113 != null) goto L311;
        if ((r112 instanceof Number) == false) goto L298;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L280;
        Float r120 = Float.valueOf(((Number) r112).floatValue());     // Catch: Throwable -> L313
        if ((r120 instanceof Boolean) == true) goto L278;
        r120 = null;
    L278:
        r113 = (Boolean) r120;     // Catch: Throwable -> L313
        goto L311
    L280:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L286;
        Double r121 = Double.valueOf(((Number) r112).doubleValue());     // Catch: Throwable -> L313
        if ((r121 instanceof Boolean) == true) goto L284;
        r121 = null;
    L284:
        r113 = (Boolean) r121;     // Catch: Throwable -> L313
        goto L311
    L286:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L292;
        Integer r122 = Integer.valueOf(((Number) r112).intValue());     // Catch: Throwable -> L313
        if ((r122 instanceof Boolean) == true) goto L290;
        r122 = null;
    L290:
        r113 = (Boolean) r122;     // Catch: Throwable -> L313
        goto L311
    L292:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L298;
        Long r123 = Long.valueOf(((Number) r112).longValue());     // Catch: Throwable -> L313
        if ((r123 instanceof Boolean) == true) goto L296;
        r123 = null;
    L296:
        r113 = (Boolean) r123;     // Catch: Throwable -> L313
    L298:
        if ((r112 instanceof JSONObject) == false) goto L300;
    L362:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L306
        Object r124 = SDKSettingsCacheManager.a().fromJson(r112.toString(), Boolean.class);     // Catch: Throwable -> L306
        if ((r124 instanceof Boolean) == true) goto L304;
        r124 = null;
    L304:
        Object r125 = Result.m9449constructorimpl((Boolean) r124);     // Catch: Throwable -> L306
    L308:
        r113 = r125;
        if (Result.m9455isFailureimpl(r113) == false) goto L311;
    L306:
        th = move-exception;
        Result.Companion r126 = Result.Companion;     // Catch: Throwable -> L313
        r125 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L313
        goto L308
    L300:
        if ((r112 instanceof JSONArray) == false) goto L310;
    L267:
        r119 = r112;
    L339:
        th = move-exception;
        Result.Companion r127 = Result.Companion;     // Catch: Throwable -> L349
        r118 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L349
        Throwable r128 = Result.m9452exceptionOrNullimpl(r118);     // Catch: Throwable -> L349
        if (r128 == null) goto L344;
        EnsureManager.ensureNotReachHere(r128);     // Catch: Throwable -> L349
    L344:
        if (Result.m9455isFailureimpl(r118) == false) goto L346;
    L313:
        th = move-exception;
        Result.Companion r129 = Result.Companion;     // Catch: Throwable -> L339
        r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L339
    L359:
        return ((Boolean) r109).booleanValue();
    L192:
        if ((r105 instanceof Boolean) == true) goto L194;
        Object r130 = null;
    L195:
        r106 = (Boolean) r130;     // Catch: Throwable -> L240
        if (r106 != null) goto L238;
        if ((r105 instanceof Number) == false) goto L225;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L207;
        Float r131 = Float.valueOf(((Number) r105).floatValue());     // Catch: Throwable -> L240
        if ((r131 instanceof Boolean) == true) goto L205;
        r131 = null;
    L205:
        r106 = (Boolean) r131;     // Catch: Throwable -> L240
        goto L238
    L207:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L213;
        Double r132 = Double.valueOf(((Number) r105).doubleValue());     // Catch: Throwable -> L240
        if ((r132 instanceof Boolean) == true) goto L211;
        r132 = null;
    L211:
        r106 = (Boolean) r132;     // Catch: Throwable -> L240
        goto L238
    L213:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L219;
        Integer r133 = Integer.valueOf(((Number) r105).intValue());     // Catch: Throwable -> L240
        if ((r133 instanceof Boolean) == true) goto L217;
        r133 = null;
    L217:
        r106 = (Boolean) r133;     // Catch: Throwable -> L240
        goto L238
    L219:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L225;
        Long r134 = Long.valueOf(((Number) r105).longValue());     // Catch: Throwable -> L240
        if ((r134 instanceof Boolean) == true) goto L223;
        r134 = null;
    L223:
        r106 = (Boolean) r134;     // Catch: Throwable -> L240
    L225:
        if ((r105 instanceof JSONObject) == false) goto L227;
    L380:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L233
        Object r135 = SDKSettingsCacheManager.a().fromJson(r105.toString(), Boolean.class);     // Catch: Throwable -> L233
        if ((r135 instanceof Boolean) == true) goto L231;
        r135 = null;
    L231:
        Object r136 = Result.m9449constructorimpl((Boolean) r135);     // Catch: Throwable -> L233
    L235:
        r106 = r136;
        if (Result.m9455isFailureimpl(r106) == false) goto L238;
    L233:
        th = move-exception;
        Result.Companion r137 = Result.Companion;     // Catch: Throwable -> L240
        r136 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L240
        goto L235
    L227:
        if ((r105 instanceof JSONArray) == false) goto L237;
    L194:
        r130 = r105;
    L240:
        th = move-exception;
        Result.Companion r138 = Result.Companion;     // Catch: Throwable -> L349
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L349
    L349:
        th = move-exception;
        Result.Companion r139 = Result.Companion;
        Object r140 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r141 = Result.m9452exceptionOrNullimpl(r140);
        if (r141 == null) goto L354;
        EnsureManager.ensureNotReachHere(r141);
    L354:
        if (Result.m9455isFailureimpl(r140) == true) goto L357;
        r103 = r140;
    L357:
        r109 = r103;
        goto L359
    L5:
        if (ECAppInfoService.k() == true) goto L186;
        if (ECAppInfoService.m() == true) goto L186;
        int r142 = com.bytedance.android.ec.base.settings.b.f42814a;
        Object r143 = Boolean.FALSE;
        Result.Companion r144 = Result.Companion;     // Catch: Throwable -> L176
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L176
        SDKSettingsCacheManager r145 = SDKSettingsCacheManager.f42812e;     // Catch: Throwable -> L176
        r145.getClass();     // Catch: Throwable -> L63
        Object r146 = SDKSettingsCacheManager.f42809b.get("ec_pdp_refactor_v2");     // Catch: Throwable -> L63
        if (r146 != null) goto L15;
    L60:
        Object r147 = null;
    L61:
        Object r148 = Result.m9449constructorimpl(r147);     // Catch: Throwable -> L63
    L65:
        Throwable r149 = Result.m9452exceptionOrNullimpl(r148);     // Catch: Throwable -> L176
        if (r149 == null) goto L69;
        EnsureManager.ensureNotReachHere(r149);     // Catch: Throwable -> L176
    L69:
        if (Result.m9455isFailureimpl(r148) == false) goto L72;
        r148 = null;
    L72:
        if ((r148 instanceof Boolean) == true) goto L74;
        r148 = null;
    L74:
        Object r150 = (Boolean) r148;     // Catch: Throwable -> L176
        if (r150 != null) goto L81;
        r145.getClass();     // Catch: Throwable -> L176
        Object r151 = SDKSettingsCacheManager.f42808a.get("ec_pdp_refactor_v2");     // Catch: Throwable -> L176
        if ((r151 instanceof Boolean) == true) goto L80;
        r151 = null;
    L80:
        r150 = (Boolean) r151;     // Catch: Throwable -> L176
    L81:
        if (r150 != null) goto L385;
        int r152 = com.bytedance.android.ec.base.settings.g.f42821a;     // Catch: Throwable -> L176
    L163:
        th = move-exception;
        Result.Companion r153 = Result.Companion;     // Catch: Throwable -> L176
        Object r154 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L176
    L165:
        Object r155 = r154;
        if (Result.m9452exceptionOrNullimpl(r155) != null) goto L366;
    L173:
        r150 = r155;
    L174:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L176
        SDKSettingsCacheManager.e("ec_pdp_refactor_v2", r150);     // Catch: Throwable -> L176
        goto L385
    L366:
        r155 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ec_pdp_refactor_v2", Boolean.class, r143);     // Catch: Throwable -> L170
    L171:
        if (r155 != null) goto L173;
        r150 = r143;
    L170:
        r155 = r143;
        goto L171
    L383:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L137
        Object r156 = SDKSettingsCacheManager.f42809b.get("ec_pdp_refactor_v2");     // Catch: Throwable -> L137
        if (r156 != null) goto L89;
    L134:
        Object r157 = null;
    L135:
        Object r158 = Result.m9449constructorimpl(r157);     // Catch: Throwable -> L137
    L139:
        Throwable r159 = Result.m9452exceptionOrNullimpl(r158);     // Catch: Throwable -> L163
        if (r159 == null) goto L143;
        EnsureManager.ensureNotReachHere(r159);     // Catch: Throwable -> L163
    L143:
        if (Result.m9455isFailureimpl(r158) == false) goto L146;
        r158 = null;
    L146:
        if ((r158 instanceof Boolean) == true) goto L148;
        r158 = null;
    L148:
        r155 = (Boolean) r158;     // Catch: Throwable -> L163
        if (r155 != null) goto L173;
        jj4.b r160 = jj4.b.f499326b;     // Catch: Throwable -> L163
        Object r161 = jj4.a.a("ec_pdp_refactor_v2", Boolean.class, r143, false);     // Catch: Throwable -> L163
        if (r161 != null) goto L155;
        Intrinsics.throwNpe();     // Catch: Throwable -> L163
    L155:
        if ((r161 instanceof Boolean) == false) goto L158;
        r101 = r161;
    L158:
        Object r162 = (Boolean) r101;     // Catch: Throwable -> L163
        if (r162 != null) goto L161;
        r162 = r143;
    L161:
        r154 = Result.m9449constructorimpl(r162);     // Catch: Throwable -> L163
    L89:
        if ((r156 instanceof Boolean) == true) goto L91;
        Object r163 = null;
    L92:
        r157 = (Boolean) r163;     // Catch: Throwable -> L137
        if (r157 != null) goto L135;
        if ((r156 instanceof Number) == false) goto L122;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L104;
        Float r164 = Float.valueOf(((Number) r156).floatValue());     // Catch: Throwable -> L137
        if ((r164 instanceof Boolean) == true) goto L102;
        r164 = null;
    L102:
        r157 = (Boolean) r164;     // Catch: Throwable -> L137
        goto L135
    L104:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L110;
        Double r165 = Double.valueOf(((Number) r156).doubleValue());     // Catch: Throwable -> L137
        if ((r165 instanceof Boolean) == true) goto L108;
        r165 = null;
    L108:
        r157 = (Boolean) r165;     // Catch: Throwable -> L137
        goto L135
    L110:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L116;
        Integer r166 = Integer.valueOf(((Number) r156).intValue());     // Catch: Throwable -> L137
        if ((r166 instanceof Boolean) == true) goto L114;
        r166 = null;
    L114:
        r157 = (Boolean) r166;     // Catch: Throwable -> L137
        goto L135
    L116:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L122;
        Long r167 = Long.valueOf(((Number) r156).longValue());     // Catch: Throwable -> L137
        if ((r167 instanceof Boolean) == true) goto L120;
        r167 = null;
    L120:
        r157 = (Boolean) r167;     // Catch: Throwable -> L137
    L122:
        if ((r156 instanceof JSONObject) == false) goto L124;
    L364:
        Object r168 = SDKSettingsCacheManager.a().fromJson(r156.toString(), Boolean.class);     // Catch: Throwable -> L130
        if ((r168 instanceof Boolean) == true) goto L128;
        r168 = null;
    L128:
        Object r169 = Result.m9449constructorimpl((Boolean) r168);     // Catch: Throwable -> L130
    L132:
        r157 = r169;
        if (Result.m9455isFailureimpl(r157) == false) goto L135;
    L130:
        th = move-exception;
        Result.Companion r170 = Result.Companion;     // Catch: Throwable -> L137
        r169 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L137
        goto L132
    L124:
        if ((r156 instanceof JSONArray) == false) goto L134;
    L91:
        r163 = r156;
    L137:
        th = move-exception;
        Result.Companion r171 = Result.Companion;     // Catch: Throwable -> L163
        r158 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
    L385:
        return ((Boolean) r150).booleanValue();
    L15:
        if ((r146 instanceof Boolean) == true) goto L17;
        Object r172 = null;
    L18:
        r147 = (Boolean) r172;     // Catch: Throwable -> L63
        if (r147 != null) goto L61;
        if ((r146 instanceof Number) == false) goto L48;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L30;
        Float r173 = Float.valueOf(((Number) r146).floatValue());     // Catch: Throwable -> L63
        if ((r173 instanceof Boolean) == true) goto L28;
        r173 = null;
    L28:
        r147 = (Boolean) r173;     // Catch: Throwable -> L63
        goto L61
    L30:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L36;
        Double r174 = Double.valueOf(((Number) r146).doubleValue());     // Catch: Throwable -> L63
        if ((r174 instanceof Boolean) == true) goto L34;
        r174 = null;
    L34:
        r147 = (Boolean) r174;     // Catch: Throwable -> L63
        goto L61
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L42;
        Integer r175 = Integer.valueOf(((Number) r146).intValue());     // Catch: Throwable -> L63
        if ((r175 instanceof Boolean) == true) goto L40;
        r175 = null;
    L40:
        r147 = (Boolean) r175;     // Catch: Throwable -> L63
        goto L61
    L42:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L48;
        Long r176 = Long.valueOf(((Number) r146).longValue());     // Catch: Throwable -> L63
        if ((r176 instanceof Boolean) == true) goto L46;
        r176 = null;
    L46:
        r147 = (Boolean) r176;     // Catch: Throwable -> L63
    L48:
        if ((r146 instanceof JSONObject) == false) goto L50;
    L378:
        Object r177 = SDKSettingsCacheManager.a().fromJson(r146.toString(), Boolean.class);     // Catch: Throwable -> L56
        if ((r177 instanceof Boolean) == true) goto L54;
        r177 = null;
    L54:
        Object r178 = Result.m9449constructorimpl((Boolean) r177);     // Catch: Throwable -> L56
    L58:
        r147 = r178;
        if (Result.m9455isFailureimpl(r147) == false) goto L61;
    L56:
        th = move-exception;
        Result.Companion r179 = Result.Companion;     // Catch: Throwable -> L63
        r178 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L63
        goto L58
    L50:
        if ((r146 instanceof JSONArray) == false) goto L60;
    L17:
        r172 = r146;
    L63:
        th = move-exception;
        Result.Companion r180 = Result.Companion;     // Catch: Throwable -> L176
        r148 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L176
    L176:
        th = move-exception;
        Result.Companion r181 = Result.Companion;
        Object r182 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r183 = Result.m9452exceptionOrNullimpl(r182);
        if (r183 == null) goto L181;
        EnsureManager.ensureNotReachHere(r183);
    L181:
        if (Result.m9455isFailureimpl(r182) == true) goto L184;
        r143 = r182;
    L184:
        r150 = r143;
        goto L385
    }

    @SettingPanel("事件链支持 action_map")
    public static final boolean b() {
        int r100 = com.bytedance.android.ec.base.settings.b.f42814a;
        Object r101 = Boolean.TRUE;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L172
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L172
        SDKSettingsCacheManager r103 = SDKSettingsCacheManager.f42812e;     // Catch: Throwable -> L172
        Object r104 = null;
        r103.getClass();     // Catch: Throwable -> L59
        Object r105 = SDKSettingsCacheManager.f42809b.get("ec_event_chain_supplement");     // Catch: Throwable -> L59
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
        Object r110 = SDKSettingsCacheManager.f42808a.get("ec_event_chain_supplement");     // Catch: Throwable -> L172
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
        SDKSettingsCacheManager.e("ec_event_chain_supplement", r109);     // Catch: Throwable -> L172
        goto L182
    L185:
        r113 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ec_event_chain_supplement", Boolean.class, r101);     // Catch: Throwable -> L166
    L167:
        if (r113 != null) goto L169;
        r109 = r101;
    L166:
        r113 = r101;
        goto L167
    L191:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L133
        Object r114 = SDKSettingsCacheManager.f42809b.get("ec_event_chain_supplement");     // Catch: Throwable -> L133
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
        Object r119 = jj4.a.a("ec_event_chain_supplement", Boolean.class, r101, false);     // Catch: Throwable -> L159
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

    @SettingPanel("商详容器滚动优化-已固化")
    public static final boolean c() {
        int r100 = j.f43647a;
        int r101 = e.f43640a;
        Object r102 = e.a(Boolean.TRUE, Boolean.FALSE);
        int r103 = com.bytedance.android.ec.base.settings.b.f42814a;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L172
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L172
        SDKSettingsCacheManager r105 = SDKSettingsCacheManager.f42812e;     // Catch: Throwable -> L172
        Object r106 = null;
        r105.getClass();     // Catch: Throwable -> L59
        Object r107 = SDKSettingsCacheManager.f42809b.get("ec_pdp_container_scroll_opt");     // Catch: Throwable -> L59
        if (r107 != null) goto L11;
    L56:
        Object r108 = null;
    L57:
        Object r109 = Result.m9449constructorimpl(r108);     // Catch: Throwable -> L59
    L61:
        Throwable r110 = Result.m9452exceptionOrNullimpl(r109);     // Catch: Throwable -> L172
        if (r110 == null) goto L65;
        EnsureManager.ensureNotReachHere(r110);     // Catch: Throwable -> L172
    L65:
        if (Result.m9455isFailureimpl(r109) == false) goto L68;
        r109 = null;
    L68:
        if ((r109 instanceof Boolean) == true) goto L70;
        r109 = null;
    L70:
        Object r111 = (Boolean) r109;     // Catch: Throwable -> L172
        if (r111 != null) goto L77;
        r105.getClass();     // Catch: Throwable -> L172
        Object r112 = SDKSettingsCacheManager.f42808a.get("ec_pdp_container_scroll_opt");     // Catch: Throwable -> L172
        if ((r112 instanceof Boolean) == true) goto L76;
        r112 = null;
    L76:
        r111 = (Boolean) r112;     // Catch: Throwable -> L172
    L77:
        if (r111 != null) goto L182;
        int r113 = com.bytedance.android.ec.base.settings.g.f42821a;     // Catch: Throwable -> L172
    L159:
        th = move-exception;
        Result.Companion r114 = Result.Companion;     // Catch: Throwable -> L172
        Object r115 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L172
    L162:
        if (Result.m9452exceptionOrNullimpl(r115) != null) goto L191;
    L169:
        r111 = r115;
    L170:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L172
        SDKSettingsCacheManager.e("ec_pdp_container_scroll_opt", r111);     // Catch: Throwable -> L172
        goto L182
    L191:
        r115 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ec_pdp_container_scroll_opt", Boolean.class, r102);     // Catch: Throwable -> L166
    L167:
        if (r115 != null) goto L169;
        r111 = r102;
    L166:
        r115 = r102;
        goto L167
    L183:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L133
        Object r116 = SDKSettingsCacheManager.f42809b.get("ec_pdp_container_scroll_opt");     // Catch: Throwable -> L133
        if (r116 != null) goto L85;
    L130:
        Object r117 = null;
    L131:
        Object r118 = Result.m9449constructorimpl(r117);     // Catch: Throwable -> L133
    L135:
        Throwable r119 = Result.m9452exceptionOrNullimpl(r118);     // Catch: Throwable -> L159
        if (r119 == null) goto L139;
        EnsureManager.ensureNotReachHere(r119);     // Catch: Throwable -> L159
    L139:
        if (Result.m9455isFailureimpl(r118) == false) goto L142;
        r118 = null;
    L142:
        if ((r118 instanceof Boolean) == true) goto L144;
        r118 = null;
    L144:
        r115 = (Boolean) r118;     // Catch: Throwable -> L159
        if (r115 != null) goto L169;
        jj4.b r120 = jj4.b.f499326b;     // Catch: Throwable -> L159
        Object r121 = jj4.a.a("ec_pdp_container_scroll_opt", Boolean.class, r102, false);     // Catch: Throwable -> L159
        if (r121 != null) goto L151;
        Intrinsics.throwNpe();     // Catch: Throwable -> L159
    L151:
        if ((r121 instanceof Boolean) == false) goto L154;
        r106 = r121;
    L154:
        Object r122 = (Boolean) r106;     // Catch: Throwable -> L159
        if (r122 != null) goto L157;
        r122 = r102;
    L157:
        r115 = Result.m9449constructorimpl(r122);     // Catch: Throwable -> L159
    L85:
        if ((r116 instanceof Boolean) == true) goto L87;
        Object r123 = null;
    L88:
        r117 = (Boolean) r123;     // Catch: Throwable -> L133
        if (r117 != null) goto L131;
        if ((r116 instanceof Number) == false) goto L118;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L100;
        Float r124 = Float.valueOf(((Number) r116).floatValue());     // Catch: Throwable -> L133
        if ((r124 instanceof Boolean) == true) goto L98;
        r124 = null;
    L98:
        r117 = (Boolean) r124;     // Catch: Throwable -> L133
        goto L131
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L106;
        Double r125 = Double.valueOf(((Number) r116).doubleValue());     // Catch: Throwable -> L133
        if ((r125 instanceof Boolean) == true) goto L104;
        r125 = null;
    L104:
        r117 = (Boolean) r125;     // Catch: Throwable -> L133
        goto L131
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L112;
        Integer r126 = Integer.valueOf(((Number) r116).intValue());     // Catch: Throwable -> L133
        if ((r126 instanceof Boolean) == true) goto L110;
        r126 = null;
    L110:
        r117 = (Boolean) r126;     // Catch: Throwable -> L133
        goto L131
    L112:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L118;
        Long r127 = Long.valueOf(((Number) r116).longValue());     // Catch: Throwable -> L133
        if ((r127 instanceof Boolean) == true) goto L116;
        r127 = null;
    L116:
        r117 = (Boolean) r127;     // Catch: Throwable -> L133
    L118:
        if ((r116 instanceof JSONObject) == false) goto L120;
    L189:
        Object r128 = SDKSettingsCacheManager.a().fromJson(r116.toString(), Boolean.class);     // Catch: Throwable -> L126
        if ((r128 instanceof Boolean) == true) goto L124;
        r128 = null;
    L124:
        Object r129 = Result.m9449constructorimpl((Boolean) r128);     // Catch: Throwable -> L126
    L128:
        r117 = r129;
        if (Result.m9455isFailureimpl(r117) == false) goto L131;
    L126:
        th = move-exception;
        Result.Companion r130 = Result.Companion;     // Catch: Throwable -> L133
        r129 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L133
        goto L128
    L120:
        if ((r116 instanceof JSONArray) == false) goto L130;
    L87:
        r123 = r116;
    L133:
        th = move-exception;
        Result.Companion r131 = Result.Companion;     // Catch: Throwable -> L159
        r118 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L159
    L182:
        return ((Boolean) r111).booleanValue();
    L11:
        if ((r107 instanceof Boolean) == true) goto L13;
        Object r132 = null;
    L14:
        r108 = (Boolean) r132;     // Catch: Throwable -> L59
        if (r108 != null) goto L57;
        if ((r107 instanceof Number) == false) goto L44;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r133 = Float.valueOf(((Number) r107).floatValue());     // Catch: Throwable -> L59
        if ((r133 instanceof Boolean) == true) goto L24;
        r133 = null;
    L24:
        r108 = (Boolean) r133;     // Catch: Throwable -> L59
        goto L57
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r134 = Double.valueOf(((Number) r107).doubleValue());     // Catch: Throwable -> L59
        if ((r134 instanceof Boolean) == true) goto L30;
        r134 = null;
    L30:
        r108 = (Boolean) r134;     // Catch: Throwable -> L59
        goto L57
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L38;
        Integer r135 = Integer.valueOf(((Number) r107).intValue());     // Catch: Throwable -> L59
        if ((r135 instanceof Boolean) == true) goto L36;
        r135 = null;
    L36:
        r108 = (Boolean) r135;     // Catch: Throwable -> L59
        goto L57
    L38:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L44;
        Long r136 = Long.valueOf(((Number) r107).longValue());     // Catch: Throwable -> L59
        if ((r136 instanceof Boolean) == true) goto L42;
        r136 = null;
    L42:
        r108 = (Boolean) r136;     // Catch: Throwable -> L59
    L44:
        if ((r107 instanceof JSONObject) == false) goto L46;
    L195:
        Object r137 = SDKSettingsCacheManager.a().fromJson(r107.toString(), Boolean.class);     // Catch: Throwable -> L52
        if ((r137 instanceof Boolean) == true) goto L50;
        r137 = null;
    L50:
        Object r138 = Result.m9449constructorimpl((Boolean) r137);     // Catch: Throwable -> L52
    L54:
        r108 = r138;
        if (Result.m9455isFailureimpl(r108) == false) goto L57;
    L52:
        th = move-exception;
        Result.Companion r139 = Result.Companion;     // Catch: Throwable -> L59
        r138 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L59
        goto L54
    L46:
        if ((r107 instanceof JSONArray) == false) goto L56;
    L13:
        r132 = r107;
    L59:
        th = move-exception;
        Result.Companion r140 = Result.Companion;     // Catch: Throwable -> L172
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L172
    L172:
        th = move-exception;
        Result.Companion r141 = Result.Companion;
        Object r142 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r143 = Result.m9452exceptionOrNullimpl(r142);
        if (r143 == null) goto L177;
        EnsureManager.ensureNotReachHere(r143);
    L177:
        if (Result.m9455isFailureimpl(r142) == true) goto L180;
        r102 = r142;
    L180:
        r111 = r102;
        goto L182
    }

    @SettingPanel("商详预加载开关")
    public static final int d() {
        int r100 = j.f43647a;
        Object r101 = 0;
        int r102 = com.bytedance.android.ec.base.settings.b.f42814a;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L166
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L166
        SDKSettingsCacheManager r104 = SDKSettingsCacheManager.f42812e;     // Catch: Throwable -> L166
        Object r105 = null;
        r104.getClass();     // Catch: Throwable -> L56
        Object r106 = SDKSettingsCacheManager.f42809b.get("iesec_pdp_enable_preload");     // Catch: Throwable -> L56
        if (r106 != null) goto L11;
    L53:
        Object r107 = null;
    L54:
        Object r108 = Result.m9449constructorimpl(r107);     // Catch: Throwable -> L56
    L58:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);     // Catch: Throwable -> L166
        if (r109 == null) goto L62;
        EnsureManager.ensureNotReachHere(r109);     // Catch: Throwable -> L166
    L62:
        if (Result.m9455isFailureimpl(r108) == false) goto L65;
        r108 = null;
    L65:
        if ((r108 instanceof Integer) == true) goto L67;
        r108 = null;
    L67:
        Object r110 = (Integer) r108;     // Catch: Throwable -> L166
        if (r110 != null) goto L74;
        r104.getClass();     // Catch: Throwable -> L166
        Object r111 = SDKSettingsCacheManager.f42808a.get("iesec_pdp_enable_preload");     // Catch: Throwable -> L166
        if ((r111 instanceof Integer) == true) goto L73;
        r111 = null;
    L73:
        r110 = (Integer) r111;     // Catch: Throwable -> L166
    L74:
        if (r110 != null) goto L176;
        int r112 = com.bytedance.android.ec.base.settings.g.f42821a;     // Catch: Throwable -> L166
    L153:
        th = move-exception;
        Result.Companion r113 = Result.Companion;     // Catch: Throwable -> L166
        Object r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
    L156:
        if (Result.m9452exceptionOrNullimpl(r114) != null) goto L183;
    L163:
        r110 = r114;
    L164:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L166
        SDKSettingsCacheManager.e("iesec_pdp_enable_preload", r110);     // Catch: Throwable -> L166
        goto L176
    L183:
        r114 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("iesec_pdp_enable_preload", Integer.class, r101);     // Catch: Throwable -> L160
    L161:
        if (r114 != null) goto L163;
        r110 = r101;
    L160:
        r114 = r101;
        goto L161
    L189:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L127
        Object r115 = SDKSettingsCacheManager.f42809b.get("iesec_pdp_enable_preload");     // Catch: Throwable -> L127
        if (r115 != null) goto L82;
    L124:
        Object r116 = null;
    L125:
        Object r117 = Result.m9449constructorimpl(r116);     // Catch: Throwable -> L127
    L129:
        Throwable r118 = Result.m9452exceptionOrNullimpl(r117);     // Catch: Throwable -> L153
        if (r118 == null) goto L133;
        EnsureManager.ensureNotReachHere(r118);     // Catch: Throwable -> L153
    L133:
        if (Result.m9455isFailureimpl(r117) == false) goto L136;
        r117 = null;
    L136:
        if ((r117 instanceof Integer) == true) goto L138;
        r117 = null;
    L138:
        Integer r119 = (Integer) r117;     // Catch: Throwable -> L153
        if (r119 == null) goto L141;
        r110 = r119;
        goto L164
    L141:
        jj4.b r120 = jj4.b.f499326b;     // Catch: Throwable -> L153
        Object r121 = jj4.a.a("iesec_pdp_enable_preload", Integer.class, r101, false);     // Catch: Throwable -> L153
        if (r121 != null) goto L145;
        Intrinsics.throwNpe();     // Catch: Throwable -> L153
    L145:
        if ((r121 instanceof Integer) == false) goto L148;
        r105 = r121;
    L148:
        Object r122 = (Integer) r105;     // Catch: Throwable -> L153
        if (r122 != null) goto L151;
        r122 = r101;
    L151:
        r114 = Result.m9449constructorimpl(r122);     // Catch: Throwable -> L153
    L82:
        if ((r115 instanceof Integer) == true) goto L84;
        Object r123 = null;
    L85:
        r116 = (Integer) r123;     // Catch: Throwable -> L127
        if (r116 != null) goto L125;
        if ((r115 instanceof Number) == false) goto L112;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r124 = Float.valueOf(((Number) r115).floatValue());     // Catch: Throwable -> L127
        if ((r124 instanceof Integer) == true) goto L95;
        r124 = null;
    L95:
        r116 = (Integer) r124;     // Catch: Throwable -> L127
        goto L125
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r125 = Double.valueOf(((Number) r115).doubleValue());     // Catch: Throwable -> L127
        if ((r125 instanceof Integer) == true) goto L101;
        r125 = null;
    L101:
        r116 = (Integer) r125;     // Catch: Throwable -> L127
        goto L125
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L106;
        r116 = Integer.valueOf(((Number) r115).intValue());     // Catch: Throwable -> L127
        goto L125
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L112;
        Long r126 = Long.valueOf(((Number) r115).longValue());     // Catch: Throwable -> L127
        if ((r126 instanceof Integer) == true) goto L110;
        r126 = null;
    L110:
        r116 = (Integer) r126;     // Catch: Throwable -> L127
    L112:
        if ((r115 instanceof JSONObject) == false) goto L114;
    L181:
        Object r127 = SDKSettingsCacheManager.a().fromJson(r115.toString(), Integer.class);     // Catch: Throwable -> L120
        if ((r127 instanceof Integer) == true) goto L118;
        r127 = null;
    L118:
        Object r128 = Result.m9449constructorimpl((Integer) r127);     // Catch: Throwable -> L120
    L122:
        r116 = r128;
        if (Result.m9455isFailureimpl(r116) == false) goto L125;
    L120:
        th = move-exception;
        Result.Companion r129 = Result.Companion;     // Catch: Throwable -> L127
        r128 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L127
        goto L122
    L114:
        if ((r115 instanceof JSONArray) == false) goto L124;
    L84:
        r123 = r115;
    L127:
        th = move-exception;
        Result.Companion r130 = Result.Companion;     // Catch: Throwable -> L153
        r117 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L153
    L176:
        return ((Number) r110).intValue();
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
    L179:
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
        Result.Companion r138 = Result.Companion;     // Catch: Throwable -> L166
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
    L166:
        th = move-exception;
        Result.Companion r139 = Result.Companion;
        Object r140 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r141 = Result.m9452exceptionOrNullimpl(r140);
        if (r141 == null) goto L171;
        EnsureManager.ensureNotReachHere(r141);
    L171:
        if (Result.m9455isFailureimpl(r140) == true) goto L174;
        r101 = r140;
    L174:
        r110 = r101;
        goto L176
    }

    @SettingPanel("商详预加载配置")
    public static final String e() {
        int r100 = j.f43647a;
        Object r101 = "";
        int r102 = com.bytedance.android.ec.base.settings.b.f42814a;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L172
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L172
        SDKSettingsCacheManager r104 = SDKSettingsCacheManager.f42812e;     // Catch: Throwable -> L172
        Object r105 = null;
        r104.getClass();     // Catch: Throwable -> L59
        Object r106 = SDKSettingsCacheManager.f42809b.get("iesec_pdp_preload_config");     // Catch: Throwable -> L59
        if (r106 != null) goto L11;
    L56:
        Object r107 = null;
    L57:
        Object r108 = Result.m9449constructorimpl(r107);     // Catch: Throwable -> L59
    L61:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);     // Catch: Throwable -> L172
        if (r109 == null) goto L65;
        EnsureManager.ensureNotReachHere(r109);     // Catch: Throwable -> L172
    L65:
        if (Result.m9455isFailureimpl(r108) == false) goto L68;
        r108 = null;
    L68:
        if ((r108 instanceof String) == true) goto L70;
        r108 = null;
    L70:
        Object r110 = (String) r108;     // Catch: Throwable -> L172
        if (r110 != null) goto L77;
        r104.getClass();     // Catch: Throwable -> L172
        Object r111 = SDKSettingsCacheManager.f42808a.get("iesec_pdp_preload_config");     // Catch: Throwable -> L172
        if ((r111 instanceof String) == true) goto L76;
        r111 = null;
    L76:
        r110 = (String) r111;     // Catch: Throwable -> L172
    L77:
        if (r110 != null) goto L182;
        int r112 = com.bytedance.android.ec.base.settings.g.f42821a;     // Catch: Throwable -> L172
    L159:
        th = move-exception;
        Result.Companion r113 = Result.Companion;     // Catch: Throwable -> L172
        Object r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L172
    L162:
        if (Result.m9452exceptionOrNullimpl(r114) != null) goto L185;
    L169:
        r110 = r114;
    L170:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L172
        SDKSettingsCacheManager.e("iesec_pdp_preload_config", r110);     // Catch: Throwable -> L172
        goto L182
    L185:
        r114 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("iesec_pdp_preload_config", String.class, "");     // Catch: Throwable -> L166
    L167:
        if (r114 != null) goto L169;
        r110 = "";
    L166:
        r114 = "";
        goto L167
    L191:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L133
        Object r115 = SDKSettingsCacheManager.f42809b.get("iesec_pdp_preload_config");     // Catch: Throwable -> L133
        if (r115 != null) goto L85;
    L130:
        Object r116 = null;
    L131:
        Object r117 = Result.m9449constructorimpl(r116);     // Catch: Throwable -> L133
    L135:
        Throwable r118 = Result.m9452exceptionOrNullimpl(r117);     // Catch: Throwable -> L159
        if (r118 == null) goto L139;
        EnsureManager.ensureNotReachHere(r118);     // Catch: Throwable -> L159
    L139:
        if (Result.m9455isFailureimpl(r117) == false) goto L142;
        r117 = null;
    L142:
        if ((r117 instanceof String) == true) goto L144;
        r117 = null;
    L144:
        r114 = (String) r117;     // Catch: Throwable -> L159
        if (r114 != null) goto L169;
        jj4.b r119 = jj4.b.f499326b;     // Catch: Throwable -> L159
        Object r120 = jj4.a.a("iesec_pdp_preload_config", String.class, "", false);     // Catch: Throwable -> L159
        if (r120 != null) goto L151;
        Intrinsics.throwNpe();     // Catch: Throwable -> L159
    L151:
        if ((r120 instanceof String) == false) goto L154;
        r105 = r120;
    L154:
        String r121 = (String) r105;     // Catch: Throwable -> L159
        if (r121 != null) goto L157;
        r121 = "";
    L157:
        r114 = Result.m9449constructorimpl(r121);     // Catch: Throwable -> L159
    L85:
        if ((r115 instanceof String) == true) goto L87;
        Object r122 = null;
    L88:
        r116 = (String) r122;     // Catch: Throwable -> L133
        if (r116 != null) goto L131;
        if ((r115 instanceof Number) == false) goto L118;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L100;
        Float r123 = Float.valueOf(((Number) r115).floatValue());     // Catch: Throwable -> L133
        if ((r123 instanceof String) == true) goto L98;
        r123 = null;
    L98:
        r116 = (String) r123;     // Catch: Throwable -> L133
        goto L131
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L106;
        Double r124 = Double.valueOf(((Number) r115).doubleValue());     // Catch: Throwable -> L133
        if ((r124 instanceof String) == true) goto L104;
        r124 = null;
    L104:
        r116 = (String) r124;     // Catch: Throwable -> L133
        goto L131
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L112;
        Integer r125 = Integer.valueOf(((Number) r115).intValue());     // Catch: Throwable -> L133
        if ((r125 instanceof String) == true) goto L110;
        r125 = null;
    L110:
        r116 = (String) r125;     // Catch: Throwable -> L133
        goto L131
    L112:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L118;
        Long r126 = Long.valueOf(((Number) r115).longValue());     // Catch: Throwable -> L133
        if ((r126 instanceof String) == true) goto L116;
        r126 = null;
    L116:
        r116 = (String) r126;     // Catch: Throwable -> L133
    L118:
        if ((r115 instanceof JSONObject) == false) goto L120;
    L183:
        Object r127 = SDKSettingsCacheManager.a().fromJson(r115.toString(), String.class);     // Catch: Throwable -> L126
        if ((r127 instanceof String) == true) goto L124;
        r127 = null;
    L124:
        Object r128 = Result.m9449constructorimpl((String) r127);     // Catch: Throwable -> L126
    L128:
        r116 = r128;
        if (Result.m9455isFailureimpl(r116) == false) goto L131;
    L126:
        th = move-exception;
        Result.Companion r129 = Result.Companion;     // Catch: Throwable -> L133
        r128 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L133
        goto L128
    L120:
        if ((r115 instanceof JSONArray) == false) goto L130;
    L87:
        r122 = r115;
    L133:
        th = move-exception;
        Result.Companion r130 = Result.Companion;     // Catch: Throwable -> L159
        r117 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L159
    L182:
        return (String) r110;
    L11:
        if ((r106 instanceof String) == true) goto L13;
        Object r131 = null;
    L14:
        r107 = (String) r131;     // Catch: Throwable -> L59
        if (r107 != null) goto L57;
        if ((r106 instanceof Number) == false) goto L44;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r132 = Float.valueOf(((Number) r106).floatValue());     // Catch: Throwable -> L59
        if ((r132 instanceof String) == true) goto L24;
        r132 = null;
    L24:
        r107 = (String) r132;     // Catch: Throwable -> L59
        goto L57
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r133 = Double.valueOf(((Number) r106).doubleValue());     // Catch: Throwable -> L59
        if ((r133 instanceof String) == true) goto L30;
        r133 = null;
    L30:
        r107 = (String) r133;     // Catch: Throwable -> L59
        goto L57
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L38;
        Integer r134 = Integer.valueOf(((Number) r106).intValue());     // Catch: Throwable -> L59
        if ((r134 instanceof String) == true) goto L36;
        r134 = null;
    L36:
        r107 = (String) r134;     // Catch: Throwable -> L59
        goto L57
    L38:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L44;
        Long r135 = Long.valueOf(((Number) r106).longValue());     // Catch: Throwable -> L59
        if ((r135 instanceof String) == true) goto L42;
        r135 = null;
    L42:
        r107 = (String) r135;     // Catch: Throwable -> L59
    L44:
        if ((r106 instanceof JSONObject) == false) goto L46;
    L189:
        Object r136 = SDKSettingsCacheManager.a().fromJson(r106.toString(), String.class);     // Catch: Throwable -> L52
        if ((r136 instanceof String) == true) goto L50;
        r136 = null;
    L50:
        Object r137 = Result.m9449constructorimpl((String) r136);     // Catch: Throwable -> L52
    L54:
        r107 = r137;
        if (Result.m9455isFailureimpl(r107) == false) goto L57;
    L52:
        th = move-exception;
        Result.Companion r138 = Result.Companion;     // Catch: Throwable -> L59
        r137 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L59
        goto L54
    L46:
        if ((r106 instanceof JSONArray) == false) goto L56;
    L13:
        r131 = r106;
    L59:
        th = move-exception;
        Result.Companion r139 = Result.Companion;     // Catch: Throwable -> L172
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L172
    L172:
        th = move-exception;
        Result.Companion r140 = Result.Companion;
        Object r141 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r142 = Result.m9452exceptionOrNullimpl(r141);
        if (r142 == null) goto L177;
        EnsureManager.ensureNotReachHere(r142);
    L177:
        if (Result.m9455isFailureimpl(r141) == true) goto L180;
        r101 = r141;
    L180:
        r110 = r101;
        goto L182
    }

    @SettingPanel("商详加载失败重试-已固化")
    public static final boolean f() {
        int r100 = j.f43647a;
        int r101 = e.f43640a;
        Object r102 = e.a(Boolean.TRUE, Boolean.FALSE);
        int r103 = com.bytedance.android.ec.base.settings.b.f42814a;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L172
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L172
        SDKSettingsCacheManager r105 = SDKSettingsCacheManager.f42812e;     // Catch: Throwable -> L172
        Object r106 = null;
        r105.getClass();     // Catch: Throwable -> L59
        Object r107 = SDKSettingsCacheManager.f42809b.get("ec_pdp_retry");     // Catch: Throwable -> L59
        if (r107 != null) goto L11;
    L56:
        Object r108 = null;
    L57:
        Object r109 = Result.m9449constructorimpl(r108);     // Catch: Throwable -> L59
    L61:
        Throwable r110 = Result.m9452exceptionOrNullimpl(r109);     // Catch: Throwable -> L172
        if (r110 == null) goto L65;
        EnsureManager.ensureNotReachHere(r110);     // Catch: Throwable -> L172
    L65:
        if (Result.m9455isFailureimpl(r109) == false) goto L68;
        r109 = null;
    L68:
        if ((r109 instanceof Boolean) == true) goto L70;
        r109 = null;
    L70:
        Object r111 = (Boolean) r109;     // Catch: Throwable -> L172
        if (r111 != null) goto L77;
        r105.getClass();     // Catch: Throwable -> L172
        Object r112 = SDKSettingsCacheManager.f42808a.get("ec_pdp_retry");     // Catch: Throwable -> L172
        if ((r112 instanceof Boolean) == true) goto L76;
        r112 = null;
    L76:
        r111 = (Boolean) r112;     // Catch: Throwable -> L172
    L77:
        if (r111 != null) goto L182;
        int r113 = com.bytedance.android.ec.base.settings.g.f42821a;     // Catch: Throwable -> L172
    L159:
        th = move-exception;
        Result.Companion r114 = Result.Companion;     // Catch: Throwable -> L172
        Object r115 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L172
    L162:
        if (Result.m9452exceptionOrNullimpl(r115) != null) goto L191;
    L169:
        r111 = r115;
    L170:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L172
        SDKSettingsCacheManager.e("ec_pdp_retry", r111);     // Catch: Throwable -> L172
        goto L182
    L191:
        r115 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ec_pdp_retry", Boolean.class, r102);     // Catch: Throwable -> L166
    L167:
        if (r115 != null) goto L169;
        r111 = r102;
    L166:
        r115 = r102;
        goto L167
    L183:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L133
        Object r116 = SDKSettingsCacheManager.f42809b.get("ec_pdp_retry");     // Catch: Throwable -> L133
        if (r116 != null) goto L85;
    L130:
        Object r117 = null;
    L131:
        Object r118 = Result.m9449constructorimpl(r117);     // Catch: Throwable -> L133
    L135:
        Throwable r119 = Result.m9452exceptionOrNullimpl(r118);     // Catch: Throwable -> L159
        if (r119 == null) goto L139;
        EnsureManager.ensureNotReachHere(r119);     // Catch: Throwable -> L159
    L139:
        if (Result.m9455isFailureimpl(r118) == false) goto L142;
        r118 = null;
    L142:
        if ((r118 instanceof Boolean) == true) goto L144;
        r118 = null;
    L144:
        r115 = (Boolean) r118;     // Catch: Throwable -> L159
        if (r115 != null) goto L169;
        jj4.b r120 = jj4.b.f499326b;     // Catch: Throwable -> L159
        Object r121 = jj4.a.a("ec_pdp_retry", Boolean.class, r102, false);     // Catch: Throwable -> L159
        if (r121 != null) goto L151;
        Intrinsics.throwNpe();     // Catch: Throwable -> L159
    L151:
        if ((r121 instanceof Boolean) == false) goto L154;
        r106 = r121;
    L154:
        Object r122 = (Boolean) r106;     // Catch: Throwable -> L159
        if (r122 != null) goto L157;
        r122 = r102;
    L157:
        r115 = Result.m9449constructorimpl(r122);     // Catch: Throwable -> L159
    L85:
        if ((r116 instanceof Boolean) == true) goto L87;
        Object r123 = null;
    L88:
        r117 = (Boolean) r123;     // Catch: Throwable -> L133
        if (r117 != null) goto L131;
        if ((r116 instanceof Number) == false) goto L118;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L100;
        Float r124 = Float.valueOf(((Number) r116).floatValue());     // Catch: Throwable -> L133
        if ((r124 instanceof Boolean) == true) goto L98;
        r124 = null;
    L98:
        r117 = (Boolean) r124;     // Catch: Throwable -> L133
        goto L131
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L106;
        Double r125 = Double.valueOf(((Number) r116).doubleValue());     // Catch: Throwable -> L133
        if ((r125 instanceof Boolean) == true) goto L104;
        r125 = null;
    L104:
        r117 = (Boolean) r125;     // Catch: Throwable -> L133
        goto L131
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L112;
        Integer r126 = Integer.valueOf(((Number) r116).intValue());     // Catch: Throwable -> L133
        if ((r126 instanceof Boolean) == true) goto L110;
        r126 = null;
    L110:
        r117 = (Boolean) r126;     // Catch: Throwable -> L133
        goto L131
    L112:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L118;
        Long r127 = Long.valueOf(((Number) r116).longValue());     // Catch: Throwable -> L133
        if ((r127 instanceof Boolean) == true) goto L116;
        r127 = null;
    L116:
        r117 = (Boolean) r127;     // Catch: Throwable -> L133
    L118:
        if ((r116 instanceof JSONObject) == false) goto L120;
    L189:
        Object r128 = SDKSettingsCacheManager.a().fromJson(r116.toString(), Boolean.class);     // Catch: Throwable -> L126
        if ((r128 instanceof Boolean) == true) goto L124;
        r128 = null;
    L124:
        Object r129 = Result.m9449constructorimpl((Boolean) r128);     // Catch: Throwable -> L126
    L128:
        r117 = r129;
        if (Result.m9455isFailureimpl(r117) == false) goto L131;
    L126:
        th = move-exception;
        Result.Companion r130 = Result.Companion;     // Catch: Throwable -> L133
        r129 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L133
        goto L128
    L120:
        if ((r116 instanceof JSONArray) == false) goto L130;
    L87:
        r123 = r116;
    L133:
        th = move-exception;
        Result.Companion r131 = Result.Companion;     // Catch: Throwable -> L159
        r118 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L159
    L182:
        return ((Boolean) r111).booleanValue();
    L11:
        if ((r107 instanceof Boolean) == true) goto L13;
        Object r132 = null;
    L14:
        r108 = (Boolean) r132;     // Catch: Throwable -> L59
        if (r108 != null) goto L57;
        if ((r107 instanceof Number) == false) goto L44;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r133 = Float.valueOf(((Number) r107).floatValue());     // Catch: Throwable -> L59
        if ((r133 instanceof Boolean) == true) goto L24;
        r133 = null;
    L24:
        r108 = (Boolean) r133;     // Catch: Throwable -> L59
        goto L57
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r134 = Double.valueOf(((Number) r107).doubleValue());     // Catch: Throwable -> L59
        if ((r134 instanceof Boolean) == true) goto L30;
        r134 = null;
    L30:
        r108 = (Boolean) r134;     // Catch: Throwable -> L59
        goto L57
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L38;
        Integer r135 = Integer.valueOf(((Number) r107).intValue());     // Catch: Throwable -> L59
        if ((r135 instanceof Boolean) == true) goto L36;
        r135 = null;
    L36:
        r108 = (Boolean) r135;     // Catch: Throwable -> L59
        goto L57
    L38:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L44;
        Long r136 = Long.valueOf(((Number) r107).longValue());     // Catch: Throwable -> L59
        if ((r136 instanceof Boolean) == true) goto L42;
        r136 = null;
    L42:
        r108 = (Boolean) r136;     // Catch: Throwable -> L59
    L44:
        if ((r107 instanceof JSONObject) == false) goto L46;
    L195:
        Object r137 = SDKSettingsCacheManager.a().fromJson(r107.toString(), Boolean.class);     // Catch: Throwable -> L52
        if ((r137 instanceof Boolean) == true) goto L50;
        r137 = null;
    L50:
        Object r138 = Result.m9449constructorimpl((Boolean) r137);     // Catch: Throwable -> L52
    L54:
        r108 = r138;
        if (Result.m9455isFailureimpl(r108) == false) goto L57;
    L52:
        th = move-exception;
        Result.Companion r139 = Result.Companion;     // Catch: Throwable -> L59
        r138 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L59
        goto L54
    L46:
        if ((r107 instanceof JSONArray) == false) goto L56;
    L13:
        r132 = r107;
    L59:
        th = move-exception;
        Result.Companion r140 = Result.Companion;     // Catch: Throwable -> L172
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L172
    L172:
        th = move-exception;
        Result.Companion r141 = Result.Companion;
        Object r142 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r143 = Result.m9452exceptionOrNullimpl(r142);
        if (r143 == null) goto L177;
        EnsureManager.ensureNotReachHere(r143);
    L177:
        if (Result.m9455isFailureimpl(r142) == true) goto L180;
        r102 = r142;
    L180:
        r111 = r102;
        goto L182
    }

    @SettingPanel("商详schema老转新切流")
    public static final int g() {
        int r100 = com.bytedance.android.ec.base.settings.b.f42814a;
        Object r101 = 0;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L166
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L166
        SDKSettingsCacheManager r103 = SDKSettingsCacheManager.f42812e;     // Catch: Throwable -> L166
        Object r104 = null;
        r103.getClass();     // Catch: Throwable -> L56
        Object r105 = SDKSettingsCacheManager.f42809b.get("ec_pdp_schema_convert_config");     // Catch: Throwable -> L56
        if (r105 != null) goto L11;
    L53:
        Object r106 = null;
    L54:
        Object r107 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L56
    L58:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);     // Catch: Throwable -> L166
        if (r108 == null) goto L62;
        EnsureManager.ensureNotReachHere(r108);     // Catch: Throwable -> L166
    L62:
        if (Result.m9455isFailureimpl(r107) == false) goto L65;
        r107 = null;
    L65:
        if ((r107 instanceof Integer) == true) goto L67;
        r107 = null;
    L67:
        Object r109 = (Integer) r107;     // Catch: Throwable -> L166
        if (r109 != null) goto L74;
        r103.getClass();     // Catch: Throwable -> L166
        Object r110 = SDKSettingsCacheManager.f42808a.get("ec_pdp_schema_convert_config");     // Catch: Throwable -> L166
        if ((r110 instanceof Integer) == true) goto L73;
        r110 = null;
    L73:
        r109 = (Integer) r110;     // Catch: Throwable -> L166
    L74:
        if (r109 != null) goto L176;
        int r111 = com.bytedance.android.ec.base.settings.g.f42821a;     // Catch: Throwable -> L166
    L153:
        th = move-exception;
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L166
        Object r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
    L156:
        if (Result.m9452exceptionOrNullimpl(r113) != null) goto L179;
    L163:
        r109 = r113;
    L164:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L166
        SDKSettingsCacheManager.e("ec_pdp_schema_convert_config", r109);     // Catch: Throwable -> L166
        goto L176
    L179:
        r113 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ec_pdp_schema_convert_config", Integer.class, r101);     // Catch: Throwable -> L160
    L161:
        if (r113 != null) goto L163;
        r109 = r101;
    L160:
        r113 = r101;
        goto L161
    L185:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L127
        Object r114 = SDKSettingsCacheManager.f42809b.get("ec_pdp_schema_convert_config");     // Catch: Throwable -> L127
        if (r114 != null) goto L82;
    L124:
        Object r115 = null;
    L125:
        Object r116 = Result.m9449constructorimpl(r115);     // Catch: Throwable -> L127
    L129:
        Throwable r117 = Result.m9452exceptionOrNullimpl(r116);     // Catch: Throwable -> L153
        if (r117 == null) goto L133;
        EnsureManager.ensureNotReachHere(r117);     // Catch: Throwable -> L153
    L133:
        if (Result.m9455isFailureimpl(r116) == false) goto L136;
        r116 = null;
    L136:
        if ((r116 instanceof Integer) == true) goto L138;
        r116 = null;
    L138:
        Integer r118 = (Integer) r116;     // Catch: Throwable -> L153
        if (r118 == null) goto L141;
        r109 = r118;
        goto L164
    L141:
        jj4.b r119 = jj4.b.f499326b;     // Catch: Throwable -> L153
        Object r120 = jj4.a.a("ec_pdp_schema_convert_config", Integer.class, r101, false);     // Catch: Throwable -> L153
        if (r120 != null) goto L145;
        Intrinsics.throwNpe();     // Catch: Throwable -> L153
    L145:
        if ((r120 instanceof Integer) == false) goto L148;
        r104 = r120;
    L148:
        Object r121 = (Integer) r104;     // Catch: Throwable -> L153
        if (r121 != null) goto L151;
        r121 = r101;
    L151:
        r113 = Result.m9449constructorimpl(r121);     // Catch: Throwable -> L153
    L82:
        if ((r114 instanceof Integer) == true) goto L84;
        Object r122 = null;
    L85:
        r115 = (Integer) r122;     // Catch: Throwable -> L127
        if (r115 != null) goto L125;
        if ((r114 instanceof Number) == false) goto L112;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r123 = Float.valueOf(((Number) r114).floatValue());     // Catch: Throwable -> L127
        if ((r123 instanceof Integer) == true) goto L95;
        r123 = null;
    L95:
        r115 = (Integer) r123;     // Catch: Throwable -> L127
        goto L125
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r124 = Double.valueOf(((Number) r114).doubleValue());     // Catch: Throwable -> L127
        if ((r124 instanceof Integer) == true) goto L101;
        r124 = null;
    L101:
        r115 = (Integer) r124;     // Catch: Throwable -> L127
        goto L125
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L106;
        r115 = Integer.valueOf(((Number) r114).intValue());     // Catch: Throwable -> L127
        goto L125
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L112;
        Long r125 = Long.valueOf(((Number) r114).longValue());     // Catch: Throwable -> L127
        if ((r125 instanceof Integer) == true) goto L110;
        r125 = null;
    L110:
        r115 = (Integer) r125;     // Catch: Throwable -> L127
    L112:
        if ((r114 instanceof JSONObject) == false) goto L114;
    L177:
        Object r126 = SDKSettingsCacheManager.a().fromJson(r114.toString(), Integer.class);     // Catch: Throwable -> L120
        if ((r126 instanceof Integer) == true) goto L118;
        r126 = null;
    L118:
        Object r127 = Result.m9449constructorimpl((Integer) r126);     // Catch: Throwable -> L120
    L122:
        r115 = r127;
        if (Result.m9455isFailureimpl(r115) == false) goto L125;
    L120:
        th = move-exception;
        Result.Companion r128 = Result.Companion;     // Catch: Throwable -> L127
        r127 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L127
        goto L122
    L114:
        if ((r114 instanceof JSONArray) == false) goto L124;
    L84:
        r122 = r114;
    L127:
        th = move-exception;
        Result.Companion r129 = Result.Companion;     // Catch: Throwable -> L153
        r116 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L153
    L176:
        return ((Number) r109).intValue();
    L11:
        if ((r105 instanceof Integer) == true) goto L13;
        Object r130 = null;
    L14:
        r106 = (Integer) r130;     // Catch: Throwable -> L56
        if (r106 != null) goto L54;
        if ((r105 instanceof Number) == false) goto L41;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r131 = Float.valueOf(((Number) r105).floatValue());     // Catch: Throwable -> L56
        if ((r131 instanceof Integer) == true) goto L24;
        r131 = null;
    L24:
        r106 = (Integer) r131;     // Catch: Throwable -> L56
        goto L54
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r132 = Double.valueOf(((Number) r105).doubleValue());     // Catch: Throwable -> L56
        if ((r132 instanceof Integer) == true) goto L30;
        r132 = null;
    L30:
        r106 = (Integer) r132;     // Catch: Throwable -> L56
        goto L54
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L35;
        r106 = Integer.valueOf(((Number) r105).intValue());     // Catch: Throwable -> L56
        goto L54
    L35:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L41;
        Long r133 = Long.valueOf(((Number) r105).longValue());     // Catch: Throwable -> L56
        if ((r133 instanceof Integer) == true) goto L39;
        r133 = null;
    L39:
        r106 = (Integer) r133;     // Catch: Throwable -> L56
    L41:
        if ((r105 instanceof JSONObject) == false) goto L43;
    L189:
        Object r134 = SDKSettingsCacheManager.a().fromJson(r105.toString(), Integer.class);     // Catch: Throwable -> L49
        if ((r134 instanceof Integer) == true) goto L47;
        r134 = null;
    L47:
        Object r135 = Result.m9449constructorimpl((Integer) r134);     // Catch: Throwable -> L49
    L51:
        r106 = r135;
        if (Result.m9455isFailureimpl(r106) == false) goto L54;
    L49:
        th = move-exception;
        Result.Companion r136 = Result.Companion;     // Catch: Throwable -> L56
        r135 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L56
        goto L51
    L43:
        if ((r105 instanceof JSONArray) == false) goto L53;
    L13:
        r130 = r105;
    L56:
        th = move-exception;
        Result.Companion r137 = Result.Companion;     // Catch: Throwable -> L166
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
    L166:
        th = move-exception;
        Result.Companion r138 = Result.Companion;
        Object r139 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r140 = Result.m9452exceptionOrNullimpl(r139);
        if (r140 == null) goto L171;
        EnsureManager.ensureNotReachHere(r140);
    L171:
        if (Result.m9455isFailureimpl(r139) == true) goto L174;
        r101 = r139;
    L174:
        r109 = r101;
        goto L176
    }

    @SettingPanel("商详schema diff")
    public static final boolean h() {
        int r100 = com.bytedance.android.ec.base.settings.b.f42814a;
        Object r101 = Boolean.FALSE;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L172
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L172
        SDKSettingsCacheManager r103 = SDKSettingsCacheManager.f42812e;     // Catch: Throwable -> L172
        Object r104 = null;
        r103.getClass();     // Catch: Throwable -> L59
        Object r105 = SDKSettingsCacheManager.f42809b.get("ec_pdp_schema_diff");     // Catch: Throwable -> L59
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
        Object r110 = SDKSettingsCacheManager.f42808a.get("ec_pdp_schema_diff");     // Catch: Throwable -> L172
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
        SDKSettingsCacheManager.e("ec_pdp_schema_diff", r109);     // Catch: Throwable -> L172
        goto L182
    L185:
        r113 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ec_pdp_schema_diff", Boolean.class, r101);     // Catch: Throwable -> L166
    L167:
        if (r113 != null) goto L169;
        r109 = r101;
    L166:
        r113 = r101;
        goto L167
    L191:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L133
        Object r114 = SDKSettingsCacheManager.f42809b.get("ec_pdp_schema_diff");     // Catch: Throwable -> L133
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
        Object r119 = jj4.a.a("ec_pdp_schema_diff", Boolean.class, r101, false);     // Catch: Throwable -> L159
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

    @SettingPanel("商详截图优化-已固化")
    public static final int i() {
        int r100 = j.f43647a;
        int r101 = e.f43640a;
        Object r102 = e.a(1, 0);
        int r103 = com.bytedance.android.ec.base.settings.b.f42814a;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L166
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L166
        SDKSettingsCacheManager r105 = SDKSettingsCacheManager.f42812e;     // Catch: Throwable -> L166
        Object r106 = null;
        r105.getClass();     // Catch: Throwable -> L56
        Object r107 = SDKSettingsCacheManager.f42809b.get("ec_php_screen_shot_style");     // Catch: Throwable -> L56
        if (r107 != null) goto L11;
    L53:
        Object r108 = null;
    L54:
        Object r109 = Result.m9449constructorimpl(r108);     // Catch: Throwable -> L56
    L58:
        Throwable r110 = Result.m9452exceptionOrNullimpl(r109);     // Catch: Throwable -> L166
        if (r110 == null) goto L62;
        EnsureManager.ensureNotReachHere(r110);     // Catch: Throwable -> L166
    L62:
        if (Result.m9455isFailureimpl(r109) == false) goto L65;
        r109 = null;
    L65:
        if ((r109 instanceof Integer) == true) goto L67;
        r109 = null;
    L67:
        Object r111 = (Integer) r109;     // Catch: Throwable -> L166
        if (r111 != null) goto L74;
        r105.getClass();     // Catch: Throwable -> L166
        Object r112 = SDKSettingsCacheManager.f42808a.get("ec_php_screen_shot_style");     // Catch: Throwable -> L166
        if ((r112 instanceof Integer) == true) goto L73;
        r112 = null;
    L73:
        r111 = (Integer) r112;     // Catch: Throwable -> L166
    L74:
        if (r111 != null) goto L176;
        int r113 = com.bytedance.android.ec.base.settings.g.f42821a;     // Catch: Throwable -> L166
    L153:
        th = move-exception;
        Result.Companion r114 = Result.Companion;     // Catch: Throwable -> L166
        Object r115 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
    L155:
        Object r116 = r115;
        if (Result.m9452exceptionOrNullimpl(r116) != null) goto L179;
    L163:
        r111 = r116;
    L164:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L166
        SDKSettingsCacheManager.e("ec_php_screen_shot_style", r111);     // Catch: Throwable -> L166
        goto L176
    L179:
        r116 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ec_php_screen_shot_style", Integer.class, r102);     // Catch: Throwable -> L160
    L161:
        if (r116 != null) goto L163;
        r111 = r102;
    L160:
        r116 = r102;
        goto L161
    L185:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L127
        Object r117 = SDKSettingsCacheManager.f42809b.get("ec_php_screen_shot_style");     // Catch: Throwable -> L127
        if (r117 != null) goto L82;
    L124:
        Object r118 = null;
    L125:
        Object r119 = Result.m9449constructorimpl(r118);     // Catch: Throwable -> L127
    L129:
        Throwable r120 = Result.m9452exceptionOrNullimpl(r119);     // Catch: Throwable -> L153
        if (r120 == null) goto L133;
        EnsureManager.ensureNotReachHere(r120);     // Catch: Throwable -> L153
    L133:
        if (Result.m9455isFailureimpl(r119) == false) goto L136;
        r119 = null;
    L136:
        if ((r119 instanceof Integer) == true) goto L138;
        r119 = null;
    L138:
        r116 = (Integer) r119;     // Catch: Throwable -> L153
        if (r116 != null) goto L163;
        jj4.b r121 = jj4.b.f499326b;     // Catch: Throwable -> L153
        Object r122 = jj4.a.a("ec_php_screen_shot_style", Integer.class, r102, false);     // Catch: Throwable -> L153
        if (r122 != null) goto L145;
        Intrinsics.throwNpe();     // Catch: Throwable -> L153
    L145:
        if ((r122 instanceof Integer) == false) goto L148;
        r106 = r122;
    L148:
        Object r123 = (Integer) r106;     // Catch: Throwable -> L153
        if (r123 != null) goto L151;
        r123 = r102;
    L151:
        r115 = Result.m9449constructorimpl(r123);     // Catch: Throwable -> L153
    L82:
        if ((r117 instanceof Integer) == true) goto L84;
        Object r124 = null;
    L85:
        r118 = (Integer) r124;     // Catch: Throwable -> L127
        if (r118 != null) goto L125;
        if ((r117 instanceof Number) == false) goto L112;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r125 = Float.valueOf(((Number) r117).floatValue());     // Catch: Throwable -> L127
        if ((r125 instanceof Integer) == true) goto L95;
        r125 = null;
    L95:
        r118 = (Integer) r125;     // Catch: Throwable -> L127
        goto L125
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r126 = Double.valueOf(((Number) r117).doubleValue());     // Catch: Throwable -> L127
        if ((r126 instanceof Integer) == true) goto L101;
        r126 = null;
    L101:
        r118 = (Integer) r126;     // Catch: Throwable -> L127
        goto L125
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L106;
        r118 = Integer.valueOf(((Number) r117).intValue());     // Catch: Throwable -> L127
        goto L125
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L112;
        Long r127 = Long.valueOf(((Number) r117).longValue());     // Catch: Throwable -> L127
        if ((r127 instanceof Integer) == true) goto L110;
        r127 = null;
    L110:
        r118 = (Integer) r127;     // Catch: Throwable -> L127
    L112:
        if ((r117 instanceof JSONObject) == false) goto L114;
    L177:
        Object r128 = SDKSettingsCacheManager.a().fromJson(r117.toString(), Integer.class);     // Catch: Throwable -> L120
        if ((r128 instanceof Integer) == true) goto L118;
        r128 = null;
    L118:
        Object r129 = Result.m9449constructorimpl((Integer) r128);     // Catch: Throwable -> L120
    L122:
        r118 = r129;
        if (Result.m9455isFailureimpl(r118) == false) goto L125;
    L120:
        th = move-exception;
        Result.Companion r130 = Result.Companion;     // Catch: Throwable -> L127
        r129 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L127
        goto L122
    L114:
        if ((r117 instanceof JSONArray) == false) goto L124;
    L84:
        r124 = r117;
    L127:
        th = move-exception;
        Result.Companion r131 = Result.Companion;     // Catch: Throwable -> L153
        r119 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L153
    L176:
        return ((Number) r111).intValue();
    L11:
        if ((r107 instanceof Integer) == true) goto L13;
        Object r132 = null;
    L14:
        r108 = (Integer) r132;     // Catch: Throwable -> L56
        if (r108 != null) goto L54;
        if ((r107 instanceof Number) == false) goto L41;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r133 = Float.valueOf(((Number) r107).floatValue());     // Catch: Throwable -> L56
        if ((r133 instanceof Integer) == true) goto L24;
        r133 = null;
    L24:
        r108 = (Integer) r133;     // Catch: Throwable -> L56
        goto L54
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r134 = Double.valueOf(((Number) r107).doubleValue());     // Catch: Throwable -> L56
        if ((r134 instanceof Integer) == true) goto L30;
        r134 = null;
    L30:
        r108 = (Integer) r134;     // Catch: Throwable -> L56
        goto L54
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L35;
        r108 = Integer.valueOf(((Number) r107).intValue());     // Catch: Throwable -> L56
        goto L54
    L35:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L41;
        Long r135 = Long.valueOf(((Number) r107).longValue());     // Catch: Throwable -> L56
        if ((r135 instanceof Integer) == true) goto L39;
        r135 = null;
    L39:
        r108 = (Integer) r135;     // Catch: Throwable -> L56
    L41:
        if ((r107 instanceof JSONObject) == false) goto L43;
    L189:
        Object r136 = SDKSettingsCacheManager.a().fromJson(r107.toString(), Integer.class);     // Catch: Throwable -> L49
        if ((r136 instanceof Integer) == true) goto L47;
        r136 = null;
    L47:
        Object r137 = Result.m9449constructorimpl((Integer) r136);     // Catch: Throwable -> L49
    L51:
        r108 = r137;
        if (Result.m9455isFailureimpl(r108) == false) goto L54;
    L49:
        th = move-exception;
        Result.Companion r138 = Result.Companion;     // Catch: Throwable -> L56
        r137 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L56
        goto L51
    L43:
        if ((r107 instanceof JSONArray) == false) goto L53;
    L13:
        r132 = r107;
    L56:
        th = move-exception;
        Result.Companion r139 = Result.Companion;     // Catch: Throwable -> L166
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
    L166:
        th = move-exception;
        Result.Companion r140 = Result.Companion;
        Object r141 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r142 = Result.m9452exceptionOrNullimpl(r141);
        if (r142 == null) goto L171;
        EnsureManager.ensureNotReachHere(r142);
    L171:
        if (Result.m9455isFailureimpl(r141) == true) goto L174;
        r102 = r141;
    L174:
        r111 = r102;
        goto L176
    }

    public static final boolean j() {
        int r100 = j.f43647a;
        Object r101 = Boolean.TRUE;
        int r102 = com.bytedance.android.ec.base.settings.b.f42814a;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L172
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L172
        SDKSettingsCacheManager r104 = SDKSettingsCacheManager.f42812e;     // Catch: Throwable -> L172
        Object r105 = null;
        r104.getClass();     // Catch: Throwable -> L59
        Object r106 = SDKSettingsCacheManager.f42809b.get("ec_pdp_use_new_check_valid");     // Catch: Throwable -> L59
        if (r106 != null) goto L11;
    L56:
        Object r107 = null;
    L57:
        Object r108 = Result.m9449constructorimpl(r107);     // Catch: Throwable -> L59
    L61:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);     // Catch: Throwable -> L172
        if (r109 == null) goto L65;
        EnsureManager.ensureNotReachHere(r109);     // Catch: Throwable -> L172
    L65:
        if (Result.m9455isFailureimpl(r108) == false) goto L68;
        r108 = null;
    L68:
        if ((r108 instanceof Boolean) == true) goto L70;
        r108 = null;
    L70:
        Object r110 = (Boolean) r108;     // Catch: Throwable -> L172
        if (r110 != null) goto L77;
        r104.getClass();     // Catch: Throwable -> L172
        Object r111 = SDKSettingsCacheManager.f42808a.get("ec_pdp_use_new_check_valid");     // Catch: Throwable -> L172
        if ((r111 instanceof Boolean) == true) goto L76;
        r111 = null;
    L76:
        r110 = (Boolean) r111;     // Catch: Throwable -> L172
    L77:
        if (r110 != null) goto L182;
        int r112 = com.bytedance.android.ec.base.settings.g.f42821a;     // Catch: Throwable -> L172
    L159:
        th = move-exception;
        Result.Companion r113 = Result.Companion;     // Catch: Throwable -> L172
        Object r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L172
    L162:
        if (Result.m9452exceptionOrNullimpl(r114) != null) goto L185;
    L169:
        r110 = r114;
    L170:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L172
        SDKSettingsCacheManager.e("ec_pdp_use_new_check_valid", r110);     // Catch: Throwable -> L172
        goto L182
    L185:
        r114 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ec_pdp_use_new_check_valid", Boolean.class, r101);     // Catch: Throwable -> L166
    L167:
        if (r114 != null) goto L169;
        r110 = r101;
    L166:
        r114 = r101;
        goto L167
    L191:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L133
        Object r115 = SDKSettingsCacheManager.f42809b.get("ec_pdp_use_new_check_valid");     // Catch: Throwable -> L133
        if (r115 != null) goto L85;
    L130:
        Object r116 = null;
    L131:
        Object r117 = Result.m9449constructorimpl(r116);     // Catch: Throwable -> L133
    L135:
        Throwable r118 = Result.m9452exceptionOrNullimpl(r117);     // Catch: Throwable -> L159
        if (r118 == null) goto L139;
        EnsureManager.ensureNotReachHere(r118);     // Catch: Throwable -> L159
    L139:
        if (Result.m9455isFailureimpl(r117) == false) goto L142;
        r117 = null;
    L142:
        if ((r117 instanceof Boolean) == true) goto L144;
        r117 = null;
    L144:
        r114 = (Boolean) r117;     // Catch: Throwable -> L159
        if (r114 != null) goto L169;
        jj4.b r119 = jj4.b.f499326b;     // Catch: Throwable -> L159
        Object r120 = jj4.a.a("ec_pdp_use_new_check_valid", Boolean.class, r101, false);     // Catch: Throwable -> L159
        if (r120 != null) goto L151;
        Intrinsics.throwNpe();     // Catch: Throwable -> L159
    L151:
        if ((r120 instanceof Boolean) == false) goto L154;
        r105 = r120;
    L154:
        Object r121 = (Boolean) r105;     // Catch: Throwable -> L159
        if (r121 != null) goto L157;
        r121 = r101;
    L157:
        r114 = Result.m9449constructorimpl(r121);     // Catch: Throwable -> L159
    L85:
        if ((r115 instanceof Boolean) == true) goto L87;
        Object r122 = null;
    L88:
        r116 = (Boolean) r122;     // Catch: Throwable -> L133
        if (r116 != null) goto L131;
        if ((r115 instanceof Number) == false) goto L118;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L100;
        Float r123 = Float.valueOf(((Number) r115).floatValue());     // Catch: Throwable -> L133
        if ((r123 instanceof Boolean) == true) goto L98;
        r123 = null;
    L98:
        r116 = (Boolean) r123;     // Catch: Throwable -> L133
        goto L131
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L106;
        Double r124 = Double.valueOf(((Number) r115).doubleValue());     // Catch: Throwable -> L133
        if ((r124 instanceof Boolean) == true) goto L104;
        r124 = null;
    L104:
        r116 = (Boolean) r124;     // Catch: Throwable -> L133
        goto L131
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L112;
        Integer r125 = Integer.valueOf(((Number) r115).intValue());     // Catch: Throwable -> L133
        if ((r125 instanceof Boolean) == true) goto L110;
        r125 = null;
    L110:
        r116 = (Boolean) r125;     // Catch: Throwable -> L133
        goto L131
    L112:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L118;
        Long r126 = Long.valueOf(((Number) r115).longValue());     // Catch: Throwable -> L133
        if ((r126 instanceof Boolean) == true) goto L116;
        r126 = null;
    L116:
        r116 = (Boolean) r126;     // Catch: Throwable -> L133
    L118:
        if ((r115 instanceof JSONObject) == false) goto L120;
    L183:
        Object r127 = SDKSettingsCacheManager.a().fromJson(r115.toString(), Boolean.class);     // Catch: Throwable -> L126
        if ((r127 instanceof Boolean) == true) goto L124;
        r127 = null;
    L124:
        Object r128 = Result.m9449constructorimpl((Boolean) r127);     // Catch: Throwable -> L126
    L128:
        r116 = r128;
        if (Result.m9455isFailureimpl(r116) == false) goto L131;
    L126:
        th = move-exception;
        Result.Companion r129 = Result.Companion;     // Catch: Throwable -> L133
        r128 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L133
        goto L128
    L120:
        if ((r115 instanceof JSONArray) == false) goto L130;
    L87:
        r122 = r115;
    L133:
        th = move-exception;
        Result.Companion r130 = Result.Companion;     // Catch: Throwable -> L159
        r117 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L159
    L182:
        return ((Boolean) r110).booleanValue();
    L11:
        if ((r106 instanceof Boolean) == true) goto L13;
        Object r131 = null;
    L14:
        r107 = (Boolean) r131;     // Catch: Throwable -> L59
        if (r107 != null) goto L57;
        if ((r106 instanceof Number) == false) goto L44;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r132 = Float.valueOf(((Number) r106).floatValue());     // Catch: Throwable -> L59
        if ((r132 instanceof Boolean) == true) goto L24;
        r132 = null;
    L24:
        r107 = (Boolean) r132;     // Catch: Throwable -> L59
        goto L57
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r133 = Double.valueOf(((Number) r106).doubleValue());     // Catch: Throwable -> L59
        if ((r133 instanceof Boolean) == true) goto L30;
        r133 = null;
    L30:
        r107 = (Boolean) r133;     // Catch: Throwable -> L59
        goto L57
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L38;
        Integer r134 = Integer.valueOf(((Number) r106).intValue());     // Catch: Throwable -> L59
        if ((r134 instanceof Boolean) == true) goto L36;
        r134 = null;
    L36:
        r107 = (Boolean) r134;     // Catch: Throwable -> L59
        goto L57
    L38:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L44;
        Long r135 = Long.valueOf(((Number) r106).longValue());     // Catch: Throwable -> L59
        if ((r135 instanceof Boolean) == true) goto L42;
        r135 = null;
    L42:
        r107 = (Boolean) r135;     // Catch: Throwable -> L59
    L44:
        if ((r106 instanceof JSONObject) == false) goto L46;
    L189:
        Object r136 = SDKSettingsCacheManager.a().fromJson(r106.toString(), Boolean.class);     // Catch: Throwable -> L52
        if ((r136 instanceof Boolean) == true) goto L50;
        r136 = null;
    L50:
        Object r137 = Result.m9449constructorimpl((Boolean) r136);     // Catch: Throwable -> L52
    L54:
        r107 = r137;
        if (Result.m9455isFailureimpl(r107) == false) goto L57;
    L52:
        th = move-exception;
        Result.Companion r138 = Result.Companion;     // Catch: Throwable -> L59
        r137 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L59
        goto L54
    L46:
        if ((r106 instanceof JSONArray) == false) goto L56;
    L13:
        r131 = r106;
    L59:
        th = move-exception;
        Result.Companion r139 = Result.Companion;     // Catch: Throwable -> L172
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L172
    L172:
        th = move-exception;
        Result.Companion r140 = Result.Companion;
        Object r141 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r142 = Result.m9452exceptionOrNullimpl(r141);
        if (r142 == null) goto L177;
        EnsureManager.ensureNotReachHere(r142);
    L177:
        if (Result.m9455isFailureimpl(r141) == true) goto L180;
        r101 = r141;
    L180:
        r110 = r101;
        goto L182
    }

    public static final boolean k() {
        jj4.b r100 = jj4.b.f499326b;
        int r101 = e.f43640a;
        Object r102 = jj4.a.a("iesec_sku_preview", Boolean.class, e.a(Boolean.TRUE, Boolean.FALSE), false);
        if (r102 != null) goto L6;
        Intrinsics.throwNpe();
    L6:
        return ((Boolean) r102).booleanValue();
    }

    @SettingPanel("曝光时长开关")
    public static final boolean l() {
        int r100 = com.bytedance.android.ec.base.settings.b.f42814a;
        Object r101 = Boolean.TRUE;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L172
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L172
        SDKSettingsCacheManager r103 = SDKSettingsCacheManager.f42812e;     // Catch: Throwable -> L172
        Object r104 = null;
        r103.getClass();     // Catch: Throwable -> L59
        Object r105 = SDKSettingsCacheManager.f42809b.get("iesec_pdp_enable_exposure_engine");     // Catch: Throwable -> L59
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
        Object r110 = SDKSettingsCacheManager.f42808a.get("iesec_pdp_enable_exposure_engine");     // Catch: Throwable -> L172
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
        SDKSettingsCacheManager.e("iesec_pdp_enable_exposure_engine", r109);     // Catch: Throwable -> L172
        goto L182
    L185:
        r113 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("iesec_pdp_enable_exposure_engine", Boolean.class, r101);     // Catch: Throwable -> L166
    L167:
        if (r113 != null) goto L169;
        r109 = r101;
    L166:
        r113 = r101;
        goto L167
    L191:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L133
        Object r114 = SDKSettingsCacheManager.f42809b.get("iesec_pdp_enable_exposure_engine");     // Catch: Throwable -> L133
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
        Object r119 = jj4.a.a("iesec_pdp_enable_exposure_engine", Boolean.class, r101, false);     // Catch: Throwable -> L159
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

    @SettingPanel("曝光时长：商详顶导 alpha 遮挡阈值")
    public static final float m() {
        int r100 = com.bytedance.android.ec.base.settings.b.f42814a;
        Object r101 = Float.valueOf(0.8f);
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L166
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L166
        SDKSettingsCacheManager r103 = SDKSettingsCacheManager.f42812e;     // Catch: Throwable -> L166
        Object r104 = null;
        r103.getClass();     // Catch: Throwable -> L56
        Object r105 = SDKSettingsCacheManager.f42809b.get("iesec_pdp_exposure_alpha_percentage");     // Catch: Throwable -> L56
        if (r105 != null) goto L11;
    L53:
        Object r106 = null;
    L54:
        Object r107 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L56
    L58:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);     // Catch: Throwable -> L166
        if (r108 == null) goto L62;
        EnsureManager.ensureNotReachHere(r108);     // Catch: Throwable -> L166
    L62:
        if (Result.m9455isFailureimpl(r107) == false) goto L65;
        r107 = null;
    L65:
        if ((r107 instanceof Float) == true) goto L67;
        r107 = null;
    L67:
        Object r109 = (Float) r107;     // Catch: Throwable -> L166
        if (r109 != null) goto L74;
        r103.getClass();     // Catch: Throwable -> L166
        Object r110 = SDKSettingsCacheManager.f42808a.get("iesec_pdp_exposure_alpha_percentage");     // Catch: Throwable -> L166
        if ((r110 instanceof Float) == true) goto L73;
        r110 = null;
    L73:
        r109 = (Float) r110;     // Catch: Throwable -> L166
    L74:
        if (r109 != null) goto L176;
        int r111 = com.bytedance.android.ec.base.settings.g.f42821a;     // Catch: Throwable -> L166
    L153:
        th = move-exception;
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L166
        Object r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
    L156:
        if (Result.m9452exceptionOrNullimpl(r113) != null) goto L183;
    L163:
        r109 = r113;
    L164:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L166
        SDKSettingsCacheManager.e("iesec_pdp_exposure_alpha_percentage", r109);     // Catch: Throwable -> L166
        goto L176
    L183:
        r113 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("iesec_pdp_exposure_alpha_percentage", Float.class, r101);     // Catch: Throwable -> L160
    L161:
        if (r113 != null) goto L163;
        r109 = r101;
    L160:
        r113 = r101;
        goto L161
    L189:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L127
        Object r114 = SDKSettingsCacheManager.f42809b.get("iesec_pdp_exposure_alpha_percentage");     // Catch: Throwable -> L127
        if (r114 != null) goto L82;
    L124:
        Object r115 = null;
    L125:
        Object r116 = Result.m9449constructorimpl(r115);     // Catch: Throwable -> L127
    L129:
        Throwable r117 = Result.m9452exceptionOrNullimpl(r116);     // Catch: Throwable -> L153
        if (r117 == null) goto L133;
        EnsureManager.ensureNotReachHere(r117);     // Catch: Throwable -> L153
    L133:
        if (Result.m9455isFailureimpl(r116) == false) goto L136;
        r116 = null;
    L136:
        if ((r116 instanceof Float) == true) goto L138;
        r116 = null;
    L138:
        r113 = (Float) r116;     // Catch: Throwable -> L153
        if (r113 != null) goto L163;
        jj4.b r118 = jj4.b.f499326b;     // Catch: Throwable -> L153
        Object r119 = jj4.a.a("iesec_pdp_exposure_alpha_percentage", Float.class, r101, false);     // Catch: Throwable -> L153
        if (r119 != null) goto L145;
        Intrinsics.throwNpe();     // Catch: Throwable -> L153
    L145:
        if ((r119 instanceof Float) == false) goto L148;
        r104 = r119;
    L148:
        Object r120 = (Float) r104;     // Catch: Throwable -> L153
        if (r120 != null) goto L151;
        r120 = r101;
    L151:
        r113 = Result.m9449constructorimpl(r120);     // Catch: Throwable -> L153
    L82:
        if ((r114 instanceof Float) == true) goto L84;
        Object r121 = null;
    L85:
        r115 = (Float) r121;     // Catch: Throwable -> L127
        if (r115 != null) goto L125;
        if ((r114 instanceof Number) == false) goto L112;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Float.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L94;
        r115 = Float.valueOf(((Number) r114).floatValue());     // Catch: Throwable -> L127
        goto L125
    L94:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Float.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L100;
        Double r122 = Double.valueOf(((Number) r114).doubleValue());     // Catch: Throwable -> L127
        if ((r122 instanceof Float) == true) goto L98;
        r122 = null;
    L98:
        r115 = (Float) r122;     // Catch: Throwable -> L127
        goto L125
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Float.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L106;
        Integer r123 = Integer.valueOf(((Number) r114).intValue());     // Catch: Throwable -> L127
        if ((r123 instanceof Float) == true) goto L104;
        r123 = null;
    L104:
        r115 = (Float) r123;     // Catch: Throwable -> L127
        goto L125
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Float.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L112;
        Long r124 = Long.valueOf(((Number) r114).longValue());     // Catch: Throwable -> L127
        if ((r124 instanceof Float) == true) goto L110;
        r124 = null;
    L110:
        r115 = (Float) r124;     // Catch: Throwable -> L127
    L112:
        if ((r114 instanceof JSONObject) == false) goto L114;
    L181:
        Object r125 = SDKSettingsCacheManager.a().fromJson(r114.toString(), Float.class);     // Catch: Throwable -> L120
        if ((r125 instanceof Float) == true) goto L118;
        r125 = null;
    L118:
        Object r126 = Result.m9449constructorimpl((Float) r125);     // Catch: Throwable -> L120
    L122:
        r115 = r126;
        if (Result.m9455isFailureimpl(r115) == false) goto L125;
    L120:
        th = move-exception;
        Result.Companion r127 = Result.Companion;     // Catch: Throwable -> L127
        r126 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L127
        goto L122
    L114:
        if ((r114 instanceof JSONArray) == false) goto L124;
    L84:
        r121 = r114;
    L127:
        th = move-exception;
        Result.Companion r128 = Result.Companion;     // Catch: Throwable -> L153
        r116 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L153
    L176:
        return ((Number) r109).floatValue();
    L11:
        if ((r105 instanceof Float) == true) goto L13;
        Object r129 = null;
    L14:
        r106 = (Float) r129;     // Catch: Throwable -> L56
        if (r106 != null) goto L54;
        if ((r105 instanceof Number) == false) goto L41;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Float.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L23;
        r106 = Float.valueOf(((Number) r105).floatValue());     // Catch: Throwable -> L56
        goto L54
    L23:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Float.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L29;
        Double r130 = Double.valueOf(((Number) r105).doubleValue());     // Catch: Throwable -> L56
        if ((r130 instanceof Float) == true) goto L27;
        r130 = null;
    L27:
        r106 = (Float) r130;     // Catch: Throwable -> L56
        goto L54
    L29:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Float.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L35;
        Integer r131 = Integer.valueOf(((Number) r105).intValue());     // Catch: Throwable -> L56
        if ((r131 instanceof Float) == true) goto L33;
        r131 = null;
    L33:
        r106 = (Float) r131;     // Catch: Throwable -> L56
        goto L54
    L35:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Float.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L41;
        Long r132 = Long.valueOf(((Number) r105).longValue());     // Catch: Throwable -> L56
        if ((r132 instanceof Float) == true) goto L39;
        r132 = null;
    L39:
        r106 = (Float) r132;     // Catch: Throwable -> L56
    L41:
        if ((r105 instanceof JSONObject) == false) goto L43;
    L179:
        Object r133 = SDKSettingsCacheManager.a().fromJson(r105.toString(), Float.class);     // Catch: Throwable -> L49
        if ((r133 instanceof Float) == true) goto L47;
        r133 = null;
    L47:
        Object r134 = Result.m9449constructorimpl((Float) r133);     // Catch: Throwable -> L49
    L51:
        r106 = r134;
        if (Result.m9455isFailureimpl(r106) == false) goto L54;
    L49:
        th = move-exception;
        Result.Companion r135 = Result.Companion;     // Catch: Throwable -> L56
        r134 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L56
        goto L51
    L43:
        if ((r105 instanceof JSONArray) == false) goto L53;
    L13:
        r129 = r105;
    L56:
        th = move-exception;
        Result.Companion r136 = Result.Companion;     // Catch: Throwable -> L166
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
    L166:
        th = move-exception;
        Result.Companion r137 = Result.Companion;
        Object r138 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r139 = Result.m9452exceptionOrNullimpl(r138);
        if (r139 == null) goto L171;
        EnsureManager.ensureNotReachHere(r139);
    L171:
        if (Result.m9455isFailureimpl(r138) == true) goto L174;
        r101 = r138;
    L174:
        r109 = r101;
        goto L176
    }

    @SettingPanel("曝光时长轮询间隔")
    public static final long n() {
        int r100 = com.bytedance.android.ec.base.settings.b.f42814a;
        Object r101 = 100L;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L166
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L166
        SDKSettingsCacheManager r103 = SDKSettingsCacheManager.f42812e;     // Catch: Throwable -> L166
        Object r104 = null;
        r103.getClass();     // Catch: Throwable -> L56
        Object r105 = SDKSettingsCacheManager.f42809b.get("iesec_pdp_exposure_duration");     // Catch: Throwable -> L56
        if (r105 != null) goto L11;
    L53:
        Object r106 = null;
    L54:
        Object r107 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L56
    L58:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);     // Catch: Throwable -> L166
        if (r108 == null) goto L62;
        EnsureManager.ensureNotReachHere(r108);     // Catch: Throwable -> L166
    L62:
        if (Result.m9455isFailureimpl(r107) == false) goto L65;
        r107 = null;
    L65:
        if ((r107 instanceof Long) == true) goto L67;
        r107 = null;
    L67:
        Object r109 = (Long) r107;     // Catch: Throwable -> L166
        if (r109 != null) goto L74;
        r103.getClass();     // Catch: Throwable -> L166
        Object r110 = SDKSettingsCacheManager.f42808a.get("iesec_pdp_exposure_duration");     // Catch: Throwable -> L166
        if ((r110 instanceof Long) == true) goto L73;
        r110 = null;
    L73:
        r109 = (Long) r110;     // Catch: Throwable -> L166
    L74:
        if (r109 != null) goto L176;
        int r111 = com.bytedance.android.ec.base.settings.g.f42821a;     // Catch: Throwable -> L166
    L153:
        th = move-exception;
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L166
        Object r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
    L156:
        if (Result.m9452exceptionOrNullimpl(r113) != null) goto L181;
    L163:
        r109 = r113;
    L164:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L166
        SDKSettingsCacheManager.e("iesec_pdp_exposure_duration", r109);     // Catch: Throwable -> L166
        goto L176
    L181:
        r113 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("iesec_pdp_exposure_duration", Long.class, r101);     // Catch: Throwable -> L160
    L161:
        if (r113 != null) goto L163;
        r109 = r101;
    L160:
        r113 = r101;
        goto L161
    L187:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L127
        Object r114 = SDKSettingsCacheManager.f42809b.get("iesec_pdp_exposure_duration");     // Catch: Throwable -> L127
        if (r114 != null) goto L82;
    L124:
        Object r115 = null;
    L125:
        Object r116 = Result.m9449constructorimpl(r115);     // Catch: Throwable -> L127
    L129:
        Throwable r117 = Result.m9452exceptionOrNullimpl(r116);     // Catch: Throwable -> L153
        if (r117 == null) goto L133;
        EnsureManager.ensureNotReachHere(r117);     // Catch: Throwable -> L153
    L133:
        if (Result.m9455isFailureimpl(r116) == false) goto L136;
        r116 = null;
    L136:
        if ((r116 instanceof Long) == true) goto L138;
        r116 = null;
    L138:
        r113 = (Long) r116;     // Catch: Throwable -> L153
        if (r113 != null) goto L163;
        jj4.b r118 = jj4.b.f499326b;     // Catch: Throwable -> L153
        Object r119 = jj4.a.a("iesec_pdp_exposure_duration", Long.class, r101, false);     // Catch: Throwable -> L153
        if (r119 != null) goto L145;
        Intrinsics.throwNpe();     // Catch: Throwable -> L153
    L145:
        if ((r119 instanceof Long) == false) goto L148;
        r104 = r119;
    L148:
        Object r120 = (Long) r104;     // Catch: Throwable -> L153
        if (r120 != null) goto L151;
        r120 = r101;
    L151:
        r113 = Result.m9449constructorimpl(r120);     // Catch: Throwable -> L153
    L82:
        if ((r114 instanceof Long) == true) goto L84;
        Object r121 = null;
    L85:
        r115 = (Long) r121;     // Catch: Throwable -> L127
        if (r115 != null) goto L125;
        if ((r114 instanceof Number) == false) goto L112;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Long.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r122 = Float.valueOf(((Number) r114).floatValue());     // Catch: Throwable -> L127
        if ((r122 instanceof Long) == true) goto L95;
        r122 = null;
    L95:
        r115 = (Long) r122;     // Catch: Throwable -> L127
        goto L125
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Long.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r123 = Double.valueOf(((Number) r114).doubleValue());     // Catch: Throwable -> L127
        if ((r123 instanceof Long) == true) goto L101;
        r123 = null;
    L101:
        r115 = (Long) r123;     // Catch: Throwable -> L127
        goto L125
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Long.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L109;
        Integer r124 = Integer.valueOf(((Number) r114).intValue());     // Catch: Throwable -> L127
        if ((r124 instanceof Long) == true) goto L107;
        r124 = null;
    L107:
        r115 = (Long) r124;     // Catch: Throwable -> L127
        goto L125
    L109:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Long.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L112;
        r115 = Long.valueOf(((Number) r114).longValue());     // Catch: Throwable -> L127
    L112:
        if ((r114 instanceof JSONObject) == false) goto L114;
    L179:
        Object r125 = SDKSettingsCacheManager.a().fromJson(r114.toString(), Long.class);     // Catch: Throwable -> L120
        if ((r125 instanceof Long) == true) goto L118;
        r125 = null;
    L118:
        Object r126 = Result.m9449constructorimpl((Long) r125);     // Catch: Throwable -> L120
    L122:
        r115 = r126;
        if (Result.m9455isFailureimpl(r115) == false) goto L125;
    L120:
        th = move-exception;
        Result.Companion r127 = Result.Companion;     // Catch: Throwable -> L127
        r126 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L127
        goto L122
    L114:
        if ((r114 instanceof JSONArray) == false) goto L124;
    L84:
        r121 = r114;
    L127:
        th = move-exception;
        Result.Companion r128 = Result.Companion;     // Catch: Throwable -> L153
        r116 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L153
    L176:
        return ((Number) r109).longValue();
    L11:
        if ((r105 instanceof Long) == true) goto L13;
        Object r129 = null;
    L14:
        r106 = (Long) r129;     // Catch: Throwable -> L56
        if (r106 != null) goto L54;
        if ((r105 instanceof Number) == false) goto L41;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Long.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r130 = Float.valueOf(((Number) r105).floatValue());     // Catch: Throwable -> L56
        if ((r130 instanceof Long) == true) goto L24;
        r130 = null;
    L24:
        r106 = (Long) r130;     // Catch: Throwable -> L56
        goto L54
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Long.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r131 = Double.valueOf(((Number) r105).doubleValue());     // Catch: Throwable -> L56
        if ((r131 instanceof Long) == true) goto L30;
        r131 = null;
    L30:
        r106 = (Long) r131;     // Catch: Throwable -> L56
        goto L54
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Long.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L38;
        Integer r132 = Integer.valueOf(((Number) r105).intValue());     // Catch: Throwable -> L56
        if ((r132 instanceof Long) == true) goto L36;
        r132 = null;
    L36:
        r106 = (Long) r132;     // Catch: Throwable -> L56
        goto L54
    L38:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Long.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L41;
        r106 = Long.valueOf(((Number) r105).longValue());     // Catch: Throwable -> L56
    L41:
        if ((r105 instanceof JSONObject) == false) goto L43;
    L177:
        Object r133 = SDKSettingsCacheManager.a().fromJson(r105.toString(), Long.class);     // Catch: Throwable -> L49
        if ((r133 instanceof Long) == true) goto L47;
        r133 = null;
    L47:
        Object r134 = Result.m9449constructorimpl((Long) r133);     // Catch: Throwable -> L49
    L51:
        r106 = r134;
        if (Result.m9455isFailureimpl(r106) == false) goto L54;
    L49:
        th = move-exception;
        Result.Companion r135 = Result.Companion;     // Catch: Throwable -> L56
        r134 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L56
        goto L51
    L43:
        if ((r105 instanceof JSONArray) == false) goto L53;
    L13:
        r129 = r105;
    L56:
        th = move-exception;
        Result.Companion r136 = Result.Companion;     // Catch: Throwable -> L166
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
    L166:
        th = move-exception;
        Result.Companion r137 = Result.Companion;
        Object r138 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r139 = Result.m9452exceptionOrNullimpl(r138);
        if (r139 == null) goto L171;
        EnsureManager.ensureNotReachHere(r139);
    L171:
        if (Result.m9455isFailureimpl(r138) == true) goto L174;
        r101 = r138;
    L174:
        r109 = r101;
        goto L176
    }

    @SettingPanel("头图视频容器标准化V1")
    public static final boolean o() {
        int r100 = com.bytedance.android.ec.base.settings.b.f42814a;
        Object r101 = Boolean.FALSE;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L172
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L172
        SDKSettingsCacheManager r103 = SDKSettingsCacheManager.f42812e;     // Catch: Throwable -> L172
        Object r104 = null;
        r103.getClass();     // Catch: Throwable -> L59
        Object r105 = SDKSettingsCacheManager.f42809b.get("iesec_andr_pdp_player_view_refactor");     // Catch: Throwable -> L59
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
        Object r110 = SDKSettingsCacheManager.f42808a.get("iesec_andr_pdp_player_view_refactor");     // Catch: Throwable -> L172
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
        SDKSettingsCacheManager.e("iesec_andr_pdp_player_view_refactor", r109);     // Catch: Throwable -> L172
        goto L182
    L185:
        r113 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("iesec_andr_pdp_player_view_refactor", Boolean.class, r101);     // Catch: Throwable -> L166
    L167:
        if (r113 != null) goto L169;
        r109 = r101;
    L166:
        r113 = r101;
        goto L167
    L191:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L133
        Object r114 = SDKSettingsCacheManager.f42809b.get("iesec_andr_pdp_player_view_refactor");     // Catch: Throwable -> L133
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
        Object r119 = jj4.a.a("iesec_andr_pdp_player_view_refactor", Boolean.class, r101, false);     // Catch: Throwable -> L159
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

    @SettingPanel("商详视频直播声音互斥优化")
    public static final boolean p() {
        Lazy r100 = ECAppInfoService.f48110a;
        return ECAppInfoService.h();
    }

    @SettingPanel("黑灯页购买决策实验")
    public static final int q() {
        int r100 = j.f43647a;
        int r101 = e.f43640a;
        Object r102 = e.a(2, 0);
        int r103 = com.bytedance.android.ec.base.settings.b.f42814a;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L166
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L166
        SDKSettingsCacheManager r105 = SDKSettingsCacheManager.f42812e;     // Catch: Throwable -> L166
        Object r106 = null;
        r105.getClass();     // Catch: Throwable -> L56
        Object r107 = SDKSettingsCacheManager.f42809b.get("iesec_pdp_gallery_buy");     // Catch: Throwable -> L56
        if (r107 != null) goto L11;
    L53:
        Object r108 = null;
    L54:
        Object r109 = Result.m9449constructorimpl(r108);     // Catch: Throwable -> L56
    L58:
        Throwable r110 = Result.m9452exceptionOrNullimpl(r109);     // Catch: Throwable -> L166
        if (r110 == null) goto L62;
        EnsureManager.ensureNotReachHere(r110);     // Catch: Throwable -> L166
    L62:
        if (Result.m9455isFailureimpl(r109) == false) goto L65;
        r109 = null;
    L65:
        if ((r109 instanceof Integer) == true) goto L67;
        r109 = null;
    L67:
        Object r111 = (Integer) r109;     // Catch: Throwable -> L166
        if (r111 != null) goto L74;
        r105.getClass();     // Catch: Throwable -> L166
        Object r112 = SDKSettingsCacheManager.f42808a.get("iesec_pdp_gallery_buy");     // Catch: Throwable -> L166
        if ((r112 instanceof Integer) == true) goto L73;
        r112 = null;
    L73:
        r111 = (Integer) r112;     // Catch: Throwable -> L166
    L74:
        if (r111 != null) goto L176;
        int r113 = com.bytedance.android.ec.base.settings.g.f42821a;     // Catch: Throwable -> L166
    L153:
        th = move-exception;
        Result.Companion r114 = Result.Companion;     // Catch: Throwable -> L166
        Object r115 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
    L155:
        Object r116 = r115;
        if (Result.m9452exceptionOrNullimpl(r116) != null) goto L179;
    L163:
        r111 = r116;
    L164:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L166
        SDKSettingsCacheManager.e("iesec_pdp_gallery_buy", r111);     // Catch: Throwable -> L166
        goto L176
    L179:
        r116 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("iesec_pdp_gallery_buy", Integer.class, r102);     // Catch: Throwable -> L160
    L161:
        if (r116 != null) goto L163;
        r111 = r102;
    L160:
        r116 = r102;
        goto L161
    L185:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L127
        Object r117 = SDKSettingsCacheManager.f42809b.get("iesec_pdp_gallery_buy");     // Catch: Throwable -> L127
        if (r117 != null) goto L82;
    L124:
        Object r118 = null;
    L125:
        Object r119 = Result.m9449constructorimpl(r118);     // Catch: Throwable -> L127
    L129:
        Throwable r120 = Result.m9452exceptionOrNullimpl(r119);     // Catch: Throwable -> L153
        if (r120 == null) goto L133;
        EnsureManager.ensureNotReachHere(r120);     // Catch: Throwable -> L153
    L133:
        if (Result.m9455isFailureimpl(r119) == false) goto L136;
        r119 = null;
    L136:
        if ((r119 instanceof Integer) == true) goto L138;
        r119 = null;
    L138:
        r116 = (Integer) r119;     // Catch: Throwable -> L153
        if (r116 != null) goto L163;
        jj4.b r121 = jj4.b.f499326b;     // Catch: Throwable -> L153
        Object r122 = jj4.a.a("iesec_pdp_gallery_buy", Integer.class, r102, false);     // Catch: Throwable -> L153
        if (r122 != null) goto L145;
        Intrinsics.throwNpe();     // Catch: Throwable -> L153
    L145:
        if ((r122 instanceof Integer) == false) goto L148;
        r106 = r122;
    L148:
        Object r123 = (Integer) r106;     // Catch: Throwable -> L153
        if (r123 != null) goto L151;
        r123 = r102;
    L151:
        r115 = Result.m9449constructorimpl(r123);     // Catch: Throwable -> L153
    L82:
        if ((r117 instanceof Integer) == true) goto L84;
        Object r124 = null;
    L85:
        r118 = (Integer) r124;     // Catch: Throwable -> L127
        if (r118 != null) goto L125;
        if ((r117 instanceof Number) == false) goto L112;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r125 = Float.valueOf(((Number) r117).floatValue());     // Catch: Throwable -> L127
        if ((r125 instanceof Integer) == true) goto L95;
        r125 = null;
    L95:
        r118 = (Integer) r125;     // Catch: Throwable -> L127
        goto L125
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r126 = Double.valueOf(((Number) r117).doubleValue());     // Catch: Throwable -> L127
        if ((r126 instanceof Integer) == true) goto L101;
        r126 = null;
    L101:
        r118 = (Integer) r126;     // Catch: Throwable -> L127
        goto L125
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L106;
        r118 = Integer.valueOf(((Number) r117).intValue());     // Catch: Throwable -> L127
        goto L125
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L112;
        Long r127 = Long.valueOf(((Number) r117).longValue());     // Catch: Throwable -> L127
        if ((r127 instanceof Integer) == true) goto L110;
        r127 = null;
    L110:
        r118 = (Integer) r127;     // Catch: Throwable -> L127
    L112:
        if ((r117 instanceof JSONObject) == false) goto L114;
    L177:
        Object r128 = SDKSettingsCacheManager.a().fromJson(r117.toString(), Integer.class);     // Catch: Throwable -> L120
        if ((r128 instanceof Integer) == true) goto L118;
        r128 = null;
    L118:
        Object r129 = Result.m9449constructorimpl((Integer) r128);     // Catch: Throwable -> L120
    L122:
        r118 = r129;
        if (Result.m9455isFailureimpl(r118) == false) goto L125;
    L120:
        th = move-exception;
        Result.Companion r130 = Result.Companion;     // Catch: Throwable -> L127
        r129 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L127
        goto L122
    L114:
        if ((r117 instanceof JSONArray) == false) goto L124;
    L84:
        r124 = r117;
    L127:
        th = move-exception;
        Result.Companion r131 = Result.Companion;     // Catch: Throwable -> L153
        r119 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L153
    L176:
        return ((Number) r111).intValue();
    L11:
        if ((r107 instanceof Integer) == true) goto L13;
        Object r132 = null;
    L14:
        r108 = (Integer) r132;     // Catch: Throwable -> L56
        if (r108 != null) goto L54;
        if ((r107 instanceof Number) == false) goto L41;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r133 = Float.valueOf(((Number) r107).floatValue());     // Catch: Throwable -> L56
        if ((r133 instanceof Integer) == true) goto L24;
        r133 = null;
    L24:
        r108 = (Integer) r133;     // Catch: Throwable -> L56
        goto L54
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r134 = Double.valueOf(((Number) r107).doubleValue());     // Catch: Throwable -> L56
        if ((r134 instanceof Integer) == true) goto L30;
        r134 = null;
    L30:
        r108 = (Integer) r134;     // Catch: Throwable -> L56
        goto L54
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L35;
        r108 = Integer.valueOf(((Number) r107).intValue());     // Catch: Throwable -> L56
        goto L54
    L35:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L41;
        Long r135 = Long.valueOf(((Number) r107).longValue());     // Catch: Throwable -> L56
        if ((r135 instanceof Integer) == true) goto L39;
        r135 = null;
    L39:
        r108 = (Integer) r135;     // Catch: Throwable -> L56
    L41:
        if ((r107 instanceof JSONObject) == false) goto L43;
    L189:
        Object r136 = SDKSettingsCacheManager.a().fromJson(r107.toString(), Integer.class);     // Catch: Throwable -> L49
        if ((r136 instanceof Integer) == true) goto L47;
        r136 = null;
    L47:
        Object r137 = Result.m9449constructorimpl((Integer) r136);     // Catch: Throwable -> L49
    L51:
        r108 = r137;
        if (Result.m9455isFailureimpl(r108) == false) goto L54;
    L49:
        th = move-exception;
        Result.Companion r138 = Result.Companion;     // Catch: Throwable -> L56
        r137 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L56
        goto L51
    L43:
        if ((r107 instanceof JSONArray) == false) goto L53;
    L13:
        r132 = r107;
    L56:
        th = move-exception;
        Result.Companion r139 = Result.Companion;     // Catch: Throwable -> L166
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
    L166:
        th = move-exception;
        Result.Companion r140 = Result.Companion;
        Object r141 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r142 = Result.m9452exceptionOrNullimpl(r141);
        if (r142 == null) goto L171;
        EnsureManager.ensureNotReachHere(r142);
    L171:
        if (Result.m9455isFailureimpl(r141) == true) goto L174;
        r102 = r141;
    L174:
        r111 = r102;
        goto L176
    }

    @SettingPanel("商详头图测评视频预加载-已固化")
    public static final int r() {
        int r100 = j.f43647a;
        int r101 = e.f43640a;
        Object r102 = e.a(1, 0);
        int r103 = com.bytedance.android.ec.base.settings.b.f42814a;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L166
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L166
        SDKSettingsCacheManager r105 = SDKSettingsCacheManager.f42812e;     // Catch: Throwable -> L166
        Object r106 = null;
        r105.getClass();     // Catch: Throwable -> L56
        Object r107 = SDKSettingsCacheManager.f42809b.get("iesec_ecom_pdp_kol_preload");     // Catch: Throwable -> L56
        if (r107 != null) goto L11;
    L53:
        Object r108 = null;
    L54:
        Object r109 = Result.m9449constructorimpl(r108);     // Catch: Throwable -> L56
    L58:
        Throwable r110 = Result.m9452exceptionOrNullimpl(r109);     // Catch: Throwable -> L166
        if (r110 == null) goto L62;
        EnsureManager.ensureNotReachHere(r110);     // Catch: Throwable -> L166
    L62:
        if (Result.m9455isFailureimpl(r109) == false) goto L65;
        r109 = null;
    L65:
        if ((r109 instanceof Integer) == true) goto L67;
        r109 = null;
    L67:
        Object r111 = (Integer) r109;     // Catch: Throwable -> L166
        if (r111 != null) goto L74;
        r105.getClass();     // Catch: Throwable -> L166
        Object r112 = SDKSettingsCacheManager.f42808a.get("iesec_ecom_pdp_kol_preload");     // Catch: Throwable -> L166
        if ((r112 instanceof Integer) == true) goto L73;
        r112 = null;
    L73:
        r111 = (Integer) r112;     // Catch: Throwable -> L166
    L74:
        if (r111 != null) goto L176;
        int r113 = com.bytedance.android.ec.base.settings.g.f42821a;     // Catch: Throwable -> L166
    L153:
        th = move-exception;
        Result.Companion r114 = Result.Companion;     // Catch: Throwable -> L166
        Object r115 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
    L155:
        Object r116 = r115;
        if (Result.m9452exceptionOrNullimpl(r116) != null) goto L179;
    L163:
        r111 = r116;
    L164:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L166
        SDKSettingsCacheManager.e("iesec_ecom_pdp_kol_preload", r111);     // Catch: Throwable -> L166
        goto L176
    L179:
        r116 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("iesec_ecom_pdp_kol_preload", Integer.class, r102);     // Catch: Throwable -> L160
    L161:
        if (r116 != null) goto L163;
        r111 = r102;
    L160:
        r116 = r102;
        goto L161
    L185:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L127
        Object r117 = SDKSettingsCacheManager.f42809b.get("iesec_ecom_pdp_kol_preload");     // Catch: Throwable -> L127
        if (r117 != null) goto L82;
    L124:
        Object r118 = null;
    L125:
        Object r119 = Result.m9449constructorimpl(r118);     // Catch: Throwable -> L127
    L129:
        Throwable r120 = Result.m9452exceptionOrNullimpl(r119);     // Catch: Throwable -> L153
        if (r120 == null) goto L133;
        EnsureManager.ensureNotReachHere(r120);     // Catch: Throwable -> L153
    L133:
        if (Result.m9455isFailureimpl(r119) == false) goto L136;
        r119 = null;
    L136:
        if ((r119 instanceof Integer) == true) goto L138;
        r119 = null;
    L138:
        r116 = (Integer) r119;     // Catch: Throwable -> L153
        if (r116 != null) goto L163;
        jj4.b r121 = jj4.b.f499326b;     // Catch: Throwable -> L153
        Object r122 = jj4.a.a("iesec_ecom_pdp_kol_preload", Integer.class, r102, false);     // Catch: Throwable -> L153
        if (r122 != null) goto L145;
        Intrinsics.throwNpe();     // Catch: Throwable -> L153
    L145:
        if ((r122 instanceof Integer) == false) goto L148;
        r106 = r122;
    L148:
        Object r123 = (Integer) r106;     // Catch: Throwable -> L153
        if (r123 != null) goto L151;
        r123 = r102;
    L151:
        r115 = Result.m9449constructorimpl(r123);     // Catch: Throwable -> L153
    L82:
        if ((r117 instanceof Integer) == true) goto L84;
        Object r124 = null;
    L85:
        r118 = (Integer) r124;     // Catch: Throwable -> L127
        if (r118 != null) goto L125;
        if ((r117 instanceof Number) == false) goto L112;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r125 = Float.valueOf(((Number) r117).floatValue());     // Catch: Throwable -> L127
        if ((r125 instanceof Integer) == true) goto L95;
        r125 = null;
    L95:
        r118 = (Integer) r125;     // Catch: Throwable -> L127
        goto L125
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r126 = Double.valueOf(((Number) r117).doubleValue());     // Catch: Throwable -> L127
        if ((r126 instanceof Integer) == true) goto L101;
        r126 = null;
    L101:
        r118 = (Integer) r126;     // Catch: Throwable -> L127
        goto L125
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L106;
        r118 = Integer.valueOf(((Number) r117).intValue());     // Catch: Throwable -> L127
        goto L125
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L112;
        Long r127 = Long.valueOf(((Number) r117).longValue());     // Catch: Throwable -> L127
        if ((r127 instanceof Integer) == true) goto L110;
        r127 = null;
    L110:
        r118 = (Integer) r127;     // Catch: Throwable -> L127
    L112:
        if ((r117 instanceof JSONObject) == false) goto L114;
    L177:
        Object r128 = SDKSettingsCacheManager.a().fromJson(r117.toString(), Integer.class);     // Catch: Throwable -> L120
        if ((r128 instanceof Integer) == true) goto L118;
        r128 = null;
    L118:
        Object r129 = Result.m9449constructorimpl((Integer) r128);     // Catch: Throwable -> L120
    L122:
        r118 = r129;
        if (Result.m9455isFailureimpl(r118) == false) goto L125;
    L120:
        th = move-exception;
        Result.Companion r130 = Result.Companion;     // Catch: Throwable -> L127
        r129 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L127
        goto L122
    L114:
        if ((r117 instanceof JSONArray) == false) goto L124;
    L84:
        r124 = r117;
    L127:
        th = move-exception;
        Result.Companion r131 = Result.Companion;     // Catch: Throwable -> L153
        r119 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L153
    L176:
        return ((Number) r111).intValue();
    L11:
        if ((r107 instanceof Integer) == true) goto L13;
        Object r132 = null;
    L14:
        r108 = (Integer) r132;     // Catch: Throwable -> L56
        if (r108 != null) goto L54;
        if ((r107 instanceof Number) == false) goto L41;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r133 = Float.valueOf(((Number) r107).floatValue());     // Catch: Throwable -> L56
        if ((r133 instanceof Integer) == true) goto L24;
        r133 = null;
    L24:
        r108 = (Integer) r133;     // Catch: Throwable -> L56
        goto L54
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r134 = Double.valueOf(((Number) r107).doubleValue());     // Catch: Throwable -> L56
        if ((r134 instanceof Integer) == true) goto L30;
        r134 = null;
    L30:
        r108 = (Integer) r134;     // Catch: Throwable -> L56
        goto L54
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L35;
        r108 = Integer.valueOf(((Number) r107).intValue());     // Catch: Throwable -> L56
        goto L54
    L35:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L41;
        Long r135 = Long.valueOf(((Number) r107).longValue());     // Catch: Throwable -> L56
        if ((r135 instanceof Integer) == true) goto L39;
        r135 = null;
    L39:
        r108 = (Integer) r135;     // Catch: Throwable -> L56
    L41:
        if ((r107 instanceof JSONObject) == false) goto L43;
    L189:
        Object r136 = SDKSettingsCacheManager.a().fromJson(r107.toString(), Integer.class);     // Catch: Throwable -> L49
        if ((r136 instanceof Integer) == true) goto L47;
        r136 = null;
    L47:
        Object r137 = Result.m9449constructorimpl((Integer) r136);     // Catch: Throwable -> L49
    L51:
        r108 = r137;
        if (Result.m9455isFailureimpl(r108) == false) goto L54;
    L49:
        th = move-exception;
        Result.Companion r138 = Result.Companion;     // Catch: Throwable -> L56
        r137 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L56
        goto L51
    L43:
        if ((r107 instanceof JSONArray) == false) goto L53;
    L13:
        r132 = r107;
    L56:
        th = move-exception;
        Result.Companion r139 = Result.Companion;     // Catch: Throwable -> L166
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
    L166:
        th = move-exception;
        Result.Companion r140 = Result.Companion;
        Object r141 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r142 = Result.m9452exceptionOrNullimpl(r141);
        if (r142 == null) goto L171;
        EnsureManager.ensureNotReachHere(r142);
    L171:
        if (Result.m9455isFailureimpl(r141) == true) goto L174;
        r102 = r141;
    L174:
        r111 = r102;
        goto L176
    }

    @SettingPanel("商详网络错误码相关配置")
    public static Map s() {
        int r100 = com.bytedance.android.ec.base.settings.b.f42814a;
        Object r101 = new HashMap();
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L172
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L172
        SDKSettingsCacheManager r103 = SDKSettingsCacheManager.f42812e;     // Catch: Throwable -> L172
        Object r104 = null;
        r103.getClass();     // Catch: Throwable -> L59
        Object r105 = SDKSettingsCacheManager.f42809b.get("iesec_pdp_network_error_code_config_map");     // Catch: Throwable -> L59
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
        if ((r107 instanceof HashMap) == true) goto L70;
        r107 = null;
    L70:
        Object r109 = (HashMap) r107;     // Catch: Throwable -> L172
        if (r109 != null) goto L77;
        r103.getClass();     // Catch: Throwable -> L172
        Object r110 = SDKSettingsCacheManager.f42808a.get("iesec_pdp_network_error_code_config_map");     // Catch: Throwable -> L172
        if ((r110 instanceof HashMap) == true) goto L76;
        r110 = null;
    L76:
        r109 = (HashMap) r110;     // Catch: Throwable -> L172
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
        SDKSettingsCacheManager.e("iesec_pdp_network_error_code_config_map", r109);     // Catch: Throwable -> L172
        goto L182
    L185:
        r113 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("iesec_pdp_network_error_code_config_map", HashMap.class, r101);     // Catch: Throwable -> L166
    L167:
        if (r113 != null) goto L169;
        r109 = r101;
    L166:
        r113 = r101;
        goto L167
    L191:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L133
        Object r114 = SDKSettingsCacheManager.f42809b.get("iesec_pdp_network_error_code_config_map");     // Catch: Throwable -> L133
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
        if ((r116 instanceof HashMap) == true) goto L144;
        r116 = null;
    L144:
        r113 = (HashMap) r116;     // Catch: Throwable -> L159
        if (r113 != null) goto L169;
        jj4.b r118 = jj4.b.f499326b;     // Catch: Throwable -> L159
        Object r119 = jj4.a.a("iesec_pdp_network_error_code_config_map", HashMap.class, r101, false);     // Catch: Throwable -> L159
        if (r119 != null) goto L151;
        Intrinsics.throwNpe();     // Catch: Throwable -> L159
    L151:
        if ((r119 instanceof HashMap) == false) goto L154;
        r104 = r119;
    L154:
        Object r120 = (HashMap) r104;     // Catch: Throwable -> L159
        if (r120 != null) goto L157;
        r120 = r101;
    L157:
        r113 = Result.m9449constructorimpl(r120);     // Catch: Throwable -> L159
    L85:
        if ((r114 instanceof HashMap) == true) goto L87;
        Object r121 = null;
    L88:
        r115 = (HashMap) r121;     // Catch: Throwable -> L133
        if (r115 != null) goto L131;
        if ((r114 instanceof Number) == false) goto L118;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(HashMap.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L100;
        Float r122 = Float.valueOf(((Number) r114).floatValue());     // Catch: Throwable -> L133
        if ((r122 instanceof HashMap) == true) goto L98;
        r122 = null;
    L98:
        r115 = (HashMap) r122;     // Catch: Throwable -> L133
        goto L131
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(HashMap.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L106;
        Double r123 = Double.valueOf(((Number) r114).doubleValue());     // Catch: Throwable -> L133
        if ((r123 instanceof HashMap) == true) goto L104;
        r123 = null;
    L104:
        r115 = (HashMap) r123;     // Catch: Throwable -> L133
        goto L131
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(HashMap.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L112;
        Integer r124 = Integer.valueOf(((Number) r114).intValue());     // Catch: Throwable -> L133
        if ((r124 instanceof HashMap) == true) goto L110;
        r124 = null;
    L110:
        r115 = (HashMap) r124;     // Catch: Throwable -> L133
        goto L131
    L112:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(HashMap.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L118;
        Long r125 = Long.valueOf(((Number) r114).longValue());     // Catch: Throwable -> L133
        if ((r125 instanceof HashMap) == true) goto L116;
        r125 = null;
    L116:
        r115 = (HashMap) r125;     // Catch: Throwable -> L133
    L118:
        if ((r114 instanceof JSONObject) == false) goto L120;
    L183:
        Object r126 = SDKSettingsCacheManager.a().fromJson(r114.toString(), HashMap.class);     // Catch: Throwable -> L126
        if ((r126 instanceof HashMap) == true) goto L124;
        r126 = null;
    L124:
        Object r127 = Result.m9449constructorimpl((HashMap) r126);     // Catch: Throwable -> L126
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
        return (Map) r109;
    L11:
        if ((r105 instanceof HashMap) == true) goto L13;
        Object r130 = null;
    L14:
        r106 = (HashMap) r130;     // Catch: Throwable -> L59
        if (r106 != null) goto L57;
        if ((r105 instanceof Number) == false) goto L44;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(HashMap.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r131 = Float.valueOf(((Number) r105).floatValue());     // Catch: Throwable -> L59
        if ((r131 instanceof HashMap) == true) goto L24;
        r131 = null;
    L24:
        r106 = (HashMap) r131;     // Catch: Throwable -> L59
        goto L57
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(HashMap.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r132 = Double.valueOf(((Number) r105).doubleValue());     // Catch: Throwable -> L59
        if ((r132 instanceof HashMap) == true) goto L30;
        r132 = null;
    L30:
        r106 = (HashMap) r132;     // Catch: Throwable -> L59
        goto L57
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(HashMap.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L38;
        Integer r133 = Integer.valueOf(((Number) r105).intValue());     // Catch: Throwable -> L59
        if ((r133 instanceof HashMap) == true) goto L36;
        r133 = null;
    L36:
        r106 = (HashMap) r133;     // Catch: Throwable -> L59
        goto L57
    L38:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(HashMap.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L44;
        Long r134 = Long.valueOf(((Number) r105).longValue());     // Catch: Throwable -> L59
        if ((r134 instanceof HashMap) == true) goto L42;
        r134 = null;
    L42:
        r106 = (HashMap) r134;     // Catch: Throwable -> L59
    L44:
        if ((r105 instanceof JSONObject) == false) goto L46;
    L189:
        Object r135 = SDKSettingsCacheManager.a().fromJson(r105.toString(), HashMap.class);     // Catch: Throwable -> L52
        if ((r135 instanceof HashMap) == true) goto L50;
        r135 = null;
    L50:
        Object r136 = Result.m9449constructorimpl((HashMap) r135);     // Catch: Throwable -> L52
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

    public static final int t() {
        int r100 = j.f43647a;
        Object r101 = 0;
        int r102 = com.bytedance.android.ec.base.settings.b.f42814a;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L166
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L166
        SDKSettingsCacheManager r104 = SDKSettingsCacheManager.f42812e;     // Catch: Throwable -> L166
        Object r105 = null;
        r104.getClass();     // Catch: Throwable -> L56
        Object r106 = SDKSettingsCacheManager.f42809b.get("iesec_ecom_pdp_update_exp");     // Catch: Throwable -> L56
        if (r106 != null) goto L11;
    L53:
        Object r107 = null;
    L54:
        Object r108 = Result.m9449constructorimpl(r107);     // Catch: Throwable -> L56
    L58:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);     // Catch: Throwable -> L166
        if (r109 == null) goto L62;
        EnsureManager.ensureNotReachHere(r109);     // Catch: Throwable -> L166
    L62:
        if (Result.m9455isFailureimpl(r108) == false) goto L65;
        r108 = null;
    L65:
        if ((r108 instanceof Integer) == true) goto L67;
        r108 = null;
    L67:
        Object r110 = (Integer) r108;     // Catch: Throwable -> L166
        if (r110 != null) goto L74;
        r104.getClass();     // Catch: Throwable -> L166
        Object r111 = SDKSettingsCacheManager.f42808a.get("iesec_ecom_pdp_update_exp");     // Catch: Throwable -> L166
        if ((r111 instanceof Integer) == true) goto L73;
        r111 = null;
    L73:
        r110 = (Integer) r111;     // Catch: Throwable -> L166
    L74:
        if (r110 != null) goto L176;
        int r112 = com.bytedance.android.ec.base.settings.g.f42821a;     // Catch: Throwable -> L166
    L153:
        th = move-exception;
        Result.Companion r113 = Result.Companion;     // Catch: Throwable -> L166
        Object r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
    L156:
        if (Result.m9452exceptionOrNullimpl(r114) != null) goto L183;
    L163:
        r110 = r114;
    L164:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L166
        SDKSettingsCacheManager.e("iesec_ecom_pdp_update_exp", r110);     // Catch: Throwable -> L166
        goto L176
    L183:
        r114 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("iesec_ecom_pdp_update_exp", Integer.class, r101);     // Catch: Throwable -> L160
    L161:
        if (r114 != null) goto L163;
        r110 = r101;
    L160:
        r114 = r101;
        goto L161
    L189:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L127
        Object r115 = SDKSettingsCacheManager.f42809b.get("iesec_ecom_pdp_update_exp");     // Catch: Throwable -> L127
        if (r115 != null) goto L82;
    L124:
        Object r116 = null;
    L125:
        Object r117 = Result.m9449constructorimpl(r116);     // Catch: Throwable -> L127
    L129:
        Throwable r118 = Result.m9452exceptionOrNullimpl(r117);     // Catch: Throwable -> L153
        if (r118 == null) goto L133;
        EnsureManager.ensureNotReachHere(r118);     // Catch: Throwable -> L153
    L133:
        if (Result.m9455isFailureimpl(r117) == false) goto L136;
        r117 = null;
    L136:
        if ((r117 instanceof Integer) == true) goto L138;
        r117 = null;
    L138:
        Integer r119 = (Integer) r117;     // Catch: Throwable -> L153
        if (r119 == null) goto L141;
        r110 = r119;
        goto L164
    L141:
        jj4.b r120 = jj4.b.f499326b;     // Catch: Throwable -> L153
        Object r121 = jj4.a.a("iesec_ecom_pdp_update_exp", Integer.class, r101, false);     // Catch: Throwable -> L153
        if (r121 != null) goto L145;
        Intrinsics.throwNpe();     // Catch: Throwable -> L153
    L145:
        if ((r121 instanceof Integer) == false) goto L148;
        r105 = r121;
    L148:
        Object r122 = (Integer) r105;     // Catch: Throwable -> L153
        if (r122 != null) goto L151;
        r122 = r101;
    L151:
        r114 = Result.m9449constructorimpl(r122);     // Catch: Throwable -> L153
    L82:
        if ((r115 instanceof Integer) == true) goto L84;
        Object r123 = null;
    L85:
        r116 = (Integer) r123;     // Catch: Throwable -> L127
        if (r116 != null) goto L125;
        if ((r115 instanceof Number) == false) goto L112;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r124 = Float.valueOf(((Number) r115).floatValue());     // Catch: Throwable -> L127
        if ((r124 instanceof Integer) == true) goto L95;
        r124 = null;
    L95:
        r116 = (Integer) r124;     // Catch: Throwable -> L127
        goto L125
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r125 = Double.valueOf(((Number) r115).doubleValue());     // Catch: Throwable -> L127
        if ((r125 instanceof Integer) == true) goto L101;
        r125 = null;
    L101:
        r116 = (Integer) r125;     // Catch: Throwable -> L127
        goto L125
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L106;
        r116 = Integer.valueOf(((Number) r115).intValue());     // Catch: Throwable -> L127
        goto L125
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L112;
        Long r126 = Long.valueOf(((Number) r115).longValue());     // Catch: Throwable -> L127
        if ((r126 instanceof Integer) == true) goto L110;
        r126 = null;
    L110:
        r116 = (Integer) r126;     // Catch: Throwable -> L127
    L112:
        if ((r115 instanceof JSONObject) == false) goto L114;
    L181:
        Object r127 = SDKSettingsCacheManager.a().fromJson(r115.toString(), Integer.class);     // Catch: Throwable -> L120
        if ((r127 instanceof Integer) == true) goto L118;
        r127 = null;
    L118:
        Object r128 = Result.m9449constructorimpl((Integer) r127);     // Catch: Throwable -> L120
    L122:
        r116 = r128;
        if (Result.m9455isFailureimpl(r116) == false) goto L125;
    L120:
        th = move-exception;
        Result.Companion r129 = Result.Companion;     // Catch: Throwable -> L127
        r128 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L127
        goto L122
    L114:
        if ((r115 instanceof JSONArray) == false) goto L124;
    L84:
        r123 = r115;
    L127:
        th = move-exception;
        Result.Companion r130 = Result.Companion;     // Catch: Throwable -> L153
        r117 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L153
    L176:
        return ((Number) r110).intValue();
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
    L179:
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
        Result.Companion r138 = Result.Companion;     // Catch: Throwable -> L166
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
    L166:
        th = move-exception;
        Result.Companion r139 = Result.Companion;
        Object r140 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r141 = Result.m9452exceptionOrNullimpl(r140);
        if (r141 == null) goto L171;
        EnsureManager.ensureNotReachHere(r141);
    L171:
        if (Result.m9455isFailureimpl(r140) == true) goto L174;
        r101 = r140;
    L174:
        r110 = r101;
        goto L176
    }

    public static final int u() {
        int r100 = j.f43647a;
        Object r101 = 0;
        int r102 = com.bytedance.android.ec.base.settings.b.f42814a;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L166
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L166
        SDKSettingsCacheManager r104 = SDKSettingsCacheManager.f42812e;     // Catch: Throwable -> L166
        Object r105 = null;
        r104.getClass();     // Catch: Throwable -> L56
        Object r106 = SDKSettingsCacheManager.f42809b.get("iesec_pdp_fit_width");     // Catch: Throwable -> L56
        if (r106 != null) goto L11;
    L53:
        Object r107 = null;
    L54:
        Object r108 = Result.m9449constructorimpl(r107);     // Catch: Throwable -> L56
    L58:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);     // Catch: Throwable -> L166
        if (r109 == null) goto L62;
        EnsureManager.ensureNotReachHere(r109);     // Catch: Throwable -> L166
    L62:
        if (Result.m9455isFailureimpl(r108) == false) goto L65;
        r108 = null;
    L65:
        if ((r108 instanceof Integer) == true) goto L67;
        r108 = null;
    L67:
        Object r110 = (Integer) r108;     // Catch: Throwable -> L166
        if (r110 != null) goto L74;
        r104.getClass();     // Catch: Throwable -> L166
        Object r111 = SDKSettingsCacheManager.f42808a.get("iesec_pdp_fit_width");     // Catch: Throwable -> L166
        if ((r111 instanceof Integer) == true) goto L73;
        r111 = null;
    L73:
        r110 = (Integer) r111;     // Catch: Throwable -> L166
    L74:
        if (r110 != null) goto L176;
        int r112 = com.bytedance.android.ec.base.settings.g.f42821a;     // Catch: Throwable -> L166
    L153:
        th = move-exception;
        Result.Companion r113 = Result.Companion;     // Catch: Throwable -> L166
        Object r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
    L156:
        if (Result.m9452exceptionOrNullimpl(r114) != null) goto L183;
    L163:
        r110 = r114;
    L164:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L166
        SDKSettingsCacheManager.e("iesec_pdp_fit_width", r110);     // Catch: Throwable -> L166
        goto L176
    L183:
        r114 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("iesec_pdp_fit_width", Integer.class, r101);     // Catch: Throwable -> L160
    L161:
        if (r114 != null) goto L163;
        r110 = r101;
    L160:
        r114 = r101;
        goto L161
    L189:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L127
        Object r115 = SDKSettingsCacheManager.f42809b.get("iesec_pdp_fit_width");     // Catch: Throwable -> L127
        if (r115 != null) goto L82;
    L124:
        Object r116 = null;
    L125:
        Object r117 = Result.m9449constructorimpl(r116);     // Catch: Throwable -> L127
    L129:
        Throwable r118 = Result.m9452exceptionOrNullimpl(r117);     // Catch: Throwable -> L153
        if (r118 == null) goto L133;
        EnsureManager.ensureNotReachHere(r118);     // Catch: Throwable -> L153
    L133:
        if (Result.m9455isFailureimpl(r117) == false) goto L136;
        r117 = null;
    L136:
        if ((r117 instanceof Integer) == true) goto L138;
        r117 = null;
    L138:
        Integer r119 = (Integer) r117;     // Catch: Throwable -> L153
        if (r119 == null) goto L141;
        r110 = r119;
        goto L164
    L141:
        jj4.b r120 = jj4.b.f499326b;     // Catch: Throwable -> L153
        Object r121 = jj4.a.a("iesec_pdp_fit_width", Integer.class, r101, false);     // Catch: Throwable -> L153
        if (r121 != null) goto L145;
        Intrinsics.throwNpe();     // Catch: Throwable -> L153
    L145:
        if ((r121 instanceof Integer) == false) goto L148;
        r105 = r121;
    L148:
        Object r122 = (Integer) r105;     // Catch: Throwable -> L153
        if (r122 != null) goto L151;
        r122 = r101;
    L151:
        r114 = Result.m9449constructorimpl(r122);     // Catch: Throwable -> L153
    L82:
        if ((r115 instanceof Integer) == true) goto L84;
        Object r123 = null;
    L85:
        r116 = (Integer) r123;     // Catch: Throwable -> L127
        if (r116 != null) goto L125;
        if ((r115 instanceof Number) == false) goto L112;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r124 = Float.valueOf(((Number) r115).floatValue());     // Catch: Throwable -> L127
        if ((r124 instanceof Integer) == true) goto L95;
        r124 = null;
    L95:
        r116 = (Integer) r124;     // Catch: Throwable -> L127
        goto L125
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r125 = Double.valueOf(((Number) r115).doubleValue());     // Catch: Throwable -> L127
        if ((r125 instanceof Integer) == true) goto L101;
        r125 = null;
    L101:
        r116 = (Integer) r125;     // Catch: Throwable -> L127
        goto L125
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L106;
        r116 = Integer.valueOf(((Number) r115).intValue());     // Catch: Throwable -> L127
        goto L125
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L112;
        Long r126 = Long.valueOf(((Number) r115).longValue());     // Catch: Throwable -> L127
        if ((r126 instanceof Integer) == true) goto L110;
        r126 = null;
    L110:
        r116 = (Integer) r126;     // Catch: Throwable -> L127
    L112:
        if ((r115 instanceof JSONObject) == false) goto L114;
    L181:
        Object r127 = SDKSettingsCacheManager.a().fromJson(r115.toString(), Integer.class);     // Catch: Throwable -> L120
        if ((r127 instanceof Integer) == true) goto L118;
        r127 = null;
    L118:
        Object r128 = Result.m9449constructorimpl((Integer) r127);     // Catch: Throwable -> L120
    L122:
        r116 = r128;
        if (Result.m9455isFailureimpl(r116) == false) goto L125;
    L120:
        th = move-exception;
        Result.Companion r129 = Result.Companion;     // Catch: Throwable -> L127
        r128 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L127
        goto L122
    L114:
        if ((r115 instanceof JSONArray) == false) goto L124;
    L84:
        r123 = r115;
    L127:
        th = move-exception;
        Result.Companion r130 = Result.Companion;     // Catch: Throwable -> L153
        r117 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L153
    L176:
        return ((Number) r110).intValue();
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
    L179:
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
        Result.Companion r138 = Result.Companion;     // Catch: Throwable -> L166
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
    L166:
        th = move-exception;
        Result.Companion r139 = Result.Companion;
        Object r140 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r141 = Result.m9452exceptionOrNullimpl(r140);
        if (r141 == null) goto L171;
        EnsureManager.ensureNotReachHere(r141);
    L171:
        if (Result.m9455isFailureimpl(r140) == true) goto L174;
        r101 = r140;
    L174:
        r110 = r101;
        goto L176
    }

    @SettingPanel("不出重试按钮的code名单，比如限流Code 7180")
    public static final List<Double> v() {
        jj4.b r100 = jj4.b.f499326b;
        Object r101 = jj4.a.a("iesec_pdp_not_retry_status_code_list", List.class, new ArrayList(), false);
        if (r101 != null) goto L6;
        Intrinsics.throwNpe();
    L6:
        return (List) r101;
    }

    @SettingPanel("商详播放器交互动态化")
    public static final boolean w() {
        int r100 = com.bytedance.android.ec.base.settings.b.f42814a;
        Object r101 = Boolean.FALSE;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L172
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L172
        SDKSettingsCacheManager r103 = SDKSettingsCacheManager.f42812e;     // Catch: Throwable -> L172
        Object r104 = null;
        r103.getClass();     // Catch: Throwable -> L59
        Object r105 = SDKSettingsCacheManager.f42809b.get("iesec_pdp_player_dynamic_interactor");     // Catch: Throwable -> L59
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
        Object r110 = SDKSettingsCacheManager.f42808a.get("iesec_pdp_player_dynamic_interactor");     // Catch: Throwable -> L172
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
        SDKSettingsCacheManager.e("iesec_pdp_player_dynamic_interactor", r109);     // Catch: Throwable -> L172
        goto L182
    L185:
        r113 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("iesec_pdp_player_dynamic_interactor", Boolean.class, r101);     // Catch: Throwable -> L166
    L167:
        if (r113 != null) goto L169;
        r109 = r101;
    L166:
        r113 = r101;
        goto L167
    L191:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L133
        Object r114 = SDKSettingsCacheManager.f42809b.get("iesec_pdp_player_dynamic_interactor");     // Catch: Throwable -> L133
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
        Object r119 = jj4.a.a("iesec_pdp_player_dynamic_interactor", Boolean.class, r101, false);     // Catch: Throwable -> L159
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

    @SettingPanel("商详刷新全量使用chunk接口")
    public static final boolean x() {
        int r100 = j.f43647a;
        Object r101 = Boolean.FALSE;
        int r102 = com.bytedance.android.ec.base.settings.b.f42814a;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L172
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L172
        SDKSettingsCacheManager r104 = SDKSettingsCacheManager.f42812e;     // Catch: Throwable -> L172
        Object r105 = null;
        r104.getClass();     // Catch: Throwable -> L59
        Object r106 = SDKSettingsCacheManager.f42809b.get("detail_refresh_use_chunk");     // Catch: Throwable -> L59
        if (r106 != null) goto L11;
    L56:
        Object r107 = null;
    L57:
        Object r108 = Result.m9449constructorimpl(r107);     // Catch: Throwable -> L59
    L61:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);     // Catch: Throwable -> L172
        if (r109 == null) goto L65;
        EnsureManager.ensureNotReachHere(r109);     // Catch: Throwable -> L172
    L65:
        if (Result.m9455isFailureimpl(r108) == false) goto L68;
        r108 = null;
    L68:
        if ((r108 instanceof Boolean) == true) goto L70;
        r108 = null;
    L70:
        Object r110 = (Boolean) r108;     // Catch: Throwable -> L172
        if (r110 != null) goto L77;
        r104.getClass();     // Catch: Throwable -> L172
        Object r111 = SDKSettingsCacheManager.f42808a.get("detail_refresh_use_chunk");     // Catch: Throwable -> L172
        if ((r111 instanceof Boolean) == true) goto L76;
        r111 = null;
    L76:
        r110 = (Boolean) r111;     // Catch: Throwable -> L172
    L77:
        if (r110 != null) goto L182;
        int r112 = com.bytedance.android.ec.base.settings.g.f42821a;     // Catch: Throwable -> L172
    L159:
        th = move-exception;
        Result.Companion r113 = Result.Companion;     // Catch: Throwable -> L172
        Object r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L172
    L162:
        if (Result.m9452exceptionOrNullimpl(r114) != null) goto L185;
    L169:
        r110 = r114;
    L170:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L172
        SDKSettingsCacheManager.e("detail_refresh_use_chunk", r110);     // Catch: Throwable -> L172
        goto L182
    L185:
        r114 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("detail_refresh_use_chunk", Boolean.class, r101);     // Catch: Throwable -> L166
    L167:
        if (r114 != null) goto L169;
        r110 = r101;
    L166:
        r114 = r101;
        goto L167
    L191:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L133
        Object r115 = SDKSettingsCacheManager.f42809b.get("detail_refresh_use_chunk");     // Catch: Throwable -> L133
        if (r115 != null) goto L85;
    L130:
        Object r116 = null;
    L131:
        Object r117 = Result.m9449constructorimpl(r116);     // Catch: Throwable -> L133
    L135:
        Throwable r118 = Result.m9452exceptionOrNullimpl(r117);     // Catch: Throwable -> L159
        if (r118 == null) goto L139;
        EnsureManager.ensureNotReachHere(r118);     // Catch: Throwable -> L159
    L139:
        if (Result.m9455isFailureimpl(r117) == false) goto L142;
        r117 = null;
    L142:
        if ((r117 instanceof Boolean) == true) goto L144;
        r117 = null;
    L144:
        r114 = (Boolean) r117;     // Catch: Throwable -> L159
        if (r114 != null) goto L169;
        jj4.b r119 = jj4.b.f499326b;     // Catch: Throwable -> L159
        Object r120 = jj4.a.a("detail_refresh_use_chunk", Boolean.class, r101, false);     // Catch: Throwable -> L159
        if (r120 != null) goto L151;
        Intrinsics.throwNpe();     // Catch: Throwable -> L159
    L151:
        if ((r120 instanceof Boolean) == false) goto L154;
        r105 = r120;
    L154:
        Object r121 = (Boolean) r105;     // Catch: Throwable -> L159
        if (r121 != null) goto L157;
        r121 = r101;
    L157:
        r114 = Result.m9449constructorimpl(r121);     // Catch: Throwable -> L159
    L85:
        if ((r115 instanceof Boolean) == true) goto L87;
        Object r122 = null;
    L88:
        r116 = (Boolean) r122;     // Catch: Throwable -> L133
        if (r116 != null) goto L131;
        if ((r115 instanceof Number) == false) goto L118;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L100;
        Float r123 = Float.valueOf(((Number) r115).floatValue());     // Catch: Throwable -> L133
        if ((r123 instanceof Boolean) == true) goto L98;
        r123 = null;
    L98:
        r116 = (Boolean) r123;     // Catch: Throwable -> L133
        goto L131
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L106;
        Double r124 = Double.valueOf(((Number) r115).doubleValue());     // Catch: Throwable -> L133
        if ((r124 instanceof Boolean) == true) goto L104;
        r124 = null;
    L104:
        r116 = (Boolean) r124;     // Catch: Throwable -> L133
        goto L131
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L112;
        Integer r125 = Integer.valueOf(((Number) r115).intValue());     // Catch: Throwable -> L133
        if ((r125 instanceof Boolean) == true) goto L110;
        r125 = null;
    L110:
        r116 = (Boolean) r125;     // Catch: Throwable -> L133
        goto L131
    L112:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L118;
        Long r126 = Long.valueOf(((Number) r115).longValue());     // Catch: Throwable -> L133
        if ((r126 instanceof Boolean) == true) goto L116;
        r126 = null;
    L116:
        r116 = (Boolean) r126;     // Catch: Throwable -> L133
    L118:
        if ((r115 instanceof JSONObject) == false) goto L120;
    L183:
        Object r127 = SDKSettingsCacheManager.a().fromJson(r115.toString(), Boolean.class);     // Catch: Throwable -> L126
        if ((r127 instanceof Boolean) == true) goto L124;
        r127 = null;
    L124:
        Object r128 = Result.m9449constructorimpl((Boolean) r127);     // Catch: Throwable -> L126
    L128:
        r116 = r128;
        if (Result.m9455isFailureimpl(r116) == false) goto L131;
    L126:
        th = move-exception;
        Result.Companion r129 = Result.Companion;     // Catch: Throwable -> L133
        r128 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L133
        goto L128
    L120:
        if ((r115 instanceof JSONArray) == false) goto L130;
    L87:
        r122 = r115;
    L133:
        th = move-exception;
        Result.Companion r130 = Result.Companion;     // Catch: Throwable -> L159
        r117 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L159
    L182:
        return ((Boolean) r110).booleanValue();
    L11:
        if ((r106 instanceof Boolean) == true) goto L13;
        Object r131 = null;
    L14:
        r107 = (Boolean) r131;     // Catch: Throwable -> L59
        if (r107 != null) goto L57;
        if ((r106 instanceof Number) == false) goto L44;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r132 = Float.valueOf(((Number) r106).floatValue());     // Catch: Throwable -> L59
        if ((r132 instanceof Boolean) == true) goto L24;
        r132 = null;
    L24:
        r107 = (Boolean) r132;     // Catch: Throwable -> L59
        goto L57
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r133 = Double.valueOf(((Number) r106).doubleValue());     // Catch: Throwable -> L59
        if ((r133 instanceof Boolean) == true) goto L30;
        r133 = null;
    L30:
        r107 = (Boolean) r133;     // Catch: Throwable -> L59
        goto L57
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L38;
        Integer r134 = Integer.valueOf(((Number) r106).intValue());     // Catch: Throwable -> L59
        if ((r134 instanceof Boolean) == true) goto L36;
        r134 = null;
    L36:
        r107 = (Boolean) r134;     // Catch: Throwable -> L59
        goto L57
    L38:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L44;
        Long r135 = Long.valueOf(((Number) r106).longValue());     // Catch: Throwable -> L59
        if ((r135 instanceof Boolean) == true) goto L42;
        r135 = null;
    L42:
        r107 = (Boolean) r135;     // Catch: Throwable -> L59
    L44:
        if ((r106 instanceof JSONObject) == false) goto L46;
    L189:
        Object r136 = SDKSettingsCacheManager.a().fromJson(r106.toString(), Boolean.class);     // Catch: Throwable -> L52
        if ((r136 instanceof Boolean) == true) goto L50;
        r136 = null;
    L50:
        Object r137 = Result.m9449constructorimpl((Boolean) r136);     // Catch: Throwable -> L52
    L54:
        r107 = r137;
        if (Result.m9455isFailureimpl(r107) == false) goto L57;
    L52:
        th = move-exception;
        Result.Companion r138 = Result.Companion;     // Catch: Throwable -> L59
        r137 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L59
        goto L54
    L46:
        if ((r106 instanceof JSONArray) == false) goto L56;
    L13:
        r131 = r106;
    L59:
        th = move-exception;
        Result.Companion r139 = Result.Companion;     // Catch: Throwable -> L172
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L172
    L172:
        th = move-exception;
        Result.Companion r140 = Result.Companion;
        Object r141 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r142 = Result.m9452exceptionOrNullimpl(r141);
        if (r142 == null) goto L177;
        EnsureManager.ensureNotReachHere(r142);
    L177:
        if (Result.m9455isFailureimpl(r141) == true) goto L180;
        r101 = r141;
    L180:
        r110 = r101;
        goto L182
    }

    @SettingPanel("商详无效刷新治理-已固化")
    public static final boolean y() {
        jj4.b r100 = jj4.b.f499326b;
        int r101 = e.f43640a;
        Object r102 = jj4.a.a("detail_return_pdp_refresh_opt", Boolean.class, e.a(Boolean.TRUE, Boolean.FALSE), false);
        if (r102 != null) goto L6;
        Intrinsics.throwNpe();
    L6:
        return ((Boolean) r102).booleanValue();
    }

    public static final boolean z() {
        int r100 = j.f43647a;
        Object r101 = Boolean.FALSE;
        int r102 = com.bytedance.android.ec.base.settings.b.f42814a;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L172
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L172
        SDKSettingsCacheManager r104 = SDKSettingsCacheManager.f42812e;     // Catch: Throwable -> L172
        Object r105 = null;
        r104.getClass();     // Catch: Throwable -> L59
        Object r106 = SDKSettingsCacheManager.f42809b.get("iesec_pdp_first_enter_use_chunk");     // Catch: Throwable -> L59
        if (r106 != null) goto L11;
    L56:
        Object r107 = null;
    L57:
        Object r108 = Result.m9449constructorimpl(r107);     // Catch: Throwable -> L59
    L61:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);     // Catch: Throwable -> L172
        if (r109 == null) goto L65;
        EnsureManager.ensureNotReachHere(r109);     // Catch: Throwable -> L172
    L65:
        if (Result.m9455isFailureimpl(r108) == false) goto L68;
        r108 = null;
    L68:
        if ((r108 instanceof Boolean) == true) goto L70;
        r108 = null;
    L70:
        Object r110 = (Boolean) r108;     // Catch: Throwable -> L172
        if (r110 != null) goto L77;
        r104.getClass();     // Catch: Throwable -> L172
        Object r111 = SDKSettingsCacheManager.f42808a.get("iesec_pdp_first_enter_use_chunk");     // Catch: Throwable -> L172
        if ((r111 instanceof Boolean) == true) goto L76;
        r111 = null;
    L76:
        r110 = (Boolean) r111;     // Catch: Throwable -> L172
    L77:
        if (r110 != null) goto L182;
        int r112 = com.bytedance.android.ec.base.settings.g.f42821a;     // Catch: Throwable -> L172
    L159:
        th = move-exception;
        Result.Companion r113 = Result.Companion;     // Catch: Throwable -> L172
        Object r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L172
    L162:
        if (Result.m9452exceptionOrNullimpl(r114) != null) goto L185;
    L169:
        r110 = r114;
    L170:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L172
        SDKSettingsCacheManager.e("iesec_pdp_first_enter_use_chunk", r110);     // Catch: Throwable -> L172
        goto L182
    L185:
        r114 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("iesec_pdp_first_enter_use_chunk", Boolean.class, r101);     // Catch: Throwable -> L166
    L167:
        if (r114 != null) goto L169;
        r110 = r101;
    L166:
        r114 = r101;
        goto L167
    L191:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L133
        Object r115 = SDKSettingsCacheManager.f42809b.get("iesec_pdp_first_enter_use_chunk");     // Catch: Throwable -> L133
        if (r115 != null) goto L85;
    L130:
        Object r116 = null;
    L131:
        Object r117 = Result.m9449constructorimpl(r116);     // Catch: Throwable -> L133
    L135:
        Throwable r118 = Result.m9452exceptionOrNullimpl(r117);     // Catch: Throwable -> L159
        if (r118 == null) goto L139;
        EnsureManager.ensureNotReachHere(r118);     // Catch: Throwable -> L159
    L139:
        if (Result.m9455isFailureimpl(r117) == false) goto L142;
        r117 = null;
    L142:
        if ((r117 instanceof Boolean) == true) goto L144;
        r117 = null;
    L144:
        r114 = (Boolean) r117;     // Catch: Throwable -> L159
        if (r114 != null) goto L169;
        jj4.b r119 = jj4.b.f499326b;     // Catch: Throwable -> L159
        Object r120 = jj4.a.a("iesec_pdp_first_enter_use_chunk", Boolean.class, r101, false);     // Catch: Throwable -> L159
        if (r120 != null) goto L151;
        Intrinsics.throwNpe();     // Catch: Throwable -> L159
    L151:
        if ((r120 instanceof Boolean) == false) goto L154;
        r105 = r120;
    L154:
        Object r121 = (Boolean) r105;     // Catch: Throwable -> L159
        if (r121 != null) goto L157;
        r121 = r101;
    L157:
        r114 = Result.m9449constructorimpl(r121);     // Catch: Throwable -> L159
    L85:
        if ((r115 instanceof Boolean) == true) goto L87;
        Object r122 = null;
    L88:
        r116 = (Boolean) r122;     // Catch: Throwable -> L133
        if (r116 != null) goto L131;
        if ((r115 instanceof Number) == false) goto L118;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L100;
        Float r123 = Float.valueOf(((Number) r115).floatValue());     // Catch: Throwable -> L133
        if ((r123 instanceof Boolean) == true) goto L98;
        r123 = null;
    L98:
        r116 = (Boolean) r123;     // Catch: Throwable -> L133
        goto L131
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L106;
        Double r124 = Double.valueOf(((Number) r115).doubleValue());     // Catch: Throwable -> L133
        if ((r124 instanceof Boolean) == true) goto L104;
        r124 = null;
    L104:
        r116 = (Boolean) r124;     // Catch: Throwable -> L133
        goto L131
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L112;
        Integer r125 = Integer.valueOf(((Number) r115).intValue());     // Catch: Throwable -> L133
        if ((r125 instanceof Boolean) == true) goto L110;
        r125 = null;
    L110:
        r116 = (Boolean) r125;     // Catch: Throwable -> L133
        goto L131
    L112:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L118;
        Long r126 = Long.valueOf(((Number) r115).longValue());     // Catch: Throwable -> L133
        if ((r126 instanceof Boolean) == true) goto L116;
        r126 = null;
    L116:
        r116 = (Boolean) r126;     // Catch: Throwable -> L133
    L118:
        if ((r115 instanceof JSONObject) == false) goto L120;
    L183:
        Object r127 = SDKSettingsCacheManager.a().fromJson(r115.toString(), Boolean.class);     // Catch: Throwable -> L126
        if ((r127 instanceof Boolean) == true) goto L124;
        r127 = null;
    L124:
        Object r128 = Result.m9449constructorimpl((Boolean) r127);     // Catch: Throwable -> L126
    L128:
        r116 = r128;
        if (Result.m9455isFailureimpl(r116) == false) goto L131;
    L126:
        th = move-exception;
        Result.Companion r129 = Result.Companion;     // Catch: Throwable -> L133
        r128 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L133
        goto L128
    L120:
        if ((r115 instanceof JSONArray) == false) goto L130;
    L87:
        r122 = r115;
    L133:
        th = move-exception;
        Result.Companion r130 = Result.Companion;     // Catch: Throwable -> L159
        r117 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L159
    L182:
        return ((Boolean) r110).booleanValue();
    L11:
        if ((r106 instanceof Boolean) == true) goto L13;
        Object r131 = null;
    L14:
        r107 = (Boolean) r131;     // Catch: Throwable -> L59
        if (r107 != null) goto L57;
        if ((r106 instanceof Number) == false) goto L44;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r132 = Float.valueOf(((Number) r106).floatValue());     // Catch: Throwable -> L59
        if ((r132 instanceof Boolean) == true) goto L24;
        r132 = null;
    L24:
        r107 = (Boolean) r132;     // Catch: Throwable -> L59
        goto L57
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r133 = Double.valueOf(((Number) r106).doubleValue());     // Catch: Throwable -> L59
        if ((r133 instanceof Boolean) == true) goto L30;
        r133 = null;
    L30:
        r107 = (Boolean) r133;     // Catch: Throwable -> L59
        goto L57
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L38;
        Integer r134 = Integer.valueOf(((Number) r106).intValue());     // Catch: Throwable -> L59
        if ((r134 instanceof Boolean) == true) goto L36;
        r134 = null;
    L36:
        r107 = (Boolean) r134;     // Catch: Throwable -> L59
        goto L57
    L38:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L44;
        Long r135 = Long.valueOf(((Number) r106).longValue());     // Catch: Throwable -> L59
        if ((r135 instanceof Boolean) == true) goto L42;
        r135 = null;
    L42:
        r107 = (Boolean) r135;     // Catch: Throwable -> L59
    L44:
        if ((r106 instanceof JSONObject) == false) goto L46;
    L189:
        Object r136 = SDKSettingsCacheManager.a().fromJson(r106.toString(), Boolean.class);     // Catch: Throwable -> L52
        if ((r136 instanceof Boolean) == true) goto L50;
        r136 = null;
    L50:
        Object r137 = Result.m9449constructorimpl((Boolean) r136);     // Catch: Throwable -> L52
    L54:
        r107 = r137;
        if (Result.m9455isFailureimpl(r107) == false) goto L57;
    L52:
        th = move-exception;
        Result.Companion r138 = Result.Companion;     // Catch: Throwable -> L59
        r137 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L59
        goto L54
    L46:
        if ((r106 instanceof JSONArray) == false) goto L56;
    L13:
        r131 = r106;
    L59:
        th = move-exception;
        Result.Companion r139 = Result.Companion;     // Catch: Throwable -> L172
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L172
    L172:
        th = move-exception;
        Result.Companion r140 = Result.Companion;
        Object r141 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r142 = Result.m9452exceptionOrNullimpl(r141);
        if (r142 == null) goto L177;
        EnsureManager.ensureNotReachHere(r142);
    L177:
        if (Result.m9455isFailureimpl(r141) == true) goto L180;
        r101 = r141;
    L180:
        r110 = r101;
        goto L182
    }
}
