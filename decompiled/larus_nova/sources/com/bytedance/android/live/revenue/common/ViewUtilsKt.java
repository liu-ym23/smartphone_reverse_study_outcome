package com.bytedance.android.live.revenue.common;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.common.utility.UIUtils;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes47.dex */
public final class ViewUtilsKt {
    public static final Sequence<View> a(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$children");
        return SequencesKt.sequence(new ViewUtilsKt$children$1(r100, null));
    }

    public static final void e(View r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$setVisibilityGone");
        UIUtils.setViewVisibility(r100, 8);
    }

    public static final void f(View r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$setVisibilityVisible");
        UIUtils.setViewVisibility(r100, 0);
    }

    public static final void b(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$layoutMarginBottom");
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        if ((r102 instanceof ViewGroup.MarginLayoutParams) == false) goto L6;
        ((ViewGroup.MarginLayoutParams) r102).bottomMargin = r101;
        r100.setLayoutParams(r102);
        return;
    }

    public static final void c(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$layoutMarginLeft");
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        if ((r102 instanceof ViewGroup.MarginLayoutParams) == false) goto L6;
        ((ViewGroup.MarginLayoutParams) r102).leftMargin = r101;
        r100.setLayoutParams(r102);
        return;
    }

    public static final void d(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$layoutWidth");
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        if (r102 == null) goto L6;
        r102.width = r101;
        r100.setLayoutParams(r102);
        return;
    }

    public static final void g(View r100, boolean r101) {
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
