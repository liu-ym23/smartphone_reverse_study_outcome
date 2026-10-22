package z3;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.networknt.schema.SchemaException;
import com.networknt.schema.keyword.KeywordType;
import com.networknt.schema.utils.JsonType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import v3.C2057a;

/* renamed from: z3.c, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2158c extends AbstractC2161f {
    public final /* synthetic */ int f;
    public final ArrayList g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2158c(u3.j jVar, JsonNode jsonNode, u3.i iVar, G6.c cVar, int i) {
        super(KeywordType.e, jsonNode, jVar, iVar, cVar);
        this.f = i;
        switch (i) {
            case 1:
                super(KeywordType.f, jsonNode, jVar, iVar, cVar);
                if (jsonNode.isArray()) {
                    int size = jsonNode.size();
                    this.g = new ArrayList(size);
                    for (int i6 = 0; i6 < size; i6++) {
                        this.g.add(cVar.c(jVar.a(i6), jsonNode.get(i6), iVar));
                    }
                    return;
                }
                JsonType jsonTypeD = com.stepos.ability.task.executor.e.D(jsonNode, ((u3.k) this.d.d).g);
                u3.g gVarJ = j();
                gVarJ.getClass();
                gVarJ.d = jVar.b;
                gVarJ.i = "type";
                gVarJ.e = new Object[]{jsonTypeD.f3057a, "array"};
                throw new SchemaException(gVarJ.a());
            case 2:
                super(KeywordType.f3027P, jsonNode, jVar, iVar, cVar);
                if (!jsonNode.isArray()) {
                    JsonType jsonTypeD2 = com.stepos.ability.task.executor.e.D(jsonNode, ((u3.k) this.d.d).g);
                    u3.g gVarJ2 = j();
                    gVarJ2.getClass();
                    gVarJ2.d = jVar.b;
                    gVarJ2.i = "type";
                    gVarJ2.e = new Object[]{jsonTypeD2.f3057a, "array"};
                    throw new SchemaException(gVarJ2.a());
                }
                int size2 = jsonNode.size();
                this.g = new ArrayList(size2);
                for (int i10 = 0; i10 < size2; i10++) {
                    this.g.add(cVar.c(jVar.a(i10), jsonNode.get(i10), iVar));
                }
                return;
            case 3:
                super(KeywordType.f3030S, jsonNode, jVar, iVar, cVar);
                if (!(jsonNode instanceof ArrayNode) || jsonNode.isEmpty()) {
                    throw new IllegalArgumentException("The value of 'prefixItems' MUST be a non-empty array of valid JSON Schemas.");
                }
                this.g = new ArrayList(jsonNode.size());
                Iterator<JsonNode> it = jsonNode.iterator();
                int i11 = 0;
                while (it.hasNext()) {
                    this.g.add(cVar.c(jVar.a(i11), it.next(), iVar));
                    i11++;
                }
                return;
            default:
                if (jsonNode.isArray()) {
                    int size3 = jsonNode.size();
                    this.g = new ArrayList(size3);
                    for (int i12 = 0; i12 < size3; i12++) {
                        this.g.add(cVar.c(jVar.a(i12), jsonNode.get(i12), iVar));
                    }
                    return;
                }
                JsonType jsonTypeD3 = com.stepos.ability.task.executor.e.D(jsonNode, ((u3.k) this.d.d).g);
                u3.g gVarJ3 = j();
                gVarJ3.getClass();
                gVarJ3.d = jVar.b;
                gVarJ3.i = "type";
                gVarJ3.e = new Object[]{jsonTypeD3.f3057a, "array"};
                throw new SchemaException(gVarJ3.a());
        }
    }

    @Override // z3.AbstractC2156a, u3.m
    public final void a(u3.f fVar, JsonNode jsonNode, JsonNode jsonNode2, A3.a aVar) {
        switch (this.f) {
            case 0:
                n(fVar, jsonNode, jsonNode2, aVar, false);
                return;
            case 1:
                n(fVar, jsonNode, jsonNode2, aVar, false);
                return;
            case 2:
                n(fVar, jsonNode, jsonNode2, aVar, false);
                return;
            default:
                if (jsonNode.isArray()) {
                    int size = jsonNode.size();
                    ArrayList arrayList = this.g;
                    int iMin = Math.min(size, arrayList.size());
                    for (int i = 0; i < iMin; i++) {
                        aVar.getClass();
                        A3.a aVar2 = new A3.a(aVar, i);
                        fVar.b(i);
                        try {
                            ((u3.i) arrayList.get(i)).a(fVar, jsonNode.get(i), jsonNode2, aVar2);
                            fVar.d();
                        } catch (Throwable th) {
                            fVar.d();
                            throw th;
                        }
                    }
                    if (!AbstractC2156a.g(fVar)) {
                        AbstractC2156a.d(fVar, e());
                        return;
                    }
                    int size2 = jsonNode.isArray() ? jsonNode.size() : 1;
                    int size3 = arrayList.size();
                    if (size2 > size3) {
                        fVar.e().a(new C2057a(this.f6946a, aVar, this.c, fVar.f, Integer.valueOf(size3)));
                        return;
                    } else {
                        fVar.e().a(new C2057a(this.f6946a, aVar, this.c, fVar.f, Boolean.TRUE));
                        return;
                    }
                }
                return;
        }
    }

    @Override // u3.m
    public final void b(u3.f fVar, JsonNode jsonNode, JsonNode jsonNode2, A3.a aVar, boolean z10) {
        switch (this.f) {
            case 0:
                if (z10 && jsonNode != null) {
                    n(fVar, jsonNode, jsonNode2, aVar, true);
                    return;
                }
                Iterator it = this.g.iterator();
                int i = 0;
                while (it.hasNext()) {
                    u3.i iVar = (u3.i) it.next();
                    fVar.b(i);
                    try {
                        iVar.b(fVar, jsonNode, jsonNode2, aVar, false);
                        fVar.d();
                        i++;
                    } finally {
                    }
                }
                return;
            case 1:
                if (z10 && jsonNode != null) {
                    n(fVar, jsonNode, jsonNode2, aVar, true);
                    return;
                }
                Iterator it2 = this.g.iterator();
                int i6 = 0;
                while (it2.hasNext()) {
                    u3.i iVar2 = (u3.i) it2.next();
                    fVar.b(i6);
                    try {
                        iVar2.b(fVar, jsonNode, jsonNode2, aVar, false);
                        fVar.d();
                        i6++;
                    } finally {
                    }
                }
                return;
            case 2:
                if (z10 && jsonNode != null) {
                    n(fVar, jsonNode, jsonNode2, aVar, true);
                    return;
                }
                Iterator it3 = this.g.iterator();
                int i10 = 0;
                while (it3.hasNext()) {
                    u3.i iVar3 = (u3.i) it3.next();
                    fVar.b(i10);
                    try {
                        iVar3.b(fVar, jsonNode, jsonNode2, aVar, false);
                        fVar.d();
                        i10++;
                    } finally {
                    }
                }
                return;
            default:
                boolean z11 = jsonNode instanceof ArrayNode;
                int i11 = 0;
                ArrayList arrayList = this.g;
                if (!z11) {
                    int size = arrayList.size();
                    while (i11 < size) {
                        m(fVar, i11, null, jsonNode2, aVar, z10);
                        i11++;
                    }
                    return;
                }
                int size2 = arrayList.size();
                while (i11 < size2) {
                    JsonNode jsonNode3 = jsonNode.get(i11);
                    ((G3.a) fVar.f().f4555a).getClass();
                    m(fVar, i11, jsonNode3, jsonNode2, aVar, z10);
                    i11++;
                }
                if (!AbstractC2156a.g(fVar)) {
                    AbstractC2156a.d(fVar, e());
                    return;
                }
                int size3 = jsonNode.isArray() ? jsonNode.size() : 1;
                int size4 = arrayList.size();
                if (size3 > size4) {
                    fVar.e().a(new C2057a(this.f6946a, aVar, this.c, fVar.f, Integer.valueOf(size4)));
                    return;
                } else {
                    fVar.e().a(new C2057a(this.f6946a, aVar, this.c, fVar.f, Boolean.TRUE));
                    return;
                }
        }
    }

    @Override // z3.AbstractC2156a
    public final void i() {
        switch (this.f) {
            case 0:
                AbstractC2161f.l(this.g);
                break;
            case 1:
                AbstractC2161f.l(this.g);
                break;
            case 2:
                Iterator it = this.g.iterator();
                while (it.hasNext()) {
                    ((u3.i) it.next()).h();
                }
                break;
            default:
                AbstractC2161f.l(this.g);
                break;
        }
    }

    public void m(u3.f fVar, int i, JsonNode jsonNode, JsonNode jsonNode2, A3.a aVar, boolean z10) {
        u3.i iVar = (u3.i) this.g.get(i);
        aVar.getClass();
        A3.a aVar2 = new A3.a(aVar, i);
        fVar.f().getClass();
        KeywordType.f3030S.getClass();
        int size = fVar.d.size();
        fVar.b(i);
        try {
            iVar.b(fVar, jsonNode, jsonNode2, aVar2, z10);
            fVar.d();
            fVar.f().getClass();
            List list = fVar.d;
            list.subList(size, list.size());
        } catch (Throwable th) {
            fVar.d();
            throw th;
        }
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00f3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void n(u3.f r24, com.fasterxml.jackson.databind.JsonNode r25, com.fasterxml.jackson.databind.JsonNode r26, A3.a r27, boolean r28) {
        /*
            Method dump skipped, instructions count: 836
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: z3.C2158c.n(u3.f, com.fasterxml.jackson.databind.JsonNode, com.fasterxml.jackson.databind.JsonNode, A3.a, boolean):void");
    }
}
