package v1;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final int f10355a;

    public final boolean equals(Object obj) {
        if (obj instanceof i) {
            return this.f10355a == ((i) obj).f10355a;
        }
        return false;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f10355a);
    }

    public final String toString() {
        int i2 = this.f10355a;
        return i2 == 0 ? "Normal" : i2 == 1 ? "Italic" : "Invalid";
    }
}
