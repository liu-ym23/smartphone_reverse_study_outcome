package n0;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final float f6787a;

    public c(float f10) {
        this.f6787a = f10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof c) && Float.compare(this.f6787a, ((c) obj).f6787a) == 0;
    }

    public final int hashCode() {
        return Float.hashCode(this.f6787a);
    }

    public final String toString() {
        return "Horizontal(bias=" + this.f6787a + ')';
    }
}
