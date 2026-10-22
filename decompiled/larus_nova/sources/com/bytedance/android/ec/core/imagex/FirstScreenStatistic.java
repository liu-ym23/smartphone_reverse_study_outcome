package com.bytedance.android.ec.core.imagex;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.monitor.ECMonitorService;
import com.bytedance.android.ec.hybrid.hostapi.IECHybridKevaService;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.apm.constant.UploadTypeInf;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.services.apm.api.EnsureManager;
import com.facebook.drawee.view.GenericDraweeView;
import com.facebook.imagepipeline.animated.base.AnimatedImage;
import com.facebook.imagepipeline.animated.base.AnimatedImageFrame;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.facebook.imagepipeline.image.CloseableAnimatedImage;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.request.ImageRequest;
import com.larus.apm.impl.protector.RunnableProtector;
import com.optimize.statistics.FrescoMonitorConst;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.effectmanager.MobConstants;
import java.io.File;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class FirstScreenStatistic {
    public static final AtomicInteger A = null;
    public static final q0 B = null;
    public static long C;
    public static final Set<String> D = null;
    public static final boolean E = false;
    public static final boolean F = false;
    public static final boolean G = false;
    public static boolean H;
    public static final Handler I = null;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static final ConcurrentHashMap<String, ConcurrentHashMap<String, i0>> f44357J = null;
    public static final ConcurrentHashMap<String, Boolean> K = null;
    public static final ConcurrentHashMap<ImageView, String> L = null;
    public static final ConcurrentHashMap<String, String> M = null;
    public static final ConcurrentHashMap<String, p0> N = null;
    public static final ConcurrentHashMap<String, Bitmap> O = null;
    public static final ConcurrentHashMap<String, Deferred<Bitmap>> P = null;
    public static final ConcurrentLinkedQueue<com.bytedance.android.ec.core.imagex.a> Q = null;
    public static final Lazy R = null;
    public static final FirstScreenStatistic S = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f44358a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f44359b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile boolean f44360c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static long f44361d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f44362e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final HashMap<String, HashMap<String, i0>> f44363f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final HashMap<String, HashMap<String, i0>> f44364g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final HashMap<String, o0> f44365h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Set<String> f44366i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final List<String> f44367j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final List<String> f44368k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final List<String> f44369l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final boolean f44370m = false;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final boolean f44371n = false;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final boolean f44372o = false;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final boolean f44373p = false;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final HashSet<String> f44374q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final Set<String> f44375r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final Set<String> f44376s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static boolean f44377t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static boolean f44378u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final HashSet<String> f44379v = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final HashSet<String> f44380w = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final AtomicInteger f44381x = null;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final AtomicInteger f44382y = null;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final HashSet<String> f44383z = null;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f44384a;

        public a(String r100) {
            this.f44384a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            FirstScreenStatistic r100 = FirstScreenStatistic.S;     // Catch: Throwable -> L4
            String r101 = this.f44384a;     // Catch: Throwable -> L4
            r100.getClass();     // Catch: Throwable -> L4
            FirstScreenStatistic.j(r101);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Bitmap f44385a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f44386b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f44387c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f44388d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Map f44389e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ long f44390f;

        public b(Bitmap r100, String r101, int r102, int r103, Map r104, long r105) {
            this.f44385a = r100;
            this.f44386b = r101;
            this.f44387c = r102;
            this.f44388d = r103;
            this.f44389e = r104;
            this.f44390f = r105;
        }

        @Override // java.lang.Runnable
        public final void run() {
            FirstScreenStatistic r100 = FirstScreenStatistic.S;     // Catch: Throwable -> L4
            Bitmap r101 = this.f44385a;     // Catch: Throwable -> L4
            String r102 = this.f44386b;     // Catch: Throwable -> L4
            int r103 = this.f44387c;     // Catch: Throwable -> L4
            int r104 = this.f44388d;     // Catch: Throwable -> L4
            Map r105 = this.f44389e;     // Catch: Throwable -> L4
            long r106 = this.f44390f;     // Catch: Throwable -> L4
            r100.getClass();     // Catch: Throwable -> L4
            FirstScreenStatistic.u(r101, r102, r103, r104, r105, r106);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Bitmap f44391a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f44392b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f44393c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f44394d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Map f44395e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ long f44396f;

        public c(Bitmap r100, String r101, int r102, int r103, Map r104, long r105) {
            this.f44391a = r100;
            this.f44392b = r101;
            this.f44393c = r102;
            this.f44394d = r103;
            this.f44395e = r104;
            this.f44396f = r105;
        }

        @Override // java.lang.Runnable
        public final void run() {
            FirstScreenStatistic r100 = FirstScreenStatistic.S;     // Catch: Throwable -> L4
            Bitmap r101 = this.f44391a;     // Catch: Throwable -> L4
            String r102 = this.f44392b;     // Catch: Throwable -> L4
            int r103 = this.f44393c;     // Catch: Throwable -> L4
            int r104 = this.f44394d;     // Catch: Throwable -> L4
            Map r105 = this.f44395e;     // Catch: Throwable -> L4
            long r106 = this.f44396f;     // Catch: Throwable -> L4
            r100.getClass();     // Catch: Throwable -> L4
            FirstScreenStatistic.u(r101, r102, r103, r104, r105, r106);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public FirstScreenStatistic() {
    }

    public static void c() {
        Iterator<Map.Entry<String, o0>> r100 = f44365h.entrySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L32;
        o0 r101 = r100.next().getValue();
        if (r101.f44696e < 0) goto L4;
        if (r101.f44698g == null) goto L4;
        JSONObject r102 = new JSONObject();     // Catch: Exception -> L30
        r102.put("loadStartTime", r101.f44694c);     // Catch: Exception -> L30
        r102.put("loadEndTime", r101.f44695d);     // Catch: Exception -> L30
        r102.put("loadCostTime", r101.f44696e);     // Catch: Exception -> L30
        int r103 = r101.f44697f;     // Catch: Exception -> L30
        if (r103 != 0) goto L12;
        String r104 = "network";
    L28:
        r102.put("from", r104);     // Catch: Exception -> L30
        r102.put("sceneTag", r101.f44693b);     // Catch: Exception -> L30
        r102.put("loadType", r101.f44698g);     // Catch: Exception -> L30
        r102.put("url", r101.f44692a);     // Catch: Exception -> L30
        int r105 = ECMonitorService.f45110b;     // Catch: Exception -> L30
        ECMonitorService.a.a("first_screen_load_image_info", r102, null, null);     // Catch: Exception -> L30
        dm.a.a("FirstScreenStatistic").a("first_screen_load_image_info " + r102.toString());     // Catch: Exception -> L30
    L31:
        r100.remove();
        goto L4
    L12:
        if (r103 != 1) goto L14;
        r104 = "memory_encode";
        goto L28
    L14:
        if (r103 != 2) goto L16;
        r104 = UploadTypeInf.DISK;
        goto L28
    L16:
        if (r103 != 3) goto L18;
        r104 = "memory_decode";
        goto L28
    L18:
        if (r103 != 4) goto L20;
        r104 = "bitmap_cache";
        goto L28
    L20:
        if (r103 == 5) goto L22;
        r104 = "unkown";
        goto L28
    L22:
        r104 = "simple_fresco";
    L30:
        ECExceptionMonitor.c("batchReportLoadImageInfo json error");
        goto L31
    }

    public static void r() {
        Set r100 = CollectionsKt.toSet(L.values());
        dm.a.a("FirstScreenStatistic").a("saveFirstScreenImageSet: " + r100.size() + ' ' + CollectionsKt.joinToString$default(r100, null, null, null, 0, null, null, 63, null));
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new FirstScreenStatistic$saveFirstScreenImageSet$1(r100, null), 3, null);
    }

    public static void e() {
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new FirstScreenStatistic$clear$1(null), 3, null);
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new FirstScreenStatistic$clear$2(null), 3, null);
    }

    static {
        S = new FirstScreenStatistic();
        f44363f = new HashMap();
        f44364g = new HashMap();
        f44365h = new HashMap();
        f44366i = new LinkedHashSet();
        List<String> r100 = CollectionsKt.listOf(new String[]{"ec_na_mall_header", "ec_na_mall_topbar", "ec_na_mall_background", "ec_na_mall_combined", "ec_na_mall_product", "ec_na_mall_top_category_tab", "ec_na_mall_live_product", "ec_na_mall_live_cover", "ec_na_mall_live_avatar", "ec_na_mall_video_product", "ec_na_mall_video_avatar", "ec_na_mall_video_cover"});
        f44367j = r100;
        f44368k = CollectionsKt.listOf(new String[]{"ec_na_mall_header", "ec_na_mall_topbar", "ec_na_mall_background", "ec_na_mall_top_category_tab"});
        f44369l = r100;
        int r101 = com.bytedance.android.ec.core.imagex.opt.h0.f44861a;
        Object r102 = Boolean.FALSE;
        Object r103 = null;
        if (com.bytedance.android.ec.core.imagex.opt.z.b() == false) goto L93;
        int r104 = com.bytedance.android.ec.base.settings.g.f42821a;
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L83
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L58
        Object r106 = SDKSettingsCacheManager.b().get("ec_first_screen_image_monitor_enable");     // Catch: Throwable -> L58
        if (r106 != null) goto L10;
    L55:
        Object r107 = null;
    L56:
        Object r108 = Result.m9449constructorimpl(r107);     // Catch: Throwable -> L58
    L60:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);     // Catch: Throwable -> L83
        if (r109 == null) goto L64;
        EnsureManager.ensureNotReachHere(r109);     // Catch: Throwable -> L83
    L64:
        if (Result.m9455isFailureimpl(r108) == false) goto L67;
        r108 = null;
    L67:
        if ((r108 instanceof Boolean) == true) goto L69;
        r108 = null;
    L69:
        Object r110 = (Boolean) r108;     // Catch: Throwable -> L83
        if (r110 != null) goto L179;
        Object r111 = jj4.a.a("ec_first_screen_image_monitor_enable", Boolean.class, r102, jj4.b.f499326b.a());     // Catch: Throwable -> L83
        if (r111 != null) goto L76;
        Intrinsics.throwNpe();     // Catch: Throwable -> L83
    L76:
        if ((r111 instanceof Boolean) == true) goto L78;
        r111 = null;
    L78:
        Object r112 = (Boolean) r111;     // Catch: Throwable -> L83
        if (r112 != null) goto L81;
        r112 = r102;
    L81:
        r110 = Result.m9449constructorimpl(r112);     // Catch: Throwable -> L83
    L86:
        if (Result.m9452exceptionOrNullimpl(r110) == null) goto L179;
        r110 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ec_first_screen_image_monitor_enable", Boolean.class, r102);     // Catch: Throwable -> L90
    L91:
        if (r110 != null) goto L179;
    L180:
        f44370m = ((Boolean) r102).booleanValue();
        boolean r113 = true;
        f44371n = true;
        int r114 = com.bytedance.android.ec.core.imagex.opt.h0.f44861a;
        Object r115 = Boolean.FALSE;
        if (com.bytedance.android.ec.core.imagex.opt.z.b() == false) goto L271;
        int r116 = com.bytedance.android.ec.base.settings.g.f42821a;
        Result.Companion r117 = Result.Companion;     // Catch: Throwable -> L261
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L236
        Object r118 = SDKSettingsCacheManager.b().get("ec_first_screen_simple_fresco_opt_enable");     // Catch: Throwable -> L236
        if (r118 != null) goto L188;
    L233:
        Object r119 = null;
    L234:
        Object r120 = Result.m9449constructorimpl(r119);     // Catch: Throwable -> L236
    L238:
        Throwable r121 = Result.m9452exceptionOrNullimpl(r120);     // Catch: Throwable -> L261
        if (r121 == null) goto L242;
        EnsureManager.ensureNotReachHere(r121);     // Catch: Throwable -> L261
    L242:
        if (Result.m9455isFailureimpl(r120) == false) goto L245;
        r120 = null;
    L245:
        if ((r120 instanceof Boolean) == true) goto L247;
        r120 = null;
    L247:
        Object r122 = (Boolean) r120;     // Catch: Throwable -> L261
        if (r122 != null) goto L357;
        Object r123 = jj4.a.a("ec_first_screen_simple_fresco_opt_enable", Boolean.class, r115, jj4.b.f499326b.a());     // Catch: Throwable -> L261
        if (r123 != null) goto L254;
        Intrinsics.throwNpe();     // Catch: Throwable -> L261
    L254:
        if ((r123 instanceof Boolean) == true) goto L256;
        r123 = null;
    L256:
        Object r124 = (Boolean) r123;     // Catch: Throwable -> L261
        if (r124 != null) goto L259;
        r124 = r115;
    L259:
        r122 = Result.m9449constructorimpl(r124);     // Catch: Throwable -> L261
    L264:
        if (Result.m9452exceptionOrNullimpl(r122) == null) goto L357;
        r122 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ec_first_screen_simple_fresco_opt_enable", Boolean.class, r115);     // Catch: Throwable -> L268
    L269:
        if (r122 != null) goto L357;
    L358:
        f44372o = ((Boolean) r115).booleanValue();
        int r125 = com.bytedance.android.ec.core.imagex.opt.h0.f44861a;
        Object r126 = Boolean.TRUE;
        if (com.bytedance.android.ec.core.imagex.opt.z.b() == false) goto L449;
        int r127 = com.bytedance.android.ec.base.settings.g.f42821a;
        Result.Companion r128 = Result.Companion;     // Catch: Throwable -> L439
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L414
        Object r129 = SDKSettingsCacheManager.b().get("ec_first_screen_post_fix_enable");     // Catch: Throwable -> L414
        if (r129 != null) goto L366;
    L411:
        Object r130 = null;
    L412:
        Object r131 = Result.m9449constructorimpl(r130);     // Catch: Throwable -> L414
    L416:
        Throwable r132 = Result.m9452exceptionOrNullimpl(r131);     // Catch: Throwable -> L439
        if (r132 == null) goto L420;
        EnsureManager.ensureNotReachHere(r132);     // Catch: Throwable -> L439
    L420:
        if (Result.m9455isFailureimpl(r131) == false) goto L423;
        r131 = null;
    L423:
        if ((r131 instanceof Boolean) == true) goto L425;
        r131 = null;
    L425:
        Object r133 = (Boolean) r131;     // Catch: Throwable -> L439
        if (r133 != null) goto L535;
        Object r134 = jj4.a.a("ec_first_screen_post_fix_enable", Boolean.class, r126, jj4.b.f499326b.a());     // Catch: Throwable -> L439
        if (r134 != null) goto L432;
        Intrinsics.throwNpe();     // Catch: Throwable -> L439
    L432:
        if ((r134 instanceof Boolean) == true) goto L434;
        r134 = null;
    L434:
        Object r135 = (Boolean) r134;     // Catch: Throwable -> L439
        if (r135 != null) goto L437;
        r135 = r126;
    L437:
        r133 = Result.m9449constructorimpl(r135);     // Catch: Throwable -> L439
    L442:
        if (Result.m9452exceptionOrNullimpl(r133) == null) goto L535;
        r133 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ec_first_screen_post_fix_enable", Boolean.class, r126);     // Catch: Throwable -> L446
    L447:
        if (r133 != null) goto L535;
    L536:
        f44373p = ((Boolean) r126).booleanValue();
        f44374q = new HashSet();
        f44375r = new LinkedHashSet();
        f44376s = new LinkedHashSet();
        f44379v = new HashSet();
        f44380w = new HashSet();
        f44381x = new AtomicInteger(0);
        f44382y = new AtomicInteger(0);
        f44383z = new HashSet();
        A = new AtomicInteger(0);
        B = new q0();
        D = new LinkedHashSet();
        int r136 = com.bytedance.android.ec.core.imagex.opt.h0.f44861a;
        Object r137 = Boolean.FALSE;
        if (com.bytedance.android.ec.core.imagex.opt.z.b() == false) goto L627;
        int r138 = com.bytedance.android.ec.base.settings.g.f42821a;
        Result.Companion r139 = Result.Companion;     // Catch: Throwable -> L617
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L592
        Object r140 = SDKSettingsCacheManager.b().get("ec_first_screen_bitmap_place_holder");     // Catch: Throwable -> L592
        if (r140 != null) goto L544;
    L589:
        Object r141 = null;
    L590:
        Object r142 = Result.m9449constructorimpl(r141);     // Catch: Throwable -> L592
    L594:
        Throwable r143 = Result.m9452exceptionOrNullimpl(r142);     // Catch: Throwable -> L617
        if (r143 == null) goto L598;
        EnsureManager.ensureNotReachHere(r143);     // Catch: Throwable -> L617
    L598:
        if (Result.m9455isFailureimpl(r142) == false) goto L601;
        r142 = null;
    L601:
        if ((r142 instanceof Boolean) == true) goto L603;
        r142 = null;
    L603:
        Object r144 = (Boolean) r142;     // Catch: Throwable -> L617
        if (r144 != null) goto L713;
        Object r145 = jj4.a.a("ec_first_screen_bitmap_place_holder", Boolean.class, r137, jj4.b.f499326b.a());     // Catch: Throwable -> L617
        if (r145 != null) goto L610;
        Intrinsics.throwNpe();     // Catch: Throwable -> L617
    L610:
        if ((r145 instanceof Boolean) == true) goto L612;
        r145 = null;
    L612:
        Object r146 = (Boolean) r145;     // Catch: Throwable -> L617
        if (r146 != null) goto L615;
        r146 = r137;
    L615:
        r144 = Result.m9449constructorimpl(r146);     // Catch: Throwable -> L617
    L620:
        if (Result.m9452exceptionOrNullimpl(r144) == null) goto L713;
        r144 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ec_first_screen_bitmap_place_holder", Boolean.class, r137);     // Catch: Throwable -> L624
    L625:
        if (r144 != null) goto L713;
    L714:
        E = ((Boolean) r137).booleanValue();
        int r147 = com.bytedance.android.ec.core.imagex.opt.h0.f44861a;
        Object r148 = Boolean.FALSE;
        if (com.bytedance.android.ec.core.imagex.opt.z.b() == false) goto L805;
        int r149 = com.bytedance.android.ec.base.settings.g.f42821a;
        Result.Companion r150 = Result.Companion;     // Catch: Throwable -> L795
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L770
        Object r151 = SDKSettingsCacheManager.b().get("ec_first_screen_delay_late_flip_enable");     // Catch: Throwable -> L770
        if (r151 != null) goto L722;
    L767:
        Object r152 = null;
    L768:
        Object r153 = Result.m9449constructorimpl(r152);     // Catch: Throwable -> L770
    L772:
        Throwable r154 = Result.m9452exceptionOrNullimpl(r153);     // Catch: Throwable -> L795
        if (r154 == null) goto L776;
        EnsureManager.ensureNotReachHere(r154);     // Catch: Throwable -> L795
    L776:
        if (Result.m9455isFailureimpl(r153) == false) goto L779;
        r153 = null;
    L779:
        if ((r153 instanceof Boolean) == true) goto L781;
        r153 = null;
    L781:
        Object r155 = (Boolean) r153;     // Catch: Throwable -> L795
        if (r155 != null) goto L891;
        Object r156 = jj4.a.a("ec_first_screen_delay_late_flip_enable", Boolean.class, r148, jj4.b.f499326b.a());     // Catch: Throwable -> L795
        if (r156 != null) goto L788;
        Intrinsics.throwNpe();     // Catch: Throwable -> L795
    L788:
        if ((r156 instanceof Boolean) == true) goto L790;
        r156 = null;
    L790:
        Object r157 = (Boolean) r156;     // Catch: Throwable -> L795
        if (r157 != null) goto L793;
        r157 = r148;
    L793:
        r155 = Result.m9449constructorimpl(r157);     // Catch: Throwable -> L795
    L798:
        if (Result.m9452exceptionOrNullimpl(r155) == null) goto L891;
        r155 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ec_first_screen_delay_late_flip_enable", Boolean.class, r148);     // Catch: Throwable -> L802
    L803:
        if (r155 != null) goto L891;
    L892:
        F = ((Boolean) r148).booleanValue();
        int r158 = com.bytedance.android.ec.core.imagex.opt.h0.f44861a;
        Object r159 = Boolean.FALSE;
        if (com.bytedance.android.ec.core.imagex.opt.z.b() == false) goto L983;
        int r160 = com.bytedance.android.ec.base.settings.g.f42821a;
        Result.Companion r161 = Result.Companion;     // Catch: Throwable -> L973
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L948
        Object r162 = SDKSettingsCacheManager.b().get("ec_first_screen_lynx_bitmap_hit_enable");     // Catch: Throwable -> L948
        if (r162 != null) goto L900;
    L945:
        Object r163 = null;
    L946:
        Object r164 = Result.m9449constructorimpl(r163);     // Catch: Throwable -> L948
    L950:
        Throwable r165 = Result.m9452exceptionOrNullimpl(r164);     // Catch: Throwable -> L973
        if (r165 == null) goto L954;
        EnsureManager.ensureNotReachHere(r165);     // Catch: Throwable -> L973
    L954:
        if (Result.m9455isFailureimpl(r164) == false) goto L957;
        r164 = null;
    L957:
        if ((r164 instanceof Boolean) == true) goto L959;
        r164 = null;
    L959:
        Object r166 = (Boolean) r164;     // Catch: Throwable -> L973
        if (r166 != null) goto L1069;
        Object r167 = jj4.a.a("ec_first_screen_lynx_bitmap_hit_enable", Boolean.class, r159, jj4.b.f499326b.a());     // Catch: Throwable -> L973
        if (r167 != null) goto L966;
        Intrinsics.throwNpe();     // Catch: Throwable -> L973
    L966:
        if ((r167 instanceof Boolean) == true) goto L968;
        r167 = null;
    L968:
        Object r168 = (Boolean) r167;     // Catch: Throwable -> L973
        if (r168 != null) goto L971;
        r168 = r159;
    L971:
        r166 = Result.m9449constructorimpl(r168);     // Catch: Throwable -> L973
    L976:
        if (Result.m9452exceptionOrNullimpl(r166) == null) goto L1069;
        r166 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ec_first_screen_lynx_bitmap_hit_enable", Boolean.class, r159);     // Catch: Throwable -> L980
    L981:
        if (r166 != null) goto L1069;
    L1070:
        ((Boolean) r159).booleanValue();
        G = true;
        I = new Handler(Looper.getMainLooper());
        f44357J = new ConcurrentHashMap();
        K = new ConcurrentHashMap();
        L = new ConcurrentHashMap();
        M = new ConcurrentHashMap();
        new ConcurrentHashMap();
        N = new ConcurrentHashMap();
        O = new ConcurrentHashMap();
        P = new ConcurrentHashMap();
        Q = new ConcurrentLinkedQueue();
        R = LazyKt.lazy(FirstScreenStatistic$bitmapCacheDir$2.INSTANCE);
        if (f44370m == false) goto L1365;
        int r169 = com.bytedance.android.ec.core.imagex.opt.h0.f44861a;
        Object r170 = "";
        if (com.bytedance.android.ec.core.imagex.opt.z.b() == false) goto L1164;
        int r171 = com.bytedance.android.ec.base.settings.g.f42821a;
        Result.Companion r172 = Result.Companion;     // Catch: Throwable -> L1154
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L1128
        Object r173 = SDKSettingsCacheManager.b().get("ec_first_screen_image_filter");     // Catch: Throwable -> L1128
        if (r173 != null) goto L1080;
    L1125:
        Object r174 = null;
    L1126:
        Object r175 = Result.m9449constructorimpl(r174);     // Catch: Throwable -> L1128
    L1130:
        Throwable r176 = Result.m9452exceptionOrNullimpl(r175);     // Catch: Throwable -> L1154
        if (r176 == null) goto L1134;
        EnsureManager.ensureNotReachHere(r176);     // Catch: Throwable -> L1154
    L1134:
        if (Result.m9455isFailureimpl(r175) == false) goto L1137;
        r175 = null;
    L1137:
        if ((r175 instanceof String) == true) goto L1139;
        r175 = null;
    L1139:
        Object r177 = (String) r175;     // Catch: Throwable -> L1154
        if (r177 != null) goto L1252;
        Object r178 = jj4.a.a("ec_first_screen_image_filter", String.class, "", jj4.b.f499326b.a());     // Catch: Throwable -> L1154
        if (r178 != null) goto L1146;
        Intrinsics.throwNpe();     // Catch: Throwable -> L1154
    L1146:
        if ((r178 instanceof String) == false) goto L1149;
        r103 = r178;
    L1149:
        String r179 = (String) r103;     // Catch: Throwable -> L1154
        if (r179 != null) goto L1152;
        r179 = "";
    L1152:
        r177 = Result.m9449constructorimpl(r179);     // Catch: Throwable -> L1154
    L1157:
        if (Result.m9452exceptionOrNullimpl(r177) == null) goto L1252;
        r177 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ec_first_screen_image_filter", String.class, "");     // Catch: Throwable -> L1161
    L1162:
        if (r177 != null) goto L1252;
    L1253:
        String r180 = (String) r170;
        if (r180.length() > 0) goto L1257;
        r113 = false;
    L1257:
        if (r113 == false) goto L1259;
        f44369l = StringsKt.split$default(r180, new String[]{","}, false, 0, 6, null);
    L1260:
        Iterator<T> r181 = f44369l.iterator();
    L1262:
        if (r181.hasNext() == false) goto L1264;
        String r182 = (String) r181.next();
        f44363f.put(r182, new HashMap());
        f44364g.put(r182, new HashMap());
        f44357J.put(r182, new ConcurrentHashMap());
        goto L1262
    L1264:
        f44363f.put("ec_na_mall_other", new HashMap());
        f44364g.put("ec_na_mall_other", new HashMap());
        f44357J.put("ec_na_mall_other", new ConcurrentHashMap());
        return;
    L1259:
        f44369l = f44367j;
    L1161:
        r177 = "";
    L1252:
        r170 = r177;
        goto L1253
    L1080:
        if ((r173 instanceof String) == true) goto L1082;
        Object r183 = null;
    L1083:
        r174 = (String) r183;     // Catch: Throwable -> L1128
        if (r174 != null) goto L1126;
        if ((r173 instanceof Number) == false) goto L1113;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L1095;
        Float r184 = Float.valueOf(((Number) r173).floatValue());     // Catch: Throwable -> L1128
        if ((r184 instanceof String) == true) goto L1093;
        r184 = null;
    L1093:
        r174 = (String) r184;     // Catch: Throwable -> L1128
        goto L1126
    L1095:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L1101;
        Double r185 = Double.valueOf(((Number) r173).doubleValue());     // Catch: Throwable -> L1128
        if ((r185 instanceof String) == true) goto L1099;
        r185 = null;
    L1099:
        r174 = (String) r185;     // Catch: Throwable -> L1128
        goto L1126
    L1101:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L1107;
        Integer r186 = Integer.valueOf(((Number) r173).intValue());     // Catch: Throwable -> L1128
        if ((r186 instanceof String) == true) goto L1105;
        r186 = null;
    L1105:
        r174 = (String) r186;     // Catch: Throwable -> L1128
        goto L1126
    L1107:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L1113;
        Long r187 = Long.valueOf(((Number) r173).longValue());     // Catch: Throwable -> L1128
        if ((r187 instanceof String) == true) goto L1111;
        r187 = null;
    L1111:
        r174 = (String) r187;     // Catch: Throwable -> L1128
    L1113:
        if ((r173 instanceof JSONObject) == false) goto L1115;
    L1282:
        Object r188 = SDKSettingsCacheManager.a().fromJson(r173.toString(), String.class);     // Catch: Throwable -> L1121
        if ((r188 instanceof String) == true) goto L1119;
        r188 = null;
    L1119:
        Object r189 = Result.m9449constructorimpl((String) r188);     // Catch: Throwable -> L1121
    L1123:
        r174 = r189;
        if (Result.m9455isFailureimpl(r174) == false) goto L1126;
    L1121:
        th = move-exception;
        Result.Companion r190 = Result.Companion;     // Catch: Throwable -> L1128
        r189 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L1128
        goto L1123
    L1115:
        if ((r173 instanceof JSONArray) == false) goto L1125;
    L1082:
        r183 = r173;
    L1128:
        th = move-exception;
        Result.Companion r191 = Result.Companion;     // Catch: Throwable -> L1154
        r175 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L1154
    L1154:
        th = move-exception;
        Result.Companion r192 = Result.Companion;
        r177 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L1157
    L1164:
        int r193 = com.bytedance.android.ec.core.opt.ab.n.f45241a;
        int r194 = com.bytedance.android.ec.base.settings.c.f42815a;
        Result.Companion r195 = Result.Companion;     // Catch: Throwable -> L1245
        Object r196 = com.bytedance.android.ec.base.settings.d.a().get("ec_first_screen_image_filter");     // Catch: Throwable -> L1218
        if (r196 != null) goto L1170;
    L1215:
        Object r197 = null;
    L1216:
        Object r198 = Result.m9449constructorimpl(r197);     // Catch: Throwable -> L1218
    L1220:
        Throwable r199 = Result.m9452exceptionOrNullimpl(r198);     // Catch: Throwable -> L1245
        if (r199 == null) goto L1224;
        EnsureManager.ensureNotReachHere(r199);     // Catch: Throwable -> L1245
    L1224:
        if (Result.m9455isFailureimpl(r198) == false) goto L1227;
        r198 = null;
    L1227:
        if ((r198 instanceof String) == true) goto L1229;
        r198 = null;
    L1229:
        r177 = (String) r198;     // Catch: Throwable -> L1245
        if (r177 != null) goto L1252;
        IHybridHostService r200 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L1245
        if (r200 == null) goto L1235;
        Object r201 = r200.getHostABValue("ec_first_screen_image_filter", "");     // Catch: Throwable -> L1245
    L1236:
        if (r201 == null) goto L1253;
        if ((r201 instanceof String) == false) goto L1241;
        r103 = r201;
    L1241:
        String r202 = (String) r103;     // Catch: Throwable -> L1245
        if (r202 == null) goto L1253;
        r170 = r202;
        goto L1253
    L1235:
        r201 = null;
        goto L1236
    L1170:
        if ((r196 instanceof String) == true) goto L1172;
        Object r203 = null;
    L1173:
        r197 = (String) r203;     // Catch: Throwable -> L1218
        if (r197 != null) goto L1216;
        if ((r196 instanceof Number) == false) goto L1203;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L1185;
        Float r204 = Float.valueOf(((Number) r196).floatValue());     // Catch: Throwable -> L1218
        if ((r204 instanceof String) == true) goto L1183;
        r204 = null;
    L1183:
        r197 = (String) r204;     // Catch: Throwable -> L1218
        goto L1216
    L1185:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L1191;
        Double r205 = Double.valueOf(((Number) r196).doubleValue());     // Catch: Throwable -> L1218
        if ((r205 instanceof String) == true) goto L1189;
        r205 = null;
    L1189:
        r197 = (String) r205;     // Catch: Throwable -> L1218
        goto L1216
    L1191:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L1197;
        Integer r206 = Integer.valueOf(((Number) r196).intValue());     // Catch: Throwable -> L1218
        if ((r206 instanceof String) == true) goto L1195;
        r206 = null;
    L1195:
        r197 = (String) r206;     // Catch: Throwable -> L1218
        goto L1216
    L1197:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L1203;
        Long r207 = Long.valueOf(((Number) r196).longValue());     // Catch: Throwable -> L1218
        if ((r207 instanceof String) == true) goto L1201;
        r207 = null;
    L1201:
        r197 = (String) r207;     // Catch: Throwable -> L1218
    L1203:
        if ((r196 instanceof JSONObject) == false) goto L1205;
    L1268:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L1211
        Object r208 = SDKSettingsCacheManager.a().fromJson(r196.toString(), String.class);     // Catch: Throwable -> L1211
        if ((r208 instanceof String) == true) goto L1209;
        r208 = null;
    L1209:
        Object r209 = Result.m9449constructorimpl((String) r208);     // Catch: Throwable -> L1211
    L1213:
        r197 = r209;
        if (Result.m9455isFailureimpl(r197) == false) goto L1216;
    L1211:
        th = move-exception;
        Result.Companion r210 = Result.Companion;     // Catch: Throwable -> L1218
        r209 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L1218
        goto L1213
    L1205:
        if ((r196 instanceof JSONArray) == false) goto L1215;
    L1172:
        r203 = r196;
    L1218:
        th = move-exception;
        Result.Companion r211 = Result.Companion;     // Catch: Throwable -> L1245
        r198 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L1245
    L1245:
        th = move-exception;
        Result.Companion r212 = Result.Companion;
        r177 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r213 = Result.m9452exceptionOrNullimpl(r177);
        if (r213 == null) goto L1250;
        EnsureManager.ensureNotReachHere(r213);
    L1250:
        if (Result.m9455isFailureimpl(r177) == false) goto L1252;
    L1365:
        return;
    L980:
        r166 = r159;
    L1069:
        r159 = r166;
        goto L1070
    L900:
        if ((r162 instanceof Boolean) == true) goto L902;
        Object r214 = null;
    L903:
        r163 = (Boolean) r214;     // Catch: Throwable -> L948
        if (r163 != null) goto L946;
        if ((r162 instanceof Number) == false) goto L933;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L915;
        Float r215 = Float.valueOf(((Number) r162).floatValue());     // Catch: Throwable -> L948
        if ((r215 instanceof Boolean) == true) goto L913;
        r215 = null;
    L913:
        r163 = (Boolean) r215;     // Catch: Throwable -> L948
        goto L946
    L915:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L921;
        Double r216 = Double.valueOf(((Number) r162).doubleValue());     // Catch: Throwable -> L948
        if ((r216 instanceof Boolean) == true) goto L919;
        r216 = null;
    L919:
        r163 = (Boolean) r216;     // Catch: Throwable -> L948
        goto L946
    L921:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L927;
        Integer r217 = Integer.valueOf(((Number) r162).intValue());     // Catch: Throwable -> L948
        if ((r217 instanceof Boolean) == true) goto L925;
        r217 = null;
    L925:
        r163 = (Boolean) r217;     // Catch: Throwable -> L948
        goto L946
    L927:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L933;
        Long r218 = Long.valueOf(((Number) r162).longValue());     // Catch: Throwable -> L948
        if ((r218 instanceof Boolean) == true) goto L931;
        r218 = null;
    L931:
        r163 = (Boolean) r218;     // Catch: Throwable -> L948
    L933:
        if ((r162 instanceof JSONObject) == false) goto L935;
    L1356:
        Object r219 = SDKSettingsCacheManager.a().fromJson(r162.toString(), Boolean.class);     // Catch: Throwable -> L941
        if ((r219 instanceof Boolean) == true) goto L939;
        r219 = null;
    L939:
        Object r220 = Result.m9449constructorimpl((Boolean) r219);     // Catch: Throwable -> L941
    L943:
        r163 = r220;
        if (Result.m9455isFailureimpl(r163) == false) goto L946;
    L941:
        th = move-exception;
        Result.Companion r221 = Result.Companion;     // Catch: Throwable -> L948
        r220 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L948
        goto L943
    L935:
        if ((r162 instanceof JSONArray) == false) goto L945;
    L902:
        r214 = r162;
    L948:
        th = move-exception;
        Result.Companion r222 = Result.Companion;     // Catch: Throwable -> L973
        r164 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L973
    L973:
        th = move-exception;
        Result.Companion r223 = Result.Companion;
        r166 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L976
    L983:
        int r224 = com.bytedance.android.ec.core.opt.ab.n.f45241a;
        int r225 = com.bytedance.android.ec.base.settings.c.f42815a;
        Result.Companion r226 = Result.Companion;     // Catch: Throwable -> L1062
        Object r227 = com.bytedance.android.ec.base.settings.d.a().get("ec_first_screen_lynx_bitmap_hit_enable");     // Catch: Throwable -> L1037
        if (r227 != null) goto L989;
    L1034:
        Object r228 = null;
    L1035:
        Object r229 = Result.m9449constructorimpl(r228);     // Catch: Throwable -> L1037
    L1039:
        Throwable r230 = Result.m9452exceptionOrNullimpl(r229);     // Catch: Throwable -> L1062
        if (r230 == null) goto L1043;
        EnsureManager.ensureNotReachHere(r230);     // Catch: Throwable -> L1062
    L1043:
        if (Result.m9455isFailureimpl(r229) == false) goto L1046;
        r229 = null;
    L1046:
        if ((r229 instanceof Boolean) == true) goto L1048;
        r229 = null;
    L1048:
        r166 = (Boolean) r229;     // Catch: Throwable -> L1062
        if (r166 != null) goto L1069;
        IHybridHostService r231 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L1062
        if (r231 == null) goto L1054;
        Object r232 = r231.getHostABValue("ec_first_screen_lynx_bitmap_hit_enable", r159);     // Catch: Throwable -> L1062
    L1055:
        if (r232 == null) goto L1070;
        if ((r232 instanceof Boolean) == true) goto L1059;
        r232 = null;
    L1059:
        r166 = (Boolean) r232;     // Catch: Throwable -> L1062
        if (r166 != null) goto L1069;
    L1054:
        r232 = null;
        goto L1055
    L989:
        if ((r227 instanceof Boolean) == true) goto L991;
        Object r233 = null;
    L992:
        r228 = (Boolean) r233;     // Catch: Throwable -> L1037
        if (r228 != null) goto L1035;
        if ((r227 instanceof Number) == false) goto L1022;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L1004;
        Float r234 = Float.valueOf(((Number) r227).floatValue());     // Catch: Throwable -> L1037
        if ((r234 instanceof Boolean) == true) goto L1002;
        r234 = null;
    L1002:
        r228 = (Boolean) r234;     // Catch: Throwable -> L1037
        goto L1035
    L1004:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L1010;
        Double r235 = Double.valueOf(((Number) r227).doubleValue());     // Catch: Throwable -> L1037
        if ((r235 instanceof Boolean) == true) goto L1008;
        r235 = null;
    L1008:
        r228 = (Boolean) r235;     // Catch: Throwable -> L1037
        goto L1035
    L1010:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L1016;
        Integer r236 = Integer.valueOf(((Number) r227).intValue());     // Catch: Throwable -> L1037
        if ((r236 instanceof Boolean) == true) goto L1014;
        r236 = null;
    L1014:
        r228 = (Boolean) r236;     // Catch: Throwable -> L1037
        goto L1035
    L1016:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L1022;
        Long r237 = Long.valueOf(((Number) r227).longValue());     // Catch: Throwable -> L1037
        if ((r237 instanceof Boolean) == true) goto L1020;
        r237 = null;
    L1020:
        r228 = (Boolean) r237;     // Catch: Throwable -> L1037
    L1022:
        if ((r227 instanceof JSONObject) == false) goto L1024;
    L1342:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L1030
        Object r238 = SDKSettingsCacheManager.a().fromJson(r227.toString(), Boolean.class);     // Catch: Throwable -> L1030
        if ((r238 instanceof Boolean) == true) goto L1028;
        r238 = null;
    L1028:
        Object r239 = Result.m9449constructorimpl((Boolean) r238);     // Catch: Throwable -> L1030
    L1032:
        r228 = r239;
        if (Result.m9455isFailureimpl(r228) == false) goto L1035;
    L1030:
        th = move-exception;
        Result.Companion r240 = Result.Companion;     // Catch: Throwable -> L1037
        r239 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L1037
        goto L1032
    L1024:
        if ((r227 instanceof JSONArray) == false) goto L1034;
    L991:
        r233 = r227;
    L1037:
        th = move-exception;
        Result.Companion r241 = Result.Companion;     // Catch: Throwable -> L1062
        r229 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L1062
    L1062:
        th = move-exception;
        Result.Companion r242 = Result.Companion;
        r166 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r243 = Result.m9452exceptionOrNullimpl(r166);
        if (r243 == null) goto L1067;
        EnsureManager.ensureNotReachHere(r243);
    L1067:
        if (Result.m9455isFailureimpl(r166) == false) goto L1069;
    L802:
        r155 = r148;
    L891:
        r148 = r155;
        goto L892
    L722:
        if ((r151 instanceof Boolean) == true) goto L724;
        Object r244 = null;
    L725:
        r152 = (Boolean) r244;     // Catch: Throwable -> L770
        if (r152 != null) goto L768;
        if ((r151 instanceof Number) == false) goto L755;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L737;
        Float r245 = Float.valueOf(((Number) r151).floatValue());     // Catch: Throwable -> L770
        if ((r245 instanceof Boolean) == true) goto L735;
        r245 = null;
    L735:
        r152 = (Boolean) r245;     // Catch: Throwable -> L770
        goto L768
    L737:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L743;
        Double r246 = Double.valueOf(((Number) r151).doubleValue());     // Catch: Throwable -> L770
        if ((r246 instanceof Boolean) == true) goto L741;
        r246 = null;
    L741:
        r152 = (Boolean) r246;     // Catch: Throwable -> L770
        goto L768
    L743:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L749;
        Integer r247 = Integer.valueOf(((Number) r151).intValue());     // Catch: Throwable -> L770
        if ((r247 instanceof Boolean) == true) goto L747;
        r247 = null;
    L747:
        r152 = (Boolean) r247;     // Catch: Throwable -> L770
        goto L768
    L749:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L755;
        Long r248 = Long.valueOf(((Number) r151).longValue());     // Catch: Throwable -> L770
        if ((r248 instanceof Boolean) == true) goto L753;
        r248 = null;
    L753:
        r152 = (Boolean) r248;     // Catch: Throwable -> L770
    L755:
        if ((r151 instanceof JSONObject) == false) goto L757;
    L1298:
        Object r249 = SDKSettingsCacheManager.a().fromJson(r151.toString(), Boolean.class);     // Catch: Throwable -> L763
        if ((r249 instanceof Boolean) == true) goto L761;
        r249 = null;
    L761:
        Object r250 = Result.m9449constructorimpl((Boolean) r249);     // Catch: Throwable -> L763
    L765:
        r152 = r250;
        if (Result.m9455isFailureimpl(r152) == false) goto L768;
    L763:
        th = move-exception;
        Result.Companion r251 = Result.Companion;     // Catch: Throwable -> L770
        r250 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L770
        goto L765
    L757:
        if ((r151 instanceof JSONArray) == false) goto L767;
    L724:
        r244 = r151;
    L770:
        th = move-exception;
        Result.Companion r252 = Result.Companion;     // Catch: Throwable -> L795
        r153 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L795
    L795:
        th = move-exception;
        Result.Companion r253 = Result.Companion;
        r155 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L798
    L805:
        int r254 = com.bytedance.android.ec.core.opt.ab.n.f45241a;
        int r255 = com.bytedance.android.ec.base.settings.c.f42815a;
        Result.Companion r256 = Result.Companion;     // Catch: Throwable -> L884
        Object r257 = com.bytedance.android.ec.base.settings.d.a().get("ec_first_screen_delay_late_flip_enable");     // Catch: Throwable -> L859
        if (r257 != null) goto L811;
    L856:
        Object r258 = null;
    L857:
        Object r259 = Result.m9449constructorimpl(r258);     // Catch: Throwable -> L859
    L861:
        Throwable r260 = Result.m9452exceptionOrNullimpl(r259);     // Catch: Throwable -> L884
        if (r260 == null) goto L865;
        EnsureManager.ensureNotReachHere(r260);     // Catch: Throwable -> L884
    L865:
        if (Result.m9455isFailureimpl(r259) == false) goto L868;
        r259 = null;
    L868:
        if ((r259 instanceof Boolean) == true) goto L870;
        r259 = null;
    L870:
        r155 = (Boolean) r259;     // Catch: Throwable -> L884
        if (r155 != null) goto L891;
        IHybridHostService r261 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L884
        if (r261 == null) goto L876;
        Object r262 = r261.getHostABValue("ec_first_screen_delay_late_flip_enable", r148);     // Catch: Throwable -> L884
    L877:
        if (r262 == null) goto L892;
        if ((r262 instanceof Boolean) == true) goto L881;
        r262 = null;
    L881:
        r155 = (Boolean) r262;     // Catch: Throwable -> L884
        if (r155 != null) goto L891;
    L876:
        r262 = null;
        goto L877
    L811:
        if ((r257 instanceof Boolean) == true) goto L813;
        Object r263 = null;
    L814:
        r258 = (Boolean) r263;     // Catch: Throwable -> L859
        if (r258 != null) goto L857;
        if ((r257 instanceof Number) == false) goto L844;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L826;
        Float r264 = Float.valueOf(((Number) r257).floatValue());     // Catch: Throwable -> L859
        if ((r264 instanceof Boolean) == true) goto L824;
        r264 = null;
    L824:
        r258 = (Boolean) r264;     // Catch: Throwable -> L859
        goto L857
    L826:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L832;
        Double r265 = Double.valueOf(((Number) r257).doubleValue());     // Catch: Throwable -> L859
        if ((r265 instanceof Boolean) == true) goto L830;
        r265 = null;
    L830:
        r258 = (Boolean) r265;     // Catch: Throwable -> L859
        goto L857
    L832:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L838;
        Integer r266 = Integer.valueOf(((Number) r257).intValue());     // Catch: Throwable -> L859
        if ((r266 instanceof Boolean) == true) goto L836;
        r266 = null;
    L836:
        r258 = (Boolean) r266;     // Catch: Throwable -> L859
        goto L857
    L838:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L844;
        Long r267 = Long.valueOf(((Number) r257).longValue());     // Catch: Throwable -> L859
        if ((r267 instanceof Boolean) == true) goto L842;
        r267 = null;
    L842:
        r258 = (Boolean) r267;     // Catch: Throwable -> L859
    L844:
        if ((r257 instanceof JSONObject) == false) goto L846;
    L1280:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L852
        Object r268 = SDKSettingsCacheManager.a().fromJson(r257.toString(), Boolean.class);     // Catch: Throwable -> L852
        if ((r268 instanceof Boolean) == true) goto L850;
        r268 = null;
    L850:
        Object r269 = Result.m9449constructorimpl((Boolean) r268);     // Catch: Throwable -> L852
    L854:
        r258 = r269;
        if (Result.m9455isFailureimpl(r258) == false) goto L857;
    L852:
        th = move-exception;
        Result.Companion r270 = Result.Companion;     // Catch: Throwable -> L859
        r269 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L859
        goto L854
    L846:
        if ((r257 instanceof JSONArray) == false) goto L856;
    L813:
        r263 = r257;
    L859:
        th = move-exception;
        Result.Companion r271 = Result.Companion;     // Catch: Throwable -> L884
        r259 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L884
    L884:
        th = move-exception;
        Result.Companion r272 = Result.Companion;
        r155 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r273 = Result.m9452exceptionOrNullimpl(r155);
        if (r273 == null) goto L889;
        EnsureManager.ensureNotReachHere(r273);
    L889:
        if (Result.m9455isFailureimpl(r155) == false) goto L891;
    L624:
        r144 = r137;
    L713:
        r137 = r144;
        goto L714
    L544:
        if ((r140 instanceof Boolean) == true) goto L546;
        Object r274 = null;
    L547:
        r141 = (Boolean) r274;     // Catch: Throwable -> L592
        if (r141 != null) goto L590;
        if ((r140 instanceof Number) == false) goto L577;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L559;
        Float r275 = Float.valueOf(((Number) r140).floatValue());     // Catch: Throwable -> L592
        if ((r275 instanceof Boolean) == true) goto L557;
        r275 = null;
    L557:
        r141 = (Boolean) r275;     // Catch: Throwable -> L592
        goto L590
    L559:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L565;
        Double r276 = Double.valueOf(((Number) r140).doubleValue());     // Catch: Throwable -> L592
        if ((r276 instanceof Boolean) == true) goto L563;
        r276 = null;
    L563:
        r141 = (Boolean) r276;     // Catch: Throwable -> L592
        goto L590
    L565:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L571;
        Integer r277 = Integer.valueOf(((Number) r140).intValue());     // Catch: Throwable -> L592
        if ((r277 instanceof Boolean) == true) goto L569;
        r277 = null;
    L569:
        r141 = (Boolean) r277;     // Catch: Throwable -> L592
        goto L590
    L571:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L577;
        Long r278 = Long.valueOf(((Number) r140).longValue());     // Catch: Throwable -> L592
        if ((r278 instanceof Boolean) == true) goto L575;
        r278 = null;
    L575:
        r141 = (Boolean) r278;     // Catch: Throwable -> L592
    L577:
        if ((r140 instanceof JSONObject) == false) goto L579;
    L1334:
        Object r279 = SDKSettingsCacheManager.a().fromJson(r140.toString(), Boolean.class);     // Catch: Throwable -> L585
        if ((r279 instanceof Boolean) == true) goto L583;
        r279 = null;
    L583:
        Object r280 = Result.m9449constructorimpl((Boolean) r279);     // Catch: Throwable -> L585
    L587:
        r141 = r280;
        if (Result.m9455isFailureimpl(r141) == false) goto L590;
    L585:
        th = move-exception;
        Result.Companion r281 = Result.Companion;     // Catch: Throwable -> L592
        r280 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L592
        goto L587
    L579:
        if ((r140 instanceof JSONArray) == false) goto L589;
    L546:
        r274 = r140;
    L592:
        th = move-exception;
        Result.Companion r282 = Result.Companion;     // Catch: Throwable -> L617
        r142 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L617
    L617:
        th = move-exception;
        Result.Companion r283 = Result.Companion;
        r144 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L620
    L627:
        int r284 = com.bytedance.android.ec.core.opt.ab.n.f45241a;
        int r285 = com.bytedance.android.ec.base.settings.c.f42815a;
        Result.Companion r286 = Result.Companion;     // Catch: Throwable -> L706
        Object r287 = com.bytedance.android.ec.base.settings.d.a().get("ec_first_screen_bitmap_place_holder");     // Catch: Throwable -> L681
        if (r287 != null) goto L633;
    L678:
        Object r288 = null;
    L679:
        Object r289 = Result.m9449constructorimpl(r288);     // Catch: Throwable -> L681
    L683:
        Throwable r290 = Result.m9452exceptionOrNullimpl(r289);     // Catch: Throwable -> L706
        if (r290 == null) goto L687;
        EnsureManager.ensureNotReachHere(r290);     // Catch: Throwable -> L706
    L687:
        if (Result.m9455isFailureimpl(r289) == false) goto L690;
        r289 = null;
    L690:
        if ((r289 instanceof Boolean) == true) goto L692;
        r289 = null;
    L692:
        r144 = (Boolean) r289;     // Catch: Throwable -> L706
        if (r144 != null) goto L713;
        IHybridHostService r291 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L706
        if (r291 == null) goto L698;
        Object r292 = r291.getHostABValue("ec_first_screen_bitmap_place_holder", r137);     // Catch: Throwable -> L706
    L699:
        if (r292 == null) goto L714;
        if ((r292 instanceof Boolean) == true) goto L703;
        r292 = null;
    L703:
        r144 = (Boolean) r292;     // Catch: Throwable -> L706
        if (r144 != null) goto L713;
    L698:
        r292 = null;
        goto L699
    L633:
        if ((r287 instanceof Boolean) == true) goto L635;
        Object r293 = null;
    L636:
        r288 = (Boolean) r293;     // Catch: Throwable -> L681
        if (r288 != null) goto L679;
        if ((r287 instanceof Number) == false) goto L666;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L648;
        Float r294 = Float.valueOf(((Number) r287).floatValue());     // Catch: Throwable -> L681
        if ((r294 instanceof Boolean) == true) goto L646;
        r294 = null;
    L646:
        r288 = (Boolean) r294;     // Catch: Throwable -> L681
        goto L679
    L648:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L654;
        Double r295 = Double.valueOf(((Number) r287).doubleValue());     // Catch: Throwable -> L681
        if ((r295 instanceof Boolean) == true) goto L652;
        r295 = null;
    L652:
        r288 = (Boolean) r295;     // Catch: Throwable -> L681
        goto L679
    L654:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L660;
        Integer r296 = Integer.valueOf(((Number) r287).intValue());     // Catch: Throwable -> L681
        if ((r296 instanceof Boolean) == true) goto L658;
        r296 = null;
    L658:
        r288 = (Boolean) r296;     // Catch: Throwable -> L681
        goto L679
    L660:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L666;
        Long r297 = Long.valueOf(((Number) r287).longValue());     // Catch: Throwable -> L681
        if ((r297 instanceof Boolean) == true) goto L664;
        r297 = null;
    L664:
        r288 = (Boolean) r297;     // Catch: Throwable -> L681
    L666:
        if ((r287 instanceof JSONObject) == false) goto L668;
    L1324:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L674
        Object r298 = SDKSettingsCacheManager.a().fromJson(r287.toString(), Boolean.class);     // Catch: Throwable -> L674
        if ((r298 instanceof Boolean) == true) goto L672;
        r298 = null;
    L672:
        Object r299 = Result.m9449constructorimpl((Boolean) r298);     // Catch: Throwable -> L674
    L676:
        r288 = r299;
        if (Result.m9455isFailureimpl(r288) == false) goto L679;
    L674:
        th = move-exception;
        Result.Companion r300 = Result.Companion;     // Catch: Throwable -> L681
        r299 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L681
        goto L676
    L668:
        if ((r287 instanceof JSONArray) == false) goto L678;
    L635:
        r293 = r287;
    L681:
        th = move-exception;
        Result.Companion r301 = Result.Companion;     // Catch: Throwable -> L706
        r289 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L706
    L706:
        th = move-exception;
        Result.Companion r302 = Result.Companion;
        r144 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r303 = Result.m9452exceptionOrNullimpl(r144);
        if (r303 == null) goto L711;
        EnsureManager.ensureNotReachHere(r303);
    L711:
        if (Result.m9455isFailureimpl(r144) == false) goto L713;
    L446:
        r133 = r126;
    L535:
        r126 = r133;
        goto L536
    L366:
        if ((r129 instanceof Boolean) == true) goto L368;
        Object r304 = null;
    L369:
        r130 = (Boolean) r304;     // Catch: Throwable -> L414
        if (r130 != null) goto L412;
        if ((r129 instanceof Number) == false) goto L399;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L381;
        Float r305 = Float.valueOf(((Number) r129).floatValue());     // Catch: Throwable -> L414
        if ((r305 instanceof Boolean) == true) goto L379;
        r305 = null;
    L379:
        r130 = (Boolean) r305;     // Catch: Throwable -> L414
        goto L412
    L381:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L387;
        Double r306 = Double.valueOf(((Number) r129).doubleValue());     // Catch: Throwable -> L414
        if ((r306 instanceof Boolean) == true) goto L385;
        r306 = null;
    L385:
        r130 = (Boolean) r306;     // Catch: Throwable -> L414
        goto L412
    L387:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L393;
        Integer r307 = Integer.valueOf(((Number) r129).intValue());     // Catch: Throwable -> L414
        if ((r307 instanceof Boolean) == true) goto L391;
        r307 = null;
    L391:
        r130 = (Boolean) r307;     // Catch: Throwable -> L414
        goto L412
    L393:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L399;
        Long r308 = Long.valueOf(((Number) r129).longValue());     // Catch: Throwable -> L414
        if ((r308 instanceof Boolean) == true) goto L397;
        r308 = null;
    L397:
        r130 = (Boolean) r308;     // Catch: Throwable -> L414
    L399:
        if ((r129 instanceof JSONObject) == false) goto L401;
    L1316:
        Object r309 = SDKSettingsCacheManager.a().fromJson(r129.toString(), Boolean.class);     // Catch: Throwable -> L407
        if ((r309 instanceof Boolean) == true) goto L405;
        r309 = null;
    L405:
        Object r310 = Result.m9449constructorimpl((Boolean) r309);     // Catch: Throwable -> L407
    L409:
        r130 = r310;
        if (Result.m9455isFailureimpl(r130) == false) goto L412;
    L407:
        th = move-exception;
        Result.Companion r311 = Result.Companion;     // Catch: Throwable -> L414
        r310 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L414
        goto L409
    L401:
        if ((r129 instanceof JSONArray) == false) goto L411;
    L368:
        r304 = r129;
    L414:
        th = move-exception;
        Result.Companion r312 = Result.Companion;     // Catch: Throwable -> L439
        r131 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L439
    L439:
        th = move-exception;
        Result.Companion r313 = Result.Companion;
        r133 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L442
    L449:
        int r314 = com.bytedance.android.ec.core.opt.ab.n.f45241a;
        int r315 = com.bytedance.android.ec.base.settings.c.f42815a;
        Result.Companion r316 = Result.Companion;     // Catch: Throwable -> L528
        Object r317 = com.bytedance.android.ec.base.settings.d.a().get("ec_first_screen_post_fix_enable");     // Catch: Throwable -> L503
        if (r317 != null) goto L455;
    L500:
        Object r318 = null;
    L501:
        Object r319 = Result.m9449constructorimpl(r318);     // Catch: Throwable -> L503
    L505:
        Throwable r320 = Result.m9452exceptionOrNullimpl(r319);     // Catch: Throwable -> L528
        if (r320 == null) goto L509;
        EnsureManager.ensureNotReachHere(r320);     // Catch: Throwable -> L528
    L509:
        if (Result.m9455isFailureimpl(r319) == false) goto L512;
        r319 = null;
    L512:
        if ((r319 instanceof Boolean) == true) goto L514;
        r319 = null;
    L514:
        r133 = (Boolean) r319;     // Catch: Throwable -> L528
        if (r133 != null) goto L535;
        IHybridHostService r321 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L528
        if (r321 == null) goto L520;
        Object r322 = r321.getHostABValue("ec_first_screen_post_fix_enable", r126);     // Catch: Throwable -> L528
    L521:
        if (r322 == null) goto L536;
        if ((r322 instanceof Boolean) == true) goto L525;
        r322 = null;
    L525:
        r133 = (Boolean) r322;     // Catch: Throwable -> L528
        if (r133 != null) goto L535;
    L520:
        r322 = null;
        goto L521
    L455:
        if ((r317 instanceof Boolean) == true) goto L457;
        Object r323 = null;
    L458:
        r318 = (Boolean) r323;     // Catch: Throwable -> L503
        if (r318 != null) goto L501;
        if ((r317 instanceof Number) == false) goto L488;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L470;
        Float r324 = Float.valueOf(((Number) r317).floatValue());     // Catch: Throwable -> L503
        if ((r324 instanceof Boolean) == true) goto L468;
        r324 = null;
    L468:
        r318 = (Boolean) r324;     // Catch: Throwable -> L503
        goto L501
    L470:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L476;
        Double r325 = Double.valueOf(((Number) r317).doubleValue());     // Catch: Throwable -> L503
        if ((r325 instanceof Boolean) == true) goto L474;
        r325 = null;
    L474:
        r318 = (Boolean) r325;     // Catch: Throwable -> L503
        goto L501
    L476:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L482;
        Integer r326 = Integer.valueOf(((Number) r317).intValue());     // Catch: Throwable -> L503
        if ((r326 instanceof Boolean) == true) goto L480;
        r326 = null;
    L480:
        r318 = (Boolean) r326;     // Catch: Throwable -> L503
        goto L501
    L482:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L488;
        Long r327 = Long.valueOf(((Number) r317).longValue());     // Catch: Throwable -> L503
        if ((r327 instanceof Boolean) == true) goto L486;
        r327 = null;
    L486:
        r318 = (Boolean) r327;     // Catch: Throwable -> L503
    L488:
        if ((r317 instanceof JSONObject) == false) goto L490;
    L1300:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L496
        Object r328 = SDKSettingsCacheManager.a().fromJson(r317.toString(), Boolean.class);     // Catch: Throwable -> L496
        if ((r328 instanceof Boolean) == true) goto L494;
        r328 = null;
    L494:
        Object r329 = Result.m9449constructorimpl((Boolean) r328);     // Catch: Throwable -> L496
    L498:
        r318 = r329;
        if (Result.m9455isFailureimpl(r318) == false) goto L501;
    L496:
        th = move-exception;
        Result.Companion r330 = Result.Companion;     // Catch: Throwable -> L503
        r329 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L503
        goto L498
    L490:
        if ((r317 instanceof JSONArray) == false) goto L500;
    L457:
        r323 = r317;
    L503:
        th = move-exception;
        Result.Companion r331 = Result.Companion;     // Catch: Throwable -> L528
        r319 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L528
    L528:
        th = move-exception;
        Result.Companion r332 = Result.Companion;
        r133 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r333 = Result.m9452exceptionOrNullimpl(r133);
        if (r333 == null) goto L533;
        EnsureManager.ensureNotReachHere(r333);
    L533:
        if (Result.m9455isFailureimpl(r133) == false) goto L535;
    L268:
        r122 = r115;
    L357:
        r115 = r122;
        goto L358
    L188:
        if ((r118 instanceof Boolean) == true) goto L190;
        Object r334 = null;
    L191:
        r119 = (Boolean) r334;     // Catch: Throwable -> L236
        if (r119 != null) goto L234;
        if ((r118 instanceof Number) == false) goto L221;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L203;
        Float r335 = Float.valueOf(((Number) r118).floatValue());     // Catch: Throwable -> L236
        if ((r335 instanceof Boolean) == true) goto L201;
        r335 = null;
    L201:
        r119 = (Boolean) r335;     // Catch: Throwable -> L236
        goto L234
    L203:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L209;
        Double r336 = Double.valueOf(((Number) r118).doubleValue());     // Catch: Throwable -> L236
        if ((r336 instanceof Boolean) == true) goto L207;
        r336 = null;
    L207:
        r119 = (Boolean) r336;     // Catch: Throwable -> L236
        goto L234
    L209:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L215;
        Integer r337 = Integer.valueOf(((Number) r118).intValue());     // Catch: Throwable -> L236
        if ((r337 instanceof Boolean) == true) goto L213;
        r337 = null;
    L213:
        r119 = (Boolean) r337;     // Catch: Throwable -> L236
        goto L234
    L215:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L221;
        Long r338 = Long.valueOf(((Number) r118).longValue());     // Catch: Throwable -> L236
        if ((r338 instanceof Boolean) == true) goto L219;
        r338 = null;
    L219:
        r119 = (Boolean) r338;     // Catch: Throwable -> L236
    L221:
        if ((r118 instanceof JSONObject) == false) goto L223;
    L1348:
        Object r339 = SDKSettingsCacheManager.a().fromJson(r118.toString(), Boolean.class);     // Catch: Throwable -> L229
        if ((r339 instanceof Boolean) == true) goto L227;
        r339 = null;
    L227:
        Object r340 = Result.m9449constructorimpl((Boolean) r339);     // Catch: Throwable -> L229
    L231:
        r119 = r340;
        if (Result.m9455isFailureimpl(r119) == false) goto L234;
    L229:
        th = move-exception;
        Result.Companion r341 = Result.Companion;     // Catch: Throwable -> L236
        r340 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L236
        goto L231
    L223:
        if ((r118 instanceof JSONArray) == false) goto L233;
    L190:
        r334 = r118;
    L236:
        th = move-exception;
        Result.Companion r342 = Result.Companion;     // Catch: Throwable -> L261
        r120 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L261
    L261:
        th = move-exception;
        Result.Companion r343 = Result.Companion;
        r122 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L264
    L271:
        int r344 = com.bytedance.android.ec.core.opt.ab.n.f45241a;
        int r345 = com.bytedance.android.ec.base.settings.c.f42815a;
        Result.Companion r346 = Result.Companion;     // Catch: Throwable -> L350
        Object r347 = com.bytedance.android.ec.base.settings.d.a().get("ec_first_screen_simple_fresco_opt_enable");     // Catch: Throwable -> L325
        if (r347 != null) goto L277;
    L322:
        Object r348 = null;
    L323:
        Object r349 = Result.m9449constructorimpl(r348);     // Catch: Throwable -> L325
    L327:
        Throwable r350 = Result.m9452exceptionOrNullimpl(r349);     // Catch: Throwable -> L350
        if (r350 == null) goto L331;
        EnsureManager.ensureNotReachHere(r350);     // Catch: Throwable -> L350
    L331:
        if (Result.m9455isFailureimpl(r349) == false) goto L334;
        r349 = null;
    L334:
        if ((r349 instanceof Boolean) == true) goto L336;
        r349 = null;
    L336:
        r122 = (Boolean) r349;     // Catch: Throwable -> L350
        if (r122 != null) goto L357;
        IHybridHostService r351 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L350
        if (r351 == null) goto L342;
        Object r352 = r351.getHostABValue("ec_first_screen_simple_fresco_opt_enable", r115);     // Catch: Throwable -> L350
    L343:
        if (r352 == null) goto L358;
        if ((r352 instanceof Boolean) == true) goto L347;
        r352 = null;
    L347:
        r122 = (Boolean) r352;     // Catch: Throwable -> L350
        if (r122 != null) goto L357;
    L342:
        r352 = null;
        goto L343
    L277:
        if ((r347 instanceof Boolean) == true) goto L279;
        Object r353 = null;
    L280:
        r348 = (Boolean) r353;     // Catch: Throwable -> L325
        if (r348 != null) goto L323;
        if ((r347 instanceof Number) == false) goto L310;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L292;
        Float r354 = Float.valueOf(((Number) r347).floatValue());     // Catch: Throwable -> L325
        if ((r354 instanceof Boolean) == true) goto L290;
        r354 = null;
    L290:
        r348 = (Boolean) r354;     // Catch: Throwable -> L325
        goto L323
    L292:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L298;
        Double r355 = Double.valueOf(((Number) r347).doubleValue());     // Catch: Throwable -> L325
        if ((r355 instanceof Boolean) == true) goto L296;
        r355 = null;
    L296:
        r348 = (Boolean) r355;     // Catch: Throwable -> L325
        goto L323
    L298:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L304;
        Integer r356 = Integer.valueOf(((Number) r347).intValue());     // Catch: Throwable -> L325
        if ((r356 instanceof Boolean) == true) goto L302;
        r356 = null;
    L302:
        r348 = (Boolean) r356;     // Catch: Throwable -> L325
        goto L323
    L304:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L310;
        Long r357 = Long.valueOf(((Number) r347).longValue());     // Catch: Throwable -> L325
        if ((r357 instanceof Boolean) == true) goto L308;
        r357 = null;
    L308:
        r348 = (Boolean) r357;     // Catch: Throwable -> L325
    L310:
        if ((r347 instanceof JSONObject) == false) goto L312;
    L1336:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L318
        Object r358 = SDKSettingsCacheManager.a().fromJson(r347.toString(), Boolean.class);     // Catch: Throwable -> L318
        if ((r358 instanceof Boolean) == true) goto L316;
        r358 = null;
    L316:
        Object r359 = Result.m9449constructorimpl((Boolean) r358);     // Catch: Throwable -> L318
    L320:
        r348 = r359;
        if (Result.m9455isFailureimpl(r348) == false) goto L323;
    L318:
        th = move-exception;
        Result.Companion r360 = Result.Companion;     // Catch: Throwable -> L325
        r359 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L325
        goto L320
    L312:
        if ((r347 instanceof JSONArray) == false) goto L322;
    L279:
        r353 = r347;
    L325:
        th = move-exception;
        Result.Companion r361 = Result.Companion;     // Catch: Throwable -> L350
        r349 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L350
    L350:
        th = move-exception;
        Result.Companion r362 = Result.Companion;
        r122 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r363 = Result.m9452exceptionOrNullimpl(r122);
        if (r363 == null) goto L355;
        EnsureManager.ensureNotReachHere(r363);
    L355:
        if (Result.m9455isFailureimpl(r122) == false) goto L357;
    L90:
        r110 = r102;
    L179:
        r102 = r110;
        goto L180
    L10:
        if ((r106 instanceof Boolean) == true) goto L12;
        Object r364 = null;
    L13:
        r107 = (Boolean) r364;     // Catch: Throwable -> L58
        if (r107 != null) goto L56;
        if ((r106 instanceof Number) == false) goto L43;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L25;
        Float r365 = Float.valueOf(((Number) r106).floatValue());     // Catch: Throwable -> L58
        if ((r365 instanceof Boolean) == true) goto L23;
        r365 = null;
    L23:
        r107 = (Boolean) r365;     // Catch: Throwable -> L58
        goto L56
    L25:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L31;
        Double r366 = Double.valueOf(((Number) r106).doubleValue());     // Catch: Throwable -> L58
        if ((r366 instanceof Boolean) == true) goto L29;
        r366 = null;
    L29:
        r107 = (Boolean) r366;     // Catch: Throwable -> L58
        goto L56
    L31:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L37;
        Integer r367 = Integer.valueOf(((Number) r106).intValue());     // Catch: Throwable -> L58
        if ((r367 instanceof Boolean) == true) goto L35;
        r367 = null;
    L35:
        r107 = (Boolean) r367;     // Catch: Throwable -> L58
        goto L56
    L37:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L43;
        Long r368 = Long.valueOf(((Number) r106).longValue());     // Catch: Throwable -> L58
        if ((r368 instanceof Boolean) == true) goto L41;
        r368 = null;
    L41:
        r107 = (Boolean) r368;     // Catch: Throwable -> L58
    L43:
        if ((r106 instanceof JSONObject) == false) goto L45;
    L1292:
        Object r369 = SDKSettingsCacheManager.a().fromJson(r106.toString(), Boolean.class);     // Catch: Throwable -> L51
        if ((r369 instanceof Boolean) == true) goto L49;
        r369 = null;
    L49:
        Object r370 = Result.m9449constructorimpl((Boolean) r369);     // Catch: Throwable -> L51
    L53:
        r107 = r370;
        if (Result.m9455isFailureimpl(r107) == false) goto L56;
    L51:
        th = move-exception;
        Result.Companion r371 = Result.Companion;     // Catch: Throwable -> L58
        r370 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L58
        goto L53
    L45:
        if ((r106 instanceof JSONArray) == false) goto L55;
    L12:
        r364 = r106;
    L58:
        th = move-exception;
        Result.Companion r372 = Result.Companion;     // Catch: Throwable -> L83
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L83
    L83:
        th = move-exception;
        Result.Companion r373 = Result.Companion;
        r110 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L86
    L93:
        int r374 = com.bytedance.android.ec.core.opt.ab.n.f45241a;
        int r375 = com.bytedance.android.ec.base.settings.c.f42815a;
        Result.Companion r376 = Result.Companion;     // Catch: Throwable -> L172
        Object r377 = com.bytedance.android.ec.base.settings.d.a().get("ec_first_screen_image_monitor_enable");     // Catch: Throwable -> L147
        if (r377 != null) goto L99;
    L144:
        Object r378 = null;
    L145:
        Object r379 = Result.m9449constructorimpl(r378);     // Catch: Throwable -> L147
    L149:
        Throwable r380 = Result.m9452exceptionOrNullimpl(r379);     // Catch: Throwable -> L172
        if (r380 == null) goto L153;
        EnsureManager.ensureNotReachHere(r380);     // Catch: Throwable -> L172
    L153:
        if (Result.m9455isFailureimpl(r379) == false) goto L156;
        r379 = null;
    L156:
        if ((r379 instanceof Boolean) == true) goto L158;
        r379 = null;
    L158:
        r110 = (Boolean) r379;     // Catch: Throwable -> L172
        if (r110 != null) goto L179;
        IHybridHostService r381 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L172
        if (r381 == null) goto L164;
        Object r382 = r381.getHostABValue("ec_first_screen_image_monitor_enable", r102);     // Catch: Throwable -> L172
    L165:
        if (r382 == null) goto L180;
        if ((r382 instanceof Boolean) == true) goto L169;
        r382 = null;
    L169:
        r110 = (Boolean) r382;     // Catch: Throwable -> L172
        if (r110 != null) goto L179;
    L164:
        r382 = null;
        goto L165
    L99:
        if ((r377 instanceof Boolean) == true) goto L101;
        Object r383 = null;
    L102:
        r378 = (Boolean) r383;     // Catch: Throwable -> L147
        if (r378 != null) goto L145;
        if ((r377 instanceof Number) == false) goto L132;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L114;
        Float r384 = Float.valueOf(((Number) r377).floatValue());     // Catch: Throwable -> L147
        if ((r384 instanceof Boolean) == true) goto L112;
        r384 = null;
    L112:
        r378 = (Boolean) r384;     // Catch: Throwable -> L147
        goto L145
    L114:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L120;
        Double r385 = Double.valueOf(((Number) r377).doubleValue());     // Catch: Throwable -> L147
        if ((r385 instanceof Boolean) == true) goto L118;
        r385 = null;
    L118:
        r378 = (Boolean) r385;     // Catch: Throwable -> L147
        goto L145
    L120:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L126;
        Integer r386 = Integer.valueOf(((Number) r377).intValue());     // Catch: Throwable -> L147
        if ((r386 instanceof Boolean) == true) goto L124;
        r386 = null;
    L124:
        r378 = (Boolean) r386;     // Catch: Throwable -> L147
        goto L145
    L126:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L132;
        Long r387 = Long.valueOf(((Number) r377).longValue());     // Catch: Throwable -> L147
        if ((r387 instanceof Boolean) == true) goto L130;
        r387 = null;
    L130:
        r378 = (Boolean) r387;     // Catch: Throwable -> L147
    L132:
        if ((r377 instanceof JSONObject) == false) goto L134;
    L1276:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L140
        Object r388 = SDKSettingsCacheManager.a().fromJson(r377.toString(), Boolean.class);     // Catch: Throwable -> L140
        if ((r388 instanceof Boolean) == true) goto L138;
        r388 = null;
    L138:
        Object r389 = Result.m9449constructorimpl((Boolean) r388);     // Catch: Throwable -> L140
    L142:
        r378 = r389;
        if (Result.m9455isFailureimpl(r378) == false) goto L145;
    L140:
        th = move-exception;
        Result.Companion r390 = Result.Companion;     // Catch: Throwable -> L147
        r389 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L147
        goto L142
    L134:
        if ((r377 instanceof JSONArray) == false) goto L144;
    L101:
        r383 = r377;
    L147:
        th = move-exception;
        Result.Companion r391 = Result.Companion;     // Catch: Throwable -> L172
        r379 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L172
    L172:
        th = move-exception;
        Result.Companion r392 = Result.Companion;
        r110 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r393 = Result.m9452exceptionOrNullimpl(r110);
        if (r393 == null) goto L177;
        EnsureManager.ensureNotReachHere(r393);
    L177:
        if (Result.m9455isFailureimpl(r110) == false) goto L179;
        goto L179
    }

    public static String g(GenericDraweeView r100) {
        Intrinsics.checkNotNullParameter(r100, "imageView");
        String r101 = L.get(r100);
        if (r101 != null) goto L5;
    L9:
        dm.a.a("FirstScreenStatistic").a("getLoadingUrl " + r100.hashCode() + ' ' + r101);
    L10:
        if (r101 != null) goto L13;
        return "";
    L13:
        return r101;
    L5:
        if (r101.length() != 0) goto L7;
        boolean r102 = true;
    L8:
        if (r102 == false) goto L10;
    L7:
        r102 = false;
        goto L8
    }

    public static boolean h(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        String r101 = M.get(r100);
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        Boolean r102 = K.get(r101);
        if (r102 != null) goto L9;
        r102 = Boolean.FALSE;
    L9:
        return r102.booleanValue();
    }

    public static void j(String r100) {
        Intrinsics.checkNotNullParameter(r100, "cleanUrl");
        if (Intrinsics.areEqual(ThreadMethodProxy.currentThread(), ThreadMethodProxy.getLooperThread(Looper.getMainLooper())) == true) goto L5;
        I.post(new a(r100));
        return;
    L5:
        if (com.bytedance.android.shopping.extensions.k.c(r100) == false) goto L11;
        HashSet<String> r101 = f44380w;
        if (r101.contains(r100) == true) goto L12;
        r101.add(r100);
        f44382y.incrementAndGet();
        return;
    L12:
        return;
    }

    public static String k(String r100) {
        Intrinsics.checkNotNullParameter(r100, "originUrl");
        int r101 = StringsKt.indexOf$default(r100, "&is_from_mall_cache=", 0, false, 6, null);
        if (r101 != (-1)) goto L5;
        return r100;
    L5:
        return StringsKt.removeRange(r100, r101, (r101 + 20) + 1).toString();
    }

    public static void o(int r100) {
        JSONObject r101 = new JSONObject();
        int r102 = f44381x.get();
        int r103 = f44382y.get();
        int r104 = r102 + r103;
        int r105 = A.get();
        r101.put("normalFrescoLoadNum", r102);     // Catch: Exception -> L7
        r101.put("simpleFrescoLoadNum", r103);     // Catch: Exception -> L7
        r101.put("totalFrescoLoadNum", r104);     // Catch: Exception -> L7
        r101.put("cacheNum", r105);     // Catch: Exception -> L7
        r101.put("time", r100);     // Catch: Exception -> L7
        if (r104 <= 0) goto L8;
        r101.put("cacheRate", Float.valueOf(r105 / r104));     // Catch: Exception -> L7
    L8:
        dm.a.a("FirstScreenStatistic").a("reportFrescoLoadAndCacheRate " + r101);
        int r106 = ECMonitorService.f45110b;
        ECMonitorService.a.a("first_screen_fresco_load_cache_rate", r101, null, null);
        return;
    L7:
        ECExceptionMonitor.c("reportFrescoLoadAndCacheRate json error");
        goto L8
    }

    public static String t(String r110) {
        Intrinsics.checkNotNullParameter(r110, "url");
        q0 r100 = B;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r110, "url");
        byte[] r101 = r110.getBytes(Charsets.UTF_8);     // Catch: Exception -> L9
        MessageDigest r102 = MessageDigest.getInstance("MD5");     // Catch: Exception -> L9
        r102.update(r101);     // Catch: Exception -> L9
        byte[] r103 = r102.digest();     // Catch: Exception -> L9
        char[] r104 = new char[32];     // Catch: Exception -> L9
        int r105 = 0;
        int r106 = 0;
    L5:
        if (r105 > 15) goto L7;
        byte r107 = r103[r105];     // Catch: Exception -> L9
        int r108 = r106 + 1;     // Catch: Exception -> L9
        char[] r109 = r100.f44936a;     // Catch: Exception -> L9
        r104[r106] = r109[15 & (r107 >>> 4)];     // Catch: Exception -> L9
        r106 = r108 + 1;     // Catch: Exception -> L9
        r104[r108] = r109[r107 & 15];     // Catch: Exception -> L9
        r105 = r105 + 1;     // Catch: Exception -> L9
        goto L5
    L7:
        String r111 = new String(r104);     // Catch: Exception -> L9
    L11:
        if (r111 != null) goto L14;
        return r110;
    L14:
        return r111;
    L9:
        e = move-exception;
        ECExceptionMonitor.e(e);
        HashMap r112 = new HashMap();
        r112.put("cleanUrl", r110);
        S.getClass();
        n("md5", "", e, r112);
        r111 = null;
        goto L11
    }

    public static final void a(FirstScreenStatistic r210, com.bytedance.android.ec.core.imagex.a r211) {
        r210.getClass();
        String r100 = r211.f44527a;
        String r101 = r211.f44528b;
        String r102 = r211.f44529c;
        Map<String, String> r103 = r211.f44530d;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L75
        Uri r105 = UriProtector.parse(r100);     // Catch: Throwable -> L75
        String r106 = M.get(r100);     // Catch: Throwable -> L75
        if (r106 != null) goto L6;
        r106 = t(r100);     // Catch: Throwable -> L75
    L6:
        p0 r107 = N.get(r106);     // Catch: Throwable -> L75
        FirstScreenStatistic$doReportBitmapHitImageMonitor$1$1 r108 = FirstScreenStatistic$doReportBitmapHitImageMonitor$1$1.INSTANCE;     // Catch: Throwable -> L75
        if (r107 == null) goto L9;
        long r110 = FirstScreenStatistic$doReportBitmapHitImageMonitor$1$1.INSTANCE.invoke(r107.f44933c, r107.f44935e);     // Catch: Throwable -> L75
    L10:
        if (r107 == null) goto L12;
        long r109 = FirstScreenStatistic$doReportBitmapHitImageMonitor$1$1.INSTANCE.invoke(r107.f44934d, r107.f44935e);     // Catch: Throwable -> L75
    L13:
        if (r107 == null) goto L17;
        Map<String, String> r111 = r103;
        long r112 = FirstScreenStatistic$doReportBitmapHitImageMonitor$1$1.INSTANCE.invoke(r107.f44931a, r107.f44932b);     // Catch: Throwable -> L24
    L18:
        if (r107 == null) goto L26;
        long r113 = r107.f44932b;     // Catch: Throwable -> L24
        if (r113 <= 0) goto L26;
        long r212 = r112;
        long r114 = r107.f44933c;     // Catch: Throwable -> L24
        if (r114 <= 0) goto L27;
        long r115 = r114 - r113;     // Catch: Throwable -> L24
    L28:
        JSONObject r116 = new JSONObject();     // Catch: Throwable -> L24
        String r117 = null;
        if (r102 != null) goto L31;
    L35:
        r102 = "ec_default";
    L36:
        r116.put("biz_tag", r102);     // Catch: Throwable -> L24
        if ((!StringsKt.isBlank(r101)) == true) goto L42;
        r101 = null;
    L42:
        if (r101 != null) goto L44;
        r101 = "unknown";
    L44:
        r116.put(FrescoMonitorConst.SCENE_TAG, r101);     // Catch: Throwable -> L24
        r116.put("page_name", "unknown");     // Catch: Throwable -> L24
        r116.put("host", r105.getHost());     // Catch: Throwable -> L24
        if (r105.isHierarchical() == false) goto L61;
        String r118 = UriProtector.getQueryParameter(r105, "biz_tag");     // Catch: Throwable -> L24
        if (r118 != null) goto L49;
    L54:
        String r119 = UriProtector.getQueryParameter(r105, FrescoMonitorConst.SCENE_TAG);     // Catch: Throwable -> L24
        if (r119 == null) goto L61;
        if ((!StringsKt.isBlank(r119)) == false) goto L59;
        r117 = r119;
    L59:
        if (r117 == null) goto L61;
        r116.put("url_scene", r117);     // Catch: Throwable -> L24
        goto L61
    L49:
        if ((!StringsKt.isBlank(r118)) == true) goto L52;
        r118 = null;
    L52:
        if (r118 == null) goto L54;
        r116.put("url_biz", r118);     // Catch: Throwable -> L24
    L61:
        r116.put("is_animated_image", false);     // Catch: Throwable -> L24
        r116.put("is_success", true);     // Catch: Throwable -> L24
        r116.put("is_cancel", false);     // Catch: Throwable -> L24
        r116.put(MobConstants.FORM_CACHE, true);     // Catch: Throwable -> L24
        r116.put("is_preload", false);     // Catch: Throwable -> L24
        r116.put("first_request", true);     // Catch: Throwable -> L24
        r116.put("image_from", "bitmap_cache");     // Catch: Throwable -> L24
        JSONObject r120 = new JSONObject();     // Catch: Throwable -> L24
        r120.put("ec_local_duration", 0);     // Catch: Throwable -> L24
        r120.put("ec_sdk_duration", 0);     // Catch: Throwable -> L24
        r120.put("ec_biz_duration", r110);     // Catch: Throwable -> L24
        r120.put("ec_queue_duration", 0);     // Catch: Throwable -> L24
        r120.put("ec_download_duration", 0);     // Catch: Throwable -> L24
        r120.put("ec_decode_duration", 0);     // Catch: Throwable -> L24
        r120.put("ec_image_set_duration", r109);     // Catch: Throwable -> L24
        r120.put("ec_biz_image_set_duration", r109);     // Catch: Throwable -> L24
        if (r107 == null) goto L64;
        long r121 = FirstScreenStatistic$doReportBitmapHitImageMonitor$1$1.INSTANCE.invoke(0, r107.f44931a);     // Catch: Throwable -> L24
    L65:
        r120.put("bitmap_prepare_duration", r121);     // Catch: Throwable -> L24
        r120.put("bitmap_disk_load_duration", r212);     // Catch: Throwable -> L24
        if (r107 == null) goto L68;
        long r122 = FirstScreenStatistic$doReportBitmapHitImageMonitor$1$1.INSTANCE.invoke(r107.f44933c, r107.f44934d);     // Catch: Throwable -> L24
    L69:
        r120.put("bitmap_use_duration", r122);     // Catch: Throwable -> L24
        r120.put("bitmap_set_duration", r109);     // Catch: Throwable -> L24
        r120.put("bitmap_total_duration", r110);     // Catch: Throwable -> L24
        r120.put("bitmap_real_load_to_disk_end_duration", r115);     // Catch: Throwable -> L24
        JSONObject r123 = new JSONObject();     // Catch: Throwable -> L24
        r123.put("url", r100);     // Catch: Throwable -> L24
        r123.put("url_path", r105.getPath());     // Catch: Throwable -> L24
        r123.put("bitmap_cache_md5", r106);     // Catch: Throwable -> L24
        r123.put("bitmap_cache_hit", true);     // Catch: Throwable -> L24
        Iterator<Map.Entry<String, String>> r124 = r111.entrySet().iterator();     // Catch: Throwable -> L24
    L71:
        if (r124.hasNext() == false) goto L73;
        Map.Entry<String, String> r125 = r124.next();     // Catch: Throwable -> L24
        r123.put(r125.getKey(), r125.getValue());     // Catch: Throwable -> L24
        goto L71
    L73:
        int r126 = ECMonitorService.f45110b;     // Catch: Throwable -> L24
        ECMonitorService.a.a("ecom_image_monitor", r116, r120, r123);     // Catch: Throwable -> L24
        Object r127 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L24
    L78:
        Throwable r128 = Result.m9452exceptionOrNullimpl(r127);
        if (r128 == null) goto L87;
        S.getClass();
        n("reportBitmapHitImageMonitor", "report bitmap hit image monitor error", r128, r111);
        return;
    L87:
        return;
    L68:
        r122 = -1;
        goto L69
    L64:
        r121 = -1;
        goto L65
    L31:
        if ((!StringsKt.isBlank(r102)) == true) goto L34;
        r102 = null;
    L34:
        if (r102 != null) goto L36;
    L27:
        r115 = -1;
    L26:
        r212 = r112;
    L24:
        th = th;
    L77:
        Result.Companion r129 = Result.Companion;
        r127 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L78
    L17:
        r111 = r103;
        r112 = -1;
        goto L18
    L12:
        r109 = -1;
        goto L13
    L9:
        r110 = -1;
    L75:
        th = th;
        r111 = r103;
        goto L77
    }

    public static void q(boolean r100, Map r101) {
        Intrinsics.checkNotNullParameter(r101, "extra");
        JSONObject r102 = new JSONObject();
        r102.put("success", r100);     // Catch: Exception -> L8
        Iterator r103 = r101.entrySet().iterator();     // Catch: Exception -> L8
    L5:
        if (r103.hasNext() == false) goto L9;
        Map.Entry r104 = (Map.Entry) r103.next();     // Catch: Exception -> L8
        r102.put((String) r104.getKey(), r104.getValue());     // Catch: Exception -> L8
    L9:
        int r105 = ECMonitorService.f45110b;
        ECMonitorService.a.a("first_screen_simple_fresco_load", r102, null, null);
        return;
    L8:
        ECExceptionMonitor.c("reportSimpleFrescoLoadResult json error");
        goto L9
    }

    public static boolean s(Bitmap r100, PolarisFileWrapper r101) {
        Intrinsics.checkNotNullParameter(r100, SimplayerImageStrategy.RESULT_BITMAP);
        Intrinsics.checkNotNullParameter(r101, "md5WhFile");
        int r102 = r100.getByteCount();
        if (r100.isRecycled() == true) goto L19;
        if (r102 != 0) goto L6;
        return false;
    L6:
        if (r100.getWidth() != 0) goto L8;
        return false;
    L8:
        if (r100.getHeight() == 0) goto L27;
        PolarisFileOutputStreamWrapper r103 = new PolarisFileOutputStreamWrapper(r101);
        ByteBuffer r104 = ByteBuffer.allocateDirect(r102);     // Catch: Throwable -> L14
        r100.copyPixelsToBuffer(r104);     // Catch: Throwable -> L14
        r103.write(r104.array());     // Catch: Throwable -> L14
        r103.flush();     // Catch: Throwable -> L14
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L14
        CloseableKt.closeFinally(r103, null);
        return true;
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        CloseableKt.closeFinally(r103, th);
        throw th;
    L27:
        return false;
    L19:
        return false;
    }

    public static Bitmap f(String r100, CloseableImage r101, Map r110) {
        Intrinsics.checkNotNullParameter(r100, "cleanUrl");
        Intrinsics.checkNotNullParameter(r110, "extra");
        if (r101 != null) goto L37;
    L22:
        Bitmap r102 = null;
        Exception r103 = null;
    L23:
        if (r102 != null) goto L26;
        n("cacheBitmap", "getBitmap null", r103, r110);
        return null;
    L26:
        Bitmap.Config r111 = r102.getConfig();
        if (r111 != null) goto L29;
        r111 = Bitmap.Config.ARGB_8888;
    L29:
        long r104 = System.currentTimeMillis();
        boolean r105 = f44371n;
        if (r105 == false) goto L32;
        Bitmap r106 = r102.copy(r111, false);
    L33:
        long r107 = System.currentTimeMillis();
        if (r105 == false) goto L36;
        int r112 = r106.getByteCount();
        int r108 = r102.getWidth();
        int r109 = r102.getHeight();
        JSONObject r113 = new JSONObject();
        r113.put("bitmapByteCount", r112);
        r113.put("bitmapWidth", r108);
        r113.put("bitmapHeight", r109);
        r113.put("time", r107 - r104);
        int r114 = ECMonitorService.f45110b;
        ECMonitorService.a.a("first_screen_bitmap_copy", r113, null, null);
    L36:
        return r106;
    L32:
        r106 = r102;
        goto L33
    L37:
    L20:
        e = move-exception;
        dm.a.a("FirstScreenStatistic").b("onFinalImageSet getBitmap from closeableImage failed " + e.toString(), null);
        r103 = e;
        r102 = null;
        goto L23
    L5:
        if ((r101 instanceof CloseableStaticBitmap) == false) goto L8;
        r102 = ((CloseableStaticBitmap) r101).getUnderlyingBitmap();     // Catch: Exception -> L20
    L19:
        r103 = null;
        goto L23
    L8:
        if ((r101 instanceof CloseableAnimatedImage) == false) goto L15;
        AnimatedImage r115 = ((CloseableAnimatedImage) r101).getImage();     // Catch: Exception -> L20
        if (r115 == null) goto L22;
        if (r115.getFrameCount() <= 0) goto L18;
        AnimatedImageFrame r116 = r115.getFrame(0);     // Catch: Exception -> L20
        Bitmap r117 = Bitmap.createBitmap(r116.getWidth(), r116.getHeight(), Bitmap.Config.ARGB_8888);     // Catch: Exception -> L20
        r116.renderFrame(r116.getWidth(), r116.getHeight(), r117);     // Catch: Exception -> L20
        r102 = r117;
    L18:
        r102 = null;
        goto L19
    L15:
        if ((r101 instanceof CloseableBitmap) == false) goto L18;
        r102 = ((CloseableBitmap) r101).getUnderlyingBitmap();     // Catch: Exception -> L20
        goto L19
    }

    public static void i(String r100, String r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "sceneTag");
        o0 r103 = f44365h.get(r100);
        if (r103 == null) goto L6;
        long r104 = System.currentTimeMillis();
        r103.f44695d = r104;
        r103.f44696e = r104 - r103.f44694c;
        r103.f44697f = r102;
    L6:
        if (H == false) goto L9;
        c();
    L9:
        if (f44362e == false) goto L12;
        return;
    L12:
        if (f44358a == false) goto L40;
        String r105 = String.valueOf(r101);
        ConcurrentHashMap<String, i0> r106 = f44357J.get(r105);
        if (r106 != null) goto L16;
        return;
    L16:
        HashMap<String, HashMap<String, i0>> r107 = f44364g;
        HashMap<String, i0> r108 = r107.get(r105);
        if (r108 != null) goto L19;
        return;
    L19:
        i0 r109 = r108.get(r100);
        if (r109 != null) goto L22;
        return;
    L22:
        r109.f44679a = System.currentTimeMillis() - f44361d;
        r109.f44681c = System.currentTimeMillis();
        r109.f44682d = r102;
        if (r106.containsKey(r100) == true) goto L25;
        r106.put(r100, r109);
    L25:
        Iterator<T> r110 = r107.values().iterator();
        int r111 = 0;
        int r112 = 0;
    L27:
        if (r110.hasNext() == false) goto L29;
        r112 = r112 + ((HashMap) r110.next()).size();
        goto L27
    L29:
        Iterator<T> r113 = f44363f.values().iterator();
        int r114 = 0;
    L31:
        if (r113.hasNext() == false) goto L33;
        r114 = r114 + ((HashMap) r113.next()).size();
        goto L31
    L33:
        Iterator<T> r115 = f44357J.values().iterator();
    L35:
        if (r115.hasNext() == false) goto L38;
        r111 = r111 + ((ConcurrentHashMap) r115.next()).size();
        goto L35
    L38:
        if (r112 != (r114 + r111)) goto L56;
        dm.a.a("FirstScreenStatistic").a("all image load complete, not accept load end any more");
        f44362e = true;
        return;
    L56:
        return;
    L40:
        String r116 = String.valueOf(r101);
        HashMap<String, i0> r117 = f44363f.get(r116);
        if (r117 != null) goto L43;
        return;
    L43:
        HashMap<String, i0> r118 = f44364g.get(r116);
        if (r118 != null) goto L46;
        return;
    L46:
        i0 r119 = r118.get(r100);
        if (r119 != null) goto L49;
        return;
    L49:
        r119.f44682d = r102;
        r119.f44681c = System.currentTimeMillis();
        if (r117.containsKey(r100) == true) goto L58;
        r117.put(r100, r119);
        return;
    }

    public static void p(boolean r100, int r101, int r102) {
        JSONObject r103 = new JSONObject();
        r103.put("success", r100);
        r103.put("md5Size", r101);
        r103.put("urlSize", r102);
        int r104 = ECMonitorService.f45110b;
        ECMonitorService.a.a("first_screen_save_first_screen", r103, null, null);
    }

    public static final Bitmap b(FirstScreenStatistic r100, File r101, int r102, int r103) {
        r100.getClass();
        Bitmap r104 = null;
        if (r101 != null) goto L5;
    L21:
        return r104;
    L5:
        if (r101.exists() == false) goto L21;
        PolarisFileInputStreamWrapper r105 = new PolarisFileInputStreamWrapper(r101);
        int r106 = r105.available();     // Catch: Throwable -> L16
        byte[] r107 = new byte[r106];     // Catch: Throwable -> L16
        if (r105.read(r107) == r106) goto L10;
        CloseableKt.closeFinally(r105, null);
        goto L21
    L10:
        Unit r108 = Unit.INSTANCE;     // Catch: Throwable -> L16
        CloseableKt.closeFinally(r105, null);
        r104 = Bitmap.createBitmap(r102, r103, Bitmap.Config.ARGB_8888);
        if (r104 == null) goto L14;
        r104.copyPixelsFromBuffer(ByteBuffer.wrap(r107));
    L14:
        if (r104 == null) goto L21;
        r104.prepareToDraw();
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        CloseableKt.closeFinally(r105, th);
        throw th;
    }

    public static void m(String r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "editedUrl");
        Intrinsics.checkNotNullParameter(r101, "originUrl");
        Intrinsics.checkNotNullParameter(r102, "cleanUrl");
        Intrinsics.checkNotNullParameter(r103, "sceneTag");
        if (f44358a == false) goto L5;
        return;
    L5:
        JSONObject r104 = new JSONObject();
        r104.put("editedUrl", r100);
        r104.put("originUrl", r101);
        r104.put("cleanUrl", r102);
        r104.put("sceneTag", r103);
        int r105 = ECMonitorService.f45110b;
        ECMonitorService.a.a("first_screen_record_image_load", r104, null, null);
    }

    public static void n(String r100, String r101, Throwable r102, Map r103) {
        Intrinsics.checkNotNullParameter(r100, "phase");
        Intrinsics.checkNotNullParameter(r101, "errorMsg");
        JSONObject r104 = new JSONObject();
        r104.put("phase", r100);
        if (r103 == null) goto L9;
        Iterator r105 = r103.entrySet().iterator();
    L6:
        if (r105.hasNext() == false) goto L9;
        Map.Entry r106 = (Map.Entry) r105.next();
        r104.put((String) r106.getKey(), (String) r106.getValue());
    L9:
        if (r102 == null) goto L11;
        r104.put("error", r102.toString());
    L12:
        int r107 = ECMonitorService.f45110b;
        ECMonitorService.a.a("first_screen_bitmap_opt_error", r104, null, null);
        dm.a.a("FirstScreenStatistic").a(String.valueOf(r104.toString(2)));
        return;
    L11:
        r104.put("error", r101);
        goto L12
    }

    public static void d(Bitmap r110, ImageRequest r111, String r112, Map r113, String r114) {
        Intrinsics.checkNotNullParameter(r112, "cleanUrl");
        Intrinsics.checkNotNullParameter(r113, "extra");
        Intrinsics.checkNotNullParameter(r114, "from");
        if (D.contains(r112) == true) goto L6;
        dm.a.a("FirstScreenStatistic").a("not start before realdata firstscreen return " + r112 + ' ');
        return;
    L6:
        HashSet<String> r100 = f44383z;
        if (r100.contains(r112) == false) goto L11;
        dm.a.a("FirstScreenStatistic").a("repeatCache already caching return " + r112);
        return;
    L11:
        if (h(r112) == false) goto L15;
        dm.a.a("FirstScreenStatistic").a("hasCacheFile return ".concat(r112));
        return;
    L15:
        if (f44379v.contains(r112) == false) goto L17;
    L19:
        r100.add(r112);
        A.incrementAndGet();
        if (r110 == null) goto L22;
        Bitmap.Config r101 = r110.getConfig();
    L23:
        if (r110 == null) goto L45;
        if (r101 == null) goto L46;
        if (r111 == null) goto L28;
        ResizeOptions r115 = r111.getResizeOptions();
    L29:
        int r102 = r110.getWidth();
        int r103 = r110.getHeight();
        int r104 = 0;
        if (r115 == null) goto L32;
        int r105 = r115.width;
    L33:
        if (r115 == null) goto L35;
        r104 = r115.height;
    L35:
        if (r102 != 0) goto L38;
        if (r103 != 0) goto L38;
        dm.a.a("FirstScreenStatistic").b("bitmapSize width&height = 0", null);
    L38:
        if (r105 == 0) goto L43;
        if (r104 == 0) goto L43;
        if (r105 == r102) goto L43;
        if (r104 == r103) goto L43;
        dm.a.a("FirstScreenStatistic").b("bitmapSize width&height != resizeWidth&resizeHeight", null);
    L43:
        dm.a.a("FirstScreenStatistic").a(ThreadMethodProxy.currentThread().getName() + ' ' + r114 + " cacheBitmap: bitmapSize " + r102 + ' ' + r103 + " resize " + r105 + ' ' + r104 + ' ' + r112);
        u(r110, r112, r102, r103, r113, System.currentTimeMillis());
        return;
    L32:
        r105 = 0;
        goto L33
    L28:
        r115 = null;
        goto L29
    L46:
        return;
    L45:
        return;
    L22:
        r101 = null;
        goto L23
    L17:
        if (f44380w.contains(r112) == true) goto L19;
        dm.a.a("FirstScreenStatistic").a("not in fresco loading urls. extra " + r113.toString() + " cleanUrl " + r112);
        goto L19
    }

    public static void l(String r100, String r101, String r102, String r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "editedUrl");
        Intrinsics.checkNotNullParameter(r101, "originUrl");
        Intrinsics.checkNotNullParameter(r102, "cleanUrl");
        Intrinsics.checkNotNullParameter(r103, "sceneTag");
        Intrinsics.checkNotNullParameter(r104, "callerContextState");
        JSONObject r105 = new JSONObject();
        r105.put("editedUrl", r100);
        r105.put("originUrl", r101);
        r105.put("cleanUrl", r102);
        r105.put("sceneTag", r103);
        r105.put("callerContext", r104);
        int r106 = ECMonitorService.f45110b;
        ECMonitorService.a.a("first_screen_record_image_end", r105, null, null);
    }

    public static void u(Bitmap r110, String r111, int r112, int r113, Map r114, long r115) {
        Intrinsics.checkNotNullParameter(r110, "saveBitmap");
        Intrinsics.checkNotNullParameter(r111, "cleanUrl");
        Intrinsics.checkNotNullParameter(r114, "extra");
        if (H == true) goto L15;
        long r100 = System.currentTimeMillis();
        if (F == false) goto L7;
        long r101 = 4000;
    L9:
        if ((r100 - r115) <= r101) goto L11;
        return;
    L11:
        if (f44373p == false) goto L13;
        I.postDelayed(new b(r110, r111, r112, r113, r114, r115), 300);
        return;
    L13:
        I.post(new c(r110, r111, r112, r113, r114, r115));
        return;
    L7:
        r101 = 1000;
        goto L9
    L15:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new FirstScreenStatistic$writeBitmapToDisk$3(r111, r112, r113, r110, r114, null), 3, null);
    }
}
