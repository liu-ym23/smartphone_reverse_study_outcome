package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.R$styleable;
import com.google.common.base.Ascii;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class d extends c {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f1839g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f1840h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f1841i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f1842j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f1843k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f1844l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f1845m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f1846n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f1847o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f1848p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f1849q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f1850r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f1851s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public float f1852t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f1853u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f1854v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f1855w;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static SparseIntArray f1856a;

        static {
            SparseIntArray r10 = new SparseIntArray();
            f1856a = r10;
            r10.append(R$styleable.KeyAttribute_android_alpha, 1);
            f1856a.append(R$styleable.KeyAttribute_android_elevation, 2);
            f1856a.append(R$styleable.KeyAttribute_android_rotation, 4);
            f1856a.append(R$styleable.KeyAttribute_android_rotationX, 5);
            f1856a.append(R$styleable.KeyAttribute_android_rotationY, 6);
            f1856a.append(R$styleable.KeyAttribute_android_transformPivotX, 19);
            f1856a.append(R$styleable.KeyAttribute_android_transformPivotY, 20);
            f1856a.append(R$styleable.KeyAttribute_android_scaleX, 7);
            f1856a.append(R$styleable.KeyAttribute_transitionPathRotate, 8);
            f1856a.append(R$styleable.KeyAttribute_transitionEasing, 9);
            f1856a.append(R$styleable.KeyAttribute_motionTarget, 10);
            f1856a.append(R$styleable.KeyAttribute_framePosition, 12);
            f1856a.append(R$styleable.KeyAttribute_curveFit, 13);
            f1856a.append(R$styleable.KeyAttribute_android_scaleY, 14);
            f1856a.append(R$styleable.KeyAttribute_android_translationX, 15);
            f1856a.append(R$styleable.KeyAttribute_android_translationY, 16);
            f1856a.append(R$styleable.KeyAttribute_android_translationZ, 17);
            f1856a.append(R$styleable.KeyAttribute_motionProgress, 18);
        }

        public static void a(d r10, TypedArray r11) {
            int r12 = r11.getIndexCount();
            int r13 = 0;
        L3:
            if (r13 >= r12) goto L34;
            int r14 = r11.getIndex(r13);
            switch(f1856a.get(r14)) {
                case 1: goto L32;
                case 2: goto L31;
                case 3: goto L6;
                case 4: goto L30;
                case 5: goto L29;
                case 6: goto L28;
                case 7: goto L27;
                case 8: goto L26;
                case 9: goto L25;
                case 10: goto L17;
                case 11: goto L6;
                case 12: goto L15;
                case 13: goto L14;
                case 14: goto L13;
                case 15: goto L12;
                case 16: goto L11;
                case 17: goto L10;
                case 18: goto L9;
                case 19: goto L8;
                case 20: goto L7;
                default: goto L6;
            };
        L6:
            Log.e("KeyAttribute", "unused attribute 0x" + Integer.toHexString(r14) + "   " + f1856a.get(r14));
        L33:
            r13 = r13 + 1;
            goto L3
        L7:
            d.P(r10, r11.getDimension(r14, d.O(r10)));
            goto L33
        L8:
            d.N(r10, r11.getDimension(r14, d.M(r10)));
            goto L33
        L9:
            d.B(r10, r11.getFloat(r14, d.A(r10)));
            goto L33
        L10:
            d.z(r10, r11.getDimension(r14, d.y(r10)));
            goto L33
        L11:
            d.x(r10, r11.getDimension(r14, d.w(r10)));
            goto L33
        L12:
            d.v(r10, r11.getDimension(r14, d.u(r10)));
            goto L33
        L13:
            d.q(r10, r11.getFloat(r14, d.p(r10)));
            goto L33
        L14:
            d.F(r10, r11.getInteger(r14, d.E(r10)));
            goto L33
        L15:
            r10.f1834a = r11.getInt(r14, r10.f1834a);
            goto L33
        L25:
            d.Q(r10, r11.getString(r14));
            goto L33
        L26:
            d.t(r10, r11.getFloat(r14, d.s(r10)));
            goto L33
        L27:
            d.H(r10, r11.getFloat(r14, d.G(r10)));
            goto L33
        L28:
            d.L(r10, r11.getFloat(r14, d.K(r10)));
            goto L33
        L29:
            d.J(r10, r11.getFloat(r14, d.I(r10)));
            goto L33
        L30:
            d.D(r10, r11.getFloat(r14, d.C(r10)));
            goto L33
        L31:
            d.r(r10, r11.getDimension(r14, d.o(r10)));
            goto L33
        L32:
            d.n(r10, r11.getFloat(r14, d.m(r10)));
            goto L33
        L17:
            if (MotionLayout.E0 == false) goto L22;
            int r15 = r11.getResourceId(r14, r10.f1835b);
            r10.f1835b = r15;
            if (r15 != (-1)) goto L33;
            r10.f1836c = r11.getString(r14);
            goto L33
        L22:
            if (r11.peekValue(r14).type != 3) goto L24;
            r10.f1836c = r11.getString(r14);
            goto L33
        L24:
            r10.f1835b = r11.getResourceId(r14, r10.f1835b);
            goto L33
        }
    }

    public d() {
        this.f1840h = -1;
        this.f1841i = false;
        this.f1842j = Float.NaN;
        this.f1843k = Float.NaN;
        this.f1844l = Float.NaN;
        this.f1845m = Float.NaN;
        this.f1846n = Float.NaN;
        this.f1847o = Float.NaN;
        this.f1848p = Float.NaN;
        this.f1849q = Float.NaN;
        this.f1850r = Float.NaN;
        this.f1851s = Float.NaN;
        this.f1852t = Float.NaN;
        this.f1853u = Float.NaN;
        this.f1854v = Float.NaN;
        this.f1855w = Float.NaN;
        this.f1837d = 1;
        this.f1838e = new HashMap();
    }

    public static /* synthetic */ float A(d r10) {
        return r10.f1855w;
    }

    public static /* synthetic */ float B(d r10, float r11) {
        r10.f1855w = r11;
        return r11;
    }

    public static /* synthetic */ float C(d r10) {
        return r10.f1844l;
    }

    public static /* synthetic */ float D(d r10, float r11) {
        r10.f1844l = r11;
        return r11;
    }

    public static /* synthetic */ int E(d r10) {
        return r10.f1840h;
    }

    public static /* synthetic */ int F(d r10, int r11) {
        r10.f1840h = r11;
        return r11;
    }

    public static /* synthetic */ float G(d r10) {
        return r10.f1850r;
    }

    public static /* synthetic */ float H(d r10, float r11) {
        r10.f1850r = r11;
        return r11;
    }

    public static /* synthetic */ float I(d r10) {
        return r10.f1845m;
    }

    public static /* synthetic */ float J(d r10, float r11) {
        r10.f1845m = r11;
        return r11;
    }

    public static /* synthetic */ float K(d r10) {
        return r10.f1846n;
    }

    public static /* synthetic */ float L(d r10, float r11) {
        r10.f1846n = r11;
        return r11;
    }

    public static /* synthetic */ float M(d r10) {
        return r10.f1847o;
    }

    public static /* synthetic */ float N(d r10, float r11) {
        r10.f1847o = r11;
        return r11;
    }

    public static /* synthetic */ float O(d r10) {
        return r10.f1848p;
    }

    public static /* synthetic */ float P(d r10, float r11) {
        r10.f1848p = r11;
        return r11;
    }

    public static /* synthetic */ String Q(d r10, String r11) {
        r10.f1839g = r11;
        return r11;
    }

    public static /* synthetic */ float m(d r10) {
        return r10.f1842j;
    }

    public static /* synthetic */ float n(d r10, float r11) {
        r10.f1842j = r11;
        return r11;
    }

    public static /* synthetic */ float o(d r10) {
        return r10.f1843k;
    }

    public static /* synthetic */ float p(d r10) {
        return r10.f1851s;
    }

    public static /* synthetic */ float q(d r10, float r11) {
        r10.f1851s = r11;
        return r11;
    }

    public static /* synthetic */ float r(d r10, float r11) {
        r10.f1843k = r11;
        return r11;
    }

    public static /* synthetic */ float s(d r10) {
        return r10.f1849q;
    }

    public static /* synthetic */ float t(d r10, float r11) {
        r10.f1849q = r11;
        return r11;
    }

    public static /* synthetic */ float u(d r10) {
        return r10.f1852t;
    }

    public static /* synthetic */ float v(d r10, float r11) {
        r10.f1852t = r11;
        return r11;
    }

    public static /* synthetic */ float w(d r10) {
        return r10.f1853u;
    }

    public static /* synthetic */ float x(d r10, float r11) {
        r10.f1853u = r11;
        return r11;
    }

    public static /* synthetic */ float y(d r10) {
        return r10.f1854v;
    }

    public static /* synthetic */ float z(d r10, float r11) {
        r10.f1854v = r11;
        return r11;
    }

    public void R(String r10, Object r11) {
        r10.hashCode();
        byte r12 = -1;
        switch(r10.hashCode()) {
            case -1913008125: goto L70;
            case -1812823328: goto L66;
            case -1249320806: goto L62;
            case -1249320805: goto L58;
            case -1225497657: goto L54;
            case -1225497656: goto L50;
            case -1225497655: goto L46;
            case -908189618: goto L42;
            case -908189617: goto L38;
            case -760884510: goto L34;
            case -760884509: goto L30;
            case -40300674: goto L26;
            case -4379043: goto L22;
            case 37232917: goto L18;
            case 92909918: goto L14;
            case 579057826: goto L10;
            case 1941332754: goto L6;
            default: goto L73;
        };
    L73:
        switch(r12) {
            case 0: goto L91;
            case 1: goto L90;
            case 2: goto L89;
            case 3: goto L88;
            case 4: goto L87;
            case 5: goto L86;
            case 6: goto L85;
            case 7: goto L84;
            case 8: goto L83;
            case 9: goto L82;
            case 10: goto L81;
            case 11: goto L80;
            case 12: goto L79;
            case 13: goto L78;
            case 14: goto L77;
            case 15: goto L76;
            case 16: goto L75;
            default: goto L109;
        };
    L75:
        this.f1841i = j(r11);
        return;
    L76:
        this.f1840h = l(r11);
        return;
    L77:
        this.f1842j = k(r11);
        return;
    L78:
        this.f1849q = k(r11);
        return;
    L79:
        this.f1843k = k(r11);
        return;
    L80:
        this.f1844l = k(r11);
        return;
    L81:
        this.f1848p = k(r11);
        return;
    L82:
        this.f1847o = k(r11);
        return;
    L83:
        this.f1851s = k(r11);
        return;
    L84:
        this.f1850r = k(r11);
        return;
    L85:
        this.f1854v = k(r11);
        return;
    L86:
        this.f1853u = k(r11);
        return;
    L87:
        this.f1852t = k(r11);
        return;
    L88:
        this.f1846n = k(r11);
        return;
    L89:
        this.f1845m = k(r11);
        return;
    L90:
        this.f1839g = r11.toString();
        return;
    L91:
        this.f1855w = k(r11);
        return;
    L109:
        return;
    L6:
        if (r10.equals("visibility") == false) goto L73;
        r12 = Ascii.DLE;
        goto L73
    L10:
        if (r10.equals("curveFit") == false) goto L73;
        r12 = Ascii.SI;
        goto L73
    L14:
        if (r10.equals("alpha") == false) goto L73;
        r12 = Ascii.SO;
        goto L73
    L18:
        if (r10.equals("transitionPathRotate") == false) goto L73;
        r12 = Ascii.CR;
        goto L73
    L22:
        if (r10.equals("elevation") == false) goto L73;
        r12 = Ascii.FF;
        goto L73
    L26:
        if (r10.equals("rotation") == false) goto L73;
        r12 = Ascii.VT;
        goto L73
    L30:
        if (r10.equals("transformPivotY") == false) goto L73;
        r12 = 10;
        goto L73
    L34:
        if (r10.equals("transformPivotX") == false) goto L73;
        r12 = 9;
        goto L73
    L38:
        if (r10.equals("scaleY") == false) goto L73;
        r12 = 8;
        goto L73
    L42:
        if (r10.equals("scaleX") == false) goto L73;
        r12 = 7;
        goto L73
    L46:
        if (r10.equals("translationZ") == false) goto L73;
        r12 = 6;
        goto L73
    L50:
        if (r10.equals("translationY") == false) goto L73;
        r12 = 5;
        goto L73
    L54:
        if (r10.equals("translationX") == false) goto L73;
        r12 = 4;
        goto L73
    L58:
        if (r10.equals("rotationY") == false) goto L73;
        r12 = 3;
        goto L73
    L62:
        if (r10.equals("rotationX") == false) goto L73;
        r12 = 2;
        goto L73
    L66:
        if (r10.equals("transitionEasing") == false) goto L73;
        r12 = 1;
        goto L73
    L70:
        if (r10.equals("motionProgress") == false) goto L73;
        r12 = 0;
        goto L73
    }

    @Override // androidx.constraintlayout.motion.widget.c
    public void a(HashMap r10) {
        Iterator r11 = r10.keySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L116;
        String r12 = (String) r11.next();
        androidx.constraintlayout.core.motion.utils.b r13 = (androidx.constraintlayout.core.motion.utils.b) r10.get(r12);
        if (r13 == null) goto L4;
        if (r12.startsWith("CUSTOM") == true) goto L10;
        byte r14 = -1;
        switch(r12.hashCode()) {
            case -1249320806: goto L69;
            case -1249320805: goto L65;
            case -1225497657: goto L61;
            case -1225497656: goto L57;
            case -1225497655: goto L53;
            case -1001078227: goto L49;
            case -908189618: goto L45;
            case -908189617: goto L41;
            case -760884510: goto L37;
            case -760884509: goto L33;
            case -40300674: goto L29;
            case -4379043: goto L25;
            case 37232917: goto L21;
            case 92909918: goto L17;
            default: goto L72;
        };
    L72:
        switch(r14) {
            case 0: goto L114;
            case 1: goto L111;
            case 2: goto L108;
            case 3: goto L105;
            case 4: goto L102;
            case 5: goto L99;
            case 6: goto L96;
            case 7: goto L93;
            case 8: goto L90;
            case 9: goto L87;
            case 10: goto L84;
            case 11: goto L81;
            case 12: goto L78;
            case 13: goto L75;
            default: goto L4;
        };
    L75:
        if (Float.isNaN(this.f1842j) == true) goto L4;
        r13.c(this.f1834a, this.f1842j);
        goto L4
    L78:
        if (Float.isNaN(this.f1849q) == true) goto L4;
        r13.c(this.f1834a, this.f1849q);
        goto L4
    L81:
        if (Float.isNaN(this.f1843k) == true) goto L4;
        r13.c(this.f1834a, this.f1843k);
        goto L4
    L84:
        if (Float.isNaN(this.f1844l) == true) goto L4;
        r13.c(this.f1834a, this.f1844l);
        goto L4
    L87:
        if (Float.isNaN(this.f1846n) == true) goto L4;
        r13.c(this.f1834a, this.f1848p);
        goto L4
    L90:
        if (Float.isNaN(this.f1845m) == true) goto L4;
        r13.c(this.f1834a, this.f1847o);
        goto L4
    L93:
        if (Float.isNaN(this.f1851s) == true) goto L4;
        r13.c(this.f1834a, this.f1851s);
        goto L4
    L96:
        if (Float.isNaN(this.f1850r) == true) goto L4;
        r13.c(this.f1834a, this.f1850r);
        goto L4
    L99:
        if (Float.isNaN(this.f1855w) == true) goto L4;
        r13.c(this.f1834a, this.f1855w);
        goto L4
    L102:
        if (Float.isNaN(this.f1854v) == true) goto L4;
        r13.c(this.f1834a, this.f1854v);
        goto L4
    L105:
        if (Float.isNaN(this.f1853u) == true) goto L4;
        r13.c(this.f1834a, this.f1853u);
        goto L4
    L108:
        if (Float.isNaN(this.f1852t) == true) goto L4;
        r13.c(this.f1834a, this.f1852t);
        goto L4
    L111:
        if (Float.isNaN(this.f1846n) == true) goto L4;
        r13.c(this.f1834a, this.f1846n);
        goto L4
    L114:
        if (Float.isNaN(this.f1845m) == true) goto L4;
        r13.c(this.f1834a, this.f1845m);
        goto L4
    L17:
        if (r12.equals("alpha") == false) goto L72;
        r14 = Ascii.CR;
        goto L72
    L21:
        if (r12.equals("transitionPathRotate") == false) goto L72;
        r14 = Ascii.FF;
        goto L72
    L25:
        if (r12.equals("elevation") == false) goto L72;
        r14 = Ascii.VT;
        goto L72
    L29:
        if (r12.equals("rotation") == false) goto L72;
        r14 = 10;
        goto L72
    L33:
        if (r12.equals("transformPivotY") == false) goto L72;
        r14 = 9;
        goto L72
    L37:
        if (r12.equals("transformPivotX") == false) goto L72;
        r14 = 8;
        goto L72
    L41:
        if (r12.equals("scaleY") == false) goto L72;
        r14 = 7;
        goto L72
    L45:
        if (r12.equals("scaleX") == false) goto L72;
        r14 = 6;
        goto L72
    L49:
        if (r12.equals("progress") == false) goto L72;
        r14 = 5;
        goto L72
    L53:
        if (r12.equals("translationZ") == false) goto L72;
        r14 = 4;
        goto L72
    L57:
        if (r12.equals("translationY") == false) goto L72;
        r14 = 3;
        goto L72
    L61:
        if (r12.equals("translationX") == false) goto L72;
        r14 = 2;
        goto L72
    L65:
        if (r12.equals("rotationY") == false) goto L72;
        r14 = 1;
        goto L72
    L69:
        if (r12.equals("rotationX") == false) goto L72;
        r14 = 0;
        goto L72
    L10:
        ConstraintAttribute r15 = (ConstraintAttribute) this.f1838e.get(r12.substring(7));
        if (r15 == null) goto L4;
        ((m.d.b) r13).i(this.f1834a, r15);
        goto L4
    }

    @Override // androidx.constraintlayout.motion.widget.c
    public c b() {
        return new d().c(this);
    }

    @Override // androidx.constraintlayout.motion.widget.c
    public c c(c r10) {
        super.c(r10);
        d r11 = (d) r10;
        this.f1840h = r11.f1840h;
        this.f1841i = r11.f1841i;
        this.f1842j = r11.f1842j;
        this.f1843k = r11.f1843k;
        this.f1844l = r11.f1844l;
        this.f1845m = r11.f1845m;
        this.f1846n = r11.f1846n;
        this.f1847o = r11.f1847o;
        this.f1848p = r11.f1848p;
        this.f1849q = r11.f1849q;
        this.f1850r = r11.f1850r;
        this.f1851s = r11.f1851s;
        this.f1852t = r11.f1852t;
        this.f1853u = r11.f1853u;
        this.f1854v = r11.f1854v;
        this.f1855w = r11.f1855w;
        return this;
    }

    public /* bridge */ /* synthetic */ Object clone() {
        return b();
    }

    @Override // androidx.constraintlayout.motion.widget.c
    public void d(HashSet r10) {
        if (Float.isNaN(this.f1842j) == true) goto L6;
        r10.add("alpha");
    L6:
        if (Float.isNaN(this.f1843k) == true) goto L9;
        r10.add("elevation");
    L9:
        if (Float.isNaN(this.f1844l) == true) goto L12;
        r10.add("rotation");
    L12:
        if (Float.isNaN(this.f1845m) == true) goto L15;
        r10.add("rotationX");
    L15:
        if (Float.isNaN(this.f1846n) == true) goto L18;
        r10.add("rotationY");
    L18:
        if (Float.isNaN(this.f1847o) == true) goto L21;
        r10.add("transformPivotX");
    L21:
        if (Float.isNaN(this.f1848p) == true) goto L24;
        r10.add("transformPivotY");
    L24:
        if (Float.isNaN(this.f1852t) == true) goto L27;
        r10.add("translationX");
    L27:
        if (Float.isNaN(this.f1853u) == true) goto L30;
        r10.add("translationY");
    L30:
        if (Float.isNaN(this.f1854v) == true) goto L33;
        r10.add("translationZ");
    L33:
        if (Float.isNaN(this.f1849q) == true) goto L36;
        r10.add("transitionPathRotate");
    L36:
        if (Float.isNaN(this.f1850r) == true) goto L39;
        r10.add("scaleX");
    L39:
        if (Float.isNaN(this.f1851s) == true) goto L42;
        r10.add("scaleY");
    L42:
        if (Float.isNaN(this.f1855w) == true) goto L45;
        r10.add("progress");
    L45:
        if (this.f1838e.size() <= 0) goto L50;
        Iterator r11 = this.f1838e.keySet().iterator();
    L48:
        if (r11.hasNext() == false) goto L52;
        r10.add("CUSTOM," + ((String) r11.next()));
        goto L48
    L52:
        return;
    }

    @Override // androidx.constraintlayout.motion.widget.c
    public void e(Context r10, AttributeSet r11) {
        a.a(this, r10.obtainStyledAttributes(r11, R$styleable.KeyAttribute));
    }

    @Override // androidx.constraintlayout.motion.widget.c
    public void h(HashMap r10) {
        if (this.f1840h != (-1)) goto L6;
        return;
    L6:
        if (Float.isNaN(this.f1842j) == true) goto L9;
        r10.put("alpha", Integer.valueOf(this.f1840h));
    L9:
        if (Float.isNaN(this.f1843k) == true) goto L12;
        r10.put("elevation", Integer.valueOf(this.f1840h));
    L12:
        if (Float.isNaN(this.f1844l) == true) goto L15;
        r10.put("rotation", Integer.valueOf(this.f1840h));
    L15:
        if (Float.isNaN(this.f1845m) == true) goto L18;
        r10.put("rotationX", Integer.valueOf(this.f1840h));
    L18:
        if (Float.isNaN(this.f1846n) == true) goto L21;
        r10.put("rotationY", Integer.valueOf(this.f1840h));
    L21:
        if (Float.isNaN(this.f1847o) == true) goto L24;
        r10.put("transformPivotX", Integer.valueOf(this.f1840h));
    L24:
        if (Float.isNaN(this.f1848p) == true) goto L27;
        r10.put("transformPivotY", Integer.valueOf(this.f1840h));
    L27:
        if (Float.isNaN(this.f1852t) == true) goto L30;
        r10.put("translationX", Integer.valueOf(this.f1840h));
    L30:
        if (Float.isNaN(this.f1853u) == true) goto L33;
        r10.put("translationY", Integer.valueOf(this.f1840h));
    L33:
        if (Float.isNaN(this.f1854v) == true) goto L36;
        r10.put("translationZ", Integer.valueOf(this.f1840h));
    L36:
        if (Float.isNaN(this.f1849q) == true) goto L39;
        r10.put("transitionPathRotate", Integer.valueOf(this.f1840h));
    L39:
        if (Float.isNaN(this.f1850r) == true) goto L42;
        r10.put("scaleX", Integer.valueOf(this.f1840h));
    L42:
        if (Float.isNaN(this.f1851s) == true) goto L45;
        r10.put("scaleY", Integer.valueOf(this.f1840h));
    L45:
        if (Float.isNaN(this.f1855w) == true) goto L48;
        r10.put("progress", Integer.valueOf(this.f1840h));
    L48:
        if (this.f1838e.size() <= 0) goto L53;
        Iterator r11 = this.f1838e.keySet().iterator();
    L51:
        if (r11.hasNext() == false) goto L55;
        r10.put("CUSTOM," + ((String) r11.next()), Integer.valueOf(this.f1840h));
        goto L51
    L55:
        return;
    }
}
