package s8;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class w1 {

    /* renamed from: a, reason: collision with root package name */
    public final int f12057a;

    /* renamed from: b, reason: collision with root package name */
    public final int f12058b;

    public w1(int i, int i3) {
        this.f12057a = i;
        this.f12058b = i3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof w1)) {
            return false;
        }
        w1 w1Var = (w1) obj;
        return this.f12057a == w1Var.f12057a && this.f12058b == w1Var.f12058b;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f12058b) + (Integer.hashCode(this.f12057a) * 31);
    }

    public final String toString() {
        return "HomeEmphasisPreviewSlots(interceptItems=" + this.f12057a + ", undoableItems=" + this.f12058b + ")";
    }
}
