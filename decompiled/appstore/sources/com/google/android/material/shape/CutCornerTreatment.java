package com.google.android.material.shape;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public class CutCornerTreatment extends CornerTreatment {
    float size;

    public CutCornerTreatment() {
        this.size = -1.0f;
    }

    @Override // com.google.android.material.shape.CornerTreatment
    public void getCornerPath(@NonNull ShapePath r10, float r11, float r12, float r13) {
        r10.reset(0.0f, r13 * r12, 180.0f, 180.0f - r11);
        double r14 = r13;
        double r15 = r12;
        r10.lineTo((float) ((Math.sin(Math.toRadians(r11)) * r14) * r15), (float) ((Math.sin(Math.toRadians(90.0f - r11)) * r14) * r15));
    }

    @Deprecated
    public CutCornerTreatment(float r10) {
        this.size = r10;
    }
}
