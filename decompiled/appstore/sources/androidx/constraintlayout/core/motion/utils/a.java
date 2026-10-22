package androidx.constraintlayout.core.motion.utils;

import androidx.appcompat.widget.p;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import p001j.g;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public p001j.b f1372a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f1373b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f1374c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f1375d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f1376e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f1377f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ArrayList f1378g;

    /* JADX INFO: renamed from: androidx.constraintlayout.core.motion.utils.a$a, reason: collision with other inner class name */
    public class C0009a implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f1379a;

        public C0009a(a r10) {
            this.f1379a = r10;
        }

        public int a(c r10, c r11) {
            throw null;
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(Object r10, Object r11) {
            p.a(r10);
            p.a(r11);
            return a(null, null);
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f1380a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public g f1381b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f1382c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f1383d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f1384e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public float[] f1385f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public double[] f1386g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public float[] f1387h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public float[] f1388i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public float[] f1389j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public float[] f1390k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f1391l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public p001j.b f1392m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public double[] f1393n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public double[] f1394o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public float f1395p;

        public b(int r10, String r11, int r12, int r13) {
            g r14 = new g();
            this.f1381b = r14;
            this.f1382c = 0;
            this.f1383d = 1;
            this.f1384e = 2;
            this.f1391l = r10;
            this.f1380a = r12;
            r14.g(r10, r11);
            this.f1385f = new float[r13];
            this.f1386g = new double[r13];
            this.f1387h = new float[r13];
            this.f1388i = new float[r13];
            this.f1389j = new float[r13];
            this.f1390k = new float[r13];
        }

        public double a(float r14) {
            p001j.b r10 = this.f1392m;
            if (r10 == null) goto L5;
            double r11 = r14;
            r10.g(r11, this.f1394o);
            this.f1392m.d(r11, this.f1393n);
        L6:
            double r12 = r14;
            double r13 = this.f1381b.e(r12, this.f1393n[1]);
            double r15 = this.f1381b.d(r12, this.f1393n[1], this.f1394o[1]);
            double[] r16 = this.f1394o;
            return (r16[0] + (r13 * r16[2])) + (r15 * this.f1393n[2]);
        L5:
            double[] r17 = this.f1394o;
            r17[0] = 0.0d;
            r17[1] = 0.0d;
            r17[2] = 0.0d;
            goto L6
        }

        public double b(float r10) {
            p001j.b r11 = this.f1392m;
            if (r11 == null) goto L5;
            r11.d(r10, this.f1393n);
        L6:
            double[] r12 = this.f1393n;
            return r12[0] + (this.f1381b.e(r10, r12[1]) * this.f1393n[2]);
        L5:
            double[] r13 = this.f1393n;
            r13[0] = this.f1388i[0];
            r13[1] = this.f1389j[0];
            r13[2] = this.f1385f[0];
            goto L6
        }

        public void c(float r10) {
            this.f1395p = r10;
            double[][] r11 = (double[][]) Array.newInstance(Double.TYPE, new int[]{this.f1386g.length, 3});
            float[] r12 = this.f1385f;
            this.f1393n = new double[r12.length + 2];
            this.f1394o = new double[r12.length + 2];
            if (this.f1386g[0] <= 0.0d) goto L5;
            this.f1381b.a(0.0d, this.f1387h[0]);
        L5:
            double[] r13 = this.f1386g;
            int r14 = r13.length - 1;
            if (r13[r14] >= 1.0d) goto L8;
            this.f1381b.a(1.0d, this.f1387h[r14]);
        L8:
            int r15 = 0;
        L10:
            if (r15 >= r11.length) goto L12;
            double[] r16 = r11[r15];
            r16[0] = this.f1388i[r15];
            r16[1] = this.f1389j[r15];
            r16[2] = this.f1385f[r15];
            this.f1381b.a(this.f1386g[r15], this.f1387h[r15]);
            r15 = r15 + 1;
            goto L10
        L12:
            this.f1381b.f();
            double[] r17 = this.f1386g;
            if (r17.length <= 1) goto L15;
            this.f1392m = p001j.b.a(0, r17, r11);
            return;
        L15:
            this.f1392m = null;
        }
    }

    public static class c {
    }

    public a() {
        this.f1375d = 0;
        this.f1376e = null;
        this.f1377f = 0;
        this.f1378g = new ArrayList();
    }

    public float a(float r10) {
        return (float) this.f1373b.b(r10);
    }

    public float b(float r10) {
        return (float) this.f1373b.a(r10);
    }

    public void c(String r10) {
        this.f1374c = r10;
    }

    public void d(float r10) {
        int r11 = this.f1378g.size();
        if (r11 != 0) goto L5;
        return;
    L5:
        Collections.sort(this.f1378g, new C0009a(this));
        double[] r12 = new double[r11];
        double[][] r13 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r11, 3});
        this.f1373b = new b(this.f1375d, this.f1376e, this.f1377f, r11);
        Iterator r14 = this.f1378g.iterator();
        if (r14.hasNext() == true) goto L9;
        this.f1373b.c(r10);
        this.f1372a = p001j.b.a(0, r12, r13);
        return;
    L9:
        p.a(r14.next());
        throw null;
    }

    public boolean e() {
        if (this.f1377f == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public String toString() {
        String r10 = this.f1374c;
        new DecimalFormat("##.##");
        Iterator r11 = this.f1378g.iterator();
        if (r11.hasNext() == true) goto L5;
        return r10;
    L5:
        p.a(r11.next());
        StringBuilder r12 = new StringBuilder();
        r12.append(r10);
        r12.append("[");
        throw null;
    }
}
