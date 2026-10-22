package com.google.android.material.shape;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public final class MarkerEdgeTreatment extends EdgeTreatment {
    private final float radius;

    public MarkerEdgeTreatment(float r10) {
        this.radius = r10 - 0.001f;
    }

    @Override // com.google.android.material.shape.EdgeTreatment
    public boolean forceIntersection() {
        return true;
    }

    @Override // com.google.android.material.shape.EdgeTreatment
    public void getEdgePath(float r10, float r11, float r12, @NonNull ShapePath r13) {
        float r14 = (float) ((((double) this.radius) * Math.sqrt(2.0d)) / 2.0d);
        float r15 = (float) Math.sqrt(Math.pow(this.radius, 2.0d) - Math.pow(r14, 2.0d));
        r13.reset(r11 - r14, ((float) (-((((double) this.radius) * Math.sqrt(2.0d)) - ((double) this.radius)))) + r15);
        r13.lineTo(r11, (float) (-((((double) this.radius) * Math.sqrt(2.0d)) - ((double) this.radius))));
        r13.lineTo(r11 + r14, ((float) (-((((double) this.radius) * Math.sqrt(2.0d)) - ((double) this.radius)))) + r15);
    }
}
