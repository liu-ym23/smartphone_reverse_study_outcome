package io.modelcontextprotocol.json.schema.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.Error;
import com.networknt.schema.Schema;
import com.networknt.schema.SchemaRegistry;
import com.networknt.schema.dialect.Dialects;
import io.modelcontextprotocol.json.schema.JsonSchemaValidator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import vc.c;
import vc.e;

/* loaded from: classes4.dex */
public class DefaultJsonSchemaValidator implements JsonSchemaValidator {
    private static final c logger = e.l(DefaultJsonSchemaValidator.class);
    private final ObjectMapper objectMapper;
    private final ConcurrentHashMap<String, Schema> schemaCache;
    private final SchemaRegistry schemaFactory;

    public DefaultJsonSchemaValidator() {
        this(new ObjectMapper());
    }

    private Schema createJsonSchema(Map<String, Object> map) throws JsonProcessingException, IllegalArgumentException {
        JsonNode jsonNodeValueToTree = this.objectMapper.valueToTree(map);
        if (jsonNodeValueToTree != null) {
            return this.schemaFactory.getSchema(jsonNodeValueToTree);
        }
        throw new JsonProcessingException("Failed to convert schema to JsonNode") { // from class: io.modelcontextprotocol.json.schema.jackson.DefaultJsonSchemaValidator.1
        };
    }

    private Schema getOrCreateJsonSchema(Map<String, Object> map) throws JsonProcessingException, IllegalArgumentException {
        String strGenerateCacheKey = generateCacheKey(map);
        Schema schema = this.schemaCache.get(strGenerateCacheKey);
        if (schema != null) {
            return schema;
        }
        Schema schemaCreateJsonSchema = createJsonSchema(map);
        Schema schemaPutIfAbsent = this.schemaCache.putIfAbsent(strGenerateCacheKey, schemaCreateJsonSchema);
        return schemaPutIfAbsent != null ? schemaPutIfAbsent : schemaCreateJsonSchema;
    }

    public void clearCache() {
        this.schemaCache.clear();
    }

    public String generateCacheKey(Map<String, Object> map) {
        if (!map.containsKey("$id")) {
            return String.valueOf(map.hashCode());
        }
        return String.valueOf(map.get("$id"));
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
            List<Error> listValidate = getOrCreateJsonSchema(map).validate(tree);
            if (listValidate.isEmpty()) {
                return JsonSchemaValidator.ValidationResponse.asValid(tree.toString());
            }
            return JsonSchemaValidator.ValidationResponse.asInvalid("Validation failed: structuredContent does not match tool outputSchema. Validation errors: " + String.valueOf(listValidate));
        } catch (JsonProcessingException e10) {
            logger.error("Failed to validate CallToolResult: Error parsing schema: {}", e10);
            return JsonSchemaValidator.ValidationResponse.asInvalid("Error parsing tool JSON Schema: " + e10.getMessage());
        } catch (Exception e11) {
            logger.error("Failed to validate CallToolResult: Unexpected error: {}", e11);
            return JsonSchemaValidator.ValidationResponse.asInvalid("Unexpected validation error: " + e11.getMessage());
        }
    }

    public DefaultJsonSchemaValidator(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
        this.schemaFactory = SchemaRegistry.withDialect(Dialects.getDraft202012());
        this.schemaCache = new ConcurrentHashMap<>();
    }
}
