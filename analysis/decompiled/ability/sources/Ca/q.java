package Ca;

/* loaded from: classes4.dex */
public final class q extends G {

    /* renamed from: a, reason: collision with root package name */
    public final za.i f360a;
    public final za.g b;

    public q(za.i taskInfo, za.g gVar) {
        kotlin.jvm.internal.k.f(taskInfo, "taskInfo");
        this.f360a = taskInfo;
        this.b = gVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        return kotlin.jvm.internal.k.b(this.f360a, qVar.f360a) && kotlin.jvm.internal.k.b(this.b, qVar.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.f360a.hashCode() * 31);
    }

    public final String toString() {
        return "StepStarted(taskInfo=" + this.f360a + ", stepInfo=" + this.b + ")";
    }
}
