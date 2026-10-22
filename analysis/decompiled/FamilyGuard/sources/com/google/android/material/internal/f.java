package com.google.android.material.internal;

/* loaded from: classes.dex */
final class f {
    static void a(float f5, float[] fArr) {
        if (f5 <= 0.5f) {
            fArr[0] = 1.0f - (f5 * 2.0f);
            fArr[1] = 0.0f;
        } else {
            fArr[0] = 0.0f;
            fArr[1] = (f5 * 2.0f) - 1.0f;
        }
    }
}
