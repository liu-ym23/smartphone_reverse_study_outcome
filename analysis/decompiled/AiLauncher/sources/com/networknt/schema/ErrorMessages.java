package com.networknt.schema;

import com.fasterxml.jackson.databind.JsonNode;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Consumer;

/* loaded from: classes2.dex */
public class ErrorMessages {
    public static Map<String, String> getErrorMessage(Schema schema, String str, String str2) {
        JsonNode jsonNode;
        JsonNode messageNode = getMessageNode(str, schema.schemaNode, schema, str2);
        if (messageNode != null && (jsonNode = messageNode.get(str2)) != null) {
            if (jsonNode.isTextual()) {
                return Collections.singletonMap("", jsonNode.asText());
            }
            if (jsonNode.isObject()) {
                final LinkedHashMap linkedHashMap = new LinkedHashMap();
                jsonNode.fields().forEachRemaining(new Consumer() { // from class: com.networknt.schema.e
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        Map.Entry entry = (Map.Entry) obj;
                        linkedHashMap.put((String) entry.getKey(), ((JsonNode) entry.getValue()).textValue());
                    }
                });
                if (!linkedHashMap.isEmpty()) {
                    return linkedHashMap;
                }
            }
        }
        return Collections.EMPTY_MAP;
    }

    public static JsonNode getMessageNode(String str, JsonNode jsonNode, Schema schema, String str2) {
        if (jsonNode.get(str) != null && jsonNode.get(str).get(str2) != null) {
            return jsonNode.get(str);
        }
        JsonNode jsonNode2 = jsonNode.get(str);
        return (jsonNode2 == null && schema != null && (jsonNode2 = schema.schemaNode.get(str)) == null) ? getMessageNode(str, schema.schemaNode, schema.getParentSchema(), str2) : jsonNode2;
    }
}
