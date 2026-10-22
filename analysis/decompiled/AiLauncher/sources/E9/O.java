package E9;

import java.util.Collection;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;

/* loaded from: classes5.dex */
public interface O extends CallableMemberDescriptor, k0 {
    InterfaceC0812q L();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.a, E9.InterfaceC0803h
    O a();

    O c(TypeSubstitutor typeSubstitutor);

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.a
    Collection<? extends O> d();

    P getGetter();

    Q getSetter();

    InterfaceC0812q r0();

    List<kotlin.reflect.jvm.internal.impl.descriptors.f> t();
}
