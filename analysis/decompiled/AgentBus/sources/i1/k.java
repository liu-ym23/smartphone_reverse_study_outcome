package i1;

/* loaded from: classes.dex */
public abstract class k extends n0.l {

    /* renamed from: t, reason: collision with root package name */
    public final int f4513t = e1.e(this);

    /* renamed from: u, reason: collision with root package name */
    public n0.l f4514u;

    @Override // n0.l
    public final void b0() {
        super.b0();
        for (n0.l lVar = this.f4514u; lVar != null; lVar = lVar.f6802k) {
            lVar.k0(this.f6804m);
            if (!lVar.f6810s) {
                lVar.b0();
            }
        }
    }

    @Override // n0.l
    public final void c0() {
        for (n0.l lVar = this.f4514u; lVar != null; lVar = lVar.f6802k) {
            lVar.c0();
        }
        super.c0();
    }

    @Override // n0.l
    public final void g0() {
        super.g0();
        for (n0.l lVar = this.f4514u; lVar != null; lVar = lVar.f6802k) {
            lVar.g0();
        }
    }

    @Override // n0.l
    public final void h0() {
        for (n0.l lVar = this.f4514u; lVar != null; lVar = lVar.f6802k) {
            lVar.h0();
        }
        super.h0();
    }

    @Override // n0.l
    public final void i0() {
        super.i0();
        for (n0.l lVar = this.f4514u; lVar != null; lVar = lVar.f6802k) {
            lVar.i0();
        }
    }

    @Override // n0.l
    public final void j0(n0.l lVar) {
        this.f6797f = lVar;
        for (n0.l lVar2 = this.f4514u; lVar2 != null; lVar2 = lVar2.f6802k) {
            lVar2.j0(lVar);
        }
    }

    @Override // n0.l
    public final void k0(d1 d1Var) {
        this.f6804m = d1Var;
        for (n0.l lVar = this.f4514u; lVar != null; lVar = lVar.f6802k) {
            lVar.k0(d1Var);
        }
    }

    public final void l0(j jVar) {
        n0.l lVar = ((n0.l) jVar).f6797f;
        if (lVar != jVar) {
            n0.l lVar2 = jVar instanceof n0.l ? (n0.l) jVar : null;
            n0.l lVar3 = lVar2 != null ? lVar2.f6801j : null;
            if (lVar != this.f6797f || !q7.k.a(lVar3, this)) {
                throw new IllegalStateException("Cannot delegate to an already delegated node");
            }
            return;
        }
        if (lVar.f6810s) {
            f1.a.b("Cannot delegate to an already attached node");
        }
        lVar.j0(this.f6797f);
        int i2 = this.f6799h;
        int iF = e1.f(lVar);
        lVar.f6799h = iF;
        int i10 = this.f6799h;
        int i11 = iF & 2;
        if (i11 != 0 && (i10 & 2) != 0 && !(this instanceof v)) {
            f1.a.b("Delegating to multiple LayoutModifierNodes without the delegating node implementing LayoutModifierNode itself is not allowed.\nDelegating Node: " + this + "\nDelegate Node: " + lVar);
        }
        lVar.f6802k = this.f4514u;
        this.f4514u = lVar;
        lVar.f6801j = this;
        n0(iF | this.f6799h, false);
        if (this.f6810s) {
            if (i11 == 0 || (i2 & 2) != 0) {
                k0(this.f6804m);
            } else {
                a1 a1Var = l.u(this).H;
                this.f6797f.k0(null);
                a1Var.l();
            }
            lVar.b0();
            lVar.h0();
            if (!lVar.f6810s) {
                f1.a.b("autoInvalidateInsertedNode called on unattached node");
            }
            e1.a(lVar, -1, 1);
        }
    }

    public final void m0(j jVar) {
        n0.l lVar = null;
        for (n0.l lVar2 = this.f4514u; lVar2 != null; lVar2 = lVar2.f6802k) {
            if (lVar2 == jVar) {
                boolean z4 = lVar2.f6810s;
                if (z4) {
                    k.y yVar = e1.f4446a;
                    if (!z4) {
                        f1.a.b("autoInvalidateRemovedNode called on unattached node");
                    }
                    e1.a(lVar2, -1, 2);
                    lVar2.i0();
                    lVar2.c0();
                }
                lVar2.j0(lVar2);
                lVar2.f6800i = 0;
                if (lVar == null) {
                    this.f4514u = lVar2.f6802k;
                } else {
                    lVar.f6802k = lVar2.f6802k;
                }
                lVar2.f6802k = null;
                lVar2.f6801j = null;
                int i2 = this.f6799h;
                int iF = e1.f(this);
                n0(iF, true);
                if (this.f6810s && (i2 & 2) != 0 && (iF & 2) == 0) {
                    a1 a1Var = l.u(this).H;
                    this.f6797f.k0(null);
                    a1Var.l();
                    return;
                }
                return;
            }
            lVar = lVar2;
        }
        throw new IllegalStateException(("Could not find delegate: " + jVar).toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [n0.l] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    public final void n0(int i2, boolean z4) {
        n0.l lVar;
        int i10 = this.f6799h;
        this.f6799h = i2;
        if (i10 != i2) {
            n0.l lVar2 = this.f6797f;
            if (lVar2 == this) {
                this.f6800i = i2;
            }
            boolean z10 = this.f6810s;
            ?? r22 = this;
            if (z10) {
                while (r22 != 0) {
                    i2 |= r22.f6799h;
                    r22.f6799h = i2;
                    if (r22 == lVar2) {
                        break;
                    } else {
                        r22 = r22.f6801j;
                    }
                }
                if (z4 && r22 == lVar2) {
                    i2 = e1.f(lVar2);
                    lVar2.f6799h = i2;
                }
                int i11 = i2 | ((r22 == 0 || (lVar = r22.f6802k) == null) ? 0 : lVar.f6800i);
                for (n0.l lVar3 = r22; lVar3 != null; lVar3 = lVar3.f6801j) {
                    i11 |= lVar3.f6799h;
                    lVar3.f6800i = i11;
                }
            }
        }
    }
}
