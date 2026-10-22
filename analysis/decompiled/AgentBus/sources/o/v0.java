package o;

import i1.s1;

/* loaded from: classes.dex */
public final class v0 extends n0.l implements s1 {

    /* renamed from: t, reason: collision with root package name */
    public y0 f7137t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f7138u;

    @Override // i1.s1
    public final void u(p1.i iVar) {
        w7.t[] tVarArr = p1.u.f8372a;
        p1.v vVar = p1.s.f8356m;
        w7.t[] tVarArr2 = p1.u.f8372a;
        w7.t tVar = tVarArr2[6];
        vVar.a(iVar, Boolean.TRUE);
        p1.g gVar = new p1.g(new u0(this, 0), new u0(this, 1));
        if (this.f7138u) {
            p1.v vVar2 = p1.s.f8364u;
            w7.t tVar2 = tVarArr2[12];
            vVar2.a(iVar, gVar);
        } else {
            p1.v vVar3 = p1.s.f8363t;
            w7.t tVar3 = tVarArr2[11];
            vVar3.a(iVar, gVar);
        }
    }
}
