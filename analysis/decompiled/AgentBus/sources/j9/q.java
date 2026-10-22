package j9;

/* loaded from: classes.dex */
public final class q extends r {

    /* renamed from: a, reason: collision with root package name */
    public final f f5416a;

    public q(f fVar) {
        this.f5416a = fVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof q) && q7.k.a(this.f5416a, ((q) obj).f5416a);
    }

    public final int hashCode() {
        return this.f5416a.hashCode();
    }

    public final String toString() {
        return "NormalClass(value=" + this.f5416a + ')';
    }
}
