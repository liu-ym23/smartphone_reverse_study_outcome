package v9;

import java.util.List;

/* loaded from: classes.dex */
public final class a0 extends z {

    /* renamed from: g, reason: collision with root package name */
    public final m0 f10533g;

    /* renamed from: h, reason: collision with root package name */
    public final List f10534h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f10535i;

    /* renamed from: j, reason: collision with root package name */
    public final o9.n f10536j;

    /* renamed from: k, reason: collision with root package name */
    public final p7.k f10537k;

    public a0(m0 m0Var, List list, boolean z4, o9.n nVar, p7.k kVar) {
        q7.k.e(m0Var, "constructor");
        q7.k.e(list, "arguments");
        q7.k.e(nVar, "memberScope");
        this.f10533g = m0Var;
        this.f10534h = list;
        this.f10535i = z4;
        this.f10536j = nVar;
        this.f10537k = kVar;
        if (!(nVar instanceof x9.e) || (nVar instanceof x9.j)) {
            return;
        }
        throw new IllegalStateException("SimpleTypeImpl should not be created for error type: " + nVar + '\n' + m0Var);
    }

    @Override // v9.v
    public final List C0() {
        return this.f10534h;
    }

    @Override // v9.v
    public final i0 D0() {
        i0.f10557g.getClass();
        return i0.f10558h;
    }

    @Override // v9.v
    public final m0 E0() {
        return this.f10533g;
    }

    @Override // v9.v
    public final boolean F0() {
        return this.f10535i;
    }

    @Override // v9.v
    public final v G0(w9.g gVar) {
        q7.k.e(gVar, "kotlinTypeRefiner");
        z zVar = (z) this.f10537k.invoke(gVar);
        return zVar == null ? this : zVar;
    }

    @Override // v9.z0
    /* renamed from: J0 */
    public final z0 G0(w9.g gVar) {
        q7.k.e(gVar, "kotlinTypeRefiner");
        z zVar = (z) this.f10537k.invoke(gVar);
        return zVar == null ? this : zVar;
    }

    @Override // v9.z
    /* renamed from: L0 */
    public final z I0(boolean z4) {
        return z4 == this.f10535i ? this : z4 ? new y(this, 1) : new y(this, 0);
    }

    @Override // v9.z
    /* renamed from: M0 */
    public final z K0(i0 i0Var) {
        q7.k.e(i0Var, "newAttributes");
        return i0Var.isEmpty() ? this : new b0(this, i0Var);
    }

    @Override // v9.v
    public final o9.n v0() {
        return this.f10536j;
    }
}
