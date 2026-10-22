package n;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class p {

    /* renamed from: s, reason: collision with root package name */
    public static float[] f6683s;

    /* renamed from: a, reason: collision with root package name */
    public final float f6684a;

    /* renamed from: b, reason: collision with root package name */
    public final float f6685b;

    /* renamed from: c, reason: collision with root package name */
    public final float f6686c;

    /* renamed from: d, reason: collision with root package name */
    public final float f6687d;

    /* renamed from: e, reason: collision with root package name */
    public final float f6688e;

    /* renamed from: f, reason: collision with root package name */
    public final float f6689f;

    /* renamed from: g, reason: collision with root package name */
    public final float f6690g;

    /* renamed from: h, reason: collision with root package name */
    public float f6691h;

    /* renamed from: i, reason: collision with root package name */
    public float f6692i;

    /* renamed from: j, reason: collision with root package name */
    public final float[] f6693j;

    /* renamed from: k, reason: collision with root package name */
    public final float f6694k;

    /* renamed from: l, reason: collision with root package name */
    public final float f6695l;

    /* renamed from: m, reason: collision with root package name */
    public final float f6696m;

    /* renamed from: n, reason: collision with root package name */
    public final float f6697n;

    /* renamed from: o, reason: collision with root package name */
    public final float f6698o;

    /* renamed from: p, reason: collision with root package name */
    public final float f6699p;

    /* renamed from: q, reason: collision with root package name */
    public final boolean f6700q;

    /* renamed from: r, reason: collision with root package name */
    public final boolean f6701r;

    public p(int i2, float f10, float f11, float f12, float f13, float f14, float f15) {
        boolean z4;
        float f16;
        float f17;
        float f18 = f12;
        this.f6684a = f10;
        this.f6685b = f11;
        this.f6686c = f18;
        this.f6687d = f13;
        this.f6688e = f14;
        this.f6689f = f15;
        float f19 = f14 - f18;
        float f20 = f15 - f13;
        float f21 = 0.0f;
        boolean z10 = true;
        boolean z11 = i2 == 1 || (i2 == 4 ? f20 > 0.0f : !(i2 != 5 || f20 >= 0.0f));
        this.f6700q = z11;
        float f22 = f11 - f10;
        float f23 = 1 / f22;
        this.f6694k = f23;
        boolean z12 = 3 == i2;
        if (z12 || Math.abs(f19) < 0.001f || Math.abs(f20) < 0.001f) {
            float fHypot = (float) Math.hypot(f20, f19);
            this.f6690g = fHypot;
            this.f6699p = fHypot * f23;
            this.f6697n = f19 / f22;
            this.f6698o = f20 / f22;
            this.f6693j = new float[101];
            this.f6695l = Float.NaN;
            this.f6696m = Float.NaN;
            z4 = true;
        } else {
            float[] fArr = new float[101];
            this.f6693j = fArr;
            this.f6695l = (z11 ? -1 : 1) * f19;
            this.f6696m = f20 * (z11 ? 1 : -1);
            this.f6697n = z11 ? f14 : f18;
            this.f6698o = z11 ? f13 : f15;
            float f24 = f13 - f15;
            int length = h4.n.b().length;
            float fHypot2 = 0.0f;
            float f25 = 0.0f;
            float f26 = 0.0f;
            int i10 = 0;
            while (i10 < length) {
                boolean z13 = z10;
                float f27 = f26;
                double radians = (float) Math.toRadians((i10 * 90.0d) / (h4.n.b().length - 1));
                float fSin = ((float) Math.sin(radians)) * f19;
                float fCos = ((float) Math.cos(radians)) * f24;
                if (i10 > 0) {
                    float f28 = f21;
                    double d6 = fSin - f25;
                    float f29 = fCos - f27;
                    f16 = f28;
                    f17 = fSin;
                    fHypot2 += (float) Math.hypot(d6, f29);
                    h4.n.b()[i10] = fHypot2;
                } else {
                    f16 = f21;
                    f17 = fSin;
                }
                i10++;
                f25 = f17;
                f21 = f16;
                f26 = fCos;
                z10 = z13;
            }
            float f30 = f21;
            this.f6690g = fHypot2;
            int length2 = h4.n.b().length;
            for (int i11 = 0; i11 < length2; i11++) {
                float[] fArrB = h4.n.b();
                fArrB[i11] = fArrB[i11] / fHypot2;
            }
            for (int i12 = 0; i12 < 101; i12++) {
                float f31 = i12 / 100;
                float[] fArrB2 = h4.n.b();
                int iBinarySearch = Arrays.binarySearch(fArrB2, 0, fArrB2.length, f31);
                if (iBinarySearch >= 0) {
                    fArr[i12] = iBinarySearch / (h4.n.b().length - 1);
                } else if (iBinarySearch == -1) {
                    fArr[i12] = f30;
                } else {
                    int i13 = -iBinarySearch;
                    int i14 = i13 - 2;
                    fArr[i12] = (((f31 - h4.n.b()[i14]) / (h4.n.b()[i13 - 1] - h4.n.b()[i14])) + i14) / (h4.n.b().length - 1);
                }
            }
            this.f6699p = this.f6690g * this.f6694k;
            z4 = z12;
        }
        this.f6701r = z4;
    }

    public final float a() {
        float f10 = this.f6695l * this.f6692i;
        float fHypot = this.f6699p / ((float) Math.hypot(f10, (-this.f6696m) * this.f6691h));
        return this.f6700q ? (-f10) * fHypot : f10 * fHypot;
    }

    public final float b() {
        float f10 = this.f6695l * this.f6692i;
        float f11 = (-this.f6696m) * this.f6691h;
        float fHypot = this.f6699p / ((float) Math.hypot(f10, f11));
        return this.f6700q ? (-f11) * fHypot : f11 * fHypot;
    }

    public final void c(float f10) {
        float f11 = (this.f6700q ? this.f6685b - f10 : f10 - this.f6684a) * this.f6694k;
        float f12 = 0.0f;
        if (f11 > 0.0f) {
            f12 = 1.0f;
            if (f11 < 1.0f) {
                float[] fArr = this.f6693j;
                float length = f11 * (fArr.length - 1);
                int i2 = (int) length;
                float f13 = fArr[i2];
                f12 = ((fArr[i2 + 1] - f13) * (length - i2)) + f13;
            }
        }
        double d6 = f12 * 1.5707964f;
        this.f6691h = (float) Math.sin(d6);
        this.f6692i = (float) Math.cos(d6);
    }
}
