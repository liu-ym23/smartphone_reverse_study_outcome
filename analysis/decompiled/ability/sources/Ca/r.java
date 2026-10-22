package Ca;

/* loaded from: classes4.dex */
public final class r extends G {

    /* renamed from: a, reason: collision with root package name */
    public final za.i f361a;
    public final String b;

    public r(za.i iVar, String reason) {
        kotlin.jvm.internal.k.f(reason, "reason");
        this.f361a = iVar;
        this.b = reason;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        return kotlin.jvm.internal.k.b(this.f361a, rVar.f361a) && kotlin.jvm.internal.k.b(this.b, rVar.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.f361a.hashCode() * 31);
    }

    public final String toString() {
        return "TaskCancelled(info=" + this.f361a + ", reason=" + this.b + ")";
    }
}
