package z8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class e extends f9.j implements f9.v {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f12105g;

    /* renamed from: h, reason: collision with root package name */
    public int f12106h;

    /* renamed from: i, reason: collision with root package name */
    public Object f12107i;

    /* renamed from: j, reason: collision with root package name */
    public int f12108j;

    public /* synthetic */ e(int i2) {
        this.f12105g = i2;
    }

    public static e g() {
        e eVar = new e(1);
        eVar.f12107i = Collections.EMPTY_LIST;
        eVar.f12108j = -1;
        return eVar;
    }

    @Override // f9.j
    public final f9.a a() {
        switch (this.f12105g) {
            case 0:
                f fVarE = e();
                if (fVarE.isInitialized()) {
                    return fVarE;
                }
                throw new a4.u(4);
            case 1:
                v0 v0VarF = f();
                if (v0VarF.isInitialized()) {
                    return v0VarF;
                }
                throw new a4.u(4);
            default:
                d dVarD = d();
                if (dVarD.isInitialized()) {
                    return dVarD;
                }
                throw new a4.u(4);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x005c  */
    @Override // f9.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final f9.j b(f9.e r3, f9.h r4) throws java.lang.Throwable {
        /*
            r2 = this;
            int r0 = r2.f12105g
            switch(r0) {
                case 0: goto L43;
                case 1: goto L24;
                default: goto L5;
            }
        L5:
            r0 = 0
            c9.a r1 = z8.d.f12086m     // Catch: java.lang.Throwable -> L14 f9.r -> L16
            r1.getClass()     // Catch: java.lang.Throwable -> L14 f9.r -> L16
            z8.d r1 = new z8.d     // Catch: java.lang.Throwable -> L14 f9.r -> L16
            r1.<init>(r3, r4)     // Catch: java.lang.Throwable -> L14 f9.r -> L16
            r2.h(r1)
            return r2
        L14:
            r3 = move-exception
            goto L1e
        L16:
            r3 = move-exception
            f9.a r4 = r3.f3597f     // Catch: java.lang.Throwable -> L14
            z8.d r4 = (z8.d) r4     // Catch: java.lang.Throwable -> L14
            throw r3     // Catch: java.lang.Throwable -> L1c
        L1c:
            r3 = move-exception
            r0 = r4
        L1e:
            if (r0 == 0) goto L23
            r2.h(r0)
        L23:
            throw r3
        L24:
            r0 = 0
            c9.a r1 = z8.v0.f12414m     // Catch: java.lang.Throwable -> L33 f9.r -> L35
            r1.getClass()     // Catch: java.lang.Throwable -> L33 f9.r -> L35
            z8.v0 r1 = new z8.v0     // Catch: java.lang.Throwable -> L33 f9.r -> L35
            r1.<init>(r3, r4)     // Catch: java.lang.Throwable -> L33 f9.r -> L35
            r2.j(r1)
            return r2
        L33:
            r3 = move-exception
            goto L3d
        L35:
            r3 = move-exception
            f9.a r4 = r3.f3597f     // Catch: java.lang.Throwable -> L33
            z8.v0 r4 = (z8.v0) r4     // Catch: java.lang.Throwable -> L33
            throw r3     // Catch: java.lang.Throwable -> L3b
        L3b:
            r3 = move-exception
            r0 = r4
        L3d:
            if (r0 == 0) goto L42
            r2.j(r0)
        L42:
            throw r3
        L43:
            r0 = 0
            c9.a r1 = z8.f.f12125m     // Catch: java.lang.Throwable -> L50 f9.r -> L52
            java.lang.Object r3 = r1.a(r3, r4)     // Catch: java.lang.Throwable -> L50 f9.r -> L52
            z8.f r3 = (z8.f) r3     // Catch: java.lang.Throwable -> L50 f9.r -> L52
            r2.i(r3)
            return r2
        L50:
            r3 = move-exception
            goto L5a
        L52:
            r3 = move-exception
            f9.a r4 = r3.f3597f     // Catch: java.lang.Throwable -> L50
            z8.f r4 = (z8.f) r4     // Catch: java.lang.Throwable -> L50
            throw r3     // Catch: java.lang.Throwable -> L58
        L58:
            r3 = move-exception
            r0 = r4
        L5a:
            if (r0 == 0) goto L5f
            r2.i(r0)
        L5f:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: z8.e.b(f9.e, f9.h):f9.j");
    }

    @Override // f9.j
    public final /* bridge */ /* synthetic */ f9.j c(f9.o oVar) {
        switch (this.f12105g) {
            case 0:
                i((f) oVar);
                break;
            case 1:
                j((v0) oVar);
                break;
            default:
                h((d) oVar);
                break;
        }
        return this;
    }

    public final Object clone() {
        switch (this.f12105g) {
            case 0:
                e eVar = new e(0);
                eVar.f12107i = Collections.EMPTY_LIST;
                eVar.i(e());
                return eVar;
            case 1:
                e eVarG = g();
                eVarG.j(f());
                return eVarG;
            default:
                e eVar2 = new e(2);
                eVar2.f12107i = c.f12057u;
                eVar2.h(d());
                return eVar2;
        }
    }

    public d d() {
        d dVar = new d(this);
        int i2 = this.f12106h;
        int i10 = (i2 & 1) != 1 ? 0 : 1;
        dVar.f12089h = this.f12108j;
        if ((i2 & 2) == 2) {
            i10 |= 2;
        }
        dVar.f12090i = (c) this.f12107i;
        dVar.f12088g = i10;
        return dVar;
    }

    public f e() {
        f fVar = new f(this);
        int i2 = this.f12106h;
        int i10 = (i2 & 1) != 1 ? 0 : 1;
        fVar.f12128h = this.f12108j;
        if ((i2 & 2) == 2) {
            this.f12107i = Collections.unmodifiableList((List) this.f12107i);
            this.f12106h &= -3;
        }
        fVar.f12129i = (List) this.f12107i;
        fVar.f12127g = i10;
        return fVar;
    }

    public v0 f() {
        v0 v0Var = new v0(this);
        int i2 = this.f12106h;
        if ((i2 & 1) == 1) {
            this.f12107i = Collections.unmodifiableList((List) this.f12107i);
            this.f12106h &= -2;
        }
        v0Var.f12417h = (List) this.f12107i;
        int i10 = (i2 & 2) != 2 ? 0 : 1;
        v0Var.f12418i = this.f12108j;
        v0Var.f12416g = i10;
        return v0Var;
    }

    public void h(d dVar) {
        c cVar;
        if (dVar == d.f12085l) {
            return;
        }
        int i2 = dVar.f12088g;
        if ((i2 & 1) == 1) {
            int i10 = dVar.f12089h;
            this.f12106h = 1 | this.f12106h;
            this.f12108j = i10;
        }
        if ((i2 & 2) == 2) {
            c cVar2 = dVar.f12090i;
            if ((this.f12106h & 2) != 2 || (cVar = (c) this.f12107i) == c.f12057u) {
                this.f12107i = cVar2;
            } else {
                a aVarE = a.e();
                aVarE.f(cVar);
                aVarE.f(cVar2);
                this.f12107i = aVarE.d();
            }
            this.f12106h |= 2;
        }
        this.f3565f = this.f3565f.f(dVar.f12087f);
    }

    public void i(f fVar) {
        if (fVar == f.f12124l) {
            return;
        }
        if ((fVar.f12127g & 1) == 1) {
            int i2 = fVar.f12128h;
            this.f12106h = 1 | this.f12106h;
            this.f12108j = i2;
        }
        if (!fVar.f12129i.isEmpty()) {
            if (((List) this.f12107i).isEmpty()) {
                this.f12107i = fVar.f12129i;
                this.f12106h &= -3;
            } else {
                if ((this.f12106h & 2) != 2) {
                    this.f12107i = new ArrayList((List) this.f12107i);
                    this.f12106h |= 2;
                }
                ((List) this.f12107i).addAll(fVar.f12129i);
            }
        }
        this.f3565f = this.f3565f.f(fVar.f12126f);
    }

    public void j(v0 v0Var) {
        if (v0Var == v0.f12413l) {
            return;
        }
        if (!v0Var.f12417h.isEmpty()) {
            if (((List) this.f12107i).isEmpty()) {
                this.f12107i = v0Var.f12417h;
                this.f12106h &= -2;
            } else {
                if ((this.f12106h & 1) != 1) {
                    this.f12107i = new ArrayList((List) this.f12107i);
                    this.f12106h |= 1;
                }
                ((List) this.f12107i).addAll(v0Var.f12417h);
            }
        }
        if ((v0Var.f12416g & 1) == 1) {
            int i2 = v0Var.f12418i;
            this.f12106h |= 2;
            this.f12108j = i2;
        }
        this.f3565f = this.f3565f.f(v0Var.f12415f);
    }
}
