package com.bytedance.android.shopping.buynow.utils;

import android.view.View;
import android.widget.HorizontalScrollView;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class q {
    static {
    }

    @JvmStatic
    public static final int a(View r100, View r101) {
        if (r100 == null) goto L14;
        if (r101 != null) goto L6;
        return 0;
    L6:
        if (Intrinsics.areEqual(r100.getParent(), r101) == true) goto L8;
        int r102 = r100.getLeft();
        Object r103 = r100.getParent();
        if ((r103 instanceof View) == true) goto L13;
        r103 = null;
    L13:
        return r102 + a((View) r103, r101);
    L8:
        return r100.getLeft();
    L14:
        return 0;
    }

    @JvmStatic
    public static final int b(View r100, View r101) {
        if (r100 == null) goto L14;
        if (r101 != null) goto L6;
        return 0;
    L6:
        if (Intrinsics.areEqual(r100.getParent(), r101) == true) goto L8;
        int r102 = r100.getTop();
        Object r103 = r100.getParent();
        if ((r103 instanceof View) == true) goto L13;
        r103 = null;
    L13:
        return r102 + b((View) r103, r101);
    L8:
        return r100.getTop();
    L14:
        return 0;
    }

    @JvmStatic
    public static final void c(View r100, HorizontalScrollView r101) {
        if (r100 == null) goto L7;
        if (r101 == null) goto L8;
        r101.smoothScrollTo(a(r100, r101) - ((r101.getWidth() - r100.getWidth()) / 2), 0);
        return;
    L8:
        return;
    }
}
