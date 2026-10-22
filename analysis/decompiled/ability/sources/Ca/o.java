package Ca;

/* loaded from: classes4.dex */
public final class o extends G {

    /* renamed from: a, reason: collision with root package name */
    public final za.i f358a;
    public final za.g b;
    public final Throwable c;

    public o(za.i taskInfo, za.g gVar, Throwable th) {
        kotlin.jvm.internal.k.f(taskInfo, "taskInfo");
        this.f358a = taskInfo;
        this.b = gVar;
        this.c = th;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        return kotlin.jvm.internal.k.b(this.f358a, oVar.f358a) && kotlin.jvm.internal.k.b(this.b, oVar.b) && kotlin.jvm.internal.k.b(this.c, oVar.c);
    }

    public final int hashCode() {
        return this.c.hashCode() + ((this.b.hashCode() + (this.f358a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return "StepFailed(taskInfo=" + this.f358a + ", stepInfo=" + this.b + ", error=" + this.c + ")";
    }
}
