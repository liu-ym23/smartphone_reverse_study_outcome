package K9;

/* loaded from: classes5.dex */
public final class u extends h implements Z9.m {

    /* renamed from: c, reason: collision with root package name */
    public final Enum<?> f4191c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(ga.e eVar, Enum<?> value) {
        super(eVar, null);
        kotlin.jvm.internal.p.i(value, "value");
        this.f4191c = value;
    }

    @Override // Z9.m
    public ga.b d() {
        Class<?> enclosingClass = this.f4191c.getClass();
        if (!enclosingClass.isEnum()) {
            enclosingClass = enclosingClass.getEnclosingClass();
        }
        kotlin.jvm.internal.p.f(enclosingClass);
        return C0925f.e(enclosingClass);
    }

    @Override // Z9.m
    public ga.e e() {
        return ga.e.j(this.f4191c.name());
    }
}
