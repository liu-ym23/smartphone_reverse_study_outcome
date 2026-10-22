package com.obric.oui.constraintlayout.motion.widget;

import android.view.View;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: MotionPaths.java */
/* JADX INFO: loaded from: classes4.dex */
class o implements Comparable<o> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static String[] f34884a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    com.obric.oui.constraintlayout.a.a.a.c f34885b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f34886c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    float f34887d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    float f34888e;
    float f;
    float g;
    float h;
    float i;
    float j;
    float k;
    int l;
    int m;
    float n;
    m o;
    LinkedHashMap<String, com.obric.oui.constraintlayout.widget.a> p;
    int q;
    int r;
    double[] s;
    double[] t;

    private static float a(float r0, float r1, float r2, float r3, float r4, float r5) {
        return (((r4 - r2) * r1) - ((r5 - r3) * r0)) + r2;
    }

    private static float b(float r0, float r1, float r2, float r3, float r4, float r5) {
        return (((r4 - r2) * r0) + ((r5 - r3) * r1)) + r3;
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(o r3) {
        return a((o) ZeusTransformUtils.preCheckCast(r3, o.class, "com.obric.aiagent.plugin"));
    }

    static {
        f34884a = new String[]{"position", "x", "y", "width", "height", "pathRotate"};
    }

    o() {
        this.f34886c = 0;
        this.j = Float.NaN;
        this.k = Float.NaN;
        this.l = d.f34861a;
        this.m = d.f34861a;
        this.n = Float.NaN;
        this.o = null;
        this.p = new LinkedHashMap();
        this.q = 0;
        this.s = new double[18];
        this.t = new double[18];
    }

    void a(h r18, o r19, o r20) {
        float r4 = r18.f34862b / 100.0f;
        this.f34887d = r4;
        this.f34886c = r18.i;
        if (Float.isNaN(r18.j) == false) goto L5;
        float r5 = r4;
    L7:
        if (Float.isNaN(r18.k) == false) goto L9;
        float r6 = r4;
    L10:
        float r7 = r20.h;
        float r8 = r19.h;
        float r10 = r20.i;
        float r11 = r19.i;
        this.f34888e = this.f34887d;
        float r13 = r19.f;
        float r1 = r19.g;
        float r2 = r20.f + (r7 / 2.0f);
        float r3 = r2 - ((r8 / 2.0f) + r13);
        float r9 = (r20.g + (r10 / 2.0f)) - (r1 + (r11 / 2.0f));
        float r12 = (r7 - r8) * r5;
        float r14 = r12 / 2.0f;
        this.f = (int) ((r13 + (r3 * r4)) - r14);
        float r15 = (r10 - r11) * r6;
        float r16 = r15 / 2.0f;
        this.g = (int) ((r1 + (r9 * r4)) - r16);
        this.h = (int) (r8 + r12);
        this.i = (int) (r11 + r15);
        if (Float.isNaN(r18.l) == false) goto L13;
        float r17 = r4;
    L14:
        float r21 = 0.0f;
        if (Float.isNaN(r18.o) == false) goto L17;
        float r22 = 0.0f;
    L19:
        if (Float.isNaN(r18.m) == true) goto L23;
        r4 = r18.m;
    L23:
        if (Float.isNaN(r18.n) == true) goto L26;
        r21 = r18.n;
    L26:
        this.q = 0;
        this.f = (int) (((r19.f + (r17 * r3)) + (r21 * r9)) - r14);
        this.g = (int) (((r19.g + (r3 * r22)) + (r9 * r4)) - r16);
        this.f34885b = com.obric.oui.constraintlayout.a.a.a.c.a(r18.g);
        this.l = r18.h;
        return;
    L17:
        r22 = r18.o;
        goto L19
    L13:
        r17 = r18.l;
        goto L14
    L9:
        r6 = r18.k;
        goto L10
    L5:
        r5 = r18.j;
        goto L7
    }

    void b(h r19, o r20, o r21) {
        float r4 = r19.f34862b / 100.0f;
        this.f34887d = r4;
        this.f34886c = r19.i;
        if (Float.isNaN(r19.j) == false) goto L5;
        float r5 = r4;
    L7:
        if (Float.isNaN(r19.k) == false) goto L9;
        float r6 = r4;
    L10:
        float r7 = r21.h;
        float r8 = r20.h;
        float r9 = r7 - r8;
        float r10 = r21.i;
        float r11 = r20.i;
        float r12 = r10 - r11;
        this.f34888e = this.f34887d;
        float r13 = r20.f;
        float r15 = (r8 / 2.0f) + r13;
        float r1 = r20.g;
        float r16 = r1 + (r11 / 2.0f);
        float r2 = r21.f + (r7 / 2.0f);
        float r3 = r21.g + (r10 / 2.0f);
        if (r15 <= r2) goto L14;
        r15 = r2;
        r2 = r15;
    L14:
        if (r16 > r3) goto L17;
        r16 = r3;
        r3 = r16;
    L17:
        float r14 = r2 - r15;
        float r17 = r16 - r3;
        float r18 = r9 * r5;
        float r22 = r18 / 2.0f;
        this.f = (int) ((r13 + (r14 * r4)) - r22);
        float r110 = r12 * r6;
        float r23 = r110 / 2.0f;
        this.g = (int) ((r1 + (r17 * r4)) - r23);
        this.h = (int) (r8 + r18);
        this.i = (int) (r11 + r110);
        if (Float.isNaN(r19.l) == false) goto L20;
        float r24 = r4;
    L21:
        float r25 = 0.0f;
        if (Float.isNaN(r19.o) == false) goto L24;
        float r26 = 0.0f;
    L26:
        if (Float.isNaN(r19.m) == true) goto L30;
        r4 = r19.m;
    L30:
        if (Float.isNaN(r19.n) == true) goto L33;
        r25 = r19.n;
    L33:
        this.q = 0;
        this.f = (int) (((r20.f + (r24 * r14)) + (r25 * r17)) - r22);
        this.g = (int) (((r20.g + (r14 * r26)) + (r17 * r4)) - r23);
        this.f34885b = com.obric.oui.constraintlayout.a.a.a.c.a(r19.g);
        this.l = r19.h;
        return;
    L24:
        r26 = r19.o;
        goto L26
    L20:
        r24 = r19.l;
        goto L21
    L9:
        r6 = r19.k;
        goto L10
    L5:
        r5 = r19.j;
        goto L7
    }

    o(int r4, int r5, h r6, o r7, o r8) {
        this.f34886c = 0;
        this.j = Float.NaN;
        this.k = Float.NaN;
        this.l = d.f34861a;
        this.m = d.f34861a;
        this.n = Float.NaN;
        this.o = null;
        this.p = new LinkedHashMap();
        this.q = 0;
        this.s = new double[18];
        this.t = new double[18];
        if (r7.m == d.f34861a) goto L6;
        a(r4, r5, r6, r7, r8);
        return;
    L6:
        int r0 = r6.p;
        if (r0 != 1) goto L9;
        c(r6, r7, r8);
        return;
    L9:
        if (r0 != 2) goto L11;
        b(r4, r5, r6, r7, r8);
        return;
    L11:
        if (r0 == 3) goto L14;
        a(r6, r7, r8);
        return;
    L14:
        b(r6, r7, r8);
    }

    void a(int r7, int r8, h r9, o r10, o r11) {
        float r12 = r9.f34862b / 100.0f;
        this.f34887d = r12;
        this.f34886c = r9.i;
        this.q = r9.p;
        if (Float.isNaN(r9.j) == false) goto L5;
        float r13 = r12;
    L7:
        if (Float.isNaN(r9.k) == false) goto L9;
        float r0 = r12;
    L10:
        float r1 = r11.h;
        float r2 = r10.h;
        float r3 = r11.i;
        float r4 = r10.i;
        this.f34888e = this.f34887d;
        this.h = (int) (r2 + ((r1 - r2) * r13));
        this.i = (int) (r4 + ((r3 - r4) * r0));
        if (r9.p == 2) goto L22;
        if (Float.isNaN(r9.l) == false) goto L15;
        float r14 = r12;
    L16:
        float r5 = r11.f;
        float r6 = r10.f;
        this.f = (r14 * (r5 - r6)) + r6;
        if (Float.isNaN(r9.m) == true) goto L20;
        r12 = r9.m;
    L20:
        float r15 = r11.g;
        float r16 = r10.g;
        this.g = (r12 * (r15 - r16)) + r16;
    L30:
        this.m = r10.m;
        this.f34885b = com.obric.oui.constraintlayout.a.a.a.c.a(r9.g);
        this.l = r9.h;
        return;
    L15:
        r14 = r9.l;
        goto L16
    L22:
        if (Float.isNaN(r9.l) == false) goto L24;
        float r17 = r11.f;
        float r18 = r10.f;
        float r19 = ((r17 - r18) * r12) + r18;
    L25:
        this.f = r19;
        if (Float.isNaN(r9.m) == false) goto L28;
        float r20 = r11.g;
        float r110 = r10.g;
        float r21 = (r12 * (r20 - r110)) + r110;
    L29:
        this.g = r21;
        goto L30
    L28:
        r21 = r9.m;
        goto L29
    L24:
        r19 = Math.min(r0, r13) * r9.l;
        goto L25
    L9:
        r0 = r9.k;
        goto L10
    L5:
        r13 = r9.j;
        goto L7
    }

    public void a(m r6, o r7) {
        double r0 = ((this.f + (this.h / 2.0f)) - r7.f) - (r7.h / 2.0f);
        double r2 = ((this.g + (this.i / 2.0f)) - r7.g) - (r7.i / 2.0f);
        this.o = r6;
        this.f = (float) Math.hypot(r2, r0);
        if (Float.isNaN(this.n) == false) goto L5;
        this.g = (float) (Math.atan2(r2, r0) + 1.5707963267948966d);
        return;
    L5:
        this.g = (float) Math.toRadians(this.n);
    }

    void b(int r18, int r19, h r20, o r21, o r22) {
        float r4 = r20.f34862b / 100.0f;
        this.f34887d = r4;
        this.f34886c = r20.i;
        if (Float.isNaN(r20.j) == false) goto L5;
        float r5 = r4;
    L7:
        if (Float.isNaN(r20.k) == false) goto L9;
        float r6 = r4;
    L10:
        float r7 = r22.h;
        float r8 = r21.h;
        float r10 = r22.i;
        float r11 = r21.i;
        this.f34888e = this.f34887d;
        float r13 = r21.f;
        float r2 = r21.g;
        float r1 = r22.f + (r7 / 2.0f);
        float r3 = r22.g + (r10 / 2.0f);
        float r9 = (r7 - r8) * r5;
        this.f = (int) ((r13 + ((r1 - ((r8 / 2.0f) + r13)) * r4)) - (r9 / 2.0f));
        float r12 = (r10 - r11) * r6;
        this.g = (int) ((r2 + ((r3 - (r2 + (r11 / 2.0f))) * r4)) - (r12 / 2.0f));
        this.h = (int) (r8 + r9);
        this.i = (int) (r11 + r12);
        this.q = 2;
        if (Float.isNaN(r20.l) == true) goto L14;
        this.f = (int) (r20.l * (r18 - ((int) this.h)));
    L14:
        if (Float.isNaN(r20.m) == true) goto L16;
        this.g = (int) (r20.m * (r19 - ((int) this.i)));
    L16:
        this.m = this.m;
        this.f34885b = com.obric.oui.constraintlayout.a.a.a.c.a(r20.g);
        this.l = r20.h;
        return;
    L9:
        r6 = r20.k;
        goto L10
    L5:
        r5 = r20.j;
        goto L7
    }

    void c(h r17, o r18, o r19) {
        float r4 = r17.f34862b / 100.0f;
        this.f34887d = r4;
        this.f34886c = r17.i;
        if (Float.isNaN(r17.j) == false) goto L5;
        float r5 = r4;
    L7:
        if (Float.isNaN(r17.k) == false) goto L9;
        float r6 = r4;
    L10:
        float r7 = r19.h - r18.h;
        float r8 = r19.i - r18.i;
        this.f34888e = this.f34887d;
        if (Float.isNaN(r17.l) == true) goto L14;
        r4 = r17.l;
    L14:
        float r9 = r18.f;
        float r10 = r18.h;
        float r13 = r18.g;
        float r14 = r18.i;
        float r2 = r19.f + (r19.h / 2.0f);
        float r3 = r2 - ((r10 / 2.0f) + r9);
        float r1 = (r19.g + (r19.i / 2.0f)) - ((r14 / 2.0f) + r13);
        float r11 = r3 * r4;
        float r12 = r7 * r5;
        float r15 = r12 / 2.0f;
        this.f = (int) ((r9 + r11) - r15);
        float r16 = r4 * r1;
        float r20 = r8 * r6;
        float r21 = r20 / 2.0f;
        this.g = (int) ((r13 + r16) - r21);
        this.h = (int) (r10 + r12);
        this.i = (int) (r14 + r20);
        if (Float.isNaN(r17.m) == false) goto L17;
        float r22 = 0.0f;
    L18:
        this.q = 1;
        float r23 = (int) ((r18.f + r11) - r15);
        this.f = r23;
        float r24 = (int) ((r18.g + r16) - r21);
        this.g = r24;
        this.f = r23 + ((-r1) * r22);
        this.g = r24 + (r3 * r22);
        this.m = this.m;
        this.f34885b = com.obric.oui.constraintlayout.a.a.a.c.a(r17.g);
        this.l = r17.h;
        return;
    L17:
        r22 = r17.m;
        goto L18
    L9:
        r6 = r17.k;
        goto L10
    L5:
        r5 = r17.j;
        goto L7
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

    void a(o r6, boolean[] r7, String[] r8, boolean r9) {
        boolean r10 = a(this.f, r6.f);
        boolean r0 = a(this.g, r6.g);
        r7[0] = r7[0] | a(this.f34888e, r6.f34888e);
        boolean r11 = (r10 | r0) | r9;
        r7[1] = r7[1] | r11;
        r7[2] = r11 | r7[2];
        r7[3] = r7[3] | a(this.h, r6.h);
        boolean r12 = r7[4];
        r7[4] = a(this.i, r6.i) | r12;
    }

    void a(double r16, int[] r18, double[] r19, float[] r20, int r21) {
        float r2 = this.f;
        float r3 = this.g;
        float r4 = this.h;
        float r5 = this.i;
        int r7 = 0;
    L4:
        if (r7 >= r18.length) goto L18;
        float r8 = (float) r19[r7];
        int r11 = r18[r7];
        if (r11 == 1) goto L16;
        if (r11 != 2) goto L9;
        r3 = r8;
    L17:
        r7 = r7 + 1;
        goto L4
    L9:
        if (r11 != 3) goto L11;
        r4 = r8;
        goto L17
    L11:
        if (r11 != 4) goto L17;
        r5 = r8;
        goto L17
    L16:
        r2 = r8;
        goto L17
    L18:
        m r0 = this.o;
        if (r0 == null) goto L21;
        float[] r9 = new float[2];
        r0.a(r16, r9, new float[2]);
        float r1 = r9[0];
        float r6 = r9[1];
        double r12 = r2;
        double r10 = r3;
        float r13 = (float) ((((double) r1) + (Math.sin(r10) * r12)) - ((double) (r4 / 2.0f)));
        r3 = (float) ((((double) r6) - (r12 * Math.cos(r10))) - ((double) (r5 / 2.0f)));
        r2 = r13;
    L21:
        r20[r21] = (r2 + (r4 / 2.0f)) + 0.0f;
        r20[r21 + 1] = (r3 + (r5 / 2.0f)) + 0.0f;
    }

    void a(double r19, int[] r21, double[] r22, float[] r23, double[] r24, float[] r25) {
        float r2 = this.f;
        float r3 = this.g;
        float r4 = this.h;
        float r5 = this.i;
        int r8 = 0;
        float r9 = 0.0f;
        float r10 = 0.0f;
        float r11 = 0.0f;
        float r12 = 0.0f;
    L4:
        if (r8 >= r21.length) goto L19;
        float r6 = (float) r22[r8];
        float r13 = (float) r24[r8];
        int r14 = r21[r8];
        if (r14 != 1) goto L8;
        r2 = r6;
        r9 = r13;
    L18:
        r8 = r8 + 1;
        goto L4
    L8:
        if (r14 != 2) goto L10;
        r3 = r6;
        r11 = r13;
        goto L18
    L10:
        if (r14 != 3) goto L12;
        r4 = r6;
        r10 = r13;
        goto L18
    L12:
        if (r14 != 4) goto L18;
        r5 = r6;
        r12 = r13;
        goto L18
    L19:
        float r15 = (r10 / 2.0f) + r9;
        float r16 = (r12 / 2.0f) + r11;
        m r0 = this.o;
        if (r0 == null) goto L22;
        float[] r7 = new float[2];
        float[] r17 = new float[2];
        r0.a(r19, r7, r17);
        float r18 = r7[0];
        float r20 = r7[1];
        float r110 = r17[0];
        float r1 = r17[1];
        double r26 = r2;
        float r27 = r11;
        double r111 = r3;
        float r28 = (float) ((((double) r18) + (Math.sin(r111) * r26)) - ((double) (r4 / 2.0f)));
        float r29 = (float) ((((double) r20) - (r26 * Math.cos(r111))) - ((double) (r5 / 2.0f)));
        double r30 = r9;
        double r31 = r27;
        float r32 = (float) ((((double) r110) + (Math.sin(r111) * r30)) + (Math.cos(r111) * r31));
        r16 = (float) ((((double) r1) - (r30 * Math.cos(r111))) + (Math.sin(r111) * r31));
        r2 = r28;
        r3 = r29;
        r15 = r32;
        float r33 = 2.0f;
    L23:
        r23[0] = (r2 + (r4 / r33)) + 0.0f;
        r23[1] = (r3 + (r5 / r33)) + 0.0f;
        r25[0] = r15;
        r25[1] = r16;
        return;
    L22:
        r33 = 2.0f;
        goto L23
    }

    void a(float r21, View r22, int[] r23, double[] r24, double[] r25, double[] r26, boolean r27) {
        float r4 = this.f;
        float r5 = this.g;
        float r6 = this.h;
        float r7 = this.i;
        if (r23.length != 0) goto L5;
    L7:
        Arrays.fill(this.s, Double.NaN);
        int r10 = 0;
    L9:
        if (r10 >= r23.length) goto L11;
        this.s[r23[r10]] = r24[r10];
        this.t[r23[r10]] = r25[r10];
        r10 = r10 + 1;
        goto L9
    L11:
        float r11 = Float.NaN;
        int r12 = 0;
        float r13 = 0.0f;
        float r14 = 0.0f;
        float r15 = 0.0f;
        float r16 = 0.0f;
    L12:
        double[] r2 = this.s;
        if (r12 >= r2.length) goto L43;
        double r17 = 0.0d;
        if (Double.isNaN(r2[r12]) == false) goto L20;
        if (r26 != null) goto L18;
    L19:
        float r28 = r11;
    L36:
        r11 = r28;
    L42:
        r12 = r12 + 1;
        goto L12
    L18:
        if (r26[r12] == 0.0d) goto L19;
    L20:
        if (r26 == null) goto L23;
        r17 = r26[r12];
    L23:
        if (Double.isNaN(this.s[r12]) == true) goto L26;
        r17 = this.s[r12] + r17;
    L26:
        r28 = r11;
        float r8 = (float) r17;
        float r9 = (float) this.t[r12];
        if (r12 != 1) goto L29;
        r11 = r28;
        r4 = r8;
        r13 = r9;
        goto L42
    L29:
        if (r12 != 2) goto L31;
        r11 = r28;
        r5 = r8;
        r14 = r9;
        goto L42
    L31:
        if (r12 != 3) goto L33;
        r11 = r28;
        r6 = r8;
        r15 = r9;
        goto L42
    L33:
        if (r12 != 4) goto L35;
        r11 = r28;
        r7 = r8;
        r16 = r9;
        goto L42
    L35:
        if (r12 != 5) goto L36;
        r11 = r8;
        goto L42
    L43:
        float r29 = r11;
        m r0 = this.o;
        if (r0 == null) goto L53;
        float[] r18 = new float[2];
        float[] r19 = new float[2];
        r0.a(r21, r18, r19);
        float r110 = r18[0];
        float r20 = r18[1];
        float r111 = r19[0];
        float r1 = r19[1];
        double r3 = r4;
        double r30 = r5;
        float r31 = (float) ((((double) r110) + (Math.sin(r30) * r3)) - ((double) (r6 / 2.0f)));
        float r112 = r7;
        float r32 = (float) ((((double) r20) - (Math.cos(r30) * r3)) - ((double) (r7 / 2.0f)));
        double r113 = r13;
        double r114 = r14;
        float r33 = (float) ((((double) r111) + (Math.sin(r30) * r113)) + ((Math.cos(r30) * r3) * r114));
        float r34 = (float) ((((double) r1) - (r113 * Math.cos(r30))) + ((r3 * Math.sin(r30)) * r114));
        if (r25.length < 2) goto L48;
        boolean r35 = false;
        r25[0] = r33;
        boolean r115 = true;
        r25[1] = r34;
    L50:
        if (Float.isNaN(r29) == true) goto L52;
        r22.setRotation((float) (((double) r29) + Math.toDegrees(Math.atan2(r34, r33))));
    L52:
        r4 = r31;
        r5 = r32;
    L57:
        if (ZeusTransformUtils.instanceOf(r22, c.class) == false) goto L60;
        ((c) ZeusTransformUtils.preCheckCast(r22, c.class, "com.obric.aiagent.plugin")).layout(r4, r5, r6 + r4, r5 + r112);
        return;
    L60:
        float r36 = r4 + 0.5f;
        int r37 = (int) r36;
        float r38 = r5 + 0.5f;
        int r39 = (int) r38;
        int r40 = (int) (r36 + r6);
        int r41 = (int) (r38 + r112);
        int r42 = r40 - r37;
        int r43 = r41 - r39;
        if (r42 == r22.getMeasuredWidth()) goto L63;
    L64:
        r35 = r115;
    L65:
        if (r35 == true) goto L67;
        if (r27 == true) goto L67;
    L68:
        r22.layout(r37, r39, r40, r41);
        return;
    L67:
        r22.measure(View.MeasureSpec.makeMeasureSpec(r42, 1073741824), View.MeasureSpec.makeMeasureSpec(r43, 1073741824));
        goto L68
    L63:
        if (r43 == r22.getMeasuredHeight()) goto L65;
    L48:
        r35 = false;
        r115 = true;
        goto L50
    L53:
        r112 = r7;
        r35 = false;
        r115 = true;
        if (Float.isNaN(r29) == true) goto L57;
        r22.setRotation((((float) Math.toDegrees(Math.atan2(r14 + (r16 / 2.0f), r13 + (r15 / 2.0f)))) + r29) + 0.0f);
        goto L57
    L5:
        if (this.s.length > r23[r23.length - 1]) goto L7;
        int r44 = r23[r23.length - 1] + 1;
        this.s = new double[r44];
        this.t = new double[r44];
        goto L7
    }

    void a(int[] r10, double[] r11, float[] r12, int r13) {
        float r0 = this.f;
        float r1 = this.g;
        float r2 = this.h;
        float r3 = this.i;
        int r4 = 0;
    L4:
        if (r4 >= r10.length) goto L19;
        float r5 = (float) r11[r4];
        int r6 = r10[r4];
        if (r6 != 1) goto L8;
        r0 = r5;
    L18:
        r4 = r4 + 1;
        goto L4
    L8:
        if (r6 != 2) goto L10;
        r1 = r5;
        goto L18
    L10:
        if (r6 != 3) goto L12;
        r2 = r5;
        goto L18
    L12:
        if (r6 != 4) goto L18;
        r3 = r5;
        goto L18
    L19:
        m r14 = this.o;
        if (r14 == null) goto L22;
        float r15 = r14.f();
        float r9 = this.o.g();
        double r7 = r0;
        double r8 = r1;
        float r16 = (float) ((((double) r15) + (Math.sin(r8) * r7)) - ((double) (r2 / 2.0f)));
        r1 = (float) ((((double) r9) - (r7 * Math.cos(r8))) - ((double) (r3 / 2.0f)));
        r0 = r16;
    L22:
        float r17 = r2 + r0;
        float r18 = r3 + r1;
        Float.isNaN(Float.NaN);
        Float.isNaN(Float.NaN);
        int r19 = r13 + 1;
        r12[r13] = r0 + 0.0f;
        int r110 = r19 + 1;
        r12[r19] = r1 + 0.0f;
        int r20 = r110 + 1;
        r12[r110] = r17 + 0.0f;
        int r111 = r20 + 1;
        r12[r20] = r1 + 0.0f;
        int r21 = r111 + 1;
        r12[r111] = r17 + 0.0f;
        int r112 = r21 + 1;
        r12[r21] = r18 + 0.0f;
        r12[r112] = r0 + 0.0f;
        r12[r112 + 1] = r18 + 0.0f;
    }

    void a(float r13, float r14, float[] r15, int[] r16, double[] r17, double[] r18) {
        int r3 = 0;
        float r4 = 0.0f;
        float r5 = 0.0f;
        float r6 = 0.0f;
        float r7 = 0.0f;
    L4:
        if (r3 >= r16.length) goto L19;
        float r8 = (float) r17[r3];
        double r10 = r18[r3];
        int r11 = r16[r3];
        if (r11 != 1) goto L8;
        r4 = r8;
    L18:
        r3 = r3 + 1;
        goto L4
    L8:
        if (r11 != 2) goto L10;
        r6 = r8;
        goto L18
    L10:
        if (r11 != 3) goto L12;
        r5 = r8;
        goto L18
    L12:
        if (r11 != 4) goto L18;
        r7 = r8;
        goto L18
    L19:
        float r9 = r4 - ((0.0f * r5) / 2.0f);
        float r12 = r6 - ((0.0f * r7) / 2.0f);
        r15[0] = ((r9 * (1.0f - r13)) + (((r5 * 1.0f) + r9) * r13)) + 0.0f;
        r15[1] = ((r12 * (1.0f - r14)) + (((r7 * 1.0f) + r12) * r14)) + 0.0f;
    }

    void a(double[] r7, int[] r8) {
        int r3 = 0;
        float[] r1 = {this.f34888e, this.f, this.g, this.h, this.i, this.j};
        int r6 = 0;
    L4:
        if (r3 >= r8.length) goto L9;
        if (r8[r3] >= 6) goto L8;
        r7[r6] = r1[r8[r3]];
        r6 = r6 + 1;
    L8:
        r3 = r3 + 1;
        goto L4
    }

    boolean a(String r1) {
        return this.p.containsKey(r1);
    }

    int b(String r2) {
        com.obric.oui.constraintlayout.widget.a r1 = (com.obric.oui.constraintlayout.widget.a) ZeusTransformUtils.preCheckCast(this.p.get(r2), com.obric.oui.constraintlayout.widget.a.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L7;
        return 0;
    L7:
        return r1.c();
    }

    int a(String r5, double[] r6, int r7) {
        com.obric.oui.constraintlayout.widget.a r4 = (com.obric.oui.constraintlayout.widget.a) ZeusTransformUtils.preCheckCast(this.p.get(r5), com.obric.oui.constraintlayout.widget.a.class, "com.obric.aiagent.plugin");
        int r8 = 0;
        if (r4 != null) goto L6;
        return 0;
    L6:
        if (r4.c() != 1) goto L9;
        r6[r7] = r4.d();
        return 1;
    L9:
        int r0 = r4.c();
        float[] r1 = new float[r0];
        r4.a(r1);
    L10:
        if (r8 >= r0) goto L12;
        r6[r7] = r1[r8];
        r8 = r8 + 1;
        r7 = r7 + 1;
        goto L10
    L12:
        return r0;
    }

    void a(float r1, float r2, float r3, float r4) {
        this.f = r1;
        this.g = r2;
        this.h = r3;
        this.i = r4;
    }

    public int a(o r1) {
        return Float.compare(this.f34888e, r1.f34888e);
    }

    public void a(com.obric.oui.constraintlayout.widget.c.a r6) {
        this.f34885b = com.obric.oui.constraintlayout.a.a.a.c.a(r6.f34960d.f34976d);
        this.l = r6.f34960d.f34977e;
        this.m = r6.f34960d.f34974b;
        this.j = r6.f34960d.i;
        this.f34886c = r6.f34960d.f;
        this.r = r6.f34960d.f34975c;
        this.k = r6.f34959c.f34982e;
        this.n = r6.f34961e.D;
        Iterator<String> r0 = r6.g.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.aiagent.plugin");
        com.obric.oui.constraintlayout.widget.a r2 = (com.obric.oui.constraintlayout.widget.a) ZeusTransformUtils.preCheckCast(r6.g.get(r1), com.obric.oui.constraintlayout.widget.a.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L4;
        if (r2.b() == false) goto L4;
        this.p.put(r1, r2);
        goto L4
    }
}
