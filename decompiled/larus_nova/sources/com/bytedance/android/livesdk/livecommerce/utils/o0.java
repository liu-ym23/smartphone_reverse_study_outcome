package com.bytedance.android.livesdk.livecommerce.utils;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class o0 {
    public static final int a(View r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$layoutMarginLeft");
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        if ((r101 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
        r101 = null;
    L5:
        ViewGroup.MarginLayoutParams r102 = (ViewGroup.MarginLayoutParams) r101;
        if (r102 != null) goto L10;
        return 0;
    L10:
        return r102.leftMargin;
    }

    public static final int b(View r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$layoutMarginRight");
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        if ((r101 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
        r101 = null;
    L5:
        ViewGroup.MarginLayoutParams r102 = (ViewGroup.MarginLayoutParams) r101;
        if (r102 != null) goto L10;
        return 0;
    L10:
        return r102.rightMargin;
    }

    public static final void c(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$layoutGravity");
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        if ((r102 instanceof FrameLayout.LayoutParams) == false) goto L6;
        ((FrameLayout.LayoutParams) r102).gravity = r101;
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
        Intrinsics.checkNotNullParameter(r100, "$this$layoutMarginLeft");
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        if ((r102 instanceof ViewGroup.MarginLayoutParams) == false) goto L6;
        ((ViewGroup.MarginLayoutParams) r102).leftMargin = r101;
        r100.setLayoutParams(r102);
        return;
    }

    public static final void f(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$layoutWidth");
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        if (r102 == null) goto L6;
        r102.width = r101;
        r100.setLayoutParams(r102);
        return;
    }
}
