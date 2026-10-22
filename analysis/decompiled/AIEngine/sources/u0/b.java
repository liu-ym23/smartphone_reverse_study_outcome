package u0;

import java.util.Objects;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b<F, S> {

    /* renamed from: a, reason: collision with root package name */
    public final F f13138a;

    /* renamed from: b, reason: collision with root package name */
    public final S f13139b;

    public b(F f8, S s8) {
        this.f13138a = f8;
        this.f13139b = s8;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return Objects.equals(bVar.f13138a, this.f13138a) && Objects.equals(bVar.f13139b, this.f13139b);
    }

    public final int hashCode() {
        F f8 = this.f13138a;
        int iHashCode = f8 == null ? 0 : f8.hashCode();
        S s8 = this.f13139b;
        return iHashCode ^ (s8 != null ? s8.hashCode() : 0);
    }

    public final String toString() {
        return "Pair{" + this.f13138a + " " + this.f13139b + "}";
    }
}
