package D9;

import E9.InterfaceC0797b;
import Z8.C1173v;
import Z8.X;
import Z8.Y;
import java.util.Collection;
import ka.C4828h;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;

/* loaded from: classes5.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f2290a = new b();

    public static /* synthetic */ InterfaceC0797b f(b bVar, ga.c cVar, C9.j jVar, Integer num, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            num = null;
        }
        return bVar.e(cVar, jVar, num);
    }

    public final InterfaceC0797b a(InterfaceC0797b mutable) {
        kotlin.jvm.internal.p.i(mutable, "mutable");
        ga.c cVarO = a.f2270a.o(C4828h.m(mutable));
        if (cVarO != null) {
            InterfaceC0797b interfaceC0797bP = DescriptorUtilsKt.m(mutable).p(cVarO);
            kotlin.jvm.internal.p.h(interfaceC0797bP, "getBuiltInClassByFqName(...)");
            return interfaceC0797bP;
        }
        throw new IllegalArgumentException("Given class " + mutable + " is not a mutable collection");
    }

    public final InterfaceC0797b b(InterfaceC0797b readOnly) {
        kotlin.jvm.internal.p.i(readOnly, "readOnly");
        ga.c cVarP = a.f2270a.p(C4828h.m(readOnly));
        if (cVarP != null) {
            InterfaceC0797b interfaceC0797bP = DescriptorUtilsKt.m(readOnly).p(cVarP);
            kotlin.jvm.internal.p.h(interfaceC0797bP, "getBuiltInClassByFqName(...)");
            return interfaceC0797bP;
        }
        throw new IllegalArgumentException("Given class " + readOnly + " is not a read-only collection");
    }

    public final boolean c(InterfaceC0797b mutable) {
        kotlin.jvm.internal.p.i(mutable, "mutable");
        return a.f2270a.k(C4828h.m(mutable));
    }

    public final boolean d(InterfaceC0797b readOnly) {
        kotlin.jvm.internal.p.i(readOnly, "readOnly");
        return a.f2270a.l(C4828h.m(readOnly));
    }

    public final InterfaceC0797b e(ga.c fqName, C9.j builtIns, Integer num) {
        kotlin.jvm.internal.p.i(fqName, "fqName");
        kotlin.jvm.internal.p.i(builtIns, "builtIns");
        ga.b bVarM = (num == null || !kotlin.jvm.internal.p.d(fqName, a.f2270a.h())) ? a.f2270a.m(fqName) : C9.o.a(num.intValue());
        if (bVarM != null) {
            return builtIns.p(bVarM.a());
        }
        return null;
    }

    public final Collection<InterfaceC0797b> g(ga.c fqName, C9.j builtIns) {
        kotlin.jvm.internal.p.i(fqName, "fqName");
        kotlin.jvm.internal.p.i(builtIns, "builtIns");
        InterfaceC0797b interfaceC0797bF = f(this, fqName, builtIns, null, 4, null);
        if (interfaceC0797bF == null) {
            return Y.e();
        }
        ga.c cVarP = a.f2270a.p(DescriptorUtilsKt.p(interfaceC0797bF));
        if (cVarP == null) {
            return X.d(interfaceC0797bF);
        }
        InterfaceC0797b interfaceC0797bP = builtIns.p(cVarP);
        kotlin.jvm.internal.p.h(interfaceC0797bP, "getBuiltInClassByFqName(...)");
        return C1173v.p(interfaceC0797bF, interfaceC0797bP);
    }
}
