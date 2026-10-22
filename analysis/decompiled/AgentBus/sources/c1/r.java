package c1;

/* loaded from: classes.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    public final int f1838a;

    public final boolean equals(Object obj) {
        if (obj instanceof r) {
            return this.f1838a == ((r) obj).f1838a;
        }
        return false;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f1838a);
    }

    public final String toString() {
        return "PointerKeyboardModifiers(packedValue=" + this.f1838a + ')';
    }
}
