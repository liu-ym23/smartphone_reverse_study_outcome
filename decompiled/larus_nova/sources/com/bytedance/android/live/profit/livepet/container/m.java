package com.bytedance.android.live.profit.livepet.container;

import android.graphics.RectF;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class m {
    public static final String a(a r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$describe");
        return r100 + " [" + r100.getLeft() + ", " + r100.getTop() + ", " + r100.getRight() + ", " + r100.getBottom() + "] " + b(r100);
    }

    public static final RectF b(a r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$toNormalizedRect");
        a r101 = r100.getRoot();
        Intrinsics.checkNotNullParameter(r101, "$this$getWidth");
        float r102 = Math.max(0, r101.getRight() - r101.getLeft());
        Intrinsics.checkNotNullParameter(r101, "$this$getHeight");
        float r103 = Math.max(0, r101.getBottom() - r101.getTop());
        float r104 = 0.0f;
        if (r102 != 0.0f) goto L5;
        float r105 = 0.0f;
    L7:
        if (r103 != 0.0f) goto L9;
        float r106 = 0.0f;
    L10:
        if (r102 != 0.0f) goto L12;
        float r107 = 0.0f;
    L13:
        if (r103 == 0.0f) goto L17;
        r104 = r100.getBottom() / r103;
    L17:
        return new RectF(r105, r106, r107, r104);
    L12:
        r107 = r100.getRight() / r102;
        goto L13
    L9:
        r106 = r100.getTop() / r103;
        goto L10
    L5:
        r105 = r100.getLeft() / r102;
        goto L7
    }
}
