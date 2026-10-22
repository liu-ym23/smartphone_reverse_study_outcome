package Ca;

/* loaded from: classes4.dex */
public final class y extends G {

    /* renamed from: a, reason: collision with root package name */
    public final za.i f368a;

    public y(za.i info) {
        kotlin.jvm.internal.k.f(info, "info");
        this.f368a = info;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof y) && kotlin.jvm.internal.k.b(this.f368a, ((y) obj).f368a);
    }

    public final int hashCode() {
        return this.f368a.hashCode();
    }

    public final String toString() {
        return "TaskResumed(info=" + this.f368a + ")";
    }
}
