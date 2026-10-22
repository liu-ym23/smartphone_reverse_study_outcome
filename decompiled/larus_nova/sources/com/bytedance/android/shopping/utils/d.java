package com.bytedance.android.shopping.utils;

import android.animation.TypeEvaluator;
import android.graphics.Point;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class d implements TypeEvaluator<Point> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Point f187075a;

    public d(Point r100) {
        Intrinsics.checkNotNullParameter(r100, "controlPoint");
        this.f187075a = r100;
    }

    @Override // android.animation.TypeEvaluator
    public final Point evaluate(float r100, Point r101, Point r102) {
        Point r103 = r101;
        Point r104 = r102;
        if (r103 == null) goto L8;
        if (r104 == null) goto L8;
        float r105 = 1 - r100;
        float r106 = r105 * r105;
        float r107 = r103.x * r106;
        float r108 = (2 * r100) * r105;
        Point r109 = this.f187075a;
        float r110 = r100 * r100;
        return new Point((int) ((r107 + (r109.x * r108)) + (r104.x * r110)), (int) (((r106 * r103.y) + (r108 * r109.y)) + (r110 * r104.y)));
    L8:
        return new Point(0, 0);
    }
}
