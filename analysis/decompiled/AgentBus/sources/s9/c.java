package s9;

import f8.e0;
import f8.z;
import i5.f;
import i8.c0;
import o9.n;
import r9.i;
import t9.p;
import u9.k;
import z8.b0;
import z8.d0;
import z8.j0;
import z8.k0;

/* loaded from: classes.dex */
public final class c extends c0 implements e0 {

    /* renamed from: l, reason: collision with root package name */
    public final a9.a f9623l;

    /* renamed from: m, reason: collision with root package name */
    public final q6.b f9624m;

    /* renamed from: n, reason: collision with root package name */
    public final f f9625n;

    /* renamed from: o, reason: collision with root package name */
    public d0 f9626o;

    /* renamed from: p, reason: collision with root package name */
    public p f9627p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(e9.c cVar, k kVar, z zVar, d0 d0Var, a9.a aVar) {
        super(zVar, cVar);
        q7.k.e(cVar, "fqName");
        q7.k.e(zVar, "module");
        this.f9623l = aVar;
        k0 k0Var = d0Var.f12097i;
        q7.k.d(k0Var, "proto.strings");
        j0 j0Var = d0Var.f12098j;
        q7.k.d(j0Var, "proto.qualifiedNames");
        q6.b bVar = new q6.b(k0Var, j0Var);
        this.f9624m = bVar;
        this.f9625n = new f(d0Var, bVar, aVar, new r9.z(this));
        this.f9626o = d0Var;
    }

    public final void H0(i iVar) {
        q7.k.e(iVar, "components");
        d0 d0Var = this.f9626o;
        if (d0Var == null) {
            throw new IllegalStateException("Repeated call to DeserializedPackageFragmentImpl::initialize");
        }
        this.f9626o = null;
        b0 b0Var = d0Var.f12099k;
        q7.k.d(b0Var, "proto.`package`");
        this.f9627p = new p(this, b0Var, this.f9624m, this.f9623l, null, iVar, "scope of " + this, new a8.c(27, this));
    }

    @Override // i8.c0, i8.m
    public final String toString() {
        return "builtins package fragment for " + this.f4758j + " from " + l9.d.j(this);
    }

    @Override // f8.e0
    public final n v0() {
        p pVar = this.f9627p;
        if (pVar != null) {
            return pVar;
        }
        q7.k.j("_memberScope");
        throw null;
    }
}
