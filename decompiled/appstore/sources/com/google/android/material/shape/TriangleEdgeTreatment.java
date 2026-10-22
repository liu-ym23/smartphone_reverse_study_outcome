package com.google.android.material.shape;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public class TriangleEdgeTreatment extends EdgeTreatment {
    private final boolean inside;
    private final float size;

    public TriangleEdgeTreatment(float r10, boolean r11) {
        this.size = r10;
        this.inside = r11;
    }

    @Override // com.google.android.material.shape.EdgeTreatment
    public void getEdgePath(float r10, float r11, float r12, @NonNull ShapePath r13) {
        r13.lineTo(r11 - (this.size * r12), 0.0f);
        if (this.inside == false) goto L6;
        float r14 = this.size;
    L7:
        r13.lineTo(r11, r14 * r12);
        r13.lineTo(r11 + (this.size * r12), 0.0f);
        r13.lineTo(r10, 0.0f);
        return;
    L6:
        r14 = -this.size;
        goto L7
    }
}
