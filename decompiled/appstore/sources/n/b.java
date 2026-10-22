package n;

import android.graphics.Color;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final float[][] f22320a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final float[][] f22321b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final float[] f22322c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final float[][] f22323d = null;

    static {
        f22320a = new float[][]{new float[]{0.401288f, 0.650173f, -0.051461f}, new float[]{-0.250268f, 1.204414f, 0.045854f}, new float[]{-0.002079f, 0.048952f, 0.953127f}};
        f22321b = new float[][]{new float[]{1.8620678f, -1.0112547f, 0.14918678f}, new float[]{0.38752654f, 0.62144744f, -0.00897398f}, new float[]{-0.0158415f, -0.03412294f, 1.0499644f}};
        f22322c = new float[]{95.047f, 100.0f, 108.883f};
        f22323d = new float[][]{new float[]{0.41233894f, 0.35762063f, 0.18051042f}, new float[]{0.2126f, 0.7152f, 0.0722f}, new float[]{0.01932141f, 0.11916382f, 0.9503448f}};
    }

    public static int a(float r15) {
        if (r15 >= 1.0f) goto L7;
        return -16777216;
    L7:
        if (r15 <= 99.0f) goto L10;
        return -1;
    L10:
        float r10 = (r15 + 16.0f) / 116.0f;
        if (r15 <= 8.0f) goto L13;
        float r16 = (r10 * r10) * r10;
    L14:
        float r11 = (r10 * r10) * r10;
        if (r11 <= 0.008856452f) goto L17;
        boolean r12 = true;
    L18:
        if (r12 == false) goto L20;
        float r13 = r11;
    L21:
        if (r12 == true) goto L24;
        r11 = ((r10 * 116.0f) - 16.0f) / 903.2963f;
    L24:
        float[] r14 = f22322c;
        return androidx.core.graphics.d.b(r13 * r14[0], r16 * r14[1], r11 * r14[2]);
    L20:
        r13 = ((r10 * 116.0f) - 16.0f) / 903.2963f;
        goto L21
    L17:
        r12 = false;
        goto L18
    L13:
        r16 = r15 / 903.2963f;
        goto L14
    }

    public static float b(int r10) {
        return c(g(r10));
    }

    public static float c(float r10) {
        float r11 = r10 / 100.0f;
        if (r11 > 0.008856452f) goto L7;
        return r11 * 903.2963f;
    L7:
        return (((float) Math.cbrt(r11)) * 116.0f) - 16.0f;
    }

    public static float d(float r10, float r11, float r12) {
        return r10 + ((r11 - r10) * r12);
    }

    public static float e(int r10) {
        float r11 = r10 / 255.0f;
        if (r11 > 0.04045f) goto L7;
        float r12 = r11 / 12.92f;
    L6:
        return r12 * 100.0f;
    L7:
        r12 = (float) Math.pow((r11 + 0.055f) / 1.055f, 2.4000000953674316d);
        goto L6
    }

    public static float[] f(int r10) {
        float r11 = e(Color.red(r10));
        float r12 = e(Color.green(r10));
        float r13 = e(Color.blue(r10));
        float[][] r14 = f22323d;
        float[] r15 = r14[0];
        float r16 = ((r15[0] * r11) + (r15[1] * r12)) + (r15[2] * r13);
        float[] r17 = r14[1];
        float r18 = ((r17[0] * r11) + (r17[1] * r12)) + (r17[2] * r13);
        float[] r19 = r14[2];
        return new float[]{r16, r18, ((r11 * r19[0]) + (r12 * r19[1])) + (r13 * r19[2])};
    }

    public static float g(int r10) {
        float r11 = e(Color.red(r10));
        float r12 = e(Color.green(r10));
        float r13 = e(Color.blue(r10));
        float[] r14 = f22323d[1];
        return ((r11 * r14[0]) + (r12 * r14[1])) + (r13 * r14[2]);
    }

    public static float h(float r10) {
        if (r10 <= 8.0f) goto L7;
        float r11 = (float) Math.pow((((double) r10) + 16.0d) / 116.0d, 3.0d);
    L6:
        return r11 * 100.0f;
    L7:
        r11 = r10 / 903.2963f;
        goto L6
    }
}
