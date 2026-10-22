package com.google.android.material.shape;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public class RoundedCornerTreatment extends CornerTreatment {
    float radius;

    public RoundedCornerTreatment() {
        this.radius = -1.0f;
    }

    @Override // com.google.android.material.shape.CornerTreatment
    public void getCornerPath(@NonNull ShapePath r10, float r11, float r12, float r13) {
        r10.reset(0.0f, r13 * r12, 180.0f, 180.0f - r11);
        float r14 = (r13 * 2.0f) * r12;
        r10.addArc(0.0f, 0.0f, r14, r14, 180.0f, r11);
    }

    @Deprecated
    public RoundedCornerTreatment(float r10) {
        this.radius = r10;
    }
}
