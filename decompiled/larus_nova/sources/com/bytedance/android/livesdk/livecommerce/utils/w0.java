package com.bytedance.android.livesdk.livecommerce.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes10.dex */
public final class w0 {
    public static Context getContext() {
        return com.bytedance.android.livesdk.livecommerce.room.f.a();
    }

    public static Resources getResources() {
        Context r100 = getContext();
        if (r100 != null) goto L6;
        return null;
    L6:
        return r100.getResources();
    }

    public static int a(float r100) {
        Resources r101 = Resources.getSystem();
        return (int) ((r100 * WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density) + 0.5f);
    }

    public static float b(float r100) {
        Resources r101 = Resources.getSystem();
        return TypedValue.applyDimension(2, r100, WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()));
    }
}
