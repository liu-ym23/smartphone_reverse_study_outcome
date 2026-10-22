package Ca;

/* loaded from: classes4.dex */
public final class x extends G {

    /* renamed from: a, reason: collision with root package name */
    public final za.i f367a;

    public x(za.i info) {
        kotlin.jvm.internal.k.f(info, "info");
        this.f367a = info;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof x) && kotlin.jvm.internal.k.b(this.f367a, ((x) obj).f367a);
    }

    public final int hashCode() {
        return this.f367a.hashCode();
    }

    public final String toString() {
        return "TaskRecoveryStarted(info=" + this.f367a + ")";
    }
}
