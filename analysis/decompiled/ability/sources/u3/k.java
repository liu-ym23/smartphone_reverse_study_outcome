package u3;

import aa.AbstractC0317d;
import aa.InterfaceC0315b;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.InputFormat;
import com.networknt.schema.SchemaException;
import com.networknt.schema.SpecificationVersion;
import e1.C1403b;
import java.io.InputStream;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import w3.C2096a;
import w3.C2097b;

/* loaded from: classes3.dex */
public final class k {
    public static final InterfaceC0315b h = AbstractC0317d.b(k.class);

    /* renamed from: a, reason: collision with root package name */
    public final C1403b f6705a;
    public final String b;
    public final C3.g c;
    public final ConcurrentHashMap d = new ConcurrentHashMap();
    public final boolean e;
    public final Z0.a f;
    public final T6.a g;

    public k(String str, Z0.a aVar) {
        if (str == null || str.trim().isEmpty()) {
            throw new IllegalArgumentException("defaultDialectId must not be null or empty");
        }
        this.f6705a = D3.a.f376a;
        this.b = str;
        C3.d dVar = C3.g.c;
        this.c = C3.f.f288a;
        this.e = true;
        this.f = aVar == null ? new C2096a() : aVar;
        this.g = l.f6706a;
    }

    public final i a(G6.c cVar, j jVar, JsonNode jsonNode, i iVar, boolean z10) {
        T6.a aVar = ((k) cVar.d).g;
        JsonNode jsonNode2 = jsonNode.get("$schema");
        C2097b c2097bB = (jsonNode2 == null || !jsonNode2.isTextual()) ? null : b(jsonNode2.textValue());
        if (c2097bB != null && !c2097bB.f6840a.equals(((C2097b) cVar.c).f6840a)) {
            cVar = new G6.c(c2097bB, (k) cVar.d, (ConcurrentMap) cVar.e, (ConcurrentMap) cVar.f, (ConcurrentMap) cVar.g);
        }
        return new i(cVar, jVar, jsonNode, iVar, z10);
    }

    public final C2097b b(String str) {
        SpecificationVersion[] specificationVersionArrValues = SpecificationVersion.values();
        int length = specificationVersionArrValues.length;
        int i = 0;
        while (true) {
            if (i < length) {
                if (specificationVersionArrValues[i].b.equals(str)) {
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
        return this.f.F(str, this);
    }

    public final C2097b c(JsonNode jsonNode) {
        JsonNode jsonNode2 = jsonNode.get("$schema");
        if (jsonNode2 == null || jsonNode2.isNull() || jsonNode2.isTextual()) {
            return b((jsonNode2 == null || jsonNode2.isNull()) ? this.b : jsonNode2.textValue());
        }
        throw new SchemaException("Unknown dialect: " + jsonNode2);
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00b0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final u3.i d(u3.j r13) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 284
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u3.k.d(u3.j):u3.i");
    }

    public final i e(j jVar) {
        i iVarD;
        if (!this.e) {
            return d(jVar);
        }
        i iVar = (i) this.d.get(jVar);
        if (iVar != null) {
            return iVar;
        }
        synchronized (this) {
            try {
                iVarD = (i) this.d.get(jVar);
                if (iVarD == null && (iVarD = d(jVar)) != null) {
                    this.d.put(jVar, iVarD);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return iVarD;
    }

    public final JsonNode f(InputStream inputStream, InputFormat inputFormat) {
        ObjectMapper objectMapper;
        this.f6705a.getClass();
        if (InputFormat.f3011a.equals(inputFormat)) {
            objectMapper = D3.b.f377a;
        } else {
            if (!InputFormat.b.equals(inputFormat)) {
                throw new IllegalArgumentException("Unsupported input format " + inputFormat);
            }
            objectMapper = D3.c.f378a;
        }
        return objectMapper.readTree(inputStream);
    }
}
