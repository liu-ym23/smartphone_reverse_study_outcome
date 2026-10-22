package com.networknt.schema.utils;

import com.autonavi.aps.amapapi.config.Const;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.networknt.schema.SchemaRegistryConfig;

/* loaded from: classes2.dex */
public class TypeFactory {

    /* renamed from: com.networknt.schema.utils.TypeFactory$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$fasterxml$jackson$databind$node$JsonNodeType;

        static {
            int[] iArr = new int[JsonNodeType.values().length];
            $SwitchMap$com$fasterxml$jackson$databind$node$JsonNodeType = iArr;
            try {
                iArr[JsonNodeType.OBJECT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$databind$node$JsonNodeType[JsonNodeType.ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$databind$node$JsonNodeType[JsonNodeType.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$databind$node$JsonNodeType[JsonNodeType.BINARY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$databind$node$JsonNodeType[JsonNodeType.NUMBER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$databind$node$JsonNodeType[JsonNodeType.BOOLEAN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$databind$node$JsonNodeType[JsonNodeType.NULL.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static JsonType getSchemaNodeType(JsonNode jsonNode) {
        if (jsonNode.isTextual()) {
            String strTextValue = jsonNode.textValue();
            if ("object".equals(strTextValue)) {
                return JsonType.OBJECT;
            }
            if ("array".equals(strTextValue)) {
                return JsonType.ARRAY;
            }
            if ("string".equals(strTextValue)) {
                return JsonType.STRING;
            }
            if (Const.JSON_KEY_NUMBER.equals(strTextValue)) {
                return JsonType.NUMBER;
            }
            if ("integer".equals(strTextValue)) {
                return JsonType.INTEGER;
            }
            if ("boolean".equals(strTextValue)) {
                return JsonType.BOOLEAN;
            }
            if ("any".equals(strTextValue)) {
                return JsonType.ANY;
            }
            if ("null".equals(strTextValue)) {
                return JsonType.NULL;
            }
        }
        return jsonNode.isArray() ? JsonType.UNION : JsonType.UNKNOWN;
    }

    public static JsonType getValueNodeType(JsonNode jsonNode, SchemaRegistryConfig schemaRegistryConfig) {
        if (jsonNode == null) {
            return JsonType.UNKNOWN;
        }
        switch (AnonymousClass1.$SwitchMap$com$fasterxml$jackson$databind$node$JsonNodeType[jsonNode.getNodeType().ordinal()]) {
            case 5:
                if (!jsonNode.isIntegralNumber()) {
                    if (schemaRegistryConfig == null || !schemaRegistryConfig.isLosslessNarrowing() || !jsonNode.canConvertToExactIntegral()) {
                        break;
                    } else {
                        break;
                    }
                } else {
                    break;
                }
                break;
        }
        return JsonType.UNKNOWN;
    }
}
