package d1;

import a4.u;
import ib.k;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final c f2771a;

    /* renamed from: b, reason: collision with root package name */
    public final int f2772b;

    /* renamed from: c, reason: collision with root package name */
    public final a[] f2773c;

    /* renamed from: d, reason: collision with root package name */
    public int f2774d;

    /* renamed from: e, reason: collision with root package name */
    public final float[] f2775e;

    /* renamed from: f, reason: collision with root package name */
    public final float[] f2776f;

    /* renamed from: g, reason: collision with root package name */
    public final float[] f2777g;

    public d() {
        int i2;
        c cVar = c.f2769f;
        this.f2771a = cVar;
        int iOrdinal = cVar.ordinal();
        if (iOrdinal == 0) {
            i2 = 3;
        } else {
            if (iOrdinal != 1) {
                throw new u();
            }
            i2 = 2;
        }
        this.f2772b = i2;
        this.f2773c = new a[20];
        this.f2775e = new float[20];
        this.f2776f = new float[20];
        this.f2777g = new float[3];
    }

    public final void a(float f10, long j2) {
        int i2 = (this.f2774d + 1) % 20;
        this.f2774d = i2;
        a[] aVarArr = this.f2773c;
        a aVar = aVarArr[i2];
        if (aVar != null) {
            aVar.f2764a = j2;
            aVar.f2765b = f10;
        } else {
            a aVar2 = new a();
            aVar2.f2764a = j2;
            aVar2.f2765b = f10;
            aVarArr[i2] = aVar2;
        }
    }

    public final float b(float f10) {
        float[] fArr;
        float[] fArr2;
        float f11;
        c cVar;
        int i2;
        float f12;
        float fSignum;
        float f13 = 0.0f;
        if (f10 <= 0.0f) {
            f1.a.b("maximumVelocity should be a positive value. You specified=" + f10);
        }
        int i10 = this.f2774d;
        a[] aVarArr = this.f2773c;
        a aVar = aVarArr[i10];
        if (aVar == null) {
            f12 = 0.0f;
            f11 = 0.0f;
        } else {
            int i11 = 0;
            a aVar2 = aVar;
            while (true) {
                a aVar3 = aVarArr[i10];
                c cVar2 = this.f2771a;
                fArr = this.f2775e;
                fArr2 = this.f2776f;
                if (aVar3 == null) {
                    f11 = f13;
                    cVar = cVar2;
                    i2 = 1;
                    break;
                }
                long j2 = aVar.f2764a;
                f11 = f13;
                int i12 = i10;
                long j4 = aVar3.f2764a;
                float f14 = j2 - j4;
                i2 = 1;
                float fAbs = Math.abs(j4 - aVar2.f2764a);
                cVar = cVar2;
                a aVar4 = cVar != c.f2769f ? aVar : aVar3;
                if (f14 > 100.0f || fAbs > 40.0f) {
                    break;
                }
                fArr[i11] = aVar3.f2765b;
                fArr2[i11] = -f14;
                if (i12 == 0) {
                    i12 = 20;
                }
                int i13 = i12 - 1;
                i11++;
                if (i11 >= 20) {
                    break;
                }
                aVar2 = aVar4;
                i10 = i13;
                f13 = f11;
            }
            if (i11 >= this.f2772b) {
                int iOrdinal = cVar.ordinal();
                if (iOrdinal == 0) {
                    try {
                        float[] fArr3 = this.f2777g;
                        k.F(fArr2, fArr, i11, fArr3);
                        fSignum = fArr3[1];
                    } catch (IllegalArgumentException unused) {
                        fSignum = f11;
                    }
                } else {
                    if (iOrdinal != i2) {
                        throw new u();
                    }
                    int i14 = i11 - i2;
                    float f15 = fArr2[i14];
                    int i15 = i14;
                    float fAbs2 = f11;
                    while (i15 > 0) {
                        int i16 = i15 - 1;
                        float f16 = fArr2[i16];
                        if (f15 != f16) {
                            float f17 = (fArr[i15] - fArr[i16]) / (f15 - f16);
                            fAbs2 += Math.abs(f17) * (f17 - (Math.signum(fAbs2) * ((float) Math.sqrt(Math.abs(fAbs2) * 2))));
                            if (i15 == i14) {
                                fAbs2 *= 0.5f;
                            }
                        }
                        i15--;
                        f15 = f16;
                    }
                    fSignum = Math.signum(fAbs2) * ((float) Math.sqrt(Math.abs(fAbs2) * 2));
                }
                f12 = fSignum * 1000;
            } else {
                f12 = f11;
            }
        }
        if (f12 == f11 || Float.isNaN(f12)) {
            return f11;
        }
        if (f12 <= f11) {
            float f18 = -f10;
            if (f12 < f18) {
                return f18;
            }
        } else if (f12 > f10) {
            f12 = f10;
        }
        return f12;
    }
}
