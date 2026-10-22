package d5;

/* loaded from: classes3.dex */
public final class d extends l {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f4294a;

    public d(boolean z10) {
        this.f4294a = z10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof d) && this.f4294a == ((d) obj).f4294a;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.f4294a);
    }

    public final String toString() {
        return "BooleanValue(value=" + this.f4294a + ")";
    }
}
