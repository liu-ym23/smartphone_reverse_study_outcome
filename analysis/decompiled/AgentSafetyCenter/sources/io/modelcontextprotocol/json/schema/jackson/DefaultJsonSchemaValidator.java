package io.modelcontextprotocol.json.schema.jackson;

import androidx.room.q;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import e8.e;
import io.modelcontextprotocol.json.schema.JsonSchemaValidator;
import java.lang.invoke.VarHandle;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import rd.b;
import rd.d;
import stepos.support.v7.app.f;
import w7.l;
import w7.n;
import w7.o;
import w7.p;
import y7.a;
import y7.c;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class DefaultJsonSchemaValidator implements JsonSchemaValidator {
    private static final b logger = d.b(DefaultJsonSchemaValidator.class);
    private final ObjectMapper objectMapper;
    private final ConcurrentHashMap<String, l> schemaCache;
    private final o schemaFactory;

    public DefaultJsonSchemaValidator(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
        HashMap map = c.f15936a;
        a aVar = y7.b.f15935a;
        b bVar = o.f15342h;
        String str = aVar.f15929a;
        f fVar = new f(16);
        a8.c cVar = new a8.c(7);
        cVar.f234b = aVar;
        VarHandle.storeStoreFence();
        fVar.f12315f = cVar;
        o oVar = new o();
        oVar.f15346d = new ConcurrentHashMap();
        if (str == null || str.trim().isEmpty()) {
            g5.f.s("defaultDialectId must not be null or empty");
            throw null;
        }
        oVar.f15343a = f8.a.f4037a;
        oVar.f15344b = str;
        e8.c cVar2 = e8.f.f3608c;
        oVar.f15345c = e.f3607a;
        oVar.f15347e = true;
        oVar.f15348f = fVar;
        oVar.f15349g = p.f15350a;
        VarHandle.storeStoreFence();
        this.schemaFactory = oVar;
        this.schemaCache = new ConcurrentHashMap<>();
    }

    private l createJsonSchema(Map<String, Object> map) throws JsonProcessingException {
        JsonNode jsonNodeValueToTree = this.objectMapper.valueToTree(map);
        if (jsonNodeValueToTree == null) {
            throw new JsonProcessingException("Failed to convert schema to JsonNode") { // from class: io.modelcontextprotocol.json.schema.jackson.DefaultJsonSchemaValidator.1
            };
        }
        o oVar = this.schemaFactory;
        l lVarA = oVar.a(new q(oVar.c(jsonNodeValueToTree), oVar), n.f15338f, jsonNodeValueToTree, null, false);
        oVar.f15349g.getClass();
        try {
            lVarA.h();
        } catch (Exception unused) {
        }
        return lVarA;
    }

    private l getOrCreateJsonSchema(Map<String, Object> map) throws JsonProcessingException {
        String strGenerateCacheKey = generateCacheKey(map);
        l lVar = this.schemaCache.get(strGenerateCacheKey);
        if (lVar != null) {
            return lVar;
        }
        l lVarCreateJsonSchema = createJsonSchema(map);
        l lVarPutIfAbsent = this.schemaCache.putIfAbsent(strGenerateCacheKey, lVarCreateJsonSchema);
        return lVarPutIfAbsent != null ? lVarPutIfAbsent : lVarCreateJsonSchema;
    }

    public void clearCache() {
        this.schemaCache.clear();
    }

    public String generateCacheKey(Map<String, Object> map) {
        return map.containsKey("$id") ? String.valueOf(map.get("$id")) : String.valueOf(map.hashCode());
    }

    public int getCacheSize() {
        return this.schemaCache.size();
    }

    @Override // io.modelcontextprotocol.json.schema.JsonSchemaValidator
    public JsonSchemaValidator.ValidationResponse validate(Map<String, Object> map, Object obj) {
        if (map == null) {
            g5.f.s("Schema must not be null");
            return null;
        }
        if (obj == null) {
            g5.f.s("Structured content must not be null");
            return null;
        }
        try {
            boolean z10 = obj instanceof String;
            ObjectMapper objectMapper = this.objectMapper;
            JsonNode tree = z10 ? objectMapper.readTree((String) obj) : objectMapper.valueToTree(obj);
            List listI = getOrCreateJsonSchema(map).i(tree);
            return !listI.isEmpty() ? JsonSchemaValidator.ValidationResponse.asInvalid("Validation failed: structuredContent does not match tool outputSchema. Validation errors: ".concat(String.valueOf(listI))) : JsonSchemaValidator.ValidationResponse.asValid(tree.toString());
        } catch (JsonProcessingException e10) {
            logger.error("Failed to validate CallToolResult: Error parsing schema: {}", e10);
            return JsonSchemaValidator.ValidationResponse.asInvalid("Error parsing tool JSON Schema: " + e10.getMessage());
        } catch (Exception e11) {
            logger.error("Failed to validate CallToolResult: Unexpected error: {}", e11);
            return JsonSchemaValidator.ValidationResponse.asInvalid("Unexpected validation error: " + e11.getMessage());
        }
    }

    public DefaultJsonSchemaValidator() {
        this(new ObjectMapper());
    }
}
