package vc;

import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public class j extends c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public f f25191d;

    public j(String r10) {
        this.f25152a = r10;
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
        this.f25191d = d(Arrays.copyOf(r11, r14 + 1));
    }

    public static f d(double[] r18) {
        int r10 = (r18.length * 3) - 2;
        int r11 = r18.length - 1;
        double r12 = 1.0d / ((double) r11);
        double[][] r13 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r10, 1});
        double[] r14 = new double[r10];
        int r15 = 0;
    L4:
        if (r15 >= r18.length) goto L9;
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
    L9:
        f r20 = new f(r14, r13);
        PrintStream r21 = System.out;
        r21.println(" 0 " + r20.c(0.0d, 0));
        r21.println(" 1 " + r20.c(1.0d, 0));
        return r20;
    }

    @Override // vc.c
    public double a(double r10) {
        return this.f25191d.c(r10, 0);
    }

    @Override // vc.c
    public double b(double r10) {
        return this.f25191d.f(r10, 0);
    }
}
