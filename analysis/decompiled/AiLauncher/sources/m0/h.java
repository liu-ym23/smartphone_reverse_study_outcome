package m0;

import java.util.Arrays;

/* loaded from: classes.dex */
public class h {

    /* renamed from: c, reason: collision with root package name */
    public double[] f37102c;

    /* renamed from: d, reason: collision with root package name */
    public String f37103d;

    /* renamed from: e, reason: collision with root package name */
    public g f37104e;

    /* renamed from: f, reason: collision with root package name */
    public int f37105f;

    /* renamed from: a, reason: collision with root package name */
    public float[] f37100a = new float[0];

    /* renamed from: b, reason: collision with root package name */
    public double[] f37101b = new double[0];

    /* renamed from: g, reason: collision with root package name */
    public double f37106g = 6.283185307179586d;

    /* renamed from: h, reason: collision with root package name */
    public boolean f37107h = false;

    public void a(double d10, float f10) {
        int length = this.f37100a.length + 1;
        int iBinarySearch = Arrays.binarySearch(this.f37101b, d10);
        if (iBinarySearch < 0) {
            iBinarySearch = (-iBinarySearch) - 1;
        }
        this.f37101b = Arrays.copyOf(this.f37101b, length);
        this.f37100a = Arrays.copyOf(this.f37100a, length);
        this.f37102c = new double[length];
        double[] dArr = this.f37101b;
        System.arraycopy(dArr, iBinarySearch, dArr, iBinarySearch + 1, (length - iBinarySearch) - 1);
        this.f37101b[iBinarySearch] = d10;
        this.f37100a[iBinarySearch] = f10;
        this.f37107h = false;
    }

    public double b(double d10) {
        if (d10 <= 0.0d) {
            return 0.0d;
        }
        if (d10 >= 1.0d) {
            return 1.0d;
        }
        int iBinarySearch = Arrays.binarySearch(this.f37101b, d10);
        if (iBinarySearch < 0) {
            iBinarySearch = (-iBinarySearch) - 1;
        }
        float[] fArr = this.f37100a;
        float f10 = fArr[iBinarySearch];
        int i10 = iBinarySearch - 1;
        float f11 = fArr[i10];
        double d11 = f10 - f11;
        double[] dArr = this.f37101b;
        double d12 = dArr[iBinarySearch];
        double d13 = dArr[i10];
        double d14 = d11 / (d12 - d13);
        return this.f37102c[i10] + ((f11 - (d14 * d13)) * (d10 - d13)) + ((d14 * ((d10 * d10) - (d13 * d13))) / 2.0d);
    }

    public double c(double d10, double d11) {
        double dB = b(d10) + d11;
        switch (this.f37105f) {
            case 1:
                return Math.signum(0.5d - (dB % 1.0d));
            case 2:
                return 1.0d - Math.abs((((dB * 4.0d) + 1.0d) % 4.0d) - 2.0d);
            case 3:
                return (((dB * 2.0d) + 1.0d) % 2.0d) - 1.0d;
            case 4:
                return 1.0d - (((dB * 2.0d) + 1.0d) % 2.0d);
            case 5:
                return Math.cos(this.f37106g * (d11 + dB));
            case 6:
                double dAbs = 1.0d - Math.abs(((dB * 4.0d) % 4.0d) - 2.0d);
                return 1.0d - (dAbs * dAbs);
            case 7:
                return this.f37104e.c(dB % 1.0d, 0);
            default:
                return Math.sin(this.f37106g * dB);
        }
    }

    public void d() {
        double d10 = 0.0d;
        int i10 = 0;
        while (true) {
            if (i10 >= this.f37100a.length) {
                break;
            }
            d10 += r6[i10];
            i10++;
        }
        double d11 = 0.0d;
        int i11 = 1;
        while (true) {
            float[] fArr = this.f37100a;
            if (i11 >= fArr.length) {
                break;
            }
            int i12 = i11 - 1;
            float f10 = (fArr[i12] + fArr[i11]) / 2.0f;
            double[] dArr = this.f37101b;
            d11 += (dArr[i11] - dArr[i12]) * f10;
            i11++;
        }
        int i13 = 0;
        while (true) {
            float[] fArr2 = this.f37100a;
            if (i13 >= fArr2.length) {
                break;
            }
            fArr2[i13] = fArr2[i13] * ((float) (d10 / d11));
            i13++;
        }
        this.f37102c[0] = 0.0d;
        int i14 = 1;
        while (true) {
            float[] fArr3 = this.f37100a;
            if (i14 >= fArr3.length) {
                this.f37107h = true;
                return;
            }
            int i15 = i14 - 1;
            float f11 = (fArr3[i15] + fArr3[i14]) / 2.0f;
            double[] dArr2 = this.f37101b;
            double d12 = dArr2[i14] - dArr2[i15];
            double[] dArr3 = this.f37102c;
            dArr3[i14] = dArr3[i15] + (d12 * f11);
            i14++;
        }
    }

    public void e(int i10, String str) {
        this.f37105f = i10;
        this.f37103d = str;
        if (str != null) {
            this.f37104e = g.h(str);
        }
    }

    public String toString() {
        return "pos =" + Arrays.toString(this.f37101b) + " period=" + Arrays.toString(this.f37100a);
    }
}
