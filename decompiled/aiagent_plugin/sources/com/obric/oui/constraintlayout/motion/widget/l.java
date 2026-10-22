package com.obric.oui.constraintlayout.motion.widget;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: MotionConstrainedPoint.java */
/* JADX INFO: loaded from: classes4.dex */
class l implements Comparable<l> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static String[] f34873a;
    private float A;
    private float B;
    private float C;
    private int D;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f34874b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f34875c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f34876d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    LinkedHashMap<String, com.obric.oui.constraintlayout.widget.a> f34877e;
    int f;
    double[] g;
    double[] h;
    private float i;
    private boolean j;
    private float k;
    private float l;
    private float m;
    private float n;
    private float o;
    private float p;
    private float q;
    private float r;
    private float s;
    private float t;
    private com.obric.oui.constraintlayout.a.a.a.c u;
    private int v;
    private float w;
    private float x;
    private float y;
    private float z;

    l() {
        this.f34874b = 0.0f;
        this.f34875c = 0;
        this.f34877e = new LinkedHashMap();
        this.f = 0;
        this.g = new double[18];
        this.h = new double[18];
        this.i = 1.0f;
        this.j = false;
        this.k = 0.0f;
        this.l = 0.0f;
        this.m = 0.0f;
        this.n = 1.0f;
        this.o = 1.0f;
        this.p = Float.NaN;
        this.q = Float.NaN;
        this.r = 0.0f;
        this.s = 0.0f;
        this.t = 0.0f;
        this.v = 0;
        this.B = Float.NaN;
        this.C = Float.NaN;
        this.D = -1;
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(l r3) {
        return a((l) ZeusTransformUtils.preCheckCast(r3, l.class, "com.obric.aiagent.plugin"));
    }

    static {
        f34873a = new String[]{"position", "x", "y", "width", "height", "pathRotate"};
    }

    private boolean a(float r3, float r4) {
        if (Float.isNaN(r3) == true) goto L13;
        if (Float.isNaN(r4) == true) goto L13;
        if (Math.abs(r3 - r4) <= 1.0E-6f) goto L11;
        return true;
    L11:
        return false;
    L13:
        if (Float.isNaN(r3) == Float.isNaN(r4)) goto L16;
        return true;
    L16:
        return false;
    }

    void a(l r5, HashSet<String> r6) {
        if (a(this.i, r5.i) == false) goto L6;
        r6.add("alpha");
    L6:
        if (a(this.k, r5.k) == false) goto L8;
        r6.add("elevation");
    L8:
        int r0 = this.f34876d;
        int r2 = r5.f34876d;
        if (r0 == r2) goto L16;
        if (this.f34875c != 0) goto L16;
        if (r0 == 0) goto L14;
        if (r2 != 0) goto L16;
    L14:
        r6.add("alpha");
    L16:
        if (a(this.l, r5.l) == false) goto L19;
        r6.add("rotation");
    L19:
        if (Float.isNaN(this.B) == true) goto L21;
    L22:
        r6.add("transitionPathRotate");
    L24:
        if (Float.isNaN(this.C) == true) goto L26;
    L27:
        r6.add("progress");
    L29:
        if (a(this.m, r5.m) == false) goto L32;
        r6.add("rotationX");
    L32:
        if (a(this.f34874b, r5.f34874b) == false) goto L35;
        r6.add("rotationY");
    L35:
        if (a(this.p, r5.p) == false) goto L38;
        r6.add("transformPivotX");
    L38:
        if (a(this.q, r5.q) == false) goto L41;
        r6.add("transformPivotY");
    L41:
        if (a(this.n, r5.n) == false) goto L44;
        r6.add("scaleX");
    L44:
        if (a(this.o, r5.o) == false) goto L47;
        r6.add("scaleY");
    L47:
        if (a(this.r, r5.r) == false) goto L50;
        r6.add("translationX");
    L50:
        if (a(this.s, r5.s) == false) goto L53;
        r6.add("translationY");
    L53:
        if (a(this.t, r5.t) == false) goto L56;
        r6.add("translationZ");
        return;
    L56:
        return;
    L26:
        if (Float.isNaN(r5.C) == true) goto L29;
    L21:
        if (Float.isNaN(r5.B) == true) goto L24;
        goto L22
    }

    void a(float r1, float r2, float r3, float r4) {
        this.x = r1;
        this.y = r2;
        this.z = r3;
        this.A = r4;
    }

    public int a(l r1) {
        return Float.compare(this.w, r1.w);
    }

    public void a(View r2) {
        this.f34876d = r2.getVisibility();
        if (r2.getVisibility() == 0) goto L5;
        float r0 = 0.0f;
    L6:
        this.i = r0;
        this.j = false;
        this.k = r2.getElevation();
        this.l = r2.getRotation();
        this.m = r2.getRotationX();
        this.f34874b = r2.getRotationY();
        this.n = r2.getScaleX();
        this.o = r2.getScaleY();
        this.p = r2.getPivotX();
        this.q = r2.getPivotY();
        this.r = r2.getTranslationX();
        this.s = r2.getTranslationY();
        this.t = r2.getTranslationZ();
        return;
    L5:
        r0 = r2.getAlpha();
        goto L6
    }

    public void a(com.obric.oui.constraintlayout.widget.c.a r6) {
        this.f34875c = r6.f34959c.f34980c;
        this.f34876d = r6.f34959c.f34979b;
        if (r6.f34959c.f34979b != 0) goto L5;
    L7:
        float r0 = r6.f34959c.f34981d;
    L8:
        this.i = r0;
        this.j = r6.f.m;
        this.k = r6.f.n;
        this.l = r6.f.f34984b;
        this.m = r6.f.f34985c;
        this.f34874b = r6.f.f34986d;
        this.n = r6.f.f34987e;
        this.o = r6.f.f;
        this.p = r6.f.g;
        this.q = r6.f.h;
        this.r = r6.f.j;
        this.s = r6.f.k;
        this.t = r6.f.l;
        this.u = com.obric.oui.constraintlayout.a.a.a.c.a(r6.f34960d.f34976d);
        this.B = r6.f34960d.i;
        this.v = r6.f34960d.f;
        this.D = r6.f34960d.f34974b;
        this.C = r6.f34959c.f34982e;
        Iterator<String> r1 = r6.g.keySet().iterator();
    L10:
        if (r1.hasNext() == false) goto L14;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.aiagent.plugin");
        com.obric.oui.constraintlayout.widget.a r3 = (com.obric.oui.constraintlayout.widget.a) ZeusTransformUtils.preCheckCast(r6.g.get(r2), com.obric.oui.constraintlayout.widget.a.class, "com.obric.aiagent.plugin");
        if (r3.b() == false) goto L10;
        this.f34877e.put(r2, r3);
        goto L10
    L14:
        return;
    L5:
        if (this.f34875c != 0) goto L7;
        r0 = 0.0f;
        goto L8
    }

    public void a(HashMap<String, com.obric.oui.constraintlayout.motion.utils.c> r9, int r10) {
        Iterator<String> r0 = r9.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L148;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.aiagent.plugin");
        com.obric.oui.constraintlayout.motion.utils.c r2 = (com.obric.oui.constraintlayout.motion.utils.c) ZeusTransformUtils.preCheckCast(r9.get(r1), com.obric.oui.constraintlayout.motion.utils.c.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L4;
        r1.hashCode();
        byte r4 = -1;
        switch(r1.hashCode()) {
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
        float r5 = 1.0f;
        float r7 = 0.0f;
        switch(r4) {
            case 0: goto L144;
            case 1: goto L139;
            case 2: goto L134;
            case 3: goto L129;
            case 4: goto L124;
            case 5: goto L119;
            case 6: goto L114;
            case 7: goto L109;
            case 8: goto L104;
            case 9: goto L99;
            case 10: goto L94;
            case 11: goto L89;
            case 12: goto L84;
            case 13: goto L79;
            default: goto L70;
        };
    L79:
        if (Float.isNaN(this.i) == true) goto L82;
        r5 = this.i;
    L82:
        r2.a(r10, r5);
        goto L4
    L84:
        if (Float.isNaN(this.B) == true) goto L87;
        r7 = this.B;
    L87:
        r2.a(r10, r7);
        goto L4
    L89:
        if (Float.isNaN(this.k) == true) goto L92;
        r7 = this.k;
    L92:
        r2.a(r10, r7);
        goto L4
    L94:
        if (Float.isNaN(this.l) == true) goto L97;
        r7 = this.l;
    L97:
        r2.a(r10, r7);
        goto L4
    L99:
        if (Float.isNaN(this.q) == true) goto L102;
        r7 = this.q;
    L102:
        r2.a(r10, r7);
        goto L4
    L104:
        if (Float.isNaN(this.p) == true) goto L107;
        r7 = this.p;
    L107:
        r2.a(r10, r7);
        goto L4
    L109:
        if (Float.isNaN(this.o) == true) goto L112;
        r5 = this.o;
    L112:
        r2.a(r10, r5);
        goto L4
    L114:
        if (Float.isNaN(this.n) == true) goto L117;
        r5 = this.n;
    L117:
        r2.a(r10, r5);
        goto L4
    L119:
        if (Float.isNaN(this.C) == true) goto L122;
        r7 = this.C;
    L122:
        r2.a(r10, r7);
        goto L4
    L124:
        if (Float.isNaN(this.t) == true) goto L127;
        r7 = this.t;
    L127:
        r2.a(r10, r7);
        goto L4
    L129:
        if (Float.isNaN(this.s) == true) goto L132;
        r7 = this.s;
    L132:
        r2.a(r10, r7);
        goto L4
    L134:
        if (Float.isNaN(this.r) == true) goto L137;
        r7 = this.r;
    L137:
        r2.a(r10, r7);
        goto L4
    L139:
        if (Float.isNaN(this.f34874b) == true) goto L142;
        r7 = this.f34874b;
    L142:
        r2.a(r10, r7);
        goto L4
    L144:
        if (Float.isNaN(this.m) == true) goto L147;
        r7 = this.m;
    L147:
        r2.a(r10, r7);
        goto L4
    L70:
        if (r1.startsWith("CUSTOM") == true) goto L71;
        a("MotionPaths", "UNKNOWN spline " + r1);
        goto L4
    L71:
        String r6 = r1.split(",")[1];
        if (this.f34877e.containsKey(r6) == false) goto L4;
        com.obric.oui.constraintlayout.widget.a r8 = (com.obric.oui.constraintlayout.widget.a) ZeusTransformUtils.preCheckCast(this.f34877e.get(r6), com.obric.oui.constraintlayout.widget.a.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r2, com.obric.oui.constraintlayout.motion.utils.c.b.class) == true) goto L75;
        a("MotionPaths", r1 + " ViewSpline not a CustomSet frame = " + r10 + ", value" + r8.d() + r2);
        goto L4
    L75:
        ((com.obric.oui.constraintlayout.motion.utils.c.b) ZeusTransformUtils.preCheckCast(r2, com.obric.oui.constraintlayout.motion.utils.c.b.class, "com.obric.aiagent.plugin")).a(r10, r8);
        goto L4
    L12:
        if (r1.equals("alpha") == false) goto L67;
        r4 = 13;
        goto L67
    L16:
        if (r1.equals("transitionPathRotate") == false) goto L67;
        r4 = 12;
        goto L67
    L20:
        if (r1.equals("elevation") == false) goto L67;
        r4 = 11;
        goto L67
    L24:
        if (r1.equals("rotation") == false) goto L67;
        r4 = 10;
        goto L67
    L28:
        if (r1.equals("transformPivotY") == false) goto L67;
        r4 = 9;
        goto L67
    L32:
        if (r1.equals("transformPivotX") == false) goto L67;
        r4 = 8;
        goto L67
    L36:
        if (r1.equals("scaleY") == false) goto L67;
        r4 = 7;
        goto L67
    L40:
        if (r1.equals("scaleX") == false) goto L67;
        r4 = 6;
        goto L67
    L44:
        if (r1.equals("progress") == false) goto L67;
        r4 = 5;
        goto L67
    L48:
        if (r1.equals("translationZ") == false) goto L67;
        r4 = 4;
        goto L67
    L52:
        if (r1.equals("translationY") == false) goto L67;
        r4 = 3;
        goto L67
    L56:
        if (r1.equals("translationX") == false) goto L67;
        r4 = 2;
        goto L67
    L60:
        if (r1.equals("rotationY") == false) goto L67;
        r4 = 1;
        goto L67
    L64:
        if (r1.equals("rotationX") == false) goto L67;
        r4 = 0;
        goto L67
    }

    public void b(View r5) {
        a(r5.getX(), r5.getY(), r5.getWidth(), r5.getHeight());
        a(r5);
    }

    public void a(Rect r4, View r5, int r6, float r7) {
        a(r4.left, r4.top, r4.width(), r4.height());
        a(r5);
        this.p = Float.NaN;
        this.q = Float.NaN;
        if (r6 != 1) goto L5;
        this.l = r7 - 90.0f;
        return;
    L5:
        if (r6 != 2) goto L11;
        this.l = r7 + 90.0f;
        return;
    }

    public void a(Rect r4, com.obric.oui.constraintlayout.widget.c r5, int r6, int r7) {
        a(r4.left, r4.top, r4.width(), r4.height());
        a(r5.a(r7));
        if (r6 != 1) goto L5;
    L14:
        this.l -= 90.0f;
        return;
    L5:
        if (r6 != 2) goto L7;
    L11:
        float r8 = this.l + 90.0f;
        this.l = r8;
        if (r8 <= 180.0f) goto L16;
        this.l = r8 - 360.0f;
        return;
    L16:
        return;
    L7:
        if (r6 == 3) goto L14;
        if (r6 == 4) goto L11;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1) {
        return Log.e(r0, r1);
    }
}
