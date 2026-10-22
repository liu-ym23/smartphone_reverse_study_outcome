package b8;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.MissingNode;
import java.lang.invoke.VarHandle;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class l0 extends f {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f1980g;

    /* renamed from: h, reason: collision with root package name */
    public LinkedHashMap f1981h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ l0(x xVar, JsonNode jsonNode, w7.n nVar, w7.l lVar, androidx.room.q qVar, int i) {
        super(xVar, jsonNode, nVar, lVar, qVar);
        this.f1980g = i;
    }

    public static void n(w7.f fVar, Map.Entry entry, JsonNode jsonNode, JsonNode jsonNode2, c8.a aVar, boolean z10) {
        w7.l lVar = (w7.l) entry.getValue();
        JsonNode jsonNode3 = jsonNode == null ? null : jsonNode.get((String) entry.getKey());
        c8.a aVarB = aVar.b((String) entry.getKey());
        b0.T.getClass();
        if (jsonNode3 == null && jsonNode != null) {
            jsonNode3 = jsonNode.get((String) entry.getKey());
        }
        JsonNode jsonNode4 = jsonNode3;
        int size = fVar.f15309d.size();
        lVar.a(fVar, jsonNode4, jsonNode2, aVarB, z10);
        List list = fVar.f15309d;
        list.subList(size, list.size());
    }

    @Override // w7.s
    public final void a(w7.f fVar, JsonNode jsonNode, JsonNode jsonNode2, c8.a aVar, boolean z10) {
        switch (this.f1980g) {
            case 0:
                LinkedHashMap linkedHashMap = this.f1981h;
                fVar.f().getClass();
                if (z10) {
                    if (jsonNode == null) {
                        jsonNode = MissingNode.getInstance();
                    }
                    m(fVar, jsonNode, jsonNode2, aVar, true);
                    return;
                }
                fVar.f().getClass();
                for (Map.Entry entry : linkedHashMap.entrySet()) {
                    fVar.c((String) entry.getKey());
                    w7.f fVar2 = fVar;
                    try {
                        n(fVar2, entry, jsonNode, jsonNode2, aVar, z10);
                        fVar2 = fVar2;
                    } finally {
                        fVar2.d();
                    }
                }
                return;
            default:
                if (z10) {
                    m(fVar, jsonNode, jsonNode2, aVar, true);
                    return;
                }
                for (Map.Entry entry2 : this.f1981h.entrySet()) {
                    fVar.c((String) entry2.getKey());
                    try {
                        for (Map.Entry entry3 : ((Map) entry2.getValue()).entrySet()) {
                            fVar.c((String) entry3.getKey());
                            try {
                                ((w7.l) entry3.getValue()).a(fVar, jsonNode, jsonNode2, aVar, false);
                                fVar.d();
                            } catch (Throwable th) {
                                fVar.d();
                                throw th;
                            }
                        }
                        fVar.d();
                    } catch (Throwable th2) {
                        fVar.d();
                        throw th2;
                    }
                }
                return;
        }
    }

    @Override // b8.a, w7.s
    public final void b(w7.f fVar, JsonNode jsonNode, JsonNode jsonNode2, c8.a aVar) {
        switch (this.f1980g) {
            case 0:
                m(fVar, jsonNode, jsonNode2, aVar, false);
                break;
            default:
                m(fVar, jsonNode, jsonNode2, aVar, false);
                break;
        }
    }

    @Override // b8.a
    public final void i() {
        switch (this.f1980g) {
            case 0:
                f.l(this.f1981h.values());
                break;
            default:
                Iterator it = this.f1981h.values().iterator();
                while (it.hasNext()) {
                    Iterator it2 = ((Map) it.next()).values().iterator();
                    while (it2.hasNext()) {
                        ((w7.l) it2.next()).h();
                    }
                }
                break;
        }
    }

    public final void m(w7.f fVar, JsonNode jsonNode, JsonNode jsonNode2, c8.a aVar, boolean z10) {
        boolean z11;
        Map map;
        c8.a aVar2 = aVar;
        switch (this.f1980g) {
            case 0:
                if (a.h(fVar)) {
                    z11 = true;
                } else {
                    a.d(fVar, e());
                    z11 = false;
                }
                Set linkedHashSet = null;
                for (Map.Entry entry : this.f1981h.entrySet()) {
                    JsonNode jsonNode3 = jsonNode.get((String) entry.getKey());
                    if (jsonNode3 != null) {
                        c8.a aVarB = aVar2.b((String) entry.getKey());
                        if (z11) {
                            if (linkedHashSet == null) {
                                linkedHashSet = new LinkedHashSet();
                            }
                            linkedHashSet.add((String) entry.getKey());
                        }
                        fVar.c((String) entry.getKey());
                        if (z10) {
                            fVar.f().getClass();
                            n(fVar, entry, jsonNode, jsonNode2, aVar2, true);
                        } else {
                            try {
                                ((w7.l) entry.getValue()).b(fVar, jsonNode3, jsonNode2, aVarB);
                            } finally {
                            }
                        }
                    } else if (z10) {
                        fVar.c((String) entry.getKey());
                        try {
                            fVar.f().getClass();
                            aVar2 = aVar;
                            n(fVar, entry, jsonNode, jsonNode2, aVar2, true);
                        } finally {
                            fVar.d();
                        }
                    }
                    aVar2 = aVar;
                }
                if (z11) {
                    androidx.room.t tVarE = fVar.e();
                    c8.a aVar3 = fVar.f15311f;
                    if (linkedHashSet == null) {
                        linkedHashSet = Collections.EMPTY_SET;
                    }
                    x7.a aVar4 = new x7.a();
                    aVar4.f15589f = true;
                    aVar4.f15584a = this.f1907a;
                    aVar4.f15585b = aVar2;
                    aVar4.f15586c = this.f1909c;
                    aVar4.f15587d = aVar3;
                    aVar4.f15588e = linkedHashSet;
                    VarHandle.storeStoreFence();
                    tVarE.b(aVar4);
                    return;
                }
                return;
            default:
                for (Map.Entry<String, JsonNode> entry2 : jsonNode.properties()) {
                    String key = entry2.getKey();
                    String strAsText = entry2.getValue().asText();
                    if (strAsText != null && (map = (Map) this.f1981h.get(key)) != null) {
                        fVar.c(key);
                        try {
                            w7.l lVar = (w7.l) map.get(strAsText);
                            if (lVar != null) {
                                fVar.c(strAsText);
                                if (z10) {
                                    lVar.a(fVar, jsonNode, jsonNode2, aVar, true);
                                    aVar2 = aVar;
                                } else {
                                    try {
                                        lVar.b(fVar, jsonNode, jsonNode2, aVar2);
                                    } catch (Throwable th) {
                                        fVar.d();
                                        throw th;
                                    }
                                }
                                fVar.d();
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                }
                return;
        }
    }
}
