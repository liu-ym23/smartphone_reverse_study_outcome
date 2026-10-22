package T8;

/* loaded from: classes4.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final G8.b f1219a;
    public final f b;

    public h(G8.b classId, f fVar) {
        kotlin.jvm.internal.k.f(classId, "classId");
        this.f1219a = classId;
        this.b = fVar;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof h) {
            return kotlin.jvm.internal.k.b(this.f1219a, ((h) obj).f1219a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f1219a.hashCode();
    }
}
