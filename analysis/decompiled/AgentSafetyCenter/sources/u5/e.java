package u5;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e extends g {

    /* renamed from: a, reason: collision with root package name */
    public final h1.b f14055a;

    public e(h1.b bVar) {
        this.f14055a = bVar;
    }

    @Override // u5.g
    public final h1.b a() {
        return this.f14055a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof e) && yb.k.a(this.f14055a, ((e) obj).f14055a);
    }

    public final int hashCode() {
        h1.b bVar = this.f14055a;
        if (bVar == null) {
            return 0;
        }
        return bVar.hashCode();
    }

    public final String toString() {
        return "Loading(painter=" + this.f14055a + ')';
    }
}
