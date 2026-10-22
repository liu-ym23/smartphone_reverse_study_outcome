package z7;

/* loaded from: classes.dex */
public final /* synthetic */ class r0 extends q7.h implements p7.n {

    /* renamed from: n, reason: collision with root package name */
    public static final r0 f11945n = new r0(2);

    @Override // q7.c
    public final String A() {
        return "loadProperty(Lorg/jetbrains/kotlin/metadata/ProtoBuf$Property;)Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;";
    }

    @Override // q7.c, w7.c
    public final String getName() {
        return "loadProperty";
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        r9.r rVar = (r9.r) obj;
        z8.f0 f0Var = (z8.f0) obj2;
        q7.k.e(rVar, "p0");
        q7.k.e(f0Var, "p1");
        return rVar.f(f0Var);
    }

    @Override // q7.c
    public final w7.f y() {
        return q7.w.f8821a.b(r9.r.class);
    }
}
