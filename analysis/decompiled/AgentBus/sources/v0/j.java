package v0;

/* loaded from: classes.dex */
public abstract class j {

    /* renamed from: a, reason: collision with root package name */
    public static final s f10305a = new s(0.31006f, 0.31616f);

    /* renamed from: b, reason: collision with root package name */
    public static final s f10306b = new s(0.34567f, 0.3585f);

    /* renamed from: c, reason: collision with root package name */
    public static final s f10307c = new s(0.32168f, 0.33767f);

    /* renamed from: d, reason: collision with root package name */
    public static final s f10308d = new s(0.31271f, 0.32902f);

    /* renamed from: e, reason: collision with root package name */
    public static final float[] f10309e = {0.964212f, 1.0f, 0.825188f};

    public static c a(c cVar) {
        if (b.a(cVar.f10270b, b.f10264a)) {
            q qVar = (q) cVar;
            s sVar = qVar.f10324d;
            s sVar2 = f10306b;
            if (!d(sVar, sVar2)) {
                return new q(qVar.f10269a, qVar.f10328h, sVar2, g(c(a.f10262b.f10263a, sVar.a(), sVar2.a()), qVar.f10329i), qVar.f10331k, qVar.f10334n, qVar.f10325e, qVar.f10326f, qVar.f10327g, -1);
            }
        }
        return cVar;
    }

    public static float b(float[] fArr) {
        if (fArr.length < 6) {
            return 0.0f;
        }
        float f10 = fArr[0];
        float f11 = fArr[1];
        float f12 = fArr[2];
        float f13 = fArr[3];
        float f14 = fArr[4];
        float f15 = fArr[5];
        float f16 = (((((f12 * f15) + ((f11 * f14) + (f10 * f13))) - (f13 * f14)) - (f11 * f12)) - (f10 * f15)) * 0.5f;
        return f16 < 0.0f ? -f16 : f16;
    }

    public static final float[] c(float[] fArr, float[] fArr2, float[] fArr3) {
        h(fArr, fArr2);
        h(fArr, fArr3);
        float[] fArr4 = {fArr3[0] / fArr2[0], fArr3[1] / fArr2[1], fArr3[2] / fArr2[2]};
        float[] fArrF = f(fArr);
        float f10 = fArr4[0];
        float f11 = fArr[0] * f10;
        float f12 = fArr4[1];
        float f13 = fArr[1] * f12;
        float f14 = fArr4[2];
        return g(fArrF, new float[]{f11, f13, fArr[2] * f14, fArr[3] * f10, fArr[4] * f12, fArr[5] * f14, f10 * fArr[6], f12 * fArr[7], f14 * fArr[8]});
    }

    public static final boolean d(s sVar, s sVar2) {
        if (sVar == sVar2) {
            return true;
        }
        return Math.abs(sVar.f10345a - sVar2.f10345a) < 0.001f && Math.abs(sVar.f10346b - sVar2.f10346b) < 0.001f;
    }

    public static final g e(c cVar, c cVar2) {
        if (cVar == cVar2) {
            return new e(cVar, cVar, 1);
        }
        long j2 = cVar.f10270b;
        long j4 = b.f10264a;
        return (b.a(j2, j4) && b.a(cVar2.f10270b, j4)) ? new f((q) cVar, (q) cVar2) : new g(cVar, cVar2, 0);
    }

    public static final float[] f(float[] fArr) {
        float f10 = fArr[0];
        float f11 = fArr[3];
        float f12 = fArr[6];
        float f13 = fArr[1];
        float f14 = fArr[4];
        float f15 = fArr[7];
        float f16 = fArr[2];
        float f17 = fArr[5];
        float f18 = fArr[8];
        float f19 = (f14 * f18) - (f15 * f17);
        float f20 = (f15 * f16) - (f13 * f18);
        float f21 = (f13 * f17) - (f14 * f16);
        float f22 = (f12 * f21) + (f11 * f20) + (f10 * f19);
        float[] fArr2 = new float[fArr.length];
        fArr2[0] = f19 / f22;
        fArr2[1] = f20 / f22;
        fArr2[2] = f21 / f22;
        fArr2[3] = ((f12 * f17) - (f11 * f18)) / f22;
        fArr2[4] = ((f18 * f10) - (f12 * f16)) / f22;
        fArr2[5] = ((f16 * f11) - (f17 * f10)) / f22;
        fArr2[6] = ((f11 * f15) - (f12 * f14)) / f22;
        fArr2[7] = ((f12 * f13) - (f15 * f10)) / f22;
        fArr2[8] = ((f10 * f14) - (f11 * f13)) / f22;
        return fArr2;
    }

    public static final float[] g(float[] fArr, float[] fArr2) {
        float[] fArr3 = new float[9];
        if (fArr.length < 9 || fArr2.length < 9) {
            return fArr3;
        }
        float f10 = fArr[0] * fArr2[0];
        float f11 = fArr[3];
        float f12 = fArr2[1];
        float f13 = fArr[6];
        float f14 = fArr2[2];
        fArr3[0] = (f13 * f14) + (f11 * f12) + f10;
        float f15 = fArr[1];
        float f16 = fArr2[0];
        float f17 = fArr[4];
        float f18 = fArr[7];
        float f19 = f18 * f14;
        fArr3[1] = f19 + (f12 * f17) + (f15 * f16);
        float f20 = fArr[2] * f16;
        float f21 = fArr[5];
        float f22 = (fArr2[1] * f21) + f20;
        float f23 = fArr[8];
        fArr3[2] = (f14 * f23) + f22;
        float f24 = fArr[0];
        float f25 = fArr2[3] * f24;
        float f26 = fArr2[4];
        float f27 = (f11 * f26) + f25;
        float f28 = fArr2[5];
        fArr3[3] = (f13 * f28) + f27;
        float f29 = fArr[1];
        float f30 = fArr2[3];
        float f31 = f17 * f26;
        fArr3[4] = (f18 * f28) + f31 + (f29 * f30);
        float f32 = fArr[2];
        float f33 = f28 * f23;
        fArr3[5] = f33 + (f21 * fArr2[4]) + (f30 * f32);
        float f34 = f24 * fArr2[6];
        float f35 = fArr[3];
        float f36 = fArr2[7];
        float f37 = (f35 * f36) + f34;
        float f38 = fArr2[8];
        fArr3[6] = (f13 * f38) + f37;
        float f39 = fArr2[6];
        float f40 = f18 * f38;
        fArr3[7] = f40 + (fArr[4] * f36) + (f29 * f39);
        float f41 = f23 * f38;
        fArr3[8] = f41 + (fArr[5] * fArr2[7]) + (f32 * f39);
        return fArr3;
    }

    public static final float[] h(float[] fArr, float[] fArr2) {
        if (fArr.length < 9 || fArr2.length < 3) {
            return fArr2;
        }
        float f10 = fArr2[0];
        float f11 = fArr2[1];
        float f12 = fArr2[2];
        fArr2[0] = (fArr[6] * f12) + (fArr[3] * f11) + (fArr[0] * f10);
        fArr2[1] = (fArr[7] * f12) + (fArr[4] * f11) + (fArr[1] * f10);
        fArr2[2] = (fArr[8] * f12) + (fArr[5] * f11) + (fArr[2] * f10);
        return fArr2;
    }
}
