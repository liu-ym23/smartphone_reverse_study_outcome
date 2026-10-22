package s;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a1 implements z0 {

    /* renamed from: a, reason: collision with root package name */
    public final Object f10939a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f10940b;

    public a1(Object obj, Object obj2) {
        this.f10939a = obj;
        this.f10940b = obj2;
    }

    @Override // s.z0
    public final Object b() {
        return this.f10939a;
    }

    @Override // s.z0
    public final Object c() {
        return this.f10940b;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof z0)) {
            return false;
        }
        z0 z0Var = (z0) obj;
        return yb.k.a(this.f10939a, z0Var.b()) && yb.k.a(this.f10940b, z0Var.c());
    }

    public final int hashCode() {
        Object obj = this.f10939a;
        int iHashCode = (obj != null ? obj.hashCode() : 0) * 31;
        Object obj2 = this.f10940b;
        return iHashCode + (obj2 != null ? obj2.hashCode() : 0);
    }
}
