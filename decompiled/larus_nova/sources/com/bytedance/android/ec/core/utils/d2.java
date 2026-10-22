package com.bytedance.android.ec.core.utils;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class d2 {
    public static final void a(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$setBottomMargin");
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        if ((r102 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
        r102 = null;
    L5:
        ViewGroup.MarginLayoutParams r103 = (ViewGroup.MarginLayoutParams) r102;
        if (r103 == null) goto L9;
        r103.bottomMargin = r101;
        Unit r104 = Unit.INSTANCE;
        r100.setLayoutParams(r103);
        return;
    }

    public static final void b(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$setGravity");
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        if ((r102 instanceof FrameLayout.LayoutParams) == true) goto L5;
        r102 = null;
    L5:
        FrameLayout.LayoutParams r103 = (FrameLayout.LayoutParams) r102;
        if (r103 == null) goto L9;
        r103.gravity = r101;
        Unit r104 = Unit.INSTANCE;
        r100.setLayoutParams(r103);
        return;
    }

    public static final void c(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$setLeftMargin");
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        if ((r102 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
        r102 = null;
    L5:
        ViewGroup.MarginLayoutParams r103 = (ViewGroup.MarginLayoutParams) r102;
        if (r103 == null) goto L9;
        r103.leftMargin = r101;
        Unit r104 = Unit.INSTANCE;
        r100.setLayoutParams(r103);
        return;
    }

    public static final void e(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$setRightMargin");
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        if ((r102 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
        r102 = null;
    L5:
        ViewGroup.MarginLayoutParams r103 = (ViewGroup.MarginLayoutParams) r102;
        if (r103 == null) goto L9;
        r103.rightMargin = r101;
        Unit r104 = Unit.INSTANCE;
        r100.setLayoutParams(r103);
        return;
    }

    public static final void f(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$setTopMargin");
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        if ((r102 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
        r102 = null;
    L5:
        ViewGroup.MarginLayoutParams r103 = (ViewGroup.MarginLayoutParams) r102;
        if (r103 == null) goto L9;
        r103.topMargin = r101;
        Unit r104 = Unit.INSTANCE;
        r100.setLayoutParams(r103);
        return;
    }

    public static final void d(View r100, int r101, int r102, int r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, "$this$setMargins");
        ViewGroup.LayoutParams r105 = r100.getLayoutParams();
        if ((r105 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
        r105 = null;
    L5:
        ViewGroup.MarginLayoutParams r106 = (ViewGroup.MarginLayoutParams) r105;
        if (r106 == null) goto L9;
        r106.setMargins(r101, r102, r103, r104);
        Unit r107 = Unit.INSTANCE;
        r100.setLayoutParams(r106);
        return;
    }
}
