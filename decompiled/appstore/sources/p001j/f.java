package p001j;

import java.lang.reflect.Array;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class f extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public double[] f20795a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public double[][] f20796b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public double[][] f20797c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f20798d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public double[] f20799e;

    public f(double[] r22, double[][] r23) {
        this.f20798d = true;
        int r10 = r22.length;
        int r11 = r23[0].length;
        this.f20799e = new double[r11];
        int r12 = r10 - 1;
        Class r13 = Double.TYPE;
        double[][] r14 = (double[][]) Array.newInstance(r13, new int[]{r12, r11});
        double[][] r15 = (double[][]) Array.newInstance(r13, new int[]{r10, r11});
        int r16 = 0;
    L3:
        if (r16 >= r11) goto L12;
        int r17 = 0;
    L5:
        if (r17 >= r12) goto L11;
        int r18 = r17 + 1;
        double r19 = r22[r18] - r22[r17];
        double[] r110 = r14[r17];
        double r111 = (r23[r18][r16] - r23[r17][r16]) / r19;
        r110[r16] = r111;
        if (r17 != 0) goto L9;
        r15[r17][r16] = r111;
    L10:
        r17 = r18;
        goto L5
    L9:
        r15[r17][r16] = (r14[r17 - 1][r16] + r111) * 0.5d;
        goto L10
    L11:
        r15[r12][r16] = r14[r10 - 2][r16];
        r16 = r16 + 1;
        goto L3
    L12:
        int r20 = 0;
    L13:
        if (r20 >= r12) goto L24;
        int r21 = 0;
    L15:
        if (r21 >= r11) goto L23;
        double r112 = r14[r20][r21];
        if (r112 != 0.0d) goto L19;
        r15[r20][r21] = 0.0d;
        r15[r20 + 1][r21] = 0.0d;
    L22:
        r21 = r21 + 1;
        goto L15
    L19:
        double r113 = r15[r20][r21] / r112;
        int r114 = r20 + 1;
        double r115 = r15[r114][r21] / r112;
        double r116 = Math.hypot(r113, r115);
        if (r116 <= 9.0d) goto L22;
        double r117 = 3.0d / r116;
        double[] r118 = r15[r20];
        double[] r119 = r14[r20];
        r118[r21] = (r113 * r117) * r119[r21];
        r15[r114][r21] = (r117 * r115) * r119[r21];
        goto L22
    L23:
        r20 = r20 + 1;
        goto L13
    L24:
        this.f20795a = r22;
        this.f20796b = r23;
        this.f20797c = r15;
    }

    public static f i(String r10) {
        double[] r11 = new double[r10.length() / 2];
        int r12 = r10.indexOf(40) + 1;
        int r13 = r10.indexOf(44, r12);
        int r14 = 0;
    L4:
        if (r13 == (-1)) goto L6;
        r11[r14] = Double.parseDouble(r10.substring(r12, r13).trim());
        r12 = r13 + 1;
        r13 = r10.indexOf(44, r12);
        r14 = r14 + 1;
        goto L4
    L6:
        String r15 = r10.substring(r12, r10.indexOf(41, r12)).trim();
        r11[r14] = Double.parseDouble(r15);
        return j(Arrays.copyOf(r11, r14 + 1));
    }

    public static f j(double[] r18) {
        int r10 = (r18.length * 3) - 2;
        int r11 = r18.length - 1;
        double r12 = 1.0d / ((double) r11);
        double[][] r13 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r10, 1});
        double[] r14 = new double[r10];
        int r15 = 0;
    L4:
        if (r15 >= r18.length) goto L10;
        double r16 = r18[r15];
        int r17 = r15 + r11;
        r13[r17][0] = r16;
        double r19 = ((double) r15) * r12;
        r14[r17] = r19;
        if (r15 <= 0) goto L8;
        int r110 = (r11 * 2) + r15;
        r13[r110][0] = r16 + 1.0d;
        r14[r110] = r19 + 1.0d;
        int r111 = r15 - 1;
        r13[r111][0] = (r16 - 1.0d) - r12;
        r14[r111] = (r19 - 1.0d) - r12;
    L8:
        r15 = r15 + 1;
        goto L4
    L10:
        return new f(r14, r13);
    }

    public static double k(double r10, double r12, double r14, double r16, double r18, double r20) {
        double r11 = r12 * r12;
        double r13 = r12 * 6.0d;
        double r15 = (((((-6.0d) * r11) * r16) + (r13 * r16)) + ((6.0d * r11) * r14)) - (r13 * r14);
        double r17 = 3.0d * r10;
        return ((((r15 + ((r17 * r20) * r11)) + ((r17 * r18) * r11)) - (((2.0d * r10) * r20) * r12)) - (((4.0d * r10) * r18) * r12)) + (r10 * r18);
    }

    public static double l(double r12, double r14, double r16, double r18, double r20, double r22) {
        double r10 = r14 * r14;
        double r11 = r10 * r14;
        double r13 = 3.0d * r10;
        double r15 = ((((((-2.0d) * r11) * r18) + (r13 * r18)) + ((r11 * 2.0d) * r16)) - (r13 * r16)) + r16;
        double r17 = r12 * r22;
        double r19 = r15 + (r17 * r11);
        double r110 = r12 * r20;
        return (((r19 + (r11 * r110)) - (r17 * r10)) - (((r12 * 2.0d) * r20) * r10)) + (r110 * r14);
    }

    @Override // p001j.b
    public double c(double r23, int r25) {
        double[] r10 = this.f20795a;
        int r11 = r10.length;
        int r12 = 0;
        if (this.f20798d == false) goto L13;
        double r13 = r10[0];
        if (r23 > r13) goto L9;
        double r14 = this.f20796b[0][r25];
        double r15 = r23 - r13;
        double r16 = f(r13, r25);
    L8:
        return r14 + (r15 * r16);
    L9:
        int r17 = r11 - 1;
        double r18 = r10[r17];
        if (r23 < r18) goto L21;
        r14 = this.f20796b[r17][r25];
        r15 = r23 - r18;
        r16 = f(r18, r25);
    L21:
        if (r12 >= (r11 - 1)) goto L31;
        double[] r19 = this.f20795a;
        double r20 = r19[r12];
        if (r23 == r20) goto L25;
        int r21 = r12 + 1;
        double r22 = r19[r21];
        if (r23 < r22) goto L28;
        r12 = r21;
        goto L21
    L28:
        double r110 = r22 - r20;
        double r111 = (r23 - r20) / r110;
        double[][] r24 = this.f20796b;
        double r112 = r24[r12][r25];
        double r113 = r24[r21][r25];
        double[][] r26 = this.f20797c;
        return l(r110, r111, r112, r113, r26[r12][r25], r26[r21][r25]);
    L25:
        return this.f20796b[r12][r25];
    L31:
        return 0.0d;
    L13:
        if (r23 <= r10[0]) goto L15;
        int r27 = r11 - 1;
        if (r23 < r10[r27]) goto L21;
        return this.f20796b[r27][r25];
    L15:
        return this.f20796b[0][r25];
    }

    @Override // p001j.b
    public void d(double r24, double[] r26) {
        double[] r10 = this.f20795a;
        int r11 = r10.length;
        int r12 = 0;
        int r13 = this.f20796b[0].length;
        if (this.f20798d == false) goto L17;
        double r14 = r10[0];
        if (r24 > r14) goto L10;
        g(r14, this.f20799e);
        int r15 = 0;
    L7:
        if (r15 >= r13) goto L9;
        r26[r15] = this.f20796b[0][r15] + ((r24 - this.f20795a[0]) * this.f20799e[r15]);
        r15 = r15 + 1;
        goto L7
    L9:
        return;
    L10:
        int r16 = r11 - 1;
        double r17 = r10[r16];
        if (r24 < r17) goto L27;
        g(r17, this.f20799e);
    L13:
        if (r12 >= r13) goto L15;
        r26[r12] = this.f20796b[r16][r12] + ((r24 - this.f20795a[r16]) * this.f20799e[r12]);
        r12 = r12 + 1;
        goto L13
    L15:
        return;
    L27:
        int r18 = 0;
    L29:
        if (r18 >= (r11 - 1)) goto L42;
        if (r24 != this.f20795a[r18]) goto L35;
        int r19 = 0;
    L33:
        if (r19 >= r13) goto L35;
        r26[r19] = this.f20796b[r18][r19];
        r19 = r19 + 1;
    L35:
        double[] r20 = this.f20795a;
        int r21 = r18 + 1;
        double r22 = r20[r21];
        if (r24 < r22) goto L37;
        r18 = r21;
        goto L29
    L37:
        double r23 = r20[r18];
        double r25 = r22 - r23;
        double r27 = (r24 - r23) / r25;
    L38:
        if (r12 >= r13) goto L40;
        double[][] r28 = this.f20796b;
        double r110 = r28[r18][r12];
        double r111 = r28[r21][r12];
        double[][] r29 = this.f20797c;
        r26[r12] = l(r25, r27, r110, r111, r29[r18][r12], r29[r21][r12]);
        r12 = r12 + 1;
        goto L38
    L40:
        return;
    L42:
        return;
    L17:
        if (r24 > r10[0]) goto L22;
        int r30 = 0;
    L19:
        if (r30 >= r13) goto L21;
        r26[r30] = this.f20796b[0][r30];
        r30 = r30 + 1;
        goto L19
    L21:
        return;
    L22:
        int r31 = r11 - 1;
        if (r24 < r10[r31]) goto L27;
    L24:
        if (r12 >= r13) goto L26;
        r26[r12] = this.f20796b[r31][r12];
        r12 = r12 + 1;
        goto L24
    }

    @Override // p001j.b
    public void e(double r24, float[] r26) {
        double[] r10 = this.f20795a;
        int r11 = r10.length;
        int r12 = 0;
        int r13 = this.f20796b[0].length;
        if (this.f20798d == false) goto L17;
        double r14 = r10[0];
        if (r24 > r14) goto L10;
        g(r14, this.f20799e);
        int r15 = 0;
    L7:
        if (r15 >= r13) goto L9;
        r26[r15] = (float) (this.f20796b[0][r15] + ((r24 - this.f20795a[0]) * this.f20799e[r15]));
        r15 = r15 + 1;
        goto L7
    L9:
        return;
    L10:
        int r16 = r11 - 1;
        double r17 = r10[r16];
        if (r24 < r17) goto L27;
        g(r17, this.f20799e);
    L13:
        if (r12 >= r13) goto L15;
        r26[r12] = (float) (this.f20796b[r16][r12] + ((r24 - this.f20795a[r16]) * this.f20799e[r12]));
        r12 = r12 + 1;
        goto L13
    L15:
        return;
    L27:
        int r18 = 0;
    L29:
        if (r18 >= (r11 - 1)) goto L42;
        if (r24 != this.f20795a[r18]) goto L35;
        int r19 = 0;
    L33:
        if (r19 >= r13) goto L35;
        r26[r19] = (float) this.f20796b[r18][r19];
        r19 = r19 + 1;
    L35:
        double[] r20 = this.f20795a;
        int r21 = r18 + 1;
        double r22 = r20[r21];
        if (r24 < r22) goto L37;
        r18 = r21;
        goto L29
    L37:
        double r23 = r20[r18];
        double r25 = r22 - r23;
        double r27 = (r24 - r23) / r25;
    L38:
        if (r12 >= r13) goto L40;
        double[][] r28 = this.f20796b;
        double r110 = r28[r18][r12];
        double r111 = r28[r21][r12];
        double[][] r29 = this.f20797c;
        r26[r12] = (float) l(r25, r27, r110, r111, r29[r18][r12], r29[r21][r12]);
        r12 = r12 + 1;
        goto L38
    L40:
        return;
    L42:
        return;
    L17:
        if (r24 > r10[0]) goto L22;
        int r30 = 0;
    L19:
        if (r30 >= r13) goto L21;
        r26[r30] = (float) this.f20796b[0][r30];
        r30 = r30 + 1;
        goto L19
    L21:
        return;
    L22:
        int r31 = r11 - 1;
        if (r24 < r10[r31]) goto L27;
    L24:
        if (r12 >= r13) goto L26;
        r26[r12] = (float) this.f20796b[r31][r12];
        r12 = r12 + 1;
        goto L24
    }

    @Override // p001j.b
    public double f(double r22, int r24) {
        double[] r10 = this.f20795a;
        int r11 = r10.length;
        int r12 = 0;
        double r13 = r10[0];
        if (r22 < r13) goto L10;
        r13 = r10[r11 - 1];
        if (r22 >= r13) goto L10;
        r13 = r22;
    L10:
        if (r12 >= (r11 - 1)) goto L16;
        double[] r14 = this.f20795a;
        int r15 = r12 + 1;
        double r16 = r14[r15];
        if (r13 <= r16) goto L13;
        r12 = r15;
        goto L10
    L13:
        double r17 = r14[r12];
        double r18 = r16 - r17;
        double r19 = (r13 - r17) / r18;
        double[][] r20 = this.f20796b;
        double r110 = r20[r12][r24];
        double r111 = r20[r15][r24];
        double[][] r21 = this.f20797c;
        return k(r18, r19, r110, r111, r21[r12][r24], r21[r15][r24]) / r18;
    L16:
        return 0.0d;
    }

    @Override // p001j.b
    public void g(double r26, double[] r28) {
        double[] r10 = this.f20795a;
        int r11 = r10.length;
        int r12 = 0;
        int r13 = this.f20796b[0].length;
        double r14 = r10[0];
        if (r26 <= r14) goto L9;
        r14 = r10[r11 - 1];
        if (r26 >= r14) goto L9;
        r14 = r26;
    L9:
        int r15 = 0;
    L11:
        if (r15 >= (r11 - 1)) goto L18;
        double[] r16 = this.f20795a;
        int r17 = r15 + 1;
        double r18 = r16[r17];
        if (r14 <= r18) goto L14;
        r15 = r17;
        goto L11
    L14:
        double r19 = r16[r15];
        double r20 = r18 - r19;
        double r21 = (r14 - r19) / r20;
    L15:
        if (r12 >= r13) goto L22;
        double[][] r22 = this.f20796b;
        double r110 = r22[r15][r12];
        double r111 = r22[r17][r12];
        double[][] r23 = this.f20797c;
        r28[r12] = k(r20, r21, r110, r111, r23[r15][r12], r23[r17][r12]) / r20;
        r12 = r12 + 1;
        goto L15
    L22:
        return;
    }

    @Override // p001j.b
    public double[] h() {
        return this.f20795a;
    }
}
