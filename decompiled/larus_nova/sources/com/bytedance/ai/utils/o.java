package com.bytedance.ai.utils;

import android.content.Context;
import android.content.res.Resources;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f37679a = 0;

    static {
    }

    @JvmStatic
    public static final int a(float r100) {
        Resources r101 = Resources.getSystem();
        return (int) ((r100 * WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density) + 0.5f);
    }

    public static int c(Number r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        float r101 = r100.floatValue();
        Resources r102 = Resources.getSystem();
        return (int) ((r101 * WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density) + 0.5f);
    }

    public static int b(Context r100, double r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r100.getResources() == null) goto L8;
        Resources r102 = r100.getResources();
        if (WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()) == null) goto L10;
        Resources r103 = r100.getResources();
        return (int) ((r101 * ((double) WindowDisplayMetricsOverride.apply(r103, r103.getDisplayMetrics()).density)) + ((double) 0.5f));
    L10:
        return 0;
    L8:
        return 0;
    }

    public static int d(double r100, Context r101) {
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Resources r102 = r101.getResources();
        return (int) ((r100 / ((double) WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density)) + ((double) 0.5f));
    }
}
