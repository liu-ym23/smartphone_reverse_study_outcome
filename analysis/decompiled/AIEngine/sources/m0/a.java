package m0;

import android.graphics.Color;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final float f10438a;

    /* renamed from: b, reason: collision with root package name */
    public final float f10439b;

    /* renamed from: c, reason: collision with root package name */
    public final float f10440c;

    /* renamed from: d, reason: collision with root package name */
    public final float f10441d;

    /* renamed from: e, reason: collision with root package name */
    public final float f10442e;

    /* renamed from: f, reason: collision with root package name */
    public final float f10443f;

    public a(float f8, float f9, float f10, float f11, float f12, float f13) {
        this.f10438a = f8;
        this.f10439b = f9;
        this.f10440c = f10;
        this.f10441d = f11;
        this.f10442e = f12;
        this.f10443f = f13;
    }

    public static a a(int i10) {
        h hVar = h.f10470k;
        float fB = b.b(Color.red(i10));
        float fB2 = b.b(Color.green(i10));
        float fB3 = b.b(Color.blue(i10));
        float[][] fArr = b.f10447d;
        float[] fArr2 = fArr[0];
        float f8 = (fArr2[2] * fB3) + (fArr2[1] * fB2) + (fArr2[0] * fB);
        float[] fArr3 = fArr[1];
        float f9 = (fArr3[2] * fB3) + (fArr3[1] * fB2) + (fArr3[0] * fB);
        float[] fArr4 = fArr[2];
        float f10 = (fB3 * fArr4[2]) + (fB2 * fArr4[1]) + (fB * fArr4[0]);
        float[][] fArr5 = b.f10444a;
        float[] fArr6 = fArr5[0];
        float f11 = (fArr6[2] * f10) + (fArr6[1] * f9) + (fArr6[0] * f8);
        float[] fArr7 = fArr5[1];
        float f12 = (fArr7[2] * f10) + (fArr7[1] * f9) + (fArr7[0] * f8);
        float[] fArr8 = fArr5[2];
        float f13 = (f10 * fArr8[2]) + (f9 * fArr8[1]) + (f8 * fArr8[0]);
        float[] fArr9 = hVar.f10477g;
        float f14 = hVar.f10478i;
        float f15 = hVar.f10474d;
        float f16 = hVar.f10471a;
        float f17 = fArr9[0] * f11;
        float f18 = fArr9[1] * f12;
        float f19 = fArr9[2] * f13;
        float f20 = hVar.h;
        float fPow = (float) Math.pow((Math.abs(f17) * f20) / 100.0d, 0.42d);
        float fPow2 = (float) Math.pow((Math.abs(f18) * f20) / 100.0d, 0.42d);
        float fPow3 = (float) Math.pow((Math.abs(f19) * f20) / 100.0d, 0.42d);
        float fSignum = ((Math.signum(f17) * 400.0f) * fPow) / (fPow + 27.13f);
        float fSignum2 = ((Math.signum(f18) * 400.0f) * fPow2) / (fPow2 + 27.13f);
        float fSignum3 = ((Math.signum(f19) * 400.0f) * fPow3) / (fPow3 + 27.13f);
        double d8 = fSignum3;
        float f21 = ((float) (((fSignum2 * (-12.0d)) + (fSignum * 11.0d)) + d8)) / 11.0f;
        float f22 = ((float) ((fSignum + fSignum2) - (d8 * 2.0d))) / 9.0f;
        float f23 = fSignum2 * 20.0f;
        float f24 = ((21.0f * fSignum3) + ((fSignum * 20.0f) + f23)) / 20.0f;
        float f25 = (((fSignum * 40.0f) + f23) + fSignum3) / 20.0f;
        float fAtan2 = (((float) Math.atan2(f22, f21)) * 180.0f) / 3.1415927f;
        if (fAtan2 < 0.0f) {
            fAtan2 += 360.0f;
        } else if (fAtan2 >= 360.0f) {
            fAtan2 -= 360.0f;
        }
        float f26 = (3.1415927f * fAtan2) / 180.0f;
        float fPow4 = ((float) Math.pow((f25 * hVar.f10472b) / f16, hVar.f10479j * f15)) * 100.0f;
        Math.sqrt(fPow4 / 100.0f);
        float f27 = f16 + 4.0f;
        float fPow5 = ((float) Math.pow(1.64d - Math.pow(0.29d, hVar.f10476f), 0.73d)) * ((float) Math.pow((((((((float) (Math.cos((((((double) fAtan2) < 20.14d ? 360.0f + fAtan2 : fAtan2) * 3.141592653589793d) / 180.0d) + 2.0d) + 3.8d)) * 0.25f) * 3846.1538f) * hVar.f10475e) * hVar.f10473c) * ((float) Math.sqrt((f22 * f22) + (f21 * f21)))) / (f24 + 0.305f), 0.9d)) * ((float) Math.sqrt(fPow4 / 100.0d));
        Math.sqrt((r0 * f15) / f27);
        float f28 = (1.7f * fPow4) / ((0.007f * fPow4) + 1.0f);
        float fLog = ((float) Math.log((f14 * fPow5 * 0.0228f) + 1.0f)) * 43.85965f;
        double d10 = f26;
        return new a(fAtan2, fPow5, fPow4, f28, fLog * ((float) Math.cos(d10)), fLog * ((float) Math.sin(d10)));
    }

    public static a b(float f8, float f9, float f10) {
        h hVar = h.f10470k;
        float f11 = hVar.f10474d;
        Math.sqrt(f8 / 100.0d);
        float f12 = hVar.f10471a + 4.0f;
        float f13 = hVar.f10478i * f9;
        Math.sqrt(((f9 / ((float) Math.sqrt(r1))) * hVar.f10474d) / f12);
        float f14 = (1.7f * f8) / ((0.007f * f8) + 1.0f);
        float fLog = ((float) Math.log((f13 * 0.0228d) + 1.0d)) * 43.85965f;
        double d8 = (3.1415927f * f10) / 180.0f;
        return new a(f10, f9, f8, f14, fLog * ((float) Math.cos(d8)), fLog * ((float) Math.sin(d8)));
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int c(m0.h r20) {
        /*
            Method dump skipped, instructions count: 377
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m0.a.c(m0.h):int");
    }
}
