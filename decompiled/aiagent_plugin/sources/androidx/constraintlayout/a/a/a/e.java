package androidx.constraintlayout.a.a.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/* JADX INFO: compiled from: KeyCycleOscillator.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class e {
    private static final String TAG = "KeyCycleOscillator";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f620a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    ArrayList<b> f621b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private androidx.constraintlayout.a.a.a.b f622c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private a f623d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f624e;
    private int f;
    private String g;

    /* JADX INFO: compiled from: KeyCycleOscillator.java */
    static class a {
        private static final String TAG = "CycleOscillator";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        h f626a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        float[] f627b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        double[] f628c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        float[] f629d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        float[] f630e;
        float[] f;
        float[] g;
        int h;
        androidx.constraintlayout.a.a.a.b i;
        double[] j;
        double[] k;
        float l;
        private final int m;
        private final int n;
        private final int o;
        private final int p;

        a(int r3, String r4, int r5, int r6) {
            h r0 = new h();
            this.f626a = r0;
            this.n = 0;
            this.o = 1;
            this.p = 2;
            this.h = r3;
            this.m = r5;
            r0.a(r3, r4);
            this.f627b = new float[r6];
            this.f628c = new double[r6];
            this.f629d = new float[r6];
            this.f630e = new float[r6];
            this.f = new float[r6];
            this.g = new float[r6];
        }

        public double a(float r10) {
            androidx.constraintlayout.a.a.a.b r0 = this.i;
            if (r0 == null) goto L5;
            r0.a(r10, this.j);
        L6:
            double[] r1 = this.j;
            return r1[0] + (this.f626a.a(r10, r1[1]) * this.j[2]);
        L5:
            double[] r2 = this.j;
            r2[0] = this.f630e[0];
            r2[1] = this.f[0];
            r2[2] = this.f627b[0];
            goto L6
        }

        public double b(float r14) {
            androidx.constraintlayout.a.a.a.b r0 = this.i;
            if (r0 == null) goto L5;
            double r4 = r14;
            r0.b(r4, this.k);
            this.i.a(r4, this.j);
        L6:
            double r5 = r14;
            double r11 = this.f626a.a(r5, this.j[1]);
            double r3 = this.f626a.a(r5, this.j[1], this.k[1]);
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
            this.f628c[r6] = ((double) r7) / 100.0d;
            this.f629d[r6] = r8;
            this.f630e[r6] = r9;
            this.f[r6] = r10;
            this.f627b[r6] = r11;
        }

        public void c(float r10) {
            this.l = r10;
            double[][] r11 = (double[][]) Array.newInstance(double.class, new int[]{this.f628c.length, 3});
            float[] r1 = this.f627b;
            this.j = new double[r1.length + 2];
            this.k = new double[r1.length + 2];
            if (this.f628c[0] <= 0.0d) goto L5;
            this.f626a.a(0.0d, this.f629d[0]);
        L5:
            double[] r2 = this.f628c;
            int r4 = r2.length - 1;
            if (r2[r4] >= 1.0d) goto L8;
            this.f626a.a(1.0d, this.f629d[r4]);
        L8:
            int r3 = 0;
        L10:
            if (r3 >= r11.length) goto L12;
            r11[r3][0] = this.f630e[r3];
            r11[r3][1] = this.f[r3];
            r11[r3][2] = this.f627b[r3];
            this.f626a.a(this.f628c[r3], this.f629d[r3]);
            r3 = r3 + 1;
            goto L10
        L12:
            this.f626a.a();
            double[] r0 = this.f628c;
            if (r0.length <= 1) goto L15;
            this.i = androidx.constraintlayout.a.a.a.b.a(0, r0, r11);
            return;
        L15:
            this.i = null;
        }
    }

    /* JADX INFO: compiled from: KeyCycleOscillator.java */
    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f631a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        float f632b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        float f633c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        float f634d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        float f635e;

        public b(int r1, float r2, float r3, float r4, float r5) {
            this.f631a = r1;
            this.f632b = r5;
            this.f633c = r3;
            this.f634d = r2;
            this.f635e = r4;
        }
    }

    public void a(Object r1) {
    }

    public e() {
        this.f = 0;
        this.g = null;
        this.f620a = 0;
        this.f621b = new ArrayList();
    }

    public boolean a() {
        if (this.f620a == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public String toString() {
        String r0 = this.f624e;
        DecimalFormat r1 = new DecimalFormat("##.##");
        Iterator<b> r5 = this.f621b.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        b r2 = (b) ZeusTransformUtils.preCheckCast(r5.next(), b.class, "com.obric.aiagent.plugin");
        r0 = r0 + "[" + r2.f631a + " , " + r1.format(r2.f632b) + "] ";
        goto L4
    L6:
        return r0;
    }

    public void a(String r1) {
        this.f624e = r1;
    }

    public float a(float r1) {
        return (float) this.f623d.a(r1);
    }

    public float b(float r1) {
        return (float) this.f623d.b(r1);
    }

    public void a(int r11, int r12, String r13, int r14, float r15, float r16, float r17, float r18, Object r19) {
        this.f621b.add(new b(r11, r15, r16, r17, r18));
        if (r14 == (-1)) goto L5;
        this.f620a = r14;
    L5:
        this.f = r12;
        a(r19);
        this.g = r13;
    }

    public void a(int r11, int r12, String r13, int r14, float r15, float r16, float r17, float r18) {
        this.f621b.add(new b(r11, r15, r16, r17, r18));
        if (r14 == (-1)) goto L5;
        this.f620a = r14;
    L5:
        this.f = r12;
        this.g = r13;
    }

    public void c(float r15) {
        int r0 = this.f621b.size();
        if (r0 != 0) goto L5;
        return;
    L5:
        Collections.sort(this.f621b, new AnonymousClass1(this));
        double[] r1 = new double[r0];
        double[][] r4 = (double[][]) Array.newInstance(double.class, new int[]{r0, 3});
        this.f623d = new a(this.f, this.g, this.f620a, r0);
        Iterator<b> r2 = this.f621b.iterator();
        int r13 = 0;
    L7:
        if (r2.hasNext() == false) goto L9;
        b r6 = (b) ZeusTransformUtils.preCheckCast(r2.next(), b.class, "com.obric.aiagent.plugin");
        r1[r13] = ((double) r6.f634d) * 0.01d;
        r4[r13][0] = r6.f632b;
        r4[r13][1] = r6.f633c;
        r4[r13][2] = r6.f635e;
        this.f623d.a(r13, r6.f631a, r6.f634d, r6.f633c, r6.f635e, r6.f632b);
        r13 = r13 + 1;
        goto L7
    L9:
        this.f623d.c(r15);
        this.f622c = androidx.constraintlayout.a.a.a.b.a(0, r1, r4);
    }
}
