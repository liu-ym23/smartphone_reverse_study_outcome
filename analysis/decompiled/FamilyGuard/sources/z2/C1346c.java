package z2;

import A2.C0267f;
import android.content.Context;

/* renamed from: z2.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1346c extends g {

    /* renamed from: e, reason: collision with root package name */
    private int[] f24058e;

    /* renamed from: f, reason: collision with root package name */
    private int[] f24059f;

    public C1346c(int[] iArr, int[] iArr2) {
        this.f24058e = iArr;
        this.f24059f = iArr2;
    }

    private float[] j(d dVar, int i5, double d6, int i6) {
        float[] fArr = new float[i6];
        int i7 = i6 - 1;
        if (d6 <= 0.0d) {
            return fArr;
        }
        double[] dArrQ = dVar.q(i5);
        int iMin = Math.min(i7, dArrQ == null ? 0 : dArrQ.length);
        double d7 = 0.0d;
        for (int i8 = 0; i8 < iMin; i8++) {
            double d8 = dArrQ[i8];
            if (d8 > 0.0d) {
                d7 += d8;
            }
        }
        double d9 = d7 > d6 ? d6 / d7 : 1.0d;
        float f5 = 0.0f;
        for (int i9 = 0; i9 < iMin; i9++) {
            float fMax = (float) ((Math.max(0.0d, dArrQ[i9]) * d9) / d6);
            fArr[i9] = fMax;
            f5 += fMax;
        }
        float f6 = 1.0f - f5;
        if (f6 < 0.0f) {
            f6 = 0.0f;
        }
        int iK = k(dVar.r(), i7);
        if (iK < 0) {
            fArr[i7] = f6;
            return fArr;
        }
        fArr[iK] = fArr[iK] + f6;
        fArr[i7] = 0.0f;
        return fArr;
    }

    private static int k(int[] iArr, int i5) {
        if (iArr == null) {
            return -1;
        }
        int iMin = Math.min(i5, iArr.length);
        for (int i6 = 0; i6 < iMin; i6++) {
            if (iArr[i6] == 10) {
                return i6;
            }
        }
        return -1;
    }

    @Override // z2.e
    public void d(Context context, int i5, y2.g gVar) {
        f fVarB = b();
        if ((gVar instanceof C0267f) && (fVarB instanceof d)) {
            C0267f c0267f = (C0267f) gVar;
            d dVar = (d) fVarB;
            double dA = fVarB.a();
            double dE = fVarB.e(i5);
            c0267f.f((float) (dE / dA));
            int length = this.f24059f.length;
            if (length == 0) {
                c0267f.v(new float[0]);
            } else {
                c0267f.v(j(dVar, i5, dE, length));
            }
        }
    }

    @Override // z2.e
    public y2.g f(Context context, int i5) {
        C0267f c0267f = new C0267f(context, this.f24058e, this.f24059f);
        c0267f.p(g());
        d(context, i5, c0267f);
        return c0267f;
    }
}
