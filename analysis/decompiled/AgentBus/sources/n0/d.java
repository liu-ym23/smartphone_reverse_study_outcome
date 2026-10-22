package n0;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final float f6788a;

    public d(float f10) {
        this.f6788a = f10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof d) && Float.compare(this.f6788a, ((d) obj).f6788a) == 0;
    }

    public final int hashCode() {
        return Float.hashCode(this.f6788a);
    }

    public final String toString() {
        return "Vertical(bias=" + this.f6788a + ')';
    }
}
