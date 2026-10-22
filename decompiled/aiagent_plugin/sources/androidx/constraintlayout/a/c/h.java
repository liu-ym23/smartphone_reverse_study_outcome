package androidx.constraintlayout.a.c;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;

/* JADX INFO: compiled from: Guideline.java */
/* JADX INFO: loaded from: classes.dex */
public class h extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected float f786a;
    protected boolean aA;
    private d aB;
    private int aC;
    private int aD;
    private boolean aE;
    protected int ay;
    protected int az;

    /* JADX INFO: renamed from: androidx.constraintlayout.a.c.h$1, reason: invalid class name */
    /* JADX INFO: compiled from: Guideline.java */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f787a = null;

        static {
            int[] r0 = new int[d.a.values().length];
            f787a = r0;
            r0[d.a.f763b.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L24:
            f787a[d.a.f765d.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L28:
            f787a[d.a.f764c.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L38:
            f787a[d.a.f766e.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L26:
            f787a[d.a.f.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L30:
            f787a[d.a.g.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L32:
            f787a[d.a.h.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L34:
            f787a[d.a.i.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L22:
            f787a[d.a.f762a.ordinal()] = 9;     // Catch: NoSuchFieldError -> L21
            return;
        }
    }

    @Override // androidx.constraintlayout.a.c.e
    public boolean a() {
        return true;
    }

    @Override // androidx.constraintlayout.a.c.e
    public String getType() {
        return "Guideline";
    }

    public h() {
        this.f786a = -1.0f;
        this.ay = -1;
        this.az = -1;
        this.aA = true;
        this.aB = this.B;
        int r0 = 0;
        this.aC = 0;
        this.aD = 0;
        this.f767J.clear();
        this.f767J.add(this.aB);
        int r1 = this.I.length;
    L3:
        if (r0 >= r1) goto L5;
        this.I[r0] = this.aB;
        r0 = r0 + 1;
        goto L3
    }

    @Override // androidx.constraintlayout.a.c.e
    public void a(e r2, HashMap<e, e> r3) {
        super.a(r2, r3);
        h r4 = (h) ZeusTransformUtils.preCheckCast(r2, h.class, "com.obric.aiagent.plugin");
        this.f786a = r4.f786a;
        this.ay = r4.ay;
        this.az = r4.az;
        this.aA = r4.aA;
        a(r4.aC);
    }

    public void a(int r4) {
        if (this.aC != r4) goto L5;
        return;
    L5:
        this.aC = r4;
        this.f767J.clear();
        if (this.aC != 1) goto L8;
        this.aB = this.A;
    L9:
        this.f767J.add(this.aB);
        int r5 = this.I.length;
        int r0 = 0;
    L10:
        if (r0 >= r5) goto L12;
        this.I[r0] = this.aB;
        r0 = r0 + 1;
        goto L10
    L12:
        return;
    L8:
        this.aB = this.B;
        goto L9
    }

    public d b() {
        return this.aB;
    }

    public int c() {
        return this.aC;
    }

    @Override // androidx.constraintlayout.a.c.e
    public d a(d.a r3) {
        int r4 = AnonymousClass1.f787a[r3.ordinal()];
        if (r4 == 1) goto L16;
        if (r4 == 2) goto L16;
        if (r4 == 3) goto L12;
        if (r4 == 4) goto L12;
        return null;
    L12:
        if (this.aC == 0) goto L14;
        return null;
    L14:
        return this.aB;
    L16:
        if (this.aC == 1) goto L18;
        return null;
    L18:
        return this.aB;
    }

    public void e(float r2) {
        if (r2 <= (-1.0f)) goto L6;
        this.f786a = r2;
        this.ay = -1;
        this.az = -1;
        return;
    }

    public void b(int r3) {
        if (r3 <= (-1)) goto L6;
        this.f786a = -1.0f;
        this.ay = r3;
        this.az = -1;
        return;
    }

    public void A(int r3) {
        if (r3 <= (-1)) goto L6;
        this.f786a = -1.0f;
        this.ay = -1;
        this.az = r3;
        return;
    }

    public float f() {
        return this.f786a;
    }

    public int g() {
        return this.ay;
    }

    public int h() {
        return this.az;
    }

    public void B(int r2) {
        this.aB.a(r2);
        this.aE = true;
    }

    @Override // androidx.constraintlayout.a.c.e
    public boolean d() {
        return this.aE;
    }

    @Override // androidx.constraintlayout.a.c.e
    public boolean e() {
        return this.aE;
    }

    @Override // androidx.constraintlayout.a.c.e
    public void a(androidx.constraintlayout.a.d r8, boolean r9) {
        f r10 = (f) ZeusTransformUtils.preCheckCast(A(), f.class, "com.obric.aiagent.plugin");
        if (r10 != null) goto L5;
        return;
    L5:
        d r0 = r10.a(d.a.f763b);
        d r1 = r10.a(d.a.f765d);
        boolean r3 = true;
        if (this.L != null) goto L8;
    L10:
        boolean r2 = false;
    L12:
        if (this.aC != 0) goto L21;
        r0 = r10.a(d.a.f764c);
        r1 = r10.a(d.a.f766e);
        if (this.L != null) goto L16;
    L18:
        r3 = false;
    L19:
        r2 = r3;
        goto L21
    L16:
        if (this.L.K[1] != e.a.f776b) goto L18;
    L21:
        if (this.aE == false) goto L35;
        if (this.aB.f() == false) goto L35;
        androidx.constraintlayout.a.h r11 = r8.a(this.aB);
        r8.a(r11, this.aB.d());
        if (this.ay == (-1)) goto L29;
        if (r2 == false) goto L32;
        r8.a(r8.a(r1), r11, 0, 5);
    L32:
        this.aE = false;
        return;
    L29:
        if (this.az == (-1)) goto L32;
        if (r2 == false) goto L32;
        androidx.constraintlayout.a.h r4 = r8.a(r1);
        r8.a(r11, r8.a(r0), 0, 5);
        r8.a(r4, r11, 0, 5);
    L35:
        if (this.ay == (-1)) goto L40;
        androidx.constraintlayout.a.h r12 = r8.a(this.aB);
        r8.c(r12, r8.a(r0), this.ay, 8);
        if (r2 == false) goto L48;
        r8.a(r8.a(r1), r12, 0, 5);
        return;
    L48:
        return;
    L40:
        if (this.az == (-1)) goto L45;
        androidx.constraintlayout.a.h r13 = r8.a(this.aB);
        androidx.constraintlayout.a.h r5 = r8.a(r1);
        r8.c(r13, r5, -this.az, 8);
        if (r2 == false) goto L50;
        r8.a(r13, r8.a(r0), 0, 5);
        r8.a(r5, r13, 0, 5);
        return;
    L50:
        return;
    L45:
        if (this.f786a == (-1.0f)) goto L52;
        r8.a(androidx.constraintlayout.a.d.a(r8, r8.a(this.aB), r8.a(r1), this.f786a));
        return;
    L52:
        return;
    L8:
        if (this.L.K[0] != e.a.f776b) goto L10;
        r2 = true;
        goto L12
    }

    @Override // androidx.constraintlayout.a.c.e
    public void b(androidx.constraintlayout.a.d r3, boolean r4) {
        if (A() != null) goto L5;
        return;
    L5:
        int r5 = r3.b(this.aB);
        if (this.aC != 1) goto L8;
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
