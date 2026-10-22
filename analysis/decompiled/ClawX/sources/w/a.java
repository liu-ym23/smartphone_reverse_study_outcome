package w;

import android.graphics.Color;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final float f6039a;

    /* renamed from: b, reason: collision with root package name */
    public final float f6040b;

    /* renamed from: c, reason: collision with root package name */
    public final float f6041c;
    public final float d;

    /* renamed from: e, reason: collision with root package name */
    public final float f6042e;

    /* renamed from: f, reason: collision with root package name */
    public final float f6043f;

    public a(float f3, float f7, float f9, float f10, float f11, float f12) {
        this.f6039a = f3;
        this.f6040b = f7;
        this.f6041c = f9;
        this.d = f10;
        this.f6042e = f11;
        this.f6043f = f12;
    }

    public static a a(int i8) {
        k kVar = k.f6064k;
        float fC = b.c(Color.red(i8));
        float fC2 = b.c(Color.green(i8));
        float fC3 = b.c(Color.blue(i8));
        float[][] fArr = b.d;
        float[] fArr2 = fArr[0];
        float f3 = (fArr2[2] * fC3) + (fArr2[1] * fC2) + (fArr2[0] * fC);
        float[] fArr3 = fArr[1];
        float f7 = (fArr3[2] * fC3) + (fArr3[1] * fC2) + (fArr3[0] * fC);
        float[] fArr4 = fArr[2];
        float f9 = (fC3 * fArr4[2]) + (fC2 * fArr4[1]) + (fC * fArr4[0]);
        float[][] fArr5 = b.f6044a;
        float[] fArr6 = fArr5[0];
        float f10 = (fArr6[2] * f9) + (fArr6[1] * f7) + (fArr6[0] * f3);
        float[] fArr7 = fArr5[1];
        float f11 = (fArr7[2] * f9) + (fArr7[1] * f7) + (fArr7[0] * f3);
        float[] fArr8 = fArr5[2];
        float f12 = (f9 * fArr8[2]) + (f7 * fArr8[1]) + (f3 * fArr8[0]);
        float[] fArr9 = kVar.f6070g;
        float f13 = kVar.f6072i;
        float f14 = kVar.d;
        float f15 = kVar.f6065a;
        float f16 = fArr9[0] * f10;
        float f17 = fArr9[1] * f11;
        float f18 = fArr9[2] * f12;
        float f19 = kVar.f6071h;
        float fPow = (float) Math.pow((Math.abs(f16) * f19) / 100.0d, 0.42d);
        float fPow2 = (float) Math.pow((Math.abs(f17) * f19) / 100.0d, 0.42d);
        float fPow3 = (float) Math.pow((Math.abs(f18) * f19) / 100.0d, 0.42d);
        float fSignum = ((Math.signum(f16) * 400.0f) * fPow) / (fPow + 27.13f);
        float fSignum2 = ((Math.signum(f17) * 400.0f) * fPow2) / (fPow2 + 27.13f);
        float fSignum3 = ((Math.signum(f18) * 400.0f) * fPow3) / (fPow3 + 27.13f);
        double d = fSignum3;
        float f20 = ((float) (((fSignum2 * (-12.0d)) + (fSignum * 11.0d)) + d)) / 11.0f;
        float f21 = ((float) ((fSignum + fSignum2) - (d * 2.0d))) / 9.0f;
        float f22 = fSignum2 * 20.0f;
        float f23 = ((21.0f * fSignum3) + ((fSignum * 20.0f) + f22)) / 20.0f;
        float f24 = (((fSignum * 40.0f) + f22) + fSignum3) / 20.0f;
        float fAtan2 = (((float) Math.atan2(f21, f20)) * 180.0f) / 3.1415927f;
        if (fAtan2 < 0.0f) {
            fAtan2 += 360.0f;
        } else if (fAtan2 >= 360.0f) {
            fAtan2 -= 360.0f;
        }
        float f25 = (3.1415927f * fAtan2) / 180.0f;
        float fPow4 = ((float) Math.pow((f24 * kVar.f6066b) / f15, kVar.f6073j * f14)) * 100.0f;
        Math.sqrt(fPow4 / 100.0f);
        float f26 = f15 + 4.0f;
        float fPow5 = ((float) Math.pow(1.64d - Math.pow(0.29d, kVar.f6069f), 0.73d)) * ((float) Math.pow((((((((float) (Math.cos((((((double) fAtan2) < 20.14d ? 360.0f + fAtan2 : fAtan2) * 3.141592653589793d) / 180.0d) + 2.0d) + 3.8d)) * 0.25f) * 3846.1538f) * kVar.f6068e) * kVar.f6067c) * ((float) Math.sqrt((f21 * f21) + (f20 * f20)))) / (f23 + 0.305f), 0.9d)) * ((float) Math.sqrt(fPow4 / 100.0d));
        Math.sqrt((r0 * f14) / f26);
        float f27 = (1.7f * fPow4) / ((0.007f * fPow4) + 1.0f);
        float fLog = ((float) Math.log((f13 * fPow5 * 0.0228f) + 1.0f)) * 43.85965f;
        double d9 = f25;
        return new a(fAtan2, fPow5, fPow4, f27, fLog * ((float) Math.cos(d9)), fLog * ((float) Math.sin(d9)));
    }

    public static a b(float f3, float f7, float f9) {
        k kVar = k.f6064k;
        float f10 = kVar.d;
        Math.sqrt(f3 / 100.0d);
        float f11 = kVar.f6065a + 4.0f;
        float f12 = kVar.f6072i * f7;
        Math.sqrt(((f7 / ((float) Math.sqrt(r1))) * kVar.d) / f11);
        float f13 = (1.7f * f3) / ((0.007f * f3) + 1.0f);
        float fLog = ((float) Math.log((f12 * 0.0228d) + 1.0d)) * 43.85965f;
        double d = (3.1415927f * f9) / 180.0f;
        return new a(f9, f7, f3, f13, fLog * ((float) Math.cos(d)), fLog * ((float) Math.sin(d)));
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int c(w.k r20) {
        /*
            Method dump skipped, instructions count: 377
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: w.a.c(w.k):int");
    }
}
