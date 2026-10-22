package w;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public int f13527a;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof a) && this.f13527a == ((a) obj).f13527a;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f13527a);
    }

    public final String toString() {
        return a0.a.l(new StringBuilder("DeltaCounter(count="), this.f13527a, ')');
    }
}
