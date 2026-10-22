package wa;

/* loaded from: classes.dex */
public final class d implements sa.a {

    /* renamed from: a, reason: collision with root package name */
    public static final d f10965a = new d();

    /* renamed from: b, reason: collision with root package name */
    public static final j f10966b = new j("kotlin.Int", ua.b.f10211b);

    @Override // sa.a
    public final ua.d a() {
        return f10966b;
    }

    @Override // sa.a
    public final Object deserialize(va.b bVar) {
        q7.k.e(bVar, "decoder");
        return Integer.valueOf(bVar.e());
    }

    @Override // sa.a
    public final void serialize(va.c cVar, Object obj) {
        cVar.e(((Number) obj).intValue());
    }
}
