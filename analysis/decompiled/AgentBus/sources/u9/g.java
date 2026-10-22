package u9;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final Object f10197a;

    /* renamed from: b, reason: collision with root package name */
    public final q7.m f10198b;

    /* JADX WARN: Multi-variable type inference failed */
    public g(Object obj, p7.a aVar) {
        this.f10197a = obj;
        this.f10198b = (q7.m) aVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && g.class == obj.getClass() && this.f10197a.equals(((g) obj).f10197a);
    }

    public final int hashCode() {
        return this.f10197a.hashCode();
    }
}
