package L8;

/* loaded from: classes4.dex */
public final class q extends r {

    /* renamed from: a, reason: collision with root package name */
    public final f f943a;

    public q(f fVar) {
        this.f943a = fVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof q) && kotlin.jvm.internal.k.b(this.f943a, ((q) obj).f943a);
    }

    public final int hashCode() {
        return this.f943a.hashCode();
    }

    public final String toString() {
        return "NormalClass(value=" + this.f943a + ')';
    }
}
