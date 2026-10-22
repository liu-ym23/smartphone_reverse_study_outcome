package Ca;

/* loaded from: classes4.dex */
public final class t extends G {

    /* renamed from: a, reason: collision with root package name */
    public final za.i f363a;

    public t(za.i info) {
        kotlin.jvm.internal.k.f(info, "info");
        this.f363a = info;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof t) && kotlin.jvm.internal.k.b(this.f363a, ((t) obj).f363a);
    }

    public final int hashCode() {
        return this.f363a.hashCode();
    }

    public final String toString() {
        return "TaskCreated(info=" + this.f363a + ")";
    }
}
