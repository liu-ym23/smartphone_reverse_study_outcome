package androidx.core.content.b;

import android.graphics.Color;

/* JADX INFO: compiled from: CamUtils.java */
/* JADX INFO: loaded from: classes.dex */
final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final float[][] f1156a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final float[][] f1157b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final float[] f1158c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final float[][] f1159d = null;

    static float a(float r0, float r1, float r2) {
        return r0 + ((r1 - r0) * r2);
    }

    static {
        f1156a = new float[][]{new float[]{0.401288f, 0.650173f, -0.051461f}, new float[]{-0.250268f, 1.204414f, 0.045854f}, new float[]{-0.002079f, 0.048952f, 0.953127f}};
        f1157b = new float[][]{new float[]{1.8620678f, -1.0112547f, 0.14918678f}, new float[]{0.38752654f, 0.62144744f, -0.00897398f}, new float[]{-0.0158415f, -0.03412294f, 1.0499644f}};
        f1158c = new float[]{95.047f, 100.0f, 108.883f};
        f1159d = new float[][]{new float[]{0.41233894f, 0.35762063f, 0.18051042f}, new float[]{0.2126f, 0.7152f, 0.0722f}, new float[]{0.01932141f, 0.11916382f, 0.9503448f}};
    }

    static int a(float r15) {
        if (r15 >= 1.0f) goto L7;
        return -16777216;
    L7:
        if (r15 <= 99.0f) goto L10;
        return -1;
    L10:
        float r1 = (r15 + 16.0f) / 116.0f;
        if (r15 <= 8.0f) goto L13;
        boolean r5 = true;
    L14:
        if (r5 == false) goto L16;
        float r16 = (r1 * r1) * r1;
    L17:
        float r6 = (r1 * r1) * r1;
        if (r6 <= 0.008856452f) goto L20;
        boolean r4 = true;
    L21:
        if (r4 == false) goto L23;
        float r8 = r6;
    L24:
        if (r4 == true) goto L27;
        r6 = ((r1 * 116.0f) - 16.0f) / 903.2963f;
    L27:
        float[] r0 = f1158c;
        return androidx.core.graphics.e.a(r8 * r0[0], r16 * r0[1], r6 * r0[2]);
    L23:
        r8 = ((r1 * 116.0f) - 16.0f) / 903.2963f;
        goto L24
    L20:
        r4 = false;
        goto L21
    L16:
        r16 = r15 / 903.2963f;
        goto L17
    L13:
        r5 = false;
        goto L14
    }

    static float a(int r0) {
        return b(b(r0));
    }

    static float b(float r2) {
        float r3 = r2 / 100.0f;
        if (r3 > 0.008856452f) goto L7;
        return r3 * 903.2963f;
    L7:
        return (((float) Math.cbrt(r3)) * 116.0f) - 16.0f;
    }

    static float b(int r6) {
        float r0 = c(Color.red(r6));
        float r1 = c(Color.green(r6));
        float r7 = c(Color.blue(r6));
        float[][] r2 = f1159d;
        return ((r0 * r2[1][0]) + (r1 * r2[1][1])) + (r7 * r2[1][2]);
    }

    static void a(int r8, float[] r9) {
        float r0 = c(Color.red(r8));
        float r1 = c(Color.green(r8));
        float r10 = c(Color.blue(r8));
        float[][] r2 = f1159d;
        r9[0] = ((r2[0][0] * r0) + (r2[0][1] * r1)) + (r2[0][2] * r10);
        r9[1] = ((r2[1][0] * r0) + (r2[1][1] * r1)) + (r2[1][2] * r10);
        r9[2] = ((r0 * r2[2][0]) + (r1 * r2[2][1])) + (r10 * r2[2][2]);
    }

    static float c(float r6) {
        if (r6 <= 8.0f) goto L7;
        float r7 = (float) Math.pow((((double) r6) + 16.0d) / 116.0d, 3.0d);
    L6:
        return r7 * 100.0f;
    L7:
        r7 = r6 / 903.2963f;
        goto L6
    }

    static float c(int r6) {
        float r7 = r6 / 255.0f;
        if (r7 > 0.04045f) goto L7;
        float r8 = r7 / 12.92f;
    L6:
        return r8 * 100.0f;
    L7:
        r8 = (float) Math.pow((r7 + 0.055f) / 1.055f, 2.4000000953674316d);
        goto L6
    }
}
