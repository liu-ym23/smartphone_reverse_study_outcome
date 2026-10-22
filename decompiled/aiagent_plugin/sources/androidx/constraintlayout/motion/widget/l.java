package androidx.constraintlayout.motion.widget;

import android.graphics.Rect;
import android.os.Build;
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
/* JADX INFO: loaded from: classes.dex */
class l implements Comparable<l> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static String[] f890d;
    private float A;
    private float B;
    private float C;
    private int D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f891a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f892b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f893c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    LinkedHashMap<String, androidx.constraintlayout.widget.a> f894e;
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
    private androidx.constraintlayout.a.a.a.c u;
    private int v;
    private float w;
    private float x;
    private float y;
    private float z;

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(l r3) {
        return a((l) ZeusTransformUtils.preCheckCast(r3, l.class, "com.obric.aiagent.plugin"));
    }

    static {
        f890d = new String[]{"position", "x", "y", "width", "height", "pathRotate"};
    }

    public l() {
        this.i = 1.0f;
        this.f891a = 0;
        this.j = false;
        this.k = 0.0f;
        this.l = 0.0f;
        this.m = 0.0f;
        this.f893c = 0.0f;
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
        this.f894e = new LinkedHashMap();
        this.f = 0;
        this.g = new double[18];
        this.h = new double[18];
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
        int r0 = this.f892b;
        int r2 = r5.f892b;
        if (r0 == r2) goto L16;
        if (this.f891a != 0) goto L16;
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
        if (a(this.f893c, r5.f893c) == false) goto L35;
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

    public void a(View r3) {
        this.f892b = r3.getVisibility();
        if (r3.getVisibility() == 0) goto L5;
        float r0 = 0.0f;
    L6:
        this.i = r0;
        this.j = false;
        if (Build.VERSION.SDK_INT < 21) goto L9;
        this.k = r3.getElevation();
    L9:
        this.l = r3.getRotation();
        this.m = r3.getRotationX();
        this.f893c = r3.getRotationY();
        this.n = r3.getScaleX();
        this.o = r3.getScaleY();
        this.p = r3.getPivotX();
        this.q = r3.getPivotY();
        this.r = r3.getTranslationX();
        this.s = r3.getTranslationY();
        if (Build.VERSION.SDK_INT < 21) goto L13;
        this.t = r3.getTranslationZ();
        return;
    L13:
        return;
    L5:
        r0 = r3.getAlpha();
        goto L6
    }

    public void a(androidx.constraintlayout.widget.c.a r6) {
        this.f891a = r6.f975c.f996c;
        this.f892b = r6.f975c.f995b;
        if (r6.f975c.f995b != 0) goto L5;
    L7:
        float r0 = r6.f975c.f997d;
    L8:
        this.i = r0;
        this.j = r6.f.m;
        this.k = r6.f.n;
        this.l = r6.f.f1000b;
        this.m = r6.f.f1001c;
        this.f893c = r6.f.f1002d;
        this.n = r6.f.f1003e;
        this.o = r6.f.f;
        this.p = r6.f.g;
        this.q = r6.f.h;
        this.r = r6.f.j;
        this.s = r6.f.k;
        this.t = r6.f.l;
        this.u = androidx.constraintlayout.a.a.a.c.a(r6.f976d.f992d);
        this.B = r6.f976d.i;
        this.v = r6.f976d.f;
        this.D = r6.f976d.f990b;
        this.C = r6.f975c.f998e;
        Iterator<String> r1 = r6.g.keySet().iterator();
    L10:
        if (r1.hasNext() == false) goto L14;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.aiagent.plugin");
        androidx.constraintlayout.widget.a r3 = (androidx.constraintlayout.widget.a) ZeusTransformUtils.preCheckCast(r6.g.get(r2), androidx.constraintlayout.widget.a.class, "com.obric.aiagent.plugin");
        if (r3.b() == false) goto L10;
        this.f894e.put(r2, r3);
        goto L10
    L14:
        return;
    L5:
        if (this.f891a != 0) goto L7;
        r0 = 0.0f;
        goto L8
    }

    public void a(HashMap<String, androidx.constraintlayout.motion.utils.c> r9, int r10) {
        Iterator<String> r0 = r9.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L145;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.aiagent.plugin");
        androidx.constraintlayout.motion.utils.c r2 = (androidx.constraintlayout.motion.utils.c) ZeusTransformUtils.preCheckCast(r9.get(r1), androidx.constraintlayout.motion.utils.c.class, "com.obric.aiagent.plugin");
        r1.hashCode();
        byte r4 = -1;
        switch(r1.hashCode()) {
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
        float r5 = 1.0f;
        float r7 = 0.0f;
        switch(r4) {
            case 0: goto L141;
            case 1: goto L136;
            case 2: goto L131;
            case 3: goto L126;
            case 4: goto L121;
            case 5: goto L116;
            case 6: goto L111;
            case 7: goto L106;
            case 8: goto L101;
            case 9: goto L96;
            case 10: goto L91;
            case 11: goto L86;
            case 12: goto L81;
            case 13: goto L76;
            default: goto L67;
        };
    L76:
        if (Float.isNaN(this.i) == true) goto L79;
        r5 = this.i;
    L79:
        r2.a(r10, r5);
        goto L4
    L81:
        if (Float.isNaN(this.B) == true) goto L84;
        r7 = this.B;
    L84:
        r2.a(r10, r7);
        goto L4
    L86:
        if (Float.isNaN(this.k) == true) goto L89;
        r7 = this.k;
    L89:
        r2.a(r10, r7);
        goto L4
    L91:
        if (Float.isNaN(this.l) == true) goto L94;
        r7 = this.l;
    L94:
        r2.a(r10, r7);
        goto L4
    L96:
        if (Float.isNaN(this.q) == true) goto L99;
        r7 = this.q;
    L99:
        r2.a(r10, r7);
        goto L4
    L101:
        if (Float.isNaN(this.p) == true) goto L104;
        r7 = this.p;
    L104:
        r2.a(r10, r7);
        goto L4
    L106:
        if (Float.isNaN(this.o) == true) goto L109;
        r5 = this.o;
    L109:
        r2.a(r10, r5);
        goto L4
    L111:
        if (Float.isNaN(this.n) == true) goto L114;
        r5 = this.n;
    L114:
        r2.a(r10, r5);
        goto L4
    L116:
        if (Float.isNaN(this.C) == true) goto L119;
        r7 = this.C;
    L119:
        r2.a(r10, r7);
        goto L4
    L121:
        if (Float.isNaN(this.t) == true) goto L124;
        r7 = this.t;
    L124:
        r2.a(r10, r7);
        goto L4
    L126:
        if (Float.isNaN(this.s) == true) goto L129;
        r7 = this.s;
    L129:
        r2.a(r10, r7);
        goto L4
    L131:
        if (Float.isNaN(this.r) == true) goto L134;
        r7 = this.r;
    L134:
        r2.a(r10, r7);
        goto L4
    L136:
        if (Float.isNaN(this.f893c) == true) goto L139;
        r7 = this.f893c;
    L139:
        r2.a(r10, r7);
        goto L4
    L141:
        if (Float.isNaN(this.m) == true) goto L144;
        r7 = this.m;
    L144:
        r2.a(r10, r7);
        goto L4
    L67:
        if (r1.startsWith("CUSTOM") == true) goto L68;
        a("MotionPaths", "UNKNOWN spline " + r1);
        goto L4
    L68:
        String r6 = r1.split(",")[1];
        if (this.f894e.containsKey(r6) == false) goto L4;
        androidx.constraintlayout.widget.a r8 = (androidx.constraintlayout.widget.a) ZeusTransformUtils.preCheckCast(this.f894e.get(r6), androidx.constraintlayout.widget.a.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r2, androidx.constraintlayout.motion.utils.c.b.class) == true) goto L72;
        a("MotionPaths", r1 + " ViewSpline not a CustomSet frame = " + r10 + ", value" + r8.d() + r2);
        goto L4
    L72:
        ((androidx.constraintlayout.motion.utils.c.b) ZeusTransformUtils.preCheckCast(r2, androidx.constraintlayout.motion.utils.c.b.class, "com.obric.aiagent.plugin")).a(r10, r8);
        goto L4
    L9:
        if (r1.equals("alpha") == false) goto L64;
        r4 = 13;
        goto L64
    L13:
        if (r1.equals("transitionPathRotate") == false) goto L64;
        r4 = 12;
        goto L64
    L17:
        if (r1.equals("elevation") == false) goto L64;
        r4 = 11;
        goto L64
    L21:
        if (r1.equals("rotation") == false) goto L64;
        r4 = 10;
        goto L64
    L25:
        if (r1.equals("transformPivotY") == false) goto L64;
        r4 = 9;
        goto L64
    L29:
        if (r1.equals("transformPivotX") == false) goto L64;
        r4 = 8;
        goto L64
    L33:
        if (r1.equals("scaleY") == false) goto L64;
        r4 = 7;
        goto L64
    L37:
        if (r1.equals("scaleX") == false) goto L64;
        r4 = 6;
        goto L64
    L41:
        if (r1.equals("progress") == false) goto L64;
        r4 = 5;
        goto L64
    L45:
        if (r1.equals("translationZ") == false) goto L64;
        r4 = 4;
        goto L64
    L49:
        if (r1.equals("translationY") == false) goto L64;
        r4 = 3;
        goto L64
    L53:
        if (r1.equals("translationX") == false) goto L64;
        r4 = 2;
        goto L64
    L57:
        if (r1.equals("rotationY") == false) goto L64;
        r4 = 1;
        goto L64
    L61:
        if (r1.equals("rotationX") == false) goto L64;
        r4 = 0;
        goto L64
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

    public void a(Rect r4, androidx.constraintlayout.widget.c r5, int r6, int r7) {
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
