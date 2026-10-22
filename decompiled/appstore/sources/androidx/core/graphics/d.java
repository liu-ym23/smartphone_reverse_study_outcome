package androidx.core.graphics;

import android.graphics.Color;
import com.ttnet.org.chromium.net.PrivateKeyType;

/* JADX INFO: loaded from: classes.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ThreadLocal f2543a = null;

    static {
        f2543a = new ThreadLocal();
    }

    public static void a(int r16, int r17, int r18, double[] r19) {
        if (r19.length != 3) goto L21;
        double r10 = ((double) r16) / 255.0d;
        if (r10 >= 0.04045d) goto L8;
        double r11 = r10 / 12.92d;
    L9:
        double r12 = ((double) r17) / 255.0d;
        if (r12 >= 0.04045d) goto L13;
        double r13 = r12 / 12.92d;
    L14:
        double r14 = ((double) r18) / 255.0d;
        if (r14 >= 0.04045d) goto L17;
        double r15 = r14 / 12.92d;
    L18:
        r19[0] = (((0.4124d * r11) + (0.3576d * r13)) + (0.1805d * r15)) * 100.0d;
        r19[1] = (((0.2126d * r11) + (0.7152d * r13)) + (0.0722d * r15)) * 100.0d;
        r19[2] = (((r11 * 0.0193d) + (r13 * 0.1192d)) + (r15 * 0.9505d)) * 100.0d;
        return;
    L17:
        r15 = Math.pow((r14 + 0.055d) / 1.055d, 2.4d);
        goto L18
    L13:
        r13 = Math.pow((r12 + 0.055d) / 1.055d, 2.4d);
        goto L14
    L8:
        r11 = Math.pow((r10 + 0.055d) / 1.055d, 2.4d);
        goto L9
    L21:
        throw new IllegalArgumentException("outXyz must have a length of 3.");
    }

    public static int b(double r17, double r19, double r21) {
        double r10 = (((3.2406d * r17) + ((-1.5372d) * r19)) + ((-0.4986d) * r21)) / 100.0d;
        double r11 = ((((-0.9689d) * r17) + (1.8758d * r19)) + (0.0415d * r21)) / 100.0d;
        double r12 = (((0.0557d * r17) + ((-0.204d) * r19)) + (1.057d * r21)) / 100.0d;
        if (r10 <= 0.0031308d) goto L5;
        double r13 = (Math.pow(r10, 0.4166666666666667d) * 1.055d) - 0.055d;
    L7:
        if (r11 <= 0.0031308d) goto L9;
        double r14 = (Math.pow(r11, 0.4166666666666667d) * 1.055d) - 0.055d;
    L11:
        if (r12 <= 0.0031308d) goto L13;
        double r15 = (Math.pow(r12, 0.4166666666666667d) * 1.055d) - 0.055d;
    L15:
        return Color.rgb(i((int) Math.round(r13 * 255.0d), 0, PrivateKeyType.INVALID), i((int) Math.round(r14 * 255.0d), 0, PrivateKeyType.INVALID), i((int) Math.round(r15 * 255.0d), 0, PrivateKeyType.INVALID));
    L13:
        r15 = r12 * 12.92d;
        goto L15
    L9:
        r14 = r11 * 12.92d;
        goto L11
    L5:
        r13 = r10 * 12.92d;
        goto L7
    }

    public static int c(int r10, int r11, float r12) {
        float r13 = 1.0f - r12;
        return Color.argb((int) ((Color.alpha(r10) * r13) + (Color.alpha(r11) * r12)), (int) ((Color.red(r10) * r13) + (Color.red(r11) * r12)), (int) ((Color.green(r10) * r13) + (Color.green(r11) * r12)), (int) ((Color.blue(r10) * r13) + (Color.blue(r11) * r12)));
    }

    public static double d(int r10) {
        double[] r11 = j();
        e(r10, r11);
        return r11[1] / 100.0d;
    }

    public static void e(int r10, double[] r11) {
        a(Color.red(r10), Color.green(r10), Color.blue(r10), r11);
    }

    public static int f(int r10, int r11) {
        return 255 - (((255 - r11) * (255 - r10)) / PrivateKeyType.INVALID);
    }

    public static int g(int r10, int r11) {
        int r12 = Color.alpha(r11);
        int r13 = Color.alpha(r10);
        int r14 = f(r13, r12);
        return Color.argb(r14, h(Color.red(r10), r13, Color.red(r11), r12, r14), h(Color.green(r10), r13, Color.green(r11), r12, r14), h(Color.blue(r10), r13, Color.blue(r11), r12, r14));
    }

    public static int h(int r10, int r11, int r12, int r13, int r14) {
        if (r14 != 0) goto L6;
        return 0;
    L6:
        return (((r10 * PrivateKeyType.INVALID) * r11) + ((r12 * r13) * (255 - r11))) / (r14 * PrivateKeyType.INVALID);
    }

    public static int i(int r10, int r11, int r12) {
        if (r10 >= r11) goto L5;
        return r11;
    L5:
        return Math.min(r10, r12);
    }

    public static double[] j() {
        ThreadLocal r10 = f2543a;
        double[] r11 = (double[]) r10.get();
        if (r11 != null) goto L6;
        double[] r12 = new double[3];
        r10.set(r12);
        return r12;
    L6:
        return r11;
    }

    public static int k(int r10, int r11) {
        if (r11 < 0) goto L8;
        if (r11 > 255) goto L8;
        return (r10 & 16777215) | (r11 << 24);
    L8:
        throw new IllegalArgumentException("alpha must be between 0 and 255.");
    }
}
