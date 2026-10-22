package c2;

/* loaded from: classes.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    public final int f1886a;

    public final boolean equals(Object obj) {
        if (obj instanceof r) {
            return this.f1886a == ((r) obj).f1886a;
        }
        return false;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f1886a);
    }

    public final String toString() {
        int i2 = this.f1886a;
        return i2 == 1 ? "Linearity.Linear" : i2 == 2 ? "Linearity.FontHinting" : i2 == 3 ? "Linearity.None" : "Invalid";
    }
}
