package kotlin.reflect.jvm.internal.impl.resolve;

import E9.E;
import E9.InterfaceC0797b;
import E9.InterfaceC0799d;
import E9.InterfaceC0803h;
import E9.InterfaceC0816v;
import E9.W;
import E9.b0;
import Z8.F;
import java.util.Collection;
import ka.C4823c;
import ka.C4824d;
import ka.C4825e;
import ka.C4826f;
import ka.C4828h;
import kotlin.jvm.internal.p;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.types.checker.c;
import ya.v0;

/* loaded from: classes5.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f35994a = new a();

    public static /* synthetic */ boolean f(a aVar, kotlin.reflect.jvm.internal.impl.descriptors.a aVar2, kotlin.reflect.jvm.internal.impl.descriptors.a aVar3, boolean z10, boolean z11, boolean z12, c cVar, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            z11 = true;
        }
        boolean z13 = z11;
        if ((i10 & 16) != 0) {
            z12 = false;
        }
        return aVar.e(aVar2, aVar3, z10, z13, z12, cVar);
    }

    public static final boolean g(InterfaceC0803h interfaceC0803h, InterfaceC0803h interfaceC0803h2) {
        return false;
    }

    public static final boolean h(boolean z10, kotlin.reflect.jvm.internal.impl.descriptors.a aVar, kotlin.reflect.jvm.internal.impl.descriptors.a aVar2, v0 c12, v0 c22) {
        p.i(c12, "c1");
        p.i(c22, "c2");
        if (p.d(c12, c22)) {
            return true;
        }
        InterfaceC0799d interfaceC0799dD = c12.d();
        InterfaceC0799d interfaceC0799dD2 = c22.d();
        if ((interfaceC0799dD instanceof b0) && (interfaceC0799dD2 instanceof b0)) {
            return f35994a.n((b0) interfaceC0799dD, (b0) interfaceC0799dD2, z10, new C4826f(aVar, aVar2));
        }
        return false;
    }

    public static final boolean i(kotlin.reflect.jvm.internal.impl.descriptors.a aVar, kotlin.reflect.jvm.internal.impl.descriptors.a aVar2, InterfaceC0803h interfaceC0803h, InterfaceC0803h interfaceC0803h2) {
        return p.d(interfaceC0803h, aVar) && p.d(interfaceC0803h2, aVar2);
    }

    public static /* synthetic */ boolean l(a aVar, InterfaceC0803h interfaceC0803h, InterfaceC0803h interfaceC0803h2, boolean z10, boolean z11, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            z11 = true;
        }
        return aVar.k(interfaceC0803h, interfaceC0803h2, z10, z11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ boolean o(a aVar, b0 b0Var, b0 b0Var2, boolean z10, p9.p pVar, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            pVar = C4823c.f34645a;
        }
        return aVar.n(b0Var, b0Var2, z10, pVar);
    }

    public static final boolean p(InterfaceC0803h interfaceC0803h, InterfaceC0803h interfaceC0803h2) {
        return false;
    }

    public final boolean e(kotlin.reflect.jvm.internal.impl.descriptors.a a10, kotlin.reflect.jvm.internal.impl.descriptors.a b10, boolean z10, boolean z11, boolean z12, c kotlinTypeRefiner) {
        p.i(a10, "a");
        p.i(b10, "b");
        p.i(kotlinTypeRefiner, "kotlinTypeRefiner");
        if (p.d(a10, b10)) {
            return true;
        }
        if (!p.d(a10.getName(), b10.getName())) {
            return false;
        }
        if (z11 && (a10 instanceof InterfaceC0816v) && (b10 instanceof InterfaceC0816v) && ((InterfaceC0816v) a10).e0() != ((InterfaceC0816v) b10).e0()) {
            return false;
        }
        if ((p.d(a10.b(), b10.b()) && (!z10 || !p.d(r(a10), r(b10)))) || C4828h.E(a10) || C4828h.E(b10) || !q(a10, b10, C4824d.f34646a, z10)) {
            return false;
        }
        OverridingUtil overridingUtilI = OverridingUtil.i(kotlinTypeRefiner, new C4825e(z10, a10, b10));
        p.h(overridingUtilI, "create(...)");
        OverridingUtil.OverrideCompatibilityInfo.Result resultC = overridingUtilI.E(a10, b10, null, !z12).c();
        OverridingUtil.OverrideCompatibilityInfo.Result result = OverridingUtil.OverrideCompatibilityInfo.Result.OVERRIDABLE;
        return resultC == result && overridingUtilI.E(b10, a10, null, z12 ^ true).c() == result;
    }

    public final boolean j(InterfaceC0797b interfaceC0797b, InterfaceC0797b interfaceC0797b2) {
        return p.d(interfaceC0797b.j(), interfaceC0797b2.j());
    }

    public final boolean k(InterfaceC0803h interfaceC0803h, InterfaceC0803h interfaceC0803h2, boolean z10, boolean z11) {
        return ((interfaceC0803h instanceof InterfaceC0797b) && (interfaceC0803h2 instanceof InterfaceC0797b)) ? j((InterfaceC0797b) interfaceC0803h, (InterfaceC0797b) interfaceC0803h2) : ((interfaceC0803h instanceof b0) && (interfaceC0803h2 instanceof b0)) ? o(this, (b0) interfaceC0803h, (b0) interfaceC0803h2, z10, null, 8, null) : ((interfaceC0803h instanceof kotlin.reflect.jvm.internal.impl.descriptors.a) && (interfaceC0803h2 instanceof kotlin.reflect.jvm.internal.impl.descriptors.a)) ? f(this, (kotlin.reflect.jvm.internal.impl.descriptors.a) interfaceC0803h, (kotlin.reflect.jvm.internal.impl.descriptors.a) interfaceC0803h2, z10, z11, false, c.a.f36099a, 16, null) : ((interfaceC0803h instanceof E) && (interfaceC0803h2 instanceof E)) ? p.d(((E) interfaceC0803h).f(), ((E) interfaceC0803h2).f()) : p.d(interfaceC0803h, interfaceC0803h2);
    }

    public final boolean m(b0 a10, b0 b10, boolean z10) {
        p.i(a10, "a");
        p.i(b10, "b");
        return o(this, a10, b10, z10, null, 8, null);
    }

    public final boolean n(b0 a10, b0 b10, boolean z10, p9.p<? super InterfaceC0803h, ? super InterfaceC0803h, Boolean> equivalentCallables) {
        p.i(a10, "a");
        p.i(b10, "b");
        p.i(equivalentCallables, "equivalentCallables");
        if (p.d(a10, b10)) {
            return true;
        }
        return !p.d(a10.b(), b10.b()) && q(a10, b10, equivalentCallables, z10) && a10.getIndex() == b10.getIndex();
    }

    public final boolean q(InterfaceC0803h interfaceC0803h, InterfaceC0803h interfaceC0803h2, p9.p<? super InterfaceC0803h, ? super InterfaceC0803h, Boolean> pVar, boolean z10) {
        InterfaceC0803h interfaceC0803hB = interfaceC0803h.b();
        InterfaceC0803h interfaceC0803hB2 = interfaceC0803h2.b();
        return ((interfaceC0803hB instanceof CallableMemberDescriptor) || (interfaceC0803hB2 instanceof CallableMemberDescriptor)) ? pVar.invoke(interfaceC0803hB, interfaceC0803hB2).booleanValue() : l(this, interfaceC0803hB, interfaceC0803hB2, z10, false, 8, null);
    }

    public final W r(kotlin.reflect.jvm.internal.impl.descriptors.a aVar) {
        while (aVar instanceof CallableMemberDescriptor) {
            CallableMemberDescriptor callableMemberDescriptor = (CallableMemberDescriptor) aVar;
            if (callableMemberDescriptor.getKind() != CallableMemberDescriptor.Kind.FAKE_OVERRIDE) {
                break;
            }
            Collection<? extends CallableMemberDescriptor> collectionD = callableMemberDescriptor.d();
            p.h(collectionD, "getOverriddenDescriptors(...)");
            aVar = (CallableMemberDescriptor) F.Y0(collectionD);
            if (aVar == null) {
                return null;
            }
        }
        return aVar.e();
    }
}
