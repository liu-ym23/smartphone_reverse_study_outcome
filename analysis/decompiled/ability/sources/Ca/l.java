package Ca;

/* loaded from: classes4.dex */
public final class l extends G {

    /* renamed from: a, reason: collision with root package name */
    public final za.i f355a;
    public final za.g b;

    public l(za.i taskInfo, za.g gVar) {
        kotlin.jvm.internal.k.f(taskInfo, "taskInfo");
        this.f355a = taskInfo;
        this.b = gVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return kotlin.jvm.internal.k.b(this.f355a, lVar.f355a) && kotlin.jvm.internal.k.b(this.b, lVar.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.f355a.hashCode() * 31);
    }

    public final String toString() {
        return "StepCancelled(taskInfo=" + this.f355a + ", stepInfo=" + this.b + ")";
    }
}
