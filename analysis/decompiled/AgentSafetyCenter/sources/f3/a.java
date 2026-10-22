package f3;

import android.graphics.Color;
import g5.f;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f3898a = 0;

    static {
        new ThreadLocal();
    }

    public static int a(double d7, double d10, double d11) {
        double d12 = (((-0.4986d) * d11) + (((-1.5372d) * d10) + (3.2406d * d7))) / 100.0d;
        double d13 = ((0.0415d * d11) + ((1.8758d * d10) + ((-0.9689d) * d7))) / 100.0d;
        double d14 = ((1.057d * d11) + (((-0.204d) * d10) + (0.0557d * d7))) / 100.0d;
        double dPow = d12 > 0.0031308d ? (Math.pow(d12, 0.4166666666666667d) * 1.055d) - 0.055d : d12 * 12.92d;
        double dPow2 = d13 > 0.0031308d ? (Math.pow(d13, 0.4166666666666667d) * 1.055d) - 0.055d : d13 * 12.92d;
        double dPow3 = d14 > 0.0031308d ? (Math.pow(d14, 0.4166666666666667d) * 1.055d) - 0.055d : d14 * 12.92d;
        int iRound = (int) Math.round(dPow * 255.0d);
        int iMin = iRound < 0 ? 0 : Math.min(iRound, 255);
        int iRound2 = (int) Math.round(dPow2 * 255.0d);
        int iMin2 = iRound2 < 0 ? 0 : Math.min(iRound2, 255);
        int iRound3 = (int) Math.round(dPow3 * 255.0d);
        return Color.rgb(iMin, iMin2, iRound3 >= 0 ? Math.min(iRound3, 255) : 0);
    }

    public static int b(int i, int i3) {
        int iAlpha = Color.alpha(i3);
        int iAlpha2 = Color.alpha(i);
        int i10 = 255 - (((255 - iAlpha2) * (255 - iAlpha)) / 255);
        return Color.argb(i10, c(Color.red(i), iAlpha2, Color.red(i3), iAlpha, i10), c(Color.green(i), iAlpha2, Color.green(i3), iAlpha, i10), c(Color.blue(i), iAlpha2, Color.blue(i3), iAlpha, i10));
    }

    public static int c(int i, int i3, int i10, int i11, int i12) {
        if (i12 == 0) {
            return 0;
        }
        return (((255 - i3) * (i10 * i11)) + ((i * 255) * i3)) / (i12 * 255);
    }

    public static int d(int i, int i3) {
        if (i3 >= 0 && i3 <= 255) {
            return (i & 16777215) | (i3 << 24);
        }
        f.s("alpha must be between 0 and 255.");
        return 0;
    }
}
