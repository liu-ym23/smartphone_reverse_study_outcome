package r9;

import f8.n0;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final b9.f f9037a;

    /* renamed from: b, reason: collision with root package name */
    public final z8.i f9038b;

    /* renamed from: c, reason: collision with root package name */
    public final b9.a f9039c;

    /* renamed from: d, reason: collision with root package name */
    public final n0 f9040d;

    public d(b9.f fVar, z8.i iVar, b9.a aVar, n0 n0Var) {
        q7.k.e(fVar, "nameResolver");
        q7.k.e(iVar, "classProto");
        q7.k.e(n0Var, "sourceElement");
        this.f9037a = fVar;
        this.f9038b = iVar;
        this.f9039c = aVar;
        this.f9040d = n0Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return q7.k.a(this.f9037a, dVar.f9037a) && q7.k.a(this.f9038b, dVar.f9038b) && q7.k.a(this.f9039c, dVar.f9039c) && q7.k.a(this.f9040d, dVar.f9040d);
    }

    public final int hashCode() {
        return this.f9040d.hashCode() + ((this.f9039c.hashCode() + ((this.f9038b.hashCode() + (this.f9037a.hashCode() * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "ClassData(nameResolver=" + this.f9037a + ", classProto=" + this.f9038b + ", metadataVersion=" + this.f9039c + ", sourceElement=" + this.f9040d + ')';
    }
}
