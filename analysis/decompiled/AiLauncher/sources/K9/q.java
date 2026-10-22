package K9;

/* loaded from: classes5.dex */
public final class q extends h implements Z9.h {

    /* renamed from: c, reason: collision with root package name */
    public final Class<?> f4187c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(ga.e eVar, Class<?> klass) {
        super(eVar, null);
        kotlin.jvm.internal.p.i(klass, "klass");
        this.f4187c = klass;
    }

    @Override // Z9.h
    public Z9.x b() {
        return D.f4146a.a(this.f4187c);
    }
}
