package z3;

import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.schema.keyword.KeywordType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: classes3.dex */
public final class r extends AbstractC2161f {
    public final u3.i f;
    public final List g;
    public final Boolean h;
    public final u3.i i;

    /* renamed from: j, reason: collision with root package name */
    public final u3.j f6951j;
    public final JsonNode k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(u3.j jVar, JsonNode jsonNode, u3.i iVar, G6.c cVar) {
        u3.i iVarC;
        u3.i iVarC2;
        JsonNode jsonNode2;
        super(KeywordType.f3052x, jsonNode, jVar, iVar, cVar);
        u3.j jVar2 = iVar.i;
        boolean zIsObject = jsonNode.isObject();
        Boolean bool = null;
        if (zIsObject || jsonNode.isBoolean()) {
            iVarC = cVar.c(jVar, jsonNode, iVar);
            this.g = Collections.EMPTY_LIST;
            iVarC2 = null;
        } else {
            this.g = new ArrayList(jsonNode.size());
            Iterator<JsonNode> it = jsonNode.iterator();
            int i = 0;
            while (it.hasNext()) {
                this.g.add(cVar.c(jVar.a(i), it.next(), iVar));
                i++;
            }
            JsonNode jsonNode3 = this.e.g.get("additionalItems");
            if (jsonNode3 != null) {
                if (jsonNode3.isBoolean()) {
                    Boolean boolValueOf = Boolean.valueOf(jsonNode3.asBoolean());
                    jsonNode2 = jsonNode3;
                    iVarC = null;
                    bool = boolValueOf;
                } else {
                    if (jsonNode3.isObject()) {
                        iVarC2 = cVar.c(jVar2.b("additionalItems"), jsonNode3, iVar);
                        jsonNode2 = jsonNode3;
                        iVarC = null;
                        this.h = bool;
                        this.f = iVarC;
                        this.i = iVarC2;
                        this.f6951j = jVar2.b("additionalItems");
                        this.k = jsonNode2;
                    }
                    jsonNode2 = jsonNode3;
                    iVarC = null;
                }
                iVarC2 = iVarC;
                this.h = bool;
                this.f = iVarC;
                this.i = iVarC2;
                this.f6951j = jVar2.b("additionalItems");
                this.k = jsonNode2;
            }
            iVarC = null;
            iVarC2 = null;
        }
        jsonNode2 = iVarC2;
        this.h = bool;
        this.f = iVarC;
        this.i = iVarC2;
        this.f6951j = jVar2.b("additionalItems");
        this.k = jsonNode2;
    }

    public static void n(u3.f fVar, u3.i iVar, JsonNode jsonNode, JsonNode jsonNode2, A3.a aVar, boolean z10, String str) throws Throwable {
        u3.f fVar2;
        boolean zEquals = "additionalItems".equals(str);
        if (zEquals) {
            fVar.d();
            fVar.c(str);
        }
        try {
            fVar.f().getClass();
            int size = fVar.d.size();
            fVar2 = fVar;
            try {
                iVar.b(fVar2, jsonNode, jsonNode2, aVar, z10);
                fVar2.f().getClass();
                List list = fVar2.d;
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

    /* JADX WARN: Removed duplicated region for block: B:36:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    @Override // z3.AbstractC2156a, u3.m
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(u3.f r21, com.fasterxml.jackson.databind.JsonNode r22, com.fasterxml.jackson.databind.JsonNode r23, A3.a r24) {
        /*
            Method dump skipped, instructions count: 251
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: z3.r.a(u3.f, com.fasterxml.jackson.databind.JsonNode, com.fasterxml.jackson.databind.JsonNode, A3.a):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00d1  */
    @Override // u3.m
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(u3.f r17, com.fasterxml.jackson.databind.JsonNode r18, com.fasterxml.jackson.databind.JsonNode r19, A3.a r20, boolean r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 470
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: z3.r.b(u3.f, com.fasterxml.jackson.databind.JsonNode, com.fasterxml.jackson.databind.JsonNode, A3.a, boolean):void");
    }

    @Override // z3.AbstractC2156a
    public final void i() {
        u3.i iVar = this.f;
        if (iVar != null) {
            iVar.h();
        }
        AbstractC2161f.l(this.g);
        u3.i iVar2 = this.i;
        if (iVar2 != null) {
            iVar2.h();
        }
    }

    public final boolean m(u3.f fVar, int i, JsonNode jsonNode, JsonNode jsonNode2, A3.a aVar) {
        aVar.getClass();
        A3.a aVar2 = new A3.a(aVar, i);
        u3.i iVar = this.f;
        if (iVar != null) {
            iVar.a(fVar, jsonNode, jsonNode2, aVar2);
            return false;
        }
        List list = this.g;
        if (list != null) {
            if (i < list.size()) {
                fVar.b(i);
                try {
                    ((u3.i) list.get(i)).a(fVar, jsonNode, jsonNode2, aVar2);
                    return false;
                } finally {
                    fVar.d();
                }
            }
            Boolean bool = this.h;
            u3.i iVar2 = this.i;
            z = (bool != null && bool.booleanValue()) || iVar2 != null;
            if (iVar2 != null) {
                fVar.d();
                fVar.c("additionalItems");
                try {
                    iVar2.a(fVar, jsonNode, jsonNode2, aVar2);
                    return z;
                } finally {
                }
            }
            if (bool != null && !bool.booleanValue()) {
                fVar.d();
                fVar.c("additionalItems");
                try {
                    u3.g gVarJ = j();
                    gVarJ.getClass();
                    gVarJ.d = aVar;
                    gVarJ.f6696a = "additionalItems";
                    gVarJ.i = "additionalItems";
                    gVarJ.b = fVar.f;
                    gVarJ.c = this.f6951j;
                    gVarJ.k = (Locale) fVar.f6698a.f177a;
                    Integer numValueOf = Integer.valueOf(i);
                    if (gVarJ.f == null) {
                        gVarJ.f = new HashMap();
                    }
                    gVarJ.f.put("index", numValueOf);
                    gVarJ.e = new Object[]{Integer.valueOf(i)};
                    fVar.a(gVarJ.a());
                    return z;
                } finally {
                }
            }
        }
        return z;
    }
}
