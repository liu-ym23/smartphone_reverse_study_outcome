package kotlin.reflect.jvm.internal.impl.descriptors;

import E9.InterfaceC0804i;
import E9.InterfaceC0807l;
import E9.S;
import E9.Y;
import E9.b0;
import E9.i0;
import java.util.Collection;
import java.util.List;

/* loaded from: classes5.dex */
public interface a extends InterfaceC0804i, InterfaceC0807l, Y<a> {

    /* renamed from: kotlin.reflect.jvm.internal.impl.descriptors.a$a, reason: collision with other inner class name */
    public interface InterfaceC0437a<V> {
    }

    S H();

    S K();

    @Override // E9.InterfaceC0803h
    a a();

    boolean b0();

    Collection<? extends a> d();

    ya.S getReturnType();

    List<b0> getTypeParameters();

    List<i0> i();

    <V> V o0(InterfaceC0437a<V> interfaceC0437a);

    List<S> s0();
}
