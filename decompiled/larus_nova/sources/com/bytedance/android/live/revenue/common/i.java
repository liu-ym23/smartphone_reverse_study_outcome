package com.bytedance.android.live.revenue.common;

import android.content.res.Resources;
import com.bytedance.android.livehostapi.TTMiddlewareLiveSDK;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes47.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f90837a = 0;

    static {
    }

    public static float a(float r100) {
        Resources r101 = TTMiddlewareLiveSDK.getContext().getApplicationContext().getResources();
        return (r100 * WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density) + 0.5f;
    }

    public static int b(int r100) {
        return (int) a(r100);
    }
}
