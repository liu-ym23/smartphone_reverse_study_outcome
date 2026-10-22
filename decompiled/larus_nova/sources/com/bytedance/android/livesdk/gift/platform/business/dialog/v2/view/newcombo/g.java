package com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo;

import android.animation.TypeEvaluator;
import android.graphics.PointF;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class g implements TypeEvaluator<PointF> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PointF f126861a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PointF f126862b;

    public g(PointF r100, PointF r101) {
        Intrinsics.checkNotNullParameter(r100, "controlPoint1");
        Intrinsics.checkNotNullParameter(r101, "controlPoint2");
        this.f126861a = r100;
        this.f126862b = r101;
    }

    @Override // android.animation.TypeEvaluator
    public final PointF evaluate(float r100, PointF r110, PointF r111) {
        PointF r112 = r110;
        PointF r113 = r111;
        Intrinsics.checkNotNullParameter(r112, "startValue");
        Intrinsics.checkNotNullParameter(r113, "endValue");
        PointF r101 = new PointF();
        float r102 = 1 - r100;
        float r103 = (r102 * r102) * r102;
        float r104 = r112.x * r103;
        float r105 = 3 * r100;
        float r106 = (r105 * r102) * r102;
        PointF r107 = this.f126861a;
        float r108 = r104 + (r107.x * r106);
        float r109 = (r105 * r100) * r102;
        PointF r114 = this.f126862b;
        float r115 = (r100 * r100) * r100;
        r101.x = (r108 + (r114.x * r109)) + (r113.x * r115);
        r101.y = (((r103 * r112.y) + (r106 * r107.y)) + (r109 * r114.y)) + (r115 * r113.y);
        return r101;
    }
}
