package v8;

import H4.o;
import X8.A;
import X8.AbstractC0272c;
import X8.F;
import X8.H;
import X8.K;
import X8.N;
import X8.P;
import X8.w;
import com.fasterxml.jackson.core.JsonFactory;
import e8.i;
import fa.C1449a;
import h8.InterfaceC1507O;
import h8.InterfaceC1522e;
import h8.InterfaceC1524g;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.k;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeFlexibility;
import kotlin.reflect.jvm.internal.impl.types.TypeUsage;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;

/* renamed from: v8.e, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2069e extends P {
    public static final C2065a c;
    public static final C2065a d;
    public final C1449a b = new C1449a(new C2068d());

    static {
        TypeUsage typeUsage = TypeUsage.b;
        c = C2065a.a(M.a.o0(typeUsage, false, null, 5), JavaTypeFlexibility.c, false, null, null, 61);
        d = C2065a.a(M.a.o0(typeUsage, false, null, 5), JavaTypeFlexibility.b, false, null, null, 61);
    }

    @Override // X8.P
    public final N d(w wVar) {
        return new F(h(wVar, new C2065a(TypeUsage.b, false, false, null, 62)));
    }

    public final Pair g(A a3, InterfaceC1522e interfaceC1522e, C2065a c2065a) {
        if (a3.Q().getParameters().isEmpty()) {
            return new Pair(a3, Boolean.FALSE);
        }
        if (i.y(a3)) {
            N n = (N) a3.L().get(0);
            Variance varianceA = n.a();
            w wVarB = n.b();
            k.e(wVarB, "getType(...)");
            return new Pair(AbstractC0272c.u(a3.M(), a3.Q(), o.M(new F(h(wVarB, c2065a), varianceA)), a3.W()), Boolean.FALSE);
        }
        if (AbstractC0272c.k(a3)) {
            return new Pair(Z8.i.c(ErrorTypeKind.n, a3.Q().toString()), Boolean.FALSE);
        }
        Q8.o oVarD = interfaceC1522e.D(this);
        k.e(oVarD, "getMemberScope(...)");
        H hM = a3.M();
        K kM = interfaceC1522e.m();
        k.e(kM, "getTypeConstructor(...)");
        List parameters = interfaceC1522e.m().getParameters();
        k.e(parameters, "getParameters(...)");
        List<InterfaceC1507O> list = parameters;
        ArrayList arrayList = new ArrayList(D7.w.c0(list, 10));
        for (InterfaceC1507O interfaceC1507O : list) {
            k.c(interfaceC1507O);
            C1449a c1449a = this.b;
            arrayList.add(C2068d.a(interfaceC1507O, c2065a, c1449a, c1449a.j(interfaceC1507O, c2065a)));
        }
        return new Pair(AbstractC0272c.w(hM, kM, arrayList, a3.W(), oVarD, new J4.b(interfaceC1522e, this, a3, c2065a)), Boolean.TRUE);
    }

    public final w h(w wVar, C2065a c2065a) {
        InterfaceC1524g interfaceC1524gD = wVar.Q().d();
        if (interfaceC1524gD instanceof InterfaceC1507O) {
            c2065a.getClass();
            return h(this.b.j((InterfaceC1507O) interfaceC1524gD, C2065a.a(c2065a, null, true, null, null, 59)), c2065a);
        }
        if (!(interfaceC1524gD instanceof InterfaceC1522e)) {
            throw new IllegalStateException(("Unexpected declaration kind: " + interfaceC1524gD).toString());
        }
        InterfaceC1524g interfaceC1524gD2 = AbstractC0272c.E(wVar).Q().d();
        if (interfaceC1524gD2 instanceof InterfaceC1522e) {
            Pair pairG = g(AbstractC0272c.m(wVar), (InterfaceC1522e) interfaceC1524gD, c);
            A a3 = (A) pairG.f4886a;
            boolean zBooleanValue = ((Boolean) pairG.b).booleanValue();
            Pair pairG2 = g(AbstractC0272c.E(wVar), (InterfaceC1522e) interfaceC1524gD2, d);
            A a4 = (A) pairG2.f4886a;
            return (zBooleanValue || ((Boolean) pairG2.b).booleanValue()) ? new C2071g(a3, a4) : AbstractC0272c.f(a3, a4);
        }
        throw new IllegalStateException(("For some reason declaration for upper bound is not a class but \"" + interfaceC1524gD2 + "\" while for lower it's \"" + interfaceC1524gD + JsonFactory.DEFAULT_QUOTE_CHAR).toString());
    }
}
