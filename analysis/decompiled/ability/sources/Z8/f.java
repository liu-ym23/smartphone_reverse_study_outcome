package Z8;

import D7.N;
import Q8.o;
import h8.AbstractC1532o;
import h8.InterfaceC1503K;
import h8.InterfaceC1524g;
import i8.C1560f;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import kotlin.collections.EmptyList;
import kotlin.collections.EmptySet;
import kotlin.jvm.internal.k;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor$Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorEntity;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorScopeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;

/* loaded from: classes4.dex */
public class f implements o {
    public final String b;

    public f(ErrorScopeKind errorScopeKind, String... formatParams) {
        k.f(formatParams, "formatParams");
        String str = errorScopeKind.f5148a;
        Object[] objArrCopyOf = Arrays.copyOf(formatParams, formatParams.length);
        this.b = String.format(str, Arrays.copyOf(objArrCopyOf, objArrCopyOf.length));
    }

    @Override // Q8.o
    public Set a() {
        return EmptySet.f4895a;
    }

    @Override // Q8.q
    public InterfaceC1524g b(G8.f name, p8.a location) {
        k.f(name, "name");
        k.f(location, "location");
        ErrorEntity[] errorEntityArr = ErrorEntity.f5147a;
        return new a(G8.f.g(String.format("<Error class: %s>", Arrays.copyOf(new Object[]{name}, 1))));
    }

    @Override // Q8.q
    public Collection c(Q8.f kindFilter, S7.k kVar) {
        k.f(kindFilter, "kindFilter");
        return EmptyList.f4893a;
    }

    @Override // Q8.o
    public Set e() {
        return EmptySet.f4895a;
    }

    @Override // Q8.o
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public Set f(G8.f name, NoLookupLocation noLookupLocation) {
        k.f(name, "name");
        a containingDeclaration = i.c;
        k.f(containingDeclaration, "containingDeclaration");
        ErrorEntity[] errorEntityArr = ErrorEntity.f5147a;
        b bVar = new b(containingDeclaration, null, C1560f.f4611a, G8.f.g("<Error function>"), CallableMemberDescriptor$Kind.f4950a, InterfaceC1503K.f4577I);
        EmptyList emptyList = EmptyList.f4893a;
        bVar.W0(null, null, emptyList, emptyList, emptyList, i.c(ErrorTypeKind.e, new String[0]), Modality.d, AbstractC1532o.e);
        return N.Q(bVar);
    }

    @Override // Q8.o
    public Set getVariableNames() {
        return EmptySet.f4895a;
    }

    @Override // Q8.o
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public Set d(G8.f name, NoLookupLocation noLookupLocation) {
        k.f(name, "name");
        return i.f;
    }

    public String toString() {
        return B7.a.g('}', this.b, new StringBuilder("ErrorScope{"));
    }
}
