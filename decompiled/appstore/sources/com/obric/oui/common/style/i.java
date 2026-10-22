package com.obric.oui.common.style;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;

/* JADX INFO: loaded from: classes4.dex */
public abstract class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static TypedValue f13076a;

    public static int a(Context r10, int r11) {
        if (f13076a != null) goto L6;
        f13076a = new TypedValue();
    L6:
        if (r10.getTheme().resolveAttribute(r11, f13076a, true) == true) goto L10;
        return 0;
    L10:
        return TypedValue.complexToDimensionPixelSize(f13076a.data, g.a(r10));
    }

    public static float b(Context r10, int r11) {
        return c(r10.getTheme(), r11);
    }

    public static float c(Resources.Theme r10, int r11) {
        if (f13076a != null) goto L6;
        f13076a = new TypedValue();
    L6:
        if (r10.resolveAttribute(r11, f13076a, true) == true) goto L10;
        return -1.0f;
    L10:
        return f13076a.getFloat();
    }

    public static TypedArray d(Resources r10, Resources.Theme r11, AttributeSet r12, int[] r13) {
        if (r11 != null) goto L5;
        return r10.obtainAttributes(r12, r13);
    L5:
        return r11.obtainStyledAttributes(r12, r13, 0, 0);
    }
}
