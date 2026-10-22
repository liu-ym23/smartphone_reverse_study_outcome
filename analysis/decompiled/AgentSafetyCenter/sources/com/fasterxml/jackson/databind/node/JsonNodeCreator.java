package com.fasterxml.jackson.databind.node;

import com.fasterxml.jackson.databind.util.RawValue;
import java.math.BigDecimal;
import java.math.BigInteger;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public interface JsonNodeCreator {
    ArrayNode arrayNode();

    ArrayNode arrayNode(int i);

    ValueNode binaryNode(byte[] bArr);

    ValueNode binaryNode(byte[] bArr, int i, int i3);

    ValueNode booleanNode(boolean z10);

    ValueNode nullNode();

    ValueNode numberNode(byte b10);

    ValueNode numberNode(double d7);

    ValueNode numberNode(float f5);

    ValueNode numberNode(int i);

    ValueNode numberNode(long j10);

    ValueNode numberNode(Byte b10);

    ValueNode numberNode(Double d7);

    ValueNode numberNode(Float f5);

    ValueNode numberNode(Integer num);

    ValueNode numberNode(Long l2);

    ValueNode numberNode(Short sh);

    ValueNode numberNode(BigDecimal bigDecimal);

    ValueNode numberNode(BigInteger bigInteger);

    ValueNode numberNode(short s6);

    ObjectNode objectNode();

    ValueNode pojoNode(Object obj);

    ValueNode rawValueNode(RawValue rawValue);

    ValueNode textNode(String str);
}
