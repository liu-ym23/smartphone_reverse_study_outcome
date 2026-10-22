package com.fasterxml.jackson.databind.node;

import b3.h;
import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonToken;
import java.util.Arrays;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class BinaryNode extends ValueNode {

    /* renamed from: b, reason: collision with root package name */
    public static final BinaryNode f4257b = new BinaryNode(new byte[0]);

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f4258a;

    public BinaryNode(byte[] bArr) {
        this.f4258a = bArr;
    }

    @Override // com.fasterxml.jackson.databind.node.BaseJsonNode, b3.e
    public final void a(JsonGenerator jsonGenerator, h hVar) {
        Base64Variant base64Variant = hVar.f3044a.f3828b.f3795k;
        byte[] bArr = this.f4258a;
        jsonGenerator.c0(base64Variant, bArr, 0, bArr.length);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && (obj instanceof BinaryNode)) {
            return Arrays.equals(((BinaryNode) obj).f4258a, this.f4258a);
        }
        return false;
    }

    @Override // b3.d
    public final JsonNodeType g() {
        return JsonNodeType.f4271b;
    }

    @Override // com.fasterxml.jackson.databind.node.ValueNode
    public final JsonToken h() {
        return JsonToken.VALUE_EMBEDDED_OBJECT;
    }

    public final int hashCode() {
        byte[] bArr = this.f4258a;
        if (bArr == null) {
            return -1;
        }
        return bArr.length;
    }
}
