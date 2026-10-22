package l5;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b extends c {

    /* renamed from: a, reason: collision with root package name */
    public final int f7735a;

    public b(int i) {
        this.f7735a = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof b) && this.f7735a == ((b) obj).f7735a;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f7735a);
    }

    public final String toString() {
        return androidx.activity.b.l(new StringBuilder("ConstraintsNotMet(reason="), this.f7735a, ')');
    }
}
