package z0;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final int f11754a;

    public final boolean equals(Object obj) {
        if (obj instanceof a) {
            return this.f11754a == ((a) obj).f11754a;
        }
        return false;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f11754a);
    }

    public final String toString() {
        int i2 = this.f11754a;
        return i2 == 1 ? "Touch" : i2 == 2 ? "Keyboard" : "Error";
    }
}
