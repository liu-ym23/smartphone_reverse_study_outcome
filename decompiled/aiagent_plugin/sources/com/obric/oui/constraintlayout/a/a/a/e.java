package com.obric.oui.constraintlayout.a.a.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: compiled from: KeyCycleOscillator.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class e {
    private static final String TAG = "KeyCycleOscillator";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f34597a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    ArrayList<b> f34598b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.obric.oui.constraintlayout.a.a.a.b f34599c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private a f34600d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f34601e;
    private int f;
    private String g;

    /* JADX INFO: compiled from: KeyCycleOscillator.java */
    static class a {
        private static final String TAG = "CycleOscillator";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        h f34603a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        float[] f34604b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        double[] f34605c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        float[] f34606d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        float[] f34607e;
        float[] f;
        float[] g;
        int h;
        com.obric.oui.constraintlayout.a.a.a.b i;
        double[] j;
        double[] k;
        float l;
        private final int m;
        private final int n;
        private final int o;
        private final int p;

        a(int r3, String r4, int r5, int r6) {
            h r0 = new h();
            this.f34603a = r0;
            this.n = 0;
            this.o = 1;
            this.p = 2;
            this.h = r3;
            this.m = r5;
            r0.a(r3, r4);
            this.f34604b = new float[r6];
            this.f34605c = new double[r6];
            this.f34606d = new float[r6];
            this.f34607e = new float[r6];
            this.f = new float[r6];
            this.g = new float[r6];
        }

        public double a(float r10) {
            com.obric.oui.constraintlayout.a.a.a.b r0 = this.i;
            if (r0 == null) goto L5;
            r0.a(r10, this.j);
        L6:
            double[] r1 = this.j;
            double r3 = r1[0];
            Objects.requireNonNull(this);
            return r3 + (this.f34603a.a(r10, r1[1]) * this.j[2]);
        L5:
            double[] r2 = this.j;
            r2[0] = this.f34607e[0];
            r2[1] = this.f[0];
            r2[2] = this.f34604b[0];
            goto L6
        }

        public double b(float r14) {
            com.obric.oui.constraintlayout.a.a.a.b r0 = this.i;
            if (r0 == null) goto L5;
            double r4 = r14;
            r0.b(r4, this.k);
            this.i.a(r4, this.j);
        L6:
            double r5 = r14;
            double r11 = this.f34603a.a(r5, this.j[1]);
            double r3 = this.f34603a.a(r5, this.j[1], this.k[1]);
            double[] r15 = this.k;
            return (r15[0] + (r11 * r15[2])) + (r3 * this.j[2]);
        L5:
            double[] r1 = this.k;
            r1[0] = 0.0d;
            r1[1] = 0.0d;
            r1[2] = 0.0d;
            goto L6
        }

        public void a(int r6, int r7, float r8, float r9, float r10, float r11) {
            this.f34605c[r6] = ((double) r7) / 100.0d;
            this.f34606d[r6] = r8;
            this.f34607e[r6] = r9;
            this.f[r6] = r10;
            this.f34604b[r6] = r11;
        }

        public void c(float r10) {
            this.l = r10;
            double[][] r11 = (double[][]) Array.newInstance(double.class, new int[]{this.f34605c.length, 3});
            float[] r1 = this.f34604b;
            this.j = new double[r1.length + 2];
            this.k = new double[r1.length + 2];
            if (this.f34605c[0] <= 0.0d) goto L5;
            this.f34603a.a(0.0d, this.f34606d[0]);
        L5:
            double[] r2 = this.f34605c;
            int r4 = r2.length - 1;
            if (r2[r4] >= 1.0d) goto L8;
            this.f34603a.a(1.0d, this.f34606d[r4]);
        L8:
            int r3 = 0;
        L10:
            if (r3 >= r11.length) goto L12;
            r11[r3][0] = this.f34607e[r3];
            r11[r3][1] = this.f[r3];
            r11[r3][2] = this.f34604b[r3];
            this.f34603a.a(this.f34605c[r3], this.f34606d[r3]);
            r3 = r3 + 1;
            goto L10
        L12:
            this.f34603a.a();
            double[] r0 = this.f34605c;
            if (r0.length <= 1) goto L15;
            this.i = com.obric.oui.constraintlayout.a.a.a.b.a(0, r0, r11);
            return;
        L15:
            this.i = null;
        }
    }

    /* JADX INFO: compiled from: KeyCycleOscillator.java */
    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f34608a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        float f34609b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        float f34610c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        float f34611d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        float f34612e;

        b(int r1, float r2, float r3, float r4, float r5) {
            this.f34608a = r1;
            this.f34609b = r5;
            this.f34610c = r3;
            this.f34611d = r2;
            this.f34612e = r4;
        }
    }

    public void a(Object r1) {
    }

    public e() {
        this.f = 0;
        this.g = null;
        this.f34597a = 0;
        this.f34598b = new ArrayList();
    }

    public boolean a() {
        if (this.f34597a == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public String toString() {
        String r0 = this.f34601e;
        DecimalFormat r1 = new DecimalFormat("##.##");
        Iterator<b> r5 = this.f34598b.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        b r2 = (b) ZeusTransformUtils.preCheckCast(r5.next(), b.class, "com.obric.aiagent.plugin");
        r0 = r0 + "[" + r2.f34608a + " , " + r1.format(r2.f34609b) + "] ";
        goto L4
    L6:
        return r0;
    }

    public void a(String r1) {
        this.f34601e = r1;
    }

    public float a(float r1) {
        return (float) this.f34600d.a(r1);
    }

    public float b(float r1) {
        return (float) this.f34600d.b(r1);
    }

    public void a(int r11, int r12, String r13, int r14, float r15, float r16, float r17, float r18, Object r19) {
        this.f34598b.add(new b(r11, r15, r16, r17, r18));
        if (r14 == (-1)) goto L5;
        this.f34597a = r14;
    L5:
        this.f = r12;
        a(r19);
        this.g = r13;
    }

    public void a(int r11, int r12, String r13, int r14, float r15, float r16, float r17, float r18) {
        this.f34598b.add(new b(r11, r15, r16, r17, r18));
        if (r14 == (-1)) goto L5;
        this.f34597a = r14;
    L5:
        this.f = r12;
        this.g = r13;
    }

    public void c(float r15) {
        int r0 = this.f34598b.size();
        if (r0 != 0) goto L5;
        return;
    L5:
        Collections.sort(this.f34598b, new AnonymousClass1(this));
        double[] r1 = new double[r0];
        double[][] r4 = (double[][]) Array.newInstance(double.class, new int[]{r0, 3});
        this.f34600d = new a(this.f, this.g, this.f34597a, r0);
        Iterator<b> r2 = this.f34598b.iterator();
        int r13 = 0;
    L7:
        if (r2.hasNext() == false) goto L9;
        b r6 = (b) ZeusTransformUtils.preCheckCast(r2.next(), b.class, "com.obric.aiagent.plugin");
        r1[r13] = ((double) r6.f34611d) * 0.01d;
        r4[r13][0] = r6.f34609b;
        r4[r13][1] = r6.f34610c;
        r4[r13][2] = r6.f34612e;
        this.f34600d.a(r13, r6.f34608a, r6.f34611d, r6.f34610c, r6.f34612e, r6.f34609b);
        r13 = r13 + 1;
        goto L7
    L9:
        this.f34600d.c(r15);
        this.f34599c = com.obric.oui.constraintlayout.a.a.a.b.a(0, r1, r4);
    }
}
