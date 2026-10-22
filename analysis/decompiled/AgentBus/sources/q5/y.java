package q5;

/* loaded from: classes.dex */
public final class y extends a0 {

    /* renamed from: a, reason: collision with root package name */
    public final d5.e f8781a;

    public y(d5.e eVar) {
        q7.k.e(eVar, "target");
        this.f8781a = eVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof y) && q7.k.a(this.f8781a, ((y) obj).f8781a);
    }

    public final int hashCode() {
        return this.f8781a.hashCode();
    }

    public final String toString() {
        return "Forward(target=" + this.f8781a + ")";
    }
}
