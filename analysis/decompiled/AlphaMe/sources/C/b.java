package C;

import K.f0;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;
import android.view.View;

/* loaded from: classes.dex */
public abstract class b implements f0 {

    /* renamed from: a, reason: collision with root package name */
    public static final float[][] f245a = {new float[]{0.401288f, 0.650173f, -0.051461f}, new float[]{-0.250268f, 1.204414f, 0.045854f}, new float[]{-0.002079f, 0.048952f, 0.953127f}};

    /* renamed from: b, reason: collision with root package name */
    public static final float[][] f246b = {new float[]{1.8620678f, -1.0112547f, 0.14918678f}, new float[]{0.38752654f, 0.62144744f, -0.00897398f}, new float[]{-0.0158415f, -0.03412294f, 1.0499644f}};

    /* renamed from: c, reason: collision with root package name */
    public static final float[] f247c = {95.047f, 100.0f, 108.883f};

    /* renamed from: d, reason: collision with root package name */
    public static final float[][] f248d = {new float[]{0.41233894f, 0.35762063f, 0.18051042f}, new float[]{0.2126f, 0.7152f, 0.0722f}, new float[]{0.01932141f, 0.11916382f, 0.9503448f}};

    public static int e(float f4) {
        if (f4 < 1.0f) {
            return -16777216;
        }
        if (f4 > 99.0f) {
            return -1;
        }
        float f5 = (f4 + 16.0f) / 116.0f;
        float f6 = f4 > 8.0f ? f5 * f5 * f5 : f4 / 903.2963f;
        float f7 = f5 * f5 * f5;
        boolean z4 = f7 > 0.008856452f;
        float f8 = z4 ? f7 : ((f5 * 116.0f) - 16.0f) / 903.2963f;
        if (!z4) {
            f7 = ((f5 * 116.0f) - 16.0f) / 903.2963f;
        }
        float[] fArr = f247c;
        return D.a.a(f8 * fArr[0], f6 * fArr[1], f7 * fArr[2]);
    }

    public static float f(int i4) {
        float f4 = i4 / 255.0f;
        return (f4 <= 0.04045f ? f4 / 12.92f : (float) Math.pow((f4 + 0.055f) / 1.055f, 2.4000000953674316d)) * 100.0f;
    }

    public static float i() {
        return ((float) Math.pow((50.0f + 16.0d) / 116.0d, 3.0d)) * 100.0f;
    }

    public void a(int i4) {
        new Handler(Looper.getMainLooper()).post(new n(i4, 0, this));
    }

    public void b(Typeface typeface) {
        new Handler(Looper.getMainLooper()).post(new androidx.appcompat.app.o(1, this, typeface));
    }

    @Override // K.f0
    public void c(View view) {
    }

    @Override // K.f0
    public void d(View view) {
    }

    public abstract void g(int i4);

    public abstract void h(Typeface typeface);

    @Override // K.f0
    public void onAnimationCancel() {
    }
}
