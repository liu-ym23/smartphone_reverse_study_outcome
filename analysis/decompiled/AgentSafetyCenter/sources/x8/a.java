package x8;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public boolean f15590a;

    /* renamed from: b, reason: collision with root package name */
    public int f15591b;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f15590a == aVar.f15590a && this.f15591b == aVar.f15591b;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f15591b) + (Boolean.hashCode(this.f15590a) * 31);
    }

    public final String toString() {
        return "RunningTaskState(hasRunningTask=" + this.f15590a + ", runningTaskCount=" + this.f15591b + ")";
    }
}
