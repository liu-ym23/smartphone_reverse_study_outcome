package Ca;

/* loaded from: classes4.dex */
public final class A extends G {

    /* renamed from: a, reason: collision with root package name */
    public final za.i f338a;

    public A(za.i info) {
        kotlin.jvm.internal.k.f(info, "info");
        this.f338a = info;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof A) && kotlin.jvm.internal.k.b(this.f338a, ((A) obj).f338a);
    }

    public final int hashCode() {
        return this.f338a.hashCode();
    }

    public final String toString() {
        return "TaskStarted(info=" + this.f338a + ")";
    }
}
