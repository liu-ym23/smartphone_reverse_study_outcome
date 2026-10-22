package c2;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final int f1860a;

    public static String a(int i2) {
        return i2 == 1 ? "Hyphens.None" : i2 == 2 ? "Hyphens.Auto" : i2 == Integer.MIN_VALUE ? "Hyphens.Unspecified" : "Invalid";
    }

    public final boolean equals(Object obj) {
        if (obj instanceof d) {
            return this.f1860a == ((d) obj).f1860a;
        }
        return false;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f1860a);
    }

    public final String toString() {
        return a(this.f1860a);
    }
}
