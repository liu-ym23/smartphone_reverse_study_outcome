package f9;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final Object f3556a;

    /* renamed from: b, reason: collision with root package name */
    public final int f3557b;

    public g(int i2, Object obj) {
        this.f3556a = obj;
        this.f3557b = i2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return this.f3556a == gVar.f3556a && this.f3557b == gVar.f3557b;
    }

    public final int hashCode() {
        return (System.identityHashCode(this.f3556a) * 65535) + this.f3557b;
    }
}
