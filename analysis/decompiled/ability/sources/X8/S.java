package X8;

import h8.InterfaceC1507O;
import h8.InterfaceC1522e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.types.TypeUsage;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import v8.C2065a;

/* loaded from: classes4.dex */
public abstract class S {

    /* renamed from: a, reason: collision with root package name */
    public static final Z8.g f1527a = Z8.i.c(ErrorTypeKind.l, new String[0]);
    public static final Z8.g b = Z8.i.c(ErrorTypeKind.i, new String[0]);
    public static final Q c = new Q("NO_EXPECTED_TYPE");
    public static final Q d = new Q("UNIT_EXPECTED_TYPE");

    /* JADX WARN: Removed duplicated region for block: B:17:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0120  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ void a(int r27) {
        /*
            Method dump skipped, instructions count: 774
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: X8.S.a(int):void");
    }

    public static boolean b(w wVar) {
        if (wVar == null) {
            a(28);
            throw null;
        }
        if (wVar.W()) {
            return true;
        }
        return AbstractC0272c.l(wVar) && b(((AbstractC0285p) wVar.Z()).c);
    }

    public static boolean c(w wVar, S7.k kVar, g9.i iVar) {
        if (wVar == null) {
            return false;
        }
        U uZ = wVar.Z();
        if (l(wVar)) {
            return ((Boolean) kVar.invoke(uZ)).booleanValue();
        }
        if (iVar != null && iVar.contains(wVar)) {
            return false;
        }
        if (((Boolean) kVar.invoke(uZ)).booleanValue()) {
            return true;
        }
        if (iVar == null) {
            int i = g9.i.c;
            iVar = g9.l.f();
        }
        iVar.add(wVar);
        AbstractC0285p abstractC0285p = uZ instanceof AbstractC0285p ? (AbstractC0285p) uZ : null;
        if (abstractC0285p != null && (c(abstractC0285p.b, kVar, iVar) || c(abstractC0285p.c, kVar, iVar))) {
            return true;
        }
        if ((uZ instanceof C0281l) && c(((C0281l) uZ).b, kVar, iVar)) {
            return true;
        }
        K kQ = wVar.Q();
        if (kQ instanceof v) {
            Iterator it = ((v) kQ).b.iterator();
            while (it.hasNext()) {
                if (c((w) it.next(), kVar, iVar)) {
                    return true;
                }
            }
            return false;
        }
        for (N n : wVar.L()) {
            if (!n.c() && c(n.b(), kVar, iVar)) {
                return true;
            }
        }
        return false;
    }

    public static List d(List list) {
        if (list == null) {
            a(16);
            throw null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new F(((InterfaceC1507O) it.next()).g()));
        }
        List listF1 = D7.v.f1(arrayList);
        if (listF1 != null) {
            return listF1;
        }
        a(17);
        throw null;
    }

    public static boolean e(w wVar) {
        if (wVar == null) {
            a(27);
            throw null;
        }
        if (!wVar.W() && (!AbstractC0272c.l(wVar) || !e(((AbstractC0285p) wVar.Z()).c))) {
            if (!(wVar.Z() instanceof C0281l)) {
                if (f(wVar)) {
                    if (!(wVar.Q().d() instanceof InterfaceC1522e)) {
                        kotlin.reflect.jvm.internal.impl.types.a aVarD = kotlin.reflect.jvm.internal.impl.types.a.d(wVar);
                        Collection<w> collectionE = wVar.Q().e();
                        ArrayList arrayList = new ArrayList(collectionE.size());
                        for (w wVar2 : collectionE) {
                            if (wVar2 == null) {
                                a(21);
                                throw null;
                            }
                            w wVarI = aVarD.i(wVar2, Variance.c);
                            w wVarH = wVarI != null ? h(wVarI, wVar.W()) : null;
                            if (wVarH != null) {
                                arrayList.add(wVarH);
                            }
                        }
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            if (e((w) it.next())) {
                                return true;
                            }
                        }
                    }
                    return false;
                }
                K kQ = wVar.Q();
                if (kQ instanceof v) {
                    Iterator it2 = ((v) kQ).b.iterator();
                    while (it2.hasNext()) {
                        if (e((w) it2.next())) {
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public static boolean f(w wVar) {
        if (wVar == null) {
            a(60);
            throw null;
        }
        if ((wVar.Q().d() instanceof InterfaceC1507O ? (InterfaceC1507O) wVar.Q().d() : null) != null) {
            return true;
        }
        wVar.Q();
        return false;
    }

    public static U g(w wVar, boolean z10) {
        if (wVar == null) {
            a(3);
            throw null;
        }
        U uF0 = wVar.Z().f0(z10);
        if (uF0 != null) {
            return uF0;
        }
        a(4);
        throw null;
    }

    public static w h(w wVar, boolean z10) {
        if (wVar != null) {
            return z10 ? g(wVar, true) : wVar;
        }
        a(8);
        throw null;
    }

    public static A i(A a3, boolean z10) {
        if (a3 == null) {
            a(5);
            throw null;
        }
        if (!z10) {
            return a3;
        }
        A aN0 = a3.f0(true);
        if (aN0 != null) {
            return aN0;
        }
        a(6);
        throw null;
    }

    public static F j(InterfaceC1507O interfaceC1507O) {
        if (interfaceC1507O != null) {
            return new F(interfaceC1507O);
        }
        a(45);
        throw null;
    }

    public static N k(InterfaceC1507O interfaceC1507O, C2065a c2065a) {
        if (interfaceC1507O != null) {
            return c2065a.b == TypeUsage.f5142a ? new F(AbstractC0272c.x(interfaceC1507O)) : new F(interfaceC1507O);
        }
        a(46);
        throw null;
    }

    public static boolean l(w wVar) {
        if (wVar != null) {
            return wVar == c || wVar == d;
        }
        a(0);
        throw null;
    }
}
