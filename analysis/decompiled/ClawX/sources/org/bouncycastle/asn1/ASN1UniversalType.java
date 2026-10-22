package org.bouncycastle.asn1;

/* loaded from: classes.dex */
abstract class ASN1UniversalType extends ASN1Type {
    final ASN1Tag tag;

    public ASN1UniversalType(Class cls, int i8) {
        super(cls);
        this.tag = ASN1Tag.create(0, i8);
    }

    public final ASN1Primitive checkedCast(ASN1Primitive aSN1Primitive) {
        if (this.javaClass.isInstance(aSN1Primitive)) {
            return aSN1Primitive;
        }
        throw new IllegalStateException("unexpected object: ".concat(aSN1Primitive.getClass().getName()));
    }

    public final ASN1Primitive fromByteArray(byte[] bArr) {
        return checkedCast(ASN1Primitive.fromByteArray(bArr));
    }

    public ASN1Primitive fromImplicitConstructed(ASN1Sequence aSN1Sequence) {
        throw new IllegalStateException("unexpected implicit constructed encoding");
    }

    public ASN1Primitive fromImplicitPrimitive(DEROctetString dEROctetString) {
        throw new IllegalStateException("unexpected implicit primitive encoding");
    }

    public final ASN1Primitive getContextTagged(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return checkedCast(ASN1Util.checkContextTagClass(aSN1TaggedObject).getBaseUniversal(z, this));
    }

    public final ASN1Tag getTag() {
        return this.tag;
    }

    public final ASN1Primitive getTagged(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return checkedCast(aSN1TaggedObject.getBaseUniversal(z, this));
    }
}
