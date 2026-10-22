package b8;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import java.lang.invoke.VarHandle;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class v extends f {

    /* renamed from: g, reason: collision with root package name */
    public w7.l f2029g;

    /* renamed from: h, reason: collision with root package name */
    public List f2030h;
    public Boolean i;

    /* renamed from: j, reason: collision with root package name */
    public w7.l f2031j;

    /* renamed from: k, reason: collision with root package name */
    public w7.n f2032k;

    public static void n(w7.f fVar, w7.l lVar, JsonNode jsonNode, JsonNode jsonNode2, c8.a aVar, boolean z10, String str) throws Throwable {
        w7.f fVar2;
        boolean zEquals = "additionalItems".equals(str);
        if (zEquals) {
            fVar.d();
            fVar.c(str);
        }
        try {
            fVar.f().getClass();
            int size = fVar.f15309d.size();
            fVar2 = fVar;
            try {
                lVar.a(fVar2, jsonNode, jsonNode2, aVar, z10);
                fVar2.f().getClass();
                List list = fVar2.f15309d;
                list.subList(size, list.size());
                if (zEquals) {
                    fVar2.d();
                    fVar2.c("items");
                }
            } catch (Throwable th) {
                th = th;
                Throwable th2 = th;
                if (!zEquals) {
                    throw th2;
                }
                fVar2.d();
                fVar2.c("items");
                throw th2;
            }
        } catch (Throwable th3) {
            th = th3;
            fVar2 = fVar;
        }
    }

    @Override // w7.s
    public final void a(w7.f fVar, JsonNode jsonNode, JsonNode jsonNode2, c8.a aVar, boolean z10) throws Throwable {
        int i;
        w7.f fVar2 = fVar;
        w7.l lVar = this.f2031j;
        w7.l lVar2 = this.f2029g;
        List list = this.f2030h;
        boolean zG = a.g(fVar2);
        if (zG) {
            String str = this.f1907a;
            w7.n nVar = this.f1909c;
            if (lVar2 != null) {
                androidx.room.t tVarE = fVar2.e();
                c8.a aVar2 = fVar2.f15311f;
                Boolean bool = Boolean.TRUE;
                x7.a aVar3 = new x7.a();
                aVar3.f15589f = true;
                aVar3.f15584a = str;
                aVar3.f15585b = aVar;
                aVar3.f15586c = nVar;
                aVar3.f15587d = aVar2;
                aVar3.f15588e = bool;
                VarHandle.storeStoreFence();
                tVarE.b(aVar3);
            } else if (list != null) {
                int size = jsonNode.isArray() ? jsonNode.size() : 1;
                int size2 = list.size();
                if (size > size2) {
                    androidx.room.t tVarE2 = fVar2.e();
                    c8.a aVar4 = fVar2.f15311f;
                    Integer numValueOf = Integer.valueOf(size2);
                    x7.a aVar5 = new x7.a();
                    aVar5.f15589f = true;
                    aVar5.f15584a = str;
                    aVar5.f15585b = aVar;
                    aVar5.f15586c = nVar;
                    aVar5.f15587d = aVar4;
                    aVar5.f15588e = numValueOf;
                    VarHandle.storeStoreFence();
                    tVarE2.b(aVar5);
                } else {
                    androidx.room.t tVarE3 = fVar2.e();
                    c8.a aVar6 = fVar2.f15311f;
                    Boolean bool2 = Boolean.TRUE;
                    x7.a aVar7 = new x7.a();
                    aVar7.f15589f = true;
                    aVar7.f15584a = str;
                    aVar7.f15585b = aVar;
                    aVar7.f15586c = nVar;
                    aVar7.f15587d = aVar6;
                    aVar7.f15588e = bool2;
                    VarHandle.storeStoreFence();
                    tVarE3.b(aVar7);
                }
            }
        } else {
            a.d(fVar2, e());
        }
        int i3 = 0;
        if (lVar2 != null) {
            if (!(jsonNode instanceof ArrayNode)) {
                n(fVar, lVar2, null, jsonNode2, aVar.a(0), z10, b0.B.f1938c);
                return;
            }
            int iMax = Math.max(1, jsonNode.size());
            ArrayNode arrayNode = (ArrayNode) jsonNode;
            fVar2.f().getClass();
            while (i3 < iMax) {
                JsonNode jsonNode3 = arrayNode.get(i3);
                if (jsonNode3 != null) {
                    jsonNode3.isNull();
                }
                n(fVar2, this.f2029g, jsonNode3, jsonNode2, aVar.a(i3), z10, b0.B.f1938c);
                i3++;
                fVar2 = fVar;
            }
            return;
        }
        if (list != null) {
            int size3 = list.size();
            int i10 = 0;
            while (i10 < size3) {
                if (jsonNode instanceof ArrayNode) {
                    JsonNode jsonNode4 = ((ArrayNode) jsonNode).get(i10);
                    fVar2.f().getClass();
                    if (jsonNode4 != null) {
                        jsonNode4.isNull();
                    }
                    fVar2.b(i10);
                    try {
                        i = i10;
                        n(fVar2, (w7.l) list.get(i10), jsonNode4, jsonNode2, aVar.a(i10), z10, b0.B.f1938c);
                    } finally {
                        fVar2.d();
                    }
                } else {
                    i = i10;
                    fVar2.b(i);
                    try {
                        n(fVar2, (w7.l) list.get(i), null, jsonNode2, aVar.a(i), z10, b0.B.f1938c);
                    } finally {
                        fVar.d();
                    }
                }
                i10 = i + 1;
                fVar2 = fVar;
            }
            if (lVar != null) {
                int iMax2 = Math.max(1, (jsonNode != null ? jsonNode.size() : 0) - size3);
                boolean z11 = false;
                for (int i11 = 0; i11 < iMax2; i11++) {
                    int i12 = i11 + size3;
                    if (jsonNode instanceof ArrayNode) {
                        JsonNode jsonNode5 = ((ArrayNode) jsonNode).get(i12);
                        fVar.f().getClass();
                        if (jsonNode5 != null) {
                            jsonNode5.isNull();
                        }
                        n(fVar, this.f2031j, jsonNode5, jsonNode2, aVar.a(i12), z10, "additionalItems");
                        if (jsonNode5 != null) {
                            z11 = true;
                        }
                    } else {
                        n(fVar, this.f2031j, null, jsonNode2, aVar.a(i12), z10, "additionalItems");
                    }
                }
                if (z11) {
                    if (!zG) {
                        fVar.f15306a.getClass();
                        return;
                    }
                    fVar.c("additionalItems");
                    androidx.room.t tVarE4 = fVar.e();
                    c8.a aVar8 = fVar.f15311f;
                    w7.n nVar2 = this.f2032k;
                    Boolean bool3 = Boolean.TRUE;
                    x7.a aVar9 = new x7.a();
                    aVar9.f15589f = true;
                    aVar9.f15584a = "additionalItems";
                    aVar9.f15585b = aVar;
                    aVar9.f15586c = nVar2;
                    aVar9.f15587d = aVar8;
                    aVar9.f15588e = bool3;
                    VarHandle.storeStoreFence();
                    tVarE4.b(aVar9);
                }
            }
        }
    }

    @Override // b8.a, w7.s
    public final void b(w7.f fVar, JsonNode jsonNode, JsonNode jsonNode2, c8.a aVar) {
        List list = this.f2030h;
        if (!jsonNode.isArray()) {
            ((w7.o) this.f1954d.f1601d).f15349g.getClass();
            return;
        }
        boolean zG = a.g(fVar);
        if (zG) {
            w7.l lVar = this.f2029g;
            String str = this.f1907a;
            w7.n nVar = this.f1909c;
            if (lVar != null) {
                androidx.room.t tVarE = fVar.e();
                c8.a aVar2 = fVar.f15311f;
                Boolean bool = Boolean.TRUE;
                x7.a aVar3 = new x7.a();
                aVar3.f15589f = true;
                aVar3.f15584a = str;
                aVar3.f15585b = aVar;
                aVar3.f15586c = nVar;
                aVar3.f15587d = aVar2;
                aVar3.f15588e = bool;
                VarHandle.storeStoreFence();
                tVarE.b(aVar3);
            } else if (list != null) {
                int size = jsonNode.isArray() ? jsonNode.size() : 1;
                int size2 = list.size();
                if (size > size2) {
                    androidx.room.t tVarE2 = fVar.e();
                    c8.a aVar4 = fVar.f15311f;
                    Integer numValueOf = Integer.valueOf(size2);
                    x7.a aVar5 = new x7.a();
                    aVar5.f15589f = true;
                    aVar5.f15584a = str;
                    aVar5.f15585b = aVar;
                    aVar5.f15586c = nVar;
                    aVar5.f15587d = aVar4;
                    aVar5.f15588e = numValueOf;
                    VarHandle.storeStoreFence();
                    tVarE2.b(aVar5);
                } else {
                    androidx.room.t tVarE3 = fVar.e();
                    c8.a aVar6 = fVar.f15311f;
                    Boolean bool2 = Boolean.TRUE;
                    x7.a aVar7 = new x7.a();
                    aVar7.f15589f = true;
                    aVar7.f15584a = str;
                    aVar7.f15585b = aVar;
                    aVar7.f15586c = nVar;
                    aVar7.f15587d = aVar6;
                    aVar7.f15588e = bool2;
                    VarHandle.storeStoreFence();
                    tVarE3.b(aVar7);
                }
            }
        } else {
            a.d(fVar, e());
        }
        boolean z10 = false;
        if (jsonNode.isArray()) {
            Iterator<JsonNode> it = jsonNode.iterator();
            int i = 0;
            while (it.hasNext()) {
                if (m(fVar, i, it.next(), jsonNode2, aVar)) {
                    z10 = true;
                }
                i++;
            }
        } else if (m(fVar, 0, jsonNode, jsonNode2, aVar)) {
            z10 = true;
        }
        if (z10) {
            if (!zG) {
                fVar.f15306a.getClass();
                return;
            }
            fVar.c("additionalItems");
            androidx.room.t tVarE4 = fVar.e();
            c8.a aVar8 = fVar.f15311f;
            w7.n nVar2 = this.f2032k;
            Boolean bool3 = Boolean.TRUE;
            x7.a aVar9 = new x7.a();
            aVar9.f15589f = true;
            aVar9.f15584a = "additionalItems";
            aVar9.f15585b = aVar;
            aVar9.f15586c = nVar2;
            aVar9.f15587d = aVar8;
            aVar9.f15588e = bool3;
            VarHandle.storeStoreFence();
            tVarE4.b(aVar9);
            fVar.d();
        }
    }

    @Override // b8.a
    public final void i() {
        w7.l lVar = this.f2029g;
        if (lVar != null) {
            lVar.h();
        }
        f.l(this.f2030h);
        w7.l lVar2 = this.f2031j;
        if (lVar2 != null) {
            lVar2.h();
        }
    }

    public final boolean m(w7.f fVar, int i, JsonNode jsonNode, JsonNode jsonNode2, c8.a aVar) {
        Boolean bool = this.i;
        List list = this.f2030h;
        w7.l lVar = this.f2031j;
        c8.a aVarA = aVar.a(i);
        w7.l lVar2 = this.f2029g;
        if (lVar2 != null) {
            lVar2.b(fVar, jsonNode, jsonNode2, aVarA);
            return false;
        }
        if (list != null) {
            if (i < list.size()) {
                fVar.b(i);
                try {
                    ((w7.l) list.get(i)).b(fVar, jsonNode, jsonNode2, aVarA);
                    return false;
                } finally {
                    fVar.d();
                }
            }
            z = (bool != null && bool.booleanValue()) || lVar != null;
            if (lVar != null) {
                fVar.d();
                fVar.c("additionalItems");
                try {
                    lVar.b(fVar, jsonNode, jsonNode2, aVarA);
                    return z;
                } finally {
                }
            }
            if (bool != null && !bool.booleanValue()) {
                fVar.d();
                fVar.c("additionalItems");
                try {
                    w7.j jVarJ = j();
                    jVarJ.f15293d = aVar;
                    jVarJ.f15290a = "additionalItems";
                    jVarJ.i = "additionalItems";
                    jVarJ.f15291b = fVar.f15311f;
                    jVarJ.f15292c = this.f2032k;
                    jVarJ.f15319l = (Locale) fVar.f15306a.f7721f;
                    Integer numValueOf = Integer.valueOf(i);
                    if (jVarJ.f15295f == null) {
                        jVarJ.f15295f = new HashMap();
                    }
                    jVarJ.f15295f.put("index", numValueOf);
                    jVarJ.f15294e = new Object[]{Integer.valueOf(i)};
                    fVar.a(jVarJ.a());
                    return z;
                } finally {
                }
            }
        }
        return z;
    }
}
