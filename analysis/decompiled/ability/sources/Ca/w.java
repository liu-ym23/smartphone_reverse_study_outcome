package Ca;

/* loaded from: classes4.dex */
public final class w extends G {

    /* renamed from: a, reason: collision with root package name */
    public final za.i f366a;

    public w(za.i info) {
        kotlin.jvm.internal.k.f(info, "info");
        this.f366a = info;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof w) && kotlin.jvm.internal.k.b(this.f366a, ((w) obj).f366a);
    }

    public final int hashCode() {
        return this.f366a.hashCode();
    }

    public final String toString() {
        return "TaskRecoveredFromTakeover(info=" + this.f366a + ")";
    }
}
