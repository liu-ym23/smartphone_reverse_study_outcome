package org.bouncycastle.asn1;

import java.io.IOException;

/* loaded from: classes.dex */
public class BERTaggedObject extends ASN1TaggedObject {
    public BERTaggedObject(int i8, int i9, int i10, ASN1Encodable aSN1Encodable) {
        super(i8, i9, i10, aSN1Encodable);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public void encode(ASN1OutputStream aSN1OutputStream, boolean z) throws IOException {
        ASN1Primitive aSN1Primitive = this.obj.toASN1Primitive();
        boolean zIsExplicit = isExplicit();
        if (z) {
            int i8 = this.tagClass;
            if (zIsExplicit || aSN1Primitive.encodeConstructed()) {
                i8 |= 32;
            }
            aSN1OutputStream.writeIdentifier(true, i8, this.tagNo);
        }
        if (!zIsExplicit) {
            aSN1Primitive.encode(aSN1OutputStream, false);
            return;
        }
        aSN1OutputStream.write(128);
        aSN1Primitive.encode(aSN1OutputStream, true);
        aSN1OutputStream.write(0);
        aSN1OutputStream.write(0);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public boolean encodeConstructed() {
        return isExplicit() || this.obj.toASN1Primitive().encodeConstructed();
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public int encodedLength(boolean z) {
        ASN1Primitive aSN1Primitive = this.obj.toASN1Primitive();
        boolean zIsExplicit = isExplicit();
        int iEncodedLength = aSN1Primitive.encodedLength(zIsExplicit);
        if (zIsExplicit) {
            iEncodedLength += 3;
        }
        return iEncodedLength + (z ? ASN1OutputStream.getLengthOfIdentifier(this.tagNo) : 0);
    }

    @Override // org.bouncycastle.asn1.ASN1TaggedObject
    public ASN1Sequence rebuildConstructed(ASN1Primitive aSN1Primitive) {
        return new BERSequence(aSN1Primitive);
    }

    @Override // org.bouncycastle.asn1.ASN1TaggedObject
    public ASN1TaggedObject replaceTag(int i8, int i9) {
        return new BERTaggedObject(this.explicitness, i8, i9, this.obj);
    }

    public BERTaggedObject(int i8, int i9, ASN1Encodable aSN1Encodable) {
        super(true, i8, i9, aSN1Encodable);
    }

    public BERTaggedObject(int i8, ASN1Encodable aSN1Encodable) {
        super(true, i8, aSN1Encodable);
    }

    public BERTaggedObject(boolean z, int i8, int i9, ASN1Encodable aSN1Encodable) {
        super(z, i8, i9, aSN1Encodable);
    }

    public BERTaggedObject(boolean z, int i8, ASN1Encodable aSN1Encodable) {
        super(z, i8, aSN1Encodable);
    }
}
