package kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil;

import E9.C0813s;
import E9.C0820z;
import E9.E;
import E9.InterfaceC0797b;
import E9.InterfaceC0799d;
import E9.InterfaceC0800e;
import E9.InterfaceC0803h;
import E9.InterfaceC0819y;
import E9.O;
import E9.g0;
import E9.i0;
import Ia.b;
import Ka.j;
import Ka.t;
import Z8.C1172u;
import Z8.C1173v;
import Z8.C1174w;
import Z8.F;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import ga.c;
import ga.d;
import ga.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import ka.C4828h;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.p;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.f;
import kotlin.reflect.jvm.internal.impl.types.checker.c;
import kotlin.sequences.SequencesKt___SequencesKt;
import oa.C5014a;
import oa.C5015b;
import oa.C5016c;
import oa.C5017d;
import p9.InterfaceC5074l;
import ya.AbstractC5990d0;
import ya.S;
import za.AbstractC6475u;
import za.C6458d;
import za.C6467m;

/* loaded from: classes5.dex */
public final class DescriptorUtilsKt {

    /* renamed from: a, reason: collision with root package name */
    public static final e f36002a;

    public static final class a extends b.AbstractC0058b<CallableMemberDescriptor, CallableMemberDescriptor> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Ref$ObjectRef<CallableMemberDescriptor> f36003a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ InterfaceC5074l<CallableMemberDescriptor, Boolean> f36004b;

        /* JADX WARN: Multi-variable type inference failed */
        public a(Ref$ObjectRef<CallableMemberDescriptor> ref$ObjectRef, InterfaceC5074l<? super CallableMemberDescriptor, Boolean> interfaceC5074l) {
            this.f36003a = ref$ObjectRef;
            this.f36004b = interfaceC5074l;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // Ia.b.AbstractC0058b, Ia.b.d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(CallableMemberDescriptor current) {
            p.i(current, "current");
            if (this.f36003a.f34820a == null && this.f36004b.invoke(current).booleanValue()) {
                this.f36003a.f34820a = current;
            }
        }

        @Override // Ia.b.d
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public boolean c(CallableMemberDescriptor current) {
            p.i(current, "current");
            return this.f36003a.f34820a == null;
        }

        @Override // Ia.b.d
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public CallableMemberDescriptor a() {
            return this.f36003a.f34820a;
        }
    }

    static {
        e eVarJ = e.j(UxipConstants.f30680s);
        p.h(eVarJ, "identifier(...)");
        f36002a = eVarJ;
    }

    public static final j A(boolean z10, CallableMemberDescriptor callableMemberDescriptor) {
        p.f(callableMemberDescriptor);
        return z(callableMemberDescriptor, z10);
    }

    public static final InterfaceC0797b B(InterfaceC0819y interfaceC0819y, c topLevelClassFqName, M9.b location) {
        p.i(interfaceC0819y, "<this>");
        p.i(topLevelClassFqName, "topLevelClassFqName");
        p.i(location, "location");
        topLevelClassFqName.c();
        InterfaceC0799d interfaceC0799dD = interfaceC0819y.f0(topLevelClassFqName.d()).m().d(topLevelClassFqName.f(), location);
        if (interfaceC0799dD instanceof InterfaceC0797b) {
            return (InterfaceC0797b) interfaceC0799dD;
        }
        return null;
    }

    public static final InterfaceC0803h a(InterfaceC0803h it) {
        p.i(it, "it");
        return it.b();
    }

    public static final boolean f(i0 i0Var) {
        p.i(i0Var, "<this>");
        Boolean boolE = b.e(C1172u.e(i0Var), C5014a.f37494a, DescriptorUtilsKt$declaresOrInheritsDefaultValue$2.f36005a);
        p.h(boolE, "ifAny(...)");
        return boolE.booleanValue();
    }

    public static final Iterable g(i0 i0Var) {
        Collection<i0> collectionD = i0Var.d();
        ArrayList arrayList = new ArrayList(C1174w.x(collectionD, 10));
        Iterator<T> it = collectionD.iterator();
        while (it.hasNext()) {
            arrayList.add(((i0) it.next()).a());
        }
        return arrayList;
    }

    public static final CallableMemberDescriptor h(CallableMemberDescriptor callableMemberDescriptor, boolean z10, InterfaceC5074l<? super CallableMemberDescriptor, Boolean> predicate) {
        p.i(callableMemberDescriptor, "<this>");
        p.i(predicate, "predicate");
        return (CallableMemberDescriptor) b.b(C1172u.e(callableMemberDescriptor), new C5016c(z10), new a(new Ref$ObjectRef(), predicate));
    }

    public static /* synthetic */ CallableMemberDescriptor i(CallableMemberDescriptor callableMemberDescriptor, boolean z10, InterfaceC5074l interfaceC5074l, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        return h(callableMemberDescriptor, z10, interfaceC5074l);
    }

    public static final Iterable j(boolean z10, CallableMemberDescriptor callableMemberDescriptor) {
        Collection<? extends CallableMemberDescriptor> collectionD;
        if (z10) {
            callableMemberDescriptor = callableMemberDescriptor != null ? callableMemberDescriptor.a() : null;
        }
        return (callableMemberDescriptor == null || (collectionD = callableMemberDescriptor.d()) == null) ? C1173v.m() : collectionD;
    }

    public static final c k(InterfaceC0803h interfaceC0803h) {
        p.i(interfaceC0803h, "<this>");
        d dVarP = p(interfaceC0803h);
        if (!dVarP.f()) {
            dVarP = null;
        }
        if (dVarP != null) {
            return dVarP.m();
        }
        return null;
    }

    public static final InterfaceC0797b l(F9.c cVar) {
        p.i(cVar, "<this>");
        InterfaceC0799d interfaceC0799dD = cVar.getType().H0().d();
        if (interfaceC0799dD instanceof InterfaceC0797b) {
            return (InterfaceC0797b) interfaceC0799dD;
        }
        return null;
    }

    public static final C9.j m(InterfaceC0803h interfaceC0803h) {
        p.i(interfaceC0803h, "<this>");
        return s(interfaceC0803h).g();
    }

    public static final ga.b n(InterfaceC0799d interfaceC0799d) {
        InterfaceC0803h interfaceC0803hB;
        ga.b bVarN;
        if (interfaceC0799d != null && (interfaceC0803hB = interfaceC0799d.b()) != null) {
            if (interfaceC0803hB instanceof E) {
                c cVarF = ((E) interfaceC0803hB).f();
                e name = interfaceC0799d.getName();
                p.h(name, "getName(...)");
                return new ga.b(cVarF, name);
            }
            if ((interfaceC0803hB instanceof InterfaceC0800e) && (bVarN = n((InterfaceC0799d) interfaceC0803hB)) != null) {
                e name2 = interfaceC0799d.getName();
                p.h(name2, "getName(...)");
                return bVarN.d(name2);
            }
        }
        return null;
    }

    public static final c o(InterfaceC0803h interfaceC0803h) {
        p.i(interfaceC0803h, "<this>");
        c cVarN = C4828h.n(interfaceC0803h);
        p.h(cVarN, "getFqNameSafe(...)");
        return cVarN;
    }

    public static final d p(InterfaceC0803h interfaceC0803h) {
        p.i(interfaceC0803h, "<this>");
        d dVarM = C4828h.m(interfaceC0803h);
        p.h(dVarM, "getFqName(...)");
        return dVarM;
    }

    public static final C0813s<AbstractC5990d0> q(InterfaceC0797b interfaceC0797b) {
        g0<AbstractC5990d0> g0VarP = interfaceC0797b != null ? interfaceC0797b.P() : null;
        if (g0VarP instanceof C0813s) {
            return (C0813s) g0VarP;
        }
        return null;
    }

    public static final kotlin.reflect.jvm.internal.impl.types.checker.c r(InterfaceC0819y interfaceC0819y) {
        p.i(interfaceC0819y, "<this>");
        C6467m c6467m = (C6467m) interfaceC0819y.q0(C6458d.a());
        AbstractC6475u abstractC6475u = c6467m != null ? (AbstractC6475u) c6467m.a() : null;
        return abstractC6475u instanceof AbstractC6475u.a ? ((AbstractC6475u.a) abstractC6475u).b() : c.a.f36099a;
    }

    public static final InterfaceC0819y s(InterfaceC0803h interfaceC0803h) {
        p.i(interfaceC0803h, "<this>");
        InterfaceC0819y interfaceC0819yG = C4828h.g(interfaceC0803h);
        p.h(interfaceC0819yG, "getContainingModule(...)");
        return interfaceC0819yG;
    }

    public static final C0820z<AbstractC5990d0> t(InterfaceC0797b interfaceC0797b) {
        g0<AbstractC5990d0> g0VarP = interfaceC0797b != null ? interfaceC0797b.P() : null;
        if (g0VarP instanceof C0820z) {
            return (C0820z) g0VarP;
        }
        return null;
    }

    public static final j<InterfaceC0803h> u(InterfaceC0803h interfaceC0803h) {
        p.i(interfaceC0803h, "<this>");
        return SequencesKt___SequencesKt.E(v(interfaceC0803h), 1);
    }

    public static final j<InterfaceC0803h> v(InterfaceC0803h interfaceC0803h) {
        p.i(interfaceC0803h, "<this>");
        return t.q(interfaceC0803h, C5015b.f37495a);
    }

    public static final CallableMemberDescriptor w(CallableMemberDescriptor callableMemberDescriptor) {
        p.i(callableMemberDescriptor, "<this>");
        if (!(callableMemberDescriptor instanceof f)) {
            return callableMemberDescriptor;
        }
        O oQ = ((f) callableMemberDescriptor).Q();
        p.h(oQ, "getCorrespondingProperty(...)");
        return oQ;
    }

    public static final InterfaceC0797b x(InterfaceC0797b interfaceC0797b) {
        p.i(interfaceC0797b, "<this>");
        for (S s10 : interfaceC0797b.n().H0().e()) {
            if (!C9.j.c0(s10)) {
                InterfaceC0799d interfaceC0799dD = s10.H0().d();
                if (C4828h.w(interfaceC0799dD)) {
                    p.g(interfaceC0799dD, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                    return (InterfaceC0797b) interfaceC0799dD;
                }
            }
        }
        return null;
    }

    public static final boolean y(InterfaceC0819y interfaceC0819y) {
        AbstractC6475u abstractC6475u;
        p.i(interfaceC0819y, "<this>");
        C6467m c6467m = (C6467m) interfaceC0819y.q0(C6458d.a());
        return (c6467m == null || (abstractC6475u = (AbstractC6475u) c6467m.a()) == null || !abstractC6475u.a()) ? false : true;
    }

    public static final j<CallableMemberDescriptor> z(CallableMemberDescriptor callableMemberDescriptor, boolean z10) {
        p.i(callableMemberDescriptor, "<this>");
        if (z10) {
            callableMemberDescriptor = callableMemberDescriptor.a();
        }
        j jVarW = t.w(callableMemberDescriptor);
        Collection<? extends CallableMemberDescriptor> collectionD = callableMemberDescriptor.d();
        p.h(collectionD, "getOverriddenDescriptors(...)");
        return SequencesKt___SequencesKt.V(jVarW, SequencesKt___SequencesKt.L(F.d0(collectionD), new C5017d(z10)));
    }
}
