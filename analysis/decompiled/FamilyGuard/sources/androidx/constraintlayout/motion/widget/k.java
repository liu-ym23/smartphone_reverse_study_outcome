package androidx.constraintlayout.motion.widget;

import android.view.View;
import java.util.Arrays;
import java.util.LinkedHashMap;
import t.C1102b;

/* loaded from: classes.dex */
class k implements Comparable<k> {

    /* renamed from: s, reason: collision with root package name */
    static String[] f8753s = {"position", "x", "y", "width", "height", "pathRotate"};

    /* renamed from: a, reason: collision with root package name */
    C1102b f8754a;

    /* renamed from: c, reason: collision with root package name */
    float f8756c;

    /* renamed from: d, reason: collision with root package name */
    float f8757d;

    /* renamed from: e, reason: collision with root package name */
    float f8758e;

    /* renamed from: f, reason: collision with root package name */
    float f8759f;

    /* renamed from: g, reason: collision with root package name */
    float f8760g;

    /* renamed from: h, reason: collision with root package name */
    float f8761h;

    /* renamed from: k, reason: collision with root package name */
    int f8764k;

    /* renamed from: l, reason: collision with root package name */
    int f8765l;

    /* renamed from: m, reason: collision with root package name */
    float f8766m;

    /* renamed from: n, reason: collision with root package name */
    g f8767n;

    /* renamed from: o, reason: collision with root package name */
    LinkedHashMap<String, androidx.constraintlayout.widget.a> f8768o;

    /* renamed from: p, reason: collision with root package name */
    int f8769p;

    /* renamed from: q, reason: collision with root package name */
    double[] f8770q;

    /* renamed from: r, reason: collision with root package name */
    double[] f8771r;

    /* renamed from: b, reason: collision with root package name */
    int f8755b = 0;

    /* renamed from: i, reason: collision with root package name */
    float f8762i = Float.NaN;

    /* renamed from: j, reason: collision with root package name */
    float f8763j = Float.NaN;

    public k() {
        int i5 = d.f8659a;
        this.f8764k = i5;
        this.f8765l = i5;
        this.f8766m = Float.NaN;
        this.f8767n = null;
        this.f8768o = new LinkedHashMap<>();
        this.f8769p = 0;
        this.f8770q = new double[18];
        this.f8771r = new double[18];
    }

    @Override // java.lang.Comparable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public int compareTo(k kVar) {
        return Float.compare(this.f8757d, kVar.f8757d);
    }

    void d(double d6, int[] iArr, double[] dArr, float[] fArr, double[] dArr2, float[] fArr2) {
        float f5;
        float fSin = this.f8758e;
        float fCos = this.f8759f;
        float f6 = this.f8760g;
        float f7 = this.f8761h;
        float f8 = 0.0f;
        float f9 = 0.0f;
        float f10 = 0.0f;
        float f11 = 0.0f;
        for (int i5 = 0; i5 < iArr.length; i5++) {
            float f12 = (float) dArr[i5];
            float f13 = (float) dArr2[i5];
            int i6 = iArr[i5];
            if (i6 == 1) {
                fSin = f12;
                f8 = f13;
            } else if (i6 == 2) {
                fCos = f12;
                f10 = f13;
            } else if (i6 == 3) {
                f6 = f12;
                f9 = f13;
            } else if (i6 == 4) {
                f7 = f12;
                f11 = f13;
            }
        }
        float f14 = (f9 / 2.0f) + f8;
        float fCos2 = (f11 / 2.0f) + f10;
        g gVar = this.f8767n;
        if (gVar != null) {
            float[] fArr3 = new float[2];
            float[] fArr4 = new float[2];
            gVar.b(d6, fArr3, fArr4);
            float f15 = fArr3[0];
            float f16 = fArr3[1];
            float f17 = fArr4[0];
            float f18 = fArr4[1];
            double d7 = f15;
            f5 = 2.0f;
            double d8 = fSin;
            double d9 = fCos;
            fSin = (float) ((d7 + (Math.sin(d9) * d8)) - (f6 / 2.0f));
            fCos = (float) ((f16 - (Math.cos(d9) * d8)) - (f7 / 2.0f));
            double d10 = f17;
            double d11 = f8;
            double d12 = f10;
            float fSin2 = (float) (d10 + (Math.sin(d9) * d11) + (Math.cos(d9) * d12));
            fCos2 = (float) ((f18 - (d11 * Math.cos(d9))) + (Math.sin(d9) * d12));
            f14 = fSin2;
        } else {
            f5 = 2.0f;
        }
        fArr[0] = fSin + (f6 / f5) + 0.0f;
        fArr[1] = fCos + (f7 / f5) + 0.0f;
        fArr2[0] = f14;
        fArr2[1] = fCos2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    void e(float f5, View view, int[] iArr, double[] dArr, double[] dArr2, double[] dArr3, boolean z5) {
        float f6;
        float f7 = this.f8758e;
        float f8 = this.f8759f;
        float f9 = this.f8760g;
        float f10 = this.f8761h;
        if (iArr.length != 0 && this.f8770q.length <= iArr[iArr.length - 1]) {
            int i5 = iArr[iArr.length - 1] + 1;
            this.f8770q = new double[i5];
            this.f8771r = new double[i5];
        }
        Arrays.fill(this.f8770q, Double.NaN);
        for (int i6 = 0; i6 < iArr.length; i6++) {
            double[] dArr4 = this.f8770q;
            int i7 = iArr[i6];
            dArr4[i7] = dArr[i6];
            this.f8771r[i7] = dArr2[i6];
        }
        float f11 = Float.NaN;
        int i8 = 0;
        float f12 = 0.0f;
        float f13 = 0.0f;
        float f14 = 0.0f;
        float f15 = 0.0f;
        while (true) {
            double[] dArr5 = this.f8770q;
            if (i8 >= dArr5.length) {
                break;
            }
            if (Double.isNaN(dArr5[i8]) && (dArr3 == null || dArr3[i8] == 0.0d)) {
                f6 = f11;
            } else {
                double d6 = dArr3 != null ? dArr3[i8] : 0.0d;
                if (!Double.isNaN(this.f8770q[i8])) {
                    d6 = this.f8770q[i8] + d6;
                }
                f6 = f11;
                float f16 = (float) d6;
                float f17 = (float) this.f8771r[i8];
                if (i8 == 1) {
                    f11 = f6;
                    f7 = f16;
                    f12 = f17;
                } else if (i8 == 2) {
                    f11 = f6;
                    f8 = f16;
                    f13 = f17;
                } else if (i8 == 3) {
                    f11 = f6;
                    f9 = f16;
                    f14 = f17;
                } else if (i8 == 4) {
                    f11 = f6;
                    f10 = f16;
                    f15 = f17;
                } else if (i8 == 5) {
                    f11 = f16;
                }
                i8++;
            }
            f11 = f6;
            i8++;
        }
        float f18 = f11;
        g gVar = this.f8767n;
        if (gVar != null) {
            float[] fArr = new float[2];
            float[] fArr2 = new float[2];
            gVar.b(f5, fArr, fArr2);
            float f19 = fArr[0];
            float f20 = fArr[1];
            float f21 = fArr2[0];
            float f22 = fArr2[1];
            double d7 = f7;
            double d8 = f8;
            float fSin = (float) ((f19 + (Math.sin(d8) * d7)) - (f9 / 2.0f));
            float fCos = (float) ((f20 - (Math.cos(d8) * d7)) - (f10 / 2.0f));
            double d9 = f21;
            double d10 = f12;
            double dSin = d9 + (Math.sin(d8) * d10);
            double dCos = Math.cos(d8) * d7;
            double d11 = f13;
            float f23 = (float) (dSin + (dCos * d11));
            float fCos2 = (float) ((f22 - (d10 * Math.cos(d8))) + (Math.sin(d8) * d7 * d11));
            if (dArr2.length >= 2) {
                dArr2[0] = f23;
                dArr2[1] = fCos2;
            }
            if (!Float.isNaN(f18)) {
                view.setRotation((float) (f18 + Math.toDegrees(Math.atan2(fCos2, f23))));
            }
            f7 = fSin;
            f8 = fCos;
        } else if (!Float.isNaN(f18)) {
            view.setRotation((float) (0.0f + f18 + Math.toDegrees(Math.atan2(f13 + (f15 / 2.0f), f12 + (f14 / 2.0f)))));
        }
        if (view instanceof c) {
            ((c) view).a(f7, f8, f9 + f7, f10 + f8);
            return;
        }
        float f24 = f7 + 0.5f;
        int i9 = (int) f24;
        float f25 = f8 + 0.5f;
        int i10 = (int) f25;
        int i11 = (int) (f24 + f9);
        int i12 = (int) (f25 + f10);
        int i13 = i11 - i9;
        int i14 = i12 - i10;
        if (i13 != view.getMeasuredWidth() || i14 != view.getMeasuredHeight() || z5) {
            view.measure(View.MeasureSpec.makeMeasureSpec(i13, 1073741824), View.MeasureSpec.makeMeasureSpec(i14, 1073741824));
        }
        view.layout(i9, i10, i11, i12);
    }
}
