package z3;

import com.fasterxml.jackson.databind.JsonNode;
import java.util.Collection;
import java.util.Iterator;

/* renamed from: z3.f, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC2161f extends AbstractC2156a {
    public final G6.c d;
    public final u3.i e;

    public AbstractC2161f(t tVar, JsonNode jsonNode, u3.j jVar, u3.i iVar, G6.c cVar) {
        super(tVar, jsonNode, jVar);
        this.d = cVar;
        this.e = iVar;
        if (iVar != null) {
            ((u3.k) cVar.d).g.getClass();
        }
    }

    public static void l(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            ((u3.i) it.next()).h();
        }
    }

    public final u3.g j() {
        ((u3.k) this.d.d).g.getClass();
        u3.g gVar = new u3.g(y3.a.f6893a);
        gVar.c = this.c;
        gVar.f6696a = e();
        gVar.i = e();
        return gVar;
    }

    public final String k() {
        JsonNode jsonNode = this.e.g.get("type");
        if (jsonNode != null) {
            return jsonNode.asText();
        }
        return null;
    }
}
