package com.bytedance.android.ec.window.base.dynamicview.common;

import android.graphics.Rect;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a {
    public static final void a(Object r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "name");
        if (r100 == null) goto L5;
        return;
    L5:
        if (c.f49250a == false) goto L8;
        return;
    }

    public static final void b(ViewGroup.MarginLayoutParams r100, Rect r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$setMargins");
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.left;
    L6:
        r100.leftMargin = r103;
        if (r101 == null) goto L9;
        int r104 = r101.top;
    L10:
        r100.topMargin = r104;
        if (r101 == null) goto L13;
        int r105 = r101.right;
    L14:
        r100.rightMargin = r105;
        if (r101 == null) goto L17;
        r102 = r101.bottom;
    L17:
        r100.bottomMargin = r102;
        return;
    L13:
        r105 = 0;
        goto L14
    L9:
        r104 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }
}
