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
public class i extends c {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f13705g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f13706h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f13707i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f13708j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f13709k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f13710l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f13711m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f13712n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f13713o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f13714p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f13715q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f13716r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f13717s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public float f13718t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f13719u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f13720v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f13721w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f13722x;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static SparseIntArray f13723a;

        static {
            SparseIntArray r10 = new SparseIntArray();
            f13723a = r10;
            r10.append(R$styleable.KeyTimeCycle_android_alpha, 1);
            f13723a.append(R$styleable.KeyTimeCycle_android_elevation, 2);
            f13723a.append(R$styleable.KeyTimeCycle_android_rotation, 4);
            f13723a.append(R$styleable.KeyTimeCycle_android_rotationX, 5);
            f13723a.append(R$styleable.KeyTimeCycle_android_rotationY, 6);
            f13723a.append(R$styleable.KeyTimeCycle_android_scaleX, 7);
            f13723a.append(R$styleable.KeyTimeCycle_transitionPathRotate, 8);
            f13723a.append(R$styleable.KeyTimeCycle_transitionEasing, 9);
            f13723a.append(R$styleable.KeyTimeCycle_motionTarget, 10);
            f13723a.append(R$styleable.KeyTimeCycle_framePosition, 12);
            f13723a.append(R$styleable.KeyTimeCycle_curveFit, 13);
            f13723a.append(R$styleable.KeyTimeCycle_android_scaleY, 14);
            f13723a.append(R$styleable.KeyTimeCycle_android_translationX, 15);
            f13723a.append(R$styleable.KeyTimeCycle_android_translationY, 16);
            f13723a.append(R$styleable.KeyTimeCycle_android_translationZ, 17);
            f13723a.append(R$styleable.KeyTimeCycle_motionProgress, 18);
            f13723a.append(R$styleable.KeyTimeCycle_wavePeriod, 20);
            f13723a.append(R$styleable.KeyTimeCycle_waveOffset, 21);
            f13723a.append(R$styleable.KeyTimeCycle_waveShape, 19);
        }

        public static void a(i r10, TypedArray r11) {
            int r12 = r11.getIndexCount();
            int r13 = 0;
        L3:
            if (r13 >= r12) goto L41;
            int r14 = r11.getIndex(r13);
            switch(f13723a.get(r14)) {
                case 1: goto L39;
                case 2: goto L38;
                case 3: goto L6;
                case 4: goto L37;
                case 5: goto L36;
                case 6: goto L35;
                case 7: goto L34;
                case 8: goto L33;
                case 9: goto L32;
                case 10: goto L24;
                case 11: goto L6;
                case 12: goto L22;
                case 13: goto L21;
                case 14: goto L20;
                case 15: goto L19;
                case 16: goto L18;
                case 17: goto L17;
                case 18: goto L16;
                case 19: goto L13;
                case 20: goto L11;
                case 21: goto L8;
                default: goto L6;
            };
        L6:
            Log.e("KeyTimeCycle", "unused attribute 0x" + Integer.toHexString(r14) + "   " + f13723a.get(r14));
        L40:
            r13 = r13 + 1;
            goto L3
        L11:
            i.N(r10, r11.getFloat(r14, i.M(r10)));
            goto L40
        L16:
            i.E(r10, r11.getFloat(r14, i.D(r10)));
            goto L40
        L17:
            i.C(r10, r11.getDimension(r14, i.B(r10)));
            goto L40
        L18:
            i.A(r10, r11.getDimension(r14, i.z(r10)));
            goto L40
        L19:
            i.y(r10, r11.getDimension(r14, i.x(r10)));
            goto L40
        L20:
            i.u(r10, r11.getFloat(r14, i.t(r10)));
            goto L40
        L21:
            i.I(r10, r11.getInteger(r14, i.H(r10)));
            goto L40
        L22:
            r10.f13645a = r11.getInt(r14, r10.f13645a);
            goto L40
        L32:
            i.s(r10, r11.getString(r14));
            goto L40
        L33:
            i.w(r10, r11.getFloat(r14, i.v(r10)));
            goto L40
        L34:
            i.R(r10, r11.getFloat(r14, i.Q(r10)));
            goto L40
        L35:
            i.q(r10, r11.getFloat(r14, i.p(r10)));
            goto L40
        L36:
            i.T(r10, r11.getFloat(r14, i.S(r10)));
            goto L40
        L37:
            i.G(r10, r11.getFloat(r14, i.F(r10)));
            goto L40
        L38:
            i.r(r10, r11.getDimension(r14, i.o(r10)));
            goto L40
        L39:
            i.n(r10, r11.getFloat(r14, i.m(r10)));
            goto L40
        L8:
            if (r11.peekValue(r14).type != 5) goto L10;
            i.P(r10, r11.getDimension(r14, i.O(r10)));
            goto L40
        L10:
            i.P(r10, r11.getFloat(r14, i.O(r10)));
            goto L40
        L13:
            if (r11.peekValue(r14).type != 3) goto L15;
            i.J(r10, r11.getString(r14));
            i.L(r10, 7);
            goto L40
        L15:
            i.L(r10, r11.getInt(r14, i.K(r10)));
            goto L40
        L24:
            if (MotionLayout.f13558d1 == false) goto L29;
            int r15 = r11.getResourceId(r14, r10.f13646b);
            r10.f13646b = r15;
            if (r15 != (-1)) goto L40;
            r10.f13647c = r11.getString(r14);
            goto L40
        L29:
            if (r11.peekValue(r14).type != 3) goto L31;
            r10.f13647c = r11.getString(r14);
            goto L40
        L31:
            r10.f13646b = r11.getResourceId(r14, r10.f13646b);
            goto L40
        }
    }

    public i() {
        this.f13706h = -1;
        this.f13707i = Float.NaN;
        this.f13708j = Float.NaN;
        this.f13709k = Float.NaN;
        this.f13710l = Float.NaN;
        this.f13711m = Float.NaN;
        this.f13712n = Float.NaN;
        this.f13713o = Float.NaN;
        this.f13714p = Float.NaN;
        this.f13715q = Float.NaN;
        this.f13716r = Float.NaN;
        this.f13717s = Float.NaN;
        this.f13718t = Float.NaN;
        this.f13719u = 0;
        this.f13720v = null;
        this.f13721w = Float.NaN;
        this.f13722x = 0.0f;
        this.f13648d = 3;
        this.f13649e = new HashMap();
    }

    public static /* synthetic */ float A(i r10, float r11) {
        r10.f13716r = r11;
        return r11;
    }

    public static /* synthetic */ float B(i r10) {
        return r10.f13717s;
    }

    public static /* synthetic */ float C(i r10, float r11) {
        r10.f13717s = r11;
        return r11;
    }

    public static /* synthetic */ float D(i r10) {
        return r10.f13718t;
    }

    public static /* synthetic */ float E(i r10, float r11) {
        r10.f13718t = r11;
        return r11;
    }

    public static /* synthetic */ float F(i r10) {
        return r10.f13709k;
    }

    public static /* synthetic */ float G(i r10, float r11) {
        r10.f13709k = r11;
        return r11;
    }

    public static /* synthetic */ int H(i r10) {
        return r10.f13706h;
    }

    public static /* synthetic */ int I(i r10, int r11) {
        r10.f13706h = r11;
        return r11;
    }

    public static /* synthetic */ String J(i r10, String r11) {
        r10.f13720v = r11;
        return r11;
    }

    public static /* synthetic */ int K(i r10) {
        return r10.f13719u;
    }

    public static /* synthetic */ int L(i r10, int r11) {
        r10.f13719u = r11;
        return r11;
    }

    public static /* synthetic */ float M(i r10) {
        return r10.f13721w;
    }

    public static /* synthetic */ float N(i r10, float r11) {
        r10.f13721w = r11;
        return r11;
    }

    public static /* synthetic */ float O(i r10) {
        return r10.f13722x;
    }

    public static /* synthetic */ float P(i r10, float r11) {
        r10.f13722x = r11;
        return r11;
    }

    public static /* synthetic */ float Q(i r10) {
        return r10.f13713o;
    }

    public static /* synthetic */ float R(i r10, float r11) {
        r10.f13713o = r11;
        return r11;
    }

    public static /* synthetic */ float S(i r10) {
        return r10.f13710l;
    }

    public static /* synthetic */ float T(i r10, float r11) {
        r10.f13710l = r11;
        return r11;
    }

    public static /* synthetic */ float m(i r10) {
        return r10.f13707i;
    }

    public static /* synthetic */ float n(i r10, float r11) {
        r10.f13707i = r11;
        return r11;
    }

    public static /* synthetic */ float o(i r10) {
        return r10.f13708j;
    }

    public static /* synthetic */ float p(i r10) {
        return r10.f13711m;
    }

    public static /* synthetic */ float q(i r10, float r11) {
        r10.f13711m = r11;
        return r11;
    }

    public static /* synthetic */ float r(i r10, float r11) {
        r10.f13708j = r11;
        return r11;
    }

    public static /* synthetic */ String s(i r10, String r11) {
        r10.f13705g = r11;
        return r11;
    }

    public static /* synthetic */ float t(i r10) {
        return r10.f13714p;
    }

    public static /* synthetic */ float u(i r10, float r11) {
        r10.f13714p = r11;
        return r11;
    }

    public static /* synthetic */ float v(i r10) {
        return r10.f13712n;
    }

    public static /* synthetic */ float w(i r10, float r11) {
        r10.f13712n = r11;
        return r11;
    }

    public static /* synthetic */ float x(i r10) {
        return r10.f13715q;
    }

    public static /* synthetic */ float y(i r10, float r11) {
        r10.f13715q = r11;
        return r11;
    }

    public static /* synthetic */ float z(i r10) {
        return r10.f13716r;
    }

    public void U(HashMap r12) {
        Iterator r10 = r12.keySet().iterator();
    L4:
        if (r10.hasNext() == false) goto L102;
        String r11 = (String) r10.next();
        yc.f r13 = (yc.f) r12.get(r11);
        if (r13 == null) goto L4;
        if (r11.startsWith("CUSTOM") == true) goto L10;
        byte r14 = -1;
        switch(r11.hashCode()) {
            case -1249320806: goto L61;
            case -1249320805: goto L57;
            case -1225497657: goto L53;
            case -1225497656: goto L49;
            case -1225497655: goto L45;
            case -1001078227: goto L41;
            case -908189618: goto L37;
            case -908189617: goto L33;
            case -40300674: goto L29;
            case -4379043: goto L25;
            case 37232917: goto L21;
            case 92909918: goto L17;
            default: goto L64;
        };
    L64:
        switch(r14) {
            case 0: goto L100;
            case 1: goto L97;
            case 2: goto L94;
            case 3: goto L91;
            case 4: goto L88;
            case 5: goto L85;
            case 6: goto L82;
            case 7: goto L79;
            case 8: goto L76;
            case 9: goto L73;
            case 10: goto L70;
            case 11: goto L67;
            default: goto L65;
        };
    L67:
        if (Float.isNaN(this.f13707i) == true) goto L4;
        r13.b(this.f13645a, this.f13707i, this.f13721w, this.f13719u, this.f13722x);
        goto L4
    L70:
        if (Float.isNaN(this.f13712n) == true) goto L4;
        r13.b(this.f13645a, this.f13712n, this.f13721w, this.f13719u, this.f13722x);
        goto L4
    L73:
        if (Float.isNaN(this.f13708j) == true) goto L4;
        r13.b(this.f13645a, this.f13708j, this.f13721w, this.f13719u, this.f13722x);
        goto L4
    L76:
        if (Float.isNaN(this.f13709k) == true) goto L4;
        r13.b(this.f13645a, this.f13709k, this.f13721w, this.f13719u, this.f13722x);
        goto L4
    L79:
        if (Float.isNaN(this.f13714p) == true) goto L4;
        r13.b(this.f13645a, this.f13714p, this.f13721w, this.f13719u, this.f13722x);
        goto L4
    L82:
        if (Float.isNaN(this.f13713o) == true) goto L4;
        r13.b(this.f13645a, this.f13713o, this.f13721w, this.f13719u, this.f13722x);
        goto L4
    L85:
        if (Float.isNaN(this.f13718t) == true) goto L4;
        r13.b(this.f13645a, this.f13718t, this.f13721w, this.f13719u, this.f13722x);
        goto L4
    L88:
        if (Float.isNaN(this.f13717s) == true) goto L4;
        r13.b(this.f13645a, this.f13717s, this.f13721w, this.f13719u, this.f13722x);
        goto L4
    L91:
        if (Float.isNaN(this.f13716r) == true) goto L4;
        r13.b(this.f13645a, this.f13716r, this.f13721w, this.f13719u, this.f13722x);
        goto L4
    L94:
        if (Float.isNaN(this.f13715q) == true) goto L4;
        r13.b(this.f13645a, this.f13715q, this.f13721w, this.f13719u, this.f13722x);
        goto L4
    L97:
        if (Float.isNaN(this.f13711m) == true) goto L4;
        r13.b(this.f13645a, this.f13711m, this.f13721w, this.f13719u, this.f13722x);
        goto L4
    L100:
        if (Float.isNaN(this.f13710l) == true) goto L4;
        r13.b(this.f13645a, this.f13710l, this.f13721w, this.f13719u, this.f13722x);
        goto L4
    L65:
        Log.e("KeyTimeCycles", "UNKNOWN addValues \"" + r11 + "\"");
        goto L4
    L17:
        if (r11.equals("alpha") == false) goto L64;
        r14 = Ascii.VT;
        goto L64
    L21:
        if (r11.equals("transitionPathRotate") == false) goto L64;
        r14 = 10;
        goto L64
    L25:
        if (r11.equals("elevation") == false) goto L64;
        r14 = 9;
        goto L64
    L29:
        if (r11.equals("rotation") == false) goto L64;
        r14 = 8;
        goto L64
    L33:
        if (r11.equals("scaleY") == false) goto L64;
        r14 = 7;
        goto L64
    L37:
        if (r11.equals("scaleX") == false) goto L64;
        r14 = 6;
        goto L64
    L41:
        if (r11.equals("progress") == false) goto L64;
        r14 = 5;
        goto L64
    L45:
        if (r11.equals("translationZ") == false) goto L64;
        r14 = 4;
        goto L64
    L49:
        if (r11.equals("translationY") == false) goto L64;
        r14 = 3;
        goto L64
    L53:
        if (r11.equals("translationX") == false) goto L64;
        r14 = 2;
        goto L64
    L57:
        if (r11.equals("rotationY") == false) goto L64;
        r14 = 1;
        goto L64
    L61:
        if (r11.equals("rotationX") == false) goto L64;
        r14 = 0;
        goto L64
    L10:
        ConstraintAttribute r15 = (ConstraintAttribute) this.f13649e.get(r11.substring(7));
        if (r15 == null) goto L4;
        ((yc.f.b) r13).j(this.f13645a, r15, this.f13721w, this.f13719u, this.f13722x);
        goto L4
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.c
    public void a(HashMap r10) {
        throw new IllegalArgumentException(" KeyTimeCycles do not support SplineSet");
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.c
    public c b() {
        return new i().c(this);
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.c
    public c c(c r10) {
        super.c(r10);
        i r11 = (i) r10;
        this.f13705g = r11.f13705g;
        this.f13706h = r11.f13706h;
        this.f13719u = r11.f13719u;
        this.f13721w = r11.f13721w;
        this.f13722x = r11.f13722x;
        this.f13718t = r11.f13718t;
        this.f13707i = r11.f13707i;
        this.f13708j = r11.f13708j;
        this.f13709k = r11.f13709k;
        this.f13712n = r11.f13712n;
        this.f13710l = r11.f13710l;
        this.f13711m = r11.f13711m;
        this.f13713o = r11.f13713o;
        this.f13714p = r11.f13714p;
        this.f13715q = r11.f13715q;
        this.f13716r = r11.f13716r;
        this.f13717s = r11.f13717s;
        this.f13720v = r11.f13720v;
        return this;
    }

    public /* bridge */ /* synthetic */ Object clone() {
        return b();
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.c
    public void d(HashSet r10) {
        if (Float.isNaN(this.f13707i) == true) goto L6;
        r10.add("alpha");
    L6:
        if (Float.isNaN(this.f13708j) == true) goto L9;
        r10.add("elevation");
    L9:
        if (Float.isNaN(this.f13709k) == true) goto L12;
        r10.add("rotation");
    L12:
        if (Float.isNaN(this.f13710l) == true) goto L15;
        r10.add("rotationX");
    L15:
        if (Float.isNaN(this.f13711m) == true) goto L18;
        r10.add("rotationY");
    L18:
        if (Float.isNaN(this.f13715q) == true) goto L21;
        r10.add("translationX");
    L21:
        if (Float.isNaN(this.f13716r) == true) goto L24;
        r10.add("translationY");
    L24:
        if (Float.isNaN(this.f13717s) == true) goto L27;
        r10.add("translationZ");
    L27:
        if (Float.isNaN(this.f13712n) == true) goto L30;
        r10.add("transitionPathRotate");
    L30:
        if (Float.isNaN(this.f13713o) == true) goto L33;
        r10.add("scaleX");
    L33:
        if (Float.isNaN(this.f13714p) == true) goto L36;
        r10.add("scaleY");
    L36:
        if (Float.isNaN(this.f13718t) == true) goto L39;
        r10.add("progress");
    L39:
        if (this.f13649e.size() <= 0) goto L44;
        Iterator r11 = this.f13649e.keySet().iterator();
    L42:
        if (r11.hasNext() == false) goto L46;
        r10.add("CUSTOM," + ((String) r11.next()));
        goto L42
    L46:
        return;
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.c
    public void e(Context r10, AttributeSet r11) {
        a.a(this, r10.obtainStyledAttributes(r11, R$styleable.KeyTimeCycle));
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.c
    public void h(HashMap r10) {
        if (this.f13706h != (-1)) goto L6;
        return;
    L6:
        if (Float.isNaN(this.f13707i) == true) goto L9;
        r10.put("alpha", Integer.valueOf(this.f13706h));
    L9:
        if (Float.isNaN(this.f13708j) == true) goto L12;
        r10.put("elevation", Integer.valueOf(this.f13706h));
    L12:
        if (Float.isNaN(this.f13709k) == true) goto L15;
        r10.put("rotation", Integer.valueOf(this.f13706h));
    L15:
        if (Float.isNaN(this.f13710l) == true) goto L18;
        r10.put("rotationX", Integer.valueOf(this.f13706h));
    L18:
        if (Float.isNaN(this.f13711m) == true) goto L21;
        r10.put("rotationY", Integer.valueOf(this.f13706h));
    L21:
        if (Float.isNaN(this.f13715q) == true) goto L24;
        r10.put("translationX", Integer.valueOf(this.f13706h));
    L24:
        if (Float.isNaN(this.f13716r) == true) goto L27;
        r10.put("translationY", Integer.valueOf(this.f13706h));
    L27:
        if (Float.isNaN(this.f13717s) == true) goto L30;
        r10.put("translationZ", Integer.valueOf(this.f13706h));
    L30:
        if (Float.isNaN(this.f13712n) == true) goto L33;
        r10.put("transitionPathRotate", Integer.valueOf(this.f13706h));
    L33:
        if (Float.isNaN(this.f13713o) == true) goto L36;
        r10.put("scaleX", Integer.valueOf(this.f13706h));
    L36:
        if (Float.isNaN(this.f13713o) == true) goto L39;
        r10.put("scaleY", Integer.valueOf(this.f13706h));
    L39:
        if (Float.isNaN(this.f13718t) == true) goto L42;
        r10.put("progress", Integer.valueOf(this.f13706h));
    L42:
        if (this.f13649e.size() <= 0) goto L47;
        Iterator r11 = this.f13649e.keySet().iterator();
    L45:
        if (r11.hasNext() == false) goto L49;
        r10.put("CUSTOM," + ((String) r11.next()), Integer.valueOf(this.f13706h));
        goto L45
    L49:
        return;
    }
}
