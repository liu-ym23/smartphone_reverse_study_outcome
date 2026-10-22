package x5;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final String f6293a;

    /* renamed from: b, reason: collision with root package name */
    public final u5.f f6294b;

    public g(String str, u5.f fVar) {
        this.f6293a = str;
        this.f6294b = fVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return kotlin.jvm.internal.p.a(this.f6293a, gVar.f6293a) && kotlin.jvm.internal.p.a(this.f6294b, gVar.f6294b);
    }

    public final int hashCode() {
        return this.f6294b.hashCode() + (this.f6293a.hashCode() * 31);
    }

    public final String toString() {
        return "MatchGroup(value=" + this.f6293a + ", range=" + this.f6294b + ')';
    }
}
