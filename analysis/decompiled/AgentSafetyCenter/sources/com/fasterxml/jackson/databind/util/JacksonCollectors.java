package com.fasterxml.jackson.databind.util;

import b8.q0;
import c8.b;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeCreator;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import java.lang.invoke.VarHandle;
import java.util.stream.Collector;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class JacksonCollectors {
    public static Collector<JsonNode, ArrayNode, ArrayNode> toArrayNode(JsonNodeCreator jsonNodeCreator) {
        jsonNodeCreator.getClass();
        q0 q0Var = new q0(2);
        q0Var.f2013f = jsonNodeCreator;
        VarHandle.storeStoreFence();
        return Collector.of(q0Var, new b(8), new a(0), new Collector.Characteristics[0]);
    }

    public static Collector<JsonNode, ArrayNode, ArrayNode> toArrayNode() {
        return toArrayNode(JsonNodeFactory.instance);
    }
}
