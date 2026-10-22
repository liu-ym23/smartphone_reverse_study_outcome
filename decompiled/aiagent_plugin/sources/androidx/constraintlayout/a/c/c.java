package androidx.constraintlayout.a.c;

import java.util.ArrayList;

/* JADX INFO: compiled from: ChainHead.java */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected e f751a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected e f752b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected e f753c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected e f754d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected e f755e;
    protected e f;
    protected e g;
    protected ArrayList<e> h;
    protected int i;
    protected int j;
    protected float k;
    int l;
    int m;
    int n;
    boolean o;
    protected boolean p;
    protected boolean q;
    protected boolean r;
    protected boolean s;
    private int t;
    private boolean u;
    private boolean v;

    public c(e r2, int r3, boolean r4) {
        this.k = 0.0f;
        this.u = false;
        this.f751a = r2;
        this.t = r3;
        this.u = r4;
    }

    private static boolean a(e r2, int r3) {
        if (r2.B() != 8) goto L5;
    L11:
        return false;
    L5:
        if (r2.K[r3] != e.a.f777c) goto L11;
        if (r2.p[r3] != 0) goto L9;
    L10:
        return true;
    L9:
        if (r2.p[r3] != 3) goto L11;
        goto L10
    }

    private void b() {
        int r0 = this.t * 2;
        e r2 = this.f751a;
        boolean r3 = true;
        this.o = true;
        e r5 = r2;
        boolean r6 = false;
    L3:
        if (r6 == true) goto L75;
        this.i++;
        e r9 = null;
        r2.at[this.t] = null;
        r2.as[this.t] = null;
        if (r2.B() == 8) goto L61;
        this.l++;
        if (r2.x(this.t) == e.a.f777c) goto L9;
        this.m += r2.m(this.t);
    L9:
        int r7 = this.m + r2.I[r0].i();
        this.m = r7;
        int r10 = r0 + 1;
        this.m = r7 + r2.I[r10].i();
        int r8 = this.n + r2.I[r0].i();
        this.n = r8;
        this.n = r8 + r2.I[r10].i();
        if (this.f752b != null) goto L12;
        this.f752b = r2;
    L12:
        this.f754d = r2;
        if (r2.K[this.t] != e.a.f777c) goto L61;
        if (r2.p[this.t] != 0) goto L17;
    L20:
        this.j++;
        float r11 = r2.ar[this.t];
        if (r11 <= 0.0f) goto L24;
        this.k += r2.ar[this.t];
    L24:
        if (a(r2, this.t) == false) goto L34;
        if (r11 >= 0.0f) goto L28;
        this.p = true;
    L30:
        if (this.h != null) goto L32;
        this.h = new ArrayList();
    L32:
        this.h.add(r2);
        goto L34
    L28:
        this.q = true;
    L34:
        if (this.f != null) goto L36;
        this.f = r2;
    L36:
        e r12 = this.g;
        if (r12 == null) goto L39;
        r12.as[this.t] = r2;
    L39:
        this.g = r2;
    L41:
        if (this.t != 0) goto L51;
        if (r2.n == 0) goto L46;
        this.o = false;
    L59:
        if (r2.O == 0.0f) goto L61;
        this.o = false;
        this.s = true;
        goto L61
    L46:
        if (r2.q == 0) goto L48;
    L49:
        this.o = false;
        goto L59
    L48:
        if (r2.r == 0) goto L59;
    L51:
        if (r2.o == 0) goto L54;
        this.o = false;
        goto L59
    L54:
        if (r2.t == 0) goto L56;
    L57:
        this.o = false;
        goto L59
    L56:
        if (r2.u == 0) goto L59;
    L17:
        if (r2.p[this.t] == 3) goto L20;
        if (r2.p[this.t] != 2) goto L41;
    L61:
        if (r5 == r2) goto L63;
        r5.at[this.t] = r2;
    L63:
        d r13 = r2.I[r0 + 1].f758c;
        if (r13 == null) goto L71;
        e r14 = r13.f756a;
        if (r14.I[r0].f758c == null) goto L71;
        if (r14.I[r0].f758c.f756a != r2) goto L71;
        r9 = r14;
    L71:
        if (r9 != null) goto L74;
        r9 = r2;
        r6 = true;
    L74:
        r5 = r2;
        r2 = r9;
        goto L3
    L75:
        e r1 = this.f752b;
        if (r1 == null) goto L78;
        this.m -= r1.I[r0].i();
    L78:
        e r4 = this.f754d;
        if (r4 == null) goto L81;
        this.m -= r4.I[r0 + 1].i();
    L81:
        this.f753c = r2;
        if (this.t == 0) goto L84;
    L86:
        this.f755e = this.f751a;
    L88:
        if (this.q == true) goto L90;
    L92:
        r3 = false;
    L93:
        this.r = r3;
        return;
    L90:
        if (this.p == false) goto L92;
    L84:
        if (this.u == false) goto L86;
        this.f755e = r2;
        goto L88
    }

    public void a() {
        if (this.v == true) goto L5;
        b();
    L5:
        this.v = true;
    }
}
