package com.networknt.schema.serialization.node;

import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.databind.node.BinaryNode;

/* loaded from: classes2.dex */
public class TokenStreamLocationAwareBinaryNode extends BinaryNode implements TokenStreamLocationAware {
    private static final long serialVersionUID = 1;
    private final JsonLocation tokenStreamLocation;

    public TokenStreamLocationAwareBinaryNode(byte[] bArr, JsonLocation jsonLocation) {
        super(bArr);
        this.tokenStreamLocation = jsonLocation;
    }

    @Override // com.networknt.schema.serialization.node.TokenStreamLocationAware
    public JsonLocation tokenStreamLocation() {
        return this.tokenStreamLocation;
    }

    public TokenStreamLocationAwareBinaryNode(byte[] bArr, int i10, int i11, JsonLocation jsonLocation) {
        super(bArr, i10, i11);
        this.tokenStreamLocation = jsonLocation;
    }
}
