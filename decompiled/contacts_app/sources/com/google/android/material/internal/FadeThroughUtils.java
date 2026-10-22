package com.google.android.material.internal;

/* JADX INFO: loaded from: classes2.dex */
final class FadeThroughUtils {
    static final float THRESHOLD_ALPHA = 0.5f;

    static void calculateFadeOutAndInAlphas(float r6, float[] r7) {
        if (r6 > 0.5f) goto L5;
        r7[0] = 1.0f - (r6 * 2.0f);
        r7[1] = 0.0f;
        return;
    L5:
        r7[0] = 0.0f;
        r7[1] = (r6 * 2.0f) - 1.0f;
    }

    private FadeThroughUtils() {
    }
}
