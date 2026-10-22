package com.obric.oui.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import com.google.common.base.Ascii;
import com.obric.oui.constraintlayout.widget.ConstraintAttribute;
import com.obric.oui.constraintlayout.widget.R$styleable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
public class d extends c {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f13650g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f13651h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f13652i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f13653j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f13654k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f13655l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f13656m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f13657n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f13658o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f13659p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f13660q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f13661r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f13662s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public float f13663t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f13664u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f13665v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f13666w;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static SparseIntArray f13667a;

        static {
            SparseIntArray r10 = new SparseIntArray();
            f13667a = r10;
            r10.append(R$styleable.KeyAttribute_android_alpha, 1);
            f13667a.append(R$styleable.KeyAttribute_android_elevation, 2);
            f13667a.append(R$styleable.KeyAttribute_android_rotation, 4);
            f13667a.append(R$styleable.KeyAttribute_android_rotationX, 5);
            f13667a.append(R$styleable.KeyAttribute_android_rotationY, 6);
            f13667a.append(R$styleable.KeyAttribute_android_transformPivotX, 19);
            f13667a.append(R$styleable.KeyAttribute_android_transformPivotY, 20);
            f13667a.append(R$styleable.KeyAttribute_android_scaleX, 7);
            f13667a.append(R$styleable.KeyAttribute_transitionPathRotate, 8);
            f13667a.append(R$styleable.KeyAttribute_transitionEasing, 9);
            f13667a.append(R$styleable.KeyAttribute_motionTarget, 10);
            f13667a.append(R$styleable.KeyAttribute_framePosition, 12);
            f13667a.append(R$styleable.KeyAttribute_curveFit, 13);
            f13667a.append(R$styleable.KeyAttribute_android_scaleY, 14);
            f13667a.append(R$styleable.KeyAttribute_android_translationX, 15);
            f13667a.append(R$styleable.KeyAttribute_android_translationY, 16);
            f13667a.append(R$styleable.KeyAttribute_android_translationZ, 17);
            f13667a.append(R$styleable.KeyAttribute_motionProgress, 18);
        }

        public static void a(d r10, TypedArray r11) {
            int r12 = r11.getIndexCount();
            int r13 = 0;
        L3:
            if (r13 >= r12) goto L34;
            int r14 = r11.getIndex(r13);
            switch(f13667a.get(r14)) {
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
            Log.e("KeyAttribute", "unused attribute 0x" + Integer.toHexString(r14) + "   " + f13667a.get(r14));
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
            r10.f13645a = r11.getInt(r14, r10.f13645a);
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
            if (MotionLayout.f13558d1 == false) goto L22;
            int r15 = r11.getResourceId(r14, r10.f13646b);
            r10.f13646b = r15;
            if (r15 != (-1)) goto L33;
            r10.f13647c = r11.getString(r14);
            goto L33
        L22:
            if (r11.peekValue(r14).type != 3) goto L24;
            r10.f13647c = r11.getString(r14);
            goto L33
        L24:
            r10.f13646b = r11.getResourceId(r14, r10.f13646b);
            goto L33
        }
    }

    public d() {
        this.f13651h = -1;
        this.f13652i = false;
        this.f13653j = Float.NaN;
        this.f13654k = Float.NaN;
        this.f13655l = Float.NaN;
        this.f13656m = Float.NaN;
        this.f13657n = Float.NaN;
        this.f13658o = Float.NaN;
        this.f13659p = Float.NaN;
        this.f13660q = Float.NaN;
        this.f13661r = Float.NaN;
        this.f13662s = Float.NaN;
        this.f13663t = Float.NaN;
        this.f13664u = Float.NaN;
        this.f13665v = Float.NaN;
        this.f13666w = Float.NaN;
        this.f13648d = 1;
        this.f13649e = new HashMap();
    }

    public static /* synthetic */ float A(d r10) {
        return r10.f13666w;
    }

    public static /* synthetic */ float B(d r10, float r11) {
        r10.f13666w = r11;
        return r11;
    }

    public static /* synthetic */ float C(d r10) {
        return r10.f13655l;
    }

    public static /* synthetic */ float D(d r10, float r11) {
        r10.f13655l = r11;
        return r11;
    }

    public static /* synthetic */ int E(d r10) {
        return r10.f13651h;
    }

    public static /* synthetic */ int F(d r10, int r11) {
        r10.f13651h = r11;
        return r11;
    }

    public static /* synthetic */ float G(d r10) {
        return r10.f13661r;
    }

    public static /* synthetic */ float H(d r10, float r11) {
        r10.f13661r = r11;
        return r11;
    }

    public static /* synthetic */ float I(d r10) {
        return r10.f13656m;
    }

    public static /* synthetic */ float J(d r10, float r11) {
        r10.f13656m = r11;
        return r11;
    }

    public static /* synthetic */ float K(d r10) {
        return r10.f13657n;
    }

    public static /* synthetic */ float L(d r10, float r11) {
        r10.f13657n = r11;
        return r11;
    }

    public static /* synthetic */ float M(d r10) {
        return r10.f13658o;
    }

    public static /* synthetic */ float N(d r10, float r11) {
        r10.f13658o = r11;
        return r11;
    }

    public static /* synthetic */ float O(d r10) {
        return r10.f13659p;
    }

    public static /* synthetic */ float P(d r10, float r11) {
        r10.f13659p = r11;
        return r11;
    }

    public static /* synthetic */ String Q(d r10, String r11) {
        r10.f13650g = r11;
        return r11;
    }

    public static /* synthetic */ float m(d r10) {
        return r10.f13653j;
    }

    public static /* synthetic */ float n(d r10, float r11) {
        r10.f13653j = r11;
        return r11;
    }

    public static /* synthetic */ float o(d r10) {
        return r10.f13654k;
    }

    public static /* synthetic */ float p(d r10) {
        return r10.f13662s;
    }

    public static /* synthetic */ float q(d r10, float r11) {
        r10.f13662s = r11;
        return r11;
    }

    public static /* synthetic */ float r(d r10, float r11) {
        r10.f13654k = r11;
        return r11;
    }

    public static /* synthetic */ float s(d r10) {
        return r10.f13660q;
    }

    public static /* synthetic */ float t(d r10, float r11) {
        r10.f13660q = r11;
        return r11;
    }

    public static /* synthetic */ float u(d r10) {
        return r10.f13663t;
    }

    public static /* synthetic */ float v(d r10, float r11) {
        r10.f13663t = r11;
        return r11;
    }

    public static /* synthetic */ float w(d r10) {
        return r10.f13664u;
    }

    public static /* synthetic */ float x(d r10, float r11) {
        r10.f13664u = r11;
        return r11;
    }

    public static /* synthetic */ float y(d r10) {
        return r10.f13665v;
    }

    public static /* synthetic */ float z(d r10, float r11) {
        r10.f13665v = r11;
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
        this.f13652i = j(r11);
        return;
    L76:
        this.f13651h = l(r11);
        return;
    L77:
        this.f13653j = k(r11);
        return;
    L78:
        this.f13660q = k(r11);
        return;
    L79:
        this.f13654k = k(r11);
        return;
    L80:
        this.f13655l = k(r11);
        return;
    L81:
        this.f13659p = k(r11);
        return;
    L82:
        this.f13658o = k(r11);
        return;
    L83:
        this.f13662s = k(r11);
        return;
    L84:
        this.f13661r = k(r11);
        return;
    L85:
        this.f13665v = k(r11);
        return;
    L86:
        this.f13664u = k(r11);
        return;
    L87:
        this.f13663t = k(r11);
        return;
    L88:
        this.f13657n = k(r11);
        return;
    L89:
        this.f13656m = k(r11);
        return;
    L90:
        this.f13650g = r11.toString();
        return;
    L91:
        this.f13666w = k(r11);
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

    @Override // com.obric.oui.constraintlayout.motion.widget.c
    public void a(HashMap r10) {
        Iterator r11 = r10.keySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L116;
        String r12 = (String) r11.next();
        com.obric.oui.constraintlayout.core.motion.utils.b r13 = (com.obric.oui.constraintlayout.core.motion.utils.b) r10.get(r12);
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
        if (Float.isNaN(this.f13653j) == true) goto L4;
        r13.c(this.f13645a, this.f13653j);
        goto L4
    L78:
        if (Float.isNaN(this.f13660q) == true) goto L4;
        r13.c(this.f13645a, this.f13660q);
        goto L4
    L81:
        if (Float.isNaN(this.f13654k) == true) goto L4;
        r13.c(this.f13645a, this.f13654k);
        goto L4
    L84:
        if (Float.isNaN(this.f13655l) == true) goto L4;
        r13.c(this.f13645a, this.f13655l);
        goto L4
    L87:
        if (Float.isNaN(this.f13657n) == true) goto L4;
        r13.c(this.f13645a, this.f13659p);
        goto L4
    L90:
        if (Float.isNaN(this.f13656m) == true) goto L4;
        r13.c(this.f13645a, this.f13658o);
        goto L4
    L93:
        if (Float.isNaN(this.f13662s) == true) goto L4;
        r13.c(this.f13645a, this.f13662s);
        goto L4
    L96:
        if (Float.isNaN(this.f13661r) == true) goto L4;
        r13.c(this.f13645a, this.f13661r);
        goto L4
    L99:
        if (Float.isNaN(this.f13666w) == true) goto L4;
        r13.c(this.f13645a, this.f13666w);
        goto L4
    L102:
        if (Float.isNaN(this.f13665v) == true) goto L4;
        r13.c(this.f13645a, this.f13665v);
        goto L4
    L105:
        if (Float.isNaN(this.f13664u) == true) goto L4;
        r13.c(this.f13645a, this.f13664u);
        goto L4
    L108:
        if (Float.isNaN(this.f13663t) == true) goto L4;
        r13.c(this.f13645a, this.f13663t);
        goto L4
    L111:
        if (Float.isNaN(this.f13657n) == true) goto L4;
        r13.c(this.f13645a, this.f13657n);
        goto L4
    L114:
        if (Float.isNaN(this.f13656m) == true) goto L4;
        r13.c(this.f13645a, this.f13656m);
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
        ConstraintAttribute r15 = (ConstraintAttribute) this.f13649e.get(r12.substring(7));
        if (r15 == null) goto L4;
        ((yc.d.b) r13).i(this.f13645a, r15);
        goto L4
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.c
    public c b() {
        return new d().c(this);
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.c
    public c c(c r10) {
        super.c(r10);
        d r11 = (d) r10;
        this.f13651h = r11.f13651h;
        this.f13652i = r11.f13652i;
        this.f13653j = r11.f13653j;
        this.f13654k = r11.f13654k;
        this.f13655l = r11.f13655l;
        this.f13656m = r11.f13656m;
        this.f13657n = r11.f13657n;
        this.f13658o = r11.f13658o;
        this.f13659p = r11.f13659p;
        this.f13660q = r11.f13660q;
        this.f13661r = r11.f13661r;
        this.f13662s = r11.f13662s;
        this.f13663t = r11.f13663t;
        this.f13664u = r11.f13664u;
        this.f13665v = r11.f13665v;
        this.f13666w = r11.f13666w;
        this.f13650g = r11.f13650g;
        return this;
    }

    public /* bridge */ /* synthetic */ Object clone() {
        return b();
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.c
    public void d(HashSet r10) {
        if (Float.isNaN(this.f13653j) == true) goto L6;
        r10.add("alpha");
    L6:
        if (Float.isNaN(this.f13654k) == true) goto L9;
        r10.add("elevation");
    L9:
        if (Float.isNaN(this.f13655l) == true) goto L12;
        r10.add("rotation");
    L12:
        if (Float.isNaN(this.f13656m) == true) goto L15;
        r10.add("rotationX");
    L15:
        if (Float.isNaN(this.f13657n) == true) goto L18;
        r10.add("rotationY");
    L18:
        if (Float.isNaN(this.f13658o) == true) goto L21;
        r10.add("transformPivotX");
    L21:
        if (Float.isNaN(this.f13659p) == true) goto L24;
        r10.add("transformPivotY");
    L24:
        if (Float.isNaN(this.f13663t) == true) goto L27;
        r10.add("translationX");
    L27:
        if (Float.isNaN(this.f13664u) == true) goto L30;
        r10.add("translationY");
    L30:
        if (Float.isNaN(this.f13665v) == true) goto L33;
        r10.add("translationZ");
    L33:
        if (Float.isNaN(this.f13660q) == true) goto L36;
        r10.add("transitionPathRotate");
    L36:
        if (Float.isNaN(this.f13661r) == true) goto L39;
        r10.add("scaleX");
    L39:
        if (Float.isNaN(this.f13662s) == true) goto L42;
        r10.add("scaleY");
    L42:
        if (Float.isNaN(this.f13666w) == true) goto L45;
        r10.add("progress");
    L45:
        if (this.f13649e.size() <= 0) goto L50;
        Iterator r11 = this.f13649e.keySet().iterator();
    L48:
        if (r11.hasNext() == false) goto L52;
        r10.add("CUSTOM," + ((String) r11.next()));
        goto L48
    L52:
        return;
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.c
    public void e(Context r10, AttributeSet r11) {
        a.a(this, r10.obtainStyledAttributes(r11, R$styleable.KeyAttribute));
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.c
    public void h(HashMap r10) {
        if (this.f13651h != (-1)) goto L6;
        return;
    L6:
        if (Float.isNaN(this.f13653j) == true) goto L9;
        r10.put("alpha", Integer.valueOf(this.f13651h));
    L9:
        if (Float.isNaN(this.f13654k) == true) goto L12;
        r10.put("elevation", Integer.valueOf(this.f13651h));
    L12:
        if (Float.isNaN(this.f13655l) == true) goto L15;
        r10.put("rotation", Integer.valueOf(this.f13651h));
    L15:
        if (Float.isNaN(this.f13656m) == true) goto L18;
        r10.put("rotationX", Integer.valueOf(this.f13651h));
    L18:
        if (Float.isNaN(this.f13657n) == true) goto L21;
        r10.put("rotationY", Integer.valueOf(this.f13651h));
    L21:
        if (Float.isNaN(this.f13658o) == true) goto L24;
        r10.put("transformPivotX", Integer.valueOf(this.f13651h));
    L24:
        if (Float.isNaN(this.f13659p) == true) goto L27;
        r10.put("transformPivotY", Integer.valueOf(this.f13651h));
    L27:
        if (Float.isNaN(this.f13663t) == true) goto L30;
        r10.put("translationX", Integer.valueOf(this.f13651h));
    L30:
        if (Float.isNaN(this.f13664u) == true) goto L33;
        r10.put("translationY", Integer.valueOf(this.f13651h));
    L33:
        if (Float.isNaN(this.f13665v) == true) goto L36;
        r10.put("translationZ", Integer.valueOf(this.f13651h));
    L36:
        if (Float.isNaN(this.f13660q) == true) goto L39;
        r10.put("transitionPathRotate", Integer.valueOf(this.f13651h));
    L39:
        if (Float.isNaN(this.f13661r) == true) goto L42;
        r10.put("scaleX", Integer.valueOf(this.f13651h));
    L42:
        if (Float.isNaN(this.f13662s) == true) goto L45;
        r10.put("scaleY", Integer.valueOf(this.f13651h));
    L45:
        if (Float.isNaN(this.f13666w) == true) goto L48;
        r10.put("progress", Integer.valueOf(this.f13651h));
    L48:
        if (this.f13649e.size() <= 0) goto L53;
        Iterator r11 = this.f13649e.keySet().iterator();
    L51:
        if (r11.hasNext() == false) goto L55;
        r10.put("CUSTOM," + ((String) r11.next()), Integer.valueOf(this.f13651h));
        goto L51
    L55:
        return;
    }
}
