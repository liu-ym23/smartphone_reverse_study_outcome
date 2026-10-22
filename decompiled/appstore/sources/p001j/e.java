package p001j;

/* JADX INFO: loaded from: classes.dex */
public class e extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public double[] f20790a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public double[][] f20791b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public double f20792c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f20793d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public double[] f20794e;

    public e(double[] r11, double[][] r12) {
        this.f20792c = Double.NaN;
        this.f20793d = true;
        int r10 = r11.length;
        int r13 = r12[0].length;
        this.f20794e = new double[r13];
        this.f20790a = r11;
        this.f20791b = r12;
        if (r13 <= 2) goto L16;
        int r14 = 0;
        double r15 = 0.0d;
    L5:
        double r16 = r15;
        if (r14 >= r11.length) goto L11;
        double r17 = r12[r14][0];
        if (r14 <= 0) goto L10;
        Math.hypot(r17 - r15, r17 - r16);
    L10:
        r14 = r14 + 1;
        r15 = r17;
        goto L5
    L11:
        this.f20792c = 0.0d;
        return;
    }

    @Override // p001j.b
    public double c(double r10, int r11) {
        double[] r12 = this.f20790a;
        int r13 = r12.length;
        int r14 = 0;
        if (this.f20793d == false) goto L13;
        double r15 = r12[0];
        if (r10 <= r15) goto L7;
        int r16 = r13 - 1;
        double r17 = r12[r16];
        if (r10 < r17) goto L21;
        return this.f20791b[r16][r11] + ((r10 - r17) * f(r17, r11));
    L21:
        if (r14 >= (r13 - 1)) goto L31;
        double[] r18 = this.f20790a;
        double r19 = r18[r14];
        if (r10 == r19) goto L25;
        int r20 = r14 + 1;
        double r21 = r18[r20];
        if (r10 < r21) goto L28;
        r14 = r20;
        goto L21
    L28:
        double r22 = (r10 - r19) / (r21 - r19);
        double[][] r23 = this.f20791b;
        return (r23[r14][r11] * (1.0d - r22)) + (r23[r20][r11] * r22);
    L25:
        return this.f20791b[r14][r11];
    L31:
        return 0.0d;
    L7:
        return this.f20791b[0][r11] + ((r10 - r15) * f(r15, r11));
    L13:
        if (r10 <= r12[0]) goto L15;
        int r24 = r13 - 1;
        if (r10 < r12[r24]) goto L21;
        return this.f20791b[r24][r11];
    L15:
        return this.f20791b[0][r11];
    }

    @Override // p001j.b
    public void d(double r13, double[] r15) {
        double[] r10 = this.f20790a;
        int r11 = r10.length;
        int r12 = 0;
        int r14 = this.f20791b[0].length;
        if (this.f20793d == false) goto L17;
        double r16 = r10[0];
        if (r13 > r16) goto L10;
        g(r16, this.f20794e);
        int r17 = 0;
    L7:
        if (r17 >= r14) goto L9;
        r15[r17] = this.f20791b[0][r17] + ((r13 - this.f20790a[0]) * this.f20794e[r17]);
        r17 = r17 + 1;
        goto L7
    L9:
        return;
    L10:
        int r18 = r11 - 1;
        double r19 = r10[r18];
        if (r13 < r19) goto L27;
        g(r19, this.f20794e);
    L13:
        if (r12 >= r14) goto L15;
        r15[r12] = this.f20791b[r18][r12] + ((r13 - this.f20790a[r18]) * this.f20794e[r12]);
        r12 = r12 + 1;
        goto L13
    L15:
        return;
    L27:
        int r20 = 0;
    L29:
        if (r20 >= (r11 - 1)) goto L42;
        if (r13 != this.f20790a[r20]) goto L35;
        int r21 = 0;
    L33:
        if (r21 >= r14) goto L35;
        r15[r21] = this.f20791b[r20][r21];
        r21 = r21 + 1;
    L35:
        double[] r22 = this.f20790a;
        int r23 = r20 + 1;
        double r24 = r22[r23];
        if (r13 < r24) goto L37;
        r20 = r23;
        goto L29
    L37:
        double r25 = r22[r20];
        double r110 = (r13 - r25) / (r24 - r25);
    L38:
        if (r12 >= r14) goto L40;
        double[][] r26 = this.f20791b;
        r15[r12] = (r26[r20][r12] * (1.0d - r110)) + (r26[r23][r12] * r110);
        r12 = r12 + 1;
        goto L38
    L40:
        return;
    L42:
        return;
    L17:
        if (r13 > r10[0]) goto L22;
        int r111 = 0;
    L19:
        if (r111 >= r14) goto L21;
        r15[r111] = this.f20791b[0][r111];
        r111 = r111 + 1;
        goto L19
    L21:
        return;
    L22:
        int r27 = r11 - 1;
        if (r13 < r10[r27]) goto L27;
    L24:
        if (r12 >= r14) goto L26;
        r15[r12] = this.f20791b[r27][r12];
        r12 = r12 + 1;
        goto L24
    }

    @Override // p001j.b
    public void e(double r13, float[] r15) {
        double[] r10 = this.f20790a;
        int r11 = r10.length;
        int r12 = 0;
        int r14 = this.f20791b[0].length;
        if (this.f20793d == false) goto L17;
        double r16 = r10[0];
        if (r13 > r16) goto L10;
        g(r16, this.f20794e);
        int r17 = 0;
    L7:
        if (r17 >= r14) goto L9;
        r15[r17] = (float) (this.f20791b[0][r17] + ((r13 - this.f20790a[0]) * this.f20794e[r17]));
        r17 = r17 + 1;
        goto L7
    L9:
        return;
    L10:
        int r18 = r11 - 1;
        double r19 = r10[r18];
        if (r13 < r19) goto L27;
        g(r19, this.f20794e);
    L13:
        if (r12 >= r14) goto L15;
        r15[r12] = (float) (this.f20791b[r18][r12] + ((r13 - this.f20790a[r18]) * this.f20794e[r12]));
        r12 = r12 + 1;
        goto L13
    L15:
        return;
    L27:
        int r20 = 0;
    L29:
        if (r20 >= (r11 - 1)) goto L42;
        if (r13 != this.f20790a[r20]) goto L35;
        int r21 = 0;
    L33:
        if (r21 >= r14) goto L35;
        r15[r21] = (float) this.f20791b[r20][r21];
        r21 = r21 + 1;
    L35:
        double[] r22 = this.f20790a;
        int r23 = r20 + 1;
        double r24 = r22[r23];
        if (r13 < r24) goto L37;
        r20 = r23;
        goto L29
    L37:
        double r25 = r22[r20];
        double r110 = (r13 - r25) / (r24 - r25);
    L38:
        if (r12 >= r14) goto L40;
        double[][] r26 = this.f20791b;
        r15[r12] = (float) ((r26[r20][r12] * (1.0d - r110)) + (r26[r23][r12] * r110));
        r12 = r12 + 1;
        goto L38
    L40:
        return;
    L42:
        return;
    L17:
        if (r13 > r10[0]) goto L22;
        int r111 = 0;
    L19:
        if (r111 >= r14) goto L21;
        r15[r111] = (float) this.f20791b[0][r111];
        r111 = r111 + 1;
        goto L19
    L21:
        return;
    L22:
        int r27 = r11 - 1;
        if (r13 < r10[r27]) goto L27;
    L24:
        if (r12 >= r14) goto L26;
        r15[r12] = (float) this.f20791b[r27][r12];
        r12 = r12 + 1;
        goto L24
    }

    @Override // p001j.b
    public double f(double r10, int r11) {
        double[] r12 = this.f20790a;
        int r13 = r12.length;
        int r14 = 0;
        double r15 = r12[0];
        if (r10 >= r15) goto L5;
    L4:
        r10 = r15;
    L9:
        if (r14 >= (r13 - 1)) goto L15;
        double[] r16 = this.f20790a;
        int r17 = r14 + 1;
        double r18 = r16[r17];
        if (r10 <= r18) goto L12;
        r14 = r17;
        goto L9
    L12:
        double r19 = r18 - r16[r14];
        double[][] r20 = this.f20791b;
        return (r20[r17][r11] - r20[r14][r11]) / r19;
    L15:
        return 0.0d;
    L5:
        r15 = r12[r13 - 1];
        if (r10 < r15) goto L9;
        goto L4
    }

    @Override // p001j.b
    public void g(double r11, double[] r13) {
        double[] r10 = this.f20790a;
        int r12 = r10.length;
        int r14 = 0;
        int r15 = this.f20791b[0].length;
        double r16 = r10[0];
        if (r11 > r16) goto L5;
    L4:
        r11 = r16;
    L8:
        int r17 = 0;
    L10:
        if (r17 >= (r12 - 1)) goto L17;
        double[] r18 = this.f20790a;
        int r19 = r17 + 1;
        double r20 = r18[r19];
        if (r11 <= r20) goto L13;
        r17 = r19;
        goto L10
    L13:
        double r21 = r20 - r18[r17];
    L14:
        if (r14 >= r15) goto L21;
        double[][] r110 = this.f20791b;
        r13[r14] = (r110[r19][r14] - r110[r17][r14]) / r21;
        r14 = r14 + 1;
        goto L14
    L21:
        return;
    L17:
        return;
    L5:
        r16 = r10[r12 - 1];
        if (r11 < r16) goto L8;
        goto L8
    }

    @Override // p001j.b
    public double[] h() {
        return this.f20790a;
    }
}
