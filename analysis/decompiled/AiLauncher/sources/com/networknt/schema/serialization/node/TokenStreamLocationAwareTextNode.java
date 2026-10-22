package com.networknt.schema.serialization.node;

import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.databind.node.TextNode;

/* loaded from: classes2.dex */
public class TokenStreamLocationAwareTextNode extends TextNode implements TokenStreamLocationAware {
    private static final long serialVersionUID = 1;
    private final JsonLocation tokenStreamLocation;

    public TokenStreamLocationAwareTextNode(String str, JsonLocation jsonLocation) {
        super(str);
        this.tokenStreamLocation = jsonLocation;
    }

    @Override // com.networknt.schema.serialization.node.TokenStreamLocationAware
    public JsonLocation tokenStreamLocation() {
        return this.tokenStreamLocation;
    }
}
