package c0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public String f2147a;

    /* renamed from: b, reason: collision with root package name */
    public String f2148b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f2149c;

    /* renamed from: d, reason: collision with root package name */
    public e f2150d;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return yb.k.a(this.f2147a, iVar.f2147a) && yb.k.a(this.f2148b, iVar.f2148b) && this.f2149c == iVar.f2149c && yb.k.a(this.f2150d, iVar.f2150d);
    }

    public final int hashCode() {
        int iH = k0.a.h(androidx.activity.b.d(this.f2147a.hashCode() * 31, 31, this.f2148b), 31, this.f2149c);
        e eVar = this.f2150d;
        return iH + (eVar == null ? 0 : eVar.hashCode());
    }

    public final String toString() {
        return "TextSubstitution(layoutCache=" + this.f2150d + ", isShowingSubstitution=" + this.f2149c + ')';
    }
}
