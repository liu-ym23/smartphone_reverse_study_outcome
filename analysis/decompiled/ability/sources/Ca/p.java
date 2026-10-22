package Ca;

/* loaded from: classes4.dex */
public final class p extends G {

    /* renamed from: a, reason: collision with root package name */
    public final za.i f359a;
    public final za.g b;

    public p(za.i taskInfo, za.g gVar) {
        kotlin.jvm.internal.k.f(taskInfo, "taskInfo");
        this.f359a = taskInfo;
        this.b = gVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        return kotlin.jvm.internal.k.b(this.f359a, pVar.f359a) && this.b.equals(pVar.b);
    }

    public final int hashCode() {
        return Integer.hashCode(0) + ((this.b.hashCode() + (this.f359a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return "StepRetrying(taskInfo=" + this.f359a + ", stepInfo=" + this.b + ", retryCount=0)";
    }
}
