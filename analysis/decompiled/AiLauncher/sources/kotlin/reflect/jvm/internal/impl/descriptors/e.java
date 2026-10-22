package kotlin.reflect.jvm.internal.impl.descriptors;

import E9.AbstractC0811p;
import E9.InterfaceC0803h;
import E9.S;
import E9.b0;
import E9.i0;
import java.util.Collection;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import ya.E0;

/* loaded from: classes5.dex */
public interface e extends CallableMemberDescriptor {

    public interface a<D extends e> {
        a<D> a();

        a<D> b(List<i0> list);

        D build();

        a<D> c();

        a<D> d(E0 e02);

        <V> a<D> e(a.InterfaceC0437a<V> interfaceC0437a, V v10);

        a<D> f(S s10);

        a<D> g();

        a<D> h(F9.g gVar);

        a<D> i(Modality modality);

        a<D> j();

        a<D> k(S s10);

        a<D> l(CallableMemberDescriptor callableMemberDescriptor);

        a<D> m(boolean z10);

        a<D> n(ga.e eVar);

        a<D> o(ya.S s10);

        a<D> p(List<b0> list);

        a<D> q(CallableMemberDescriptor.Kind kind);

        a<D> r(AbstractC0811p abstractC0811p);

        a<D> s(InterfaceC0803h interfaceC0803h);

        a<D> t();
    }

    boolean A();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.a, E9.InterfaceC0803h
    e a();

    @Override // E9.InterfaceC0804i, E9.InterfaceC0803h
    InterfaceC0803h b();

    e c(TypeSubstitutor typeSubstitutor);

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.a
    Collection<? extends e> d();

    boolean isInfix();

    boolean isInline();

    boolean isOperator();

    boolean isSuspend();

    e m0();

    a<? extends e> s();

    boolean w0();

    boolean z0();
}
