package vc;

import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float[] f25170a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public double[] f25171b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public double[] f25172c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f25173d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public f f25174e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f25175f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public double f25176g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f25177h;

    static {
    }

    public g() {
        this.f25170a = new float[0];
        this.f25171b = new double[0];
        this.f25176g = 6.283185307179586d;
        this.f25177h = false;
    }

    public void a(double r10, float r11) {
        int r12 = this.f25170a.length + 1;
        int r13 = Arrays.binarySearch(this.f25171b, r10);
        if (r13 >= 0) goto L5;
        r13 = (-r13) - 1;
    L5:
        this.f25171b = Arrays.copyOf(this.f25171b, r12);
        this.f25170a = Arrays.copyOf(this.f25170a, r12);
        this.f25172c = new double[r12];
        double[] r14 = this.f25171b;
        System.arraycopy(r14, r13, r14, r13 + 1, (r12 - r13) - 1);
        this.f25171b[r13] = r10;
        this.f25170a[r13] = r11;
        this.f25177h = false;
    }

    public double b(double r10) {
        if (r10 > 0.0d) goto L6;
        return 0.0d;
    L6:
        if (r10 < 1.0d) goto L8;
        return 1.0d;
    L8:
        int r11 = Arrays.binarySearch(this.f25171b, r10);
        if (r11 >= 0) goto L11;
        r11 = (-r11) - 1;
    L11:
        float[] r12 = this.f25170a;
        float r13 = r12[r11];
        int r14 = r11 - 1;
        float r15 = r12[r14];
        double r16 = r13 - r15;
        double[] r17 = this.f25171b;
        double r18 = r17[r11];
        double r19 = r17[r14];
        double r20 = r16 / (r18 - r19);
        return (r10 * r20) + (((double) r15) - (r20 * r19));
    }

    public double c(double r11) {
        if (r11 > 0.0d) goto L6;
        return 0.0d;
    L6:
        if (r11 < 1.0d) goto L8;
        return 1.0d;
    L8:
        int r10 = Arrays.binarySearch(this.f25171b, r11);
        if (r10 >= 0) goto L11;
        r10 = (-r10) - 1;
    L11:
        float[] r12 = this.f25170a;
        float r13 = r12[r10];
        int r14 = r10 - 1;
        float r15 = r12[r14];
        double r16 = r13 - r15;
        double[] r17 = this.f25171b;
        double r18 = r17[r10];
        double r19 = r17[r14];
        double r20 = r16 / (r18 - r19);
        return (this.f25172c[r14] + ((((double) r15) - (r20 * r19)) * (r11 - r19))) + ((r20 * ((r11 * r11) - (r19 * r19))) / 2.0d);
    }

    public double d(double r10, double r11, double r12) {
        double r13 = r11 + c(r10);
        double r14 = b(r10) + r12;
        switch(this.f25175f) {
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L13;
            case 5: goto L10;
            case 6: goto L9;
            case 7: goto L8;
            default: goto L4;
        };
    L4:
        double r15 = this.f25176g;
        double r16 = r14 * r15;
        double r17 = Math.cos(r15 * r13);
    L6:
        return r16 * r17;
    L9:
        r16 = r14 * 4.0d;
        r17 = (((r13 * 4.0d) + 2.0d) % 4.0d) - 2.0d;
        goto L6
    L10:
        double r18 = this.f25176g;
        return ((-r18) * r14) * Math.sin(r18 * r13);
    L16:
        r16 = r14 * 4.0d;
        r17 = Math.signum((((r13 * 4.0d) + 3.0d) % 4.0d) - 2.0d);
        goto L6
    L17:
        return 0.0d;
    L8:
        return this.f25174e.f(r13 % 1.0d, 0);
    L13:
        return (-r14) * 2.0d;
    L15:
        return r14 * 2.0d;
    }

    public double e(double r10, double r11) {
        double r12 = c(r10) + r11;
        switch(this.f25175f) {
            case 1: goto L19;
            case 2: goto L17;
            case 3: goto L15;
            case 4: goto L13;
            case 5: goto L11;
            case 6: goto L8;
            case 7: goto L7;
            default: goto L5;
        };
    L8:
        double r13 = 1.0d - Math.abs(((r12 * 4.0d) % 4.0d) - 2.0d);
        return 1.0d - (r13 * r13);
    L5:
        return Math.sin(this.f25176g * r12);
    L7:
        return this.f25174e.c(r12 % 1.0d, 0);
    L11:
        return Math.cos(this.f25176g * (r11 + r12));
    L13:
        return 1.0d - (((r12 * 2.0d) + 1.0d) % 2.0d);
    L15:
        return (((r12 * 2.0d) + 1.0d) % 2.0d) - 1.0d;
    L17:
        return 1.0d - Math.abs((((r12 * 4.0d) + 1.0d) % 4.0d) - 2.0d);
    L19:
        return Math.signum(0.5d - (r12 % 1.0d));
    }

    public void f() {
        double r10 = 0.0d;
        int r11 = 0;
    L3:
        float[] r12 = this.f25170a;
        if (r11 >= r12.length) goto L6;
        r10 = r10 + ((double) r12[r11]);
        r11 = r11 + 1;
        goto L3
    L6:
        double r13 = 0.0d;
        int r14 = 1;
    L7:
        float[] r15 = this.f25170a;
        if (r14 >= r15.length) goto L10;
        int r16 = r14 - 1;
        float r17 = (r15[r16] + r15[r14]) / 2.0f;
        double[] r18 = this.f25171b;
        r13 = r13 + ((r18[r14] - r18[r16]) * ((double) r17));
        r14 = r14 + 1;
        goto L7
    L10:
        int r19 = 0;
    L11:
        float[] r20 = this.f25170a;
        if (r19 >= r20.length) goto L14;
        r20[r19] = r20[r19] * ((float) (r10 / r13));
        r19 = r19 + 1;
        goto L11
    L14:
        this.f25172c[0] = 0.0d;
        int r21 = 1;
    L15:
        float[] r22 = this.f25170a;
        if (r21 >= r22.length) goto L18;
        int r23 = r21 - 1;
        float r24 = (r22[r23] + r22[r21]) / 2.0f;
        double[] r25 = this.f25171b;
        double r26 = r25[r21] - r25[r23];
        double[] r27 = this.f25172c;
        r27[r21] = r27[r23] + (r26 * ((double) r24));
        r21 = r21 + 1;
        goto L15
    L18:
        this.f25177h = true;
    }

    public void g(int r10, String r11) {
        this.f25175f = r10;
        this.f25173d = r11;
        if (r11 == null) goto L6;
        this.f25174e = f.i(r11);
        return;
    }

    public String toString() {
        return "pos =" + Arrays.toString(this.f25171b) + " period=" + Arrays.toString(this.f25170a);
    }
}
