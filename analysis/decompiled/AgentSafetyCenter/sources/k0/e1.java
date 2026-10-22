package k0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e1 {

    /* renamed from: a, reason: collision with root package name */
    public final String f6881a;

    public e1(String str) {
        this.f6881a = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof e1) && this.f6881a.equals(((e1) obj).f6881a);
    }

    public final int hashCode() {
        return this.f6881a.hashCode();
    }

    public final String toString() {
        return a.s(new StringBuilder("OpaqueKey(key="), this.f6881a, ')');
    }
}
