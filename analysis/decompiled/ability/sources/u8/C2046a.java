package u8;

import i9.C1570e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.EmptyList;

/* renamed from: u8.a, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2046a implements InterfaceC2048c {

    /* renamed from: a, reason: collision with root package name */
    public final kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.a f6714a;
    public final S7.k b;
    public final J4.b c;
    public final LinkedHashMap d;
    public final LinkedHashMap e;
    public final LinkedHashMap f;

    public C2046a(kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.a jClass, S7.k kVar) {
        kotlin.jvm.internal.k.f(jClass, "jClass");
        this.f6714a = jClass;
        this.b = kVar;
        J4.b bVar = new J4.b(this, 23);
        this.c = bVar;
        i9.f fVarF0 = kotlin.sequences.a.f0(D7.v.s0(jClass.e()), bVar);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        C1570e c1570e = new C1570e(fVarF0);
        while (c1570e.hasNext()) {
            Object next = c1570e.next();
            G8.f fVarC = ((n8.q) next).c();
            Object arrayList = linkedHashMap.get(fVarC);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(fVarC, arrayList);
            }
            ((List) arrayList).add(next);
        }
        this.d = linkedHashMap;
        i9.f fVarF02 = kotlin.sequences.a.f0(D7.v.s0(this.f6714a.c()), this.b);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        C1570e c1570e2 = new C1570e(fVarF02);
        while (c1570e2.hasNext()) {
            Object next2 = c1570e2.next();
            linkedHashMap2.put(((n8.n) next2).c(), next2);
        }
        this.e = linkedHashMap2;
        ArrayList arrayListG = this.f6714a.g();
        S7.k kVar2 = this.b;
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayListG.iterator();
        while (it.hasNext()) {
            Object next3 = it.next();
            if (((Boolean) kVar2.invoke(next3)).booleanValue()) {
                arrayList2.add(next3);
            }
        }
        int iP = kotlin.collections.a.P(D7.w.c0(arrayList2, 10));
        LinkedHashMap linkedHashMap3 = new LinkedHashMap(iP < 16 ? 16 : iP);
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            Object next4 = it2.next();
            linkedHashMap3.put(((n8.t) next4).c(), next4);
        }
        this.f = linkedHashMap3;
    }

    @Override // u8.InterfaceC2048c
    public final Set a() {
        i9.f fVarF0 = kotlin.sequences.a.f0(D7.v.s0(this.f6714a.e()), this.c);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        C1570e c1570e = new C1570e(fVarF0);
        while (c1570e.hasNext()) {
            linkedHashSet.add(((n8.q) c1570e.next()).c());
        }
        return linkedHashSet;
    }

    @Override // u8.InterfaceC2048c
    public final Set b() {
        return this.f.keySet();
    }

    @Override // u8.InterfaceC2048c
    public final Set c() {
        i9.f fVarF0 = kotlin.sequences.a.f0(D7.v.s0(this.f6714a.c()), this.b);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        C1570e c1570e = new C1570e(fVarF0);
        while (c1570e.hasNext()) {
            linkedHashSet.add(((n8.n) c1570e.next()).c());
        }
        return linkedHashSet;
    }

    @Override // u8.InterfaceC2048c
    public final n8.n d(G8.f name) {
        kotlin.jvm.internal.k.f(name, "name");
        return (n8.n) this.e.get(name);
    }

    @Override // u8.InterfaceC2048c
    public final Collection e(G8.f name) {
        kotlin.jvm.internal.k.f(name, "name");
        List list = (List) this.d.get(name);
        return list != null ? list : EmptyList.f4893a;
    }

    @Override // u8.InterfaceC2048c
    public final n8.t f(G8.f name) {
        kotlin.jvm.internal.k.f(name, "name");
        return (n8.t) this.f.get(name);
    }
}
