package p001j;

import java.lang.reflect.Array;
import java.text.DecimalFormat;

/* JADX INFO: loaded from: classes.dex */
public abstract class l {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static float f20837k = 6.2831855f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f20838a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f20839b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int[] f20840c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float[][] f20841d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f20842e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f20843f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float[] f20844g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f20845h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f20846i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f20847j;

    public static class a {
        public static void a(int[] r10, float[][] r11, int r12, int r13) {
            int[] r14 = new int[r10.length + 10];
            r14[0] = r13;
            r14[1] = r12;
            int r15 = 2;
        L3:
            if (r15 <= 0) goto L8;
            int r16 = r14[r15 - 1];
            int r17 = r15 - 2;
            int r18 = r14[r17];
            if (r16 < r18) goto L6;
            r15 = r17;
            goto L3
        L6:
            int r19 = b(r10, r11, r16, r18);
            r14[r17] = r19 - 1;
            r14[r15 - 1] = r16;
            int r20 = r15 + 1;
            r14[r15] = r18;
            r15 = r15 + 2;
            r14[r20] = r19 + 1;
            goto L3
        }

        public static int b(int[] r10, float[][] r11, int r12, int r13) {
            int r14 = r10[r13];
            int r15 = r12;
        L3:
            if (r12 >= r13) goto L8;
            if (r10[r12] > r14) goto L7;
            c(r10, r11, r15, r12);
            r15 = r15 + 1;
        L7:
            r12 = r12 + 1;
            goto L3
        L8:
            c(r10, r11, r15, r13);
            return r15;
        }

        public static void c(int[] r10, float[][] r11, int r12, int r13) {
            int r14 = r10[r12];
            r10[r12] = r10[r13];
            r10[r13] = r14;
            float[] r15 = r11[r12];
            r11[r12] = r11[r13];
            r11[r13] = r15;
        }
    }

    static {
    }

    public l() {
        this.f20839b = 0;
        this.f20840c = new int[10];
        this.f20841d = (float[][]) Array.newInstance(Float.TYPE, new int[]{10, 3});
        this.f20844g = new float[3];
        this.f20845h = false;
        this.f20847j = Float.NaN;
    }

    public float a(float r10) {
        switch(this.f20839b) {
            case 1: goto L17;
            case 2: goto L15;
            case 3: goto L13;
            case 4: goto L11;
            case 5: goto L9;
            case 6: goto L6;
            default: goto L5;
        };
    L6:
        float r11 = 1.0f - Math.abs(((r10 * 4.0f) % 4.0f) - 2.0f);
        return 1.0f - (r11 * r11);
    L5:
        return (float) Math.sin(r10 * f20837k);
    L9:
        return (float) Math.cos(r10 * f20837k);
    L11:
        return 1.0f - (((r10 * 2.0f) + 1.0f) % 2.0f);
    L13:
        return (((r10 * 2.0f) + 1.0f) % 2.0f) - 1.0f;
    L15:
        return 1.0f - Math.abs(r10);
    L17:
        return Math.signum(r10 * f20837k);
    }

    public void b(long r10) {
        this.f20846i = r10;
    }

    public void c(String r10) {
        this.f20843f = r10;
    }

    public void d(int r12) {
        int r10 = this.f20842e;
        if (r10 != 0) goto L6;
        System.err.println("Error no points added to " + this.f20843f);
        return;
    L6:
        a.a(this.f20840c, this.f20841d, 0, r10 - 1);
        int r11 = 1;
        int r13 = 0;
    L7:
        int[] r14 = this.f20840c;
        if (r11 >= r14.length) goto L13;
        if (r14[r11] == r14[r11 - 1]) goto L12;
        r13 = r13 + 1;
    L12:
        r11 = r11 + 1;
        goto L7
    L13:
        if (r13 != 0) goto L15;
        r13 = 1;
    L15:
        double[] r15 = new double[r13];
        double[][] r16 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r13, 3});
        int r17 = 0;
        int r18 = 0;
    L17:
        if (r17 >= this.f20842e) goto L24;
        if (r17 <= 0) goto L22;
        int[] r19 = this.f20840c;
        if (r19[r17] != r19[r17 - 1]) goto L22;
    L23:
        r17 = r17 + 1;
    L22:
        r15[r18] = ((double) this.f20840c[r17]) * 0.01d;
        double[] r20 = r16[r18];
        float[] r21 = this.f20841d[r17];
        r20[0] = r21[0];
        r20[1] = r21[1];
        r20[2] = r21[2];
        r18 = r18 + 1;
        goto L23
    L24:
        this.f20838a = b.a(r12, r15, r16);
    }

    public String toString() {
        String r10 = this.f20843f;
        DecimalFormat r11 = new DecimalFormat("##.##");
        int r12 = 0;
    L4:
        if (r12 >= this.f20842e) goto L6;
        r10 = r10 + "[" + this.f20840c[r12] + " , " + r11.format(this.f20841d[r12]) + "] ";
        r12 = r12 + 1;
        goto L4
    L6:
        return r10;
    }
}
