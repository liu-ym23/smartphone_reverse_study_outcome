package tc;

import java.util.Iterator;
import tc.s0;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class u0<Element, Array, Builder extends s0<Array>> extends o<Element, Array, Builder> {

    /* renamed from: b, reason: collision with root package name */
    public final t0 f13058b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u0(pc.a<Element> primitiveSerializer) {
        super(primitiveSerializer);
        kotlin.jvm.internal.g.f(primitiveSerializer, "primitiveSerializer");
        this.f13058b = new t0(primitiveSerializer.d());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // tc.o, pc.c
    public final void a(vc.k kVar, Object obj) {
        int iH = h(obj);
        t0 t0Var = this.f13058b;
        sc.c cVarC = kVar.C(t0Var);
        o(cVarC, obj, iH);
        cVarC.a(t0Var);
    }

    @Override // tc.a, pc.a
    public final Array b(sc.d dVar) {
        return (Array) i(dVar);
    }

    @Override // pc.c
    public final rc.e d() {
        return this.f13058b;
    }

    @Override // tc.a
    public final Object e() {
        return k(n());
    }

    @Override // tc.a
    public final int f(Object obj) {
        s0 s0Var = (s0) obj;
        kotlin.jvm.internal.g.f(s0Var, "<this>");
        return s0Var.d();
    }

    @Override // tc.a
    public final Iterator<Element> g(Array array) {
        throw new IllegalStateException("This method lead to boxing and must not be used, use writeContents instead");
    }

    @Override // tc.a
    public final Object l(Object obj) {
        s0 s0Var = (s0) obj;
        kotlin.jvm.internal.g.f(s0Var, "<this>");
        return s0Var.a();
    }

    @Override // tc.o
    public final void m(int i10, Object obj, Object obj2) {
        kotlin.jvm.internal.g.f((s0) obj, "<this>");
        throw new IllegalStateException("This method lead to boxing and must not be used, use Builder.append instead");
    }

    public abstract Array n();

    public abstract void o(sc.c cVar, Array array, int i10);
}
