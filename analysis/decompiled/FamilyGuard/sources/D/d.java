package D;

/* loaded from: classes.dex */
public class d<F, S> {

    /* renamed from: a, reason: collision with root package name */
    public final F f999a;

    /* renamed from: b, reason: collision with root package name */
    public final S f1000b;

    public boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return c.a(dVar.f999a, this.f999a) && c.a(dVar.f1000b, this.f1000b);
    }

    public int hashCode() {
        F f5 = this.f999a;
        int iHashCode = f5 == null ? 0 : f5.hashCode();
        S s5 = this.f1000b;
        return iHashCode ^ (s5 != null ? s5.hashCode() : 0);
    }

    public String toString() {
        return "Pair{" + this.f999a + " " + this.f1000b + "}";
    }
}
