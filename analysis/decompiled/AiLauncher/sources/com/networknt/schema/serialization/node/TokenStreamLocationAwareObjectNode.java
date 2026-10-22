package com.networknt.schema.serialization.node;

import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.Map;

/* loaded from: classes2.dex */
public class TokenStreamLocationAwareObjectNode extends ObjectNode implements TokenStreamLocationAware {
    private static final long serialVersionUID = 1;
    private final JsonLocation tokenStreamLocation;

    public TokenStreamLocationAwareObjectNode(JsonNodeFactory jsonNodeFactory, Map<String, JsonNode> map, JsonLocation jsonLocation) {
        super(jsonNodeFactory, map);
        this.tokenStreamLocation = jsonLocation;
    }

    @Override // com.networknt.schema.serialization.node.TokenStreamLocationAware
    public JsonLocation tokenStreamLocation() {
        return this.tokenStreamLocation;
    }

    public TokenStreamLocationAwareObjectNode(JsonNodeFactory jsonNodeFactory, JsonLocation jsonLocation) {
        super(jsonNodeFactory);
        this.tokenStreamLocation = jsonLocation;
    }
}
