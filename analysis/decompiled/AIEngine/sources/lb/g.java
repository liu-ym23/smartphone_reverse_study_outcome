package lb;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class g implements Comparable<g> {

    /* renamed from: a, reason: collision with root package name */
    public final int f10400a;

    public /* synthetic */ g(int i10) {
        this.f10400a = i10;
    }

    @Override // java.lang.Comparable
    public final int compareTo(g gVar) {
        return kotlin.jvm.internal.g.g(this.f10400a ^ Integer.MIN_VALUE, gVar.f10400a ^ Integer.MIN_VALUE);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof g) {
            return this.f10400a == ((g) obj).f10400a;
        }
        return false;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f10400a);
    }

    public final String toString() {
        return String.valueOf(this.f10400a & 4294967295L);
    }
}
