package v1;

/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public final int f10356a;

    public final boolean equals(Object obj) {
        if (obj instanceof j) {
            return this.f10356a == ((j) obj).f10356a;
        }
        return false;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f10356a);
    }

    public final String toString() {
        int i2 = this.f10356a;
        return i2 == 0 ? "None" : i2 == 1 ? "Weight" : i2 == 2 ? "Style" : i2 == 65535 ? "All" : "Invalid";
    }
}
