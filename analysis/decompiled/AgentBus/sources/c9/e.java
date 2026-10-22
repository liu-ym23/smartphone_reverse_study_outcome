package c9;

import f9.o;
import f9.v;

/* loaded from: classes.dex */
public final class e extends f9.j implements v {

    /* renamed from: g, reason: collision with root package name */
    public int f2108g;

    /* renamed from: h, reason: collision with root package name */
    public c f2109h;

    /* renamed from: i, reason: collision with root package name */
    public d f2110i;

    /* renamed from: j, reason: collision with root package name */
    public d f2111j;

    /* renamed from: k, reason: collision with root package name */
    public d f2112k;

    /* renamed from: l, reason: collision with root package name */
    public d f2113l;

    public static e e() {
        e eVar = new e();
        eVar.f2109h = c.f2092l;
        d dVar = d.f2100l;
        eVar.f2110i = dVar;
        eVar.f2111j = dVar;
        eVar.f2112k = dVar;
        eVar.f2113l = dVar;
        return eVar;
    }

    @Override // f9.j
    public final f9.a a() {
        f fVarD = d();
        fVarD.isInitialized();
        return fVarD;
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
            c9.a r1 = c9.f.f2115p     // Catch: java.lang.Throwable -> Lf f9.r -> L11
            r1.getClass()     // Catch: java.lang.Throwable -> Lf f9.r -> L11
            c9.f r1 = new c9.f     // Catch: java.lang.Throwable -> Lf f9.r -> L11
            r1.<init>(r3, r4)     // Catch: java.lang.Throwable -> Lf f9.r -> L11
            r2.f(r1)
            return r2
        Lf:
            r3 = move-exception
            goto L19
        L11:
            r3 = move-exception
            f9.a r4 = r3.f3597f     // Catch: java.lang.Throwable -> Lf
            c9.f r4 = (c9.f) r4     // Catch: java.lang.Throwable -> Lf
            throw r3     // Catch: java.lang.Throwable -> L17
        L17:
            r3 = move-exception
            r0 = r4
        L19:
            if (r0 == 0) goto L1e
            r2.f(r0)
        L1e:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: c9.e.b(f9.e, f9.h):f9.j");
    }

    @Override // f9.j
    public final /* bridge */ /* synthetic */ f9.j c(o oVar) {
        f((f) oVar);
        return this;
    }

    public final Object clone() {
        e eVarE = e();
        eVarE.f(d());
        return eVarE;
    }

    public final f d() {
        f fVar = new f(this);
        int i2 = this.f2108g;
        int i10 = (i2 & 1) != 1 ? 0 : 1;
        fVar.f2118h = this.f2109h;
        if ((i2 & 2) == 2) {
            i10 |= 2;
        }
        fVar.f2119i = this.f2110i;
        if ((i2 & 4) == 4) {
            i10 |= 4;
        }
        fVar.f2120j = this.f2111j;
        if ((i2 & 8) == 8) {
            i10 |= 8;
        }
        fVar.f2121k = this.f2112k;
        if ((i2 & 16) == 16) {
            i10 |= 16;
        }
        fVar.f2122l = this.f2113l;
        fVar.f2117g = i10;
        return fVar;
    }

    public final void f(f fVar) {
        d dVar;
        d dVar2;
        d dVar3;
        d dVar4;
        c cVar;
        if (fVar == f.f2114o) {
            return;
        }
        if ((fVar.f2117g & 1) == 1) {
            c cVar2 = fVar.f2118h;
            if ((this.f2108g & 1) != 1 || (cVar = this.f2109h) == c.f2092l) {
                this.f2109h = cVar2;
            } else {
                b bVar = new b(0);
                bVar.f(cVar);
                bVar.f(cVar2);
                this.f2109h = bVar.d();
            }
            this.f2108g |= 1;
        }
        if ((fVar.f2117g & 2) == 2) {
            d dVar5 = fVar.f2119i;
            if ((this.f2108g & 2) != 2 || (dVar4 = this.f2110i) == d.f2100l) {
                this.f2110i = dVar5;
            } else {
                b bVarG = d.g(dVar4);
                bVarG.g(dVar5);
                this.f2110i = bVarG.e();
            }
            this.f2108g |= 2;
        }
        if ((fVar.f2117g & 4) == 4) {
            d dVar6 = fVar.f2120j;
            if ((this.f2108g & 4) != 4 || (dVar3 = this.f2111j) == d.f2100l) {
                this.f2111j = dVar6;
            } else {
                b bVarG2 = d.g(dVar3);
                bVarG2.g(dVar6);
                this.f2111j = bVarG2.e();
            }
            this.f2108g |= 4;
        }
        if ((fVar.f2117g & 8) == 8) {
            d dVar7 = fVar.f2121k;
            if ((this.f2108g & 8) != 8 || (dVar2 = this.f2112k) == d.f2100l) {
                this.f2112k = dVar7;
            } else {
                b bVarG3 = d.g(dVar2);
                bVarG3.g(dVar7);
                this.f2112k = bVarG3.e();
            }
            this.f2108g |= 8;
        }
        if ((fVar.f2117g & 16) == 16) {
            d dVar8 = fVar.f2122l;
            if ((this.f2108g & 16) != 16 || (dVar = this.f2113l) == d.f2100l) {
                this.f2113l = dVar8;
            } else {
                b bVarG4 = d.g(dVar);
                bVarG4.g(dVar8);
                this.f2113l = bVarG4.e();
            }
            this.f2108g |= 16;
        }
        this.f3565f = this.f3565f.f(fVar.f2116f);
    }
}
