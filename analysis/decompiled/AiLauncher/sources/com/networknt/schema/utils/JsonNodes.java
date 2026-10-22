package com.networknt.schema.utils;

import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.networknt.schema.path.NodePath;
import com.networknt.schema.serialization.node.JsonNodeFactoryFactory;
import com.networknt.schema.serialization.node.TokenStreamLocationAware;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes2.dex */
public class JsonNodes {
    public static <T extends JsonNode> T get(JsonNode jsonNode, NodePath nodePath) {
        int nameCount = nodePath.getNameCount();
        for (int i10 = 0; i10 < nameCount; i10++) {
            jsonNode = (T) get(jsonNode, nodePath.getElement(i10));
            if (jsonNode == null) {
                return null;
            }
        }
        return (T) jsonNode;
    }

    public static JsonNode readTree(ObjectMapper objectMapper, String str, JsonNodeFactoryFactory jsonNodeFactoryFactory) {
        try {
            JsonParser jsonParserCreateParser = objectMapper.getFactory().createParser(str);
            try {
                JsonNodeFactory jsonNodeFactory = jsonNodeFactoryFactory.getJsonNodeFactory(jsonParserCreateParser);
                JsonNode jsonNodeMissingNode = (JsonNode) objectMapper.reader(jsonNodeFactory).readTree(jsonParserCreateParser);
                if (jsonNodeMissingNode == null) {
                    jsonNodeMissingNode = jsonNodeFactory.missingNode();
                }
                if (jsonParserCreateParser != null) {
                    jsonParserCreateParser.close();
                }
                return jsonNodeMissingNode;
            } finally {
            }
        } catch (IOException e10) {
            throw new IllegalArgumentException("Invalid input", e10);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static JsonLocation tokenStreamLocationOf(JsonNode jsonNode) {
        if (jsonNode instanceof TokenStreamLocationAware) {
            return ((TokenStreamLocationAware) jsonNode).tokenStreamLocation();
        }
        throw new IllegalArgumentException("JsonNode does not contain the location information.");
    }

    public static <T extends JsonNode> T get(JsonNode jsonNode, Object obj) {
        if ((obj instanceof Number) && jsonNode.isArray()) {
            return (T) jsonNode.get(((Number) obj).intValue());
        }
        return (T) jsonNode.get(obj.toString());
    }

    public static JsonNode readTree(ObjectMapper objectMapper, InputStream inputStream, JsonNodeFactoryFactory jsonNodeFactoryFactory) {
        try {
            JsonParser jsonParserCreateParser = objectMapper.getFactory().createParser(inputStream);
            try {
                JsonNodeFactory jsonNodeFactory = jsonNodeFactoryFactory.getJsonNodeFactory(jsonParserCreateParser);
                JsonNode jsonNodeMissingNode = (JsonNode) objectMapper.reader(jsonNodeFactory).readTree(jsonParserCreateParser);
                if (jsonNodeMissingNode == null) {
                    jsonNodeMissingNode = jsonNodeFactory.missingNode();
                }
                if (jsonParserCreateParser != null) {
                    jsonParserCreateParser.close();
                }
                return jsonNodeMissingNode;
            } finally {
            }
        } catch (IOException e10) {
            throw new IllegalArgumentException("Invalid input", e10);
        }
    }
}
