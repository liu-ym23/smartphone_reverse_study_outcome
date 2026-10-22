package Ca;

/* loaded from: classes4.dex */
public final class B extends G {

    /* renamed from: a, reason: collision with root package name */
    public final za.i f339a;
    public final String b;

    public B(za.i iVar, String reason) {
        kotlin.jvm.internal.k.f(reason, "reason");
        this.f339a = iVar;
        this.b = reason;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof B)) {
            return false;
        }
        B b = (B) obj;
        return kotlin.jvm.internal.k.b(this.f339a, b.f339a) && kotlin.jvm.internal.k.b(this.b, b.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.f339a.hashCode() * 31);
    }

    public final String toString() {
        return "TaskTakenOver(info=" + this.f339a + ", reason=" + this.b + ")";
    }
}
