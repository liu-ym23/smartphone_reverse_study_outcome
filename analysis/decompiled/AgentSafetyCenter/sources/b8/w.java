package b8;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import java.lang.invoke.VarHandle;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class w extends f {

    /* renamed from: g, reason: collision with root package name */
    public w7.l f2034g;

    /* renamed from: h, reason: collision with root package name */
    public int f2035h;
    public boolean i;

    public static void m(w7.f fVar, w7.l lVar, JsonNode jsonNode, JsonNode jsonNode2, c8.a aVar, boolean z10) {
        fVar.f().getClass();
        b0.A.getClass();
        int size = fVar.f15309d.size();
        lVar.a(fVar, jsonNode, jsonNode2, aVar, z10);
        fVar.f().getClass();
        List list = fVar.f15309d;
        list.subList(size, list.size());
    }

    @Override // w7.s
    public final void a(w7.f fVar, JsonNode jsonNode, JsonNode jsonNode2, c8.a aVar, boolean z10) {
        int i = this.f2035h;
        if (!(jsonNode instanceof ArrayNode)) {
            m(fVar, this.f2034g, null, jsonNode2, aVar.a(i), z10);
            return;
        }
        fVar.f().getClass();
        boolean z11 = false;
        while (i < jsonNode.size()) {
            JsonNode jsonNode3 = jsonNode.get(i);
            jsonNode3.isNull();
            m(fVar, this.f2034g, jsonNode3, jsonNode2, aVar.a(i), z10);
            i++;
            z11 = true;
        }
        if (z11) {
            if (!a.g(fVar)) {
                a.d(fVar, e());
                return;
            }
            androidx.room.t tVarE = fVar.e();
            c8.a aVar2 = fVar.f15311f;
            Boolean bool = Boolean.TRUE;
            x7.a aVar3 = new x7.a();
            aVar3.f15589f = true;
            aVar3.f15584a = this.f1907a;
            aVar3.f15585b = aVar;
            aVar3.f15586c = this.f1909c;
            aVar3.f15587d = aVar2;
            aVar3.f15588e = bool;
            VarHandle.storeStoreFence();
            tVarE.b(aVar3);
        }
    }

    @Override // b8.a, w7.s
    public final void b(w7.f fVar, JsonNode jsonNode, JsonNode jsonNode2, c8.a aVar) {
        if (jsonNode.isArray()) {
            int i = this.f2035h;
            boolean z10 = false;
            while (i < jsonNode.size()) {
                c8.a aVarA = aVar.a(i);
                if (this.i) {
                    this.f2034g.b(fVar, jsonNode.get(i), jsonNode2, aVarA);
                } else {
                    w7.j jVarJ = j();
                    jVarJ.f15293d = aVar;
                    jVarJ.f15291b = fVar.f15311f;
                    jVarJ.f15319l = (Locale) fVar.f15306a.f7721f;
                    Integer numValueOf = Integer.valueOf(i);
                    if (jVarJ.f15295f == null) {
                        jVarJ.f15295f = new HashMap();
                    }
                    jVarJ.f15295f.put("index", numValueOf);
                    jVarJ.f15294e = new Object[]{Integer.valueOf(i)};
                    fVar.a(jVarJ.a());
                }
                i++;
                z10 = true;
            }
            if (z10) {
                if (!a.g(fVar)) {
                    a.d(fVar, e());
                    return;
                }
                androidx.room.t tVarE = fVar.e();
                c8.a aVar2 = fVar.f15311f;
                Boolean bool = Boolean.TRUE;
                x7.a aVar3 = new x7.a();
                aVar3.f15589f = true;
                aVar3.f15584a = this.f1907a;
                aVar3.f15585b = aVar;
                aVar3.f15586c = this.f1909c;
                aVar3.f15587d = aVar2;
                aVar3.f15588e = bool;
                VarHandle.storeStoreFence();
                tVarE.b(aVar3);
            }
        }
    }

    @Override // b8.a
    public final void i() {
        this.f2034g.h();
    }
}
