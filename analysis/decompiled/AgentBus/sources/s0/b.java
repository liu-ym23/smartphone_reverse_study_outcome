package s0;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final int f9166a;

    public static String a(int i2) {
        return i2 == 1 ? "Next" : i2 == 2 ? "Previous" : i2 == 3 ? "Left" : i2 == 4 ? "Right" : i2 == 5 ? "Up" : i2 == 6 ? "Down" : i2 == 7 ? "Enter" : i2 == 8 ? "Exit" : "Invalid FocusDirection";
    }

    public final boolean equals(Object obj) {
        if (obj instanceof b) {
            return this.f9166a == ((b) obj).f9166a;
        }
        return false;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f9166a);
    }

    public final String toString() {
        return a(this.f9166a);
    }
}
