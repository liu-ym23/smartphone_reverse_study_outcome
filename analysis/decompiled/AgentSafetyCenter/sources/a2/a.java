package a2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f29a;

    /* renamed from: b, reason: collision with root package name */
    public final jb.b f30b;

    public a(String str, jb.b bVar) {
        this.f29a = str;
        this.f30b = bVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return yb.k.a(this.f29a, aVar.f29a) && yb.k.a(this.f30b, aVar.f30b);
    }

    public final int hashCode() {
        String str = this.f29a;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        jb.b bVar = this.f30b;
        return iHashCode + (bVar != null ? bVar.hashCode() : 0);
    }

    public final String toString() {
        return "AccessibilityAction(label=" + this.f29a + ", action=" + this.f30b + ')';
    }
}
