package com.fasterxml.jackson.databind.util;

import A3.b;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeCreator;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import java.util.stream.Collector;

/* loaded from: classes3.dex */
public abstract class JacksonCollectors {
    public static Collector<JsonNode, ArrayNode, ArrayNode> toArrayNode() {
        return toArrayNode(JsonNodeFactory.instance);
    }

    public static Collector<JsonNode, ArrayNode, ArrayNode> toArrayNode(JsonNodeCreator jsonNodeCreator) {
        jsonNodeCreator.getClass();
        return Collector.of(new com.fasterxml.jackson.core.util.a(jsonNodeCreator, 1), new b(8), new a(0), new Collector.Characteristics[0]);
    }
}
