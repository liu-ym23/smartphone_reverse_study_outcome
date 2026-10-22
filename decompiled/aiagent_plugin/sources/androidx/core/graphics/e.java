package androidx.core.graphics;

import android.graphics.Color;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ColorUtils.java */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ThreadLocal<double[]> f1208a = null;

    static {
        f1208a = new ThreadLocal();
    }

    public static int a(int r6, int r7) {
        int r0 = Color.alpha(r7);
        int r1 = Color.alpha(r6);
        int r2 = c(r1, r0);
        return Color.argb(r2, a(Color.red(r6), r1, Color.red(r7), r0, r2), a(Color.green(r6), r1, Color.green(r7), r0, r2), a(Color.blue(r6), r1, Color.blue(r7), r0, r2));
    }

    private static int c(int r0, int r1) {
        return 255 - (((255 - r1) * (255 - r0)) / 255);
    }

    private static int a(int r0, int r1, int r2, int r3, int r4) {
        if (r4 != 0) goto L6;
        return 0;
    L6:
        return (((r0 * 255) * r1) + ((r2 * r3) * (255 - r1))) / (r4 * 255);
    }

    public static double a(int r4) {
        double[] r0 = a();
        a(r4, r0);
        return r0[1] / 100.0d;
    }

    public static int b(int r1, int r2) {
        if (r2 < 0) goto L8;
        if (r2 > 255) goto L8;
        return (r1 & 16777215) | (r2 << 24);
    L8:
        throw new IllegalArgumentException("alpha must be between 0 and 255.");
    }

    public static void a(int r2, double[] r3) {
        a(Color.red(r2), Color.green(r2), Color.blue(r2), r3);
    }

    public static void a(int r16, int r17, int r18, double[] r19) {
        if (r19.length != 3) goto L19;
        double r1 = ((double) r16) / 255.0d;
        if (r1 >= 0.04045d) goto L7;
        double r2 = r1 / 12.92d;
    L8:
        double r10 = ((double) r17) / 255.0d;
        if (r10 >= 0.04045d) goto L11;
        double r11 = r10 / 12.92d;
    L12:
        double r12 = ((double) r18) / 255.0d;
        if (r12 >= 0.04045d) goto L15;
        double r13 = r12 / 12.92d;
    L16:
        r19[0] = (((0.4124d * r2) + (0.3576d * r11)) + (0.1805d * r13)) * 100.0d;
        r19[1] = (((0.2126d * r2) + (0.7152d * r11)) + (0.0722d * r13)) * 100.0d;
        r19[2] = (((r2 * 0.0193d) + (r11 * 0.1192d)) + (r13 * 0.9505d)) * 100.0d;
        return;
    L15:
        r13 = Math.pow((r12 + 0.055d) / 1.055d, 2.4d);
        goto L16
    L11:
        r11 = Math.pow((r10 + 0.055d) / 1.055d, 2.4d);
        goto L12
    L7:
        r2 = Math.pow((r1 + 0.055d) / 1.055d, 2.4d);
        goto L8
    L19:
        throw new IllegalArgumentException("outXyz must have a length of 3.");
    }

    public static int a(double r17, double r19, double r21) {
        double r0 = (((3.2406d * r17) + ((-1.5372d) * r19)) + ((-0.4986d) * r21)) / 100.0d;
        double r4 = ((((-0.9689d) * r17) + (1.8758d * r19)) + (0.0415d * r21)) / 100.0d;
        double r6 = (((0.0557d * r17) + ((-0.204d) * r19)) + (1.057d * r21)) / 100.0d;
        if (r0 <= 0.0031308d) goto L5;
        double r1 = (Math.pow(r0, 0.4166666666666667d) * 1.055d) - 0.055d;
    L7:
        if (r4 <= 0.0031308d) goto L9;
        double r5 = (Math.pow(r4, 0.4166666666666667d) * 1.055d) - 0.055d;
    L11:
        if (r6 <= 0.0031308d) goto L13;
        double r2 = (Math.pow(r6, 0.4166666666666667d) * 1.055d) - 0.055d;
    L15:
        return Color.rgb(a((int) Math.round(r1 * 255.0d), 0, 255), a((int) Math.round(r5 * 255.0d), 0, 255), a((int) Math.round(r2 * 255.0d), 0, 255));
    L13:
        r2 = r6 * 12.92d;
        goto L15
    L9:
        r5 = r4 * 12.92d;
        goto L11
    L5:
        r1 = r0 * 12.92d;
        goto L7
    }

    private static int a(int r0, int r1, int r2) {
        if (r0 >= r1) goto L5;
        return r1;
    L5:
        return Math.min(r0, r2);
    }

    public static int a(int r5, int r6, float r7) {
        float r0 = 1.0f - r7;
        return Color.argb((int) ((Color.alpha(r5) * r0) + (Color.alpha(r6) * r7)), (int) ((Color.red(r5) * r0) + (Color.red(r6) * r7)), (int) ((Color.green(r5) * r0) + (Color.green(r6) * r7)), (int) ((Color.blue(r5) * r0) + (Color.blue(r6) * r7)));
    }

    private static double[] a() {
        ThreadLocal<double[]> r0 = f1208a;
        double[] r1 = (double[]) ZeusTransformUtils.preCheckCast(r0.get(), double[].class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L6;
        double[] r2 = new double[3];
        r0.set(r2);
        return r2;
    L6:
        return r1;
    }
}
