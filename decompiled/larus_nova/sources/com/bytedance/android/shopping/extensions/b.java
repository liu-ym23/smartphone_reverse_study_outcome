package com.bytedance.android.shopping.extensions;

import android.content.res.Resources;
import android.util.TypedValue;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes13.dex */
public final class b {
    public static final int a(Number r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$dp2px");
        float r101 = r100.floatValue();
        Resources r102 = Resources.getSystem();
        return MathKt.roundToInt((r101 * WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density) + 0.5f);
    }

    public static final int b(Number r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$dp");
        float r101 = r100.floatValue();
        Resources r102 = Resources.getSystem();
        return (int) TypedValue.applyDimension(1, r101, WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()));
    }

    public static final float c(Number r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$sp");
        float r101 = r100.floatValue();
        Resources r102 = uf4.a.a().getResources();
        return TypedValue.applyDimension(2, r101, WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()));
    }

    public static final float d(Number r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$toDp");
        float r101 = r100.floatValue();
        Resources r102 = Resources.getSystem();
        return r101 / WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density;
    }

    public static final int e(Number r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$toDpInt");
        return MathKt.roundToInt(d(r100));
    }

    public static final Object f(Number r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$px2dp");
        Resources r101 = Resources.getSystem();
        float r102 = WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density;
        if (r102 == 0.0f) goto L12;
        return Float.valueOf((float) Math.ceil(r100.floatValue() / Math.max(1.0f, r102)));
    L7:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return Unit.INSTANCE;
    L12:
        return r100;
    }
}
