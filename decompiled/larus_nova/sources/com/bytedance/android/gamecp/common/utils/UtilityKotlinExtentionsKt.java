package com.bytedance.android.gamecp.common.utils;

import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bytedance.common.utility.UIUtils;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes44.dex */
public final class UtilityKotlinExtentionsKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Handler f57194a = null;

    static {
        f57194a = new Handler(Looper.getMainLooper());
    }

    public static final Sequence<View> a(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$children");
        return SequencesKt.sequence(new UtilityKotlinExtentionsKt$children$1(r100, null));
    }

    public static final float b(float r100) {
        Resources r101 = com.bytedance.android.gamecp.host_api.a.b().getHostContext().getAppContext().getResources();
        return (WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density * r100) + 0.5f;
    }

    public static final int c(int r100) {
        return (int) b(r100);
    }

    public static final float d(float r100) {
        Resources r101 = com.bytedance.android.gamecp.host_api.a.b().getHostContext().getAppContext().getResources();
        return TypedValue.applyDimension(2, r100, WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()));
    }

    public static final int e(int r100) {
        return (int) d(r100);
    }

    public static final ViewGroup f(View r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$parentView");
        ViewParent r101 = r100.getParent();
        if ((r101 instanceof ViewGroup) == true) goto L6;
        r101 = null;
    L6:
        return (ViewGroup) r101;
    }

    public static final void h(View r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$setVisibilityGone");
        UIUtils.setViewVisibility(r100, 8);
    }

    public static final void i(View r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$setVisibilityInVisible");
        UIUtils.setViewVisibility(r100, 4);
    }

    public static final void j(View r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$setVisibilityVisible");
        UIUtils.setViewVisibility(r100, 0);
    }

    public static final void k(View r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$visibleOrGone");
        if (r101 == false) goto L5;
        int r102 = 0;
    L6:
        r100.setVisibility(r102);
        return;
    L5:
        r102 = 8;
        goto L6
    }

    public static void g(long r100, boolean r101, boolean r102, Function0 r103, int r104) {
        if ((r104 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = false;
    L9:
        if ((r104 & 4) == 0) goto L11;
        r102 = false;
    L11:
        Intrinsics.checkNotNullParameter(r103, "action");
        if (r100 <= 0) goto L14;
        f57194a.postDelayed(new p1(r103), r100);
        return;
    L14:
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L17;
        if (r102 == true) goto L17;
        r103.invoke();
        return;
    L17:
        if (r101 == false) goto L19;
        f57194a.postAtTime(new p1(r103), 2);
        return;
    L19:
        f57194a.post(new p1(r103));
    }
}
