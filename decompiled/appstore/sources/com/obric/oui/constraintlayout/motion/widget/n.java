package com.obric.oui.constraintlayout.motion.widget;

import android.view.View;
import com.google.common.primitives.Ints;
import com.obric.oui.constraintlayout.widget.ConstraintAttribute;
import com.tmall.wireless.tangram.dataparser.concrete.Style;
import com.tmall.wireless.tangram.structure.card.FixCard;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes4.dex */
public class n implements Comparable {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static String[] f13799t;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public vc.c f13800a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f13801b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f13802c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f13803d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f13804e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f13805f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f13806g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f13807h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f13808i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f13809j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f13810k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f13811l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f13812m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public l f13813n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public LinkedHashMap f13814o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f13815p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f13816q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public double[] f13817r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public double[] f13818s;

    static {
        f13799t = new String[]{"position", FixCard.FixStyle.KEY_X, FixCard.FixStyle.KEY_Y, Style.KEY_WIDTH, Style.KEY_HEIGHT, "pathRotate"};
    }

    public n() {
        this.f13801b = 0;
        this.f13808i = Float.NaN;
        this.f13809j = Float.NaN;
        int r10 = c.f13644f;
        this.f13810k = r10;
        this.f13811l = r10;
        this.f13812m = Float.NaN;
        this.f13813n = null;
        this.f13814o = new LinkedHashMap();
        this.f13815p = 0;
        this.f13817r = new double[18];
        this.f13818s = new double[18];
    }

    public void a(com.obric.oui.constraintlayout.widget.a.C0195a r10) {
        this.f13800a = vc.c.c(r10.f14175d.f14241d);
        com.obric.oui.constraintlayout.widget.a.c r11 = r10.f14175d;
        this.f13810k = r11.f14242e;
        this.f13811l = r11.f14239b;
        this.f13808i = r11.f14246i;
        this.f13801b = r11.f14243f;
        this.f13816q = r11.f14240c;
        this.f13809j = r10.f14174c.f14256e;
        this.f13812m = r10.f14176e.D;
        Iterator r12 = r10.f14178g.keySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L10;
        String r13 = (String) r12.next();
        ConstraintAttribute r14 = (ConstraintAttribute) r10.f14178g.get(r13);
        if (r14 == null) goto L4;
        if (r14.g() == false) goto L4;
        this.f13814o.put(r13, r14);
        goto L4
    }

    public int b(n r10) {
        return Float.compare(this.f13803d, r10.f13803d);
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
        boolean r14 = c(this.f13804e, r10.f13804e);
        boolean r15 = c(this.f13805f, r10.f13805f);
        r11[0] = r11[0] | c(this.f13803d, r10.f13803d);
        boolean r16 = (r14 | r15) | r13;
        r11[1] = r11[1] | r16;
        r11[2] = r16 | r11[2];
        r11[3] = r11[3] | c(this.f13806g, r10.f13806g);
        boolean r17 = r11[4];
        r11[4] = c(this.f13807h, r10.f13807h) | r17;
    }

    public void e(double[] r10, int[] r11) {
        int r12 = 0;
        float[] r13 = {this.f13803d, this.f13804e, this.f13805f, this.f13806g, this.f13807h, this.f13808i};
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
        float r10 = this.f13804e;
        float r11 = this.f13805f;
        float r12 = this.f13806g;
        float r13 = this.f13807h;
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
        l r22 = this.f13813n;
        if (r22 == null) goto L21;
        float[] r23 = new float[2];
        r22.i(r16, r23, new float[2]);
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
        float r10 = this.f13804e;
        float r11 = this.f13805f;
        float r12 = this.f13806g;
        float r13 = this.f13807h;
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
        l r21 = this.f13813n;
        if (r21 == null) goto L22;
        float[] r27 = new float[2];
        float[] r28 = new float[2];
        r21.i(r20, r27, r28);
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
        ConstraintAttribute r13 = (ConstraintAttribute) this.f13814o.get(r10);
        int r14 = 0;
        if (r13 != null) goto L6;
        return 0;
    L6:
        if (r13.h() != 1) goto L9;
        r11[r12] = r13.e();
        return 1;
    L9:
        int r15 = r13.h();
        float[] r16 = new float[r15];
        r13.f(r16);
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
        ConstraintAttribute r11 = (ConstraintAttribute) this.f13814o.get(r10);
        if (r11 != null) goto L7;
        return 0;
    L7:
        return r11.h();
    }

    public void j(int[] r10, double[] r11, float[] r12, int r13) {
        float r14 = this.f13804e;
        float r15 = this.f13805f;
        float r16 = this.f13806g;
        float r17 = this.f13807h;
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
        l r110 = this.f13813n;
        if (r110 == null) goto L22;
        float r111 = r110.j();
        float r21 = this.f13813n.k();
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
        return this.f13814o.containsKey(r10);
    }

    public void l(g r19, n r20, n r21) {
        float r10 = r19.f13645a / 100.0f;
        this.f13802c = r10;
        this.f13801b = r19.f13693j;
        if (Float.isNaN(r19.f13694k) == false) goto L5;
        float r11 = r10;
    L7:
        if (Float.isNaN(r19.f13695l) == false) goto L9;
        float r12 = r10;
    L10:
        float r13 = r21.f13806g;
        float r14 = r20.f13806g;
        float r15 = r13 - r14;
        float r16 = r21.f13807h;
        float r17 = r20.f13807h;
        float r18 = r16 - r17;
        this.f13803d = this.f13802c;
        float r110 = r20.f13804e;
        float r111 = (r14 / 2.0f) + r110;
        float r22 = r20.f13805f;
        float r112 = r22 + (r17 / 2.0f);
        float r23 = r21.f13804e + (r13 / 2.0f);
        float r24 = r21.f13805f + (r16 / 2.0f);
        if (r111 <= r23) goto L14;
        r111 = r23;
        r23 = r111;
    L14:
        if (r112 > r24) goto L17;
        r112 = r24;
        r24 = r112;
    L17:
        float r25 = r23 - r111;
        float r113 = r112 - r24;
        float r26 = r15 * r11;
        float r27 = r26 / 2.0f;
        this.f13804e = (int) ((r110 + (r25 * r10)) - r27);
        float r114 = r18 * r12;
        float r28 = r114 / 2.0f;
        this.f13805f = (int) ((r22 + (r113 * r10)) - r28);
        this.f13806g = (int) (r14 + r26);
        this.f13807h = (int) (r17 + r114);
        if (Float.isNaN(r19.f13696m) == false) goto L20;
        float r29 = r10;
    L21:
        float r30 = 0.0f;
        if (Float.isNaN(r19.f13699p) == false) goto L24;
        float r31 = 0.0f;
    L26:
        if (Float.isNaN(r19.f13697n) == true) goto L30;
        r10 = r19.f13697n;
    L30:
        if (Float.isNaN(r19.f13698o) == true) goto L33;
        r30 = r19.f13698o;
    L33:
        this.f13815p = 0;
        this.f13804e = (int) (((r20.f13804e + (r29 * r25)) + (r30 * r113)) - r27);
        this.f13805f = (int) (((r20.f13805f + (r25 * r31)) + (r113 * r10)) - r28);
        this.f13800a = vc.c.c(r19.f13691h);
        this.f13810k = r19.f13692i;
        return;
    L24:
        r31 = r19.f13699p;
        goto L26
    L20:
        r29 = r19.f13696m;
        goto L21
    L9:
        r12 = r19.f13695l;
        goto L10
    L5:
        r11 = r19.f13694k;
        goto L7
    }

    public void m(g r18, n r19, n r20) {
        float r10 = r18.f13645a / 100.0f;
        this.f13802c = r10;
        this.f13801b = r18.f13693j;
        if (Float.isNaN(r18.f13694k) == false) goto L5;
        float r11 = r10;
    L7:
        if (Float.isNaN(r18.f13695l) == false) goto L9;
        float r12 = r10;
    L10:
        float r13 = r20.f13806g;
        float r14 = r19.f13806g;
        float r15 = r20.f13807h;
        float r16 = r19.f13807h;
        this.f13803d = this.f13802c;
        float r17 = r19.f13804e;
        float r21 = r19.f13805f;
        float r22 = r20.f13804e + (r13 / 2.0f);
        float r23 = r22 - ((r14 / 2.0f) + r17);
        float r24 = (r20.f13805f + (r15 / 2.0f)) - (r21 + (r16 / 2.0f));
        float r25 = (r13 - r14) * r11;
        float r26 = r25 / 2.0f;
        this.f13804e = (int) ((r17 + (r23 * r10)) - r26);
        float r110 = (r15 - r16) * r12;
        float r27 = r110 / 2.0f;
        this.f13805f = (int) ((r21 + (r24 * r10)) - r27);
        this.f13806g = (int) (r14 + r25);
        this.f13807h = (int) (r16 + r110);
        if (Float.isNaN(r18.f13696m) == false) goto L13;
        float r28 = r10;
    L14:
        float r29 = 0.0f;
        if (Float.isNaN(r18.f13699p) == false) goto L17;
        float r30 = 0.0f;
    L19:
        if (Float.isNaN(r18.f13697n) == true) goto L23;
        r10 = r18.f13697n;
    L23:
        if (Float.isNaN(r18.f13698o) == true) goto L26;
        r29 = r18.f13698o;
    L26:
        this.f13815p = 0;
        this.f13804e = (int) (((r19.f13804e + (r28 * r23)) + (r29 * r24)) - r26);
        this.f13805f = (int) (((r19.f13805f + (r23 * r30)) + (r24 * r10)) - r27);
        this.f13800a = vc.c.c(r18.f13691h);
        this.f13810k = r18.f13692i;
        return;
    L17:
        r30 = r18.f13699p;
        goto L19
    L13:
        r28 = r18.f13696m;
        goto L14
    L9:
        r12 = r18.f13695l;
        goto L10
    L5:
        r11 = r18.f13694k;
        goto L7
    }

    public void n(g r17, n r18, n r19) {
        float r10 = r17.f13645a / 100.0f;
        this.f13802c = r10;
        this.f13801b = r17.f13693j;
        if (Float.isNaN(r17.f13694k) == false) goto L5;
        float r11 = r10;
    L7:
        if (Float.isNaN(r17.f13695l) == false) goto L9;
        float r12 = r10;
    L10:
        float r13 = r19.f13806g - r18.f13806g;
        float r14 = r19.f13807h - r18.f13807h;
        this.f13803d = this.f13802c;
        if (Float.isNaN(r17.f13696m) == true) goto L14;
        r10 = r17.f13696m;
    L14:
        float r15 = r18.f13804e;
        float r16 = r18.f13806g;
        float r110 = r18.f13805f;
        float r111 = r18.f13807h;
        float r20 = r19.f13804e + (r19.f13806g / 2.0f);
        float r21 = r20 - ((r16 / 2.0f) + r15);
        float r22 = (r19.f13805f + (r19.f13807h / 2.0f)) - ((r111 / 2.0f) + r110);
        float r23 = r21 * r10;
        float r24 = r13 * r11;
        float r25 = r24 / 2.0f;
        this.f13804e = (int) ((r15 + r23) - r25);
        float r26 = r10 * r22;
        float r27 = r14 * r12;
        float r28 = r27 / 2.0f;
        this.f13805f = (int) ((r110 + r26) - r28);
        this.f13806g = (int) (r16 + r24);
        this.f13807h = (int) (r111 + r27);
        if (Float.isNaN(r17.f13697n) == false) goto L17;
        float r29 = 0.0f;
    L18:
        this.f13815p = 1;
        float r30 = (int) ((r18.f13804e + r23) - r25);
        float r31 = (int) ((r18.f13805f + r26) - r28);
        this.f13804e = r30 + ((-r22) * r29);
        this.f13805f = r31 + (r21 * r29);
        this.f13811l = this.f13811l;
        this.f13800a = vc.c.c(r17.f13691h);
        this.f13810k = r17.f13692i;
        return;
    L17:
        r29 = r17.f13697n;
        goto L18
    L9:
        r12 = r17.f13695l;
        goto L10
    L5:
        r11 = r17.f13694k;
        goto L7
    }

    public void o(int r10, int r11, g r12, n r13, n r14) {
        float r15 = r12.f13645a / 100.0f;
        this.f13802c = r15;
        this.f13801b = r12.f13693j;
        this.f13815p = r12.f13700q;
        if (Float.isNaN(r12.f13694k) == false) goto L5;
        float r16 = r15;
    L7:
        if (Float.isNaN(r12.f13695l) == false) goto L9;
        float r17 = r15;
    L10:
        float r18 = r14.f13806g;
        float r19 = r13.f13806g;
        float r20 = r14.f13807h;
        float r21 = r13.f13807h;
        this.f13803d = this.f13802c;
        this.f13806g = (int) (r19 + ((r18 - r19) * r16));
        this.f13807h = (int) (r21 + ((r20 - r21) * r17));
        if (r12.f13700q == 2) goto L22;
        if (Float.isNaN(r12.f13696m) == false) goto L15;
        float r22 = r15;
    L16:
        float r23 = r14.f13804e;
        float r24 = r13.f13804e;
        this.f13804e = (r22 * (r23 - r24)) + r24;
        if (Float.isNaN(r12.f13697n) == true) goto L20;
        r15 = r12.f13697n;
    L20:
        float r25 = r14.f13805f;
        float r110 = r13.f13805f;
        this.f13805f = (r15 * (r25 - r110)) + r110;
    L30:
        this.f13811l = r13.f13811l;
        this.f13800a = vc.c.c(r12.f13691h);
        this.f13810k = r12.f13692i;
        return;
    L15:
        r22 = r12.f13696m;
        goto L16
    L22:
        if (Float.isNaN(r12.f13696m) == false) goto L24;
        float r26 = r14.f13804e;
        float r27 = r13.f13804e;
        float r28 = ((r26 - r27) * r15) + r27;
    L25:
        this.f13804e = r28;
        if (Float.isNaN(r12.f13697n) == false) goto L28;
        float r29 = r14.f13805f;
        float r111 = r13.f13805f;
        float r30 = (r15 * (r29 - r111)) + r111;
    L29:
        this.f13805f = r30;
        goto L30
    L28:
        r30 = r12.f13697n;
        goto L29
    L24:
        r28 = Math.min(r17, r16) * r12.f13696m;
        goto L25
    L9:
        r17 = r12.f13695l;
        goto L10
    L5:
        r16 = r12.f13694k;
        goto L7
    }

    public void p(int r18, int r19, g r20, n r21, n r22) {
        float r10 = r20.f13645a / 100.0f;
        this.f13802c = r10;
        this.f13801b = r20.f13693j;
        if (Float.isNaN(r20.f13694k) == false) goto L5;
        float r11 = r10;
    L7:
        if (Float.isNaN(r20.f13695l) == false) goto L9;
        float r12 = r10;
    L10:
        float r13 = r22.f13806g;
        float r14 = r21.f13806g;
        float r15 = r22.f13807h;
        float r16 = r21.f13807h;
        this.f13803d = this.f13802c;
        float r17 = r21.f13804e;
        float r23 = r21.f13805f;
        float r24 = r22.f13804e + (r13 / 2.0f);
        float r25 = r22.f13805f + (r15 / 2.0f);
        float r26 = (r13 - r14) * r11;
        this.f13804e = (int) ((r17 + ((r24 - ((r14 / 2.0f) + r17)) * r10)) - (r26 / 2.0f));
        float r110 = (r15 - r16) * r12;
        this.f13805f = (int) ((r23 + ((r25 - (r23 + (r16 / 2.0f))) * r10)) - (r110 / 2.0f));
        this.f13806g = (int) (r14 + r26);
        this.f13807h = (int) (r16 + r110);
        this.f13815p = 2;
        if (Float.isNaN(r20.f13696m) == true) goto L14;
        this.f13804e = (int) (r20.f13696m * (r18 - ((int) this.f13806g)));
    L14:
        if (Float.isNaN(r20.f13697n) == true) goto L16;
        this.f13805f = (int) (r20.f13697n * (r19 - ((int) this.f13807h)));
    L16:
        this.f13811l = this.f13811l;
        this.f13800a = vc.c.c(r20.f13691h);
        this.f13810k = r20.f13692i;
        return;
    L9:
        r12 = r20.f13695l;
        goto L10
    L5:
        r11 = r20.f13694k;
        goto L7
    }

    public void q(float r10, float r11, float r12, float r13) {
        this.f13804e = r10;
        this.f13805f = r11;
        this.f13806g = r12;
        this.f13807h = r13;
    }

    public void r(float r13, float r14, float[] r15, int[] r16, double[] r17, double[] r18) {
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
    public void s(float r21, View r22, int[] r23, double[] r24, double[] r25, double[] r26, boolean r27) {
        float r10 = this.f13804e;
        float r11 = this.f13805f;
        float r12 = this.f13806g;
        float r13 = this.f13807h;
        if (r23.length != 0) goto L5;
    L7:
        Arrays.fill(this.f13817r, Double.NaN);
        int r14 = 0;
    L9:
        if (r14 >= r23.length) goto L11;
        double[] r15 = this.f13817r;
        int r16 = r23[r14];
        r15[r16] = r24[r14];
        this.f13818s[r16] = r25[r14];
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
        double[] r20 = this.f13817r;
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
        if (Double.isNaN(this.f13817r[r18]) == false) goto L25;
    L24:
        r28 = r17;
        float r29 = (float) r113;
        float r30 = (float) this.f13818s[r18];
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
        r113 = this.f13817r[r18] + r113;
        goto L24
    L43:
        float r210 = r17;
        l r31 = this.f13813n;
        if (r31 == null) goto L52;
        float[] r32 = new float[2];
        float[] r114 = new float[2];
        r31.i(r21, r32, r114);
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
        r22.setRotation((r210 + ((float) Math.toDegrees(Math.atan2(r110 + (r112 / 2.0f), r19 + (r111 / 2.0f))))) + 0.0f);
        goto L56
    L5:
        if (this.f13817r.length > r23[r23.length - 1]) goto L7;
        int r49 = r23[r23.length - 1] + 1;
        this.f13817r = new double[r49];
        this.f13818s = new double[r49];
        goto L7
    }

    public void t(l r10, n r11) {
        double r12 = ((this.f13804e + (this.f13806g / 2.0f)) - r11.f13804e) - (r11.f13806g / 2.0f);
        double r13 = ((this.f13805f + (this.f13807h / 2.0f)) - r11.f13805f) - (r11.f13807h / 2.0f);
        this.f13813n = r10;
        this.f13804e = (float) Math.hypot(r13, r12);
        if (Float.isNaN(this.f13812m) == false) goto L5;
        this.f13805f = (float) (Math.atan2(r13, r12) + 1.5707963267948966d);
        return;
    L5:
        this.f13805f = (float) Math.toRadians(this.f13812m);
    }

    public n(int r10, int r11, g r12, n r13, n r14) {
        this.f13801b = 0;
        this.f13808i = Float.NaN;
        this.f13809j = Float.NaN;
        int r15 = c.f13644f;
        this.f13810k = r15;
        this.f13811l = r15;
        this.f13812m = Float.NaN;
        this.f13813n = null;
        this.f13814o = new LinkedHashMap();
        this.f13815p = 0;
        this.f13817r = new double[18];
        this.f13818s = new double[18];
        if (r13.f13811l == c.f13644f) goto L6;
        o(r10, r11, r12, r13, r14);
        return;
    L6:
        int r16 = r12.f13700q;
        if (r16 != 1) goto L9;
        n(r12, r13, r14);
        return;
    L9:
        if (r16 != 2) goto L11;
        p(r10, r11, r12, r13, r14);
        return;
    L11:
        if (r16 == 3) goto L14;
        m(r12, r13, r14);
        return;
    L14:
        l(r12, r13, r14);
    }
}
