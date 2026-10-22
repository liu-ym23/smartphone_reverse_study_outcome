package com.bytedance.android.ec.window.base.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f49722a = 0;

    public static final float[] b(float r100, float r101, float r102, float r103) {
        return new float[]{r100, r100, r101, r101, r102, r102, r103, r103};
    }

    static {
        f49722a = dg4.b.c();
    }

    public static final View a(View r100, Function1<? super View, Boolean> r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$findViewWithCondition");
        Intrinsics.checkNotNullParameter(r101, "condition");
        if (r101.invoke(r100).booleanValue() == false) goto L5;
        View r102 = r100;
    L6:
        if (r102 == null) goto L9;
        return r102;
    L9:
        if ((r100 instanceof ViewGroup) == true) goto L11;
        return null;
    L11:
        ViewGroup r103 = (ViewGroup) r100;
        int r104 = r103.getChildCount();
        int r105 = 0;
    L12:
        if (r105 >= r104) goto L25;
        View r106 = r103.getChildAt(r105);
        if (r101.invoke(r106).booleanValue() == false) goto L16;
        View r107 = r106;
    L17:
        if (r107 != null) goto L18;
        if ((r106 instanceof ViewGroup) == false) goto L24;
        View r108 = a(r106, r101);
        if (r108 == null) goto L24;
        return r108;
    L24:
        r105 = r105 + 1;
        goto L12
    L18:
        return r107;
    L16:
        r107 = null;
        goto L17
    L25:
        return null;
    L5:
        r102 = null;
        goto L6
    }

    public static final int c(Context r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$getColorCompat");
        if (Build.VERSION.SDK_INT < 23) goto L6;
        return th.a.e(r100, true).getColor(r101);
    L6:
        return th.a.f(r100).getColor(r101);
    }

    public static final void d(View r100, Drawable r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$setBackgroundCompat");
        r100.setBackground(r101);
    }

    public static final void e(GradientDrawable r100, int[] r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$setColorsCompat");
        Intrinsics.checkNotNullParameter(r101, "colors");
        r100.setColors(r101);
    }

    public static final void f(GradientDrawable r100, GradientDrawable.Orientation r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$setOrientationCompat");
        Intrinsics.checkNotNullParameter(r101, "orientation");
        r100.setOrientation(r101);
    }
}
