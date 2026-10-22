package q2;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final String f11491a;

    /* renamed from: b, reason: collision with root package name */
    public final Long f11492b;

    public d(String str, Long l10) {
        this.f11491a = str;
        this.f11492b = l10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return kotlin.jvm.internal.g.b(this.f11491a, dVar.f11491a) && kotlin.jvm.internal.g.b(this.f11492b, dVar.f11492b);
    }

    public final int hashCode() {
        int iHashCode = this.f11491a.hashCode() * 31;
        Long l10 = this.f11492b;
        return iHashCode + (l10 == null ? 0 : l10.hashCode());
    }

    public final String toString() {
        return "Preference(key=" + this.f11491a + ", value=" + this.f11492b + ')';
    }
}
