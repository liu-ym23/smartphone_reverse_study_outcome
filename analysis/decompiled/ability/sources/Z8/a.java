package Z8;

import D7.N;
import Q8.o;
import X8.P;
import h8.AbstractC1532o;
import h8.InterfaceC1503K;
import h8.InterfaceC1522e;
import h8.InterfaceC1528k;
import i8.C1560f;
import java.util.List;
import k8.C1640i;
import k8.C1642k;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.k;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor$Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorScopeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;

/* loaded from: classes4.dex */
public final class a extends C1642k {
    /* JADX WARN: Illegal instructions before constructor call */
    public a(G8.f fVar) {
        i iVar = i.f1619a;
        d dVar = i.b;
        Modality modality = Modality.d;
        ClassKind classKind = ClassKind.f4951a;
        List list = EmptyList.f4893a;
        super(dVar, fVar, modality, classKind, list, W8.i.e);
        C1640i c1640i = new C1640i(this, null, C1560f.f4611a, true, CallableMemberDescriptor$Kind.f4950a, InterfaceC1503K.f4577I);
        c1640i.f1(list, AbstractC1532o.d);
        f fVarB = i.b(ErrorScopeKind.f, c1640i.getName().f690a, "");
        ErrorTypeKind errorTypeKind = ErrorTypeKind.f5159v;
        c1640i.g = new g(i.d(errorTypeKind, new String[0]), fVarB, errorTypeKind, list, false, new String[0]);
        L(fVarB, N.Q(c1640i), c1640i);
    }

    @Override // k8.AbstractC1633b
    /* renamed from: G */
    public final InterfaceC1522e b(kotlin.reflect.jvm.internal.impl.types.a substitutor) {
        k.f(substitutor, "substitutor");
        return this;
    }

    @Override // k8.AbstractC1633b, h8.InterfaceC1505M
    public final InterfaceC1528k b(kotlin.reflect.jvm.internal.impl.types.a substitutor) {
        k.f(substitutor, "substitutor");
        return this;
    }

    @Override // k8.AbstractC1633b, k8.y
    public final o k(P p, Y8.f fVar) {
        return i.b(ErrorScopeKind.f, getName().f690a, p.toString());
    }

    @Override // k8.C1642k
    public final String toString() {
        String strB = getName().b();
        k.e(strB, "asString(...)");
        return strB;
    }
}
