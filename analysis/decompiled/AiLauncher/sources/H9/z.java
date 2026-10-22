package H9;

import E9.InterfaceC0797b;
import E9.InterfaceC0799d;
import E9.InterfaceC0803h;
import ra.InterfaceC5238k;
import ya.E0;

/* loaded from: classes5.dex */
public abstract class z implements InterfaceC0797b {

    /* renamed from: a, reason: collision with root package name */
    public static final a f3233a = new a(null);

    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final InterfaceC5238k a(InterfaceC0797b interfaceC0797b, E0 typeSubstitution, kotlin.reflect.jvm.internal.impl.types.checker.c kotlinTypeRefiner) {
            InterfaceC5238k interfaceC5238kT;
            kotlin.jvm.internal.p.i(interfaceC0797b, "<this>");
            kotlin.jvm.internal.p.i(typeSubstitution, "typeSubstitution");
            kotlin.jvm.internal.p.i(kotlinTypeRefiner, "kotlinTypeRefiner");
            z zVar = interfaceC0797b instanceof z ? (z) interfaceC0797b : null;
            if (zVar != null && (interfaceC5238kT = zVar.T(typeSubstitution, kotlinTypeRefiner)) != null) {
                return interfaceC5238kT;
            }
            InterfaceC5238k interfaceC5238kK0 = interfaceC0797b.k0(typeSubstitution);
            kotlin.jvm.internal.p.h(interfaceC5238kK0, "getMemberScope(...)");
            return interfaceC5238kK0;
        }

        public final InterfaceC5238k b(InterfaceC0797b interfaceC0797b, kotlin.reflect.jvm.internal.impl.types.checker.c kotlinTypeRefiner) {
            InterfaceC5238k interfaceC5238kC0;
            kotlin.jvm.internal.p.i(interfaceC0797b, "<this>");
            kotlin.jvm.internal.p.i(kotlinTypeRefiner, "kotlinTypeRefiner");
            z zVar = interfaceC0797b instanceof z ? (z) interfaceC0797b : null;
            if (zVar != null && (interfaceC5238kC0 = zVar.c0(kotlinTypeRefiner)) != null) {
                return interfaceC5238kC0;
            }
            InterfaceC5238k interfaceC5238kR = interfaceC0797b.R();
            kotlin.jvm.internal.p.h(interfaceC5238kR, "getUnsubstitutedMemberScope(...)");
            return interfaceC5238kR;
        }

        public a() {
        }
    }

    public abstract InterfaceC5238k T(E0 e02, kotlin.reflect.jvm.internal.impl.types.checker.c cVar);

    @Override // E9.InterfaceC0797b, E9.InterfaceC0803h
    public /* bridge */ /* synthetic */ InterfaceC0799d a() {
        return a();
    }

    public abstract InterfaceC5238k c0(kotlin.reflect.jvm.internal.impl.types.checker.c cVar);

    @Override // E9.InterfaceC0803h
    public /* bridge */ /* synthetic */ InterfaceC0803h a() {
        return a();
    }
}
