package androidx.constraintlayout.a.c;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;

/* JADX INFO: compiled from: Barrier.java */
/* JADX INFO: loaded from: classes.dex */
public class a extends j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f693a;
    private int aA;
    private boolean aB;
    private int aC;

    @Override // androidx.constraintlayout.a.c.e
    public boolean a() {
        return true;
    }

    public a() {
        this.aA = 0;
        this.aB = true;
        this.aC = 0;
        this.f693a = false;
    }

    public int b() {
        return this.aA;
    }

    public void a(int r1) {
        this.aA = r1;
    }

    public void a(boolean r1) {
        this.aB = r1;
    }

    public boolean c() {
        return this.aB;
    }

    @Override // androidx.constraintlayout.a.c.e
    public boolean d() {
        return this.f693a;
    }

    @Override // androidx.constraintlayout.a.c.e
    public boolean e() {
        return this.f693a;
    }

    @Override // androidx.constraintlayout.a.c.j, androidx.constraintlayout.a.c.e
    public void a(e r2, HashMap<e, e> r3) {
        super.a(r2, r3);
        a r4 = (a) ZeusTransformUtils.preCheckCast(r2, a.class, "com.obric.aiagent.plugin");
        this.aA = r4.aA;
        this.aB = r4.aB;
        this.aC = r4.aC;
    }

    @Override // androidx.constraintlayout.a.c.e
    public String toString() {
        String r0 = "[Barrier] " + C() + " {";
        int r1 = 0;
    L4:
        if (r1 >= this.az) goto L10;
        e r2 = this.ay[r1];
        if (r1 <= 0) goto L8;
        r0 = r0 + ", ";
    L8:
        r0 = r0 + r2.C();
        r1 = r1 + 1;
        goto L4
    L10:
        return r0 + "}";
    }

    public void f() {
        int r1 = 0;
    L4:
        if (r1 >= this.az) goto L21;
        e r2 = this.ay[r1];
        if (this.aB == false) goto L8;
    L10:
        int r3 = this.aA;
        if (r3 == 0) goto L19;
        if (r3 == 1) goto L19;
        if (r3 != 2) goto L17;
    L18:
        r2.a(1, true);
    L20:
        r1 = r1 + 1;
        goto L4
    L17:
        if (r3 != 3) goto L20;
    L19:
        r2.a(0, true);
        goto L20
    L8:
        if (r2.a() == true) goto L10;
    }

    @Override // androidx.constraintlayout.a.c.e
    public void a(androidx.constraintlayout.a.d r13, boolean r14) {
        this.I[0] = this.A;
        this.I[2] = this.B;
        this.I[1] = this.C;
        this.I[3] = this.D;
        int r15 = 0;
    L4:
        if (r15 >= this.I.length) goto L6;
        this.I[r15].f = r13.a(this.I[r15]);
        r15 = r15 + 1;
        goto L4
    L6:
        int r16 = this.aA;
        if (r16 >= 0) goto L9;
        return;
    L9:
        if (r16 >= 4) goto L130;
        d r17 = this.I[this.aA];
        if (this.f693a == true) goto L14;
        i();
    L14:
        if (this.f693a == false) goto L24;
        this.f693a = false;
        int r18 = this.aA;
        if (r18 == 0) goto L22;
        if (r18 == 1) goto L22;
        if (r18 == 2) goto L21;
        if (r18 == 3) goto L21;
        return;
    L21:
        r13.a(this.B.f, this.R);
        r13.a(this.D.f, this.R);
        return;
    L22:
        r13.a(this.A.f, this.Q);
        r13.a(this.C.f, this.Q);
        return;
    L24:
        int r5 = 0;
    L26:
        if (r5 >= this.az) goto L53;
        e r6 = this.ay[r5];
        if (this.aB == false) goto L30;
    L32:
        int r7 = this.aA;
        if (r7 == 0) goto L36;
        if (r7 == 1) goto L36;
    L42:
        int r8 = this.aA;
        if (r8 == 2) goto L46;
        if (r8 == 3) goto L46;
    L52:
        r5 = r5 + 1;
    L46:
        if (r6.ab() != e.a.f777c) goto L52;
        if (r6.B.f758c == null) goto L52;
        if (r6.D.f758c == null) goto L52;
    L41:
        boolean r9 = true;
    L55:
        if (this.A.c() == false) goto L57;
    L60:
        boolean r10 = true;
    L62:
        if (this.B.c() == false) goto L64;
    L67:
        boolean r11 = true;
    L68:
        if (r9 == true) goto L79;
        int r12 = this.aA;
        if (r12 != 0) goto L72;
        if (r10 == false) goto L72;
    L78:
        boolean r19 = true;
    L80:
        int r20 = 5;
        if (r19 == true) goto L83;
        r20 = 4;
    L83:
        int r21 = 0;
    L85:
        if (r21 >= this.az) goto L105;
        e r22 = this.ay[r21];
        if (this.aB == false) goto L89;
    L91:
        androidx.constraintlayout.a.h r23 = r13.a(r22.I[this.aA]);
        r22.I[this.aA].f = r23;
        if (r22.I[this.aA].f758c != null) goto L94;
    L96:
        int r24 = 0;
    L97:
        int r110 = this.aA;
        if (r110 == 0) goto L102;
        if (r110 == 2) goto L102;
        r13.a(r17.f, r23, this.aC + r24, r9);
    L103:
        r13.c(r17.f, r23, this.aC + r24, r20);
    L104:
        r21 = r21 + 1;
    L102:
        r13.b(r17.f, r23, this.aC - r24, r9);
        goto L103
    L94:
        if (r22.I[this.aA].f758c.f756a != this) goto L96;
        r24 = r22.I[this.aA].f759d + 0;
        goto L97
    L89:
        if (r22.a() == true) goto L91;
    L105:
        int r111 = this.aA;
        if (r111 != 0) goto L108;
        r13.c(this.C.f, this.A.f, 0, 8);
        r13.c(this.A.f, this.L.C.f, 0, 4);
        r13.c(this.A.f, this.L.A.f, 0, 0);
        return;
    L108:
        if (r111 != 1) goto L110;
        r13.c(this.A.f, this.C.f, 0, 8);
        r13.c(this.A.f, this.L.A.f, 0, 4);
        r13.c(this.A.f, this.L.C.f, 0, 0);
        return;
    L110:
        if (r111 != 2) goto L112;
        r13.c(this.D.f, this.B.f, 0, 8);
        r13.c(this.B.f, this.L.D.f, 0, 4);
        r13.c(this.B.f, this.L.B.f, 0, 0);
        return;
    L112:
        if (r111 != 3) goto L134;
        r13.c(this.B.f, this.D.f, 0, 8);
        r13.c(this.B.f, this.L.B.f, 0, 4);
        r13.c(this.B.f, this.L.D.f, 0, 0);
        return;
    L134:
        return;
    L72:
        if (r12 != 2) goto L74;
        if (r11 == true) goto L78;
    L74:
        if (r12 != 1) goto L76;
        if (r10 == true) goto L78;
    L76:
        if (r12 != 3) goto L79;
        if (r11 == true) goto L78;
    L79:
        r19 = false;
        goto L80
    L64:
        if (this.D.c() == true) goto L67;
        r11 = false;
        goto L68
    L57:
        if (this.C.c() == true) goto L60;
        r10 = false;
    L36:
        if (r6.aa() != e.a.f777c) goto L42;
        if (r6.A.f758c == null) goto L42;
        if (r6.C.f758c == null) goto L42;
    L30:
        if (r6.a() == true) goto L32;
    L53:
        r9 = false;
        goto L55
    }

    public void b(int r1) {
        this.aC = r1;
    }

    public int g() {
        return this.aC;
    }

    public int h() {
        int r2 = this.aA;
        if (r2 != 0) goto L5;
        return 0;
    L5:
        if (r2 != 1) goto L7;
        return 0;
    L7:
        if (r2 != 2) goto L9;
    L12:
        return 1;
    L9:
        if (r2 == 3) goto L12;
        return -1;
    }

    public boolean i() {
        int r0 = 0;
        int r2 = 0;
        boolean r3 = true;
    L4:
        if (r2 >= this.az) goto L23;
        e r4 = this.ay[r2];
        if (this.aB == false) goto L8;
    L10:
        int r7 = this.aA;
        if (r7 == 0) goto L14;
        if (r7 == 1) goto L14;
    L16:
        int r8 = this.aA;
        if (r8 == 2) goto L20;
        if (r8 == 3) goto L20;
    L22:
        r2 = r2 + 1;
    L20:
        if (r4.e() == true) goto L22;
    L15:
        r3 = false;
    L14:
        if (r4.d() == true) goto L16;
    L8:
        if (r4.a() == true) goto L10;
    L23:
        if (r3 == true) goto L25;
    L63:
        return false;
    L25:
        if (this.az <= 0) goto L63;
        int r5 = 0;
        boolean r6 = false;
    L28:
        if (r0 >= this.az) goto L55;
        e r9 = this.ay[r0];
        if (this.aB == false) goto L32;
    L34:
        if (r6 == true) goto L45;
        int r10 = this.aA;
        if (r10 != 0) goto L38;
        r5 = r9.a(d.a.f763b).d();
    L44:
        r6 = true;
        goto L45
    L38:
        if (r10 != 1) goto L40;
        r5 = r9.a(d.a.f765d).d();
        goto L44
    L40:
        if (r10 != 2) goto L42;
        r5 = r9.a(d.a.f764c).d();
        goto L44
    L42:
        if (r10 != 3) goto L44;
        r5 = r9.a(d.a.f766e).d();
    L45:
        int r11 = this.aA;
        if (r11 != 0) goto L48;
        r5 = Math.min(r5, r9.a(d.a.f763b).d());
    L54:
        r0 = r0 + 1;
        goto L28
    L48:
        if (r11 != 1) goto L50;
        r5 = Math.max(r5, r9.a(d.a.f765d).d());
        goto L54
    L50:
        if (r11 != 2) goto L52;
        r5 = Math.min(r5, r9.a(d.a.f764c).d());
        goto L54
    L52:
        if (r11 != 3) goto L54;
        r5 = Math.max(r5, r9.a(d.a.f766e).d());
        goto L54
    L32:
        if (r9.a() == true) goto L34;
    L55:
        int r12 = r5 + this.aC;
        int r1 = this.aA;
        if (r1 == 0) goto L60;
        if (r1 == 1) goto L60;
        b(r12, r12);
    L61:
        this.f693a = true;
        return true;
    L60:
        a(r12, r12);
        goto L61
    }
}
