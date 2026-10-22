package com.bytedance.android.ec.core.utils;

import android.content.res.Resources;
import android.util.TypedValue;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class q {
    public static final float a(Number r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$dpFloat");
        float r101 = r100.floatValue();
        Resources r102 = uf4.a.a().getResources();
        return TypedValue.applyDimension(1, r101, WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()));
    }

    public static final float b(Number r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$spFloat");
        float r101 = r100.floatValue();
        Resources r102 = uf4.a.a().getResources();
        return TypedValue.applyDimension(2, r101, WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()));
    }
}
