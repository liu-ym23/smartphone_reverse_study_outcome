package androidx.constraintlayout.a.c.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: VerticalWidgetRun.java */
/* JADX INFO: loaded from: classes.dex */
public class n extends p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f f729a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    g f730b;

    /* JADX INFO: renamed from: androidx.constraintlayout.a.c.a.n$1, reason: invalid class name */
    /* JADX INFO: compiled from: VerticalWidgetRun.java */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f731a = null;

        static {
            int[] r0 = new int[p.a.values().length];
            f731a = r0;
            r0[p.a.f747b.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f731a[p.a.f748c.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f731a[p.a.f749d.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public n(androidx.constraintlayout.a.c.e r2) {
        super(r2);
        this.f729a = new f(this);
        this.f730b = null;
        f r3 = this.j;
        r3.f713e = f.a.f;
        f r4 = this.k;
        r4.f713e = f.a.g;
        f r5 = this.f729a;
        r5.f713e = f.a.h;
        this.h = 1;
    }

    public String toString() {
        return "VerticalRun " + this.f743d.C();
    }

    @Override // androidx.constraintlayout.a.c.a.p
    void c() {
        this.f744e = null;
        this.j.a();
        this.k.a();
        this.f729a.a();
        this.g.a();
        this.i = false;
    }

    @Override // androidx.constraintlayout.a.c.a.p
    void d() {
        this.i = false;
        this.j.a();
        this.j.j = false;
        this.k.a();
        this.k.j = false;
        this.f729a.a();
        this.f729a.j = false;
        this.g.j = false;
    }

    @Override // androidx.constraintlayout.a.c.a.p
    boolean a() {
        if (this.f == androidx.constraintlayout.a.c.e.a.f777c) goto L5;
        return true;
    L5:
        if (this.f743d.o != 0) goto L7;
        return true;
    L7:
        return false;
    }

    @Override // androidx.constraintlayout.a.c.a.p, androidx.constraintlayout.a.c.a.d
    public void update(d r8) {
        d r9 = (d) ZeusTransformUtils.wrapperContextForParams(r8, d.class, "com.obric.aiagent.plugin");
        int r0 = AnonymousClass1.f731a[this.l.ordinal()];
        if (r0 == 1) goto L10;
        if (r0 == 2) goto L9;
        if (r0 != 3) goto L12;
        a(r9, this.f743d.B, this.f743d.D, 1);
        return;
    L12:
        if (this.g.f711c == false) goto L40;
        if (this.g.j == true) goto L40;
        if (this.f != androidx.constraintlayout.a.c.e.a.f777c) goto L40;
        int r10 = this.f743d.o;
        if (r10 == 2) goto L34;
        if (r10 != 3) goto L40;
        if (this.f743d.f.g.j == false) goto L40;
        int r11 = this.f743d.V();
        if (r11 == (-1)) goto L30;
        if (r11 == 0) goto L29;
        if (r11 == 1) goto L28;
        int r12 = 0;
    L33:
        this.g.a(r12);
        goto L40
    L28:
        float r13 = this.f743d.f.g.g;
        float r2 = this.f743d.U();
    L31:
        float r14 = r13 / r2;
    L32:
        r12 = (int) (r14 + 0.5f);
        goto L33
    L29:
        r14 = this.f743d.f.g.g * this.f743d.U();
        goto L32
    L30:
        r13 = this.f743d.f.g.g;
        r2 = this.f743d.U();
        goto L31
    L34:
        androidx.constraintlayout.a.c.e r15 = this.f743d.A();
        if (r15 == null) goto L40;
        if (r15.g.g.j == false) goto L40;
        this.g.a((int) ((r15.g.g.g * this.f743d.v) + 0.5f));
    L40:
        if (this.j.f711c == true) goto L42;
        return;
    L42:
        if (this.k.f711c == true) goto L45;
        return;
    L45:
        if (this.j.j == false) goto L52;
        if (this.k.j == false) goto L52;
        if (this.g.j == false) goto L52;
        return;
    L52:
        if (this.g.j == true) goto L62;
        if (this.f != androidx.constraintlayout.a.c.e.a.f777c) goto L62;
        if (this.f743d.n != 0) goto L62;
        if (this.f743d.ad() == true) goto L62;
        f r16 = (f) ZeusTransformUtils.preCheckCast(this.j.l.get(0), f.class, "com.obric.aiagent.plugin");
        f r1 = (f) ZeusTransformUtils.preCheckCast(this.k.l.get(0), f.class, "com.obric.aiagent.plugin");
        int r17 = r16.g + this.j.f;
        int r3 = r1.g + this.k.f;
        this.j.a(r17);
        this.k.a(r3);
        this.g.a(r3 - r17);
        return;
    L62:
        if (this.g.j == true) goto L76;
        if (this.f != androidx.constraintlayout.a.c.e.a.f777c) goto L76;
        if (this.f742c != 1) goto L76;
        if (this.j.l.size() <= 0) goto L76;
        if (this.k.l.size() <= 0) goto L76;
        f r18 = (f) ZeusTransformUtils.preCheckCast(this.j.l.get(0), f.class, "com.obric.aiagent.plugin");
        f r4 = (f) ZeusTransformUtils.preCheckCast(this.k.l.get(0), f.class, "com.obric.aiagent.plugin");
        int r5 = (r4.g + this.k.f) - (r18.g + this.j.f);
        if (r5 >= this.g.m) goto L74;
        this.g.a(r5);
        goto L76
    L74:
        this.g.a(this.g.m);
    L76:
        if (this.g.j == true) goto L79;
        return;
    L79:
        if (this.j.l.size() > 0) goto L81;
        return;
    L81:
        if (this.k.l.size() <= 0) goto L89;
        f r19 = (f) ZeusTransformUtils.preCheckCast(this.j.l.get(0), f.class, "com.obric.aiagent.plugin");
        f r6 = (f) ZeusTransformUtils.preCheckCast(this.k.l.get(0), f.class, "com.obric.aiagent.plugin");
        int r7 = r19.g + this.j.f;
        int r20 = r6.g + this.k.f;
        float r21 = this.f743d.Q();
        if (r19 != r6) goto L85;
        r7 = r19.g;
        r20 = r6.g;
        r21 = 0.5f;
    L85:
        this.j.a((int) ((r7 + 0.5f) + (((r20 - r7) - this.g.g) * r21)));
        this.k.a(this.j.g + this.g.g);
        return;
    L89:
        return;
    L9:
        b(r9);
        goto L12
    L10:
        a(r9);
        goto L12
    }

    @Override // androidx.constraintlayout.a.c.a.p
    void f() {
        if (this.f743d.f769b == false) goto L6;
        this.g.a(this.f743d.G());
    L6:
        if (this.g.j == true) goto L24;
        this.f = this.f743d.ab();
        if (this.f743d.R() == false) goto L11;
        this.f730b = new a(this);
    L11:
        if (this.f == androidx.constraintlayout.a.c.e.a.f777c) goto L32;
        if (this.f != androidx.constraintlayout.a.c.e.a.f778d) goto L21;
        androidx.constraintlayout.a.c.e r0 = this.f743d.A();
        if (r0 == null) goto L21;
        if (r0.ab() != androidx.constraintlayout.a.c.e.a.f775a) goto L21;
        int r1 = (r0.G() - this.f743d.B.i()) - this.f743d.D.i();
        a(this.j, r0.g.j, this.f743d.B.i());
        a(this.k, r0.g.k, -this.f743d.D.i());
        this.g.a(r1);
        return;
    L21:
        if (this.f != androidx.constraintlayout.a.c.e.a.f775a) goto L32;
        this.g.a(this.f743d.G());
    L32:
        if (this.g.j == false) goto L82;
        if (this.f743d.f769b == false) goto L82;
        if (this.f743d.I[2].f758c == null) goto L53;
        if (this.f743d.I[3].f758c == null) goto L53;
        if (this.f743d.ad() == false) goto L42;
        f r2 = this.j;
        r2.f = this.f743d.I[2].i();
        f r3 = this.k;
        r3.f = -this.f743d.I[3].i();
    L50:
        if (this.f743d.R() == false) goto L160;
        a(this.f729a, this.j, this.f743d.S());
        return;
    L160:
        return;
    L42:
        f r4 = a(this.f743d.I[2]);
        if (r4 == null) goto L45;
        a(this.j, r4, this.f743d.I[2].i());
    L45:
        f r5 = a(this.f743d.I[3]);
        if (r5 == null) goto L48;
        a(this.k, r5, -this.f743d.I[3].i());
    L48:
        this.j.f710b = true;
        this.k.f710b = true;
    L53:
        if (this.f743d.I[2].f758c == null) goto L60;
        f r6 = a(this.f743d.I[2]);
        if (r6 == null) goto L162;
        a(this.j, r6, this.f743d.I[2].i());
        a(this.k, this.j, this.g.g);
        if (this.f743d.R() == false) goto L163;
        a(this.f729a, this.j, this.f743d.S());
        return;
    L163:
        return;
    L162:
        return;
    L60:
        if (this.f743d.I[3].f758c == null) goto L68;
        f r7 = a(this.f743d.I[3]);
        if (r7 == null) goto L65;
        a(this.k, r7, -this.f743d.I[3].i());
        a(this.j, this.k, -this.g.g);
    L65:
        if (this.f743d.R() == false) goto L165;
        a(this.f729a, this.j, this.f743d.S());
        return;
    L165:
        return;
    L68:
        if (this.f743d.I[4].f758c == null) goto L73;
        f r8 = a(this.f743d.I[4]);
        if (r8 == null) goto L167;
        a(this.f729a, r8, 0);
        a(this.j, this.f729a, -this.f743d.S());
        a(this.k, this.j, this.g.g);
        return;
    L167:
        return;
    L73:
        if (ZeusTransformUtils.instanceOf(this.f743d, androidx.constraintlayout.a.c.i.class) == false) goto L75;
        return;
    L75:
        if (this.f743d.A() != null) goto L77;
        return;
    L77:
        if (this.f743d.a(androidx.constraintlayout.a.c.d.a.g).f758c != null) goto L171;
        f r9 = this.f743d.A().g.j;
        a(this.j, r9, this.f743d.E());
        a(this.k, this.j, this.g.g);
        if (this.f743d.R() == false) goto L172;
        a(this.f729a, this.j, this.f743d.S());
        return;
    L172:
        return;
    L171:
        return;
    L82:
        if (this.g.j == false) goto L84;
    L99:
        this.g.a(this);
    L101:
        if (this.f743d.I[2].f758c == null) goto L117;
        if (this.f743d.I[3].f758c == null) goto L117;
        if (this.f743d.ad() == false) goto L107;
        f r10 = this.j;
        r10.f = this.f743d.I[2].i();
        f r11 = this.k;
        r11.f = -this.f743d.I[3].i();
    L114:
        if (this.f743d.R() == false) goto L157;
        a(this.f729a, this.j, 1, this.f730b);
    L157:
        if (this.g.l.size() != 0) goto L174;
        this.g.f711c = true;
        return;
    L174:
        return;
    L107:
        f r12 = a(this.f743d.I[2]);
        f r13 = a(this.f743d.I[3]);
        if (r12 == null) goto L110;
        r12.a(this);
    L110:
        if (r13 == null) goto L112;
        r13.a(this);
    L112:
        this.l = p.a.f749d;
    L117:
        if (this.f743d.I[2].f758c == null) goto L131;
        f r14 = a(this.f743d.I[2]);
        if (r14 == null) goto L157;
        a(this.j, r14, this.f743d.I[2].i());
        a(this.k, this.j, 1, this.g);
        if (this.f743d.R() == false) goto L124;
        a(this.f729a, this.j, 1, this.f730b);
    L124:
        if (this.f != androidx.constraintlayout.a.c.e.a.f777c) goto L157;
        if (this.f743d.U() <= 0.0f) goto L157;
        if (this.f743d.f.f != androidx.constraintlayout.a.c.e.a.f777c) goto L157;
        this.f743d.f.g.k.add(this.g);
        this.g.l.add(this.f743d.f.g);
        this.g.f709a = this;
        goto L157
    L131:
        if (this.f743d.I[3].f758c == null) goto L138;
        f r15 = a(this.f743d.I[3]);
        if (r15 == null) goto L157;
        a(this.k, r15, -this.f743d.I[3].i());
        a(this.j, this.k, -1, this.g);
        if (this.f743d.R() == false) goto L157;
        a(this.f729a, this.j, 1, this.f730b);
        goto L157
    L138:
        if (this.f743d.I[4].f758c == null) goto L143;
        f r16 = a(this.f743d.I[4]);
        if (r16 == null) goto L157;
        a(this.f729a, r16, 0);
        a(this.j, this.f729a, -1, this.f730b);
        a(this.k, this.j, 1, this.g);
        goto L157
    L143:
        if (ZeusTransformUtils.instanceOf(this.f743d, androidx.constraintlayout.a.c.i.class) == true) goto L157;
        if (this.f743d.A() == null) goto L157;
        f r17 = this.f743d.A().g.j;
        a(this.j, r17, this.f743d.E());
        a(this.k, this.j, 1, this.g);
        if (this.f743d.R() == false) goto L150;
        a(this.f729a, this.j, 1, this.f730b);
    L150:
        if (this.f != androidx.constraintlayout.a.c.e.a.f777c) goto L157;
        if (this.f743d.U() <= 0.0f) goto L157;
        if (this.f743d.f.f != androidx.constraintlayout.a.c.e.a.f777c) goto L157;
        this.f743d.f.g.k.add(this.g);
        this.g.l.add(this.f743d.f.g);
        this.g.f709a = this;
        goto L157
    L84:
        if (this.f != androidx.constraintlayout.a.c.e.a.f777c) goto L99;
        int r18 = this.f743d.o;
        if (r18 == 2) goto L95;
        if (r18 != 3) goto L101;
        if (this.f743d.ad() == true) goto L101;
        if (this.f743d.n == 3) goto L101;
        g r19 = this.f743d.f.g;
        this.g.l.add(r19);
        r19.k.add(this.g);
        this.g.f710b = true;
        this.g.k.add(this.j);
        this.g.k.add(this.k);
        goto L101
    L95:
        androidx.constraintlayout.a.c.e r20 = this.f743d.A();
        if (r20 == null) goto L101;
        g r21 = r20.g.g;
        this.g.l.add(r21);
        r21.k.add(this.g);
        this.g.f710b = true;
        this.g.k.add(this.j);
        this.g.k.add(this.k);
        goto L101
    L24:
        if (this.f != androidx.constraintlayout.a.c.e.a.f778d) goto L32;
        androidx.constraintlayout.a.c.e r22 = this.f743d.A();
        if (r22 == null) goto L32;
        if (r22.ab() != androidx.constraintlayout.a.c.e.a.f775a) goto L32;
        a(this.j, r22.g.j, this.f743d.B.i());
        a(this.k, r22.g.k, -this.f743d.D.i());
    }

    @Override // androidx.constraintlayout.a.c.a.p
    public void e() {
        if (this.j.j == false) goto L6;
        this.f743d.p(this.j.g);
        return;
    }
}
