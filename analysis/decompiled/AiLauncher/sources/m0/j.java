package m0;

import java.text.DecimalFormat;
import java.util.Arrays;

/* loaded from: classes.dex */
public abstract class j {

    /* renamed from: a, reason: collision with root package name */
    public AbstractC4889b f37110a;

    /* renamed from: b, reason: collision with root package name */
    public int[] f37111b = new int[10];

    /* renamed from: c, reason: collision with root package name */
    public float[] f37112c = new float[10];

    /* renamed from: d, reason: collision with root package name */
    public int f37113d;

    /* renamed from: e, reason: collision with root package name */
    public String f37114e;

    public static class a {
        public static void a(int[] iArr, float[] fArr, int i10, int i11) {
            int[] iArr2 = new int[iArr.length + 10];
            iArr2[0] = i11;
            iArr2[1] = i10;
            int i12 = 2;
            while (i12 > 0) {
                int i13 = iArr2[i12 - 1];
                int i14 = i12 - 2;
                int i15 = iArr2[i14];
                if (i13 < i15) {
                    int iB = b(iArr, fArr, i13, i15);
                    iArr2[i14] = iB - 1;
                    iArr2[i12 - 1] = i13;
                    int i16 = i12 + 1;
                    iArr2[i12] = i15;
                    i12 += 2;
                    iArr2[i16] = iB + 1;
                } else {
                    i12 = i14;
                }
            }
        }

        public static int b(int[] iArr, float[] fArr, int i10, int i11) {
            int i12 = iArr[i11];
            int i13 = i10;
            while (i10 < i11) {
                if (iArr[i10] <= i12) {
                    c(iArr, fArr, i13, i10);
                    i13++;
                }
                i10++;
            }
            c(iArr, fArr, i13, i11);
            return i13;
        }

        public static void c(int[] iArr, float[] fArr, int i10, int i11) {
            int i12 = iArr[i10];
            iArr[i10] = iArr[i11];
            iArr[i11] = i12;
            float f10 = fArr[i10];
            fArr[i10] = fArr[i11];
            fArr[i11] = f10;
        }
    }

    public float a(float f10) {
        return (float) this.f37110a.c(f10, 0);
    }

    public void b(int i10, float f10) {
        int[] iArr = this.f37111b;
        if (iArr.length < this.f37113d + 1) {
            this.f37111b = Arrays.copyOf(iArr, iArr.length * 2);
            float[] fArr = this.f37112c;
            this.f37112c = Arrays.copyOf(fArr, fArr.length * 2);
        }
        int[] iArr2 = this.f37111b;
        int i11 = this.f37113d;
        iArr2[i11] = i10;
        this.f37112c[i11] = f10;
        this.f37113d = i11 + 1;
    }

    public void c(String str) {
        this.f37114e = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void d(int r10) {
        /*
            r9 = this;
            int r0 = r9.f37113d
            if (r0 != 0) goto L5
            return
        L5:
            int[] r1 = r9.f37111b
            float[] r2 = r9.f37112c
            r3 = 1
            int r0 = r0 - r3
            r4 = 0
            m0.j.a.a(r1, r2, r4, r0)
            r0 = r3
            r1 = r0
        L11:
            int r2 = r9.f37113d
            if (r0 >= r2) goto L24
            int[] r2 = r9.f37111b
            int r5 = r0 + (-1)
            r5 = r2[r5]
            r2 = r2[r0]
            if (r5 == r2) goto L21
            int r1 = r1 + 1
        L21:
            int r0 = r0 + 1
            goto L11
        L24:
            double[] r0 = new double[r1]
            r2 = 2
            int[] r2 = new int[r2]
            r2[r3] = r3
            r2[r4] = r1
            java.lang.Class r1 = java.lang.Double.TYPE
            java.lang.Object r1 = java.lang.reflect.Array.newInstance(r1, r2)
            double[][] r1 = (double[][]) r1
            r2 = r4
            r3 = r2
        L37:
            int r5 = r9.f37113d
            if (r2 >= r5) goto L63
            if (r2 <= 0) goto L48
            int[] r5 = r9.f37111b
            r6 = r5[r2]
            int r7 = r2 + (-1)
            r5 = r5[r7]
            if (r6 != r5) goto L48
            goto L60
        L48:
            int[] r5 = r9.f37111b
            r5 = r5[r2]
            double r5 = (double) r5
            r7 = 4576918229304087675(0x3f847ae147ae147b, double:0.01)
            double r5 = r5 * r7
            r0[r3] = r5
            r5 = r1[r3]
            float[] r6 = r9.f37112c
            r6 = r6[r2]
            double r6 = (double) r6
            r5[r4] = r6
            int r3 = r3 + 1
        L60:
            int r2 = r2 + 1
            goto L37
        L63:
            m0.b r10 = m0.AbstractC4889b.a(r10, r0, r1)
            r9.f37110a = r10
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: m0.j.d(int):void");
    }

    public String toString() {
        String str = this.f37114e;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        for (int i10 = 0; i10 < this.f37113d; i10++) {
            str = str + "[" + this.f37111b[i10] + " , " + decimalFormat.format(this.f37112c[i10]) + "] ";
        }
        return str;
    }
}
