package p001j;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float[] f20800a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public double[] f20801b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public double[] f20802c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f20803d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public f f20804e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f20805f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public double f20806g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f20807h;

    static {
    }

    public g() {
        this.f20800a = new float[0];
        this.f20801b = new double[0];
        this.f20806g = 6.283185307179586d;
        this.f20807h = false;
    }

    public void a(double r10, float r11) {
        int r12 = this.f20800a.length + 1;
        int r13 = Arrays.binarySearch(this.f20801b, r10);
        if (r13 >= 0) goto L5;
        r13 = (-r13) - 1;
    L5:
        this.f20801b = Arrays.copyOf(this.f20801b, r12);
        this.f20800a = Arrays.copyOf(this.f20800a, r12);
        this.f20802c = new double[r12];
        double[] r14 = this.f20801b;
        System.arraycopy(r14, r13, r14, r13 + 1, (r12 - r13) - 1);
        this.f20801b[r13] = r10;
        this.f20800a[r13] = r11;
        this.f20807h = false;
    }

    public double b(double r10) {
        if (r10 > 0.0d) goto L6;
        r10 = 1.0E-5d;
    L8:
        int r11 = Arrays.binarySearch(this.f20801b, r10);
        if (r11 <= 0) goto L11;
        return 0.0d;
    L11:
        if (r11 == 0) goto L14;
        int r12 = -r11;
        int r13 = r12 - 1;
        float[] r14 = this.f20800a;
        float r15 = r14[r13];
        int r16 = r12 - 2;
        float r17 = r14[r16];
        double[] r18 = this.f20801b;
        double r19 = r18[r13];
        double r20 = r18[r16];
        double r21 = ((double) (r15 - r17)) / (r19 - r20);
        return (r10 * r21) + (((double) r17) - (r21 * r20));
    L14:
        return 0.0d;
    L6:
        if (r10 < 1.0d) goto L8;
        r10 = 0.999999d;
        goto L8
    }

    public double c(double r13) {
        if (r13 >= 0.0d) goto L6;
        r13 = 0.0d;
    L8:
        int r10 = Arrays.binarySearch(this.f20801b, r13);
        if (r10 > 0) goto L14;
        if (r10 == 0) goto L15;
        int r11 = -r10;
        int r12 = r11 - 1;
        float[] r14 = this.f20800a;
        float r15 = r14[r12];
        int r16 = r11 - 2;
        float r17 = r14[r16];
        double[] r18 = this.f20801b;
        double r19 = r18[r12];
        double r20 = r18[r16];
        double r21 = ((double) (r15 - r17)) / (r19 - r20);
        return (this.f20802c[r16] + ((((double) r17) - (r21 * r20)) * (r13 - r20))) + ((r21 * ((r13 * r13) - (r20 * r20))) / 2.0d);
    L15:
        return 0.0d;
    L14:
        return 1.0d;
    L6:
        if (r13 <= 1.0d) goto L8;
        r13 = 1.0d;
        goto L8
    }

    public double d(double r10, double r11, double r12) {
        double r13 = r11 + c(r10);
        double r14 = b(r10) + r12;
        switch(this.f20805f) {
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
        double r15 = this.f20806g;
        double r16 = r14 * r15;
        double r17 = Math.cos(r15 * r13);
    L6:
        return r16 * r17;
    L9:
        r16 = r14 * 4.0d;
        r17 = (((r13 * 4.0d) + 2.0d) % 4.0d) - 2.0d;
        goto L6
    L10:
        double r18 = this.f20806g;
        return ((-r18) * r14) * Math.sin(r18 * r13);
    L16:
        r16 = r14 * 4.0d;
        r17 = Math.signum((((r13 * 4.0d) + 3.0d) % 4.0d) - 2.0d);
        goto L6
    L17:
        return 0.0d;
    L8:
        return this.f20804e.f(r13 % 1.0d, 0);
    L13:
        return (-r14) * 2.0d;
    L15:
        return r14 * 2.0d;
    }

    public double e(double r10, double r11) {
        double r12 = c(r10) + r11;
        switch(this.f20805f) {
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
        return Math.sin(this.f20806g * r12);
    L7:
        return this.f20804e.c(r12 % 1.0d, 0);
    L11:
        return Math.cos(this.f20806g * (r11 + r12));
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
        float[] r12 = this.f20800a;
        if (r11 >= r12.length) goto L6;
        r10 = r10 + ((double) r12[r11]);
        r11 = r11 + 1;
        goto L3
    L6:
        double r13 = 0.0d;
        int r14 = 1;
    L7:
        float[] r15 = this.f20800a;
        if (r14 >= r15.length) goto L10;
        int r16 = r14 - 1;
        float r17 = (r15[r16] + r15[r14]) / 2.0f;
        double[] r18 = this.f20801b;
        r13 = r13 + ((r18[r14] - r18[r16]) * ((double) r17));
        r14 = r14 + 1;
        goto L7
    L10:
        int r19 = 0;
    L11:
        float[] r110 = this.f20800a;
        if (r19 >= r110.length) goto L14;
        r110[r19] = (float) (((double) r110[r19]) * (r10 / r13));
        r19 = r19 + 1;
        goto L11
    L14:
        this.f20802c[0] = 0.0d;
        int r20 = 1;
    L15:
        float[] r21 = this.f20800a;
        if (r20 >= r21.length) goto L18;
        int r22 = r20 - 1;
        float r23 = (r21[r22] + r21[r20]) / 2.0f;
        double[] r24 = this.f20801b;
        double r25 = r24[r20] - r24[r22];
        double[] r26 = this.f20802c;
        r26[r20] = r26[r22] + (r25 * ((double) r23));
        r20 = r20 + 1;
        goto L15
    L18:
        this.f20807h = true;
    }

    public void g(int r10, String r11) {
        this.f20805f = r10;
        this.f20803d = r11;
        if (r11 == null) goto L6;
        this.f20804e = f.i(r11);
        return;
    }

    public String toString() {
        return "pos =" + Arrays.toString(this.f20801b) + " period=" + Arrays.toString(this.f20800a);
    }
}
