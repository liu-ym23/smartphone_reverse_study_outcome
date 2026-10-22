package kotlin.reflect.jvm.internal.impl.descriptors;

import E9.InterfaceC0797b;
import E9.InterfaceC0800e;
import E9.b0;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import ya.S;

/* loaded from: classes5.dex */
public interface c extends e {
    boolean X();

    InterfaceC0797b Y();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e, E9.InterfaceC0804i, E9.InterfaceC0803h
    InterfaceC0800e b();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e, E9.Y
    c c(TypeSubstitutor typeSubstitutor);

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    S getReturnType();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    List<b0> getTypeParameters();
}
