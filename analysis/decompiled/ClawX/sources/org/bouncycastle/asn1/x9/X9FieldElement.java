package org.bouncycastle.asn1.x9;

import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DEROctetString;
import p7.m;

/* loaded from: classes.dex */
public class X9FieldElement extends ASN1Object {
    private static X9IntegerConverter converter = new X9IntegerConverter();

    /* renamed from: f, reason: collision with root package name */
    protected m f4373f;

    public X9FieldElement(m mVar) {
        this.f4373f = mVar;
    }

    public m getValue() {
        return this.f4373f;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DEROctetString(converter.integerToBytes(this.f4373f.t(), converter.getByteLength(this.f4373f)));
    }
}
