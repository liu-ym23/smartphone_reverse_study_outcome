package Ca;

/* loaded from: classes4.dex */
public final class u extends G {

    /* renamed from: a, reason: collision with root package name */
    public final za.i f364a;
    public final Throwable b;

    public u(za.i iVar, Throwable error) {
        kotlin.jvm.internal.k.f(error, "error");
        this.f364a = iVar;
        this.b = error;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof u)) {
            return false;
        }
        u uVar = (u) obj;
        return kotlin.jvm.internal.k.b(this.f364a, uVar.f364a) && kotlin.jvm.internal.k.b(this.b, uVar.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.f364a.hashCode() * 31);
    }

    public final String toString() {
        return "TaskFailed(info=" + this.f364a + ", error=" + this.b + ")";
    }
}
