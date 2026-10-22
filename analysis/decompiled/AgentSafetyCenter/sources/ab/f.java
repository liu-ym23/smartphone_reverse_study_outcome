package ab;

import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public int f394a;

    /* renamed from: b, reason: collision with root package name */
    public int f395b;

    /* renamed from: c, reason: collision with root package name */
    public float f396c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f397d;

    /* renamed from: e, reason: collision with root package name */
    public y9.b f398e;

    /* renamed from: f, reason: collision with root package name */
    public a f399f;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.f394a == fVar.f394a && this.f395b == fVar.f395b && Float.compare(this.f396c, fVar.f396c) == 0 && this.f397d == fVar.f397d && k.a(this.f398e, fVar.f398e) && k.a(this.f399f, fVar.f399f);
    }

    public final int hashCode() {
        int iHashCode = (this.f398e.hashCode() + k0.a.h(k0.a.g(s.f.b(this.f395b, Integer.hashCode(this.f394a) * 31, 31), this.f396c, 31), 31, this.f397d)) * 31;
        a aVar = this.f399f;
        return iHashCode + (aVar == null ? 0 : aVar.hashCode());
    }

    public final String toString() {
        int i = this.f394a;
        int i3 = this.f395b;
        float f5 = this.f396c;
        boolean z10 = this.f397d;
        y9.b bVar = this.f398e;
        a aVar = this.f399f;
        StringBuilder sbU = k0.a.u("GlassRequest(width=", i, ", height=", ", radius=", i3);
        sbU.append(f5);
        sbU.append(", crossWindow=");
        sbU.append(z10);
        sbU.append(", effect=");
        sbU.append(bVar);
        sbU.append(", customizer=");
        sbU.append(aVar);
        sbU.append(")");
        return sbU.toString();
    }
}
