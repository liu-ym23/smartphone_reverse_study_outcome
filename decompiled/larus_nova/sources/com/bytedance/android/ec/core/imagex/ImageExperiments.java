package com.bytedance.android.ec.core.imagex;

import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.core.imagex.opt.ImageXSettingKt$lazyImageXSettingsOrNull$4;
import com.bytedance.android.ec.core.opt.ab.ColdLaunchExpFilter;
import com.bytedance.android.ec.core.opt.ab.LazyFastSDKSettings;
import com.bytedance.android.ec.hybrid.hostapi.IECHybridKevaService;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.services.apm.api.EnsureManager;
import com.facebook.keyframes.model.KFAnimation;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class ImageExperiments {
    public static final Lazy A = null;
    public static final Lazy B = null;
    public static final ReadOnlyProperty C = null;
    public static final Lazy D = null;
    public static final Lazy E = null;
    public static final Lazy F = null;
    public static final ImageExperiments G = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f44398a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f44399b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f44400c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f44401d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f44402e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Lazy f44403f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Lazy f44404g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Lazy f44405h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Lazy f44406i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Lazy f44407j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Lazy f44408k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Lazy f44409l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Lazy f44410m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Lazy f44411n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Lazy f44412o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Lazy f44413p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Lazy f44414q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final Lazy f44415r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final Lazy f44416s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final Lazy f44417t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final Lazy f44418u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final Lazy f44419v = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final Lazy f44420w = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final Lazy f44421x = null;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final Lazy f44422y = null;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final Lazy f44423z = null;

    public static final class a implements ReadOnlyProperty<Object, e> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final /* synthetic */ KProperty[] f44424g = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final LazyFastSDKSettings f44425a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public e f44426b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f44427c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Object f44428d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Function0 f44429e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ Function2 f44430f;

        static {
            f44424g = new KProperty[]{Reflection.property1(new PropertyReference1Impl(a.class, "value", "getValue()Ljava/lang/Object;", 0))};
        }

        /* JADX WARN: Type inference failed for: r4v6, types: [com.bytedance.android.ec.core.imagex.e, java.lang.Object] */
        @Override // kotlin.properties.ReadOnlyProperty
        public final e getValue(Object r100, KProperty<?> r101) {
            Intrinsics.checkNotNullParameter(r100, "thisRef");
            Intrinsics.checkNotNullParameter(r101, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
            if (this.f44426b != null) goto L5;
            LazyFastSDKSettings r102 = this.f44425a;
            KProperty<?>[] r103 = f44424g;
            if (r102.getValue(this, r103[0]) == this.f44428d) goto L15;
            this.f44426b = this.f44425a.getValue(this, r103[0]);
            if (ColdLaunchExpFilter.f45205e.b(this.f44427c) == true) goto L15;
            return this.f44426b;
        L15:
            return null;
        L5:
            if (ColdLaunchExpFilter.f45205e.b(this.f44427c) == false) goto L8;
            return null;
        L8:
            return this.f44426b;
        }

        public a(final e r100, Function0 r110, ImageXSettingKt$lazyImageXSettingsOrNull$4 r111) {
            final String r101 = "ec_image_decode_rgb_565_config";
            this.f44427c = "ec_image_decode_rgb_565_config";
            this.f44428d = r100;
            this.f44429e = r110;
            this.f44430f = r111;
            this.f44425a = new LazyFastSDKSettings("ec_image_decode_rgb_565_config", r100, null, r110, r111, new ImageExperiments$$special$$inlined$lazyImageXSettingsOrNull$1$1(r101, r100));
        }
    }

    static {
        f44398a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(ImageExperiments.class, "decodeRGB565Config", "getDecodeRGB565Config()Lcom/bytedance/android/ec/core/imagex/ECImageCustomDecodeRGBConfig;", 0))};
        G = new ImageExperiments();
        f44399b = LazyKt.lazy(ImageExperiments$urlTransformEnable$2.INSTANCE);
        f44400c = LazyKt.lazy(ImageExperiments$urlTransformConfigKeys$2.INSTANCE);
        f44401d = LazyKt.lazy(ImageExperiments$imageRenderMonitorEnable$2.INSTANCE);
        f44402e = LazyKt.lazy(ImageExperiments$ecImageMiddlewareUrlEditCacheEnable$2.INSTANCE);
        f44403f = LazyKt.lazy(ImageExperiments$ecImageMiddlewareUrlEditCacheSize$2.INSTANCE);
        f44404g = LazyKt.lazy(ImageExperiments$all$2.INSTANCE);
        f44405h = LazyKt.lazy(ImageExperiments$ecImageHostReplaceOptEnable$2.INSTANCE);
        f44406i = LazyKt.lazy(ImageExperiments$ecImageSlcLoaderHookerEnable$2.INSTANCE);
        f44407j = LazyKt.lazy(ImageExperiments$ecImageSingleAsyncWorkerOpt$2.INSTANCE);
        f44408k = LazyKt.lazy(ImageExperiments$ecImageAbSettingsGetOpt$2.INSTANCE);
        f44409l = LazyKt.lazy(ImageExperiments$ecImagePreloadAsyncWorkerOpt$2.INSTANCE);
        f44410m = LazyKt.lazy(ImageExperiments$ecImagePreloadAsyncPriority$2.INSTANCE);
        f44411n = LazyKt.lazy(ImageExperiments$ecSliceImageRequestBuildCacheSize$2.INSTANCE);
        f44412o = LazyKt.lazy(ImageExperiments$ecGoodsImagePlaceholderEnable$2.INSTANCE);
        f44413p = LazyKt.lazy(ImageExperiments$ecGoodsImageDefaultResizeOptionsEnable$2.INSTANCE);
        f44414q = LazyKt.lazy(ImageExperiments$ecLynxImagePreloadEnable$2.INSTANCE);
        f44415r = LazyKt.lazy(ImageExperiments$ecLynxImageLoadUrlLogEnable$2.INSTANCE);
        f44416s = LazyKt.lazy(ImageExperiments$ecLynxImageLoadUrlCacheEnable$2.INSTANCE);
        f44417t = LazyKt.lazy(ImageExperiments$ecomImageBehaviorDefaultEnable$2.INSTANCE);
        f44418u = LazyKt.lazy(ImageExperiments$ecImageDefaultUseEcomImage$2.INSTANCE);
        f44419v = LazyKt.lazy(ImageExperiments$useOriginImageLoad$2.INSTANCE);
        f44420w = LazyKt.lazy(ImageExperiments$ecSliceLocalDurationOpt$2.INSTANCE);
        f44421x = LazyKt.lazy(ImageExperiments$useNewLynxImageConfig$2.INSTANCE);
        f44422y = LazyKt.lazy(ImageExperiments$useNewLynxImageType$2.INSTANCE);
        f44423z = LazyKt.lazy(ImageExperiments$decodeRGB565EnableConfig$2.INSTANCE);
        A = LazyKt.lazy(ImageExperiments$decodeRGB565Enable$2.INSTANCE);
        B = LazyKt.lazy(ImageExperiments$decodeRGB565EnableNew$2.INSTANCE);
        e r100 = new e(null);
        ImageExperiments$decodeRGB565Config$2 r101 = ImageExperiments$decodeRGB565Config$2.INSTANCE;
        ImageXSettingKt$lazyImageXSettingsOrNull$4 r102 = new ImageXSettingKt$lazyImageXSettingsOrNull$4(null);
        if (com.bytedance.android.ec.core.imagex.opt.z.b() == false) goto L5;
        ReadOnlyProperty r103 = new a(r100, r101, r102);
    L6:
        C = r103;
        D = LazyKt.lazy(ImageExperiments$pdpDetailImageMemoryOptEnable$2.INSTANCE);
        E = LazyKt.lazy(ImageExperiments$immediatePriorityConfig$2.INSTANCE);
        F = LazyKt.lazy(ImageExperiments$imageDeferInvalidationConfig$2.INSTANCE);
        return;
    L5:
        r103 = com.bytedance.android.ec.core.opt.ab.h.b("ec_image_decode_rgb_565_config", r100, null, r101, r102);
        goto L6
    }

    public ImageExperiments() {
    }

    public static HashMap b() {
        return (HashMap) f44404g.getValue();
    }

    public static boolean c() {
        return ((Boolean) f44418u.getValue()).booleanValue();
    }

    public static final int a() {
        int r100 = com.bytedance.android.ec.core.imagex.opt.h0.f44861a;
        Object r101 = 1;
        Object r102 = null;
        if (com.bytedance.android.ec.core.imagex.opt.z.b() == false) goto L172;
        int r103 = com.bytedance.android.ec.base.settings.b.f42814a;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L165
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L165
        SDKSettingsCacheManager r105 = SDKSettingsCacheManager.f42812e;     // Catch: Throwable -> L165
        r105.getClass();     // Catch: Throwable -> L55
        Object r106 = SDKSettingsCacheManager.f42809b.get("ec_image_url_transform_enable");     // Catch: Throwable -> L55
        if (r106 != null) goto L10;
    L52:
        Object r107 = null;
    L53:
        Object r108 = Result.m9449constructorimpl(r107);     // Catch: Throwable -> L55
    L57:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);     // Catch: Throwable -> L165
        if (r109 == null) goto L61;
        EnsureManager.ensureNotReachHere(r109);     // Catch: Throwable -> L165
    L61:
        if (Result.m9455isFailureimpl(r108) == false) goto L64;
        r108 = null;
    L64:
        if ((r108 instanceof Integer) == true) goto L66;
        r108 = null;
    L66:
        Object r110 = (Integer) r108;     // Catch: Throwable -> L165
        if (r110 != null) goto L73;
        r105.getClass();     // Catch: Throwable -> L165
        Object r111 = SDKSettingsCacheManager.f42808a.get("ec_image_url_transform_enable");     // Catch: Throwable -> L165
        if ((r111 instanceof Integer) == true) goto L72;
        r111 = null;
    L72:
        r110 = (Integer) r111;     // Catch: Throwable -> L165
    L73:
        if (r110 != null) goto L338;
        int r112 = com.bytedance.android.ec.base.settings.g.f42821a;     // Catch: Throwable -> L165
    L152:
        th = move-exception;
        Result.Companion r113 = Result.Companion;     // Catch: Throwable -> L165
        Object r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L165
    L155:
        if (Result.m9452exceptionOrNullimpl(r114) != null) goto L354;
    L162:
        r110 = r114;
    L163:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L165
        SDKSettingsCacheManager.e("ec_image_url_transform_enable", r110);     // Catch: Throwable -> L165
        goto L338
    L354:
        r114 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ec_image_url_transform_enable", Integer.class, r101);     // Catch: Throwable -> L159
    L160:
        if (r114 != null) goto L162;
        r110 = r101;
    L159:
        r114 = r101;
        goto L160
    L339:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L126
        Object r115 = SDKSettingsCacheManager.f42809b.get("ec_image_url_transform_enable");     // Catch: Throwable -> L126
        if (r115 != null) goto L81;
    L123:
        Object r116 = null;
    L124:
        Object r117 = Result.m9449constructorimpl(r116);     // Catch: Throwable -> L126
    L128:
        Throwable r118 = Result.m9452exceptionOrNullimpl(r117);     // Catch: Throwable -> L152
        if (r118 == null) goto L132;
        EnsureManager.ensureNotReachHere(r118);     // Catch: Throwable -> L152
    L132:
        if (Result.m9455isFailureimpl(r117) == false) goto L135;
        r117 = null;
    L135:
        if ((r117 instanceof Integer) == true) goto L137;
        r117 = null;
    L137:
        r114 = (Integer) r117;     // Catch: Throwable -> L152
        if (r114 != null) goto L162;
        jj4.b r119 = jj4.b.f499326b;     // Catch: Throwable -> L152
        Object r120 = jj4.a.a("ec_image_url_transform_enable", Integer.class, r101, false);     // Catch: Throwable -> L152
        if (r120 != null) goto L144;
        Intrinsics.throwNpe();     // Catch: Throwable -> L152
    L144:
        if ((r120 instanceof Integer) == false) goto L147;
        r102 = r120;
    L147:
        Object r121 = (Integer) r102;     // Catch: Throwable -> L152
        if (r121 != null) goto L150;
        r121 = r101;
    L150:
        r114 = Result.m9449constructorimpl(r121);     // Catch: Throwable -> L152
    L81:
        if ((r115 instanceof Integer) == true) goto L83;
        Object r122 = null;
    L84:
        r116 = (Integer) r122;     // Catch: Throwable -> L126
        if (r116 != null) goto L124;
        if ((r115 instanceof Number) == false) goto L111;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L96;
        Float r123 = Float.valueOf(((Number) r115).floatValue());     // Catch: Throwable -> L126
        if ((r123 instanceof Integer) == true) goto L94;
        r123 = null;
    L94:
        r116 = (Integer) r123;     // Catch: Throwable -> L126
        goto L124
    L96:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L102;
        Double r124 = Double.valueOf(((Number) r115).doubleValue());     // Catch: Throwable -> L126
        if ((r124 instanceof Integer) == true) goto L100;
        r124 = null;
    L100:
        r116 = (Integer) r124;     // Catch: Throwable -> L126
        goto L124
    L102:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L105;
        r116 = Integer.valueOf(((Number) r115).intValue());     // Catch: Throwable -> L126
        goto L124
    L105:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L111;
        Long r125 = Long.valueOf(((Number) r115).longValue());     // Catch: Throwable -> L126
        if ((r125 instanceof Integer) == true) goto L109;
        r125 = null;
    L109:
        r116 = (Integer) r125;     // Catch: Throwable -> L126
    L111:
        if ((r115 instanceof JSONObject) == false) goto L113;
    L352:
        Object r126 = SDKSettingsCacheManager.a().fromJson(r115.toString(), Integer.class);     // Catch: Throwable -> L119
        if ((r126 instanceof Integer) == true) goto L117;
        r126 = null;
    L117:
        Object r127 = Result.m9449constructorimpl((Integer) r126);     // Catch: Throwable -> L119
    L121:
        r116 = r127;
        if (Result.m9455isFailureimpl(r116) == false) goto L124;
    L119:
        th = move-exception;
        Result.Companion r128 = Result.Companion;     // Catch: Throwable -> L126
        r127 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L126
        goto L121
    L113:
        if ((r115 instanceof JSONArray) == false) goto L123;
    L83:
        r122 = r115;
    L126:
        th = move-exception;
        Result.Companion r129 = Result.Companion;     // Catch: Throwable -> L152
        r117 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L152
    L338:
        return ((Number) r110).intValue();
    L10:
        if ((r106 instanceof Integer) == true) goto L12;
        Object r130 = null;
    L13:
        r107 = (Integer) r130;     // Catch: Throwable -> L55
        if (r107 != null) goto L53;
        if ((r106 instanceof Number) == false) goto L40;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L25;
        Float r131 = Float.valueOf(((Number) r106).floatValue());     // Catch: Throwable -> L55
        if ((r131 instanceof Integer) == true) goto L23;
        r131 = null;
    L23:
        r107 = (Integer) r131;     // Catch: Throwable -> L55
        goto L53
    L25:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L31;
        Double r132 = Double.valueOf(((Number) r106).doubleValue());     // Catch: Throwable -> L55
        if ((r132 instanceof Integer) == true) goto L29;
        r132 = null;
    L29:
        r107 = (Integer) r132;     // Catch: Throwable -> L55
        goto L53
    L31:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L34;
        r107 = Integer.valueOf(((Number) r106).intValue());     // Catch: Throwable -> L55
        goto L53
    L34:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L40;
        Long r133 = Long.valueOf(((Number) r106).longValue());     // Catch: Throwable -> L55
        if ((r133 instanceof Integer) == true) goto L38;
        r133 = null;
    L38:
        r107 = (Integer) r133;     // Catch: Throwable -> L55
    L40:
        if ((r106 instanceof JSONObject) == false) goto L42;
    L350:
        Object r134 = SDKSettingsCacheManager.a().fromJson(r106.toString(), Integer.class);     // Catch: Throwable -> L48
        if ((r134 instanceof Integer) == true) goto L46;
        r134 = null;
    L46:
        Object r135 = Result.m9449constructorimpl((Integer) r134);     // Catch: Throwable -> L48
    L50:
        r107 = r135;
        if (Result.m9455isFailureimpl(r107) == false) goto L53;
    L48:
        th = move-exception;
        Result.Companion r136 = Result.Companion;     // Catch: Throwable -> L55
        r135 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L55
        goto L50
    L42:
        if ((r106 instanceof JSONArray) == false) goto L52;
    L12:
        r130 = r106;
    L55:
        th = move-exception;
        Result.Companion r137 = Result.Companion;     // Catch: Throwable -> L165
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L165
    L165:
        th = move-exception;
        Result.Companion r138 = Result.Companion;
        Object r139 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r140 = Result.m9452exceptionOrNullimpl(r139);
        if (r140 == null) goto L170;
        EnsureManager.ensureNotReachHere(r140);
    L170:
        if (Result.m9455isFailureimpl(r139) == true) goto L336;
    L335:
        r101 = r139;
    L336:
        r110 = r101;
        goto L338
    L172:
        int r141 = com.bytedance.android.ec.core.opt.ab.n.f45241a;
        int r142 = com.bytedance.android.ec.base.settings.a.f42813a;
        Result.Companion r143 = Result.Companion;     // Catch: Throwable -> L328
        Object r144 = com.bytedance.android.ec.base.settings.d.f42818c.get("ec_image_url_transform_enable");     // Catch: Throwable -> L223
        if (r144 != null) goto L178;
    L220:
        Object r145 = null;
    L221:
        Object r146 = Result.m9449constructorimpl(r145);     // Catch: Throwable -> L223
    L225:
        Throwable r147 = Result.m9452exceptionOrNullimpl(r146);     // Catch: Throwable -> L328
        if (r147 == null) goto L229;
        EnsureManager.ensureNotReachHere(r147);     // Catch: Throwable -> L328
    L229:
        if (Result.m9455isFailureimpl(r146) == false) goto L232;
        r146 = null;
    L232:
        if ((r146 instanceof Integer) == true) goto L234;
        r146 = null;
    L234:
        Object r148 = (Integer) r146;     // Catch: Throwable -> L328
        if (r148 != null) goto L241;
        Object r149 = com.bytedance.android.ec.base.settings.d.f42816a.get("ec_image_url_transform_enable");     // Catch: Throwable -> L328
        if ((r149 instanceof Integer) == true) goto L240;
        r149 = null;
    L240:
        r148 = (Integer) r149;     // Catch: Throwable -> L328
    L241:
        if (r148 == null) goto L243;
    L242:
        r110 = r148;
        goto L338
    L243:
        int r150 = com.bytedance.android.ec.base.settings.c.f42815a;     // Catch: Throwable -> L328
        Object r151 = com.bytedance.android.ec.base.settings.d.f42818c.get("ec_image_url_transform_enable");     // Catch: Throwable -> L293
        if (r151 != null) goto L248;
    L290:
        Object r152 = null;
    L291:
        Object r153 = Result.m9449constructorimpl(r152);     // Catch: Throwable -> L293
    L295:
        Throwable r154 = Result.m9452exceptionOrNullimpl(r153);     // Catch: Throwable -> L319
        if (r154 == null) goto L299;
        EnsureManager.ensureNotReachHere(r154);     // Catch: Throwable -> L319
    L299:
        if (Result.m9455isFailureimpl(r153) == false) goto L302;
        r153 = null;
    L302:
        if ((r153 instanceof Integer) == true) goto L304;
        r153 = null;
    L304:
        r148 = (Integer) r153;     // Catch: Throwable -> L319
        if (r148 != null) goto L326;
        IHybridHostService r155 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L319
        if (r155 == null) goto L310;
        Object r156 = r155.getHostABValue("ec_image_url_transform_enable", r101);     // Catch: Throwable -> L319
    L311:
        if (r156 != null) goto L313;
    L325:
        r148 = r101;
        goto L326
    L313:
        if ((r156 instanceof Integer) == false) goto L316;
        r102 = r156;
    L316:
        r148 = (Integer) r102;     // Catch: Throwable -> L319
        if (r148 != null) goto L326;
    L310:
        r156 = null;
    L326:
        com.bytedance.android.ec.base.settings.d.d("ec_image_url_transform_enable", r148);     // Catch: Throwable -> L328
        goto L242
    L248:
        if ((r151 instanceof Integer) == true) goto L250;
        Object r157 = null;
    L251:
        r152 = (Integer) r157;     // Catch: Throwable -> L293
        if (r152 != null) goto L291;
        if ((r151 instanceof Number) == false) goto L278;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L263;
        Float r158 = Float.valueOf(((Number) r151).floatValue());     // Catch: Throwable -> L293
        if ((r158 instanceof Integer) == true) goto L261;
        r158 = null;
    L261:
        r152 = (Integer) r158;     // Catch: Throwable -> L293
        goto L291
    L263:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L269;
        Double r159 = Double.valueOf(((Number) r151).doubleValue());     // Catch: Throwable -> L293
        if ((r159 instanceof Integer) == true) goto L267;
        r159 = null;
    L267:
        r152 = (Integer) r159;     // Catch: Throwable -> L293
        goto L291
    L269:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L272;
        r152 = Integer.valueOf(((Number) r151).intValue());     // Catch: Throwable -> L293
        goto L291
    L272:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L278;
        Long r160 = Long.valueOf(((Number) r151).longValue());     // Catch: Throwable -> L293
        if ((r160 instanceof Integer) == true) goto L276;
        r160 = null;
    L276:
        r152 = (Integer) r160;     // Catch: Throwable -> L293
    L278:
        if ((r151 instanceof JSONObject) == false) goto L280;
    L358:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L286
        Object r161 = SDKSettingsCacheManager.a().fromJson(r151.toString(), Integer.class);     // Catch: Throwable -> L286
        if ((r161 instanceof Integer) == true) goto L284;
        r161 = null;
    L284:
        Object r162 = Result.m9449constructorimpl((Integer) r161);     // Catch: Throwable -> L286
    L288:
        r152 = r162;
        if (Result.m9455isFailureimpl(r152) == false) goto L291;
    L286:
        th = move-exception;
        Result.Companion r163 = Result.Companion;     // Catch: Throwable -> L293
        r162 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L293
        goto L288
    L280:
        if ((r151 instanceof JSONArray) == false) goto L290;
    L250:
        r157 = r151;
    L319:
        th = move-exception;
        Result.Companion r164 = Result.Companion;     // Catch: Throwable -> L328
        r148 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L328
        Throwable r165 = Result.m9452exceptionOrNullimpl(r148);     // Catch: Throwable -> L328
        if (r165 == null) goto L324;
        EnsureManager.ensureNotReachHere(r165);     // Catch: Throwable -> L328
    L324:
        if (Result.m9455isFailureimpl(r148) == false) goto L326;
    L293:
        th = move-exception;
        Result.Companion r166 = Result.Companion;     // Catch: Throwable -> L319
        r153 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L319
        goto L295
    L178:
        if ((r144 instanceof Integer) == true) goto L180;
        Object r167 = null;
    L181:
        r145 = (Integer) r167;     // Catch: Throwable -> L223
        if (r145 != null) goto L221;
        if ((r144 instanceof Number) == false) goto L208;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L193;
        Float r168 = Float.valueOf(((Number) r144).floatValue());     // Catch: Throwable -> L223
        if ((r168 instanceof Integer) == true) goto L191;
        r168 = null;
    L191:
        r145 = (Integer) r168;     // Catch: Throwable -> L223
        goto L221
    L193:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L199;
        Double r169 = Double.valueOf(((Number) r144).doubleValue());     // Catch: Throwable -> L223
        if ((r169 instanceof Integer) == true) goto L197;
        r169 = null;
    L197:
        r145 = (Integer) r169;     // Catch: Throwable -> L223
        goto L221
    L199:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L202;
        r145 = Integer.valueOf(((Number) r144).intValue());     // Catch: Throwable -> L223
        goto L221
    L202:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L208;
        Long r170 = Long.valueOf(((Number) r144).longValue());     // Catch: Throwable -> L223
        if ((r170 instanceof Integer) == true) goto L206;
        r170 = null;
    L206:
        r145 = (Integer) r170;     // Catch: Throwable -> L223
    L208:
        if ((r144 instanceof JSONObject) == false) goto L210;
    L356:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L216
        Object r171 = SDKSettingsCacheManager.a().fromJson(r144.toString(), Integer.class);     // Catch: Throwable -> L216
        if ((r171 instanceof Integer) == true) goto L214;
        r171 = null;
    L214:
        Object r172 = Result.m9449constructorimpl((Integer) r171);     // Catch: Throwable -> L216
    L218:
        r145 = r172;
        if (Result.m9455isFailureimpl(r145) == false) goto L221;
    L216:
        th = move-exception;
        Result.Companion r173 = Result.Companion;     // Catch: Throwable -> L223
        r172 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L223
        goto L218
    L210:
        if ((r144 instanceof JSONArray) == false) goto L220;
    L180:
        r167 = r144;
    L223:
        th = move-exception;
        Result.Companion r174 = Result.Companion;     // Catch: Throwable -> L328
        r146 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L328
    L328:
        th = move-exception;
        Result.Companion r175 = Result.Companion;
        r139 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r176 = Result.m9452exceptionOrNullimpl(r139);
        if (r176 == null) goto L333;
        EnsureManager.ensureNotReachHere(r176);
    L333:
        if (Result.m9455isFailureimpl(r139) == false) goto L335;
        goto L335
    }
}
