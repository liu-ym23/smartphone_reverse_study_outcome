package z8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class l extends f9.j implements f9.v {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f12240g;

    /* renamed from: h, reason: collision with root package name */
    public int f12241h;

    /* renamed from: i, reason: collision with root package name */
    public List f12242i;

    public /* synthetic */ l(int i2) {
        this.f12240g = i2;
    }

    @Override // f9.j
    public final f9.a a() {
        switch (this.f12240g) {
            case 0:
                m mVarD = d();
                if (mVarD.isInitialized()) {
                    return mVarD;
                }
                throw new a4.u(4);
            case 1:
                j0 j0VarE = e();
                if (j0VarE.isInitialized()) {
                    return j0VarE;
                }
                throw new a4.u(4);
            case 2:
                c1 c1VarG = g();
                c1VarG.isInitialized();
                return c1VarG;
            default:
                k0 k0VarF = f();
                k0VarF.isInitialized();
                return k0VarF;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x007d  */
    @Override // f9.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final f9.j b(f9.e r3, f9.h r4) throws java.lang.Throwable {
        /*
            r2 = this;
            int r0 = r2.f12240g
            switch(r0) {
                case 0: goto L62;
                case 1: goto L43;
                case 2: goto L24;
                default: goto L5;
            }
        L5:
            r4 = 0
            c9.a r0 = z8.k0.f12235k     // Catch: java.lang.Throwable -> L14 f9.r -> L16
            r0.getClass()     // Catch: java.lang.Throwable -> L14 f9.r -> L16
            z8.k0 r0 = new z8.k0     // Catch: java.lang.Throwable -> L14 f9.r -> L16
            r0.<init>(r3)     // Catch: java.lang.Throwable -> L14 f9.r -> L16
            r2.j(r0)
            return r2
        L14:
            r3 = move-exception
            goto L1e
        L16:
            r3 = move-exception
            f9.a r0 = r3.f3597f     // Catch: java.lang.Throwable -> L14
            z8.k0 r0 = (z8.k0) r0     // Catch: java.lang.Throwable -> L14
            throw r3     // Catch: java.lang.Throwable -> L1c
        L1c:
            r3 = move-exception
            r4 = r0
        L1e:
            if (r4 == 0) goto L23
            r2.j(r4)
        L23:
            throw r3
        L24:
            r0 = 0
            c9.a r1 = z8.c1.f12080k     // Catch: java.lang.Throwable -> L33 f9.r -> L35
            r1.getClass()     // Catch: java.lang.Throwable -> L33 f9.r -> L35
            z8.c1 r1 = new z8.c1     // Catch: java.lang.Throwable -> L33 f9.r -> L35
            r1.<init>(r3, r4)     // Catch: java.lang.Throwable -> L33 f9.r -> L35
            r2.k(r1)
            return r2
        L33:
            r3 = move-exception
            goto L3d
        L35:
            r3 = move-exception
            f9.a r4 = r3.f3597f     // Catch: java.lang.Throwable -> L33
            z8.c1 r4 = (z8.c1) r4     // Catch: java.lang.Throwable -> L33
            throw r3     // Catch: java.lang.Throwable -> L3b
        L3b:
            r3 = move-exception
            r0 = r4
        L3d:
            if (r0 == 0) goto L42
            r2.k(r0)
        L42:
            throw r3
        L43:
            r0 = 0
            c9.a r1 = z8.j0.f12220k     // Catch: java.lang.Throwable -> L52 f9.r -> L54
            r1.getClass()     // Catch: java.lang.Throwable -> L52 f9.r -> L54
            z8.j0 r1 = new z8.j0     // Catch: java.lang.Throwable -> L52 f9.r -> L54
            r1.<init>(r3, r4)     // Catch: java.lang.Throwable -> L52 f9.r -> L54
            r2.i(r1)
            return r2
        L52:
            r3 = move-exception
            goto L5c
        L54:
            r3 = move-exception
            f9.a r4 = r3.f3597f     // Catch: java.lang.Throwable -> L52
            z8.j0 r4 = (z8.j0) r4     // Catch: java.lang.Throwable -> L52
            throw r3     // Catch: java.lang.Throwable -> L5a
        L5a:
            r3 = move-exception
            r0 = r4
        L5c:
            if (r0 == 0) goto L61
            r2.i(r0)
        L61:
            throw r3
        L62:
            r0 = 0
            c9.a r1 = z8.m.f12248k     // Catch: java.lang.Throwable -> L71 f9.r -> L73
            r1.getClass()     // Catch: java.lang.Throwable -> L71 f9.r -> L73
            z8.m r1 = new z8.m     // Catch: java.lang.Throwable -> L71 f9.r -> L73
            r1.<init>(r3, r4)     // Catch: java.lang.Throwable -> L71 f9.r -> L73
            r2.h(r1)
            return r2
        L71:
            r3 = move-exception
            goto L7b
        L73:
            r3 = move-exception
            f9.a r4 = r3.f3597f     // Catch: java.lang.Throwable -> L71
            z8.m r4 = (z8.m) r4     // Catch: java.lang.Throwable -> L71
            throw r3     // Catch: java.lang.Throwable -> L79
        L79:
            r3 = move-exception
            r0 = r4
        L7b:
            if (r0 == 0) goto L80
            r2.h(r0)
        L80:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: z8.l.b(f9.e, f9.h):f9.j");
    }

    @Override // f9.j
    public final /* bridge */ /* synthetic */ f9.j c(f9.o oVar) {
        switch (this.f12240g) {
            case 0:
                h((m) oVar);
                break;
            case 1:
                i((j0) oVar);
                break;
            case 2:
                k((c1) oVar);
                break;
            default:
                j((k0) oVar);
                break;
        }
        return this;
    }

    public final Object clone() {
        switch (this.f12240g) {
            case 0:
                l lVar = new l(0);
                lVar.f12242i = Collections.EMPTY_LIST;
                lVar.h(d());
                return lVar;
            case 1:
                l lVar2 = new l(1);
                lVar2.f12242i = Collections.EMPTY_LIST;
                lVar2.i(e());
                return lVar2;
            case 2:
                l lVar3 = new l(2);
                lVar3.f12242i = Collections.EMPTY_LIST;
                lVar3.k(g());
                return lVar3;
            default:
                l lVar4 = new l(3);
                lVar4.f12242i = f9.s.f3598g;
                lVar4.j(f());
                return lVar4;
        }
    }

    public m d() {
        m mVar = new m(this);
        if ((this.f12241h & 1) == 1) {
            this.f12242i = Collections.unmodifiableList(this.f12242i);
            this.f12241h &= -2;
        }
        mVar.f12250g = this.f12242i;
        return mVar;
    }

    public j0 e() {
        j0 j0Var = new j0(this);
        if ((this.f12241h & 1) == 1) {
            this.f12242i = Collections.unmodifiableList(this.f12242i);
            this.f12241h &= -2;
        }
        j0Var.f12222g = this.f12242i;
        return j0Var;
    }

    public k0 f() {
        k0 k0Var = new k0(this);
        if ((this.f12241h & 1) == 1) {
            this.f12242i = ((f9.t) this.f12242i).getUnmodifiableView();
            this.f12241h &= -2;
        }
        k0Var.f12237g = (f9.t) this.f12242i;
        return k0Var;
    }

    public c1 g() {
        c1 c1Var = new c1(this);
        if ((this.f12241h & 1) == 1) {
            this.f12242i = Collections.unmodifiableList(this.f12242i);
            this.f12241h &= -2;
        }
        c1Var.f12082g = this.f12242i;
        return c1Var;
    }

    public void h(m mVar) {
        if (mVar == m.f12247j) {
            return;
        }
        if (!mVar.f12250g.isEmpty()) {
            if (this.f12242i.isEmpty()) {
                this.f12242i = mVar.f12250g;
                this.f12241h &= -2;
            } else {
                if ((this.f12241h & 1) != 1) {
                    this.f12242i = new ArrayList(this.f12242i);
                    this.f12241h |= 1;
                }
                this.f12242i.addAll(mVar.f12250g);
            }
        }
        this.f3565f = this.f3565f.f(mVar.f12249f);
    }

    public void i(j0 j0Var) {
        if (j0Var == j0.f12219j) {
            return;
        }
        if (!j0Var.f12222g.isEmpty()) {
            if (this.f12242i.isEmpty()) {
                this.f12242i = j0Var.f12222g;
                this.f12241h &= -2;
            } else {
                if ((this.f12241h & 1) != 1) {
                    this.f12242i = new ArrayList(this.f12242i);
                    this.f12241h |= 1;
                }
                this.f12242i.addAll(j0Var.f12222g);
            }
        }
        this.f3565f = this.f3565f.f(j0Var.f12221f);
    }

    public void j(k0 k0Var) {
        if (k0Var == k0.f12234j) {
            return;
        }
        if (!k0Var.f12237g.isEmpty()) {
            if (((f9.t) this.f12242i).isEmpty()) {
                this.f12242i = k0Var.f12237g;
                this.f12241h &= -2;
            } else {
                if ((this.f12241h & 1) != 1) {
                    this.f12242i = new f9.s((f9.t) this.f12242i);
                    this.f12241h |= 1;
                }
                ((f9.t) this.f12242i).addAll(k0Var.f12237g);
            }
        }
        this.f3565f = this.f3565f.f(k0Var.f12236f);
    }

    public void k(c1 c1Var) {
        if (c1Var == c1.f12079j) {
            return;
        }
        if (!c1Var.f12082g.isEmpty()) {
            if (this.f12242i.isEmpty()) {
                this.f12242i = c1Var.f12082g;
                this.f12241h &= -2;
            } else {
                if ((this.f12241h & 1) != 1) {
                    this.f12242i = new ArrayList(this.f12242i);
                    this.f12241h |= 1;
                }
                this.f12242i.addAll(c1Var.f12082g);
            }
        }
        this.f3565f = this.f3565f.f(c1Var.f12081f);
    }
}
