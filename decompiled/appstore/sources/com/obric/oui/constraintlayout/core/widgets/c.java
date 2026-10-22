package com.obric.oui.constraintlayout.core.widgets;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes4.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ConstraintWidget f13387a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ConstraintWidget f13388b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ConstraintWidget f13389c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ConstraintWidget f13390d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ConstraintWidget f13391e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ConstraintWidget f13392f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ConstraintWidget f13393g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ArrayList f13394h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f13395i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f13396j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f13397k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f13398l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f13399m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f13400n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f13401o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f13402p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f13403q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f13404r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f13405s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f13406t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f13407u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f13408v;

    public c(ConstraintWidget r10, int r11, boolean r12) {
        this.f13397k = 0.0f;
        this.f13387a = r10;
        this.f13402p = r11;
        this.f13403q = r12;
    }

    public static boolean c(ConstraintWidget r10, int r11) {
        if (r10.U() != 8) goto L5;
    L11:
        return false;
    L5:
        if (r10.f13254b0[r11] != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L11;
        int r12 = r10.f13299y[r11];
        if (r12 != 0) goto L9;
    L10:
        return true;
    L9:
        if (r12 != 3) goto L11;
        goto L10
    }

    public void a() {
        if (this.f13408v == true) goto L5;
        b();
    L5:
        this.f13408v = true;
    }

    public final void b() {
        int r10 = this.f13402p * 2;
        ConstraintWidget r11 = this.f13387a;
        boolean r12 = true;
        this.f13401o = true;
        ConstraintWidget r13 = r11;
        boolean r14 = false;
    L3:
        if (r14 == true) goto L74;
        this.f13395i++;
        ConstraintWidget[] r15 = r11.P0;
        int r16 = this.f13402p;
        ConstraintWidget r17 = null;
        r15[r16] = null;
        r11.O0[r16] = null;
        if (r11.U() == 8) goto L60;
        this.f13398l++;
        ConstraintWidget.DimensionBehaviour r18 = r11.t(this.f13402p);
        ConstraintWidget.DimensionBehaviour r19 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r18 == r19) goto L9;
        this.f13399m += r11.D(this.f13402p);
    L9:
        int r20 = this.f13399m + r11.Y[r10].f();
        this.f13399m = r20;
        int r110 = r10 + 1;
        this.f13399m = r20 + r11.Y[r110].f();
        int r21 = this.f13400n + r11.Y[r10].f();
        this.f13400n = r21;
        this.f13400n = r21 + r11.Y[r110].f();
        if (this.f13388b != null) goto L12;
        this.f13388b = r11;
    L12:
        this.f13390d = r11;
        ConstraintWidget.DimensionBehaviour[] r22 = r11.f13254b0;
        int r111 = this.f13402p;
        if (r22[r111] != r19) goto L60;
        int r23 = r11.f13299y[r111];
        if (r23 != 0) goto L17;
    L19:
        this.f13396j++;
        float r24 = r11.N0[r111];
        if (r24 <= 0.0f) goto L23;
        this.f13397k += r24;
    L23:
        if (c(r11, r111) == false) goto L33;
        if (r24 >= 0.0f) goto L27;
        this.f13404r = true;
    L29:
        if (this.f13394h != null) goto L31;
        this.f13394h = new ArrayList();
    L31:
        this.f13394h.add(r11);
        goto L33
    L27:
        this.f13405s = true;
    L33:
        if (this.f13392f != null) goto L35;
        this.f13392f = r11;
    L35:
        ConstraintWidget r25 = this.f13393g;
        if (r25 == null) goto L38;
        r25.O0[this.f13402p] = r11;
    L38:
        this.f13393g = r11;
    L40:
        if (this.f13402p != 0) goto L50;
        if (r11.f13295w == 0) goto L45;
        this.f13401o = false;
    L58:
        if (r11.f13262f0 == 0.0f) goto L60;
        this.f13401o = false;
        this.f13407u = true;
        goto L60
    L45:
        if (r11.f13301z == 0) goto L47;
    L48:
        this.f13401o = false;
        goto L58
    L47:
        if (r11.A == 0) goto L58;
    L50:
        if (r11.f13297x == 0) goto L53;
        this.f13401o = false;
        goto L58
    L53:
        if (r11.C == 0) goto L55;
    L56:
        this.f13401o = false;
        goto L58
    L55:
        if (r11.D == 0) goto L58;
    L17:
        if (r23 == 3) goto L19;
        if (r23 != 2) goto L40;
    L60:
        if (r13 == r11) goto L62;
        r13.P0[this.f13402p] = r11;
    L62:
        ConstraintAnchor r26 = r11.Y[r10 + 1].f13245f;
        if (r26 == null) goto L70;
        ConstraintWidget r27 = r26.f13243d;
        ConstraintAnchor r28 = r27.Y[r10].f13245f;
        if (r28 == null) goto L70;
        if (r28.f13243d != r11) goto L70;
        r17 = r27;
    L70:
        if (r17 != null) goto L73;
        r17 = r11;
        r14 = true;
    L73:
        r13 = r11;
        r11 = r17;
        goto L3
    L74:
        ConstraintWidget r29 = this.f13388b;
        if (r29 == null) goto L77;
        this.f13399m -= r29.Y[r10].f();
    L77:
        ConstraintWidget r30 = this.f13390d;
        if (r30 == null) goto L80;
        this.f13399m -= r30.Y[r10 + 1].f();
    L80:
        this.f13389c = r11;
        if (this.f13402p == 0) goto L83;
    L85:
        this.f13391e = this.f13387a;
    L87:
        if (this.f13405s == true) goto L89;
    L91:
        r12 = false;
    L92:
        this.f13406t = r12;
        return;
    L89:
        if (this.f13404r == false) goto L91;
    L83:
        if (this.f13403q == false) goto L85;
        this.f13391e = r11;
        goto L87
    }
}
