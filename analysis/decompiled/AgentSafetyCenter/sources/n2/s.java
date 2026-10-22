package n2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class s {

    /* renamed from: c, reason: collision with root package name */
    public static final s f8675c = new s(2, false);

    /* renamed from: d, reason: collision with root package name */
    public static final s f8676d = new s(1, true);

    /* renamed from: a, reason: collision with root package name */
    public final int f8677a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f8678b;

    public s(int i, boolean z10) {
        this.f8677a = i;
        this.f8678b = z10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        return this.f8677a == sVar.f8677a && this.f8678b == sVar.f8678b;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.f8678b) + (Integer.hashCode(this.f8677a) * 31);
    }

    public final String toString() {
        return equals(f8675c) ? "TextMotion.Static" : equals(f8676d) ? "TextMotion.Animated" : "Invalid";
    }
}
