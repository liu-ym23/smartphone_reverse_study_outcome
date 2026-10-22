package kotlin.reflect.jvm.internal.impl.types.checker;

import K8.c;
import V8.e;
import X8.A;
import X8.AbstractC0272c;
import X8.AbstractC0285p;
import X8.K;
import X8.N;
import X8.U;
import X8.v;
import X8.w;
import Y8.h;
import Y8.i;
import a9.InterfaceC0310b;
import h8.InterfaceC1507O;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.k;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;

/* loaded from: classes4.dex */
public abstract class a {
    /* JADX WARN: Multi-variable type inference failed */
    public static A b(A a3) {
        w wVarB;
        K kQ = a3.Q();
        InterfaceC1507O interfaceC1507O = null;
        if (kQ instanceof c) {
            c cVar = (c) kQ;
            N n = cVar.f910a;
            if (n.a() != Variance.d) {
                n = null;
            }
            U uZ = (n == null || (wVarB = n.b()) == null) ? null : wVarB.Z();
            if (cVar.b == null) {
                N projection = cVar.f910a;
                Collection collectionE = cVar.e();
                ArrayList arrayList = new ArrayList(D7.w.c0(collectionE, 10));
                Iterator it = collectionE.iterator();
                while (it.hasNext()) {
                    arrayList.add(((w) it.next()).Z());
                }
                k.f(projection, "projection");
                cVar.b = new i(projection, new e(arrayList, 1), interfaceC1507O, 8);
            }
            CaptureStatus captureStatus = CaptureStatus.f5164a;
            i iVar = cVar.b;
            k.c(iVar);
            return new h(captureStatus, iVar, uZ, a3.M(), a3.W(), 32);
        }
        if (!(kQ instanceof v) || !a3.W()) {
            return a3;
        }
        v vVar = (v) kQ;
        LinkedHashSet linkedHashSet = vVar.b;
        ArrayList arrayList2 = new ArrayList(D7.w.c0(linkedHashSet, 10));
        Iterator it2 = linkedHashSet.iterator();
        boolean z10 = false;
        while (it2.hasNext()) {
            arrayList2.add(U7.a.N((w) it2.next()));
            z10 = true;
        }
        if (z10) {
            w wVar = vVar.f1536a;
            U uN = wVar != null ? U7.a.N(wVar) : null;
            arrayList2.isEmpty();
            LinkedHashSet linkedHashSet2 = new LinkedHashSet(arrayList2);
            linkedHashSet2.hashCode();
            v vVar2 = new v(linkedHashSet2);
            vVar2.f1536a = uN;
            interfaceC1507O = vVar2;
        }
        if (interfaceC1507O != null) {
            vVar = interfaceC1507O;
        }
        return vVar.b();
    }

    public final U a(InterfaceC0310b type) {
        U uF;
        k.f(type, "type");
        if (!(type instanceof w)) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        U uZ = ((w) type).Z();
        if (uZ instanceof A) {
            uF = b((A) uZ);
        } else {
            if (!(uZ instanceof AbstractC0285p)) {
                throw new NoWhenBranchMatchedException();
            }
            AbstractC0285p abstractC0285p = (AbstractC0285p) uZ;
            A a3 = abstractC0285p.c;
            A a4 = abstractC0285p.b;
            A aB = b(a4);
            A aB2 = b(a3);
            uF = (aB == a4 && aB2 == a3) ? uZ : AbstractC0272c.f(aB, aB2);
        }
        KotlinTypePreparator$prepareType$1 kotlinTypePreparator$prepareType$1 = new KotlinTypePreparator$prepareType$1(1, this);
        w wVarG = AbstractC0272c.g(uZ);
        return AbstractC0272c.G(uF, wVarG != null ? (w) kotlinTypePreparator$prepareType$1.invoke(wVarG) : null);
    }
}
