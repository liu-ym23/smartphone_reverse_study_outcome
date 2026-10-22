package wa;

/* loaded from: classes.dex */
public final class m implements sa.a {

    /* renamed from: a, reason: collision with root package name */
    public static final m f10990a = new m();

    /* renamed from: b, reason: collision with root package name */
    public static final j f10991b = new j("kotlin.String", ua.b.f10213d);

    @Override // sa.a
    public final ua.d a() {
        return f10991b;
    }

    @Override // sa.a
    public final Object deserialize(va.b bVar) {
        q7.k.e(bVar, "decoder");
        return bVar.f();
    }

    @Override // sa.a
    public final void serialize(va.c cVar, Object obj) {
        String str = (String) obj;
        q7.k.e(str, "value");
        cVar.i(str);
    }
}
