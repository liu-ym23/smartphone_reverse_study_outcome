package com.google.android.material.e;

/* JADX INFO: compiled from: MathUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public static float a(float r1, float r2, float r3) {
        return ((1.0f - r3) * r1) + (r3 * r2);
    }

    private static float b(float r1, float r2, float r3, float r4) {
        if (r1 <= r2) goto L10;
        if (r1 <= r3) goto L10;
        if (r1 <= r4) goto L10;
        return r1;
    L10:
        if (r2 <= r3) goto L15;
        if (r2 <= r4) goto L15;
        return r2;
    L15:
        if (r3 <= r4) goto L18;
        return r3;
    L18:
        return r4;
    }

    public static boolean b(float r0, float r1, float r2) {
        if ((r0 + r2) < r1) goto L5;
        return true;
    L5:
        return false;
    }

    public static float a(float r0, float r1, float r2, float r3) {
        return (float) Math.hypot(r2 - r0, r3 - r1);
    }

    public static float a(float r1, float r2, float r3, float r4, float r5, float r6) {
        return b(a(r1, r2, r3, r4), a(r1, r2, r5, r4), a(r1, r2, r5, r6), a(r1, r2, r3, r6));
    }
}
