package com.bytedance.android.ec.core.monitor;

import android.util.Base64;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.core.monitor.listener.ActionRateListener;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.utils.x0;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.hybrid.hostapi.IECHybridKevaService;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.shopping.buynow.data.model.CheckPointType;
import com.bytedance.dataplatform.config.SettingPanel;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.bytedance.services.apm.api.EnsureManager;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPOutputStream;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.random.Random;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class ECProcessMonitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set<String> f45118a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final HashMap<String, ActionRateListener> f45119b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static PdpMonitorSetting f45120c;

    public ECProcessMonitor() {
    }

    static {
        f45118a = new LinkedHashSet();
        f45119b = new HashMap();
    }

    public static boolean a() {
        if (f45120c != null) goto L5;
        f45120c = h();
    L5:
        PdpMonitorSetting r100 = f45120c;
        if (r100 != null) goto L10;
        return false;
    L10:
        return r100.getALogSwitch();
    }

    @SettingPanel("商详监控配置")
    public static final PdpMonitorSetting h() {
        int r100 = com.bytedance.android.ec.core.abtest.j.f43647a;
        Object r101 = new PdpMonitorSetting(null, false, false, null, null, null, null, null, 255, null);
        int r102 = com.bytedance.android.ec.base.settings.b.f42814a;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L172
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L172
        SDKSettingsCacheManager r104 = SDKSettingsCacheManager.f42812e;     // Catch: Throwable -> L172
        Object r105 = null;
        r104.getClass();     // Catch: Throwable -> L59
        Object r106 = SDKSettingsCacheManager.f42809b.get("pdp_monitor_setting");     // Catch: Throwable -> L59
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
        if ((r108 instanceof PdpMonitorSetting) == true) goto L70;
        r108 = null;
    L70:
        Object r110 = (PdpMonitorSetting) r108;     // Catch: Throwable -> L172
        if (r110 != null) goto L77;
        r104.getClass();     // Catch: Throwable -> L172
        Object r111 = SDKSettingsCacheManager.f42808a.get("pdp_monitor_setting");     // Catch: Throwable -> L172
        if ((r111 instanceof PdpMonitorSetting) == true) goto L76;
        r111 = null;
    L76:
        r110 = (PdpMonitorSetting) r111;     // Catch: Throwable -> L172
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
        SDKSettingsCacheManager.e("pdp_monitor_setting", r110);     // Catch: Throwable -> L172
        goto L182
    L185:
        r114 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("pdp_monitor_setting", PdpMonitorSetting.class, r101);     // Catch: Throwable -> L166
    L167:
        if (r114 != null) goto L169;
        r110 = r101;
    L166:
        r114 = r101;
        goto L167
    L191:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L133
        Object r115 = SDKSettingsCacheManager.f42809b.get("pdp_monitor_setting");     // Catch: Throwable -> L133
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
        if ((r117 instanceof PdpMonitorSetting) == true) goto L144;
        r117 = null;
    L144:
        r114 = (PdpMonitorSetting) r117;     // Catch: Throwable -> L159
        if (r114 != null) goto L169;
        jj4.b r119 = jj4.b.f499326b;     // Catch: Throwable -> L159
        Object r120 = jj4.a.a("pdp_monitor_setting", PdpMonitorSetting.class, r101, false);     // Catch: Throwable -> L159
        if (r120 != null) goto L151;
        Intrinsics.throwNpe();     // Catch: Throwable -> L159
    L151:
        if ((r120 instanceof PdpMonitorSetting) == false) goto L154;
        r105 = r120;
    L154:
        Object r121 = (PdpMonitorSetting) r105;     // Catch: Throwable -> L159
        if (r121 != null) goto L157;
        r121 = r101;
    L157:
        r114 = Result.m9449constructorimpl(r121);     // Catch: Throwable -> L159
    L85:
        if ((r115 instanceof PdpMonitorSetting) == true) goto L87;
        Object r122 = null;
    L88:
        r116 = (PdpMonitorSetting) r122;     // Catch: Throwable -> L133
        if (r116 != null) goto L131;
        if ((r115 instanceof Number) == false) goto L118;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(PdpMonitorSetting.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L100;
        Float r123 = Float.valueOf(((Number) r115).floatValue());     // Catch: Throwable -> L133
        if ((r123 instanceof PdpMonitorSetting) == true) goto L98;
        r123 = null;
    L98:
        r116 = (PdpMonitorSetting) r123;     // Catch: Throwable -> L133
        goto L131
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(PdpMonitorSetting.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L106;
        Double r124 = Double.valueOf(((Number) r115).doubleValue());     // Catch: Throwable -> L133
        if ((r124 instanceof PdpMonitorSetting) == true) goto L104;
        r124 = null;
    L104:
        r116 = (PdpMonitorSetting) r124;     // Catch: Throwable -> L133
        goto L131
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(PdpMonitorSetting.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L112;
        Integer r125 = Integer.valueOf(((Number) r115).intValue());     // Catch: Throwable -> L133
        if ((r125 instanceof PdpMonitorSetting) == true) goto L110;
        r125 = null;
    L110:
        r116 = (PdpMonitorSetting) r125;     // Catch: Throwable -> L133
        goto L131
    L112:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(PdpMonitorSetting.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L118;
        Long r126 = Long.valueOf(((Number) r115).longValue());     // Catch: Throwable -> L133
        if ((r126 instanceof PdpMonitorSetting) == true) goto L116;
        r126 = null;
    L116:
        r116 = (PdpMonitorSetting) r126;     // Catch: Throwable -> L133
    L118:
        if ((r115 instanceof JSONObject) == false) goto L120;
    L183:
        Object r127 = SDKSettingsCacheManager.a().fromJson(r115.toString(), PdpMonitorSetting.class);     // Catch: Throwable -> L126
        if ((r127 instanceof PdpMonitorSetting) == true) goto L124;
        r127 = null;
    L124:
        Object r128 = Result.m9449constructorimpl((PdpMonitorSetting) r127);     // Catch: Throwable -> L126
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
        return (PdpMonitorSetting) r110;
    L11:
        if ((r106 instanceof PdpMonitorSetting) == true) goto L13;
        Object r131 = null;
    L14:
        r107 = (PdpMonitorSetting) r131;     // Catch: Throwable -> L59
        if (r107 != null) goto L57;
        if ((r106 instanceof Number) == false) goto L44;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(PdpMonitorSetting.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r132 = Float.valueOf(((Number) r106).floatValue());     // Catch: Throwable -> L59
        if ((r132 instanceof PdpMonitorSetting) == true) goto L24;
        r132 = null;
    L24:
        r107 = (PdpMonitorSetting) r132;     // Catch: Throwable -> L59
        goto L57
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(PdpMonitorSetting.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r133 = Double.valueOf(((Number) r106).doubleValue());     // Catch: Throwable -> L59
        if ((r133 instanceof PdpMonitorSetting) == true) goto L30;
        r133 = null;
    L30:
        r107 = (PdpMonitorSetting) r133;     // Catch: Throwable -> L59
        goto L57
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(PdpMonitorSetting.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L38;
        Integer r134 = Integer.valueOf(((Number) r106).intValue());     // Catch: Throwable -> L59
        if ((r134 instanceof PdpMonitorSetting) == true) goto L36;
        r134 = null;
    L36:
        r107 = (PdpMonitorSetting) r134;     // Catch: Throwable -> L59
        goto L57
    L38:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(PdpMonitorSetting.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L44;
        Long r135 = Long.valueOf(((Number) r106).longValue());     // Catch: Throwable -> L59
        if ((r135 instanceof PdpMonitorSetting) == true) goto L42;
        r135 = null;
    L42:
        r107 = (PdpMonitorSetting) r135;     // Catch: Throwable -> L59
    L44:
        if ((r106 instanceof JSONObject) == false) goto L46;
    L189:
        Object r136 = SDKSettingsCacheManager.a().fromJson(r106.toString(), PdpMonitorSetting.class);     // Catch: Throwable -> L52
        if ((r136 instanceof PdpMonitorSetting) == true) goto L50;
        r136 = null;
    L50:
        Object r137 = Result.m9449constructorimpl((PdpMonitorSetting) r136);     // Catch: Throwable -> L52
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

    public static com.bytedance.android.ec.core.monitor.listener.d o() {
        HashMap<String, ActionRateListener> r100 = f45119b;
        Object r101 = r100.get(g("ec_product_detail", CheckPointType.ENTER_PAGE));
        if ((r101 instanceof com.bytedance.android.ec.core.monitor.listener.d) == true) goto L5;
        r101 = null;
    L5:
        com.bytedance.android.ec.core.monitor.listener.d r102 = (com.bytedance.android.ec.core.monitor.listener.d) r101;
        if (r102 == null) goto L8;
        return r102;
    L8:
        com.bytedance.android.ec.core.monitor.listener.d r103 = new com.bytedance.android.ec.core.monitor.listener.d(ECProcessMonitor$openPdpListener$2$1.INSTANCE);
        r100.put(g("ec_product_detail", CheckPointType.ENTER_PAGE), r103);
        return r103;
    }

    public static com.bytedance.android.ec.core.monitor.listener.e p() {
        HashMap<String, ActionRateListener> r100 = f45119b;
        Object r101 = r100.get(g("ec_sku", CheckPointType.ENTER_PAGE));
        if ((r101 instanceof com.bytedance.android.ec.core.monitor.listener.e) == true) goto L5;
        r101 = null;
    L5:
        com.bytedance.android.ec.core.monitor.listener.e r102 = (com.bytedance.android.ec.core.monitor.listener.e) r101;
        if (r102 == null) goto L8;
        return r102;
    L8:
        com.bytedance.android.ec.core.monitor.listener.e r103 = new com.bytedance.android.ec.core.monitor.listener.e(ECProcessMonitor$openSkuListener$2$1.INSTANCE);
        r100.put(g("ec_sku", CheckPointType.ENTER_PAGE), r103);
        return r103;
    }

    public static boolean b(String r100) {
        Intrinsics.checkNotNullParameter(r100, ReportConstant.COMMON_ACTION_TYPE);
        if (f45120c != null) goto L6;
        f45120c = h();
    L6:
        if (a() == false) goto L16;
        PdpMonitorSetting r101 = f45120c;
        if (r101 == null) goto L12;
        List<String> r102 = r101.getActionALogBlockList();
        if (r102 == null) goto L12;
        boolean r103 = r102.contains(r100);
    L13:
        if (r103 == true) goto L17;
        return true;
    L17:
        return false;
    L12:
        r103 = false;
        goto L13
    L16:
        return false;
    }

    public static com.bytedance.android.ec.core.monitor.listener.a d(final String r100) {
        Intrinsics.checkNotNullParameter(r100, "pageName");
        HashMap<String, ActionRateListener> r101 = f45119b;
        Object r102 = r101.get(g(r100, "add_2_cart"));
        if ((r102 instanceof com.bytedance.android.ec.core.monitor.listener.a) == true) goto L5;
        r102 = null;
    L5:
        com.bytedance.android.ec.core.monitor.listener.a r103 = (com.bytedance.android.ec.core.monitor.listener.a) r102;
        if (r103 == null) goto L8;
        return r103;
    L8:
        com.bytedance.android.ec.core.monitor.listener.a r104 = new com.bytedance.android.ec.core.monitor.listener.a(r100, new ECProcessMonitor$addCartListener$$inlined$run$lambda$1(r100));
        r101.put(g(r100, "add_2_cart"), r104);
        return r104;
    }

    public static com.bytedance.android.ec.core.monitor.listener.b e(final String r100) {
        Intrinsics.checkNotNullParameter(r100, "pageName");
        HashMap<String, ActionRateListener> r101 = f45119b;
        Object r102 = r101.get(g(r100, "buy_now"));
        if ((r102 instanceof com.bytedance.android.ec.core.monitor.listener.b) == true) goto L5;
        r102 = null;
    L5:
        com.bytedance.android.ec.core.monitor.listener.b r103 = (com.bytedance.android.ec.core.monitor.listener.b) r102;
        if (r103 == null) goto L8;
        return r103;
    L8:
        com.bytedance.android.ec.core.monitor.listener.b r104 = new com.bytedance.android.ec.core.monitor.listener.b(r100, new ECProcessMonitor$buyNowListener$$inlined$run$lambda$1(r100));
        r101.put(g(r100, "buy_now"), r104);
        return r104;
    }

    public static String f(String r100) {
        Intrinsics.checkNotNullParameter("UTF-8", "encoding");
        GZIPOutputStream r101 = null;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L35
        if (r100 != null) goto L6;
    L9:
        boolean r103 = true;
    L10:
        if (r103 == false) goto L40;
        return null;
    L40:
        ByteArrayOutputStream r104 = new ByteArrayOutputStream();     // Catch: Throwable -> L35
        GZIPOutputStream r105 = new GZIPOutputStream(r104);     // Catch: Throwable -> L23 IOException -> L25
        Charset r106 = Charset.forName("UTF-8");     // Catch: Throwable -> L19 IOException -> L21
        if (r100 == null) goto L18;
        r105.write(r100.getBytes(r106));     // Catch: Throwable -> L19 IOException -> L21
    L29:
        r105.close();     // Catch: Throwable -> L35
    L31:
        return Base64.encodeToString(r104.toByteArray(), 0);
    L18:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");     // Catch: Throwable -> L19 IOException -> L21
    L21:
        e = e;
    L27:
        e.getMessage();     // Catch: Throwable -> L19
        if (r105 == null) goto L31;
    L25:
        e = e;
        r105 = null;
    L23:
        th = th;
    L32:
        if (0 == 0) goto L34;
        r101.close();     // Catch: Throwable -> L35
    L34:
        throw th;     // Catch: Throwable -> L35
    L19:
        th = th;
        goto L32
    L6:
        if (r100.length() == 0) goto L9;
        r103 = false;
    L35:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        Throwable r108 = Result.m9452exceptionOrNullimpl(Result.m9449constructorimpl(ResultKt.createFailure(th)));
        if (r108 == null) goto L39;
        ECExceptionMonitor.e(r108);
    L39:
        return null;
    }

    public static boolean q(String r100) {
        Intrinsics.checkNotNullParameter(r100, "eventType");
        if (f45120c != null) goto L5;
        f45120c = h();
    L5:
        PdpMonitorSetting r101 = f45120c;
        if (r101 == null) goto L12;
        Map<String, Integer> r102 = r101.getSampleConfigMap();
        if (r102 == null) goto L12;
        Integer r103 = r102.get(r100);
        if (r103 == null) goto L12;
        int r104 = r103.intValue();
    L14:
        if (Random.Default.nextFloat() >= (r104 / 100.0f)) goto L16;
        return true;
    L16:
        return false;
    L12:
        r104 = 100;
        goto L14
    }

    public static com.bytedance.android.ec.core.monitor.listener.c c(final String r100, final String r101) {
        Intrinsics.checkNotNullParameter(r100, "pageName");
        Intrinsics.checkNotNullParameter(r101, "actionName");
        HashMap<String, ActionRateListener> r102 = f45119b;
        Object r103 = r102.get(g(r100, r101));
        if ((r103 instanceof com.bytedance.android.ec.core.monitor.listener.c) == true) goto L5;
        r103 = null;
    L5:
        com.bytedance.android.ec.core.monitor.listener.c r104 = (com.bytedance.android.ec.core.monitor.listener.c) r103;
        if (r104 == null) goto L8;
        return r104;
    L8:
        com.bytedance.android.ec.core.monitor.listener.c r105 = new com.bytedance.android.ec.core.monitor.listener.c(r100, r101, new ECProcessMonitor$actionListener$$inlined$run$lambda$1(r100, r101));
        r102.put(g(r100, r101), r105);
        return r105;
    }

    public static String g(String r100, String r101) {
        return r100 + "_" + r101;
    }

    public static String r(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "pageName");
        Intrinsics.checkNotNullParameter(r101, "suffix");
        int r102 = r100.hashCode();
        if (r102 == (-1309050372)) goto L11;
        if (r102 == 1300332386) goto L8;
    L13:
        String r103 = "Trade";
    L15:
        return r103 + r101;
    L8:
        if (r100.equals("ec_product_detail") == false) goto L13;
        r103 = "Detail";
        goto L15
    L11:
        if (r100.equals("ec_sku") == false) goto L13;
        r103 = "Sku";
        goto L15
    }

    public static void s(long r100, String r101) {
        if (r101 == null) goto L26;
        Set<String> r102 = f45118a;
        if (r102.contains(r101) == true) goto L6;
        return;
    L6:
        if (f45120c != null) goto L8;
        f45120c = h();
    L8:
        PdpMonitorSetting r103 = f45120c;
        if (r103 == null) goto L13;
        Float r104 = r103.getUploadSample();
        if (r104 == null) goto L13;
        float r105 = r104.floatValue();
    L14:
        PdpMonitorSetting r106 = f45120c;
        if (r106 == null) goto L21;
        boolean r107 = true;
        if (r106.getUploadSwitch() != true) goto L21;
        if (Random.Default.nextFloat() >= (r105 / 100.0f)) goto L21;
    L22:
        if (r107 == false) goto L24;
        com.bytedance.android.ec.sdk.helper.g.f48122a.c(r100 - 5000, System.currentTimeMillis());
    L24:
        r102.remove(r101);
        return;
    L21:
        r107 = false;
    L13:
        r105 = 0.0f;
        goto L14
    }

    public static void j(String r100, String r101, long r110, JSONObject r111, JSONObject r112) {
        Intrinsics.checkNotNullParameter(r100, "pageName");
        Intrinsics.checkNotNullParameter(r101, "actionName");
        boolean r102 = q("duration");
        if (r111 == null) goto L5;
        JSONObject r113 = x0.a(r111);
    L6:
        JSONObject r103 = r113;
        r103.put("event_type", "duration");
        r103.put("page_name", r100);
        r103.put("action_name", r101);
        Unit r104 = Unit.INSTANCE;
        JSONObject r105 = new JSONObject();
        r105.put("duration", r110);
        i(r102, 0, "ec_full_trade_process_monitor", r103, r105, r112, r(r100, ""));
        return;
    L5:
        r113 = new JSONObject();
        goto L6
    }

    public static /* synthetic */ void k(String r100, long r101, JSONObject r102, JSONObject r110, int r111) {
        if ((r111 & 8) == 0) goto L5;
        JSONObject r103 = null;
    L7:
        if ((r111 & 16) == 0) goto L9;
        JSONObject r104 = null;
    L10:
        j("ec_product_detail", r100, r101, r103, r104);
        return;
    L9:
        r104 = r110;
        goto L10
    L5:
        r103 = r102;
        goto L7
    }

    public static /* synthetic */ void n(ActionRateListener r100, String r101, String r102, Integer r110, String r111, JSONObject r112) {
        m(r100, r101, r102, r110, r111, r112, null);
    }

    public static void i(boolean r100, int r101, String r102, JSONObject r103, JSONObject r104, JSONObject r105, String r106) {
        Intrinsics.checkNotNullParameter(r102, "serviceName");
        Intrinsics.checkNotNullParameter(r106, "tag");
        if (r100 == false) goto L8;
        int r107 = ECSdk.f48106a;
        pi.b r108 = (pi.b) ECSdk.a(pi.b.class);
        if (r108 == null) goto L8;
        r103.put("data_type", com.bytedance.android.ec.core.event.a.VALUE_DATA_TYPE);
        Unit r109 = Unit.INSTANCE;
        r108.monitorEvent(r102, r103, r104, r105);
    L8:
        if (a() == false) goto L16;
        JSONObject r110 = new JSONObject();
        z1.b(r110, r103);
        String r111 = r110.toString();
        dm.a.b r112 = dm.a.a(r106);
        if (r101 != 0) goto L13;
        r112.i(r111);
        return;
    L13:
        if (r101 != 1) goto L18;
        r112.b(r111, null);
        return;
    L18:
        return;
    }

    public static void m(ActionRateListener r210, String r211, String r212, Integer r213, String r310, JSONObject r311, JSONObject r312) {
        Intrinsics.checkNotNullParameter(r210, "listener");
        Intrinsics.checkNotNullParameter(r211, "pageName");
        Intrinsics.checkNotNullParameter(r212, "actionName");
        Intrinsics.checkNotNullParameter(r310, "message");
        boolean r100 = r210.f45166a;
        if (r311 == null) goto L5;
        JSONObject r101 = x0.a(r311);
    L6:
        JSONObject r102 = r101;
        r102.put("event_type", "rate");
        r102.put("page_name", r211);
        r102.put("action_name", r212);
        if (r213 == null) goto L9;
        r102.put("action_code", r213.intValue());
    L9:
        String r103 = a2.d(r310);
        if (r103 == null) goto L12;
        r102.put("message", r103);
    L12:
        r102.put("rate_type", "failed");
        Unit r104 = Unit.INSTANCE;
        i(r100, 1, "ec_full_trade_process_monitor", r102, null, r312, r(r211, ""));
        if (r311 == null) goto L15;
        JSONObject r105 = x0.a(r311);
    L16:
        r105.put("event_type", "rate");
        r105.put("page_name", r211);
        r105.put("action_name", r212);
        if (r213 == null) goto L19;
        r105.put("action_code", r213.intValue());
    L19:
        String r106 = a2.d(r310);
        if (r106 == null) goto L22;
        r105.put("message", r106);
    L22:
        r105.put("rate_type", "failed");
        JSONObject r214 = r105;
        i(true, 1, "ec_full_trade_error", r214, null, r312, r(r211, ""));
        return;
    L15:
        r105 = new JSONObject();
        goto L16
    L5:
        r101 = new JSONObject();
        goto L6
    }

    public static void l(String r110, String r111, String r112, JSONObject r113, JSONObject r114, String r115, String r116, int r117) {
        String r100 = null;
        if ((r117 & 8) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r117 & 16) == 0) goto L9;
        JSONObject r102 = null;
    L11:
        if ((r117 & 32) == 0) goto L13;
        JSONObject r103 = null;
    L15:
        if ((r117 & 64) == 0) goto L17;
        String r104 = "";
    L19:
        if ((r117 & 128) != 0) goto L22;
        r100 = r116;
    L22:
        Intrinsics.checkNotNullParameter(r110, "pageName");
        Intrinsics.checkNotNullParameter(r111, "actionName");
        Intrinsics.checkNotNullParameter(r104, "logTag");
        if (r100 == null) goto L26;
        f45118a.add(r100);
    L26:
        if (r102 == null) goto L28;
        JSONObject r105 = x0.a(r102);
    L29:
        r105.put("event_type", "error");
        r105.put("page_name", r110);
        r105.put("action_name", r111);
        String r106 = a2.d(r105.optString("code"));
        if (r106 == null) goto L40;
        String r118 = r105.optString("action_code");
        if (r118 != null) goto L34;
    L37:
        boolean r119 = true;
    L38:
        if (r119 == false) goto L40;
        KtSafeMethodExtensionKt.safePut(r105, "action_code", r106);
        goto L40
    L34:
        if (r118.length() == 0) goto L37;
        r119 = false;
    L40:
        if (r101 == null) goto L42;
        KtSafeMethodExtensionKt.safePut(r105, "message", r101);
    L42:
        Unit r107 = Unit.INSTANCE;
        i(true, 1, "ec_full_trade_error", r105, null, r103, r(r110, r104));
        return;
    L28:
        r105 = new JSONObject();
        goto L29
    L17:
        r104 = r115;
        goto L19
    L13:
        r103 = r114;
        goto L15
    L9:
        r102 = r113;
        goto L11
    L5:
        r101 = r112;
        goto L7
    }
}
