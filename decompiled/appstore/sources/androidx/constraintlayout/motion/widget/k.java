package androidx.constraintlayout.motion.widget;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintSet;
import com.google.common.base.Ascii;
import com.tmall.wireless.tangram.dataparser.concrete.Style;
import com.tmall.wireless.tangram.structure.card.FixCard;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes.dex */
public class k implements Comparable {
    public static String[] D;
    public int A;
    public double[] B;
    public double[] C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f1873a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1874b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f1875c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f1876d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f1877e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f1878f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f1879g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f1880h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f1881i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f1882j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f1883k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f1884l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f1885m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f1886n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f1887o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public p001j.c f1888p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f1889q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f1890r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f1891s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public float f1892t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f1893u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f1894v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f1895w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f1896x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f1897y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public LinkedHashMap f1898z;

    static {
        D = new String[]{"position", FixCard.FixStyle.KEY_X, FixCard.FixStyle.KEY_Y, Style.KEY_WIDTH, Style.KEY_HEIGHT, "pathRotate"};
    }

    public k() {
        this.f1873a = 1.0f;
        this.f1874b = 0;
        this.f1876d = false;
        this.f1877e = 0.0f;
        this.f1878f = 0.0f;
        this.f1879g = 0.0f;
        this.f1880h = 0.0f;
        this.f1881i = 1.0f;
        this.f1882j = 1.0f;
        this.f1883k = Float.NaN;
        this.f1884l = Float.NaN;
        this.f1885m = 0.0f;
        this.f1886n = 0.0f;
        this.f1887o = 0.0f;
        this.f1889q = 0;
        this.f1895w = Float.NaN;
        this.f1896x = Float.NaN;
        this.f1897y = -1;
        this.f1898z = new LinkedHashMap();
        this.A = 0;
        this.B = new double[18];
        this.C = new double[18];
    }

    public void a(HashMap r10, int r11) {
        Iterator r12 = r10.keySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L144;
        String r13 = (String) r12.next();
        m.d r14 = (m.d) r10.get(r13);
        r13.hashCode();
        float r15 = 1.0f;
        float r16 = 0.0f;
        byte r17 = -1;
        switch(r13.hashCode()) {
            case -1249320806: goto L61;
            case -1249320805: goto L57;
            case -1225497657: goto L53;
            case -1225497656: goto L49;
            case -1225497655: goto L45;
            case -1001078227: goto L41;
            case -908189618: goto L37;
            case -908189617: goto L33;
            case -760884510: goto L29;
            case -760884509: goto L25;
            case -40300674: goto L21;
            case -4379043: goto L17;
            case 37232917: goto L13;
            case 92909918: goto L9;
            default: goto L64;
        };
    L64:
        switch(r17) {
            case 0: goto L140;
            case 1: goto L135;
            case 2: goto L130;
            case 3: goto L125;
            case 4: goto L120;
            case 5: goto L115;
            case 6: goto L110;
            case 7: goto L105;
            case 8: goto L100;
            case 9: goto L95;
            case 10: goto L90;
            case 11: goto L85;
            case 12: goto L80;
            case 13: goto L75;
            default: goto L66;
        };
    L75:
        if (Float.isNaN(this.f1873a) == true) goto L78;
        r15 = this.f1873a;
    L78:
        r14.c(r11, r15);
        goto L4
    L80:
        if (Float.isNaN(this.f1895w) == true) goto L83;
        r16 = this.f1895w;
    L83:
        r14.c(r11, r16);
        goto L4
    L85:
        if (Float.isNaN(this.f1877e) == true) goto L88;
        r16 = this.f1877e;
    L88:
        r14.c(r11, r16);
        goto L4
    L90:
        if (Float.isNaN(this.f1878f) == true) goto L93;
        r16 = this.f1878f;
    L93:
        r14.c(r11, r16);
        goto L4
    L95:
        if (Float.isNaN(this.f1884l) == true) goto L98;
        r16 = this.f1884l;
    L98:
        r14.c(r11, r16);
        goto L4
    L100:
        if (Float.isNaN(this.f1883k) == true) goto L103;
        r16 = this.f1883k;
    L103:
        r14.c(r11, r16);
        goto L4
    L105:
        if (Float.isNaN(this.f1882j) == true) goto L108;
        r15 = this.f1882j;
    L108:
        r14.c(r11, r15);
        goto L4
    L110:
        if (Float.isNaN(this.f1881i) == true) goto L113;
        r15 = this.f1881i;
    L113:
        r14.c(r11, r15);
        goto L4
    L115:
        if (Float.isNaN(this.f1896x) == true) goto L118;
        r16 = this.f1896x;
    L118:
        r14.c(r11, r16);
        goto L4
    L120:
        if (Float.isNaN(this.f1887o) == true) goto L123;
        r16 = this.f1887o;
    L123:
        r14.c(r11, r16);
        goto L4
    L125:
        if (Float.isNaN(this.f1886n) == true) goto L128;
        r16 = this.f1886n;
    L128:
        r14.c(r11, r16);
        goto L4
    L130:
        if (Float.isNaN(this.f1885m) == true) goto L133;
        r16 = this.f1885m;
    L133:
        r14.c(r11, r16);
        goto L4
    L135:
        if (Float.isNaN(this.f1880h) == true) goto L138;
        r16 = this.f1880h;
    L138:
        r14.c(r11, r16);
        goto L4
    L140:
        if (Float.isNaN(this.f1879g) == true) goto L143;
        r16 = this.f1879g;
    L143:
        r14.c(r11, r16);
        goto L4
    L66:
        if (r13.startsWith("CUSTOM") == true) goto L67;
        Log.e("MotionPaths", "UNKNOWN spline " + r13);
        goto L4
    L67:
        String r18 = r13.split(",")[1];
        if (this.f1898z.containsKey(r18) == false) goto L4;
        ConstraintAttribute r19 = (ConstraintAttribute) this.f1898z.get(r18);
        if ((r14 instanceof m.d.b) == true) goto L71;
        Log.e("MotionPaths", r13 + " ViewSpline not a CustomSet frame = " + r11 + ", value" + r19.d() + r14);
        goto L4
    L71:
        ((m.d.b) r14).i(r11, r19);
        goto L4
    L9:
        if (r13.equals("alpha") == false) goto L64;
        r17 = Ascii.CR;
        goto L64
    L13:
        if (r13.equals("transitionPathRotate") == false) goto L64;
        r17 = Ascii.FF;
        goto L64
    L17:
        if (r13.equals("elevation") == false) goto L64;
        r17 = Ascii.VT;
        goto L64
    L21:
        if (r13.equals("rotation") == false) goto L64;
        r17 = 10;
        goto L64
    L25:
        if (r13.equals("transformPivotY") == false) goto L64;
        r17 = 9;
        goto L64
    L29:
        if (r13.equals("transformPivotX") == false) goto L64;
        r17 = 8;
        goto L64
    L33:
        if (r13.equals("scaleY") == false) goto L64;
        r17 = 7;
        goto L64
    L37:
        if (r13.equals("scaleX") == false) goto L64;
        r17 = 6;
        goto L64
    L41:
        if (r13.equals("progress") == false) goto L64;
        r17 = 5;
        goto L64
    L45:
        if (r13.equals("translationZ") == false) goto L64;
        r17 = 4;
        goto L64
    L49:
        if (r13.equals("translationY") == false) goto L64;
        r17 = 3;
        goto L64
    L53:
        if (r13.equals("translationX") == false) goto L64;
        r17 = 2;
        goto L64
    L57:
        if (r13.equals("rotationY") == false) goto L64;
        r17 = 1;
        goto L64
    L61:
        if (r13.equals("rotationX") == false) goto L64;
        r17 = 0;
        goto L64
    }

    public void b(View r10) {
        this.f1875c = r10.getVisibility();
        if (r10.getVisibility() == 0) goto L5;
        float r11 = 0.0f;
    L6:
        this.f1873a = r11;
        this.f1876d = false;
        this.f1877e = r10.getElevation();
        this.f1878f = r10.getRotation();
        this.f1879g = r10.getRotationX();
        this.f1880h = r10.getRotationY();
        this.f1881i = r10.getScaleX();
        this.f1882j = r10.getScaleY();
        this.f1883k = r10.getPivotX();
        this.f1884l = r10.getPivotY();
        this.f1885m = r10.getTranslationX();
        this.f1886n = r10.getTranslationY();
        this.f1887o = r10.getTranslationZ();
        return;
    L5:
        r11 = r10.getAlpha();
        goto L6
    }

    public void c(ConstraintSet.a r10) {
        ConstraintSet.d r11 = r10.f2275c;
        int r12 = r11.f2355c;
        this.f1874b = r12;
        int r13 = r11.f2354b;
        this.f1875c = r13;
        if (r13 == 0) goto L6;
        if (r12 != 0) goto L6;
        float r14 = 0.0f;
    L7:
        this.f1873a = r14;
        ConstraintSet.e r15 = r10.f2278f;
        this.f1876d = r15.f2371m;
        this.f1877e = r15.f2372n;
        this.f1878f = r15.f2360b;
        this.f1879g = r15.f2361c;
        this.f1880h = r15.f2362d;
        this.f1881i = r15.f2363e;
        this.f1882j = r15.f2364f;
        this.f1883k = r15.f2365g;
        this.f1884l = r15.f2366h;
        this.f1885m = r15.f2368j;
        this.f1886n = r15.f2369k;
        this.f1887o = r15.f2370l;
        this.f1888p = p001j.c.c(r10.f2276d.f2342d);
        ConstraintSet.c r16 = r10.f2276d;
        this.f1895w = r16.f2347i;
        this.f1889q = r16.f2344f;
        this.f1897y = r16.f2340b;
        this.f1896x = r10.f2275c.f2357e;
        Iterator r17 = r10.f2279g.keySet().iterator();
    L9:
        if (r17.hasNext() == false) goto L13;
        String r18 = (String) r17.next();
        ConstraintAttribute r19 = (ConstraintAttribute) r10.f2279g.get(r18);
        if (r19.f() == false) goto L9;
        this.f1898z.put(r18, r19);
        goto L9
    L13:
        return;
    L6:
        r14 = r11.f2356d;
        goto L7
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Object r10) {
        return d((k) r10);
    }

    public int d(k r10) {
        return Float.compare(this.f1890r, r10.f1890r);
    }

    public final boolean e(float r10, float r11) {
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

    public void f(k r10, HashSet r11) {
        if (e(this.f1873a, r10.f1873a) == false) goto L6;
        r11.add("alpha");
    L6:
        if (e(this.f1877e, r10.f1877e) == false) goto L8;
        r11.add("elevation");
    L8:
        int r12 = this.f1875c;
        int r13 = r10.f1875c;
        if (r12 == r13) goto L16;
        if (this.f1874b != 0) goto L16;
        if (r12 == 0) goto L14;
        if (r13 != 0) goto L16;
    L14:
        r11.add("alpha");
    L16:
        if (e(this.f1878f, r10.f1878f) == false) goto L19;
        r11.add("rotation");
    L19:
        if (Float.isNaN(this.f1895w) == true) goto L21;
    L22:
        r11.add("transitionPathRotate");
    L24:
        if (Float.isNaN(this.f1896x) == true) goto L26;
    L27:
        r11.add("progress");
    L29:
        if (e(this.f1879g, r10.f1879g) == false) goto L32;
        r11.add("rotationX");
    L32:
        if (e(this.f1880h, r10.f1880h) == false) goto L35;
        r11.add("rotationY");
    L35:
        if (e(this.f1883k, r10.f1883k) == false) goto L38;
        r11.add("transformPivotX");
    L38:
        if (e(this.f1884l, r10.f1884l) == false) goto L41;
        r11.add("transformPivotY");
    L41:
        if (e(this.f1881i, r10.f1881i) == false) goto L44;
        r11.add("scaleX");
    L44:
        if (e(this.f1882j, r10.f1882j) == false) goto L47;
        r11.add("scaleY");
    L47:
        if (e(this.f1885m, r10.f1885m) == false) goto L50;
        r11.add("translationX");
    L50:
        if (e(this.f1886n, r10.f1886n) == false) goto L53;
        r11.add("translationY");
    L53:
        if (e(this.f1887o, r10.f1887o) == false) goto L56;
        r11.add("translationZ");
        return;
    L56:
        return;
    L26:
        if (Float.isNaN(r10.f1896x) == true) goto L29;
    L21:
        if (Float.isNaN(r10.f1895w) == true) goto L24;
        goto L22
    }

    public void g(float r10, float r11, float r12, float r13) {
        this.f1891s = r10;
        this.f1892t = r11;
        this.f1893u = r12;
        this.f1894v = r13;
    }

    public void h(Rect r10, ConstraintSet r11, int r12, int r13) {
        g(r10.left, r10.top, r10.width(), r10.height());
        c(r11.E(r13));
        if (r12 != 1) goto L5;
    L14:
        this.f1878f -= 90.0f;
        return;
    L5:
        if (r12 != 2) goto L7;
    L11:
        float r14 = this.f1878f + 90.0f;
        this.f1878f = r14;
        if (r14 <= 180.0f) goto L16;
        this.f1878f = r14 - 360.0f;
        return;
    L16:
        return;
    L7:
        if (r12 == 3) goto L14;
        if (r12 == 4) goto L11;
    }

    public void i(View r10) {
        g(r10.getX(), r10.getY(), r10.getWidth(), r10.getHeight());
        b(r10);
    }
}
