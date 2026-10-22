package com.bytedance.android.livesdk.dsl.util;

import com.bytedance.android.live.core.log.ALogger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class DSLLog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f122804a = null;

    static {
        f122804a = LazyKt.lazy(DSLLog$isLocalTest$2.INSTANCE);
    }

    public static void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "content");
        ALogger.i("DSL_DYNAMIC_LOG", r100);
    }
}
