package androidx.constraintlayout.a.a.a;

import java.lang.reflect.Array;
import java.util.Arrays;

/* JADX INFO: compiled from: StepCurve.java */
/* JADX INFO: loaded from: classes.dex */
public class l extends c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    g f663d;

    l(String r9) {
        this.f616b = r9;
        double[] r0 = new double[this.f616b.length() / 2];
        int r1 = r9.indexOf(40) + 1;
        int r3 = r9.indexOf(44, r1);
        int r4 = 0;
    L4:
        if (r3 == (-1)) goto L6;
        r0[r4] = Double.parseDouble(r9.substring(r1, r3).trim());
        r1 = r3 + 1;
        r3 = r9.indexOf(44, r1);
        r4 = r4 + 1;
        goto L4
    L6:
        String r10 = r9.substring(r1, r9.indexOf(41, r1)).trim();
        r0[r4] = Double.parseDouble(r10);
        this.f663d = a(Arrays.copyOf(r0, r4 + 1));
    }

    private static g a(double[] r18) {
        int r1 = (r18.length * 3) - 2;
        int r3 = r18.length - 1;
        double r5 = 1.0d / ((double) r3);
        double[][] r2 = (double[][]) Array.newInstance(double.class, new int[]{r1, 1});
        double[] r4 = new double[r1];
        int r9 = 0;
    L4:
        if (r9 >= r18.length) goto L9;
        double r10 = r18[r9];
        int r12 = r9 + r3;
        r2[r12][0] = r10;
        double r13 = ((double) r9) * r5;
        r4[r12] = r13;
        if (r9 <= 0) goto L8;
        int r14 = (r3 * 2) + r9;
        r2[r14][0] = r10 + 1.0d;
        r4[r14] = r13 + 1.0d;
        int r15 = r9 - 1;
        r2[r15][0] = (r10 - 1.0d) - r5;
        r4[r15] = (r13 - 1.0d) - r5;
    L8:
        r9 = r9 + 1;
        goto L4
    L9:
        g r0 = new g(r4, r2);
        System.out.println(" 0 " + r0.a(0.0d, 0));
        System.out.println(" 1 " + r0.a(1.0d, 0));
        return r0;
    }

    @Override // androidx.constraintlayout.a.a.a.c
    public double b(double r2) {
        return this.f663d.b(r2, 0);
    }

    @Override // androidx.constraintlayout.a.a.a.c
    public double a(double r2) {
        return this.f663d.a(r2, 0);
    }
}
