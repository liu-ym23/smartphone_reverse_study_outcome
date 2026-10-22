package com.networknt.schema.serialization.node;

import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.databind.node.DecimalNode;
import java.math.BigDecimal;

/* loaded from: classes2.dex */
public class TokenStreamLocationAwareDecimalNode extends DecimalNode implements TokenStreamLocationAware {
    private static final long serialVersionUID = 1;
    private final JsonLocation tokenStreamLocation;

    public TokenStreamLocationAwareDecimalNode(BigDecimal bigDecimal, JsonLocation jsonLocation) {
        super(bigDecimal);
        this.tokenStreamLocation = jsonLocation;
    }

    @Override // com.networknt.schema.serialization.node.TokenStreamLocationAware
    public JsonLocation tokenStreamLocation() {
        return this.tokenStreamLocation;
    }
}
