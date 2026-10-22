package com.networknt.schema.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.schema.ExecutionContext;
import com.networknt.schema.Schema;
import com.networknt.schema.SchemaContext;
import com.networknt.schema.SchemaRegistryConfig;
import com.networknt.schema.SpecificationVersion;

/* loaded from: classes2.dex */
public class JsonNodeTypes {
    private static final String ENUM = "enum";
    private static final String NULLABLE = "nullable";
    private static final String REF = "$ref";
    private static final String TYPE = "type";
    private static final long V6_VALUE = SpecificationVersion.DRAFT_6.getOrder();

    private static long detectVersion(SchemaContext schemaContext) {
        return schemaContext.getDialect().getSpecificationVersion().getOrder();
    }

    public static boolean equalsToSchemaType(JsonNode jsonNode, JsonType jsonType, Schema schema, SchemaContext schemaContext, ExecutionContext executionContext) {
        Schema parentSchema;
        SchemaRegistryConfig schemaRegistryConfig = schemaContext.getSchemaRegistryConfig();
        JsonType valueNodeType = TypeFactory.getValueNodeType(jsonNode, schemaRegistryConfig);
        if (valueNodeType == jsonType) {
            return true;
        }
        JsonType jsonType2 = JsonType.NUMBER;
        if (jsonType == jsonType2 && valueNodeType == JsonType.INTEGER) {
            return true;
        }
        JsonType jsonType3 = JsonType.INTEGER;
        if (jsonType == jsonType3 && valueNodeType == jsonType2 && jsonNode.canConvertToExactIntegral() && V6_VALUE <= detectVersion(schemaContext)) {
            return true;
        }
        if (valueNodeType == JsonType.NULL && schema != null && schemaContext.isNullableKeywordEnabled() && (((parentSchema = schema.getParentSchema()) != null && isNodeNullable(parentSchema.getSchemaNode())) || isNodeNullable(schema.getSchemaNode()))) {
            return true;
        }
        if (!schemaRegistryConfig.isStrict("type", Boolean.TRUE) && isEnumObjectSchema(schema, executionContext)) {
            return true;
        }
        if (schemaRegistryConfig.isTypeLoose()) {
            if (jsonType == JsonType.ARRAY) {
                return true;
            }
            if (valueNodeType == JsonType.STRING) {
                if (jsonType == jsonType3) {
                    return Strings.isInteger(jsonNode.textValue());
                }
                if (jsonType == JsonType.BOOLEAN) {
                    return Strings.isBoolean(jsonNode.textValue());
                }
                if (jsonType == jsonType2) {
                    return Strings.isNumeric(jsonNode.textValue());
                }
            }
        }
        return jsonType == JsonType.ANY;
    }

    private static boolean isEnumObjectSchema(Schema schema, ExecutionContext executionContext) {
        JsonNode jsonNode;
        boolean zEquals;
        JsonNode jsonNode2 = null;
        if (schema != null) {
            if (schema.getSchemaNode() != null) {
                jsonNode2 = schema.getSchemaNode().get("type");
                jsonNode = schema.getSchemaNode().get(ENUM);
            } else {
                jsonNode = null;
            }
            zEquals = REF.equals(executionContext.getEvaluationPath().getParent().getElement(-1));
        } else {
            jsonNode = null;
            zEquals = false;
        }
        return jsonNode2 != null && jsonNode != null && zEquals && TypeFactory.getSchemaNodeType(jsonNode2) == JsonType.OBJECT && jsonNode.isArray();
    }

    public static boolean isNodeNullable(JsonNode jsonNode) {
        JsonNode jsonNode2 = jsonNode.get(NULLABLE);
        return jsonNode2 != null && jsonNode2.asBoolean();
    }

    public static boolean isNumber(JsonNode jsonNode, SchemaRegistryConfig schemaRegistryConfig) {
        if (jsonNode.isNumber()) {
            return true;
        }
        if (schemaRegistryConfig.isTypeLoose() && TypeFactory.getValueNodeType(jsonNode, schemaRegistryConfig) == JsonType.STRING) {
            return Strings.isNumeric(jsonNode.textValue());
        }
        return false;
    }
}
