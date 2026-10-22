package Ca;

/* loaded from: classes4.dex */
public final class z extends G {

    /* renamed from: a, reason: collision with root package name */
    public final za.i f369a;
    public final za.c b;

    public z(za.i info, za.c progress) {
        kotlin.jvm.internal.k.f(info, "info");
        kotlin.jvm.internal.k.f(progress, "progress");
        this.f369a = info;
        this.b = progress;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof z)) {
            return false;
        }
        z zVar = (z) obj;
        return kotlin.jvm.internal.k.b(this.f369a, zVar.f369a) && kotlin.jvm.internal.k.b(this.b, zVar.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.f369a.hashCode() * 31);
    }

    public final String toString() {
        return "TaskRunning(info=" + this.f369a + ", progress=" + this.b + ")";
    }
}
