package com.bytedance.android.ec.core.opt.ab;

import com.bytedance.android.ec.ab.opt.HostExperimentKey;
import com.bytedance.android.ec.ab.opt.OptSetting;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.hybrid.hostapi.IECHybridKevaService;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.dataplatform.config.SettingPanel;
import com.bytedance.services.apm.api.EnsureManager;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
@OptSetting(business = "大佬们，拆分出去吧，特别是交易的人！！！诶...")
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f45223a = 0;

    @HostExperimentKey
    public static final int a() {
        int r100 = m.f45240a;
        Object r101 = 0;
        boolean r102 = ECServiceManager.f42805a;
        s83.g r103 = (s83.g) ECServiceManager.c(s83.g.class);
        if (r103 == null) goto L8;
        s83.a r104 = r103.q();
        if (r104 == null) goto L8;
        Object r105 = r104.e("ec_anim_delay");
        if (r105 == null) goto L8;
    L175:
        return ((Number) r105).intValue();
    L8:
        int r106 = n.f45241a;
        int r107 = com.bytedance.android.ec.base.settings.a.f42813a;
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L165
        Object r109 = null;
        Object r110 = com.bytedance.android.ec.base.settings.d.f42818c.get("ec_anim_delay");     // Catch: Throwable -> L60
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
        Object r115 = com.bytedance.android.ec.base.settings.d.f42816a.get("ec_anim_delay");     // Catch: Throwable -> L165
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
        Object r117 = com.bytedance.android.ec.base.settings.d.f42818c.get("ec_anim_delay");     // Catch: Throwable -> L130
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
        com.bytedance.android.ec.base.settings.d.d("ec_anim_delay", r105);     // Catch: Throwable -> L165
        goto L175
    L144:
        IHybridHostService r122 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L156
        if (r122 == null) goto L147;
        Object r123 = r122.getHostABValue("ec_anim_delay", r101);     // Catch: Throwable -> L156
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
    public static final boolean b() {
        int r100 = m.f45240a;
        Object r101 = 0;
        boolean r102 = ECServiceManager.f42805a;
        s83.g r103 = (s83.g) ECServiceManager.c(s83.g.class);
        if (r103 == null) goto L8;
        s83.a r104 = r103.q();
        if (r104 == null) goto L8;
        Object r105 = r104.e("ec_half_detail_query_entry_show");
        if (r105 == null) goto L8;
    L175:
        if (((Number) r105).intValue() != 1) goto L189;
        return true;
    L189:
        return false;
    L8:
        int r106 = n.f45241a;
        int r107 = com.bytedance.android.ec.base.settings.a.f42813a;
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L165
        Object r109 = null;
        Object r110 = com.bytedance.android.ec.base.settings.d.f42818c.get("ec_half_detail_query_entry_show");     // Catch: Throwable -> L60
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
        Object r115 = com.bytedance.android.ec.base.settings.d.f42816a.get("ec_half_detail_query_entry_show");     // Catch: Throwable -> L165
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
        Object r117 = com.bytedance.android.ec.base.settings.d.f42818c.get("ec_half_detail_query_entry_show");     // Catch: Throwable -> L130
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
        com.bytedance.android.ec.base.settings.d.d("ec_half_detail_query_entry_show", r105);     // Catch: Throwable -> L165
        goto L175
    L144:
        IHybridHostService r122 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L156
        if (r122 == null) goto L147;
        Object r123 = r122.getHostABValue("ec_half_detail_query_entry_show", r101);     // Catch: Throwable -> L156
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
    L185:
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
    L183:
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

    public static final int c() {
        int r100 = n.f45241a;
        Object r101 = 0;
        int r102 = com.bytedance.android.ec.base.settings.a.f42813a;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L160
        Object r104 = null;
        Object r105 = com.bytedance.android.ec.base.settings.d.f42818c.get("iesec_ad_popup");     // Catch: Throwable -> L54
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
        Object r110 = com.bytedance.android.ec.base.settings.d.f42816a.get("iesec_ad_popup");     // Catch: Throwable -> L160
        if ((r110 instanceof Integer) == true) goto L71;
        r110 = null;
    L71:
        r109 = (Integer) r110;     // Catch: Throwable -> L160
    L72:
        if (r109 != null) goto L170;
        int r111 = com.bytedance.android.ec.base.settings.c.f42815a;     // Catch: Throwable -> L160
        Object r112 = com.bytedance.android.ec.base.settings.d.f42818c.get("iesec_ad_popup");     // Catch: Throwable -> L124
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
        Object r117 = r116.getHostABValue("iesec_ad_popup", r101);     // Catch: Throwable -> L150
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
        com.bytedance.android.ec.base.settings.d.d("iesec_ad_popup", r109);     // Catch: Throwable -> L160
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

    @SettingPanel("商详顶部测评视频交互优化-已固化")
    public static final boolean d() {
        int r100 = com.bytedance.android.ec.base.settings.b.f42814a;
        int r101 = com.bytedance.android.ec.core.abtest.e.f43640a;
        Object r102 = com.bytedance.android.ec.core.abtest.e.a(1, 0);
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L166
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L166
        SDKSettingsCacheManager r104 = SDKSettingsCacheManager.f42812e;     // Catch: Throwable -> L166
        Object r105 = null;
        r104.getClass();     // Catch: Throwable -> L56
        Object r106 = SDKSettingsCacheManager.f42809b.get("iesec_kol_video_evaluation_detail");     // Catch: Throwable -> L56
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
        Object r111 = SDKSettingsCacheManager.f42808a.get("iesec_kol_video_evaluation_detail");     // Catch: Throwable -> L166
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
        if (Result.m9452exceptionOrNullimpl(r114) != null) goto L188;
    L163:
        r110 = r114;
    L164:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L166
        SDKSettingsCacheManager.e("iesec_kol_video_evaluation_detail", r110);     // Catch: Throwable -> L166
        goto L176
    L188:
        r114 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("iesec_kol_video_evaluation_detail", Integer.class, r102);     // Catch: Throwable -> L160
    L161:
        if (r114 != null) goto L163;
        r110 = r102;
    L160:
        r114 = r102;
        goto L161
    L182:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L127
        Object r115 = SDKSettingsCacheManager.f42809b.get("iesec_kol_video_evaluation_detail");     // Catch: Throwable -> L127
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
        r114 = (Integer) r117;     // Catch: Throwable -> L153
        if (r114 != null) goto L163;
        jj4.b r119 = jj4.b.f499326b;     // Catch: Throwable -> L153
        Object r120 = jj4.a.a("iesec_kol_video_evaluation_detail", Integer.class, r102, false);     // Catch: Throwable -> L153
        if (r120 != null) goto L145;
        Intrinsics.throwNpe();     // Catch: Throwable -> L153
    L145:
        if ((r120 instanceof Integer) == false) goto L148;
        r105 = r120;
    L148:
        Object r121 = (Integer) r105;     // Catch: Throwable -> L153
        if (r121 != null) goto L151;
        r121 = r102;
    L151:
        r114 = Result.m9449constructorimpl(r121);     // Catch: Throwable -> L153
    L82:
        if ((r115 instanceof Integer) == true) goto L84;
        Object r122 = null;
    L85:
        r116 = (Integer) r122;     // Catch: Throwable -> L127
        if (r116 != null) goto L125;
        if ((r115 instanceof Number) == false) goto L112;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r123 = Float.valueOf(((Number) r115).floatValue());     // Catch: Throwable -> L127
        if ((r123 instanceof Integer) == true) goto L95;
        r123 = null;
    L95:
        r116 = (Integer) r123;     // Catch: Throwable -> L127
        goto L125
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r124 = Double.valueOf(((Number) r115).doubleValue());     // Catch: Throwable -> L127
        if ((r124 instanceof Integer) == true) goto L101;
        r124 = null;
    L101:
        r116 = (Integer) r124;     // Catch: Throwable -> L127
        goto L125
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L106;
        r116 = Integer.valueOf(((Number) r115).intValue());     // Catch: Throwable -> L127
        goto L125
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L112;
        Long r125 = Long.valueOf(((Number) r115).longValue());     // Catch: Throwable -> L127
        if ((r125 instanceof Integer) == true) goto L110;
        r125 = null;
    L110:
        r116 = (Integer) r125;     // Catch: Throwable -> L127
    L112:
        if ((r115 instanceof JSONObject) == false) goto L114;
    L192:
        Object r126 = SDKSettingsCacheManager.a().fromJson(r115.toString(), Integer.class);     // Catch: Throwable -> L120
        if ((r126 instanceof Integer) == true) goto L118;
        r126 = null;
    L118:
        Object r127 = Result.m9449constructorimpl((Integer) r126);     // Catch: Throwable -> L120
    L122:
        r116 = r127;
        if (Result.m9455isFailureimpl(r116) == false) goto L125;
    L120:
        th = move-exception;
        Result.Companion r128 = Result.Companion;     // Catch: Throwable -> L127
        r127 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L127
        goto L122
    L114:
        if ((r115 instanceof JSONArray) == false) goto L124;
    L84:
        r122 = r115;
    L127:
        th = move-exception;
        Result.Companion r129 = Result.Companion;     // Catch: Throwable -> L153
        r117 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L153
    L176:
        if (((Number) r110).intValue() == 1) goto L194;
        return false;
    L194:
        return true;
    L11:
        if ((r106 instanceof Integer) == true) goto L13;
        Object r130 = null;
    L14:
        r107 = (Integer) r130;     // Catch: Throwable -> L56
        if (r107 != null) goto L54;
        if ((r106 instanceof Number) == false) goto L41;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r131 = Float.valueOf(((Number) r106).floatValue());     // Catch: Throwable -> L56
        if ((r131 instanceof Integer) == true) goto L24;
        r131 = null;
    L24:
        r107 = (Integer) r131;     // Catch: Throwable -> L56
        goto L54
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r132 = Double.valueOf(((Number) r106).doubleValue());     // Catch: Throwable -> L56
        if ((r132 instanceof Integer) == true) goto L30;
        r132 = null;
    L30:
        r107 = (Integer) r132;     // Catch: Throwable -> L56
        goto L54
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L35;
        r107 = Integer.valueOf(((Number) r106).intValue());     // Catch: Throwable -> L56
        goto L54
    L35:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L41;
        Long r133 = Long.valueOf(((Number) r106).longValue());     // Catch: Throwable -> L56
        if ((r133 instanceof Integer) == true) goto L39;
        r133 = null;
    L39:
        r107 = (Integer) r133;     // Catch: Throwable -> L56
    L41:
        if ((r106 instanceof JSONObject) == false) goto L43;
    L186:
        Object r134 = SDKSettingsCacheManager.a().fromJson(r106.toString(), Integer.class);     // Catch: Throwable -> L49
        if ((r134 instanceof Integer) == true) goto L47;
        r134 = null;
    L47:
        Object r135 = Result.m9449constructorimpl((Integer) r134);     // Catch: Throwable -> L49
    L51:
        r107 = r135;
        if (Result.m9455isFailureimpl(r107) == false) goto L54;
    L49:
        th = move-exception;
        Result.Companion r136 = Result.Companion;     // Catch: Throwable -> L56
        r135 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L56
        goto L51
    L43:
        if ((r106 instanceof JSONArray) == false) goto L53;
    L13:
        r130 = r106;
    L56:
        th = move-exception;
        Result.Companion r137 = Result.Companion;     // Catch: Throwable -> L166
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
    L166:
        th = move-exception;
        Result.Companion r138 = Result.Companion;
        Object r139 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r140 = Result.m9452exceptionOrNullimpl(r139);
        if (r140 == null) goto L171;
        EnsureManager.ensureNotReachHere(r140);
    L171:
        if (Result.m9455isFailureimpl(r139) == true) goto L174;
        r102 = r139;
    L174:
        r110 = r102;
        goto L176
    }

    public static final boolean e() {
        int r100 = n.f45241a;
        Object r101 = Boolean.FALSE;
        int r102 = com.bytedance.android.ec.base.settings.a.f42813a;
        Object r103 = null;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L163
        Object r105 = com.bytedance.android.ec.base.settings.d.f42818c.get("detail_favorite_bff");     // Catch: Throwable -> L56
        if (r105 != null) goto L8;
    L53:
        Object r106 = null;
    L54:
        Object r107 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L56
    L58:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);     // Catch: Throwable -> L163
        if (r108 == null) goto L62;
        EnsureManager.ensureNotReachHere(r108);     // Catch: Throwable -> L163
    L62:
        if (Result.m9455isFailureimpl(r107) == false) goto L65;
        r107 = null;
    L65:
        if ((r107 instanceof Boolean) == true) goto L67;
        r107 = null;
    L67:
        Object r109 = (Boolean) r107;     // Catch: Throwable -> L163
        if (r109 != null) goto L74;
        Object r110 = com.bytedance.android.ec.base.settings.d.f42816a.get("detail_favorite_bff");     // Catch: Throwable -> L163
        if ((r110 instanceof Boolean) == true) goto L73;
        r110 = null;
    L73:
        r109 = (Boolean) r110;     // Catch: Throwable -> L163
    L74:
        if (r109 != null) goto L173;
        int r111 = com.bytedance.android.ec.base.settings.c.f42815a;     // Catch: Throwable -> L163
        Object r112 = com.bytedance.android.ec.base.settings.d.f42818c.get("detail_favorite_bff");     // Catch: Throwable -> L129
        if (r112 != null) goto L81;
    L126:
        Object r113 = null;
    L127:
        Object r114 = Result.m9449constructorimpl(r113);     // Catch: Throwable -> L129
    L131:
        Throwable r115 = Result.m9452exceptionOrNullimpl(r114);     // Catch: Throwable -> L154
        if (r115 == null) goto L135;
        EnsureManager.ensureNotReachHere(r115);     // Catch: Throwable -> L154
    L135:
        if (Result.m9455isFailureimpl(r114) == false) goto L138;
        r114 = null;
    L138:
        if ((r114 instanceof Boolean) == true) goto L140;
        r114 = null;
    L140:
        r109 = (Boolean) r114;     // Catch: Throwable -> L154
        if (r109 != null) goto L161;
        IHybridHostService r116 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L154
        if (r116 == null) goto L146;
        Object r117 = r116.getHostABValue("detail_favorite_bff", r101);     // Catch: Throwable -> L154
    L147:
        if (r117 != null) goto L149;
    L160:
        r109 = r101;
        goto L161
    L149:
        if ((r117 instanceof Boolean) == true) goto L151;
        r117 = null;
    L151:
        r109 = (Boolean) r117;     // Catch: Throwable -> L154
        if (r109 != null) goto L161;
    L146:
        r117 = null;
    L161:
        com.bytedance.android.ec.base.settings.d.d("detail_favorite_bff", r109);     // Catch: Throwable -> L163
        goto L173
    L81:
        if ((r112 instanceof Boolean) == true) goto L83;
        Object r118 = null;
    L84:
        r113 = (Boolean) r118;     // Catch: Throwable -> L129
        if (r113 != null) goto L127;
        if ((r112 instanceof Number) == false) goto L114;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L96;
        Float r119 = Float.valueOf(((Number) r112).floatValue());     // Catch: Throwable -> L129
        if ((r119 instanceof Boolean) == true) goto L94;
        r119 = null;
    L94:
        r113 = (Boolean) r119;     // Catch: Throwable -> L129
        goto L127
    L96:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L102;
        Double r120 = Double.valueOf(((Number) r112).doubleValue());     // Catch: Throwable -> L129
        if ((r120 instanceof Boolean) == true) goto L100;
        r120 = null;
    L100:
        r113 = (Boolean) r120;     // Catch: Throwable -> L129
        goto L127
    L102:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L108;
        Integer r121 = Integer.valueOf(((Number) r112).intValue());     // Catch: Throwable -> L129
        if ((r121 instanceof Boolean) == true) goto L106;
        r121 = null;
    L106:
        r113 = (Boolean) r121;     // Catch: Throwable -> L129
        goto L127
    L108:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L114;
        Long r122 = Long.valueOf(((Number) r112).longValue());     // Catch: Throwable -> L129
        if ((r122 instanceof Boolean) == true) goto L112;
        r122 = null;
    L112:
        r113 = (Boolean) r122;     // Catch: Throwable -> L129
    L114:
        if ((r112 instanceof JSONObject) == false) goto L116;
    L365:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L122
        Object r123 = SDKSettingsCacheManager.a().fromJson(r112.toString(), Boolean.class);     // Catch: Throwable -> L122
        if ((r123 instanceof Boolean) == true) goto L120;
        r123 = null;
    L120:
        Object r124 = Result.m9449constructorimpl((Boolean) r123);     // Catch: Throwable -> L122
    L124:
        r113 = r124;
        if (Result.m9455isFailureimpl(r113) == false) goto L127;
    L122:
        th = move-exception;
        Result.Companion r125 = Result.Companion;     // Catch: Throwable -> L129
        r124 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L129
        goto L124
    L116:
        if ((r112 instanceof JSONArray) == false) goto L126;
    L83:
        r118 = r112;
    L154:
        th = move-exception;
        Result.Companion r126 = Result.Companion;     // Catch: Throwable -> L163
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
        Throwable r127 = Result.m9452exceptionOrNullimpl(r109);     // Catch: Throwable -> L163
        if (r127 == null) goto L159;
        EnsureManager.ensureNotReachHere(r127);     // Catch: Throwable -> L163
    L159:
        if (Result.m9455isFailureimpl(r109) == false) goto L161;
    L129:
        th = move-exception;
        Result.Companion r128 = Result.Companion;     // Catch: Throwable -> L154
        r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L154
    L173:
        if (((Boolean) r109).booleanValue() == true) goto L352;
        int r129 = com.bytedance.android.ec.base.settings.b.f42814a;
        Object r130 = Boolean.FALSE;
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L341
        SDKSettingsCacheManager r131 = SDKSettingsCacheManager.f42812e;     // Catch: Throwable -> L341
        r131.getClass();     // Catch: Throwable -> L228
        Object r132 = SDKSettingsCacheManager.f42809b.get("detail_favorite_bff");     // Catch: Throwable -> L228
        if (r132 != null) goto L180;
    L225:
        Object r133 = null;
    L226:
        Object r134 = Result.m9449constructorimpl(r133);     // Catch: Throwable -> L228
    L230:
        Throwable r135 = Result.m9452exceptionOrNullimpl(r134);     // Catch: Throwable -> L341
        if (r135 == null) goto L234;
        EnsureManager.ensureNotReachHere(r135);     // Catch: Throwable -> L341
    L234:
        if (Result.m9455isFailureimpl(r134) == false) goto L237;
        r134 = null;
    L237:
        if ((r134 instanceof Boolean) == true) goto L239;
        r134 = null;
    L239:
        Object r136 = (Boolean) r134;     // Catch: Throwable -> L341
        if (r136 != null) goto L246;
        r131.getClass();     // Catch: Throwable -> L341
        Object r137 = SDKSettingsCacheManager.f42808a.get("detail_favorite_bff");     // Catch: Throwable -> L341
        if ((r137 instanceof Boolean) == true) goto L245;
        r137 = null;
    L245:
        r136 = (Boolean) r137;     // Catch: Throwable -> L341
    L246:
        if (r136 != null) goto L351;
        int r138 = com.bytedance.android.ec.base.settings.g.f42821a;     // Catch: Throwable -> L341
    L328:
        th = move-exception;
        Result.Companion r139 = Result.Companion;     // Catch: Throwable -> L341
        Object r140 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L341
    L331:
        if (Result.m9452exceptionOrNullimpl(r140) != null) goto L371;
    L338:
        r136 = r140;
    L339:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L341
        SDKSettingsCacheManager.e("detail_favorite_bff", r136);     // Catch: Throwable -> L341
        goto L351
    L371:
        r140 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("detail_favorite_bff", Boolean.class, r130);     // Catch: Throwable -> L335
    L336:
        if (r140 != null) goto L338;
        r136 = r130;
    L335:
        r140 = r130;
        goto L336
    L363:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L302
        Object r141 = SDKSettingsCacheManager.f42809b.get("detail_favorite_bff");     // Catch: Throwable -> L302
        if (r141 != null) goto L254;
    L299:
        Object r142 = null;
    L300:
        Object r143 = Result.m9449constructorimpl(r142);     // Catch: Throwable -> L302
    L304:
        Throwable r144 = Result.m9452exceptionOrNullimpl(r143);     // Catch: Throwable -> L328
        if (r144 == null) goto L308;
        EnsureManager.ensureNotReachHere(r144);     // Catch: Throwable -> L328
    L308:
        if (Result.m9455isFailureimpl(r143) == false) goto L311;
        r143 = null;
    L311:
        if ((r143 instanceof Boolean) == true) goto L313;
        r143 = null;
    L313:
        Boolean r145 = (Boolean) r143;     // Catch: Throwable -> L328
        if (r145 == null) goto L316;
        r136 = r145;
        goto L339
    L316:
        jj4.b r146 = jj4.b.f499326b;     // Catch: Throwable -> L328
        Object r147 = jj4.a.a("detail_favorite_bff", Boolean.class, r130, false);     // Catch: Throwable -> L328
        if (r147 != null) goto L320;
        Intrinsics.throwNpe();     // Catch: Throwable -> L328
    L320:
        if ((r147 instanceof Boolean) == false) goto L323;
        r103 = r147;
    L323:
        Object r148 = (Boolean) r103;     // Catch: Throwable -> L328
        if (r148 != null) goto L326;
        r148 = r130;
    L326:
        r140 = Result.m9449constructorimpl(r148);     // Catch: Throwable -> L328
    L254:
        if ((r141 instanceof Boolean) == true) goto L256;
        Object r149 = null;
    L257:
        r142 = (Boolean) r149;     // Catch: Throwable -> L302
        if (r142 != null) goto L300;
        if ((r141 instanceof Number) == false) goto L287;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L269;
        Float r150 = Float.valueOf(((Number) r141).floatValue());     // Catch: Throwable -> L302
        if ((r150 instanceof Boolean) == true) goto L267;
        r150 = null;
    L267:
        r142 = (Boolean) r150;     // Catch: Throwable -> L302
        goto L300
    L269:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L275;
        Double r151 = Double.valueOf(((Number) r141).doubleValue());     // Catch: Throwable -> L302
        if ((r151 instanceof Boolean) == true) goto L273;
        r151 = null;
    L273:
        r142 = (Boolean) r151;     // Catch: Throwable -> L302
        goto L300
    L275:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L281;
        Integer r152 = Integer.valueOf(((Number) r141).intValue());     // Catch: Throwable -> L302
        if ((r152 instanceof Boolean) == true) goto L279;
        r152 = null;
    L279:
        r142 = (Boolean) r152;     // Catch: Throwable -> L302
        goto L300
    L281:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L287;
        Long r153 = Long.valueOf(((Number) r141).longValue());     // Catch: Throwable -> L302
        if ((r153 instanceof Boolean) == true) goto L285;
        r153 = null;
    L285:
        r142 = (Boolean) r153;     // Catch: Throwable -> L302
    L287:
        if ((r141 instanceof JSONObject) == false) goto L289;
    L369:
        Object r154 = SDKSettingsCacheManager.a().fromJson(r141.toString(), Boolean.class);     // Catch: Throwable -> L295
        if ((r154 instanceof Boolean) == true) goto L293;
        r154 = null;
    L293:
        Object r155 = Result.m9449constructorimpl((Boolean) r154);     // Catch: Throwable -> L295
    L297:
        r142 = r155;
        if (Result.m9455isFailureimpl(r142) == false) goto L300;
    L295:
        th = move-exception;
        Result.Companion r156 = Result.Companion;     // Catch: Throwable -> L302
        r155 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L302
        goto L297
    L289:
        if ((r141 instanceof JSONArray) == false) goto L299;
    L256:
        r149 = r141;
    L302:
        th = move-exception;
        Result.Companion r157 = Result.Companion;     // Catch: Throwable -> L328
        r143 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L328
    L351:
        if (((Boolean) r136).booleanValue() == true) goto L352;
        return false;
    L180:
        if ((r132 instanceof Boolean) == true) goto L182;
        Object r158 = null;
    L183:
        r133 = (Boolean) r158;     // Catch: Throwable -> L228
        if (r133 != null) goto L226;
        if ((r132 instanceof Number) == false) goto L213;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L195;
        Float r159 = Float.valueOf(((Number) r132).floatValue());     // Catch: Throwable -> L228
        if ((r159 instanceof Boolean) == true) goto L193;
        r159 = null;
    L193:
        r133 = (Boolean) r159;     // Catch: Throwable -> L228
        goto L226
    L195:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L201;
        Double r160 = Double.valueOf(((Number) r132).doubleValue());     // Catch: Throwable -> L228
        if ((r160 instanceof Boolean) == true) goto L199;
        r160 = null;
    L199:
        r133 = (Boolean) r160;     // Catch: Throwable -> L228
        goto L226
    L201:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L207;
        Integer r161 = Integer.valueOf(((Number) r132).intValue());     // Catch: Throwable -> L228
        if ((r161 instanceof Boolean) == true) goto L205;
        r161 = null;
    L205:
        r133 = (Boolean) r161;     // Catch: Throwable -> L228
        goto L226
    L207:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L213;
        Long r162 = Long.valueOf(((Number) r132).longValue());     // Catch: Throwable -> L228
        if ((r162 instanceof Boolean) == true) goto L211;
        r162 = null;
    L211:
        r133 = (Boolean) r162;     // Catch: Throwable -> L228
    L213:
        if ((r132 instanceof JSONObject) == false) goto L215;
    L361:
        Object r163 = SDKSettingsCacheManager.a().fromJson(r132.toString(), Boolean.class);     // Catch: Throwable -> L221
        if ((r163 instanceof Boolean) == true) goto L219;
        r163 = null;
    L219:
        Object r164 = Result.m9449constructorimpl((Boolean) r163);     // Catch: Throwable -> L221
    L223:
        r133 = r164;
        if (Result.m9455isFailureimpl(r133) == false) goto L226;
    L221:
        th = move-exception;
        Result.Companion r165 = Result.Companion;     // Catch: Throwable -> L228
        r164 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L228
        goto L223
    L215:
        if ((r132 instanceof JSONArray) == false) goto L225;
    L182:
        r158 = r132;
    L228:
        th = move-exception;
        Result.Companion r166 = Result.Companion;     // Catch: Throwable -> L341
        r134 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L341
    L341:
        th = move-exception;
        Result.Companion r167 = Result.Companion;
        Object r168 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r169 = Result.m9452exceptionOrNullimpl(r168);
        if (r169 == null) goto L346;
        EnsureManager.ensureNotReachHere(r169);
    L346:
        if (Result.m9455isFailureimpl(r168) == true) goto L349;
        r130 = r168;
    L349:
        r136 = r130;
    L352:
        return true;
    L8:
        if ((r105 instanceof Boolean) == true) goto L10;
        Object r170 = null;
    L11:
        r106 = (Boolean) r170;     // Catch: Throwable -> L56
        if (r106 != null) goto L54;
        if ((r105 instanceof Number) == false) goto L41;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L23;
        Float r171 = Float.valueOf(((Number) r105).floatValue());     // Catch: Throwable -> L56
        if ((r171 instanceof Boolean) == true) goto L21;
        r171 = null;
    L21:
        r106 = (Boolean) r171;     // Catch: Throwable -> L56
        goto L54
    L23:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L29;
        Double r172 = Double.valueOf(((Number) r105).doubleValue());     // Catch: Throwable -> L56
        if ((r172 instanceof Boolean) == true) goto L27;
        r172 = null;
    L27:
        r106 = (Boolean) r172;     // Catch: Throwable -> L56
        goto L54
    L29:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L35;
        Integer r173 = Integer.valueOf(((Number) r105).intValue());     // Catch: Throwable -> L56
        if ((r173 instanceof Boolean) == true) goto L33;
        r173 = null;
    L33:
        r106 = (Boolean) r173;     // Catch: Throwable -> L56
        goto L54
    L35:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L41;
        Long r174 = Long.valueOf(((Number) r105).longValue());     // Catch: Throwable -> L56
        if ((r174 instanceof Boolean) == true) goto L39;
        r174 = null;
    L39:
        r106 = (Boolean) r174;     // Catch: Throwable -> L56
    L41:
        if ((r105 instanceof JSONObject) == false) goto L43;
    L358:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L49
        Object r175 = SDKSettingsCacheManager.a().fromJson(r105.toString(), Boolean.class);     // Catch: Throwable -> L49
        if ((r175 instanceof Boolean) == true) goto L47;
        r175 = null;
    L47:
        Object r176 = Result.m9449constructorimpl((Boolean) r175);     // Catch: Throwable -> L49
    L51:
        r106 = r176;
        if (Result.m9455isFailureimpl(r106) == false) goto L54;
    L49:
        th = move-exception;
        Result.Companion r177 = Result.Companion;     // Catch: Throwable -> L56
        r176 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L56
        goto L51
    L43:
        if ((r105 instanceof JSONArray) == false) goto L53;
    L10:
        r170 = r105;
    L56:
        th = move-exception;
        Result.Companion r178 = Result.Companion;     // Catch: Throwable -> L163
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
    L163:
        th = move-exception;
        Result.Companion r179 = Result.Companion;
        Object r180 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r181 = Result.m9452exceptionOrNullimpl(r180);
        if (r181 == null) goto L168;
        EnsureManager.ensureNotReachHere(r181);
    L168:
        if (Result.m9455isFailureimpl(r180) == true) goto L171;
        r101 = r180;
    L171:
        r109 = r101;
        goto L173
    }

    @HostExperimentKey
    public static final int f() {
        int r100 = n.f45241a;
        Object r101 = 0;
        int r102 = com.bytedance.android.ec.base.settings.a.f42813a;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L160
        Object r104 = null;
        Object r105 = com.bytedance.android.ec.base.settings.d.f42818c.get("ec_video_performance_opt");     // Catch: Throwable -> L54
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
        Object r110 = com.bytedance.android.ec.base.settings.d.f42816a.get("ec_video_performance_opt");     // Catch: Throwable -> L160
        if ((r110 instanceof Integer) == true) goto L71;
        r110 = null;
    L71:
        r109 = (Integer) r110;     // Catch: Throwable -> L160
    L72:
        if (r109 != null) goto L170;
        int r111 = com.bytedance.android.ec.base.settings.c.f42815a;     // Catch: Throwable -> L160
        Object r112 = com.bytedance.android.ec.base.settings.d.f42818c.get("ec_video_performance_opt");     // Catch: Throwable -> L124
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
        Object r117 = r116.getHostABValue("ec_video_performance_opt", r101);     // Catch: Throwable -> L150
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
        com.bytedance.android.ec.base.settings.d.d("ec_video_performance_opt", r109);     // Catch: Throwable -> L160
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

    @HostExperimentKey
    public static final boolean g() {
        int r100 = m.f45240a;
        Object r101 = 0;
        boolean r102 = ECServiceManager.f42805a;
        s83.g r103 = (s83.g) ECServiceManager.c(s83.g.class);
        if (r103 == null) goto L8;
        s83.a r104 = r103.q();
        if (r104 == null) goto L8;
        Object r105 = r104.e("order_list_cache_android");
        if (r105 == null) goto L8;
    L175:
        if (((Number) r105).intValue() != 1) goto L189;
        return true;
    L189:
        return false;
    L8:
        int r106 = n.f45241a;
        int r107 = com.bytedance.android.ec.base.settings.a.f42813a;
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L165
        Object r109 = null;
        Object r110 = com.bytedance.android.ec.base.settings.d.f42818c.get("order_list_cache_android");     // Catch: Throwable -> L60
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
        Object r115 = com.bytedance.android.ec.base.settings.d.f42816a.get("order_list_cache_android");     // Catch: Throwable -> L165
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
        Object r117 = com.bytedance.android.ec.base.settings.d.f42818c.get("order_list_cache_android");     // Catch: Throwable -> L130
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
        com.bytedance.android.ec.base.settings.d.d("order_list_cache_android", r105);     // Catch: Throwable -> L165
        goto L175
    L144:
        IHybridHostService r122 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L156
        if (r122 == null) goto L147;
        Object r123 = r122.getHostABValue("order_list_cache_android", r101);     // Catch: Throwable -> L156
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
    L185:
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
    L183:
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
    public static final boolean h() {
        int r100 = m.f45240a;
        Object r101 = 0;
        boolean r102 = ECServiceManager.f42805a;
        s83.g r103 = (s83.g) ECServiceManager.c(s83.g.class);
        if (r103 == null) goto L8;
        s83.a r104 = r103.q();
        if (r104 == null) goto L8;
        Object r105 = r104.e("order_list_stream_request_android");
        if (r105 == null) goto L8;
    L175:
        if (((Number) r105).intValue() != 1) goto L189;
        return true;
    L189:
        return false;
    L8:
        int r106 = n.f45241a;
        int r107 = com.bytedance.android.ec.base.settings.a.f42813a;
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L165
        Object r109 = null;
        Object r110 = com.bytedance.android.ec.base.settings.d.f42818c.get("order_list_stream_request_android");     // Catch: Throwable -> L60
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
        Object r115 = com.bytedance.android.ec.base.settings.d.f42816a.get("order_list_stream_request_android");     // Catch: Throwable -> L165
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
        Object r117 = com.bytedance.android.ec.base.settings.d.f42818c.get("order_list_stream_request_android");     // Catch: Throwable -> L130
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
        com.bytedance.android.ec.base.settings.d.d("order_list_stream_request_android", r105);     // Catch: Throwable -> L165
        goto L175
    L144:
        IHybridHostService r122 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L156
        if (r122 == null) goto L147;
        Object r123 = r122.getHostABValue("order_list_stream_request_android", r101);     // Catch: Throwable -> L156
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
    L185:
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
    L183:
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
    public static final boolean i() {
        int r100 = m.f45240a;
        Object r101 = 0;
        boolean r102 = ECServiceManager.f42805a;
        s83.g r103 = (s83.g) ECServiceManager.c(s83.g.class);
        if (r103 == null) goto L8;
        s83.a r104 = r103.q();
        if (r104 == null) goto L8;
        Object r105 = r104.e("order_list_stream_request_android_v2");
        if (r105 == null) goto L8;
    L175:
        if (((Number) r105).intValue() != 1) goto L189;
        return true;
    L189:
        return false;
    L8:
        int r106 = n.f45241a;
        int r107 = com.bytedance.android.ec.base.settings.a.f42813a;
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L165
        Object r109 = null;
        Object r110 = com.bytedance.android.ec.base.settings.d.f42818c.get("order_list_stream_request_android_v2");     // Catch: Throwable -> L60
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
        Object r115 = com.bytedance.android.ec.base.settings.d.f42816a.get("order_list_stream_request_android_v2");     // Catch: Throwable -> L165
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
        Object r117 = com.bytedance.android.ec.base.settings.d.f42818c.get("order_list_stream_request_android_v2");     // Catch: Throwable -> L130
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
        com.bytedance.android.ec.base.settings.d.d("order_list_stream_request_android_v2", r105);     // Catch: Throwable -> L165
        goto L175
    L144:
        IHybridHostService r122 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L156
        if (r122 == null) goto L147;
        Object r123 = r122.getHostABValue("order_list_stream_request_android_v2", r101);     // Catch: Throwable -> L156
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
    L185:
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
    L183:
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
    public static final int j() {
        int r100 = n.f45241a;
        Object r101 = 0;
        int r102 = com.bytedance.android.ec.base.settings.a.f42813a;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L160
        Object r104 = null;
        Object r105 = com.bytedance.android.ec.base.settings.d.f42818c.get("iesec_pdp_bottom_nav_slice");     // Catch: Throwable -> L54
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
        Object r110 = com.bytedance.android.ec.base.settings.d.f42816a.get("iesec_pdp_bottom_nav_slice");     // Catch: Throwable -> L160
        if ((r110 instanceof Integer) == true) goto L71;
        r110 = null;
    L71:
        r109 = (Integer) r110;     // Catch: Throwable -> L160
    L72:
        if (r109 != null) goto L170;
        int r111 = com.bytedance.android.ec.base.settings.c.f42815a;     // Catch: Throwable -> L160
        Object r112 = com.bytedance.android.ec.base.settings.d.f42818c.get("iesec_pdp_bottom_nav_slice");     // Catch: Throwable -> L124
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
        Object r117 = r116.getHostABValue("iesec_pdp_bottom_nav_slice", r101);     // Catch: Throwable -> L150
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
        com.bytedance.android.ec.base.settings.d.d("iesec_pdp_bottom_nav_slice", r109);     // Catch: Throwable -> L160
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

    @HostExperimentKey
    public static final int k() {
        int r100 = n.f45241a;
        Object r101 = 0;
        int r102 = com.bytedance.android.ec.base.settings.a.f42813a;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L160
        Object r104 = null;
        Object r105 = com.bytedance.android.ec.base.settings.d.f42818c.get("iesec_pdp_new_style_bottom");     // Catch: Throwable -> L54
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
        Object r110 = com.bytedance.android.ec.base.settings.d.f42816a.get("iesec_pdp_new_style_bottom");     // Catch: Throwable -> L160
        if ((r110 instanceof Integer) == true) goto L71;
        r110 = null;
    L71:
        r109 = (Integer) r110;     // Catch: Throwable -> L160
    L72:
        if (r109 != null) goto L170;
        int r111 = com.bytedance.android.ec.base.settings.c.f42815a;     // Catch: Throwable -> L160
        Object r112 = com.bytedance.android.ec.base.settings.d.f42818c.get("iesec_pdp_new_style_bottom");     // Catch: Throwable -> L124
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
        Object r117 = r116.getHostABValue("iesec_pdp_new_style_bottom", r101);     // Catch: Throwable -> L150
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
        com.bytedance.android.ec.base.settings.d.d("iesec_pdp_new_style_bottom", r109);     // Catch: Throwable -> L160
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

    @HostExperimentKey
    public static final int l() {
        int r100 = n.f45241a;
        Object r101 = 0;
        int r102 = com.bytedance.android.ec.base.settings.a.f42813a;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L160
        Object r104 = null;
        Object r105 = com.bytedance.android.ec.base.settings.d.f42818c.get("iesec_ecom_pdp_update_exp");     // Catch: Throwable -> L54
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
        Object r110 = com.bytedance.android.ec.base.settings.d.f42816a.get("iesec_ecom_pdp_update_exp");     // Catch: Throwable -> L160
        if ((r110 instanceof Integer) == true) goto L71;
        r110 = null;
    L71:
        r109 = (Integer) r110;     // Catch: Throwable -> L160
    L72:
        if (r109 != null) goto L170;
        int r111 = com.bytedance.android.ec.base.settings.c.f42815a;     // Catch: Throwable -> L160
        Object r112 = com.bytedance.android.ec.base.settings.d.f42818c.get("iesec_ecom_pdp_update_exp");     // Catch: Throwable -> L124
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
        Object r117 = r116.getHostABValue("iesec_ecom_pdp_update_exp", r101);     // Catch: Throwable -> L150
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
        com.bytedance.android.ec.base.settings.d.d("iesec_ecom_pdp_update_exp", r109);     // Catch: Throwable -> L160
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

    @HostExperimentKey
    public static final int m() {
        int r100 = n.f45241a;
        Object r101 = 0;
        int r102 = com.bytedance.android.ec.base.settings.a.f42813a;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L160
        Object r104 = null;
        Object r105 = com.bytedance.android.ec.base.settings.d.f42818c.get("iesec_pdp_fit_width");     // Catch: Throwable -> L54
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
        Object r110 = com.bytedance.android.ec.base.settings.d.f42816a.get("iesec_pdp_fit_width");     // Catch: Throwable -> L160
        if ((r110 instanceof Integer) == true) goto L71;
        r110 = null;
    L71:
        r109 = (Integer) r110;     // Catch: Throwable -> L160
    L72:
        if (r109 != null) goto L170;
        int r111 = com.bytedance.android.ec.base.settings.c.f42815a;     // Catch: Throwable -> L160
        Object r112 = com.bytedance.android.ec.base.settings.d.f42818c.get("iesec_pdp_fit_width");     // Catch: Throwable -> L124
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
        Object r117 = r116.getHostABValue("iesec_pdp_fit_width", r101);     // Catch: Throwable -> L150
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
        com.bytedance.android.ec.base.settings.d.d("iesec_pdp_fit_width", r109);     // Catch: Throwable -> L160
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

    @HostExperimentKey
    public static final int n() {
        int r100 = n.f45241a;
        Object r101 = 0;
        int r102 = com.bytedance.android.ec.base.settings.a.f42813a;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L160
        Object r104 = null;
        Object r105 = com.bytedance.android.ec.base.settings.d.f42818c.get("iesec_pdp_new_style_top");     // Catch: Throwable -> L54
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
        Object r110 = com.bytedance.android.ec.base.settings.d.f42816a.get("iesec_pdp_new_style_top");     // Catch: Throwable -> L160
        if ((r110 instanceof Integer) == true) goto L71;
        r110 = null;
    L71:
        r109 = (Integer) r110;     // Catch: Throwable -> L160
    L72:
        if (r109 != null) goto L170;
        int r111 = com.bytedance.android.ec.base.settings.c.f42815a;     // Catch: Throwable -> L160
        Object r112 = com.bytedance.android.ec.base.settings.d.f42818c.get("iesec_pdp_new_style_top");     // Catch: Throwable -> L124
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
        Object r117 = r116.getHostABValue("iesec_pdp_new_style_top", r101);     // Catch: Throwable -> L150
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
        com.bytedance.android.ec.base.settings.d.d("iesec_pdp_new_style_top", r109);     // Catch: Throwable -> L160
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

    @HostExperimentKey
    public static final int o() {
        int r100 = n.f45241a;
        Object r101 = 0;
        int r102 = com.bytedance.android.ec.base.settings.a.f42813a;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L160
        Object r104 = null;
        Object r105 = com.bytedance.android.ec.base.settings.d.f42818c.get("iesec_pdp_top_nav_slice");     // Catch: Throwable -> L54
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
        Object r110 = com.bytedance.android.ec.base.settings.d.f42816a.get("iesec_pdp_top_nav_slice");     // Catch: Throwable -> L160
        if ((r110 instanceof Integer) == true) goto L71;
        r110 = null;
    L71:
        r109 = (Integer) r110;     // Catch: Throwable -> L160
    L72:
        if (r109 != null) goto L170;
        int r111 = com.bytedance.android.ec.base.settings.c.f42815a;     // Catch: Throwable -> L160
        Object r112 = com.bytedance.android.ec.base.settings.d.f42818c.get("iesec_pdp_top_nav_slice");     // Catch: Throwable -> L124
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
        Object r117 = r116.getHostABValue("iesec_pdp_top_nav_slice", r101);     // Catch: Throwable -> L150
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
        com.bytedance.android.ec.base.settings.d.d("iesec_pdp_top_nav_slice", r109);     // Catch: Throwable -> L160
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

    @HostExperimentKey
    public static final boolean p() {
        int r100 = n.f45241a;
        Object r101 = Boolean.FALSE;
        int r102 = com.bytedance.android.ec.base.settings.a.f42813a;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L166
        Object r104 = null;
        Object r105 = com.bytedance.android.ec.base.settings.d.f42818c.get("detail_first_render_opt_chunk");     // Catch: Throwable -> L57
        if (r105 != null) goto L9;
    L54:
        Object r106 = null;
    L55:
        Object r107 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L57
    L59:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);     // Catch: Throwable -> L166
        if (r108 == null) goto L63;
        EnsureManager.ensureNotReachHere(r108);     // Catch: Throwable -> L166
    L63:
        if (Result.m9455isFailureimpl(r107) == false) goto L66;
        r107 = null;
    L66:
        if ((r107 instanceof Boolean) == true) goto L68;
        r107 = null;
    L68:
        Object r109 = (Boolean) r107;     // Catch: Throwable -> L166
        if (r109 != null) goto L75;
        Object r110 = com.bytedance.android.ec.base.settings.d.f42816a.get("detail_first_render_opt_chunk");     // Catch: Throwable -> L166
        if ((r110 instanceof Boolean) == true) goto L74;
        r110 = null;
    L74:
        r109 = (Boolean) r110;     // Catch: Throwable -> L166
    L75:
        if (r109 != null) goto L176;
        int r111 = com.bytedance.android.ec.base.settings.c.f42815a;     // Catch: Throwable -> L166
        Object r112 = com.bytedance.android.ec.base.settings.d.f42818c.get("detail_first_render_opt_chunk");     // Catch: Throwable -> L130
        if (r112 != null) goto L82;
    L127:
        Object r113 = null;
    L128:
        Object r114 = Result.m9449constructorimpl(r113);     // Catch: Throwable -> L130
    L132:
        Throwable r115 = Result.m9452exceptionOrNullimpl(r114);     // Catch: Throwable -> L156
        if (r115 == null) goto L136;
        EnsureManager.ensureNotReachHere(r115);     // Catch: Throwable -> L156
    L136:
        if (Result.m9455isFailureimpl(r114) == false) goto L139;
        r114 = null;
    L139:
        if ((r114 instanceof Boolean) == true) goto L141;
        r114 = null;
    L141:
        r109 = (Boolean) r114;     // Catch: Throwable -> L156
        if (r109 != null) goto L164;
        IHybridHostService r116 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L156
        if (r116 == null) goto L147;
        Object r117 = r116.getHostABValue("detail_first_render_opt_chunk", r101);     // Catch: Throwable -> L156
    L148:
        if (r117 != null) goto L150;
    L155:
        r109 = r101;
        goto L164
    L150:
        if ((r117 instanceof Boolean) == false) goto L153;
        r104 = r117;
    L153:
        Object r118 = (Boolean) r104;     // Catch: Throwable -> L156
        if (r118 == null) goto L155;
    L163:
        r109 = r118;
        goto L164
    L147:
        r117 = null;
    L164:
        com.bytedance.android.ec.base.settings.d.d("detail_first_render_opt_chunk", r109);     // Catch: Throwable -> L166
        goto L176
    L82:
        if ((r112 instanceof Boolean) == true) goto L84;
        Object r119 = null;
    L85:
        r113 = (Boolean) r119;     // Catch: Throwable -> L130
        if (r113 != null) goto L128;
        if ((r112 instanceof Number) == false) goto L115;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r120 = Float.valueOf(((Number) r112).floatValue());     // Catch: Throwable -> L130
        if ((r120 instanceof Boolean) == true) goto L95;
        r120 = null;
    L95:
        r113 = (Boolean) r120;     // Catch: Throwable -> L130
        goto L128
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r121 = Double.valueOf(((Number) r112).doubleValue());     // Catch: Throwable -> L130
        if ((r121 instanceof Boolean) == true) goto L101;
        r121 = null;
    L101:
        r113 = (Boolean) r121;     // Catch: Throwable -> L130
        goto L128
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L109;
        Integer r122 = Integer.valueOf(((Number) r112).intValue());     // Catch: Throwable -> L130
        if ((r122 instanceof Boolean) == true) goto L107;
        r122 = null;
    L107:
        r113 = (Boolean) r122;     // Catch: Throwable -> L130
        goto L128
    L109:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L115;
        Long r123 = Long.valueOf(((Number) r112).longValue());     // Catch: Throwable -> L130
        if ((r123 instanceof Boolean) == true) goto L113;
        r123 = null;
    L113:
        r113 = (Boolean) r123;     // Catch: Throwable -> L130
    L115:
        if ((r112 instanceof JSONObject) == false) goto L117;
    L184:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L123
        Object r124 = SDKSettingsCacheManager.a().fromJson(r112.toString(), Boolean.class);     // Catch: Throwable -> L123
        if ((r124 instanceof Boolean) == true) goto L121;
        r124 = null;
    L121:
        Object r125 = Result.m9449constructorimpl((Boolean) r124);     // Catch: Throwable -> L123
    L125:
        r113 = r125;
        if (Result.m9455isFailureimpl(r113) == false) goto L128;
    L123:
        th = move-exception;
        Result.Companion r126 = Result.Companion;     // Catch: Throwable -> L130
        r125 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L130
        goto L125
    L117:
        if ((r112 instanceof JSONArray) == false) goto L127;
    L84:
        r119 = r112;
    L156:
        th = move-exception;
        Result.Companion r127 = Result.Companion;     // Catch: Throwable -> L166
        r118 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
        Throwable r128 = Result.m9452exceptionOrNullimpl(r118);     // Catch: Throwable -> L166
        if (r128 == null) goto L161;
        EnsureManager.ensureNotReachHere(r128);     // Catch: Throwable -> L166
    L161:
        if (Result.m9455isFailureimpl(r118) == false) goto L163;
        r118 = r101;
    L130:
        th = move-exception;
        Result.Companion r129 = Result.Companion;     // Catch: Throwable -> L156
        r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L156
    L176:
        return ((Boolean) r109).booleanValue();
    L9:
        if ((r105 instanceof Boolean) == true) goto L11;
        Object r130 = null;
    L12:
        r106 = (Boolean) r130;     // Catch: Throwable -> L57
        if (r106 != null) goto L55;
        if ((r105 instanceof Number) == false) goto L42;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L24;
        Float r131 = Float.valueOf(((Number) r105).floatValue());     // Catch: Throwable -> L57
        if ((r131 instanceof Boolean) == true) goto L22;
        r131 = null;
    L22:
        r106 = (Boolean) r131;     // Catch: Throwable -> L57
        goto L55
    L24:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L30;
        Double r132 = Double.valueOf(((Number) r105).doubleValue());     // Catch: Throwable -> L57
        if ((r132 instanceof Boolean) == true) goto L28;
        r132 = null;
    L28:
        r106 = (Boolean) r132;     // Catch: Throwable -> L57
        goto L55
    L30:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L36;
        Integer r133 = Integer.valueOf(((Number) r105).intValue());     // Catch: Throwable -> L57
        if ((r133 instanceof Boolean) == true) goto L34;
        r133 = null;
    L34:
        r106 = (Boolean) r133;     // Catch: Throwable -> L57
        goto L55
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L42;
        Long r134 = Long.valueOf(((Number) r105).longValue());     // Catch: Throwable -> L57
        if ((r134 instanceof Boolean) == true) goto L40;
        r134 = null;
    L40:
        r106 = (Boolean) r134;     // Catch: Throwable -> L57
    L42:
        if ((r105 instanceof JSONObject) == false) goto L44;
    L181:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L50
        Object r135 = SDKSettingsCacheManager.a().fromJson(r105.toString(), Boolean.class);     // Catch: Throwable -> L50
        if ((r135 instanceof Boolean) == true) goto L48;
        r135 = null;
    L48:
        Object r136 = Result.m9449constructorimpl((Boolean) r135);     // Catch: Throwable -> L50
    L52:
        r106 = r136;
        if (Result.m9455isFailureimpl(r106) == false) goto L55;
    L50:
        th = move-exception;
        Result.Companion r137 = Result.Companion;     // Catch: Throwable -> L57
        r136 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L57
        goto L52
    L44:
        if ((r105 instanceof JSONArray) == false) goto L54;
    L11:
        r130 = r105;
    L57:
        th = move-exception;
        Result.Companion r138 = Result.Companion;     // Catch: Throwable -> L166
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
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
        r109 = r101;
        goto L176
    }

    @HostExperimentKey
    public static final int q() {
        int r100 = m.f45240a;
        Object r101 = 0;
        boolean r102 = ECServiceManager.f42805a;
        s83.g r103 = (s83.g) ECServiceManager.c(s83.g.class);
        if (r103 == null) goto L8;
        s83.a r104 = r103.q();
        if (r104 == null) goto L8;
        Object r105 = r104.e("ec_live_promotion_item_async_event");
        if (r105 == null) goto L8;
    L175:
        return ((Number) r105).intValue();
    L8:
        int r106 = n.f45241a;
        int r107 = com.bytedance.android.ec.base.settings.a.f42813a;
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L165
        Object r109 = null;
        Object r110 = com.bytedance.android.ec.base.settings.d.f42818c.get("ec_live_promotion_item_async_event");     // Catch: Throwable -> L60
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
        Object r115 = com.bytedance.android.ec.base.settings.d.f42816a.get("ec_live_promotion_item_async_event");     // Catch: Throwable -> L165
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
        Object r117 = com.bytedance.android.ec.base.settings.d.f42818c.get("ec_live_promotion_item_async_event");     // Catch: Throwable -> L130
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
        com.bytedance.android.ec.base.settings.d.d("ec_live_promotion_item_async_event", r105);     // Catch: Throwable -> L165
        goto L175
    L144:
        IHybridHostService r122 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L156
        if (r122 == null) goto L147;
        Object r123 = r122.getHostABValue("ec_live_promotion_item_async_event", r101);     // Catch: Throwable -> L156
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

    static {
    }
}
