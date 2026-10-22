package com.bytedance.android.livesdk.chatroom.vs_base.util;

import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bytedance.android.livehostapi.TTMiddlewareLiveSDK;
import com.bytedance.common.utility.UIUtils;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes8.dex */
public final class UtilityKotlinExtentionsKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Handler f118187a = null;

    static {
        f118187a = new Handler(Looper.getMainLooper());
    }

    public static final Sequence<View> a(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$children");
        return SequencesKt.sequence(new UtilityKotlinExtentionsKt$children$1(r100, null));
    }

    public static final float b(float r100) {
        Resources r101 = TTMiddlewareLiveSDK.getContext().getApplicationContext().getResources();
        return (WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density * r100) + 0.5f;
    }

    public static final int c(int r100) {
        return (int) b(r100);
    }

    public static final float d(int r100) {
        Resources r101 = TTMiddlewareLiveSDK.getContext().getApplicationContext().getResources();
        return (r100 / WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density) + 0.5f;
    }

    public static final ViewGroup f(View r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$parentView");
        ViewParent r101 = r100.getParent();
        if ((r101 instanceof ViewGroup) == true) goto L6;
        r101 = null;
    L6:
        return (ViewGroup) r101;
    }

    public static void g(Function0 r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
        r100.invoke();
        return;
    L5:
        f118187a.post(new a0(r100));
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

    public static final boolean e(Object r100, Object... r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$isAnyOf");
        Intrinsics.checkNotNullParameter(r101, "args");
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L11;
        if (Intrinsics.areEqual(r101[r103], r100) == true) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return true;
    L11:
        return false;
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
}
