package com.bytedance.android.live.revlink.impl.rtc;

import android.graphics.Matrix;
import android.graphics.RectF;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class c {
    public static final RectF a(RectF r100, RectF r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$transformByCropFromCanvasGrid");
        RectF r102 = new RectF(r100);
        if (r101 != null) goto L5;
        return r102;
    L5:
        float r103 = r101.left;
        float r104 = r101.top;
        float r105 = r101.width();
        float r106 = r101.height();
        Matrix r107 = new Matrix();
        r107.postScale(r105, r106);
        r107.postTranslate(r103, r104);
        Intrinsics.checkNotNullParameter(r107, "matrix");
        Matrix r108 = new Matrix();
        r107.invert(r108);
        r108.mapRect(r102);
        return r102;
    }
}
