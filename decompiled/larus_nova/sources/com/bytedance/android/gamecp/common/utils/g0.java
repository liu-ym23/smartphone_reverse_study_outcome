package com.bytedance.android.gamecp.common.utils;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class g0 {
    public static final int a(View r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$layoutGravity");
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        if ((r101 instanceof FrameLayout.LayoutParams) == false) goto L7;
        return ((FrameLayout.LayoutParams) r101).gravity;
    L7:
        if ((r101 instanceof CoordinatorLayout.LayoutParams) == true) goto L9;
        return 0;
    L9:
        return ((CoordinatorLayout.LayoutParams) r101).gravity;
    }

    public static final int b(View r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$layoutWidth");
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        if (r101 != null) goto L7;
        return 0;
    L7:
        return r101.width;
    }

    public static final void c(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$layoutGravity");
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        if ((r102 instanceof FrameLayout.LayoutParams) == false) goto L6;
        ((FrameLayout.LayoutParams) r102).gravity = r101;
        r100.setLayoutParams(r102);
        return;
    L6:
        if ((r102 instanceof CoordinatorLayout.LayoutParams) == false) goto L10;
        ((CoordinatorLayout.LayoutParams) r102).gravity = r101;
        r100.setLayoutParams(r102);
        return;
    }

    public static final void d(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$layoutHeight");
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        if (r102 == null) goto L6;
        r102.height = r101;
        r100.setLayoutParams(r102);
        return;
    }

    public static final void e(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$layoutMarginBottom");
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        if ((r102 instanceof ViewGroup.MarginLayoutParams) == false) goto L6;
        ((ViewGroup.MarginLayoutParams) r102).bottomMargin = r101;
        r100.setLayoutParams(r102);
        return;
    }

    public static final void f(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$layoutMarginLeft");
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        if ((r102 instanceof ViewGroup.MarginLayoutParams) == false) goto L6;
        ((ViewGroup.MarginLayoutParams) r102).leftMargin = r101;
        r100.setLayoutParams(r102);
        return;
    }

    public static final void g(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$layoutMarginRight");
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        if ((r102 instanceof ViewGroup.MarginLayoutParams) == false) goto L6;
        ((ViewGroup.MarginLayoutParams) r102).rightMargin = r101;
        r100.setLayoutParams(r102);
        return;
    }

    public static final void h(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$layoutMarginTop");
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        if ((r102 instanceof ViewGroup.MarginLayoutParams) == false) goto L6;
        ((ViewGroup.MarginLayoutParams) r102).topMargin = r101;
        r100.setLayoutParams(r102);
        return;
    }

    public static final void i(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$layoutWidth");
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        if (r102 == null) goto L6;
        r102.width = r101;
        r100.setLayoutParams(r102);
        return;
    }
}
