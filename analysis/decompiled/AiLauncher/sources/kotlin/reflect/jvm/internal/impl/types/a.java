package kotlin.reflect.jvm.internal.impl.types;

import Ca.g;
import Ca.h;
import Ca.n;
import Ca.q;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.internal.p;
import kotlin.reflect.jvm.internal.impl.types.TypeCheckerState;

/* loaded from: classes5.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f36091a = new a();

    public final boolean a(TypeCheckerState typeCheckerState, h type, TypeCheckerState.b supertypesPolicy) {
        p.i(typeCheckerState, "<this>");
        p.i(type, "type");
        p.i(supertypesPolicy, "supertypesPolicy");
        q qVarJ = typeCheckerState.j();
        if ((qVarJ.j(type) && !qVarJ.N(type)) || qVarJ.z(type)) {
            return true;
        }
        typeCheckerState.k();
        ArrayDeque<h> arrayDequeH = typeCheckerState.h();
        p.f(arrayDequeH);
        Set<h> setI = typeCheckerState.i();
        p.f(setI);
        arrayDequeH.push(type);
        while (!arrayDequeH.isEmpty()) {
            h hVarPop = arrayDequeH.pop();
            p.f(hVarPop);
            if (setI.add(hVarPop)) {
                TypeCheckerState.b bVar = qVarJ.N(hVarPop) ? TypeCheckerState.b.c.f36086a : supertypesPolicy;
                if (p.d(bVar, TypeCheckerState.b.c.f36086a)) {
                    bVar = null;
                }
                if (bVar == null) {
                    continue;
                } else {
                    q qVarJ2 = typeCheckerState.j();
                    Iterator<g> it = qVarJ2.K0(qVarJ2.e(hVarPop)).iterator();
                    while (it.hasNext()) {
                        h hVarA = bVar.a(typeCheckerState, it.next());
                        if ((qVarJ.j(hVarA) && !qVarJ.N(hVarA)) || qVarJ.z(hVarA)) {
                            typeCheckerState.e();
                            return true;
                        }
                        arrayDequeH.add(hVarA);
                    }
                }
            }
        }
        typeCheckerState.e();
        return false;
    }

    public final boolean b(TypeCheckerState state, h start, n end) {
        p.i(state, "state");
        p.i(start, "start");
        p.i(end, "end");
        q qVarJ = state.j();
        if (f36091a.c(state, start, end)) {
            return true;
        }
        state.k();
        ArrayDeque<h> arrayDequeH = state.h();
        p.f(arrayDequeH);
        Set<h> setI = state.i();
        p.f(setI);
        arrayDequeH.push(start);
        while (!arrayDequeH.isEmpty()) {
            h hVarPop = arrayDequeH.pop();
            p.f(hVarPop);
            if (setI.add(hVarPop)) {
                TypeCheckerState.b bVar = qVarJ.N(hVarPop) ? TypeCheckerState.b.c.f36086a : TypeCheckerState.b.C0460b.f36085a;
                if (p.d(bVar, TypeCheckerState.b.c.f36086a)) {
                    bVar = null;
                }
                if (bVar == null) {
                    continue;
                } else {
                    q qVarJ2 = state.j();
                    Iterator<g> it = qVarJ2.K0(qVarJ2.e(hVarPop)).iterator();
                    while (it.hasNext()) {
                        h hVarA = bVar.a(state, it.next());
                        if (f36091a.c(state, hVarA, end)) {
                            state.e();
                            return true;
                        }
                        arrayDequeH.add(hVarA);
                    }
                }
            }
        }
        state.e();
        return false;
    }

    public final boolean c(TypeCheckerState typeCheckerState, h hVar, n nVar) {
        q qVarJ = typeCheckerState.j();
        if (qVarJ.y0(hVar)) {
            return true;
        }
        if (qVarJ.N(hVar)) {
            return false;
        }
        if (typeCheckerState.o() && qVarJ.A(hVar)) {
            return true;
        }
        return qVarJ.y(qVarJ.e(hVar), nVar);
    }

    public final boolean d(TypeCheckerState state, h subType, h superType) {
        p.i(state, "state");
        p.i(subType, "subType");
        p.i(superType, "superType");
        return e(state, subType, superType);
    }

    public final boolean e(TypeCheckerState typeCheckerState, h hVar, h hVar2) {
        q qVarJ = typeCheckerState.j();
        if (b.f36093b) {
            if (!qVarJ.a(hVar) && !qVarJ.m(qVarJ.e(hVar))) {
                typeCheckerState.l(hVar);
            }
            if (!qVarJ.a(hVar2)) {
                typeCheckerState.l(hVar2);
            }
        }
        if (qVarJ.N(hVar2) || qVarJ.S0(hVar) || qVarJ.z(hVar)) {
            return true;
        }
        if ((hVar instanceof Ca.b) && qVarJ.c0((Ca.b) hVar)) {
            return true;
        }
        a aVar = f36091a;
        if (aVar.a(typeCheckerState, hVar, TypeCheckerState.b.C0460b.f36085a)) {
            return true;
        }
        if (qVarJ.z(hVar2) || aVar.a(typeCheckerState, hVar2, TypeCheckerState.b.d.f36087a) || qVarJ.j(hVar)) {
            return false;
        }
        return aVar.b(typeCheckerState, hVar, qVarJ.e(hVar2));
    }
}
