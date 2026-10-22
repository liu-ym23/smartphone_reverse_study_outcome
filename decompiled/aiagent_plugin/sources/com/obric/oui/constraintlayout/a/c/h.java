package com.obric.oui.constraintlayout.a.c;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;

/* JADX INFO: compiled from: Guideline.java */
/* JADX INFO: loaded from: classes4.dex */
public class h extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected float f34767a;
    protected int aA;
    protected boolean aB;
    private d aC;
    private int aD;
    private int aE;
    private boolean aF;
    protected int az;

    /* JADX INFO: renamed from: com.obric.oui.constraintlayout.a.c.h$1, reason: invalid class name */
    /* JADX INFO: compiled from: Guideline.java */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f34768a = null;

        static {
            int[] r0 = new int[d.a.values().length];
            f34768a = r0;
            r0[d.a.f34744b.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L24:
            f34768a[d.a.f34746d.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L28:
            f34768a[d.a.f34745c.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L38:
            f34768a[d.a.f34747e.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L26:
            f34768a[d.a.f.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L30:
            f34768a[d.a.g.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L32:
            f34768a[d.a.h.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L34:
            f34768a[d.a.i.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L22:
            f34768a[d.a.f34743a.ordinal()] = 9;     // Catch: NoSuchFieldError -> L21
            return;
        }
    }

    @Override // com.obric.oui.constraintlayout.a.c.e
    public boolean a() {
        return true;
    }

    @Override // com.obric.oui.constraintlayout.a.c.e
    public String getType() {
        return "Guideline";
    }

    public h() {
        this.f34767a = -1.0f;
        this.az = -1;
        this.aA = -1;
        this.aB = true;
        this.aC = this.C;
        int r0 = 0;
        this.aD = 0;
        this.aE = 0;
        this.K.clear();
        this.K.add(this.aC);
        int r1 = this.f34748J.length;
    L3:
        if (r0 >= r1) goto L5;
        this.f34748J[r0] = this.aC;
        r0 = r0 + 1;
        goto L3
    }

    @Override // com.obric.oui.constraintlayout.a.c.e
    public void a(e r2, HashMap<e, e> r3) {
        super.a(r2, r3);
        h r4 = (h) ZeusTransformUtils.preCheckCast(r2, h.class, "com.obric.aiagent.plugin");
        this.f34767a = r4.f34767a;
        this.az = r4.az;
        this.aA = r4.aA;
        this.aB = r4.aB;
        a(r4.aD);
    }

    public void a(int r4) {
        if (this.aD != r4) goto L5;
        return;
    L5:
        this.aD = r4;
        this.K.clear();
        if (this.aD != 1) goto L8;
        this.aC = this.B;
    L9:
        this.K.add(this.aC);
        int r5 = this.f34748J.length;
        int r0 = 0;
    L10:
        if (r0 >= r5) goto L12;
        this.f34748J[r0] = this.aC;
        r0 = r0 + 1;
        goto L10
    L12:
        return;
    L8:
        this.aC = this.C;
        goto L9
    }

    public d b() {
        return this.aC;
    }

    public int c() {
        return this.aD;
    }

    @Override // com.obric.oui.constraintlayout.a.c.e
    public d a(d.a r3) {
        int r4 = AnonymousClass1.f34768a[r3.ordinal()];
        if (r4 == 1) goto L16;
        if (r4 == 2) goto L16;
        if (r4 == 3) goto L12;
        if (r4 == 4) goto L12;
        return null;
    L12:
        if (this.aD == 0) goto L14;
        return null;
    L14:
        return this.aC;
    L16:
        if (this.aD == 1) goto L18;
        return null;
    L18:
        return this.aC;
    }

    public void e(float r2) {
        if (r2 <= (-1.0f)) goto L6;
        this.f34767a = r2;
        this.az = -1;
        this.aA = -1;
        return;
    }

    public void b(int r3) {
        if (r3 <= (-1)) goto L6;
        this.f34767a = -1.0f;
        this.az = r3;
        this.aA = -1;
        return;
    }

    public void A(int r3) {
        if (r3 <= (-1)) goto L6;
        this.f34767a = -1.0f;
        this.az = -1;
        this.aA = r3;
        return;
    }

    public float f() {
        return this.f34767a;
    }

    public int g() {
        return this.az;
    }

    public int h() {
        return this.aA;
    }

    public void B(int r2) {
        this.aC.a(r2);
        this.aF = true;
    }

    @Override // com.obric.oui.constraintlayout.a.c.e
    public boolean d() {
        return this.aF;
    }

    @Override // com.obric.oui.constraintlayout.a.c.e
    public boolean e() {
        return this.aF;
    }

    @Override // com.obric.oui.constraintlayout.a.c.e
    public void a(com.obric.oui.constraintlayout.a.d r8, boolean r9) {
        f r10 = (f) ZeusTransformUtils.preCheckCast(A(), f.class, "com.obric.aiagent.plugin");
        if (r10 != null) goto L5;
        return;
    L5:
        d r0 = r10.a(d.a.f34744b);
        d r1 = r10.a(d.a.f34746d);
        boolean r3 = true;
        if (this.M != null) goto L8;
    L10:
        boolean r2 = false;
    L12:
        if (this.aD != 0) goto L21;
        r0 = r10.a(d.a.f34745c);
        r1 = r10.a(d.a.f34747e);
        if (this.M != null) goto L16;
    L18:
        r3 = false;
    L19:
        r2 = r3;
        goto L21
    L16:
        if (this.M.L[1] != e.a.f34757b) goto L18;
    L21:
        if (this.aF == false) goto L35;
        if (this.aC.f() == false) goto L35;
        com.obric.oui.constraintlayout.a.h r11 = r8.a(this.aC);
        r8.a(r11, this.aC.d());
        if (this.az == (-1)) goto L29;
        if (r2 == false) goto L32;
        r8.a(r8.a(r1), r11, 0, 5);
    L32:
        this.aF = false;
        return;
    L29:
        if (this.aA == (-1)) goto L32;
        if (r2 == false) goto L32;
        com.obric.oui.constraintlayout.a.h r4 = r8.a(r1);
        r8.a(r11, r8.a(r0), 0, 5);
        r8.a(r4, r11, 0, 5);
    L35:
        if (this.az == (-1)) goto L40;
        com.obric.oui.constraintlayout.a.h r12 = r8.a(this.aC);
        r8.c(r12, r8.a(r0), this.az, 8);
        if (r2 == false) goto L48;
        r8.a(r8.a(r1), r12, 0, 5);
        return;
    L48:
        return;
    L40:
        if (this.aA == (-1)) goto L45;
        com.obric.oui.constraintlayout.a.h r13 = r8.a(this.aC);
        com.obric.oui.constraintlayout.a.h r5 = r8.a(r1);
        r8.c(r13, r5, -this.aA, 8);
        if (r2 == false) goto L50;
        r8.a(r13, r8.a(r0), 0, 5);
        r8.a(r5, r13, 0, 5);
        return;
    L50:
        return;
    L45:
        if (this.f34767a == (-1.0f)) goto L52;
        r8.a(com.obric.oui.constraintlayout.a.d.a(r8, r8.a(this.aC), r8.a(r1), this.f34767a));
        return;
    L52:
        return;
    L8:
        if (this.M.L[0] != e.a.f34757b) goto L10;
        r2 = true;
        goto L12
    }

    @Override // com.obric.oui.constraintlayout.a.c.e
    public void b(com.obric.oui.constraintlayout.a.d r3, boolean r4) {
        if (A() != null) goto L5;
        return;
    L5:
        int r5 = r3.b(this.aC);
        if (this.aD != 1) goto L8;
        o(r5);
        p(0);
        r(A().G());
        q(0);
        return;
    L8:
        o(0);
        p(r5);
        q(A().F());
        r(0);
    }
}
