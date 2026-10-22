package com.bytedance.android.shopping.utils;

import android.animation.TypeEvaluator;
import android.graphics.PointF;

/* JADX INFO: loaded from: classes14.dex */
public final class v implements TypeEvaluator<PointF> {
    public v() {
    }

    @Override // android.animation.TypeEvaluator
    public final PointF evaluate(float r100, PointF r101, PointF r102) {
        PointF r103 = r101;
        PointF r104 = r102;
        if (r103 == null) goto L8;
        if (r104 == null) goto L8;
        float r105 = r103.x;
        float r106 = r105 + ((r104.x - r105) * r100);
        float r107 = r103.y;
        return new PointF(r106, r107 + ((r104.y - r107) * r100));
    L8:
        return new PointF(0.0f, 0.0f);
    }
}
