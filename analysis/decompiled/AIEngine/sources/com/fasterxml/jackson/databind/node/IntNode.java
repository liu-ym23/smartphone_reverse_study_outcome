package com.fasterxml.jackson.databind.node;

import b3.h;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class IntNode extends NumericNode {

    /* renamed from: b, reason: collision with root package name */
    public static final IntNode[] f4267b = new IntNode[12];

    /* renamed from: a, reason: collision with root package name */
    public final int f4268a;

    static {
        for (int i10 = 0; i10 < 12; i10++) {
            f4267b[i10] = new IntNode(i10 - 1);
        }
    }

    public IntNode(int i10) {
        this.f4268a = i10;
    }

    @Override // com.fasterxml.jackson.databind.node.BaseJsonNode, b3.e
    public final void a(JsonGenerator jsonGenerator, h hVar) {
        jsonGenerator.M0(this.f4268a);
    }

    @Override // b3.d
    public final float e() {
        return this.f4268a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return obj != null && (obj instanceof IntNode) && ((IntNode) obj).f4268a == this.f4268a;
    }

    @Override // com.fasterxml.jackson.databind.node.ValueNode
    public final JsonToken h() {
        return JsonToken.VALUE_NUMBER_INT;
    }

    public final int hashCode() {
        return this.f4268a;
    }
}
