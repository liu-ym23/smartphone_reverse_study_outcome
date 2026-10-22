package J8;

import D7.v;
import X8.AbstractC0272c;
import X8.C0273d;
import X8.J;
import X8.w;
import h8.AbstractC1532o;
import h8.C1531n;
import h8.InterfaceC1500H;
import h8.InterfaceC1501I;
import h8.InterfaceC1507O;
import h8.InterfaceC1519b;
import h8.InterfaceC1520c;
import h8.InterfaceC1522e;
import h8.InterfaceC1527j;
import h8.InterfaceC1536s;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ServiceLoader;
import k8.F;
import k8.H;
import k8.Q;
import k8.t;
import k8.u;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor$Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition$Contract;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil$OverrideCompatibilityInfo$Result;

/* loaded from: classes4.dex */
public final class k {
    public static final List b = v.f1(ServiceLoader.load(f.class, f.class.getClassLoader()));
    public static final k c;
    public static final c d;

    /* renamed from: a, reason: collision with root package name */
    public final Y8.c f887a;

    static {
        c cVar = new c();
        d = cVar;
        c = new k(cVar);
    }

    public k(Y8.c cVar) {
        if (cVar != null) {
            this.f887a = cVar;
        } else {
            a(5);
            throw null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0035 A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0058 A[FALL_THROUGH] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ void a(int r25) {
        /*
            Method dump skipped, instructions count: 1296
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: J8.k.a(int):void");
    }

    public static boolean b(w wVar, w wVar2, J j5) {
        if (wVar == null) {
            a(44);
            throw null;
        }
        if (wVar2 == null) {
            a(45);
            throw null;
        }
        if (AbstractC0272c.k(wVar) && AbstractC0272c.k(wVar2)) {
            return true;
        }
        return C0273d.g(j5, wVar.Z(), wVar2.Z());
    }

    public static void c(InterfaceC1520c interfaceC1520c, LinkedHashSet linkedHashSet) {
        if (interfaceC1520c == null) {
            a(17);
            throw null;
        }
        CallableMemberDescriptor$Kind kind = interfaceC1520c.getKind();
        kind.getClass();
        if (kind != CallableMemberDescriptor$Kind.b) {
            linkedHashSet.add(interfaceC1520c);
            return;
        }
        if (interfaceC1520c.e().isEmpty()) {
            throw new IllegalStateException("No overridden descriptors found for (fake override) " + interfaceC1520c);
        }
        Iterator it = interfaceC1520c.e().iterator();
        while (it.hasNext()) {
            c((InterfaceC1520c) it.next(), linkedHashSet);
        }
    }

    public static ArrayList d(InterfaceC1519b interfaceC1519b) {
        u uVarI = interfaceC1519b.I();
        ArrayList arrayList = new ArrayList();
        if (uVarI != null) {
            arrayList.add(uVarI.getType());
        }
        Iterator it = interfaceC1519b.x().iterator();
        while (it.hasNext()) {
            arrayList.add(((Q) it.next()).getType());
        }
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:113:0x0190, code lost:
    
        if (r1 == false) goto L115;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0192, code lost:
    
        r1 = h8.AbstractC1532o.h;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0195, code lost:
    
        r1 = h8.AbstractC1532o.g;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0197, code lost:
    
        r11 = ((h8.InterfaceC1520c) s(r10, new J8.i(0))).U(r11, r0, r1);
        r12.p(r11, r10);
        r12.b(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x01ad, code lost:
    
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void e(java.util.Collection r10, h8.InterfaceC1522e r11, J8.m r12) {
        /*
            Method dump skipped, instructions count: 454
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: J8.k.e(java.util.Collection, h8.e, J8.m):void");
    }

    public static ArrayList g(Object obj, LinkedList linkedList, S7.k kVar, S7.k kVar2) {
        if (obj == null) {
            a(97);
            throw null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(obj);
        InterfaceC1519b interfaceC1519b = (InterfaceC1519b) kVar.invoke(obj);
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            InterfaceC1519b interfaceC1519b2 = (InterfaceC1519b) kVar.invoke(next);
            if (obj == next) {
                it.remove();
            } else {
                OverridingUtil$OverrideCompatibilityInfo$Result overridingUtil$OverrideCompatibilityInfo$ResultJ = j(interfaceC1519b, interfaceC1519b2);
                if (overridingUtil$OverrideCompatibilityInfo$ResultJ == OverridingUtil$OverrideCompatibilityInfo$Result.f5116a) {
                    arrayList.add(next);
                    it.remove();
                } else if (overridingUtil$OverrideCompatibilityInfo$ResultJ == OverridingUtil$OverrideCompatibilityInfo$Result.c) {
                    kVar2.invoke(next);
                    it.remove();
                }
            }
        }
        return arrayList;
    }

    public static j i(InterfaceC1519b interfaceC1519b, InterfaceC1519b interfaceC1519b2) {
        boolean z10;
        if (interfaceC1519b == null) {
            a(38);
            throw null;
        }
        if (interfaceC1519b2 == null) {
            a(39);
            throw null;
        }
        boolean z11 = interfaceC1519b instanceof InterfaceC1536s;
        if ((z11 && !(interfaceC1519b2 instanceof InterfaceC1536s)) || (((z10 = interfaceC1519b instanceof InterfaceC1501I)) && !(interfaceC1519b2 instanceof InterfaceC1501I))) {
            return j.c("Member kind mismatch");
        }
        if (!z11 && !z10) {
            throw new IllegalArgumentException("This type of CallableDescriptor cannot be checked for overridability: " + interfaceC1519b);
        }
        if (!interfaceC1519b.getName().equals(interfaceC1519b2.getName())) {
            return j.c("Name mismatch");
        }
        j jVarC = (interfaceC1519b.I() == null) != (interfaceC1519b2.I() == null) ? j.c("Receiver presence mismatch") : interfaceC1519b.x().size() != interfaceC1519b2.x().size() ? j.c("Value parameter number mismatch") : null;
        if (jVarC != null) {
            return jVarC;
        }
        return null;
    }

    public static OverridingUtil$OverrideCompatibilityInfo$Result j(InterfaceC1519b interfaceC1519b, InterfaceC1519b interfaceC1519b2) {
        k kVar = c;
        OverridingUtil$OverrideCompatibilityInfo$Result overridingUtil$OverrideCompatibilityInfo$ResultB = kVar.l(interfaceC1519b2, interfaceC1519b, null).b();
        OverridingUtil$OverrideCompatibilityInfo$Result overridingUtil$OverrideCompatibilityInfo$ResultB2 = kVar.m(interfaceC1519b, interfaceC1519b2, null, false).b();
        OverridingUtil$OverrideCompatibilityInfo$Result overridingUtil$OverrideCompatibilityInfo$Result = OverridingUtil$OverrideCompatibilityInfo$Result.f5116a;
        if (overridingUtil$OverrideCompatibilityInfo$ResultB == overridingUtil$OverrideCompatibilityInfo$Result && overridingUtil$OverrideCompatibilityInfo$ResultB2 == overridingUtil$OverrideCompatibilityInfo$Result) {
            return overridingUtil$OverrideCompatibilityInfo$Result;
        }
        OverridingUtil$OverrideCompatibilityInfo$Result overridingUtil$OverrideCompatibilityInfo$Result2 = OverridingUtil$OverrideCompatibilityInfo$Result.c;
        return (overridingUtil$OverrideCompatibilityInfo$ResultB == overridingUtil$OverrideCompatibilityInfo$Result2 || overridingUtil$OverrideCompatibilityInfo$ResultB2 == overridingUtil$OverrideCompatibilityInfo$Result2) ? overridingUtil$OverrideCompatibilityInfo$Result2 : OverridingUtil$OverrideCompatibilityInfo$Result.b;
    }

    public static boolean k(InterfaceC1519b interfaceC1519b, InterfaceC1519b interfaceC1519b2) {
        if (interfaceC1519b == null) {
            a(65);
            throw null;
        }
        if (interfaceC1519b2 == null) {
            a(66);
            throw null;
        }
        w returnType = interfaceC1519b.getReturnType();
        w returnType2 = interfaceC1519b2.getReturnType();
        if (!p(interfaceC1519b, interfaceC1519b2)) {
            return false;
        }
        J jF = c.f(interfaceC1519b.getTypeParameters(), interfaceC1519b2.getTypeParameters());
        if (interfaceC1519b instanceof InterfaceC1536s) {
            return o(interfaceC1519b, returnType, interfaceC1519b2, returnType2, jF);
        }
        if (!(interfaceC1519b instanceof InterfaceC1501I)) {
            throw new IllegalArgumentException("Unexpected callable: " + interfaceC1519b.getClass());
        }
        InterfaceC1501I interfaceC1501I = (InterfaceC1501I) interfaceC1519b;
        InterfaceC1501I interfaceC1501I2 = (InterfaceC1501I) interfaceC1519b2;
        k8.J setter = interfaceC1501I.getSetter();
        k8.J setter2 = interfaceC1501I2.getSetter();
        if ((setter == null || setter2 == null) ? true : p(setter, setter2)) {
            return (interfaceC1501I.H() && interfaceC1501I2.H()) ? C0273d.g(jF, returnType.Z(), returnType2.Z()) : (interfaceC1501I.H() || !interfaceC1501I2.H()) && o(interfaceC1519b, returnType, interfaceC1519b2, returnType2, jF);
        }
        return false;
    }

    public static boolean o(InterfaceC1519b interfaceC1519b, w wVar, InterfaceC1519b interfaceC1519b2, w wVar2, J j5) {
        if (interfaceC1519b == null) {
            a(71);
            throw null;
        }
        if (wVar == null) {
            a(72);
            throw null;
        }
        if (interfaceC1519b2 == null) {
            a(73);
            throw null;
        }
        if (wVar2 == null) {
            a(74);
            throw null;
        }
        return C0273d.m(C0273d.f1528a, j5, wVar.Z(), wVar2.Z());
    }

    public static boolean p(InterfaceC1519b interfaceC1519b, InterfaceC1519b interfaceC1519b2) {
        if (interfaceC1519b == null) {
            a(67);
            throw null;
        }
        if (interfaceC1519b2 != null) {
            Integer numB = AbstractC1532o.b(interfaceC1519b.getVisibility(), interfaceC1519b2.getVisibility());
            return numB == null || numB.intValue() >= 0;
        }
        a(68);
        throw null;
    }

    public static boolean q(InterfaceC1519b interfaceC1519b, InterfaceC1519b interfaceC1519b2) {
        if (interfaceC1519b == null) {
            a(13);
            throw null;
        }
        if (interfaceC1519b2 == null) {
            a(14);
            throw null;
        }
        boolean zEquals = interfaceC1519b.equals(interfaceC1519b2);
        c cVar = c.f882a;
        if (!zEquals && cVar.b(interfaceC1519b.a(), interfaceC1519b2.a(), false)) {
            return true;
        }
        InterfaceC1519b interfaceC1519bA = interfaceC1519b2.a();
        int i = e.f883a;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        e.b(interfaceC1519b.a(), linkedHashSet);
        Iterator it = linkedHashSet.iterator();
        while (it.hasNext()) {
            if (cVar.b(interfaceC1519bA, (InterfaceC1519b) it.next(), false)) {
                return true;
            }
        }
        return false;
    }

    public static void r(InterfaceC1520c interfaceC1520c, S7.k kVar) {
        C1531n c1531n;
        C1531n c1531nF;
        C1531n c1531n2;
        if (interfaceC1520c == null) {
            a(105);
            throw null;
        }
        for (InterfaceC1520c interfaceC1520c2 : interfaceC1520c.e()) {
            if (interfaceC1520c2.getVisibility() == AbstractC1532o.g) {
                r(interfaceC1520c2, kVar);
            }
        }
        if (interfaceC1520c.getVisibility() != AbstractC1532o.g) {
            return;
        }
        Collection<InterfaceC1520c> collectionE = interfaceC1520c.e();
        if (collectionE == null) {
            a(107);
            throw null;
        }
        if (collectionE.isEmpty()) {
            c1531nF = AbstractC1532o.l;
        } else {
            Iterator it = collectionE.iterator();
            loop3: while (true) {
                c1531n = null;
                while (it.hasNext()) {
                    C1531n visibility = ((InterfaceC1520c) it.next()).getVisibility();
                    if (c1531n != null) {
                        Integer numB = AbstractC1532o.b(visibility, c1531n);
                        if (numB == null) {
                            break;
                        } else if (numB.intValue() > 0) {
                        }
                    }
                    c1531n = visibility;
                }
            }
            if (c1531n == null) {
                c1531nF = null;
                break;
            }
            Iterator it2 = collectionE.iterator();
            while (it2.hasNext()) {
                Integer numB2 = AbstractC1532o.b(c1531n, ((InterfaceC1520c) it2.next()).getVisibility());
                if (numB2 == null || numB2.intValue() < 0) {
                    c1531nF = null;
                    break;
                }
            }
            c1531nF = c1531n;
        }
        if (c1531nF == null) {
            c1531nF = null;
            break;
        }
        if (interfaceC1520c.getKind() == CallableMemberDescriptor$Kind.b) {
            for (InterfaceC1520c interfaceC1520c3 : collectionE) {
                if (interfaceC1520c3.i() != Modality.e && !interfaceC1520c3.getVisibility().equals(c1531nF)) {
                    c1531nF = null;
                    break;
                }
            }
        } else {
            c1531nF = AbstractC1532o.f(c1531nF.f4582a.c());
        }
        if (c1531nF == null) {
            if (kVar != null) {
                kVar.invoke(interfaceC1520c);
            }
            c1531n2 = AbstractC1532o.e;
        } else {
            c1531n2 = c1531nF;
        }
        if (interfaceC1520c instanceof H) {
            H h = (H) interfaceC1520c;
            if (c1531n2 == null) {
                H.C0(20);
                throw null;
            }
            h.f4830j = c1531n2;
            Iterator it3 = ((InterfaceC1501I) interfaceC1520c).l().iterator();
            while (it3.hasNext()) {
                r((InterfaceC1500H) it3.next(), c1531nF == null ? null : kVar);
            }
            return;
        }
        if (interfaceC1520c instanceof t) {
            t tVar = (t) interfaceC1520c;
            if (c1531n2 != null) {
                tVar.l = c1531n2;
                return;
            } else {
                t.C0(10);
                throw null;
            }
        }
        F f = (F) interfaceC1520c;
        f.k = c1531n2;
        if (c1531n2 != f.R0().getVisibility()) {
            f.e = false;
        }
    }

    public static Object s(Collection collection, S7.k kVar) {
        Object next;
        if (collection.size() == 1) {
            Object objZ0 = v.z0(collection);
            if (objZ0 != null) {
                return objZ0;
            }
            a(78);
            throw null;
        }
        ArrayList arrayList = new ArrayList(2);
        ArrayList arrayList2 = new ArrayList(D7.w.c0(collection, 10));
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            arrayList2.add(kVar.invoke(it.next()));
        }
        Object objZ02 = v.z0(collection);
        InterfaceC1519b interfaceC1519b = (InterfaceC1519b) kVar.invoke(objZ02);
        for (Object obj : collection) {
            InterfaceC1519b interfaceC1519b2 = (InterfaceC1519b) kVar.invoke(obj);
            if (interfaceC1519b2 == null) {
                a(69);
                throw null;
            }
            Iterator it2 = arrayList2.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    arrayList.add(obj);
                    break;
                }
                if (!k(interfaceC1519b2, (InterfaceC1519b) it2.next())) {
                    break;
                }
            }
            if (k(interfaceC1519b2, interfaceC1519b) && !k(interfaceC1519b, interfaceC1519b2)) {
                objZ02 = obj;
            }
        }
        if (arrayList.isEmpty()) {
            if (objZ02 != null) {
                return objZ02;
            }
            a(79);
            throw null;
        }
        if (arrayList.size() == 1) {
            Object objZ03 = v.z0(arrayList);
            if (objZ03 != null) {
                return objZ03;
            }
            a(80);
            throw null;
        }
        Iterator it3 = arrayList.iterator();
        while (true) {
            if (!it3.hasNext()) {
                next = null;
                break;
            }
            next = it3.next();
            if (!AbstractC0272c.l(((InterfaceC1519b) kVar.invoke(next)).getReturnType())) {
                break;
            }
        }
        if (next != null) {
            return next;
        }
        Object objZ04 = v.z0(arrayList);
        if (objZ04 != null) {
            return objZ04;
        }
        a(82);
        throw null;
    }

    public final J f(List list, List list2) {
        if (list == null) {
            a(40);
            throw null;
        }
        if (list2 == null) {
            a(41);
            throw null;
        }
        boolean zIsEmpty = list.isEmpty();
        Y8.e eVar = Y8.e.f1573a;
        Y8.f fVar = Y8.f.f1574a;
        Y8.c cVar = this.f887a;
        if (zIsEmpty) {
            return new J(true, true, new l(null, cVar), eVar, fVar);
        }
        HashMap map = new HashMap();
        for (int i = 0; i < list.size(); i++) {
            map.put(((InterfaceC1507O) list.get(i)).m(), ((InterfaceC1507O) list2.get(i)).m());
        }
        return new J(true, true, new l(map, cVar), eVar, fVar);
    }

    public final void h(G8.f fVar, Collection collection, Collection collection2, InterfaceC1522e interfaceC1522e, m mVar) {
        Integer numB;
        if (fVar == null) {
            a(50);
            throw null;
        }
        if (collection == null) {
            a(51);
            throw null;
        }
        if (collection2 == null) {
            a(52);
            throw null;
        }
        if (interfaceC1522e == null) {
            a(53);
            throw null;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(collection);
        Iterator it = collection2.iterator();
        while (true) {
            int i = 1;
            if (!it.hasNext()) {
                if (linkedHashSet.size() >= 2) {
                    InterfaceC1527j interfaceC1527jD = ((InterfaceC1520c) linkedHashSet.iterator().next()).d();
                    if (!linkedHashSet.isEmpty()) {
                        Iterator it2 = linkedHashSet.iterator();
                        while (it2.hasNext()) {
                            if (((InterfaceC1520c) it2.next()).d() != interfaceC1527jD) {
                                LinkedList<InterfaceC1520c> linkedList = new LinkedList(linkedHashSet);
                                while (!linkedList.isEmpty()) {
                                    linkedList.isEmpty();
                                    InterfaceC1520c interfaceC1520c = null;
                                    for (InterfaceC1520c interfaceC1520c2 : linkedList) {
                                        if (interfaceC1520c == null || ((numB = AbstractC1532o.b(interfaceC1520c.getVisibility(), interfaceC1520c2.getVisibility())) != null && numB.intValue() < 0)) {
                                            interfaceC1520c = interfaceC1520c2;
                                        }
                                    }
                                    kotlin.jvm.internal.k.c(interfaceC1520c);
                                    e(g(interfaceC1520c, linkedList, new i(1), new J4.f(i, mVar, interfaceC1520c)), interfaceC1522e, mVar);
                                }
                                return;
                            }
                        }
                    }
                }
                Iterator it3 = linkedHashSet.iterator();
                while (it3.hasNext()) {
                    e(Collections.singleton((InterfaceC1520c) it3.next()), interfaceC1522e, mVar);
                }
                return;
            }
            InterfaceC1520c interfaceC1520c3 = (InterfaceC1520c) it.next();
            if (interfaceC1520c3 == null) {
                a(57);
                throw null;
            }
            ArrayList arrayList = new ArrayList(collection.size());
            int i6 = g9.i.c;
            g9.i iVarF = g9.l.f();
            Iterator it4 = collection.iterator();
            while (it4.hasNext()) {
                InterfaceC1520c interfaceC1520c4 = (InterfaceC1520c) it4.next();
                OverridingUtil$OverrideCompatibilityInfo$Result overridingUtil$OverrideCompatibilityInfo$ResultB = l(interfaceC1520c4, interfaceC1520c3, interfaceC1522e).b();
                boolean z10 = !AbstractC1532o.e(interfaceC1520c4.getVisibility()) && AbstractC1532o.c(AbstractC1532o.n, interfaceC1520c4, interfaceC1520c3) == null;
                int iOrdinal = overridingUtil$OverrideCompatibilityInfo$ResultB.ordinal();
                if (iOrdinal == 0) {
                    if (z10) {
                        iVarF.add(interfaceC1520c4);
                    }
                    arrayList.add(interfaceC1520c4);
                } else if (iOrdinal == 2) {
                    if (z10) {
                        mVar.d(interfaceC1520c4, interfaceC1520c3);
                    }
                    arrayList.add(interfaceC1520c4);
                }
            }
            mVar.p(interfaceC1520c3, iVarF);
            linkedHashSet.removeAll(arrayList);
        }
    }

    public final j l(InterfaceC1519b interfaceC1519b, InterfaceC1519b interfaceC1519b2, InterfaceC1522e interfaceC1522e) {
        if (interfaceC1519b == null) {
            a(19);
            throw null;
        }
        if (interfaceC1519b2 != null) {
            return m(interfaceC1519b, interfaceC1519b2, interfaceC1522e, false);
        }
        a(20);
        throw null;
    }

    public final j m(InterfaceC1519b interfaceC1519b, InterfaceC1519b interfaceC1519b2, InterfaceC1522e interfaceC1522e, boolean z10) {
        if (interfaceC1519b == null) {
            a(22);
            throw null;
        }
        if (interfaceC1519b2 == null) {
            a(23);
            throw null;
        }
        j jVarN = n(interfaceC1519b, interfaceC1519b2, z10);
        boolean z11 = jVarN.b() == OverridingUtil$OverrideCompatibilityInfo$Result.f5116a;
        List<f> list = b;
        Iterator it = list.iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            ExternalOverridabilityCondition$Contract externalOverridabilityCondition$Contract = ExternalOverridabilityCondition$Contract.f5114a;
            if (!zHasNext) {
                if (!z11) {
                    return jVarN;
                }
                for (f fVar : list) {
                    if (fVar.b() == externalOverridabilityCondition$Contract) {
                        int iOrdinal = fVar.a(interfaceC1519b, interfaceC1519b2, interfaceC1522e).ordinal();
                        if (iOrdinal == 0) {
                            throw new IllegalStateException("Contract violation in " + fVar.getClass().getName() + " condition. It's not supposed to end with success");
                        }
                        if (iOrdinal == 1) {
                            return j.c("External condition");
                        }
                    }
                }
                j jVar = j.c;
                if (jVar != null) {
                    return jVar;
                }
                j.a(0);
                throw null;
            }
            f fVar2 = (f) it.next();
            if (fVar2.b() != externalOverridabilityCondition$Contract && (!z11 || fVar2.b() != ExternalOverridabilityCondition$Contract.b)) {
                int iOrdinal2 = fVar2.a(interfaceC1519b, interfaceC1519b2, interfaceC1522e).ordinal();
                if (iOrdinal2 == 0) {
                    z11 = true;
                } else if (iOrdinal2 == 1) {
                    return j.c("External condition");
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x00b2, code lost:
    
        r14.remove();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final J8.j n(h8.InterfaceC1519b r17, h8.InterfaceC1519b r18, boolean r19) {
        /*
            Method dump skipped, instructions count: 343
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: J8.k.n(h8.b, h8.b, boolean):J8.j");
    }
}
