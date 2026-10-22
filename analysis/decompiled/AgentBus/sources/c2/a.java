package c2;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final float f1857a;

    public final boolean equals(Object obj) {
        if (obj instanceof a) {
            return Float.compare(this.f1857a, ((a) obj).f1857a) == 0;
        }
        return false;
    }

    public final int hashCode() {
        return Float.hashCode(this.f1857a);
    }

    public final String toString() {
        return "BaselineShift(multiplier=" + this.f1857a + ')';
    }
}
