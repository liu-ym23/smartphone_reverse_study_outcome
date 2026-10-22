package com.bytedance.android.gamecp.business.gamedetail.view;

import android.content.Context;
import android.content.res.Resources;
import android.view.ViewConfiguration;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final float f55873a = 0.0f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final float f55874b = 0.0f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static float f55875c;

    public static final class a {
    }

    static {
        f55873a = (float) (Math.log(0.78d) / Math.log(0.9d));
        f55874b = ViewConfiguration.getScrollFriction();
    }

    public h(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Resources r101 = r100.getResources();
        f55875c = (((WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density * 9.80665f) * 160.0f) * 39.37f) * 0.84f;
    }

    public static double a(int r100) {
        float r101 = Math.abs(r100) * 0.35f;
        float r102 = f55874b;
        double r103 = Math.log(r101 / (f55875c * r102));
        double r104 = f55873a;
        return Math.exp(r103 * (r104 / (r104 - 1.0d))) * ((double) (r102 * f55875c));
    }
}
