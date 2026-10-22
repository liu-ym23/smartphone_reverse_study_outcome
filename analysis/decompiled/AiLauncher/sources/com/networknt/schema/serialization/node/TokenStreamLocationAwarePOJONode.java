package com.networknt.schema.serialization.node;

import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.databind.node.POJONode;

/* loaded from: classes2.dex */
public class TokenStreamLocationAwarePOJONode extends POJONode implements TokenStreamLocationAware {
    private static final long serialVersionUID = 1;
    private final JsonLocation tokenStreamLocation;

    public TokenStreamLocationAwarePOJONode(Object obj, JsonLocation jsonLocation) {
        super(obj);
        this.tokenStreamLocation = jsonLocation;
    }

    @Override // com.networknt.schema.serialization.node.TokenStreamLocationAware
    public JsonLocation tokenStreamLocation() {
        return this.tokenStreamLocation;
    }
}
