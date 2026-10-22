package i9;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public String f5844a;

    /* renamed from: b, reason: collision with root package name */
    public String f5845b;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f5844a.equals(cVar.f5844a) && this.f5845b.equals(cVar.f5845b);
    }

    public final int hashCode() {
        return this.f5845b.hashCode() + (this.f5844a.hashCode() * 31);
    }

    public final String toString() {
        return androidx.activity.b.k("LauncherAppRow(packageName=", this.f5844a, ", displayLabel=", this.f5845b, ")");
    }
}
