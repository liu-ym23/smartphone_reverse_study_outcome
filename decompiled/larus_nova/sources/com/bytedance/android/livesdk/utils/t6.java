package com.bytedance.android.livesdk.utils;

import android.content.Context;
import android.content.res.Resources;
import com.bytedance.common.utility.UIUtils;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes11.dex */
public final class t6 {
    public static int b(Context r100) {
        if (r100 != null) goto L5;
        return 0;
    L5:
        int r101 = UIUtils.getScreenWidth(r100);
        int r102 = UIUtils.getScreenHeight(r100);
        if (r102 >= r101) goto L9;
        return r101;
    L9:
        return r102;
    }

    public static int c(Context r100) {
        if (r100 != null) goto L5;
        return 0;
    L5:
        int r101 = UIUtils.getScreenWidth(r100);
        int r102 = UIUtils.getScreenHeight(r100);
        if (r102 <= r101) goto L9;
        return r101;
    L9:
        return r102;
    }

    public static float a(Context r100, float r101) {
        Resources r102 = r100.getResources();
        return (r101 * WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density) + 0.5f;
    }

    public static int d(Context r100, float r101) {
        Resources r102 = r100.getResources();
        return (int) ((r101 / WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density) + 0.5f);
    }
}
