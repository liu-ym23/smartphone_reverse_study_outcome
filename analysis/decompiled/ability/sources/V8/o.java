package V8;

import D7.w;
import H8.AbstractC0241b;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias;

/* loaded from: classes4.dex */
public final class o {

    /* renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ Z7.t[] f1400j;

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f1401a;
    public final LinkedHashMap b;
    public final LinkedHashMap c;
    public final W8.e d;
    public final W8.e e;
    public final kotlin.reflect.jvm.internal.impl.storage.b f;
    public final W8.h g;
    public final W8.h h;
    public final /* synthetic */ p i;

    static {
        kotlin.jvm.internal.n nVar = kotlin.jvm.internal.m.f4928a;
        f1400j = new Z7.t[]{nVar.g(new PropertyReference1Impl(nVar.b(o.class), "functionNames", "getFunctionNames()Ljava/util/Set;")), nVar.g(new PropertyReference1Impl(nVar.b(o.class), "variableNames", "getVariableNames()Ljava/util/Set;"))};
    }

    public o(p pVar, List functionList, List propertyList, List typeAliasList) {
        kotlin.jvm.internal.k.f(functionList, "functionList");
        kotlin.jvm.internal.k.f(propertyList, "propertyList");
        kotlin.jvm.internal.k.f(typeAliasList, "typeAliasList");
        this.i = pVar;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : functionList) {
            G8.f fVarX = N9.j.x(pVar.b.b, ((ProtoBuf$Function) ((AbstractC0241b) obj)).f);
            Object arrayList = linkedHashMap.get(fVarX);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(fVarX, arrayList);
            }
            ((List) arrayList).add(obj);
        }
        this.f1401a = c(linkedHashMap);
        p pVar2 = this.i;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Object obj2 : propertyList) {
            G8.f fVarX2 = N9.j.x(pVar2.b.b, ((ProtoBuf$Property) ((AbstractC0241b) obj2)).f);
            Object arrayList2 = linkedHashMap2.get(fVarX2);
            if (arrayList2 == null) {
                arrayList2 = new ArrayList();
                linkedHashMap2.put(fVarX2, arrayList2);
            }
            ((List) arrayList2).add(obj2);
        }
        this.b = c(linkedHashMap2);
        this.i.b.f1228a.c.getClass();
        p pVar3 = this.i;
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        for (Object obj3 : typeAliasList) {
            G8.f fVarX3 = N9.j.x(pVar3.b.b, ((ProtoBuf$TypeAlias) ((AbstractC0241b) obj3)).e);
            Object arrayList3 = linkedHashMap3.get(fVarX3);
            if (arrayList3 == null) {
                arrayList3 = new ArrayList();
                linkedHashMap3.put(fVarX3, arrayList3);
            }
            ((List) arrayList3).add(obj3);
        }
        this.c = c(linkedHashMap3);
        this.d = this.i.b.f1228a.f1222a.c(new l(this, 0));
        this.e = this.i.b.f1228a.f1222a.c(new l(this, 1));
        this.f = this.i.b.f1228a.f1222a.d(new l(this, 2));
        p pVar4 = this.i;
        W8.i iVar = pVar4.b.f1228a.f1222a;
        m mVar = new m(this, pVar4, 0);
        iVar.getClass();
        this.g = new W8.h(iVar, mVar);
        p pVar5 = this.i;
        W8.i iVar2 = pVar5.b.f1228a.f1222a;
        m mVar2 = new m(this, pVar5, 1);
        iVar2.getClass();
        this.h = new W8.h(iVar2, mVar2);
    }

    public static LinkedHashMap c(LinkedHashMap linkedHashMap) throws IOException {
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(kotlin.collections.a.P(linkedHashMap.size()));
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            Object key = entry.getKey();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            Iterable<AbstractC0241b> iterable = (Iterable) entry.getValue();
            ArrayList arrayList = new ArrayList(w.c0(iterable, 10));
            for (AbstractC0241b abstractC0241b : iterable) {
                int iA = abstractC0241b.a();
                int iJ = A0.d.j(iA) + iA;
                if (iJ > 4096) {
                    iJ = 4096;
                }
                A0.d dVarN = A0.d.n(byteArrayOutputStream, iJ);
                dVarN.z(iA);
                abstractC0241b.d(dVarN);
                dVarN.m();
                arrayList.add(C7.r.f317a);
            }
            linkedHashMap2.put(key, byteArrayOutputStream.toByteArray());
        }
        return linkedHashMap2;
    }

    public final Collection a(G8.f name, p8.a aVar) {
        kotlin.jvm.internal.k.f(name, "name");
        return !((Set) S0.b.g1(this.g, f1400j[0])).contains(name) ? EmptyList.f4893a : (Collection) this.d.invoke(name);
    }

    public final Collection b(G8.f name, p8.a aVar) {
        kotlin.jvm.internal.k.f(name, "name");
        return !((Set) S0.b.g1(this.h, f1400j[1])).contains(name) ? EmptyList.f4893a : (Collection) this.e.invoke(name);
    }
}
