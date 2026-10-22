package com.networknt.schema.serialization.node;

import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.databind.node.LongNode;

/* loaded from: classes2.dex */
public class TokenStreamLocationAwareLongNode extends LongNode implements TokenStreamLocationAware {
    private static final long serialVersionUID = 1;
    private final JsonLocation tokenStreamLocation;

    public TokenStreamLocationAwareLongNode(long j10, JsonLocation jsonLocation) {
        super(j10);
        this.tokenStreamLocation = jsonLocation;
    }

    @Override // com.networknt.schema.serialization.node.TokenStreamLocationAware
    public JsonLocation tokenStreamLocation() {
        return this.tokenStreamLocation;
    }
}
