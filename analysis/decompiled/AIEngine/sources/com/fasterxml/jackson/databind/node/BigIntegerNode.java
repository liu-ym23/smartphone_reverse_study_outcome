package com.fasterxml.jackson.databind.node;

import b3.h;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonToken;
import java.math.BigInteger;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class BigIntegerNode extends NumericNode {

    /* renamed from: a, reason: collision with root package name */
    public final BigInteger f4256a;

    static {
        BigInteger.valueOf(-2147483648L);
        BigInteger.valueOf(2147483647L);
        BigInteger.valueOf(Long.MIN_VALUE);
        BigInteger.valueOf(Long.MAX_VALUE);
    }

    public BigIntegerNode(BigInteger bigInteger) {
        this.f4256a = bigInteger;
    }

    @Override // com.fasterxml.jackson.databind.node.BaseJsonNode, b3.e
    public final void a(JsonGenerator jsonGenerator, h hVar) {
        jsonGenerator.Q0(this.f4256a);
    }

    @Override // b3.d
    public final float e() {
        return this.f4256a.floatValue();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && (obj instanceof BigIntegerNode)) {
            return ((BigIntegerNode) obj).f4256a.equals(this.f4256a);
        }
        return false;
    }

    @Override // com.fasterxml.jackson.databind.node.ValueNode
    public final JsonToken h() {
        return JsonToken.VALUE_NUMBER_INT;
    }

    public final int hashCode() {
        return this.f4256a.hashCode();
    }
}
