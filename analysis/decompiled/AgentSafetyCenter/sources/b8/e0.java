package b8;

import com.fasterxml.jackson.databind.JsonNode;
import java.lang.invoke.VarHandle;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e0 extends f {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f1952g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f1953h;
    public Object i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e0(x xVar, JsonNode jsonNode, w7.n nVar, w7.l lVar, androidx.room.q qVar, int i) {
        super(xVar, jsonNode, nVar, lVar, qVar);
        this.f1952g = i;
    }

    @Override // b8.a, w7.s
    public final void b(w7.f fVar, JsonNode jsonNode, JsonNode jsonNode2, c8.a aVar) {
        boolean z10;
        int i;
        boolean z11;
        int i3 = this.f1952g;
        androidx.room.q qVar = this.f1954d;
        switch (i3) {
            case 0:
                r0 r0Var = (r0) this.i;
                if (g8.b.a(jsonNode, ((w7.o) qVar.f1601d).f15349g) && r0Var.o(jsonNode)) {
                    w7.j jVarJ = j();
                    jVarJ.f15293d = aVar;
                    jVarJ.f15291b = fVar.f15311f;
                    jVarJ.f15319l = (Locale) fVar.f15306a.f7721f;
                    jVarJ.f15294e = new Object[]{r0Var.k()};
                    fVar.a(jVarJ.a());
                    break;
                }
                break;
            case 1:
                r0 r0Var2 = (r0) this.i;
                if (g8.b.a(jsonNode, ((w7.o) qVar.f1601d).f15349g) && r0Var2.o(jsonNode)) {
                    w7.j jVarJ2 = j();
                    jVarJ2.f15293d = aVar;
                    jVarJ2.f15291b = fVar.f15311f;
                    jVarJ2.f15319l = (Locale) fVar.f15306a.f7721f;
                    jVarJ2.f15294e = new Object[]{r0Var2.k()};
                    fVar.a(jVarJ2.a());
                    break;
                }
                break;
            default:
                if (jsonNode.isArray()) {
                    boolean z12 = this.f1953h;
                    String str = z12 ? "prefixItems" : "items";
                    String str2 = z12 ? "items" : "additionalItems";
                    a8.e eVar = new a8.e(4);
                    boolean z13 = false;
                    t0 t0Var = new t0(0);
                    t0Var.f2023f = fVar;
                    VarHandle.storeStoreFence();
                    List list = (List) fVar.e().f1627b.getOrDefault(aVar, Collections.EMPTY_LIST);
                    JsonNode jsonNode3 = this.f1908b;
                    if (!jsonNode3.isBoolean() || !jsonNode3.booleanValue()) {
                        Stream stream = list.stream();
                        u0 u0Var = new u0(0);
                        u0Var.f2028f = str;
                        VarHandle.storeStoreFence();
                        List list2 = (List) stream.filter(u0Var).filter(t0Var).filter(eVar).collect(Collectors.toList());
                        if (list2.isEmpty()) {
                            z10 = false;
                            i = 0;
                        } else {
                            Iterator it = list2.iterator();
                            z10 = false;
                            i = 0;
                            while (it.hasNext()) {
                                Object obj = ((x7.a) it.next()).f15588e;
                                if (obj instanceof Number) {
                                    int iIntValue = ((Number) obj).intValue();
                                    if (iIntValue > i) {
                                        i = iIntValue;
                                    }
                                } else if (obj instanceof Boolean) {
                                    z10 = true;
                                }
                            }
                        }
                        if (!z10) {
                            Stream stream2 = list.stream();
                            u0 u0Var2 = new u0(1);
                            u0Var2.f2028f = str2;
                            VarHandle.storeStoreFence();
                            Iterator it2 = ((List) stream2.filter(u0Var2).filter(t0Var).filter(eVar).collect(Collectors.toList())).iterator();
                            while (it2.hasNext()) {
                                Object obj2 = ((x7.a) it2.next()).f15588e;
                                if ((obj2 instanceof Boolean) && Boolean.TRUE.equals(obj2)) {
                                    z10 = true;
                                }
                            }
                        }
                        if (!z10) {
                            Iterator it3 = ((List) list.stream().filter(new a8.e(5)).filter(t0Var).filter(eVar).collect(Collectors.toList())).iterator();
                            while (it3.hasNext()) {
                                Object obj3 = ((x7.a) it3.next()).f15588e;
                                if ((obj3 instanceof Boolean) && Boolean.TRUE.equals(obj3)) {
                                    z10 = true;
                                }
                            }
                        }
                        z11 = false;
                    } else if (jsonNode.isEmpty()) {
                        z11 = false;
                        i = 0;
                        z10 = true;
                    } else {
                        i = 0;
                        z11 = true;
                        z10 = true;
                    }
                    if (!z10) {
                        fVar.f15309d.size();
                        List list3 = (List) list.stream().filter(new a8.e(6)).filter(t0Var).filter(eVar).collect(Collectors.toList());
                        HashSet hashSet = new HashSet();
                        Iterator it4 = list3.iterator();
                        while (it4.hasNext()) {
                            Object obj4 = ((x7.a) it4.next()).f15588e;
                            if (obj4 instanceof List) {
                                hashSet.addAll((List) obj4);
                            } else if (obj4 instanceof Boolean) {
                                z13 = true;
                            }
                        }
                        if (!z13) {
                            while (i < jsonNode.size()) {
                                if (!hashSet.contains(Integer.valueOf(i))) {
                                    if (!jsonNode3.isBoolean() || jsonNode3.booleanValue()) {
                                        ((w7.l) this.i).b(fVar, jsonNode.get(i), jsonNode, aVar.a(i));
                                    } else {
                                        w7.j jVarJ3 = j();
                                        jVarJ3.f15293d = aVar;
                                        jVarJ3.f15294e = new Object[]{Integer.valueOf(i)};
                                        jVarJ3.f15291b = fVar.f15311f;
                                        jVarJ3.f15319l = (Locale) fVar.f15306a.f7721f;
                                        fVar.a(jVarJ3.a());
                                    }
                                    z11 = true;
                                }
                                i++;
                            }
                        }
                        fVar.f15309d.size();
                    }
                    if (z11) {
                        androidx.room.t tVarE = fVar.e();
                        c8.a aVar2 = fVar.f15311f;
                        Boolean bool = Boolean.TRUE;
                        x7.a aVar3 = new x7.a();
                        aVar3.f15589f = true;
                        aVar3.f15584a = "unevaluatedItems";
                        aVar3.f15585b = aVar;
                        aVar3.f15586c = this.f1909c;
                        aVar3.f15587d = aVar2;
                        aVar3.f15588e = bool;
                        VarHandle.storeStoreFence();
                        tVarE.b(aVar3);
                        break;
                    }
                }
                break;
        }
    }
}
