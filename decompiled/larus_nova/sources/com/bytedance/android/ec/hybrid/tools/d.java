package com.bytedance.android.ec.hybrid.tools;

import android.content.res.Resources;
import android.util.TypedValue;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class d {
    public static final int a(Number r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$layout");
        int r101 = r100.intValue();
        if (r101 < (-2)) goto L9;
        if (r101 < 0) goto L10;
        Intrinsics.checkNotNullParameter(r100, "$this$dp");
        float r102 = r100.floatValue();
        Resources r103 = Resources.getSystem();
        return (int) TypedValue.applyDimension(1, r102, WindowDisplayMetricsOverride.apply(r103, r103.getDisplayMetrics()));
    L10:
        return r101;
    L9:
        throw new IllegalArgumentException("LayoutParams not support width_height_value=" + r101 + ", need >= -2");
    }

    public static final int b(Number r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$margin");
        Intrinsics.checkNotNullParameter(r100, "$this$dp");
        float r101 = r100.floatValue();
        Resources r102 = Resources.getSystem();
        return (int) TypedValue.applyDimension(1, r101, WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()));
    }
}
