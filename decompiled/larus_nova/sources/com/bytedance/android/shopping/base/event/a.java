package com.bytedance.android.shopping.base.event;

import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.base.settings.g;
import com.bytedance.android.ec.base.settings.h;
import com.bytedance.android.ec.core.abtest.j;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.hybrid.hostapi.IECHybridKevaService;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.dataplatform.config.SettingPanel;
import com.bytedance.services.apm.api.EnsureManager;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, String> f170704a = null;

    public a() {
    }

    static {
        f170704a = new ConcurrentHashMap();
    }

    @SettingPanel("全链路trace监控开关")
    public static PdpFullNodeTraceSetting a() {
        int r100 = j.f43647a;
        Object r101 = null;
        Object r102 = new PdpFullNodeTraceSetting(false, false, 3, null);
        int r103 = com.bytedance.android.ec.base.settings.b.f42814a;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L171
        h.a();     // Catch: Throwable -> L171
        SDKSettingsCacheManager r105 = SDKSettingsCacheManager.f42812e;     // Catch: Throwable -> L171
        r105.getClass();     // Catch: Throwable -> L58
        Object r106 = SDKSettingsCacheManager.f42809b.get("full_node_trace_setting");     // Catch: Throwable -> L58
        if (r106 != null) goto L10;
    L55:
        Object r107 = null;
    L56:
        Object r108 = Result.m9449constructorimpl(r107);     // Catch: Throwable -> L58
    L60:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);     // Catch: Throwable -> L171
        if (r109 == null) goto L64;
        EnsureManager.ensureNotReachHere(r109);     // Catch: Throwable -> L171
    L64:
        if (Result.m9455isFailureimpl(r108) == false) goto L67;
        r108 = null;
    L67:
        if ((r108 instanceof PdpFullNodeTraceSetting) == true) goto L69;
        r108 = null;
    L69:
        Object r110 = (PdpFullNodeTraceSetting) r108;     // Catch: Throwable -> L171
        if (r110 != null) goto L76;
        r105.getClass();     // Catch: Throwable -> L171
        Object r111 = SDKSettingsCacheManager.f42808a.get("full_node_trace_setting");     // Catch: Throwable -> L171
        if ((r111 instanceof PdpFullNodeTraceSetting) == true) goto L75;
        r111 = null;
    L75:
        r110 = (PdpFullNodeTraceSetting) r111;     // Catch: Throwable -> L171
    L76:
        if (r110 != null) goto L181;
        int r112 = g.f42821a;     // Catch: Throwable -> L171
    L158:
        th = move-exception;
        Result.Companion r113 = Result.Companion;     // Catch: Throwable -> L171
        Object r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L171
    L161:
        if (Result.m9452exceptionOrNullimpl(r114) != null) goto L188;
    L168:
        r110 = r114;
    L169:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L171
        SDKSettingsCacheManager.e("full_node_trace_setting", r110);     // Catch: Throwable -> L171
        goto L181
    L188:
        r114 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("full_node_trace_setting", PdpFullNodeTraceSetting.class, r102);     // Catch: Throwable -> L165
    L166:
        if (r114 != null) goto L168;
        r110 = r102;
    L165:
        r114 = r102;
        goto L166
    L194:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L132
        Object r115 = SDKSettingsCacheManager.f42809b.get("full_node_trace_setting");     // Catch: Throwable -> L132
        if (r115 != null) goto L84;
    L129:
        Object r116 = null;
    L130:
        Object r117 = Result.m9449constructorimpl(r116);     // Catch: Throwable -> L132
    L134:
        Throwable r118 = Result.m9452exceptionOrNullimpl(r117);     // Catch: Throwable -> L158
        if (r118 == null) goto L138;
        EnsureManager.ensureNotReachHere(r118);     // Catch: Throwable -> L158
    L138:
        if (Result.m9455isFailureimpl(r117) == false) goto L141;
        r117 = null;
    L141:
        if ((r117 instanceof PdpFullNodeTraceSetting) == true) goto L143;
        r117 = null;
    L143:
        PdpFullNodeTraceSetting r119 = (PdpFullNodeTraceSetting) r117;     // Catch: Throwable -> L158
        if (r119 == null) goto L146;
        r110 = r119;
        goto L169
    L146:
        jj4.b r120 = jj4.b.f499326b;     // Catch: Throwable -> L158
        Object r121 = jj4.a.a("full_node_trace_setting", PdpFullNodeTraceSetting.class, r102, false);     // Catch: Throwable -> L158
        if (r121 != null) goto L150;
        Intrinsics.throwNpe();     // Catch: Throwable -> L158
    L150:
        if ((r121 instanceof PdpFullNodeTraceSetting) == false) goto L153;
        r101 = r121;
    L153:
        Object r122 = (PdpFullNodeTraceSetting) r101;     // Catch: Throwable -> L158
        if (r122 != null) goto L156;
        r122 = r102;
    L156:
        r114 = Result.m9449constructorimpl(r122);     // Catch: Throwable -> L158
    L84:
        if ((r115 instanceof PdpFullNodeTraceSetting) == true) goto L86;
        Object r123 = null;
    L87:
        r116 = (PdpFullNodeTraceSetting) r123;     // Catch: Throwable -> L132
        if (r116 != null) goto L130;
        if ((r115 instanceof Number) == false) goto L117;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(PdpFullNodeTraceSetting.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L99;
        Float r124 = Float.valueOf(((Number) r115).floatValue());     // Catch: Throwable -> L132
        if ((r124 instanceof PdpFullNodeTraceSetting) == true) goto L97;
        r124 = null;
    L97:
        r116 = (PdpFullNodeTraceSetting) r124;     // Catch: Throwable -> L132
        goto L130
    L99:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(PdpFullNodeTraceSetting.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L105;
        Double r125 = Double.valueOf(((Number) r115).doubleValue());     // Catch: Throwable -> L132
        if ((r125 instanceof PdpFullNodeTraceSetting) == true) goto L103;
        r125 = null;
    L103:
        r116 = (PdpFullNodeTraceSetting) r125;     // Catch: Throwable -> L132
        goto L130
    L105:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(PdpFullNodeTraceSetting.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L111;
        Integer r126 = Integer.valueOf(((Number) r115).intValue());     // Catch: Throwable -> L132
        if ((r126 instanceof PdpFullNodeTraceSetting) == true) goto L109;
        r126 = null;
    L109:
        r116 = (PdpFullNodeTraceSetting) r126;     // Catch: Throwable -> L132
        goto L130
    L111:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(PdpFullNodeTraceSetting.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L117;
        Long r127 = Long.valueOf(((Number) r115).longValue());     // Catch: Throwable -> L132
        if ((r127 instanceof PdpFullNodeTraceSetting) == true) goto L115;
        r127 = null;
    L115:
        r116 = (PdpFullNodeTraceSetting) r127;     // Catch: Throwable -> L132
    L117:
        if ((r115 instanceof JSONObject) == false) goto L119;
    L186:
        Object r128 = SDKSettingsCacheManager.a().fromJson(r115.toString(), PdpFullNodeTraceSetting.class);     // Catch: Throwable -> L125
        if ((r128 instanceof PdpFullNodeTraceSetting) == true) goto L123;
        r128 = null;
    L123:
        Object r129 = Result.m9449constructorimpl((PdpFullNodeTraceSetting) r128);     // Catch: Throwable -> L125
    L127:
        r116 = r129;
        if (Result.m9455isFailureimpl(r116) == false) goto L130;
    L125:
        th = move-exception;
        Result.Companion r130 = Result.Companion;     // Catch: Throwable -> L132
        r129 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L132
        goto L127
    L119:
        if ((r115 instanceof JSONArray) == false) goto L129;
    L86:
        r123 = r115;
    L132:
        th = move-exception;
        Result.Companion r131 = Result.Companion;     // Catch: Throwable -> L158
        r117 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L158
    L181:
        return (PdpFullNodeTraceSetting) r110;
    L10:
        if ((r106 instanceof PdpFullNodeTraceSetting) == true) goto L12;
        Object r132 = null;
    L13:
        r107 = (PdpFullNodeTraceSetting) r132;     // Catch: Throwable -> L58
        if (r107 != null) goto L56;
        if ((r106 instanceof Number) == false) goto L43;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(PdpFullNodeTraceSetting.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L25;
        Float r133 = Float.valueOf(((Number) r106).floatValue());     // Catch: Throwable -> L58
        if ((r133 instanceof PdpFullNodeTraceSetting) == true) goto L23;
        r133 = null;
    L23:
        r107 = (PdpFullNodeTraceSetting) r133;     // Catch: Throwable -> L58
        goto L56
    L25:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(PdpFullNodeTraceSetting.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L31;
        Double r134 = Double.valueOf(((Number) r106).doubleValue());     // Catch: Throwable -> L58
        if ((r134 instanceof PdpFullNodeTraceSetting) == true) goto L29;
        r134 = null;
    L29:
        r107 = (PdpFullNodeTraceSetting) r134;     // Catch: Throwable -> L58
        goto L56
    L31:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(PdpFullNodeTraceSetting.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L37;
        Integer r135 = Integer.valueOf(((Number) r106).intValue());     // Catch: Throwable -> L58
        if ((r135 instanceof PdpFullNodeTraceSetting) == true) goto L35;
        r135 = null;
    L35:
        r107 = (PdpFullNodeTraceSetting) r135;     // Catch: Throwable -> L58
        goto L56
    L37:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(PdpFullNodeTraceSetting.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L43;
        Long r136 = Long.valueOf(((Number) r106).longValue());     // Catch: Throwable -> L58
        if ((r136 instanceof PdpFullNodeTraceSetting) == true) goto L41;
        r136 = null;
    L41:
        r107 = (PdpFullNodeTraceSetting) r136;     // Catch: Throwable -> L58
    L43:
        if ((r106 instanceof JSONObject) == false) goto L45;
    L192:
        Object r137 = SDKSettingsCacheManager.a().fromJson(r106.toString(), PdpFullNodeTraceSetting.class);     // Catch: Throwable -> L51
        if ((r137 instanceof PdpFullNodeTraceSetting) == true) goto L49;
        r137 = null;
    L49:
        Object r138 = Result.m9449constructorimpl((PdpFullNodeTraceSetting) r137);     // Catch: Throwable -> L51
    L53:
        r107 = r138;
        if (Result.m9455isFailureimpl(r107) == false) goto L56;
    L51:
        th = move-exception;
        Result.Companion r139 = Result.Companion;     // Catch: Throwable -> L58
        r138 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L58
        goto L53
    L45:
        if ((r106 instanceof JSONArray) == false) goto L55;
    L12:
        r132 = r106;
    L58:
        th = move-exception;
        Result.Companion r140 = Result.Companion;     // Catch: Throwable -> L171
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L171
    L171:
        th = move-exception;
        Result.Companion r141 = Result.Companion;
        Object r142 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r143 = Result.m9452exceptionOrNullimpl(r142);
        if (r143 == null) goto L176;
        EnsureManager.ensureNotReachHere(r143);
    L176:
        if (Result.m9455isFailureimpl(r142) == true) goto L179;
        r102 = r142;
    L179:
        r110 = r102;
        goto L181
    }

    public static void b(boolean r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter("ec_full_node_trace", "serviceName");
        if (a().getMonitorEnable() == true) goto L5;
        return;
    L5:
        int r102 = ECSdk.f48106a;
        pi.b r103 = (pi.b) ECSdk.a(pi.b.class);
        if (r103 == null) goto L8;
        r101.put("data_type", com.bytedance.android.ec.core.event.a.VALUE_DATA_TYPE);
        Unit r104 = Unit.INSTANCE;
        r103.monitorEvent("ec_full_node_trace", r101, null, null);
    L8:
        if (r100 == true) goto L10;
        return;
    L10:
        if (a().getALogEnable() == false) goto L14;
        JSONObject r105 = new JSONObject();
        z1.b(r105, r101);
        String r106 = r105.toString();
        dm.a.a("ec_full_node_trace").b(r106, null);
        return;
    }

    public static void c(String r100, String r101, String r102, String r103, boolean r104, JSONObject r110) {
        Intrinsics.checkNotNullParameter(r100, "pageName");
        Intrinsics.checkNotNullParameter(r101, "stage");
        Intrinsics.checkNotNullParameter(r102, "stage_status");
        if ((!Intrinsics.areEqual(r102, "failed")) == false) goto L8;
        String r105 = r100 + r101 + r102;
        ConcurrentHashMap<String, String> r106 = f170704a;
        if (r106.containsKey(r105) == false) goto L7;
        return;
    L7:
        r106.put(r105, r105);
    L8:
        if (r110 == null) goto L18;
    L10:
        r110.put("page_name", r100);     // Catch: Exception -> L15
        r110.put("stage", r101);     // Catch: Exception -> L15
        r110.put("stage_status", r102);     // Catch: Exception -> L15
        if (r103 == null) goto L13;
        r110.put("error_message", r103);     // Catch: Exception -> L15
    L13:
        b(r104, r110);     // Catch: Exception -> L15
        return;
    L15:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return;
    L18:
        r110 = new JSONObject();     // Catch: Exception -> L15
        goto L10
    }

    public static /* synthetic */ void d(String r100, String r101, String r110, String r111, boolean r112, JSONObject r113, int r114) {
        if ((r114 & 8) == 0) goto L5;
        String r102 = null;
    L7:
        if ((r114 & 16) == 0) goto L9;
        boolean r103 = false;
    L11:
        if ((r114 & 32) == 0) goto L13;
        JSONObject r104 = null;
    L14:
        c(r100, r101, r110, r102, r103, r104);
        return;
    L13:
        r104 = r113;
        goto L14
    L9:
        r103 = r112;
        goto L11
    L5:
        r102 = r111;
        goto L7
    }
}
