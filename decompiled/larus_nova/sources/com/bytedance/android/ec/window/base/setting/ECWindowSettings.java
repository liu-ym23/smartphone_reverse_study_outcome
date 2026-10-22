package com.bytedance.android.ec.window.base.setting;

import com.bytedance.android.ec.core.opt.ab.p;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class ECWindowSettings {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f49556a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f49557b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f49558c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f49559d = null;

    static {
        f49556a = LazyKt.lazy(ECWindowSettings$PRODUCT_LIST_PITAYA_CONFIG_OPT$2.INSTANCE);
        f49557b = LazyKt.lazy(ECWindowSettings$EC_SHOP_IMAGE_PRELOAD_CONFIG_OPT$2.INSTANCE);
        f49558c = LazyKt.lazy(ECWindowSettings$EC_SHOP_ACTION_EVENTS_OPT$2.INSTANCE);
        f49559d = LazyKt.lazy(ECWindowSettings$SHOP_LOAD_MORE_CONFIG_OPT$2.INSTANCE);
    }

    public static final boolean a() {
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
}
