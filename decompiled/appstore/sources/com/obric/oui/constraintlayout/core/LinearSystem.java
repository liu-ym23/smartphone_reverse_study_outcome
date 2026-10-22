package com.obric.oui.constraintlayout.core;

import com.obric.oui.constraintlayout.core.widgets.ConstraintAnchor;
import com.obric.oui.constraintlayout.core.widgets.ConstraintWidget;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: loaded from: classes4.dex */
public class LinearSystem {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static boolean f13101s = false;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static boolean f13102t = true;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static boolean f13103u = true;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static boolean f13104v = true;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static boolean f13105w = false;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static long f13106x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static long f13107y;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f13108a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f13109b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f13110c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public HashMap f13111d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Row f13112e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f13113f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f13114g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ArrayRow[] f13115h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f13116i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f13117j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean[] f13118k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f13119l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f13120m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f13121n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final b f13122o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public SolverVariable[] f13123p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f13124q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Row f13125r;

    public interface Row {
        void addError(SolverVariable r10);

        void clear();

        SolverVariable getKey();

        SolverVariable getPivotCandidate(LinearSystem r10, boolean[] r11);

        void initFromRow(Row r10);

        boolean isEmpty();

        void updateFromFinalVariable(LinearSystem r10, SolverVariable r11, boolean r12);

        void updateFromRow(LinearSystem r10, ArrayRow r11, boolean r12);

        void updateFromSystem(LinearSystem r10);
    }

    public static class a extends ArrayRow {
        public a(b r10) {
            this.f13099e = new f(this, r10);
        }
    }

    static {
    }

    public LinearSystem() {
        this.f13108a = 1000;
        this.f13109b = false;
        this.f13110c = 0;
        this.f13111d = null;
        this.f13113f = 32;
        this.f13114g = 32;
        this.f13116i = false;
        this.f13117j = false;
        this.f13118k = new boolean[32];
        this.f13119l = 1;
        this.f13120m = 0;
        this.f13121n = 32;
        this.f13123p = new SolverVariable[1000];
        this.f13124q = 0;
        this.f13115h = new ArrayRow[32];
        D();
        b r10 = new b();
        this.f13122o = r10;
        this.f13112e = new e(r10);
        if (f13105w == false) goto L5;
        this.f13125r = new a(r10);
        return;
    L5:
        this.f13125r = new ArrayRow(r10);
    }

    public static ArrayRow s(LinearSystem r10, SolverVariable r11, SolverVariable r12, float r13) {
        return r10.r().g(r11, r12, r13);
    }

    public static c x() {
        return null;
    }

    public void A() {
        if (this.f13112e.isEmpty() == false) goto L7;
        n();
        return;
    L7:
        if (this.f13116i == false) goto L9;
    L12:
        int r10 = 0;
    L14:
        if (r10 >= this.f13120m) goto L19;
        if (this.f13115h[r10].f13100f == false) goto L17;
        r10 = r10 + 1;
        goto L14
    L17:
        B(this.f13112e);
        return;
    L19:
        n();
        return;
    L9:
        if (this.f13117j == true) goto L12;
        B(this.f13112e);
    }

    public void B(Row r10) {
        u(r10);
        C(r10, false);
        n();
    }

    public final int C(Row r11, boolean r12) {
        int r10 = 0;
    L4:
        if (r10 >= this.f13119l) goto L6;
        this.f13118k[r10] = false;
        r10 = r10 + 1;
        goto L4
    L6:
        boolean r13 = false;
        int r14 = 0;
    L7:
        if (r13 == true) goto L41;
        r14 = r14 + 1;
        if (r14 >= (this.f13119l * 2)) goto L10;
        if (r11.getKey() == null) goto L14;
        this.f13118k[r11.getKey().f13129c] = true;
    L14:
        SolverVariable r15 = r11.getPivotCandidate(this, this.f13118k);
        if (r15 == null) goto L20;
        boolean[] r16 = this.f13118k;
        int r17 = r15.f13129c;
        if (r16[r17] == true) goto L18;
        r16[r17] = true;
        goto L20
    L18:
        return r14;
    L20:
        if (r15 != null) goto L21;
        r13 = true;
        goto L7
    L21:
        float r18 = Float.MAX_VALUE;
        int r19 = 0;
        int r20 = -1;
    L23:
        if (r19 >= this.f13120m) goto L38;
        ArrayRow r21 = this.f13115h[r19];
        if (r21.f13095a.f13136j == SolverVariable.Type.UNRESTRICTED) goto L37;
        if (r21.f13100f == true) goto L37;
        if (r21.q(r15) == false) goto L37;
        float r22 = r21.f13099e.get(r15);
        if (r22 >= 0.0f) goto L37;
        float r23 = (-r21.f13096b) / r22;
        if (r23 >= r18) goto L37;
        r20 = r19;
        r18 = r23;
    L37:
        r19 = r19 + 1;
        goto L23
    L38:
        if (r20 <= (-1)) goto L7;
        ArrayRow r24 = this.f13115h[r20];
        r24.f13095a.f13130d = -1;
        r24.u(r15);
        SolverVariable r25 = r24.f13095a;
        r25.f13130d = r20;
        r25.h(this, r24);
        goto L7
    L10:
        return r14;
    L41:
        return r14;
    }

    public final void D() {
        int r10 = 0;
        if (f13105w == false) goto L11;
    L5:
        if (r10 >= this.f13120m) goto L16;
        ArrayRow r11 = this.f13115h[r10];
        if (r11 == null) goto L9;
        this.f13122o.f13156a.release(r11);
    L9:
        this.f13115h[r10] = null;
        r10 = r10 + 1;
        goto L5
    L16:
        return;
    L11:
        if (r10 >= this.f13120m) goto L23;
        ArrayRow r12 = this.f13115h[r10];
        if (r12 == null) goto L15;
        this.f13122o.f13157b.release(r12);
    L15:
        this.f13115h[r10] = null;
        r10 = r10 + 1;
        goto L11
    }

    public void E() {
        int r10 = 0;
    L3:
        b r11 = this.f13122o;
        SolverVariable[] r12 = r11.f13159d;
        if (r10 >= r12.length) goto L9;
        SolverVariable r13 = r12[r10];
        if (r13 == null) goto L8;
        r13.e();
    L8:
        r10 = r10 + 1;
        goto L3
    L9:
        r11.f13158c.releaseAll(this.f13123p, this.f13124q);
        this.f13124q = 0;
        Arrays.fill(this.f13122o.f13159d, null);
        HashMap r14 = this.f13111d;
        if (r14 == null) goto L12;
        r14.clear();
    L12:
        this.f13110c = 0;
        this.f13112e.clear();
        this.f13119l = 1;
        int r15 = 0;
    L14:
        if (r15 >= this.f13120m) goto L19;
        ArrayRow r16 = this.f13115h[r15];
        if (r16 == null) goto L18;
        r16.f13097c = false;
    L18:
        r15 = r15 + 1;
        goto L14
    L19:
        D();
        this.f13120m = 0;
        if (f13105w == false) goto L22;
        this.f13125r = new a(this.f13122o);
        return;
    L22:
        this.f13125r = new ArrayRow(this.f13122o);
    }

    public final SolverVariable a(SolverVariable.Type r10, String r11) {
        SolverVariable r12 = (SolverVariable) this.f13122o.f13158c.acquire();
        if (r12 != null) goto L5;
        r12 = new SolverVariable(r10, r11);
        r12.g(r10, r11);
    L6:
        int r13 = this.f13124q;
        int r14 = this.f13108a;
        if (r13 < r14) goto L9;
        int r15 = r14 * 2;
        this.f13108a = r15;
        this.f13123p = (SolverVariable[]) Arrays.copyOf(this.f13123p, r15);
    L9:
        SolverVariable[] r16 = this.f13123p;
        int r17 = this.f13124q;
        this.f13124q = r17 + 1;
        r16[r17] = r12;
        return r12;
    L5:
        r12.e();
        r12.g(r10, r11);
        goto L6
    }

    public void b(ConstraintWidget r17, ConstraintWidget r18, float r19, int r20) {
        ConstraintAnchor.Type r10 = ConstraintAnchor.Type.LEFT;
        SolverVariable r11 = q(r17.n(r10));
        ConstraintAnchor.Type r12 = ConstraintAnchor.Type.TOP;
        SolverVariable r13 = q(r17.n(r12));
        ConstraintAnchor.Type r14 = ConstraintAnchor.Type.RIGHT;
        SolverVariable r15 = q(r17.n(r14));
        ConstraintAnchor.Type r16 = ConstraintAnchor.Type.BOTTOM;
        SolverVariable r21 = q(r17.n(r16));
        SolverVariable r22 = q(r18.n(r10));
        SolverVariable r110 = q(r18.n(r12));
        SolverVariable r23 = q(r18.n(r14));
        SolverVariable r111 = q(r18.n(r16));
        ArrayRow r24 = r();
        double r25 = r19;
        double r26 = r20;
        r24.n(r13, r21, r110, r111, (float) (Math.sin(r25) * r26));
        d(r24);
        ArrayRow r27 = r();
        r27.n(r11, r15, r22, r23, (float) (Math.cos(r25) * r26));
        d(r27);
    }

    public void c(SolverVariable r12, SolverVariable r13, int r14, float r15, SolverVariable r16, SolverVariable r17, int r18, int r19) {
        ArrayRow r10 = r();
        r10.e(r12, r13, r14, r15, r16, r17, r18);
        if (r19 == 8) goto L5;
        r10.a(this, r19);
    L5:
        d(r10);
    }

    public void d(ArrayRow r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        boolean r11 = true;
        if ((this.f13120m + 1) < this.f13121n) goto L7;
    L8:
        z();
    L9:
        boolean r12 = false;
        if (r10.f13100f == true) goto L38;
        r10.updateFromSystem(this);
        if (r10.isEmpty() == false) goto L14;
        return;
    L14:
        r10.o();
        if (r10.c(this) == false) goto L33;
        SolverVariable r13 = p();
        r10.f13095a = r13;
        int r14 = this.f13120m;
        l(r10);
        if (this.f13120m != (r14 + 1)) goto L33;
        this.f13125r.initFromRow(r10);
        C(this.f13125r, true);
        if (r13.f13130d != (-1)) goto L35;
        if (r10.f13095a != r13) goto L26;
        SolverVariable r15 = r10.s(r13);
        if (r15 == null) goto L26;
        r10.u(r15);
    L26:
        if (r10.f13100f == true) goto L29;
        r10.f13095a.h(this, r10);
    L29:
        if (f13105w == false) goto L31;
        this.f13122o.f13156a.release(r10);
    L32:
        this.f13120m--;
        goto L35
    L31:
        this.f13122o.f13157b.release(r10);
    L35:
        if (r10.p() == true) goto L37;
        return;
    L37:
        r12 = r11;
    L33:
        r11 = false;
    L38:
        if (r12 == true) goto L41;
        l(r10);
        return;
    L41:
        return;
    L7:
        if ((this.f13119l + 1) < this.f13114g) goto L9;
        goto L8
    }

    public ArrayRow e(SolverVariable r10, SolverVariable r11, int r12, int r13) {
        if (f13102t == false) goto L11;
        if (r13 != 8) goto L11;
        if (r11.f13133g == false) goto L11;
        if (r10.f13130d != (-1)) goto L11;
        r10.f(this, r11.f13132f + r12);
        return null;
    L11:
        ArrayRow r14 = r();
        r14.k(r10, r11, r12);
        if (r13 == 8) goto L14;
        r14.a(this, r13);
    L14:
        d(r14);
        return r14;
    }

    public void f(SolverVariable r10, int r11) {
        if (f13102t == true) goto L5;
    L18:
        int r12 = r10.f13130d;
        if (r12 == (-1)) goto L27;
        ArrayRow r13 = this.f13115h[r12];
        if (r13.f13100f == false) goto L24;
        r13.f13096b = r11;
        return;
    L24:
        if (r13.f13099e.getCurrentSize() != 0) goto L26;
        r13.f13100f = true;
        r13.f13096b = r11;
        return;
    L26:
        ArrayRow r14 = r();
        r14.j(r10, r11);
        d(r14);
        return;
    L27:
        ArrayRow r15 = r();
        r15.f(r10, r11);
        d(r15);
        return;
    L5:
        if (r10.f13130d != (-1)) goto L18;
        float r16 = r11;
        r10.f(this, r16);
        int r17 = 0;
    L8:
        if (r17 >= (this.f13110c + 1)) goto L17;
        SolverVariable r18 = this.f13122o.f13159d[r17];
        if (r18 == null) goto L16;
        if (r18.f13140n == false) goto L16;
        if (r18.f13141o != r10.f13129c) goto L16;
        r18.f(this, r18.f13142p + r16);
    L16:
        r17 = r17 + 1;
        goto L8
    }

    public void g(SolverVariable r10, SolverVariable r11, int r12, boolean r13) {
        ArrayRow r14 = r();
        SolverVariable r15 = t();
        r15.f13131e = 0;
        r14.l(r10, r11, r15, r12);
        d(r14);
    }

    public void h(SolverVariable r10, SolverVariable r11, int r12, int r13) {
        ArrayRow r14 = r();
        SolverVariable r15 = t();
        r15.f13131e = 0;
        r14.l(r10, r11, r15, r12);
        if (r13 == 8) goto L5;
        m(r14, (int) (r14.f13099e.get(r15) * (-1.0f)), r13);
    L5:
        d(r14);
    }

    public void i(SolverVariable r10, SolverVariable r11, int r12, boolean r13) {
        ArrayRow r14 = r();
        SolverVariable r15 = t();
        r15.f13131e = 0;
        r14.m(r10, r11, r15, r12);
        d(r14);
    }

    public void j(SolverVariable r10, SolverVariable r11, int r12, int r13) {
        ArrayRow r14 = r();
        SolverVariable r15 = t();
        r15.f13131e = 0;
        r14.m(r10, r11, r15, r12);
        if (r13 == 8) goto L5;
        m(r14, (int) (r14.f13099e.get(r15) * (-1.0f)), r13);
    L5:
        d(r14);
    }

    public void k(SolverVariable r10, SolverVariable r11, SolverVariable r12, SolverVariable r13, float r14, int r15) {
        ArrayRow r16 = r();
        r16.h(r10, r11, r12, r13, r14);
        if (r15 == 8) goto L5;
        r16.a(this, r15);
    L5:
        d(r16);
    }

    public final void l(ArrayRow r10) {
        if (f13103u == true) goto L5;
    L7:
        ArrayRow[] r11 = this.f13115h;
        int r12 = this.f13120m;
        r11[r12] = r10;
        SolverVariable r13 = r10.f13095a;
        r13.f13130d = r12;
        this.f13120m = r12 + 1;
        r13.h(this, r10);
    L9:
        if (f13103u == true) goto L11;
        return;
    L11:
        if (this.f13109b == false) goto L47;
        int r14 = 0;
    L14:
        if (r14 >= this.f13120m) goto L37;
        if (this.f13115h[r14] != null) goto L18;
        System.out.println("WTF");
    L18:
        ArrayRow r15 = this.f13115h[r14];
        if (r15 == null) goto L36;
        if (r15.f13100f == false) goto L36;
        r15.f13095a.f(this, r15.f13096b);
        if (f13105w == false) goto L25;
        this.f13122o.f13156a.release(r15);
    L26:
        this.f13115h[r14] = null;
        int r16 = r14 + 1;
        int r17 = r16;
    L27:
        int r18 = this.f13120m;
        if (r16 >= r18) goto L33;
        ArrayRow[] r19 = this.f13115h;
        int r20 = r16 - 1;
        ArrayRow r21 = r19[r16];
        r19[r20] = r21;
        SolverVariable r22 = r21.f13095a;
        if (r22.f13130d != r16) goto L32;
        r22.f13130d = r20;
    L32:
        r17 = r16;
        r16 = r16 + 1;
        goto L27
    L33:
        if (r17 >= r18) goto L35;
        this.f13115h[r17] = null;
    L35:
        this.f13120m = r18 - 1;
        r14 = r14 - 1;
        goto L36
    L25:
        this.f13122o.f13157b.release(r15);
    L36:
        r14 = r14 + 1;
        goto L14
    L37:
        this.f13109b = false;
        return;
    L47:
        return;
    L5:
        if (r10.f13100f == false) goto L7;
        r10.f13095a.f(this, r10.f13096b);
        goto L9
    }

    public void m(ArrayRow r10, int r11, int r12) {
        r10.b(o(r12, null), r11);
    }

    public final void n() {
        int r10 = 0;
    L4:
        if (r10 >= this.f13120m) goto L6;
        ArrayRow r11 = this.f13115h[r10];
        SolverVariable r12 = r11.f13095a;
        r12.f13132f = r11.f13096b;
        r10 = r10 + 1;
        goto L4
    }

    public SolverVariable o(int r10, String r11) {
        if ((this.f13119l + 1) < this.f13114g) goto L5;
        z();
    L5:
        SolverVariable r12 = a(SolverVariable.Type.ERROR, r11);
        int r13 = this.f13110c + 1;
        this.f13110c = r13;
        this.f13119l++;
        r12.f13129c = r13;
        r12.f13131e = r10;
        this.f13122o.f13159d[r13] = r12;
        this.f13112e.addError(r12);
        return r12;
    }

    public SolverVariable p() {
        if ((this.f13119l + 1) < this.f13114g) goto L5;
        z();
    L5:
        SolverVariable r10 = a(SolverVariable.Type.SLACK, null);
        int r11 = this.f13110c + 1;
        this.f13110c = r11;
        this.f13119l++;
        r10.f13129c = r11;
        this.f13122o.f13159d[r11] = r10;
        return r10;
    }

    public SolverVariable q(Object r10) {
        SolverVariable r11 = null;
        if (r10 != null) goto L6;
        return null;
    L6:
        if ((this.f13119l + 1) < this.f13114g) goto L9;
        z();
    L9:
        if ((r10 instanceof ConstraintAnchor) == false) goto L22;
        ConstraintAnchor r12 = (ConstraintAnchor) r10;
        r11 = r12.i();
        if (r11 != null) goto L13;
        r12.s(this.f13122o);
        r11 = r12.i();
    L13:
        int r13 = r11.f13129c;
        if (r13 != (-1)) goto L16;
    L19:
        if (r13 == (-1)) goto L21;
        r11.e();
    L21:
        int r14 = this.f13110c + 1;
        this.f13110c = r14;
        this.f13119l++;
        r11.f13129c = r14;
        r11.f13136j = SolverVariable.Type.UNRESTRICTED;
        this.f13122o.f13159d[r14] = r11;
        goto L22
    L16:
        if (r13 > this.f13110c) goto L19;
        if (this.f13122o.f13159d[r13] == null) goto L19;
    L22:
        return r11;
    }

    public ArrayRow r() {
        if (f13105w == false) goto L8;
        ArrayRow r10 = (ArrayRow) this.f13122o.f13156a.acquire();
        if (r10 != null) goto L7;
        r10 = new a(this.f13122o);
        f13107y++;
    L12:
        SolverVariable.c();
        return r10;
    L7:
        r10.v();
        goto L12
    L8:
        r10 = (ArrayRow) this.f13122o.f13157b.acquire();
        if (r10 != null) goto L11;
        r10 = new ArrayRow(this.f13122o);
        f13106x++;
        goto L12
    L11:
        r10.v();
        goto L12
    }

    public SolverVariable t() {
        if ((this.f13119l + 1) < this.f13114g) goto L5;
        z();
    L5:
        SolverVariable r10 = a(SolverVariable.Type.SLACK, null);
        int r11 = this.f13110c + 1;
        this.f13110c = r11;
        this.f13119l++;
        r10.f13129c = r11;
        this.f13122o.f13159d[r11] = r10;
        return r10;
    }

    public final int u(Row r20) {
        int r10 = 0;
    L4:
        if (r10 >= this.f13120m) goto L63;
        ArrayRow r11 = this.f13115h[r10];
        if (r11.f13095a.f13136j == SolverVariable.Type.UNRESTRICTED) goto L62;
        if (r11.f13096b >= 0.0f) goto L62;
        boolean r12 = false;
        int r13 = 0;
    L11:
        if (r12 == true) goto L88;
        r13 = r13 + 1;
        float r14 = Float.MAX_VALUE;
        int r15 = 0;
        int r16 = -1;
        int r17 = -1;
        int r18 = 0;
    L13:
        int r19 = 1;
        if (r15 >= this.f13120m) goto L55;
        ArrayRow r110 = this.f13115h[r15];
        if (r110.f13095a.f13136j == SolverVariable.Type.UNRESTRICTED) goto L53;
        if (r110.f13100f == true) goto L53;
        if (r110.f13096b >= 0.0f) goto L53;
        int r111 = 9;
        if (f13104v == false) goto L40;
        int r112 = r110.f13099e.getCurrentSize();
        int r113 = 0;
    L26:
        if (r113 >= r112) goto L53;
        SolverVariable r114 = r110.f13099e.getVariable(r113);
        float r21 = r110.f13099e.get(r114);
        if (r21 <= 0.0f) goto L38;
        int r22 = 0;
    L31:
        if (r22 >= r111) goto L38;
        float r115 = r114.f13134h[r22] / r21;
        if (r115 >= r14) goto L35;
        if (r22 != r18) goto L35;
    L36:
        r18 = r22;
        r17 = r114.f13129c;
        r16 = r15;
        r14 = r115;
    L37:
        r22 = r22 + 1;
        r111 = 9;
    L35:
        if (r22 <= r18) goto L37;
    L38:
        r113 = r113 + 1;
        r111 = 9;
    L40:
        if (r19 >= this.f13119l) goto L53;
        SolverVariable r23 = this.f13122o.f13159d[r19];
        float r24 = r110.f13099e.get(r23);
        if (r24 <= 0.0f) goto L52;
        int r116 = 0;
    L45:
        if (r116 >= 9) goto L52;
        float r117 = r23.f13134h[r116] / r24;
        if (r117 >= r14) goto L49;
        if (r116 != r18) goto L49;
    L50:
        r16 = r15;
        r17 = r19;
        r18 = r116;
        r14 = r117;
    L51:
        r116 = r116 + 1;
    L49:
        if (r116 <= r18) goto L51;
    L52:
        r19 = r19 + 1;
    L53:
        r15 = r15 + 1;
        goto L13
    L55:
        if (r16 == (-1)) goto L57;
        ArrayRow r25 = this.f13115h[r16];
        r25.f13095a.f13130d = -1;
        r25.u(this.f13122o.f13159d[r17]);
        SolverVariable r26 = r25.f13095a;
        r26.f13130d = r16;
        r26.h(this, r25);
    L59:
        if (r13 <= (this.f13119l / 2)) goto L11;
        r12 = true;
        goto L11
    L57:
        r12 = true;
        goto L59
    L88:
        return r13;
    L62:
        r10 = r10 + 1;
        goto L4
    L63:
        return 0;
    }

    public void v(c r10) {
    }

    public b w() {
        return this.f13122o;
    }

    public int y(Object r10) {
        SolverVariable r11 = ((ConstraintAnchor) r10).i();
        if (r11 != null) goto L5;
        return 0;
    L5:
        return (int) (r11.f13132f + 0.5f);
    }

    public final void z() {
        int r10 = this.f13113f * 2;
        this.f13113f = r10;
        this.f13115h = (ArrayRow[]) Arrays.copyOf(this.f13115h, r10);
        b r11 = this.f13122o;
        r11.f13159d = (SolverVariable[]) Arrays.copyOf(r11.f13159d, this.f13113f);
        int r12 = this.f13113f;
        this.f13118k = new boolean[r12];
        this.f13114g = r12;
        this.f13121n = r12;
    }
}
