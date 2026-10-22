package com.bytedance.android.ec.core.sku;

import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class SkuPerformanceOpt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f45320a = null;

    public static Map b() {
        return (Map) f45320a.getValue();
    }

    static {
        f45320a = LazyKt.lazy(LazyThreadSafetyMode.NONE, SkuPerformanceOpt$performanceAB$2.INSTANCE);
    }

    public static void a() {
        Map r100 = b();
        if (r100 == null) goto L5;
        Object r101 = r100.get("ec_sku_client_opt");
    L6:
        Intrinsics.areEqual(r101, 1);
        return;
    L5:
        r101 = null;
        goto L6
    }
}
