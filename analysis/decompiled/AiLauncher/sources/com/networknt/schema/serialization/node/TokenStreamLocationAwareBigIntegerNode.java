package com.networknt.schema.serialization.node;

import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.databind.node.BigIntegerNode;
import java.math.BigInteger;

/* loaded from: classes2.dex */
public class TokenStreamLocationAwareBigIntegerNode extends BigIntegerNode implements TokenStreamLocationAware {
    private static final long serialVersionUID = 1;
    private final JsonLocation tokenStreamLocation;

    public TokenStreamLocationAwareBigIntegerNode(BigInteger bigInteger, JsonLocation jsonLocation) {
        super(bigInteger);
        this.tokenStreamLocation = jsonLocation;
    }

    @Override // com.networknt.schema.serialization.node.TokenStreamLocationAware
    public JsonLocation tokenStreamLocation() {
        return this.tokenStreamLocation;
    }
}
