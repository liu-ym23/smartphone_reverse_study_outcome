package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import D7.v;
import D7.w;
import G8.c;
import G8.f;
import H4.o;
import V8.s;
import W8.e;
import W8.h;
import W8.i;
import X8.A;
import X8.P;
import X8.y;
import Z7.t;
import androidx.appcompat.app.AppCompatDelegate;
import ca.AbstractC0897f;
import com.stepos.statsrpk.d;
import g8.C1466b;
import g8.C1468d;
import g8.C1469e;
import g8.C1472h;
import g8.j;
import g8.k;
import h8.AbstractC1538u;
import h8.InterfaceC1522e;
import h8.InterfaceC1524g;
import i8.InterfaceC1561g;
import j8.AbstractC1606e;
import j8.InterfaceC1603b;
import j8.InterfaceC1605d;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import k8.C1640i;
import k8.C1642k;
import k8.C1649s;
import k8.K;
import k8.Q;
import k8.z;
import kotlin.collections.EmptyList;
import kotlin.collections.EmptySet;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil$OverrideCompatibilityInfo$Result;

/* loaded from: classes4.dex */
public final class b implements InterfaceC1603b, InterfaceC1605d {
    public static final /* synthetic */ t[] h;

    /* renamed from: a, reason: collision with root package name */
    public final z f4949a;
    public final h b;
    public final A c;
    public final h d;
    public final e e;
    public final h f;
    public final e g;

    static {
        n nVar = m.f4928a;
        h = new t[]{nVar.g(new PropertyReference1Impl(nVar.b(b.class), "settings", "getSettings()Lorg/jetbrains/kotlin/builtins/jvm/JvmBuiltIns$Settings;")), nVar.g(new PropertyReference1Impl(nVar.b(b.class), "cloneableType", "getCloneableType()Lorg/jetbrains/kotlin/types/SimpleType;")), nVar.g(new PropertyReference1Impl(nVar.b(b.class), "notConsideredDeprecation", "getNotConsideredDeprecation()Lorg/jetbrains/kotlin/descriptors/annotations/Annotations;"))};
    }

    public b(z zVar, i iVar, I8.e eVar) {
        this.f4949a = zVar;
        this.b = new h(iVar, eVar);
        C1642k c1642k = new C1642k(new k(zVar, new c("java.io"), 0), f.e("Serializable"), Modality.e, ClassKind.b, o.M(new y(iVar, new j(this, 1))), iVar);
        c1642k.L(Q8.n.b, EmptySet.f4895a, null);
        this.c = c1642k.g();
        this.d = new h(iVar, new J4.e(11, this, iVar));
        this.e = new e(iVar, new ConcurrentHashMap(3, 1.0f, 2), new W8.f(), 0);
        this.f = new h(iVar, new j(this, 0));
        this.g = iVar.c(new J4.b(this, 11));
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0220 A[EDGE_INSN: B:145:0x0220->B:80:0x0220 BREAK  A[LOOP:4: B:76:0x01ff->B:146:?]] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x025a  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0276  */
    @Override // j8.InterfaceC1603b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.Collection a(G8.f r18, h8.InterfaceC1522e r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 913
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.builtins.jvm.b.a(G8.f, h8.e):java.util.Collection");
    }

    @Override // j8.InterfaceC1603b
    public final Collection b(InterfaceC1522e classDescriptor) {
        Set setA;
        kotlin.jvm.internal.k.f(classDescriptor, "classDescriptor");
        g().getClass();
        u8.j jVarF = f(classDescriptor);
        if (jVarF == null || (setA = jVarF.L().a()) == null) {
            setA = EmptySet.f4895a;
        }
        return setA;
    }

    @Override // j8.InterfaceC1603b
    public final Collection c(InterfaceC1522e interfaceC1522e) {
        G8.e eVarH = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.h(interfaceC1522e);
        LinkedHashSet linkedHashSet = g8.n.f4499a;
        G8.e eVar = e8.n.g;
        boolean zEquals = eVarH.equals(eVar);
        boolean zIsAssignableFrom = false;
        A a3 = this.c;
        if (!zEquals) {
            HashMap map = e8.n.f4416d0;
            if (map.get(eVarH) == null) {
                if (eVarH.equals(eVar) || map.get(eVarH) != null) {
                    zIsAssignableFrom = true;
                } else {
                    String str = C1468d.f4490a;
                    G8.b bVarF = C1468d.f(eVarH);
                    if (bVarF != null) {
                        try {
                            zIsAssignableFrom = Serializable.class.isAssignableFrom(Class.forName(bVarF.a().b()));
                        } catch (ClassNotFoundException unused) {
                        }
                    }
                }
                return zIsAssignableFrom ? o.M(a3) : EmptyList.f4893a;
            }
        }
        return o.N((A) S0.b.g1(this.d, h[1]), a3);
    }

    @Override // j8.InterfaceC1603b
    public final Collection d(InterfaceC1522e interfaceC1522e) {
        InterfaceC1522e interfaceC1522eB;
        if (interfaceC1522e.getKind() != ClassKind.f4951a) {
            return EmptyList.f4893a;
        }
        g().getClass();
        u8.j jVarF = f(interfaceC1522e);
        if (jVarF != null && (interfaceC1522eB = C1469e.b(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.g(jVarF), C1466b.f)) != null) {
            kotlin.reflect.jvm.internal.impl.types.a aVar = new kotlin.reflect.jvm.internal.impl.types.a(d.r(interfaceC1522eB, jVarF));
            List list = (List) jVarF.f6722q.f4998q.invoke();
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                C1640i c1640i = (C1640i) next;
                C1640i c1640i2 = c1640i;
                if (c1640i2.getVisibility().f4582a.b) {
                    Collection collectionN = interfaceC1522eB.n();
                    kotlin.jvm.internal.k.e(collectionN, "getConstructors(...)");
                    Collection<C1640i> collection = collectionN;
                    if (!(collection instanceof Collection) || !collection.isEmpty()) {
                        for (C1640i c1640i3 : collection) {
                            kotlin.jvm.internal.k.c(c1640i3);
                            if (J8.k.j(c1640i3, c1640i.b(aVar)) == OverridingUtil$OverrideCompatibilityInfo$Result.f5116a) {
                                break;
                            }
                        }
                    }
                    if (c1640i2.x().size() == 1) {
                        List listX = c1640i2.x();
                        kotlin.jvm.internal.k.e(listX, "getValueParameters(...)");
                        InterfaceC1524g interfaceC1524gD = ((Q) v.U0(listX)).getType().Q().d();
                        if (kotlin.jvm.internal.k.b(interfaceC1524gD != null ? kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.h(interfaceC1524gD) : null, kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.h(interfaceC1522e))) {
                        }
                    }
                    if (!e8.i.C(c1640i) && !g8.n.f.contains(AbstractC0897f.K(jVarF, com.stepos.ability.task.executor.e.t(c1640i, 3)))) {
                        arrayList.add(next);
                    }
                }
            }
            ArrayList arrayList2 = new ArrayList(w.c0(arrayList, 10));
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                C1640i c1640i4 = (C1640i) it2.next();
                C1640i c1640i5 = c1640i4;
                c1640i5.getClass();
                C1649s c1649sX0 = c1640i5.X0(kotlin.reflect.jvm.internal.impl.types.a.b);
                c1649sX0.b = interfaceC1522e;
                c1649sX0.A(interfaceC1522e.g());
                c1649sX0.o = true;
                P pF = aVar.f();
                if (pF == null) {
                    C1649s.a(37);
                    throw null;
                }
                c1649sX0.f4852a = pF;
                if (!g8.n.g.contains(AbstractC0897f.K(jVarF, com.stepos.ability.task.executor.e.t(c1640i4, 3)))) {
                    c1649sX0.x((InterfaceC1561g) S0.b.g1(this.f, h[2]));
                }
                k8.t tVarU0 = c1649sX0.f4860x.U0(c1649sX0);
                kotlin.jvm.internal.k.d(tVarU0, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassConstructorDescriptor");
                arrayList2.add((C1640i) tVarU0);
            }
            return arrayList2;
        }
        return EmptyList.f4893a;
    }

    @Override // j8.InterfaceC1605d
    public final boolean e(InterfaceC1522e classDescriptor, s sVar) {
        kotlin.jvm.internal.k.f(classDescriptor, "classDescriptor");
        u8.j jVarF = f(classDescriptor);
        if (jVarF == null || !sVar.getAnnotations().k(AbstractC1606e.f4777a)) {
            return true;
        }
        g().getClass();
        String strT = com.stepos.ability.task.executor.e.t(sVar, 3);
        kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.a aVarL = jVarF.L();
        f name = sVar.getName();
        kotlin.jvm.internal.k.e(name, "getName(...)");
        Collection collectionF = aVarL.f(name, NoLookupLocation.f4986a);
        if ((collectionF instanceof Collection) && collectionF.isEmpty()) {
            return false;
        }
        Iterator it = collectionF.iterator();
        while (it.hasNext()) {
            if (com.stepos.ability.task.executor.e.t((K) it.next(), 3).equals(strT)) {
                return true;
            }
        }
        return false;
    }

    public final u8.j f(InterfaceC1522e interfaceC1522e) {
        c cVarA;
        if (interfaceC1522e == null) {
            e8.i.a(AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY);
            throw null;
        }
        if (!e8.i.b(interfaceC1522e, e8.n.f4413a) && e8.i.I(interfaceC1522e)) {
            G8.e eVarH = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.h(interfaceC1522e);
            if (eVarH.d()) {
                String str = C1468d.f4490a;
                G8.b bVarF = C1468d.f(eVarH);
                if (bVarF != null && (cVarA = bVarF.a()) != null) {
                    z zVar = g().f4495a;
                    NoLookupLocation noLookupLocation = NoLookupLocation.f4986a;
                    InterfaceC1522e interfaceC1522eG = AbstractC1538u.g(zVar, cVarA);
                    if (interfaceC1522eG instanceof u8.j) {
                        return (u8.j) interfaceC1522eG;
                    }
                }
            }
        }
        return null;
    }

    public final C1472h g() {
        return (C1472h) S0.b.g1(this.b, h[0]);
    }
}
