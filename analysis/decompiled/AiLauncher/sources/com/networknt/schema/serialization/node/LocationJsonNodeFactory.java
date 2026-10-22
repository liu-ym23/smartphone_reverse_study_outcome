package com.networknt.schema.serialization.node;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.BinaryNode;
import com.fasterxml.jackson.databind.node.BooleanNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.NumericNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
import com.fasterxml.jackson.databind.node.ValueNode;
import com.fasterxml.jackson.databind.util.RawValue;
import java.math.BigDecimal;
import java.math.BigInteger;

/* loaded from: classes2.dex */
public class LocationJsonNodeFactory extends JsonNodeFactory {
    private static final long serialVersionUID = 1;
    private final JsonParser jsonParser;

    public LocationJsonNodeFactory(JsonParser jsonParser) {
        this.jsonParser = jsonParser;
    }

    @Override // com.fasterxml.jackson.databind.node.JsonNodeFactory, com.fasterxml.jackson.databind.node.JsonNodeCreator
    public ArrayNode arrayNode() {
        return new TokenStreamLocationAwareArrayNode(this, this.jsonParser.currentTokenLocation());
    }

    @Override // com.fasterxml.jackson.databind.node.JsonNodeFactory
    public JsonNode missingNode() {
        return super.missingNode();
    }

    @Override // com.fasterxml.jackson.databind.node.JsonNodeFactory, com.fasterxml.jackson.databind.node.JsonNodeCreator
    public ObjectNode objectNode() {
        return new TokenStreamLocationAwareObjectNode(this, this.jsonParser.currentTokenLocation());
    }

    @Override // com.fasterxml.jackson.databind.node.JsonNodeFactory, com.fasterxml.jackson.databind.node.JsonNodeCreator
    public ValueNode pojoNode(Object obj) {
        return new TokenStreamLocationAwarePOJONode(obj, this.jsonParser.currentTokenLocation());
    }

    @Override // com.fasterxml.jackson.databind.node.JsonNodeFactory, com.fasterxml.jackson.databind.node.JsonNodeCreator
    public ValueNode rawValueNode(RawValue rawValue) {
        return new TokenStreamLocationAwarePOJONode(rawValue, this.jsonParser.currentTokenLocation());
    }

    @Override // com.fasterxml.jackson.databind.node.JsonNodeFactory, com.fasterxml.jackson.databind.node.JsonNodeCreator
    public ArrayNode arrayNode(int i10) {
        return new TokenStreamLocationAwareArrayNode(this, i10, this.jsonParser.currentTokenLocation());
    }

    @Override // com.fasterxml.jackson.databind.node.JsonNodeFactory, com.fasterxml.jackson.databind.node.JsonNodeCreator
    public BooleanNode booleanNode(boolean z10) {
        return new TokenStreamLocationAwareBooleanNode(z10, this.jsonParser.currentTokenLocation());
    }

    @Override // com.fasterxml.jackson.databind.node.JsonNodeFactory, com.fasterxml.jackson.databind.node.JsonNodeCreator
    public NullNode nullNode() {
        return new TokenStreamLocationAwareNullNode(this.jsonParser.currentTokenLocation());
    }

    @Override // com.fasterxml.jackson.databind.node.JsonNodeFactory, com.fasterxml.jackson.databind.node.JsonNodeCreator
    public TextNode textNode(String str) {
        return new TokenStreamLocationAwareTextNode(str, this.jsonParser.currentTokenLocation());
    }

    @Override // com.fasterxml.jackson.databind.node.JsonNodeFactory, com.fasterxml.jackson.databind.node.JsonNodeCreator
    public BinaryNode binaryNode(byte[] bArr) {
        return new TokenStreamLocationAwareBinaryNode(bArr, this.jsonParser.currentTokenLocation());
    }

    @Override // com.fasterxml.jackson.databind.node.JsonNodeFactory, com.fasterxml.jackson.databind.node.JsonNodeCreator
    public BinaryNode binaryNode(byte[] bArr, int i10, int i11) {
        return new TokenStreamLocationAwareBinaryNode(bArr, i10, i11, this.jsonParser.currentTokenLocation());
    }

    @Override // com.fasterxml.jackson.databind.node.JsonNodeFactory, com.fasterxml.jackson.databind.node.JsonNodeCreator
    public NumericNode numberNode(byte b10) {
        return new TokenStreamLocationAwareIntNode(b10, this.jsonParser.currentTokenLocation());
    }

    @Override // com.fasterxml.jackson.databind.node.JsonNodeFactory, com.fasterxml.jackson.databind.node.JsonNodeCreator
    public ValueNode numberNode(Byte b10) {
        return b10 == null ? nullNode() : numberNode(b10.intValue());
    }

    @Override // com.fasterxml.jackson.databind.node.JsonNodeFactory, com.fasterxml.jackson.databind.node.JsonNodeCreator
    public NumericNode numberNode(short s10) {
        return new TokenStreamLocationAwareShortNode(s10, this.jsonParser.currentTokenLocation());
    }

    @Override // com.fasterxml.jackson.databind.node.JsonNodeFactory, com.fasterxml.jackson.databind.node.JsonNodeCreator
    public ValueNode numberNode(Short sh) {
        return sh == null ? nullNode() : numberNode(sh.shortValue());
    }

    @Override // com.fasterxml.jackson.databind.node.JsonNodeFactory, com.fasterxml.jackson.databind.node.JsonNodeCreator
    public NumericNode numberNode(int i10) {
        return new TokenStreamLocationAwareIntNode(i10, this.jsonParser.currentTokenLocation());
    }

    @Override // com.fasterxml.jackson.databind.node.JsonNodeFactory, com.fasterxml.jackson.databind.node.JsonNodeCreator
    public ValueNode numberNode(Integer num) {
        return num == null ? nullNode() : numberNode(num.intValue());
    }

    @Override // com.fasterxml.jackson.databind.node.JsonNodeFactory, com.fasterxml.jackson.databind.node.JsonNodeCreator
    public NumericNode numberNode(long j10) {
        return new TokenStreamLocationAwareLongNode(j10, this.jsonParser.currentTokenLocation());
    }

    @Override // com.fasterxml.jackson.databind.node.JsonNodeFactory, com.fasterxml.jackson.databind.node.JsonNodeCreator
    public ValueNode numberNode(Long l10) {
        return l10 == null ? nullNode() : numberNode(l10.longValue());
    }

    @Override // com.fasterxml.jackson.databind.node.JsonNodeFactory, com.fasterxml.jackson.databind.node.JsonNodeCreator
    public ValueNode numberNode(BigInteger bigInteger) {
        return bigInteger == null ? nullNode() : new TokenStreamLocationAwareBigIntegerNode(bigInteger, this.jsonParser.currentTokenLocation());
    }

    @Override // com.fasterxml.jackson.databind.node.JsonNodeFactory, com.fasterxml.jackson.databind.node.JsonNodeCreator
    public NumericNode numberNode(float f10) {
        return new TokenStreamLocationAwareFloatNode(f10, this.jsonParser.currentTokenLocation());
    }

    @Override // com.fasterxml.jackson.databind.node.JsonNodeFactory, com.fasterxml.jackson.databind.node.JsonNodeCreator
    public ValueNode numberNode(Float f10) {
        return f10 == null ? nullNode() : numberNode(f10.floatValue());
    }

    @Override // com.fasterxml.jackson.databind.node.JsonNodeFactory, com.fasterxml.jackson.databind.node.JsonNodeCreator
    public NumericNode numberNode(double d10) {
        return new TokenStreamLocationAwareDoubleNode(d10, this.jsonParser.currentTokenLocation());
    }

    @Override // com.fasterxml.jackson.databind.node.JsonNodeFactory, com.fasterxml.jackson.databind.node.JsonNodeCreator
    public ValueNode numberNode(Double d10) {
        return d10 == null ? nullNode() : numberNode(d10.doubleValue());
    }

    @Override // com.fasterxml.jackson.databind.node.JsonNodeFactory, com.fasterxml.jackson.databind.node.JsonNodeCreator
    public ValueNode numberNode(BigDecimal bigDecimal) {
        return bigDecimal == null ? nullNode() : new TokenStreamLocationAwareDecimalNode(bigDecimal, this.jsonParser.currentTokenLocation());
    }
}
