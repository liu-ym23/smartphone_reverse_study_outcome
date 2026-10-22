package com.bytedance.android.ec.core.opt.ab;

import com.bytedance.android.ec.ab.opt.HostExperimentKey;
import com.bytedance.android.ec.ab.opt.OptSetting;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.services.apm.api.EnsureManager;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
@OptSetting(business = "交易标准化能力开关")
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f45246a = 0;

    @HostExperimentKey
    public static final int b() {
        int r100 = m.f45240a;
        Object r101 = 0;
        boolean r102 = ECServiceManager.f42805a;
        s83.g r103 = (s83.g) ECServiceManager.c(s83.g.class);
        if (r103 == null) goto L8;
        s83.a r104 = r103.q();
        if (r104 == null) goto L8;
        Object r105 = r104.e("shopping_abilities_enter_cart");
        if (r105 == null) goto L8;
    L175:
        return ((Number) r105).intValue();
    L8:
        int r106 = n.f45241a;
        int r107 = com.bytedance.android.ec.base.settings.a.f42813a;
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L165
        Object r109 = null;
        Object r110 = com.bytedance.android.ec.base.settings.d.f42818c.get("shopping_abilities_enter_cart");     // Catch: Throwable -> L60
        if (r110 != null) goto L15;
    L57:
        Object r111 = null;
    L58:
        Object r112 = Result.m9449constructorimpl(r111);     // Catch: Throwable -> L60
    L62:
        Throwable r113 = Result.m9452exceptionOrNullimpl(r112);     // Catch: Throwable -> L165
        if (r113 == null) goto L66;
        EnsureManager.ensureNotReachHere(r113);     // Catch: Throwable -> L165
    L66:
        if (Result.m9455isFailureimpl(r112) == false) goto L69;
        r112 = null;
    L69:
        if ((r112 instanceof Integer) == true) goto L71;
        r112 = null;
    L71:
        Integer r114 = (Integer) r112;     // Catch: Throwable -> L165
        if (r114 != null) goto L78;
        Object r115 = com.bytedance.android.ec.base.settings.d.f42816a.get("shopping_abilities_enter_cart");     // Catch: Throwable -> L165
        if ((r115 instanceof Integer) == true) goto L77;
        r115 = null;
    L77:
        r114 = (Integer) r115;     // Catch: Throwable -> L165
    L78:
        if (r114 == null) goto L80;
        r105 = r114;
        goto L175
    L80:
        int r116 = com.bytedance.android.ec.base.settings.c.f42815a;     // Catch: Throwable -> L165
        Object r117 = com.bytedance.android.ec.base.settings.d.f42818c.get("shopping_abilities_enter_cart");     // Catch: Throwable -> L130
        if (r117 != null) goto L85;
    L127:
        Object r118 = null;
    L128:
        Object r119 = Result.m9449constructorimpl(r118);     // Catch: Throwable -> L130
    L132:
        Throwable r120 = Result.m9452exceptionOrNullimpl(r119);     // Catch: Throwable -> L156
        if (r120 == null) goto L136;
        EnsureManager.ensureNotReachHere(r120);     // Catch: Throwable -> L156
    L136:
        if (Result.m9455isFailureimpl(r119) == false) goto L139;
        r119 = null;
    L139:
        if ((r119 instanceof Integer) == true) goto L141;
        r119 = null;
    L141:
        Integer r121 = (Integer) r119;     // Catch: Throwable -> L156
        if (r121 == null) goto L144;
        r105 = r121;
    L163:
        com.bytedance.android.ec.base.settings.d.d("shopping_abilities_enter_cart", r105);     // Catch: Throwable -> L165
        goto L175
    L144:
        IHybridHostService r122 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L156
        if (r122 == null) goto L147;
        Object r123 = r122.getHostABValue("shopping_abilities_enter_cart", r101);     // Catch: Throwable -> L156
    L148:
        if (r123 != null) goto L150;
    L162:
        r105 = r101;
        goto L163
    L150:
        if ((r123 instanceof Integer) == false) goto L153;
        r109 = r123;
    L153:
        r105 = (Integer) r109;     // Catch: Throwable -> L156
        if (r105 != null) goto L163;
    L147:
        r123 = null;
        goto L148
    L85:
        if ((r117 instanceof Integer) == true) goto L87;
        Object r124 = null;
    L88:
        r118 = (Integer) r124;     // Catch: Throwable -> L130
        if (r118 != null) goto L128;
        if ((r117 instanceof Number) == false) goto L115;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L100;
        Float r125 = Float.valueOf(((Number) r117).floatValue());     // Catch: Throwable -> L130
        if ((r125 instanceof Integer) == true) goto L98;
        r125 = null;
    L98:
        r118 = (Integer) r125;     // Catch: Throwable -> L130
        goto L128
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L106;
        Double r126 = Double.valueOf(((Number) r117).doubleValue());     // Catch: Throwable -> L130
        if ((r126 instanceof Integer) == true) goto L104;
        r126 = null;
    L104:
        r118 = (Integer) r126;     // Catch: Throwable -> L130
        goto L128
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L109;
        r118 = Integer.valueOf(((Number) r117).intValue());     // Catch: Throwable -> L130
        goto L128
    L109:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L115;
        Long r127 = Long.valueOf(((Number) r117).longValue());     // Catch: Throwable -> L130
        if ((r127 instanceof Integer) == true) goto L113;
        r127 = null;
    L113:
        r118 = (Integer) r127;     // Catch: Throwable -> L130
    L115:
        if ((r117 instanceof JSONObject) == false) goto L117;
    L183:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L123
        Object r128 = SDKSettingsCacheManager.a().fromJson(r117.toString(), Integer.class);     // Catch: Throwable -> L123
        if ((r128 instanceof Integer) == true) goto L121;
        r128 = null;
    L121:
        Object r129 = Result.m9449constructorimpl((Integer) r128);     // Catch: Throwable -> L123
    L125:
        r118 = r129;
        if (Result.m9455isFailureimpl(r118) == false) goto L128;
    L123:
        th = move-exception;
        Result.Companion r130 = Result.Companion;     // Catch: Throwable -> L130
        r129 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L130
        goto L125
    L117:
        if ((r117 instanceof JSONArray) == false) goto L127;
    L87:
        r124 = r117;
    L156:
        th = move-exception;
        Result.Companion r131 = Result.Companion;     // Catch: Throwable -> L165
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L165
        Throwable r132 = Result.m9452exceptionOrNullimpl(r105);     // Catch: Throwable -> L165
        if (r132 == null) goto L161;
        EnsureManager.ensureNotReachHere(r132);     // Catch: Throwable -> L165
    L161:
        if (Result.m9455isFailureimpl(r105) == false) goto L163;
    L130:
        th = move-exception;
        Result.Companion r133 = Result.Companion;     // Catch: Throwable -> L156
        r119 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L156
        goto L132
    L15:
        if ((r110 instanceof Integer) == true) goto L17;
        Object r134 = null;
    L18:
        r111 = (Integer) r134;     // Catch: Throwable -> L60
        if (r111 != null) goto L58;
        if ((r110 instanceof Number) == false) goto L45;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L30;
        Float r135 = Float.valueOf(((Number) r110).floatValue());     // Catch: Throwable -> L60
        if ((r135 instanceof Integer) == true) goto L28;
        r135 = null;
    L28:
        r111 = (Integer) r135;     // Catch: Throwable -> L60
        goto L58
    L30:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L36;
        Double r136 = Double.valueOf(((Number) r110).doubleValue());     // Catch: Throwable -> L60
        if ((r136 instanceof Integer) == true) goto L34;
        r136 = null;
    L34:
        r111 = (Integer) r136;     // Catch: Throwable -> L60
        goto L58
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L39;
        r111 = Integer.valueOf(((Number) r110).intValue());     // Catch: Throwable -> L60
        goto L58
    L39:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L45;
        Long r137 = Long.valueOf(((Number) r110).longValue());     // Catch: Throwable -> L60
        if ((r137 instanceof Integer) == true) goto L43;
        r137 = null;
    L43:
        r111 = (Integer) r137;     // Catch: Throwable -> L60
    L45:
        if ((r110 instanceof JSONObject) == false) goto L47;
    L181:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L53
        Object r138 = SDKSettingsCacheManager.a().fromJson(r110.toString(), Integer.class);     // Catch: Throwable -> L53
        if ((r138 instanceof Integer) == true) goto L51;
        r138 = null;
    L51:
        Object r139 = Result.m9449constructorimpl((Integer) r138);     // Catch: Throwable -> L53
    L55:
        r111 = r139;
        if (Result.m9455isFailureimpl(r111) == false) goto L58;
    L53:
        th = move-exception;
        Result.Companion r140 = Result.Companion;     // Catch: Throwable -> L60
        r139 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L60
        goto L55
    L47:
        if ((r110 instanceof JSONArray) == false) goto L57;
    L17:
        r134 = r110;
    L60:
        th = move-exception;
        Result.Companion r141 = Result.Companion;     // Catch: Throwable -> L165
        r112 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L165
    L165:
        th = move-exception;
        Result.Companion r142 = Result.Companion;
        Object r143 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r144 = Result.m9452exceptionOrNullimpl(r143);
        if (r144 == null) goto L170;
        EnsureManager.ensureNotReachHere(r144);
    L170:
        if (Result.m9455isFailureimpl(r143) == true) goto L173;
        r101 = r143;
    L173:
        r105 = r101;
        goto L175
    }

    @HostExperimentKey
    public static final int c() {
        int r100 = m.f45240a;
        Object r101 = 0;
        boolean r102 = ECServiceManager.f42805a;
        s83.g r103 = (s83.g) ECServiceManager.c(s83.g.class);
        if (r103 == null) goto L8;
        s83.a r104 = r103.q();
        if (r104 == null) goto L8;
        Object r105 = r104.e("shopping_abilities_open_im");
        if (r105 == null) goto L8;
    L175:
        return ((Number) r105).intValue();
    L8:
        int r106 = n.f45241a;
        int r107 = com.bytedance.android.ec.base.settings.a.f42813a;
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L165
        Object r109 = null;
        Object r110 = com.bytedance.android.ec.base.settings.d.f42818c.get("shopping_abilities_open_im");     // Catch: Throwable -> L60
        if (r110 != null) goto L15;
    L57:
        Object r111 = null;
    L58:
        Object r112 = Result.m9449constructorimpl(r111);     // Catch: Throwable -> L60
    L62:
        Throwable r113 = Result.m9452exceptionOrNullimpl(r112);     // Catch: Throwable -> L165
        if (r113 == null) goto L66;
        EnsureManager.ensureNotReachHere(r113);     // Catch: Throwable -> L165
    L66:
        if (Result.m9455isFailureimpl(r112) == false) goto L69;
        r112 = null;
    L69:
        if ((r112 instanceof Integer) == true) goto L71;
        r112 = null;
    L71:
        Integer r114 = (Integer) r112;     // Catch: Throwable -> L165
        if (r114 != null) goto L78;
        Object r115 = com.bytedance.android.ec.base.settings.d.f42816a.get("shopping_abilities_open_im");     // Catch: Throwable -> L165
        if ((r115 instanceof Integer) == true) goto L77;
        r115 = null;
    L77:
        r114 = (Integer) r115;     // Catch: Throwable -> L165
    L78:
        if (r114 == null) goto L80;
        r105 = r114;
        goto L175
    L80:
        int r116 = com.bytedance.android.ec.base.settings.c.f42815a;     // Catch: Throwable -> L165
        Object r117 = com.bytedance.android.ec.base.settings.d.f42818c.get("shopping_abilities_open_im");     // Catch: Throwable -> L130
        if (r117 != null) goto L85;
    L127:
        Object r118 = null;
    L128:
        Object r119 = Result.m9449constructorimpl(r118);     // Catch: Throwable -> L130
    L132:
        Throwable r120 = Result.m9452exceptionOrNullimpl(r119);     // Catch: Throwable -> L156
        if (r120 == null) goto L136;
        EnsureManager.ensureNotReachHere(r120);     // Catch: Throwable -> L156
    L136:
        if (Result.m9455isFailureimpl(r119) == false) goto L139;
        r119 = null;
    L139:
        if ((r119 instanceof Integer) == true) goto L141;
        r119 = null;
    L141:
        Integer r121 = (Integer) r119;     // Catch: Throwable -> L156
        if (r121 == null) goto L144;
        r105 = r121;
    L163:
        com.bytedance.android.ec.base.settings.d.d("shopping_abilities_open_im", r105);     // Catch: Throwable -> L165
        goto L175
    L144:
        IHybridHostService r122 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L156
        if (r122 == null) goto L147;
        Object r123 = r122.getHostABValue("shopping_abilities_open_im", r101);     // Catch: Throwable -> L156
    L148:
        if (r123 != null) goto L150;
    L162:
        r105 = r101;
        goto L163
    L150:
        if ((r123 instanceof Integer) == false) goto L153;
        r109 = r123;
    L153:
        r105 = (Integer) r109;     // Catch: Throwable -> L156
        if (r105 != null) goto L163;
    L147:
        r123 = null;
        goto L148
    L85:
        if ((r117 instanceof Integer) == true) goto L87;
        Object r124 = null;
    L88:
        r118 = (Integer) r124;     // Catch: Throwable -> L130
        if (r118 != null) goto L128;
        if ((r117 instanceof Number) == false) goto L115;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L100;
        Float r125 = Float.valueOf(((Number) r117).floatValue());     // Catch: Throwable -> L130
        if ((r125 instanceof Integer) == true) goto L98;
        r125 = null;
    L98:
        r118 = (Integer) r125;     // Catch: Throwable -> L130
        goto L128
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L106;
        Double r126 = Double.valueOf(((Number) r117).doubleValue());     // Catch: Throwable -> L130
        if ((r126 instanceof Integer) == true) goto L104;
        r126 = null;
    L104:
        r118 = (Integer) r126;     // Catch: Throwable -> L130
        goto L128
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L109;
        r118 = Integer.valueOf(((Number) r117).intValue());     // Catch: Throwable -> L130
        goto L128
    L109:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L115;
        Long r127 = Long.valueOf(((Number) r117).longValue());     // Catch: Throwable -> L130
        if ((r127 instanceof Integer) == true) goto L113;
        r127 = null;
    L113:
        r118 = (Integer) r127;     // Catch: Throwable -> L130
    L115:
        if ((r117 instanceof JSONObject) == false) goto L117;
    L183:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L123
        Object r128 = SDKSettingsCacheManager.a().fromJson(r117.toString(), Integer.class);     // Catch: Throwable -> L123
        if ((r128 instanceof Integer) == true) goto L121;
        r128 = null;
    L121:
        Object r129 = Result.m9449constructorimpl((Integer) r128);     // Catch: Throwable -> L123
    L125:
        r118 = r129;
        if (Result.m9455isFailureimpl(r118) == false) goto L128;
    L123:
        th = move-exception;
        Result.Companion r130 = Result.Companion;     // Catch: Throwable -> L130
        r129 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L130
        goto L125
    L117:
        if ((r117 instanceof JSONArray) == false) goto L127;
    L87:
        r124 = r117;
    L156:
        th = move-exception;
        Result.Companion r131 = Result.Companion;     // Catch: Throwable -> L165
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L165
        Throwable r132 = Result.m9452exceptionOrNullimpl(r105);     // Catch: Throwable -> L165
        if (r132 == null) goto L161;
        EnsureManager.ensureNotReachHere(r132);     // Catch: Throwable -> L165
    L161:
        if (Result.m9455isFailureimpl(r105) == false) goto L163;
    L130:
        th = move-exception;
        Result.Companion r133 = Result.Companion;     // Catch: Throwable -> L156
        r119 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L156
        goto L132
    L15:
        if ((r110 instanceof Integer) == true) goto L17;
        Object r134 = null;
    L18:
        r111 = (Integer) r134;     // Catch: Throwable -> L60
        if (r111 != null) goto L58;
        if ((r110 instanceof Number) == false) goto L45;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L30;
        Float r135 = Float.valueOf(((Number) r110).floatValue());     // Catch: Throwable -> L60
        if ((r135 instanceof Integer) == true) goto L28;
        r135 = null;
    L28:
        r111 = (Integer) r135;     // Catch: Throwable -> L60
        goto L58
    L30:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L36;
        Double r136 = Double.valueOf(((Number) r110).doubleValue());     // Catch: Throwable -> L60
        if ((r136 instanceof Integer) == true) goto L34;
        r136 = null;
    L34:
        r111 = (Integer) r136;     // Catch: Throwable -> L60
        goto L58
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L39;
        r111 = Integer.valueOf(((Number) r110).intValue());     // Catch: Throwable -> L60
        goto L58
    L39:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L45;
        Long r137 = Long.valueOf(((Number) r110).longValue());     // Catch: Throwable -> L60
        if ((r137 instanceof Integer) == true) goto L43;
        r137 = null;
    L43:
        r111 = (Integer) r137;     // Catch: Throwable -> L60
    L45:
        if ((r110 instanceof JSONObject) == false) goto L47;
    L181:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L53
        Object r138 = SDKSettingsCacheManager.a().fromJson(r110.toString(), Integer.class);     // Catch: Throwable -> L53
        if ((r138 instanceof Integer) == true) goto L51;
        r138 = null;
    L51:
        Object r139 = Result.m9449constructorimpl((Integer) r138);     // Catch: Throwable -> L53
    L55:
        r111 = r139;
        if (Result.m9455isFailureimpl(r111) == false) goto L58;
    L53:
        th = move-exception;
        Result.Companion r140 = Result.Companion;     // Catch: Throwable -> L60
        r139 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L60
        goto L55
    L47:
        if ((r110 instanceof JSONArray) == false) goto L57;
    L17:
        r134 = r110;
    L60:
        th = move-exception;
        Result.Companion r141 = Result.Companion;     // Catch: Throwable -> L165
        r112 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L165
    L165:
        th = move-exception;
        Result.Companion r142 = Result.Companion;
        Object r143 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r144 = Result.m9452exceptionOrNullimpl(r143);
        if (r144 == null) goto L170;
        EnsureManager.ensureNotReachHere(r144);
    L170:
        if (Result.m9455isFailureimpl(r143) == true) goto L173;
        r101 = r143;
    L173:
        r105 = r101;
        goto L175
    }

    public static final int d() {
        int r100 = n.f45241a;
        Object r101 = 0;
        int r102 = com.bytedance.android.ec.base.settings.a.f42813a;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L160
        Object r104 = null;
        Object r105 = com.bytedance.android.ec.base.settings.d.f42818c.get("shopping_abilities_open_product_detail");     // Catch: Throwable -> L54
        if (r105 != null) goto L9;
    L51:
        Object r106 = null;
    L52:
        Object r107 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L54
    L56:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);     // Catch: Throwable -> L160
        if (r108 == null) goto L60;
        EnsureManager.ensureNotReachHere(r108);     // Catch: Throwable -> L160
    L60:
        if (Result.m9455isFailureimpl(r107) == false) goto L63;
        r107 = null;
    L63:
        if ((r107 instanceof Integer) == true) goto L65;
        r107 = null;
    L65:
        Object r109 = (Integer) r107;     // Catch: Throwable -> L160
        if (r109 != null) goto L72;
        Object r110 = com.bytedance.android.ec.base.settings.d.f42816a.get("shopping_abilities_open_product_detail");     // Catch: Throwable -> L160
        if ((r110 instanceof Integer) == true) goto L71;
        r110 = null;
    L71:
        r109 = (Integer) r110;     // Catch: Throwable -> L160
    L72:
        if (r109 != null) goto L170;
        int r111 = com.bytedance.android.ec.base.settings.c.f42815a;     // Catch: Throwable -> L160
        Object r112 = com.bytedance.android.ec.base.settings.d.f42818c.get("shopping_abilities_open_product_detail");     // Catch: Throwable -> L124
        if (r112 != null) goto L79;
    L121:
        Object r113 = null;
    L122:
        Object r114 = Result.m9449constructorimpl(r113);     // Catch: Throwable -> L124
    L126:
        Throwable r115 = Result.m9452exceptionOrNullimpl(r114);     // Catch: Throwable -> L150
        if (r115 == null) goto L130;
        EnsureManager.ensureNotReachHere(r115);     // Catch: Throwable -> L150
    L130:
        if (Result.m9455isFailureimpl(r114) == false) goto L133;
        r114 = null;
    L133:
        if ((r114 instanceof Integer) == true) goto L135;
        r114 = null;
    L135:
        r109 = (Integer) r114;     // Catch: Throwable -> L150
        if (r109 != null) goto L158;
        IHybridHostService r116 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L150
        if (r116 == null) goto L141;
        Object r117 = r116.getHostABValue("shopping_abilities_open_product_detail", r101);     // Catch: Throwable -> L150
    L142:
        if (r117 != null) goto L144;
    L149:
        r109 = r101;
        goto L158
    L144:
        if ((r117 instanceof Integer) == false) goto L147;
        r104 = r117;
    L147:
        Object r118 = (Integer) r104;     // Catch: Throwable -> L150
        if (r118 == null) goto L149;
    L157:
        r109 = r118;
        goto L158
    L141:
        r117 = null;
    L158:
        com.bytedance.android.ec.base.settings.d.d("shopping_abilities_open_product_detail", r109);     // Catch: Throwable -> L160
        goto L170
    L79:
        if ((r112 instanceof Integer) == true) goto L81;
        Object r119 = null;
    L82:
        r113 = (Integer) r119;     // Catch: Throwable -> L124
        if (r113 != null) goto L122;
        if ((r112 instanceof Number) == false) goto L109;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L94;
        Float r120 = Float.valueOf(((Number) r112).floatValue());     // Catch: Throwable -> L124
        if ((r120 instanceof Integer) == true) goto L92;
        r120 = null;
    L92:
        r113 = (Integer) r120;     // Catch: Throwable -> L124
        goto L122
    L94:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L100;
        Double r121 = Double.valueOf(((Number) r112).doubleValue());     // Catch: Throwable -> L124
        if ((r121 instanceof Integer) == true) goto L98;
        r121 = null;
    L98:
        r113 = (Integer) r121;     // Catch: Throwable -> L124
        goto L122
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L103;
        r113 = Integer.valueOf(((Number) r112).intValue());     // Catch: Throwable -> L124
        goto L122
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L109;
        Long r122 = Long.valueOf(((Number) r112).longValue());     // Catch: Throwable -> L124
        if ((r122 instanceof Integer) == true) goto L107;
        r122 = null;
    L107:
        r113 = (Integer) r122;     // Catch: Throwable -> L124
    L109:
        if ((r112 instanceof JSONObject) == false) goto L111;
    L180:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L117
        Object r123 = SDKSettingsCacheManager.a().fromJson(r112.toString(), Integer.class);     // Catch: Throwable -> L117
        if ((r123 instanceof Integer) == true) goto L115;
        r123 = null;
    L115:
        Object r124 = Result.m9449constructorimpl((Integer) r123);     // Catch: Throwable -> L117
    L119:
        r113 = r124;
        if (Result.m9455isFailureimpl(r113) == false) goto L122;
    L117:
        th = move-exception;
        Result.Companion r125 = Result.Companion;     // Catch: Throwable -> L124
        r124 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L124
        goto L119
    L111:
        if ((r112 instanceof JSONArray) == false) goto L121;
    L81:
        r119 = r112;
    L150:
        th = move-exception;
        Result.Companion r126 = Result.Companion;     // Catch: Throwable -> L160
        r118 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L160
        Throwable r127 = Result.m9452exceptionOrNullimpl(r118);     // Catch: Throwable -> L160
        if (r127 == null) goto L155;
        EnsureManager.ensureNotReachHere(r127);     // Catch: Throwable -> L160
    L155:
        if (Result.m9455isFailureimpl(r118) == false) goto L157;
        r118 = r101;
    L124:
        th = move-exception;
        Result.Companion r128 = Result.Companion;     // Catch: Throwable -> L150
        r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L150
    L170:
        return ((Number) r109).intValue();
    L9:
        if ((r105 instanceof Integer) == true) goto L11;
        Object r129 = null;
    L12:
        r106 = (Integer) r129;     // Catch: Throwable -> L54
        if (r106 != null) goto L52;
        if ((r105 instanceof Number) == false) goto L39;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L24;
        Float r130 = Float.valueOf(((Number) r105).floatValue());     // Catch: Throwable -> L54
        if ((r130 instanceof Integer) == true) goto L22;
        r130 = null;
    L22:
        r106 = (Integer) r130;     // Catch: Throwable -> L54
        goto L52
    L24:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L30;
        Double r131 = Double.valueOf(((Number) r105).doubleValue());     // Catch: Throwable -> L54
        if ((r131 instanceof Integer) == true) goto L28;
        r131 = null;
    L28:
        r106 = (Integer) r131;     // Catch: Throwable -> L54
        goto L52
    L30:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L33;
        r106 = Integer.valueOf(((Number) r105).intValue());     // Catch: Throwable -> L54
        goto L52
    L33:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L39;
        Long r132 = Long.valueOf(((Number) r105).longValue());     // Catch: Throwable -> L54
        if ((r132 instanceof Integer) == true) goto L37;
        r132 = null;
    L37:
        r106 = (Integer) r132;     // Catch: Throwable -> L54
    L39:
        if ((r105 instanceof JSONObject) == false) goto L41;
    L178:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L47
        Object r133 = SDKSettingsCacheManager.a().fromJson(r105.toString(), Integer.class);     // Catch: Throwable -> L47
        if ((r133 instanceof Integer) == true) goto L45;
        r133 = null;
    L45:
        Object r134 = Result.m9449constructorimpl((Integer) r133);     // Catch: Throwable -> L47
    L49:
        r106 = r134;
        if (Result.m9455isFailureimpl(r106) == false) goto L52;
    L47:
        th = move-exception;
        Result.Companion r135 = Result.Companion;     // Catch: Throwable -> L54
        r134 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L54
        goto L49
    L41:
        if ((r105 instanceof JSONArray) == false) goto L51;
    L11:
        r129 = r105;
    L54:
        th = move-exception;
        Result.Companion r136 = Result.Companion;     // Catch: Throwable -> L160
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L160
    L160:
        th = move-exception;
        Result.Companion r137 = Result.Companion;
        Object r138 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r139 = Result.m9452exceptionOrNullimpl(r138);
        if (r139 == null) goto L165;
        EnsureManager.ensureNotReachHere(r139);
    L165:
        if (Result.m9455isFailureimpl(r138) == true) goto L168;
        r101 = r138;
    L168:
        r109 = r101;
        goto L170
    }

    public static boolean a() {
        if (d() != 1) goto L192;
        int r100 = m.f45240a;
        Object r101 = 0;
        boolean r102 = ECServiceManager.f42805a;
        s83.g r103 = (s83.g) ECServiceManager.c(s83.g.class);
        if (r103 == null) goto L10;
        s83.a r104 = r103.q();
        if (r104 == null) goto L10;
        Object r105 = r104.e("shopping_abilities_preload_product_detail");
        if (r105 == null) goto L10;
    L177:
        if (((Number) r105).intValue() != 1) goto L193;
        return true;
    L193:
        return false;
    L10:
        int r106 = n.f45241a;
        int r107 = com.bytedance.android.ec.base.settings.a.f42813a;
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L167
        Object r109 = null;
        Object r110 = com.bytedance.android.ec.base.settings.d.f42818c.get("shopping_abilities_preload_product_detail");     // Catch: Throwable -> L62
        if (r110 != null) goto L17;
    L59:
        Object r111 = null;
    L60:
        Object r112 = Result.m9449constructorimpl(r111);     // Catch: Throwable -> L62
    L64:
        Throwable r113 = Result.m9452exceptionOrNullimpl(r112);     // Catch: Throwable -> L167
        if (r113 == null) goto L68;
        EnsureManager.ensureNotReachHere(r113);     // Catch: Throwable -> L167
    L68:
        if (Result.m9455isFailureimpl(r112) == false) goto L71;
        r112 = null;
    L71:
        if ((r112 instanceof Integer) == true) goto L73;
        r112 = null;
    L73:
        Integer r114 = (Integer) r112;     // Catch: Throwable -> L167
        if (r114 != null) goto L80;
        Object r115 = com.bytedance.android.ec.base.settings.d.f42816a.get("shopping_abilities_preload_product_detail");     // Catch: Throwable -> L167
        if ((r115 instanceof Integer) == true) goto L79;
        r115 = null;
    L79:
        r114 = (Integer) r115;     // Catch: Throwable -> L167
    L80:
        if (r114 == null) goto L82;
        r105 = r114;
        goto L177
    L82:
        int r116 = com.bytedance.android.ec.base.settings.c.f42815a;     // Catch: Throwable -> L167
        Object r117 = com.bytedance.android.ec.base.settings.d.f42818c.get("shopping_abilities_preload_product_detail");     // Catch: Throwable -> L132
        if (r117 != null) goto L87;
    L129:
        Object r118 = null;
    L130:
        Object r119 = Result.m9449constructorimpl(r118);     // Catch: Throwable -> L132
    L134:
        Throwable r120 = Result.m9452exceptionOrNullimpl(r119);     // Catch: Throwable -> L158
        if (r120 == null) goto L138;
        EnsureManager.ensureNotReachHere(r120);     // Catch: Throwable -> L158
    L138:
        if (Result.m9455isFailureimpl(r119) == false) goto L141;
        r119 = null;
    L141:
        if ((r119 instanceof Integer) == true) goto L143;
        r119 = null;
    L143:
        Integer r121 = (Integer) r119;     // Catch: Throwable -> L158
        if (r121 == null) goto L146;
        r105 = r121;
    L165:
        com.bytedance.android.ec.base.settings.d.d("shopping_abilities_preload_product_detail", r105);     // Catch: Throwable -> L167
        goto L177
    L146:
        IHybridHostService r122 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L158
        if (r122 == null) goto L149;
        Object r123 = r122.getHostABValue("shopping_abilities_preload_product_detail", r101);     // Catch: Throwable -> L158
    L150:
        if (r123 != null) goto L152;
    L164:
        r105 = r101;
        goto L165
    L152:
        if ((r123 instanceof Integer) == false) goto L155;
        r109 = r123;
    L155:
        r105 = (Integer) r109;     // Catch: Throwable -> L158
        if (r105 != null) goto L165;
    L158:
        th = move-exception;
        Result.Companion r124 = Result.Companion;     // Catch: Throwable -> L167
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L167
        Throwable r125 = Result.m9452exceptionOrNullimpl(r105);     // Catch: Throwable -> L167
        if (r125 == null) goto L163;
        EnsureManager.ensureNotReachHere(r125);     // Catch: Throwable -> L167
    L163:
        if (Result.m9455isFailureimpl(r105) == false) goto L165;
    L149:
        r123 = null;
        goto L150
    L87:
        if ((r117 instanceof Integer) == true) goto L89;
        Object r126 = null;
    L90:
        r118 = (Integer) r126;     // Catch: Throwable -> L132
        if (r118 != null) goto L130;
        if ((r117 instanceof Number) == false) goto L117;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L102;
        Float r127 = Float.valueOf(((Number) r117).floatValue());     // Catch: Throwable -> L132
        if ((r127 instanceof Integer) == true) goto L100;
        r127 = null;
    L100:
        r118 = (Integer) r127;     // Catch: Throwable -> L132
        goto L130
    L102:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L108;
        Double r128 = Double.valueOf(((Number) r117).doubleValue());     // Catch: Throwable -> L132
        if ((r128 instanceof Integer) == true) goto L106;
        r128 = null;
    L106:
        r118 = (Integer) r128;     // Catch: Throwable -> L132
        goto L130
    L108:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L111;
        r118 = Integer.valueOf(((Number) r117).intValue());     // Catch: Throwable -> L132
        goto L130
    L111:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L117;
        Long r129 = Long.valueOf(((Number) r117).longValue());     // Catch: Throwable -> L132
        if ((r129 instanceof Integer) == true) goto L115;
        r129 = null;
    L115:
        r118 = (Integer) r129;     // Catch: Throwable -> L132
    L117:
        if ((r117 instanceof JSONObject) == false) goto L119;
    L180:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L125
        Object r130 = SDKSettingsCacheManager.a().fromJson(r117.toString(), Integer.class);     // Catch: Throwable -> L125
        if ((r130 instanceof Integer) == true) goto L123;
        r130 = null;
    L123:
        Object r131 = Result.m9449constructorimpl((Integer) r130);     // Catch: Throwable -> L125
    L127:
        r118 = r131;
        if (Result.m9455isFailureimpl(r118) == false) goto L130;
    L125:
        th = move-exception;
        Result.Companion r132 = Result.Companion;     // Catch: Throwable -> L132
        r131 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L132
        goto L127
    L119:
        if ((r117 instanceof JSONArray) == false) goto L129;
    L89:
        r126 = r117;
    L132:
        th = move-exception;
        Result.Companion r133 = Result.Companion;     // Catch: Throwable -> L158
        r119 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L158
        goto L134
    L17:
        if ((r110 instanceof Integer) == true) goto L19;
        Object r134 = null;
    L20:
        r111 = (Integer) r134;     // Catch: Throwable -> L62
        if (r111 != null) goto L60;
        if ((r110 instanceof Number) == false) goto L47;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L32;
        Float r135 = Float.valueOf(((Number) r110).floatValue());     // Catch: Throwable -> L62
        if ((r135 instanceof Integer) == true) goto L30;
        r135 = null;
    L30:
        r111 = (Integer) r135;     // Catch: Throwable -> L62
        goto L60
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L38;
        Double r136 = Double.valueOf(((Number) r110).doubleValue());     // Catch: Throwable -> L62
        if ((r136 instanceof Integer) == true) goto L36;
        r136 = null;
    L36:
        r111 = (Integer) r136;     // Catch: Throwable -> L62
        goto L60
    L38:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L41;
        r111 = Integer.valueOf(((Number) r110).intValue());     // Catch: Throwable -> L62
        goto L60
    L41:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L47;
        Long r137 = Long.valueOf(((Number) r110).longValue());     // Catch: Throwable -> L62
        if ((r137 instanceof Integer) == true) goto L45;
        r137 = null;
    L45:
        r111 = (Integer) r137;     // Catch: Throwable -> L62
    L47:
        if ((r110 instanceof JSONObject) == false) goto L49;
    L190:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L55
        Object r138 = SDKSettingsCacheManager.a().fromJson(r110.toString(), Integer.class);     // Catch: Throwable -> L55
        if ((r138 instanceof Integer) == true) goto L53;
        r138 = null;
    L53:
        Object r139 = Result.m9449constructorimpl((Integer) r138);     // Catch: Throwable -> L55
    L57:
        r111 = r139;
        if (Result.m9455isFailureimpl(r111) == false) goto L60;
    L55:
        th = move-exception;
        Result.Companion r140 = Result.Companion;     // Catch: Throwable -> L62
        r139 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L62
        goto L57
    L49:
        if ((r110 instanceof JSONArray) == false) goto L59;
    L19:
        r134 = r110;
    L62:
        th = move-exception;
        Result.Companion r141 = Result.Companion;     // Catch: Throwable -> L167
        r112 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L167
    L167:
        th = move-exception;
        Result.Companion r142 = Result.Companion;
        Object r143 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r144 = Result.m9452exceptionOrNullimpl(r143);
        if (r144 == null) goto L172;
        EnsureManager.ensureNotReachHere(r144);
    L172:
        if (Result.m9455isFailureimpl(r143) == true) goto L175;
        r101 = r143;
    L175:
        r105 = r101;
        goto L177
    L192:
        return false;
    }

    static {
    }
}
