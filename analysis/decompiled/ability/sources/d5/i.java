package d5;

/* loaded from: classes3.dex */
public final class i extends l {

    /* renamed from: a, reason: collision with root package name */
    public final int f4299a;

    public i(int i) {
        this.f4299a = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof i) && this.f4299a == ((i) obj).f4299a;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f4299a);
    }

    public final String toString() {
        return androidx.appfunctions.metadata.a.i(this.f4299a, "IntValue(value=", ")");
    }
}
