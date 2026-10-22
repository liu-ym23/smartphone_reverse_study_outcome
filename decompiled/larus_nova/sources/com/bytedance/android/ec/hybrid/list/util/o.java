package com.bytedance.android.ec.hybrid.list.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.services.apm.api.EnsureManager;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.File;
import java.lang.ref.SoftReference;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.Charsets;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f47348a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f47349b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f47350c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ConcurrentHashMap<String, SoftReference<Bitmap>> f47351d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f47352e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final HashSet<Integer> f47353f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final o f47354g = null;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f47355a;

        /* JADX INFO: renamed from: com.bytedance.android.ec.hybrid.list.util.o$a$a, reason: collision with other inner class name */
        public static final class C0826a<T> implements Comparator<T> {
            public C0826a() {
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T r100, T r101) {
                return ComparisonsKt.compareValues(Long.valueOf(((File) r101).lastModified()), Long.valueOf(((File) r100).lastModified()));
            }
        }

        public a(Context r100) {
            this.f47355a = r100;
        }

        public final void a() {
            File[] r100 = new PolarisFileWrapper(this.f47355a.getFilesDir(), "ec_mall_image_cache").listFiles();
            if (r100 == null) goto L6;
            List r101 = ArraysKt.sortedWith(r100, new C0826a());
            if (r101 == null) goto L6;
        L7:
            boolean r102 = o.f47348a;
            Iterator r103 = CollectionsKt.drop(r101, o.f47349b).iterator();
        L9:
            if (r103.hasNext() == false) goto L11;
            ((File) r103.next()).delete();
            goto L9
        L11:
            return;
        L6:
            r101 = CollectionsKt.emptyList();
            goto L7
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public o() {
    }

    static {
        f47354g = new o();
        int r100 = com.bytedance.android.ec.base.settings.a.f42813a;
        Object r101 = Boolean.FALSE;
        Object r102 = null;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L163
        Object r104 = com.bytedance.android.ec.base.settings.d.f42818c.get("mall_image_bitmap_cache");     // Catch: Throwable -> L56
        if (r104 != null) goto L8;
    L53:
        Object r105 = null;
    L54:
        Object r106 = Result.m9449constructorimpl(r105);     // Catch: Throwable -> L56
    L58:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);     // Catch: Throwable -> L163
        if (r107 == null) goto L62;
        EnsureManager.ensureNotReachHere(r107);     // Catch: Throwable -> L163
    L62:
        if (Result.m9455isFailureimpl(r106) == false) goto L65;
        r106 = null;
    L65:
        if ((r106 instanceof Boolean) == true) goto L67;
        r106 = null;
    L67:
        Object r108 = (Boolean) r106;     // Catch: Throwable -> L163
        if (r108 != null) goto L74;
        Object r109 = com.bytedance.android.ec.base.settings.d.f42816a.get("mall_image_bitmap_cache");     // Catch: Throwable -> L163
        if ((r109 instanceof Boolean) == true) goto L73;
        r109 = null;
    L73:
        r108 = (Boolean) r109;     // Catch: Throwable -> L163
    L74:
        if (r108 != null) goto L172;
        int r110 = com.bytedance.android.ec.base.settings.c.f42815a;     // Catch: Throwable -> L163
        Object r111 = com.bytedance.android.ec.base.settings.d.f42818c.get("mall_image_bitmap_cache");     // Catch: Throwable -> L129
        if (r111 != null) goto L81;
    L126:
        Object r112 = null;
    L127:
        Object r113 = Result.m9449constructorimpl(r112);     // Catch: Throwable -> L129
    L131:
        Throwable r114 = Result.m9452exceptionOrNullimpl(r113);     // Catch: Throwable -> L154
        if (r114 == null) goto L135;
        EnsureManager.ensureNotReachHere(r114);     // Catch: Throwable -> L154
    L135:
        if (Result.m9455isFailureimpl(r113) == false) goto L138;
        r113 = null;
    L138:
        if ((r113 instanceof Boolean) == true) goto L140;
        r113 = null;
    L140:
        r108 = (Boolean) r113;     // Catch: Throwable -> L154
        if (r108 != null) goto L161;
        IHybridHostService r115 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L154
        if (r115 == null) goto L146;
        Object r116 = r115.getHostABValue("mall_image_bitmap_cache", r101);     // Catch: Throwable -> L154
    L147:
        if (r116 != null) goto L149;
    L160:
        r108 = r101;
        goto L161
    L149:
        if ((r116 instanceof Boolean) == true) goto L151;
        r116 = null;
    L151:
        r108 = (Boolean) r116;     // Catch: Throwable -> L154
        if (r108 != null) goto L161;
    L154:
        th = move-exception;
        Result.Companion r117 = Result.Companion;     // Catch: Throwable -> L163
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
        Throwable r118 = Result.m9452exceptionOrNullimpl(r108);     // Catch: Throwable -> L163
        if (r118 == null) goto L159;
        EnsureManager.ensureNotReachHere(r118);     // Catch: Throwable -> L163
    L159:
        if (Result.m9455isFailureimpl(r108) == false) goto L161;
    L146:
        r116 = null;
    L161:
        com.bytedance.android.ec.base.settings.d.d("mall_image_bitmap_cache", r108);     // Catch: Throwable -> L163
        goto L172
    L81:
        if ((r111 instanceof Boolean) == true) goto L83;
        Object r119 = null;
    L84:
        r112 = (Boolean) r119;     // Catch: Throwable -> L129
        if (r112 != null) goto L127;
        if ((r111 instanceof Number) == false) goto L114;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L96;
        Float r120 = Float.valueOf(((Number) r111).floatValue());     // Catch: Throwable -> L129
        if ((r120 instanceof Boolean) == true) goto L94;
        r120 = null;
    L94:
        r112 = (Boolean) r120;     // Catch: Throwable -> L129
        goto L127
    L96:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L102;
        Double r121 = Double.valueOf(((Number) r111).doubleValue());     // Catch: Throwable -> L129
        if ((r121 instanceof Boolean) == true) goto L100;
        r121 = null;
    L100:
        r112 = (Boolean) r121;     // Catch: Throwable -> L129
        goto L127
    L102:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L108;
        Integer r122 = Integer.valueOf(((Number) r111).intValue());     // Catch: Throwable -> L129
        if ((r122 instanceof Boolean) == true) goto L106;
        r122 = null;
    L106:
        r112 = (Boolean) r122;     // Catch: Throwable -> L129
        goto L127
    L108:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L114;
        Long r123 = Long.valueOf(((Number) r111).longValue());     // Catch: Throwable -> L129
        if ((r123 instanceof Boolean) == true) goto L112;
        r123 = null;
    L112:
        r112 = (Boolean) r123;     // Catch: Throwable -> L129
    L114:
        if ((r111 instanceof JSONObject) == false) goto L116;
    L339:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L122
        Object r124 = SDKSettingsCacheManager.a().fromJson(r111.toString(), Boolean.class);     // Catch: Throwable -> L122
        if ((r124 instanceof Boolean) == true) goto L120;
        r124 = null;
    L120:
        Object r125 = Result.m9449constructorimpl((Boolean) r124);     // Catch: Throwable -> L122
    L124:
        r112 = r125;
        if (Result.m9455isFailureimpl(r112) == false) goto L127;
    L122:
        th = move-exception;
        Result.Companion r126 = Result.Companion;     // Catch: Throwable -> L129
        r125 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L129
        goto L124
    L116:
        if ((r111 instanceof JSONArray) == false) goto L126;
    L83:
        r119 = r111;
    L129:
        th = move-exception;
        Result.Companion r127 = Result.Companion;     // Catch: Throwable -> L154
        r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L154
    L172:
        f47348a = ((Boolean) r108).booleanValue();
        int r128 = com.bytedance.android.ec.base.settings.a.f42813a;
        Object r129 = 6;
        Object r130 = com.bytedance.android.ec.base.settings.d.f42818c.get("mall_image_bitmap_cache_size");     // Catch: Throwable -> L222
        if (r130 != null) goto L177;
    L219:
        Object r131 = null;
    L220:
        Object r132 = Result.m9449constructorimpl(r131);     // Catch: Throwable -> L222
    L224:
        Throwable r133 = Result.m9452exceptionOrNullimpl(r132);     // Catch: Throwable -> L328
        if (r133 == null) goto L228;
        EnsureManager.ensureNotReachHere(r133);     // Catch: Throwable -> L328
    L228:
        if (Result.m9455isFailureimpl(r132) == false) goto L231;
        r132 = null;
    L231:
        if ((r132 instanceof Integer) == true) goto L233;
        r132 = null;
    L233:
        Object r134 = (Integer) r132;     // Catch: Throwable -> L328
        if (r134 != null) goto L240;
        Object r135 = com.bytedance.android.ec.base.settings.d.f42816a.get("mall_image_bitmap_cache_size");     // Catch: Throwable -> L328
        if ((r135 instanceof Integer) == true) goto L239;
        r135 = null;
    L239:
        r134 = (Integer) r135;     // Catch: Throwable -> L328
    L240:
        if (r134 != null) goto L337;
        int r136 = com.bytedance.android.ec.base.settings.c.f42815a;     // Catch: Throwable -> L328
        Object r137 = com.bytedance.android.ec.base.settings.d.f42818c.get("mall_image_bitmap_cache_size");     // Catch: Throwable -> L292
        if (r137 != null) goto L247;
    L289:
        Object r138 = null;
    L290:
        Object r139 = Result.m9449constructorimpl(r138);     // Catch: Throwable -> L292
    L294:
        Throwable r140 = Result.m9452exceptionOrNullimpl(r139);     // Catch: Throwable -> L318
        if (r140 == null) goto L298;
        EnsureManager.ensureNotReachHere(r140);     // Catch: Throwable -> L318
    L298:
        if (Result.m9455isFailureimpl(r139) == false) goto L301;
        r139 = null;
    L301:
        if ((r139 instanceof Integer) == true) goto L303;
        r139 = null;
    L303:
        r134 = (Integer) r139;     // Catch: Throwable -> L318
        if (r134 != null) goto L326;
        IHybridHostService r141 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L318
        if (r141 == null) goto L309;
        Object r142 = r141.getHostABValue("mall_image_bitmap_cache_size", r129);     // Catch: Throwable -> L318
    L310:
        if (r142 != null) goto L312;
    L317:
        r134 = r129;
        goto L326
    L312:
        if ((r142 instanceof Integer) == false) goto L315;
        r102 = r142;
    L315:
        Object r143 = (Integer) r102;     // Catch: Throwable -> L318
        if (r143 == null) goto L317;
    L325:
        r134 = r143;
        goto L326
    L309:
        r142 = null;
    L326:
        com.bytedance.android.ec.base.settings.d.d("mall_image_bitmap_cache_size", r134);     // Catch: Throwable -> L328
        goto L337
    L247:
        if ((r137 instanceof Integer) == true) goto L249;
        Object r144 = null;
    L250:
        r138 = (Integer) r144;     // Catch: Throwable -> L292
        if (r138 != null) goto L290;
        if ((r137 instanceof Number) == false) goto L277;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L262;
        Float r145 = Float.valueOf(((Number) r137).floatValue());     // Catch: Throwable -> L292
        if ((r145 instanceof Integer) == true) goto L260;
        r145 = null;
    L260:
        r138 = (Integer) r145;     // Catch: Throwable -> L292
        goto L290
    L262:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L268;
        Double r146 = Double.valueOf(((Number) r137).doubleValue());     // Catch: Throwable -> L292
        if ((r146 instanceof Integer) == true) goto L266;
        r146 = null;
    L266:
        r138 = (Integer) r146;     // Catch: Throwable -> L292
        goto L290
    L268:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L271;
        r138 = Integer.valueOf(((Number) r137).intValue());     // Catch: Throwable -> L292
        goto L290
    L271:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L277;
        Long r147 = Long.valueOf(((Number) r137).longValue());     // Catch: Throwable -> L292
        if ((r147 instanceof Integer) == true) goto L275;
        r147 = null;
    L275:
        r138 = (Integer) r147;     // Catch: Throwable -> L292
    L277:
        if ((r137 instanceof JSONObject) == false) goto L279;
    L345:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L285
        Object r148 = SDKSettingsCacheManager.a().fromJson(r137.toString(), Integer.class);     // Catch: Throwable -> L285
        if ((r148 instanceof Integer) == true) goto L283;
        r148 = null;
    L283:
        Object r149 = Result.m9449constructorimpl((Integer) r148);     // Catch: Throwable -> L285
    L287:
        r138 = r149;
        if (Result.m9455isFailureimpl(r138) == false) goto L290;
    L285:
        th = move-exception;
        Result.Companion r150 = Result.Companion;     // Catch: Throwable -> L292
        r149 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L292
        goto L287
    L279:
        if ((r137 instanceof JSONArray) == false) goto L289;
    L249:
        r144 = r137;
    L318:
        th = move-exception;
        Result.Companion r151 = Result.Companion;     // Catch: Throwable -> L328
        r143 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L328
        Throwable r152 = Result.m9452exceptionOrNullimpl(r143);     // Catch: Throwable -> L328
        if (r152 == null) goto L323;
        EnsureManager.ensureNotReachHere(r152);     // Catch: Throwable -> L328
    L323:
        if (Result.m9455isFailureimpl(r143) == false) goto L325;
        r143 = r129;
    L292:
        th = move-exception;
        Result.Companion r153 = Result.Companion;     // Catch: Throwable -> L318
        r139 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L318
    L337:
        f47349b = ((Number) r134).intValue();
        f47350c = new Object();
        new Handler(Looper.getMainLooper());
        f47351d = new ConcurrentHashMap();
        f47352e = true;
        f47353f = new HashSet();
        return;
    L177:
        if ((r130 instanceof Integer) == true) goto L179;
        Object r154 = null;
    L180:
        r131 = (Integer) r154;     // Catch: Throwable -> L222
        if (r131 != null) goto L220;
        if ((r130 instanceof Number) == false) goto L207;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L192;
        Float r155 = Float.valueOf(((Number) r130).floatValue());     // Catch: Throwable -> L222
        if ((r155 instanceof Integer) == true) goto L190;
        r155 = null;
    L190:
        r131 = (Integer) r155;     // Catch: Throwable -> L222
        goto L220
    L192:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L198;
        Double r156 = Double.valueOf(((Number) r130).doubleValue());     // Catch: Throwable -> L222
        if ((r156 instanceof Integer) == true) goto L196;
        r156 = null;
    L196:
        r131 = (Integer) r156;     // Catch: Throwable -> L222
        goto L220
    L198:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L201;
        r131 = Integer.valueOf(((Number) r130).intValue());     // Catch: Throwable -> L222
        goto L220
    L201:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L207;
        Long r157 = Long.valueOf(((Number) r130).longValue());     // Catch: Throwable -> L222
        if ((r157 instanceof Integer) == true) goto L205;
        r157 = null;
    L205:
        r131 = (Integer) r157;     // Catch: Throwable -> L222
    L207:
        if ((r130 instanceof JSONObject) == false) goto L209;
    L343:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L215
        Object r158 = SDKSettingsCacheManager.a().fromJson(r130.toString(), Integer.class);     // Catch: Throwable -> L215
        if ((r158 instanceof Integer) == true) goto L213;
        r158 = null;
    L213:
        Object r159 = Result.m9449constructorimpl((Integer) r158);     // Catch: Throwable -> L215
    L217:
        r131 = r159;
        if (Result.m9455isFailureimpl(r131) == false) goto L220;
    L215:
        th = move-exception;
        Result.Companion r160 = Result.Companion;     // Catch: Throwable -> L222
        r159 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L222
        goto L217
    L209:
        if ((r130 instanceof JSONArray) == false) goto L219;
    L179:
        r154 = r130;
    L328:
        th = move-exception;
        Result.Companion r161 = Result.Companion;
        Object r162 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r163 = Result.m9452exceptionOrNullimpl(r162);
        if (r163 == null) goto L333;
        EnsureManager.ensureNotReachHere(r163);
    L333:
        if (Result.m9455isFailureimpl(r162) == true) goto L336;
        r129 = r162;
    L336:
        r134 = r129;
    L222:
        th = move-exception;
        Result.Companion r164 = Result.Companion;     // Catch: Throwable -> L328
        r132 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L328
        goto L224
    L8:
        if ((r104 instanceof Boolean) == true) goto L10;
        Object r165 = null;
    L11:
        r105 = (Boolean) r165;     // Catch: Throwable -> L56
        if (r105 != null) goto L54;
        if ((r104 instanceof Number) == false) goto L41;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L23;
        Float r166 = Float.valueOf(((Number) r104).floatValue());     // Catch: Throwable -> L56
        if ((r166 instanceof Boolean) == true) goto L21;
        r166 = null;
    L21:
        r105 = (Boolean) r166;     // Catch: Throwable -> L56
        goto L54
    L23:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L29;
        Double r167 = Double.valueOf(((Number) r104).doubleValue());     // Catch: Throwable -> L56
        if ((r167 instanceof Boolean) == true) goto L27;
        r167 = null;
    L27:
        r105 = (Boolean) r167;     // Catch: Throwable -> L56
        goto L54
    L29:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L35;
        Integer r168 = Integer.valueOf(((Number) r104).intValue());     // Catch: Throwable -> L56
        if ((r168 instanceof Boolean) == true) goto L33;
        r168 = null;
    L33:
        r105 = (Boolean) r168;     // Catch: Throwable -> L56
        goto L54
    L35:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L41;
        Long r169 = Long.valueOf(((Number) r104).longValue());     // Catch: Throwable -> L56
        if ((r169 instanceof Boolean) == true) goto L39;
        r169 = null;
    L39:
        r105 = (Boolean) r169;     // Catch: Throwable -> L56
    L41:
        if ((r104 instanceof JSONObject) == false) goto L43;
    L351:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L49
        Object r170 = SDKSettingsCacheManager.a().fromJson(r104.toString(), Boolean.class);     // Catch: Throwable -> L49
        if ((r170 instanceof Boolean) == true) goto L47;
        r170 = null;
    L47:
        Object r171 = Result.m9449constructorimpl((Boolean) r170);     // Catch: Throwable -> L49
    L51:
        r105 = r171;
        if (Result.m9455isFailureimpl(r105) == false) goto L54;
    L49:
        th = move-exception;
        Result.Companion r172 = Result.Companion;     // Catch: Throwable -> L56
        r171 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L56
        goto L51
    L43:
        if ((r104 instanceof JSONArray) == false) goto L53;
    L10:
        r165 = r104;
    L56:
        th = move-exception;
        Result.Companion r173 = Result.Companion;     // Catch: Throwable -> L163
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
    L163:
        th = move-exception;
        Result.Companion r174 = Result.Companion;
        Object r175 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r176 = Result.m9452exceptionOrNullimpl(r175);
        if (r176 == null) goto L168;
        EnsureManager.ensureNotReachHere(r176);
    L168:
        if (Result.m9455isFailureimpl(r175) == true) goto L171;
        r101 = r175;
    L171:
        r108 = r101;
        goto L172
    }

    public static void c(boolean r100) {
        IHybridHostService r101 = com.bytedance.android.ec.hybrid.a.h();
        if (r101 == null) goto L8;
        yj.k r102 = r101.getIHybridHostEventService();
        if (r102 == null) goto L9;
        JSONObject r103 = new JSONObject();
        r103.putOpt("success", Boolean.valueOf(r100));
        Unit r104 = Unit.INSTANCE;
        r102.logV3("ec_mall_image_cache", r103);
        return;
    L9:
        return;
    }

    public static void a(Context r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (f47348a == false) goto L15;
        HashSet<Integer> r102 = f47353f;
        if (r102.contains(Integer.valueOf(r101)) == true) goto L18;
        r102.add(Integer.valueOf(r101));
        Object r103 = f47350c;
        monitor-enter(r103);
        com.bytedance.android.ec.hybrid.a.d().submit(new a(r100));     // Catch: Throwable -> L12
        monitor-exit(r103);
        return;
    L12:
        th = move-exception;
        throw th;
    L18:
        return;
    }

    public static PolarisFileWrapper b(Context r110, String r111) {
        MessageDigest r100 = MessageDigest.getInstance("MD5");     // Catch: Exception -> L7
        Charset r101 = Charsets.UTF_8;     // Catch: Exception -> L7
        if (r111 == null) goto L6;
        String r112 = ArraysKt.joinToString$default(r100.digest(r111.getBytes(r101)), "", null, null, 0, null, ECImageFileCache$md5$1.INSTANCE, 30, null);     // Catch: Exception -> L7
    L8:
        PolarisFileWrapper r102 = new PolarisFileWrapper(r110.getFilesDir(), "ec_mall_image_cache");
        if (r102.exists() == true) goto L12;
        r102.mkdirs();
    L12:
        return new PolarisFileWrapper(r102, r112);
    L6:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");     // Catch: Exception -> L7
    L7:
        r112 = String.valueOf(r111.hashCode());
        goto L8
    }
}
