package u1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class m extends w0.l {

    /* renamed from: s, reason: collision with root package name */
    public final int f13865s = h1.e(this);

    /* renamed from: t, reason: collision with root package name */
    public w0.l f13866t;

    @Override // w0.l
    public final void A0(g1 g1Var) {
        this.f15120l = g1Var;
        for (w0.l lVar = this.f13866t; lVar != null; lVar = lVar.f15118j) {
            lVar.A0(g1Var);
        }
    }

    public final void B0(l lVar) {
        w0.l lVar2 = ((w0.l) lVar).f15114c;
        if (lVar2 != lVar) {
            w0.l lVar3 = lVar instanceof w0.l ? (w0.l) lVar : null;
            w0.l lVar4 = lVar3 != null ? lVar3.i : null;
            if (lVar2 == this.f15114c && yb.k.a(lVar4, this)) {
                return;
            }
            od.f.e("Cannot delegate to an already delegated node");
            return;
        }
        if (lVar2.f15126r) {
            r1.a.b("Cannot delegate to an already attached node");
        }
        lVar2.z0(this.f15114c);
        int i = this.f15116g;
        int iF = h1.f(lVar2);
        lVar2.f15116g = iF;
        int i3 = this.f15116g;
        int i10 = iF & 2;
        if (i10 != 0 && (i3 & 2) != 0 && !(this instanceof w)) {
            r1.a.b("Delegating to multiple LayoutModifierNodes without the delegating node implementing LayoutModifierNode itself is not allowed.\nDelegating Node: " + this + "\nDelegate Node: " + lVar2);
        }
        lVar2.f15118j = this.f13866t;
        this.f13866t = lVar2;
        lVar2.i = this;
        D0(iF | this.f15116g, false);
        if (this.f15126r) {
            if (i10 == 0 || (i & 2) != 0) {
                A0(this.f15120l);
            } else {
                c1 c1Var = f.u(this).H;
                this.f15114c.A0(null);
                c1Var.g();
            }
            lVar2.r0();
            lVar2.x0();
            if (!lVar2.f15126r) {
                r1.a.b("autoInvalidateInsertedNode called on unattached node");
            }
            h1.a(lVar2, -1, 1);
        }
    }

    public final void C0(l lVar) {
        w0.l lVar2 = null;
        for (w0.l lVar3 = this.f13866t; lVar3 != null; lVar3 = lVar3.f15118j) {
            if (lVar3 == lVar) {
                boolean z10 = lVar3.f15126r;
                if (z10) {
                    p.z zVar = h1.f13831a;
                    if (!z10) {
                        r1.a.b("autoInvalidateRemovedNode called on unattached node");
                    }
                    h1.a(lVar3, -1, 2);
                    lVar3.y0();
                    lVar3.s0();
                }
                lVar3.z0(lVar3);
                lVar3.f15117h = 0;
                w0.l lVar4 = lVar3.f15118j;
                if (lVar2 == null) {
                    this.f13866t = lVar4;
                } else {
                    lVar2.f15118j = lVar4;
                }
                lVar3.f15118j = null;
                lVar3.i = null;
                int i = this.f15116g;
                int iF = h1.f(this);
                D0(iF, true);
                if (this.f15126r && (i & 2) != 0 && (iF & 2) == 0) {
                    c1 c1Var = f.u(this).H;
                    this.f15114c.A0(null);
                    c1Var.g();
                    return;
                }
                return;
            }
            lVar2 = lVar3;
        }
        g5.f.n(lVar, "Could not find delegate: ");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [w0.l] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    public final void D0(int i, boolean z10) {
        w0.l lVar;
        int i3 = this.f15116g;
        this.f15116g = i;
        if (i3 != i) {
            w0.l lVar2 = this.f15114c;
            if (lVar2 == this) {
                this.f15117h = i;
            }
            boolean z11 = this.f15126r;
            ?? r22 = this;
            if (z11) {
                while (r22 != 0) {
                    i |= r22.f15116g;
                    r22.f15116g = i;
                    if (r22 == lVar2) {
                        break;
                    } else {
                        r22 = r22.i;
                    }
                }
                if (z10 && r22 == lVar2) {
                    i = h1.f(lVar2);
                    lVar2.f15116g = i;
                }
                int i10 = i | ((r22 == 0 || (lVar = r22.f15118j) == null) ? 0 : lVar.f15117h);
                for (w0.l lVar3 = r22; lVar3 != null; lVar3 = lVar3.i) {
                    i10 |= lVar3.f15116g;
                    lVar3.f15117h = i10;
                }
            }
        }
    }

    @Override // w0.l
    public final void r0() {
        super.r0();
        for (w0.l lVar = this.f13866t; lVar != null; lVar = lVar.f15118j) {
            lVar.A0(this.f15120l);
            if (!lVar.f15126r) {
                lVar.r0();
            }
        }
    }

    @Override // w0.l
    public final void s0() {
        for (w0.l lVar = this.f13866t; lVar != null; lVar = lVar.f15118j) {
            lVar.s0();
        }
        super.s0();
    }

    @Override // w0.l
    public final void w0() {
        super.w0();
        for (w0.l lVar = this.f13866t; lVar != null; lVar = lVar.f15118j) {
            lVar.w0();
        }
    }

    @Override // w0.l
    public final void x0() {
        for (w0.l lVar = this.f13866t; lVar != null; lVar = lVar.f15118j) {
            lVar.x0();
        }
        super.x0();
    }

    @Override // w0.l
    public final void y0() {
        super.y0();
        for (w0.l lVar = this.f13866t; lVar != null; lVar = lVar.f15118j) {
            lVar.y0();
        }
    }

    @Override // w0.l
    public final void z0(w0.l lVar) {
        this.f15114c = lVar;
        for (w0.l lVar2 = this.f13866t; lVar2 != null; lVar2 = lVar2.f15118j) {
            lVar2.z0(lVar);
        }
    }
}
