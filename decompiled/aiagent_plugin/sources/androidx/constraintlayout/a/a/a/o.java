package androidx.constraintlayout.a.a.a;

import java.lang.reflect.Array;
import java.text.DecimalFormat;

/* JADX INFO: compiled from: TimeCycleSplineSet.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class o {
    private static final String TAG = "SplineSet";
    protected static float h = 6.2831855f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected b f669a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected int f670b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected int[] f671c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected float[][] f672d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected int f673e;
    protected String f;
    protected float[] g;
    protected boolean i;
    protected long j;
    protected float k;

    /* JADX INFO: compiled from: TimeCycleSplineSet.java */
    protected static class a {
        static void a(int[] r6, float[][] r7, int r8, int r9) {
            int[] r0 = new int[r6.length + 10];
            r0[0] = r9;
            r0[1] = r8;
            int r10 = 2;
        L3:
            if (r10 <= 0) goto L7;
            int r11 = r10 - 1;
            int r1 = r0[r11];
            r10 = r11 - 1;
            int r2 = r0[r10];
            if (r1 >= r2) goto L3;
            int r3 = b(r6, r7, r1, r2);
            int r4 = r10 + 1;
            r0[r10] = r3 - 1;
            int r12 = r4 + 1;
            r0[r4] = r1;
            int r5 = r12 + 1;
            r0[r12] = r2;
            r10 = r5 + 1;
            r0[r5] = r3 + 1;
            goto L3
        }

        private static int b(int[] r3, float[][] r4, int r5, int r6) {
            int r0 = r3[r6];
            int r1 = r5;
        L3:
            if (r5 >= r6) goto L8;
            if (r3[r5] > r0) goto L7;
            c(r3, r4, r1, r5);
            r1 = r1 + 1;
        L7:
            r5 = r5 + 1;
            goto L3
        L8:
            c(r3, r4, r1, r6);
            return r1;
        }

        private static void c(int[] r2, float[][] r3, int r4, int r5) {
            int r0 = r2[r4];
            r2[r4] = r2[r5];
            r2[r5] = r0;
            float[] r6 = r3[r4];
            r3[r4] = r3[r5];
            r3[r5] = r6;
        }
    }

    static {
    }

    public o() {
        this.f670b = 0;
        this.f671c = new int[10];
        this.f672d = (float[][]) Array.newInstance(float.class, new int[]{10, 3});
        this.g = new float[3];
        this.i = false;
        this.k = Float.NaN;
    }

    public String toString() {
        String r0 = this.f;
        DecimalFormat r1 = new DecimalFormat("##.##");
        int r2 = 0;
    L4:
        if (r2 >= this.f673e) goto L6;
        r0 = r0 + "[" + this.f671c[r2] + " , " + r1.format(this.f672d[r2]) + "] ";
        r2 = r2 + 1;
        goto L4
    L6:
        return r0;
    }

    public void a(String r1) {
        this.f = r1;
    }

    public float a(float r3) {
        switch(this.f670b) {
            case 1: goto L17;
            case 2: goto L15;
            case 3: goto L13;
            case 4: goto L11;
            case 5: goto L9;
            case 6: goto L6;
            default: goto L5;
        };
    L6:
        float r2 = 1.0f - Math.abs(((r3 * 4.0f) % 4.0f) - 2.0f);
        return 1.0f - (r2 * r2);
    L5:
        return (float) Math.sin(r3 * h);
    L9:
        return (float) Math.cos(r3 * h);
    L11:
        return 1.0f - (((r3 * 2.0f) + 1.0f) % 2.0f);
    L13:
        return (((r3 * 2.0f) + 1.0f) % 2.0f) - 1.0f;
    L15:
        return 1.0f - Math.abs(r3);
    L17:
        return Math.signum(r3 * h);
    }

    public void a(long r1) {
        this.j = r1;
    }

    public void a(int r4, float r5, float r6, int r7, float r8) {
        int[] r0 = this.f671c;
        int r1 = this.f673e;
        r0[r1] = r4;
        float[][] r9 = this.f672d;
        r9[r1][0] = r5;
        r9[r1][1] = r6;
        r9[r1][2] = r8;
        this.f670b = Math.max(this.f670b, r7);
        this.f673e++;
    }

    public void a(int r12) {
        int r0 = this.f673e;
        if (r0 != 0) goto L6;
        System.err.println("Error no points added to " + this.f);
        return;
    L6:
        a.a(this.f671c, this.f672d, 0, r0 - 1);
        int r1 = 1;
        int r2 = 0;
    L7:
        int[] r3 = this.f671c;
        if (r1 >= r3.length) goto L13;
        if (r3[r1] == r3[r1 - 1]) goto L12;
        r2 = r2 + 1;
    L12:
        r1 = r1 + 1;
        goto L7
    L13:
        if (r2 != 0) goto L15;
        r2 = 1;
    L15:
        double[] r4 = new double[r2];
        double[][] r5 = (double[][]) Array.newInstance(double.class, new int[]{r2, 3});
        int r6 = 0;
        int r7 = 0;
    L17:
        if (r6 >= this.f673e) goto L24;
        if (r6 <= 0) goto L22;
        int[] r8 = this.f671c;
        if (r8[r6] != r8[r6 - 1]) goto L22;
    L23:
        r6 = r6 + 1;
    L22:
        r4[r7] = ((double) this.f671c[r6]) * 0.01d;
        double[] r9 = r5[r7];
        float[][] r10 = this.f672d;
        r9[0] = r10[r6][0];
        r5[r7][1] = r10[r6][1];
        r5[r7][2] = r10[r6][2];
        r7 = r7 + 1;
        goto L23
    L24:
        this.f669a = b.a(r12, r4, r5);
    }
}
