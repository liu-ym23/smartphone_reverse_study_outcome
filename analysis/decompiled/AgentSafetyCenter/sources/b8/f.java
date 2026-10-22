package b8;

import com.fasterxml.jackson.databind.JsonNode;
import java.lang.invoke.VarHandle;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class f extends a {

    /* renamed from: d, reason: collision with root package name */
    public final androidx.room.q f1954d;

    /* renamed from: e, reason: collision with root package name */
    public final w7.l f1955e;

    /* renamed from: f, reason: collision with root package name */
    public final Map f1956f;

    public f(x xVar, JsonNode jsonNode, w7.n nVar, w7.l lVar, androidx.room.q qVar) {
        super(xVar, jsonNode, nVar);
        this.f1954d = qVar;
        this.f1955e = lVar;
        if (lVar != null) {
            ((w7.o) qVar.f1601d).f15349g.getClass();
        }
        this.f1956f = null;
    }

    public static void l(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            ((w7.l) it.next()).h();
        }
    }

    public final w7.j j() {
        ((w7.o) this.f1954d.f1601d).f15349g.getClass();
        p5.i iVar = a8.a.f231a;
        w7.j jVar = new w7.j();
        jVar.f15317j = iVar;
        jVar.f15318k = this.f1956f;
        VarHandle.storeStoreFence();
        jVar.f15292c = this.f1909c;
        jVar.f15290a = e();
        jVar.i = e();
        return jVar;
    }

    public final String k() {
        JsonNode jsonNode = this.f1955e.f15331g.get("type");
        if (jsonNode != null) {
            return jsonNode.asText();
        }
        return null;
    }
}
