package ba;

/* loaded from: classes.dex */
public abstract class y implements f {

    /* renamed from: a, reason: collision with root package name */
    public final q7.m f1653a;

    /* renamed from: b, reason: collision with root package name */
    public final String f1654b;

    /* JADX WARN: Multi-variable type inference failed */
    public y(String str, p7.k kVar) {
        this.f1653a = (q7.m) kVar;
        this.f1654b = "must return ".concat(str);
    }

    @Override // ba.f
    public final String a(q8.e eVar) {
        return e.invoke(this, eVar);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [p7.k, q7.m] */
    @Override // ba.f
    public final boolean b(f8.t tVar) {
        return q7.k.a(tVar.f(), this.f1653a.invoke(l9.d.e(tVar)));
    }

    @Override // ba.f
    public final String getDescription() {
        return this.f1654b;
    }
}
