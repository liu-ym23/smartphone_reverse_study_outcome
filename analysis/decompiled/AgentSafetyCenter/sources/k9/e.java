package k9;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public String f7368a;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof e) && this.f7368a.equals(((e) obj).f7368a);
    }

    public final int hashCode() {
        return this.f7368a.hashCode();
    }

    public final String toString() {
        return k0.a.C("DailyStatusOutcome(rawJson=", this.f7368a, ")");
    }
}
