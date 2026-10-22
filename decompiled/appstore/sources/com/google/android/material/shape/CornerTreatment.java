package com.google.android.material.shape;

import android.graphics.RectF;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public class CornerTreatment {
    public CornerTreatment() {
    }

    @Deprecated
    public void getCornerPath(float r10, float r11, @NonNull ShapePath r12) {
    }

    public void getCornerPath(@NonNull ShapePath r10, float r11, float r12, float r13) {
        getCornerPath(r11, r12, r10);
    }

    public void getCornerPath(@NonNull ShapePath r10, float r11, float r12, @NonNull RectF r13, @NonNull CornerSize r14) {
        getCornerPath(r10, r11, r12, r14.getCornerSize(r13));
    }
}
