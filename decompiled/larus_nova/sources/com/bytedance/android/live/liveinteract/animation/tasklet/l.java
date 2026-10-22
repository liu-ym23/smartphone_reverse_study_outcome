package com.bytedance.android.live.liveinteract.animation.tasklet;

import android.animation.TypeEvaluator;
import android.graphics.PointF;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class l implements TypeEvaluator<PointF> {
    public l() {
    }

    @Override // android.animation.TypeEvaluator
    public final PointF evaluate(float r100, PointF r101, PointF r102) {
        PointF r103 = r101;
        PointF r104 = r102;
        Intrinsics.checkNotNullParameter(r103, "startValue");
        Intrinsics.checkNotNullParameter(r104, "endValue");
        PointF r105 = new PointF();
        float r106 = r103.x;
        r105.x = r106 + ((r104.x - r106) * r100);
        float r107 = r103.y;
        r105.y = r107 + ((r104.y - r107) * r100);
        return r105;
    }
}
