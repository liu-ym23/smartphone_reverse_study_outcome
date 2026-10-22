package b8;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.TextNode;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.stream.Collectors;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class j0 extends f {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f1972g;

    /* renamed from: h, reason: collision with root package name */
    public w7.l f1973h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ j0(x xVar, JsonNode jsonNode, w7.n nVar, w7.l lVar, androidx.room.q qVar, int i) {
        super(xVar, jsonNode, nVar, lVar, qVar);
        this.f1972g = i;
    }

    @Override // w7.s
    public void a(w7.f fVar, JsonNode jsonNode, JsonNode jsonNode2, c8.a aVar, boolean z10) throws Throwable {
        switch (this.f1972g) {
            case 0:
                if (z10 && jsonNode != null) {
                    m(fVar, jsonNode, jsonNode2, aVar, true);
                    break;
                } else {
                    this.f1973h.a(fVar, jsonNode, jsonNode2, aVar, false);
                    break;
                }
            default:
                super.a(fVar, jsonNode, jsonNode2, aVar, z10);
                break;
        }
    }

    @Override // b8.a, w7.s
    public final void b(w7.f fVar, JsonNode jsonNode, JsonNode jsonNode2, c8.a aVar) throws Throwable {
        switch (this.f1972g) {
            case 0:
                m(fVar, jsonNode, jsonNode2, aVar, false);
                return;
            case 1:
                List list = fVar.f15309d;
                ArrayList arrayList = new ArrayList();
                fVar.f15309d = arrayList;
                Iterator<String> itFieldNames = jsonNode.fieldNames();
                while (itFieldNames.hasNext()) {
                    String next = itFieldNames.next();
                    this.f1973h.b(fVar, TextNode.valueOf(next), jsonNode, aVar.b(next));
                    int size = arrayList.size();
                    int i = 0;
                    while (i < size) {
                        Object obj = arrayList.get(i);
                        i++;
                        w7.j jVar = (w7.j) j().b(next);
                        jVar.f15293d = aVar;
                        jVar.f15291b = fVar.f15311f;
                        jVar.f15319l = (Locale) fVar.f15306a.f7721f;
                        jVar.f15294e = new Object[]{next, ((w7.e) obj).a()};
                        list.add(jVar.a());
                    }
                    arrayList.clear();
                }
                fVar.f15309d = list;
                return;
            default:
                JsonNode jsonNode3 = this.f1908b;
                if (jsonNode.isObject()) {
                    a8.e eVar = new a8.e(7);
                    t0 t0Var = new t0(1);
                    t0Var.f2023f = fVar;
                    VarHandle.storeStoreFence();
                    List list2 = (List) fVar.e().f1627b.getOrDefault(aVar, Collections.EMPTY_LIST);
                    LinkedHashSet linkedHashSet = new LinkedHashSet();
                    LinkedHashSet linkedHashSet2 = new LinkedHashSet();
                    Iterator it = ((List) list2.stream().filter(new a8.e(8)).filter(t0Var).filter(eVar).collect(Collectors.toList())).iterator();
                    while (it.hasNext()) {
                        Object obj2 = ((x7.a) it.next()).f15588e;
                        if (obj2 instanceof Set) {
                            linkedHashSet2.addAll((Set) obj2);
                        }
                    }
                    Iterator it2 = ((List) list2.stream().filter(new a8.e(9)).filter(t0Var).filter(eVar).collect(Collectors.toList())).iterator();
                    while (it2.hasNext()) {
                        Object obj3 = ((x7.a) it2.next()).f15588e;
                        if (obj3 instanceof Set) {
                            linkedHashSet2.addAll((Set) obj3);
                        }
                    }
                    Iterator it3 = ((List) list2.stream().filter(new a8.e(10)).filter(t0Var).filter(eVar).collect(Collectors.toList())).iterator();
                    while (it3.hasNext()) {
                        Object obj4 = ((x7.a) it3.next()).f15588e;
                        if (obj4 instanceof Set) {
                            linkedHashSet2.addAll((Set) obj4);
                        }
                    }
                    Iterator it4 = ((List) list2.stream().filter(new a8.e(11)).filter(t0Var).filter(eVar).collect(Collectors.toList())).iterator();
                    while (it4.hasNext()) {
                        Object obj5 = ((x7.a) it4.next()).f15588e;
                        if (obj5 instanceof Set) {
                            linkedHashSet2.addAll((Set) obj5);
                        }
                    }
                    boolean zG = fVar.g();
                    try {
                        fVar.h(false);
                        Iterator<String> itFieldNames2 = jsonNode.fieldNames();
                        while (itFieldNames2.hasNext()) {
                            String next2 = itFieldNames2.next();
                            if (!linkedHashSet2.contains(next2)) {
                                linkedHashSet.add(next2);
                                if (!jsonNode3.isBoolean() || jsonNode3.booleanValue()) {
                                    this.f1973h.b(fVar, jsonNode.get(next2), jsonNode, aVar.b(next2));
                                } else {
                                    w7.j jVarJ = j();
                                    jVarJ.f15293d = aVar;
                                    w7.j jVar2 = (w7.j) jVarJ.b(next2);
                                    jVar2.f15291b = fVar.f15311f;
                                    jVar2.f15294e = new Object[]{next2};
                                    jVar2.f15319l = (Locale) fVar.f15306a.f7721f;
                                    fVar.a(jVar2.a());
                                }
                            }
                        }
                        fVar.h(zG);
                        androidx.room.t tVarE = fVar.e();
                        c8.a aVar2 = fVar.f15311f;
                        x7.a aVar3 = new x7.a();
                        aVar3.f15589f = true;
                        aVar3.f15584a = this.f1907a;
                        aVar3.f15585b = aVar;
                        aVar3.f15586c = this.f1909c;
                        aVar3.f15587d = aVar2;
                        aVar3.f15588e = linkedHashSet;
                        VarHandle.storeStoreFence();
                        tVarE.b(aVar3);
                        return;
                    } catch (Throwable th) {
                        fVar.h(zG);
                        throw th;
                    }
                }
                return;
        }
    }

    @Override // b8.a
    public void i() {
        switch (this.f1972g) {
            case 0:
                w7.l lVar = this.f1973h;
                if (lVar != null) {
                    lVar.h();
                    break;
                }
                break;
            case 1:
                this.f1973h.h();
                break;
        }
    }

    public void m(w7.f fVar, JsonNode jsonNode, JsonNode jsonNode2, c8.a aVar, boolean z10) throws Throwable {
        w7.f fVar2;
        Throwable th;
        c8.a aVar2;
        boolean zG = fVar.g();
        List list = fVar.f15309d;
        ArrayList arrayList = new ArrayList();
        fVar.f15309d = arrayList;
        try {
            fVar.h(false);
            w7.l lVar = this.f1973h;
            if (z10) {
                fVar2 = fVar;
                aVar2 = aVar;
                try {
                    lVar.a(fVar2, jsonNode, jsonNode2, aVar2, true);
                } catch (Throwable th2) {
                    th = th2;
                    th = th;
                    fVar2.h(zG);
                    fVar2.f15309d = list;
                    throw th;
                }
            } else {
                try {
                    lVar.b(fVar, jsonNode, jsonNode2, aVar);
                    fVar2 = fVar;
                    aVar2 = aVar;
                } catch (Throwable th3) {
                    th = th3;
                    fVar2 = fVar;
                    fVar2.h(zG);
                    fVar2.f15309d = list;
                    throw th;
                }
            }
            fVar2.h(zG);
            fVar2.f15309d = list;
            if (arrayList.isEmpty()) {
                w7.j jVarJ = j();
                jVarJ.f15293d = aVar2;
                jVarJ.f15291b = fVar2.f15311f;
                jVarJ.f15319l = (Locale) fVar2.f15306a.f7721f;
                jVarJ.f15294e = new Object[]{this.f1908b.toString()};
                fVar2.a(jVarJ.a());
            }
        } catch (Throwable th4) {
            th = th4;
            fVar2 = fVar;
        }
    }
}
