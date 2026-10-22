package com.bytedance.android.live.liveinteract.utils;

import android.animation.TypeEvaluator;
import android.graphics.PointF;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class f implements TypeEvaluator<PointF> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PointF f78765a;

    public f(PointF r100) {
        Intrinsics.checkNotNullParameter(r100, "controlPoint");
        this.f78765a = r100;
    }

    @Override // android.animation.TypeEvaluator
    public final PointF evaluate(float r100, PointF r101, PointF r102) {
        PointF r103 = r101;
        PointF r104 = r102;
        Intrinsics.checkNotNullParameter(r103, "startValue");
        Intrinsics.checkNotNullParameter(r104, "endValue");
        PointF r105 = this.f78765a;
        PointF r106 = new PointF();
        float r107 = 1 - r100;
        float r108 = r107 * r107;
        float r109 = (2 * r100) * r107;
        float r110 = r100 * r100;
        r106.x = ((r103.x * r108) + (r105.x * r109)) + (r104.x * r110);
        r106.y = ((r108 * r103.y) + (r109 * r105.y)) + (r110 * r104.y);
        return r106;
    }
}
