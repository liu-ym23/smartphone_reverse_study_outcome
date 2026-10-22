package d5;

/* loaded from: classes3.dex */
public final class j extends l {

    /* renamed from: a, reason: collision with root package name */
    public final long f4300a;

    public j(long j5) {
        this.f4300a = j5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof j) && this.f4300a == ((j) obj).f4300a;
    }

    public final int hashCode() {
        return Long.hashCode(this.f4300a);
    }

    public final String toString() {
        return androidx.compose.foundation.b.q(this.f4300a, "LongValue(value=", ")");
    }
}
