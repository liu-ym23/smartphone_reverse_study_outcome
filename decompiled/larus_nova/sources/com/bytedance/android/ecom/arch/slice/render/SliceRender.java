package com.bytedance.android.ecom.arch.slice.render;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.bytedance.android.ecom.arch.slice.render.util.SlcDimensExtensionsKt;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes44.dex */
public final class SliceRender {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f50107a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static pq.a f50108b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f50109c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f50110d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f50111e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Lazy f50112f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Lazy f50113g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Lazy f50114h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Lazy f50115i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Lazy f50116j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Lazy f50117k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Lazy f50118l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Lazy f50119m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Lazy f50120n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final SliceRender f50121o = null;

    public SliceRender() {
    }

    public static boolean b() {
        Lazy r100 = f50112f;
        KProperty r101 = f50107a[3];
        return ((Boolean) r100.getValue()).booleanValue();
    }

    public static boolean c() {
        Lazy r100 = f50117k;
        KProperty r101 = f50107a[8];
        return ((Boolean) r100.getValue()).booleanValue();
    }

    public static boolean d() {
        Lazy r100 = f50113g;
        KProperty r101 = f50107a[4];
        return ((Boolean) r100.getValue()).booleanValue();
    }

    public static boolean e() {
        Lazy r100 = f50114h;
        KProperty r101 = f50107a[5];
        return ((Boolean) r100.getValue()).booleanValue();
    }

    public static boolean f() {
        Lazy r100 = f50118l;
        KProperty r101 = f50107a[9];
        return ((Boolean) r100.getValue()).booleanValue();
    }

    public static ExecutorService g() {
        Lazy r100 = f50109c;
        KProperty r101 = f50107a[0];
        return (ExecutorService) r100.getValue();
    }

    static {
        f50107a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(SliceRender.class), "logExecutor", "getLogExecutor()Ljava/util/concurrent/ExecutorService;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(SliceRender.class), "bgSingleExecutor", "getBgSingleExecutor()Ljava/util/concurrent/ExecutorService;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(SliceRender.class), "imageRequestExecutor", "getImageRequestExecutor$slice_render_release()Ljava/util/concurrent/Executor;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(SliceRender.class), "enableCustomA11yProcess", "getEnableCustomA11yProcess$slice_render_release()Z")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(SliceRender.class), "enableLeafFlatten", "getEnableLeafFlatten()Z")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(SliceRender.class), "enableLevelFlatten", "getEnableLevelFlatten()Z")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(SliceRender.class), "enableA11yFlatten", "getEnableA11yFlatten()Z")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(SliceRender.class), "enableFlattenPool", "getEnableFlattenPool()Z")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(SliceRender.class), "enableCustomViewMigration", "getEnableCustomViewMigration()Z")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(SliceRender.class), "enableOverflowAlign", "getEnableOverflowAlign()Z")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(SliceRender.class), "enableStaticDisplayInBindInfo", "getEnableStaticDisplayInBindInfo()Z")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(SliceRender.class), "globalProps", "getGlobalProps$slice_render_release()Ljava/util/Map;"))};
        f50121o = new SliceRender();
        f50109c = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, SliceRender$logExecutor$2.INSTANCE);
        f50110d = LazyKt.lazy(SliceRender$bgSingleExecutor$2.INSTANCE);
        f50111e = LazyKt.lazy(SliceRender$imageRequestExecutor$2.INSTANCE);
        f50112f = LazyKt.lazy(SliceRender$enableCustomA11yProcess$2.INSTANCE);
        f50113g = LazyKt.lazy(SliceRender$enableLeafFlatten$2.INSTANCE);
        f50114h = LazyKt.lazy(SliceRender$enableLevelFlatten$2.INSTANCE);
        f50115i = LazyKt.lazy(SliceRender$enableA11yFlatten$2.INSTANCE);
        f50116j = LazyKt.lazy(SliceRender$enableFlattenPool$2.INSTANCE);
        f50117k = LazyKt.lazy(SliceRender$enableCustomViewMigration$2.INSTANCE);
        f50118l = LazyKt.lazy(SliceRender$enableOverflowAlign$2.INSTANCE);
        f50119m = LazyKt.lazy(SliceRender$enableStaticDisplayInBindInfo$2.INSTANCE);
        f50120n = LazyKt.lazy(SliceRender$globalProps$2.INSTANCE);
        new CopyOnWriteArrayList();
    }

    public static Map a(Map r100) {
        return MapsKt.hashMapOf(new Pair[]{TuplesKt.to("data", r100)});
    }

    public static Map h(Context r100, com.bytedance.android.ecom.arch.slice.render.context.b r101, Map r102) {
        HashMap r103 = new HashMap();
        f50121o.getClass();
        Lazy r104 = f50120n;
        KProperty r105 = f50107a[11];
        r103.putAll((Map) r104.getValue());
        int r106 = com.bytedance.android.ecom.arch.slice.render.util.h.f50744b;
        int r107 = 0;
        if (r106 > 0) goto L12;
        if (r100 != null) goto L7;
        r106 = 0;
        goto L12
    L7:
        Resources r108 = r100.getResources();
        int r109 = r108.getIdentifier("status_bar_height", "dimen", "android");
        if (r109 <= 0) goto L10;
        r106 = r108.getDimensionPixelSize(r109);
    L11:
        com.bytedance.android.ecom.arch.slice.render.util.h.f50744b = r106;
        goto L12
    L10:
        r106 = 0;
    L12:
        r103.put("status_bar_height", Integer.valueOf(Math.round(SlcDimensExtensionsKt.d(Integer.valueOf(r106), r101))));
        r103.put("custom", r102);
        int r110 = com.bytedance.android.ecom.arch.slice.render.util.h.f50745c;
        if (r110 > 0) goto L23;
        Resources r111 = r100.getResources();
        DisplayMetrics r112 = WindowDisplayMetricsOverride.apply(r111, r111.getDisplayMetrics());
        int r113 = r112.heightPixels;
        int r114 = r112.widthPixels;
        if (r113 <= r114) goto L18;
        com.bytedance.android.ecom.arch.slice.render.util.h.f50746d = r113;
        com.bytedance.android.ecom.arch.slice.render.util.h.f50745c = r114;
    L19:
        r110 = com.bytedance.android.ecom.arch.slice.render.util.h.f50745c;
        if (r110 > 0) goto L23;
        r110 = 0;
        goto L23
    L18:
        com.bytedance.android.ecom.arch.slice.render.util.h.f50746d = r114;
        com.bytedance.android.ecom.arch.slice.render.util.h.f50745c = r113;
    L23:
        r103.put("screen_width", Integer.valueOf(Math.round(SlcDimensExtensionsKt.d(Integer.valueOf(r110), r101))));
        int r115 = com.bytedance.android.ecom.arch.slice.render.util.h.f50746d;
        if (r115 > 0) goto L34;
        Resources r116 = r100.getResources();
        DisplayMetrics r117 = WindowDisplayMetricsOverride.apply(r116, r116.getDisplayMetrics());
        int r118 = r117.heightPixels;
        int r119 = r117.widthPixels;
        if (r118 <= r119) goto L29;
        com.bytedance.android.ecom.arch.slice.render.util.h.f50746d = r118;
        com.bytedance.android.ecom.arch.slice.render.util.h.f50745c = r119;
    L30:
        int r120 = com.bytedance.android.ecom.arch.slice.render.util.h.f50746d;
        if (r120 <= 0) goto L33;
        r107 = r120;
    L33:
        r115 = r107;
        goto L34
    L29:
        com.bytedance.android.ecom.arch.slice.render.util.h.f50746d = r119;
        com.bytedance.android.ecom.arch.slice.render.util.h.f50745c = r118;
    L34:
        r103.put("screen_height", Integer.valueOf(Math.round(SlcDimensExtensionsKt.d(Integer.valueOf(r115), r101))));
        float r121 = r101.f50240b;
        com.bytedance.android.ecom.arch.slice.render.context.b.f50238f.getClass();
        r103.put("scale", Float.valueOf(r121 / com.bytedance.android.ecom.arch.slice.render.context.b.f50237e.f50239a));
        r103.put("font_scale", Float.valueOf(r101.f50242d));
        return r103;
    }
}
