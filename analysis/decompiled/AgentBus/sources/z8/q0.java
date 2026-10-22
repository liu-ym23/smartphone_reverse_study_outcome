package z8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class q0 extends f9.k {

    /* renamed from: i, reason: collision with root package name */
    public int f12328i;

    /* renamed from: j, reason: collision with root package name */
    public int f12329j;

    /* renamed from: k, reason: collision with root package name */
    public int f12330k;

    /* renamed from: l, reason: collision with root package name */
    public List f12331l;

    /* renamed from: m, reason: collision with root package name */
    public p0 f12332m;

    /* renamed from: n, reason: collision with root package name */
    public int f12333n;

    /* renamed from: o, reason: collision with root package name */
    public p0 f12334o;

    /* renamed from: p, reason: collision with root package name */
    public int f12335p;

    /* renamed from: q, reason: collision with root package name */
    public List f12336q;

    /* renamed from: r, reason: collision with root package name */
    public List f12337r;

    public static q0 f() {
        q0 q0Var = new q0();
        q0Var.f12329j = 6;
        List list = Collections.EMPTY_LIST;
        q0Var.f12331l = list;
        p0 p0Var = p0.f12298y;
        q0Var.f12332m = p0Var;
        q0Var.f12334o = p0Var;
        q0Var.f12336q = list;
        q0Var.f12337r = list;
        return q0Var;
    }

    @Override // f9.j
    public final f9.a a() {
        r0 r0VarE = e();
        if (r0VarE.isInitialized()) {
            return r0VarE;
        }
        throw new a4.u(4);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x001b  */
    @Override // f9.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final f9.j b(f9.e r3, f9.h r4) throws java.lang.Throwable {
        /*
            r2 = this;
            r0 = 0
            c9.a r1 = z8.r0.f12341u     // Catch: java.lang.Throwable -> Lf f9.r -> L11
            r1.getClass()     // Catch: java.lang.Throwable -> Lf f9.r -> L11
            z8.r0 r1 = new z8.r0     // Catch: java.lang.Throwable -> Lf f9.r -> L11
            r1.<init>(r3, r4)     // Catch: java.lang.Throwable -> Lf f9.r -> L11
            r2.g(r1)
            return r2
        Lf:
            r3 = move-exception
            goto L19
        L11:
            r3 = move-exception
            f9.a r4 = r3.f3597f     // Catch: java.lang.Throwable -> Lf
            z8.r0 r4 = (z8.r0) r4     // Catch: java.lang.Throwable -> Lf
            throw r3     // Catch: java.lang.Throwable -> L17
        L17:
            r3 = move-exception
            r0 = r4
        L19:
            if (r0 == 0) goto L1e
            r2.g(r0)
        L1e:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: z8.q0.b(f9.e, f9.h):f9.j");
    }

    @Override // f9.j
    public final /* bridge */ /* synthetic */ f9.j c(f9.o oVar) {
        g((r0) oVar);
        return this;
    }

    public final Object clone() {
        q0 q0VarF = f();
        q0VarF.g(e());
        return q0VarF;
    }

    public final r0 e() {
        r0 r0Var = new r0(this);
        int i2 = this.f12328i;
        int i10 = (i2 & 1) != 1 ? 0 : 1;
        r0Var.f12344i = this.f12329j;
        if ((i2 & 2) == 2) {
            i10 |= 2;
        }
        r0Var.f12345j = this.f12330k;
        if ((i2 & 4) == 4) {
            this.f12331l = Collections.unmodifiableList(this.f12331l);
            this.f12328i &= -5;
        }
        r0Var.f12346k = this.f12331l;
        if ((i2 & 8) == 8) {
            i10 |= 4;
        }
        r0Var.f12347l = this.f12332m;
        if ((i2 & 16) == 16) {
            i10 |= 8;
        }
        r0Var.f12348m = this.f12333n;
        if ((i2 & 32) == 32) {
            i10 |= 16;
        }
        r0Var.f12349n = this.f12334o;
        if ((i2 & 64) == 64) {
            i10 |= 32;
        }
        r0Var.f12350o = this.f12335p;
        if ((this.f12328i & 128) == 128) {
            this.f12336q = Collections.unmodifiableList(this.f12336q);
            this.f12328i &= -129;
        }
        r0Var.f12351p = this.f12336q;
        if ((this.f12328i & 256) == 256) {
            this.f12337r = Collections.unmodifiableList(this.f12337r);
            this.f12328i &= -257;
        }
        r0Var.f12352q = this.f12337r;
        r0Var.f12343h = i10;
        return r0Var;
    }

    public final void g(r0 r0Var) {
        p0 p0Var;
        p0 p0Var2;
        if (r0Var == r0.f12340t) {
            return;
        }
        int i2 = r0Var.f12343h;
        if ((i2 & 1) == 1) {
            int i10 = r0Var.f12344i;
            this.f12328i = 1 | this.f12328i;
            this.f12329j = i10;
        }
        if ((i2 & 2) == 2) {
            int i11 = r0Var.f12345j;
            this.f12328i = 2 | this.f12328i;
            this.f12330k = i11;
        }
        if (!r0Var.f12346k.isEmpty()) {
            if (this.f12331l.isEmpty()) {
                this.f12331l = r0Var.f12346k;
                this.f12328i &= -5;
            } else {
                if ((this.f12328i & 4) != 4) {
                    this.f12331l = new ArrayList(this.f12331l);
                    this.f12328i |= 4;
                }
                this.f12331l.addAll(r0Var.f12346k);
            }
        }
        if ((r0Var.f12343h & 4) == 4) {
            p0 p0Var3 = r0Var.f12347l;
            if ((this.f12328i & 8) != 8 || (p0Var2 = this.f12332m) == p0.f12298y) {
                this.f12332m = p0Var3;
            } else {
                o0 o0VarP = p0.p(p0Var2);
                o0VarP.g(p0Var3);
                this.f12332m = o0VarP.e();
            }
            this.f12328i |= 8;
        }
        int i12 = r0Var.f12343h;
        if ((i12 & 8) == 8) {
            int i13 = r0Var.f12348m;
            this.f12328i |= 16;
            this.f12333n = i13;
        }
        if ((i12 & 16) == 16) {
            p0 p0Var4 = r0Var.f12349n;
            if ((this.f12328i & 32) != 32 || (p0Var = this.f12334o) == p0.f12298y) {
                this.f12334o = p0Var4;
            } else {
                o0 o0VarP2 = p0.p(p0Var);
                o0VarP2.g(p0Var4);
                this.f12334o = o0VarP2.e();
            }
            this.f12328i |= 32;
        }
        if ((r0Var.f12343h & 32) == 32) {
            int i14 = r0Var.f12350o;
            this.f12328i |= 64;
            this.f12335p = i14;
        }
        if (!r0Var.f12351p.isEmpty()) {
            if (this.f12336q.isEmpty()) {
                this.f12336q = r0Var.f12351p;
                this.f12328i &= -129;
            } else {
                if ((this.f12328i & 128) != 128) {
                    this.f12336q = new ArrayList(this.f12336q);
                    this.f12328i |= 128;
                }
                this.f12336q.addAll(r0Var.f12351p);
            }
        }
        if (!r0Var.f12352q.isEmpty()) {
            if (this.f12337r.isEmpty()) {
                this.f12337r = r0Var.f12352q;
                this.f12328i &= -257;
            } else {
                if ((this.f12328i & 256) != 256) {
                    this.f12337r = new ArrayList(this.f12337r);
                    this.f12328i |= 256;
                }
                this.f12337r.addAll(r0Var.f12352q);
            }
        }
        d(r0Var);
        this.f3565f = this.f3565f.f(r0Var.f12342g);
    }
}
