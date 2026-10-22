package com.bytedance.android.live.core.utils;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class a1 {
    public static final int d(View r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$layoutHeight");
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        if (r101 != null) goto L7;
        return 0;
    L7:
        return r101.height;
    }

    public static final int e(View r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$layoutMarginBottom");
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        if ((r101 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
        r101 = null;
    L5:
        ViewGroup.MarginLayoutParams r102 = (ViewGroup.MarginLayoutParams) r101;
        if (r102 != null) goto L10;
        return 0;
    L10:
        return r102.bottomMargin;
    }

    public static final int f(View r100) {
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

    public static final int g(View r100) {
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

    public static final int h(View r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$layoutMarginTop");
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        if ((r101 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
        r101 = null;
    L5:
        ViewGroup.MarginLayoutParams r102 = (ViewGroup.MarginLayoutParams) r101;
        if (r102 != null) goto L10;
        return 0;
    L10:
        return r102.topMargin;
    }

    public static final int i(View r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$layoutWidth");
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        if (r101 != null) goto L7;
        return 0;
    L7:
        return r101.width;
    }

    public static final void j(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$layoutGravity");
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        if ((r102 instanceof FrameLayout.LayoutParams) == false) goto L6;
        ((FrameLayout.LayoutParams) r102).gravity = r101;
        r100.setLayoutParams(r102);
        return;
    }

    public static final void k(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$layoutHeight");
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        if (r102 == null) goto L6;
        r102.height = r101;
        r100.setLayoutParams(r102);
        return;
    }

    public static final void l(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$layoutMarginBottom");
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        if ((r102 instanceof ViewGroup.MarginLayoutParams) == false) goto L6;
        ((ViewGroup.MarginLayoutParams) r102).bottomMargin = r101;
        r100.setLayoutParams(r102);
        return;
    }

    public static final void m(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$layoutMarginLeft");
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        if ((r102 instanceof ViewGroup.MarginLayoutParams) == false) goto L6;
        ((ViewGroup.MarginLayoutParams) r102).leftMargin = r101;
        r100.setLayoutParams(r102);
        return;
    }

    public static final void n(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$layoutMarginRight");
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        if ((r102 instanceof ViewGroup.MarginLayoutParams) == false) goto L6;
        ((ViewGroup.MarginLayoutParams) r102).rightMargin = r101;
        r100.setLayoutParams(r102);
        return;
    }

    public static final void o(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$layoutMarginTop");
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        if ((r102 instanceof ViewGroup.MarginLayoutParams) == false) goto L6;
        ((ViewGroup.MarginLayoutParams) r102).topMargin = r101;
        r100.setLayoutParams(r102);
        return;
    }

    public static final void p(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$layoutWidth");
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        if (r102 == null) goto L6;
        r102.width = r101;
        r100.setLayoutParams(r102);
        return;
    }

    public static void a(FrameLayout r100, View r101, Integer r110, Integer r111, Integer r112, int r113) {
        if ((r113 & 8) == 0) goto L6;
        r110 = null;
    L6:
        if ((r113 & 16) == 0) goto L8;
        Integer r102 = null;
    L10:
        if ((r113 & 128) == 0) goto L12;
        Integer r103 = null;
    L13:
        Intrinsics.checkNotNullParameter(r100, "$this$addView");
        Intrinsics.checkNotNullParameter(r101, "view");
        r100.addView(r101, b(r101.getLayoutParams(), null, null, r110, r102, null, null, r103));
        return;
    L12:
        r103 = r112;
        goto L13
    L8:
        r102 = r111;
        goto L10
    }

    public static final FrameLayout.LayoutParams b(ViewGroup.LayoutParams r100, Integer r101, Integer r102, Integer r103, Integer r104, Integer r105, Integer r106, Integer r107) {
        if ((r100 instanceof FrameLayout.LayoutParams) == false) goto L10;
        if (r100 == null) goto L8;
        FrameLayout.LayoutParams r108 = new FrameLayout.LayoutParams((ViewGroup.MarginLayoutParams) r100);
        r108.gravity = ((FrameLayout.LayoutParams) r100).gravity;
    L16:
        if (r101 == null) goto L18;
        r108.width = r101.intValue();
    L18:
        if (r102 == null) goto L20;
        r108.height = r102.intValue();
    L20:
        if (r107 == null) goto L22;
        r108.gravity = r107.intValue();
    L22:
        if (r103 == null) goto L24;
        r108.leftMargin = r103.intValue();
    L24:
        if (r104 == null) goto L26;
        r108.topMargin = r104.intValue();
    L26:
        if (r105 == null) goto L28;
        r108.rightMargin = r105.intValue();
    L28:
        if (r106 == null) goto L30;
        r108.bottomMargin = r106.intValue();
    L30:
        return r108;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L10:
        if ((r100 instanceof ViewGroup.MarginLayoutParams) == false) goto L13;
        r108 = new FrameLayout.LayoutParams((ViewGroup.MarginLayoutParams) r100);
        goto L16
    L13:
        if ((r100 instanceof ViewGroup.LayoutParams) == false) goto L15;
        r108 = new FrameLayout.LayoutParams(r100);
        goto L16
    L15:
        r108 = new FrameLayout.LayoutParams(0, 0, 0);
        goto L16
    }

    public static /* synthetic */ FrameLayout.LayoutParams c(ViewGroup.LayoutParams r100, Integer r101, Integer r102, Integer r103, Integer r104, Integer r105, Integer r106, int r107) {
        if ((r107 & 1) == 0) goto L6;
        r101 = null;
    L6:
        if ((r107 & 2) == 0) goto L9;
        r102 = null;
    L9:
        if ((r107 & 4) == 0) goto L12;
        r103 = null;
    L12:
        if ((r107 & 8) == 0) goto L15;
        r104 = null;
    L15:
        if ((r107 & 16) == 0) goto L18;
        r105 = null;
    L18:
        if ((r107 & 32) == 0) goto L21;
        r106 = null;
    L21:
        return b(r100, r101, r102, r103, r104, r105, r106, null);
    }
}
