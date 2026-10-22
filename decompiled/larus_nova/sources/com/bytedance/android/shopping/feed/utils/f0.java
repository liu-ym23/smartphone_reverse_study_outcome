package com.bytedance.android.shopping.feed.utils;

import android.view.View;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class f0 {
    public static final View a(RecyclerView r100, OrientationHelper r101, Integer r110) {
        Intrinsics.checkNotNullParameter(r100, "$this$findCenterView");
        Intrinsics.checkNotNullParameter(r101, "helper");
        RecyclerView.LayoutManager r102 = r100.getLayoutManager();
        View r103 = null;
        if (r102 == null) goto L25;
        int r104 = r102.getChildCount();
        if (r104 == 0) goto L25;
        if (r102.getClipToPadding() == false) goto L10;
        int r105 = r101.getStartAfterPadding() + (r101.getTotalSpace() / 2);
    L11:
        int r106 = Integer.MAX_VALUE;
        int r107 = 0;
    L12:
        if (r107 >= r104) goto L25;
        View r108 = r102.getChildAt(r107);
        if (r108 == null) goto L16;
        int r109 = r102.getPosition(r108);
    L17:
        if (r110 != null) goto L20;
    L21:
        int r111 = Math.abs((r101.getDecoratedStart(r108) + (r101.getDecoratedMeasurement(r108) / 2)) - r105);
        if (r111 >= r106) goto L24;
        r103 = r108;
        r106 = r111;
    L24:
        r107 = r107 + 1;
        goto L12
    L20:
        if (r109 == r110.intValue()) goto L24;
    L16:
        r109 = -1;
        goto L17
    L10:
        r105 = r101.getEnd() / 2;
    L25:
        return r103;
    }
}
