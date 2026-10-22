package com.bytedance.android.anniex.utils;

import android.content.res.Resources;
import android.util.TypedValue;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes43.dex */
public final class j {
    public static final int a(int r100) {
        Resources r101 = Resources.getSystem();
        return (int) TypedValue.applyDimension(1, r100, WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()));
    }

    public static final int b(float r100) {
        Resources r101 = Resources.getSystem();
        return (int) ((r100 / WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density) + 0.5f);
    }
}
