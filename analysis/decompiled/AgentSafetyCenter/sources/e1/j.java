package e1;

import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class j {

    /* renamed from: a, reason: collision with root package name */
    public static final s f3374a = new s(0.31006f, 0.31616f);

    /* renamed from: b, reason: collision with root package name */
    public static final s f3375b = new s(0.34567f, 0.3585f);

    /* renamed from: c, reason: collision with root package name */
    public static final s f3376c = new s(0.32168f, 0.33767f);

    /* renamed from: d, reason: collision with root package name */
    public static final s f3377d = new s(0.31271f, 0.32902f);

    /* renamed from: e, reason: collision with root package name */
    public static final float[] f3378e = {0.964212f, 1.0f, 0.825188f};

    public static c a(c cVar) {
        if (b.a(cVar.f3340b, b.f3334a)) {
            q qVar = (q) cVar;
            s sVar = qVar.f3393d;
            s sVar2 = f3375b;
            if (!d(sVar, sVar2)) {
                return new q(qVar.f3339a, qVar.f3397h, sVar2, g(c(a.f3332b.f3333a, sVar.a(), sVar2.a()), qVar.i), qVar.f3399k, qVar.f3402n, qVar.f3394e, qVar.f3395f, qVar.f3396g, -1);
            }
        }
        return cVar;
    }

    public static float b(float[] fArr) {
        if (fArr.length < 6) {
            return 0.0f;
        }
        float f5 = fArr[0];
        float f10 = fArr[1];
        float f11 = fArr[2];
        float f12 = fArr[3];
        float f13 = fArr[4];
        float f14 = fArr[5];
        float f15 = (((((f11 * f14) + ((f10 * f13) + (f5 * f12))) - (f12 * f13)) - (f10 * f11)) - (f5 * f14)) * 0.5f;
        return f15 < 0.0f ? -f15 : f15;
    }

    public static final float[] c(float[] fArr, float[] fArr2, float[] fArr3) {
        h(fArr, fArr2);
        h(fArr, fArr3);
        float[] fArr4 = {fArr3[0] / fArr2[0], fArr3[1] / fArr2[1], fArr3[2] / fArr2[2]};
        float[] fArrF = f(fArr);
        float f5 = fArr4[0];
        float f10 = fArr[0] * f5;
        float f11 = fArr4[1];
        float f12 = fArr[1] * f11;
        float f13 = fArr4[2];
        return g(fArrF, new float[]{f10, f12, fArr[2] * f13, fArr[3] * f5, fArr[4] * f11, fArr[5] * f13, f5 * fArr[6], f11 * fArr[7], f13 * fArr[8]});
    }

    public static final boolean d(s sVar, s sVar2) {
        if (sVar == sVar2) {
            return true;
        }
        return Math.abs(sVar.f3413a - sVar2.f3413a) < 0.001f && Math.abs(sVar.f3414b - sVar2.f3414b) < 0.001f;
    }

    public static final g e(c cVar, c cVar2) {
        float[] fArrG;
        if (cVar == cVar2) {
            return new e(cVar, cVar, 1);
        }
        long j10 = cVar.f3340b;
        long j11 = b.f3334a;
        if (!b.a(j10, j11) || !b.a(cVar2.f3340b, j11)) {
            return new g(cVar, cVar2, 0);
        }
        q qVar = (q) cVar;
        q qVar2 = (q) cVar2;
        f fVar = new f(qVar2, qVar, qVar2, null);
        fVar.f3366e = qVar;
        fVar.f3367f = qVar2;
        float[] fArr = a.f3332b.f3333a;
        s sVar = qVar.f3393d;
        float[] fArrG2 = qVar.i;
        s sVar2 = qVar2.f3393d;
        float[] fArrF = qVar2.f3398j;
        if (d(sVar, sVar2)) {
            fArrG = g(fArrF, fArrG2);
        } else {
            float[] fArrA = sVar.a();
            float[] fArrA2 = sVar2.a();
            s sVar3 = f3375b;
            if (!d(sVar, sVar3)) {
                fArrG2 = g(c(fArr, fArrA, new float[]{0.964212f, 1.0f, 0.825188f}), fArrG2);
            }
            if (!d(sVar2, sVar3)) {
                fArrF = f(g(c(fArr, fArrA2, new float[]{0.964212f, 1.0f, 0.825188f}), qVar2.i));
            }
            fArrG = g(fArrF, fArrG2);
        }
        fVar.f3368g = fArrG;
        VarHandle.storeStoreFence();
        return fVar;
    }

    public static final float[] f(float[] fArr) {
        float f5 = fArr[0];
        float f10 = fArr[3];
        float f11 = fArr[6];
        float f12 = fArr[1];
        float f13 = fArr[4];
        float f14 = fArr[7];
        float f15 = fArr[2];
        float f16 = fArr[5];
        float f17 = fArr[8];
        float f18 = (f13 * f17) - (f14 * f16);
        float f19 = (f14 * f15) - (f12 * f17);
        float f20 = (f12 * f16) - (f13 * f15);
        float f21 = (f11 * f20) + (f10 * f19) + (f5 * f18);
        float[] fArr2 = new float[fArr.length];
        fArr2[0] = f18 / f21;
        fArr2[1] = f19 / f21;
        fArr2[2] = f20 / f21;
        fArr2[3] = ((f11 * f16) - (f10 * f17)) / f21;
        fArr2[4] = ((f17 * f5) - (f11 * f15)) / f21;
        fArr2[5] = ((f15 * f10) - (f16 * f5)) / f21;
        fArr2[6] = ((f10 * f14) - (f11 * f13)) / f21;
        fArr2[7] = ((f11 * f12) - (f14 * f5)) / f21;
        fArr2[8] = ((f5 * f13) - (f10 * f12)) / f21;
        return fArr2;
    }

    public static final float[] g(float[] fArr, float[] fArr2) {
        float[] fArr3 = new float[9];
        if (fArr.length < 9 || fArr2.length < 9) {
            return fArr3;
        }
        float f5 = fArr[0] * fArr2[0];
        float f10 = fArr[3];
        float f11 = fArr2[1];
        float f12 = fArr[6];
        float f13 = fArr2[2];
        fArr3[0] = (f12 * f13) + (f10 * f11) + f5;
        float f14 = fArr[1];
        float f15 = fArr2[0];
        float f16 = fArr[4];
        float f17 = fArr[7];
        float f18 = f17 * f13;
        fArr3[1] = f18 + (f11 * f16) + (f14 * f15);
        float f19 = fArr[2] * f15;
        float f20 = fArr[5];
        float f21 = (fArr2[1] * f20) + f19;
        float f22 = fArr[8];
        fArr3[2] = (f13 * f22) + f21;
        float f23 = fArr[0];
        float f24 = fArr2[3] * f23;
        float f25 = fArr2[4];
        float f26 = (f10 * f25) + f24;
        float f27 = fArr2[5];
        fArr3[3] = (f12 * f27) + f26;
        float f28 = fArr[1];
        float f29 = fArr2[3];
        float f30 = f16 * f25;
        fArr3[4] = (f17 * f27) + f30 + (f28 * f29);
        float f31 = fArr[2];
        float f32 = f27 * f22;
        fArr3[5] = f32 + (f20 * fArr2[4]) + (f29 * f31);
        float f33 = f23 * fArr2[6];
        float f34 = fArr[3];
        float f35 = fArr2[7];
        float f36 = (f34 * f35) + f33;
        float f37 = fArr2[8];
        fArr3[6] = (f12 * f37) + f36;
        float f38 = fArr2[6];
        float f39 = f17 * f37;
        fArr3[7] = f39 + (fArr[4] * f35) + (f28 * f38);
        float f40 = f22 * f37;
        fArr3[8] = f40 + (fArr[5] * fArr2[7]) + (f31 * f38);
        return fArr3;
    }

    public static final float[] h(float[] fArr, float[] fArr2) {
        if (fArr.length < 9 || fArr2.length < 3) {
            return fArr2;
        }
        float f5 = fArr2[0];
        float f10 = fArr2[1];
        float f11 = fArr2[2];
        fArr2[0] = (fArr[6] * f11) + (fArr[3] * f10) + (fArr[0] * f5);
        fArr2[1] = (fArr[7] * f11) + (fArr[4] * f10) + (fArr[1] * f5);
        fArr2[2] = (fArr[8] * f11) + (fArr[5] * f10) + (fArr[2] * f5);
        return fArr2;
    }
}
