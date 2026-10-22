package d5;

/* loaded from: classes3.dex */
public final class g extends l {

    /* renamed from: a, reason: collision with root package name */
    public final float f4297a;

    public g(float f) {
        this.f4297a = f;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof g) && Float.compare(this.f4297a, ((g) obj).f4297a) == 0;
    }

    public final int hashCode() {
        return Float.hashCode(this.f4297a);
    }

    public final String toString() {
        return B7.a.l("FloatValue(value=", ")", this.f4297a);
    }
}
