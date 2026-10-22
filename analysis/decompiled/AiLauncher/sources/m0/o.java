package m0;

import java.lang.reflect.Array;
import java.text.DecimalFormat;

/* loaded from: classes.dex */
public abstract class o {

    /* renamed from: k, reason: collision with root package name */
    public static float f37143k = 6.2831855f;

    /* renamed from: a, reason: collision with root package name */
    public AbstractC4889b f37144a;

    /* renamed from: e, reason: collision with root package name */
    public int f37148e;

    /* renamed from: f, reason: collision with root package name */
    public String f37149f;

    /* renamed from: i, reason: collision with root package name */
    public long f37152i;

    /* renamed from: b, reason: collision with root package name */
    public int f37145b = 0;

    /* renamed from: c, reason: collision with root package name */
    public int[] f37146c = new int[10];

    /* renamed from: d, reason: collision with root package name */
    public float[][] f37147d = (float[][]) Array.newInstance((Class<?>) Float.TYPE, 10, 3);

    /* renamed from: g, reason: collision with root package name */
    public float[] f37150g = new float[3];

    /* renamed from: h, reason: collision with root package name */
    public boolean f37151h = false;

    /* renamed from: j, reason: collision with root package name */
    public float f37153j = Float.NaN;

    public static class a {
        public static void a(int[] iArr, float[][] fArr, int i10, int i11) {
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

        public static int b(int[] iArr, float[][] fArr, int i10, int i11) {
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

        public static void c(int[] iArr, float[][] fArr, int i10, int i11) {
            int i12 = iArr[i10];
            iArr[i10] = iArr[i11];
            iArr[i11] = i12;
            float[] fArr2 = fArr[i10];
            fArr[i10] = fArr[i11];
            fArr[i11] = fArr2;
        }
    }

    public float a(float f10) {
        switch (this.f37145b) {
            case 1:
                return Math.signum(f10 * f37143k);
            case 2:
                return 1.0f - Math.abs(f10);
            case 3:
                return (((f10 * 2.0f) + 1.0f) % 2.0f) - 1.0f;
            case 4:
                return 1.0f - (((f10 * 2.0f) + 1.0f) % 2.0f);
            case 5:
                return (float) Math.cos(f10 * f37143k);
            case 6:
                float fAbs = 1.0f - Math.abs(((f10 * 4.0f) % 4.0f) - 2.0f);
                return 1.0f - (fAbs * fAbs);
            default:
                return (float) Math.sin(f10 * f37143k);
        }
    }

    public void b(int i10, float f10, float f11, int i11, float f12) {
        int[] iArr = this.f37146c;
        int i12 = this.f37148e;
        iArr[i12] = i10;
        float[] fArr = this.f37147d[i12];
        fArr[0] = f10;
        fArr[1] = f11;
        fArr[2] = f12;
        this.f37145b = Math.max(this.f37145b, i11);
        this.f37148e++;
    }

    public void c(long j10) {
        this.f37152i = j10;
    }

    public void d(String str) {
        this.f37149f = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0063  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void e(int r12) {
        /*
            r11 = this;
            int r0 = r11.f37148e
            if (r0 != 0) goto L1d
            java.io.PrintStream r12 = java.lang.System.err
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Error no points added to "
            r0.append(r1)
            java.lang.String r11 = r11.f37149f
            r0.append(r11)
            java.lang.String r11 = r0.toString()
            r12.println(r11)
            return
        L1d:
            int[] r1 = r11.f37146c
            float[][] r2 = r11.f37147d
            r3 = 1
            int r0 = r0 - r3
            r4 = 0
            m0.o.a.a(r1, r2, r4, r0)
            r0 = r3
            r1 = r4
        L29:
            int[] r2 = r11.f37146c
            int r5 = r2.length
            if (r0 >= r5) goto L3b
            r5 = r2[r0]
            int r6 = r0 + (-1)
            r2 = r2[r6]
            if (r5 == r2) goto L38
            int r1 = r1 + 1
        L38:
            int r0 = r0 + 1
            goto L29
        L3b:
            if (r1 != 0) goto L3e
            r1 = r3
        L3e:
            double[] r0 = new double[r1]
            r2 = 2
            int[] r5 = new int[r2]
            r6 = 3
            r5[r3] = r6
            r5[r4] = r1
            java.lang.Class r1 = java.lang.Double.TYPE
            java.lang.Object r1 = java.lang.reflect.Array.newInstance(r1, r5)
            double[][] r1 = (double[][]) r1
            r5 = r4
            r6 = r5
        L52:
            int r7 = r11.f37148e
            if (r5 >= r7) goto L8a
            if (r5 <= 0) goto L63
            int[] r7 = r11.f37146c
            r8 = r7[r5]
            int r9 = r5 + (-1)
            r7 = r7[r9]
            if (r8 != r7) goto L63
            goto L87
        L63:
            int[] r7 = r11.f37146c
            r7 = r7[r5]
            double r7 = (double) r7
            r9 = 4576918229304087675(0x3f847ae147ae147b, double:0.01)
            double r7 = r7 * r9
            r0[r6] = r7
            r7 = r1[r6]
            float[][] r8 = r11.f37147d
            r8 = r8[r5]
            r9 = r8[r4]
            double r9 = (double) r9
            r7[r4] = r9
            r9 = r8[r3]
            double r9 = (double) r9
            r7[r3] = r9
            r8 = r8[r2]
            double r8 = (double) r8
            r7[r2] = r8
            int r6 = r6 + 1
        L87:
            int r5 = r5 + 1
            goto L52
        L8a:
            m0.b r12 = m0.AbstractC4889b.a(r12, r0, r1)
            r11.f37144a = r12
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: m0.o.e(int):void");
    }

    public String toString() {
        String str = this.f37149f;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        for (int i10 = 0; i10 < this.f37148e; i10++) {
            str = str + "[" + this.f37146c[i10] + " , " + decimalFormat.format(this.f37147d[i10]) + "] ";
        }
        return str;
    }
}
