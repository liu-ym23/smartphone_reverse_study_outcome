package y;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public int f15788a;

    /* renamed from: b, reason: collision with root package name */
    public int f15789b;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return this.f15788a == mVar.f15788a && this.f15789b == mVar.f15789b;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f15789b) + (Integer.hashCode(this.f15788a) * 31);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("Interval(start=");
        sb2.append(this.f15788a);
        sb2.append(", end=");
        return androidx.activity.b.l(sb2, this.f15789b, ')');
    }
}
