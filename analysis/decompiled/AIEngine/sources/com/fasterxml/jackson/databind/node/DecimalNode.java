package com.fasterxml.jackson.databind.node;

import b3.h;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonToken;
import java.math.BigDecimal;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class DecimalNode extends NumericNode {

    /* renamed from: b, reason: collision with root package name */
    public static final DecimalNode f4263b = new DecimalNode(BigDecimal.ZERO);

    /* renamed from: a, reason: collision with root package name */
    public final BigDecimal f4264a;

    static {
        BigDecimal.valueOf(-2147483648L);
        BigDecimal.valueOf(2147483647L);
        BigDecimal.valueOf(Long.MIN_VALUE);
        BigDecimal.valueOf(Long.MAX_VALUE);
    }

    public DecimalNode(BigDecimal bigDecimal) {
        this.f4264a = bigDecimal;
    }

    @Override // com.fasterxml.jackson.databind.node.BaseJsonNode, b3.e
    public final void a(JsonGenerator jsonGenerator, h hVar) {
        jsonGenerator.P0(this.f4264a);
    }

    @Override // b3.d
    public final float e() {
        return this.f4264a.floatValue();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return obj != null && (obj instanceof DecimalNode) && ((DecimalNode) obj).f4264a.compareTo(this.f4264a) == 0;
    }

    @Override // com.fasterxml.jackson.databind.node.ValueNode
    public final JsonToken h() {
        return JsonToken.VALUE_NUMBER_FLOAT;
    }

    public final int hashCode() {
        return Double.valueOf(this.f4264a.doubleValue()).hashCode();
    }
}
