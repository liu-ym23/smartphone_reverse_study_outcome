package lb;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class e implements Comparable<e> {

    /* renamed from: a, reason: collision with root package name */
    public final byte f10396a;

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(e eVar) {
        return kotlin.jvm.internal.g.g(this.f10396a & 255, eVar.f10396a & 255);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof e) {
            return this.f10396a == ((e) obj).f10396a;
        }
        return false;
    }

    public final int hashCode() {
        return Byte.hashCode(this.f10396a);
    }

    public final String toString() {
        return String.valueOf(this.f10396a & 255);
    }
}
