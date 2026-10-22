package com.bytedance.android.ec.core.abtest;

import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.core.anchorv3.m;
import com.bytedance.android.ec.core.buynow.BuyNowSettingConfig;
import com.bytedance.android.ec.core.data.EntranceInfoReportConfig;
import com.bytedance.android.ec.core.data.EntranceInfoWhiteListConfig;
import com.bytedance.android.ec.core.data.EntranceInfoWriteConfig;
import com.bytedance.android.ec.core.opt.ab.n;
import com.bytedance.android.ec.core.opt.ab.p;
import com.bytedance.android.ec.core.order.OrderCacheConfig;
import com.bytedance.android.ec.core.order.OrderListSettingConfig;
import com.bytedance.android.ec.core.order.OrderSkeletonMonitorConfig;
import com.bytedance.android.ec.core.sku.UltimateBuyCacheConfig;
import com.bytedance.android.ec.core.utils.w0;
import com.bytedance.android.ec.hybrid.hostapi.IECHybridKevaService;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.model.ECCacheMonitorStruct;
import com.bytedance.android.ec.model.promotion.ECResultDialogContentVO;
import com.bytedance.android.ec.model.promotion.ECSimilarProductFunctionDescriptionViewUri;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.dataplatform.config.SettingPanel;
import com.bytedance.services.apm.api.EnsureManager;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.ttm.player.MediaPlayer;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeIntrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class ECSettingKeys {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f43616a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f43617b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f43618c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f43619d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f43620e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Lazy f43621f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Lazy f43622g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Lazy f43623h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Lazy f43624i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final ECSettingKeys f43625j = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f43626a = 0;

        static {
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f43627a = 0;

        static {
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f43628a = 0;

        static {
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f43629a = 0;

        static {
        }
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f43630a = 0;

        static {
        }
    }

    public static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f43631a = 0;

        static {
        }
    }

    public ECSettingKeys() {
    }

    public static final boolean d() {
        return ((Boolean) f43617b.getValue()).booleanValue();
    }

    public static com.bytedance.android.ec.core.cart.a h() {
        return (com.bytedance.android.ec.core.cart.a) f43622g.getValue();
    }

    public static final boolean n() {
        return ((Boolean) f43623h.getValue()).booleanValue();
    }

    static {
        f43625j = new ECSettingKeys();
        LazyThreadSafetyMode r100 = LazyThreadSafetyMode.NONE;
        f43616a = LazyKt.lazy(r100, ECSettingKeys$IESEC_BUY_NOW_OPT_FOOTER_MARGIN$2.INSTANCE);
        f43617b = LazyKt.lazy(r100, ECSettingKeys$BUYNOW_SUPPORT_LONG_LINK$2.INSTANCE);
        f43618c = LazyKt.lazy(r100, ECSettingKeys$PDP_PRELOAD_USE_PITAYA$2.INSTANCE);
        f43619d = LazyKt.lazy(r100, ECSettingKeys$LIVE_FIRST_SHOW_PREFETCH$2.INSTANCE);
        f43620e = LazyKt.lazy(r100, ECSettingKeys$LIVE_PRODUCT_CLICK_PREFETCH$2.INSTANCE);
        f43621f = LazyKt.lazy(ECSettingKeys$BUY_NOW_STARTER_HOLDER_MEMORY_LEAK$2.INSTANCE);
        f43622g = LazyKt.lazy(ECSettingKeys$CART_ENTER_PERF_OPT_V1$2.INSTANCE);
        f43623h = LazyKt.lazy(r100, ECSettingKeys$ECOM_SKU_JS_EVENT_OPT$2.INSTANCE);
        f43624i = LazyKt.lazy(r100, ECSettingKeys$EC_BUY_CJ_PASSTHROUGH$2.INSTANCE);
    }

    @SettingPanel("电商直播间事件中心开关")
    public static final boolean A() {
        int r100 = p.f45243a;
        Object r101 = Boolean.TRUE;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r103 = jj4.b.f499326b;     // Catch: Throwable -> L7
        Object r104 = jj4.a.a("ec_live_event_center_switch", Boolean.class, r101, false);     // Catch: Throwable -> L7
        if (r104 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return ((Boolean) r104).booleanValue();
    L7:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Object r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r106) == true) goto L12;
        r101 = r106;
    L12:
        r104 = r101;
        goto L14
    }

    @SettingPanel("头图收缩配置")
    public static final k A0() {
        int r100 = com.bytedance.android.ec.base.settings.a.f42813a;
        Object r101 = new k(0);
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L166
        Object r103 = null;
        Object r104 = com.bytedance.android.ec.base.settings.d.f42818c.get("pdp_head_shrink_config");     // Catch: Throwable -> L57
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
        if ((r106 instanceof k) == true) goto L68;
        r106 = null;
    L68:
        Object r108 = (k) r106;     // Catch: Throwable -> L166
        if (r108 != null) goto L75;
        Object r109 = com.bytedance.android.ec.base.settings.d.f42816a.get("pdp_head_shrink_config");     // Catch: Throwable -> L166
        if ((r109 instanceof k) == true) goto L74;
        r109 = null;
    L74:
        r108 = (k) r109;     // Catch: Throwable -> L166
    L75:
        if (r108 != null) goto L176;
        int r110 = com.bytedance.android.ec.base.settings.c.f42815a;     // Catch: Throwable -> L166
        Object r111 = com.bytedance.android.ec.base.settings.d.f42818c.get("pdp_head_shrink_config");     // Catch: Throwable -> L130
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
        if ((r113 instanceof k) == true) goto L141;
        r113 = null;
    L141:
        r108 = (k) r113;     // Catch: Throwable -> L156
        if (r108 != null) goto L164;
        IHybridHostService r115 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L156
        if (r115 == null) goto L147;
        Object r116 = r115.getHostABValue("pdp_head_shrink_config", r101);     // Catch: Throwable -> L156
    L148:
        if (r116 != null) goto L150;
    L155:
        r108 = r101;
        goto L164
    L150:
        if ((r116 instanceof k) == false) goto L153;
        r103 = r116;
    L153:
        Object r117 = (k) r103;     // Catch: Throwable -> L156
        if (r117 == null) goto L155;
    L163:
        r108 = r117;
        goto L164
    L147:
        r116 = null;
    L164:
        com.bytedance.android.ec.base.settings.d.d("pdp_head_shrink_config", r108);     // Catch: Throwable -> L166
        goto L176
    L82:
        if ((r111 instanceof k) == true) goto L84;
        Object r118 = null;
    L85:
        r112 = (k) r118;     // Catch: Throwable -> L130
        if (r112 != null) goto L128;
        if ((r111 instanceof Number) == false) goto L115;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(k.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r119 = Float.valueOf(((Number) r111).floatValue());     // Catch: Throwable -> L130
        if ((r119 instanceof k) == true) goto L95;
        r119 = null;
    L95:
        r112 = (k) r119;     // Catch: Throwable -> L130
        goto L128
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(k.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r120 = Double.valueOf(((Number) r111).doubleValue());     // Catch: Throwable -> L130
        if ((r120 instanceof k) == true) goto L101;
        r120 = null;
    L101:
        r112 = (k) r120;     // Catch: Throwable -> L130
        goto L128
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(k.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L109;
        Integer r121 = Integer.valueOf(((Number) r111).intValue());     // Catch: Throwable -> L130
        if ((r121 instanceof k) == true) goto L107;
        r121 = null;
    L107:
        r112 = (k) r121;     // Catch: Throwable -> L130
        goto L128
    L109:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(k.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L115;
        Long r122 = Long.valueOf(((Number) r111).longValue());     // Catch: Throwable -> L130
        if ((r122 instanceof k) == true) goto L113;
        r122 = null;
    L113:
        r112 = (k) r122;     // Catch: Throwable -> L130
    L115:
        if ((r111 instanceof JSONObject) == false) goto L117;
    L184:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L123
        Object r123 = SDKSettingsCacheManager.a().fromJson(r111.toString(), k.class);     // Catch: Throwable -> L123
        if ((r123 instanceof k) == true) goto L121;
        r123 = null;
    L121:
        Object r124 = Result.m9449constructorimpl((k) r123);     // Catch: Throwable -> L123
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
        r117 = r101;
    L130:
        th = move-exception;
        Result.Companion r128 = Result.Companion;     // Catch: Throwable -> L156
        r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L156
    L176:
        return (k) r108;
    L9:
        if ((r104 instanceof k) == true) goto L11;
        Object r129 = null;
    L12:
        r105 = (k) r129;     // Catch: Throwable -> L57
        if (r105 != null) goto L55;
        if ((r104 instanceof Number) == false) goto L42;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(k.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L24;
        Float r130 = Float.valueOf(((Number) r104).floatValue());     // Catch: Throwable -> L57
        if ((r130 instanceof k) == true) goto L22;
        r130 = null;
    L22:
        r105 = (k) r130;     // Catch: Throwable -> L57
        goto L55
    L24:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(k.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L30;
        Double r131 = Double.valueOf(((Number) r104).doubleValue());     // Catch: Throwable -> L57
        if ((r131 instanceof k) == true) goto L28;
        r131 = null;
    L28:
        r105 = (k) r131;     // Catch: Throwable -> L57
        goto L55
    L30:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(k.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L36;
        Integer r132 = Integer.valueOf(((Number) r104).intValue());     // Catch: Throwable -> L57
        if ((r132 instanceof k) == true) goto L34;
        r132 = null;
    L34:
        r105 = (k) r132;     // Catch: Throwable -> L57
        goto L55
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(k.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L42;
        Long r133 = Long.valueOf(((Number) r104).longValue());     // Catch: Throwable -> L57
        if ((r133 instanceof k) == true) goto L40;
        r133 = null;
    L40:
        r105 = (k) r133;     // Catch: Throwable -> L57
    L42:
        if ((r104 instanceof JSONObject) == false) goto L44;
    L181:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L50
        Object r134 = SDKSettingsCacheManager.a().fromJson(r104.toString(), k.class);     // Catch: Throwable -> L50
        if ((r134 instanceof k) == true) goto L48;
        r134 = null;
    L48:
        Object r135 = Result.m9449constructorimpl((k) r134);     // Catch: Throwable -> L50
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
        goto L176
    }

    @SettingPanel("电商域直播预览流默认清晰度优化v2")
    public static final Map<String, String> B() {
        int r100 = n.f45241a;
        Object r101 = new LinkedHashMap();
        int r102 = com.bytedance.android.ec.base.settings.a.f42813a;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L170
        Object r104 = null;
        Object r105 = com.bytedance.android.ec.base.settings.d.f42818c.get("ec_live_player_default_resolution");     // Catch: Throwable -> L57
        if (r105 != null) goto L9;
    L54:
        Object r106 = null;
    L55:
        Object r107 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L57
    L59:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);     // Catch: Throwable -> L170
        if (r108 == null) goto L63;
        EnsureManager.ensureNotReachHere(r108);     // Catch: Throwable -> L170
    L63:
        if (Result.m9455isFailureimpl(r107) == false) goto L66;
        r107 = null;
    L66:
        if (TypeIntrinsics.isMutableMap(r107) == true) goto L68;
        r107 = null;
    L68:
        Object r109 = (Map) r107;     // Catch: Throwable -> L170
        if (r109 != null) goto L71;
    L73:
        Object r110 = com.bytedance.android.ec.base.settings.d.f42816a.get("ec_live_player_default_resolution");     // Catch: Throwable -> L170
        if (TypeIntrinsics.isMutableMap(r110) == true) goto L76;
        r110 = null;
    L76:
        r109 = (Map) r110;     // Catch: Throwable -> L170
    L77:
        if (r109 != null) goto L180;
        int r111 = com.bytedance.android.ec.base.settings.c.f42815a;     // Catch: Throwable -> L170
        Object r112 = com.bytedance.android.ec.base.settings.d.f42818c.get("ec_live_player_default_resolution");     // Catch: Throwable -> L132
        if (r112 != null) goto L84;
    L129:
        Object r113 = null;
    L130:
        Object r114 = Result.m9449constructorimpl(r113);     // Catch: Throwable -> L132
    L134:
        Throwable r115 = Result.m9452exceptionOrNullimpl(r114);     // Catch: Throwable -> L160
        if (r115 == null) goto L138;
        EnsureManager.ensureNotReachHere(r115);     // Catch: Throwable -> L160
    L138:
        if (Result.m9455isFailureimpl(r114) == false) goto L141;
        r114 = null;
    L141:
        if (TypeIntrinsics.isMutableMap(r114) == true) goto L143;
        r114 = null;
    L143:
        r109 = (Map) r114;     // Catch: Throwable -> L160
        if (r109 != null) goto L146;
    L148:
        IHybridHostService r116 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L160
        if (r116 == null) goto L151;
        Object r117 = r116.getHostABValue("ec_live_player_default_resolution", r101);     // Catch: Throwable -> L160
    L152:
        if (r117 != null) goto L154;
    L159:
        r109 = r101;
    L168:
        com.bytedance.android.ec.base.settings.d.d("ec_live_player_default_resolution", r109);     // Catch: Throwable -> L170
        goto L180
    L154:
        if (TypeIntrinsics.isMutableMap(r117) == false) goto L157;
        r104 = r117;
    L157:
        Object r118 = (Map) r104;     // Catch: Throwable -> L160
        if (r118 == null) goto L159;
    L167:
        r109 = r118;
        goto L168
    L151:
        r117 = null;
        goto L152
    L146:
        if (TypeIntrinsics.isMutableMap(r109) == false) goto L148;
    L84:
        if (TypeIntrinsics.isMutableMap(r112) == true) goto L86;
        Object r119 = null;
    L87:
        r113 = (Map) r119;     // Catch: Throwable -> L132
        if (r113 != null) goto L130;
        if ((r112 instanceof Number) == false) goto L117;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Map.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L99;
        Float r120 = Float.valueOf(((Number) r112).floatValue());     // Catch: Throwable -> L132
        if (TypeIntrinsics.isMutableMap(r120) == true) goto L97;
        r120 = null;
    L97:
        r113 = (Map) r120;     // Catch: Throwable -> L132
        goto L130
    L99:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Map.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L105;
        Double r121 = Double.valueOf(((Number) r112).doubleValue());     // Catch: Throwable -> L132
        if (TypeIntrinsics.isMutableMap(r121) == true) goto L103;
        r121 = null;
    L103:
        r113 = (Map) r121;     // Catch: Throwable -> L132
        goto L130
    L105:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Map.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L111;
        Integer r122 = Integer.valueOf(((Number) r112).intValue());     // Catch: Throwable -> L132
        if (TypeIntrinsics.isMutableMap(r122) == true) goto L109;
        r122 = null;
    L109:
        r113 = (Map) r122;     // Catch: Throwable -> L132
        goto L130
    L111:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Map.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L117;
        Long r123 = Long.valueOf(((Number) r112).longValue());     // Catch: Throwable -> L132
        if (TypeIntrinsics.isMutableMap(r123) == true) goto L115;
        r123 = null;
    L115:
        r113 = (Map) r123;     // Catch: Throwable -> L132
    L117:
        if ((r112 instanceof JSONObject) == false) goto L119;
    L181:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L125
        Object r124 = SDKSettingsCacheManager.a().fromJson(r112.toString(), Map.class);     // Catch: Throwable -> L125
        if (TypeIntrinsics.isMutableMap(r124) == true) goto L123;
        r124 = null;
    L123:
        Object r125 = Result.m9449constructorimpl((Map) r124);     // Catch: Throwable -> L125
    L127:
        r113 = r125;
        if (Result.m9455isFailureimpl(r113) == false) goto L130;
    L125:
        th = move-exception;
        Result.Companion r126 = Result.Companion;     // Catch: Throwable -> L132
        r125 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L132
        goto L127
    L119:
        if ((r112 instanceof JSONArray) == false) goto L129;
    L86:
        r119 = r112;
    L160:
        th = move-exception;
        Result.Companion r127 = Result.Companion;     // Catch: Throwable -> L170
        r118 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L170
        Throwable r128 = Result.m9452exceptionOrNullimpl(r118);     // Catch: Throwable -> L170
        if (r128 == null) goto L165;
        EnsureManager.ensureNotReachHere(r128);     // Catch: Throwable -> L170
    L165:
        if (Result.m9455isFailureimpl(r118) == false) goto L167;
        r118 = r101;
    L132:
        th = move-exception;
        Result.Companion r129 = Result.Companion;     // Catch: Throwable -> L160
        r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L160
    L180:
        return (Map) r109;
    L71:
        if (TypeIntrinsics.isMutableMap(r109) == false) goto L73;
    L9:
        if (TypeIntrinsics.isMutableMap(r105) == true) goto L11;
        Object r130 = null;
    L12:
        r106 = (Map) r130;     // Catch: Throwable -> L57
        if (r106 != null) goto L55;
        if ((r105 instanceof Number) == false) goto L42;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Map.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L24;
        Float r131 = Float.valueOf(((Number) r105).floatValue());     // Catch: Throwable -> L57
        if (TypeIntrinsics.isMutableMap(r131) == true) goto L22;
        r131 = null;
    L22:
        r106 = (Map) r131;     // Catch: Throwable -> L57
        goto L55
    L24:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Map.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L30;
        Double r132 = Double.valueOf(((Number) r105).doubleValue());     // Catch: Throwable -> L57
        if (TypeIntrinsics.isMutableMap(r132) == true) goto L28;
        r132 = null;
    L28:
        r106 = (Map) r132;     // Catch: Throwable -> L57
        goto L55
    L30:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Map.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L36;
        Integer r133 = Integer.valueOf(((Number) r105).intValue());     // Catch: Throwable -> L57
        if (TypeIntrinsics.isMutableMap(r133) == true) goto L34;
        r133 = null;
    L34:
        r106 = (Map) r133;     // Catch: Throwable -> L57
        goto L55
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Map.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L42;
        Long r134 = Long.valueOf(((Number) r105).longValue());     // Catch: Throwable -> L57
        if (TypeIntrinsics.isMutableMap(r134) == true) goto L40;
        r134 = null;
    L40:
        r106 = (Map) r134;     // Catch: Throwable -> L57
    L42:
        if ((r105 instanceof JSONObject) == false) goto L44;
    L187:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L50
        Object r135 = SDKSettingsCacheManager.a().fromJson(r105.toString(), Map.class);     // Catch: Throwable -> L50
        if (TypeIntrinsics.isMutableMap(r135) == true) goto L48;
        r135 = null;
    L48:
        Object r136 = Result.m9449constructorimpl((Map) r135);     // Catch: Throwable -> L50
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
        Result.Companion r138 = Result.Companion;     // Catch: Throwable -> L170
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L170
    L170:
        th = move-exception;
        Result.Companion r139 = Result.Companion;
        Object r140 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r141 = Result.m9452exceptionOrNullimpl(r140);
        if (r141 == null) goto L175;
        EnsureManager.ensureNotReachHere(r141);
    L175:
        if (Result.m9455isFailureimpl(r140) == true) goto L178;
        r101 = r140;
    L178:
        r109 = r101;
        goto L180
    }

    @SettingPanel("商详头图视频自动播放-已固化")
    public static final int B0() {
        int r100 = j.f43647a;
        int r101 = com.bytedance.android.ec.core.abtest.e.f43640a;
        Object r102 = com.bytedance.android.ec.core.abtest.e.a(1, 0);
        int r103 = com.bytedance.android.ec.base.settings.b.f42814a;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L166
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L166
        SDKSettingsCacheManager r105 = SDKSettingsCacheManager.f42812e;     // Catch: Throwable -> L166
        Object r106 = null;
        r105.getClass();     // Catch: Throwable -> L56
        Object r107 = SDKSettingsCacheManager.f42809b.get("iesec_pdp_video_auto_play");     // Catch: Throwable -> L56
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
        Object r112 = SDKSettingsCacheManager.f42808a.get("iesec_pdp_video_auto_play");     // Catch: Throwable -> L166
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
        SDKSettingsCacheManager.e("iesec_pdp_video_auto_play", r111);     // Catch: Throwable -> L166
        goto L176
    L179:
        r116 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("iesec_pdp_video_auto_play", Integer.class, r102);     // Catch: Throwable -> L160
    L161:
        if (r116 != null) goto L163;
        r111 = r102;
    L160:
        r116 = r102;
        goto L161
    L185:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L127
        Object r117 = SDKSettingsCacheManager.f42809b.get("iesec_pdp_video_auto_play");     // Catch: Throwable -> L127
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
        Object r122 = jj4.a.a("iesec_pdp_video_auto_play", Integer.class, r102, false);     // Catch: Throwable -> L153
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

    @SettingPanel("电商域直播预览流默认清晰度优化")
    public static final Map<String, String> C() {
        int r100 = p.f45243a;
        Object r101 = MapsKt.emptyMap();
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r103 = jj4.b.f499326b;     // Catch: Throwable -> L7
        Object r104 = jj4.a.a("iesec_live_player_default_resolution", Map.class, r101, false);     // Catch: Throwable -> L7
        if (r104 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return (Map) r104;
    L7:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Object r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r106) == true) goto L12;
        r101 = r106;
    L12:
        r104 = r101;
        goto L14
    }

    @SettingPanel("商详大字模式适配-已固化")
    public static final int C0() {
        int r100 = j.f43647a;
        int r101 = com.bytedance.android.ec.core.abtest.e.f43640a;
        Object r102 = com.bytedance.android.ec.core.abtest.e.a(1, 0);
        int r103 = com.bytedance.android.ec.base.settings.b.f42814a;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L166
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L166
        SDKSettingsCacheManager r105 = SDKSettingsCacheManager.f42812e;     // Catch: Throwable -> L166
        Object r106 = null;
        r105.getClass();     // Catch: Throwable -> L56
        Object r107 = SDKSettingsCacheManager.f42809b.get("iesec_pdp_new_large_font_mode");     // Catch: Throwable -> L56
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
        Object r112 = SDKSettingsCacheManager.f42808a.get("iesec_pdp_new_large_font_mode");     // Catch: Throwable -> L166
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
        SDKSettingsCacheManager.e("iesec_pdp_new_large_font_mode", r111);     // Catch: Throwable -> L166
        goto L176
    L179:
        r116 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("iesec_pdp_new_large_font_mode", Integer.class, r102);     // Catch: Throwable -> L160
    L161:
        if (r116 != null) goto L163;
        r111 = r102;
    L160:
        r116 = r102;
        goto L161
    L185:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L127
        Object r117 = SDKSettingsCacheManager.f42809b.get("iesec_pdp_new_large_font_mode");     // Catch: Throwable -> L127
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
        Object r122 = jj4.a.a("iesec_pdp_new_large_font_mode", Integer.class, r102, false);     // Catch: Throwable -> L153
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

    @SettingPanel("讲解回放页面消费优化")
    public static final int D() {
        int r100 = p.f45243a;
        Object r101 = 0;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r103 = jj4.b.f499326b;     // Catch: Throwable -> L7
        Object r104 = jj4.a.a("ecom_live_replay_page_opt", Integer.class, r101, false);     // Catch: Throwable -> L7
        if (r104 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return ((Number) r104).intValue();
    L7:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Object r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r106) == true) goto L12;
        r101 = r106;
    L12:
        r104 = r101;
        goto L14
    }

    @SettingPanel("商详底部系统导航栏颜色适配-生效的 schema 集合")
    public static final Map<String, String> D0() {
        int r100 = j.f43647a;
        Object r101 = MapsKt.emptyMap();
        int r102 = com.bytedance.android.ec.base.settings.b.f42814a;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L174
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L174
        SDKSettingsCacheManager r104 = SDKSettingsCacheManager.f42812e;     // Catch: Throwable -> L174
        Object r105 = null;
        r104.getClass();     // Catch: Throwable -> L59
        Object r106 = SDKSettingsCacheManager.f42809b.get("ec_pdp_nav_bar_color_schema_map");     // Catch: Throwable -> L59
        if (r106 != null) goto L11;
    L56:
        Object r107 = null;
    L57:
        Object r108 = Result.m9449constructorimpl(r107);     // Catch: Throwable -> L59
    L61:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);     // Catch: Throwable -> L174
        if (r109 == null) goto L65;
        EnsureManager.ensureNotReachHere(r109);     // Catch: Throwable -> L174
    L65:
        if (Result.m9455isFailureimpl(r108) == false) goto L68;
        r108 = null;
    L68:
        if ((r108 instanceof Map) == true) goto L70;
        r108 = null;
    L70:
        Object r110 = (Map) r108;     // Catch: Throwable -> L174
        if (r110 != null) goto L77;
        r104.getClass();     // Catch: Throwable -> L174
        Object r111 = SDKSettingsCacheManager.f42808a.get("ec_pdp_nav_bar_color_schema_map");     // Catch: Throwable -> L174
        if ((r111 instanceof Map) == true) goto L76;
        r111 = null;
    L76:
        r110 = (Map) r111;     // Catch: Throwable -> L174
    L77:
        if (r110 != null) goto L184;
        int r112 = com.bytedance.android.ec.base.settings.g.f42821a;     // Catch: Throwable -> L174
    L161:
        th = move-exception;
        Result.Companion r113 = Result.Companion;     // Catch: Throwable -> L174
        Object r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L174
    L164:
        if (Result.m9452exceptionOrNullimpl(r114) != null) goto L193;
    L171:
        r110 = r114;
    L172:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L174
        SDKSettingsCacheManager.e("ec_pdp_nav_bar_color_schema_map", r110);     // Catch: Throwable -> L174
        goto L184
    L193:
        r114 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ec_pdp_nav_bar_color_schema_map", Map.class, r101);     // Catch: Throwable -> L168
    L169:
        if (r114 != null) goto L171;
        r110 = r101;
    L168:
        r114 = r101;
        goto L169
    L197:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L133
        Object r115 = SDKSettingsCacheManager.f42809b.get("ec_pdp_nav_bar_color_schema_map");     // Catch: Throwable -> L133
        if (r115 != null) goto L85;
    L130:
        Object r116 = null;
    L131:
        Object r117 = Result.m9449constructorimpl(r116);     // Catch: Throwable -> L133
    L135:
        Throwable r118 = Result.m9452exceptionOrNullimpl(r117);     // Catch: Throwable -> L161
        if (r118 == null) goto L139;
        EnsureManager.ensureNotReachHere(r118);     // Catch: Throwable -> L161
    L139:
        if (Result.m9455isFailureimpl(r117) == false) goto L142;
        r117 = null;
    L142:
        if ((r117 instanceof Map) == true) goto L144;
        r117 = null;
    L144:
        r114 = (Map) r117;     // Catch: Throwable -> L161
        if (r114 != null) goto L147;
    L149:
        jj4.b r119 = jj4.b.f499326b;     // Catch: Throwable -> L161
        Object r120 = jj4.a.a("ec_pdp_nav_bar_color_schema_map", Map.class, r101, false);     // Catch: Throwable -> L161
        if (r120 != null) goto L153;
        Intrinsics.throwNpe();     // Catch: Throwable -> L161
    L153:
        if ((r120 instanceof Map) == false) goto L156;
        r105 = r120;
    L156:
        Object r121 = (Map) r105;     // Catch: Throwable -> L161
        if (r121 != null) goto L159;
        r121 = r101;
    L159:
        r114 = Result.m9449constructorimpl(r121);     // Catch: Throwable -> L161
    L147:
        if ((r114 instanceof Map) == false) goto L149;
    L85:
        if ((r115 instanceof Map) == true) goto L87;
        Object r122 = null;
    L88:
        r116 = (Map) r122;     // Catch: Throwable -> L133
        if (r116 != null) goto L131;
        if ((r115 instanceof Number) == false) goto L118;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Map.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L100;
        Float r123 = Float.valueOf(((Number) r115).floatValue());     // Catch: Throwable -> L133
        if ((r123 instanceof Map) == true) goto L98;
        r123 = null;
    L98:
        r116 = (Map) r123;     // Catch: Throwable -> L133
        goto L131
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Map.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L106;
        Double r124 = Double.valueOf(((Number) r115).doubleValue());     // Catch: Throwable -> L133
        if ((r124 instanceof Map) == true) goto L104;
        r124 = null;
    L104:
        r116 = (Map) r124;     // Catch: Throwable -> L133
        goto L131
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Map.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L112;
        Integer r125 = Integer.valueOf(((Number) r115).intValue());     // Catch: Throwable -> L133
        if ((r125 instanceof Map) == true) goto L110;
        r125 = null;
    L110:
        r116 = (Map) r125;     // Catch: Throwable -> L133
        goto L131
    L112:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Map.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L118;
        Long r126 = Long.valueOf(((Number) r115).longValue());     // Catch: Throwable -> L133
        if ((r126 instanceof Map) == true) goto L116;
        r126 = null;
    L116:
        r116 = (Map) r126;     // Catch: Throwable -> L133
    L118:
        if ((r115 instanceof JSONObject) == false) goto L120;
    L189:
        Object r127 = SDKSettingsCacheManager.a().fromJson(r115.toString(), Map.class);     // Catch: Throwable -> L126
        if ((r127 instanceof Map) == true) goto L124;
        r127 = null;
    L124:
        Object r128 = Result.m9449constructorimpl((Map) r127);     // Catch: Throwable -> L126
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
        Result.Companion r130 = Result.Companion;     // Catch: Throwable -> L161
        r117 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L161
    L184:
        return (Map) r110;
    L11:
        if ((r106 instanceof Map) == true) goto L13;
        Object r131 = null;
    L14:
        r107 = (Map) r131;     // Catch: Throwable -> L59
        if (r107 != null) goto L57;
        if ((r106 instanceof Number) == false) goto L44;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Map.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r132 = Float.valueOf(((Number) r106).floatValue());     // Catch: Throwable -> L59
        if ((r132 instanceof Map) == true) goto L24;
        r132 = null;
    L24:
        r107 = (Map) r132;     // Catch: Throwable -> L59
        goto L57
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Map.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r133 = Double.valueOf(((Number) r106).doubleValue());     // Catch: Throwable -> L59
        if ((r133 instanceof Map) == true) goto L30;
        r133 = null;
    L30:
        r107 = (Map) r133;     // Catch: Throwable -> L59
        goto L57
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Map.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L38;
        Integer r134 = Integer.valueOf(((Number) r106).intValue());     // Catch: Throwable -> L59
        if ((r134 instanceof Map) == true) goto L36;
        r134 = null;
    L36:
        r107 = (Map) r134;     // Catch: Throwable -> L59
        goto L57
    L38:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Map.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L44;
        Long r135 = Long.valueOf(((Number) r106).longValue());     // Catch: Throwable -> L59
        if ((r135 instanceof Map) == true) goto L42;
        r135 = null;
    L42:
        r107 = (Map) r135;     // Catch: Throwable -> L59
    L44:
        if ((r106 instanceof JSONObject) == false) goto L46;
    L191:
        Object r136 = SDKSettingsCacheManager.a().fromJson(r106.toString(), Map.class);     // Catch: Throwable -> L52
        if ((r136 instanceof Map) == true) goto L50;
        r136 = null;
    L50:
        Object r137 = Result.m9449constructorimpl((Map) r136);     // Catch: Throwable -> L52
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
        Result.Companion r139 = Result.Companion;     // Catch: Throwable -> L174
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L174
    L174:
        th = move-exception;
        Result.Companion r140 = Result.Companion;
        Object r141 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r142 = Result.m9452exceptionOrNullimpl(r141);
        if (r142 == null) goto L179;
        EnsureManager.ensureNotReachHere(r142);
    L179:
        if (Result.m9455isFailureimpl(r141) == true) goto L182;
        r101 = r141;
    L182:
        r110 = r101;
        goto L184
    }

    @SettingPanel("抖音&电商Slogan loading是否缓存到内存")
    public static final boolean E() {
        int r100 = p.f45243a;
        Object r101 = Boolean.FALSE;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r103 = jj4.b.f499326b;     // Catch: Throwable -> L7
        Object r104 = jj4.a.a("ec_loading_persistent_cache", Boolean.class, r101, false);     // Catch: Throwable -> L7
        if (r104 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return ((Boolean) r104).booleanValue();
    L7:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Object r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r106) == true) goto L12;
        r101 = r106;
    L12:
        r104 = r101;
        goto L14
    }

    @SettingPanel("商详讲解回放视频优化-已固化")
    public static final int E0() {
        int r100 = j.f43647a;
        int r101 = ECSdk.f48106a;
        s83.g r102 = (s83.g) ECSdk.a(s83.g.class);
        if (r102 == null) goto L7;
        s83.f r103 = r102.p();
        if (r103 == null) goto L7;
        r103.i();
    L7:
        Object r104 = 0;
        int r105 = com.bytedance.android.ec.base.settings.b.f42814a;
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L171
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L171
        SDKSettingsCacheManager r107 = SDKSettingsCacheManager.f42812e;     // Catch: Throwable -> L171
        Object r108 = null;
        r107.getClass();     // Catch: Throwable -> L61
        Object r109 = SDKSettingsCacheManager.f42809b.get("iesec_pdp_replay_opt");     // Catch: Throwable -> L61
        if (r109 != null) goto L16;
    L58:
        Object r110 = null;
    L59:
        Object r111 = Result.m9449constructorimpl(r110);     // Catch: Throwable -> L61
    L63:
        Throwable r112 = Result.m9452exceptionOrNullimpl(r111);     // Catch: Throwable -> L171
        if (r112 == null) goto L67;
        EnsureManager.ensureNotReachHere(r112);     // Catch: Throwable -> L171
    L67:
        if (Result.m9455isFailureimpl(r111) == false) goto L70;
        r111 = null;
    L70:
        if ((r111 instanceof Integer) == true) goto L72;
        r111 = null;
    L72:
        Object r113 = (Integer) r111;     // Catch: Throwable -> L171
        if (r113 != null) goto L79;
        r107.getClass();     // Catch: Throwable -> L171
        Object r114 = SDKSettingsCacheManager.f42808a.get("iesec_pdp_replay_opt");     // Catch: Throwable -> L171
        if ((r114 instanceof Integer) == true) goto L78;
        r114 = null;
    L78:
        r113 = (Integer) r114;     // Catch: Throwable -> L171
    L79:
        if (r113 != null) goto L181;
        int r115 = com.bytedance.android.ec.base.settings.g.f42821a;     // Catch: Throwable -> L171
    L158:
        th = move-exception;
        Result.Companion r116 = Result.Companion;     // Catch: Throwable -> L171
        Object r117 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L171
    L161:
        if (Result.m9452exceptionOrNullimpl(r117) != null) goto L190;
    L168:
        r113 = r117;
    L169:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L171
        SDKSettingsCacheManager.e("iesec_pdp_replay_opt", r113);     // Catch: Throwable -> L171
        goto L181
    L190:
        r117 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("iesec_pdp_replay_opt", Integer.class, r104);     // Catch: Throwable -> L165
    L166:
        if (r117 != null) goto L168;
        r113 = r104;
    L165:
        r117 = r104;
        goto L166
    L182:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L132
        Object r118 = SDKSettingsCacheManager.f42809b.get("iesec_pdp_replay_opt");     // Catch: Throwable -> L132
        if (r118 != null) goto L87;
    L129:
        Object r119 = null;
    L130:
        Object r120 = Result.m9449constructorimpl(r119);     // Catch: Throwable -> L132
    L134:
        Throwable r121 = Result.m9452exceptionOrNullimpl(r120);     // Catch: Throwable -> L158
        if (r121 == null) goto L138;
        EnsureManager.ensureNotReachHere(r121);     // Catch: Throwable -> L158
    L138:
        if (Result.m9455isFailureimpl(r120) == false) goto L141;
        r120 = null;
    L141:
        if ((r120 instanceof Integer) == true) goto L143;
        r120 = null;
    L143:
        Integer r122 = (Integer) r120;     // Catch: Throwable -> L158
        if (r122 == null) goto L146;
        r113 = r122;
        goto L169
    L146:
        jj4.b r123 = jj4.b.f499326b;     // Catch: Throwable -> L158
        Object r124 = jj4.a.a("iesec_pdp_replay_opt", Integer.class, r104, false);     // Catch: Throwable -> L158
        if (r124 != null) goto L150;
        Intrinsics.throwNpe();     // Catch: Throwable -> L158
    L150:
        if ((r124 instanceof Integer) == false) goto L153;
        r108 = r124;
    L153:
        Object r125 = (Integer) r108;     // Catch: Throwable -> L158
        if (r125 != null) goto L156;
        r125 = r104;
    L156:
        r117 = Result.m9449constructorimpl(r125);     // Catch: Throwable -> L158
    L87:
        if ((r118 instanceof Integer) == true) goto L89;
        Object r126 = null;
    L90:
        r119 = (Integer) r126;     // Catch: Throwable -> L132
        if (r119 != null) goto L130;
        if ((r118 instanceof Number) == false) goto L117;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L102;
        Float r127 = Float.valueOf(((Number) r118).floatValue());     // Catch: Throwable -> L132
        if ((r127 instanceof Integer) == true) goto L100;
        r127 = null;
    L100:
        r119 = (Integer) r127;     // Catch: Throwable -> L132
        goto L130
    L102:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L108;
        Double r128 = Double.valueOf(((Number) r118).doubleValue());     // Catch: Throwable -> L132
        if ((r128 instanceof Integer) == true) goto L106;
        r128 = null;
    L106:
        r119 = (Integer) r128;     // Catch: Throwable -> L132
        goto L130
    L108:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L111;
        r119 = Integer.valueOf(((Number) r118).intValue());     // Catch: Throwable -> L132
        goto L130
    L111:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L117;
        Long r129 = Long.valueOf(((Number) r118).longValue());     // Catch: Throwable -> L132
        if ((r129 instanceof Integer) == true) goto L115;
        r129 = null;
    L115:
        r119 = (Integer) r129;     // Catch: Throwable -> L132
    L117:
        if ((r118 instanceof JSONObject) == false) goto L119;
    L188:
        Object r130 = SDKSettingsCacheManager.a().fromJson(r118.toString(), Integer.class);     // Catch: Throwable -> L125
        if ((r130 instanceof Integer) == true) goto L123;
        r130 = null;
    L123:
        Object r131 = Result.m9449constructorimpl((Integer) r130);     // Catch: Throwable -> L125
    L127:
        r119 = r131;
        if (Result.m9455isFailureimpl(r119) == false) goto L130;
    L125:
        th = move-exception;
        Result.Companion r132 = Result.Companion;     // Catch: Throwable -> L132
        r131 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L132
        goto L127
    L119:
        if ((r118 instanceof JSONArray) == false) goto L129;
    L89:
        r126 = r118;
    L132:
        th = move-exception;
        Result.Companion r133 = Result.Companion;     // Catch: Throwable -> L158
        r120 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L158
    L181:
        return ((Number) r113).intValue();
    L16:
        if ((r109 instanceof Integer) == true) goto L18;
        Object r134 = null;
    L19:
        r110 = (Integer) r134;     // Catch: Throwable -> L61
        if (r110 != null) goto L59;
        if ((r109 instanceof Number) == false) goto L46;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L31;
        Float r135 = Float.valueOf(((Number) r109).floatValue());     // Catch: Throwable -> L61
        if ((r135 instanceof Integer) == true) goto L29;
        r135 = null;
    L29:
        r110 = (Integer) r135;     // Catch: Throwable -> L61
        goto L59
    L31:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L37;
        Double r136 = Double.valueOf(((Number) r109).doubleValue());     // Catch: Throwable -> L61
        if ((r136 instanceof Integer) == true) goto L35;
        r136 = null;
    L35:
        r110 = (Integer) r136;     // Catch: Throwable -> L61
        goto L59
    L37:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L40;
        r110 = Integer.valueOf(((Number) r109).intValue());     // Catch: Throwable -> L61
        goto L59
    L40:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L46;
        Long r137 = Long.valueOf(((Number) r109).longValue());     // Catch: Throwable -> L61
        if ((r137 instanceof Integer) == true) goto L44;
        r137 = null;
    L44:
        r110 = (Integer) r137;     // Catch: Throwable -> L61
    L46:
        if ((r109 instanceof JSONObject) == false) goto L48;
    L186:
        Object r138 = SDKSettingsCacheManager.a().fromJson(r109.toString(), Integer.class);     // Catch: Throwable -> L54
        if ((r138 instanceof Integer) == true) goto L52;
        r138 = null;
    L52:
        Object r139 = Result.m9449constructorimpl((Integer) r138);     // Catch: Throwable -> L54
    L56:
        r110 = r139;
        if (Result.m9455isFailureimpl(r110) == false) goto L59;
    L54:
        th = move-exception;
        Result.Companion r140 = Result.Companion;     // Catch: Throwable -> L61
        r139 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L61
        goto L56
    L48:
        if ((r109 instanceof JSONArray) == false) goto L58;
    L18:
        r134 = r109;
    L61:
        th = move-exception;
        Result.Companion r141 = Result.Companion;     // Catch: Throwable -> L171
        r111 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L171
    L171:
        th = move-exception;
        Result.Companion r142 = Result.Companion;
        Object r143 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r144 = Result.m9452exceptionOrNullimpl(r143);
        if (r144 == null) goto L176;
        EnsureManager.ensureNotReachHere(r144);
    L176:
        if (Result.m9455isFailureimpl(r143) == true) goto L179;
        r104 = r143;
    L179:
        r113 = r104;
        goto L181
    }

    @SettingPanel("订单列表和订单搜索页面配置")
    public static final OrderListSettingConfig F() {
        int r100 = p.f45243a;
        OrderListSettingConfig r110 = new OrderListSettingConfig(null, null, null, false, false, 0, false, false, false, 0, false, 0, false, false, false, 32767, null);
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L11
        jj4.b r102 = jj4.b.f499326b;     // Catch: Throwable -> L11
        OrderListSettingConfig r103 = r110;
        Object r104 = jj4.a.a("iesec_order_config", OrderListSettingConfig.class, r103, false);     // Catch: Throwable -> L9
        if (r104 != null) goto L18;
        Intrinsics.throwNpe();     // Catch: Throwable -> L9
    L18:
        return (OrderListSettingConfig) r104;
    L9:
        th = th;
    L13:
        Result.Companion r105 = Result.Companion;
        Object r111 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r111) == false) goto L16;
        r111 = r103;
    L16:
        r104 = r111;
    L11:
        th = th;
        r103 = r110;
        goto L13
    }

    @SettingPanel("商详店铺推荐商品卡曝光点击去掉entrance_info-已固化")
    public static final boolean F0() {
        int r100 = com.bytedance.android.ec.base.settings.b.f42814a;
        int r101 = com.bytedance.android.ec.core.abtest.e.f43640a;
        Object r102 = com.bytedance.android.ec.core.abtest.e.a(Boolean.TRUE, Boolean.FALSE);
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L172
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L172
        SDKSettingsCacheManager r104 = SDKSettingsCacheManager.f42812e;     // Catch: Throwable -> L172
        Object r105 = null;
        r104.getClass();     // Catch: Throwable -> L59
        Object r106 = SDKSettingsCacheManager.f42809b.get("pdp_recommend_goods_remove_entrance_info");     // Catch: Throwable -> L59
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
        Object r111 = SDKSettingsCacheManager.f42808a.get("pdp_recommend_goods_remove_entrance_info");     // Catch: Throwable -> L172
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
        if (Result.m9452exceptionOrNullimpl(r114) != null) goto L191;
    L169:
        r110 = r114;
    L170:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L172
        SDKSettingsCacheManager.e("pdp_recommend_goods_remove_entrance_info", r110);     // Catch: Throwable -> L172
        goto L182
    L191:
        r114 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("pdp_recommend_goods_remove_entrance_info", Boolean.class, r102);     // Catch: Throwable -> L166
    L167:
        if (r114 != null) goto L169;
        r110 = r102;
    L166:
        r114 = r102;
        goto L167
    L183:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L133
        Object r115 = SDKSettingsCacheManager.f42809b.get("pdp_recommend_goods_remove_entrance_info");     // Catch: Throwable -> L133
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
        Object r120 = jj4.a.a("pdp_recommend_goods_remove_entrance_info", Boolean.class, r102, false);     // Catch: Throwable -> L159
        if (r120 != null) goto L151;
        Intrinsics.throwNpe();     // Catch: Throwable -> L159
    L151:
        if ((r120 instanceof Boolean) == false) goto L154;
        r105 = r120;
    L154:
        Object r121 = (Boolean) r105;     // Catch: Throwable -> L159
        if (r121 != null) goto L157;
        r121 = r102;
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
    L189:
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
    L195:
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
        r102 = r141;
    L180:
        r110 = r102;
        goto L182
    }

    @SettingPanel("订单列表slice render info时机")
    public static final boolean G() {
        int r100 = j.f43647a;
        Object r101 = Boolean.FALSE;
        int r102 = com.bytedance.android.ec.base.settings.b.f42814a;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L172
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L172
        SDKSettingsCacheManager r104 = SDKSettingsCacheManager.f42812e;     // Catch: Throwable -> L172
        Object r105 = null;
        r104.getClass();     // Catch: Throwable -> L59
        Object r106 = SDKSettingsCacheManager.f42809b.get("order_create_slice_render_info");     // Catch: Throwable -> L59
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
        Object r111 = SDKSettingsCacheManager.f42808a.get("order_create_slice_render_info");     // Catch: Throwable -> L172
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
        SDKSettingsCacheManager.e("order_create_slice_render_info", r110);     // Catch: Throwable -> L172
        goto L182
    L185:
        r114 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("order_create_slice_render_info", Boolean.class, r101);     // Catch: Throwable -> L166
    L167:
        if (r114 != null) goto L169;
        r110 = r101;
    L166:
        r114 = r101;
        goto L167
    L191:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L133
        Object r115 = SDKSettingsCacheManager.f42809b.get("order_create_slice_render_info");     // Catch: Throwable -> L133
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
        Object r120 = jj4.a.a("order_create_slice_render_info", Boolean.class, r101, false);     // Catch: Throwable -> L159
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

    @SettingPanel("商详筛查btm及埋点关系")
    public static final boolean G0() {
        int r100 = j.f43647a;
        Object r101 = Boolean.FALSE;
        int r102 = com.bytedance.android.ec.base.settings.b.f42814a;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L172
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L172
        SDKSettingsCacheManager r104 = SDKSettingsCacheManager.f42812e;     // Catch: Throwable -> L172
        Object r105 = null;
        r104.getClass();     // Catch: Throwable -> L59
        Object r106 = SDKSettingsCacheManager.f42809b.get("pdp_save_btm_event_relations");     // Catch: Throwable -> L59
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
        Object r111 = SDKSettingsCacheManager.f42808a.get("pdp_save_btm_event_relations");     // Catch: Throwable -> L172
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
        SDKSettingsCacheManager.e("pdp_save_btm_event_relations", r110);     // Catch: Throwable -> L172
        goto L182
    L185:
        r114 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("pdp_save_btm_event_relations", Boolean.class, r101);     // Catch: Throwable -> L166
    L167:
        if (r114 != null) goto L169;
        r110 = r101;
    L166:
        r114 = r101;
        goto L167
    L191:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L133
        Object r115 = SDKSettingsCacheManager.f42809b.get("pdp_save_btm_event_relations");     // Catch: Throwable -> L133
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
        Object r120 = jj4.a.a("pdp_save_btm_event_relations", Boolean.class, r101, false);     // Catch: Throwable -> L159
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

    @SettingPanel("订单列表缓存配置")
    public static final OrderCacheConfig H() {
        int r100 = p.f45243a;
        Object r101 = new OrderCacheConfig(0, false, 0, null, false, 31, null);
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r103 = jj4.b.f499326b;     // Catch: Throwable -> L7
        Object r104 = jj4.a.a("iesec_order_list_cache_config", OrderCacheConfig.class, r101, false);     // Catch: Throwable -> L7
        if (r104 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return (OrderCacheConfig) r104;
    L7:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Object r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r106) == true) goto L12;
        r101 = r106;
    L12:
        r104 = r101;
        goto L14
    }

    @SettingPanel("商详顶部新增高斯模糊-已固化")
    public static final boolean H0() {
        int r100 = j.f43647a;
        int r101 = com.bytedance.android.ec.core.abtest.e.f43640a;
        Object r102 = com.bytedance.android.ec.core.abtest.e.a(Boolean.TRUE, Boolean.FALSE);
        int r103 = com.bytedance.android.ec.base.settings.b.f42814a;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L172
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L172
        SDKSettingsCacheManager r105 = SDKSettingsCacheManager.f42812e;     // Catch: Throwable -> L172
        Object r106 = null;
        r105.getClass();     // Catch: Throwable -> L59
        Object r107 = SDKSettingsCacheManager.f42809b.get("pdp_top_guide_gauss");     // Catch: Throwable -> L59
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
        Object r112 = SDKSettingsCacheManager.f42808a.get("pdp_top_guide_gauss");     // Catch: Throwable -> L172
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
        SDKSettingsCacheManager.e("pdp_top_guide_gauss", r111);     // Catch: Throwable -> L172
        goto L182
    L191:
        r115 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("pdp_top_guide_gauss", Boolean.class, r102);     // Catch: Throwable -> L166
    L167:
        if (r115 != null) goto L169;
        r111 = r102;
    L166:
        r115 = r102;
        goto L167
    L183:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L133
        Object r116 = SDKSettingsCacheManager.f42809b.get("pdp_top_guide_gauss");     // Catch: Throwable -> L133
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
        Object r121 = jj4.a.a("pdp_top_guide_gauss", Boolean.class, r102, false);     // Catch: Throwable -> L159
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

    @SettingPanel("订单列表首屏耗时优化")
    public static final boolean I() {
        int r100 = p.f45243a;
        Object r101 = Boolean.FALSE;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r103 = jj4.b.f499326b;     // Catch: Throwable -> L7
        Object r104 = jj4.a.a("iesec_order_list_duration_perf", Boolean.class, r101, false);     // Catch: Throwable -> L7
        if (r104 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return ((Boolean) r104).booleanValue();
    L7:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Object r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r106) == true) goto L12;
        r101 = r106;
    L12:
        r104 = r101;
        goto L14
    }

    @SettingPanel("讲解回放多码率开关")
    public static final boolean I0() {
        int r100 = p.f45243a;
        Object r101 = Boolean.TRUE;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r103 = jj4.b.f499326b;     // Catch: Throwable -> L7
        Object r104 = jj4.a.a("ec_playback_video_mbr_switch", Boolean.class, r101, false);     // Catch: Throwable -> L7
        if (r104 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return ((Boolean) r104).booleanValue();
    L7:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Object r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r106) == true) goto L12;
        r101 = r106;
    L12:
        r104 = r101;
        goto L14
    }

    @SettingPanel("订单列表预加载任务优化")
    public static final boolean J() {
        int r100 = p.f45243a;
        Object r101 = Boolean.TRUE;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r103 = jj4.b.f499326b;     // Catch: Throwable -> L7
        Object r104 = jj4.a.a("iesec_order_list_preload_task_opt", Boolean.class, r101, false);     // Catch: Throwable -> L7
        if (r104 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return ((Boolean) r104).booleanValue();
    L7:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Object r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r106) == true) goto L12;
        r101 = r106;
    L12:
        r104 = r101;
        goto L14
    }

    @SettingPanel("PriceView 统一重构")
    public static final boolean J0() {
        int r100 = p.f45243a;
        Object r101 = Boolean.TRUE;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r103 = jj4.b.f499326b;     // Catch: Throwable -> L7
        Object r104 = jj4.a.a("shopping_priceview_refactor", Boolean.class, r101, false);     // Catch: Throwable -> L7
        if (r104 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return ((Boolean) r104).booleanValue();
    L7:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Object r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r106) == true) goto L12;
        r101 = r106;
    L12:
        r104 = r101;
        goto L14
    }

    @SettingPanel("订单列表组件化流式请求tab_id控制")
    public static final List<Integer> K() {
        int r100 = p.f45243a;
        Object r101 = CollectionsKt.emptyList();
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r103 = jj4.b.f499326b;     // Catch: Throwable -> L7
        Object r104 = jj4.a.a("iesec_ecommerce_order_stream_tab_config", List.class, r101, false);     // Catch: Throwable -> L7
        if (r104 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return (List) r104;
    L7:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Object r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r106) == true) goto L12;
        r101 = r106;
    L12:
        r104 = r101;
        goto L14
    }

    @SettingPanel("找相似功能说明落地页")
    public static final ECSimilarProductFunctionDescriptionViewUri K0() {
        int r100 = e.f43630a;
        int r101 = w0.f45736a;
        Object r102 = (ECSimilarProductFunctionDescriptionViewUri) w0.b("{\"white_background_uri\":\"sslocal://webcast_lynxview?type=popup&height_percent=73&gravity=bottom&mask_alpha=0.5&url=https%3A%2F%2Flf-webcast-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source%2F10181%2Fgecko%2Fresource%2Fecommerce_address_aweme%2Faddress%2Flist%2Ftemplate.js&disable_input_scroll=1&window_floating=0&intercept_back=1&add_safe_area_height=0&input_smart_scroll=0&screen_size_adaptation=1&hide_nav_bar=1&status_bar_color=black&trans_status_bar=1&web_bg_color=%23ffffffff&top_level=1&use_real_screen_height=1&enter_from=live&new_source_type=live&enter_from_live_saas=&support_select=1&selected_id=&product_id=&shop_id=&previous_new_source_type=&need_show_poi=1&session_id=&store_id=&select_area_type=&hourly_purchase_shop_id=\"}", ECSimilarProductFunctionDescriptionViewUri.class);
        if (r102 == null) goto L17;
        int r103 = p.f45243a;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L9
        jj4.b r105 = jj4.b.f499326b;     // Catch: Throwable -> L9
        Object r106 = jj4.a.a("ec_commerce_similar_product_function_description_view_uri", ECSimilarProductFunctionDescriptionViewUri.class, r102, false);     // Catch: Throwable -> L9
        if (r106 != null) goto L15;
        Intrinsics.throwNpe();     // Catch: Throwable -> L9
    L15:
        ECSimilarProductFunctionDescriptionViewUri r107 = (ECSimilarProductFunctionDescriptionViewUri) r106;
        if (r107 == null) goto L17;
        return r107;
    L9:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        Object r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r109) == true) goto L14;
        r102 = r109;
    L14:
        r106 = r102;
    L17:
        int r110 = p.f45243a;
        Object r111 = null;
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L20
        jj4.b r113 = jj4.b.f499326b;     // Catch: Throwable -> L20
        Object r114 = jj4.a.a(" ec_commerce_similar_product_function_description_view_uri", ECSimilarProductFunctionDescriptionViewUri.class, null, false);     // Catch: Throwable -> L20
    L27:
        return (ECSimilarProductFunctionDescriptionViewUri) r114;
    L20:
        th = move-exception;
        Result.Companion r115 = Result.Companion;
        Object r116 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r116) == true) goto L25;
        r111 = r116;
    L25:
        r114 = r111;
        goto L27
    }

    @SettingPanel("订单列表白屏监控参数")
    public static final OrderSkeletonMonitorConfig L() {
        int r100 = j.f43647a;
        Object r101 = new OrderSkeletonMonitorConfig(false, 0, 0, 0, 0, 31, null);
        int r102 = com.bytedance.android.ec.base.settings.b.f42814a;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L172
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L172
        SDKSettingsCacheManager r104 = SDKSettingsCacheManager.f42812e;     // Catch: Throwable -> L172
        Object r105 = null;
        r104.getClass();     // Catch: Throwable -> L59
        Object r106 = SDKSettingsCacheManager.f42809b.get("iesec_order_list_skeleton_monitor_config");     // Catch: Throwable -> L59
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
        if ((r108 instanceof OrderSkeletonMonitorConfig) == true) goto L70;
        r108 = null;
    L70:
        Object r110 = (OrderSkeletonMonitorConfig) r108;     // Catch: Throwable -> L172
        if (r110 != null) goto L77;
        r104.getClass();     // Catch: Throwable -> L172
        Object r111 = SDKSettingsCacheManager.f42808a.get("iesec_order_list_skeleton_monitor_config");     // Catch: Throwable -> L172
        if ((r111 instanceof OrderSkeletonMonitorConfig) == true) goto L76;
        r111 = null;
    L76:
        r110 = (OrderSkeletonMonitorConfig) r111;     // Catch: Throwable -> L172
    L77:
        if (r110 != null) goto L182;
        int r112 = com.bytedance.android.ec.base.settings.g.f42821a;     // Catch: Throwable -> L172
    L159:
        th = move-exception;
        Result.Companion r113 = Result.Companion;     // Catch: Throwable -> L172
        Object r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L172
    L162:
        if (Result.m9452exceptionOrNullimpl(r114) != null) goto L193;
    L169:
        r110 = r114;
    L170:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L172
        SDKSettingsCacheManager.e("iesec_order_list_skeleton_monitor_config", r110);     // Catch: Throwable -> L172
        goto L182
    L193:
        r114 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("iesec_order_list_skeleton_monitor_config", OrderSkeletonMonitorConfig.class, r101);     // Catch: Throwable -> L166
    L167:
        if (r114 != null) goto L169;
        r110 = r101;
    L166:
        r114 = r101;
        goto L167
    L185:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L133
        Object r115 = SDKSettingsCacheManager.f42809b.get("iesec_order_list_skeleton_monitor_config");     // Catch: Throwable -> L133
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
        if ((r117 instanceof OrderSkeletonMonitorConfig) == true) goto L144;
        r117 = null;
    L144:
        r114 = (OrderSkeletonMonitorConfig) r117;     // Catch: Throwable -> L159
        if (r114 != null) goto L169;
        jj4.b r119 = jj4.b.f499326b;     // Catch: Throwable -> L159
        Object r120 = jj4.a.a("iesec_order_list_skeleton_monitor_config", OrderSkeletonMonitorConfig.class, r101, false);     // Catch: Throwable -> L159
        if (r120 != null) goto L151;
        Intrinsics.throwNpe();     // Catch: Throwable -> L159
    L151:
        if ((r120 instanceof OrderSkeletonMonitorConfig) == false) goto L154;
        r105 = r120;
    L154:
        Object r121 = (OrderSkeletonMonitorConfig) r105;     // Catch: Throwable -> L159
        if (r121 != null) goto L157;
        r121 = r101;
    L157:
        r114 = Result.m9449constructorimpl(r121);     // Catch: Throwable -> L159
    L85:
        if ((r115 instanceof OrderSkeletonMonitorConfig) == true) goto L87;
        Object r122 = null;
    L88:
        r116 = (OrderSkeletonMonitorConfig) r122;     // Catch: Throwable -> L133
        if (r116 != null) goto L131;
        if ((r115 instanceof Number) == false) goto L118;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(OrderSkeletonMonitorConfig.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L100;
        Float r123 = Float.valueOf(((Number) r115).floatValue());     // Catch: Throwable -> L133
        if ((r123 instanceof OrderSkeletonMonitorConfig) == true) goto L98;
        r123 = null;
    L98:
        r116 = (OrderSkeletonMonitorConfig) r123;     // Catch: Throwable -> L133
        goto L131
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(OrderSkeletonMonitorConfig.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L106;
        Double r124 = Double.valueOf(((Number) r115).doubleValue());     // Catch: Throwable -> L133
        if ((r124 instanceof OrderSkeletonMonitorConfig) == true) goto L104;
        r124 = null;
    L104:
        r116 = (OrderSkeletonMonitorConfig) r124;     // Catch: Throwable -> L133
        goto L131
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(OrderSkeletonMonitorConfig.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L112;
        Integer r125 = Integer.valueOf(((Number) r115).intValue());     // Catch: Throwable -> L133
        if ((r125 instanceof OrderSkeletonMonitorConfig) == true) goto L110;
        r125 = null;
    L110:
        r116 = (OrderSkeletonMonitorConfig) r125;     // Catch: Throwable -> L133
        goto L131
    L112:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(OrderSkeletonMonitorConfig.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L118;
        Long r126 = Long.valueOf(((Number) r115).longValue());     // Catch: Throwable -> L133
        if ((r126 instanceof OrderSkeletonMonitorConfig) == true) goto L116;
        r126 = null;
    L116:
        r116 = (OrderSkeletonMonitorConfig) r126;     // Catch: Throwable -> L133
    L118:
        if ((r115 instanceof JSONObject) == false) goto L120;
    L191:
        Object r127 = SDKSettingsCacheManager.a().fromJson(r115.toString(), OrderSkeletonMonitorConfig.class);     // Catch: Throwable -> L126
        if ((r127 instanceof OrderSkeletonMonitorConfig) == true) goto L124;
        r127 = null;
    L124:
        Object r128 = Result.m9449constructorimpl((OrderSkeletonMonitorConfig) r127);     // Catch: Throwable -> L126
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
        return (OrderSkeletonMonitorConfig) r110;
    L11:
        if ((r106 instanceof OrderSkeletonMonitorConfig) == true) goto L13;
        Object r131 = null;
    L14:
        r107 = (OrderSkeletonMonitorConfig) r131;     // Catch: Throwable -> L59
        if (r107 != null) goto L57;
        if ((r106 instanceof Number) == false) goto L44;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(OrderSkeletonMonitorConfig.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r132 = Float.valueOf(((Number) r106).floatValue());     // Catch: Throwable -> L59
        if ((r132 instanceof OrderSkeletonMonitorConfig) == true) goto L24;
        r132 = null;
    L24:
        r107 = (OrderSkeletonMonitorConfig) r132;     // Catch: Throwable -> L59
        goto L57
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(OrderSkeletonMonitorConfig.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r133 = Double.valueOf(((Number) r106).doubleValue());     // Catch: Throwable -> L59
        if ((r133 instanceof OrderSkeletonMonitorConfig) == true) goto L30;
        r133 = null;
    L30:
        r107 = (OrderSkeletonMonitorConfig) r133;     // Catch: Throwable -> L59
        goto L57
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(OrderSkeletonMonitorConfig.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L38;
        Integer r134 = Integer.valueOf(((Number) r106).intValue());     // Catch: Throwable -> L59
        if ((r134 instanceof OrderSkeletonMonitorConfig) == true) goto L36;
        r134 = null;
    L36:
        r107 = (OrderSkeletonMonitorConfig) r134;     // Catch: Throwable -> L59
        goto L57
    L38:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(OrderSkeletonMonitorConfig.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L44;
        Long r135 = Long.valueOf(((Number) r106).longValue());     // Catch: Throwable -> L59
        if ((r135 instanceof OrderSkeletonMonitorConfig) == true) goto L42;
        r135 = null;
    L42:
        r107 = (OrderSkeletonMonitorConfig) r135;     // Catch: Throwable -> L59
    L44:
        if ((r106 instanceof JSONObject) == false) goto L46;
    L183:
        Object r136 = SDKSettingsCacheManager.a().fromJson(r106.toString(), OrderSkeletonMonitorConfig.class);     // Catch: Throwable -> L52
        if ((r136 instanceof OrderSkeletonMonitorConfig) == true) goto L50;
        r136 = null;
    L50:
        Object r137 = Result.m9449constructorimpl((OrderSkeletonMonitorConfig) r136);     // Catch: Throwable -> L52
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

    @SettingPanel("Android获取ttnet监控网络耗时开放的path")
    public static final String L0() {
        int r100 = j.f43647a;
        Object r101 = "{\"paths\":[\"\"]}";
        int r102 = com.bytedance.android.ec.base.settings.b.f42814a;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L172
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L172
        SDKSettingsCacheManager r104 = SDKSettingsCacheManager.f42812e;     // Catch: Throwable -> L172
        Object r105 = null;
        r104.getClass();     // Catch: Throwable -> L59
        Object r106 = SDKSettingsCacheManager.f42809b.get("ec_ttnet_monitor_path_list");     // Catch: Throwable -> L59
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
        Object r111 = SDKSettingsCacheManager.f42808a.get("ec_ttnet_monitor_path_list");     // Catch: Throwable -> L172
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
        SDKSettingsCacheManager.e("ec_ttnet_monitor_path_list", r110);     // Catch: Throwable -> L172
        goto L182
    L185:
        r114 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ec_ttnet_monitor_path_list", String.class, "{\"paths\":[\"\"]}");     // Catch: Throwable -> L166
    L167:
        if (r114 != null) goto L169;
        r110 = "{\"paths\":[\"\"]}";
    L166:
        r114 = "{\"paths\":[\"\"]}";
        goto L167
    L191:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L133
        Object r115 = SDKSettingsCacheManager.f42809b.get("ec_ttnet_monitor_path_list");     // Catch: Throwable -> L133
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
        Object r120 = jj4.a.a("ec_ttnet_monitor_path_list", String.class, "{\"paths\":[\"\"]}", false);     // Catch: Throwable -> L159
        if (r120 != null) goto L151;
        Intrinsics.throwNpe();     // Catch: Throwable -> L159
    L151:
        if ((r120 instanceof String) == false) goto L154;
        r105 = r120;
    L154:
        String r121 = (String) r105;     // Catch: Throwable -> L159
        if (r121 != null) goto L157;
        r121 = "{\"paths\":[\"\"]}";
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

    @SettingPanel("商详返回动画修复")
    public static final boolean M() {
        int r100 = com.bytedance.android.ec.base.settings.b.f42814a;
        Object r101 = Boolean.TRUE;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L172
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L172
        SDKSettingsCacheManager r103 = SDKSettingsCacheManager.f42812e;     // Catch: Throwable -> L172
        Object r104 = null;
        r103.getClass();     // Catch: Throwable -> L59
        Object r105 = SDKSettingsCacheManager.f42809b.get("ec_pdp_fix_close_anim_v2");     // Catch: Throwable -> L59
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
        Object r110 = SDKSettingsCacheManager.f42808a.get("ec_pdp_fix_close_anim_v2");     // Catch: Throwable -> L172
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
        SDKSettingsCacheManager.e("ec_pdp_fix_close_anim_v2", r109);     // Catch: Throwable -> L172
        goto L182
    L185:
        r113 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ec_pdp_fix_close_anim_v2", Boolean.class, r101);     // Catch: Throwable -> L166
    L167:
        if (r113 != null) goto L169;
        r109 = r101;
    L166:
        r113 = r101;
        goto L167
    L191:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L133
        Object r114 = SDKSettingsCacheManager.f42809b.get("ec_pdp_fix_close_anim_v2");     // Catch: Throwable -> L133
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
        Object r119 = jj4.a.a("ec_pdp_fix_close_anim_v2", Boolean.class, r101, false);     // Catch: Throwable -> L159
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

    @SettingPanel("极致提单缓存配置")
    public static final UltimateBuyCacheConfig M0() {
        int r100 = j.f43647a;
        Object r101 = new UltimateBuyCacheConfig(0, 0, null, 7, null);
        int r102 = com.bytedance.android.ec.base.settings.b.f42814a;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L172
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L172
        SDKSettingsCacheManager r104 = SDKSettingsCacheManager.f42812e;     // Catch: Throwable -> L172
        Object r105 = null;
        r104.getClass();     // Catch: Throwable -> L59
        Object r106 = SDKSettingsCacheManager.f42809b.get("ultimate_buy_cache_config");     // Catch: Throwable -> L59
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
        if ((r108 instanceof UltimateBuyCacheConfig) == true) goto L70;
        r108 = null;
    L70:
        Object r110 = (UltimateBuyCacheConfig) r108;     // Catch: Throwable -> L172
        if (r110 != null) goto L77;
        r104.getClass();     // Catch: Throwable -> L172
        Object r111 = SDKSettingsCacheManager.f42808a.get("ultimate_buy_cache_config");     // Catch: Throwable -> L172
        if ((r111 instanceof UltimateBuyCacheConfig) == true) goto L76;
        r111 = null;
    L76:
        r110 = (UltimateBuyCacheConfig) r111;     // Catch: Throwable -> L172
    L77:
        if (r110 != null) goto L182;
        int r112 = com.bytedance.android.ec.base.settings.g.f42821a;     // Catch: Throwable -> L172
    L159:
        th = move-exception;
        Result.Companion r113 = Result.Companion;     // Catch: Throwable -> L172
        Object r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L172
    L162:
        if (Result.m9452exceptionOrNullimpl(r114) != null) goto L193;
    L169:
        r110 = r114;
    L170:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L172
        SDKSettingsCacheManager.e("ultimate_buy_cache_config", r110);     // Catch: Throwable -> L172
        goto L182
    L193:
        r114 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ultimate_buy_cache_config", UltimateBuyCacheConfig.class, r101);     // Catch: Throwable -> L166
    L167:
        if (r114 != null) goto L169;
        r110 = r101;
    L166:
        r114 = r101;
        goto L167
    L185:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L133
        Object r115 = SDKSettingsCacheManager.f42809b.get("ultimate_buy_cache_config");     // Catch: Throwable -> L133
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
        if ((r117 instanceof UltimateBuyCacheConfig) == true) goto L144;
        r117 = null;
    L144:
        r114 = (UltimateBuyCacheConfig) r117;     // Catch: Throwable -> L159
        if (r114 != null) goto L169;
        jj4.b r119 = jj4.b.f499326b;     // Catch: Throwable -> L159
        Object r120 = jj4.a.a("ultimate_buy_cache_config", UltimateBuyCacheConfig.class, r101, false);     // Catch: Throwable -> L159
        if (r120 != null) goto L151;
        Intrinsics.throwNpe();     // Catch: Throwable -> L159
    L151:
        if ((r120 instanceof UltimateBuyCacheConfig) == false) goto L154;
        r105 = r120;
    L154:
        Object r121 = (UltimateBuyCacheConfig) r105;     // Catch: Throwable -> L159
        if (r121 != null) goto L157;
        r121 = r101;
    L157:
        r114 = Result.m9449constructorimpl(r121);     // Catch: Throwable -> L159
    L85:
        if ((r115 instanceof UltimateBuyCacheConfig) == true) goto L87;
        Object r122 = null;
    L88:
        r116 = (UltimateBuyCacheConfig) r122;     // Catch: Throwable -> L133
        if (r116 != null) goto L131;
        if ((r115 instanceof Number) == false) goto L118;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(UltimateBuyCacheConfig.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L100;
        Float r123 = Float.valueOf(((Number) r115).floatValue());     // Catch: Throwable -> L133
        if ((r123 instanceof UltimateBuyCacheConfig) == true) goto L98;
        r123 = null;
    L98:
        r116 = (UltimateBuyCacheConfig) r123;     // Catch: Throwable -> L133
        goto L131
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(UltimateBuyCacheConfig.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L106;
        Double r124 = Double.valueOf(((Number) r115).doubleValue());     // Catch: Throwable -> L133
        if ((r124 instanceof UltimateBuyCacheConfig) == true) goto L104;
        r124 = null;
    L104:
        r116 = (UltimateBuyCacheConfig) r124;     // Catch: Throwable -> L133
        goto L131
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(UltimateBuyCacheConfig.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L112;
        Integer r125 = Integer.valueOf(((Number) r115).intValue());     // Catch: Throwable -> L133
        if ((r125 instanceof UltimateBuyCacheConfig) == true) goto L110;
        r125 = null;
    L110:
        r116 = (UltimateBuyCacheConfig) r125;     // Catch: Throwable -> L133
        goto L131
    L112:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(UltimateBuyCacheConfig.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L118;
        Long r126 = Long.valueOf(((Number) r115).longValue());     // Catch: Throwable -> L133
        if ((r126 instanceof UltimateBuyCacheConfig) == true) goto L116;
        r126 = null;
    L116:
        r116 = (UltimateBuyCacheConfig) r126;     // Catch: Throwable -> L133
    L118:
        if ((r115 instanceof JSONObject) == false) goto L120;
    L191:
        Object r127 = SDKSettingsCacheManager.a().fromJson(r115.toString(), UltimateBuyCacheConfig.class);     // Catch: Throwable -> L126
        if ((r127 instanceof UltimateBuyCacheConfig) == true) goto L124;
        r127 = null;
    L124:
        Object r128 = Result.m9449constructorimpl((UltimateBuyCacheConfig) r127);     // Catch: Throwable -> L126
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
        return (UltimateBuyCacheConfig) r110;
    L11:
        if ((r106 instanceof UltimateBuyCacheConfig) == true) goto L13;
        Object r131 = null;
    L14:
        r107 = (UltimateBuyCacheConfig) r131;     // Catch: Throwable -> L59
        if (r107 != null) goto L57;
        if ((r106 instanceof Number) == false) goto L44;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(UltimateBuyCacheConfig.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r132 = Float.valueOf(((Number) r106).floatValue());     // Catch: Throwable -> L59
        if ((r132 instanceof UltimateBuyCacheConfig) == true) goto L24;
        r132 = null;
    L24:
        r107 = (UltimateBuyCacheConfig) r132;     // Catch: Throwable -> L59
        goto L57
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(UltimateBuyCacheConfig.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r133 = Double.valueOf(((Number) r106).doubleValue());     // Catch: Throwable -> L59
        if ((r133 instanceof UltimateBuyCacheConfig) == true) goto L30;
        r133 = null;
    L30:
        r107 = (UltimateBuyCacheConfig) r133;     // Catch: Throwable -> L59
        goto L57
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(UltimateBuyCacheConfig.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L38;
        Integer r134 = Integer.valueOf(((Number) r106).intValue());     // Catch: Throwable -> L59
        if ((r134 instanceof UltimateBuyCacheConfig) == true) goto L36;
        r134 = null;
    L36:
        r107 = (UltimateBuyCacheConfig) r134;     // Catch: Throwable -> L59
        goto L57
    L38:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(UltimateBuyCacheConfig.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L44;
        Long r135 = Long.valueOf(((Number) r106).longValue());     // Catch: Throwable -> L59
        if ((r135 instanceof UltimateBuyCacheConfig) == true) goto L42;
        r135 = null;
    L42:
        r107 = (UltimateBuyCacheConfig) r135;     // Catch: Throwable -> L59
    L44:
        if ((r106 instanceof JSONObject) == false) goto L46;
    L183:
        Object r136 = SDKSettingsCacheManager.a().fromJson(r106.toString(), UltimateBuyCacheConfig.class);     // Catch: Throwable -> L52
        if ((r136 instanceof UltimateBuyCacheConfig) == true) goto L50;
        r136 = null;
    L50:
        Object r137 = Result.m9449constructorimpl((UltimateBuyCacheConfig) r136);     // Catch: Throwable -> L52
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

    @SettingPanel("商详视频UI调整")
    public static final int N() {
        int r100 = j.f43647a;
        Lazy r101 = ECAppInfoService.f48110a;
        Object r102 = Integer.valueOf(ECAppInfoService.h() ? 1 : 0);
        int r103 = com.bytedance.android.ec.base.settings.b.f42814a;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L166
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L166
        SDKSettingsCacheManager r105 = SDKSettingsCacheManager.f42812e;     // Catch: Throwable -> L166
        Object r106 = null;
        r105.getClass();     // Catch: Throwable -> L56
        Object r107 = SDKSettingsCacheManager.f42809b.get("ec_pdp_video_ui_opt");     // Catch: Throwable -> L56
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
        Object r112 = SDKSettingsCacheManager.f42808a.get("ec_pdp_video_ui_opt");     // Catch: Throwable -> L166
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
    L156:
        if (Result.m9452exceptionOrNullimpl(r115) != null) goto L185;
    L163:
        r111 = r115;
    L164:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L166
        SDKSettingsCacheManager.e("ec_pdp_video_ui_opt", r111);     // Catch: Throwable -> L166
        goto L176
    L185:
        r115 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ec_pdp_video_ui_opt", Integer.class, r102);     // Catch: Throwable -> L160
    L161:
        if (r115 != null) goto L163;
        r111 = r102;
    L160:
        r115 = r102;
        goto L161
    L177:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L127
        Object r116 = SDKSettingsCacheManager.f42809b.get("ec_pdp_video_ui_opt");     // Catch: Throwable -> L127
        if (r116 != null) goto L82;
    L124:
        Object r117 = null;
    L125:
        Object r118 = Result.m9449constructorimpl(r117);     // Catch: Throwable -> L127
    L129:
        Throwable r119 = Result.m9452exceptionOrNullimpl(r118);     // Catch: Throwable -> L153
        if (r119 == null) goto L133;
        EnsureManager.ensureNotReachHere(r119);     // Catch: Throwable -> L153
    L133:
        if (Result.m9455isFailureimpl(r118) == false) goto L136;
        r118 = null;
    L136:
        if ((r118 instanceof Integer) == true) goto L138;
        r118 = null;
    L138:
        r115 = (Integer) r118;     // Catch: Throwable -> L153
        if (r115 != null) goto L163;
        jj4.b r120 = jj4.b.f499326b;     // Catch: Throwable -> L153
        Object r121 = jj4.a.a("ec_pdp_video_ui_opt", Integer.class, r102, false);     // Catch: Throwable -> L153
        if (r121 != null) goto L145;
        Intrinsics.throwNpe();     // Catch: Throwable -> L153
    L145:
        if ((r121 instanceof Integer) == false) goto L148;
        r106 = r121;
    L148:
        Object r122 = (Integer) r106;     // Catch: Throwable -> L153
        if (r122 != null) goto L151;
        r122 = r102;
    L151:
        r115 = Result.m9449constructorimpl(r122);     // Catch: Throwable -> L153
    L82:
        if ((r116 instanceof Integer) == true) goto L84;
        Object r123 = null;
    L85:
        r117 = (Integer) r123;     // Catch: Throwable -> L127
        if (r117 != null) goto L125;
        if ((r116 instanceof Number) == false) goto L112;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r124 = Float.valueOf(((Number) r116).floatValue());     // Catch: Throwable -> L127
        if ((r124 instanceof Integer) == true) goto L95;
        r124 = null;
    L95:
        r117 = (Integer) r124;     // Catch: Throwable -> L127
        goto L125
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r125 = Double.valueOf(((Number) r116).doubleValue());     // Catch: Throwable -> L127
        if ((r125 instanceof Integer) == true) goto L101;
        r125 = null;
    L101:
        r117 = (Integer) r125;     // Catch: Throwable -> L127
        goto L125
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L106;
        r117 = Integer.valueOf(((Number) r116).intValue());     // Catch: Throwable -> L127
        goto L125
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L112;
        Long r126 = Long.valueOf(((Number) r116).longValue());     // Catch: Throwable -> L127
        if ((r126 instanceof Integer) == true) goto L110;
        r126 = null;
    L110:
        r117 = (Integer) r126;     // Catch: Throwable -> L127
    L112:
        if ((r116 instanceof JSONObject) == false) goto L114;
    L183:
        Object r127 = SDKSettingsCacheManager.a().fromJson(r116.toString(), Integer.class);     // Catch: Throwable -> L120
        if ((r127 instanceof Integer) == true) goto L118;
        r127 = null;
    L118:
        Object r128 = Result.m9449constructorimpl((Integer) r127);     // Catch: Throwable -> L120
    L122:
        r117 = r128;
        if (Result.m9455isFailureimpl(r117) == false) goto L125;
    L120:
        th = move-exception;
        Result.Companion r129 = Result.Companion;     // Catch: Throwable -> L127
        r128 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L127
        goto L122
    L114:
        if ((r116 instanceof JSONArray) == false) goto L124;
    L84:
        r123 = r116;
    L127:
        th = move-exception;
        Result.Companion r130 = Result.Companion;     // Catch: Throwable -> L153
        r118 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L153
    L176:
        return ((Number) r111).intValue();
    L11:
        if ((r107 instanceof Integer) == true) goto L13;
        Object r131 = null;
    L14:
        r108 = (Integer) r131;     // Catch: Throwable -> L56
        if (r108 != null) goto L54;
        if ((r107 instanceof Number) == false) goto L41;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r132 = Float.valueOf(((Number) r107).floatValue());     // Catch: Throwable -> L56
        if ((r132 instanceof Integer) == true) goto L24;
        r132 = null;
    L24:
        r108 = (Integer) r132;     // Catch: Throwable -> L56
        goto L54
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r133 = Double.valueOf(((Number) r107).doubleValue());     // Catch: Throwable -> L56
        if ((r133 instanceof Integer) == true) goto L30;
        r133 = null;
    L30:
        r108 = (Integer) r133;     // Catch: Throwable -> L56
        goto L54
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L35;
        r108 = Integer.valueOf(((Number) r107).intValue());     // Catch: Throwable -> L56
        goto L54
    L35:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L41;
        Long r134 = Long.valueOf(((Number) r107).longValue());     // Catch: Throwable -> L56
        if ((r134 instanceof Integer) == true) goto L39;
        r134 = null;
    L39:
        r108 = (Integer) r134;     // Catch: Throwable -> L56
    L41:
        if ((r107 instanceof JSONObject) == false) goto L43;
    L181:
        Object r135 = SDKSettingsCacheManager.a().fromJson(r107.toString(), Integer.class);     // Catch: Throwable -> L49
        if ((r135 instanceof Integer) == true) goto L47;
        r135 = null;
    L47:
        Object r136 = Result.m9449constructorimpl((Integer) r135);     // Catch: Throwable -> L49
    L51:
        r108 = r136;
        if (Result.m9455isFailureimpl(r108) == false) goto L54;
    L49:
        th = move-exception;
        Result.Companion r137 = Result.Companion;     // Catch: Throwable -> L56
        r136 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L56
        goto L51
    L43:
        if ((r107 instanceof JSONArray) == false) goto L53;
    L13:
        r131 = r107;
    L56:
        th = move-exception;
        Result.Companion r138 = Result.Companion;     // Catch: Throwable -> L166
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
    L166:
        th = move-exception;
        Result.Companion r139 = Result.Companion;
        Object r140 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r141 = Result.m9452exceptionOrNullimpl(r140);
        if (r141 == null) goto L171;
        EnsureManager.ensureNotReachHere(r141);
    L171:
        if (Result.m9455isFailureimpl(r140) == true) goto L174;
        r102 = r140;
    L174:
        r111 = r102;
        goto L176
    }

    @SettingPanel("商详直播小窗底部 margin")
    public static final int O() {
        int r100 = j.f43647a;
        Object r101 = 103;
        int r102 = com.bytedance.android.ec.base.settings.b.f42814a;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L166
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L166
        SDKSettingsCacheManager r104 = SDKSettingsCacheManager.f42812e;     // Catch: Throwable -> L166
        Object r105 = null;
        r104.getClass();     // Catch: Throwable -> L56
        Object r106 = SDKSettingsCacheManager.f42809b.get("ec_pdp_live_window_bottom_margin");     // Catch: Throwable -> L56
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
        Object r111 = SDKSettingsCacheManager.f42808a.get("ec_pdp_live_window_bottom_margin");     // Catch: Throwable -> L166
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
        SDKSettingsCacheManager.e("ec_pdp_live_window_bottom_margin", r110);     // Catch: Throwable -> L166
        goto L176
    L183:
        r114 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ec_pdp_live_window_bottom_margin", Integer.class, r101);     // Catch: Throwable -> L160
    L161:
        if (r114 != null) goto L163;
        r110 = r101;
    L160:
        r114 = r101;
        goto L161
    L189:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L127
        Object r115 = SDKSettingsCacheManager.f42809b.get("ec_pdp_live_window_bottom_margin");     // Catch: Throwable -> L127
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
        Object r120 = jj4.a.a("ec_pdp_live_window_bottom_margin", Integer.class, r101, false);     // Catch: Throwable -> L153
        if (r120 != null) goto L145;
        Intrinsics.throwNpe();     // Catch: Throwable -> L153
    L145:
        if ((r120 instanceof Integer) == false) goto L148;
        r105 = r120;
    L148:
        Object r121 = (Integer) r105;     // Catch: Throwable -> L153
        if (r121 != null) goto L151;
        r121 = r101;
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
    L181:
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
        return ((Number) r110).intValue();
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
    L179:
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
        r101 = r139;
    L174:
        r110 = r101;
        goto L176
    }

    @SettingPanel("商品卡移除无用蒙层")
    public static final boolean P() {
        int r100 = p.f45243a;
        Object r101 = Boolean.FALSE;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r103 = jj4.b.f499326b;     // Catch: Throwable -> L7
        Object r104 = jj4.a.a("ec_promotion_card_remove_mask", Boolean.class, r101, false);     // Catch: Throwable -> L7
        if (r104 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return ((Boolean) r104).booleanValue();
    L7:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Object r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r106) == true) goto L12;
        r101 = r106;
    L12:
        r104 = r101;
        goto L14
    }

    @SettingPanel("交易链路SaaS AB实验key")
    public static final List<String> Q() {
        int r100 = j.f43647a;
        Object r101 = CollectionsKt.listOf(new String[]{"iesec_saas_shop_comment", "iesec_saas_pdp_search", "debug_flag"});
        int r102 = com.bytedance.android.ec.base.settings.b.f42814a;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L174
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L174
        SDKSettingsCacheManager r104 = SDKSettingsCacheManager.f42812e;     // Catch: Throwable -> L174
        Object r105 = null;
        r104.getClass();     // Catch: Throwable -> L59
        Object r106 = SDKSettingsCacheManager.f42809b.get("iesec_saas_ab_keys");     // Catch: Throwable -> L59
        if (r106 != null) goto L11;
    L56:
        Object r107 = null;
    L57:
        Object r108 = Result.m9449constructorimpl(r107);     // Catch: Throwable -> L59
    L61:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);     // Catch: Throwable -> L174
        if (r109 == null) goto L65;
        EnsureManager.ensureNotReachHere(r109);     // Catch: Throwable -> L174
    L65:
        if (Result.m9455isFailureimpl(r108) == false) goto L68;
        r108 = null;
    L68:
        if ((r108 instanceof List) == true) goto L70;
        r108 = null;
    L70:
        Object r110 = (List) r108;     // Catch: Throwable -> L174
        if (r110 != null) goto L77;
        r104.getClass();     // Catch: Throwable -> L174
        Object r111 = SDKSettingsCacheManager.f42808a.get("iesec_saas_ab_keys");     // Catch: Throwable -> L174
        if ((r111 instanceof List) == true) goto L76;
        r111 = null;
    L76:
        r110 = (List) r111;     // Catch: Throwable -> L174
    L77:
        if (r110 != null) goto L184;
        int r112 = com.bytedance.android.ec.base.settings.g.f42821a;     // Catch: Throwable -> L174
    L161:
        th = move-exception;
        Result.Companion r113 = Result.Companion;     // Catch: Throwable -> L174
        Object r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L174
    L164:
        if (Result.m9452exceptionOrNullimpl(r114) != null) goto L187;
    L171:
        r110 = r114;
    L172:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L174
        SDKSettingsCacheManager.e("iesec_saas_ab_keys", r110);     // Catch: Throwable -> L174
        goto L184
    L187:
        r114 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("iesec_saas_ab_keys", List.class, r101);     // Catch: Throwable -> L168
    L169:
        if (r114 != null) goto L171;
        r110 = r101;
    L168:
        r114 = r101;
        goto L169
    L191:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L133
        Object r115 = SDKSettingsCacheManager.f42809b.get("iesec_saas_ab_keys");     // Catch: Throwable -> L133
        if (r115 != null) goto L85;
    L130:
        Object r116 = null;
    L131:
        Object r117 = Result.m9449constructorimpl(r116);     // Catch: Throwable -> L133
    L135:
        Throwable r118 = Result.m9452exceptionOrNullimpl(r117);     // Catch: Throwable -> L161
        if (r118 == null) goto L139;
        EnsureManager.ensureNotReachHere(r118);     // Catch: Throwable -> L161
    L139:
        if (Result.m9455isFailureimpl(r117) == false) goto L142;
        r117 = null;
    L142:
        if ((r117 instanceof List) == true) goto L144;
        r117 = null;
    L144:
        r114 = (List) r117;     // Catch: Throwable -> L161
        if (r114 != null) goto L147;
    L149:
        jj4.b r119 = jj4.b.f499326b;     // Catch: Throwable -> L161
        Object r120 = jj4.a.a("iesec_saas_ab_keys", List.class, r101, false);     // Catch: Throwable -> L161
        if (r120 != null) goto L153;
        Intrinsics.throwNpe();     // Catch: Throwable -> L161
    L153:
        if ((r120 instanceof List) == false) goto L156;
        r105 = r120;
    L156:
        Object r121 = (List) r105;     // Catch: Throwable -> L161
        if (r121 != null) goto L159;
        r121 = r101;
    L159:
        r114 = Result.m9449constructorimpl(r121);     // Catch: Throwable -> L161
    L147:
        if ((r114 instanceof List) == false) goto L149;
    L85:
        if ((r115 instanceof List) == true) goto L87;
        Object r122 = null;
    L88:
        r116 = (List) r122;     // Catch: Throwable -> L133
        if (r116 != null) goto L131;
        if ((r115 instanceof Number) == false) goto L118;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(List.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L100;
        Float r123 = Float.valueOf(((Number) r115).floatValue());     // Catch: Throwable -> L133
        if ((r123 instanceof List) == true) goto L98;
        r123 = null;
    L98:
        r116 = (List) r123;     // Catch: Throwable -> L133
        goto L131
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(List.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L106;
        Double r124 = Double.valueOf(((Number) r115).doubleValue());     // Catch: Throwable -> L133
        if ((r124 instanceof List) == true) goto L104;
        r124 = null;
    L104:
        r116 = (List) r124;     // Catch: Throwable -> L133
        goto L131
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(List.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L112;
        Integer r125 = Integer.valueOf(((Number) r115).intValue());     // Catch: Throwable -> L133
        if ((r125 instanceof List) == true) goto L110;
        r125 = null;
    L110:
        r116 = (List) r125;     // Catch: Throwable -> L133
        goto L131
    L112:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(List.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L118;
        Long r126 = Long.valueOf(((Number) r115).longValue());     // Catch: Throwable -> L133
        if ((r126 instanceof List) == true) goto L116;
        r126 = null;
    L116:
        r116 = (List) r126;     // Catch: Throwable -> L133
    L118:
        if ((r115 instanceof JSONObject) == false) goto L120;
    L197:
        Object r127 = SDKSettingsCacheManager.a().fromJson(r115.toString(), List.class);     // Catch: Throwable -> L126
        if ((r127 instanceof List) == true) goto L124;
        r127 = null;
    L124:
        Object r128 = Result.m9449constructorimpl((List) r127);     // Catch: Throwable -> L126
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
        Result.Companion r130 = Result.Companion;     // Catch: Throwable -> L161
        r117 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L161
    L184:
        return (List) r110;
    L11:
        if ((r106 instanceof List) == true) goto L13;
        Object r131 = null;
    L14:
        r107 = (List) r131;     // Catch: Throwable -> L59
        if (r107 != null) goto L57;
        if ((r106 instanceof Number) == false) goto L44;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(List.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r132 = Float.valueOf(((Number) r106).floatValue());     // Catch: Throwable -> L59
        if ((r132 instanceof List) == true) goto L24;
        r132 = null;
    L24:
        r107 = (List) r132;     // Catch: Throwable -> L59
        goto L57
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(List.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r133 = Double.valueOf(((Number) r106).doubleValue());     // Catch: Throwable -> L59
        if ((r133 instanceof List) == true) goto L30;
        r133 = null;
    L30:
        r107 = (List) r133;     // Catch: Throwable -> L59
        goto L57
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(List.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L38;
        Integer r134 = Integer.valueOf(((Number) r106).intValue());     // Catch: Throwable -> L59
        if ((r134 instanceof List) == true) goto L36;
        r134 = null;
    L36:
        r107 = (List) r134;     // Catch: Throwable -> L59
        goto L57
    L38:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(List.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L44;
        Long r135 = Long.valueOf(((Number) r106).longValue());     // Catch: Throwable -> L59
        if ((r135 instanceof List) == true) goto L42;
        r135 = null;
    L42:
        r107 = (List) r135;     // Catch: Throwable -> L59
    L44:
        if ((r106 instanceof JSONObject) == false) goto L46;
    L185:
        Object r136 = SDKSettingsCacheManager.a().fromJson(r106.toString(), List.class);     // Catch: Throwable -> L52
        if ((r136 instanceof List) == true) goto L50;
        r136 = null;
    L50:
        Object r137 = Result.m9449constructorimpl((List) r136);     // Catch: Throwable -> L52
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
        Result.Companion r139 = Result.Companion;     // Catch: Throwable -> L174
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L174
    L174:
        th = move-exception;
        Result.Companion r140 = Result.Companion;
        Object r141 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r142 = Result.m9452exceptionOrNullimpl(r141);
        if (r142 == null) goto L179;
        EnsureManager.ensureNotReachHere(r142);
    L179:
        if (Result.m9455isFailureimpl(r141) == true) goto L182;
        r101 = r141;
    L182:
        r110 = r101;
        goto L184
    }

    @SettingPanel("电商saas接入直播小窗")
    public static final int R() {
        int r100 = p.f45243a;
        Object r101 = 0;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r103 = jj4.b.f499326b;     // Catch: Throwable -> L7
        Object r104 = jj4.a.a("ec_saas_live_window_enable", Integer.class, r101, false);     // Catch: Throwable -> L7
        if (r104 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return ((Number) r104).intValue();
    L7:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Object r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r106) == true) goto L12;
        r101 = r106;
    L12:
        r104 = r101;
        goto L14
    }

    @SettingPanel("sku加购引导的频控逻辑")
    public static final List<String> S() {
        int r100 = p.f45243a;
        Object r101 = CollectionsKt.listOf(new String[]{"1", "4", "7"});
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r103 = jj4.b.f499326b;     // Catch: Throwable -> L7
        Object r104 = jj4.a.a("sku_add_cart_guide_config", List.class, r101, false);     // Catch: Throwable -> L7
        if (r104 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return (List) r104;
    L7:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Object r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r106) == true) goto L12;
        r101 = r106;
    L12:
        r104 = r101;
        goto L14
    }

    @SettingPanel("一步提单&sku大字体")
    public static int T() {
        int r100 = j.f43647a;
        Object r101 = 0;
        int r102 = com.bytedance.android.ec.base.settings.b.f42814a;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L166
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L166
        SDKSettingsCacheManager r104 = SDKSettingsCacheManager.f42812e;     // Catch: Throwable -> L166
        Object r105 = null;
        r104.getClass();     // Catch: Throwable -> L56
        Object r106 = SDKSettingsCacheManager.f42809b.get("ec_sku_buy_big_font");     // Catch: Throwable -> L56
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
        Object r111 = SDKSettingsCacheManager.f42808a.get("ec_sku_buy_big_font");     // Catch: Throwable -> L166
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
        SDKSettingsCacheManager.e("ec_sku_buy_big_font", r110);     // Catch: Throwable -> L166
        goto L176
    L183:
        r114 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ec_sku_buy_big_font", Integer.class, r101);     // Catch: Throwable -> L160
    L161:
        if (r114 != null) goto L163;
        r110 = r101;
    L160:
        r114 = r101;
        goto L161
    L189:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L127
        Object r115 = SDKSettingsCacheManager.f42809b.get("ec_sku_buy_big_font");     // Catch: Throwable -> L127
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
        Object r121 = jj4.a.a("ec_sku_buy_big_font", Integer.class, r101, false);     // Catch: Throwable -> L153
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

    @SettingPanel("独立端新设计语言二期")
    public static int U() {
        int r100 = n.f45241a;
        Object r101 = 0;
        int r102 = com.bytedance.android.ec.base.settings.a.f42813a;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L160
        Object r104 = null;
        Object r105 = com.bytedance.android.ec.base.settings.d.f42818c.get("legou_sku_buy_layout_opt_v2");     // Catch: Throwable -> L54
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
        Object r110 = com.bytedance.android.ec.base.settings.d.f42816a.get("legou_sku_buy_layout_opt_v2");     // Catch: Throwable -> L160
        if ((r110 instanceof Integer) == true) goto L71;
        r110 = null;
    L71:
        r109 = (Integer) r110;     // Catch: Throwable -> L160
    L72:
        if (r109 != null) goto L170;
        int r111 = com.bytedance.android.ec.base.settings.c.f42815a;     // Catch: Throwable -> L160
        Object r112 = com.bytedance.android.ec.base.settings.d.f42818c.get("legou_sku_buy_layout_opt_v2");     // Catch: Throwable -> L124
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
        Object r117 = r116.getHostABValue("legou_sku_buy_layout_opt_v2", r101);     // Catch: Throwable -> L150
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
        com.bytedance.android.ec.base.settings.d.d("legou_sku_buy_layout_opt_v2", r109);     // Catch: Throwable -> L160
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

    @SettingPanel("一步提单 & SKU 缩放优化")
    public static boolean V() {
        int r100 = j.f43647a;
        int r101 = com.bytedance.android.ec.core.abtest.e.f43640a;
        Object r102 = com.bytedance.android.ec.core.abtest.e.a(Boolean.TRUE, Boolean.FALSE);
        int r103 = com.bytedance.android.ec.base.settings.b.f42814a;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L172
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L172
        SDKSettingsCacheManager r105 = SDKSettingsCacheManager.f42812e;     // Catch: Throwable -> L172
        Object r106 = null;
        r105.getClass();     // Catch: Throwable -> L59
        Object r107 = SDKSettingsCacheManager.f42809b.get("ec_sku_buy_scale_opt");     // Catch: Throwable -> L59
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
        Object r112 = SDKSettingsCacheManager.f42808a.get("ec_sku_buy_scale_opt");     // Catch: Throwable -> L172
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
        SDKSettingsCacheManager.e("ec_sku_buy_scale_opt", r111);     // Catch: Throwable -> L172
        goto L182
    L191:
        r115 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ec_sku_buy_scale_opt", Boolean.class, r102);     // Catch: Throwable -> L166
    L167:
        if (r115 != null) goto L169;
        r111 = r102;
    L166:
        r115 = r102;
        goto L167
    L183:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L133
        Object r116 = SDKSettingsCacheManager.f42809b.get("ec_sku_buy_scale_opt");     // Catch: Throwable -> L133
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
        Object r121 = jj4.a.a("ec_sku_buy_scale_opt", Boolean.class, r102, false);     // Catch: Throwable -> L159
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

    @SettingPanel("sku拉屏高scenetype名单")
    public static List W() {
        int r100 = j.f43647a;
        Object r101 = CollectionsKt.listOf(new String[]{"101", BDLocationException.ERROR_UID_IS_EMPTY, "105", BDLocationException.ERROR_BLUETOOTh_NOT_AVAILABLE});
        int r102 = com.bytedance.android.ec.base.settings.b.f42814a;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L174
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L174
        SDKSettingsCacheManager r104 = SDKSettingsCacheManager.f42812e;     // Catch: Throwable -> L174
        Object r105 = null;
        r104.getClass();     // Catch: Throwable -> L59
        Object r106 = SDKSettingsCacheManager.f42809b.get("ec_sku_height_imp_scene_list");     // Catch: Throwable -> L59
        if (r106 != null) goto L11;
    L56:
        Object r107 = null;
    L57:
        Object r108 = Result.m9449constructorimpl(r107);     // Catch: Throwable -> L59
    L61:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);     // Catch: Throwable -> L174
        if (r109 == null) goto L65;
        EnsureManager.ensureNotReachHere(r109);     // Catch: Throwable -> L174
    L65:
        if (Result.m9455isFailureimpl(r108) == false) goto L68;
        r108 = null;
    L68:
        if ((r108 instanceof List) == true) goto L70;
        r108 = null;
    L70:
        Object r110 = (List) r108;     // Catch: Throwable -> L174
        if (r110 != null) goto L77;
        r104.getClass();     // Catch: Throwable -> L174
        Object r111 = SDKSettingsCacheManager.f42808a.get("ec_sku_height_imp_scene_list");     // Catch: Throwable -> L174
        if ((r111 instanceof List) == true) goto L76;
        r111 = null;
    L76:
        r110 = (List) r111;     // Catch: Throwable -> L174
    L77:
        if (r110 != null) goto L184;
        int r112 = com.bytedance.android.ec.base.settings.g.f42821a;     // Catch: Throwable -> L174
    L161:
        th = move-exception;
        Result.Companion r113 = Result.Companion;     // Catch: Throwable -> L174
        Object r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L174
    L164:
        if (Result.m9452exceptionOrNullimpl(r114) != null) goto L189;
    L171:
        r110 = r114;
    L172:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L174
        SDKSettingsCacheManager.e("ec_sku_height_imp_scene_list", r110);     // Catch: Throwable -> L174
        goto L184
    L189:
        r114 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ec_sku_height_imp_scene_list", List.class, r101);     // Catch: Throwable -> L168
    L169:
        if (r114 != null) goto L171;
        r110 = r101;
    L168:
        r114 = r101;
        goto L169
    L193:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L133
        Object r115 = SDKSettingsCacheManager.f42809b.get("ec_sku_height_imp_scene_list");     // Catch: Throwable -> L133
        if (r115 != null) goto L85;
    L130:
        Object r116 = null;
    L131:
        Object r117 = Result.m9449constructorimpl(r116);     // Catch: Throwable -> L133
    L135:
        Throwable r118 = Result.m9452exceptionOrNullimpl(r117);     // Catch: Throwable -> L161
        if (r118 == null) goto L139;
        EnsureManager.ensureNotReachHere(r118);     // Catch: Throwable -> L161
    L139:
        if (Result.m9455isFailureimpl(r117) == false) goto L142;
        r117 = null;
    L142:
        if ((r117 instanceof List) == true) goto L144;
        r117 = null;
    L144:
        r114 = (List) r117;     // Catch: Throwable -> L161
        if (r114 != null) goto L147;
    L149:
        jj4.b r119 = jj4.b.f499326b;     // Catch: Throwable -> L161
        Object r120 = jj4.a.a("ec_sku_height_imp_scene_list", List.class, r101, false);     // Catch: Throwable -> L161
        if (r120 != null) goto L153;
        Intrinsics.throwNpe();     // Catch: Throwable -> L161
    L153:
        if ((r120 instanceof List) == false) goto L156;
        r105 = r120;
    L156:
        Object r121 = (List) r105;     // Catch: Throwable -> L161
        if (r121 != null) goto L159;
        r121 = r101;
    L159:
        r114 = Result.m9449constructorimpl(r121);     // Catch: Throwable -> L161
    L147:
        if ((r114 instanceof List) == false) goto L149;
    L85:
        if ((r115 instanceof List) == true) goto L87;
        Object r122 = null;
    L88:
        r116 = (List) r122;     // Catch: Throwable -> L133
        if (r116 != null) goto L131;
        if ((r115 instanceof Number) == false) goto L118;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(List.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L100;
        Float r123 = Float.valueOf(((Number) r115).floatValue());     // Catch: Throwable -> L133
        if ((r123 instanceof List) == true) goto L98;
        r123 = null;
    L98:
        r116 = (List) r123;     // Catch: Throwable -> L133
        goto L131
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(List.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L106;
        Double r124 = Double.valueOf(((Number) r115).doubleValue());     // Catch: Throwable -> L133
        if ((r124 instanceof List) == true) goto L104;
        r124 = null;
    L104:
        r116 = (List) r124;     // Catch: Throwable -> L133
        goto L131
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(List.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L112;
        Integer r125 = Integer.valueOf(((Number) r115).intValue());     // Catch: Throwable -> L133
        if ((r125 instanceof List) == true) goto L110;
        r125 = null;
    L110:
        r116 = (List) r125;     // Catch: Throwable -> L133
        goto L131
    L112:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(List.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L118;
        Long r126 = Long.valueOf(((Number) r115).longValue());     // Catch: Throwable -> L133
        if ((r126 instanceof List) == true) goto L116;
        r126 = null;
    L116:
        r116 = (List) r126;     // Catch: Throwable -> L133
    L118:
        if ((r115 instanceof JSONObject) == false) goto L120;
    L185:
        Object r127 = SDKSettingsCacheManager.a().fromJson(r115.toString(), List.class);     // Catch: Throwable -> L126
        if ((r127 instanceof List) == true) goto L124;
        r127 = null;
    L124:
        Object r128 = Result.m9449constructorimpl((List) r127);     // Catch: Throwable -> L126
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
        Result.Companion r130 = Result.Companion;     // Catch: Throwable -> L161
        r117 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L161
    L184:
        return (List) r110;
    L11:
        if ((r106 instanceof List) == true) goto L13;
        Object r131 = null;
    L14:
        r107 = (List) r131;     // Catch: Throwable -> L59
        if (r107 != null) goto L57;
        if ((r106 instanceof Number) == false) goto L44;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(List.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r132 = Float.valueOf(((Number) r106).floatValue());     // Catch: Throwable -> L59
        if ((r132 instanceof List) == true) goto L24;
        r132 = null;
    L24:
        r107 = (List) r132;     // Catch: Throwable -> L59
        goto L57
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(List.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r133 = Double.valueOf(((Number) r106).doubleValue());     // Catch: Throwable -> L59
        if ((r133 instanceof List) == true) goto L30;
        r133 = null;
    L30:
        r107 = (List) r133;     // Catch: Throwable -> L59
        goto L57
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(List.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L38;
        Integer r134 = Integer.valueOf(((Number) r106).intValue());     // Catch: Throwable -> L59
        if ((r134 instanceof List) == true) goto L36;
        r134 = null;
    L36:
        r107 = (List) r134;     // Catch: Throwable -> L59
        goto L57
    L38:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(List.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L44;
        Long r135 = Long.valueOf(((Number) r106).longValue());     // Catch: Throwable -> L59
        if ((r135 instanceof List) == true) goto L42;
        r135 = null;
    L42:
        r107 = (List) r135;     // Catch: Throwable -> L59
    L44:
        if ((r106 instanceof JSONObject) == false) goto L46;
    L187:
        Object r136 = SDKSettingsCacheManager.a().fromJson(r106.toString(), List.class);     // Catch: Throwable -> L52
        if ((r136 instanceof List) == true) goto L50;
        r136 = null;
    L50:
        Object r137 = Result.m9449constructorimpl((List) r136);     // Catch: Throwable -> L52
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
        Result.Companion r139 = Result.Companion;     // Catch: Throwable -> L174
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L174
    L174:
        th = move-exception;
        Result.Companion r140 = Result.Companion;
        Object r141 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r142 = Result.m9452exceptionOrNullimpl(r141);
        if (r142 == null) goto L179;
        EnsureManager.ensureNotReachHere(r142);
    L179:
        if (Result.m9455isFailureimpl(r141) == true) goto L182;
        r101 = r141;
    L182:
        r110 = r101;
        goto L184
    }

    @SettingPanel("sku拉屏高高度比例")
    public static int X() {
        int r100 = j.f43647a;
        Object r101 = 83;
        int r102 = com.bytedance.android.ec.base.settings.b.f42814a;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L166
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L166
        SDKSettingsCacheManager r104 = SDKSettingsCacheManager.f42812e;     // Catch: Throwable -> L166
        Object r105 = null;
        r104.getClass();     // Catch: Throwable -> L56
        Object r106 = SDKSettingsCacheManager.f42809b.get("ec_sku_height_percent");     // Catch: Throwable -> L56
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
        Object r111 = SDKSettingsCacheManager.f42808a.get("ec_sku_height_percent");     // Catch: Throwable -> L166
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
        SDKSettingsCacheManager.e("ec_sku_height_percent", r110);     // Catch: Throwable -> L166
        goto L176
    L183:
        r114 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ec_sku_height_percent", Integer.class, r101);     // Catch: Throwable -> L160
    L161:
        if (r114 != null) goto L163;
        r110 = r101;
    L160:
        r114 = r101;
        goto L161
    L189:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L127
        Object r115 = SDKSettingsCacheManager.f42809b.get("ec_sku_height_percent");     // Catch: Throwable -> L127
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
        Object r120 = jj4.a.a("ec_sku_height_percent", Integer.class, r101, false);     // Catch: Throwable -> L153
        if (r120 != null) goto L145;
        Intrinsics.throwNpe();     // Catch: Throwable -> L153
    L145:
        if ((r120 instanceof Integer) == false) goto L148;
        r105 = r120;
    L148:
        Object r121 = (Integer) r105;     // Catch: Throwable -> L153
        if (r121 != null) goto L151;
        r121 = r101;
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
    L181:
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
        return ((Number) r110).intValue();
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
    L179:
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
        r101 = r139;
    L174:
        r110 = r101;
        goto L176
    }

    @SettingPanel("Sku组件化页面配置")
    public static final com.bytedance.android.ec.core.sku.e Y() {
        int r100 = p.f45243a;
        Object r101 = new com.bytedance.android.ec.core.sku.e(0);
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r103 = jj4.b.f499326b;     // Catch: Throwable -> L7
        Object r104 = jj4.a.a("iesec_sku_page_config", com.bytedance.android.ec.core.sku.e.class, r101, false);     // Catch: Throwable -> L7
        if (r104 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return (com.bytedance.android.ec.core.sku.e) r104;
    L7:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Object r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r106) == true) goto L12;
        r101 = r106;
    L12:
        r104 = r101;
        goto L14
    }

    @SettingPanel("SKU模版预加载配置")
    public static final List<Map<String, Object>> Z() {
        int r100 = p.f45243a;
        Object r101 = com.bytedance.android.ec.core.sku.f.f45327a;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r103 = jj4.b.f499326b;     // Catch: Throwable -> L7
        Object r104 = jj4.a.a("iesec_sku_slice_templates", List.class, r101, false);     // Catch: Throwable -> L7
        if (r104 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return (List) r104;
    L7:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Object r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r106) == true) goto L12;
        r101 = r106;
    L12:
        r104 = r101;
        goto L14
    }

    @SettingPanel("电商半屏页面FPS监控是否采用校准方案")
    public static final boolean a() {
        int r100 = p.f45243a;
        Object r101 = Boolean.TRUE;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r103 = jj4.b.f499326b;     // Catch: Throwable -> L7
        Object r104 = jj4.a.a("live_ec_fps_monitor_adjust", Boolean.class, r101, false);     // Catch: Throwable -> L7
        if (r104 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return ((Boolean) r104).booleanValue();
    L7:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Object r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r106) == true) goto L12;
        r101 = r106;
    L12:
        r104 = r101;
        goto L14
    }

    @SettingPanel("Tabkit 优化配置")
    public static final String a0() {
        int r100 = p.f45243a;
        Object r101 = SliceInitService.DEFAULT_SWITCH;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r103 = jj4.b.f499326b;     // Catch: Throwable -> L7
        Object r104 = jj4.a.a("ec_tabkit_config", String.class, SliceInitService.DEFAULT_SWITCH, false);     // Catch: Throwable -> L7
        if (r104 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return (String) r104;
    L7:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Object r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r106) == true) goto L12;
        r101 = r106;
    L12:
        r104 = r101;
        goto L14
    }

    @SettingPanel("预约成功弹窗中心文案")
    public static final ECResultDialogContentVO b() {
        int r100 = c.f43628a;
        int r101 = w0.f45736a;
        Object r102 = (ECResultDialogContentVO) w0.b("{\"title\":\"预约成功\",\"content\":\"1.预售开始的提醒会以短信与APP消息的方式通知您～请及时关注\\n2.您可以APP消息里找到已预约商品进行查看\",\"confirm\":\"我知道了\"}", ECResultDialogContentVO.class);
        if (r102 == null) goto L17;
        int r103 = p.f45243a;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L9
        jj4.b r105 = jj4.b.f499326b;     // Catch: Throwable -> L9
        Object r106 = jj4.a.a("appointment_result_dialog", ECResultDialogContentVO.class, r102, false);     // Catch: Throwable -> L9
        if (r106 != null) goto L15;
        Intrinsics.throwNpe();     // Catch: Throwable -> L9
    L15:
        ECResultDialogContentVO r107 = (ECResultDialogContentVO) r106;
        if (r107 == null) goto L17;
        return r107;
    L9:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        Object r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r109) == true) goto L14;
        r102 = r109;
    L14:
        r106 = r102;
    L17:
        int r110 = p.f45243a;
        Object r111 = null;
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L20
        jj4.b r113 = jj4.b.f499326b;     // Catch: Throwable -> L20
        Object r114 = jj4.a.a(" appointment_result_dialog", ECResultDialogContentVO.class, null, false);     // Catch: Throwable -> L20
    L27:
        return (ECResultDialogContentVO) r114;
    L20:
        th = move-exception;
        Result.Companion r115 = Result.Companion;
        Object r116 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r116) == true) goto L25;
        r111 = r116;
    L25:
        r114 = r111;
        goto L27
    }

    @SettingPanel("修复 ViewConfiguration Crash")
    public static int b0() {
        int r100 = com.bytedance.android.ec.base.settings.b.f42814a;
        Object r101 = 0;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L166
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L166
        SDKSettingsCacheManager r103 = SDKSettingsCacheManager.f42812e;     // Catch: Throwable -> L166
        Object r104 = null;
        r103.getClass();     // Catch: Throwable -> L56
        Object r105 = SDKSettingsCacheManager.f42809b.get("ec_fix_viewconf_crash");     // Catch: Throwable -> L56
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
        Object r110 = SDKSettingsCacheManager.f42808a.get("ec_fix_viewconf_crash");     // Catch: Throwable -> L166
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
        SDKSettingsCacheManager.e("ec_fix_viewconf_crash", r109);     // Catch: Throwable -> L166
        goto L176
    L179:
        r113 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ec_fix_viewconf_crash", Integer.class, r101);     // Catch: Throwable -> L160
    L161:
        if (r113 != null) goto L163;
        r109 = r101;
    L160:
        r113 = r101;
        goto L161
    L185:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L127
        Object r114 = SDKSettingsCacheManager.f42809b.get("ec_fix_viewconf_crash");     // Catch: Throwable -> L127
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
        Object r120 = jj4.a.a("ec_fix_viewconf_crash", Integer.class, r101, false);     // Catch: Throwable -> L153
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

    @SettingPanel("Android电商业务网络接口监控开关")
    public static final boolean c() {
        int r100 = j.f43647a;
        Object r101 = Boolean.FALSE;
        int r102 = com.bytedance.android.ec.base.settings.b.f42814a;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L172
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L172
        SDKSettingsCacheManager r104 = SDKSettingsCacheManager.f42812e;     // Catch: Throwable -> L172
        Object r105 = null;
        r104.getClass();     // Catch: Throwable -> L59
        Object r106 = SDKSettingsCacheManager.f42809b.get("ec_business_net_monitor_switch");     // Catch: Throwable -> L59
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
        Object r111 = SDKSettingsCacheManager.f42808a.get("ec_business_net_monitor_switch");     // Catch: Throwable -> L172
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
        SDKSettingsCacheManager.e("ec_business_net_monitor_switch", r110);     // Catch: Throwable -> L172
        goto L182
    L185:
        r114 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ec_business_net_monitor_switch", Boolean.class, r101);     // Catch: Throwable -> L166
    L167:
        if (r114 != null) goto L169;
        r110 = r101;
    L166:
        r114 = r101;
        goto L167
    L191:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L133
        Object r115 = SDKSettingsCacheManager.f42809b.get("ec_business_net_monitor_switch");     // Catch: Throwable -> L133
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
        Object r120 = jj4.a.a("ec_business_net_monitor_switch", Boolean.class, r101, false);     // Catch: Throwable -> L159
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

    @SettingPanel("橱窗商品图片预加载")
    public static final int c0() {
        int r100 = p.f45243a;
        Object r101 = 0;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r103 = jj4.b.f499326b;     // Catch: Throwable -> L7
        Object r104 = jj4.a.a("ec_window_image_preload_enable", Integer.class, r101, false);     // Catch: Throwable -> L7
        if (r104 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return ((Number) r104).intValue();
    L7:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Object r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r106) == true) goto L12;
        r101 = r106;
    L12:
        r104 = r101;
        goto L14
    }

    @SettingPanel("橱窗视频商卡使用电商播放器")
    public static final boolean d0() {
        int r100 = p.f45243a;
        Object r101 = Boolean.FALSE;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r103 = jj4.b.f499326b;     // Catch: Throwable -> L7
        Object r104 = jj4.a.a("window_video_product_use_ec_player", Boolean.class, r101, false);     // Catch: Throwable -> L7
        if (r104 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return ((Boolean) r104).booleanValue();
    L7:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Object r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r106) == true) goto L12;
        r101 = r106;
    L12:
        r104 = r101;
        goto L14
    }

    @SettingPanel("组件化提单页模版预加载Fields配置")
    public static final String e() {
        int r100 = j.f43647a;
        Object r101 = SliceInitService.DEFAULT_SWITCH;
        int r102 = com.bytedance.android.ec.base.settings.b.f42814a;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L172
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L172
        SDKSettingsCacheManager r104 = SDKSettingsCacheManager.f42812e;     // Catch: Throwable -> L172
        Object r105 = null;
        r104.getClass();     // Catch: Throwable -> L59
        Object r106 = SDKSettingsCacheManager.f42809b.get("iesec_buynow_slice_fields");     // Catch: Throwable -> L59
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
        Object r111 = SDKSettingsCacheManager.f42808a.get("iesec_buynow_slice_fields");     // Catch: Throwable -> L172
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
        SDKSettingsCacheManager.e("iesec_buynow_slice_fields", r110);     // Catch: Throwable -> L172
        goto L182
    L185:
        r114 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("iesec_buynow_slice_fields", String.class, SliceInitService.DEFAULT_SWITCH);     // Catch: Throwable -> L166
    L167:
        if (r114 != null) goto L169;
        r110 = SliceInitService.DEFAULT_SWITCH;
    L166:
        r114 = SliceInitService.DEFAULT_SWITCH;
        goto L167
    L191:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L133
        Object r115 = SDKSettingsCacheManager.f42809b.get("iesec_buynow_slice_fields");     // Catch: Throwable -> L133
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
        Object r120 = jj4.a.a("iesec_buynow_slice_fields", String.class, SliceInitService.DEFAULT_SWITCH, false);     // Catch: Throwable -> L159
        if (r120 != null) goto L151;
        Intrinsics.throwNpe();     // Catch: Throwable -> L159
    L151:
        if ((r120 instanceof String) == false) goto L154;
        r105 = r120;
    L154:
        String r121 = (String) r105;     // Catch: Throwable -> L159
        if (r121 != null) goto L157;
        r121 = SliceInitService.DEFAULT_SWITCH;
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

    @SettingPanel("Yata事件上报配置")
    public static final Map<String, Object> e0() {
        int r100 = p.f45243a;
        Object r101 = MapsKt.emptyMap();
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r103 = jj4.b.f499326b;     // Catch: Throwable -> L7
        Object r104 = jj4.a.a("iesec_yata_report_config", Map.class, r101, false);     // Catch: Throwable -> L7
        if (r104 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return (Map) r104;
    L7:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Object r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r106) == true) goto L12;
        r101 = r106;
    L12:
        r104 = r101;
        goto L14
    }

    @SettingPanel("组件化提单页模版预加载配置")
    public static final z43.b f() {
        int r100 = j.f43647a;
        Object r101 = new z43.b();
        int r102 = com.bytedance.android.ec.base.settings.b.f42814a;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L172
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L172
        SDKSettingsCacheManager r104 = SDKSettingsCacheManager.f42812e;     // Catch: Throwable -> L172
        Object r105 = null;
        r104.getClass();     // Catch: Throwable -> L59
        Object r106 = SDKSettingsCacheManager.f42809b.get("iesec_buynow_slice_templates");     // Catch: Throwable -> L59
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
        if ((r108 instanceof z43.b) == true) goto L70;
        r108 = null;
    L70:
        Object r110 = (z43.b) r108;     // Catch: Throwable -> L172
        if (r110 != null) goto L77;
        r104.getClass();     // Catch: Throwable -> L172
        Object r111 = SDKSettingsCacheManager.f42808a.get("iesec_buynow_slice_templates");     // Catch: Throwable -> L172
        if ((r111 instanceof z43.b) == true) goto L76;
        r111 = null;
    L76:
        r110 = (z43.b) r111;     // Catch: Throwable -> L172
    L77:
        if (r110 != null) goto L182;
        int r112 = com.bytedance.android.ec.base.settings.g.f42821a;     // Catch: Throwable -> L172
    L159:
        th = move-exception;
        Result.Companion r113 = Result.Companion;     // Catch: Throwable -> L172
        Object r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L172
    L162:
        if (Result.m9452exceptionOrNullimpl(r114) != null) goto L189;
    L169:
        r110 = r114;
    L170:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L172
        SDKSettingsCacheManager.e("iesec_buynow_slice_templates", r110);     // Catch: Throwable -> L172
        goto L182
    L189:
        r114 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("iesec_buynow_slice_templates", z43.b.class, r101);     // Catch: Throwable -> L166
    L167:
        if (r114 != null) goto L169;
        r110 = r101;
    L166:
        r114 = r101;
        goto L167
    L195:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L133
        Object r115 = SDKSettingsCacheManager.f42809b.get("iesec_buynow_slice_templates");     // Catch: Throwable -> L133
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
        if ((r117 instanceof z43.b) == true) goto L144;
        r117 = null;
    L144:
        r114 = (z43.b) r117;     // Catch: Throwable -> L159
        if (r114 != null) goto L169;
        jj4.b r119 = jj4.b.f499326b;     // Catch: Throwable -> L159
        Object r120 = jj4.a.a("iesec_buynow_slice_templates", z43.b.class, r101, false);     // Catch: Throwable -> L159
        if (r120 != null) goto L151;
        Intrinsics.throwNpe();     // Catch: Throwable -> L159
    L151:
        if ((r120 instanceof z43.b) == false) goto L154;
        r105 = r120;
    L154:
        Object r121 = (z43.b) r105;     // Catch: Throwable -> L159
        if (r121 != null) goto L157;
        r121 = r101;
    L157:
        r114 = Result.m9449constructorimpl(r121);     // Catch: Throwable -> L159
    L85:
        if ((r115 instanceof z43.b) == true) goto L87;
        Object r122 = null;
    L88:
        r116 = (z43.b) r122;     // Catch: Throwable -> L133
        if (r116 != null) goto L131;
        if ((r115 instanceof Number) == false) goto L118;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(z43.b.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L100;
        Float r123 = Float.valueOf(((Number) r115).floatValue());     // Catch: Throwable -> L133
        if ((r123 instanceof z43.b) == true) goto L98;
        r123 = null;
    L98:
        r116 = (z43.b) r123;     // Catch: Throwable -> L133
        goto L131
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(z43.b.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L106;
        Double r124 = Double.valueOf(((Number) r115).doubleValue());     // Catch: Throwable -> L133
        if ((r124 instanceof z43.b) == true) goto L104;
        r124 = null;
    L104:
        r116 = (z43.b) r124;     // Catch: Throwable -> L133
        goto L131
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(z43.b.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L112;
        Integer r125 = Integer.valueOf(((Number) r115).intValue());     // Catch: Throwable -> L133
        if ((r125 instanceof z43.b) == true) goto L110;
        r125 = null;
    L110:
        r116 = (z43.b) r125;     // Catch: Throwable -> L133
        goto L131
    L112:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(z43.b.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L118;
        Long r126 = Long.valueOf(((Number) r115).longValue());     // Catch: Throwable -> L133
        if ((r126 instanceof z43.b) == true) goto L116;
        r126 = null;
    L116:
        r116 = (z43.b) r126;     // Catch: Throwable -> L133
    L118:
        if ((r115 instanceof JSONObject) == false) goto L120;
    L187:
        Object r127 = SDKSettingsCacheManager.a().fromJson(r115.toString(), z43.b.class);     // Catch: Throwable -> L126
        if ((r127 instanceof z43.b) == true) goto L124;
        r127 = null;
    L124:
        Object r128 = Result.m9449constructorimpl((z43.b) r127);     // Catch: Throwable -> L126
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
        return (z43.b) r110;
    L11:
        if ((r106 instanceof z43.b) == true) goto L13;
        Object r131 = null;
    L14:
        r107 = (z43.b) r131;     // Catch: Throwable -> L59
        if (r107 != null) goto L57;
        if ((r106 instanceof Number) == false) goto L44;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(z43.b.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r132 = Float.valueOf(((Number) r106).floatValue());     // Catch: Throwable -> L59
        if ((r132 instanceof z43.b) == true) goto L24;
        r132 = null;
    L24:
        r107 = (z43.b) r132;     // Catch: Throwable -> L59
        goto L57
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(z43.b.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r133 = Double.valueOf(((Number) r106).doubleValue());     // Catch: Throwable -> L59
        if ((r133 instanceof z43.b) == true) goto L30;
        r133 = null;
    L30:
        r107 = (z43.b) r133;     // Catch: Throwable -> L59
        goto L57
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(z43.b.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L38;
        Integer r134 = Integer.valueOf(((Number) r106).intValue());     // Catch: Throwable -> L59
        if ((r134 instanceof z43.b) == true) goto L36;
        r134 = null;
    L36:
        r107 = (z43.b) r134;     // Catch: Throwable -> L59
        goto L57
    L38:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(z43.b.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L44;
        Long r135 = Long.valueOf(((Number) r106).longValue());     // Catch: Throwable -> L59
        if ((r135 instanceof z43.b) == true) goto L42;
        r135 = null;
    L42:
        r107 = (z43.b) r135;     // Catch: Throwable -> L59
    L44:
        if ((r106 instanceof JSONObject) == false) goto L46;
    L193:
        Object r136 = SDKSettingsCacheManager.a().fromJson(r106.toString(), z43.b.class);     // Catch: Throwable -> L52
        if ((r136 instanceof z43.b) == true) goto L50;
        r136 = null;
    L50:
        Object r137 = Result.m9449constructorimpl((z43.b) r136);     // Catch: Throwable -> L52
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

    @SettingPanel("Yata开关配置")
    public static final Map<String, Object> f0() {
        int r100 = j.f43647a;
        Object r101 = MapsKt.emptyMap();
        int r102 = com.bytedance.android.ec.base.settings.b.f42814a;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L174
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L174
        SDKSettingsCacheManager r104 = SDKSettingsCacheManager.f42812e;     // Catch: Throwable -> L174
        Object r105 = null;
        r104.getClass();     // Catch: Throwable -> L59
        Object r106 = SDKSettingsCacheManager.f42809b.get("iesec_yata_switch_config");     // Catch: Throwable -> L59
        if (r106 != null) goto L11;
    L56:
        Object r107 = null;
    L57:
        Object r108 = Result.m9449constructorimpl(r107);     // Catch: Throwable -> L59
    L61:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);     // Catch: Throwable -> L174
        if (r109 == null) goto L65;
        EnsureManager.ensureNotReachHere(r109);     // Catch: Throwable -> L174
    L65:
        if (Result.m9455isFailureimpl(r108) == false) goto L68;
        r108 = null;
    L68:
        if ((r108 instanceof Map) == true) goto L70;
        r108 = null;
    L70:
        Object r110 = (Map) r108;     // Catch: Throwable -> L174
        if (r110 != null) goto L77;
        r104.getClass();     // Catch: Throwable -> L174
        Object r111 = SDKSettingsCacheManager.f42808a.get("iesec_yata_switch_config");     // Catch: Throwable -> L174
        if ((r111 instanceof Map) == true) goto L76;
        r111 = null;
    L76:
        r110 = (Map) r111;     // Catch: Throwable -> L174
    L77:
        if (r110 != null) goto L184;
        int r112 = com.bytedance.android.ec.base.settings.g.f42821a;     // Catch: Throwable -> L174
    L161:
        th = move-exception;
        Result.Companion r113 = Result.Companion;     // Catch: Throwable -> L174
        Object r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L174
    L164:
        if (Result.m9452exceptionOrNullimpl(r114) != null) goto L193;
    L171:
        r110 = r114;
    L172:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L174
        SDKSettingsCacheManager.e("iesec_yata_switch_config", r110);     // Catch: Throwable -> L174
        goto L184
    L193:
        r114 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("iesec_yata_switch_config", Map.class, r101);     // Catch: Throwable -> L168
    L169:
        if (r114 != null) goto L171;
        r110 = r101;
    L168:
        r114 = r101;
        goto L169
    L197:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L133
        Object r115 = SDKSettingsCacheManager.f42809b.get("iesec_yata_switch_config");     // Catch: Throwable -> L133
        if (r115 != null) goto L85;
    L130:
        Object r116 = null;
    L131:
        Object r117 = Result.m9449constructorimpl(r116);     // Catch: Throwable -> L133
    L135:
        Throwable r118 = Result.m9452exceptionOrNullimpl(r117);     // Catch: Throwable -> L161
        if (r118 == null) goto L139;
        EnsureManager.ensureNotReachHere(r118);     // Catch: Throwable -> L161
    L139:
        if (Result.m9455isFailureimpl(r117) == false) goto L142;
        r117 = null;
    L142:
        if ((r117 instanceof Map) == true) goto L144;
        r117 = null;
    L144:
        r114 = (Map) r117;     // Catch: Throwable -> L161
        if (r114 != null) goto L147;
    L149:
        jj4.b r119 = jj4.b.f499326b;     // Catch: Throwable -> L161
        Object r120 = jj4.a.a("iesec_yata_switch_config", Map.class, r101, false);     // Catch: Throwable -> L161
        if (r120 != null) goto L153;
        Intrinsics.throwNpe();     // Catch: Throwable -> L161
    L153:
        if ((r120 instanceof Map) == false) goto L156;
        r105 = r120;
    L156:
        Object r121 = (Map) r105;     // Catch: Throwable -> L161
        if (r121 != null) goto L159;
        r121 = r101;
    L159:
        r114 = Result.m9449constructorimpl(r121);     // Catch: Throwable -> L161
    L147:
        if ((r114 instanceof Map) == false) goto L149;
    L85:
        if ((r115 instanceof Map) == true) goto L87;
        Object r122 = null;
    L88:
        r116 = (Map) r122;     // Catch: Throwable -> L133
        if (r116 != null) goto L131;
        if ((r115 instanceof Number) == false) goto L118;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Map.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L100;
        Float r123 = Float.valueOf(((Number) r115).floatValue());     // Catch: Throwable -> L133
        if ((r123 instanceof Map) == true) goto L98;
        r123 = null;
    L98:
        r116 = (Map) r123;     // Catch: Throwable -> L133
        goto L131
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Map.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L106;
        Double r124 = Double.valueOf(((Number) r115).doubleValue());     // Catch: Throwable -> L133
        if ((r124 instanceof Map) == true) goto L104;
        r124 = null;
    L104:
        r116 = (Map) r124;     // Catch: Throwable -> L133
        goto L131
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Map.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L112;
        Integer r125 = Integer.valueOf(((Number) r115).intValue());     // Catch: Throwable -> L133
        if ((r125 instanceof Map) == true) goto L110;
        r125 = null;
    L110:
        r116 = (Map) r125;     // Catch: Throwable -> L133
        goto L131
    L112:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Map.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L118;
        Long r126 = Long.valueOf(((Number) r115).longValue());     // Catch: Throwable -> L133
        if ((r126 instanceof Map) == true) goto L116;
        r126 = null;
    L116:
        r116 = (Map) r126;     // Catch: Throwable -> L133
    L118:
        if ((r115 instanceof JSONObject) == false) goto L120;
    L189:
        Object r127 = SDKSettingsCacheManager.a().fromJson(r115.toString(), Map.class);     // Catch: Throwable -> L126
        if ((r127 instanceof Map) == true) goto L124;
        r127 = null;
    L124:
        Object r128 = Result.m9449constructorimpl((Map) r127);     // Catch: Throwable -> L126
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
        Result.Companion r130 = Result.Companion;     // Catch: Throwable -> L161
        r117 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L161
    L184:
        return (Map) r110;
    L11:
        if ((r106 instanceof Map) == true) goto L13;
        Object r131 = null;
    L14:
        r107 = (Map) r131;     // Catch: Throwable -> L59
        if (r107 != null) goto L57;
        if ((r106 instanceof Number) == false) goto L44;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Map.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r132 = Float.valueOf(((Number) r106).floatValue());     // Catch: Throwable -> L59
        if ((r132 instanceof Map) == true) goto L24;
        r132 = null;
    L24:
        r107 = (Map) r132;     // Catch: Throwable -> L59
        goto L57
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Map.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r133 = Double.valueOf(((Number) r106).doubleValue());     // Catch: Throwable -> L59
        if ((r133 instanceof Map) == true) goto L30;
        r133 = null;
    L30:
        r107 = (Map) r133;     // Catch: Throwable -> L59
        goto L57
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Map.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L38;
        Integer r134 = Integer.valueOf(((Number) r106).intValue());     // Catch: Throwable -> L59
        if ((r134 instanceof Map) == true) goto L36;
        r134 = null;
    L36:
        r107 = (Map) r134;     // Catch: Throwable -> L59
        goto L57
    L38:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Map.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L44;
        Long r135 = Long.valueOf(((Number) r106).longValue());     // Catch: Throwable -> L59
        if ((r135 instanceof Map) == true) goto L42;
        r135 = null;
    L42:
        r107 = (Map) r135;     // Catch: Throwable -> L59
    L44:
        if ((r106 instanceof JSONObject) == false) goto L46;
    L191:
        Object r136 = SDKSettingsCacheManager.a().fromJson(r106.toString(), Map.class);     // Catch: Throwable -> L52
        if ((r136 instanceof Map) == true) goto L50;
        r136 = null;
    L50:
        Object r137 = Result.m9449constructorimpl((Map) r136);     // Catch: Throwable -> L52
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
        Result.Companion r139 = Result.Companion;     // Catch: Throwable -> L174
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L174
    L174:
        th = move-exception;
        Result.Companion r140 = Result.Companion;
        Object r141 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r142 = Result.m9452exceptionOrNullimpl(r141);
        if (r142 == null) goto L179;
        EnsureManager.ensureNotReachHere(r142);
    L179:
        if (Result.m9455isFailureimpl(r141) == true) goto L182;
        r101 = r141;
    L182:
        r110 = r101;
        goto L184
    }

    @SettingPanel("启用card_list_kit的页面名称")
    public static List g() {
        int r100 = com.bytedance.android.ec.base.settings.b.f42814a;
        Object r101 = CollectionsKt.emptyList();
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L174
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L174
        SDKSettingsCacheManager r103 = SDKSettingsCacheManager.f42812e;     // Catch: Throwable -> L174
        Object r104 = null;
        r103.getClass();     // Catch: Throwable -> L59
        Object r105 = SDKSettingsCacheManager.f42809b.get("ec_card_list_kit_enable");     // Catch: Throwable -> L59
        if (r105 != null) goto L11;
    L56:
        Object r106 = null;
    L57:
        Object r107 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L59
    L61:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);     // Catch: Throwable -> L174
        if (r108 == null) goto L65;
        EnsureManager.ensureNotReachHere(r108);     // Catch: Throwable -> L174
    L65:
        if (Result.m9455isFailureimpl(r107) == false) goto L68;
        r107 = null;
    L68:
        if ((r107 instanceof List) == true) goto L70;
        r107 = null;
    L70:
        Object r109 = (List) r107;     // Catch: Throwable -> L174
        if (r109 != null) goto L77;
        r103.getClass();     // Catch: Throwable -> L174
        Object r110 = SDKSettingsCacheManager.f42808a.get("ec_card_list_kit_enable");     // Catch: Throwable -> L174
        if ((r110 instanceof List) == true) goto L76;
        r110 = null;
    L76:
        r109 = (List) r110;     // Catch: Throwable -> L174
    L77:
        if (r109 != null) goto L184;
        int r111 = com.bytedance.android.ec.base.settings.g.f42821a;     // Catch: Throwable -> L174
    L161:
        th = move-exception;
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L174
        Object r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L174
    L164:
        if (Result.m9452exceptionOrNullimpl(r113) != null) goto L191;
    L171:
        r109 = r113;
    L172:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L174
        SDKSettingsCacheManager.e("ec_card_list_kit_enable", r109);     // Catch: Throwable -> L174
        goto L184
    L191:
        r113 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ec_card_list_kit_enable", List.class, r101);     // Catch: Throwable -> L168
    L169:
        if (r113 != null) goto L171;
        r109 = r101;
    L168:
        r113 = r101;
        goto L169
    L195:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L133
        Object r114 = SDKSettingsCacheManager.f42809b.get("ec_card_list_kit_enable");     // Catch: Throwable -> L133
        if (r114 != null) goto L85;
    L130:
        Object r115 = null;
    L131:
        Object r116 = Result.m9449constructorimpl(r115);     // Catch: Throwable -> L133
    L135:
        Throwable r117 = Result.m9452exceptionOrNullimpl(r116);     // Catch: Throwable -> L161
        if (r117 == null) goto L139;
        EnsureManager.ensureNotReachHere(r117);     // Catch: Throwable -> L161
    L139:
        if (Result.m9455isFailureimpl(r116) == false) goto L142;
        r116 = null;
    L142:
        if ((r116 instanceof List) == true) goto L144;
        r116 = null;
    L144:
        r113 = (List) r116;     // Catch: Throwable -> L161
        if (r113 != null) goto L147;
    L149:
        jj4.b r118 = jj4.b.f499326b;     // Catch: Throwable -> L161
        Object r119 = jj4.a.a("ec_card_list_kit_enable", List.class, r101, false);     // Catch: Throwable -> L161
        if (r119 != null) goto L153;
        Intrinsics.throwNpe();     // Catch: Throwable -> L161
    L153:
        if ((r119 instanceof List) == false) goto L156;
        r104 = r119;
    L156:
        Object r120 = (List) r104;     // Catch: Throwable -> L161
        if (r120 != null) goto L159;
        r120 = r101;
    L159:
        r113 = Result.m9449constructorimpl(r120);     // Catch: Throwable -> L161
    L147:
        if ((r113 instanceof List) == false) goto L149;
    L85:
        if ((r114 instanceof List) == true) goto L87;
        Object r121 = null;
    L88:
        r115 = (List) r121;     // Catch: Throwable -> L133
        if (r115 != null) goto L131;
        if ((r114 instanceof Number) == false) goto L118;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(List.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L100;
        Float r122 = Float.valueOf(((Number) r114).floatValue());     // Catch: Throwable -> L133
        if ((r122 instanceof List) == true) goto L98;
        r122 = null;
    L98:
        r115 = (List) r122;     // Catch: Throwable -> L133
        goto L131
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(List.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L106;
        Double r123 = Double.valueOf(((Number) r114).doubleValue());     // Catch: Throwable -> L133
        if ((r123 instanceof List) == true) goto L104;
        r123 = null;
    L104:
        r115 = (List) r123;     // Catch: Throwable -> L133
        goto L131
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(List.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L112;
        Integer r124 = Integer.valueOf(((Number) r114).intValue());     // Catch: Throwable -> L133
        if ((r124 instanceof List) == true) goto L110;
        r124 = null;
    L110:
        r115 = (List) r124;     // Catch: Throwable -> L133
        goto L131
    L112:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(List.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L118;
        Long r125 = Long.valueOf(((Number) r114).longValue());     // Catch: Throwable -> L133
        if ((r125 instanceof List) == true) goto L116;
        r125 = null;
    L116:
        r115 = (List) r125;     // Catch: Throwable -> L133
    L118:
        if ((r114 instanceof JSONObject) == false) goto L120;
    L187:
        Object r126 = SDKSettingsCacheManager.a().fromJson(r114.toString(), List.class);     // Catch: Throwable -> L126
        if ((r126 instanceof List) == true) goto L124;
        r126 = null;
    L124:
        Object r127 = Result.m9449constructorimpl((List) r126);     // Catch: Throwable -> L126
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
        Result.Companion r129 = Result.Companion;     // Catch: Throwable -> L161
        r116 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L161
    L184:
        return (List) r109;
    L11:
        if ((r105 instanceof List) == true) goto L13;
        Object r130 = null;
    L14:
        r106 = (List) r130;     // Catch: Throwable -> L59
        if (r106 != null) goto L57;
        if ((r105 instanceof Number) == false) goto L44;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(List.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r131 = Float.valueOf(((Number) r105).floatValue());     // Catch: Throwable -> L59
        if ((r131 instanceof List) == true) goto L24;
        r131 = null;
    L24:
        r106 = (List) r131;     // Catch: Throwable -> L59
        goto L57
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(List.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r132 = Double.valueOf(((Number) r105).doubleValue());     // Catch: Throwable -> L59
        if ((r132 instanceof List) == true) goto L30;
        r132 = null;
    L30:
        r106 = (List) r132;     // Catch: Throwable -> L59
        goto L57
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(List.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L38;
        Integer r133 = Integer.valueOf(((Number) r105).intValue());     // Catch: Throwable -> L59
        if ((r133 instanceof List) == true) goto L36;
        r133 = null;
    L36:
        r106 = (List) r133;     // Catch: Throwable -> L59
        goto L57
    L38:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(List.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L44;
        Long r134 = Long.valueOf(((Number) r105).longValue());     // Catch: Throwable -> L59
        if ((r134 instanceof List) == true) goto L42;
        r134 = null;
    L42:
        r106 = (List) r134;     // Catch: Throwable -> L59
    L44:
        if ((r105 instanceof JSONObject) == false) goto L46;
    L189:
        Object r135 = SDKSettingsCacheManager.a().fromJson(r105.toString(), List.class);     // Catch: Throwable -> L52
        if ((r135 instanceof List) == true) goto L50;
        r135 = null;
    L50:
        Object r136 = Result.m9449constructorimpl((List) r135);     // Catch: Throwable -> L52
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
        Result.Companion r138 = Result.Companion;     // Catch: Throwable -> L174
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L174
    L174:
        th = move-exception;
        Result.Companion r139 = Result.Companion;
        Object r140 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r141 = Result.m9452exceptionOrNullimpl(r140);
        if (r141 == null) goto L179;
        EnsureManager.ensureNotReachHere(r141);
    L179:
        if (Result.m9455isFailureimpl(r140) == true) goto L182;
        r101 = r140;
    L182:
        r109 = r101;
        goto L184
    }

    @SettingPanel("standard_product_marketing_param埋点优化")
    public static final boolean g0() {
        int r100 = p.f45243a;
        Object r101 = Boolean.TRUE;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r103 = jj4.b.f499326b;     // Catch: Throwable -> L7
        Object r104 = jj4.a.a("ec_standard_track_params_refactor_enable", Boolean.class, r101, false);     // Catch: Throwable -> L7
        if (r104 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return ((Boolean) r104).booleanValue();
    L7:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Object r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r106) == true) goto L12;
        r101 = r106;
    L12:
        r104 = r101;
        goto L14
    }

    @SettingPanel("商城关注tab首屏直")
    public static final int h0() {
        int r100 = p.f45243a;
        Object r101 = 0;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r103 = jj4.b.f499326b;     // Catch: Throwable -> L7
        Object r104 = jj4.a.a("enable_xtab_follow_page_opt", Integer.class, r101, false);     // Catch: Throwable -> L7
        if (r104 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return ((Number) r104).intValue();
    L7:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Object r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r106) == true) goto L12;
        r101 = r106;
    L12:
        r104 = r101;
        goto L14
    }

    @SettingPanel("地址 SDK 定位优化开关")
    public static final boolean i() {
        int r100 = j.f43647a;
        Object r101 = Boolean.TRUE;
        int r102 = com.bytedance.android.ec.base.settings.b.f42814a;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L172
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L172
        SDKSettingsCacheManager r104 = SDKSettingsCacheManager.f42812e;     // Catch: Throwable -> L172
        Object r105 = null;
        r104.getClass();     // Catch: Throwable -> L59
        Object r106 = SDKSettingsCacheManager.f42809b.get("iesec_address_sdk_enable_locate_opt");     // Catch: Throwable -> L59
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
        Object r111 = SDKSettingsCacheManager.f42808a.get("iesec_address_sdk_enable_locate_opt");     // Catch: Throwable -> L172
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
        SDKSettingsCacheManager.e("iesec_address_sdk_enable_locate_opt", r110);     // Catch: Throwable -> L172
        goto L182
    L185:
        r114 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("iesec_address_sdk_enable_locate_opt", Boolean.class, r101);     // Catch: Throwable -> L166
    L167:
        if (r114 != null) goto L169;
        r110 = r101;
    L166:
        r114 = r101;
        goto L167
    L191:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L133
        Object r115 = SDKSettingsCacheManager.f42809b.get("iesec_address_sdk_enable_locate_opt");     // Catch: Throwable -> L133
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
        Object r120 = jj4.a.a("iesec_address_sdk_enable_locate_opt", Boolean.class, r101, false);     // Catch: Throwable -> L159
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

    @SettingPanel("entrance_info加工规则配置")
    public static final EntranceInfoWriteConfig i0() {
        int r100 = j.f43647a;
        Object r101 = new EntranceInfoWriteConfig(null, null, null, null, null, 31, null);
        int r102 = com.bytedance.android.ec.base.settings.b.f42814a;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L172
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L172
        SDKSettingsCacheManager r104 = SDKSettingsCacheManager.f42812e;     // Catch: Throwable -> L172
        Object r105 = null;
        r104.getClass();     // Catch: Throwable -> L59
        Object r106 = SDKSettingsCacheManager.f42809b.get("entrance_info_check_config");     // Catch: Throwable -> L59
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
        if ((r108 instanceof EntranceInfoWriteConfig) == true) goto L70;
        r108 = null;
    L70:
        Object r110 = (EntranceInfoWriteConfig) r108;     // Catch: Throwable -> L172
        if (r110 != null) goto L77;
        r104.getClass();     // Catch: Throwable -> L172
        Object r111 = SDKSettingsCacheManager.f42808a.get("entrance_info_check_config");     // Catch: Throwable -> L172
        if ((r111 instanceof EntranceInfoWriteConfig) == true) goto L76;
        r111 = null;
    L76:
        r110 = (EntranceInfoWriteConfig) r111;     // Catch: Throwable -> L172
    L77:
        if (r110 != null) goto L182;
        int r112 = com.bytedance.android.ec.base.settings.g.f42821a;     // Catch: Throwable -> L172
    L159:
        th = move-exception;
        Result.Companion r113 = Result.Companion;     // Catch: Throwable -> L172
        Object r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L172
    L162:
        if (Result.m9452exceptionOrNullimpl(r114) != null) goto L193;
    L169:
        r110 = r114;
    L170:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L172
        SDKSettingsCacheManager.e("entrance_info_check_config", r110);     // Catch: Throwable -> L172
        goto L182
    L193:
        r114 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("entrance_info_check_config", EntranceInfoWriteConfig.class, r101);     // Catch: Throwable -> L166
    L167:
        if (r114 != null) goto L169;
        r110 = r101;
    L166:
        r114 = r101;
        goto L167
    L185:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L133
        Object r115 = SDKSettingsCacheManager.f42809b.get("entrance_info_check_config");     // Catch: Throwable -> L133
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
        if ((r117 instanceof EntranceInfoWriteConfig) == true) goto L144;
        r117 = null;
    L144:
        r114 = (EntranceInfoWriteConfig) r117;     // Catch: Throwable -> L159
        if (r114 != null) goto L169;
        jj4.b r119 = jj4.b.f499326b;     // Catch: Throwable -> L159
        Object r120 = jj4.a.a("entrance_info_check_config", EntranceInfoWriteConfig.class, r101, false);     // Catch: Throwable -> L159
        if (r120 != null) goto L151;
        Intrinsics.throwNpe();     // Catch: Throwable -> L159
    L151:
        if ((r120 instanceof EntranceInfoWriteConfig) == false) goto L154;
        r105 = r120;
    L154:
        Object r121 = (EntranceInfoWriteConfig) r105;     // Catch: Throwable -> L159
        if (r121 != null) goto L157;
        r121 = r101;
    L157:
        r114 = Result.m9449constructorimpl(r121);     // Catch: Throwable -> L159
    L85:
        if ((r115 instanceof EntranceInfoWriteConfig) == true) goto L87;
        Object r122 = null;
    L88:
        r116 = (EntranceInfoWriteConfig) r122;     // Catch: Throwable -> L133
        if (r116 != null) goto L131;
        if ((r115 instanceof Number) == false) goto L118;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(EntranceInfoWriteConfig.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L100;
        Float r123 = Float.valueOf(((Number) r115).floatValue());     // Catch: Throwable -> L133
        if ((r123 instanceof EntranceInfoWriteConfig) == true) goto L98;
        r123 = null;
    L98:
        r116 = (EntranceInfoWriteConfig) r123;     // Catch: Throwable -> L133
        goto L131
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(EntranceInfoWriteConfig.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L106;
        Double r124 = Double.valueOf(((Number) r115).doubleValue());     // Catch: Throwable -> L133
        if ((r124 instanceof EntranceInfoWriteConfig) == true) goto L104;
        r124 = null;
    L104:
        r116 = (EntranceInfoWriteConfig) r124;     // Catch: Throwable -> L133
        goto L131
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(EntranceInfoWriteConfig.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L112;
        Integer r125 = Integer.valueOf(((Number) r115).intValue());     // Catch: Throwable -> L133
        if ((r125 instanceof EntranceInfoWriteConfig) == true) goto L110;
        r125 = null;
    L110:
        r116 = (EntranceInfoWriteConfig) r125;     // Catch: Throwable -> L133
        goto L131
    L112:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(EntranceInfoWriteConfig.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L118;
        Long r126 = Long.valueOf(((Number) r115).longValue());     // Catch: Throwable -> L133
        if ((r126 instanceof EntranceInfoWriteConfig) == true) goto L116;
        r126 = null;
    L116:
        r116 = (EntranceInfoWriteConfig) r126;     // Catch: Throwable -> L133
    L118:
        if ((r115 instanceof JSONObject) == false) goto L120;
    L191:
        Object r127 = SDKSettingsCacheManager.a().fromJson(r115.toString(), EntranceInfoWriteConfig.class);     // Catch: Throwable -> L126
        if ((r127 instanceof EntranceInfoWriteConfig) == true) goto L124;
        r127 = null;
    L124:
        Object r128 = Result.m9449constructorimpl((EntranceInfoWriteConfig) r127);     // Catch: Throwable -> L126
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
        return (EntranceInfoWriteConfig) r110;
    L11:
        if ((r106 instanceof EntranceInfoWriteConfig) == true) goto L13;
        Object r131 = null;
    L14:
        r107 = (EntranceInfoWriteConfig) r131;     // Catch: Throwable -> L59
        if (r107 != null) goto L57;
        if ((r106 instanceof Number) == false) goto L44;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(EntranceInfoWriteConfig.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r132 = Float.valueOf(((Number) r106).floatValue());     // Catch: Throwable -> L59
        if ((r132 instanceof EntranceInfoWriteConfig) == true) goto L24;
        r132 = null;
    L24:
        r107 = (EntranceInfoWriteConfig) r132;     // Catch: Throwable -> L59
        goto L57
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(EntranceInfoWriteConfig.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r133 = Double.valueOf(((Number) r106).doubleValue());     // Catch: Throwable -> L59
        if ((r133 instanceof EntranceInfoWriteConfig) == true) goto L30;
        r133 = null;
    L30:
        r107 = (EntranceInfoWriteConfig) r133;     // Catch: Throwable -> L59
        goto L57
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(EntranceInfoWriteConfig.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L38;
        Integer r134 = Integer.valueOf(((Number) r106).intValue());     // Catch: Throwable -> L59
        if ((r134 instanceof EntranceInfoWriteConfig) == true) goto L36;
        r134 = null;
    L36:
        r107 = (EntranceInfoWriteConfig) r134;     // Catch: Throwable -> L59
        goto L57
    L38:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(EntranceInfoWriteConfig.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L44;
        Long r135 = Long.valueOf(((Number) r106).longValue());     // Catch: Throwable -> L59
        if ((r135 instanceof EntranceInfoWriteConfig) == true) goto L42;
        r135 = null;
    L42:
        r107 = (EntranceInfoWriteConfig) r135;     // Catch: Throwable -> L59
    L44:
        if ((r106 instanceof JSONObject) == false) goto L46;
    L183:
        Object r136 = SDKSettingsCacheManager.a().fromJson(r106.toString(), EntranceInfoWriteConfig.class);     // Catch: Throwable -> L52
        if ((r136 instanceof EntranceInfoWriteConfig) == true) goto L50;
        r136 = null;
    L50:
        Object r137 = Result.m9449constructorimpl((EntranceInfoWriteConfig) r136);     // Catch: Throwable -> L52
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

    @SettingPanel("新版电商主播管理页Scheme配置")
    public static final vh.a j() {
        int r100 = p.f45243a;
        Object r101 = new vh.a();
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r103 = jj4.b.f499326b;     // Catch: Throwable -> L7
        Object r104 = jj4.a.a("ecom_anchor_manage_scheme", vh.a.class, r101, false);     // Catch: Throwable -> L7
        if (r104 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return (vh.a) r104;
    L7:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Object r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r106) == true) goto L12;
        r101 = r106;
    L12:
        r104 = r101;
        goto L14
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SettingPanel("entrance_info 白名单配置")
    public static final EntranceInfoReportConfig j0() {
        int r100 = j.f43647a;
        Object r101 = null;
        Object r102 = new EntranceInfoReportConfig(0, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        int r103 = com.bytedance.android.ec.base.settings.b.f42814a;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L171
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L171
        SDKSettingsCacheManager r105 = SDKSettingsCacheManager.f42812e;     // Catch: Throwable -> L171
        r105.getClass();     // Catch: Throwable -> L58
        Object r106 = SDKSettingsCacheManager.f42809b.get("ec_entrance_info_report_track");     // Catch: Throwable -> L58
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
        if ((r108 instanceof EntranceInfoReportConfig) == true) goto L69;
        r108 = null;
    L69:
        Object r110 = (EntranceInfoReportConfig) r108;     // Catch: Throwable -> L171
        if (r110 != null) goto L76;
        r105.getClass();     // Catch: Throwable -> L171
        Object r111 = SDKSettingsCacheManager.f42808a.get("ec_entrance_info_report_track");     // Catch: Throwable -> L171
        if ((r111 instanceof EntranceInfoReportConfig) == true) goto L75;
        r111 = null;
    L75:
        r110 = (EntranceInfoReportConfig) r111;     // Catch: Throwable -> L171
    L76:
        if (r110 != null) goto L181;
        int r112 = com.bytedance.android.ec.base.settings.g.f42821a;     // Catch: Throwable -> L171
    L158:
        th = move-exception;
        Result.Companion r113 = Result.Companion;     // Catch: Throwable -> L171
        Object r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L171
    L160:
        Object r115 = r114;
        if (Result.m9452exceptionOrNullimpl(r115) != null) goto L188;
    L168:
        r110 = r115;
    L169:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L171
        SDKSettingsCacheManager.e("ec_entrance_info_report_track", r110);     // Catch: Throwable -> L171
        goto L181
    L188:
        r115 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ec_entrance_info_report_track", EntranceInfoReportConfig.class, r102);     // Catch: Throwable -> L165
    L166:
        if (r115 != null) goto L168;
        r110 = r102;
    L165:
        r115 = r102;
        goto L166
    L194:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L132
        Object r116 = SDKSettingsCacheManager.f42809b.get("ec_entrance_info_report_track");     // Catch: Throwable -> L132
        if (r116 != null) goto L84;
    L129:
        Object r117 = null;
    L130:
        Object r118 = Result.m9449constructorimpl(r117);     // Catch: Throwable -> L132
    L134:
        Throwable r119 = Result.m9452exceptionOrNullimpl(r118);     // Catch: Throwable -> L158
        if (r119 == null) goto L138;
        EnsureManager.ensureNotReachHere(r119);     // Catch: Throwable -> L158
    L138:
        if (Result.m9455isFailureimpl(r118) == false) goto L141;
        r118 = null;
    L141:
        if ((r118 instanceof EntranceInfoReportConfig) == true) goto L143;
        r118 = null;
    L143:
        r115 = (EntranceInfoReportConfig) r118;     // Catch: Throwable -> L158
        if (r115 != null) goto L168;
        jj4.b r120 = jj4.b.f499326b;     // Catch: Throwable -> L158
        Object r121 = jj4.a.a("ec_entrance_info_report_track", EntranceInfoReportConfig.class, r102, false);     // Catch: Throwable -> L158
        if (r121 != null) goto L150;
        Intrinsics.throwNpe();     // Catch: Throwable -> L158
    L150:
        if ((r121 instanceof EntranceInfoReportConfig) == false) goto L153;
        r101 = r121;
    L153:
        Object r122 = (EntranceInfoReportConfig) r101;     // Catch: Throwable -> L158
        if (r122 != null) goto L156;
        r122 = r102;
    L156:
        r114 = Result.m9449constructorimpl(r122);     // Catch: Throwable -> L158
    L84:
        if ((r116 instanceof EntranceInfoReportConfig) == true) goto L86;
        Object r123 = null;
    L87:
        r117 = (EntranceInfoReportConfig) r123;     // Catch: Throwable -> L132
        if (r117 != null) goto L130;
        if ((r116 instanceof Number) == false) goto L117;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(EntranceInfoReportConfig.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L99;
        Float r124 = Float.valueOf(((Number) r116).floatValue());     // Catch: Throwable -> L132
        if ((r124 instanceof EntranceInfoReportConfig) == true) goto L97;
        r124 = null;
    L97:
        r117 = (EntranceInfoReportConfig) r124;     // Catch: Throwable -> L132
        goto L130
    L99:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(EntranceInfoReportConfig.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L105;
        Double r125 = Double.valueOf(((Number) r116).doubleValue());     // Catch: Throwable -> L132
        if ((r125 instanceof EntranceInfoReportConfig) == true) goto L103;
        r125 = null;
    L103:
        r117 = (EntranceInfoReportConfig) r125;     // Catch: Throwable -> L132
        goto L130
    L105:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(EntranceInfoReportConfig.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L111;
        Integer r126 = Integer.valueOf(((Number) r116).intValue());     // Catch: Throwable -> L132
        if ((r126 instanceof EntranceInfoReportConfig) == true) goto L109;
        r126 = null;
    L109:
        r117 = (EntranceInfoReportConfig) r126;     // Catch: Throwable -> L132
        goto L130
    L111:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(EntranceInfoReportConfig.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L117;
        Long r127 = Long.valueOf(((Number) r116).longValue());     // Catch: Throwable -> L132
        if ((r127 instanceof EntranceInfoReportConfig) == true) goto L115;
        r127 = null;
    L115:
        r117 = (EntranceInfoReportConfig) r127;     // Catch: Throwable -> L132
    L117:
        if ((r116 instanceof JSONObject) == false) goto L119;
    L186:
        Object r128 = SDKSettingsCacheManager.a().fromJson(r116.toString(), EntranceInfoReportConfig.class);     // Catch: Throwable -> L125
        if ((r128 instanceof EntranceInfoReportConfig) == true) goto L123;
        r128 = null;
    L123:
        Object r129 = Result.m9449constructorimpl((EntranceInfoReportConfig) r128);     // Catch: Throwable -> L125
    L127:
        r117 = r129;
        if (Result.m9455isFailureimpl(r117) == false) goto L130;
    L125:
        th = move-exception;
        Result.Companion r130 = Result.Companion;     // Catch: Throwable -> L132
        r129 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L132
        goto L127
    L119:
        if ((r116 instanceof JSONArray) == false) goto L129;
    L86:
        r123 = r116;
    L132:
        th = move-exception;
        Result.Companion r131 = Result.Companion;     // Catch: Throwable -> L158
        r118 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L158
    L181:
        return (EntranceInfoReportConfig) r110;
    L10:
        if ((r106 instanceof EntranceInfoReportConfig) == true) goto L12;
        Object r132 = null;
    L13:
        r107 = (EntranceInfoReportConfig) r132;     // Catch: Throwable -> L58
        if (r107 != null) goto L56;
        if ((r106 instanceof Number) == false) goto L43;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(EntranceInfoReportConfig.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L25;
        Float r133 = Float.valueOf(((Number) r106).floatValue());     // Catch: Throwable -> L58
        if ((r133 instanceof EntranceInfoReportConfig) == true) goto L23;
        r133 = null;
    L23:
        r107 = (EntranceInfoReportConfig) r133;     // Catch: Throwable -> L58
        goto L56
    L25:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(EntranceInfoReportConfig.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L31;
        Double r134 = Double.valueOf(((Number) r106).doubleValue());     // Catch: Throwable -> L58
        if ((r134 instanceof EntranceInfoReportConfig) == true) goto L29;
        r134 = null;
    L29:
        r107 = (EntranceInfoReportConfig) r134;     // Catch: Throwable -> L58
        goto L56
    L31:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(EntranceInfoReportConfig.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L37;
        Integer r135 = Integer.valueOf(((Number) r106).intValue());     // Catch: Throwable -> L58
        if ((r135 instanceof EntranceInfoReportConfig) == true) goto L35;
        r135 = null;
    L35:
        r107 = (EntranceInfoReportConfig) r135;     // Catch: Throwable -> L58
        goto L56
    L37:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(EntranceInfoReportConfig.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L43;
        Long r136 = Long.valueOf(((Number) r106).longValue());     // Catch: Throwable -> L58
        if ((r136 instanceof EntranceInfoReportConfig) == true) goto L41;
        r136 = null;
    L41:
        r107 = (EntranceInfoReportConfig) r136;     // Catch: Throwable -> L58
    L43:
        if ((r106 instanceof JSONObject) == false) goto L45;
    L192:
        Object r137 = SDKSettingsCacheManager.a().fromJson(r106.toString(), EntranceInfoReportConfig.class);     // Catch: Throwable -> L51
        if ((r137 instanceof EntranceInfoReportConfig) == true) goto L49;
        r137 = null;
    L49:
        Object r138 = Result.m9449constructorimpl((EntranceInfoReportConfig) r137);     // Catch: Throwable -> L51
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

    @SettingPanel("Android 提单页自定义事件抽象化")
    public static final int k() {
        int r100 = p.f45243a;
        Object r101 = 0;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r103 = jj4.b.f499326b;     // Catch: Throwable -> L7
        Object r104 = jj4.a.a("buy_now_self_event_refactor", Integer.class, r101, false);     // Catch: Throwable -> L7
        if (r104 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return ((Number) r104).intValue();
    L7:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Object r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r106) == true) goto L12;
        r101 = r106;
    L12:
        r104 = r101;
        goto L14
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SettingPanel("entrance_info 白名单配置")
    public static final EntranceInfoWhiteListConfig k0() {
        int r100 = j.f43647a;
        Object r101 = null;
        Object r102 = new EntranceInfoWhiteListConfig(0 == true ? 1 : 0, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        int r103 = com.bytedance.android.ec.base.settings.b.f42814a;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L171
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L171
        SDKSettingsCacheManager r105 = SDKSettingsCacheManager.f42812e;     // Catch: Throwable -> L171
        r105.getClass();     // Catch: Throwable -> L58
        Object r106 = SDKSettingsCacheManager.f42809b.get("entrance_info_white_list_config");     // Catch: Throwable -> L58
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
        if ((r108 instanceof EntranceInfoWhiteListConfig) == true) goto L69;
        r108 = null;
    L69:
        Object r110 = (EntranceInfoWhiteListConfig) r108;     // Catch: Throwable -> L171
        if (r110 != null) goto L76;
        r105.getClass();     // Catch: Throwable -> L171
        Object r111 = SDKSettingsCacheManager.f42808a.get("entrance_info_white_list_config");     // Catch: Throwable -> L171
        if ((r111 instanceof EntranceInfoWhiteListConfig) == true) goto L75;
        r111 = null;
    L75:
        r110 = (EntranceInfoWhiteListConfig) r111;     // Catch: Throwable -> L171
    L76:
        if (r110 != null) goto L181;
        int r112 = com.bytedance.android.ec.base.settings.g.f42821a;     // Catch: Throwable -> L171
    L158:
        th = move-exception;
        Result.Companion r113 = Result.Companion;     // Catch: Throwable -> L171
        Object r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L171
    L160:
        Object r115 = r114;
        if (Result.m9452exceptionOrNullimpl(r115) != null) goto L188;
    L168:
        r110 = r115;
    L169:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L171
        SDKSettingsCacheManager.e("entrance_info_white_list_config", r110);     // Catch: Throwable -> L171
        goto L181
    L188:
        r115 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("entrance_info_white_list_config", EntranceInfoWhiteListConfig.class, r102);     // Catch: Throwable -> L165
    L166:
        if (r115 != null) goto L168;
        r110 = r102;
    L165:
        r115 = r102;
        goto L166
    L194:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L132
        Object r116 = SDKSettingsCacheManager.f42809b.get("entrance_info_white_list_config");     // Catch: Throwable -> L132
        if (r116 != null) goto L84;
    L129:
        Object r117 = null;
    L130:
        Object r118 = Result.m9449constructorimpl(r117);     // Catch: Throwable -> L132
    L134:
        Throwable r119 = Result.m9452exceptionOrNullimpl(r118);     // Catch: Throwable -> L158
        if (r119 == null) goto L138;
        EnsureManager.ensureNotReachHere(r119);     // Catch: Throwable -> L158
    L138:
        if (Result.m9455isFailureimpl(r118) == false) goto L141;
        r118 = null;
    L141:
        if ((r118 instanceof EntranceInfoWhiteListConfig) == true) goto L143;
        r118 = null;
    L143:
        r115 = (EntranceInfoWhiteListConfig) r118;     // Catch: Throwable -> L158
        if (r115 != null) goto L168;
        jj4.b r120 = jj4.b.f499326b;     // Catch: Throwable -> L158
        Object r121 = jj4.a.a("entrance_info_white_list_config", EntranceInfoWhiteListConfig.class, r102, false);     // Catch: Throwable -> L158
        if (r121 != null) goto L150;
        Intrinsics.throwNpe();     // Catch: Throwable -> L158
    L150:
        if ((r121 instanceof EntranceInfoWhiteListConfig) == false) goto L153;
        r101 = r121;
    L153:
        Object r122 = (EntranceInfoWhiteListConfig) r101;     // Catch: Throwable -> L158
        if (r122 != null) goto L156;
        r122 = r102;
    L156:
        r114 = Result.m9449constructorimpl(r122);     // Catch: Throwable -> L158
    L84:
        if ((r116 instanceof EntranceInfoWhiteListConfig) == true) goto L86;
        Object r123 = null;
    L87:
        r117 = (EntranceInfoWhiteListConfig) r123;     // Catch: Throwable -> L132
        if (r117 != null) goto L130;
        if ((r116 instanceof Number) == false) goto L117;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(EntranceInfoWhiteListConfig.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L99;
        Float r124 = Float.valueOf(((Number) r116).floatValue());     // Catch: Throwable -> L132
        if ((r124 instanceof EntranceInfoWhiteListConfig) == true) goto L97;
        r124 = null;
    L97:
        r117 = (EntranceInfoWhiteListConfig) r124;     // Catch: Throwable -> L132
        goto L130
    L99:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(EntranceInfoWhiteListConfig.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L105;
        Double r125 = Double.valueOf(((Number) r116).doubleValue());     // Catch: Throwable -> L132
        if ((r125 instanceof EntranceInfoWhiteListConfig) == true) goto L103;
        r125 = null;
    L103:
        r117 = (EntranceInfoWhiteListConfig) r125;     // Catch: Throwable -> L132
        goto L130
    L105:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(EntranceInfoWhiteListConfig.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L111;
        Integer r126 = Integer.valueOf(((Number) r116).intValue());     // Catch: Throwable -> L132
        if ((r126 instanceof EntranceInfoWhiteListConfig) == true) goto L109;
        r126 = null;
    L109:
        r117 = (EntranceInfoWhiteListConfig) r126;     // Catch: Throwable -> L132
        goto L130
    L111:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(EntranceInfoWhiteListConfig.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L117;
        Long r127 = Long.valueOf(((Number) r116).longValue());     // Catch: Throwable -> L132
        if ((r127 instanceof EntranceInfoWhiteListConfig) == true) goto L115;
        r127 = null;
    L115:
        r117 = (EntranceInfoWhiteListConfig) r127;     // Catch: Throwable -> L132
    L117:
        if ((r116 instanceof JSONObject) == false) goto L119;
    L186:
        Object r128 = SDKSettingsCacheManager.a().fromJson(r116.toString(), EntranceInfoWhiteListConfig.class);     // Catch: Throwable -> L125
        if ((r128 instanceof EntranceInfoWhiteListConfig) == true) goto L123;
        r128 = null;
    L123:
        Object r129 = Result.m9449constructorimpl((EntranceInfoWhiteListConfig) r128);     // Catch: Throwable -> L125
    L127:
        r117 = r129;
        if (Result.m9455isFailureimpl(r117) == false) goto L130;
    L125:
        th = move-exception;
        Result.Companion r130 = Result.Companion;     // Catch: Throwable -> L132
        r129 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L132
        goto L127
    L119:
        if ((r116 instanceof JSONArray) == false) goto L129;
    L86:
        r123 = r116;
    L132:
        th = move-exception;
        Result.Companion r131 = Result.Companion;     // Catch: Throwable -> L158
        r118 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L158
    L181:
        return (EntranceInfoWhiteListConfig) r110;
    L10:
        if ((r106 instanceof EntranceInfoWhiteListConfig) == true) goto L12;
        Object r132 = null;
    L13:
        r107 = (EntranceInfoWhiteListConfig) r132;     // Catch: Throwable -> L58
        if (r107 != null) goto L56;
        if ((r106 instanceof Number) == false) goto L43;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(EntranceInfoWhiteListConfig.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L25;
        Float r133 = Float.valueOf(((Number) r106).floatValue());     // Catch: Throwable -> L58
        if ((r133 instanceof EntranceInfoWhiteListConfig) == true) goto L23;
        r133 = null;
    L23:
        r107 = (EntranceInfoWhiteListConfig) r133;     // Catch: Throwable -> L58
        goto L56
    L25:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(EntranceInfoWhiteListConfig.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L31;
        Double r134 = Double.valueOf(((Number) r106).doubleValue());     // Catch: Throwable -> L58
        if ((r134 instanceof EntranceInfoWhiteListConfig) == true) goto L29;
        r134 = null;
    L29:
        r107 = (EntranceInfoWhiteListConfig) r134;     // Catch: Throwable -> L58
        goto L56
    L31:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(EntranceInfoWhiteListConfig.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L37;
        Integer r135 = Integer.valueOf(((Number) r106).intValue());     // Catch: Throwable -> L58
        if ((r135 instanceof EntranceInfoWhiteListConfig) == true) goto L35;
        r135 = null;
    L35:
        r107 = (EntranceInfoWhiteListConfig) r135;     // Catch: Throwable -> L58
        goto L56
    L37:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(EntranceInfoWhiteListConfig.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L43;
        Long r136 = Long.valueOf(((Number) r106).longValue());     // Catch: Throwable -> L58
        if ((r136 instanceof EntranceInfoWhiteListConfig) == true) goto L41;
        r136 = null;
    L41:
        r107 = (EntranceInfoWhiteListConfig) r136;     // Catch: Throwable -> L58
    L43:
        if ((r106 instanceof JSONObject) == false) goto L45;
    L192:
        Object r137 = SDKSettingsCacheManager.a().fromJson(r106.toString(), EntranceInfoWhiteListConfig.class);     // Catch: Throwable -> L51
        if ((r137 instanceof EntranceInfoWhiteListConfig) == true) goto L49;
        r137 = null;
    L49:
        Object r138 = Result.m9449constructorimpl((EntranceInfoWhiteListConfig) r137);     // Catch: Throwable -> L51
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

    @SettingPanel("电商VmSdk实验开关")
    public static final boolean l() {
        int r100 = j.f43647a;
        Object r101 = Boolean.FALSE;
        int r102 = com.bytedance.android.ec.base.settings.b.f42814a;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L172
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L172
        SDKSettingsCacheManager r104 = SDKSettingsCacheManager.f42812e;     // Catch: Throwable -> L172
        Object r105 = null;
        r104.getClass();     // Catch: Throwable -> L59
        Object r106 = SDKSettingsCacheManager.f42809b.get("ecom_enable_vmsdk_params_verify");     // Catch: Throwable -> L59
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
        Object r111 = SDKSettingsCacheManager.f42808a.get("ecom_enable_vmsdk_params_verify");     // Catch: Throwable -> L172
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
        SDKSettingsCacheManager.e("ecom_enable_vmsdk_params_verify", r110);     // Catch: Throwable -> L172
        goto L182
    L185:
        r114 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ecom_enable_vmsdk_params_verify", Boolean.class, r101);     // Catch: Throwable -> L166
    L167:
        if (r114 != null) goto L169;
        r110 = r101;
    L166:
        r114 = r101;
        goto L167
    L191:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L133
        Object r115 = SDKSettingsCacheManager.f42809b.get("ecom_enable_vmsdk_params_verify");     // Catch: Throwable -> L133
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
        Object r120 = jj4.a.a("ecom_enable_vmsdk_params_verify", Boolean.class, r101, false);     // Catch: Throwable -> L159
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

    /* JADX WARN: Multi-variable type inference failed */
    @SettingPanel("提单页 参数校验接入 增加")
    public static final BuyNowSettingConfig l0() {
        int r100 = p.f45243a;
        boolean r101 = false;
        Object r102 = new BuyNowSettingConfig(r101, null, 3, 0 == true ? 1 : 0);
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r104 = jj4.b.f499326b;     // Catch: Throwable -> L7
        Object r105 = jj4.a.a("iesec_buynow_config", BuyNowSettingConfig.class, r102, false);     // Catch: Throwable -> L7
        if (r105 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return (BuyNowSettingConfig) r105;
    L7:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        Object r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r107) == true) goto L12;
        r102 = r107;
    L12:
        r105 = r102;
        goto L14
    }

    @SettingPanel("电商网络监控path白名单")
    public static final String m() {
        int r100 = j.f43647a;
        Object r101 = "{\"paths\":[\"/aweme/v2/shop/promotion/pack/\"]}";
        int r102 = com.bytedance.android.ec.base.settings.b.f42814a;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L172
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L172
        SDKSettingsCacheManager r104 = SDKSettingsCacheManager.f42812e;     // Catch: Throwable -> L172
        Object r105 = null;
        r104.getClass();     // Catch: Throwable -> L59
        Object r106 = SDKSettingsCacheManager.f42809b.get("ecom_network_monitor_switcher");     // Catch: Throwable -> L59
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
        Object r111 = SDKSettingsCacheManager.f42808a.get("ecom_network_monitor_switcher");     // Catch: Throwable -> L172
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
        SDKSettingsCacheManager.e("ecom_network_monitor_switcher", r110);     // Catch: Throwable -> L172
        goto L182
    L185:
        r114 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ecom_network_monitor_switcher", String.class, "{\"paths\":[\"/aweme/v2/shop/promotion/pack/\"]}");     // Catch: Throwable -> L166
    L167:
        if (r114 != null) goto L169;
        r110 = "{\"paths\":[\"/aweme/v2/shop/promotion/pack/\"]}";
    L166:
        r114 = "{\"paths\":[\"/aweme/v2/shop/promotion/pack/\"]}";
        goto L167
    L191:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L133
        Object r115 = SDKSettingsCacheManager.f42809b.get("ecom_network_monitor_switcher");     // Catch: Throwable -> L133
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
        Object r120 = jj4.a.a("ecom_network_monitor_switcher", String.class, "{\"paths\":[\"/aweme/v2/shop/promotion/pack/\"]}", false);     // Catch: Throwable -> L159
        if (r120 != null) goto L151;
        Intrinsics.throwNpe();     // Catch: Throwable -> L159
    L151:
        if ((r120 instanceof String) == false) goto L154;
        r105 = r120;
    L154:
        String r121 = (String) r105;     // Catch: Throwable -> L159
        if (r121 != null) goto L157;
        r121 = "{\"paths\":[\"/aweme/v2/shop/promotion/pack/\"]}";
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

    @SettingPanel("电商优惠券面板schema下发")
    public static final String m0() {
        int r100 = p.f45243a;
        Object r101 = "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source%2Fwebcast%2Fecom%2Flynx%2Ffe_reactlynx_ecommerce_coupon_panel%2Fapp%2Ftemplate.js&type=popup&gravity=bottom&add_safe_area_height=0&height_percent=73&top_level=1&mask_alpha=0.5&use_real_screen_height=1";
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r103 = jj4.b.f499326b;     // Catch: Throwable -> L7
        Object r104 = jj4.a.a("iesec_coupon_panel_schema", String.class, "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source%2Fwebcast%2Fecom%2Flynx%2Ffe_reactlynx_ecommerce_coupon_panel%2Fapp%2Ftemplate.js&type=popup&gravity=bottom&add_safe_area_height=0&height_percent=73&top_level=1&mask_alpha=0.5&use_real_screen_height=1", false);     // Catch: Throwable -> L7
        if (r104 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return (String) r104;
    L7:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Object r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r106) == true) goto L12;
        r101 = r106;
    L12:
        r104 = r101;
        goto L14
    }

    @SettingPanel("电商商详直播容器Schema下发")
    public static final String n0() {
        int r100 = p.f45243a;
        Object r101 = SliceInitService.DEFAULT_SWITCH;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r103 = jj4.b.f499326b;     // Catch: Throwable -> L7
        Object r104 = jj4.a.a("iesec_goodsdetail_hybrid_setting", String.class, SliceInitService.DEFAULT_SWITCH, false);     // Catch: Throwable -> L7
        if (r104 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return (String) r104;
    L7:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Object r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r106) == true) goto L12;
        r101 = r106;
    L12:
        r104 = r101;
        goto L14
    }

    @SettingPanel("异步收银台埋点后置开关")
    public static boolean o() {
        int r100 = j.f43647a;
        Object r101 = Boolean.TRUE;
        int r102 = com.bytedance.android.ec.base.settings.b.f42814a;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L172
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L172
        SDKSettingsCacheManager r104 = SDKSettingsCacheManager.f42812e;     // Catch: Throwable -> L172
        Object r105 = null;
        r104.getClass();     // Catch: Throwable -> L59
        Object r106 = SDKSettingsCacheManager.f42809b.get("ec_buy_now_async_tracker_delay");     // Catch: Throwable -> L59
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
        Object r111 = SDKSettingsCacheManager.f42808a.get("ec_buy_now_async_tracker_delay");     // Catch: Throwable -> L172
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
        SDKSettingsCacheManager.e("ec_buy_now_async_tracker_delay", r110);     // Catch: Throwable -> L172
        goto L182
    L185:
        r114 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ec_buy_now_async_tracker_delay", Boolean.class, r101);     // Catch: Throwable -> L166
    L167:
        if (r114 != null) goto L169;
        r110 = r101;
    L166:
        r114 = r101;
        goto L167
    L191:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L133
        Object r115 = SDKSettingsCacheManager.f42809b.get("ec_buy_now_async_tracker_delay");     // Catch: Throwable -> L133
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
        Object r120 = jj4.a.a("ec_buy_now_async_tracker_delay", Boolean.class, r101, false);     // Catch: Throwable -> L159
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

    @SettingPanel("商详找相似入口优化-已固化")
    public static final int o0() {
        int r100 = com.bytedance.android.ec.base.settings.b.f42814a;
        int r101 = com.bytedance.android.ec.core.abtest.e.f43640a;
        Object r102 = com.bytedance.android.ec.core.abtest.e.a(2, 0);
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L166
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L166
        SDKSettingsCacheManager r104 = SDKSettingsCacheManager.f42812e;     // Catch: Throwable -> L166
        Object r105 = null;
        r104.getClass();     // Catch: Throwable -> L56
        Object r106 = SDKSettingsCacheManager.f42809b.get("iesec_pdp_find_same_opt");     // Catch: Throwable -> L56
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
        Object r111 = SDKSettingsCacheManager.f42808a.get("iesec_pdp_find_same_opt");     // Catch: Throwable -> L166
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
    L155:
        Object r115 = r114;
        if (Result.m9452exceptionOrNullimpl(r115) != null) goto L187;
    L163:
        r110 = r115;
    L164:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L166
        SDKSettingsCacheManager.e("iesec_pdp_find_same_opt", r110);     // Catch: Throwable -> L166
        goto L176
    L187:
        r115 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("iesec_pdp_find_same_opt", Integer.class, r102);     // Catch: Throwable -> L160
    L161:
        if (r115 != null) goto L163;
        r110 = r102;
    L160:
        r115 = r102;
        goto L161
    L179:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L127
        Object r116 = SDKSettingsCacheManager.f42809b.get("iesec_pdp_find_same_opt");     // Catch: Throwable -> L127
        if (r116 != null) goto L82;
    L124:
        Object r117 = null;
    L125:
        Object r118 = Result.m9449constructorimpl(r117);     // Catch: Throwable -> L127
    L129:
        Throwable r119 = Result.m9452exceptionOrNullimpl(r118);     // Catch: Throwable -> L153
        if (r119 == null) goto L133;
        EnsureManager.ensureNotReachHere(r119);     // Catch: Throwable -> L153
    L133:
        if (Result.m9455isFailureimpl(r118) == false) goto L136;
        r118 = null;
    L136:
        if ((r118 instanceof Integer) == true) goto L138;
        r118 = null;
    L138:
        r115 = (Integer) r118;     // Catch: Throwable -> L153
        if (r115 != null) goto L163;
        jj4.b r120 = jj4.b.f499326b;     // Catch: Throwable -> L153
        Object r121 = jj4.a.a("iesec_pdp_find_same_opt", Integer.class, r102, false);     // Catch: Throwable -> L153
        if (r121 != null) goto L145;
        Intrinsics.throwNpe();     // Catch: Throwable -> L153
    L145:
        if ((r121 instanceof Integer) == false) goto L148;
        r105 = r121;
    L148:
        Object r122 = (Integer) r105;     // Catch: Throwable -> L153
        if (r122 != null) goto L151;
        r122 = r102;
    L151:
        r114 = Result.m9449constructorimpl(r122);     // Catch: Throwable -> L153
    L82:
        if ((r116 instanceof Integer) == true) goto L84;
        Object r123 = null;
    L85:
        r117 = (Integer) r123;     // Catch: Throwable -> L127
        if (r117 != null) goto L125;
        if ((r116 instanceof Number) == false) goto L112;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r124 = Float.valueOf(((Number) r116).floatValue());     // Catch: Throwable -> L127
        if ((r124 instanceof Integer) == true) goto L95;
        r124 = null;
    L95:
        r117 = (Integer) r124;     // Catch: Throwable -> L127
        goto L125
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r125 = Double.valueOf(((Number) r116).doubleValue());     // Catch: Throwable -> L127
        if ((r125 instanceof Integer) == true) goto L101;
        r125 = null;
    L101:
        r117 = (Integer) r125;     // Catch: Throwable -> L127
        goto L125
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L106;
        r117 = Integer.valueOf(((Number) r116).intValue());     // Catch: Throwable -> L127
        goto L125
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L112;
        Long r126 = Long.valueOf(((Number) r116).longValue());     // Catch: Throwable -> L127
        if ((r126 instanceof Integer) == true) goto L110;
        r126 = null;
    L110:
        r117 = (Integer) r126;     // Catch: Throwable -> L127
    L112:
        if ((r116 instanceof JSONObject) == false) goto L114;
    L185:
        Object r127 = SDKSettingsCacheManager.a().fromJson(r116.toString(), Integer.class);     // Catch: Throwable -> L120
        if ((r127 instanceof Integer) == true) goto L118;
        r127 = null;
    L118:
        Object r128 = Result.m9449constructorimpl((Integer) r127);     // Catch: Throwable -> L120
    L122:
        r117 = r128;
        if (Result.m9455isFailureimpl(r117) == false) goto L125;
    L120:
        th = move-exception;
        Result.Companion r129 = Result.Companion;     // Catch: Throwable -> L127
        r128 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L127
        goto L122
    L114:
        if ((r116 instanceof JSONArray) == false) goto L124;
    L84:
        r123 = r116;
    L127:
        th = move-exception;
        Result.Companion r130 = Result.Companion;     // Catch: Throwable -> L153
        r118 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L153
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
    L183:
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
        r102 = r140;
    L174:
        r110 = r102;
        goto L176
    }

    @SettingPanel("na购物车页面配置")
    public static final com.bytedance.android.ec.core.cart.c p() {
        int r100 = p.f45243a;
        Object r101 = new com.bytedance.android.ec.core.cart.c(null);
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r103 = jj4.b.f499326b;     // Catch: Throwable -> L7
        Object r104 = jj4.a.a("iesec_cart_config", com.bytedance.android.ec.core.cart.c.class, r101, false);     // Catch: Throwable -> L7
        if (r104 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return (com.bytedance.android.ec.core.cart.c) r104;
    L7:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Object r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r106) == true) goto L12;
        r101 = r106;
    L12:
        r104 = r101;
        goto L14
    }

    @SettingPanel("商详半屏分场景(ecom_scene_id)的开关配置，包括是否一次下滑关闭商详、1:1.5的类目ID等")
    public static final Map<String, Object> p0() {
        int r100 = j.f43647a;
        Object r101 = MapsKt.emptyMap();
        int r102 = com.bytedance.android.ec.base.settings.b.f42814a;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L174
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L174
        SDKSettingsCacheManager r104 = SDKSettingsCacheManager.f42812e;     // Catch: Throwable -> L174
        Object r105 = null;
        r104.getClass();     // Catch: Throwable -> L59
        Object r106 = SDKSettingsCacheManager.f42809b.get("iesec_pdp_half_panel_scene_config");     // Catch: Throwable -> L59
        if (r106 != null) goto L11;
    L56:
        Object r107 = null;
    L57:
        Object r108 = Result.m9449constructorimpl(r107);     // Catch: Throwable -> L59
    L61:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);     // Catch: Throwable -> L174
        if (r109 == null) goto L65;
        EnsureManager.ensureNotReachHere(r109);     // Catch: Throwable -> L174
    L65:
        if (Result.m9455isFailureimpl(r108) == false) goto L68;
        r108 = null;
    L68:
        if ((r108 instanceof Map) == true) goto L70;
        r108 = null;
    L70:
        Object r110 = (Map) r108;     // Catch: Throwable -> L174
        if (r110 != null) goto L77;
        r104.getClass();     // Catch: Throwable -> L174
        Object r111 = SDKSettingsCacheManager.f42808a.get("iesec_pdp_half_panel_scene_config");     // Catch: Throwable -> L174
        if ((r111 instanceof Map) == true) goto L76;
        r111 = null;
    L76:
        r110 = (Map) r111;     // Catch: Throwable -> L174
    L77:
        if (r110 != null) goto L184;
        int r112 = com.bytedance.android.ec.base.settings.g.f42821a;     // Catch: Throwable -> L174
    L161:
        th = move-exception;
        Result.Companion r113 = Result.Companion;     // Catch: Throwable -> L174
        Object r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L174
    L164:
        if (Result.m9452exceptionOrNullimpl(r114) != null) goto L193;
    L171:
        r110 = r114;
    L172:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L174
        SDKSettingsCacheManager.e("iesec_pdp_half_panel_scene_config", r110);     // Catch: Throwable -> L174
        goto L184
    L193:
        r114 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("iesec_pdp_half_panel_scene_config", Map.class, r101);     // Catch: Throwable -> L168
    L169:
        if (r114 != null) goto L171;
        r110 = r101;
    L168:
        r114 = r101;
        goto L169
    L197:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L133
        Object r115 = SDKSettingsCacheManager.f42809b.get("iesec_pdp_half_panel_scene_config");     // Catch: Throwable -> L133
        if (r115 != null) goto L85;
    L130:
        Object r116 = null;
    L131:
        Object r117 = Result.m9449constructorimpl(r116);     // Catch: Throwable -> L133
    L135:
        Throwable r118 = Result.m9452exceptionOrNullimpl(r117);     // Catch: Throwable -> L161
        if (r118 == null) goto L139;
        EnsureManager.ensureNotReachHere(r118);     // Catch: Throwable -> L161
    L139:
        if (Result.m9455isFailureimpl(r117) == false) goto L142;
        r117 = null;
    L142:
        if ((r117 instanceof Map) == true) goto L144;
        r117 = null;
    L144:
        r114 = (Map) r117;     // Catch: Throwable -> L161
        if (r114 != null) goto L147;
    L149:
        jj4.b r119 = jj4.b.f499326b;     // Catch: Throwable -> L161
        Object r120 = jj4.a.a("iesec_pdp_half_panel_scene_config", Map.class, r101, false);     // Catch: Throwable -> L161
        if (r120 != null) goto L153;
        Intrinsics.throwNpe();     // Catch: Throwable -> L161
    L153:
        if ((r120 instanceof Map) == false) goto L156;
        r105 = r120;
    L156:
        Object r121 = (Map) r105;     // Catch: Throwable -> L161
        if (r121 != null) goto L159;
        r121 = r101;
    L159:
        r114 = Result.m9449constructorimpl(r121);     // Catch: Throwable -> L161
    L147:
        if ((r114 instanceof Map) == false) goto L149;
    L85:
        if ((r115 instanceof Map) == true) goto L87;
        Object r122 = null;
    L88:
        r116 = (Map) r122;     // Catch: Throwable -> L133
        if (r116 != null) goto L131;
        if ((r115 instanceof Number) == false) goto L118;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Map.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L100;
        Float r123 = Float.valueOf(((Number) r115).floatValue());     // Catch: Throwable -> L133
        if ((r123 instanceof Map) == true) goto L98;
        r123 = null;
    L98:
        r116 = (Map) r123;     // Catch: Throwable -> L133
        goto L131
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Map.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L106;
        Double r124 = Double.valueOf(((Number) r115).doubleValue());     // Catch: Throwable -> L133
        if ((r124 instanceof Map) == true) goto L104;
        r124 = null;
    L104:
        r116 = (Map) r124;     // Catch: Throwable -> L133
        goto L131
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Map.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L112;
        Integer r125 = Integer.valueOf(((Number) r115).intValue());     // Catch: Throwable -> L133
        if ((r125 instanceof Map) == true) goto L110;
        r125 = null;
    L110:
        r116 = (Map) r125;     // Catch: Throwable -> L133
        goto L131
    L112:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Map.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L118;
        Long r126 = Long.valueOf(((Number) r115).longValue());     // Catch: Throwable -> L133
        if ((r126 instanceof Map) == true) goto L116;
        r126 = null;
    L116:
        r116 = (Map) r126;     // Catch: Throwable -> L133
    L118:
        if ((r115 instanceof JSONObject) == false) goto L120;
    L189:
        Object r127 = SDKSettingsCacheManager.a().fromJson(r115.toString(), Map.class);     // Catch: Throwable -> L126
        if ((r127 instanceof Map) == true) goto L124;
        r127 = null;
    L124:
        Object r128 = Result.m9449constructorimpl((Map) r127);     // Catch: Throwable -> L126
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
        Result.Companion r130 = Result.Companion;     // Catch: Throwable -> L161
        r117 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L161
    L184:
        return (Map) r110;
    L11:
        if ((r106 instanceof Map) == true) goto L13;
        Object r131 = null;
    L14:
        r107 = (Map) r131;     // Catch: Throwable -> L59
        if (r107 != null) goto L57;
        if ((r106 instanceof Number) == false) goto L44;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Map.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r132 = Float.valueOf(((Number) r106).floatValue());     // Catch: Throwable -> L59
        if ((r132 instanceof Map) == true) goto L24;
        r132 = null;
    L24:
        r107 = (Map) r132;     // Catch: Throwable -> L59
        goto L57
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Map.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r133 = Double.valueOf(((Number) r106).doubleValue());     // Catch: Throwable -> L59
        if ((r133 instanceof Map) == true) goto L30;
        r133 = null;
    L30:
        r107 = (Map) r133;     // Catch: Throwable -> L59
        goto L57
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Map.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L38;
        Integer r134 = Integer.valueOf(((Number) r106).intValue());     // Catch: Throwable -> L59
        if ((r134 instanceof Map) == true) goto L36;
        r134 = null;
    L36:
        r107 = (Map) r134;     // Catch: Throwable -> L59
        goto L57
    L38:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Map.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L44;
        Long r135 = Long.valueOf(((Number) r106).longValue());     // Catch: Throwable -> L59
        if ((r135 instanceof Map) == true) goto L42;
        r135 = null;
    L42:
        r107 = (Map) r135;     // Catch: Throwable -> L59
    L44:
        if ((r106 instanceof JSONObject) == false) goto L46;
    L191:
        Object r136 = SDKSettingsCacheManager.a().fromJson(r106.toString(), Map.class);     // Catch: Throwable -> L52
        if ((r136 instanceof Map) == true) goto L50;
        r136 = null;
    L50:
        Object r137 = Result.m9449constructorimpl((Map) r136);     // Catch: Throwable -> L52
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
        Result.Companion r139 = Result.Companion;     // Catch: Throwable -> L174
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L174
    L174:
        th = move-exception;
        Result.Companion r140 = Result.Companion;
        Object r141 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r142 = Result.m9452exceptionOrNullimpl(r141);
        if (r142 == null) goto L179;
        EnsureManager.ensureNotReachHere(r142);
    L179:
        if (Result.m9455isFailureimpl(r141) == true) goto L182;
        r101 = r141;
    L182:
        r110 = r101;
        goto L184
    }

    @SettingPanel("购物车半屏适配直播开关")
    public static boolean q() {
        int r100 = j.f43647a;
        Object r101 = Boolean.TRUE;
        int r102 = com.bytedance.android.ec.base.settings.b.f42814a;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L172
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L172
        SDKSettingsCacheManager r104 = SDKSettingsCacheManager.f42812e;     // Catch: Throwable -> L172
        Object r105 = null;
        r104.getClass();     // Catch: Throwable -> L59
        Object r106 = SDKSettingsCacheManager.f42809b.get("ec_cart_half_panel_adapt_live");     // Catch: Throwable -> L59
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
        Object r111 = SDKSettingsCacheManager.f42808a.get("ec_cart_half_panel_adapt_live");     // Catch: Throwable -> L172
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
        SDKSettingsCacheManager.e("ec_cart_half_panel_adapt_live", r110);     // Catch: Throwable -> L172
        goto L182
    L185:
        r114 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ec_cart_half_panel_adapt_live", Boolean.class, r101);     // Catch: Throwable -> L166
    L167:
        if (r114 != null) goto L169;
        r110 = r101;
    L166:
        r114 = r101;
        goto L167
    L191:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L133
        Object r115 = SDKSettingsCacheManager.f42809b.get("ec_cart_half_panel_adapt_live");     // Catch: Throwable -> L133
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
        Object r120 = jj4.a.a("ec_cart_half_panel_adapt_live", Boolean.class, r101, false);     // Catch: Throwable -> L159
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

    @SettingPanel("直播间商详增加氛围条")
    public static final boolean q0() {
        int r100 = com.bytedance.android.ec.base.settings.a.f42813a;
        Object r101 = Boolean.FALSE;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L166
        Object r103 = null;
        Object r104 = com.bytedance.android.ec.base.settings.d.f42818c.get("iesec_pdp_live_atmosphere_type_opt");     // Catch: Throwable -> L57
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
        if ((r106 instanceof Boolean) == true) goto L68;
        r106 = null;
    L68:
        Object r108 = (Boolean) r106;     // Catch: Throwable -> L166
        if (r108 != null) goto L75;
        Object r109 = com.bytedance.android.ec.base.settings.d.f42816a.get("iesec_pdp_live_atmosphere_type_opt");     // Catch: Throwable -> L166
        if ((r109 instanceof Boolean) == true) goto L74;
        r109 = null;
    L74:
        r108 = (Boolean) r109;     // Catch: Throwable -> L166
    L75:
        if (r108 != null) goto L176;
        int r110 = com.bytedance.android.ec.base.settings.c.f42815a;     // Catch: Throwable -> L166
        Object r111 = com.bytedance.android.ec.base.settings.d.f42818c.get("iesec_pdp_live_atmosphere_type_opt");     // Catch: Throwable -> L130
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
        if ((r113 instanceof Boolean) == true) goto L141;
        r113 = null;
    L141:
        r108 = (Boolean) r113;     // Catch: Throwable -> L156
        if (r108 != null) goto L164;
        IHybridHostService r115 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L156
        if (r115 == null) goto L147;
        Object r116 = r115.getHostABValue("iesec_pdp_live_atmosphere_type_opt", r101);     // Catch: Throwable -> L156
    L148:
        if (r116 != null) goto L150;
    L155:
        r108 = r101;
        goto L164
    L150:
        if ((r116 instanceof Boolean) == false) goto L153;
        r103 = r116;
    L153:
        Object r117 = (Boolean) r103;     // Catch: Throwable -> L156
        if (r117 == null) goto L155;
    L163:
        r108 = r117;
        goto L164
    L147:
        r116 = null;
    L164:
        com.bytedance.android.ec.base.settings.d.d("iesec_pdp_live_atmosphere_type_opt", r108);     // Catch: Throwable -> L166
        goto L176
    L82:
        if ((r111 instanceof Boolean) == true) goto L84;
        Object r118 = null;
    L85:
        r112 = (Boolean) r118;     // Catch: Throwable -> L130
        if (r112 != null) goto L128;
        if ((r111 instanceof Number) == false) goto L115;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r119 = Float.valueOf(((Number) r111).floatValue());     // Catch: Throwable -> L130
        if ((r119 instanceof Boolean) == true) goto L95;
        r119 = null;
    L95:
        r112 = (Boolean) r119;     // Catch: Throwable -> L130
        goto L128
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r120 = Double.valueOf(((Number) r111).doubleValue());     // Catch: Throwable -> L130
        if ((r120 instanceof Boolean) == true) goto L101;
        r120 = null;
    L101:
        r112 = (Boolean) r120;     // Catch: Throwable -> L130
        goto L128
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L109;
        Integer r121 = Integer.valueOf(((Number) r111).intValue());     // Catch: Throwable -> L130
        if ((r121 instanceof Boolean) == true) goto L107;
        r121 = null;
    L107:
        r112 = (Boolean) r121;     // Catch: Throwable -> L130
        goto L128
    L109:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L115;
        Long r122 = Long.valueOf(((Number) r111).longValue());     // Catch: Throwable -> L130
        if ((r122 instanceof Boolean) == true) goto L113;
        r122 = null;
    L113:
        r112 = (Boolean) r122;     // Catch: Throwable -> L130
    L115:
        if ((r111 instanceof JSONObject) == false) goto L117;
    L184:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L123
        Object r123 = SDKSettingsCacheManager.a().fromJson(r111.toString(), Boolean.class);     // Catch: Throwable -> L123
        if ((r123 instanceof Boolean) == true) goto L121;
        r123 = null;
    L121:
        Object r124 = Result.m9449constructorimpl((Boolean) r123);     // Catch: Throwable -> L123
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
        r117 = r101;
    L130:
        th = move-exception;
        Result.Companion r128 = Result.Companion;     // Catch: Throwable -> L156
        r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L156
    L176:
        return ((Boolean) r108).booleanValue();
    L9:
        if ((r104 instanceof Boolean) == true) goto L11;
        Object r129 = null;
    L12:
        r105 = (Boolean) r129;     // Catch: Throwable -> L57
        if (r105 != null) goto L55;
        if ((r104 instanceof Number) == false) goto L42;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L24;
        Float r130 = Float.valueOf(((Number) r104).floatValue());     // Catch: Throwable -> L57
        if ((r130 instanceof Boolean) == true) goto L22;
        r130 = null;
    L22:
        r105 = (Boolean) r130;     // Catch: Throwable -> L57
        goto L55
    L24:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L30;
        Double r131 = Double.valueOf(((Number) r104).doubleValue());     // Catch: Throwable -> L57
        if ((r131 instanceof Boolean) == true) goto L28;
        r131 = null;
    L28:
        r105 = (Boolean) r131;     // Catch: Throwable -> L57
        goto L55
    L30:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L36;
        Integer r132 = Integer.valueOf(((Number) r104).intValue());     // Catch: Throwable -> L57
        if ((r132 instanceof Boolean) == true) goto L34;
        r132 = null;
    L34:
        r105 = (Boolean) r132;     // Catch: Throwable -> L57
        goto L55
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L42;
        Long r133 = Long.valueOf(((Number) r104).longValue());     // Catch: Throwable -> L57
        if ((r133 instanceof Boolean) == true) goto L40;
        r133 = null;
    L40:
        r105 = (Boolean) r133;     // Catch: Throwable -> L57
    L42:
        if ((r104 instanceof JSONObject) == false) goto L44;
    L181:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L50
        Object r134 = SDKSettingsCacheManager.a().fromJson(r104.toString(), Boolean.class);     // Catch: Throwable -> L50
        if ((r134 instanceof Boolean) == true) goto L48;
        r134 = null;
    L48:
        Object r135 = Result.m9449constructorimpl((Boolean) r134);     // Catch: Throwable -> L50
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
        goto L176
    }

    @SettingPanel("电商防暴击限制时间配置")
    public static final int r() {
        int r100 = j.f43647a;
        Object r101 = 750;
        int r102 = com.bytedance.android.ec.base.settings.b.f42814a;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L166
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L166
        SDKSettingsCacheManager r104 = SDKSettingsCacheManager.f42812e;     // Catch: Throwable -> L166
        Object r105 = null;
        r104.getClass();     // Catch: Throwable -> L56
        Object r106 = SDKSettingsCacheManager.f42809b.get("ec_client_click_interval_time");     // Catch: Throwable -> L56
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
        Object r111 = SDKSettingsCacheManager.f42808a.get("ec_client_click_interval_time");     // Catch: Throwable -> L166
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
        SDKSettingsCacheManager.e("ec_client_click_interval_time", r110);     // Catch: Throwable -> L166
        goto L176
    L183:
        r114 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ec_client_click_interval_time", Integer.class, r101);     // Catch: Throwable -> L160
    L161:
        if (r114 != null) goto L163;
        r110 = r101;
    L160:
        r114 = r101;
        goto L161
    L189:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L127
        Object r115 = SDKSettingsCacheManager.f42809b.get("ec_client_click_interval_time");     // Catch: Throwable -> L127
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
        Object r120 = jj4.a.a("ec_client_click_interval_time", Integer.class, r101, false);     // Catch: Throwable -> L153
        if (r120 != null) goto L145;
        Intrinsics.throwNpe();     // Catch: Throwable -> L153
    L145:
        if ((r120 instanceof Integer) == false) goto L148;
        r105 = r120;
    L148:
        Object r121 = (Integer) r105;     // Catch: Throwable -> L153
        if (r121 != null) goto L151;
        r121 = r101;
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
    L181:
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
        return ((Number) r110).intValue();
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
    L179:
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
        r101 = r139;
    L174:
        r110 = r101;
        goto L176
    }

    @SettingPanel("电商图片展示面板schema")
    public static String r0() {
        int r100 = p.f45243a;
        Object r101 = "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source%2Fwebcast%2Fecom%2Flynx%2Ffe_reactlynx_ecommerce_images_show_panel%2Fapp%2Ftemplate.js&type=popup&gravity=bottom&add_safe_area_height=0&height_percent=73&top_level=1&use_real_screen_height=1";
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r103 = jj4.b.f499326b;     // Catch: Throwable -> L7
        Object r104 = jj4.a.a("iesec_images_panel_schema", String.class, "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source%2Fwebcast%2Fecom%2Flynx%2Ffe_reactlynx_ecommerce_images_show_panel%2Fapp%2Ftemplate.js&type=popup&gravity=bottom&add_safe_area_height=0&height_percent=73&top_level=1&use_real_screen_height=1", false);     // Catch: Throwable -> L7
        if (r104 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return (String) r104;
    L7:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Object r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r106) == true) goto L12;
        r101 = r106;
    L12:
        r104 = r101;
        goto L14
    }

    @SettingPanel("解决个人页商品收藏页商品卡的长按冲突")
    public static final boolean s() {
        int r100 = j.f43647a;
        Object r101 = Boolean.TRUE;
        int r102 = com.bytedance.android.ec.base.settings.b.f42814a;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L172
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L172
        SDKSettingsCacheManager r104 = SDKSettingsCacheManager.f42812e;     // Catch: Throwable -> L172
        Object r105 = null;
        r104.getClass();     // Catch: Throwable -> L59
        Object r106 = SDKSettingsCacheManager.f42809b.get("ec_collect_long_press_opt");     // Catch: Throwable -> L59
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
        Object r111 = SDKSettingsCacheManager.f42808a.get("ec_collect_long_press_opt");     // Catch: Throwable -> L172
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
        SDKSettingsCacheManager.e("ec_collect_long_press_opt", r110);     // Catch: Throwable -> L172
        goto L182
    L185:
        r114 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ec_collect_long_press_opt", Boolean.class, r101);     // Catch: Throwable -> L166
    L167:
        if (r114 != null) goto L169;
        r110 = r101;
    L166:
        r114 = r101;
        goto L167
    L191:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L133
        Object r115 = SDKSettingsCacheManager.f42809b.get("ec_collect_long_press_opt");     // Catch: Throwable -> L133
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
        Object r120 = jj4.a.a("ec_collect_long_press_opt", Boolean.class, r101, false);     // Catch: Throwable -> L159
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

    @SettingPanel("商详展示弹窗")
    public static final int s0() {
        int r100 = j.f43647a;
        Object r101 = 3;
        int r102 = com.bytedance.android.ec.base.settings.b.f42814a;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L166
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L166
        SDKSettingsCacheManager r104 = SDKSettingsCacheManager.f42812e;     // Catch: Throwable -> L166
        Object r105 = null;
        r104.getClass();     // Catch: Throwable -> L56
        Object r106 = SDKSettingsCacheManager.f42809b.get("ec_disclaimer_optimize");     // Catch: Throwable -> L56
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
        Object r111 = SDKSettingsCacheManager.f42808a.get("ec_disclaimer_optimize");     // Catch: Throwable -> L166
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
        SDKSettingsCacheManager.e("ec_disclaimer_optimize", r110);     // Catch: Throwable -> L166
        goto L176
    L183:
        r114 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ec_disclaimer_optimize", Integer.class, r101);     // Catch: Throwable -> L160
    L161:
        if (r114 != null) goto L163;
        r110 = r101;
    L160:
        r114 = r101;
        goto L161
    L189:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L127
        Object r115 = SDKSettingsCacheManager.f42809b.get("ec_disclaimer_optimize");     // Catch: Throwable -> L127
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
        Object r120 = jj4.a.a("ec_disclaimer_optimize", Integer.class, r101, false);     // Catch: Throwable -> L153
        if (r120 != null) goto L145;
        Intrinsics.throwNpe();     // Catch: Throwable -> L153
    L145:
        if ((r120 instanceof Integer) == false) goto L148;
        r105 = r120;
    L148:
        Object r121 = (Integer) r105;     // Catch: Throwable -> L153
        if (r121 != null) goto L151;
        r121 = r101;
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
    L181:
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
        return ((Number) r110).intValue();
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
    L179:
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
        r101 = r139;
    L174:
        r110 = r101;
        goto L176
    }

    @SettingPanel("收藏组件化页面配置")
    public static final qg.a t() {
        int r100 = p.f45243a;
        Object r101 = new qg.a(0);
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r103 = jj4.b.f499326b;     // Catch: Throwable -> L7
        Object r104 = jj4.a.a("iesec_collect_page_config", qg.a.class, r101, false);     // Catch: Throwable -> L7
        if (r104 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return (qg.a) r104;
    L7:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Object r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r106) == true) goto L12;
        r101 = r106;
    L12:
        r104 = r101;
        goto L14
    }

    @SettingPanel("讲解回放倍速播放和直播入口实验")
    public static final int t0() {
        int r100 = p.f45243a;
        Object r101 = 0;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r103 = jj4.b.f499326b;     // Catch: Throwable -> L7
        Object r104 = jj4.a.a("live_replay_optimize", Integer.class, r101, false);     // Catch: Throwable -> L7
        if (r104 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return ((Number) r104).intValue();
    L7:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Object r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r106) == true) goto L12;
        r101 = r106;
    L12:
        r104 = r101;
        goto L14
    }

    @SettingPanel("商详找同款2.0体验优化-已固化")
    public static final int u() {
        int r100 = p.f45243a;
        int r101 = com.bytedance.android.ec.core.abtest.e.f43640a;
        Object r102 = com.bytedance.android.ec.core.abtest.e.a(3, 1);
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r104 = jj4.b.f499326b;     // Catch: Throwable -> L7
        Object r105 = jj4.a.a("ec_find_same_v2_request_opt", Integer.class, r102, false);     // Catch: Throwable -> L7
        if (r105 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return ((Number) r105).intValue();
    L7:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        Object r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r107) == true) goto L12;
        r102 = r107;
    L12:
        r105 = r102;
        goto L14
    }

    @SettingPanel("商城首页关注tab优化配置")
    public static final String u0() {
        int r100 = p.f45243a;
        Object r101 = SliceInitService.DEFAULT_SWITCH;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r103 = jj4.b.f499326b;     // Catch: Throwable -> L7
        Object r104 = jj4.a.a("mall_shop_moment_config", String.class, SliceInitService.DEFAULT_SWITCH, false);     // Catch: Throwable -> L7
        if (r104 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return (String) r104;
    L7:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Object r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r106) == true) goto L12;
        r101 = r106;
    L12:
        r104 = r101;
        goto L14
    }

    @SettingPanel("字体资源配置")
    public static Map v() {
        int r100 = com.bytedance.android.ec.base.settings.b.f42814a;
        Object r101 = new HashMap();
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L172
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L172
        SDKSettingsCacheManager r103 = SDKSettingsCacheManager.f42812e;     // Catch: Throwable -> L172
        Object r104 = null;
        r103.getClass();     // Catch: Throwable -> L59
        Object r105 = SDKSettingsCacheManager.f42809b.get("ec_font_res_config");     // Catch: Throwable -> L59
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
        Object r110 = SDKSettingsCacheManager.f42808a.get("ec_font_res_config");     // Catch: Throwable -> L172
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
        SDKSettingsCacheManager.e("ec_font_res_config", r109);     // Catch: Throwable -> L172
        goto L182
    L185:
        r113 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ec_font_res_config", HashMap.class, r101);     // Catch: Throwable -> L166
    L167:
        if (r113 != null) goto L169;
        r109 = r101;
    L166:
        r113 = r101;
        goto L167
    L191:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L133
        Object r114 = SDKSettingsCacheManager.f42809b.get("ec_font_res_config");     // Catch: Throwable -> L133
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
        Object r119 = jj4.a.a("ec_font_res_config", HashMap.class, r101, false);     // Catch: Throwable -> L159
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

    @SettingPanel("商详打开二级页设置高度的白名单")
    public static final List<String> v0() {
        int r100 = j.f43647a;
        Object r101 = CollectionsKt.emptyList();
        int r102 = com.bytedance.android.ec.base.settings.b.f42814a;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L174
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L174
        SDKSettingsCacheManager r104 = SDKSettingsCacheManager.f42812e;     // Catch: Throwable -> L174
        Object r105 = null;
        r104.getClass();     // Catch: Throwable -> L59
        Object r106 = SDKSettingsCacheManager.f42809b.get("iesec_pdp_replace_secondary_page_height_percent");     // Catch: Throwable -> L59
        if (r106 != null) goto L11;
    L56:
        Object r107 = null;
    L57:
        Object r108 = Result.m9449constructorimpl(r107);     // Catch: Throwable -> L59
    L61:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);     // Catch: Throwable -> L174
        if (r109 == null) goto L65;
        EnsureManager.ensureNotReachHere(r109);     // Catch: Throwable -> L174
    L65:
        if (Result.m9455isFailureimpl(r108) == false) goto L68;
        r108 = null;
    L68:
        if ((r108 instanceof List) == true) goto L70;
        r108 = null;
    L70:
        Object r110 = (List) r108;     // Catch: Throwable -> L174
        if (r110 != null) goto L77;
        r104.getClass();     // Catch: Throwable -> L174
        Object r111 = SDKSettingsCacheManager.f42808a.get("iesec_pdp_replace_secondary_page_height_percent");     // Catch: Throwable -> L174
        if ((r111 instanceof List) == true) goto L76;
        r111 = null;
    L76:
        r110 = (List) r111;     // Catch: Throwable -> L174
    L77:
        if (r110 != null) goto L184;
        int r112 = com.bytedance.android.ec.base.settings.g.f42821a;     // Catch: Throwable -> L174
    L161:
        th = move-exception;
        Result.Companion r113 = Result.Companion;     // Catch: Throwable -> L174
        Object r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L174
    L164:
        if (Result.m9452exceptionOrNullimpl(r114) != null) goto L193;
    L171:
        r110 = r114;
    L172:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L174
        SDKSettingsCacheManager.e("iesec_pdp_replace_secondary_page_height_percent", r110);     // Catch: Throwable -> L174
        goto L184
    L193:
        r114 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("iesec_pdp_replace_secondary_page_height_percent", List.class, r101);     // Catch: Throwable -> L168
    L169:
        if (r114 != null) goto L171;
        r110 = r101;
    L168:
        r114 = r101;
        goto L169
    L197:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L133
        Object r115 = SDKSettingsCacheManager.f42809b.get("iesec_pdp_replace_secondary_page_height_percent");     // Catch: Throwable -> L133
        if (r115 != null) goto L85;
    L130:
        Object r116 = null;
    L131:
        Object r117 = Result.m9449constructorimpl(r116);     // Catch: Throwable -> L133
    L135:
        Throwable r118 = Result.m9452exceptionOrNullimpl(r117);     // Catch: Throwable -> L161
        if (r118 == null) goto L139;
        EnsureManager.ensureNotReachHere(r118);     // Catch: Throwable -> L161
    L139:
        if (Result.m9455isFailureimpl(r117) == false) goto L142;
        r117 = null;
    L142:
        if ((r117 instanceof List) == true) goto L144;
        r117 = null;
    L144:
        r114 = (List) r117;     // Catch: Throwable -> L161
        if (r114 != null) goto L147;
    L149:
        jj4.b r119 = jj4.b.f499326b;     // Catch: Throwable -> L161
        Object r120 = jj4.a.a("iesec_pdp_replace_secondary_page_height_percent", List.class, r101, false);     // Catch: Throwable -> L161
        if (r120 != null) goto L153;
        Intrinsics.throwNpe();     // Catch: Throwable -> L161
    L153:
        if ((r120 instanceof List) == false) goto L156;
        r105 = r120;
    L156:
        Object r121 = (List) r105;     // Catch: Throwable -> L161
        if (r121 != null) goto L159;
        r121 = r101;
    L159:
        r114 = Result.m9449constructorimpl(r121);     // Catch: Throwable -> L161
    L147:
        if ((r114 instanceof List) == false) goto L149;
    L85:
        if ((r115 instanceof List) == true) goto L87;
        Object r122 = null;
    L88:
        r116 = (List) r122;     // Catch: Throwable -> L133
        if (r116 != null) goto L131;
        if ((r115 instanceof Number) == false) goto L118;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(List.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L100;
        Float r123 = Float.valueOf(((Number) r115).floatValue());     // Catch: Throwable -> L133
        if ((r123 instanceof List) == true) goto L98;
        r123 = null;
    L98:
        r116 = (List) r123;     // Catch: Throwable -> L133
        goto L131
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(List.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L106;
        Double r124 = Double.valueOf(((Number) r115).doubleValue());     // Catch: Throwable -> L133
        if ((r124 instanceof List) == true) goto L104;
        r124 = null;
    L104:
        r116 = (List) r124;     // Catch: Throwable -> L133
        goto L131
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(List.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L112;
        Integer r125 = Integer.valueOf(((Number) r115).intValue());     // Catch: Throwable -> L133
        if ((r125 instanceof List) == true) goto L110;
        r125 = null;
    L110:
        r116 = (List) r125;     // Catch: Throwable -> L133
        goto L131
    L112:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(List.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L118;
        Long r126 = Long.valueOf(((Number) r115).longValue());     // Catch: Throwable -> L133
        if ((r126 instanceof List) == true) goto L116;
        r126 = null;
    L116:
        r116 = (List) r126;     // Catch: Throwable -> L133
    L118:
        if ((r115 instanceof JSONObject) == false) goto L120;
    L189:
        Object r127 = SDKSettingsCacheManager.a().fromJson(r115.toString(), List.class);     // Catch: Throwable -> L126
        if ((r127 instanceof List) == true) goto L124;
        r127 = null;
    L124:
        Object r128 = Result.m9449constructorimpl((List) r127);     // Catch: Throwable -> L126
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
        Result.Companion r130 = Result.Companion;     // Catch: Throwable -> L161
        r117 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L161
    L184:
        return (List) r110;
    L11:
        if ((r106 instanceof List) == true) goto L13;
        Object r131 = null;
    L14:
        r107 = (List) r131;     // Catch: Throwable -> L59
        if (r107 != null) goto L57;
        if ((r106 instanceof Number) == false) goto L44;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(List.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r132 = Float.valueOf(((Number) r106).floatValue());     // Catch: Throwable -> L59
        if ((r132 instanceof List) == true) goto L24;
        r132 = null;
    L24:
        r107 = (List) r132;     // Catch: Throwable -> L59
        goto L57
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(List.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r133 = Double.valueOf(((Number) r106).doubleValue());     // Catch: Throwable -> L59
        if ((r133 instanceof List) == true) goto L30;
        r133 = null;
    L30:
        r107 = (List) r133;     // Catch: Throwable -> L59
        goto L57
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(List.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L38;
        Integer r134 = Integer.valueOf(((Number) r106).intValue());     // Catch: Throwable -> L59
        if ((r134 instanceof List) == true) goto L36;
        r134 = null;
    L36:
        r107 = (List) r134;     // Catch: Throwable -> L59
        goto L57
    L38:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(List.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L44;
        Long r135 = Long.valueOf(((Number) r106).longValue());     // Catch: Throwable -> L59
        if ((r135 instanceof List) == true) goto L42;
        r135 = null;
    L42:
        r107 = (List) r135;     // Catch: Throwable -> L59
    L44:
        if ((r106 instanceof JSONObject) == false) goto L46;
    L191:
        Object r136 = SDKSettingsCacheManager.a().fromJson(r106.toString(), List.class);     // Catch: Throwable -> L52
        if ((r136 instanceof List) == true) goto L50;
        r136 = null;
    L50:
        Object r137 = Result.m9449constructorimpl((List) r136);     // Catch: Throwable -> L52
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
        Result.Companion r139 = Result.Companion;     // Catch: Throwable -> L174
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L174
    L174:
        th = move-exception;
        Result.Companion r140 = Result.Companion;
        Object r141 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r142 = Result.m9452exceptionOrNullimpl(r141);
        if (r142 == null) goto L179;
        EnsureManager.ensureNotReachHere(r142);
    L179:
        if (Result.m9455isFailureimpl(r141) == true) goto L182;
        r101 = r141;
    L182:
        r110 = r101;
        goto L184
    }

    @SettingPanel("商详缓存优化实验-已固化")
    public static final ECCacheMonitorStruct w() {
        int r100 = j.f43647a;
        int r101 = com.bytedance.android.ec.core.abtest.e.f43640a;
        int r102 = d.f43629a;
        Object r103 = com.bytedance.android.ec.core.abtest.e.a(new ECCacheMonitorStruct(true, 1800, 10), new ECCacheMonitorStruct(false, 0, 0, 7, null));
        int r104 = com.bytedance.android.ec.base.settings.b.f42814a;
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L172
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L172
        SDKSettingsCacheManager r106 = SDKSettingsCacheManager.f42812e;     // Catch: Throwable -> L172
        Object r107 = null;
        r106.getClass();     // Catch: Throwable -> L59
        Object r108 = SDKSettingsCacheManager.f42809b.get("iesec_goods_detail_cache");     // Catch: Throwable -> L59
        if (r108 != null) goto L11;
    L56:
        Object r109 = null;
    L57:
        Object r110 = Result.m9449constructorimpl(r109);     // Catch: Throwable -> L59
    L61:
        Throwable r111 = Result.m9452exceptionOrNullimpl(r110);     // Catch: Throwable -> L172
        if (r111 == null) goto L65;
        EnsureManager.ensureNotReachHere(r111);     // Catch: Throwable -> L172
    L65:
        if (Result.m9455isFailureimpl(r110) == false) goto L68;
        r110 = null;
    L68:
        if ((r110 instanceof ECCacheMonitorStruct) == true) goto L70;
        r110 = null;
    L70:
        Object r112 = (ECCacheMonitorStruct) r110;     // Catch: Throwable -> L172
        if (r112 != null) goto L77;
        r106.getClass();     // Catch: Throwable -> L172
        Object r113 = SDKSettingsCacheManager.f42808a.get("iesec_goods_detail_cache");     // Catch: Throwable -> L172
        if ((r113 instanceof ECCacheMonitorStruct) == true) goto L76;
        r113 = null;
    L76:
        r112 = (ECCacheMonitorStruct) r113;     // Catch: Throwable -> L172
    L77:
        if (r112 != null) goto L182;
        int r114 = com.bytedance.android.ec.base.settings.g.f42821a;     // Catch: Throwable -> L172
    L159:
        th = move-exception;
        Result.Companion r115 = Result.Companion;     // Catch: Throwable -> L172
        Object r116 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L172
    L162:
        if (Result.m9452exceptionOrNullimpl(r116) != null) goto L193;
    L169:
        r112 = r116;
    L170:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L172
        SDKSettingsCacheManager.e("iesec_goods_detail_cache", r112);     // Catch: Throwable -> L172
        goto L182
    L193:
        r116 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("iesec_goods_detail_cache", ECCacheMonitorStruct.class, r103);     // Catch: Throwable -> L166
    L167:
        if (r116 != null) goto L169;
        r112 = r103;
    L166:
        r116 = r103;
        goto L167
    L185:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L133
        Object r117 = SDKSettingsCacheManager.f42809b.get("iesec_goods_detail_cache");     // Catch: Throwable -> L133
        if (r117 != null) goto L85;
    L130:
        Object r118 = null;
    L131:
        Object r119 = Result.m9449constructorimpl(r118);     // Catch: Throwable -> L133
    L135:
        Throwable r120 = Result.m9452exceptionOrNullimpl(r119);     // Catch: Throwable -> L159
        if (r120 == null) goto L139;
        EnsureManager.ensureNotReachHere(r120);     // Catch: Throwable -> L159
    L139:
        if (Result.m9455isFailureimpl(r119) == false) goto L142;
        r119 = null;
    L142:
        if ((r119 instanceof ECCacheMonitorStruct) == true) goto L144;
        r119 = null;
    L144:
        r116 = (ECCacheMonitorStruct) r119;     // Catch: Throwable -> L159
        if (r116 != null) goto L169;
        jj4.b r121 = jj4.b.f499326b;     // Catch: Throwable -> L159
        Object r122 = jj4.a.a("iesec_goods_detail_cache", ECCacheMonitorStruct.class, r103, false);     // Catch: Throwable -> L159
        if (r122 != null) goto L151;
        Intrinsics.throwNpe();     // Catch: Throwable -> L159
    L151:
        if ((r122 instanceof ECCacheMonitorStruct) == false) goto L154;
        r107 = r122;
    L154:
        Object r123 = (ECCacheMonitorStruct) r107;     // Catch: Throwable -> L159
        if (r123 != null) goto L157;
        r123 = r103;
    L157:
        r116 = Result.m9449constructorimpl(r123);     // Catch: Throwable -> L159
    L85:
        if ((r117 instanceof ECCacheMonitorStruct) == true) goto L87;
        Object r124 = null;
    L88:
        r118 = (ECCacheMonitorStruct) r124;     // Catch: Throwable -> L133
        if (r118 != null) goto L131;
        if ((r117 instanceof Number) == false) goto L118;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(ECCacheMonitorStruct.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L100;
        Float r125 = Float.valueOf(((Number) r117).floatValue());     // Catch: Throwable -> L133
        if ((r125 instanceof ECCacheMonitorStruct) == true) goto L98;
        r125 = null;
    L98:
        r118 = (ECCacheMonitorStruct) r125;     // Catch: Throwable -> L133
        goto L131
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(ECCacheMonitorStruct.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L106;
        Double r126 = Double.valueOf(((Number) r117).doubleValue());     // Catch: Throwable -> L133
        if ((r126 instanceof ECCacheMonitorStruct) == true) goto L104;
        r126 = null;
    L104:
        r118 = (ECCacheMonitorStruct) r126;     // Catch: Throwable -> L133
        goto L131
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(ECCacheMonitorStruct.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L112;
        Integer r127 = Integer.valueOf(((Number) r117).intValue());     // Catch: Throwable -> L133
        if ((r127 instanceof ECCacheMonitorStruct) == true) goto L110;
        r127 = null;
    L110:
        r118 = (ECCacheMonitorStruct) r127;     // Catch: Throwable -> L133
        goto L131
    L112:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(ECCacheMonitorStruct.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L118;
        Long r128 = Long.valueOf(((Number) r117).longValue());     // Catch: Throwable -> L133
        if ((r128 instanceof ECCacheMonitorStruct) == true) goto L116;
        r128 = null;
    L116:
        r118 = (ECCacheMonitorStruct) r128;     // Catch: Throwable -> L133
    L118:
        if ((r117 instanceof JSONObject) == false) goto L120;
    L191:
        Object r129 = SDKSettingsCacheManager.a().fromJson(r117.toString(), ECCacheMonitorStruct.class);     // Catch: Throwable -> L126
        if ((r129 instanceof ECCacheMonitorStruct) == true) goto L124;
        r129 = null;
    L124:
        Object r130 = Result.m9449constructorimpl((ECCacheMonitorStruct) r129);     // Catch: Throwable -> L126
    L128:
        r118 = r130;
        if (Result.m9455isFailureimpl(r118) == false) goto L131;
    L126:
        th = move-exception;
        Result.Companion r131 = Result.Companion;     // Catch: Throwable -> L133
        r130 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L133
        goto L128
    L120:
        if ((r117 instanceof JSONArray) == false) goto L130;
    L87:
        r124 = r117;
    L133:
        th = move-exception;
        Result.Companion r132 = Result.Companion;     // Catch: Throwable -> L159
        r119 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L159
    L182:
        return (ECCacheMonitorStruct) r112;
    L11:
        if ((r108 instanceof ECCacheMonitorStruct) == true) goto L13;
        Object r133 = null;
    L14:
        r109 = (ECCacheMonitorStruct) r133;     // Catch: Throwable -> L59
        if (r109 != null) goto L57;
        if ((r108 instanceof Number) == false) goto L44;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(ECCacheMonitorStruct.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r134 = Float.valueOf(((Number) r108).floatValue());     // Catch: Throwable -> L59
        if ((r134 instanceof ECCacheMonitorStruct) == true) goto L24;
        r134 = null;
    L24:
        r109 = (ECCacheMonitorStruct) r134;     // Catch: Throwable -> L59
        goto L57
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(ECCacheMonitorStruct.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r135 = Double.valueOf(((Number) r108).doubleValue());     // Catch: Throwable -> L59
        if ((r135 instanceof ECCacheMonitorStruct) == true) goto L30;
        r135 = null;
    L30:
        r109 = (ECCacheMonitorStruct) r135;     // Catch: Throwable -> L59
        goto L57
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(ECCacheMonitorStruct.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L38;
        Integer r136 = Integer.valueOf(((Number) r108).intValue());     // Catch: Throwable -> L59
        if ((r136 instanceof ECCacheMonitorStruct) == true) goto L36;
        r136 = null;
    L36:
        r109 = (ECCacheMonitorStruct) r136;     // Catch: Throwable -> L59
        goto L57
    L38:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(ECCacheMonitorStruct.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L44;
        Long r137 = Long.valueOf(((Number) r108).longValue());     // Catch: Throwable -> L59
        if ((r137 instanceof ECCacheMonitorStruct) == true) goto L42;
        r137 = null;
    L42:
        r109 = (ECCacheMonitorStruct) r137;     // Catch: Throwable -> L59
    L44:
        if ((r108 instanceof JSONObject) == false) goto L46;
    L183:
        Object r138 = SDKSettingsCacheManager.a().fromJson(r108.toString(), ECCacheMonitorStruct.class);     // Catch: Throwable -> L52
        if ((r138 instanceof ECCacheMonitorStruct) == true) goto L50;
        r138 = null;
    L50:
        Object r139 = Result.m9449constructorimpl((ECCacheMonitorStruct) r138);     // Catch: Throwable -> L52
    L54:
        r109 = r139;
        if (Result.m9455isFailureimpl(r109) == false) goto L57;
    L52:
        th = move-exception;
        Result.Companion r140 = Result.Companion;     // Catch: Throwable -> L59
        r139 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L59
        goto L54
    L46:
        if ((r108 instanceof JSONArray) == false) goto L56;
    L13:
        r133 = r108;
    L59:
        th = move-exception;
        Result.Companion r141 = Result.Companion;     // Catch: Throwable -> L172
        r110 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L172
    L172:
        th = move-exception;
        Result.Companion r142 = Result.Companion;
        Object r143 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r144 = Result.m9452exceptionOrNullimpl(r143);
        if (r144 == null) goto L177;
        EnsureManager.ensureNotReachHere(r144);
    L177:
        if (Result.m9455isFailureimpl(r143) == true) goto L180;
        r103 = r143;
    L180:
        r112 = r103;
        goto L182
    }

    @SettingPanel("商详性能优化-消息队列-已固化")
    public static final com.bytedance.android.ec.core.anchorv3.i w0() {
        int r100 = j.f43647a;
        int r101 = com.bytedance.android.ec.core.abtest.e.f43640a;
        Object r102 = com.bytedance.android.ec.core.abtest.e.a(new com.bytedance.android.ec.core.anchorv3.i(true, true, true, true, Boolean.FALSE, 104), new com.bytedance.android.ec.core.anchorv3.i(false, false, false, false, null, 255));
        int r103 = com.bytedance.android.ec.base.settings.b.f42814a;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L171
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L171
        SDKSettingsCacheManager r105 = SDKSettingsCacheManager.f42812e;     // Catch: Throwable -> L171
        Object r106 = null;
        r105.getClass();     // Catch: Throwable -> L59
        Object r107 = SDKSettingsCacheManager.f42809b.get("ec_pdp_perf_opt_msg");     // Catch: Throwable -> L59
        if (r107 != null) goto L11;
    L56:
        Object r108 = null;
    L57:
        Object r109 = Result.m9449constructorimpl(r108);     // Catch: Throwable -> L59
    L61:
        Throwable r110 = Result.m9452exceptionOrNullimpl(r109);     // Catch: Throwable -> L171
        if (r110 == null) goto L65;
        EnsureManager.ensureNotReachHere(r110);     // Catch: Throwable -> L171
    L65:
        if (Result.m9455isFailureimpl(r109) == false) goto L68;
        r109 = null;
    L68:
        if ((r109 instanceof com.bytedance.android.ec.core.anchorv3.i) == true) goto L70;
        r109 = null;
    L70:
        Object r111 = (com.bytedance.android.ec.core.anchorv3.i) r109;     // Catch: Throwable -> L171
        if (r111 != null) goto L77;
        r105.getClass();     // Catch: Throwable -> L171
        Object r112 = SDKSettingsCacheManager.f42808a.get("ec_pdp_perf_opt_msg");     // Catch: Throwable -> L171
        if ((r112 instanceof com.bytedance.android.ec.core.anchorv3.i) == true) goto L76;
        r112 = null;
    L76:
        r111 = (com.bytedance.android.ec.core.anchorv3.i) r112;     // Catch: Throwable -> L171
    L77:
        if (r111 != null) goto L181;
        int r113 = com.bytedance.android.ec.base.settings.g.f42821a;     // Catch: Throwable -> L171
    L159:
        th = move-exception;
        Result.Companion r114 = Result.Companion;     // Catch: Throwable -> L171
        Object r115 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L171
    L162:
        if (Result.m9452exceptionOrNullimpl(r115) != null) goto L186;
    L163:
        r111 = r115;
    L169:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L171
        SDKSettingsCacheManager.e("ec_pdp_perf_opt_msg", r111);     // Catch: Throwable -> L171
        goto L181
    L186:
        r115 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ec_pdp_perf_opt_msg", com.bytedance.android.ec.core.anchorv3.i.class, r102);     // Catch: Throwable -> L166
    L167:
        if (r115 != null) goto L163;
        r111 = r102;
    L166:
        r115 = r102;
        goto L167
    L190:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L133
        Object r116 = SDKSettingsCacheManager.f42809b.get("ec_pdp_perf_opt_msg");     // Catch: Throwable -> L133
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
        if ((r118 instanceof com.bytedance.android.ec.core.anchorv3.i) == true) goto L144;
        r118 = null;
    L144:
        r115 = (com.bytedance.android.ec.core.anchorv3.i) r118;     // Catch: Throwable -> L159
        if (r115 != null) goto L163;
        jj4.b r120 = jj4.b.f499326b;     // Catch: Throwable -> L159
        Object r121 = jj4.a.a("ec_pdp_perf_opt_msg", com.bytedance.android.ec.core.anchorv3.i.class, r102, false);     // Catch: Throwable -> L159
        if (r121 != null) goto L151;
        Intrinsics.throwNpe();     // Catch: Throwable -> L159
    L151:
        if ((r121 instanceof com.bytedance.android.ec.core.anchorv3.i) == false) goto L154;
        r106 = r121;
    L154:
        Object r122 = (com.bytedance.android.ec.core.anchorv3.i) r106;     // Catch: Throwable -> L159
        if (r122 != null) goto L157;
        r122 = r102;
    L157:
        r115 = Result.m9449constructorimpl(r122);     // Catch: Throwable -> L159
    L85:
        if ((r116 instanceof com.bytedance.android.ec.core.anchorv3.i) == true) goto L87;
        Object r123 = null;
    L88:
        r117 = (com.bytedance.android.ec.core.anchorv3.i) r123;     // Catch: Throwable -> L133
        if (r117 != null) goto L131;
        if ((r116 instanceof Number) == false) goto L118;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(com.bytedance.android.ec.core.anchorv3.i.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L100;
        Float r124 = Float.valueOf(((Number) r116).floatValue());     // Catch: Throwable -> L133
        if ((r124 instanceof com.bytedance.android.ec.core.anchorv3.i) == true) goto L98;
        r124 = null;
    L98:
        r117 = (com.bytedance.android.ec.core.anchorv3.i) r124;     // Catch: Throwable -> L133
        goto L131
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(com.bytedance.android.ec.core.anchorv3.i.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L106;
        Double r125 = Double.valueOf(((Number) r116).doubleValue());     // Catch: Throwable -> L133
        if ((r125 instanceof com.bytedance.android.ec.core.anchorv3.i) == true) goto L104;
        r125 = null;
    L104:
        r117 = (com.bytedance.android.ec.core.anchorv3.i) r125;     // Catch: Throwable -> L133
        goto L131
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(com.bytedance.android.ec.core.anchorv3.i.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L112;
        Integer r126 = Integer.valueOf(((Number) r116).intValue());     // Catch: Throwable -> L133
        if ((r126 instanceof com.bytedance.android.ec.core.anchorv3.i) == true) goto L110;
        r126 = null;
    L110:
        r117 = (com.bytedance.android.ec.core.anchorv3.i) r126;     // Catch: Throwable -> L133
        goto L131
    L112:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(com.bytedance.android.ec.core.anchorv3.i.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L118;
        Long r127 = Long.valueOf(((Number) r116).longValue());     // Catch: Throwable -> L133
        if ((r127 instanceof com.bytedance.android.ec.core.anchorv3.i) == true) goto L116;
        r127 = null;
    L116:
        r117 = (com.bytedance.android.ec.core.anchorv3.i) r127;     // Catch: Throwable -> L133
    L118:
        if ((r116 instanceof JSONObject) == false) goto L120;
    L184:
        Object r128 = SDKSettingsCacheManager.a().fromJson(r116.toString(), com.bytedance.android.ec.core.anchorv3.i.class);     // Catch: Throwable -> L126
        if ((r128 instanceof com.bytedance.android.ec.core.anchorv3.i) == true) goto L124;
        r128 = null;
    L124:
        Object r129 = Result.m9449constructorimpl((com.bytedance.android.ec.core.anchorv3.i) r128);     // Catch: Throwable -> L126
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
    L181:
        return (com.bytedance.android.ec.core.anchorv3.i) r111;
    L11:
        if ((r107 instanceof com.bytedance.android.ec.core.anchorv3.i) == true) goto L13;
        Object r132 = null;
    L14:
        r108 = (com.bytedance.android.ec.core.anchorv3.i) r132;     // Catch: Throwable -> L59
        if (r108 != null) goto L57;
        if ((r107 instanceof Number) == false) goto L44;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(com.bytedance.android.ec.core.anchorv3.i.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r133 = Float.valueOf(((Number) r107).floatValue());     // Catch: Throwable -> L59
        if ((r133 instanceof com.bytedance.android.ec.core.anchorv3.i) == true) goto L24;
        r133 = null;
    L24:
        r108 = (com.bytedance.android.ec.core.anchorv3.i) r133;     // Catch: Throwable -> L59
        goto L57
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(com.bytedance.android.ec.core.anchorv3.i.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r134 = Double.valueOf(((Number) r107).doubleValue());     // Catch: Throwable -> L59
        if ((r134 instanceof com.bytedance.android.ec.core.anchorv3.i) == true) goto L30;
        r134 = null;
    L30:
        r108 = (com.bytedance.android.ec.core.anchorv3.i) r134;     // Catch: Throwable -> L59
        goto L57
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(com.bytedance.android.ec.core.anchorv3.i.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L38;
        Integer r135 = Integer.valueOf(((Number) r107).intValue());     // Catch: Throwable -> L59
        if ((r135 instanceof com.bytedance.android.ec.core.anchorv3.i) == true) goto L36;
        r135 = null;
    L36:
        r108 = (com.bytedance.android.ec.core.anchorv3.i) r135;     // Catch: Throwable -> L59
        goto L57
    L38:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(com.bytedance.android.ec.core.anchorv3.i.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L44;
        Long r136 = Long.valueOf(((Number) r107).longValue());     // Catch: Throwable -> L59
        if ((r136 instanceof com.bytedance.android.ec.core.anchorv3.i) == true) goto L42;
        r136 = null;
    L42:
        r108 = (com.bytedance.android.ec.core.anchorv3.i) r136;     // Catch: Throwable -> L59
    L44:
        if ((r107 instanceof JSONObject) == false) goto L46;
    L188:
        Object r137 = SDKSettingsCacheManager.a().fromJson(r107.toString(), com.bytedance.android.ec.core.anchorv3.i.class);     // Catch: Throwable -> L52
        if ((r137 instanceof com.bytedance.android.ec.core.anchorv3.i) == true) goto L50;
        r137 = null;
    L50:
        Object r138 = Result.m9449constructorimpl((com.bytedance.android.ec.core.anchorv3.i) r137);     // Catch: Throwable -> L52
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
        Result.Companion r140 = Result.Companion;     // Catch: Throwable -> L171
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L171
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
        r111 = r102;
        goto L181
    }

    @SettingPanel("内流预链接图片域名")
    public static final List<String> x() {
        int r100 = p.f45243a;
        Object r101 = CollectionsKt.emptyList();
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r103 = jj4.b.f499326b;     // Catch: Throwable -> L7
        Object r104 = jj4.a.a("ec_goods_feed_host_list", List.class, r101, false);     // Catch: Throwable -> L7
        if (r104 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return (List) r104;
    L7:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Object r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r106) == true) goto L12;
        r101 = r106;
    L12:
        r104 = r101;
        goto L14
    }

    @SettingPanel("商详性能优化一期-已固化")
    public static final m x0() {
        int r100 = j.f43647a;
        Object r101 = com.bytedance.android.ec.core.abtest.e.a(new m(true, true, 1, true, true, MediaPlayer.MEDIA_PLAYER_OPTION_DEMUXER_CREATE_TIME), new m(false, false, 0, false, false, 1023));
        int r102 = com.bytedance.android.ec.base.settings.b.f42814a;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L171
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L171
        SDKSettingsCacheManager r104 = SDKSettingsCacheManager.f42812e;     // Catch: Throwable -> L171
        Object r105 = null;
        r104.getClass();     // Catch: Throwable -> L59
        Object r106 = SDKSettingsCacheManager.f42809b.get("ec_pdp_perf_opt_v1");     // Catch: Throwable -> L59
        if (r106 != null) goto L11;
    L56:
        Object r107 = null;
    L57:
        Object r108 = Result.m9449constructorimpl(r107);     // Catch: Throwable -> L59
    L61:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);     // Catch: Throwable -> L171
        if (r109 == null) goto L65;
        EnsureManager.ensureNotReachHere(r109);     // Catch: Throwable -> L171
    L65:
        if (Result.m9455isFailureimpl(r108) == false) goto L68;
        r108 = null;
    L68:
        if ((r108 instanceof m) == true) goto L70;
        r108 = null;
    L70:
        Object r110 = (m) r108;     // Catch: Throwable -> L171
        if (r110 != null) goto L77;
        r104.getClass();     // Catch: Throwable -> L171
        Object r111 = SDKSettingsCacheManager.f42808a.get("ec_pdp_perf_opt_v1");     // Catch: Throwable -> L171
        if ((r111 instanceof m) == true) goto L76;
        r111 = null;
    L76:
        r110 = (m) r111;     // Catch: Throwable -> L171
    L77:
        if (r110 != null) goto L181;
        int r112 = com.bytedance.android.ec.base.settings.g.f42821a;     // Catch: Throwable -> L171
    L159:
        th = move-exception;
        Result.Companion r113 = Result.Companion;     // Catch: Throwable -> L171
        Object r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L171
    L162:
        if (Result.m9452exceptionOrNullimpl(r114) != null) goto L194;
    L163:
        r110 = r114;
    L169:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L171
        SDKSettingsCacheManager.e("ec_pdp_perf_opt_v1", r110);     // Catch: Throwable -> L171
        goto L181
    L194:
        r114 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ec_pdp_perf_opt_v1", m.class, r101);     // Catch: Throwable -> L166
    L167:
        if (r114 != null) goto L163;
        r110 = r101;
    L166:
        r114 = r101;
        goto L167
    L184:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L133
        Object r115 = SDKSettingsCacheManager.f42809b.get("ec_pdp_perf_opt_v1");     // Catch: Throwable -> L133
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
        if ((r117 instanceof m) == true) goto L144;
        r117 = null;
    L144:
        r114 = (m) r117;     // Catch: Throwable -> L159
        if (r114 != null) goto L163;
        jj4.b r119 = jj4.b.f499326b;     // Catch: Throwable -> L159
        Object r120 = jj4.a.a("ec_pdp_perf_opt_v1", m.class, r101, false);     // Catch: Throwable -> L159
        if (r120 != null) goto L151;
        Intrinsics.throwNpe();     // Catch: Throwable -> L159
    L151:
        if ((r120 instanceof m) == false) goto L154;
        r105 = r120;
    L154:
        Object r121 = (m) r105;     // Catch: Throwable -> L159
        if (r121 != null) goto L157;
        r121 = r101;
    L157:
        r114 = Result.m9449constructorimpl(r121);     // Catch: Throwable -> L159
    L85:
        if ((r115 instanceof m) == true) goto L87;
        Object r122 = null;
    L88:
        r116 = (m) r122;     // Catch: Throwable -> L133
        if (r116 != null) goto L131;
        if ((r115 instanceof Number) == false) goto L118;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(m.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L100;
        Float r123 = Float.valueOf(((Number) r115).floatValue());     // Catch: Throwable -> L133
        if ((r123 instanceof m) == true) goto L98;
        r123 = null;
    L98:
        r116 = (m) r123;     // Catch: Throwable -> L133
        goto L131
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(m.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L106;
        Double r124 = Double.valueOf(((Number) r115).doubleValue());     // Catch: Throwable -> L133
        if ((r124 instanceof m) == true) goto L104;
        r124 = null;
    L104:
        r116 = (m) r124;     // Catch: Throwable -> L133
        goto L131
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(m.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L112;
        Integer r125 = Integer.valueOf(((Number) r115).intValue());     // Catch: Throwable -> L133
        if ((r125 instanceof m) == true) goto L110;
        r125 = null;
    L110:
        r116 = (m) r125;     // Catch: Throwable -> L133
        goto L131
    L112:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(m.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L118;
        Long r126 = Long.valueOf(((Number) r115).longValue());     // Catch: Throwable -> L133
        if ((r126 instanceof m) == true) goto L116;
        r126 = null;
    L116:
        r116 = (m) r126;     // Catch: Throwable -> L133
    L118:
        if ((r115 instanceof JSONObject) == false) goto L120;
    L192:
        Object r127 = SDKSettingsCacheManager.a().fromJson(r115.toString(), m.class);     // Catch: Throwable -> L126
        if ((r127 instanceof m) == true) goto L124;
        r127 = null;
    L124:
        Object r128 = Result.m9449constructorimpl((m) r127);     // Catch: Throwable -> L126
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
    L181:
        return (m) r110;
    L11:
        if ((r106 instanceof m) == true) goto L13;
        Object r131 = null;
    L14:
        r107 = (m) r131;     // Catch: Throwable -> L59
        if (r107 != null) goto L57;
        if ((r106 instanceof Number) == false) goto L44;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(m.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r132 = Float.valueOf(((Number) r106).floatValue());     // Catch: Throwable -> L59
        if ((r132 instanceof m) == true) goto L24;
        r132 = null;
    L24:
        r107 = (m) r132;     // Catch: Throwable -> L59
        goto L57
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(m.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r133 = Double.valueOf(((Number) r106).doubleValue());     // Catch: Throwable -> L59
        if ((r133 instanceof m) == true) goto L30;
        r133 = null;
    L30:
        r107 = (m) r133;     // Catch: Throwable -> L59
        goto L57
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(m.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L38;
        Integer r134 = Integer.valueOf(((Number) r106).intValue());     // Catch: Throwable -> L59
        if ((r134 instanceof m) == true) goto L36;
        r134 = null;
    L36:
        r107 = (m) r134;     // Catch: Throwable -> L59
        goto L57
    L38:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(m.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L44;
        Long r135 = Long.valueOf(((Number) r106).longValue());     // Catch: Throwable -> L59
        if ((r135 instanceof m) == true) goto L42;
        r135 = null;
    L42:
        r107 = (m) r135;     // Catch: Throwable -> L59
    L44:
        if ((r106 instanceof JSONObject) == false) goto L46;
    L182:
        Object r136 = SDKSettingsCacheManager.a().fromJson(r106.toString(), m.class);     // Catch: Throwable -> L52
        if ((r136 instanceof m) == true) goto L50;
        r136 = null;
    L50:
        Object r137 = Result.m9449constructorimpl((m) r136);     // Catch: Throwable -> L52
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
        Result.Companion r139 = Result.Companion;     // Catch: Throwable -> L171
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L171
    L171:
        th = move-exception;
        Result.Companion r140 = Result.Companion;
        Object r141 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r142 = Result.m9452exceptionOrNullimpl(r141);
        if (r142 == null) goto L176;
        EnsureManager.ensureNotReachHere(r142);
    L176:
        if (Result.m9455isFailureimpl(r141) == true) goto L179;
        r101 = r141;
    L179:
        r110 = r101;
        goto L181
    }

    @SettingPanel("自动领券收敛到交易链路控制-内流")
    public static final int y() {
        int r100 = j.f43647a;
        Object r101 = 0;
        int r102 = com.bytedance.android.ec.base.settings.b.f42814a;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L166
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L166
        SDKSettingsCacheManager r104 = SDKSettingsCacheManager.f42812e;     // Catch: Throwable -> L166
        Object r105 = null;
        r104.getClass();     // Catch: Throwable -> L56
        Object r106 = SDKSettingsCacheManager.f42809b.get("ec_inner_feed_auto_coupon_opt_ab");     // Catch: Throwable -> L56
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
        Object r111 = SDKSettingsCacheManager.f42808a.get("ec_inner_feed_auto_coupon_opt_ab");     // Catch: Throwable -> L166
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
        SDKSettingsCacheManager.e("ec_inner_feed_auto_coupon_opt_ab", r110);     // Catch: Throwable -> L166
        goto L176
    L183:
        r114 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ec_inner_feed_auto_coupon_opt_ab", Integer.class, r101);     // Catch: Throwable -> L160
    L161:
        if (r114 != null) goto L163;
        r110 = r101;
    L160:
        r114 = r101;
        goto L161
    L189:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L127
        Object r115 = SDKSettingsCacheManager.f42809b.get("ec_inner_feed_auto_coupon_opt_ab");     // Catch: Throwable -> L127
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
        Object r121 = jj4.a.a("ec_inner_feed_auto_coupon_opt_ab", Integer.class, r101, false);     // Catch: Throwable -> L153
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

    @SettingPanel("商详性能优化二期-已固化")
    public static final com.bytedance.android.ec.core.anchorv3.n y0() {
        int r100 = j.f43647a;
        int r101 = com.bytedance.android.ec.core.abtest.e.f43640a;
        Object r102 = com.bytedance.android.ec.core.abtest.e.a(new com.bytedance.android.ec.core.anchorv3.n(true, true, true, 3, 3, true, 2, true, 7, 14344), new com.bytedance.android.ec.core.anchorv3.n(false, false, false, 0, 0, false, 0, false, 0, 16383));
        int r103 = com.bytedance.android.ec.base.settings.b.f42814a;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L171
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L171
        SDKSettingsCacheManager r105 = SDKSettingsCacheManager.f42812e;     // Catch: Throwable -> L171
        Object r106 = null;
        r105.getClass();     // Catch: Throwable -> L59
        Object r107 = SDKSettingsCacheManager.f42809b.get("ec_pdp_perf_opt_v2");     // Catch: Throwable -> L59
        if (r107 != null) goto L11;
    L56:
        Object r108 = null;
    L57:
        Object r109 = Result.m9449constructorimpl(r108);     // Catch: Throwable -> L59
    L61:
        Throwable r110 = Result.m9452exceptionOrNullimpl(r109);     // Catch: Throwable -> L171
        if (r110 == null) goto L65;
        EnsureManager.ensureNotReachHere(r110);     // Catch: Throwable -> L171
    L65:
        if (Result.m9455isFailureimpl(r109) == false) goto L68;
        r109 = null;
    L68:
        if ((r109 instanceof com.bytedance.android.ec.core.anchorv3.n) == true) goto L70;
        r109 = null;
    L70:
        Object r111 = (com.bytedance.android.ec.core.anchorv3.n) r109;     // Catch: Throwable -> L171
        if (r111 != null) goto L77;
        r105.getClass();     // Catch: Throwable -> L171
        Object r112 = SDKSettingsCacheManager.f42808a.get("ec_pdp_perf_opt_v2");     // Catch: Throwable -> L171
        if ((r112 instanceof com.bytedance.android.ec.core.anchorv3.n) == true) goto L76;
        r112 = null;
    L76:
        r111 = (com.bytedance.android.ec.core.anchorv3.n) r112;     // Catch: Throwable -> L171
    L77:
        if (r111 != null) goto L181;
        int r113 = com.bytedance.android.ec.base.settings.g.f42821a;     // Catch: Throwable -> L171
    L159:
        th = move-exception;
        Result.Companion r114 = Result.Companion;     // Catch: Throwable -> L171
        r111 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L171
    L162:
        if (Result.m9452exceptionOrNullimpl(r111) != null) goto L194;
    L169:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L171
        SDKSettingsCacheManager.e("ec_pdp_perf_opt_v2", r111);     // Catch: Throwable -> L171
        goto L181
    L194:
        r111 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ec_pdp_perf_opt_v2", com.bytedance.android.ec.core.anchorv3.n.class, r102);     // Catch: Throwable -> L166
    L167:
        if (r111 != null) goto L169;
        r111 = r102;
    L166:
        r111 = r102;
        goto L167
    L184:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L133
        Object r115 = SDKSettingsCacheManager.f42809b.get("ec_pdp_perf_opt_v2");     // Catch: Throwable -> L133
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
        if ((r117 instanceof com.bytedance.android.ec.core.anchorv3.n) == true) goto L144;
        r117 = null;
    L144:
        r111 = (com.bytedance.android.ec.core.anchorv3.n) r117;     // Catch: Throwable -> L159
        if (r111 != null) goto L169;
        jj4.b r119 = jj4.b.f499326b;     // Catch: Throwable -> L159
        Object r120 = jj4.a.a("ec_pdp_perf_opt_v2", com.bytedance.android.ec.core.anchorv3.n.class, r102, false);     // Catch: Throwable -> L159
        if (r120 != null) goto L151;
        Intrinsics.throwNpe();     // Catch: Throwable -> L159
    L151:
        if ((r120 instanceof com.bytedance.android.ec.core.anchorv3.n) == false) goto L154;
        r106 = r120;
    L154:
        Object r121 = (com.bytedance.android.ec.core.anchorv3.n) r106;     // Catch: Throwable -> L159
        if (r121 != null) goto L157;
        r121 = r102;
    L157:
        r111 = Result.m9449constructorimpl(r121);     // Catch: Throwable -> L159
    L85:
        if ((r115 instanceof com.bytedance.android.ec.core.anchorv3.n) == true) goto L87;
        Object r122 = null;
    L88:
        r116 = (com.bytedance.android.ec.core.anchorv3.n) r122;     // Catch: Throwable -> L133
        if (r116 != null) goto L131;
        if ((r115 instanceof Number) == false) goto L118;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(com.bytedance.android.ec.core.anchorv3.n.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L100;
        Float r123 = Float.valueOf(((Number) r115).floatValue());     // Catch: Throwable -> L133
        if ((r123 instanceof com.bytedance.android.ec.core.anchorv3.n) == true) goto L98;
        r123 = null;
    L98:
        r116 = (com.bytedance.android.ec.core.anchorv3.n) r123;     // Catch: Throwable -> L133
        goto L131
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(com.bytedance.android.ec.core.anchorv3.n.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L106;
        Double r124 = Double.valueOf(((Number) r115).doubleValue());     // Catch: Throwable -> L133
        if ((r124 instanceof com.bytedance.android.ec.core.anchorv3.n) == true) goto L104;
        r124 = null;
    L104:
        r116 = (com.bytedance.android.ec.core.anchorv3.n) r124;     // Catch: Throwable -> L133
        goto L131
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(com.bytedance.android.ec.core.anchorv3.n.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L112;
        Integer r125 = Integer.valueOf(((Number) r115).intValue());     // Catch: Throwable -> L133
        if ((r125 instanceof com.bytedance.android.ec.core.anchorv3.n) == true) goto L110;
        r125 = null;
    L110:
        r116 = (com.bytedance.android.ec.core.anchorv3.n) r125;     // Catch: Throwable -> L133
        goto L131
    L112:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(com.bytedance.android.ec.core.anchorv3.n.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L118;
        Long r126 = Long.valueOf(((Number) r115).longValue());     // Catch: Throwable -> L133
        if ((r126 instanceof com.bytedance.android.ec.core.anchorv3.n) == true) goto L116;
        r126 = null;
    L116:
        r116 = (com.bytedance.android.ec.core.anchorv3.n) r126;     // Catch: Throwable -> L133
    L118:
        if ((r115 instanceof JSONObject) == false) goto L120;
    L192:
        Object r127 = SDKSettingsCacheManager.a().fromJson(r115.toString(), com.bytedance.android.ec.core.anchorv3.n.class);     // Catch: Throwable -> L126
        if ((r127 instanceof com.bytedance.android.ec.core.anchorv3.n) == true) goto L124;
        r127 = null;
    L124:
        Object r128 = Result.m9449constructorimpl((com.bytedance.android.ec.core.anchorv3.n) r127);     // Catch: Throwable -> L126
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
    L181:
        return (com.bytedance.android.ec.core.anchorv3.n) r111;
    L11:
        if ((r107 instanceof com.bytedance.android.ec.core.anchorv3.n) == true) goto L13;
        Object r131 = null;
    L14:
        r108 = (com.bytedance.android.ec.core.anchorv3.n) r131;     // Catch: Throwable -> L59
        if (r108 != null) goto L57;
        if ((r107 instanceof Number) == false) goto L44;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(com.bytedance.android.ec.core.anchorv3.n.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r132 = Float.valueOf(((Number) r107).floatValue());     // Catch: Throwable -> L59
        if ((r132 instanceof com.bytedance.android.ec.core.anchorv3.n) == true) goto L24;
        r132 = null;
    L24:
        r108 = (com.bytedance.android.ec.core.anchorv3.n) r132;     // Catch: Throwable -> L59
        goto L57
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(com.bytedance.android.ec.core.anchorv3.n.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r133 = Double.valueOf(((Number) r107).doubleValue());     // Catch: Throwable -> L59
        if ((r133 instanceof com.bytedance.android.ec.core.anchorv3.n) == true) goto L30;
        r133 = null;
    L30:
        r108 = (com.bytedance.android.ec.core.anchorv3.n) r133;     // Catch: Throwable -> L59
        goto L57
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(com.bytedance.android.ec.core.anchorv3.n.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L38;
        Integer r134 = Integer.valueOf(((Number) r107).intValue());     // Catch: Throwable -> L59
        if ((r134 instanceof com.bytedance.android.ec.core.anchorv3.n) == true) goto L36;
        r134 = null;
    L36:
        r108 = (com.bytedance.android.ec.core.anchorv3.n) r134;     // Catch: Throwable -> L59
        goto L57
    L38:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(com.bytedance.android.ec.core.anchorv3.n.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L44;
        Long r135 = Long.valueOf(((Number) r107).longValue());     // Catch: Throwable -> L59
        if ((r135 instanceof com.bytedance.android.ec.core.anchorv3.n) == true) goto L42;
        r135 = null;
    L42:
        r108 = (com.bytedance.android.ec.core.anchorv3.n) r135;     // Catch: Throwable -> L59
    L44:
        if ((r107 instanceof JSONObject) == false) goto L46;
    L182:
        Object r136 = SDKSettingsCacheManager.a().fromJson(r107.toString(), com.bytedance.android.ec.core.anchorv3.n.class);     // Catch: Throwable -> L52
        if ((r136 instanceof com.bytedance.android.ec.core.anchorv3.n) == true) goto L50;
        r136 = null;
    L50:
        Object r137 = Result.m9449constructorimpl((com.bytedance.android.ec.core.anchorv3.n) r136);     // Catch: Throwable -> L52
    L54:
        r108 = r137;
        if (Result.m9455isFailureimpl(r108) == false) goto L57;
    L52:
        th = move-exception;
        Result.Companion r138 = Result.Companion;     // Catch: Throwable -> L59
        r137 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L59
        goto L54
    L46:
        if ((r107 instanceof JSONArray) == false) goto L56;
    L13:
        r131 = r107;
    L59:
        th = move-exception;
        Result.Companion r139 = Result.Companion;     // Catch: Throwable -> L171
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L171
    L171:
        th = move-exception;
        Result.Companion r140 = Result.Companion;
        Object r141 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r142 = Result.m9452exceptionOrNullimpl(r141);
        if (r142 == null) goto L176;
        EnsureManager.ensureNotReachHere(r142);
    L176:
        if (Result.m9455isFailureimpl(r141) == true) goto L179;
        r102 = r141;
    L179:
        r111 = r102;
        goto L181
    }

    @SettingPanel("电商直播策略服务开关")
    public static final boolean z() {
        int r100 = j.f43647a;
        Object r101 = Boolean.FALSE;
        int r102 = com.bytedance.android.ec.base.settings.b.f42814a;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L172
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L172
        SDKSettingsCacheManager r104 = SDKSettingsCacheManager.f42812e;     // Catch: Throwable -> L172
        Object r105 = null;
        r104.getClass();     // Catch: Throwable -> L59
        Object r106 = SDKSettingsCacheManager.f42809b.get("ec_ligo_strategy_switch");     // Catch: Throwable -> L59
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
        Object r111 = SDKSettingsCacheManager.f42808a.get("ec_ligo_strategy_switch");     // Catch: Throwable -> L172
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
        SDKSettingsCacheManager.e("ec_ligo_strategy_switch", r110);     // Catch: Throwable -> L172
        goto L182
    L185:
        r114 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ec_ligo_strategy_switch", Boolean.class, r101);     // Catch: Throwable -> L166
    L167:
        if (r114 != null) goto L169;
        r110 = r101;
    L166:
        r114 = r101;
        goto L167
    L191:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L133
        Object r115 = SDKSettingsCacheManager.f42809b.get("ec_ligo_strategy_switch");     // Catch: Throwable -> L133
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
        Object r120 = jj4.a.a("ec_ligo_strategy_switch", Boolean.class, r101, false);     // Catch: Throwable -> L159
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

    @SettingPanel("商详修复小红条半屏关闭没有跟随消失问题")
    public static final boolean z0() {
        int r100 = com.bytedance.android.ec.base.settings.b.f42814a;
        Object r101 = Boolean.TRUE;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L172
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L172
        SDKSettingsCacheManager r103 = SDKSettingsCacheManager.f42812e;     // Catch: Throwable -> L172
        Object r104 = null;
        r103.getClass();     // Catch: Throwable -> L59
        Object r105 = SDKSettingsCacheManager.f42809b.get("ec_pdp_fix_red_tip_diss_miss");     // Catch: Throwable -> L59
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
        Object r110 = SDKSettingsCacheManager.f42808a.get("ec_pdp_fix_red_tip_diss_miss");     // Catch: Throwable -> L172
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
        SDKSettingsCacheManager.e("ec_pdp_fix_red_tip_diss_miss", r109);     // Catch: Throwable -> L172
        goto L182
    L185:
        r113 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ec_pdp_fix_red_tip_diss_miss", Boolean.class, r101);     // Catch: Throwable -> L166
    L167:
        if (r113 != null) goto L169;
        r109 = r101;
    L166:
        r113 = r101;
        goto L167
    L191:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L133
        Object r114 = SDKSettingsCacheManager.f42809b.get("ec_pdp_fix_red_tip_diss_miss");     // Catch: Throwable -> L133
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
        Object r119 = jj4.a.a("ec_pdp_fix_red_tip_diss_miss", Boolean.class, r101, false);     // Catch: Throwable -> L159
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
}
