package androidx.core.content.res;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final float f9587a;

    /* renamed from: b, reason: collision with root package name */
    private final float f9588b;

    /* renamed from: c, reason: collision with root package name */
    private final float f9589c;

    /* renamed from: d, reason: collision with root package name */
    private final float f9590d;

    /* renamed from: e, reason: collision with root package name */
    private final float f9591e;

    /* renamed from: f, reason: collision with root package name */
    private final float f9592f;

    /* renamed from: g, reason: collision with root package name */
    private final float f9593g;

    /* renamed from: h, reason: collision with root package name */
    private final float f9594h;

    /* renamed from: i, reason: collision with root package name */
    private final float f9595i;

    a(float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13) {
        this.f9587a = f5;
        this.f9588b = f6;
        this.f9589c = f7;
        this.f9590d = f8;
        this.f9591e = f9;
        this.f9592f = f10;
        this.f9593g = f11;
        this.f9594h = f12;
        this.f9595i = f13;
    }

    private static a b(float f5, float f6, float f7) {
        float f8 = 100.0f;
        float f9 = 1000.0f;
        float f10 = 0.0f;
        a aVar = null;
        float f11 = 1000.0f;
        while (Math.abs(f10 - f8) > 0.01f) {
            float f12 = ((f8 - f10) / 2.0f) + f10;
            int iP = e(f12, f6, f5).p();
            float fB = b.b(iP);
            float fAbs = Math.abs(f7 - fB);
            if (fAbs < 0.2f) {
                a aVarC = c(iP);
                float fA = aVarC.a(e(aVarC.k(), aVarC.i(), f5));
                if (fA <= 1.0f) {
                    aVar = aVarC;
                    f9 = fAbs;
                    f11 = fA;
                }
            }
            if (f9 == 0.0f && f11 == 0.0f) {
                return aVar;
            }
            if (fB < f7) {
                f10 = f12;
            } else {
                f8 = f12;
            }
        }
        return aVar;
    }

    static a c(int i5) {
        float[] fArr = new float[7];
        float[] fArr2 = new float[3];
        d(i5, l.f9629k, fArr, fArr2);
        return new a(fArr2[0], fArr2[1], fArr[0], fArr[1], fArr[2], fArr[3], fArr[4], fArr[5], fArr[6]);
    }

    static void d(int i5, l lVar, float[] fArr, float[] fArr2) {
        b.f(i5, fArr2);
        float[][] fArr3 = b.f9596a;
        float f5 = fArr2[0];
        float[] fArr4 = fArr3[0];
        float f6 = fArr4[0] * f5;
        float f7 = fArr2[1];
        float f8 = f6 + (fArr4[1] * f7);
        float f9 = fArr2[2];
        float f10 = f8 + (fArr4[2] * f9);
        float[] fArr5 = fArr3[1];
        float f11 = (fArr5[0] * f5) + (fArr5[1] * f7) + (fArr5[2] * f9);
        float[] fArr6 = fArr3[2];
        float f12 = (f5 * fArr6[0]) + (f7 * fArr6[1]) + (f9 * fArr6[2]);
        float f13 = lVar.i()[0] * f10;
        float f14 = lVar.i()[1] * f11;
        float f15 = lVar.i()[2] * f12;
        float fPow = (float) Math.pow((lVar.c() * Math.abs(f13)) / 100.0d, 0.42d);
        float fPow2 = (float) Math.pow((lVar.c() * Math.abs(f14)) / 100.0d, 0.42d);
        float fPow3 = (float) Math.pow((lVar.c() * Math.abs(f15)) / 100.0d, 0.42d);
        float fSignum = ((Math.signum(f13) * 400.0f) * fPow) / (fPow + 27.13f);
        float fSignum2 = ((Math.signum(f14) * 400.0f) * fPow2) / (fPow2 + 27.13f);
        float fSignum3 = ((Math.signum(f15) * 400.0f) * fPow3) / (fPow3 + 27.13f);
        double d6 = fSignum3;
        float f16 = ((float) (((fSignum * 11.0d) + (fSignum2 * (-12.0d))) + d6)) / 11.0f;
        float f17 = ((float) ((fSignum + fSignum2) - (d6 * 2.0d))) / 9.0f;
        float f18 = fSignum2 * 20.0f;
        float f19 = (((fSignum * 20.0f) + f18) + (21.0f * fSignum3)) / 20.0f;
        float f20 = (((fSignum * 40.0f) + f18) + fSignum3) / 20.0f;
        float fAtan2 = (((float) Math.atan2(f17, f16)) * 180.0f) / 3.1415927f;
        if (fAtan2 < 0.0f) {
            fAtan2 += 360.0f;
        } else if (fAtan2 >= 360.0f) {
            fAtan2 -= 360.0f;
        }
        float f21 = (3.1415927f * fAtan2) / 180.0f;
        float fPow4 = ((float) Math.pow((f20 * lVar.f()) / lVar.a(), lVar.b() * lVar.j())) * 100.0f;
        float fB = (4.0f / lVar.b()) * ((float) Math.sqrt(fPow4 / 100.0f)) * (lVar.a() + 4.0f) * lVar.d();
        float fSqrt = ((float) Math.sqrt(fPow4 / 100.0d)) * ((float) Math.pow(1.64d - Math.pow(0.29d, lVar.e()), 0.73d)) * ((float) Math.pow((((((((float) (Math.cos((((((double) fAtan2) < 20.14d ? 360.0f + fAtan2 : fAtan2) * 3.141592653589793d) / 180.0d) + 2.0d) + 3.8d)) * 0.25f) * 3846.1538f) * lVar.g()) * lVar.h()) * ((float) Math.sqrt((f16 * f16) + (f17 * f17)))) / (f19 + 0.305f), 0.9d));
        float fD = lVar.d() * fSqrt;
        float fSqrt2 = ((float) Math.sqrt((r4 * lVar.b()) / (lVar.a() + 4.0f))) * 50.0f;
        float f22 = (1.7f * fPow4) / ((0.007f * fPow4) + 1.0f);
        float fLog = ((float) Math.log((0.0228f * fD) + 1.0f)) * 43.85965f;
        double d7 = f21;
        float fCos = ((float) Math.cos(d7)) * fLog;
        float fSin = fLog * ((float) Math.sin(d7));
        fArr2[0] = fAtan2;
        fArr2[1] = fSqrt;
        if (fArr != null) {
            fArr[0] = fPow4;
            fArr[1] = fB;
            fArr[2] = fD;
            fArr[3] = fSqrt2;
            fArr[4] = f22;
            fArr[5] = fCos;
            fArr[6] = fSin;
        }
    }

    private static a e(float f5, float f6, float f7) {
        return f(f5, f6, f7, l.f9629k);
    }

    private static a f(float f5, float f6, float f7, l lVar) {
        float fB = (4.0f / lVar.b()) * ((float) Math.sqrt(f5 / 100.0d)) * (lVar.a() + 4.0f) * lVar.d();
        float fD = lVar.d() * f6;
        float fSqrt = ((float) Math.sqrt(((f6 / ((float) Math.sqrt(r4))) * lVar.b()) / (lVar.a() + 4.0f))) * 50.0f;
        float f8 = (1.7f * f5) / ((0.007f * f5) + 1.0f);
        float fLog = ((float) Math.log((fD * 0.0228d) + 1.0d)) * 43.85965f;
        double d6 = (3.1415927f * f7) / 180.0f;
        return new a(f7, f6, f5, fB, fD, fSqrt, f8, ((float) Math.cos(d6)) * fLog, fLog * ((float) Math.sin(d6)));
    }

    public static int m(float f5, float f6, float f7) {
        return n(f5, f6, f7, l.f9629k);
    }

    static int n(float f5, float f6, float f7, l lVar) {
        if (f6 < 1.0d || Math.round(f7) <= 0.0d || Math.round(f7) >= 100.0d) {
            return b.a(f7);
        }
        float fMin = f5 < 0.0f ? 0.0f : Math.min(360.0f, f5);
        a aVar = null;
        boolean z5 = true;
        float f8 = 0.0f;
        float f9 = f6;
        while (Math.abs(f8 - f6) >= 0.4f) {
            a aVarB = b(fMin, f9, f7);
            if (!z5) {
                if (aVarB == null) {
                    f6 = f9;
                } else {
                    f8 = f9;
                    aVar = aVarB;
                }
                f9 = ((f6 - f8) / 2.0f) + f8;
            } else {
                if (aVarB != null) {
                    return aVarB.o(lVar);
                }
                f9 = ((f6 - f8) / 2.0f) + f8;
                z5 = false;
            }
        }
        return aVar == null ? b.a(f7) : aVar.o(lVar);
    }

    float a(a aVar) {
        float fL = l() - aVar.l();
        float fG = g() - aVar.g();
        float fH = h() - aVar.h();
        return (float) (Math.pow(Math.sqrt((fL * fL) + (fG * fG) + (fH * fH)), 0.63d) * 1.41d);
    }

    float g() {
        return this.f9594h;
    }

    float h() {
        return this.f9595i;
    }

    float i() {
        return this.f9588b;
    }

    float j() {
        return this.f9587a;
    }

    float k() {
        return this.f9589c;
    }

    float l() {
        return this.f9593g;
    }

    int o(l lVar) {
        float fPow = (float) Math.pow(((((double) i()) == 0.0d || ((double) k()) == 0.0d) ? 0.0f : i() / ((float) Math.sqrt(k() / 100.0d))) / Math.pow(1.64d - Math.pow(0.29d, lVar.e()), 0.73d), 1.1111111111111112d);
        double dJ = (j() * 3.1415927f) / 180.0f;
        float fCos = ((float) (Math.cos(2.0d + dJ) + 3.8d)) * 0.25f;
        float fA = lVar.a() * ((float) Math.pow(k() / 100.0d, (1.0d / lVar.b()) / lVar.j()));
        float fG = fCos * 3846.1538f * lVar.g() * lVar.h();
        float f5 = fA / lVar.f();
        float fSin = (float) Math.sin(dJ);
        float fCos2 = (float) Math.cos(dJ);
        float f6 = (((0.305f + f5) * 23.0f) * fPow) / (((fG * 23.0f) + ((11.0f * fPow) * fCos2)) + ((fPow * 108.0f) * fSin));
        float f7 = fCos2 * f6;
        float f8 = f6 * fSin;
        float f9 = f5 * 460.0f;
        float f10 = (((451.0f * f7) + f9) + (288.0f * f8)) / 1403.0f;
        float f11 = ((f9 - (891.0f * f7)) - (261.0f * f8)) / 1403.0f;
        float fSignum = Math.signum(f10) * (100.0f / lVar.c()) * ((float) Math.pow((float) Math.max(0.0d, (Math.abs(f10) * 27.13d) / (400.0d - Math.abs(f10))), 2.380952380952381d));
        float fSignum2 = Math.signum(f11) * (100.0f / lVar.c()) * ((float) Math.pow((float) Math.max(0.0d, (Math.abs(f11) * 27.13d) / (400.0d - Math.abs(f11))), 2.380952380952381d));
        float fSignum3 = Math.signum(((f9 - (f7 * 220.0f)) - (f8 * 6300.0f)) / 1403.0f) * (100.0f / lVar.c()) * ((float) Math.pow((float) Math.max(0.0d, (Math.abs(r8) * 27.13d) / (400.0d - Math.abs(r8))), 2.380952380952381d));
        float f12 = fSignum / lVar.i()[0];
        float f13 = fSignum2 / lVar.i()[1];
        float f14 = fSignum3 / lVar.i()[2];
        float[][] fArr = b.f9597b;
        float[] fArr2 = fArr[0];
        float f15 = (fArr2[0] * f12) + (fArr2[1] * f13) + (fArr2[2] * f14);
        float[] fArr3 = fArr[1];
        float f16 = (fArr3[0] * f12) + (fArr3[1] * f13) + (fArr3[2] * f14);
        float[] fArr4 = fArr[2];
        return androidx.core.graphics.a.b(f15, f16, (f12 * fArr4[0]) + (f13 * fArr4[1]) + (f14 * fArr4[2]));
    }

    int p() {
        return o(l.f9629k);
    }
}
