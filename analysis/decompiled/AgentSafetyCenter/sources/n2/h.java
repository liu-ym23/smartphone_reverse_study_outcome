package n2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public int f8655a;

    public final boolean equals(Object obj) {
        return (obj instanceof h) && this.f8655a == ((h) obj).f8655a;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f8655a);
    }

    public final String toString() {
        int i = this.f8655a;
        return i == 1 ? "LineHeightStyle.Trim.FirstLineTop" : i == 16 ? "LineHeightStyle.Trim.LastLineBottom" : i == 17 ? "LineHeightStyle.Trim.Both" : i == 0 ? "LineHeightStyle.Trim.None" : "Invalid";
    }
}
