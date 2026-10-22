package c0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public d2.g f2133a;

    /* renamed from: b, reason: collision with root package name */
    public d2.g f2134b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f2135c;

    /* renamed from: d, reason: collision with root package name */
    public d f2136d;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return yb.k.a(this.f2133a, fVar.f2133a) && yb.k.a(this.f2134b, fVar.f2134b) && this.f2135c == fVar.f2135c && yb.k.a(this.f2136d, fVar.f2136d);
    }

    public final int hashCode() {
        int iH = k0.a.h((this.f2134b.hashCode() + (this.f2133a.hashCode() * 31)) * 31, 31, this.f2135c);
        d dVar = this.f2136d;
        return iH + (dVar == null ? 0 : dVar.hashCode());
    }

    public final String toString() {
        return "TextSubstitutionValue(original=" + ((Object) this.f2133a) + ", substitution=" + ((Object) this.f2134b) + ", isShowingSubstitution=" + this.f2135c + ", layoutCache=" + this.f2136d + ')';
    }
}
