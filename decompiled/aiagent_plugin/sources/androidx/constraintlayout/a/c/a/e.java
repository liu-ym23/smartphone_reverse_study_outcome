package androidx.constraintlayout.a.c.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: compiled from: DependencyGraph.java */
/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ArrayList<m> f704a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private androidx.constraintlayout.a.c.f f705b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f706c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f707d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private androidx.constraintlayout.a.c.f f708e;
    private ArrayList<p> f;
    private ArrayList<m> g;
    private b.InterfaceC0012b h;
    private b.a i;

    public e(androidx.constraintlayout.a.c.f r2) {
        this.f706c = true;
        this.f707d = true;
        this.f = new ArrayList();
        this.g = new ArrayList();
        this.h = null;
        this.i = new b.a();
        this.f704a = new ArrayList();
        this.f705b = r2;
        this.f708e = r2;
    }

    public void a(b.InterfaceC0012b r3) {
        this.h = (b.InterfaceC0012b) ZeusTransformUtils.wrapperContextForParams(r3, b.InterfaceC0012b.class, "com.obric.aiagent.plugin");
    }

    private int a(androidx.constraintlayout.a.c.f r8, int r9) {
        int r0 = this.f704a.size();
        long r1 = 0;
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L6;
        r1 = Math.max(r1, ((m) ZeusTransformUtils.preCheckCast(this.f704a.get(r3), m.class, "com.obric.aiagent.plugin")).a(r8, r9));
        r3 = r3 + 1;
        goto L3
    L6:
        return (int) r1;
    }

    public boolean a(boolean r11) {
        boolean r0 = true;
        boolean r12 = r11 & true;
        if (this.f706c == false) goto L5;
    L6:
        Iterator<androidx.constraintlayout.a.c.e> r1 = this.f705b.aU.iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        androidx.constraintlayout.a.c.e r4 = (androidx.constraintlayout.a.c.e) ZeusTransformUtils.preCheckCast(r1.next(), androidx.constraintlayout.a.c.e.class, "com.obric.aiagent.plugin");
        r4.z();
        r4.f769b = false;
        r4.f.d();
        r4.g.d();
        goto L8
    L10:
        this.f705b.z();
        this.f705b.f769b = false;
        this.f705b.f.d();
        this.f705b.g.d();
        this.f707d = false;
    L12:
        if (a(this.f708e) == false) goto L14;
        return false;
    L14:
        this.f705b.o(0);
        this.f705b.p(0);
        androidx.constraintlayout.a.c.e.a r2 = this.f705b.x(0);
        androidx.constraintlayout.a.c.e.a r5 = this.f705b.x(1);
        if (this.f706c == false) goto L17;
        d();
    L17:
        int r6 = this.f705b.D();
        int r7 = this.f705b.E();
        this.f705b.f.j.a(r6);
        this.f705b.g.j.a(r7);
        a();
        if (r2 != androidx.constraintlayout.a.c.e.a.f776b) goto L20;
    L21:
        if (r12 == false) goto L28;
        Iterator<p> r8 = this.f.iterator();
    L24:
        if (r8.hasNext() == false) goto L28;
        if (((p) ZeusTransformUtils.preCheckCast(r8.next(), p.class, "com.obric.aiagent.plugin")).a() == true) goto L24;
        r12 = false;
    L28:
        if (r12 == true) goto L30;
    L32:
        if (r12 == true) goto L34;
    L37:
        if (this.f705b.K[0] != androidx.constraintlayout.a.c.e.a.f775a) goto L39;
    L42:
        int r13 = this.f705b.F() + r6;
        this.f705b.f.k.a(r13);
        this.f705b.f.g.a(r13 - r6);
        a();
        if (this.f705b.K[1] != androidx.constraintlayout.a.c.e.a.f775a) goto L45;
    L46:
        int r14 = this.f705b.G() + r7;
        this.f705b.g.k.a(r14);
        this.f705b.g.g.a(r14 - r7);
    L47:
        a();
        boolean r15 = true;
    L48:
        Iterator<p> r9 = this.f.iterator();
    L50:
        if (r9.hasNext() == false) goto L57;
        p r10 = (p) ZeusTransformUtils.preCheckCast(r9.next(), p.class, "com.obric.aiagent.plugin");
        if (r10.f743d != this.f705b) goto L56;
        if (r10.i == false) goto L50;
    L56:
        r10.e();
        goto L50
    L57:
        Iterator<p> r16 = this.f.iterator();
    L59:
        if (r16.hasNext() == false) goto L80;
        p r17 = (p) ZeusTransformUtils.preCheckCast(r16.next(), p.class, "com.obric.aiagent.plugin");
        if (r15 == true) goto L66;
        if (r17.f743d == this.f705b) goto L59;
    L66:
        if (r17.j.j == false) goto L67;
        if (r17.k.j == true) goto L74;
        if (ZeusTransformUtils.instanceOf(r17, j.class) == false) goto L67;
    L74:
        if (r17.g.j == true) goto L59;
        if (ZeusTransformUtils.instanceOf(r17, c.class) == true) goto L59;
        if (ZeusTransformUtils.instanceOf(r17, j.class) == true) goto L59;
    L67:
        r0 = false;
    L80:
        this.f705b.a(r2);
        this.f705b.b(r5);
        return r0;
    L45:
        if (this.f705b.K[1] != androidx.constraintlayout.a.c.e.a.f778d) goto L47;
    L39:
        if (this.f705b.K[0] == androidx.constraintlayout.a.c.e.a.f778d) goto L42;
        r15 = false;
        goto L48
    L34:
        if (r5 != androidx.constraintlayout.a.c.e.a.f776b) goto L37;
        this.f705b.b(androidx.constraintlayout.a.c.e.a.f775a);
        androidx.constraintlayout.a.c.f r18 = this.f705b;
        r18.r(a(r18, 1));
        this.f705b.g.g.a(this.f705b.G());
        goto L37
    L30:
        if (r2 != androidx.constraintlayout.a.c.e.a.f776b) goto L32;
        this.f705b.a(androidx.constraintlayout.a.c.e.a.f775a);
        androidx.constraintlayout.a.c.f r19 = this.f705b;
        r19.q(a(r19, 0));
        this.f705b.f.g.a(this.f705b.F());
        goto L32
    L20:
        if (r5 != androidx.constraintlayout.a.c.e.a.f776b) goto L37;
    L5:
        if (this.f707d == false) goto L12;
        goto L6
    }

    public boolean b(boolean r5) {
        if (this.f706c == false) goto L10;
        Iterator<androidx.constraintlayout.a.c.e> r6 = this.f705b.aU.iterator();
    L6:
        if (r6.hasNext() == false) goto L8;
        androidx.constraintlayout.a.c.e r1 = (androidx.constraintlayout.a.c.e) ZeusTransformUtils.preCheckCast(r6.next(), androidx.constraintlayout.a.c.e.class, "com.obric.aiagent.plugin");
        r1.z();
        r1.f769b = false;
        r1.f.g.j = false;
        r1.f.i = false;
        r1.f.d();
        r1.g.g.j = false;
        r1.g.i = false;
        r1.g.d();
        goto L6
    L8:
        this.f705b.z();
        this.f705b.f769b = false;
        this.f705b.f.g.j = false;
        this.f705b.f.i = false;
        this.f705b.f.d();
        this.f705b.g.g.j = false;
        this.f705b.g.i = false;
        this.f705b.g.d();
        d();
    L10:
        if (a(this.f708e) == false) goto L12;
        return false;
    L12:
        this.f705b.o(0);
        this.f705b.p(0);
        this.f705b.f.j.a(0);
        this.f705b.g.j.a(0);
        return true;
    }

    public boolean a(boolean r11, int r12) {
        boolean r0 = true;
        boolean r13 = r11 & true;
        androidx.constraintlayout.a.c.e.a r1 = this.f705b.x(0);
        androidx.constraintlayout.a.c.e.a r3 = this.f705b.x(1);
        int r4 = this.f705b.D();
        int r5 = this.f705b.E();
        if (r13 == true) goto L5;
    L25:
        if (r12 != 0) goto L32;
        if (this.f705b.K[0] != androidx.constraintlayout.a.c.e.a.f775a) goto L29;
    L30:
        int r14 = this.f705b.F() + r4;
        this.f705b.f.k.a(r14);
        this.f705b.f.g.a(r14 - r4);
    L38:
        boolean r15 = true;
    L39:
        a();
        Iterator<p> r6 = this.f.iterator();
    L41:
        if (r6.hasNext() == false) goto L51;
        p r7 = (p) ZeusTransformUtils.preCheckCast(r6.next(), p.class, "com.obric.aiagent.plugin");
        if (r7.h != r12) goto L41;
        if (r7.f743d != this.f705b) goto L50;
        if (r7.i == false) goto L41;
    L50:
        r7.e();
        goto L41
    L51:
        Iterator<p> r8 = this.f.iterator();
    L53:
        if (r8.hasNext() == false) goto L72;
        p r9 = (p) ZeusTransformUtils.preCheckCast(r8.next(), p.class, "com.obric.aiagent.plugin");
        if (r9.h != r12) goto L53;
        if (r15 == true) goto L62;
        if (r9.f743d == this.f705b) goto L53;
    L62:
        if (r9.j.j == false) goto L63;
        if (r9.k.j == false) goto L63;
        if (ZeusTransformUtils.instanceOf(r9, c.class) == true) goto L53;
        if (r9.g.j == true) goto L53;
    L63:
        r0 = false;
    L72:
        this.f705b.a(r1);
        this.f705b.b(r3);
        return r0;
    L29:
        if (this.f705b.K[0] == androidx.constraintlayout.a.c.e.a.f778d) goto L30;
    L36:
        r15 = false;
        goto L39
    L32:
        if (this.f705b.K[1] != androidx.constraintlayout.a.c.e.a.f775a) goto L34;
    L37:
        int r16 = this.f705b.G() + r5;
        this.f705b.g.k.a(r16);
        this.f705b.g.g.a(r16 - r5);
        goto L38
    L34:
        if (this.f705b.K[1] != androidx.constraintlayout.a.c.e.a.f778d) goto L36;
    L5:
        if (r1 != androidx.constraintlayout.a.c.e.a.f776b) goto L7;
    L8:
        Iterator<p> r10 = this.f.iterator();
    L10:
        if (r10.hasNext() == false) goto L16;
        p r17 = (p) ZeusTransformUtils.preCheckCast(r10.next(), p.class, "com.obric.aiagent.plugin");
        if (r17.h != r12) goto L10;
        if (r17.a() == true) goto L10;
        r13 = false;
    L16:
        if (r12 != 0) goto L21;
        if (r13 == false) goto L25;
        if (r1 != androidx.constraintlayout.a.c.e.a.f776b) goto L25;
        this.f705b.a(androidx.constraintlayout.a.c.e.a.f775a);
        androidx.constraintlayout.a.c.f r18 = this.f705b;
        r18.q(a(r18, 0));
        this.f705b.f.g.a(this.f705b.F());
        goto L25
    L21:
        if (r13 == false) goto L25;
        if (r3 != androidx.constraintlayout.a.c.e.a.f776b) goto L25;
        this.f705b.b(androidx.constraintlayout.a.c.e.a.f775a);
        androidx.constraintlayout.a.c.f r19 = this.f705b;
        r19.r(a(r19, 1));
        this.f705b.g.g.a(this.f705b.G());
        goto L25
    L7:
        if (r3 != androidx.constraintlayout.a.c.e.a.f776b) goto L25;
        goto L8
    }

    private void a(androidx.constraintlayout.a.c.e r2, androidx.constraintlayout.a.c.e.a r3, int r4, androidx.constraintlayout.a.c.e.a r5, int r6) {
        this.i.f700d = r3;
        this.i.f701e = r5;
        this.i.f = r4;
        this.i.g = r6;
        this.h.a(r2, this.i);
        r2.q(this.i.h);
        r2.r(this.i.i);
        r2.c(this.i.k);
        r2.u(this.i.j);
    }

    private boolean a(androidx.constraintlayout.a.c.f r13) {
        Iterator<androidx.constraintlayout.a.c.e> r0 = r13.aU.iterator();
    L4:
        if (r0.hasNext() == false) goto L161;
        androidx.constraintlayout.a.c.e r1 = (androidx.constraintlayout.a.c.e) ZeusTransformUtils.preCheckCast(r0.next(), androidx.constraintlayout.a.c.e.class, "com.obric.aiagent.plugin");
        androidx.constraintlayout.a.c.e.a r3 = r1.K[0];
        androidx.constraintlayout.a.c.e.a r4 = r1.K[1];
        if (r1.B() == 8) goto L7;
        if (r1.s >= 1.0f) goto L14;
        if (r3 != androidx.constraintlayout.a.c.e.a.f777c) goto L14;
        r1.n = 2;
    L14:
        if (r1.v >= 1.0f) goto L19;
        if (r4 != androidx.constraintlayout.a.c.e.a.f777c) goto L19;
        r1.o = 2;
    L19:
        if (r1.U() <= 0.0f) goto L45;
        if (r3 != androidx.constraintlayout.a.c.e.a.f777c) goto L28;
        if (r4 != androidx.constraintlayout.a.c.e.a.f776b) goto L25;
    L26:
        r1.n = 3;
        goto L45
    L25:
        if (r4 == androidx.constraintlayout.a.c.e.a.f775a) goto L26;
    L28:
        if (r4 != androidx.constraintlayout.a.c.e.a.f777c) goto L35;
        if (r3 != androidx.constraintlayout.a.c.e.a.f776b) goto L32;
    L33:
        r1.o = 3;
        goto L45
    L32:
        if (r3 == androidx.constraintlayout.a.c.e.a.f775a) goto L33;
    L35:
        if (r3 != androidx.constraintlayout.a.c.e.a.f777c) goto L45;
        if (r4 != androidx.constraintlayout.a.c.e.a.f777c) goto L45;
        if (r1.n != 0) goto L42;
        r1.n = 3;
    L42:
        if (r1.o != 0) goto L45;
        r1.o = 3;
    L45:
        if (r3 == androidx.constraintlayout.a.c.e.a.f777c) goto L47;
    L53:
        androidx.constraintlayout.a.c.e.a r5 = r3;
        if (r4 == androidx.constraintlayout.a.c.e.a.f777c) goto L56;
    L62:
        androidx.constraintlayout.a.c.e.a r8 = r4;
    L63:
        r1.f.f = r5;
        r1.f.f742c = r1.n;
        r1.g.f = r8;
        r1.g.f742c = r1.o;
        if (r5 == androidx.constraintlayout.a.c.e.a.f778d) goto L70;
        if (r5 == androidx.constraintlayout.a.c.e.a.f775a) goto L70;
        if (r5 == androidx.constraintlayout.a.c.e.a.f776b) goto L70;
    L77:
        if (r5 != androidx.constraintlayout.a.c.e.a.f777c) goto L104;
        if (r8 == androidx.constraintlayout.a.c.e.a.f776b) goto L83;
        if (r8 != androidx.constraintlayout.a.c.e.a.f775a) goto L104;
    L83:
        if (r1.n == 3) goto L85;
        if (r1.n != 1) goto L92;
        a(r1, androidx.constraintlayout.a.c.e.a.f776b, 0, r8, 0);
        r1.f.g.m = r1.F();
        goto L4
    L92:
        if (r1.n == 2) goto L94;
        if (r1.I[0].f758c == null) goto L102;
        if (r1.I[1].f758c != null) goto L104;
    L102:
        a(r1, androidx.constraintlayout.a.c.e.a.f776b, 0, r8, 0);
        r1.f.g.a(r1.F());
        r1.g.g.a(r1.G());
        r1.f769b = true;
        goto L4
    L94:
        if (r13.K[0] == androidx.constraintlayout.a.c.e.a.f775a) goto L97;
        if (r13.K[0] != androidx.constraintlayout.a.c.e.a.f778d) goto L104;
    L97:
        a(r1, androidx.constraintlayout.a.c.e.a.f775a, (int) ((r1.s * r13.F()) + 0.5f), r8, r1.G());
        r1.f.g.a(r1.F());
        r1.g.g.a(r1.G());
        r1.f769b = true;
        goto L4
    L85:
        if (r8 != androidx.constraintlayout.a.c.e.a.f776b) goto L87;
        a(r1, androidx.constraintlayout.a.c.e.a.f776b, 0, androidx.constraintlayout.a.c.e.a.f776b, 0);
    L87:
        int r9 = r1.G();
        a(r1, androidx.constraintlayout.a.c.e.a.f775a, (int) ((r9 * r1.O) + 0.5f), androidx.constraintlayout.a.c.e.a.f775a, r9);
        r1.f.g.a(r1.F());
        r1.g.g.a(r1.G());
        r1.f769b = true;
    L104:
        if (r8 != androidx.constraintlayout.a.c.e.a.f777c) goto L134;
        if (r5 == androidx.constraintlayout.a.c.e.a.f776b) goto L110;
        if (r5 != androidx.constraintlayout.a.c.e.a.f775a) goto L134;
    L110:
        if (r1.o == 3) goto L112;
        if (r1.o != 1) goto L122;
        a(r1, r5, 0, androidx.constraintlayout.a.c.e.a.f776b, 0);
        r1.g.g.m = r1.G();
        goto L4
    L122:
        if (r1.o == 2) goto L124;
        if (r1.I[2].f758c == null) goto L132;
        if (r1.I[3].f758c != null) goto L134;
    L132:
        a(r1, androidx.constraintlayout.a.c.e.a.f776b, 0, r8, 0);
        r1.f.g.a(r1.F());
        r1.g.g.a(r1.G());
        r1.f769b = true;
        goto L4
    L124:
        if (r13.K[1] == androidx.constraintlayout.a.c.e.a.f775a) goto L127;
        if (r13.K[1] != androidx.constraintlayout.a.c.e.a.f778d) goto L134;
    L127:
        float r2 = r1.v;
        a(r1, r5, r1.F(), androidx.constraintlayout.a.c.e.a.f775a, (int) ((r2 * r13.G()) + 0.5f));
        r1.f.g.a(r1.F());
        r1.g.g.a(r1.G());
        r1.f769b = true;
        goto L4
    L112:
        if (r5 != androidx.constraintlayout.a.c.e.a.f776b) goto L114;
        a(r1, androidx.constraintlayout.a.c.e.a.f776b, 0, androidx.constraintlayout.a.c.e.a.f776b, 0);
    L114:
        int r6 = r1.F();
        float r7 = r1.O;
        if (r1.V() != (-1)) goto L117;
        r7 = 1.0f / r7;
    L117:
        a(r1, androidx.constraintlayout.a.c.e.a.f775a, r6, androidx.constraintlayout.a.c.e.a.f775a, (int) ((r6 * r7) + 0.5f));
        r1.f.g.a(r1.F());
        r1.g.g.a(r1.G());
        r1.f769b = true;
    L134:
        if (r5 != androidx.constraintlayout.a.c.e.a.f777c) goto L4;
        if (r8 != androidx.constraintlayout.a.c.e.a.f777c) goto L4;
        if (r1.n == 1) goto L151;
        if (r1.o == 1) goto L151;
        if (r1.o != 2) goto L4;
        if (r1.n != 2) goto L4;
        if (r13.K[0] != androidx.constraintlayout.a.c.e.a.f775a) goto L4;
        if (r13.K[1] != androidx.constraintlayout.a.c.e.a.f775a) goto L4;
        float r10 = r1.s;
        float r11 = r1.v;
        a(r1, androidx.constraintlayout.a.c.e.a.f775a, (int) ((r10 * r13.F()) + 0.5f), androidx.constraintlayout.a.c.e.a.f775a, (int) ((r11 * r13.G()) + 0.5f));
        r1.f.g.a(r1.F());
        r1.g.g.a(r1.G());
        r1.f769b = true;
    L151:
        a(r1, androidx.constraintlayout.a.c.e.a.f776b, 0, androidx.constraintlayout.a.c.e.a.f776b, 0);
        r1.f.g.m = r1.F();
        r1.g.g.m = r1.G();
    L70:
        if (r8 == androidx.constraintlayout.a.c.e.a.f778d) goto L152;
        if (r8 == androidx.constraintlayout.a.c.e.a.f775a) goto L152;
        if (r8 != androidx.constraintlayout.a.c.e.a.f776b) goto L77;
    L152:
        int r12 = r1.F();
        if (r5 != androidx.constraintlayout.a.c.e.a.f778d) goto L155;
        int r14 = (r13.F() - r1.A.f759d) - r1.C.f759d;
        r5 = androidx.constraintlayout.a.c.e.a.f775a;
    L156:
        int r15 = r1.G();
        if (r8 != androidx.constraintlayout.a.c.e.a.f778d) goto L159;
        int r16 = (r13.G() - r1.B.f759d) - r1.D.f759d;
        androidx.constraintlayout.a.c.e.a r17 = androidx.constraintlayout.a.c.e.a.f775a;
    L160:
        a(r1, r5, r14, r17, r16);
        r1.f.g.a(r1.F());
        r1.g.g.a(r1.G());
        r1.f769b = true;
        goto L4
    L159:
        r17 = r8;
        r16 = r15;
        goto L160
    L155:
        r14 = r12;
        goto L156
    L56:
        if (r1.o != 1) goto L62;
        if (r1.B.f758c != null) goto L60;
    L61:
        r8 = androidx.constraintlayout.a.c.e.a.f776b;
        goto L63
    L60:
        if (r1.D.f758c != null) goto L62;
    L47:
        if (r1.n != 1) goto L53;
        if (r1.A.f758c != null) goto L51;
    L52:
        r3 = androidx.constraintlayout.a.c.e.a.f776b;
        goto L53
    L51:
        if (r1.C.f758c != null) goto L53;
    L7:
        r1.f769b = true;
        goto L4
    L161:
        return false;
    }

    public void a() {
        Iterator<androidx.constraintlayout.a.c.e> r0 = this.f705b.aU.iterator();
    L4:
        if (r0.hasNext() == false) goto L43;
        androidx.constraintlayout.a.c.e r1 = (androidx.constraintlayout.a.c.e) ZeusTransformUtils.preCheckCast(r0.next(), androidx.constraintlayout.a.c.e.class, "com.obric.aiagent.plugin");
        if (r1.f769b == true) goto L4;
        boolean r3 = false;
        androidx.constraintlayout.a.c.e.a r8 = r1.K[0];
        androidx.constraintlayout.a.c.e.a r10 = r1.K[1];
        int r2 = r1.n;
        int r4 = r1.o;
        if (r8 != androidx.constraintlayout.a.c.e.a.f776b) goto L11;
    L15:
        boolean r5 = true;
    L17:
        if (r10 != androidx.constraintlayout.a.c.e.a.f776b) goto L19;
    L21:
        r3 = true;
    L22:
        boolean r6 = r1.f.g.j;
        boolean r7 = r1.g.g.j;
        if (r6 == false) goto L26;
        if (r7 == false) goto L26;
        a(r1, androidx.constraintlayout.a.c.e.a.f775a, r1.f.g.g, androidx.constraintlayout.a.c.e.a.f775a, r1.g.g.g);
        r1.f769b = true;
    L39:
        if (r1.f769b == false) goto L4;
        if (r1.g.f730b == null) goto L4;
        r1.g.f730b.a(r1.S());
    L26:
        if (r6 == false) goto L32;
        if (r3 == false) goto L32;
        a(r1, androidx.constraintlayout.a.c.e.a.f775a, r1.f.g.g, androidx.constraintlayout.a.c.e.a.f776b, r1.g.g.g);
        if (r10 != androidx.constraintlayout.a.c.e.a.f777c) goto L31;
        r1.g.g.m = r1.G();
        goto L39
    L31:
        r1.g.g.a(r1.G());
        r1.f769b = true;
    L32:
        if (r7 == false) goto L39;
        if (r5 == false) goto L39;
        a(r1, androidx.constraintlayout.a.c.e.a.f776b, r1.f.g.g, androidx.constraintlayout.a.c.e.a.f775a, r1.g.g.g);
        if (r8 != androidx.constraintlayout.a.c.e.a.f777c) goto L37;
        r1.f.g.m = r1.F();
        goto L39
    L37:
        r1.f.g.a(r1.F());
        r1.f769b = true;
        goto L39
    L19:
        if (r10 != androidx.constraintlayout.a.c.e.a.f777c) goto L22;
        if (r4 != 1) goto L22;
    L11:
        if (r8 != androidx.constraintlayout.a.c.e.a.f777c) goto L14;
        if (r2 == 1) goto L15;
    L14:
        r5 = false;
        goto L17
    }

    public void b() {
        this.f706c = true;
    }

    public void c() {
        this.f707d = true;
    }

    public void d() {
        a(this.f);
        this.f704a.clear();
        m.f724a = 0;
        a(this.f705b.f, 0, this.f704a);
        a(this.f705b.g, 1, this.f704a);
        this.f706c = false;
    }

    public void a(ArrayList<p> r6) {
        r6.clear();
        this.f708e.f.c();
        this.f708e.g.c();
        r6.add(this.f708e.f);
        r6.add(this.f708e.g);
        Iterator<androidx.constraintlayout.a.c.e> r0 = this.f708e.aU.iterator();
        HashSet r1 = null;
    L4:
        if (r0.hasNext() == false) goto L29;
        androidx.constraintlayout.a.c.e r2 = (androidx.constraintlayout.a.c.e) ZeusTransformUtils.preCheckCast(r0.next(), androidx.constraintlayout.a.c.e.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r2, androidx.constraintlayout.a.c.h.class) == true) goto L7;
        if (r2.ac() == true) goto L11;
        r6.add(r2.f);
    L18:
        if (r2.ad() == true) goto L20;
        r6.add(r2.g);
    L27:
        if (ZeusTransformUtils.instanceOf(r2, androidx.constraintlayout.a.c.j.class) == false) goto L4;
        r6.add(new k(r2));
        goto L4
    L20:
        if (r2.f772e != null) goto L22;
        r2.f772e = new c(r2, 1);
    L22:
        if (r1 != null) goto L24;
        r1 = new HashSet();
    L24:
        r1.add(r2.f772e);
        goto L27
    L11:
        if (r2.f771d != null) goto L13;
        r2.f771d = new c(r2, 0);
    L13:
        if (r1 != null) goto L15;
        r1 = new HashSet();
    L15:
        r1.add(r2.f771d);
        goto L18
    L7:
        r6.add(new j(r2));
        goto L4
    L29:
        if (r1 == null) goto L31;
        r6.addAll(r1);
    L31:
        Iterator<p> r3 = r6.iterator();
    L33:
        if (r3.hasNext() == false) goto L35;
        ((p) ZeusTransformUtils.preCheckCast(r3.next(), p.class, "com.obric.aiagent.plugin")).c();
        goto L33
    L35:
        Iterator<p> r7 = r6.iterator();
    L37:
        if (r7.hasNext() == false) goto L42;
        p r4 = (p) ZeusTransformUtils.preCheckCast(r7.next(), p.class, "com.obric.aiagent.plugin");
        if (r4.f743d == this.f708e) goto L37;
        r4.f();
        goto L37
    }

    private void a(f r10, int r11, int r12, f r13, ArrayList<m> r14, m r15) {
        p r16 = r10.f712d;
        if (r16.f744e == null) goto L5;
        return;
    L5:
        if (r16 != this.f705b.f) goto L7;
        return;
    L7:
        if (r16 == this.f705b.g) goto L80;
        if (r15 != null) goto L11;
        r15 = new m(r16, r12);
        r14.add(r15);
    L11:
        r16.f744e = r15;
        r15.a(r16);
        Iterator<d> r17 = r16.j.k.iterator();
    L13:
        if (r17.hasNext() == false) goto L17;
        d r0 = (d) ZeusTransformUtils.preCheckCast(r17.next(), d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r0, f.class) == false) goto L13;
        a((f) ZeusTransformUtils.preCheckCast(r0, f.class, "com.obric.aiagent.plugin"), r11, 0, r13, r14, r15);
        goto L13
    L17:
        Iterator<d> r18 = r16.k.k.iterator();
    L19:
        if (r18.hasNext() == false) goto L24;
        d r1 = (d) ZeusTransformUtils.preCheckCast(r18.next(), d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r1, f.class) == false) goto L19;
        a((f) ZeusTransformUtils.preCheckCast(r1, f.class, "com.obric.aiagent.plugin"), r11, 1, r13, r14, r15);
        goto L19
    L24:
        if (r11 == 1) goto L26;
    L33:
        Iterator<f> r8 = r16.j.l.iterator();
    L35:
        if (r8.hasNext() == false) goto L40;
        f r2 = (f) ZeusTransformUtils.preCheckCast(r8.next(), f.class, "com.obric.aiagent.plugin");
        if (r2 != r13) goto L39;
        r15.f726c = true;
    L39:
        a(r2, r11, 0, r13, r14, r15);
        goto L35
    L40:
        Iterator<f> r9 = r16.k.l.iterator();
    L42:
        if (r9.hasNext() == false) goto L47;
        f r3 = (f) ZeusTransformUtils.preCheckCast(r9.next(), f.class, "com.obric.aiagent.plugin");
        if (r3 != r13) goto L46;
        r15.f726c = true;
    L46:
        a(r3, r11, 1, r13, r14, r15);
        goto L42
    L47:
        if (r11 == 1) goto L49;
        return;
    L49:
        if (ZeusTransformUtils.instanceOf(r16, n.class) == false) goto L79;
        Iterator<f> r19 = ((n) ZeusTransformUtils.preCheckCast(r16, n.class, "com.obric.aiagent.plugin")).f729a.l.iterator();
    L52:
        if (r19.hasNext() == false) goto L81;
        a((f) ZeusTransformUtils.preCheckCast(r19.next(), f.class, "com.obric.aiagent.plugin"), r11, 2, r13, r14, r15);
        goto L52
    L81:
        return;
    L79:
        return;
    L26:
        if (ZeusTransformUtils.instanceOf(r16, n.class) == false) goto L33;
        Iterator<d> r20 = ((n) ZeusTransformUtils.preCheckCast(r16, n.class, "com.obric.aiagent.plugin")).f729a.k.iterator();
    L29:
        if (r20.hasNext() == false) goto L33;
        d r4 = (d) ZeusTransformUtils.preCheckCast(r20.next(), d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, f.class) == false) goto L29;
        a((f) ZeusTransformUtils.preCheckCast(r4, f.class, "com.obric.aiagent.plugin"), r11, 2, r13, r14, r15);
        goto L29
    }

    private void a(p r11, int r12, ArrayList<m> r13) {
        Iterator<d> r0 = r11.j.k.iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        d r1 = (d) ZeusTransformUtils.preCheckCast(r0.next(), d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r1, f.class) == true) goto L7;
        if (ZeusTransformUtils.instanceOf(r1, p.class) == false) goto L4;
        a(((p) ZeusTransformUtils.preCheckCast(r1, p.class, "com.obric.aiagent.plugin")).j, r12, 0, r11.k, r13, null);
        goto L4
    L7:
        a((f) ZeusTransformUtils.preCheckCast(r1, f.class, "com.obric.aiagent.plugin"), r12, 0, r11.k, r13, null);
        goto L4
    L11:
        Iterator<d> r2 = r11.k.k.iterator();
    L13:
        if (r2.hasNext() == false) goto L21;
        d r3 = (d) ZeusTransformUtils.preCheckCast(r2.next(), d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r3, f.class) == true) goto L16;
        if (ZeusTransformUtils.instanceOf(r3, p.class) == false) goto L13;
        a(((p) ZeusTransformUtils.preCheckCast(r3, p.class, "com.obric.aiagent.plugin")).k, r12, 1, r11.j, r13, null);
        goto L13
    L16:
        a((f) ZeusTransformUtils.preCheckCast(r3, f.class, "com.obric.aiagent.plugin"), r12, 1, r11.j, r13, null);
        goto L13
    L21:
        if (r12 != 1) goto L28;
        Iterator<d> r14 = ((n) ZeusTransformUtils.preCheckCast(r11, n.class, "com.obric.aiagent.plugin")).f729a.k.iterator();
    L24:
        if (r14.hasNext() == false) goto L50;
        d r4 = (d) ZeusTransformUtils.preCheckCast(r14.next(), d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, f.class) == false) goto L24;
        a((f) ZeusTransformUtils.preCheckCast(r4, f.class, "com.obric.aiagent.plugin"), r12, 2, null, r13, null);
        goto L24
    L50:
        return;
    }
}
