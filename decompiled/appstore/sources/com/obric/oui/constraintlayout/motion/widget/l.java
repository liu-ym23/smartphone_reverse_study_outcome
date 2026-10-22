package com.obric.oui.constraintlayout.motion.widget;

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
import com.google.common.primitives.Ints;
import com.obric.oui.constraintlayout.widget.ConstraintAttribute;
import com.obric.oui.constraintlayout.widget.ConstraintLayout;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
public class l {
    public ArrayList A;
    public HashMap B;
    public HashMap C;
    public HashMap D;
    public j[] E;
    public int F;
    public int G;
    public View H;
    public int I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public float f13771J;
    public Interpolator K;
    public boolean L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Rect f13772a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f13773b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f13774c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f13775d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f13776e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f13777f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public n f13778g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public n f13779h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public k f13780i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public k f13781j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public vc.b[] f13782k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public vc.b f13783l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f13784m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f13785n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f13786o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f13787p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f13788q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int[] f13789r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public double[] f13790s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public double[] f13791t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String[] f13792u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int[] f13793v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f13794w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float[] f13795x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public ArrayList f13796y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float[] f13797z;

    public class a implements Interpolator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ vc.c f13798a;

        public a(vc.c r10) {
            this.f13798a = r10;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float r10) {
            return (float) this.f13798a.a(r10);
        }
    }

    public l(View r10) {
        this.f13772a = new Rect();
        this.f13775d = false;
        this.f13777f = -1;
        this.f13778g = new n();
        this.f13779h = new n();
        this.f13780i = new k();
        this.f13781j = new k();
        this.f13784m = Float.NaN;
        this.f13785n = 0.0f;
        this.f13786o = 1.0f;
        this.f13794w = 4;
        this.f13795x = new float[4];
        this.f13796y = new ArrayList();
        this.f13797z = new float[1];
        this.A = new ArrayList();
        int r11 = c.f13644f;
        this.F = r11;
        this.G = r11;
        this.H = null;
        this.I = r11;
        this.f13771J = Float.NaN;
        this.K = null;
        this.L = false;
        H(r10);
    }

    public static Interpolator p(Context r10, int r11, String r12, int r13) {
        if (r11 == (-2)) goto L30;
        if (r11 == (-1)) goto L28;
        if (r11 == 0) goto L26;
        if (r11 == 1) goto L24;
        if (r11 == 2) goto L22;
        if (r11 == 4) goto L20;
        if (r11 == 5) goto L18;
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
    L28:
        return new a(vc.c.c(r12));
    L30:
        return AnimationUtils.loadInterpolator(r10, r13);
    }

    public void A(Rect r10, Rect r11, int r12, int r13, int r14) {
        if (r12 == 1) goto L13;
        if (r12 != 2) goto L6;
        int r15 = r10.left + r10.right;
        r11.left = r13 - (((r10.top + r10.bottom) + r10.width()) / 2);
        r11.top = (r15 - r10.height()) / 2;
        r11.right = r11.left + r10.width();
        r11.bottom = r11.top + r10.height();
        return;
    L6:
        if (r12 != 3) goto L8;
        int r16 = r10.left + r10.right;
        r11.left = ((r10.height() / 2) + r10.top) - (r16 / 2);
        r11.top = r14 - ((r16 + r10.height()) / 2);
        r11.right = r11.left + r10.width();
        r11.bottom = r11.top + r10.height();
        return;
    L8:
        if (r12 != 4) goto L18;
        int r17 = r10.left + r10.right;
        r11.left = r13 - (((r10.bottom + r10.top) + r10.width()) / 2);
        r11.top = (r17 - r10.height()) / 2;
        r11.right = r11.left + r10.width();
        r11.bottom = r11.top + r10.height();
        return;
    L18:
        return;
    L13:
        int r18 = r10.left + r10.right;
        r11.left = ((r10.top + r10.bottom) - r10.width()) / 2;
        r11.top = r14 - ((r18 + r10.height()) / 2);
        r11.right = r11.left + r10.width();
        r11.bottom = r11.top + r10.height();
    }

    public void B(View r10) {
        n r11 = this.f13778g;
        r11.f13802c = 0.0f;
        r11.f13803d = 0.0f;
        this.L = true;
        r11.q(r10.getX(), r10.getY(), r10.getWidth(), r10.getHeight());
        this.f13779h.q(r10.getX(), r10.getY(), r10.getWidth(), r10.getHeight());
        this.f13780i.i(r10);
        this.f13781j.i(r10);
    }

    public void C(Rect r10, com.obric.oui.constraintlayout.widget.a r11, int r12, int r13) {
        int r14 = r11.f14168e;
        if (r14 == 0) goto L5;
        A(r10, this.f13772a, r14, r12, r13);
        r10 = this.f13772a;
    L5:
        n r15 = this.f13779h;
        r15.f13802c = 1.0f;
        r15.f13803d = 1.0f;
        y(r15);
        this.f13779h.q(r10.left, r10.top, r10.width(), r10.height());
        this.f13779h.a(r11.x(this.f13774c));
        this.f13781j.h(r10, r11, r14, this.f13774c);
    }

    public void D(int r10) {
        this.F = r10;
    }

    public void E(View r10) {
        n r11 = this.f13778g;
        r11.f13802c = 0.0f;
        r11.f13803d = 0.0f;
        r11.q(r10.getX(), r10.getY(), r10.getWidth(), r10.getHeight());
        this.f13780i.i(r10);
    }

    public void F(Rect r10, com.obric.oui.constraintlayout.widget.a r11, int r12, int r13) {
        int r14 = r11.f14168e;
        if (r14 == 0) goto L5;
        A(r10, this.f13772a, r14, r12, r13);
    L5:
        n r15 = this.f13778g;
        r15.f13802c = 0.0f;
        r15.f13803d = 0.0f;
        y(r15);
        this.f13778g.q(r10.left, r10.top, r10.width(), r10.height());
        com.obric.oui.constraintlayout.widget.a.C0195a r16 = r11.x(this.f13774c);
        this.f13778g.a(r16);
        this.f13784m = r16.f14175d.f14244g;
        this.f13780i.h(r10, r11, r14, this.f13774c);
        this.G = r16.f14177f.f14266i;
        com.obric.oui.constraintlayout.widget.a.c r17 = r16.f14175d;
        this.I = r17.f14248k;
        this.f13771J = r17.f14247j;
        Context r18 = this.f13773b.getContext();
        com.obric.oui.constraintlayout.widget.a.c r19 = r16.f14175d;
        this.K = p(r18, r19.f14250m, r19.f14249l, r19.f14251n);
    }

    public void G(yc.e r10, View r11, int r12, int r13, int r14) {
        n r15 = this.f13778g;
        r15.f13802c = 0.0f;
        r15.f13803d = 0.0f;
        Rect r16 = new Rect();
        if (r12 != 1) goto L5;
        throw null;
    L5:
        if (r12 == 2) goto L8;
        this.f13778g.q(r16.left, r16.top, r16.width(), r16.height());
        throw null;
    L8:
        throw null;
    }

    public void H(View r10) {
        this.f13773b = r10;
        this.f13774c = r10.getId();
        ViewGroup.LayoutParams r11 = r10.getLayoutParams();
        if ((r11 instanceof ConstraintLayout.LayoutParams) == false) goto L6;
        this.f13776e = ((ConstraintLayout.LayoutParams) r11).a();
        return;
    }

    public void I(int r17, int r18, float r19, long r20) {
        new HashSet();
        HashSet r10 = new HashSet();
        HashSet r11 = new HashSet();
        HashSet r12 = new HashSet();
        HashMap r13 = new HashMap();
        int r14 = this.F;
        if (r14 == c.f13644f) goto L5;
        this.f13778g.f13810k = r14;
    L5:
        this.f13780i.f(this.f13781j, r11);
        ArrayList r15 = this.A;
        if (r15 == null) goto L27;
        Iterator r16 = r15.iterator();
        ArrayList r21 = null;
    L9:
        if (r16.hasNext() == false) goto L29;
        c r22 = (c) r16.next();
        if ((r22 instanceof g) == true) goto L12;
        if ((r22 instanceof e) == true) goto L17;
        if ((r22 instanceof i) == true) goto L20;
        if ((r22 instanceof j) == true) goto L23;
        r22.h(r13);
        r22.d(r11);
        goto L9
    L23:
        if (r21 != null) goto L25;
        r21 = new ArrayList();
    L25:
        r21.add((j) r22);
        goto L9
    L20:
        r22.d(r10);
        goto L9
    L17:
        r22.d(r12);
        goto L9
    L12:
        g r23 = (g) r22;
        w(new n(r17, r18, r23, this.f13778g, this.f13779h));
        int r24 = r23.f13704g;
        if (r24 == c.f13644f) goto L9;
        this.f13777f = r24;
    L29:
        if (r21 == null) goto L31;
        this.E = (j[]) r21.toArray(new j[0]);
    L31:
        char r110 = 1;
        if (r11.isEmpty() == true) goto L73;
        this.C = new HashMap();
        Iterator r25 = r11.iterator();
    L35:
        if (r25.hasNext() == false) goto L52;
        String r111 = (String) r25.next();
        if (r111.startsWith("CUSTOM,") == false) goto L48;
        SparseArray r112 = new SparseArray();
        String r113 = r111.split(",")[1];
        Iterator r114 = this.A.iterator();
    L40:
        if (r114.hasNext() == false) goto L47;
        c r115 = (c) r114.next();
        HashMap r26 = r115.f13649e;
        if (r26 == null) goto L40;
        ConstraintAttribute r27 = (ConstraintAttribute) r26.get(r113);
        if (r27 == null) goto L40;
        r112.append(r115.f13645a, r27);
        goto L40
    L47:
        yc.d r28 = yc.d.f(r111, r112);
    L49:
        if (r28 == null) goto L35;
        r28.d(r111);
        this.C.put(r111, r28);
        goto L35
    L48:
        r28 = yc.d.g(r111);
        goto L49
    L52:
        ArrayList r29 = this.A;
        if (r29 == null) goto L60;
        Iterator r30 = r29.iterator();
    L56:
        if (r30.hasNext() == false) goto L60;
        c r31 = (c) r30.next();
        if ((r31 instanceof d) == false) goto L56;
        r31.a(this.C);
    L60:
        this.f13780i.a(this.C, 0);
        this.f13781j.a(this.C, 100);
        Iterator r32 = this.C.keySet().iterator();
    L62:
        if (r32.hasNext() == false) goto L73;
        String r33 = (String) r32.next();
        if (r13.containsKey(r33) == false) goto L68;
        Integer r116 = (Integer) r13.get(r33);
        if (r116 == null) goto L68;
        int r117 = r116.intValue();
    L69:
        com.obric.oui.constraintlayout.core.motion.utils.b r34 = (com.obric.oui.constraintlayout.core.motion.utils.b) this.C.get(r33);
        if (r34 == null) goto L62;
        r34.e(r117);
    L68:
        r117 = 0;
    L73:
        if (r10.isEmpty() == false) goto L75;
    L115:
        int r35 = this.f13796y.size();
        int r36 = r35 + 2;
        n[] r37 = new n[r36];
        r37[0] = this.f13778g;
        r37[r35 + 1] = this.f13779h;
        if (this.f13796y.size() > 0) goto L118;
    L120:
        Iterator r38 = this.f13796y.iterator();
        int r39 = 1;
    L122:
        if (r38.hasNext() == false) goto L124;
        r37[r39] = (n) r38.next();
        r39 = r39 + 1;
        goto L122
    L124:
        HashSet r40 = new HashSet();
        Iterator r41 = this.f13779h.f13814o.keySet().iterator();
    L126:
        if (r41.hasNext() == false) goto L132;
        String r42 = (String) r41.next();
        if (this.f13778g.f13814o.containsKey(r42) == false) goto L126;
        if (r11.contains("CUSTOM," + r42) == true) goto L126;
        r40.add(r42);
        goto L126
    L132:
        String[] r43 = (String[]) r40.toArray(new String[0]);
        this.f13792u = r43;
        this.f13793v = new int[r43.length];
        int r44 = 0;
    L133:
        String[] r45 = this.f13792u;
        if (r44 >= r45.length) goto L145;
        String r46 = r45[r44];
        this.f13793v[r44] = 0;
        int r47 = 0;
    L136:
        if (r47 >= r36) goto L143;
        if (r37[r47].f13814o.containsKey(r46) == false) goto L142;
        ConstraintAttribute r48 = (ConstraintAttribute) r37[r47].f13814o.get(r46);
        if (r48 == null) goto L142;
        int[] r49 = this.f13793v;
        r49[r44] = r49[r44] + r48.h();
    L142:
        r47 = r47 + 1;
    L143:
        r44 = r44 + 1;
        goto L133
    L145:
        if (r37[0].f13810k == c.f13644f) goto L147;
        boolean r50 = true;
    L148:
        int r51 = 18 + r45.length;
        boolean[] r52 = new boolean[r51];
        int r53 = 1;
    L149:
        if (r53 >= r36) goto L151;
        r37[r53].d(r37[r53 - 1], r52, this.f13792u, r50);
        r53 = r53 + 1;
        goto L149
    L151:
        int r54 = 0;
        int r55 = 1;
    L152:
        if (r55 >= r51) goto L157;
        if (r52[r55] == false) goto L156;
        r54 = r54 + 1;
    L156:
        r55 = r55 + 1;
        goto L152
    L157:
        this.f13789r = new int[r54];
        int r56 = 2;
        int r57 = Math.max(2, r54);
        this.f13790s = new double[r57];
        this.f13791t = new double[r57];
        int r58 = 0;
        int r59 = 1;
    L158:
        if (r59 >= r51) goto L163;
        if (r52[r59] == false) goto L162;
        this.f13789r[r58] = r59;
        r58 = r58 + 1;
    L162:
        r59 = r59 + 1;
        goto L158
    L163:
        double[][] r60 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r36, this.f13789r.length});
        double[] r61 = new double[r36];
        int r62 = 0;
    L164:
        if (r62 >= r36) goto L166;
        r37[r62].e(r60[r62], this.f13789r);
        r61[r62] = r37[r62].f13802c;
        r62 = r62 + 1;
        goto L164
    L166:
        int r63 = 0;
    L167:
        int[] r64 = this.f13789r;
        if (r63 >= r64.length) goto L175;
        if (r64[r63] >= n.f13799t.length) goto L174;
        String r65 = n.f13799t[this.f13789r[r63]] + " [";
        int r118 = 0;
    L172:
        if (r118 >= r36) goto L174;
        r65 = r65 + r60[r118][r63];
        r118 = r118 + 1;
    L174:
        r63 = r63 + 1;
        goto L167
    L175:
        this.f13782k = new vc.b[this.f13792u.length + 1];
        int r66 = 0;
    L176:
        String[] r67 = this.f13792u;
        if (r66 >= r67.length) goto L188;
        String r68 = r67[r66];
        int r119 = 0;
        int r120 = 0;
        double[] r121 = null;
        double[][] r122 = null;
    L179:
        if (r119 >= r36) goto L187;
        if (r37[r119].k(r68) == false) goto L186;
        if (r122 != null) goto L184;
        r121 = new double[r36];
        int[] r123 = new int[r56];
        r123[r110] = r37[r119].i(r68);
        r123[0] = r36;
        r122 = (double[][]) Array.newInstance(Double.TYPE, r123);
    L184:
        n r124 = r37[r119];
        r121[r120] = r124.f13802c;
        r124.h(r68, r122[r120], 0);
        r120 = r120 + 1;
    L186:
        r119 = r119 + 1;
        r60 = r60;
        r56 = 2;
        r110 = 1;
        goto L179
    L187:
        r66 = r66 + 1;
        this.f13782k[r66] = vc.b.a(this.f13777f, Arrays.copyOf(r121, r120), (double[][]) Arrays.copyOf(r122, r120));
        r60 = r60;
        r56 = 2;
        r110 = 1;
        goto L176
    L188:
        this.f13782k[0] = vc.b.a(this.f13777f, r61, r60);
        if (r37[0].f13810k == c.f13644f) goto L194;
        int[] r69 = new int[r36];
        double[] r70 = new double[r36];
        double[][] r71 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r36, 2});
        int r72 = 0;
    L191:
        if (r72 >= r36) goto L193;
        n r73 = r37[r72];
        r69[r72] = r73.f13810k;
        r70[r72] = r73.f13802c;
        double[] r125 = r71[r72];
        r125[0] = r73.f13804e;
        r125[1] = r73.f13805f;
        r72 = r72 + 1;
        goto L191
    L193:
        this.f13783l = vc.b.b(r69, r70, r71);
    L194:
        this.D = new HashMap();
        if (this.A == null) goto L218;
        Iterator r74 = r12.iterator();
        float r75 = Float.NaN;
    L198:
        if (r74.hasNext() == false) goto L208;
        String r76 = (String) r74.next();
        yc.c r77 = yc.c.i(r76);
        if (r77 == null) goto L198;
        if (r77.h() == true) goto L205;
    L207:
        r77.f(r76);
        this.D.put(r76, r77);
        goto L198
    L205:
        if (Float.isNaN(r75) == false) goto L207;
        r75 = s();
        goto L207
    L208:
        Iterator r78 = this.A.iterator();
    L210:
        if (r78.hasNext() == false) goto L214;
        c r79 = (c) r78.next();
        if ((r79 instanceof e) == false) goto L210;
        ((e) r79).Y(this.D);
        goto L210
    L214:
        Iterator r80 = this.D.values().iterator();
    L216:
        if (r80.hasNext() == false) goto L321;
        ((yc.c) r80.next()).g(r75);
        goto L216
    L321:
        return;
    L218:
        return;
    L147:
        r50 = false;
        goto L148
    L118:
        if (this.f13777f != (-1)) goto L120;
        this.f13777f = 0;
        goto L120
    L75:
        if (this.B != null) goto L77;
        this.B = new HashMap();
    L77:
        Iterator r81 = r10.iterator();
    L79:
        if (r81.hasNext() == false) goto L99;
        String r82 = (String) r81.next();
        if (this.B.containsKey(r82) == true) goto L79;
        if (r82.startsWith("CUSTOM,") == false) goto L95;
        SparseArray r83 = new SparseArray();
        String r126 = r82.split(",")[1];
        Iterator r127 = this.A.iterator();
    L87:
        if (r127.hasNext() == false) goto L94;
        c r128 = (c) r127.next();
        HashMap r129 = r128.f13649e;
        if (r129 == null) goto L87;
        ConstraintAttribute r130 = (ConstraintAttribute) r129.get(r126);
        if (r130 == null) goto L87;
        r83.append(r128.f13645a, r130);
        goto L87
    L94:
        yc.f r84 = yc.f.g(r82, r83);
    L96:
        if (r84 == null) goto L79;
        r84.d(r82);
        this.B.put(r82, r84);
        goto L79
    L95:
        r84 = yc.f.h(r82, r20);
        goto L96
    L99:
        ArrayList r85 = this.A;
        if (r85 == null) goto L107;
        Iterator r86 = r85.iterator();
    L103:
        if (r86.hasNext() == false) goto L107;
        c r87 = (c) r86.next();
        if ((r87 instanceof i) == false) goto L103;
        ((i) r87).U(this.B);
    L107:
        Iterator r88 = this.B.keySet().iterator();
    L109:
        if (r88.hasNext() == false) goto L115;
        String r89 = (String) r88.next();
        if (r13.containsKey(r89) == false) goto L113;
        int r90 = ((Integer) r13.get(r89)).intValue();
    L114:
        ((yc.f) this.B.get(r89)).e(r90);
        goto L109
    L113:
        r90 = 0;
        goto L114
    L27:
        r21 = null;
        goto L29
    }

    public void J(l r10) {
        this.f13778g.t(r10, r10.f13778g);
        this.f13779h.t(r10, r10.f13779h);
    }

    public void a(c r10) {
        this.A.add(r10);
    }

    public void b(ArrayList r10) {
        this.A.addAll(r10);
    }

    public int c(float[] r11, int[] r12) {
        if (r11 == null) goto L16;
        double[] r10 = this.f13782k[0].h();
        if (r12 == null) goto L10;
        Iterator r13 = this.f13796y.iterator();
        int r14 = 0;
    L8:
        if (r13.hasNext() == false) goto L10;
        r12[r14] = ((n) r13.next()).f13815p;
        r14 = r14 + 1;
    L10:
        int r15 = 0;
        int r16 = 0;
    L12:
        if (r15 >= r10.length) goto L15;
        this.f13782k[0].d(r10[r15], this.f13790s);
        this.f13778g.f(r10[r15], this.f13789r, this.f13790s, r11, r16);
        r16 = r16 + 2;
        r15 = r15 + 1;
        goto L12
    L15:
        return r16 / 2;
    L16:
        return 0;
    }

    public void d(float[] r21, int r22) {
        float r10 = 1.0f;
        float r11 = 1.0f / (r22 - 1);
        HashMap r12 = this.C;
        yc.c r13 = null;
        if (r12 != null) goto L5;
        com.obric.oui.constraintlayout.core.motion.utils.b r14 = null;
    L6:
        HashMap r15 = this.C;
        if (r15 != null) goto L9;
        com.obric.oui.constraintlayout.core.motion.utils.b r16 = null;
    L10:
        HashMap r17 = this.D;
        if (r17 != null) goto L13;
        yc.c r18 = null;
    L14:
        HashMap r19 = this.D;
        if (r19 != null) goto L17;
    L16:
        yc.c r110 = r13;
        int r20 = 0;
    L19:
        if (r20 >= r22) goto L64;
        float r23 = r20 * r11;
        float r24 = this.f13786o;
        float r25 = 0.0f;
        if (r24 == r10) goto L30;
        float r26 = this.f13785n;
        if (r23 >= r26) goto L26;
        r23 = 0.0f;
    L26:
        if (r23 <= r26) goto L30;
        if (r23 >= 1.0d) goto L30;
        r23 = Math.min((r23 - r26) * r24, r10);
    L30:
        float r27 = r23;
        double r28 = r27;
        vc.c r29 = this.f13778g.f13800a;
        Iterator r30 = this.f13796y.iterator();
        float r111 = Float.NaN;
    L32:
        if (r30.hasNext() == false) goto L42;
        n r31 = (n) r30.next();
        vc.c r112 = r31.f13800a;
        double r113 = r28;
        if (r112 == null) goto L41;
        float r32 = r31.f13802c;
        if (r32 >= r27) goto L39;
        r25 = r32;
        r29 = r112;
        goto L41
    L39:
        if (Float.isNaN(r111) == false) goto L41;
        r111 = r31.f13802c;
    L41:
        r28 = r113;
        goto L32
    L42:
        double r114 = r28;
        if (r29 != null) goto L45;
        double r33 = r114;
    L49:
        this.f13782k[0].d(r33, this.f13790s);
        vc.b r34 = this.f13783l;
        if (r34 == null) goto L54;
        double[] r35 = this.f13790s;
        if (r35.length <= 0) goto L54;
        r34.d(r33, r35);
    L54:
        int r115 = r20 * 2;
        int r116 = r20;
        this.f13778g.f(r33, this.f13789r, this.f13790s, r21, r115);
        if (r18 == null) goto L57;
        r21[r115] = r21[r115] + r18.a(r27);
    L59:
        if (r110 == null) goto L61;
        int r117 = r115 + 1;
        r21[r117] = r21[r117] + r110.a(r27);
    L63:
        r20 = r116 + 1;
        r10 = 1.0f;
        goto L19
    L61:
        if (r16 == null) goto L63;
        int r118 = r115 + 1;
        r21[r118] = r21[r118] + r16.a(r27);
        goto L63
    L57:
        if (r14 == null) goto L59;
        r21[r115] = r21[r115] + r14.a(r27);
        goto L59
    L45:
        if (Float.isNaN(r111) == false) goto L47;
        r111 = 1.0f;
    L47:
        float r119 = r111 - r25;
        r33 = (((float) r29.a((r27 - r25) / r119)) * r119) + r25;
        goto L49
    L64:
        return;
    L17:
        r13 = (yc.c) r19.get("translationY");
        goto L16
    L13:
        r18 = (yc.c) r17.get("translationX");
        goto L14
    L9:
        r16 = (com.obric.oui.constraintlayout.core.motion.utils.b) r15.get("translationY");
        goto L10
    L5:
        r14 = (com.obric.oui.constraintlayout.core.motion.utils.b) r12.get("translationX");
        goto L6
    }

    public void e(float r10, float[] r11, int r12) {
        this.f13782k[0].d(g(r10, null), this.f13790s);
        this.f13778g.j(this.f13789r, this.f13790s, r11, r12);
    }

    public void f(boolean r10) {
        if ("button".equals(com.obric.oui.constraintlayout.motion.widget.a.d(this.f13773b)) == true) goto L5;
        return;
    L5:
        if (this.E == null) goto L18;
        int r11 = 0;
    L7:
        j[] r12 = this.E;
        if (r11 >= r12.length) goto L19;
        j r13 = r12[r11];
        if (r10 == false) goto L12;
        float r14 = -100.0f;
    L13:
        r13.y(r14, this.f13773b);
        r11 = r11 + 1;
        goto L7
    L12:
        r14 = 100.0f;
        goto L13
    L19:
        return;
    }

    public final float g(float r11, float[] r12) {
        float r10 = 0.0f;
        float r13 = 1.0f;
        if (r12 == null) goto L5;
        r12[0] = 1.0f;
    L15:
        vc.c r14 = this.f13778g.f13800a;
        Iterator r15 = this.f13796y.iterator();
        float r16 = Float.NaN;
    L17:
        if (r15.hasNext() == false) goto L26;
        n r17 = (n) r15.next();
        vc.c r18 = r17.f13800a;
        if (r18 == null) goto L17;
        float r19 = r17.f13802c;
        if (r19 < r11) goto L22;
        if (Float.isNaN(r16) == false) goto L17;
        r16 = r17.f13802c;
        goto L17
    L22:
        r14 = r18;
        r10 = r19;
        goto L17
    L26:
        if (r14 != null) goto L28;
        return r11;
    L28:
        if (Float.isNaN(r16) == true) goto L31;
        r13 = r16;
    L31:
        float r20 = r13 - r10;
        double r110 = (r11 - r10) / r20;
        float r21 = r10 + (((float) r14.a(r110)) * r20);
        if (r12 == null) goto L35;
        r12[0] = (float) r14.b(r110);
    L35:
        return r21;
    L5:
        float r22 = this.f13786o;
        if (r22 == 1.0d) goto L15;
        float r23 = this.f13785n;
        if (r11 >= r23) goto L11;
        r11 = 0.0f;
    L11:
        if (r11 <= r23) goto L15;
        if (r11 >= 1.0d) goto L15;
        r11 = Math.min((r11 - r23) * r22, 1.0f);
        goto L15
    }

    public int h() {
        return this.f13778g.f13811l;
    }

    public void i(double r10, float[] r12, float[] r13) {
        double[] r11 = new double[4];
        double[] r14 = new double[4];
        this.f13782k[0].d(r10, r11);
        this.f13782k[0].g(r10, r14);
        Arrays.fill(r13, 0.0f);
        this.f13778g.g(r10, this.f13789r, r11, r12, r14, r13);
    }

    public float j() {
        return this.f13787p;
    }

    public float k() {
        return this.f13788q;
    }

    public void l(float r12, float r13, float r14, float[] r15) {
        float r16 = g(r12, this.f13797z);
        vc.b[] r10 = this.f13782k;
        int r11 = 0;
        if (r10 == null) goto L16;
        double r17 = r16;
        r10[0].g(r17, this.f13791t);
        this.f13782k[0].d(r17, this.f13790s);
        float r18 = this.f13797z[0];
    L5:
        double[] r19 = this.f13791t;
        if (r11 >= r19.length) goto L8;
        r19[r11] = r19[r11] * ((double) r18);
        r11 = r11 + 1;
        goto L5
    L8:
        vc.b r110 = this.f13783l;
        if (r110 == null) goto L14;
        double[] r20 = this.f13790s;
        if (r20.length <= 0) goto L19;
        r110.d(r17, r20);
        this.f13783l.g(r17, this.f13791t);
        this.f13778g.r(r13, r14, r15, this.f13789r, this.f13791t, this.f13790s);
        return;
    L19:
        return;
    L14:
        this.f13778g.r(r13, r14, r15, this.f13789r, r19, this.f13790s);
        return;
    L16:
        n r111 = this.f13779h;
        float r21 = r111.f13804e;
        n r112 = this.f13778g;
        float r22 = r21 - r112.f13804e;
        float r23 = r111.f13805f - r112.f13805f;
        float r24 = (r111.f13806g - r112.f13806g) + r22;
        float r113 = (r111.f13807h - r112.f13807h) + r23;
        r15[0] = (r22 * (1.0f - r13)) + (r24 * r13);
        r15[1] = (r23 * (1.0f - r14)) + (r113 * r14);
    }

    public int m() {
        int r10 = this.f13778g.f13801b;
        Iterator r11 = this.f13796y.iterator();
    L4:
        if (r11.hasNext() == false) goto L7;
        r10 = Math.max(r10, ((n) r11.next()).f13801b);
        goto L4
    L7:
        return Math.max(r10, this.f13779h.f13801b);
    }

    public float n() {
        return this.f13779h.f13804e;
    }

    public float o() {
        return this.f13779h.f13805f;
    }

    public n q(int r10) {
        return (n) this.f13796y.get(r10);
    }

    public void r(float r19, int r20, int r21, float r22, float r23, float[] r24) {
        float r10 = g(r19, this.f13797z);
        HashMap r11 = this.C;
        yc.c r12 = null;
        if (r11 != null) goto L5;
        com.obric.oui.constraintlayout.core.motion.utils.b r13 = null;
    L6:
        HashMap r14 = this.C;
        if (r14 != null) goto L9;
        com.obric.oui.constraintlayout.core.motion.utils.b r15 = null;
    L10:
        HashMap r16 = this.C;
        if (r16 != null) goto L13;
        com.obric.oui.constraintlayout.core.motion.utils.b r17 = null;
    L14:
        HashMap r18 = this.C;
        if (r18 != null) goto L17;
        com.obric.oui.constraintlayout.core.motion.utils.b r25 = null;
    L18:
        HashMap r110 = this.C;
        if (r110 != null) goto L21;
        com.obric.oui.constraintlayout.core.motion.utils.b r111 = null;
    L22:
        HashMap r112 = this.D;
        if (r112 != null) goto L25;
        yc.c r26 = null;
    L26:
        HashMap r113 = this.D;
        if (r113 != null) goto L29;
        yc.c r27 = null;
    L30:
        HashMap r114 = this.D;
        if (r114 != null) goto L33;
        yc.c r28 = null;
    L34:
        HashMap r115 = this.D;
        if (r115 != null) goto L37;
        yc.c r116 = null;
    L38:
        HashMap r117 = this.D;
        if (r117 == null) goto L42;
        r12 = (yc.c) r117.get("scaleY");
    L42:
        vc.m r118 = new vc.m();
        r118.b();
        r118.d(r17, r10);
        r118.h(r13, r15, r10);
        r118.f(r25, r111, r10);
        r118.c(r28, r10);
        r118.g(r26, r27, r10);
        r118.e(r116, r12, r10);
        vc.b r119 = this.f13783l;
        if (r119 == null) goto L49;
        double[] r29 = this.f13790s;
        if (r29.length <= 0) goto L47;
        double r30 = r10;
        r119.d(r30, r29);
        this.f13783l.g(r30, this.f13791t);
        this.f13778g.r(r22, r23, r24, this.f13789r, this.f13791t, this.f13790s);
    L47:
        r118.a(r22, r23, r20, r21, r24);
        return;
    L49:
        int r120 = 0;
        if (this.f13782k == null) goto L57;
        double r31 = g(r10, this.f13797z);
        this.f13782k[0].g(r31, this.f13791t);
        this.f13782k[0].d(r31, this.f13790s);
        float r32 = this.f13797z[0];
    L52:
        double[] r33 = this.f13791t;
        if (r120 >= r33.length) goto L55;
        r33[r120] = r33[r120] * ((double) r32);
        r120 = r120 + 1;
        goto L52
    L55:
        this.f13778g.r(r22, r23, r24, this.f13789r, r33, this.f13790s);
        r118.a(r22, r23, r20, r21, r24);
        return;
    L57:
        n r121 = this.f13779h;
        float r122 = r121.f13804e;
        n r34 = this.f13778g;
        float r123 = r122 - r34.f13804e;
        yc.c r124 = r12;
        float r125 = r121.f13805f - r34.f13805f;
        yc.c r126 = r116;
        float r35 = (r121.f13806g - r34.f13806g) + r123;
        float r127 = (r121.f13807h - r34.f13807h) + r125;
        r24[0] = (r123 * (1.0f - r22)) + (r35 * r22);
        r24[1] = (r125 * (1.0f - r23)) + (r127 * r23);
        r118.b();
        r118.d(r17, r10);
        r118.h(r13, r15, r10);
        r118.f(r25, r111, r10);
        r118.c(r28, r10);
        r118.g(r26, r27, r10);
        r118.e(r126, r124, r10);
        r118.a(r22, r23, r20, r21, r24);
        return;
    L37:
        r116 = (yc.c) r115.get("scaleX");
        goto L38
    L33:
        r28 = (yc.c) r114.get("rotation");
        goto L34
    L29:
        r27 = (yc.c) r113.get("translationY");
        goto L30
    L25:
        r26 = (yc.c) r112.get("translationX");
        goto L26
    L21:
        r111 = (com.obric.oui.constraintlayout.core.motion.utils.b) r110.get("scaleY");
        goto L22
    L17:
        r25 = (com.obric.oui.constraintlayout.core.motion.utils.b) r18.get("scaleX");
        goto L18
    L13:
        r17 = (com.obric.oui.constraintlayout.core.motion.utils.b) r16.get("rotation");
        goto L14
    L9:
        r15 = (com.obric.oui.constraintlayout.core.motion.utils.b) r14.get("translationY");
        goto L10
    L5:
        r13 = (com.obric.oui.constraintlayout.core.motion.utils.b) r11.get("translationX");
        goto L6
    }

    public final float s() {
        float[] r10 = new float[2];
        float r11 = 1.0f / 99;
        double r13 = 0.0d;
        double r15 = 0.0d;
        int r12 = 0;
        float r17 = 0.0f;
    L4:
        if (r12 >= 100) goto L27;
        float r14 = r12 * r11;
        double r16 = r14;
        vc.c r18 = this.f13778g.f13800a;
        Iterator r19 = this.f13796y.iterator();
        float r20 = Float.NaN;
        float r110 = 0.0f;
    L7:
        if (r19.hasNext() == false) goto L17;
        n r21 = (n) r19.next();
        vc.c r111 = r21.f13800a;
        if (r111 == null) goto L7;
        float r112 = r21.f13802c;
        if (r112 >= r14) goto L14;
        r18 = r111;
        r110 = r112;
        goto L7
    L14:
        if (Float.isNaN(r20) == false) goto L7;
        r20 = r21.f13802c;
        goto L7
    L17:
        if (r18 != null) goto L19;
    L22:
        this.f13782k[0].d(r16, this.f13790s);
        int r113 = r12;
        this.f13778g.f(r16, this.f13789r, this.f13790s, r10, 0);
        if (r113 <= 0) goto L25;
        char r22 = 0;
        r17 = r17 + ((float) Math.hypot(r15 - ((double) r10[1]), r13 - ((double) r10[0])));
    L26:
        r13 = r10[r22];
        r12 = r113 + 1;
        r15 = r10[1];
        goto L4
    L25:
        r22 = 0;
        goto L26
    L19:
        if (Float.isNaN(r20) == false) goto L21;
        r20 = 1.0f;
    L21:
        float r23 = r20 - r110;
        r16 = (((float) r18.a((r14 - r110) / r23)) * r23) + r110;
        goto L22
    L27:
        return r17;
    }

    public float t() {
        return this.f13778g.f13804e;
    }

    public String toString() {
        return " start: x: " + this.f13778g.f13804e + " y: " + this.f13778g.f13805f + " end: x: " + this.f13779h.f13804e + " y: " + this.f13779h.f13805f;
    }

    public float u() {
        return this.f13778g.f13805f;
    }

    public View v() {
        return this.f13773b;
    }

    public final void w(n r10) {
        int r11 = Collections.binarySearch(this.f13796y, r10);
        if (r11 != 0) goto L5;
        Log.e("MotionController", " KeyPath position \"" + r10.f13803d + "\" outside of range");
    L5:
        this.f13796y.add((-r11) - 1, r10);
    }

    public boolean x(View r21, float r22, long r23, vc.d r25) {
        float r10 = g(r22, null);
        int r11 = this.I;
        if (r11 == c.f13644f) goto L15;
        float r12 = 1.0f / r11;
        float r13 = ((float) Math.floor(r10 / r12)) * r12;
        float r14 = (r10 % r12) / r12;
        if (Float.isNaN(this.f13771J) == true) goto L7;
        r14 = (r14 + this.f13771J) % 1.0f;
    L7:
        Interpolator r15 = this.K;
        if (r15 == null) goto L11;
        float r16 = r15.getInterpolation(r14);
    L14:
        r10 = (r16 * r12) + r13;
        goto L15
    L11:
        if (r14 <= 0.5d) goto L13;
        r16 = 1.0f;
        goto L14
    L13:
        r16 = 0.0f;
    L15:
        float r17 = r10;
        HashMap r18 = this.C;
        if (r18 == null) goto L21;
        Iterator r19 = r18.values().iterator();
    L19:
        if (r19.hasNext() == false) goto L21;
        ((yc.d) r19.next()).h(r21, r17);
    L21:
        HashMap r20 = this.B;
        if (r20 == null) goto L31;
        Iterator r24 = r20.values().iterator();
        yc.f.d r26 = null;
        boolean r27 = false;
    L25:
        if (r24.hasNext() == false) goto L30;
        yc.f r28 = (yc.f) r24.next();
        if ((r28 instanceof yc.f.d) == true) goto L28;
        r27 = r27 | r28.i(r21, r17, r23, r25);
        goto L25
    L28:
        r26 = (yc.f.d) r28;
        goto L25
    L30:
        boolean r110 = r27;
        yc.f.d r29 = r26;
    L32:
        vc.b[] r30 = this.f13782k;
        int r111 = 1;
        if (r30 == null) goto L89;
        double r31 = r17;
        r30[0].d(r31, this.f13790s);
        this.f13782k[0].g(r31, this.f13791t);
        vc.b r32 = this.f13783l;
        if (r32 == null) goto L40;
        double[] r33 = this.f13790s;
        if (r33.length <= 0) goto L40;
        r32.d(r31, r33);
        this.f13783l.g(r31, this.f13791t);
    L40:
        if (this.L == true) goto L44;
        this.f13778g.s(r17, r21, this.f13789r, this.f13790s, this.f13791t, null, this.f13775d);
        this.f13775d = false;
    L44:
        if (this.G != c.f13644f) goto L46;
    L55:
        HashMap r34 = this.C;
        if (r34 == null) goto L65;
        Iterator r35 = r34.values().iterator();
    L59:
        if (r35.hasNext() == false) goto L65;
        com.obric.oui.constraintlayout.core.motion.utils.b r36 = (com.obric.oui.constraintlayout.core.motion.utils.b) r35.next();
        if ((r36 instanceof yc.d.C0418d) == false) goto L59;
        double[] r37 = this.f13791t;
        if (r37.length <= 1) goto L59;
        ((yc.d.C0418d) r36).i(r21, r17, r37[0], r37[1]);
    L65:
        if (r29 == null) goto L68;
        double[] r38 = this.f13791t;
        r110 = r110 | r29.j(r21, r25, r17, r23, r38[0], r38[1]);
    L68:
        int r112 = r111;
    L69:
        vc.b[] r39 = this.f13782k;
        if (r112 >= r39.length) goto L72;
        r39[r112].e(r31, this.f13795x);
        yc.a.b((ConstraintAttribute) this.f13778g.f13814o.get(this.f13792u[r112 - 1]), r21, this.f13795x);
        r112 = r112 + 1;
        goto L69
    L72:
        k r40 = this.f13780i;
        if (r40.f13746b != 0) goto L84;
        if (r17 > 0.0f) goto L78;
        r21.setVisibility(r40.f13747c);
        goto L84
    L78:
        if (r17 < 1.0f) goto L81;
        r21.setVisibility(this.f13781j.f13747c);
        goto L84
    L81:
        if (this.f13781j.f13747c == r40.f13747c) goto L84;
        r21.setVisibility(0);
    L84:
        if (this.E == null) goto L97;
        int r41 = 0;
    L86:
        j[] r42 = this.E;
        if (r41 >= r42.length) goto L97;
        r42[r41].y(r17, r21);
        r41 = r41 + 1;
    L97:
        HashMap r43 = this.D;
        if (r43 == null) goto L106;
        Iterator r44 = r43.values().iterator();
    L101:
        if (r44.hasNext() == false) goto L106;
        yc.c r45 = (yc.c) r44.next();
        if ((r45 instanceof yc.c.d) == true) goto L104;
        r45.j(r21, r17);
        goto L101
    L104:
        double[] r46 = this.f13791t;
        ((yc.c.d) r45).k(r21, r17, r46[0], r46[r111]);
    L106:
        return r110;
    L46:
        if (this.H != null) goto L48;
        this.H = ((View) r21.getParent()).findViewById(this.G);
    L48:
        View r47 = this.H;
        if (r47 == null) goto L55;
        float r48 = (r47.getTop() + this.H.getBottom()) / 2.0f;
        float r49 = (this.H.getLeft() + this.H.getRight()) / 2.0f;
        if ((r21.getRight() - r21.getLeft()) <= 0) goto L55;
        if ((r21.getBottom() - r21.getTop()) <= 0) goto L55;
        float r50 = r49 - r21.getLeft();
        float r51 = r48 - r21.getTop();
        r21.setPivotX(r50);
        r21.setPivotY(r51);
        goto L55
    L89:
        r111 = 1;
        n r52 = this.f13778g;
        float r53 = r52.f13804e;
        n r54 = this.f13779h;
        float r55 = r53 + ((r54.f13804e - r53) * r17);
        float r56 = r52.f13805f;
        float r57 = r56 + ((r54.f13805f - r56) * r17);
        float r58 = r52.f13806g;
        float r59 = r54.f13806g;
        float r60 = r52.f13807h;
        float r61 = r54.f13807h;
        float r62 = r55 + 0.5f;
        int r113 = (int) r62;
        float r63 = r57 + 0.5f;
        int r64 = (int) r63;
        int r65 = (int) (r62 + (((r59 - r58) * r17) + r58));
        int r66 = (int) (r63 + (((r61 - r60) * r17) + r60));
        int r67 = r65 - r113;
        int r68 = r66 - r64;
        if (r59 == r58) goto L92;
    L95:
        r21.measure(View.MeasureSpec.makeMeasureSpec(r67, Ints.MAX_POWER_OF_TWO), View.MeasureSpec.makeMeasureSpec(r68, Ints.MAX_POWER_OF_TWO));
        this.f13775d = false;
    L96:
        r21.layout(r113, r64, r65, r66);
        goto L97
    L92:
        if (r61 != r60) goto L95;
        if (this.f13775d == false) goto L96;
    L31:
        r29 = null;
        r110 = false;
        goto L32
    }

    public final void y(n r10) {
        r10.q((int) this.f13773b.getX(), (int) this.f13773b.getY(), this.f13773b.getWidth(), this.f13773b.getHeight());
    }

    public void z() {
        this.f13775d = true;
    }
}
