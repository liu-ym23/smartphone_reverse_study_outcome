package r9;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final e9.b f9041a;

    /* renamed from: b, reason: collision with root package name */
    public final d f9042b;

    public f(e9.b bVar, d dVar) {
        q7.k.e(bVar, "classId");
        this.f9041a = bVar;
        this.f9042b = dVar;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof f) {
            return q7.k.a(this.f9041a, ((f) obj).f9041a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f9041a.hashCode();
    }
}
