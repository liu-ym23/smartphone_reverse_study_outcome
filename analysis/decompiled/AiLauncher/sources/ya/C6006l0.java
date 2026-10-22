package ya;

import E9.InterfaceC0799d;
import E9.InterfaceC0800e;
import E9.InterfaceC0803h;
import Z8.C1174w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* renamed from: ya.l0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C6006l0 {

    /* renamed from: ya.l0$a */
    public static final class a extends w0 {

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ List<v0> f44098d;

        /* JADX WARN: Multi-variable type inference failed */
        public a(List<? extends v0> list) {
            this.f44098d = list;
        }

        @Override // ya.w0
        public B0 k(v0 key) {
            kotlin.jvm.internal.p.i(key, "key");
            if (!this.f44098d.contains(key)) {
                return null;
            }
            InterfaceC0799d interfaceC0799dD = key.d();
            kotlin.jvm.internal.p.g(interfaceC0799dD, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeParameterDescriptor");
            return H0.s((E9.b0) interfaceC0799dD);
        }
    }

    public static final S a(List<? extends v0> list, List<? extends S> list2, C9.j jVar) {
        S sQ = TypeSubstitutor.h(new a(list)).q((S) Z8.F.q0(list2), Variance.OUT_VARIANCE);
        if (sQ != null) {
            return sQ;
        }
        AbstractC5990d0 abstractC5990d0Z = jVar.z();
        kotlin.jvm.internal.p.h(abstractC5990d0Z, "getDefaultBound(...)");
        return abstractC5990d0Z;
    }

    public static final S b(E9.b0 b0Var) {
        kotlin.jvm.internal.p.i(b0Var, "<this>");
        InterfaceC0803h interfaceC0803hB = b0Var.b();
        kotlin.jvm.internal.p.h(interfaceC0803hB, "getContainingDeclaration(...)");
        if (interfaceC0803hB instanceof InterfaceC0800e) {
            List<E9.b0> parameters = ((InterfaceC0800e) interfaceC0803hB).j().getParameters();
            kotlin.jvm.internal.p.h(parameters, "getParameters(...)");
            List<E9.b0> list = parameters;
            ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                v0 v0VarJ = ((E9.b0) it.next()).j();
                kotlin.jvm.internal.p.h(v0VarJ, "getTypeConstructor(...)");
                arrayList.add(v0VarJ);
            }
            List<S> upperBounds = b0Var.getUpperBounds();
            kotlin.jvm.internal.p.h(upperBounds, "getUpperBounds(...)");
            return a(arrayList, upperBounds, DescriptorUtilsKt.m(b0Var));
        }
        if (!(interfaceC0803hB instanceof kotlin.reflect.jvm.internal.impl.descriptors.e)) {
            throw new IllegalArgumentException("Unsupported descriptor type to build star projection type based on type parameters of it");
        }
        List<E9.b0> typeParameters = ((kotlin.reflect.jvm.internal.impl.descriptors.e) interfaceC0803hB).getTypeParameters();
        kotlin.jvm.internal.p.h(typeParameters, "getTypeParameters(...)");
        List<E9.b0> list2 = typeParameters;
        ArrayList arrayList2 = new ArrayList(C1174w.x(list2, 10));
        Iterator<T> it2 = list2.iterator();
        while (it2.hasNext()) {
            v0 v0VarJ2 = ((E9.b0) it2.next()).j();
            kotlin.jvm.internal.p.h(v0VarJ2, "getTypeConstructor(...)");
            arrayList2.add(v0VarJ2);
        }
        List<S> upperBounds2 = b0Var.getUpperBounds();
        kotlin.jvm.internal.p.h(upperBounds2, "getUpperBounds(...)");
        return a(arrayList2, upperBounds2, DescriptorUtilsKt.m(b0Var));
    }
}
