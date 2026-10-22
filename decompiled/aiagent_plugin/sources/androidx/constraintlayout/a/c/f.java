package androidx.constraintlayout.a.c;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: compiled from: ConstraintWidgetContainer.java */
/* JADX INFO: loaded from: classes.dex */
public class f extends n {
    static int aT;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    androidx.constraintlayout.a.c.a.b f780a;
    public androidx.constraintlayout.a.e aA;
    protected androidx.constraintlayout.a.d aB;
    int aC;
    int aD;
    int aE;
    int aF;
    public int aG;
    public int aH;
    c[] aI;
    c[] aJ;
    public boolean aK;
    public boolean aL;
    public boolean aM;
    public int aN;
    public int aO;
    public boolean aP;
    int aQ;
    HashSet<e> aR;
    public androidx.constraintlayout.a.c.a.b.a aS;
    private int aV;
    private boolean aW;
    private int aX;
    private boolean aY;
    private boolean aZ;
    public androidx.constraintlayout.a.c.a.e ay;
    protected androidx.constraintlayout.a.c.a.b.InterfaceC0012b az;
    private WeakReference<d> ba;
    private WeakReference<d> bb;
    private WeakReference<d> bc;
    private WeakReference<d> bd;

    static {
    }

    public boolean ai() {
        return false;
    }

    @Override // androidx.constraintlayout.a.c.e
    public String getType() {
        return "ConstraintLayout";
    }

    public void b() {
        this.ay.b();
    }

    public void c() {
        this.ay.c();
    }

    public boolean a(boolean r1) {
        return this.ay.a(r1);
    }

    public boolean g(boolean r1) {
        return this.ay.b(r1);
    }

    public boolean a(boolean r1, int r2) {
        return this.ay.a(r1, r2);
    }

    public long a(int r12, int r13, int r14, int r15, int r16, int r17, int r18, int r19, int r20) {
        this.aC = r19;
        this.aD = r20;
        return this.f780a.a(this, r12, r19, r20, r13, r14, r15, r16, r17, r18);
    }

    public void f() {
        this.f780a.a(this);
    }

    public void a(androidx.constraintlayout.a.c.a.b.InterfaceC0012b r3) {
        androidx.constraintlayout.a.c.a.b.InterfaceC0012b r4 = (androidx.constraintlayout.a.c.a.b.InterfaceC0012b) ZeusTransformUtils.wrapperContextForParams(r3, androidx.constraintlayout.a.c.a.b.InterfaceC0012b.class, "com.obric.aiagent.plugin");
        this.az = r4;
        this.ay.a(r4);
    }

    public androidx.constraintlayout.a.c.a.b.InterfaceC0012b g() {
        return this.az;
    }

    public void a(androidx.constraintlayout.a.e r1) {
        this.aA = r1;
        this.aB.a(r1);
    }

    public f() {
        this.f780a = new androidx.constraintlayout.a.c.a.b(this);
        this.ay = new androidx.constraintlayout.a.c.a.e(this);
        this.az = null;
        this.aW = false;
        this.aB = new androidx.constraintlayout.a.d();
        this.aG = 0;
        this.aH = 0;
        this.aI = new c[4];
        this.aJ = new c[4];
        this.aK = false;
        this.aL = false;
        this.aM = false;
        this.aN = 0;
        this.aO = 0;
        this.aX = 257;
        this.aP = false;
        this.aY = false;
        this.aZ = false;
        this.aQ = 0;
        this.ba = null;
        this.bb = null;
        this.bc = null;
        this.bd = null;
        this.aR = new HashSet();
        this.aS = new androidx.constraintlayout.a.c.a.b.a();
    }

    public void a(int r1) {
        this.aX = r1;
        androidx.constraintlayout.a.d.f790a = b(512);
    }

    public int h() {
        return this.aX;
    }

    public boolean b(int r1) {
        if ((this.aX & r1) != r1) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.constraintlayout.a.c.n, androidx.constraintlayout.a.c.e
    public void w() {
        this.aB.b();
        this.aC = 0;
        this.aE = 0;
        this.aD = 0;
        this.aF = 0;
        this.aP = false;
        super.w();
    }

    public boolean i() {
        return this.aY;
    }

    public boolean af() {
        return this.aZ;
    }

    void a(d r5) {
        WeakReference<d> r0 = this.ba;
        if (r0 != null) goto L5;
    L8:
        this.ba = new WeakReference(r5);
        return;
    L5:
        if (r0.get() == null) goto L8;
        if (r5.d() > ((d) ZeusTransformUtils.preCheckCast(this.ba.get(), d.class, "com.obric.aiagent.plugin")).d()) goto L8;
    }

    public void b(d r5) {
        WeakReference<d> r0 = this.bb;
        if (r0 != null) goto L5;
    L8:
        this.bb = new WeakReference(r5);
        return;
    L5:
        if (r0.get() == null) goto L8;
        if (r5.d() > ((d) ZeusTransformUtils.preCheckCast(this.bb.get(), d.class, "com.obric.aiagent.plugin")).d()) goto L8;
    }

    void c(d r5) {
        WeakReference<d> r0 = this.bc;
        if (r0 != null) goto L5;
    L8:
        this.bc = new WeakReference(r5);
        return;
    L5:
        if (r0.get() == null) goto L8;
        if (r5.d() > ((d) ZeusTransformUtils.preCheckCast(this.bc.get(), d.class, "com.obric.aiagent.plugin")).d()) goto L8;
    }

    public void d(d r5) {
        WeakReference<d> r0 = this.bd;
        if (r0 != null) goto L5;
    L8:
        this.bd = new WeakReference(r5);
        return;
    L5:
        if (r0.get() == null) goto L8;
        if (r5.d() > ((d) ZeusTransformUtils.preCheckCast(this.bd.get(), d.class, "com.obric.aiagent.plugin")).d()) goto L8;
    }

    private void a(d r3, androidx.constraintlayout.a.h r4) {
        androidx.constraintlayout.a.h r5 = this.aB.a(r3);
        this.aB.a(r5, r4, 0, 5);
    }

    private void b(d r3, androidx.constraintlayout.a.h r4) {
        androidx.constraintlayout.a.h r5 = this.aB.a(r3);
        this.aB.a(r4, r5, 0, 5);
    }

    public boolean b(androidx.constraintlayout.a.d r14) {
        boolean r0 = b(64);
        a(r14, r0);
        int r1 = this.aU.size();
        int r3 = 0;
        boolean r4 = false;
    L4:
        if (r3 >= r1) goto L9;
        e r5 = (e) ZeusTransformUtils.preCheckCast(this.aU.get(r3), e.class, "com.obric.aiagent.plugin");
        r5.a(0, false);
        r5.a(1, false);
        if (ZeusTransformUtils.instanceOf(r5, a.class) == false) goto L8;
        r4 = true;
    L8:
        r3 = r3 + 1;
        goto L4
    L9:
        if (r4 == false) goto L16;
        int r6 = 0;
    L11:
        if (r6 >= r1) goto L16;
        e r7 = (e) ZeusTransformUtils.preCheckCast(this.aU.get(r6), e.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r7, a.class) == false) goto L15;
        ((a) ZeusTransformUtils.preCheckCast(r7, a.class, "com.obric.aiagent.plugin")).f();
    L15:
        r6 = r6 + 1;
    L16:
        this.aR.clear();
        int r8 = 0;
    L17:
        if (r8 >= r1) goto L26;
        e r9 = (e) ZeusTransformUtils.preCheckCast(this.aU.get(r8), e.class, "com.obric.aiagent.plugin");
        if (r9.ae() == false) goto L24;
        if (ZeusTransformUtils.instanceOf(r9, m.class) == false) goto L23;
        this.aR.add(r9);
        goto L24
    L23:
        r9.a(r14, r0);
    L24:
        r8 = r8 + 1;
    L26:
        if (this.aR.size() <= 0) goto L41;
        int r10 = this.aR.size();
        Iterator<e> r11 = this.aR.iterator();
    L29:
        if (r11.hasNext() == false) goto L34;
        m r12 = (m) ZeusTransformUtils.preCheckCast((e) ZeusTransformUtils.preCheckCast(r11.next(), e.class, "com.obric.aiagent.plugin"), m.class, "com.obric.aiagent.plugin");
        if (r12.a(this.aR) == false) goto L29;
        r12.a(r14, r0);
        this.aR.remove(r12);
    L34:
        if (r10 != this.aR.size()) goto L26;
        Iterator<e> r13 = this.aR.iterator();
    L37:
        if (r13.hasNext() == false) goto L39;
        ((e) ZeusTransformUtils.preCheckCast(r13.next(), e.class, "com.obric.aiagent.plugin")).a(r14, r0);
        goto L37
    L39:
        this.aR.clear();
        goto L26
    L41:
        if (androidx.constraintlayout.a.d.f790a == false) goto L56;
        HashSet<e> r15 = new HashSet();
        int r16 = 0;
    L43:
        if (r16 >= r1) goto L49;
        e r17 = (e) ZeusTransformUtils.preCheckCast(this.aU.get(r16), e.class, "com.obric.aiagent.plugin");
        if (r17.ae() == true) goto L47;
        r15.add(r17);
    L47:
        r16 = r16 + 1;
        goto L43
    L49:
        if (aa() != e.a.f776b) goto L51;
        int r18 = 0;
    L52:
        a(this, r14, r15, r18, false);
        Iterator<e> r2 = r15.iterator();
    L54:
        if (r2.hasNext() == false) goto L77;
        e r19 = (e) ZeusTransformUtils.preCheckCast(r2.next(), e.class, "com.obric.aiagent.plugin");
        k.a(this, r14, r19);
        r19.a(r14, r0);
    L77:
        if (this.aG <= 0) goto L80;
        b.a(this, r14, null, 0);
    L80:
        if (this.aH <= 0) goto L82;
        b.a(this, r14, null, 1);
    L82:
        return true;
    L51:
        r18 = 1;
        goto L52
    L56:
        int r20 = 0;
    L57:
        if (r20 >= r1) goto L77;
        e r21 = (e) ZeusTransformUtils.preCheckCast(this.aU.get(r20), e.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r21, f.class) == false) goto L72;
        e.a r22 = r21.K[0];
        e.a r23 = r21.K[1];
        if (r22 != e.a.f776b) goto L64;
        r21.a(e.a.f775a);
    L64:
        if (r23 != e.a.f776b) goto L66;
        r21.b(e.a.f775a);
    L66:
        r21.a(r14, r0);
        if (r22 != e.a.f776b) goto L70;
        r21.a(r22);
    L70:
        if (r23 != e.a.f776b) goto L75;
        r21.b(r23);
    L75:
        r20 = r20 + 1;
        goto L57
    L72:
        k.a(this, r14, r21);
        if (r21.ae() == true) goto L75;
        r21.a(r14, r0);
        goto L75
    }

    public boolean a(androidx.constraintlayout.a.d r7, boolean[] r8) {
        int r1 = 0;
        r8[2] = false;
        boolean r9 = b(64);
        b(r7, r9);
        int r0 = this.aU.size();
        boolean r2 = false;
    L3:
        if (r1 >= r0) goto L8;
        e r3 = (e) ZeusTransformUtils.preCheckCast(this.aU.get(r1), e.class, "com.obric.aiagent.plugin");
        r3.b(r7, r9);
        if (r3.y() == false) goto L7;
        r2 = true;
    L7:
        r1 = r1 + 1;
        goto L3
    L8:
        return r2;
    }

    @Override // androidx.constraintlayout.a.c.e
    public void a(boolean r6, boolean r7) {
        super.a(r6, r7);
        int r0 = this.aU.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        ((e) ZeusTransformUtils.preCheckCast(this.aU.get(r1), e.class, "com.obric.aiagent.plugin")).a(r6, r7);
        r1 = r1 + 1;
        goto L3
    }

    public void h(boolean r1) {
        this.aW = r1;
    }

    public boolean ag() {
        return this.aW;
    }

    public static boolean a(int r5, e r6, androidx.constraintlayout.a.c.a.b.InterfaceC0012b r7, androidx.constraintlayout.a.c.a.b.a r8, int r9) {
        androidx.constraintlayout.a.c.a.b.InterfaceC0012b r10 = (androidx.constraintlayout.a.c.a.b.InterfaceC0012b) ZeusTransformUtils.wrapperContextForParams(r7, androidx.constraintlayout.a.c.a.b.InterfaceC0012b.class, "com.obric.aiagent.plugin");
        if (r10 != null) goto L6;
        return false;
    L6:
        if (r6.B() != 8) goto L8;
    L87:
        r8.h = 0;
        r8.i = 0;
        return false;
    L8:
        if (ZeusTransformUtils.instanceOf(r6, h.class) == true) goto L87;
        if (ZeusTransformUtils.instanceOf(r6, a.class) == true) goto L87;
        r8.f700d = r6.aa();
        r8.f701e = r6.ab();
        r8.f = r6.F();
        r8.g = r6.G();
        r8.l = false;
        r8.m = r9;
        if (r8.f700d != e.a.f777c) goto L15;
        boolean r11 = true;
    L17:
        if (r8.f701e != e.a.f777c) goto L19;
        boolean r0 = true;
    L21:
        if (r11 == true) goto L23;
    L25:
        boolean r3 = false;
    L26:
        if (r0 == true) goto L28;
    L30:
        boolean r2 = false;
    L31:
        if (r11 == true) goto L33;
    L43:
        if (r0 == false) goto L56;
        if (r6.g(1) == false) goto L56;
        if (r6.o != 0) goto L56;
        if (r2 == true) goto L56;
        r8.f701e = e.a.f776b;
        if (r11 == true) goto L52;
    L54:
        r0 = false;
        goto L56
    L52:
        if (r6.n != 0) goto L54;
        r8.f701e = e.a.f775a;
    L56:
        if (r6.d() == false) goto L59;
        r8.f700d = e.a.f775a;
        r11 = false;
    L59:
        if (r6.e() == false) goto L62;
        r8.f701e = e.a.f775a;
        r0 = false;
    L62:
        if (r3 == true) goto L64;
    L72:
        if (r2 == true) goto L74;
    L85:
        r10.a(r6, r8);
        r6.q(r8.h);
        r6.r(r8.i);
        r6.c(r8.k);
        r6.u(r8.j);
        r8.m = androidx.constraintlayout.a.c.a.b.a.f697a;
        return r8.l;
    L74:
        if (r6.p[1] != 4) goto L76;
        r8.f701e = e.a.f775a;
        goto L85
    L76:
        if (r11 == true) goto L85;
        if (r8.f700d != e.a.f775a) goto L80;
        int r12 = r8.f;
    L81:
        r8.f701e = e.a.f775a;
        if (r6.V() != (-1)) goto L84;
        r8.g = (int) (r12 / r6.U());
        goto L85
    L84:
        r8.g = (int) (r6.U() * r12);
        goto L85
    L80:
        r8.f701e = e.a.f776b;
        r10.a(r6, r8);
        r12 = r8.h;
        goto L81
    L64:
        if (r6.p[0] != 4) goto L66;
        r8.f700d = e.a.f775a;
        goto L72
    L66:
        if (r0 == true) goto L72;
        if (r8.f701e != e.a.f775a) goto L70;
        int r13 = r8.g;
    L71:
        r8.f700d = e.a.f775a;
        r8.f = (int) (r6.U() * r13);
        goto L72
    L70:
        r8.f700d = e.a.f776b;
        r10.a(r6, r8);
        r13 = r8.i;
        goto L71
    L33:
        if (r6.g(0) == false) goto L43;
        if (r6.n != 0) goto L43;
        if (r3 == true) goto L43;
        r8.f700d = e.a.f776b;
        if (r0 == true) goto L40;
    L42:
        r11 = false;
        goto L43
    L40:
        if (r6.o != 0) goto L42;
        r8.f700d = e.a.f775a;
        goto L42
    L28:
        if (r6.O <= 0.0f) goto L30;
        r2 = true;
        goto L31
    L23:
        if (r6.O <= 0.0f) goto L25;
        r3 = true;
        goto L26
    L19:
        r0 = false;
        goto L21
    L15:
        r11 = false;
        goto L17
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v13 */
    /* JADX WARN: Type inference failed for: r11v14 */
    /* JADX WARN: Type inference failed for: r11v15 */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v35 */
    /* JADX WARN: Type inference failed for: r11v36 */
    /* JADX WARN: Type inference failed for: r11v37 */
    /* JADX WARN: Type inference failed for: r11v38 */
    /* JADX WARN: Type inference failed for: r11v39 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v40 */
    /* JADX WARN: Type inference failed for: r11v41 */
    /* JADX WARN: Type inference failed for: r11v42 */
    /* JADX WARN: Type inference failed for: r11v43 */
    /* JADX WARN: Type inference failed for: r11v44 */
    /* JADX WARN: Type inference failed for: r11v45 */
    /* JADX WARN: Type inference failed for: r11v46 */
    /* JADX WARN: Type inference failed for: r11v47 */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r11v6 */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r11v8 */
    /* JADX WARN: Type inference failed for: r11v9 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8, types: [boolean] */
    @Override // androidx.constraintlayout.a.c.n
    public void ah() {
        this.Q = 0;
        this.R = 0;
        this.aY = false;
        this.aZ = false;
        int r3 = this.aU.size();
        int r0 = Math.max(0, F());
        int r4 = Math.max(0, G());
        e.a r5 = this.K[1];
        e.a r7 = this.K[0];
        androidx.constraintlayout.a.e r8 = this.aA;
        if (r8 == null) goto L6;
        r8.D++;
    L6:
        if (this.aV != 0) goto L35;
        if (k.a(this.aX, 1) == false) goto L35;
        androidx.constraintlayout.a.c.a.h.a(this, g());
        int r9 = 0;
    L10:
        if (r9 >= r3) goto L35;
        e r10 = (e) ZeusTransformUtils.preCheckCast(this.aU.get(r9), e.class, "com.obric.aiagent.plugin");
        if (r10.t() == false) goto L33;
        if (ZeusTransformUtils.instanceOf(r10, h.class) == true) goto L33;
        if (ZeusTransformUtils.instanceOf(r10, a.class) == true) goto L33;
        if (ZeusTransformUtils.instanceOf(r10, m.class) == true) goto L33;
        if (r10.p() == true) goto L33;
        e.a r11 = r10.x(0);
        e.a r12 = r10.x(1);
        if (r11 == e.a.f777c) goto L24;
    L30:
        boolean r13 = false;
    L31:
        if (r13 == true) goto L33;
        a(0, r10, this.az, new androidx.constraintlayout.a.c.a.b.a(), androidx.constraintlayout.a.c.a.b.a.f697a);
        goto L33
    L24:
        if (r10.n == 1) goto L30;
        if (r12 != e.a.f777c) goto L30;
        if (r10.o == 1) goto L30;
        r13 = true;
    L33:
        r9 = r9 + 1;
    L35:
        if (r3 > 2) goto L37;
    L59:
        int r14 = r4;
        int r6 = r0;
        boolean r1 = false;
    L61:
        if (b(64) == false) goto L63;
    L66:
        boolean r15 = true;
    L67:
        this.aB.j = false;
        this.aB.k = false;
        if (this.aX == 0) goto L71;
        if (r15 == false) goto L71;
        this.aB.k = true;
    L71:
        ArrayList<e> r16 = this.aU;
        if (aa() != e.a.f776b) goto L74;
    L77:
        boolean r17 = true;
    L78:
        am();
        int r18 = 0;
    L79:
        if (r18 >= r3) goto L84;
        e r2 = (e) ZeusTransformUtils.preCheckCast(this.aU.get(r18), e.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r2, n.class) == false) goto L83;
        ((n) ZeusTransformUtils.preCheckCast(r2, n.class, "com.obric.aiagent.plugin")).ah();
    L83:
        r18 = r18 + 1;
        goto L79
    L84:
        boolean r19 = b(64);
        ?? r110 = r1;
        boolean r111 = true;
        int r20 = 0;
    L85:
        if (r111 == false) goto L165;
        int r112 = r20 + 1;
        this.aB.b();     // Catch: Exception -> L113
        am();     // Catch: Exception -> L113
        a(this.aB);     // Catch: Exception -> L113
        int r21 = 0;
    L88:
        if (r21 >= r3) goto L90;
        ((e) ZeusTransformUtils.preCheckCast(this.aU.get(r21), e.class, "com.obric.aiagent.plugin")).a(this.aB);     // Catch: Exception -> L113
        r21 = r21 + 1;     // Catch: Exception -> L113
        goto L88
    L90:
        boolean r113 = b(this.aB);     // Catch: Exception -> L113
        WeakReference<d> r22 = this.ba;     // Catch: Exception -> L113
        if (r22 != null) goto L93;
    L95:
        WeakReference<d> r23 = this.bc;     // Catch: Exception -> L113
        if (r23 != null) goto L98;
    L100:
        WeakReference<d> r24 = this.bb;     // Catch: Exception -> L113
        if (r24 != null) goto L103;
    L105:
        WeakReference<d> r25 = this.bd;     // Catch: Exception -> L113
        if (r25 != null) goto L108;
    L110:
        if (r113 == false) goto L115;
        this.aB.f();     // Catch: Exception -> L113
    L115:
        if (r113 == false) goto L117;
        boolean r26 = a(this.aB, k.f788a);
    L122:
        if (r17 == false) goto L139;
        if (r112 >= 8) goto L139;
        if (k.f788a[2] == false) goto L139;
        int r27 = 0;
        int r28 = 0;
        int r114 = 0;
    L127:
        if (r28 >= r3) goto L129;
        boolean r115 = r26;
        e r29 = (e) ZeusTransformUtils.preCheckCast(this.aU.get(r28), e.class, "com.obric.aiagent.plugin");
        r114 = Math.max(r114, r29.Q + r29.F());
        r27 = Math.max(r27, r29.R + r29.G());
        r28 = r28 + 1;
        r26 = r115;
        r19 = r19;
        goto L127
    L129:
        boolean r116 = r26;
        boolean r117 = r19;
        int r30 = Math.max(this.X, r114);
        int r31 = Math.max(this.Y, r27);
        ?? r118 = r110;
        if (r7 != e.a.f776b) goto L134;
        r118 = r110;
        if (F() >= r30) goto L134;
        q(r30);
        this.K[0] = e.a.f776b;
        r118 = 1;
        r116 = true;
    L134:
        ?? r119 = r118;
        if (r5 != e.a.f776b) goto L140;
        r119 = r118;
        if (G() >= r31) goto L140;
        r(r31);
        this.K[1] = e.a.f776b;
        r119 = 1;
        r116 = true;
    L140:
        int r32 = Math.max(this.X, F());
        ?? r120 = r119;
        if (r32 <= F()) goto L143;
        q(r32);
        this.K[0] = e.a.f775a;
        r120 = 1;
        r116 = true;
    L143:
        int r33 = Math.max(this.Y, G());
        if (r33 <= G()) goto L146;
        r(r33);
        ?? r34 = 1;
        this.K[1] = e.a.f775a;
        ?? r121 = 1;
        r116 = true;
    L147:
        if (r121 != 0) goto L160;
        r121 = r121;
        r121 = r121;
        if (this.K[0] != e.a.f776b) goto L155;
        if (r6 <= 0) goto L155;
        r121 = r121;
        if (F() <= r6) goto L155;
        this.aY = r34;
        this.K[0] = e.a.f775a;
        q(r6);
        ?? r122 = r34;
        r116 = r122 == true ? 1 : 0;
        r121 = r122;
    L155:
        if (this.K[r34] != e.a.f776b) goto L160;
        if (r14 <= 0) goto L160;
        if (G() <= r14) goto L160;
        this.aZ = r34;
        this.K[r34] = e.a.f775a;
        r(r14);
        int r35 = 8;
        boolean r36 = true;
        ?? r123 = 1;
    L161:
        if (r112 <= r35) goto L163;
        r111 = false;
    L164:
        r20 = r112;
        r19 = r117;
        r110 = r123;
        goto L85
    L163:
        r111 = r36;
    L160:
        r36 = r116;
        r35 = 8;
        r123 = r121;
        goto L161
    L146:
        r34 = 1;
        r121 = r120;
    L139:
        r116 = r26;
        r117 = r19;
        r119 = r110;
        goto L140
    L117:
        b(this.aB, r19);
        int r37 = 0;
    L118:
        if (r37 >= r3) goto L120;
        ((e) ZeusTransformUtils.preCheckCast(this.aU.get(r37), e.class, "com.obric.aiagent.plugin")).b(this.aB, r19);
        r37 = r37 + 1;
        goto L118
    L120:
        r26 = false;
        goto L122
    L108:
        if (r25.get() == null) goto L110;
        b((d) ZeusTransformUtils.preCheckCast(this.bd.get(), d.class, "com.obric.aiagent.plugin"), this.aB.a(this.C));     // Catch: Exception -> L113
        this.bd = null;     // Catch: Exception -> L113
        goto L110
    L103:
        if (r24.get() == null) goto L105;
        a((d) ZeusTransformUtils.preCheckCast(this.bb.get(), d.class, "com.obric.aiagent.plugin"), this.aB.a(this.A));     // Catch: Exception -> L113
        this.bb = null;     // Catch: Exception -> L113
        goto L105
    L98:
        if (r23.get() == null) goto L100;
        b((d) ZeusTransformUtils.preCheckCast(this.bc.get(), d.class, "com.obric.aiagent.plugin"), this.aB.a(this.D));     // Catch: Exception -> L113
        this.bc = null;     // Catch: Exception -> L113
        goto L100
    L93:
        if (r22.get() == null) goto L95;
        a((d) ZeusTransformUtils.preCheckCast(this.ba.get(), d.class, "com.obric.aiagent.plugin"), this.aB.a(this.B));     // Catch: Exception -> L113
        this.ba = null;     // Catch: Exception -> L113
    L113:
        e = move-exception;
        e.printStackTrace();
        System.out.println("EXCEPTION : " + e);
        r113 = r111 ? 1 : 0;
        goto L115
    L165:
        this.aU = (ArrayList) ZeusTransformUtils.preCheckCast(r16, ArrayList.class, "com.obric.aiagent.plugin");
        if (r110 == 0) goto L168;
        this.K[0] = r7;
        this.K[1] = r5;
    L168:
        a(this.aB.g());
        return;
    L74:
        if (ab() == e.a.f776b) goto L77;
        r17 = false;
        goto L78
    L63:
        if (b(128) == true) goto L66;
        r15 = false;
        goto L67
    L37:
        if (r7 == e.a.f776b) goto L41;
        if (r5 != e.a.f776b) goto L59;
    L41:
        if (k.a(this.aX, 1024) == false) goto L59;
        if (androidx.constraintlayout.a.c.a.i.a(this, g()) == false) goto L59;
        if (r7 != e.a.f776b) goto L52;
        if (r0 >= F()) goto L50;
        if (r0 <= 0) goto L50;
        q(r0);
        this.aY = true;
    L50:
        r0 = F();
    L52:
        if (r5 == e.a.f776b) goto L54;
    L58:
        r14 = r4;
        r6 = r0;
        r1 = true;
        goto L61
    L54:
        if (r4 >= G()) goto L57;
        if (r4 <= 0) goto L57;
        r(r4);
        this.aZ = true;
    L57:
        r4 = G();
        goto L58
    }

    public androidx.constraintlayout.a.d aj() {
        return this.aB;
    }

    private void am() {
        this.aG = 0;
        this.aH = 0;
    }

    void a(e r2, int r3) {
        if (r3 != 0) goto L5;
        d(r2);
        return;
    L5:
        if (r3 != 1) goto L9;
        e(r2);
        return;
    }

    private void d(e r6) {
        int r0 = this.aG + 1;
        c[] r1 = this.aJ;
        if (r0 < r1.length) goto L5;
        this.aJ = (c[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r1, r1.length * 2), c[].class, "com.obric.aiagent.plugin");
    L5:
        this.aJ[this.aG] = new c(r6, 0, ag());
        this.aG++;
    }

    private void e(e r6) {
        int r0 = this.aH + 1;
        c[] r2 = this.aI;
        if (r0 < r2.length) goto L5;
        this.aI = (c[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r2, r2.length * 2), c[].class, "com.obric.aiagent.plugin");
    L5:
        this.aI[this.aH] = new c(r6, 1, ag());
        this.aH++;
    }

    public void A(int r1) {
        this.aV = r1;
    }

    @Override // androidx.constraintlayout.a.c.e
    public void a(StringBuilder r4) {
        r4.append(this.k + ":{\n");
        r4.append("  actualWidth:" + this.M);
        r4.append("\n");
        r4.append("  actualHeight:" + this.N);
        r4.append("\n");
        Iterator<e> r3 = ak().iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((e) ZeusTransformUtils.preCheckCast(r3.next(), e.class, "com.obric.aiagent.plugin")).a(r4);
        r4.append(",\n");
        goto L4
    L6:
        r4.append("}");
    }
}
