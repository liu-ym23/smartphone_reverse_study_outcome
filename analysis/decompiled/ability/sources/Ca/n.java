package Ca;

/* loaded from: classes4.dex */
public final class n extends G {

    /* renamed from: a, reason: collision with root package name */
    public final za.i f357a;
    public final za.g b;

    public n(za.i taskInfo, za.g gVar) {
        kotlin.jvm.internal.k.f(taskInfo, "taskInfo");
        this.f357a = taskInfo;
        this.b = gVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return kotlin.jvm.internal.k.b(this.f357a, nVar.f357a) && kotlin.jvm.internal.k.b(this.b, nVar.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.f357a.hashCode() * 31);
    }

    public final String toString() {
        return "StepExecuting(taskInfo=" + this.f357a + ", stepInfo=" + this.b + ")";
    }
}
