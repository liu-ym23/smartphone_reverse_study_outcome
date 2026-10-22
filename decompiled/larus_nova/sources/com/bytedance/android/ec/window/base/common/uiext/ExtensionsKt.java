package com.bytedance.android.ec.window.base.common.uiext;

import android.util.DisplayMetrics;
import android.util.TypedValue;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class ExtensionsKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f49216a = null;

    static {
        f49216a = LazyKt.lazy(ExtensionsKt$metrics$2.INSTANCE);
    }

    public static final int a(Number r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$dp");
        return (int) Math.rint(TypedValue.applyDimension(1, r100.floatValue(), (DisplayMetrics) f49216a.getValue()));
    }

    public static final float b(Number r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$dpFloat");
        return TypedValue.applyDimension(1, r100.floatValue(), (DisplayMetrics) f49216a.getValue());
    }
}
