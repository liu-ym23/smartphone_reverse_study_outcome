package com.google.android.material.shape;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public class EdgeTreatment {
    public EdgeTreatment() {
    }

    public boolean forceIntersection() {
        return false;
    }

    @Deprecated
    public void getEdgePath(float r10, float r11, @NonNull ShapePath r12) {
        getEdgePath(r10, r10 / 2.0f, r11, r12);
    }

    public void getEdgePath(float r10, float r11, float r12, @NonNull ShapePath r13) {
        r13.lineTo(r10, 0.0f);
    }
}
