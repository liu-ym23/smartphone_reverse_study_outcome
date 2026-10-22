package org.bouncycastle.asn1;

import java.io.IOException;

/* loaded from: classes.dex */
public class DERSet extends ASN1Set {
    private int contentsLength;

    public DERSet() {
        this.contentsLength = -1;
    }

    private static boolean checkSorted(boolean z) {
        if (z) {
            return z;
        }
        throw new IllegalStateException("DERSet elements should always be in sorted order");
    }

    public static DERSet convert(ASN1Set aSN1Set) {
        return (DERSet) aSN1Set.toDERObject();
    }

    private int getContentsLength() {
        if (this.contentsLength < 0) {
            int length = this.elements.length;
            int iEncodedLength = 0;
            for (int i8 = 0; i8 < length; i8++) {
                iEncodedLength += this.elements[i8].toASN1Primitive().toDERObject().encodedLength(true);
            }
            this.contentsLength = iEncodedLength;
        }
        return this.contentsLength;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public void encode(ASN1OutputStream aSN1OutputStream, boolean z) throws IOException {
        aSN1OutputStream.writeIdentifier(z, 49);
        DEROutputStream dERSubStream = aSN1OutputStream.getDERSubStream();
        int length = this.elements.length;
        int i8 = 0;
        if (this.contentsLength >= 0 || length > 16) {
            aSN1OutputStream.writeDL(getContentsLength());
            while (i8 < length) {
                this.elements[i8].toASN1Primitive().toDERObject().encode(dERSubStream, true);
                i8++;
            }
            return;
        }
        ASN1Primitive[] aSN1PrimitiveArr = new ASN1Primitive[length];
        int iEncodedLength = 0;
        for (int i9 = 0; i9 < length; i9++) {
            ASN1Primitive dERObject = this.elements[i9].toASN1Primitive().toDERObject();
            aSN1PrimitiveArr[i9] = dERObject;
            iEncodedLength += dERObject.encodedLength(true);
        }
        this.contentsLength = iEncodedLength;
        aSN1OutputStream.writeDL(iEncodedLength);
        while (i8 < length) {
            aSN1PrimitiveArr[i8].encode(dERSubStream, true);
            i8++;
        }
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public int encodedLength(boolean z) {
        return ASN1OutputStream.getLengthOfEncodingDL(z, getContentsLength());
    }

    @Override // org.bouncycastle.asn1.ASN1Set, org.bouncycastle.asn1.ASN1Primitive
    public ASN1Primitive toDERObject() {
        return this.sortedElements != null ? this : super.toDERObject();
    }

    public DERSet(ASN1Encodable aSN1Encodable) {
        super(aSN1Encodable);
        this.contentsLength = -1;
    }

    public DERSet(ASN1EncodableVector aSN1EncodableVector) {
        super(aSN1EncodableVector, true);
        this.contentsLength = -1;
    }

    public DERSet(boolean z, ASN1Encodable[] aSN1EncodableArr) {
        super(checkSorted(z), aSN1EncodableArr);
        this.contentsLength = -1;
    }

    public DERSet(ASN1Encodable[] aSN1EncodableArr) {
        super(aSN1EncodableArr, true);
        this.contentsLength = -1;
    }

    @Override // org.bouncycastle.asn1.ASN1Set, org.bouncycastle.asn1.ASN1Primitive
    public ASN1Primitive toDLObject() {
        return this;
    }
}
