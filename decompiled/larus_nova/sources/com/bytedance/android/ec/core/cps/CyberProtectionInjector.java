package com.bytedance.android.ec.core.cps;

import android.util.SparseBooleanArray;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.services.apm.api.EnsureManager;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class CyberProtectionInjector implements com.bytedance.android.ec.sdk.helper.u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f43924a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f43925b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static List<Integer> f43926c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static f f43927d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static d f43928e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static k f43929f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static String f43930g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static String f43931h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static long f43932i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static int f43933j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static int f43934k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final CyberProtectionInjector f43935l = null;

    public CyberProtectionInjector() {
    }

    static {
        f43935l = new CyberProtectionInjector();
        f43926c = CollectionsKt.emptyList();
        f43930g = "none";
        f43931h = "none";
    }

    public static void d() {
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), Dispatchers.getDefault(), null, new CyberProtectionInjector$initCollectorData$1(null), 2, null);
    }

    public static String c(String r210) {
        Intrinsics.checkNotNullParameter(r210, "eventName");
        String r100 = "none";
        int r101 = 0;
        if (f43924a == true) goto L21;
        CyberProtectionConfig.f43919c.getClass();
        if (((Number) CyberProtectionConfig.f43918b.getValue()).intValue() != 1) goto L7;
        boolean r102 = true;
    L8:
        if (r102 == false) goto L128;
        String r110 = String.valueOf(System.currentTimeMillis());
        String r103 = j.c(i.f43940b, CollectionsKt.joinToString$default(CollectionsKt.listOf(new String[]{"init", "none", "0x91f4f5a0", "none", r210, r110}), HiAnalyticsConstant.REPORT_VAL_SEPARATOR, null, null, 0, null, null, 62, null));
        if (r103 == null) goto L129;
        d r104 = f43928e;
        if (r104 == null) goto L18;
        String r105 = r104.g();
        if (r105 == null) goto L18;
        String r106 = r105;
    L20:
        return e.a(new h(r106, r210, "0x91f4f5a0|none", r110, r103, 0, 0)).toString();
    L18:
        r106 = "999999";
        goto L20
    L129:
        return null;
    L128:
        return null;
    L7:
        r102 = false;
        goto L8
    L21:
        String r107 = f43925b;
        if (r107 == null) goto L43;
        String r111 = String.valueOf(System.currentTimeMillis());
        Object[] r108 = new Object[6];
        r108[0] = "error";
        CyberProtectionCollector r112 = CyberProtectionCollector.f43916a;
        String r113 = ECAppInfoService.f48114e.getServerDeviceId();
        if (r113 != null) goto L26;
    L27:
        r101 = 1;
    L28:
        if (r101 != 0) goto L31;
        r100 = r113;
    L31:
        r108[1] = r100;
        r108[2] = r107;
        r108[3] = Long.valueOf(f43932i);
        r108[4] = r210;
        r108[5] = r111;
        String r109 = j.c(i.f43940b, CollectionsKt.joinToString$default(CollectionsKt.listOf(r108), HiAnalyticsConstant.REPORT_VAL_SEPARATOR, null, null, 0, null, null, 62, null));
        if (r109 == null) goto L130;
        d r114 = f43928e;
        if (r114 == null) goto L40;
        String r115 = r114.g();
        if (r115 == null) goto L40;
        String r116 = r115;
    L42:
        return e.a(new h(r116, r210, f43931h, r111, r109, f43933j, f43934k)).toString();
    L40:
        r116 = "999999";
        goto L42
    L130:
        return null;
    L26:
        if (StringsKt.isBlank(r113) == false) goto L28;
    L43:
        String r117 = String.valueOf(System.currentTimeMillis());
        ArrayList r118 = new ArrayList();
        r118.add("success");
        d r119 = f43928e;
        if (r119 == null) goto L47;
        String r120 = r119.f();
        if (r120 == null) goto L47;
    L48:
        r118.add(r120);
        r118.add(f43930g);
        r118.add(r210);
        r118.add(r117);
        d r121 = f43928e;
        if (r121 == null) goto L51;
        Integer r122 = r121.getType();
    L52:
        if (r122 != null) goto L55;
    L102:
        d r123 = f43928e;
        if (r123 == null) goto L108;
        String r124 = r123.g();
        if (r124 == null) goto L108;
        String r125 = r124;
    L110:
        return e.a(new h(r125, r210, f43931h, r117, r100, f43933j, f43934k)).toString();
    L108:
        r125 = "999999";
        goto L110
    L55:
        if (r122.intValue() != 2) goto L102;
        k r126 = f43929f;
        if (r126 == null) goto L59;
        String r127 = j.c(r126, CollectionsKt.joinToString$default(r118, HiAnalyticsConstant.REPORT_VAL_SEPARATOR, null, null, 0, null, null, 62, null));
    L60:
        if (r127 != null) goto L62;
    L101:
        return null;
    L62:
        if (32 != r127.length()) goto L101;
        f r128 = f43927d;
        if (r128 == null) goto L77;
        g r129 = r128.c();
        if (r129 == null) goto L77;
        Map<String, String> r130 = r129.a();
        if (r130 == null) goto L77;
        Iterator<Map.Entry<String, String>> r131 = r130.entrySet().iterator();
        String r132 = r127;
    L72:
        if (r131.hasNext() == false) goto L76;
        Map.Entry<String, String> r133 = r131.next();
        String r134 = r133.getValue();
        if (r134 == null) goto L72;
        r132 = StringsKt.replace$default(r132, r133.getKey(), r134, false, 4, null);
        goto L72
    L76:
        r127 = r132;
    L77:
        ArrayList r135 = new ArrayList();
        IntProgression r136 = RangesKt.step(StringsKt.getIndices(r127), 4);
        int r137 = r136.getFirst();
        int r138 = r136.getLast();
        int r139 = r136.getStep();
        if (r139 < 0) goto L81;
        if (r137 <= r138) goto L82;
    L85:
        ArrayList r140 = new ArrayList(r135.size());
        SparseBooleanArray r141 = new SparseBooleanArray();
        Iterator<Integer> r142 = f43926c.iterator();
    L87:
        if (r142.hasNext() == false) goto L93;
        int r143 = r142.next().intValue();
        int r144 = r135.size();
        if (r143 < 0) goto L87;
        if (r144 <= r143) goto L87;
        r140.add(ListProtector.get(r135, r143));
        r141.put(r143, true);
        goto L87
    L93:
        Iterator r145 = r135.iterator();
    L95:
        if (r145.hasNext() == false) goto L100;
        String r146 = (String) r145.next();
        if (r141.get(r101) == true) goto L99;
        r140.add(r146);
    L99:
        r101 = r101 + 1;
        goto L95
    L100:
        r100 = CollectionsKt.joinToString$default(r140, "", null, null, 0, null, null, 62, null);
    L82:
        r135.add(r127.substring(r137, Math.min(r137 + 4, r127.length())));
        if (r137 == r138) goto L85;
        r137 = r137 + r139;
        goto L82
    L81:
        if (r137 < r138) goto L85;
    L59:
        r127 = null;
        goto L60
    L51:
        r122 = null;
    L47:
        r120 = "none";
        goto L48
    }

    public static final Object b(CyberProtectionInjector r110, Continuation r111) {
        r110.getClass();
        if ((r111 instanceof CyberProtectionInjector$initConfig$1) == false) goto L7;
        CyberProtectionInjector$initConfig$1 r100 = (CyberProtectionInjector$initConfig$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L16;
        if (r104 == 1) goto L15;
        if (r104 != 2) goto L14;
        String r105 = (String) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L411:
        String r106 = (String) r102;
        if (r106 == null) goto L414;
        f43930g = r105;
    L415:
        f43931h = r106;
    L416:
        f43924a = true;
        return Unit.INSTANCE;
    L414:
        r106 = "0x4aaec536|" + f43932i;
        f43930g = r106;
        goto L415
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r102);
    L407:
        if (f43925b == null) goto L416;
        r105 = f43925b + '|' + f43932i;
        r100.L$0 = r105;
        r100.label = 2;
        r102 = c.b(r105, r100);
        if (r102 != r103) goto L411;
        return r103;
    L16:
        ResultKt.throwOnFailure(r102);
        if (f43924a == true) goto L438;
        f43932i = System.currentTimeMillis();
        r100.label = 1;
        CyberProtectionConfig.f43919c.getClass();
        int r107 = com.bytedance.android.ec.core.opt.ab.n.f45241a;
        int r108 = com.bytedance.android.ec.base.settings.a.f42813a;
        CyberProtectionConfig.ConfigError r109 = null;
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L180
        Object r113 = com.bytedance.android.ec.base.settings.d.f42818c.get("ecom_track_config");     // Catch: Throwable -> L73
        if (r113 != null) goto L25;
    L70:
        Object r114 = null;
    L71:
        Object r115 = Result.m9449constructorimpl(r114);     // Catch: Throwable -> L73
    L75:
        Throwable r116 = Result.m9452exceptionOrNullimpl(r115);     // Catch: Throwable -> L180
        if (r116 == null) goto L79;
        EnsureManager.ensureNotReachHere(r116);     // Catch: Throwable -> L180
    L79:
        if (Result.m9455isFailureimpl(r115) == false) goto L82;
        r115 = null;
    L82:
        if ((r115 instanceof String) == true) goto L84;
        r115 = null;
    L84:
        Object r117 = (String) r115;     // Catch: Throwable -> L180
        if (r117 != null) goto L91;
        Object r118 = com.bytedance.android.ec.base.settings.d.f42816a.get("ecom_track_config");     // Catch: Throwable -> L180
        if ((r118 instanceof String) == true) goto L90;
        r118 = null;
    L90:
        r117 = (String) r118;     // Catch: Throwable -> L180
    L91:
        if (r117 != null) goto L187;
        int r119 = com.bytedance.android.ec.base.settings.c.f42815a;     // Catch: Throwable -> L180
        Object r120 = com.bytedance.android.ec.base.settings.d.f42818c.get("ecom_track_config");     // Catch: Throwable -> L146
        if (r120 != null) goto L98;
    L143:
        Object r121 = null;
    L144:
        Object r122 = Result.m9449constructorimpl(r121);     // Catch: Throwable -> L146
    L148:
        Throwable r123 = Result.m9452exceptionOrNullimpl(r122);     // Catch: Throwable -> L171
        if (r123 == null) goto L152;
        EnsureManager.ensureNotReachHere(r123);     // Catch: Throwable -> L171
    L152:
        if (Result.m9455isFailureimpl(r122) == false) goto L155;
        r122 = null;
    L155:
        if ((r122 instanceof String) == true) goto L157;
        r122 = null;
    L157:
        r117 = (String) r122;     // Catch: Throwable -> L171
        if (r117 != null) goto L178;
        IHybridHostService r124 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L171
        if (r124 == null) goto L163;
        Object r125 = r124.getHostABValue("ecom_track_config", "VALUE_EC_DYNAMIC_EVENT_CONFIG_NULL");     // Catch: Throwable -> L171
    L164:
        if (r125 != null) goto L166;
    L177:
        r117 = "VALUE_EC_DYNAMIC_EVENT_CONFIG_NULL";
        goto L178
    L166:
        if ((r125 instanceof String) == true) goto L168;
        r125 = null;
    L168:
        r117 = (String) r125;     // Catch: Throwable -> L171
        if (r117 != null) goto L178;
    L171:
        th = move-exception;
        Result.Companion r126 = Result.Companion;     // Catch: Throwable -> L180
        r117 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L180
        Throwable r127 = Result.m9452exceptionOrNullimpl(r117);     // Catch: Throwable -> L180
        if (r127 == null) goto L176;
        EnsureManager.ensureNotReachHere(r127);     // Catch: Throwable -> L180
    L176:
        if (Result.m9455isFailureimpl(r117) == false) goto L178;
    L163:
        r125 = null;
    L178:
        com.bytedance.android.ec.base.settings.d.d("ecom_track_config", r117);     // Catch: Throwable -> L180
        goto L187
    L98:
        if ((r120 instanceof String) == true) goto L100;
        Object r128 = null;
    L101:
        r121 = (String) r128;     // Catch: Throwable -> L146
        if (r121 != null) goto L144;
        if ((r120 instanceof Number) == false) goto L131;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L113;
        Float r129 = Float.valueOf(((Number) r120).floatValue());     // Catch: Throwable -> L146
        if ((r129 instanceof String) == true) goto L111;
        r129 = null;
    L111:
        r121 = (String) r129;     // Catch: Throwable -> L146
        goto L144
    L113:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L119;
        Double r130 = Double.valueOf(((Number) r120).doubleValue());     // Catch: Throwable -> L146
        if ((r130 instanceof String) == true) goto L117;
        r130 = null;
    L117:
        r121 = (String) r130;     // Catch: Throwable -> L146
        goto L144
    L119:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L125;
        Integer r131 = Integer.valueOf(((Number) r120).intValue());     // Catch: Throwable -> L146
        if ((r131 instanceof String) == true) goto L123;
        r131 = null;
    L123:
        r121 = (String) r131;     // Catch: Throwable -> L146
        goto L144
    L125:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L131;
        Long r132 = Long.valueOf(((Number) r120).longValue());     // Catch: Throwable -> L146
        if ((r132 instanceof String) == true) goto L129;
        r132 = null;
    L129:
        r121 = (String) r132;     // Catch: Throwable -> L146
    L131:
        if ((r120 instanceof JSONObject) == false) goto L133;
    L426:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L139
        Object r133 = SDKSettingsCacheManager.a().fromJson(r120.toString(), String.class);     // Catch: Throwable -> L139
        if ((r133 instanceof String) == true) goto L137;
        r133 = null;
    L137:
        Object r134 = Result.m9449constructorimpl((String) r133);     // Catch: Throwable -> L139
    L141:
        r121 = r134;
        if (Result.m9455isFailureimpl(r121) == false) goto L144;
    L139:
        th = move-exception;
        Result.Companion r135 = Result.Companion;     // Catch: Throwable -> L146
        r134 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L146
        goto L141
    L133:
        if ((r120 instanceof JSONArray) == false) goto L143;
    L100:
        r128 = r120;
    L146:
        th = move-exception;
        Result.Companion r136 = Result.Companion;     // Catch: Throwable -> L171
        r122 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L171
    L187:
        String r137 = (String) r117;
        int r138 = 3;
        boolean r139 = false;
        if (Intrinsics.areEqual(r137, "VALUE_EC_DYNAMIC_EVENT_CONFIG_NULL") == false) goto L191;
        String[] r140 = null;
        int r141 = 2;
    L213:
        if (r140 == null) goto L424;
        r138 = 0;
    L230:
        Pair r142 = new Pair(r140, new CyberProtectionConfig.a(r141, r138, null));
        String[] r143 = (String[]) r142.component1();
        CyberProtectionConfig.a r144 = (CyberProtectionConfig.a) r142.component2();
        int r145 = r144.f43922b;
        if (r145 <= 0) goto L233;
        boolean r146 = true;
    L234:
        if (r143 != null) goto L236;
    L257:
        Triple r147 = new Triple(null, null, new CyberProtectionConfig.a(r144.f43921a, r145, CyberProtectionConfig.ConfigError.Lack));
    L258:
        f r148 = (f) r147.component1();
        d r149 = (d) r147.component2();
        CyberProtectionConfig.a r150 = (CyberProtectionConfig.a) r147.component3();
        CyberProtectionConfig.ConfigError r151 = r150.f43923c;
        f43933j = r150.f43921a;
        f43934k = r150.f43922b;
        if (r151 != CyberProtectionConfig.ConfigError.JSON) goto L262;
        f43925b = "0x796127e5";
        Object r152 = Unit.INSTANCE;
    L404:
        if (r152 != r103) goto L407;
        return r103;
    L262:
        if (r151 != CyberProtectionConfig.ConfigError.Decode) goto L265;
        f43925b = "0x596077f5";
        r152 = Unit.INSTANCE;
        goto L404
    L265:
        if (r151 == CyberProtectionConfig.ConfigError.Lack) goto L403;
        if (r148 == null) goto L403;
        if (r149 == null) goto L403;
        f43927d = r148;
        f43928e = r149;
        if ((!Intrinsics.areEqual(r148.d(), r149.g())) == false) goto L272;
        f43925b = "0x14ba792b";
        r152 = Unit.INSTANCE;
        goto L404
    L272:
        String r153 = r149.e();
        if (r153 == null) goto L276;
        List r154 = StringsKt.split$default(r153, new String[]{","}, false, 0, 6, null);
        if (r154 == null) goto L276;
    L277:
        List<String> r155 = CollectionsKt.toMutableList(r154);
        int r156 = r155.size();
        Integer r157 = r149.a();
        if (r157 != null) goto L281;
    L282:
        f43925b = "0x3b671cfe";
        r152 = Unit.INSTANCE;
        goto L404
    L281:
        if (r156 != r157.intValue()) goto L282;
        Intrinsics.checkNotNullParameter(r149, "$this$notNull");
        if (r149.c() != null) goto L286;
    L300:
        boolean r158 = false;
    L301:
        if (r158 == true) goto L303;
        f43925b = "0x91fff2c6";
        r152 = Unit.INSTANCE;
        goto L404
    L303:
        Intrinsics.checkNotNullParameter(r149, "$this$hasEmpty");
        String r159 = r149.g();
        if (r159 != null) goto L306;
    L309:
        boolean r160 = true;
    L310:
        if (r160 == true) goto L337;
        String r161 = r149.b();
        if (r161 != null) goto L314;
    L317:
        boolean r162 = true;
    L318:
        if (r162 == true) goto L337;
        String r163 = r149.f();
        if (r163 != null) goto L322;
    L325:
        boolean r164 = true;
    L326:
        if (r164 == true) goto L337;
        String r165 = r149.e();
        if (r165 != null) goto L330;
    L333:
        boolean r166 = true;
    L334:
        if (r166 == true) goto L337;
        boolean r167 = false;
    L338:
        if (r167 == false) goto L340;
        f43925b = "0xff488464";
        r152 = Unit.INSTANCE;
        goto L404
    L340:
        Integer r168 = r149.getType();
        if (r168 != null) goto L344;
    L345:
        Integer r169 = r149.getType();
        if (r169 != null) goto L349;
    L350:
        f43925b = "0xa07da6e8";
        r152 = Unit.INSTANCE;
        goto L404
    L349:
        if (r169.intValue() != 2) goto L350;
    L351:
        Integer r170 = r149.getType();
        if (r170 != null) goto L355;
    L365:
        Integer r171 = r149.getType();
        if (r171 != null) goto L369;
    L373:
        Intrinsics.checkNotNullParameter(r148, "$this$notNull");
        if (r148.d() != null) goto L376;
    L389:
        boolean r172 = false;
    L390:
        if (r172 == true) goto L392;
        f43925b = "0x7f063672";
        r152 = Unit.INSTANCE;
        goto L404
    L392:
        String r173 = r148.d();
        if (r173 != null) goto L395;
    L396:
        r139 = true;
    L397:
        if (r139 == false) goto L399;
        f43925b = "0x73cb043e";
        r152 = Unit.INSTANCE;
        goto L404
    L399:
        r152 = r110.e(r149, r148, r155, r100);
        if (r152 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L404;
        r152 = Unit.INSTANCE;
        goto L404
    L395:
        if (StringsKt.isBlank(r173) == false) goto L397;
    L376:
        if (r148.a() == null) goto L389;
        if (r148.b() == null) goto L389;
        g r174 = r148.c();
        if (r174 == null) goto L389;
        Intrinsics.checkNotNullParameter(r174, "$this$notNull");
        if (r174.b() != null) goto L384;
    L386:
        boolean r175 = false;
    L387:
        if (r175 != true) goto L389;
        r172 = true;
        goto L390
    L384:
        if (r174.a() == null) goto L386;
        r175 = true;
        goto L387
    L369:
        if (r171.intValue() != 2) goto L373;
        if (r149.a().intValue() > 0) goto L373;
        f43925b = "0xdd1ca9ef";
        r152 = Unit.INSTANCE;
        goto L404
    L355:
        if (r170.intValue() != 2) goto L365;
        String r176 = r149.d();
        if (r176 != null) goto L359;
    L362:
        boolean r177 = true;
    L363:
        if (r177 == false) goto L365;
        f43925b = "0xc665b5ff";
        r152 = Unit.INSTANCE;
        goto L404
    L359:
        if (StringsKt.isBlank(r176) == true) goto L362;
        r177 = false;
        goto L363
    L344:
        if (r168.intValue() == 1) goto L351;
    L330:
        if (StringsKt.isBlank(r165) == true) goto L333;
        r166 = false;
        goto L334
    L322:
        if (StringsKt.isBlank(r163) == true) goto L325;
        r164 = false;
        goto L326
    L314:
        if (StringsKt.isBlank(r161) == true) goto L317;
        r162 = false;
    L337:
        r167 = true;
        goto L338
    L306:
        if (StringsKt.isBlank(r159) == true) goto L309;
        r160 = false;
        goto L310
    L286:
        if (r149.g() == null) goto L300;
        if (r149.b() == null) goto L300;
        if (r149.f() == null) goto L300;
        if (r149.getType() == null) goto L300;
        if (r149.d() == null) goto L300;
        if (r149.a() == null) goto L300;
        if (r149.e() == null) goto L300;
        r158 = true;
    L276:
        r154 = CollectionsKt.emptyList();
    L403:
        f43925b = "0xc4f37df9";
        r152 = Unit.INSTANCE;
        goto L404
    L236:
        if (r143.length < 2) goto L257;
        Pair r178 = CyberProtectionConfig.a(r143[0], d.class);
        d r179 = (d) r178.component1();
        CyberProtectionConfig.ConfigError r180 = (CyberProtectionConfig.ConfigError) r178.component2();
        Pair r181 = CyberProtectionConfig.a(r143[1], f.class);
        f r182 = (f) r181.component1();
        CyberProtectionConfig.ConfigError r183 = (CyberProtectionConfig.ConfigError) r181.component2();
        CyberProtectionConfig.ConfigError r184 = CyberProtectionConfig.ConfigError.Lack;
        if (r183 == r184) goto L249;
        if (r180 == r184) goto L249;
        r184 = CyberProtectionConfig.ConfigError.Decode;
        if (r183 == r184) goto L249;
        if (r180 == r184) goto L249;
        r184 = CyberProtectionConfig.ConfigError.JSON;
        if (r183 == r184) goto L249;
        if (r180 == r184) goto L249;
    L250:
        if (r109 != null) goto L256;
        if (r146 == true) goto L256;
        Result.Companion r185 = Result.Companion;     // Catch: Throwable -> L254
        ((Keva) CyberProtectionConfig.f43917a.getValue()).storeString("ecom_track_config", u0.d(r143));     // Catch: Throwable -> L254
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L254
    L254:
        th = move-exception;
        Result.Companion r186 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    L256:
        r147 = new Triple(r182, r179, new CyberProtectionConfig.a(r144.f43921a, r144.f43922b, r109));
    L249:
        r109 = r184;
        goto L250
    L233:
        r146 = false;
        goto L234
    L424:
        String r187 = ((Keva) CyberProtectionConfig.f43917a.getValue()).getString("ecom_track_config", "VALUE_EC_DYNAMIC_EVENT_CONFIG_NULL");     // Catch: Throwable -> L216
    L217:
        if (r187 != null) goto L219;
    L228:
        r138 = 2;
        goto L230
    L219:
        if (Intrinsics.areEqual(r187, "VALUE_EC_DYNAMIC_EVENT_CONFIG_NULL") == true) goto L228;
        String[] r188 = (String[]) u0.b(r187, String[].class);     // Catch: Throwable -> L223
    L224:
        if (r188 == null) goto L230;
        if (r188.length < 2) goto L230;
        r140 = r188;
        r138 = 1;
    L223:
        r188 = null;
    L216:
        r187 = null;
        goto L217
    L191:
        if (Intrinsics.areEqual(r137, "None") == false) goto L428;
        r140 = null;
        r141 = 3;
        goto L213
    L428:
        r140 = (String[]) u0.b(r137, String[].class);     // Catch: Throwable -> L195
    L196:
        if (r140 != null) goto L198;
    L200:
        if (r140 != null) goto L203;
        int r189 = 4;
    L212:
        r141 = r189;
        r140 = null;
        goto L213
    L203:
        if (r140.length != 0) goto L205;
        boolean r190 = true;
    L206:
        if (r190 == false) goto L209;
        r189 = 5;
        goto L212
    L209:
        if (1 != r140.length) goto L211;
        r189 = 6;
        goto L212
    L211:
        r189 = 1;
        goto L212
    L205:
        r190 = false;
        goto L206
    L198:
        if (r140.length < 2) goto L200;
        r141 = 0;
    L195:
        r140 = null;
        goto L196
    L25:
        if ((r113 instanceof String) == true) goto L27;
        Object r191 = null;
    L28:
        r114 = (String) r191;     // Catch: Throwable -> L73
        if (r114 != null) goto L71;
        if ((r113 instanceof Number) == false) goto L58;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L40;
        Float r192 = Float.valueOf(((Number) r113).floatValue());     // Catch: Throwable -> L73
        if ((r192 instanceof String) == true) goto L38;
        r192 = null;
    L38:
        r114 = (String) r192;     // Catch: Throwable -> L73
        goto L71
    L40:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L46;
        Double r193 = Double.valueOf(((Number) r113).doubleValue());     // Catch: Throwable -> L73
        if ((r193 instanceof String) == true) goto L44;
        r193 = null;
    L44:
        r114 = (String) r193;     // Catch: Throwable -> L73
        goto L71
    L46:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L52;
        Integer r194 = Integer.valueOf(((Number) r113).intValue());     // Catch: Throwable -> L73
        if ((r194 instanceof String) == true) goto L50;
        r194 = null;
    L50:
        r114 = (String) r194;     // Catch: Throwable -> L73
        goto L71
    L52:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L58;
        Long r195 = Long.valueOf(((Number) r113).longValue());     // Catch: Throwable -> L73
        if ((r195 instanceof String) == true) goto L56;
        r195 = null;
    L56:
        r114 = (String) r195;     // Catch: Throwable -> L73
    L58:
        if ((r113 instanceof JSONObject) == false) goto L60;
    L418:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L66
        Object r196 = SDKSettingsCacheManager.a().fromJson(r113.toString(), String.class);     // Catch: Throwable -> L66
        if ((r196 instanceof String) == true) goto L64;
        r196 = null;
    L64:
        Object r197 = Result.m9449constructorimpl((String) r196);     // Catch: Throwable -> L66
    L68:
        r114 = r197;
        if (Result.m9455isFailureimpl(r114) == false) goto L71;
    L66:
        th = move-exception;
        Result.Companion r198 = Result.Companion;     // Catch: Throwable -> L73
        r197 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L73
        goto L68
    L60:
        if ((r113 instanceof JSONArray) == false) goto L70;
    L27:
        r191 = r113;
    L73:
        th = move-exception;
        Result.Companion r199 = Result.Companion;     // Catch: Throwable -> L180
        r115 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L180
    L180:
        th = move-exception;
        Result.Companion r200 = Result.Companion;
        r117 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r201 = Result.m9452exceptionOrNullimpl(r117);
        if (r201 == null) goto L185;
        EnsureManager.ensureNotReachHere(r201);
    L185:
        if (Result.m9455isFailureimpl(r117) == false) goto L187;
        r117 = "VALUE_EC_DYNAMIC_EVENT_CONFIG_NULL";
        goto L187
    L438:
        return Unit.INSTANCE;
    L7:
        r100 = new CyberProtectionInjector$initConfig$1(r110, r111);
        goto L8
    }

    @Override // com.bytedance.android.ec.sdk.helper.u
    public final void a(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "params");
        String r102 = c(r100);
        if (r102 == null) goto L6;
        r101.put("ecom_track_param", r102);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v5, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.util.List<java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:117:0x0223 -> B:118:0x0227). Please report as a decompilation issue!!! */
    public final Object e(d r210, f r211, List<String> r212, Continuation<? super Unit> r213) {
        if ((r213 instanceof CyberProtectionInjector$parseInitConfig$1) == false) goto L7;
        CyberProtectionInjector$parseInitConfig$1 r100 = (CyberProtectionInjector$parseInitConfig$1) r213;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L16;
        if (r104 == 1) goto L15;
        if (r104 != 2) goto L14;
        String r105 = (String) r100.L$2;
        List r106 = (List) r100.L$1;
        k r107 = (k) r100.L$0;
        ResultKt.throwOnFailure(r102);
        ?? r108 = r106;
    L123:
        String r109 = (String) r102;
        if (r109 != null) goto L127;
        f43925b = "0x4aaec536";
        return Unit.INSTANCE;
    L127:
        f43929f = r107;
        f43926c = r108;
        f43930g = r105;
        f43931h = r109;
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        Collection r110 = (Collection) r100.L$4;
        Iterator r111 = (Iterator) r100.L$3;
        Collection r112 = (Collection) r100.L$2;
        List r113 = (List) r100.L$1;
        k r114 = (k) r100.L$0;
        ResultKt.throwOnFailure(r102);
        Object r115 = r103;
        ?? r116 = r113;
        Iterator r117 = r111;
    L118:
        r110.add((String) r102);
        r110 = r112;
        Iterator r118 = r117;
        k r119 = r114;
        ?? r120 = r116;
    L113:
        if (r118.hasNext() == false) goto L119;
        String r121 = (String) r118.next();
        r100.L$0 = r119;
        r100.L$1 = r120;
        r100.L$2 = r110;
        r100.L$3 = r118;
        r100.L$4 = r110;
        r100.label = 1;
        Object r122 = c.c(r121, r100);
        if (r122 != r115) goto L117;
        return r115;
    L117:
        r114 = r119;
        r102 = r122;
        r117 = r118;
        r112 = r110;
        r116 = r120;
        goto L118
    L119:
        r105 = CollectionsKt.joinToString$default((List) r110, HiAnalyticsConstant.REPORT_VAL_SEPARATOR, null, null, 0, null, null, 62, null);
        r100.L$0 = r119;
        r100.L$1 = r120;
        r100.L$2 = r105;
        r100.L$3 = null;
        r100.L$4 = null;
        r100.label = 2;
        Object r123 = c.b(r105, r100);
        if (r123 != r115) goto L122;
        return r115;
    L122:
        r107 = r119;
        r102 = r123;
        r108 = r120;
        goto L123
    L16:
        ResultKt.throwOnFailure(r102);
        Map<String, String> r124 = r211.b();
        if (r124 != null) goto L19;
        r124 = MapsKt.emptyMap();
    L19:
        List<String> r125 = r212;
        Iterator r126 = r125.iterator();
        int r127 = 0;
    L21:
        if (r126.hasNext() == false) goto L35;
        String r128 = (String) r126.next();
        String r129 = r124.get(r128);
        if (r129 == null) goto L27;
        r128 = r129;
    L27:
        if (c.a(r128) == false) goto L28;
        if (Intrinsics.areEqual(r128, "none") == true) goto L32;
        ListProtector.set(r212, r127, r128);
        r127 = r127 + 1;
        goto L21
    L32:
        f43925b = "0x073f8321";
        return Unit.INSTANCE;
    L28:
        f43925b = "0x8ab62d69";
        return Unit.INSTANCE;
    L35:
        String r130 = r210.d();
        if (r130 == null) goto L43;
        Map<String, String> r131 = r211.a();
        if (r131 == null) goto L44;
        String r132 = r131.get(r130);
        if (r132 == null) goto L44;
        r130 = r132;
    L44:
        if (r130 != null) goto L46;
    L129:
        f43925b = "0xd0b2dce3";
        return Unit.INSTANCE;
    L46:
        if (c.a(r130) == false) goto L129;
        a r133 = i.f43939a;
        int r134 = r130.hashCode();
        switch(r134) {
            case 2281: goto L77;
            case 2282: goto L74;
            case 2283: goto L71;
            case 2284: goto L68;
            case 2285: goto L65;
            case 2286: goto L62;
            case 2287: goto L59;
            case 2288: goto L56;
            case 2289: goto L53;
            default: goto L50;
        };
    L50:
        switch(r134) {
            case 70759: goto L86;
            case 70760: goto L83;
            case 70761: goto L80;
            default: goto L148;
        };
    L148:
        k r135 = null;
    L89:
        if (r135 != null) goto L92;
        f43925b = "0x88748f85";
        return Unit.INSTANCE;
    L92:
        g r136 = r211.c();
        if (r136 == null) goto L110;
        String r137 = r136.b();
        if (r137 == null) goto L110;
        List r138 = StringsKt.split$default(r137, new String[]{","}, false, 0, 6, null);
        if (r138 == null) goto L110;
        List r139 = r138;
        ?? r140 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r139, 10));
        Iterator r141 = r139.iterator();
    L100:
        if (r141.hasNext() == false) goto L111;
        String r142 = (String) r141.next();
        Locale r143 = Locale.ROOT;
        if (r142 == null) goto L109;
        String r144 = StringsKt.replace$default(r142.toUpperCase(r143), "B", "", false, 4, null);
        if (r144 == null) goto L107;
        r140.add(Boxing.boxInt(CastIntegerProtector.parseInt(StringsKt.trim(r144).toString())));
        goto L100
    L107:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    L109:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L111:
        ArrayList r145 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r125, 10));
        r118 = r125.iterator();
        r115 = r103;
        r120 = r140;
        r119 = r135;
        r110 = r145;
    L110:
        r140 = CollectionsKt.emptyList();
        goto L111
    L80:
        if (r130.equals("H12") == false) goto L145;
        r135 = i.f43950l;
        goto L89
    L145:
        r135 = null;
        goto L89
    L83:
        if (r130.equals("H11") == false) goto L146;
        r135 = i.f43949k;
        goto L89
    L146:
        r135 = null;
        goto L89
    L86:
        if (r130.equals("H10") == false) goto L147;
        r135 = i.f43948j;
        goto L89
    L147:
        r135 = null;
        goto L89
    L53:
        if (r130.equals("H9") == false) goto L88;
        r135 = i.f43947i;
        goto L89
    L88:
        r135 = null;
        goto L89
    L56:
        if (r130.equals("H8") == false) goto L137;
        r135 = i.f43946h;
        goto L89
    L137:
        r135 = null;
        goto L89
    L59:
        if (r130.equals("H7") == false) goto L138;
        r135 = i.f43945g;
        goto L89
    L138:
        r135 = null;
        goto L89
    L62:
        if (r130.equals("H6") == false) goto L139;
        r135 = i.f43944f;
        goto L89
    L139:
        r135 = null;
        goto L89
    L65:
        if (r130.equals("H5") == false) goto L140;
        r135 = i.f43943e;
        goto L89
    L140:
        r135 = null;
        goto L89
    L68:
        if (r130.equals("H4") == false) goto L141;
        r135 = i.f43942d;
        goto L89
    L141:
        r135 = null;
        goto L89
    L71:
        if (r130.equals("H3") == false) goto L142;
        r135 = i.f43941c;
        goto L89
    L142:
        r135 = null;
        goto L89
    L74:
        if (r130.equals("H2") == false) goto L143;
        r135 = i.f43940b;
        goto L89
    L143:
        r135 = null;
        goto L89
    L77:
        if (r130.equals("H1") == false) goto L144;
        r135 = i.f43939a;
        goto L89
    L144:
        r135 = null;
        goto L89
    L43:
        r130 = null;
    L7:
        r100 = new CyberProtectionInjector$parseInitConfig$1(this, r213);
        goto L8
    }
}
