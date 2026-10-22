package u8;

import g8.C1469e;
import h8.InterfaceC1522e;
import h8.InterfaceC1540w;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Pair;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import n8.AbstractC1744c;
import t8.C2024a;
import u1.C2031a;
import x8.InterfaceC2118a;

/* loaded from: classes4.dex */
public final class f implements S7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6717a;
    public final g b;

    public /* synthetic */ f(g gVar, int i) {
        this.f6717a = i;
        this.b = gVar;
    }

    @Override // S7.a
    public final Object invoke() throws IllegalAccessException, SecurityException, IllegalArgumentException, InvocationTargetException {
        switch (this.f6717a) {
            case 0:
                return AbstractC1744c.a(M.a.Z(M.a.V(this.b.b.f5356a))).a();
            case 1:
                g gVar = this.b;
                G8.c cVarB = gVar.b();
                n8.d dVar = gVar.b;
                K1.a aVar = gVar.f6718a;
                if (cVarB == null) {
                    return Z8.i.c(ErrorTypeKind.E, dVar.toString());
                }
                C2024a c2024a = (C2024a) aVar.f903a;
                InterfaceC1540w interfaceC1540w = c2024a.o;
                InterfaceC1522e interfaceC1522eB = C1469e.b(cVarB, interfaceC1540w.c());
                if (interfaceC1522eB == null) {
                    kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.a aVar2 = new kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.a(M.a.Z(M.a.V(dVar.f5356a)));
                    A0.b bVar = c2024a.k;
                    bVar.getClass();
                    C2031a c2031a = (C2031a) bVar.b;
                    if (c2031a == null) {
                        kotlin.jvm.internal.k.n("resolver");
                        throw null;
                    }
                    interfaceC1522eB = c2031a.l(aVar2);
                    if (interfaceC1522eB == null) {
                        G8.c cVarE = cVarB.e();
                        G8.f fVarF = cVarB.f();
                        kotlin.jvm.internal.k.e(fVarF, "shortName(...)");
                        interfaceC1522eB = kotlin.reflect.jvm.internal.impl.descriptors.a.c(interfaceC1540w, new G8.b(cVarE, fVarF), c2024a.d.c().l);
                    }
                }
                return interfaceC1522eB.g();
            default:
                g gVar2 = this.b;
                ArrayList arrayListB = gVar2.b.b();
                ArrayList arrayList = new ArrayList();
                Iterator it = arrayListB.iterator();
                while (it.hasNext()) {
                    InterfaceC2118a interfaceC2118a = (InterfaceC2118a) it.next();
                    G8.f fVar = ((n8.e) interfaceC2118a).f5357a;
                    if (fVar == null) {
                        fVar = q8.u.b;
                    }
                    L8.g gVarC = gVar2.c(interfaceC2118a);
                    Pair pair = gVarC != null ? new Pair(fVar, gVarC) : null;
                    if (pair != null) {
                        arrayList.add(pair);
                    }
                }
                return kotlin.collections.a.X(arrayList);
        }
    }
}
