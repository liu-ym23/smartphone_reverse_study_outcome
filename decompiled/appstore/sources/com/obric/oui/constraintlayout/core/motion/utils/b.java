package com.obric.oui.constraintlayout.core.motion.utils;

import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public vc.b f13215a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int[] f13216b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float[] f13217c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f13218d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f13219e;

    public static class a {
        public static void a(int[] r10, float[] r11, int r12, int r13) {
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

        public static int b(int[] r10, float[] r11, int r12, int r13) {
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

        public static void c(int[] r10, float[] r11, int r12, int r13) {
            int r14 = r10[r12];
            r10[r12] = r10[r13];
            r10[r13] = r14;
            float r15 = r11[r12];
            r11[r12] = r11[r13];
            r11[r13] = r15;
        }
    }

    public b() {
        this.f13216b = new int[10];
        this.f13217c = new float[10];
    }

    public float a(float r10) {
        return (float) this.f13215a.c(r10, 0);
    }

    public float b(float r10) {
        return (float) this.f13215a.f(r10, 0);
    }

    public void c(int r10, float r11) {
        int[] r12 = this.f13216b;
        if (r12.length >= (this.f13218d + 1)) goto L5;
        this.f13216b = Arrays.copyOf(r12, r12.length * 2);
        float[] r13 = this.f13217c;
        this.f13217c = Arrays.copyOf(r13, r13.length * 2);
    L5:
        int[] r14 = this.f13216b;
        int r15 = this.f13218d;
        r14[r15] = r10;
        this.f13217c[r15] = r11;
        this.f13218d = r15 + 1;
    }

    public void d(String r10) {
        this.f13219e = r10;
    }

    public void e(int r10) {
        int r11 = this.f13218d;
        if (r11 != 0) goto L5;
        return;
    L5:
        a.a(this.f13216b, this.f13217c, 0, r11 - 1);
        int r12 = 1;
        int r13 = 1;
    L7:
        if (r12 >= this.f13218d) goto L12;
        int[] r14 = this.f13216b;
        if (r14[r12 - 1] == r14[r12]) goto L11;
        r13 = r13 + 1;
    L11:
        r12 = r12 + 1;
        goto L7
    L12:
        double[] r15 = new double[r13];
        double[][] r16 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r13, 1});
        int r17 = 0;
        int r18 = 0;
    L14:
        if (r17 >= this.f13218d) goto L21;
        if (r17 <= 0) goto L19;
        int[] r19 = this.f13216b;
        if (r19[r17] != r19[r17 - 1]) goto L19;
    L20:
        r17 = r17 + 1;
    L19:
        r15[r18] = ((double) this.f13216b[r17]) * 0.01d;
        r16[r18][0] = this.f13217c[r17];
        r18 = r18 + 1;
        goto L20
    L21:
        this.f13215a = vc.b.a(r10, r15, r16);
    }

    public String toString() {
        String r10 = this.f13219e;
        DecimalFormat r11 = new DecimalFormat("##.##");
        int r12 = 0;
    L4:
        if (r12 >= this.f13218d) goto L6;
        r10 = r10 + "[" + this.f13216b[r12] + " , " + r11.format(this.f13217c[r12]) + "] ";
        r12 = r12 + 1;
        goto L4
    L6:
        return r10;
    }
}
