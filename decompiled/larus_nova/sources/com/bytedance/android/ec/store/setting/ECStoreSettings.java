package com.bytedance.android.ec.store.setting;

import com.bytedance.android.ec.core.opt.ab.p;
import com.bytedance.android.ec.core.utils.t0;
import com.bytedance.android.ec.hybrid.data.gecko.HybridForestLoader;
import com.google.gson.JsonElement;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class ECStoreSettings {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f48572a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f48573b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f48574c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f48575d = null;

    static {
        f48572a = LazyKt.lazy(ECStoreSettings$PRODUCT_LIST_PITAYA_CONFIG_OPT$2.INSTANCE);
        f48573b = LazyKt.lazy(ECStoreSettings$EC_SHOP_IMAGE_PRELOAD_CONFIG_OPT$2.INSTANCE);
        f48574c = LazyKt.lazy(ECStoreSettings$EC_SHOP_ACTION_EVENTS_OPT$2.INSTANCE);
        f48575d = LazyKt.lazy(ECStoreSettings$SHOP_LOAD_MORE_CONFIG_OPT$2.INSTANCE);
    }

    public static final f a() {
        int r100 = p.f45243a;
        Object r101 = null;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L5
        jj4.b r103 = jj4.b.f499326b;     // Catch: Throwable -> L5
        Object r104 = jj4.a.a("ec_shop_dynamic_card_control", f.class, null, false);     // Catch: Throwable -> L5
    L12:
        return (f) r104;
    L5:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Object r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r106) == true) goto L10;
        r101 = r106;
    L10:
        r104 = r101;
        goto L12
    }

    public static final JsonElement b() {
        int r100 = p.f45243a;
        Object r101 = null;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L5
        jj4.b r103 = jj4.b.f499326b;     // Catch: Throwable -> L5
        Object r104 = jj4.a.a("ec_shop_domain_preload_config", JsonElement.class, null, false);     // Catch: Throwable -> L5
    L12:
        return (JsonElement) r104;
    L5:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Object r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r106) == true) goto L10;
        r101 = r106;
    L10:
        r104 = r101;
        goto L12
    }

    public static final int c() {
        int r100 = p.f45243a;
        Object r101 = 0;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r103 = jj4.b.f499326b;     // Catch: Throwable -> L7
        Object r104 = jj4.a.a("ec_shop_disable_fps_monitor", Integer.class, r101, false);     // Catch: Throwable -> L7
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

    public static final JsonElement d() {
        int r100 = p.f45243a;
        Object r101 = null;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L5
        jj4.b r103 = jj4.b.f499326b;     // Catch: Throwable -> L5
        Object r104 = jj4.a.a("ec_shop_res_preload_config", JsonElement.class, null, false);     // Catch: Throwable -> L5
    L12:
        return (JsonElement) r104;
    L5:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Object r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r106) == true) goto L10;
        r101 = r106;
    L10:
        r104 = r101;
        goto L12
    }

    public static final boolean e() {
        int r100 = p.f45243a;
        Object r101 = Boolean.TRUE;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r103 = jj4.b.f499326b;     // Catch: Throwable -> L7
        Object r104 = jj4.a.a("ec_shop_saas_float_window", Boolean.class, r101, false);     // Catch: Throwable -> L7
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

    public static final boolean f() {
        int r100 = p.f45243a;
        Object r101 = Boolean.FALSE;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r103 = jj4.b.f499326b;     // Catch: Throwable -> L7
        Object r104 = jj4.a.a("ec_store_over_scroll_opt", Boolean.class, r101, false);     // Catch: Throwable -> L7
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

    public static final e g() {
        int r100 = p.f45243a;
        Object r101 = null;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L5
        jj4.b r103 = jj4.b.f499326b;     // Catch: Throwable -> L5
        Object r104 = jj4.a.a("shop_collapse_animation_config", e.class, null, false);     // Catch: Throwable -> L5
    L12:
        return (e) r104;
    L5:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Object r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r106) == true) goto L10;
        r101 = r106;
    L10:
        r104 = r101;
        goto L12
    }

    public static String h() {
        LinkedHashMap r100 = new LinkedHashMap();
        int r101 = p.f45243a;
        Object r102 = null;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L5
        jj4.b r104 = jj4.b.f499326b;     // Catch: Throwable -> L5
        Object r105 = jj4.a.a("ec_shop_decoration_channels", List.class, null, false);     // Catch: Throwable -> L5
    L9:
        List r106 = (List) r105;
        if (r106 == null) goto L29;
        Iterator r107 = r106.iterator();
    L13:
        if (r107.hasNext() == false) goto L29;
        String r108 = (String) r107.next();
        Map<String, Long> r109 = HybridForestLoader.f46691a;
        Long r110 = HybridForestLoader.b(r108);
        if (r110 == null) goto L17;
        long r111 = r110.longValue();
    L18:
        r100.put(r108, Long.valueOf(r111));
        goto L13
    L17:
        r111 = -1;
    L29:
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L21
        int r113 = t0.f45720a;     // Catch: Throwable -> L21
        Object r114 = Result.m9449constructorimpl(t0.a.f45721a.toJson(r100));     // Catch: Throwable -> L21
    L24:
        if (Result.m9455isFailureimpl(r114) == true) goto L28;
        r102 = r114;
    L28:
        return (String) r102;
    L21:
        th = move-exception;
        Result.Companion r115 = Result.Companion;
        r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L5:
        th = move-exception;
        Result.Companion r116 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r105) == false) goto L9;
        r105 = null;
        goto L9
    }
}
