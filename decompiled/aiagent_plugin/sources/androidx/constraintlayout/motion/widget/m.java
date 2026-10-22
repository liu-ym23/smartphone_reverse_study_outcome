package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: MotionController.java */
/* JADX INFO: loaded from: classes.dex */
public class m {
    private static final String TAG = "MotionController";
    private ArrayList<d> A;
    private HashMap<String, androidx.constraintlayout.motion.utils.e> B;
    private HashMap<String, androidx.constraintlayout.motion.utils.c> C;
    private HashMap<String, androidx.constraintlayout.motion.utils.b> D;
    private k[] E;
    private int F;
    private int G;
    private View H;
    private int I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private float f895J;
    private Interpolator K;
    private boolean L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Rect f896a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    View f897b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f898c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    boolean f899d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    String f900e;
    float f;
    float g;
    float h;
    float i;
    float j;
    private int k;
    private o l;
    private o m;
    private l n;
    private l o;
    private androidx.constraintlayout.a.a.a.b[] p;
    private androidx.constraintlayout.a.a.a.b q;
    private int[] r;
    private double[] s;
    private double[] t;
    private String[] u;
    private int[] v;
    private int w;
    private float[] x;
    private ArrayList<o> y;
    private float[] z;

    o a(int r2) {
        return (o) ZeusTransformUtils.preCheckCast(this.y.get(r2), o.class, "com.obric.aiagent.plugin");
    }

    m(View r5) {
        this.f896a = new Rect();
        this.f899d = false;
        this.k = -1;
        this.l = new o();
        this.m = new o();
        this.n = new l();
        this.o = new l();
        this.f = Float.NaN;
        this.g = 0.0f;
        this.h = 1.0f;
        this.w = 4;
        this.x = new float[4];
        this.y = new ArrayList();
        this.z = new float[1];
        this.A = new ArrayList();
        this.F = d.f878a;
        this.G = d.f878a;
        this.H = null;
        this.I = d.f878a;
        this.f895J = Float.NaN;
        this.K = null;
        this.L = false;
        a(r5);
    }

    public float a() {
        return this.l.f;
    }

    public float b() {
        return this.l.g;
    }

    public float c() {
        return this.m.f;
    }

    public float d() {
        return this.m.g;
    }

    public int e() {
        return this.l.m;
    }

    public void a(m r3) {
        this.l.a(r3, r3.l);
        this.m.a(r3, r3.m);
    }

    public float f() {
        return this.i;
    }

    public float g() {
        return this.j;
    }

    public void a(double r10, float[] r12, float[] r13) {
        double[] r5 = new double[4];
        double[] r7 = new double[4];
        this.p[0].a(r10, r5);
        this.p[0].b(r10, r7);
        Arrays.fill(r13, 0.0f);
        this.l.a(r10, this.r, r5, r12, r7, r13);
    }

    public void h() {
        this.f899d = true;
    }

    void a(float[] r22, int r23) {
        m r0 = this;
        float r9 = 1.0f;
        float r10 = 1.0f / (r23 - 1);
        HashMap<String, androidx.constraintlayout.motion.utils.c> r1 = r0.C;
        androidx.constraintlayout.motion.utils.b r3 = null;
        if (r1 != null) goto L5;
        androidx.constraintlayout.a.a.a.j r12 = null;
    L6:
        HashMap<String, androidx.constraintlayout.motion.utils.c> r2 = r0.C;
        if (r2 != null) goto L9;
        androidx.constraintlayout.a.a.a.j r13 = null;
    L10:
        HashMap<String, androidx.constraintlayout.motion.utils.b> r4 = r0.D;
        if (r4 != null) goto L13;
        androidx.constraintlayout.motion.utils.b r14 = null;
    L14:
        HashMap<String, androidx.constraintlayout.motion.utils.b> r5 = r0.D;
        if (r5 == null) goto L18;
        r3 = (androidx.constraintlayout.motion.utils.b) ZeusTransformUtils.preCheckCast(r5.get("translationY"), androidx.constraintlayout.motion.utils.b.class, "com.obric.aiagent.plugin");
    L18:
        androidx.constraintlayout.motion.utils.b r15 = r3;
        int r7 = 0;
    L19:
        if (r7 >= r23) goto L64;
        float r6 = r7 * r10;
        float r8 = r0.h;
        if (r8 == r9) goto L30;
        float r11 = r0.g;
        if (r6 >= r11) goto L26;
        r6 = 0.0f;
    L26:
        if (r6 <= r11) goto L30;
        if (r6 >= 1.0d) goto L30;
        r6 = Math.min((r6 - r11) * r8, r9);
    L30:
        float r16 = r6;
        double r17 = r16;
        androidx.constraintlayout.a.a.a.c r18 = r0.l.f902b;
        float r19 = Float.NaN;
        Iterator<o> r20 = r0.y.iterator();
        float r110 = 0.0f;
    L32:
        if (r20.hasNext() == false) goto L42;
        double r111 = r17;
        o r21 = (o) ZeusTransformUtils.preCheckCast(r20.next(), o.class, "com.obric.aiagent.plugin");
        if (r21.f902b == null) goto L41;
        if (r21.f904d >= r16) goto L39;
        androidx.constraintlayout.a.a.a.c r24 = r21.f902b;
        r110 = r21.f904d;
        r18 = r24;
        goto L41
    L39:
        if (Float.isNaN(r19) == false) goto L41;
        r19 = r21.f904d;
    L41:
        r17 = r111;
        goto L32
    L42:
        double r112 = r17;
        if (r18 != null) goto L45;
        double r25 = r112;
    L49:
        r0.p[0].a(r25, r0.s);
        androidx.constraintlayout.a.a.a.b r26 = r0.q;
        if (r26 == null) goto L54;
        double[] r27 = r0.s;
        if (r27.length <= 0) goto L54;
        r26.a(r25, r27);
    L54:
        int r28 = r7 * 2;
        int r113 = r7;
        r0.l.a(r25, r0.r, r0.s, r22, r28);
        if (r14 == null) goto L57;
        r22[r28] = r22[r28] + r14.a(r16);
    L59:
        if (r15 == null) goto L61;
        int r29 = r28 + 1;
        r22[r29] = r22[r29] + r15.a(r16);
    L63:
        r7 = r113 + 1;
        r9 = 1.0f;
        r0 = this;
        goto L19
    L61:
        if (r13 == null) goto L63;
        int r30 = r28 + 1;
        r22[r30] = r22[r30] + r13.a(r16);
        goto L63
    L57:
        if (r12 == null) goto L59;
        r22[r28] = r22[r28] + r12.a(r16);
        goto L59
    L45:
        if (Float.isNaN(r19) == false) goto L47;
        r19 = 1.0f;
    L47:
        float r31 = r19 - r110;
        r25 = (((float) r18.a((r16 - r110) / r31)) * r31) + r110;
        goto L49
    L64:
        return;
    L13:
        r14 = (androidx.constraintlayout.motion.utils.b) ZeusTransformUtils.preCheckCast(r4.get("translationX"), androidx.constraintlayout.motion.utils.b.class, "com.obric.aiagent.plugin");
        goto L14
    L9:
        r13 = (androidx.constraintlayout.a.a.a.j) ZeusTransformUtils.preCheckCast(r2.get("translationY"), androidx.constraintlayout.a.a.a.j.class, "com.obric.aiagent.plugin");
        goto L10
    L5:
        r12 = (androidx.constraintlayout.a.a.a.j) ZeusTransformUtils.preCheckCast(r1.get("translationX"), androidx.constraintlayout.a.a.a.j.class, "com.obric.aiagent.plugin");
        goto L6
    }

    private float k() {
        float[] r1 = new float[2];
        float r10 = 1.0f / 99;
        double r13 = 0.0d;
        double r15 = 0.0d;
        float r7 = 0.0f;
        int r8 = 0;
    L4:
        if (r8 >= 100) goto L28;
        float r2 = r8 * r10;
        double r3 = r2;
        androidx.constraintlayout.a.a.a.c r5 = this.l.f902b;
        Iterator<o> r6 = this.y.iterator();
        float r17 = Float.NaN;
        float r18 = 0.0f;
    L7:
        if (r6.hasNext() == false) goto L17;
        o r9 = (o) ZeusTransformUtils.preCheckCast(r6.next(), o.class, "com.obric.aiagent.plugin");
        if (r9.f902b == null) goto L7;
        if (r9.f904d >= r2) goto L14;
        r5 = r9.f902b;
        r18 = r9.f904d;
        goto L7
    L14:
        if (Float.isNaN(r17) == false) goto L7;
        r17 = r9.f904d;
        goto L7
    L17:
        if (r5 != null) goto L19;
    L22:
        this.p[0].a(r3, this.s);
        float r11 = r7;
        int r12 = r8;
        this.l.a(r3, this.r, this.s, r1, 0);
        if (r12 <= 0) goto L25;
        char r14 = 0;
        float r4 = (float) (((double) r11) + Math.hypot(r15 - ((double) r1[1]), r13 - ((double) r1[0])));
    L26:
        r13 = r1[r14];
        r8 = r12 + 1;
        r7 = r4;
        r15 = r1[1];
        goto L4
    L25:
        r14 = 0;
        r4 = r11;
        goto L26
    L19:
        if (Float.isNaN(r17) == false) goto L21;
        r17 = 1.0f;
    L21:
        float r19 = r17 - r18;
        r3 = (((float) r5.a((r2 - r18) / r19)) * r19) + r18;
        goto L22
    L28:
        return r7;
    }

    int a(float[] r11, int[] r12) {
        if (r11 == null) goto L16;
        double[] r1 = this.p[0].a();
        if (r12 == null) goto L10;
        Iterator<o> r2 = this.y.iterator();
        int r3 = 0;
    L8:
        if (r2.hasNext() == false) goto L10;
        r12[r3] = ((o) ZeusTransformUtils.preCheckCast(r2.next(), o.class, "com.obric.aiagent.plugin")).q;
        r3 = r3 + 1;
    L10:
        int r13 = 0;
        int r9 = 0;
    L12:
        if (r13 >= r1.length) goto L15;
        this.p[0].a(r1[r13], this.s);
        this.l.a(r1[r13], this.r, this.s, r11, r9);
        r9 = r9 + 2;
        r13 = r13 + 1;
        goto L12
    L15:
        return r9 / 2;
    L16:
        return 0;
    }

    void a(float r4, float[] r5, int r6) {
        this.p[0].a(a(r4, null), this.s);
        this.l.a(this.r, this.s, r5, r6);
    }

    private void a(o r4) {
        int r0 = Collections.binarySearch(this.y, r4);
        if (r0 != 0) goto L5;
        a(TAG, " KeyPath position \"" + r4.f905e + "\" outside of range");
    L5:
        this.y.add((-r0) - 1, r4);
    }

    void a(ArrayList<d> r1) {
        this.A.addAll(r1);
    }

    public void a(d r1) {
        this.A.add(r1);
    }

    public void b(int r1) {
        this.F = r1;
    }

    public void a(int r20, int r21, float r22, long r23) {
        new HashSet();
        HashSet<String> r2 = new HashSet();
        HashSet<String> r3 = new HashSet();
        HashSet<String> r4 = new HashSet();
        HashMap<String, Integer> r5 = new HashMap();
        if (this.F == d.f878a) goto L5;
        this.l.l = this.F;
    L5:
        this.n.a(this.o, r3);
        ArrayList<d> r6 = this.A;
        if (r6 == null) goto L27;
        Iterator<d> r7 = r6.iterator();
        ArrayList r9 = null;
    L9:
        if (r7.hasNext() == false) goto L29;
        d r10 = (d) ZeusTransformUtils.preCheckCast(r7.next(), d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r10, h.class) == true) goto L12;
        if (ZeusTransformUtils.instanceOf(r10, f.class) == true) goto L17;
        if (ZeusTransformUtils.instanceOf(r10, j.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r10, k.class) == true) goto L23;
        r10.b(r5);
        r10.a(r3);
        goto L9
    L23:
        if (r9 != null) goto L25;
        r9 = new ArrayList();
    L25:
        r9.add((k) ZeusTransformUtils.preCheckCast(r10, k.class, "com.obric.aiagent.plugin"));
        goto L9
    L20:
        r10.a(r2);
        goto L9
    L17:
        r10.a(r4);
        goto L9
    L12:
        h r11 = (h) ZeusTransformUtils.preCheckCast(r10, h.class, "com.obric.aiagent.plugin");
        a(new o(r20, r21, r11, this.l, this.m));
        if (r11.q == d.f878a) goto L9;
        this.k = r11.q;
    L29:
        if (r9 == null) goto L31;
        this.E = (k[]) ZeusTransformUtils.preCheckCast(r9.toArray(new k[0]), k[].class, "com.obric.aiagent.plugin");
    L31:
        char r12 = 1;
        if (r3.isEmpty() == true) goto L75;
        this.C = new HashMap();
        Iterator<String> r8 = r3.iterator();
    L35:
        if (r8.hasNext() == false) goto L54;
        String r13 = (String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.aiagent.plugin");
        if (r13.startsWith("CUSTOM,") == false) goto L49;
        SparseArray r14 = new SparseArray();
        String r15 = r13.split(",")[r12];
        Iterator<d> r16 = this.A.iterator();
    L40:
        if (r16.hasNext() == false) goto L48;
        d r17 = (d) ZeusTransformUtils.preCheckCast(r16.next(), d.class, "com.obric.aiagent.plugin");
        if (r17.f == null) goto L40;
        Iterator<String> r18 = r8;
        androidx.constraintlayout.widget.a r19 = (androidx.constraintlayout.widget.a) ZeusTransformUtils.preCheckCast(r17.f.get(r15), androidx.constraintlayout.widget.a.class, "com.obric.aiagent.plugin");
        if (r19 == null) goto L47;
        r14.append(r17.f879b, r19);
    L47:
        r8 = r18;
        goto L40
    L48:
        Iterator<String> r110 = r8;
        androidx.constraintlayout.motion.utils.c r24 = androidx.constraintlayout.motion.utils.c.a(r13, r14);
    L50:
        if (r24 == null) goto L53;
        r24.a(r13);
        this.C.put(r13, r24);
    L53:
        r8 = r110;
        r12 = 1;
        goto L35
    L49:
        r110 = r8;
        r24 = androidx.constraintlayout.motion.utils.c.b(r13);
        goto L50
    L54:
        ArrayList<d> r25 = this.A;
        if (r25 == null) goto L62;
        Iterator<d> r26 = r25.iterator();
    L58:
        if (r26.hasNext() == false) goto L62;
        d r27 = (d) ZeusTransformUtils.preCheckCast(r26.next(), d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r27, e.class) == false) goto L58;
        r27.a(this.C);
    L62:
        this.n.a(this.C, 0);
        this.o.a(this.C, 100);
        Iterator<String> r28 = this.C.keySet().iterator();
    L64:
        if (r28.hasNext() == false) goto L75;
        String r29 = (String) ZeusTransformUtils.preCheckCast(r28.next(), String.class, "com.obric.aiagent.plugin");
        if (r5.containsKey(r29) == false) goto L70;
        Integer r111 = (Integer) ZeusTransformUtils.preCheckCast(r5.get(r29), Integer.class, "com.obric.aiagent.plugin");
        if (r111 == null) goto L70;
        int r112 = r111.intValue();
    L71:
        androidx.constraintlayout.a.a.a.j r30 = (androidx.constraintlayout.a.a.a.j) ZeusTransformUtils.preCheckCast(this.C.get(r29), androidx.constraintlayout.a.a.a.j.class, "com.obric.aiagent.plugin");
        if (r30 == null) goto L64;
        r30.a(r112);
    L70:
        r112 = 0;
    L75:
        if (r2.isEmpty() == false) goto L77;
    L117:
        int r31 = 2;
        int r32 = this.y.size() + 2;
        o[] r33 = new o[r32];
        r33[0] = this.l;
        r33[r32 - 1] = this.m;
        if (this.y.size() > 0) goto L120;
    L122:
        Iterator<o> r34 = this.y.iterator();
        int r35 = 1;
    L124:
        if (r34.hasNext() == false) goto L126;
        r33[r35] = (o) ZeusTransformUtils.preCheckCast(r34.next(), o.class, "com.obric.aiagent.plugin");
        r35 = r35 + 1;
        goto L124
    L126:
        HashSet r36 = new HashSet();
        Iterator<String> r113 = this.m.p.keySet().iterator();
    L128:
        if (r113.hasNext() == false) goto L134;
        String r114 = (String) ZeusTransformUtils.preCheckCast(r113.next(), String.class, "com.obric.aiagent.plugin");
        if (this.l.p.containsKey(r114) == false) goto L128;
        if (r3.contains("CUSTOM," + r114) == true) goto L128;
        r36.add(r114);
        goto L128
    L134:
        String[] r37 = (String[]) ZeusTransformUtils.preCheckCast(r36.toArray(new String[0]), String[].class, "com.obric.aiagent.plugin");
        this.u = r37;
        this.v = new int[r37.length];
        int r38 = 0;
    L135:
        String[] r39 = this.u;
        if (r38 >= r39.length) goto L147;
        String r40 = r39[r38];
        this.v[r38] = 0;
        int r115 = 0;
    L138:
        if (r115 >= r32) goto L145;
        if (r33[r115].p.containsKey(r40) == false) goto L144;
        androidx.constraintlayout.widget.a r116 = (androidx.constraintlayout.widget.a) ZeusTransformUtils.preCheckCast(r33[r115].p.get(r40), androidx.constraintlayout.widget.a.class, "com.obric.aiagent.plugin");
        if (r116 == null) goto L144;
        int[] r41 = this.v;
        r41[r38] = r41[r38] + r116.c();
    L144:
        r115 = r115 + 1;
    L145:
        r38 = r38 + 1;
        goto L135
    L147:
        if (r33[0].l == d.f878a) goto L149;
        boolean r42 = true;
    L150:
        int r43 = 18 + this.u.length;
        boolean[] r44 = new boolean[r43];
        int r117 = 1;
    L151:
        if (r117 >= r32) goto L153;
        r33[r117].a(r33[r117 - 1], r44, this.u, r42);
        r117 = r117 + 1;
        goto L151
    L153:
        int r45 = 1;
        int r118 = 0;
    L154:
        if (r45 >= r43) goto L159;
        if (r44[r45] == false) goto L158;
        r118 = r118 + 1;
    L158:
        r45 = r45 + 1;
        goto L154
    L159:
        this.r = new int[r118];
        int r46 = Math.max(2, r118);
        this.s = new double[r46];
        this.t = new double[r46];
        int r47 = 1;
        int r119 = 0;
    L160:
        if (r47 >= r43) goto L165;
        if (r44[r47] == false) goto L164;
        this.r[r119] = r47;
        r119 = r119 + 1;
    L164:
        r47 = r47 + 1;
        goto L160
    L165:
        double[][] r48 = (double[][]) Array.newInstance(double.class, new int[]{r32, this.r.length});
        double[] r49 = new double[r32];
        int r50 = 0;
    L166:
        if (r50 >= r32) goto L168;
        r33[r50].a(r48[r50], this.r);
        r49[r50] = r33[r50].f904d;
        r50 = r50 + 1;
        goto L166
    L168:
        int r51 = 0;
    L169:
        int[] r120 = this.r;
        if (r51 >= r120.length) goto L177;
        if (r120[r51] >= o.f901a.length) goto L176;
        String r121 = o.f901a[this.r[r51]] + " [";
        int r122 = 0;
    L174:
        if (r122 >= r32) goto L176;
        r121 = r121 + r48[r122][r51];
        r122 = r122 + 1;
    L176:
        r51 = r51 + 1;
        goto L169
    L177:
        this.p = new androidx.constraintlayout.a.a.a.b[this.u.length + 1];
        int r52 = 0;
    L178:
        String[] r123 = this.u;
        if (r52 >= r123.length) goto L191;
        String r124 = r123[r52];
        int r125 = 0;
        int r126 = 0;
        double[] r127 = null;
        double[][] r128 = null;
    L181:
        if (r125 >= r32) goto L190;
        if (r33[r125].a(r124) == false) goto L189;
        if (r128 != null) goto L186;
        r127 = new double[r32];
        int[] r129 = new int[r31];
        r129[1] = r33[r125].b(r124);
        r129[0] = r32;
        double[][] r130 = (double[][]) Array.newInstance(double.class, r129);
        int r131 = 0;
        r128 = r130;
    L187:
        r127[r126] = r33[r125].f904d;
        r33[r125].a(r124, r128[r126], r131);
        r126 = r126 + 1;
        goto L189
    L186:
        r131 = 0;
    L189:
        r125 = r125 + 1;
        r4 = r4;
        r31 = 2;
        goto L181
    L190:
        r52 = r52 + 1;
        this.p[r52] = androidx.constraintlayout.a.a.a.b.a(this.k, Arrays.copyOf(r127, r126), (double[][]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r128, r126), double[][].class, "com.obric.aiagent.plugin"));
        r4 = r4;
        r31 = 2;
        goto L178
    L191:
        HashSet<String> r132 = r4;
        this.p[0] = androidx.constraintlayout.a.a.a.b.a(this.k, r49, r48);
        if (r33[0].l == d.f878a) goto L197;
        int[] r53 = new int[r32];
        double[] r54 = new double[r32];
        double[][] r1 = (double[][]) Array.newInstance(double.class, new int[]{r32, 2});
        int r133 = 0;
    L194:
        if (r133 >= r32) goto L196;
        r53[r133] = r33[r133].l;
        r54[r133] = r33[r133].f904d;
        r1[r133][0] = r33[r133].f;
        r1[r133][1] = r33[r133].g;
        r133 = r133 + 1;
        goto L194
    L196:
        this.q = androidx.constraintlayout.a.a.a.b.a(r53, r54, r1);
    L197:
        float r55 = Float.NaN;
        this.D = new HashMap();
        if (this.A == null) goto L221;
        Iterator<String> r56 = r132.iterator();
    L201:
        if (r56.hasNext() == false) goto L211;
        String r57 = (String) ZeusTransformUtils.preCheckCast(r56.next(), String.class, "com.obric.aiagent.plugin");
        androidx.constraintlayout.motion.utils.b r58 = androidx.constraintlayout.motion.utils.b.b(r57);
        if (r58 == null) goto L201;
        if (r58.a() == true) goto L208;
    L210:
        r58.a(r57);
        this.D.put(r57, r58);
        goto L201
    L208:
        if (Float.isNaN(r55) == false) goto L210;
        r55 = k();
        goto L210
    L211:
        Iterator<d> r59 = this.A.iterator();
    L213:
        if (r59.hasNext() == false) goto L217;
        d r60 = (d) ZeusTransformUtils.preCheckCast(r59.next(), d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r60, f.class) == false) goto L213;
        ((f) ZeusTransformUtils.preCheckCast(r60, f.class, "com.obric.aiagent.plugin")).c(this.D);
        goto L213
    L217:
        Iterator<androidx.constraintlayout.motion.utils.b> r0 = this.D.values().iterator();
    L219:
        if (r0.hasNext() == false) goto L318;
        ((androidx.constraintlayout.motion.utils.b) ZeusTransformUtils.preCheckCast(r0.next(), androidx.constraintlayout.motion.utils.b.class, "com.obric.aiagent.plugin")).c(r55);
        goto L219
    L318:
        return;
    L221:
        return;
    L149:
        r42 = false;
        goto L150
    L120:
        if (this.k != (-1)) goto L122;
        this.k = 0;
        goto L122
    L77:
        if (this.B != null) goto L79;
        this.B = new HashMap();
    L79:
        Iterator<String> r61 = r2.iterator();
    L81:
        if (r61.hasNext() == false) goto L101;
        String r62 = (String) ZeusTransformUtils.preCheckCast(r61.next(), String.class, "com.obric.aiagent.plugin");
        if (this.B.containsKey(r62) == true) goto L81;
        if (r62.startsWith("CUSTOM,") == false) goto L97;
        SparseArray r63 = new SparseArray();
        String r134 = r62.split(",")[1];
        Iterator<d> r135 = this.A.iterator();
    L89:
        if (r135.hasNext() == false) goto L96;
        d r136 = (d) ZeusTransformUtils.preCheckCast(r135.next(), d.class, "com.obric.aiagent.plugin");
        if (r136.f == null) goto L89;
        androidx.constraintlayout.widget.a r137 = (androidx.constraintlayout.widget.a) ZeusTransformUtils.preCheckCast(r136.f.get(r134), androidx.constraintlayout.widget.a.class, "com.obric.aiagent.plugin");
        if (r137 == null) goto L89;
        r63.append(r136.f879b, r137);
        goto L89
    L96:
        androidx.constraintlayout.motion.utils.e r64 = androidx.constraintlayout.motion.utils.e.a(r62, r63);
    L98:
        if (r64 == null) goto L81;
        r64.a(r62);
        this.B.put(r62, r64);
        goto L81
    L97:
        r64 = androidx.constraintlayout.motion.utils.e.a(r62, r23);
        goto L98
    L101:
        ArrayList<d> r65 = this.A;
        if (r65 == null) goto L109;
        Iterator<d> r66 = r65.iterator();
    L105:
        if (r66.hasNext() == false) goto L109;
        d r67 = (d) ZeusTransformUtils.preCheckCast(r66.next(), d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r67, j.class) == false) goto L105;
        ((j) ZeusTransformUtils.preCheckCast(r67, j.class, "com.obric.aiagent.plugin")).c(this.B);
    L109:
        Iterator<String> r68 = this.B.keySet().iterator();
    L111:
        if (r68.hasNext() == false) goto L117;
        String r69 = (String) ZeusTransformUtils.preCheckCast(r68.next(), String.class, "com.obric.aiagent.plugin");
        if (r5.containsKey(r69) == false) goto L115;
        int r70 = ((Integer) ZeusTransformUtils.preCheckCast(r5.get(r69), Integer.class, "com.obric.aiagent.plugin")).intValue();
    L116:
        ((androidx.constraintlayout.motion.utils.e) ZeusTransformUtils.preCheckCast(this.B.get(r69), androidx.constraintlayout.motion.utils.e.class, "com.obric.aiagent.plugin")).a(r70);
        goto L111
    L115:
        r70 = 0;
        goto L116
    L27:
        r9 = null;
        goto L29
    }

    public String toString() {
        return " start: x: " + this.l.f + " y: " + this.l.g + " end: x: " + this.m.f + " y: " + this.m.g;
    }

    private void b(o r4) {
        r4.a((int) this.f897b.getX(), (int) this.f897b.getY(), this.f897b.getWidth(), this.f897b.getHeight());
    }

    public void a(View r3) {
        this.f897b = r3;
        this.f898c = r3.getId();
        ViewGroup.LayoutParams r4 = r3.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r4, ConstraintLayout.LayoutParams.class) == false) goto L6;
        this.f900e = ((ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r4, ConstraintLayout.LayoutParams.class, "com.obric.aiagent.plugin")).getConstraintTag();
        return;
    }

    public View i() {
        return this.f897b;
    }

    void b(View r6) {
        this.l.f904d = 0.0f;
        this.l.f905e = 0.0f;
        this.l.a(r6.getX(), r6.getY(), r6.getWidth(), r6.getHeight());
        this.n.b(r6);
    }

    public void a(androidx.constraintlayout.motion.utils.d r5, View r6, int r7, int r8, int r9) {
        this.l.f904d = 0.0f;
        this.l.f905e = 0.0f;
        Rect r0 = new Rect();
        if (r7 == 1) goto L7;
        if (r7 != 2) goto L8;
        int r10 = r5.f832b + r5.f834d;
        r0.left = r9 - (((r5.f833c + r5.f835e) + r5.a()) / 2);
        r0.top = (r10 - r5.b()) / 2;
        r0.right = r0.left + r5.a();
        r0.bottom = r0.top + r5.b();
    L8:
        this.l.a(r0.left, r0.top, r0.width(), r0.height());
        this.n.a(r0, r6, r7, r5.f831a);
        return;
    L7:
        int r11 = r5.f832b + r5.f834d;
        r0.left = ((r5.f833c + r5.f835e) - r5.a()) / 2;
        r0.top = r8 - ((r11 + r5.b()) / 2);
        r0.right = r0.left + r5.a();
        r0.bottom = r0.top + r5.b();
        goto L8
    }

    void a(Rect r2, Rect r3, int r4, int r5, int r6) {
        if (r4 == 1) goto L13;
        if (r4 != 2) goto L6;
        int r1 = r2.left + r2.right;
        r3.left = r5 - (((r2.top + r2.bottom) + r2.width()) / 2);
        r3.top = (r1 - r2.height()) / 2;
        r3.right = r3.left + r2.width();
        r3.bottom = r3.top + r2.height();
        return;
    L6:
        if (r4 != 3) goto L8;
        int r7 = r2.left + r2.right;
        int r8 = r2.top;
        int r9 = r2.bottom;
        r3.left = ((r2.height() / 2) + r2.top) - (r7 / 2);
        r3.top = r6 - ((r7 + r2.height()) / 2);
        r3.right = r3.left + r2.width();
        r3.bottom = r3.top + r2.height();
        return;
    L8:
        if (r4 != 4) goto L18;
        int r10 = r2.left + r2.right;
        r3.left = r5 - (((r2.bottom + r2.top) + r2.width()) / 2);
        r3.top = (r10 - r2.height()) / 2;
        r3.right = r3.left + r2.width();
        r3.bottom = r3.top + r2.height();
        return;
    L18:
        return;
    L13:
        int r11 = r2.left + r2.right;
        r3.left = ((r2.top + r2.bottom) - r2.width()) / 2;
        r3.top = r6 - ((r11 + r2.height()) / 2);
        r3.right = r3.left + r2.width();
        r3.bottom = r3.top + r2.height();
    }

    void a(Rect r8, androidx.constraintlayout.widget.c r9, int r10, int r11) {
        int r6 = r9.f970c;
        if (r6 == 0) goto L5;
        a(r8, this.f896a, r6, r10, r11);
    L5:
        this.l.f904d = 0.0f;
        this.l.f905e = 0.0f;
        b(this.l);
        this.l.a(r8.left, r8.top, r8.width(), r8.height());
        androidx.constraintlayout.widget.c.a r12 = r9.a(this.f898c);
        this.l.a(r12);
        this.f = r12.f976d.g;
        this.n.a(r8, r9, r6, this.f898c);
        this.G = r12.f.i;
        this.I = r12.f976d.k;
        this.f895J = r12.f976d.j;
        this.K = a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f897b.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r12.f976d.m, r12.f976d.l, r12.f976d.n);
    }

    private static Interpolator a(Context r2, int r3, String r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (r3 == (-2)) goto L30;
        if (r3 == (-1)) goto L27;
        if (r3 == 0) goto L26;
        if (r3 == 1) goto L24;
        if (r3 == 2) goto L22;
        if (r3 == 4) goto L20;
        if (r3 == 5) goto L18;
        return null;
    L18:
        return new OvershootInterpolator();
    L20:
        return new BounceInterpolator();
    L22:
        return new DecelerateInterpolator();
    L24:
        return new AccelerateInterpolator();
    L26:
        return new AccelerateDecelerateInterpolator();
    L27:
        final androidx.constraintlayout.a.a.a.c r7 = androidx.constraintlayout.a.a.a.c.a(r4);
        return new MotionController$1(r7);
    L30:
        return AnimationUtils.loadInterpolator(r6, r5);
    }

    void b(Rect r8, androidx.constraintlayout.widget.c r9, int r10, int r11) {
        int r6 = r9.f970c;
        if (r6 == 0) goto L5;
        a(r8, this.f896a, r6, r10, r11);
        r8 = this.f896a;
    L5:
        this.m.f904d = 1.0f;
        this.m.f905e = 1.0f;
        b(this.m);
        this.m.a(r8.left, r8.top, r8.width(), r8.height());
        this.m.a(r9.a(this.f898c));
        this.o.a(r8, r9, r6, this.f898c);
    }

    void c(View r6) {
        this.l.f904d = 0.0f;
        this.l.f905e = 0.0f;
        this.L = true;
        this.l.a(r6.getX(), r6.getY(), r6.getWidth(), r6.getHeight());
        this.m.a(r6.getX(), r6.getY(), r6.getWidth(), r6.getHeight());
        this.n.b(r6);
        this.o.b(r6);
    }

    private float a(float r12, float[] r13) {
        float r0 = 0.0f;
        float r2 = 1.0f;
        if (r13 == null) goto L5;
        r13[0] = 1.0f;
    L15:
        androidx.constraintlayout.a.a.a.c r3 = this.l.f902b;
        float r4 = Float.NaN;
        Iterator<o> r11 = this.y.iterator();
    L17:
        if (r11.hasNext() == false) goto L26;
        o r5 = (o) ZeusTransformUtils.preCheckCast(r11.next(), o.class, "com.obric.aiagent.plugin");
        if (r5.f902b == null) goto L17;
        if (r5.f904d < r12) goto L22;
        if (Float.isNaN(r4) == false) goto L17;
        r4 = r5.f904d;
        goto L17
    L22:
        r3 = r5.f902b;
        r0 = r5.f904d;
        goto L17
    L26:
        if (r3 != null) goto L28;
        return r12;
    L28:
        if (Float.isNaN(r4) == true) goto L31;
        r2 = r4;
    L31:
        float r6 = r2 - r0;
        double r14 = (r12 - r0) / r6;
        float r1 = r0 + (((float) r3.a(r14)) * r6);
        if (r13 == null) goto L35;
        r13[0] = (float) r3.b(r14);
    L35:
        return r1;
    L5:
        float r7 = this.h;
        if (r7 == 1.0d) goto L15;
        float r8 = this.g;
        if (r12 >= r8) goto L11;
        r12 = 0.0f;
    L11:
        if (r12 <= r8) goto L15;
        if (r12 >= 1.0d) goto L15;
        r12 = Math.min((r12 - r8) * r7, 1.0f);
        goto L15
    }

    void a(boolean r5) {
        if ("button".equals(a.a(this.f897b)) == true) goto L5;
        return;
    L5:
        if (this.E == null) goto L18;
        int r0 = 0;
    L7:
        k[] r1 = this.E;
        if (r0 >= r1.length) goto L19;
        k r2 = r1[r0];
        if (r5 == false) goto L12;
        float r3 = -100.0f;
    L13:
        r2.a(r3, this.f897b);
        r0 = r0 + 1;
        goto L7
    L12:
        r3 = 100.0f;
        goto L13
    L19:
        return;
    }

    boolean a(View r21, float r22, long r23, androidx.constraintlayout.a.a.a.d r25) {
        float r2 = a(r22, null);
        if (this.I == d.f878a) goto L15;
        float r3 = 1.0f / this.I;
        float r4 = ((float) Math.floor(r2 / r3)) * r3;
        float r5 = (r2 % r3) / r3;
        if (Float.isNaN(this.f895J) == true) goto L7;
        r5 = (r5 + this.f895J) % 1.0f;
    L7:
        Interpolator r6 = this.K;
        if (r6 == null) goto L11;
        float r7 = r6.getInterpolation(r5);
    L14:
        r2 = (r7 * r3) + r4;
        goto L15
    L11:
        if (r5 <= 0.5d) goto L13;
        r7 = 1.0f;
        goto L14
    L13:
        r7 = 0.0f;
    L15:
        float r14 = r2;
        HashMap<String, androidx.constraintlayout.motion.utils.c> r8 = this.C;
        if (r8 == null) goto L21;
        Iterator<androidx.constraintlayout.motion.utils.c> r9 = r8.values().iterator();
    L19:
        if (r9.hasNext() == false) goto L21;
        ((androidx.constraintlayout.motion.utils.c) ZeusTransformUtils.preCheckCast(r9.next(), androidx.constraintlayout.motion.utils.c.class, "com.obric.aiagent.plugin")).a(r21, r14);
    L21:
        HashMap<String, androidx.constraintlayout.motion.utils.e> r10 = this.B;
        if (r10 == null) goto L31;
        Iterator<androidx.constraintlayout.motion.utils.e> r11 = r10.values().iterator();
        androidx.constraintlayout.motion.utils.e.d r12 = null;
        boolean r13 = false;
    L25:
        if (r11.hasNext() == false) goto L30;
        androidx.constraintlayout.motion.utils.e r1 = (androidx.constraintlayout.motion.utils.e) ZeusTransformUtils.preCheckCast(r11.next(), androidx.constraintlayout.motion.utils.e.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r1, androidx.constraintlayout.motion.utils.e.d.class) == true) goto L28;
        r13 = r13 | r1.a(r21, r14, r23, r25);
        goto L25
    L28:
        r12 = (androidx.constraintlayout.motion.utils.e.d) ZeusTransformUtils.preCheckCast(r1, androidx.constraintlayout.motion.utils.e.d.class, "com.obric.aiagent.plugin");
        goto L25
    L30:
        boolean r16 = r13;
        androidx.constraintlayout.motion.utils.e.d r15 = r12;
    L32:
        androidx.constraintlayout.a.a.a.b[] r17 = this.p;
        if (r17 == null) goto L92;
        double r18 = r14;
        r17[0].a(r18, this.s);
        this.p[0].b(r18, this.t);
        androidx.constraintlayout.a.a.a.b r19 = this.q;
        if (r19 == null) goto L40;
        double[] r20 = this.s;
        if (r20.length <= 0) goto L40;
        r19.a(r18, r20);
        this.q.b(r18, this.t);
    L40:
        if (this.L == true) goto L44;
        this.l.a(r14, r21, this.r, this.s, this.t, null, this.f899d);
        this.f899d = false;
    L44:
        if (this.G != d.f878a) goto L46;
    L55:
        HashMap<String, androidx.constraintlayout.motion.utils.c> r24 = this.C;
        if (r24 == null) goto L67;
        Iterator<androidx.constraintlayout.motion.utils.c> r26 = r24.values().iterator();
    L59:
        if (r26.hasNext() == false) goto L67;
        androidx.constraintlayout.a.a.a.j r27 = (androidx.constraintlayout.a.a.a.j) ZeusTransformUtils.preCheckCast(r26.next(), androidx.constraintlayout.a.a.a.j.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r27, androidx.constraintlayout.motion.utils.c.d.class) == false) goto L59;
        if (this.t.length <= 1) goto L59;
        androidx.constraintlayout.motion.utils.c.d r28 = (androidx.constraintlayout.motion.utils.c.d) ZeusTransformUtils.preCheckCast(r27, androidx.constraintlayout.motion.utils.c.d.class, "com.obric.aiagent.plugin");
        double[] r29 = this.t;
        r28.a(r21, r14, r29[0], r29[1]);
    L67:
        char r110 = 1;
        if (r15 == null) goto L70;
        double[] r30 = this.t;
        r16 = r16 | r15.a(r21, r25, r14, r23, r30[0], r30[1]);
    L70:
        int r31 = 1;
    L71:
        androidx.constraintlayout.a.a.a.b[] r32 = this.p;
        if (r31 >= r32.length) goto L75;
        r32[r31].a(r18, this.x);
        androidx.constraintlayout.motion.utils.a.a((androidx.constraintlayout.widget.a) ZeusTransformUtils.preCheckCast(this.l.p.get(this.u[r31 - 1]), androidx.constraintlayout.widget.a.class, "com.obric.aiagent.plugin"), r21, this.x);
        r31 = r31 + 1;
        goto L71
    L75:
        if (this.n.f891a == 0) goto L77;
    L85:
        int r33 = 0;
    L87:
        if (this.E == null) goto L100;
        int r34 = r33;
    L89:
        k[] r35 = this.E;
        if (r34 >= r35.length) goto L100;
        r35[r34].a(r14, r21);
        r34 = r34 + 1;
    L100:
        HashMap<String, androidx.constraintlayout.motion.utils.b> r36 = this.D;
        if (r36 == null) goto L109;
        Iterator<androidx.constraintlayout.motion.utils.b> r37 = r36.values().iterator();
    L104:
        if (r37.hasNext() == false) goto L109;
        androidx.constraintlayout.motion.utils.b r38 = (androidx.constraintlayout.motion.utils.b) ZeusTransformUtils.preCheckCast(r37.next(), androidx.constraintlayout.motion.utils.b.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r38, androidx.constraintlayout.motion.utils.b.d.class) == true) goto L107;
        r38.a(r21, r14);
        goto L104
    L107:
        androidx.constraintlayout.motion.utils.b.d r39 = (androidx.constraintlayout.motion.utils.b.d) ZeusTransformUtils.preCheckCast(r38, androidx.constraintlayout.motion.utils.b.d.class, "com.obric.aiagent.plugin");
        double[] r40 = this.t;
        r39.a(r21, r14, r40[r33], r40[r110]);
    L109:
        return r16;
    L77:
        if (r14 > 0.0f) goto L80;
        r21.setVisibility(this.n.f892b);
        goto L85
    L80:
        if (r14 < 1.0f) goto L83;
        r21.setVisibility(this.o.f892b);
        goto L85
    L83:
        if (this.o.f892b == this.n.f892b) goto L85;
        r33 = 0;
        r21.setVisibility(0);
        goto L87
    L46:
        if (this.H != null) goto L48;
        this.H = ((View) ZeusTransformUtils.preCheckCast(r21.getParent(), View.class, "com.obric.aiagent.plugin")).findViewById(this.G);
    L48:
        View r41 = this.H;
        if (r41 == null) goto L55;
        float r42 = (r41.getTop() + this.H.getBottom()) / 2.0f;
        float r43 = (this.H.getLeft() + this.H.getRight()) / 2.0f;
        if ((r21.getRight() - r21.getLeft()) <= 0) goto L55;
        if ((r21.getBottom() - r21.getTop()) <= 0) goto L55;
        float r44 = r43 - r21.getLeft();
        float r45 = r42 - r21.getTop();
        r21.setPivotX(r44);
        r21.setPivotY(r45);
        goto L55
    L92:
        r110 = 1;
        r33 = 0;
        float r46 = this.l.f + ((this.m.f - this.l.f) * r14);
        float r47 = this.l.g + ((this.m.g - this.l.g) * r14);
        float r48 = this.l.h + ((this.m.h - this.l.h) * r14);
        float r49 = r46 + 0.5f;
        int r50 = (int) r49;
        float r51 = r47 + 0.5f;
        int r52 = (int) r51;
        int r53 = (int) (r49 + r48);
        int r54 = (int) (r51 + (this.l.i + ((this.m.i - this.l.i) * r14)));
        int r55 = r53 - r50;
        int r56 = r54 - r52;
        if (this.m.h == this.l.h) goto L95;
    L98:
        r21.measure(View.MeasureSpec.makeMeasureSpec(r55, 1073741824), View.MeasureSpec.makeMeasureSpec(r56, 1073741824));
        this.f899d = false;
    L99:
        r21.layout(r50, r52, r53, r54);
        goto L100
    L95:
        if (this.m.i != this.l.i) goto L98;
        if (this.f899d == false) goto L99;
    L31:
        r15 = null;
        r16 = false;
        goto L32
    }

    void a(float r12, float r13, float r14, float[] r15) {
        float r16 = a(r12, this.z);
        androidx.constraintlayout.a.a.a.b[] r0 = this.p;
        int r1 = 0;
        if (r0 == null) goto L16;
        double r2 = r16;
        r0[0].b(r2, this.t);
        this.p[0].a(r2, this.s);
        float r17 = this.z[0];
    L5:
        double[] r9 = this.t;
        if (r1 >= r9.length) goto L8;
        r9[r1] = r9[r1] * ((double) r17);
        r1 = r1 + 1;
        goto L5
    L8:
        androidx.constraintlayout.a.a.a.b r18 = this.q;
        if (r18 == null) goto L14;
        double[] r3 = this.s;
        if (r3.length <= 0) goto L19;
        r18.a(r2, r3);
        this.q.b(r2, this.t);
        this.l.a(r13, r14, r15, this.r, this.t, this.s);
        return;
    L19:
        return;
    L14:
        this.l.a(r13, r14, r15, this.r, r9, this.s);
        return;
    L16:
        float r19 = this.m.f - this.l.f;
        float r4 = this.m.g - this.l.g;
        float r5 = (this.m.h - this.l.h) + r19;
        float r6 = (this.m.i - this.l.i) + r4;
        r15[0] = (r19 * (1.0f - r13)) + (r5 * r13);
        r15[1] = (r4 * (1.0f - r14)) + (r6 * r14);
    }

    void a(float r19, int r20, int r21, float r22, float r23, float[] r24) {
        float r1 = a(r19, this.z);
        HashMap<String, androidx.constraintlayout.motion.utils.c> r2 = this.C;
        androidx.constraintlayout.motion.utils.b r4 = null;
        if (r2 != null) goto L5;
        androidx.constraintlayout.a.a.a.j r3 = null;
    L6:
        HashMap<String, androidx.constraintlayout.motion.utils.c> r6 = this.C;
        if (r6 != null) goto L9;
        androidx.constraintlayout.a.a.a.j r7 = null;
    L10:
        HashMap<String, androidx.constraintlayout.motion.utils.c> r8 = this.C;
        if (r8 != null) goto L13;
        androidx.constraintlayout.a.a.a.j r9 = null;
    L14:
        HashMap<String, androidx.constraintlayout.motion.utils.c> r10 = this.C;
        if (r10 != null) goto L17;
        androidx.constraintlayout.a.a.a.j r11 = null;
    L18:
        HashMap<String, androidx.constraintlayout.motion.utils.c> r12 = this.C;
        if (r12 != null) goto L21;
        androidx.constraintlayout.a.a.a.j r13 = null;
    L22:
        HashMap<String, androidx.constraintlayout.motion.utils.b> r14 = this.D;
        if (r14 != null) goto L25;
        androidx.constraintlayout.motion.utils.b r5 = null;
    L26:
        HashMap<String, androidx.constraintlayout.motion.utils.b> r15 = this.D;
        if (r15 != null) goto L29;
        androidx.constraintlayout.motion.utils.b r16 = null;
    L30:
        HashMap<String, androidx.constraintlayout.motion.utils.b> r17 = this.D;
        if (r17 != null) goto L33;
        androidx.constraintlayout.motion.utils.b r18 = null;
    L34:
        HashMap<String, androidx.constraintlayout.motion.utils.b> r110 = this.D;
        if (r110 != null) goto L37;
        androidx.constraintlayout.motion.utils.b r111 = null;
    L38:
        HashMap<String, androidx.constraintlayout.motion.utils.b> r112 = this.D;
        if (r112 == null) goto L42;
        r4 = (androidx.constraintlayout.motion.utils.b) ZeusTransformUtils.preCheckCast(r112.get("scaleY"), androidx.constraintlayout.motion.utils.b.class, "com.obric.aiagent.plugin");
    L42:
        androidx.constraintlayout.a.a.a.p r113 = new androidx.constraintlayout.a.a.a.p();
        r113.a();
        r113.a(r9, r1);
        r113.a(r3, r7, r1);
        r113.b(r11, r13, r1);
        r113.a(r18, r1);
        r113.a(r5, r16, r1);
        r113.b(r111, r4, r1);
        androidx.constraintlayout.a.a.a.b r25 = this.q;
        if (r25 == null) goto L49;
        double[] r26 = this.s;
        if (r26.length <= 0) goto L47;
        double r27 = r1;
        r25.a(r27, r26);
        this.q.b(r27, this.t);
        this.l.a(r22, r23, r24, this.r, this.t, this.s);
    L47:
        r113.a(r22, r23, r20, r21, r24);
        return;
    L49:
        int r114 = 0;
        if (this.p == null) goto L57;
        double r28 = a(r1, this.z);
        this.p[0].b(r28, this.t);
        this.p[0].a(r28, this.s);
        float r29 = this.z[0];
    L52:
        double[] r30 = this.t;
        if (r114 >= r30.length) goto L55;
        r30[r114] = r30[r114] * ((double) r29);
        r114 = r114 + 1;
        goto L52
    L55:
        this.l.a(r22, r23, r24, this.r, r30, this.s);
        r113.a(r22, r23, r20, r21, r24);
        return;
    L57:
        float r31 = this.m.f - this.l.f;
        float r115 = this.m.g - this.l.g;
        androidx.constraintlayout.motion.utils.b r116 = r4;
        float r117 = (this.m.h - this.l.h) + r31;
        float r32 = (this.m.i - this.l.i) + r115;
        r24[0] = (r31 * (1.0f - r22)) + (r117 * r22);
        r24[1] = (r115 * (1.0f - r23)) + (r32 * r23);
        r113.a();
        r113.a(r9, r1);
        r113.a(r3, r7, r1);
        r113.b(r11, r13, r1);
        r113.a(r18, r1);
        r113.a(r5, r16, r1);
        r113.b(r111, r116, r1);
        r113.a(r22, r23, r20, r21, r24);
        return;
    L37:
        r111 = (androidx.constraintlayout.motion.utils.b) ZeusTransformUtils.preCheckCast(r110.get("scaleX"), androidx.constraintlayout.motion.utils.b.class, "com.obric.aiagent.plugin");
        goto L38
    L33:
        r18 = (androidx.constraintlayout.motion.utils.b) ZeusTransformUtils.preCheckCast(r17.get("rotation"), androidx.constraintlayout.motion.utils.b.class, "com.obric.aiagent.plugin");
        goto L34
    L29:
        r16 = (androidx.constraintlayout.motion.utils.b) ZeusTransformUtils.preCheckCast(r15.get("translationY"), androidx.constraintlayout.motion.utils.b.class, "com.obric.aiagent.plugin");
        goto L30
    L25:
        r5 = (androidx.constraintlayout.motion.utils.b) ZeusTransformUtils.preCheckCast(r14.get("translationX"), androidx.constraintlayout.motion.utils.b.class, "com.obric.aiagent.plugin");
        goto L26
    L21:
        r13 = (androidx.constraintlayout.a.a.a.j) ZeusTransformUtils.preCheckCast(r12.get("scaleY"), androidx.constraintlayout.a.a.a.j.class, "com.obric.aiagent.plugin");
        goto L22
    L17:
        r11 = (androidx.constraintlayout.a.a.a.j) ZeusTransformUtils.preCheckCast(r10.get("scaleX"), androidx.constraintlayout.a.a.a.j.class, "com.obric.aiagent.plugin");
        goto L18
    L13:
        r9 = (androidx.constraintlayout.a.a.a.j) ZeusTransformUtils.preCheckCast(r8.get("rotation"), androidx.constraintlayout.a.a.a.j.class, "com.obric.aiagent.plugin");
        goto L14
    L9:
        r7 = (androidx.constraintlayout.a.a.a.j) ZeusTransformUtils.preCheckCast(r6.get("translationY"), androidx.constraintlayout.a.a.a.j.class, "com.obric.aiagent.plugin");
        goto L10
    L5:
        r3 = (androidx.constraintlayout.a.a.a.j) ZeusTransformUtils.preCheckCast(r2.get("translationX"), androidx.constraintlayout.a.a.a.j.class, "com.obric.aiagent.plugin");
        goto L6
    }

    public int j() {
        int r0 = this.l.f903c;
        Iterator<o> r1 = this.y.iterator();
    L4:
        if (r1.hasNext() == false) goto L7;
        r0 = Math.max(r0, ((o) ZeusTransformUtils.preCheckCast(r1.next(), o.class, "com.obric.aiagent.plugin")).f903c);
        goto L4
    L7:
        return Math.max(r0, this.m.f903c);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1) {
        return Log.e(r0, r1);
    }
}
