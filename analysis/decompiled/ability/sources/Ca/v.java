package Ca;

/* loaded from: classes4.dex */
public final class v extends G {

    /* renamed from: a, reason: collision with root package name */
    public final za.i f365a;

    public v(za.i info) {
        kotlin.jvm.internal.k.f(info, "info");
        this.f365a = info;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof v) && kotlin.jvm.internal.k.b(this.f365a, ((v) obj).f365a);
    }

    public final int hashCode() {
        return this.f365a.hashCode();
    }

    public final String toString() {
        return "TaskPaused(info=" + this.f365a + ")";
    }
}
