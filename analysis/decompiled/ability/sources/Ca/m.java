package Ca;

/* loaded from: classes4.dex */
public final class m extends G {

    /* renamed from: a, reason: collision with root package name */
    public final za.i f356a;
    public final za.g b;

    public m(za.i taskInfo, za.g gVar) {
        kotlin.jvm.internal.k.f(taskInfo, "taskInfo");
        this.f356a = taskInfo;
        this.b = gVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return kotlin.jvm.internal.k.b(this.f356a, mVar.f356a) && kotlin.jvm.internal.k.b(this.b, mVar.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.f356a.hashCode() * 31);
    }

    public final String toString() {
        return "StepCompleted(taskInfo=" + this.f356a + ", stepInfo=" + this.b + ")";
    }
}
