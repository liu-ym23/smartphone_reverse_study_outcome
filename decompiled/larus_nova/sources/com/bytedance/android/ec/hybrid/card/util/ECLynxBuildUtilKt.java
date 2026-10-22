package com.bytedance.android.ec.hybrid.card.util;

import android.net.Uri;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.hybrid.card.api.ECLynxLoadParam;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.services.apm.api.EnsureManager;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class ECLynxBuildUtilKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f46587a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f46588b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f46589c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f46590d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f46591e = null;

    public static final uj.c b() {
        return (uj.c) f46587a.getValue();
    }

    static {
        f46587a = LazyKt.lazy(ECLynxBuildUtilKt$shareGroupSetting$2.INSTANCE);
        int r100 = com.bytedance.android.ec.base.settings.a.f42813a;
        Object r101 = "";
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L166
        Object r103 = null;
        Object r104 = com.bytedance.android.ec.base.settings.d.f42818c.get("ec_gyl_share_group_page");     // Catch: Throwable -> L57
        if (r104 != null) goto L9;
    L54:
        Object r105 = null;
    L55:
        Object r106 = Result.m9449constructorimpl(r105);     // Catch: Throwable -> L57
    L59:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);     // Catch: Throwable -> L166
        if (r107 == null) goto L63;
        EnsureManager.ensureNotReachHere(r107);     // Catch: Throwable -> L166
    L63:
        if (Result.m9455isFailureimpl(r106) == false) goto L66;
        r106 = null;
    L66:
        if ((r106 instanceof String) == true) goto L68;
        r106 = null;
    L68:
        Object r108 = (String) r106;     // Catch: Throwable -> L166
        if (r108 != null) goto L75;
        Object r109 = com.bytedance.android.ec.base.settings.d.f42816a.get("ec_gyl_share_group_page");     // Catch: Throwable -> L166
        if ((r109 instanceof String) == true) goto L74;
        r109 = null;
    L74:
        r108 = (String) r109;     // Catch: Throwable -> L166
    L75:
        if (r108 != null) goto L175;
        int r110 = com.bytedance.android.ec.base.settings.c.f42815a;     // Catch: Throwable -> L166
        Object r111 = com.bytedance.android.ec.base.settings.d.f42818c.get("ec_gyl_share_group_page");     // Catch: Throwable -> L130
        if (r111 != null) goto L82;
    L127:
        Object r112 = null;
    L128:
        Object r113 = Result.m9449constructorimpl(r112);     // Catch: Throwable -> L130
    L132:
        Throwable r114 = Result.m9452exceptionOrNullimpl(r113);     // Catch: Throwable -> L156
        if (r114 == null) goto L136;
        EnsureManager.ensureNotReachHere(r114);     // Catch: Throwable -> L156
    L136:
        if (Result.m9455isFailureimpl(r113) == false) goto L139;
        r113 = null;
    L139:
        if ((r113 instanceof String) == true) goto L141;
        r113 = null;
    L141:
        r108 = (String) r113;     // Catch: Throwable -> L156
        if (r108 != null) goto L164;
        IHybridHostService r115 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L156
        if (r115 == null) goto L147;
        Object r116 = r115.getHostABValue("ec_gyl_share_group_page", "");     // Catch: Throwable -> L156
    L148:
        if (r116 != null) goto L150;
    L155:
        r108 = "";
        goto L164
    L150:
        if ((r116 instanceof String) == false) goto L153;
        r103 = r116;
    L153:
        Object r117 = (String) r103;     // Catch: Throwable -> L156
        if (r117 == null) goto L155;
    L163:
        r108 = r117;
        goto L164
    L147:
        r116 = null;
    L164:
        com.bytedance.android.ec.base.settings.d.d("ec_gyl_share_group_page", r108);     // Catch: Throwable -> L166
        goto L175
    L82:
        if ((r111 instanceof String) == true) goto L84;
        Object r118 = null;
    L85:
        r112 = (String) r118;     // Catch: Throwable -> L130
        if (r112 != null) goto L128;
        if ((r111 instanceof Number) == false) goto L115;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r119 = Float.valueOf(((Number) r111).floatValue());     // Catch: Throwable -> L130
        if ((r119 instanceof String) == true) goto L95;
        r119 = null;
    L95:
        r112 = (String) r119;     // Catch: Throwable -> L130
        goto L128
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r120 = Double.valueOf(((Number) r111).doubleValue());     // Catch: Throwable -> L130
        if ((r120 instanceof String) == true) goto L101;
        r120 = null;
    L101:
        r112 = (String) r120;     // Catch: Throwable -> L130
        goto L128
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L109;
        Integer r121 = Integer.valueOf(((Number) r111).intValue());     // Catch: Throwable -> L130
        if ((r121 instanceof String) == true) goto L107;
        r121 = null;
    L107:
        r112 = (String) r121;     // Catch: Throwable -> L130
        goto L128
    L109:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L115;
        Long r122 = Long.valueOf(((Number) r111).longValue());     // Catch: Throwable -> L130
        if ((r122 instanceof String) == true) goto L113;
        r122 = null;
    L113:
        r112 = (String) r122;     // Catch: Throwable -> L130
    L115:
        if ((r111 instanceof JSONObject) == false) goto L117;
    L177:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L123
        Object r123 = SDKSettingsCacheManager.a().fromJson(r111.toString(), String.class);     // Catch: Throwable -> L123
        if ((r123 instanceof String) == true) goto L121;
        r123 = null;
    L121:
        Object r124 = Result.m9449constructorimpl((String) r123);     // Catch: Throwable -> L123
    L125:
        r112 = r124;
        if (Result.m9455isFailureimpl(r112) == false) goto L128;
    L123:
        th = move-exception;
        Result.Companion r125 = Result.Companion;     // Catch: Throwable -> L130
        r124 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L130
        goto L125
    L117:
        if ((r111 instanceof JSONArray) == false) goto L127;
    L84:
        r118 = r111;
    L156:
        th = move-exception;
        Result.Companion r126 = Result.Companion;     // Catch: Throwable -> L166
        r117 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
        Throwable r127 = Result.m9452exceptionOrNullimpl(r117);     // Catch: Throwable -> L166
        if (r127 == null) goto L161;
        EnsureManager.ensureNotReachHere(r127);     // Catch: Throwable -> L166
    L161:
        if (Result.m9455isFailureimpl(r117) == false) goto L163;
        r117 = "";
    L130:
        th = move-exception;
        Result.Companion r128 = Result.Companion;     // Catch: Throwable -> L156
        r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L156
    L175:
        f46588b = (String) r108;
        f46590d = LazyKt.lazy(ECLynxBuildUtilKt$ignoreForestReusedRequestEnable$2.INSTANCE);
        f46591e = LazyKt.lazy(ECLynxBuildUtilKt$lynxPredecodeEnable$2.INSTANCE);
        return;
    L9:
        if ((r104 instanceof String) == true) goto L11;
        Object r129 = null;
    L12:
        r105 = (String) r129;     // Catch: Throwable -> L57
        if (r105 != null) goto L55;
        if ((r104 instanceof Number) == false) goto L42;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L24;
        Float r130 = Float.valueOf(((Number) r104).floatValue());     // Catch: Throwable -> L57
        if ((r130 instanceof String) == true) goto L22;
        r130 = null;
    L22:
        r105 = (String) r130;     // Catch: Throwable -> L57
        goto L55
    L24:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L30;
        Double r131 = Double.valueOf(((Number) r104).doubleValue());     // Catch: Throwable -> L57
        if ((r131 instanceof String) == true) goto L28;
        r131 = null;
    L28:
        r105 = (String) r131;     // Catch: Throwable -> L57
        goto L55
    L30:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L36;
        Integer r132 = Integer.valueOf(((Number) r104).intValue());     // Catch: Throwable -> L57
        if ((r132 instanceof String) == true) goto L34;
        r132 = null;
    L34:
        r105 = (String) r132;     // Catch: Throwable -> L57
        goto L55
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L42;
        Long r133 = Long.valueOf(((Number) r104).longValue());     // Catch: Throwable -> L57
        if ((r133 instanceof String) == true) goto L40;
        r133 = null;
    L40:
        r105 = (String) r133;     // Catch: Throwable -> L57
    L42:
        if ((r104 instanceof JSONObject) == false) goto L44;
    L185:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L50
        Object r134 = SDKSettingsCacheManager.a().fromJson(r104.toString(), String.class);     // Catch: Throwable -> L50
        if ((r134 instanceof String) == true) goto L48;
        r134 = null;
    L48:
        Object r135 = Result.m9449constructorimpl((String) r134);     // Catch: Throwable -> L50
    L52:
        r105 = r135;
        if (Result.m9455isFailureimpl(r105) == false) goto L55;
    L50:
        th = move-exception;
        Result.Companion r136 = Result.Companion;     // Catch: Throwable -> L57
        r135 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L57
        goto L52
    L44:
        if ((r104 instanceof JSONArray) == false) goto L54;
    L11:
        r129 = r104;
    L57:
        th = move-exception;
        Result.Companion r137 = Result.Companion;     // Catch: Throwable -> L166
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
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
        r108 = r101;
        goto L175
    }

    public static final void a(ECLynxLoadParam.a r100, uj.a r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$commonBuild");
        Intrinsics.checkNotNullParameter(r101, "config");
        if (r101.f550224a == null) goto L23;
        uj.c r102 = b();
        if (r102 == null) goto L23;
        if (r102.a() != true) goto L23;
        String r103 = r101.f550225b;
        String r104 = f46589c;
        if (r104 != null) goto L11;
    L14:
        boolean r105 = true;
    L15:
        if (r105 == false) goto L17;
    L21:
        uj.b r106 = new uj.b(r103);
        Intrinsics.checkNotNullParameter(r106, "group");
        r100.f46358w = r106;
        goto L23
    L17:
        if (StringsKt.contains$default(f46588b, r101.f550224a, false, 2, null) == false) goto L21;
        String r107 = f46589c;
        if (r107 == null) goto L21;
        r103 = r107;
        goto L21
    L11:
        if (r104.length() == 0) goto L14;
        r105 = false;
    L23:
        if (r101.f550224a == null) goto L32;
        uj.c r108 = b();
        if (r108 == null) goto L33;
        List<String> r109 = r108.c();
        if (r109 != null) goto L29;
        return;
    L29:
        if (r109.contains(r101.f550224a) != true) goto L35;
        r100.f46359x = true;
        return;
    L35:
        return;
    L33:
        return;
    }

    public static final Uri c(Uri r100, uj.b r101) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        Intrinsics.checkNotNullParameter(r101, "groupParams");
        Uri.Builder r102 = r100.buildUpon();
        if (UriProtector.getQueryParameter(r100, "group") != null) goto L6;
        r102.appendQueryParameter("group", r101.f550226a);
    L6:
        if (UriProtector.getQueryParameter(r100, "share_group") != null) goto L9;
        r102.appendQueryParameter("share_group", String.valueOf(r101.f550227b));
    L9:
        if (((Boolean) f46590d.getValue()).booleanValue() == false) goto L14;
        if (UriProtector.getQueryParameter(r100, "ignore_wait_reused_request") != null) goto L14;
        r102.appendQueryParameter("ignore_wait_reused_request", "1");
    L14:
        if (((Boolean) f46591e.getValue()).booleanValue() == false) goto L19;
        if (UriProtector.getQueryParameter(r100, "enable_lynx_predecode") != null) goto L19;
        r102.appendQueryParameter("enable_lynx_predecode", "1");
    L19:
        return r102.build();
    }
}
