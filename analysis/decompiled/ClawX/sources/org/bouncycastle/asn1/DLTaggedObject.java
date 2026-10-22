package org.bouncycastle.asn1;

import java.io.IOException;

/* loaded from: classes.dex */
public class DLTaggedObject extends ASN1TaggedObject {
    public DLTaggedObject(int i8, int i9, int i10, ASN1Encodable aSN1Encodable) {
        super(i8, i9, i10, aSN1Encodable);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public void encode(ASN1OutputStream aSN1OutputStream, boolean z) throws IOException {
        ASN1Primitive dLObject = this.obj.toASN1Primitive().toDLObject();
        boolean zIsExplicit = isExplicit();
        if (z) {
            int i8 = this.tagClass;
            if (zIsExplicit || dLObject.encodeConstructed()) {
                i8 |= 32;
            }
            aSN1OutputStream.writeIdentifier(true, i8, this.tagNo);
        }
        if (zIsExplicit) {
            aSN1OutputStream.writeDL(dLObject.encodedLength(true));
        }
        dLObject.encode(aSN1OutputStream.getDLSubStream(), zIsExplicit);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public boolean encodeConstructed() {
        return isExplicit() || this.obj.toASN1Primitive().toDLObject().encodeConstructed();
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public int encodedLength(boolean z) {
        ASN1Primitive dLObject = this.obj.toASN1Primitive().toDLObject();
        boolean zIsExplicit = isExplicit();
        int iEncodedLength = dLObject.encodedLength(zIsExplicit);
        if (zIsExplicit) {
            iEncodedLength += ASN1OutputStream.getLengthOfDL(iEncodedLength);
        }
        return iEncodedLength + (z ? ASN1OutputStream.getLengthOfIdentifier(this.tagNo) : 0);
    }

    @Override // org.bouncycastle.asn1.ASN1TaggedObject
    public ASN1Sequence rebuildConstructed(ASN1Primitive aSN1Primitive) {
        return new DLSequence(aSN1Primitive);
    }

    @Override // org.bouncycastle.asn1.ASN1TaggedObject
    public ASN1TaggedObject replaceTag(int i8, int i9) {
        return new DLTaggedObject(this.explicitness, i8, i9, this.obj);
    }

    public DLTaggedObject(int i8, int i9, ASN1Encodable aSN1Encodable) {
        super(true, i8, i9, aSN1Encodable);
    }

    public DLTaggedObject(int i8, ASN1Encodable aSN1Encodable) {
        super(true, i8, aSN1Encodable);
    }

    public DLTaggedObject(boolean z, int i8, int i9, ASN1Encodable aSN1Encodable) {
        super(z, i8, i9, aSN1Encodable);
    }

    public DLTaggedObject(boolean z, int i8, ASN1Encodable aSN1Encodable) {
        super(z, i8, aSN1Encodable);
    }

    @Override // org.bouncycastle.asn1.ASN1TaggedObject, org.bouncycastle.asn1.ASN1Primitive
    public ASN1Primitive toDLObject() {
        return this;
    }
}
