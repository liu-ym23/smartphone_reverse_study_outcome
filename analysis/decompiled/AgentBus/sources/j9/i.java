package j9;

import f8.z;

/* loaded from: classes.dex */
public final class i extends g {

    /* renamed from: b, reason: collision with root package name */
    public final e9.b f5409b;

    /* renamed from: c, reason: collision with root package name */
    public final e9.f f5410c;

    public i(e9.b bVar, e9.f fVar) {
        super(new c7.j(bVar, fVar));
        this.f5409b = bVar;
        this.f5410c = fVar;
    }

    @Override // j9.g
    public final v9.v a(z zVar) {
        q7.k.e(zVar, "module");
        e9.b bVar = this.f5409b;
        f8.e eVarD = f8.v.d(zVar, bVar);
        v9.z zVarK = null;
        if (eVarD != null) {
            if (!h9.f.n(eVarD, 3)) {
                eVarD = null;
            }
            if (eVarD != null) {
                zVarK = eVarD.k();
            }
        }
        if (zVarK != null) {
            return zVarK;
        }
        String string = bVar.toString();
        q7.k.d(string, "enumClassId.toString()");
        String str = this.f5410c.f3197f;
        q7.k.d(str, "enumEntryName.toString()");
        return x9.i.c(x9.h.F, string, str);
    }

    @Override // j9.g
    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f5409b.i());
        sb2.append('.');
        sb2.append(this.f5410c);
        return sb2.toString();
    }
}
