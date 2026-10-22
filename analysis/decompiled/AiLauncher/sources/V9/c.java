package V9;

import E9.InterfaceC0798c;
import E9.InterfaceC0803h;
import S9.B;
import Z9.z;
import kotlin.C4848b;
import kotlin.LazyThreadSafetyMode;

/* loaded from: classes5.dex */
public final class c {
    public static final k c(k kVar, InterfaceC0803h interfaceC0803h, z zVar, int i10, Y8.h<B> hVar) {
        return new k(kVar.a(), zVar != null ? new m(kVar, interfaceC0803h, zVar, i10) : kVar.f(), hVar);
    }

    public static final k d(k kVar, p typeParameterResolver) {
        kotlin.jvm.internal.p.i(kVar, "<this>");
        kotlin.jvm.internal.p.i(typeParameterResolver, "typeParameterResolver");
        return new k(kVar.a(), typeParameterResolver, kVar.c());
    }

    public static final k e(k kVar, InterfaceC0798c containingDeclaration, z zVar, int i10) {
        kotlin.jvm.internal.p.i(kVar, "<this>");
        kotlin.jvm.internal.p.i(containingDeclaration, "containingDeclaration");
        return c(kVar, containingDeclaration, zVar, i10, C4848b.a(LazyThreadSafetyMode.NONE, new a(kVar, containingDeclaration)));
    }

    public static /* synthetic */ k f(k kVar, InterfaceC0798c interfaceC0798c, z zVar, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            zVar = null;
        }
        if ((i11 & 4) != 0) {
            i10 = 0;
        }
        return e(kVar, interfaceC0798c, zVar, i10);
    }

    public static final B g(k kVar, InterfaceC0798c interfaceC0798c) {
        return j(kVar, interfaceC0798c.getAnnotations());
    }

    public static final k h(k kVar, InterfaceC0803h containingDeclaration, z typeParameterOwner, int i10) {
        kotlin.jvm.internal.p.i(kVar, "<this>");
        kotlin.jvm.internal.p.i(containingDeclaration, "containingDeclaration");
        kotlin.jvm.internal.p.i(typeParameterOwner, "typeParameterOwner");
        return c(kVar, containingDeclaration, typeParameterOwner, i10, kVar.c());
    }

    public static /* synthetic */ k i(k kVar, InterfaceC0803h interfaceC0803h, z zVar, int i10, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            i10 = 0;
        }
        return h(kVar, interfaceC0803h, zVar, i10);
    }

    public static final B j(k kVar, F9.g additionalAnnotations) {
        kotlin.jvm.internal.p.i(kVar, "<this>");
        kotlin.jvm.internal.p.i(additionalAnnotations, "additionalAnnotations");
        return kVar.a().a().d(kVar.b(), additionalAnnotations);
    }

    public static final k k(k kVar, F9.g additionalAnnotations) {
        kotlin.jvm.internal.p.i(kVar, "<this>");
        kotlin.jvm.internal.p.i(additionalAnnotations, "additionalAnnotations");
        return additionalAnnotations.isEmpty() ? kVar : new k(kVar.a(), kVar.f(), C4848b.a(LazyThreadSafetyMode.NONE, new b(kVar, additionalAnnotations)));
    }

    public static final B l(k kVar, F9.g gVar) {
        return j(kVar, gVar);
    }

    public static final k m(k kVar, d components) {
        kotlin.jvm.internal.p.i(kVar, "<this>");
        kotlin.jvm.internal.p.i(components, "components");
        return new k(components, kVar.f(), kVar.c());
    }
}
