package com.bytedance.android.livesdk.player.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.bytedance.android.livesdkapi.host.ILivePlayerHostService;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes11.dex */
public final class h {
    @JvmStatic
    public static final int d() {
        Resources r100 = Resources.getSystem();
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics()).heightPixels;
    }

    @JvmStatic
    public static final int e() {
        Resources r100 = Resources.getSystem();
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics()).widthPixels;
    }

    static {
    }

    public static float a(float r100) {
        Resources r101 = Resources.getSystem();
        return (r100 * WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density) + 0.5f;
    }

    public static int b(float r100) {
        Resources r101 = Resources.getSystem();
        return (int) ((r100 * WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density) + 0.5f);
    }

    public static Drawable c(int r100) {
        ILivePlayerHostService r101 = is0.c.c().hostService();
        if (r101 == null) goto L5;
        Context r102 = r101.context();
    L6:
        if (r102 != null) goto L8;
        return null;
    L8:
        if (r102.getResources() != null) goto L11;
        return null;
    L11:
        return r102.getResources().getDrawable(r100);
    L5:
        r102 = null;
        goto L6
    }
}
