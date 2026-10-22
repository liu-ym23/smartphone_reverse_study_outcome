package io.modelcontextprotocol.json.schema.jackson;

import Ba.g;
import G6.c;
import Z0.a;
import aa.AbstractC0317d;
import aa.InterfaceC0315b;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.modelcontextprotocol.json.schema.JsonSchemaValidator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import u3.i;
import u3.j;
import u3.k;
import w3.AbstractC2100e;
import w3.C2097b;
import w3.f;

/* loaded from: classes2.dex */
public class DefaultJsonSchemaValidator implements JsonSchemaValidator {
    private static final InterfaceC0315b logger = AbstractC0317d.b(DefaultJsonSchemaValidator.class);
    private final ObjectMapper objectMapper;
    private final ConcurrentHashMap<String, i> schemaCache;
    private final k schemaFactory;

    public DefaultJsonSchemaValidator() {
        this(new ObjectMapper());
    }

    private i createJsonSchema(Map<String, Object> map) throws JsonProcessingException, IllegalArgumentException {
        JsonNode jsonNodeValueToTree = this.objectMapper.valueToTree(map);
        if (jsonNodeValueToTree == null) {
            throw new JsonProcessingException("Failed to convert schema to JsonNode") { // from class: io.modelcontextprotocol.json.schema.jackson.DefaultJsonSchemaValidator.1
            };
        }
        k kVar = this.schemaFactory;
        i iVarA = kVar.a(new c(kVar.c(jsonNodeValueToTree), kVar), j.f, jsonNodeValueToTree, null, false);
        kVar.g.getClass();
        try {
            iVarA.h();
        } catch (Exception unused) {
        }
        return iVarA;
    }

    private i getOrCreateJsonSchema(Map<String, Object> map) throws JsonProcessingException, IllegalArgumentException {
        String strGenerateCacheKey = generateCacheKey(map);
        i iVar = this.schemaCache.get(strGenerateCacheKey);
        if (iVar != null) {
            return iVar;
        }
        i iVarCreateJsonSchema = createJsonSchema(map);
        i iVarPutIfAbsent = this.schemaCache.putIfAbsent(strGenerateCacheKey, iVarCreateJsonSchema);
        return iVarPutIfAbsent != null ? iVarPutIfAbsent : iVarCreateJsonSchema;
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
            throw new IllegalArgumentException("Schema must not be null");
        }
        if (obj == null) {
            throw new IllegalArgumentException("Structured content must not be null");
        }
        try {
            JsonNode tree = obj instanceof String ? this.objectMapper.readTree((String) obj) : this.objectMapper.valueToTree(obj);
            List listI = getOrCreateJsonSchema(map).i(tree);
            return !listI.isEmpty() ? JsonSchemaValidator.ValidationResponse.asInvalid("Validation failed: structuredContent does not match tool outputSchema. Validation errors: ".concat(String.valueOf(listI))) : JsonSchemaValidator.ValidationResponse.asValid(tree.toString());
        } catch (JsonProcessingException e) {
            logger.error("Failed to validate CallToolResult: Error parsing schema: {}", e);
            return JsonSchemaValidator.ValidationResponse.asInvalid("Error parsing tool JSON Schema: " + e.getMessage());
        } catch (Exception e6) {
            logger.error("Failed to validate CallToolResult: Unexpected error: {}", e6);
            return JsonSchemaValidator.ValidationResponse.asInvalid("Unexpected validation error: " + e6.getMessage());
        }
    }

    public DefaultJsonSchemaValidator(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
        HashMap map = f.f6844a;
        C2097b c2097b = AbstractC2100e.f6843a;
        InterfaceC0315b interfaceC0315b = k.h;
        String str = c2097b.f6840a;
        a aVar = new a();
        aVar.f1582a = new g(c2097b, 9);
        this.schemaFactory = new k(str, aVar);
        this.schemaCache = new ConcurrentHashMap<>();
    }
}
