package w7;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import java.io.InputStream;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class o {

    /* renamed from: h, reason: collision with root package name */
    public static final rd.b f15342h = rd.d.b(o.class);

    /* renamed from: a, reason: collision with root package name */
    public f8.b f15343a;

    /* renamed from: b, reason: collision with root package name */
    public String f15344b;

    /* renamed from: c, reason: collision with root package name */
    public e8.f f15345c;

    /* renamed from: d, reason: collision with root package name */
    public ConcurrentHashMap f15346d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f15347e;

    /* renamed from: f, reason: collision with root package name */
    public stepos.support.v7.app.f f15348f;

    /* renamed from: g, reason: collision with root package name */
    public u9.d f15349g;

    public final l a(androidx.room.q qVar, n nVar, JsonNode jsonNode, l lVar, boolean z10) {
        u9.d dVar = ((o) qVar.f1601d).f15349g;
        JsonNode jsonNode2 = jsonNode.get("$schema");
        y7.a aVarB = (jsonNode2 == null || !jsonNode2.isTextual()) ? null : b(jsonNode2.textValue());
        if (aVarB != null && !aVarB.f15929a.equals(((y7.a) qVar.f1600c).f15929a)) {
            qVar = new androidx.room.q(aVarB, (o) qVar.f1601d, (ConcurrentMap) qVar.f1602e, (ConcurrentMap) qVar.f1603f, (ConcurrentMap) qVar.f1604g);
        }
        return new l(qVar, nVar, jsonNode, lVar, z10);
    }

    public final y7.a b(String str) {
        q[] qVarArrValues = q.values();
        int length = qVarArrValues.length;
        int i = 0;
        while (true) {
            if (i < length) {
                if (qVarArrValues[i].f15357f.equals(str)) {
                    break;
                }
                i++;
            } else if (str.contains("://json-schema.org/draft")) {
                if (str.contains("/draft-07/")) {
                    str = "http://json-schema.org/draft-07/schema#";
                } else if (str.contains("/draft/2019-09/")) {
                    str = "https://json-schema.org/draft/2019-09/schema";
                } else if (str.contains("/draft/2020-12/")) {
                    str = "https://json-schema.org/draft/2020-12/schema";
                } else if (str.contains("/draft-04/")) {
                    str = "http://json-schema.org/draft-04/schema#";
                } else if (str.contains("/draft-06/")) {
                    str = "http://json-schema.org/draft-06/schema#";
                }
            }
        }
        y7.a aVar = (y7.a) ((a8.c) this.f15348f.f12315f).apply(str);
        if (aVar != null) {
            return aVar;
        }
        b bVar = new b();
        bVar.f15296g = "Unknown dialect ''{0}''. Only dialects that are explicitly configured can be used.";
        bVar.f15294e = new Object[]{str};
        throw new h(bVar.a());
    }

    public final y7.a c(JsonNode jsonNode) {
        JsonNode jsonNode2 = jsonNode.get("$schema");
        if (jsonNode2 == null || jsonNode2.isNull() || jsonNode2.isTextual()) {
            return b((jsonNode2 == null || jsonNode2.isNull()) ? this.f15344b : jsonNode2.textValue());
        }
        throw new m("Unknown dialect: " + jsonNode2);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x012b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final w7.l d(w7.n r13) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 407
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: w7.o.d(w7.n):w7.l");
    }

    public final l e(n nVar) {
        l lVarD;
        if (!this.f15347e) {
            return d(nVar);
        }
        l lVar = (l) this.f15346d.get(nVar);
        if (lVar != null) {
            return lVar;
        }
        synchronized (this) {
            try {
                lVarD = (l) this.f15346d.get(nVar);
                if (lVarD == null && (lVarD = d(nVar)) != null) {
                    this.f15346d.put(nVar, lVarD);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return lVarD;
    }

    public final JsonNode f(InputStream inputStream, int i) {
        ObjectMapper objectMapper;
        this.f15343a.getClass();
        if (s.f.a(1, i)) {
            objectMapper = f8.c.f4042a;
        } else {
            if (!s.f.a(2, i)) {
                g5.f.s("Unsupported input format ".concat(i != 1 ? i != 2 ? "null" : YAMLFactory.FORMAT_NAME_YAML : JsonFactory.FORMAT_NAME_JSON));
                return null;
            }
            objectMapper = f8.d.f4043a;
        }
        return objectMapper.readTree(inputStream);
    }
}
