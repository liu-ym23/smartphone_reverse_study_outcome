package com.google.android.material.transition;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.NonNull;
import androidx.transition.PathMotion;

/* JADX INFO: loaded from: classes3.dex */
public final class MaterialArcMotion extends PathMotion {
    public MaterialArcMotion() {
    }

    private static PointF getControlPoint(float r10, float r11, float r12, float r13) {
        if (r11 <= r13) goto L7;
        return new PointF(r12, r11);
    L7:
        return new PointF(r10, r13);
    }

    @Override // androidx.transition.PathMotion
    @NonNull
    public Path getPath(float r10, float r11, float r12, float r13) {
        Path r14 = new Path();
        r14.moveTo(r10, r11);
        PointF r15 = getControlPoint(r10, r11, r12, r13);
        r14.quadTo(r15.x, r15.y, r12, r13);
        return r14;
    }
}
