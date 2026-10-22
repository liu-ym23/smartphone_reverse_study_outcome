package com.obric.oui.constraintlayout.core.motion.utils;

import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import vc.g;

/* JADX INFO: loaded from: classes4.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public vc.b f13186a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f13187b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f13188c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f13189d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f13190e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f13191f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ArrayList f13192g;

    /* JADX INFO: renamed from: com.obric.oui.constraintlayout.core.motion.utils.a$a, reason: collision with other inner class name */
    public class C0193a implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f13193a;

        public C0193a(a r10) {
            this.f13193a = r10;
        }

        public int a(c r10, c r11) {
            return Integer.compare(r10.f13210a, r11.f13210a);
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(Object r10, Object r11) {
            return a((c) r10, (c) r11);
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f13194a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public g f13195b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f13196c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f13197d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f13198e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public float[] f13199f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public double[] f13200g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public float[] f13201h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public float[] f13202i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public float[] f13203j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public float[] f13204k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f13205l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public vc.b f13206m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public double[] f13207n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public double[] f13208o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public float f13209p;

        public b(int r10, String r11, int r12, int r13) {
            g r14 = new g();
            this.f13195b = r14;
            this.f13196c = 0;
            this.f13197d = 1;
            this.f13198e = 2;
            this.f13205l = r10;
            this.f13194a = r12;
            r14.g(r10, r11);
            this.f13199f = new float[r13];
            this.f13200g = new double[r13];
            this.f13201h = new float[r13];
            this.f13202i = new float[r13];
            this.f13203j = new float[r13];
            this.f13204k = new float[r13];
        }

        public double a(float r14) {
            vc.b r10 = this.f13206m;
            if (r10 == null) goto L5;
            double r11 = r14;
            r10.g(r11, this.f13208o);
            this.f13206m.d(r11, this.f13207n);
        L6:
            double r12 = r14;
            double r13 = this.f13195b.e(r12, this.f13207n[1]);
            double r15 = this.f13195b.d(r12, this.f13207n[1], this.f13208o[1]);
            double[] r16 = this.f13208o;
            return (r16[0] + (r13 * r16[2])) + (r15 * this.f13207n[2]);
        L5:
            double[] r17 = this.f13208o;
            r17[0] = 0.0d;
            r17[1] = 0.0d;
            r17[2] = 0.0d;
            goto L6
        }

        public double b(float r10) {
            vc.b r11 = this.f13206m;
            if (r11 == null) goto L5;
            r11.d(r10, this.f13207n);
        L6:
            double[] r12 = this.f13207n;
            return r12[0] + (this.f13195b.e(r10, r12[1]) * this.f13207n[2]);
        L5:
            double[] r13 = this.f13207n;
            r13[0] = this.f13202i[0];
            r13[1] = this.f13203j[0];
            r13[2] = this.f13199f[0];
            goto L6
        }

        public void c(int r10, int r11, float r12, float r13, float r14, float r15) {
            this.f13200g[r10] = ((double) r11) / 100.0d;
            this.f13201h[r10] = r12;
            this.f13202i[r10] = r13;
            this.f13203j[r10] = r14;
            this.f13199f[r10] = r15;
        }

        public void d(float r10) {
            this.f13209p = r10;
            double[][] r11 = (double[][]) Array.newInstance(Double.TYPE, new int[]{this.f13200g.length, 3});
            float[] r12 = this.f13199f;
            this.f13207n = new double[r12.length + 2];
            this.f13208o = new double[r12.length + 2];
            if (this.f13200g[0] <= 0.0d) goto L5;
            this.f13195b.a(0.0d, this.f13201h[0]);
        L5:
            double[] r13 = this.f13200g;
            int r14 = r13.length - 1;
            if (r13[r14] >= 1.0d) goto L8;
            this.f13195b.a(1.0d, this.f13201h[r14]);
        L8:
            int r15 = 0;
        L10:
            if (r15 >= r11.length) goto L12;
            double[] r16 = r11[r15];
            r16[0] = this.f13202i[r15];
            r16[1] = this.f13203j[r15];
            r16[2] = this.f13199f[r15];
            this.f13195b.a(this.f13200g[r15], this.f13201h[r15]);
            r15 = r15 + 1;
            goto L10
        L12:
            this.f13195b.f();
            double[] r17 = this.f13200g;
            if (r17.length <= 1) goto L15;
            this.f13206m = vc.b.a(0, r17, r11);
            return;
        L15:
            this.f13206m = null;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f13210a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f13211b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f13212c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f13213d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f13214e;

        public c(int r10, float r11, float r12, float r13, float r14) {
            this.f13210a = r10;
            this.f13211b = r14;
            this.f13212c = r12;
            this.f13213d = r11;
            this.f13214e = r13;
        }
    }

    public a() {
        this.f13189d = 0;
        this.f13190e = null;
        this.f13191f = 0;
        this.f13192g = new ArrayList();
    }

    public float a(float r10) {
        return (float) this.f13187b.b(r10);
    }

    public float b(float r10) {
        return (float) this.f13187b.a(r10);
    }

    public void c(Object r10) {
    }

    public void d(int r11, int r12, String r13, int r14, float r15, float r16, float r17, float r18) {
        this.f13192g.add(new c(r11, r15, r16, r17, r18));
        if (r14 == (-1)) goto L5;
        this.f13191f = r14;
    L5:
        this.f13189d = r12;
        this.f13190e = r13;
    }

    public void e(int r11, int r12, String r13, int r14, float r15, float r16, float r17, float r18, Object r19) {
        this.f13192g.add(new c(r11, r15, r16, r17, r18));
        if (r14 == (-1)) goto L5;
        this.f13191f = r14;
    L5:
        this.f13189d = r12;
        c(r19);
        this.f13190e = r13;
    }

    public void f(String r10) {
        this.f13188c = r10;
    }

    public void g(float r18) {
        int r10 = this.f13192g.size();
        if (r10 != 0) goto L5;
        return;
    L5:
        Collections.sort(this.f13192g, new C0193a(this));
        double[] r11 = new double[r10];
        double[][] r12 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r10, 3});
        this.f13187b = new b(this.f13189d, this.f13190e, this.f13191f, r10);
        Iterator r13 = this.f13192g.iterator();
        int r14 = 0;
    L7:
        if (r13.hasNext() == false) goto L9;
        c r15 = (c) r13.next();
        float r16 = r15.f13213d;
        r11[r14] = ((double) r16) * 0.01d;
        double[] r17 = r12[r14];
        float r19 = r15.f13211b;
        r17[0] = r19;
        float r110 = r15.f13212c;
        r17[1] = r110;
        float r111 = r15.f13214e;
        r17[2] = r111;
        this.f13187b.c(r14, r15.f13210a, r16, r110, r111, r19);
        r14 = r14 + 1;
        r12 = r12;
        goto L7
    L9:
        this.f13187b.d(r18);
        this.f13186a = vc.b.a(0, r11, r12);
    }

    public boolean h() {
        if (this.f13191f == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public String toString() {
        String r10 = this.f13188c;
        DecimalFormat r11 = new DecimalFormat("##.##");
        Iterator r12 = this.f13192g.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        c r13 = (c) r12.next();
        r10 = r10 + "[" + r13.f13210a + " , " + r11.format(r13.f13211b) + "] ";
        goto L4
    L6:
        return r10;
    }
}
