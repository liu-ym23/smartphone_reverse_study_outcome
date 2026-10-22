package s8;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class t3 {

    /* renamed from: a, reason: collision with root package name */
    public p3 f11984a;

    /* renamed from: b, reason: collision with root package name */
    public String f11985b;

    /* renamed from: c, reason: collision with root package name */
    public j3 f11986c;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t3)) {
            return false;
        }
        t3 t3Var = (t3) obj;
        return this.f11984a.equals(t3Var.f11984a) && this.f11985b.equals(t3Var.f11985b) && this.f11986c.equals(t3Var.f11986c);
    }

    public final int hashCode() {
        return this.f11986c.hashCode() + androidx.activity.b.d(this.f11984a.hashCode() * 31, 31, this.f11985b);
    }

    public final String toString() {
        return "UndoableHomeRow(line=" + this.f11984a + ", taskTitle=" + this.f11985b + ", taskGroup=" + this.f11986c + ")";
    }
}
