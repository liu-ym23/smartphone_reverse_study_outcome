package f8;

import D7.v;
import h8.InterfaceC1522e;
import h8.InterfaceC1540w;
import j8.InterfaceC1604c;
import j9.m;
import j9.t;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import k8.w;
import k8.z;
import kotlin.collections.EmptySet;

/* renamed from: f8.a, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1440a implements InterfaceC1604c {

    /* renamed from: a, reason: collision with root package name */
    public final W8.i f4443a;
    public final InterfaceC1540w b;

    public C1440a(W8.i iVar, z module) {
        kotlin.jvm.internal.k.f(module, "module");
        this.f4443a = iVar;
        this.b = module;
    }

    @Override // j8.InterfaceC1604c
    public final InterfaceC1522e a(G8.b classId) {
        G8.c cVar;
        k kVarA;
        kotlin.jvm.internal.k.f(classId, "classId");
        G8.c cVar2 = classId.b;
        if (classId.c || !cVar2.e().d()) {
            return null;
        }
        String strB = cVar2.b();
        if (!m.h0(strB, "Function", false) || (kVarA = l.c.a((cVar = classId.f687a), strB)) == null) {
            return null;
        }
        j jVar = kVarA.f4446a;
        int i = kVarA.b;
        List list = (List) S0.b.g1(((w) this.b.V(cVar)).e, w.h[0]);
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (obj instanceof U8.b) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            it.next();
        }
        if (v.C0(arrayList2) == null) {
            return new C1442c(this.f4443a, (U8.b) v.A0(arrayList), jVar, i);
        }
        throw new ClassCastException();
    }

    @Override // j8.InterfaceC1604c
    public final boolean b(G8.c packageFqName, G8.f name) {
        kotlin.jvm.internal.k.f(packageFqName, "packageFqName");
        kotlin.jvm.internal.k.f(name, "name");
        String strB = name.b();
        kotlin.jvm.internal.k.e(strB, "asString(...)");
        return (t.e0(strB, "Function", false) || t.e0(strB, "KFunction", false) || t.e0(strB, "SuspendFunction", false) || t.e0(strB, "KSuspendFunction", false)) && l.c.a(packageFqName, strB) != null;
    }

    @Override // j8.InterfaceC1604c
    public final Collection c(G8.c packageFqName) {
        kotlin.jvm.internal.k.f(packageFqName, "packageFqName");
        return EmptySet.f4895a;
    }
}
