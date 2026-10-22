package com.bytedance.android.shopping.buynow.utils;

import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.shopping.buynow.viewmodel.BuyNowViewModel;
import com.bytedance.services.apm.api.EnsureManager;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f171205a = 0;

    static {
    }

    public static boolean a(BuyNowViewModel r100) {
        Intrinsics.checkNotNullParameter(r100, "buyNowViewModel");
        Lazy r101 = ECSettingKeys.f43616a;
        int r102 = com.bytedance.android.ec.base.settings.a.f42813a;
        Object r103 = "0";
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L166
        Object r105 = null;
        Object r106 = com.bytedance.android.ec.base.settings.d.f42818c.get("standard_confirm_order_opt");     // Catch: Throwable -> L57
        if (r106 != null) goto L9;
    L54:
        Object r107 = null;
    L55:
        Object r108 = Result.m9449constructorimpl(r107);     // Catch: Throwable -> L57
    L59:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);     // Catch: Throwable -> L166
        if (r109 == null) goto L63;
        EnsureManager.ensureNotReachHere(r109);     // Catch: Throwable -> L166
    L63:
        if (Result.m9455isFailureimpl(r108) == false) goto L66;
        r108 = null;
    L66:
        if ((r108 instanceof String) == true) goto L68;
        r108 = null;
    L68:
        Object r110 = (String) r108;     // Catch: Throwable -> L166
        if (r110 != null) goto L75;
        Object r111 = com.bytedance.android.ec.base.settings.d.f42816a.get("standard_confirm_order_opt");     // Catch: Throwable -> L166
        if ((r111 instanceof String) == true) goto L74;
        r111 = null;
    L74:
        r110 = (String) r111;     // Catch: Throwable -> L166
    L75:
        if (r110 != null) goto L175;
        int r112 = com.bytedance.android.ec.base.settings.c.f42815a;     // Catch: Throwable -> L166
        Object r113 = com.bytedance.android.ec.base.settings.d.f42818c.get("standard_confirm_order_opt");     // Catch: Throwable -> L130
        if (r113 != null) goto L82;
    L127:
        Object r114 = null;
    L128:
        Object r115 = Result.m9449constructorimpl(r114);     // Catch: Throwable -> L130
    L132:
        Throwable r116 = Result.m9452exceptionOrNullimpl(r115);     // Catch: Throwable -> L156
        if (r116 == null) goto L136;
        EnsureManager.ensureNotReachHere(r116);     // Catch: Throwable -> L156
    L136:
        if (Result.m9455isFailureimpl(r115) == false) goto L139;
        r115 = null;
    L139:
        if ((r115 instanceof String) == true) goto L141;
        r115 = null;
    L141:
        r110 = (String) r115;     // Catch: Throwable -> L156
        if (r110 != null) goto L164;
        IHybridHostService r117 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L156
        if (r117 == null) goto L147;
        Object r118 = r117.getHostABValue("standard_confirm_order_opt", "0");     // Catch: Throwable -> L156
    L148:
        if (r118 != null) goto L150;
    L155:
        r110 = "0";
        goto L164
    L150:
        if ((r118 instanceof String) == false) goto L153;
        r105 = r118;
    L153:
        Object r119 = (String) r105;     // Catch: Throwable -> L156
        if (r119 == null) goto L155;
    L163:
        r110 = r119;
        goto L164
    L147:
        r118 = null;
    L164:
        com.bytedance.android.ec.base.settings.d.d("standard_confirm_order_opt", r110);     // Catch: Throwable -> L166
        goto L175
    L82:
        if ((r113 instanceof String) == true) goto L84;
        Object r120 = null;
    L85:
        r114 = (String) r120;     // Catch: Throwable -> L130
        if (r114 != null) goto L128;
        if ((r113 instanceof Number) == false) goto L115;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r121 = Float.valueOf(((Number) r113).floatValue());     // Catch: Throwable -> L130
        if ((r121 instanceof String) == true) goto L95;
        r121 = null;
    L95:
        r114 = (String) r121;     // Catch: Throwable -> L130
        goto L128
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r122 = Double.valueOf(((Number) r113).doubleValue());     // Catch: Throwable -> L130
        if ((r122 instanceof String) == true) goto L101;
        r122 = null;
    L101:
        r114 = (String) r122;     // Catch: Throwable -> L130
        goto L128
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L109;
        Integer r123 = Integer.valueOf(((Number) r113).intValue());     // Catch: Throwable -> L130
        if ((r123 instanceof String) == true) goto L107;
        r123 = null;
    L107:
        r114 = (String) r123;     // Catch: Throwable -> L130
        goto L128
    L109:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L115;
        Long r124 = Long.valueOf(((Number) r113).longValue());     // Catch: Throwable -> L130
        if ((r124 instanceof String) == true) goto L113;
        r124 = null;
    L113:
        r114 = (String) r124;     // Catch: Throwable -> L130
    L115:
        if ((r113 instanceof JSONObject) == false) goto L117;
    L188:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L123
        Object r125 = SDKSettingsCacheManager.a().fromJson(r113.toString(), String.class);     // Catch: Throwable -> L123
        if ((r125 instanceof String) == true) goto L121;
        r125 = null;
    L121:
        Object r126 = Result.m9449constructorimpl((String) r125);     // Catch: Throwable -> L123
    L125:
        r114 = r126;
        if (Result.m9455isFailureimpl(r114) == false) goto L128;
    L123:
        th = move-exception;
        Result.Companion r127 = Result.Companion;     // Catch: Throwable -> L130
        r126 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L130
        goto L125
    L117:
        if ((r113 instanceof JSONArray) == false) goto L127;
    L84:
        r120 = r113;
    L156:
        th = move-exception;
        Result.Companion r128 = Result.Companion;     // Catch: Throwable -> L166
        r119 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
        Throwable r129 = Result.m9452exceptionOrNullimpl(r119);     // Catch: Throwable -> L166
        if (r129 == null) goto L161;
        EnsureManager.ensureNotReachHere(r129);     // Catch: Throwable -> L166
    L161:
        if (Result.m9455isFailureimpl(r119) == false) goto L163;
        r119 = "0";
    L130:
        th = move-exception;
        Result.Companion r130 = Result.Companion;     // Catch: Throwable -> L156
        r115 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L156
    L175:
        String r131 = (String) r110;
        if (Intrinsics.areEqual(r131, "1") == true) goto L180;
        if (Intrinsics.areEqual(r131, "3") == true) goto L180;
    L186:
        return false;
    L180:
        if (ja3.a.c(r100.getStaticState().f171227a) == false) goto L186;
        if (r100.getStaticState().a() == false) goto L186;
        if (ja3.a.d(r100.getStaticState().f171227a) == true) goto L186;
        return true;
    L9:
        if ((r106 instanceof String) == true) goto L11;
        Object r132 = null;
    L12:
        r107 = (String) r132;     // Catch: Throwable -> L57
        if (r107 != null) goto L55;
        if ((r106 instanceof Number) == false) goto L42;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L24;
        Float r133 = Float.valueOf(((Number) r106).floatValue());     // Catch: Throwable -> L57
        if ((r133 instanceof String) == true) goto L22;
        r133 = null;
    L22:
        r107 = (String) r133;     // Catch: Throwable -> L57
        goto L55
    L24:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L30;
        Double r134 = Double.valueOf(((Number) r106).doubleValue());     // Catch: Throwable -> L57
        if ((r134 instanceof String) == true) goto L28;
        r134 = null;
    L28:
        r107 = (String) r134;     // Catch: Throwable -> L57
        goto L55
    L30:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L36;
        Integer r135 = Integer.valueOf(((Number) r106).intValue());     // Catch: Throwable -> L57
        if ((r135 instanceof String) == true) goto L34;
        r135 = null;
    L34:
        r107 = (String) r135;     // Catch: Throwable -> L57
        goto L55
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L42;
        Long r136 = Long.valueOf(((Number) r106).longValue());     // Catch: Throwable -> L57
        if ((r136 instanceof String) == true) goto L40;
        r136 = null;
    L40:
        r107 = (String) r136;     // Catch: Throwable -> L57
    L42:
        if ((r106 instanceof JSONObject) == false) goto L44;
    L196:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L50
        Object r137 = SDKSettingsCacheManager.a().fromJson(r106.toString(), String.class);     // Catch: Throwable -> L50
        if ((r137 instanceof String) == true) goto L48;
        r137 = null;
    L48:
        Object r138 = Result.m9449constructorimpl((String) r137);     // Catch: Throwable -> L50
    L52:
        r107 = r138;
        if (Result.m9455isFailureimpl(r107) == false) goto L55;
    L50:
        th = move-exception;
        Result.Companion r139 = Result.Companion;     // Catch: Throwable -> L57
        r138 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L57
        goto L52
    L44:
        if ((r106 instanceof JSONArray) == false) goto L54;
    L11:
        r132 = r106;
    L57:
        th = move-exception;
        Result.Companion r140 = Result.Companion;     // Catch: Throwable -> L166
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
    L166:
        th = move-exception;
        Result.Companion r141 = Result.Companion;
        Object r142 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r143 = Result.m9452exceptionOrNullimpl(r142);
        if (r143 == null) goto L171;
        EnsureManager.ensureNotReachHere(r143);
    L171:
        if (Result.m9455isFailureimpl(r142) == true) goto L174;
        r103 = r142;
    L174:
        r110 = r103;
        goto L175
    }
}
