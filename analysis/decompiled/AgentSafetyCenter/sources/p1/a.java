package p1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public long f9681a;

    /* renamed from: b, reason: collision with root package name */
    public float f9682b;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f9681a == aVar.f9681a && Float.compare(this.f9682b, aVar.f9682b) == 0;
    }

    public final int hashCode() {
        return Float.hashCode(this.f9682b) + (Long.hashCode(this.f9681a) * 31);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("DataPointAtTime(time=");
        sb2.append(this.f9681a);
        sb2.append(", dataPoint=");
        return k0.a.q(sb2, this.f9682b, ')');
    }
}
