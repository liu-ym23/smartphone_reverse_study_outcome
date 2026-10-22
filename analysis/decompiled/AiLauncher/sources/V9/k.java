package V9;

import E9.InterfaceC0819y;
import S9.B;
import xa.InterfaceC5869l;

/* loaded from: classes5.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public final d f6540a;

    /* renamed from: b, reason: collision with root package name */
    public final p f6541b;

    /* renamed from: c, reason: collision with root package name */
    public final Y8.h<B> f6542c;

    /* renamed from: d, reason: collision with root package name */
    public final X9.d f6543d;

    public k(d components, p typeParameterResolver, Y8.h<B> delegateForDefaultTypeQualifiers) {
        kotlin.jvm.internal.p.i(components, "components");
        kotlin.jvm.internal.p.i(typeParameterResolver, "typeParameterResolver");
        kotlin.jvm.internal.p.i(delegateForDefaultTypeQualifiers, "delegateForDefaultTypeQualifiers");
        this.f6540a = components;
        this.f6541b = typeParameterResolver;
        this.f6542c = delegateForDefaultTypeQualifiers;
        this.f6543d = new X9.d(this, typeParameterResolver);
    }

    public final d a() {
        return this.f6540a;
    }

    public final B b() {
        return this.f6542c.getValue();
    }

    public final Y8.h<B> c() {
        return this.f6542c;
    }

    public final InterfaceC0819y d() {
        return this.f6540a.m();
    }

    public final InterfaceC5869l e() {
        return this.f6540a.u();
    }

    public final p f() {
        return this.f6541b;
    }

    public final X9.d g() {
        return this.f6543d;
    }
}
