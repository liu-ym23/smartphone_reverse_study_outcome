package g0;

/* loaded from: classes.dex */
public class c extends d7.g {

    /* renamed from: h, reason: collision with root package name */
    public static final c f3672h = new c(k.f3687e, 0);

    /* renamed from: f, reason: collision with root package name */
    public final k f3673f;

    /* renamed from: g, reason: collision with root package name */
    public final int f3674g;

    public c(k kVar, int i2) {
        this.f3673f = kVar;
        this.f3674g = i2;
    }

    public final c a(Object obj, h0.a aVar) {
        d1.b bVarU = this.f3673f.u(obj != null ? obj.hashCode() : 0, 0, obj, aVar);
        return bVarU == null ? this : new c((k) bVarU.f2768h, this.f3674g + bVarU.f2767g);
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return this.f3673f.d(obj != null ? obj.hashCode() : 0, 0, obj);
    }

    @Override // java.util.Map
    public Object get(Object obj) {
        return this.f3673f.g(obj != null ? obj.hashCode() : 0, 0, obj);
    }
}
