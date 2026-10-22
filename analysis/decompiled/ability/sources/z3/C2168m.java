package z3;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.networknt.schema.SchemaException;
import com.networknt.schema.keyword.KeywordType;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

/* renamed from: z3.m, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2168m extends AbstractC2161f {
    public final String f;
    public final Map g;
    public final String h;

    public C2168m(u3.j jVar, JsonNode jsonNode, u3.i iVar, G6.c cVar) {
        super(KeywordType.n, jsonNode, jVar, iVar, cVar);
        ObjectNode objectNode = jsonNode.isObject() ? (ObjectNode) jsonNode : null;
        if (objectNode == null) {
            this.f = "";
            this.g = Collections.EMPTY_MAP;
            this.h = null;
            return;
        }
        JsonNode jsonNode2 = objectNode.get("propertyName");
        this.f = jsonNode2 != null ? jsonNode2.asText() : "";
        JsonNode jsonNode3 = objectNode.get("mapping");
        ObjectNode objectNode2 = (jsonNode3 == null || !jsonNode3.isObject()) ? null : (ObjectNode) jsonNode3;
        if (objectNode2 != null) {
            this.g = new HashMap();
            Iterator<Map.Entry<String, JsonNode>> itFields = objectNode2.fields();
            while (itFields.hasNext()) {
                Map.Entry<String, JsonNode> next = itFields.next();
                this.g.put(next.getKey(), next.getValue().asText());
            }
        } else {
            this.g = Collections.EMPTY_MAP;
        }
        JsonNode jsonNode4 = objectNode.get("defaultMapping");
        if (jsonNode4 != null) {
            this.h = jsonNode4.asText();
        } else {
            this.h = null;
        }
    }

    @Override // z3.AbstractC2156a, u3.m
    public final void a(u3.f fVar, JsonNode jsonNode, JsonNode jsonNode2, A3.a aVar) {
        C2167l c2167l;
        C2167l c2167l2 = (C2167l) fVar.e.get(aVar);
        G6.c cVar = this.d;
        u3.j jVar = this.c;
        String str = this.f;
        if (c2167l2 == null) {
            c2167l = new C2167l();
            c2167l.c = null;
            c2167l.d = false;
            c2167l.f6949a = str;
            fVar.e.put(aVar, c2167l);
        } else {
            if (((u3.k) cVar.d).g.c("discriminator", Boolean.FALSE)) {
                throw new SchemaException("Schema at " + jVar + " has a discriminator keyword for which another discriminator keyword has already been set for at " + aVar);
            }
            if (!"".equals(str) && !c2167l2.f6949a.equals(str)) {
                throw new SchemaException("Schema at " + jVar + " is redefining the discriminator property that has already been set for at " + aVar);
            }
            c2167l = c2167l2;
        }
        JsonNode jsonNode3 = jsonNode.get(c2167l.f6949a);
        if (jsonNode3 == null || !jsonNode3.isTextual()) {
            String str2 = this.h;
            if (str2 != null) {
                c2167l.c = str2;
                c2167l.d = true;
                return;
            } else {
                if (((u3.k) cVar.d).g.c("discriminator", Boolean.FALSE)) {
                    u3.g gVarJ = j();
                    gVarJ.getClass();
                    gVarJ.d = aVar;
                    gVarJ.b = fVar.f;
                    gVarJ.k = (Locale) fVar.f6698a.f177a;
                    gVarJ.i = "discriminator.missing_discriminating_value";
                    gVarJ.e = new Object[]{str};
                    fVar.a(gVarJ.a());
                    return;
                }
                return;
            }
        }
        String strAsText = jsonNode3.asText();
        c2167l.b = strAsText;
        String str3 = (String) this.g.get(strAsText);
        if (c2167l2 != null && str3 != null && c2167l2.d && !c2167l2.c.equals(str3)) {
            StringBuilder sb = new StringBuilder("Schema at ");
            sb.append(jVar);
            sb.append(" is mapping that has already been set for ");
            sb.append(aVar);
            sb.append(" from ");
            throw new SchemaException(androidx.constraintlayout.core.dsl.a.j(sb, c2167l2.c, " to ", str3));
        }
        if (str3 != null) {
            c2167l.c = str3;
            c2167l.d = true;
        } else {
            if (c2167l.d) {
                return;
            }
            c2167l.c = strAsText;
            c2167l.d = false;
        }
    }
}
