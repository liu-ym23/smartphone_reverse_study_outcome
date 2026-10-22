package m0;

import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public AbstractC4889b f37061a;

    /* renamed from: b, reason: collision with root package name */
    public b f37062b;

    /* renamed from: c, reason: collision with root package name */
    public String f37063c;

    /* renamed from: d, reason: collision with root package name */
    public int f37064d = 0;

    /* renamed from: e, reason: collision with root package name */
    public String f37065e = null;

    /* renamed from: f, reason: collision with root package name */
    public int f37066f = 0;

    /* renamed from: g, reason: collision with root package name */
    public ArrayList<c> f37067g = new ArrayList<>();

    public class a implements Comparator<c> {
        public a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(c cVar, c cVar2) {
            return Integer.compare(cVar.f37085a, cVar2.f37085a);
        }
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f37069a;

        /* renamed from: b, reason: collision with root package name */
        public h f37070b;

        /* renamed from: c, reason: collision with root package name */
        public final int f37071c;

        /* renamed from: d, reason: collision with root package name */
        public final int f37072d;

        /* renamed from: e, reason: collision with root package name */
        public final int f37073e;

        /* renamed from: f, reason: collision with root package name */
        public float[] f37074f;

        /* renamed from: g, reason: collision with root package name */
        public double[] f37075g;

        /* renamed from: h, reason: collision with root package name */
        public float[] f37076h;

        /* renamed from: i, reason: collision with root package name */
        public float[] f37077i;

        /* renamed from: j, reason: collision with root package name */
        public float[] f37078j;

        /* renamed from: k, reason: collision with root package name */
        public float[] f37079k;

        /* renamed from: l, reason: collision with root package name */
        public int f37080l;

        /* renamed from: m, reason: collision with root package name */
        public AbstractC4889b f37081m;

        /* renamed from: n, reason: collision with root package name */
        public double[] f37082n;

        /* renamed from: o, reason: collision with root package name */
        public double[] f37083o;

        /* renamed from: p, reason: collision with root package name */
        public float f37084p;

        public b(int i10, String str, int i11, int i12) {
            h hVar = new h();
            this.f37070b = hVar;
            this.f37071c = 0;
            this.f37072d = 1;
            this.f37073e = 2;
            this.f37080l = i10;
            this.f37069a = i11;
            hVar.e(i10, str);
            this.f37074f = new float[i12];
            this.f37075g = new double[i12];
            this.f37076h = new float[i12];
            this.f37077i = new float[i12];
            this.f37078j = new float[i12];
            this.f37079k = new float[i12];
        }

        public double a(float f10) {
            AbstractC4889b abstractC4889b = this.f37081m;
            if (abstractC4889b != null) {
                abstractC4889b.d(f10, this.f37082n);
            } else {
                double[] dArr = this.f37082n;
                dArr[0] = this.f37077i[0];
                dArr[1] = this.f37078j[0];
                dArr[2] = this.f37074f[0];
            }
            double[] dArr2 = this.f37082n;
            return dArr2[0] + (this.f37070b.c(f10, dArr2[1]) * this.f37082n[2]);
        }

        public void b(int i10, int i11, float f10, float f11, float f12, float f13) {
            this.f37075g[i10] = i11 / 100.0d;
            this.f37076h[i10] = f10;
            this.f37077i[i10] = f11;
            this.f37078j[i10] = f12;
            this.f37074f[i10] = f13;
        }

        public void c(float f10) {
            this.f37084p = f10;
            double[][] dArr = (double[][]) Array.newInstance((Class<?>) Double.TYPE, this.f37075g.length, 3);
            float[] fArr = this.f37074f;
            this.f37082n = new double[fArr.length + 2];
            this.f37083o = new double[fArr.length + 2];
            if (this.f37075g[0] > 0.0d) {
                this.f37070b.a(0.0d, this.f37076h[0]);
            }
            double[] dArr2 = this.f37075g;
            int length = dArr2.length - 1;
            if (dArr2[length] < 1.0d) {
                this.f37070b.a(1.0d, this.f37076h[length]);
            }
            for (int i10 = 0; i10 < dArr.length; i10++) {
                double[] dArr3 = dArr[i10];
                dArr3[0] = this.f37077i[i10];
                dArr3[1] = this.f37078j[i10];
                dArr3[2] = this.f37074f[i10];
                this.f37070b.a(this.f37075g[i10], this.f37076h[i10]);
            }
            this.f37070b.d();
            double[] dArr4 = this.f37075g;
            if (dArr4.length > 1) {
                this.f37081m = AbstractC4889b.a(0, dArr4, dArr);
            } else {
                this.f37081m = null;
            }
        }
    }

    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public int f37085a;

        /* renamed from: b, reason: collision with root package name */
        public float f37086b;

        /* renamed from: c, reason: collision with root package name */
        public float f37087c;

        /* renamed from: d, reason: collision with root package name */
        public float f37088d;

        /* renamed from: e, reason: collision with root package name */
        public float f37089e;

        public c(int i10, float f10, float f11, float f12, float f13) {
            this.f37085a = i10;
            this.f37086b = f13;
            this.f37087c = f11;
            this.f37088d = f10;
            this.f37089e = f12;
        }
    }

    public float a(float f10) {
        return (float) this.f37062b.a(f10);
    }

    public void b(Object obj) {
    }

    public void c(int i10, int i11, String str, int i12, float f10, float f11, float f12, float f13) {
        this.f37067g.add(new c(i10, f10, f11, f12, f13));
        if (i12 != -1) {
            this.f37066f = i12;
        }
        this.f37064d = i11;
        this.f37065e = str;
    }

    public void d(int i10, int i11, String str, int i12, float f10, float f11, float f12, float f13, Object obj) {
        this.f37067g.add(new c(i10, f10, f11, f12, f13));
        if (i12 != -1) {
            this.f37066f = i12;
        }
        this.f37064d = i11;
        b(obj);
        this.f37065e = str;
    }

    public void e(String str) {
        this.f37063c = str;
    }

    public void f(float f10) {
        int size = this.f37067g.size();
        if (size == 0) {
            return;
        }
        Collections.sort(this.f37067g, new a());
        double[] dArr = new double[size];
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, size, 3);
        this.f37062b = new b(this.f37064d, this.f37065e, this.f37066f, size);
        Iterator<c> it = this.f37067g.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            c next = it.next();
            float f11 = next.f37088d;
            dArr[i10] = f11 * 0.01d;
            double[] dArr3 = dArr2[i10];
            float f12 = next.f37086b;
            dArr3[0] = f12;
            float f13 = next.f37087c;
            dArr3[1] = f13;
            float f14 = next.f37089e;
            dArr3[2] = f14;
            this.f37062b.b(i10, next.f37085a, f11, f13, f14, f12);
            i10++;
        }
        this.f37062b.c(f10);
        this.f37061a = AbstractC4889b.a(0, dArr, dArr2);
    }

    public boolean g() {
        return this.f37066f == 1;
    }

    public String toString() {
        String str = this.f37063c;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        Iterator<c> it = this.f37067g.iterator();
        while (it.hasNext()) {
            str = str + "[" + it.next().f37085a + " , " + decimalFormat.format(r2.f37086b) + "] ";
        }
        return str;
    }
}
