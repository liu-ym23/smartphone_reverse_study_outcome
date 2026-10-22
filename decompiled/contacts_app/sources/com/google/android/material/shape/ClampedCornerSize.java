package com.google.android.material.shape;

import android.graphics.RectF;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class ClampedCornerSize implements CornerSize {
    private final float target;

    public static ClampedCornerSize createFromCornerSize(AbsoluteCornerSize r1) {
        return new ClampedCornerSize(r1.getCornerSize());
    }

    private static float getMaxCornerSize(RectF r2) {
        return Math.min(r2.width() / 2.0f, r2.height() / 2.0f);
    }

    public ClampedCornerSize(float r1) {
        this.target = r1;
    }

    @Override // com.google.android.material.shape.CornerSize
    public float getCornerSize(RectF r1) {
        return Math.min(this.target, getMaxCornerSize(r1));
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof ClampedCornerSize) == true) goto L9;
        return false;
    L9:
        if (this.target != ((ClampedCornerSize) r4).target) goto L12;
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.target)});
    }
}
