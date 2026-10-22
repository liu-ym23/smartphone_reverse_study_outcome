package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class ThreadGroupDeserializer extends StdNodeBasedDeserializer<ThreadGroup> {
    private static final long serialVersionUID = 1;

    public ThreadGroupDeserializer() {
        super(ThreadGroup.class);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdNodeBasedDeserializer
    public ThreadGroup convert(JsonNode jsonNode, DeserializationContext deserializationContext) {
        String strAsText = jsonNode.path("name").asText();
        if (strAsText == null) {
            strAsText = "";
        }
        return new ThreadGroup(strAsText);
    }
}
