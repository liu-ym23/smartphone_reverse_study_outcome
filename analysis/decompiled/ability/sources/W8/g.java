package W8;

/* loaded from: classes4.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final Object f1494a;
    public final S7.a b;

    public g(Object obj, S7.a aVar) {
        this.f1494a = obj;
        this.b = aVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && g.class == obj.getClass() && this.f1494a.equals(((g) obj).f1494a);
    }

    public final int hashCode() {
        return this.f1494a.hashCode();
    }
}
