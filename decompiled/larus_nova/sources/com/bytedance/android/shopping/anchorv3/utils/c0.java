package com.bytedance.android.shopping.anchorv3.utils;

import android.content.Context;
import android.content.res.Resources;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes12.dex */
public final class c0 {
    public static int a(double r100) {
        Context r101 = ECAppInfoService.f48114e.getApplicationContext();
        if (r101 != null) goto L5;
        return 0;
    L5:
        if (r101.getResources() == null) goto L12;
        Resources r102 = r101.getResources();
        if (WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()) == null) goto L13;
        Resources r103 = r101.getResources();
        return (int) ((r100 * ((double) WindowDisplayMetricsOverride.apply(r103, r103.getDisplayMetrics()).density)) + 0.5d);
    L13:
        return 0;
    L12:
        return 0;
    }
}
