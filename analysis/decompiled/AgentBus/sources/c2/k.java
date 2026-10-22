package c2;

/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public final int f1874a;

    public static String a(int i2) {
        return i2 == 1 ? "Left" : i2 == 2 ? "Right" : i2 == 3 ? "Center" : i2 == 4 ? "Justify" : i2 == 5 ? "Start" : i2 == 6 ? "End" : i2 == Integer.MIN_VALUE ? "Unspecified" : "Invalid";
    }

    public final boolean equals(Object obj) {
        if (obj instanceof k) {
            return this.f1874a == ((k) obj).f1874a;
        }
        return false;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f1874a);
    }

    public final String toString() {
        return a(this.f1874a);
    }
}
