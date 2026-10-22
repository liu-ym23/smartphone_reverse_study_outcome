package com.obric.oui.constraintlayout.motion.widget;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import com.google.common.base.Ascii;
import com.obric.oui.constraintlayout.widget.ConstraintAttribute;
import com.tmall.wireless.tangram.dataparser.concrete.Style;
import com.tmall.wireless.tangram.structure.card.FixCard;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes4.dex */
public class k implements Comparable {
    public static String[] D;
    public float A;
    public float B;
    public int C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f13745a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f13746b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f13747c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LinkedHashMap f13748d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f13749e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public double[] f13750f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public double[] f13751g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f13752h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f13753i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f13754j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f13755k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f13756l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f13757m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f13758n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f13759o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f13760p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f13761q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f13762r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f13763s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public vc.c f13764t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f13765u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f13766v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f13767w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f13768x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public float f13769y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f13770z;

    static {
        D = new String[]{"position", FixCard.FixStyle.KEY_X, FixCard.FixStyle.KEY_Y, Style.KEY_WIDTH, Style.KEY_HEIGHT, "pathRotate"};
    }

    public k() {
        this.f13745a = 0.0f;
        this.f13746b = 0;
        this.f13748d = new LinkedHashMap();
        this.f13749e = 0;
        this.f13750f = new double[18];
        this.f13751g = new double[18];
        this.f13752h = 1.0f;
        this.f13753i = false;
        this.f13754j = 0.0f;
        this.f13755k = 0.0f;
        this.f13756l = 0.0f;
        this.f13757m = 1.0f;
        this.f13758n = 1.0f;
        this.f13759o = Float.NaN;
        this.f13760p = Float.NaN;
        this.f13761q = 0.0f;
        this.f13762r = 0.0f;
        this.f13763s = 0.0f;
        this.f13765u = 0;
        this.A = Float.NaN;
        this.B = Float.NaN;
        this.C = -1;
    }

    public void a(HashMap r10, int r11) {
        Iterator r12 = r10.keySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L147;
        String r13 = (String) r12.next();
        yc.d r14 = (yc.d) r10.get(r13);
        if (r14 == null) goto L4;
        r13.hashCode();
        float r15 = 1.0f;
        float r16 = 0.0f;
        byte r17 = -1;
        switch(r13.hashCode()) {
            case -1249320806: goto L64;
            case -1249320805: goto L60;
            case -1225497657: goto L56;
            case -1225497656: goto L52;
            case -1225497655: goto L48;
            case -1001078227: goto L44;
            case -908189618: goto L40;
            case -908189617: goto L36;
            case -760884510: goto L32;
            case -760884509: goto L28;
            case -40300674: goto L24;
            case -4379043: goto L20;
            case 37232917: goto L16;
            case 92909918: goto L12;
            default: goto L67;
        };
    L67:
        switch(r17) {
            case 0: goto L143;
            case 1: goto L138;
            case 2: goto L133;
            case 3: goto L128;
            case 4: goto L123;
            case 5: goto L118;
            case 6: goto L113;
            case 7: goto L108;
            case 8: goto L103;
            case 9: goto L98;
            case 10: goto L93;
            case 11: goto L88;
            case 12: goto L83;
            case 13: goto L78;
            default: goto L69;
        };
    L78:
        if (Float.isNaN(this.f13752h) == true) goto L81;
        r15 = this.f13752h;
    L81:
        r14.c(r11, r15);
        goto L4
    L83:
        if (Float.isNaN(this.A) == true) goto L86;
        r16 = this.A;
    L86:
        r14.c(r11, r16);
        goto L4
    L88:
        if (Float.isNaN(this.f13754j) == true) goto L91;
        r16 = this.f13754j;
    L91:
        r14.c(r11, r16);
        goto L4
    L93:
        if (Float.isNaN(this.f13755k) == true) goto L96;
        r16 = this.f13755k;
    L96:
        r14.c(r11, r16);
        goto L4
    L98:
        if (Float.isNaN(this.f13760p) == true) goto L101;
        r16 = this.f13760p;
    L101:
        r14.c(r11, r16);
        goto L4
    L103:
        if (Float.isNaN(this.f13759o) == true) goto L106;
        r16 = this.f13759o;
    L106:
        r14.c(r11, r16);
        goto L4
    L108:
        if (Float.isNaN(this.f13758n) == true) goto L111;
        r15 = this.f13758n;
    L111:
        r14.c(r11, r15);
        goto L4
    L113:
        if (Float.isNaN(this.f13757m) == true) goto L116;
        r15 = this.f13757m;
    L116:
        r14.c(r11, r15);
        goto L4
    L118:
        if (Float.isNaN(this.B) == true) goto L121;
        r16 = this.B;
    L121:
        r14.c(r11, r16);
        goto L4
    L123:
        if (Float.isNaN(this.f13763s) == true) goto L126;
        r16 = this.f13763s;
    L126:
        r14.c(r11, r16);
        goto L4
    L128:
        if (Float.isNaN(this.f13762r) == true) goto L131;
        r16 = this.f13762r;
    L131:
        r14.c(r11, r16);
        goto L4
    L133:
        if (Float.isNaN(this.f13761q) == true) goto L136;
        r16 = this.f13761q;
    L136:
        r14.c(r11, r16);
        goto L4
    L138:
        if (Float.isNaN(this.f13745a) == true) goto L141;
        r16 = this.f13745a;
    L141:
        r14.c(r11, r16);
        goto L4
    L143:
        if (Float.isNaN(this.f13756l) == true) goto L146;
        r16 = this.f13756l;
    L146:
        r14.c(r11, r16);
        goto L4
    L69:
        if (r13.startsWith("CUSTOM") == true) goto L70;
        Log.e("MotionPaths", "UNKNOWN spline " + r13);
        goto L4
    L70:
        String r18 = r13.split(",")[1];
        if (this.f13748d.containsKey(r18) == false) goto L4;
        ConstraintAttribute r19 = (ConstraintAttribute) this.f13748d.get(r18);
        if ((r14 instanceof yc.d.b) == true) goto L74;
        Log.e("MotionPaths", r13 + " ViewSpline not a CustomSet frame = " + r11 + ", value" + r19.e() + r14);
        goto L4
    L74:
        ((yc.d.b) r14).i(r11, r19);
        goto L4
    L12:
        if (r13.equals("alpha") == false) goto L67;
        r17 = Ascii.CR;
        goto L67
    L16:
        if (r13.equals("transitionPathRotate") == false) goto L67;
        r17 = Ascii.FF;
        goto L67
    L20:
        if (r13.equals("elevation") == false) goto L67;
        r17 = Ascii.VT;
        goto L67
    L24:
        if (r13.equals("rotation") == false) goto L67;
        r17 = 10;
        goto L67
    L28:
        if (r13.equals("transformPivotY") == false) goto L67;
        r17 = 9;
        goto L67
    L32:
        if (r13.equals("transformPivotX") == false) goto L67;
        r17 = 8;
        goto L67
    L36:
        if (r13.equals("scaleY") == false) goto L67;
        r17 = 7;
        goto L67
    L40:
        if (r13.equals("scaleX") == false) goto L67;
        r17 = 6;
        goto L67
    L44:
        if (r13.equals("progress") == false) goto L67;
        r17 = 5;
        goto L67
    L48:
        if (r13.equals("translationZ") == false) goto L67;
        r17 = 4;
        goto L67
    L52:
        if (r13.equals("translationY") == false) goto L67;
        r17 = 3;
        goto L67
    L56:
        if (r13.equals("translationX") == false) goto L67;
        r17 = 2;
        goto L67
    L60:
        if (r13.equals("rotationY") == false) goto L67;
        r17 = 1;
        goto L67
    L64:
        if (r13.equals("rotationX") == false) goto L67;
        r17 = 0;
        goto L67
    }

    public void b(View r10) {
        this.f13747c = r10.getVisibility();
        if (r10.getVisibility() == 0) goto L5;
        float r11 = 0.0f;
    L6:
        this.f13752h = r11;
        this.f13753i = false;
        this.f13754j = r10.getElevation();
        this.f13755k = r10.getRotation();
        this.f13756l = r10.getRotationX();
        this.f13745a = r10.getRotationY();
        this.f13757m = r10.getScaleX();
        this.f13758n = r10.getScaleY();
        this.f13759o = r10.getPivotX();
        this.f13760p = r10.getPivotY();
        this.f13761q = r10.getTranslationX();
        this.f13762r = r10.getTranslationY();
        this.f13763s = r10.getTranslationZ();
        return;
    L5:
        r11 = r10.getAlpha();
        goto L6
    }

    public void c(com.obric.oui.constraintlayout.widget.a.C0195a r10) {
        com.obric.oui.constraintlayout.widget.a.d r11 = r10.f14174c;
        int r12 = r11.f14254c;
        this.f13746b = r12;
        int r13 = r11.f14253b;
        this.f13747c = r13;
        if (r13 == 0) goto L6;
        if (r12 != 0) goto L6;
        float r14 = 0.0f;
    L7:
        this.f13752h = r14;
        com.obric.oui.constraintlayout.widget.a.e r15 = r10.f14177f;
        this.f13753i = r15.f14270m;
        this.f13754j = r15.f14271n;
        this.f13755k = r15.f14259b;
        this.f13756l = r15.f14260c;
        this.f13745a = r15.f14261d;
        this.f13757m = r15.f14262e;
        this.f13758n = r15.f14263f;
        this.f13759o = r15.f14264g;
        this.f13760p = r15.f14265h;
        this.f13761q = r15.f14267j;
        this.f13762r = r15.f14268k;
        this.f13763s = r15.f14269l;
        this.f13764t = vc.c.c(r10.f14175d.f14241d);
        com.obric.oui.constraintlayout.widget.a.c r16 = r10.f14175d;
        this.A = r16.f14246i;
        this.f13765u = r16.f14243f;
        this.C = r16.f14239b;
        this.B = r10.f14174c.f14256e;
        Iterator r17 = r10.f14178g.keySet().iterator();
    L9:
        if (r17.hasNext() == false) goto L13;
        String r18 = (String) r17.next();
        ConstraintAttribute r19 = (ConstraintAttribute) r10.f14178g.get(r18);
        if (r19.g() == false) goto L9;
        this.f13748d.put(r18, r19);
        goto L9
    L13:
        return;
    L6:
        r14 = r11.f14255d;
        goto L7
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Object r10) {
        return d((k) r10);
    }

    public int d(k r10) {
        return Float.compare(this.f13766v, r10.f13766v);
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
        if (e(this.f13752h, r10.f13752h) == false) goto L6;
        r11.add("alpha");
    L6:
        if (e(this.f13754j, r10.f13754j) == false) goto L8;
        r11.add("elevation");
    L8:
        int r12 = this.f13747c;
        int r13 = r10.f13747c;
        if (r12 == r13) goto L16;
        if (this.f13746b != 0) goto L16;
        if (r12 == 0) goto L14;
        if (r13 != 0) goto L16;
    L14:
        r11.add("alpha");
    L16:
        if (e(this.f13755k, r10.f13755k) == false) goto L19;
        r11.add("rotation");
    L19:
        if (Float.isNaN(this.A) == true) goto L21;
    L22:
        r11.add("transitionPathRotate");
    L24:
        if (Float.isNaN(this.B) == true) goto L26;
    L27:
        r11.add("progress");
    L29:
        if (e(this.f13756l, r10.f13756l) == false) goto L32;
        r11.add("rotationX");
    L32:
        if (e(this.f13745a, r10.f13745a) == false) goto L35;
        r11.add("rotationY");
    L35:
        if (e(this.f13759o, r10.f13759o) == false) goto L38;
        r11.add("transformPivotX");
    L38:
        if (e(this.f13760p, r10.f13760p) == false) goto L41;
        r11.add("transformPivotY");
    L41:
        if (e(this.f13757m, r10.f13757m) == false) goto L44;
        r11.add("scaleX");
    L44:
        if (e(this.f13758n, r10.f13758n) == false) goto L47;
        r11.add("scaleY");
    L47:
        if (e(this.f13761q, r10.f13761q) == false) goto L50;
        r11.add("translationX");
    L50:
        if (e(this.f13762r, r10.f13762r) == false) goto L53;
        r11.add("translationY");
    L53:
        if (e(this.f13763s, r10.f13763s) == false) goto L56;
        r11.add("translationZ");
        return;
    L56:
        return;
    L26:
        if (Float.isNaN(r10.B) == true) goto L29;
    L21:
        if (Float.isNaN(r10.A) == true) goto L24;
        goto L22
    }

    public void g(float r10, float r11, float r12, float r13) {
        this.f13767w = r10;
        this.f13768x = r11;
        this.f13769y = r12;
        this.f13770z = r13;
    }

    public void h(Rect r10, com.obric.oui.constraintlayout.widget.a r11, int r12, int r13) {
        g(r10.left, r10.top, r10.width(), r10.height());
        c(r11.x(r13));
        if (r12 != 1) goto L5;
    L14:
        this.f13755k -= 90.0f;
        return;
    L5:
        if (r12 != 2) goto L7;
    L11:
        float r14 = this.f13755k + 90.0f;
        this.f13755k = r14;
        if (r14 <= 180.0f) goto L16;
        this.f13755k = r14 - 360.0f;
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
