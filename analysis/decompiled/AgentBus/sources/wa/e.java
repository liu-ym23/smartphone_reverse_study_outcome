package wa;

/* loaded from: classes.dex */
public final class e implements sa.a {

    /* renamed from: a, reason: collision with root package name */
    public static final e f10967a = new e();

    /* renamed from: b, reason: collision with root package name */
    public static final j f10968b = new j("kotlin.Long", ua.b.f10212c);

    @Override // sa.a
    public final ua.d a() {
        return f10968b;
    }

    @Override // sa.a
    public final Object deserialize(va.b bVar) {
        q7.k.e(bVar, "decoder");
        return Long.valueOf(bVar.b());
    }

    @Override // sa.a
    public final void serialize(va.c cVar, Object obj) {
        cVar.g(((Number) obj).longValue());
    }
}
