package wa;

/* loaded from: classes.dex */
public final class f implements sa.a {

    /* renamed from: a, reason: collision with root package name */
    public final sa.a f10969a;

    /* renamed from: b, reason: collision with root package name */
    public final k f10970b;

    public f(sa.a aVar) {
        this.f10969a = aVar;
        this.f10970b = new k(aVar.a());
    }

    @Override // sa.a
    public final ua.d a() {
        return this.f10970b;
    }

    @Override // sa.a
    public final Object deserialize(va.b bVar) {
        q7.k.e(bVar, "decoder");
        if (bVar.d()) {
            return bVar.c(this.f10969a);
        }
        return null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && f.class == obj.getClass() && q7.k.a(this.f10969a, ((f) obj).f10969a);
    }

    public final int hashCode() {
        return this.f10969a.hashCode();
    }

    @Override // sa.a
    public final void serialize(va.c cVar, Object obj) {
        if (obj != null) {
            cVar.h(this.f10969a, obj);
        } else {
            cVar.c();
        }
    }
}
