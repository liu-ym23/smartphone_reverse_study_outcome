package za;

import E9.InterfaceC0803h;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import la.C4882e;
import ya.B0;
import ya.H0;
import ya.S;
import ya.v0;
import ya.w0;

/* renamed from: za.v, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C6476v {
    public static final S a(S s10) {
        return Ea.c.b(s10).d();
    }

    public static final String b(v0 v0Var) {
        StringBuilder sb2 = new StringBuilder();
        c("type: " + v0Var, sb2);
        c("hashCode: " + v0Var.hashCode(), sb2);
        c("javaClass: " + v0Var.getClass().getCanonicalName(), sb2);
        for (InterfaceC0803h interfaceC0803hD = v0Var.d(); interfaceC0803hD != null; interfaceC0803hD = interfaceC0803hD.b()) {
            c("fqName: " + kotlin.reflect.jvm.internal.impl.renderer.b.f35917h.M(interfaceC0803hD), sb2);
            c("javaClass: " + interfaceC0803hD.getClass().getCanonicalName(), sb2);
        }
        return sb2.toString();
    }

    public static final StringBuilder c(String str, StringBuilder sb2) {
        kotlin.jvm.internal.p.i(str, "<this>");
        sb2.append(str);
        sb2.append('\n');
        return sb2;
    }

    public static final S d(S subtype, S supertype, InterfaceC6473s typeCheckingProcedureCallbacks) {
        kotlin.jvm.internal.p.i(subtype, "subtype");
        kotlin.jvm.internal.p.i(supertype, "supertype");
        kotlin.jvm.internal.p.i(typeCheckingProcedureCallbacks, "typeCheckingProcedureCallbacks");
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.add(new C6470p(subtype, null));
        v0 v0VarH0 = supertype.H0();
        while (!arrayDeque.isEmpty()) {
            C6470p c6470p = (C6470p) arrayDeque.poll();
            S sB = c6470p.b();
            v0 v0VarH02 = sB.H0();
            if (typeCheckingProcedureCallbacks.a(v0VarH02, v0VarH0)) {
                boolean zI0 = sB.I0();
                for (C6470p c6470pA = c6470p.a(); c6470pA != null; c6470pA = c6470pA.a()) {
                    S sB2 = c6470pA.b();
                    List<B0> listF0 = sB2.F0();
                    if ((listF0 instanceof Collection) && listF0.isEmpty()) {
                        sB = w0.f44131c.a(sB2).c().o(sB, Variance.INVARIANT);
                        kotlin.jvm.internal.p.f(sB);
                    } else {
                        Iterator<T> it = listF0.iterator();
                        while (it.hasNext()) {
                            Variance varianceC = ((B0) it.next()).c();
                            Variance variance = Variance.INVARIANT;
                            if (varianceC != variance) {
                                S sO = C4882e.h(w0.f44131c.a(sB2), false, 1, null).c().o(sB, variance);
                                kotlin.jvm.internal.p.h(sO, "safeSubstitute(...)");
                                sB = a(sO);
                                break;
                            }
                        }
                        sB = w0.f44131c.a(sB2).c().o(sB, Variance.INVARIANT);
                        kotlin.jvm.internal.p.f(sB);
                    }
                    zI0 = zI0 || sB2.I0();
                }
                v0 v0VarH03 = sB.H0();
                if (typeCheckingProcedureCallbacks.a(v0VarH03, v0VarH0)) {
                    return H0.p(sB, zI0);
                }
                throw new AssertionError("Type constructors should be equals!\nsubstitutedSuperType: " + b(v0VarH03) + ", \n\nsupertype: " + b(v0VarH0) + " \n" + typeCheckingProcedureCallbacks.a(v0VarH03, v0VarH0));
            }
            for (S s10 : v0VarH02.e()) {
                kotlin.jvm.internal.p.f(s10);
                arrayDeque.add(new C6470p(s10, c6470p));
            }
        }
        return null;
    }
}
