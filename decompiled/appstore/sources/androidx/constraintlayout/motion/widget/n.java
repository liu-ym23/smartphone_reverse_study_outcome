package androidx.constraintlayout.motion.widget;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintSet;
import com.google.common.primitives.Ints;
import com.tmall.wireless.tangram.dataparser.concrete.Style;
import com.tmall.wireless.tangram.structure.card.FixCard;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes.dex */
public class n implements Comparable {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static String[] f1927t;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public p001j.c f1928a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1929b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f1930c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f1931d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f1932e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f1933f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f1934g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f1935h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f1936i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f1937j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f1938k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f1939l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f1940m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public l f1941n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public LinkedHashMap f1942o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f1943p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f1944q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public double[] f1945r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public double[] f1946s;

    static {
        f1927t = new String[]{"position", FixCard.FixStyle.KEY_X, FixCard.FixStyle.KEY_Y, Style.KEY_WIDTH, Style.KEY_HEIGHT, "pathRotate"};
    }

    public n() {
        this.f1929b = 0;
        this.f1936i = Float.NaN;
        this.f1937j = Float.NaN;
        int r10 = c.f1833f;
        this.f1938k = r10;
        this.f1939l = r10;
        this.f1940m = Float.NaN;
        this.f1941n = null;
        this.f1942o = new LinkedHashMap();
        this.f1943p = 0;
        this.f1945r = new double[18];
        this.f1946s = new double[18];
    }

    public void a(ConstraintSet.a r10) {
        this.f1928a = p001j.c.c(r10.f2276d.f2342d);
        ConstraintSet.c r11 = r10.f2276d;
        this.f1938k = r11.f2343e;
        this.f1939l = r11.f2340b;
        this.f1936i = r11.f2347i;
        this.f1929b = r11.f2344f;
        this.f1944q = r11.f2341c;
        this.f1937j = r10.f2275c.f2357e;
        this.f1940m = r10.f2277e.D;
        Iterator r12 = r10.f2279g.keySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L10;
        String r13 = (String) r12.next();
        ConstraintAttribute r14 = (ConstraintAttribute) r10.f2279g.get(r13);
        if (r14 == null) goto L4;
        if (r14.f() == false) goto L4;
        this.f1942o.put(r13, r14);
        goto L4
    }

    public int b(n r10) {
        return Float.compare(this.f1931d, r10.f1931d);
    }

    public final boolean c(float r10, float r11) {
        if (Float.isNaN(r10) == true) goto L12;
        if (Float.isNaN(r11) == true) goto L12;
        if (Math.abs(r10 - r11) > 1.0E-6f) goto L10;
        return false;
    L10:
        return true;
    L12:
        if (Float.isNaN(r10) != Float.isNaN(r11)) goto L14;
        return false;
    L14:
        return true;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Object r10) {
        return b((n) r10);
    }

    public void d(n r10, boolean[] r11, String[] r12, boolean r13) {
        boolean r14 = c(this.f1932e, r10.f1932e);
        boolean r15 = c(this.f1933f, r10.f1933f);
        r11[0] = r11[0] | c(this.f1931d, r10.f1931d);
        boolean r16 = (r14 | r15) | r13;
        r11[1] = r11[1] | r16;
        r11[2] = r16 | r11[2];
        r11[3] = r11[3] | c(this.f1934g, r10.f1934g);
        boolean r17 = r11[4];
        r11[4] = c(this.f1935h, r10.f1935h) | r17;
    }

    public void e(double[] r10, int[] r11) {
        int r12 = 0;
        float[] r13 = {this.f1931d, this.f1932e, this.f1933f, this.f1934g, this.f1935h, this.f1936i};
        int r14 = 0;
    L4:
        if (r12 >= r11.length) goto L9;
        int r15 = r11[r12];
        if (r15 >= 6) goto L8;
        r10[r14] = r13[r15];
        r14 = r14 + 1;
    L8:
        r12 = r12 + 1;
        goto L4
    }

    public void f(double r16, int[] r18, double[] r19, float[] r20, int r21) {
        float r10 = this.f1932e;
        float r11 = this.f1933f;
        float r12 = this.f1934g;
        float r13 = this.f1935h;
        int r14 = 0;
    L4:
        if (r14 >= r18.length) goto L18;
        float r15 = (float) r19[r14];
        int r17 = r18[r14];
        if (r17 == 1) goto L16;
        if (r17 != 2) goto L9;
        r11 = r15;
    L17:
        r14 = r14 + 1;
        goto L4
    L9:
        if (r17 != 3) goto L11;
        r12 = r15;
        goto L17
    L11:
        if (r17 != 4) goto L17;
        r13 = r15;
        goto L17
    L16:
        r10 = r15;
        goto L17
    L18:
        l r22 = this.f1941n;
        if (r22 == null) goto L21;
        float[] r23 = new float[2];
        r22.j(r16, r23, new float[2]);
        float r24 = r23[0];
        float r25 = r23[1];
        double r110 = r10;
        double r26 = r11;
        float r27 = (float) ((((double) r24) + (Math.sin(r26) * r110)) - ((double) (r12 / 2.0f)));
        r11 = (float) ((((double) r25) - (r110 * Math.cos(r26))) - ((double) (r13 / 2.0f)));
        r10 = r27;
    L21:
        r20[r21] = (r10 + (r12 / 2.0f)) + 0.0f;
        r20[r21 + 1] = (r11 + (r13 / 2.0f)) + 0.0f;
    }

    public void g(double r20, int[] r22, double[] r23, float[] r24, double[] r25, float[] r26) {
        float r10 = this.f1932e;
        float r11 = this.f1933f;
        float r12 = this.f1934g;
        float r13 = this.f1935h;
        int r14 = 0;
        float r15 = 0.0f;
        float r16 = 0.0f;
        float r17 = 0.0f;
        float r18 = 0.0f;
    L4:
        if (r14 >= r22.length) goto L19;
        float r19 = (float) r23[r14];
        float r110 = (float) r25[r14];
        int r111 = r22[r14];
        if (r111 != 1) goto L8;
        r10 = r19;
        r15 = r110;
    L18:
        r14 = r14 + 1;
        goto L4
    L8:
        if (r111 != 2) goto L10;
        r11 = r19;
        r17 = r110;
        goto L18
    L10:
        if (r111 != 3) goto L12;
        r12 = r19;
        r16 = r110;
        goto L18
    L12:
        if (r111 != 4) goto L18;
        r13 = r19;
        r18 = r110;
        goto L18
    L19:
        float r112 = (r16 / 2.0f) + r15;
        float r113 = (r18 / 2.0f) + r17;
        l r21 = this.f1941n;
        if (r21 == null) goto L22;
        float[] r27 = new float[2];
        float[] r28 = new float[2];
        r21.j(r20, r27, r28);
        float r29 = r27[0];
        float r30 = r27[1];
        float r114 = r28[0];
        float r31 = r28[1];
        double r32 = r10;
        double r115 = r11;
        float r33 = (float) ((((double) r29) + (Math.sin(r115) * r32)) - ((double) (r12 / 2.0f)));
        float r34 = (float) ((((double) r30) - (r32 * Math.cos(r115))) - ((double) (r13 / 2.0f)));
        double r35 = r15;
        double r36 = r17;
        float r37 = (float) ((((double) r114) + (Math.sin(r115) * r35)) + (Math.cos(r115) * r36));
        r113 = (float) ((((double) r31) - (r35 * Math.cos(r115))) + (Math.sin(r115) * r36));
        r10 = r33;
        r11 = r34;
        r112 = r37;
        float r38 = 2.0f;
    L23:
        r24[0] = (r10 + (r12 / r38)) + 0.0f;
        r24[1] = (r11 + (r13 / r38)) + 0.0f;
        r26[0] = r112;
        r26[1] = r113;
        return;
    L22:
        r38 = 2.0f;
        goto L23
    }

    public int h(String r10, double[] r11, int r12) {
        ConstraintAttribute r13 = (ConstraintAttribute) this.f1942o.get(r10);
        int r14 = 0;
        if (r13 != null) goto L6;
        return 0;
    L6:
        if (r13.g() != 1) goto L9;
        r11[r12] = r13.d();
        return 1;
    L9:
        int r15 = r13.g();
        float[] r16 = new float[r15];
        r13.e(r16);
    L10:
        if (r14 >= r15) goto L12;
        r11[r12] = r16[r14];
        r14 = r14 + 1;
        r12 = r12 + 1;
        goto L10
    L12:
        return r15;
    }

    public int i(String r10) {
        ConstraintAttribute r11 = (ConstraintAttribute) this.f1942o.get(r10);
        if (r11 != null) goto L7;
        return 0;
    L7:
        return r11.g();
    }

    public void j(int[] r10, double[] r11, float[] r12, int r13) {
        float r14 = this.f1932e;
        float r15 = this.f1933f;
        float r16 = this.f1934g;
        float r17 = this.f1935h;
        int r18 = 0;
    L4:
        if (r18 >= r10.length) goto L19;
        float r19 = (float) r11[r18];
        int r20 = r10[r18];
        if (r20 != 1) goto L8;
        r14 = r19;
    L18:
        r18 = r18 + 1;
        goto L4
    L8:
        if (r20 != 2) goto L10;
        r15 = r19;
        goto L18
    L10:
        if (r20 != 3) goto L12;
        r16 = r19;
        goto L18
    L12:
        if (r20 != 4) goto L18;
        r17 = r19;
        goto L18
    L19:
        l r110 = this.f1941n;
        if (r110 == null) goto L22;
        float r111 = r110.k();
        float r21 = this.f1941n.l();
        double r22 = r14;
        double r23 = r15;
        float r112 = (float) ((((double) r111) + (Math.sin(r23) * r22)) - ((double) (r16 / 2.0f)));
        r15 = (float) ((((double) r21) - (r22 * Math.cos(r23))) - ((double) (r17 / 2.0f)));
        r14 = r112;
    L22:
        float r24 = r16 + r14;
        float r25 = r17 + r15;
        Float.isNaN(Float.NaN);
        Float.isNaN(Float.NaN);
        r12[r13] = r14 + 0.0f;
        r12[r13 + 1] = r15 + 0.0f;
        r12[r13 + 2] = r24 + 0.0f;
        r12[r13 + 3] = r15 + 0.0f;
        r12[r13 + 4] = r24 + 0.0f;
        int r113 = r13 + 6;
        r12[r13 + 5] = r25 + 0.0f;
        r12[r113] = r14 + 0.0f;
        r12[r13 + 7] = r25 + 0.0f;
    }

    public boolean k(String r10) {
        return this.f1942o.containsKey(r10);
    }

    public void l(g r18, n r19, n r20) {
        float r10 = r18.f1834a / 100.0f;
        this.f1930c = r10;
        this.f1929b = r18.f1861j;
        if (Float.isNaN(r18.f1862k) == false) goto L5;
        float r11 = r10;
    L7:
        if (Float.isNaN(r18.f1863l) == false) goto L9;
        float r12 = r10;
    L10:
        float r13 = r20.f1934g;
        float r14 = r19.f1934g;
        float r15 = r20.f1935h;
        float r16 = r19.f1935h;
        this.f1931d = this.f1930c;
        float r17 = r19.f1932e;
        float r21 = r19.f1933f;
        float r22 = r20.f1932e + (r13 / 2.0f);
        float r23 = r22 - ((r14 / 2.0f) + r17);
        float r24 = (r20.f1933f + (r15 / 2.0f)) - (r21 + (r16 / 2.0f));
        float r25 = (r13 - r14) * r11;
        float r26 = r25 / 2.0f;
        this.f1932e = (int) ((r17 + (r23 * r10)) - r26);
        float r110 = (r15 - r16) * r12;
        float r27 = r110 / 2.0f;
        this.f1933f = (int) ((r21 + (r24 * r10)) - r27);
        this.f1934g = (int) (r14 + r25);
        this.f1935h = (int) (r16 + r110);
        if (Float.isNaN(r18.f1864m) == false) goto L13;
        float r28 = r10;
    L14:
        float r29 = 0.0f;
        if (Float.isNaN(r18.f1867p) == false) goto L17;
        float r30 = 0.0f;
    L19:
        if (Float.isNaN(r18.f1865n) == true) goto L23;
        r10 = r18.f1865n;
    L23:
        if (Float.isNaN(r18.f1866o) == true) goto L26;
        r29 = r18.f1866o;
    L26:
        this.f1943p = 0;
        this.f1932e = (int) (((r19.f1932e + (r28 * r23)) + (r29 * r24)) - r26);
        this.f1933f = (int) (((r19.f1933f + (r23 * r30)) + (r24 * r10)) - r27);
        this.f1928a = p001j.c.c(r18.f1859h);
        this.f1938k = r18.f1860i;
        return;
    L17:
        r30 = r18.f1867p;
        goto L19
    L13:
        r28 = r18.f1864m;
        goto L14
    L9:
        r12 = r18.f1863l;
        goto L10
    L5:
        r11 = r18.f1862k;
        goto L7
    }

    public void m(g r17, n r18, n r19) {
        float r10 = r17.f1834a / 100.0f;
        this.f1930c = r10;
        this.f1929b = r17.f1861j;
        if (Float.isNaN(r17.f1862k) == false) goto L5;
        float r11 = r10;
    L7:
        if (Float.isNaN(r17.f1863l) == false) goto L9;
        float r12 = r10;
    L10:
        float r13 = r19.f1934g - r18.f1934g;
        float r14 = r19.f1935h - r18.f1935h;
        this.f1931d = this.f1930c;
        if (Float.isNaN(r17.f1864m) == true) goto L14;
        r10 = r17.f1864m;
    L14:
        float r15 = r18.f1932e;
        float r16 = r18.f1934g;
        float r110 = r18.f1933f;
        float r111 = r18.f1935h;
        float r20 = r19.f1932e + (r19.f1934g / 2.0f);
        float r21 = r20 - ((r16 / 2.0f) + r15);
        float r22 = (r19.f1933f + (r19.f1935h / 2.0f)) - ((r111 / 2.0f) + r110);
        float r23 = r21 * r10;
        float r24 = r13 * r11;
        float r25 = r24 / 2.0f;
        this.f1932e = (int) ((r15 + r23) - r25);
        float r26 = r10 * r22;
        float r27 = r14 * r12;
        float r28 = r27 / 2.0f;
        this.f1933f = (int) ((r110 + r26) - r28);
        this.f1934g = (int) (r16 + r24);
        this.f1935h = (int) (r111 + r27);
        if (Float.isNaN(r17.f1865n) == false) goto L17;
        float r29 = 0.0f;
    L18:
        this.f1943p = 1;
        float r30 = (int) ((r18.f1932e + r23) - r25);
        float r31 = (int) ((r18.f1933f + r26) - r28);
        this.f1932e = r30 + ((-r22) * r29);
        this.f1933f = r31 + (r21 * r29);
        this.f1939l = this.f1939l;
        this.f1928a = p001j.c.c(r17.f1859h);
        this.f1938k = r17.f1860i;
        return;
    L17:
        r29 = r17.f1865n;
        goto L18
    L9:
        r12 = r17.f1863l;
        goto L10
    L5:
        r11 = r17.f1862k;
        goto L7
    }

    public void n(int r10, int r11, g r12, n r13, n r14) {
        float r15 = r12.f1834a / 100.0f;
        this.f1930c = r15;
        this.f1929b = r12.f1861j;
        this.f1943p = r12.f1868q;
        if (Float.isNaN(r12.f1862k) == false) goto L5;
        float r16 = r15;
    L7:
        if (Float.isNaN(r12.f1863l) == false) goto L9;
        float r17 = r15;
    L10:
        float r18 = r14.f1934g;
        float r19 = r13.f1934g;
        float r20 = r14.f1935h;
        float r21 = r13.f1935h;
        this.f1931d = this.f1930c;
        this.f1934g = (int) (r19 + ((r18 - r19) * r16));
        this.f1935h = (int) (r21 + ((r20 - r21) * r17));
        int r22 = r12.f1868q;
        if (r22 == 1) goto L33;
        if (r22 == 2) goto L24;
        if (Float.isNaN(r12.f1864m) == false) goto L17;
        float r23 = r15;
    L18:
        float r24 = r14.f1932e;
        float r25 = r13.f1932e;
        this.f1932e = (r23 * (r24 - r25)) + r25;
        if (Float.isNaN(r12.f1865n) == true) goto L22;
        r15 = r12.f1865n;
    L22:
        float r26 = r14.f1933f;
        float r110 = r13.f1933f;
        this.f1933f = (r15 * (r26 - r110)) + r110;
    L41:
        this.f1939l = r13.f1939l;
        this.f1928a = p001j.c.c(r12.f1859h);
        this.f1938k = r12.f1860i;
        return;
    L17:
        r23 = r12.f1864m;
        goto L18
    L24:
        if (Float.isNaN(r12.f1864m) == false) goto L26;
        float r27 = r14.f1932e;
        float r28 = r13.f1932e;
        float r29 = ((r27 - r28) * r15) + r28;
    L27:
        this.f1932e = r29;
        if (Float.isNaN(r12.f1865n) == false) goto L30;
        float r30 = r14.f1933f;
        float r111 = r13.f1933f;
        float r31 = (r15 * (r30 - r111)) + r111;
    L31:
        this.f1933f = r31;
        goto L41
    L30:
        r31 = r12.f1865n;
        goto L31
    L26:
        r29 = Math.min(r17, r16) * r12.f1864m;
        goto L27
    L33:
        if (Float.isNaN(r12.f1864m) == false) goto L35;
        float r32 = r15;
    L36:
        float r33 = r14.f1932e;
        float r34 = r13.f1932e;
        this.f1932e = (r32 * (r33 - r34)) + r34;
        if (Float.isNaN(r12.f1865n) == true) goto L40;
        r15 = r12.f1865n;
    L40:
        float r35 = r14.f1933f;
        float r112 = r13.f1933f;
        this.f1933f = (r15 * (r35 - r112)) + r112;
        goto L41
    L35:
        r32 = r12.f1864m;
        goto L36
    L9:
        r17 = r12.f1863l;
        goto L10
    L5:
        r16 = r12.f1862k;
        goto L7
    }

    public void o(int r18, int r19, g r20, n r21, n r22) {
        float r10 = r20.f1834a / 100.0f;
        this.f1930c = r10;
        this.f1929b = r20.f1861j;
        if (Float.isNaN(r20.f1862k) == false) goto L5;
        float r11 = r10;
    L7:
        if (Float.isNaN(r20.f1863l) == false) goto L9;
        float r12 = r10;
    L10:
        float r13 = r22.f1934g;
        float r14 = r21.f1934g;
        float r15 = r22.f1935h;
        float r16 = r21.f1935h;
        this.f1931d = this.f1930c;
        float r17 = r21.f1932e;
        float r23 = r21.f1933f;
        float r24 = r22.f1932e + (r13 / 2.0f);
        float r25 = r22.f1933f + (r15 / 2.0f);
        float r26 = (r13 - r14) * r11;
        this.f1932e = (int) ((r17 + ((r24 - ((r14 / 2.0f) + r17)) * r10)) - (r26 / 2.0f));
        float r110 = (r15 - r16) * r12;
        this.f1933f = (int) ((r23 + ((r25 - (r23 + (r16 / 2.0f))) * r10)) - (r110 / 2.0f));
        this.f1934g = (int) (r14 + r26);
        this.f1935h = (int) (r16 + r110);
        this.f1943p = 2;
        if (Float.isNaN(r20.f1864m) == true) goto L14;
        this.f1932e = (int) (r20.f1864m * ((int) (r18 - this.f1934g)));
    L14:
        if (Float.isNaN(r20.f1865n) == true) goto L16;
        this.f1933f = (int) (r20.f1865n * ((int) (r19 - this.f1935h)));
    L16:
        this.f1939l = this.f1939l;
        this.f1928a = p001j.c.c(r20.f1859h);
        this.f1938k = r20.f1860i;
        return;
    L9:
        r12 = r20.f1863l;
        goto L10
    L5:
        r11 = r20.f1862k;
        goto L7
    }

    public void p(float r10, float r11, float r12, float r13) {
        this.f1932e = r10;
        this.f1933f = r11;
        this.f1934g = r12;
        this.f1935h = r13;
    }

    public void q(float r13, float r14, float[] r15, int[] r16, double[] r17, double[] r18) {
        float r10 = 0.0f;
        float r11 = 0.0f;
        float r12 = 0.0f;
        float r19 = 0.0f;
        int r20 = 0;
    L4:
        if (r20 >= r16.length) goto L19;
        float r21 = (float) r17[r20];
        double r110 = r18[r20];
        int r111 = r16[r20];
        if (r111 != 1) goto L8;
        r10 = r21;
    L18:
        r20 = r20 + 1;
        goto L4
    L8:
        if (r111 != 2) goto L10;
        r12 = r21;
        goto L18
    L10:
        if (r111 != 3) goto L12;
        r11 = r21;
        goto L18
    L12:
        if (r111 != 4) goto L18;
        r19 = r21;
        goto L18
    L19:
        float r22 = r10 - ((0.0f * r11) / 2.0f);
        float r23 = r12 - ((0.0f * r19) / 2.0f);
        r15[0] = ((r22 * (1.0f - r13)) + (((r11 * 1.0f) + r22) * r13)) + 0.0f;
        r15[1] = ((r23 * (1.0f - r14)) + (((r19 * 1.0f) + r23) * r14)) + 0.0f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void r(float r21, View r22, int[] r23, double[] r24, double[] r25, double[] r26, boolean r27) {
        float r10 = this.f1932e;
        float r11 = this.f1933f;
        float r12 = this.f1934g;
        float r13 = this.f1935h;
        if (r23.length != 0) goto L5;
    L7:
        Arrays.fill(this.f1945r, Double.NaN);
        int r14 = 0;
    L9:
        if (r14 >= r23.length) goto L11;
        double[] r15 = this.f1945r;
        int r16 = r23[r14];
        r15[r16] = r24[r14];
        this.f1946s[r16] = r25[r14];
        r14 = r14 + 1;
        goto L9
    L11:
        float r17 = Float.NaN;
        int r18 = 0;
        float r19 = 0.0f;
        float r110 = 0.0f;
        float r111 = 0.0f;
        float r112 = 0.0f;
    L12:
        double[] r20 = this.f1945r;
        if (r18 >= r20.length) goto L43;
        double r113 = 0.0d;
        if (Double.isNaN(r20[r18]) == false) goto L20;
        if (r26 != null) goto L18;
    L19:
        float r28 = r17;
    L36:
        r17 = r28;
    L42:
        r18 = r18 + 1;
        goto L12
    L18:
        if (r26[r18] == 0.0d) goto L19;
    L20:
        if (r26 == null) goto L23;
        r113 = r26[r18];
    L23:
        if (Double.isNaN(this.f1945r[r18]) == false) goto L25;
    L24:
        r28 = r17;
        float r29 = (float) r113;
        float r30 = (float) this.f1946s[r18];
        if (r18 != 1) goto L29;
        r17 = r28;
        r10 = r29;
        r19 = r30;
        goto L42
    L29:
        if (r18 != 2) goto L31;
        r17 = r28;
        r11 = r29;
        r110 = r30;
        goto L42
    L31:
        if (r18 != 3) goto L33;
        r17 = r28;
        r12 = r29;
        r111 = r30;
        goto L42
    L33:
        if (r18 != 4) goto L35;
        r17 = r28;
        r13 = r29;
        r112 = r30;
        goto L42
    L35:
        if (r18 != 5) goto L36;
        r17 = r29;
        goto L42
    L25:
        r113 = this.f1945r[r18] + r113;
        goto L24
    L43:
        float r210 = r17;
        l r31 = this.f1941n;
        if (r31 == null) goto L52;
        float[] r32 = new float[2];
        float[] r114 = new float[2];
        r31.j(r21, r32, r114);
        float r115 = r32[0];
        float r33 = r32[1];
        float r116 = r114[0];
        float r34 = r114[1];
        double r35 = r10;
        double r36 = r11;
        float r37 = (float) ((((double) r115) + (Math.sin(r36) * r35)) - ((double) (r12 / 2.0f)));
        float r117 = r13;
        float r38 = (float) ((((double) r33) - (Math.cos(r36) * r35)) - ((double) (r13 / 2.0f)));
        double r118 = r19;
        double r119 = r110;
        float r39 = (float) ((((double) r116) + (Math.sin(r36) * r118)) + ((Math.cos(r36) * r35) * r119));
        float r40 = (float) ((((double) r34) - (r118 * Math.cos(r36))) + ((r35 * Math.sin(r36)) * r119));
        if (r25.length < 2) goto L49;
        r25[0] = r39;
        r25[1] = r40;
    L49:
        if (Float.isNaN(r210) == true) goto L51;
        r22.setRotation((float) (((double) r210) + Math.toDegrees(Math.atan2(r40, r39))));
    L51:
        r10 = r37;
        r11 = r38;
    L56:
        if ((r22 instanceof FloatLayout) == false) goto L59;
        ((FloatLayout) r22).layout(r10, r11, r12 + r10, r11 + r117);
        return;
    L59:
        float r41 = r10 + 0.5f;
        int r42 = (int) r41;
        float r43 = r11 + 0.5f;
        int r44 = (int) r43;
        int r45 = (int) (r41 + r12);
        int r46 = (int) (r43 + r117);
        int r47 = r45 - r42;
        int r48 = r46 - r44;
        if (r47 == r22.getMeasuredWidth()) goto L62;
    L65:
        r22.measure(View.MeasureSpec.makeMeasureSpec(r47, Ints.MAX_POWER_OF_TWO), View.MeasureSpec.makeMeasureSpec(r48, Ints.MAX_POWER_OF_TWO));
    L66:
        r22.layout(r42, r44, r45, r46);
        return;
    L62:
        if (r48 != r22.getMeasuredHeight()) goto L65;
        if (r27 == false) goto L66;
    L52:
        r117 = r13;
        if (Float.isNaN(r210) == true) goto L56;
        r22.setRotation((float) (((double) 0.0f) + (((double) r210) + Math.toDegrees(Math.atan2(r110 + (r112 / 2.0f), r19 + (r111 / 2.0f))))));
        goto L56
    L5:
        if (this.f1945r.length > r23[r23.length - 1]) goto L7;
        int r49 = r23[r23.length - 1] + 1;
        this.f1945r = new double[r49];
        this.f1946s = new double[r49];
        goto L7
    }

    public void s(l r10, n r11) {
        double r12 = ((this.f1932e + (this.f1934g / 2.0f)) - r11.f1932e) - (r11.f1934g / 2.0f);
        double r13 = ((this.f1933f + (this.f1935h / 2.0f)) - r11.f1933f) - (r11.f1935h / 2.0f);
        this.f1941n = r10;
        this.f1932e = (float) Math.hypot(r13, r12);
        if (Float.isNaN(this.f1940m) == false) goto L5;
        this.f1933f = (float) (Math.atan2(r13, r12) + 1.5707963267948966d);
        return;
    L5:
        this.f1933f = (float) Math.toRadians(this.f1940m);
    }

    public n(int r10, int r11, g r12, n r13, n r14) {
        this.f1929b = 0;
        this.f1936i = Float.NaN;
        this.f1937j = Float.NaN;
        int r15 = c.f1833f;
        this.f1938k = r15;
        this.f1939l = r15;
        this.f1940m = Float.NaN;
        this.f1941n = null;
        this.f1942o = new LinkedHashMap();
        this.f1943p = 0;
        this.f1945r = new double[18];
        this.f1946s = new double[18];
        if (r13.f1939l == c.f1833f) goto L6;
        n(r10, r11, r12, r13, r14);
        return;
    L6:
        int r16 = r12.f1868q;
        if (r16 != 1) goto L9;
        m(r12, r13, r14);
        return;
    L9:
        if (r16 == 2) goto L12;
        l(r12, r13, r14);
        return;
    L12:
        o(r10, r11, r12, r13, r14);
    }
}
