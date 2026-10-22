package com.bytedance.android.livesdk.dslservice.slice.cache;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes8.dex */
public final class GlobalExprParseContext {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f122932a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f122933b = null;

    static {
        f122932a = LazyKt.lazy(GlobalExprParseContext$exprCacheManager$2.INSTANCE);
        f122933b = LazyKt.lazy(GlobalExprParseContext$exprContext$2.INSTANCE);
    }
}
