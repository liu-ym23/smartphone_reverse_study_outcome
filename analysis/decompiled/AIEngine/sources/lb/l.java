package lb;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class l implements Comparable<l> {

    /* renamed from: a, reason: collision with root package name */
    public final short f10409a;

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(l lVar) {
        return kotlin.jvm.internal.g.g(this.f10409a & 65535, lVar.f10409a & 65535);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof l) {
            return this.f10409a == ((l) obj).f10409a;
        }
        return false;
    }

    public final int hashCode() {
        return Short.hashCode(this.f10409a);
    }

    public final String toString() {
        return String.valueOf(this.f10409a & 65535);
    }
}
