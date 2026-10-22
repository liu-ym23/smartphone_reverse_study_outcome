package com.google.android.material.math;

/* JADX INFO: loaded from: classes3.dex */
public final class MathUtils {
    public static final float DEFAULT_EPSILON = 1.0E-4f;

    private MathUtils() {
    }

    public static float dist(float r10, float r11, float r12, float r13) {
        return (float) Math.hypot(r12 - r10, r13 - r11);
    }

    public static float distanceToFurthestCorner(float r10, float r11, float r12, float r13, float r14, float r15) {
        return max(dist(r10, r11, r12, r13), dist(r10, r11, r14, r13), dist(r10, r11, r14, r15), dist(r10, r11, r12, r15));
    }

    public static float floorMod(float r10, int r11) {
        float r12 = r11;
        int r13 = (int) (r10 / r12);
        if ((Math.signum(r10) * r12) >= 0.0f) goto L8;
        if ((r13 * r11) == r10) goto L8;
        r13 = r13 - 1;
    L8:
        return r10 - (r13 * r11);
    }

    public static boolean geq(float r10, float r11, float r12) {
        if ((r10 + r12) < r11) goto L5;
        return true;
    L5:
        return false;
    }

    public static float lerp(float r10, float r11, float r12) {
        return ((1.0f - r12) * r10) + (r12 * r11);
    }

    private static float max(float r10, float r11, float r12, float r13) {
        if (r10 <= r11) goto L10;
        if (r10 <= r12) goto L10;
        if (r10 <= r13) goto L10;
        return r10;
    L10:
        if (r11 <= r12) goto L15;
        if (r11 <= r13) goto L15;
        return r11;
    L15:
        if (r12 <= r13) goto L18;
        return r12;
    L18:
        return r13;
    }

    public static int floorMod(int r10, int r11) {
        int r12 = r10 / r11;
        if ((r10 ^ r11) >= 0) goto L8;
        if ((r12 * r11) == r10) goto L8;
        r12 = r12 - 1;
    L8:
        return r10 - (r12 * r11);
    }
}
