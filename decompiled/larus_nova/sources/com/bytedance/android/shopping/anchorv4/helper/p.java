package com.bytedance.android.shopping.anchorv4.helper;

import android.graphics.Point;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f166971a = 0;

    static {
    }

    public static Point b(View r100) {
        Intrinsics.checkNotNullParameter(r100, "cartView");
        return a(r100, r100.getWidth() / 2, r100.getHeight() / 2);
    }

    public static Point a(View r100, int r101, int r102) {
        int[] r103 = com.bytedance.android.shopping.utils.d0.f187076a;
        r100.getLocationOnScreen(r103);
        return new Point(r103[0] + r101, (r103[1] + r102) - com.bytedance.android.shopping.utils.d0.a());
    }
}
