package o1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a implements o {

    /* renamed from: b, reason: collision with root package name */
    public final int f8999b;

    public a(int i) {
        this.f8999b = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!a.class.equals(obj != null ? obj.getClass() : null)) {
            return false;
        }
        obj.getClass();
        return this.f8999b == ((a) obj).f8999b;
    }

    public final int hashCode() {
        return this.f8999b;
    }

    public final String toString() {
        return androidx.activity.b.l(new StringBuilder("AndroidPointerIcon(type="), this.f8999b, ')');
    }
}
