package org.bouncycastle.asn1;

import java.io.IOException;

/* loaded from: classes.dex */
public class DLBitString extends ASN1BitString {
    public DLBitString(byte b9, int i8) {
        super(b9, i8);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public void encode(ASN1OutputStream aSN1OutputStream, boolean z) throws IOException {
        aSN1OutputStream.writeEncodingDL(z, 3, this.contents);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public boolean encodeConstructed() {
        return false;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public int encodedLength(boolean z) {
        return ASN1OutputStream.getLengthOfEncodingDL(z, this.contents.length);
    }

    public DLBitString(int i8) {
        super(ASN1BitString.getBytes(i8), ASN1BitString.getPadBits(i8));
    }

    public static void encode(ASN1OutputStream aSN1OutputStream, boolean z, byte b9, byte[] bArr, int i8, int i9) {
        aSN1OutputStream.writeEncodingDL(z, 3, b9, bArr, i8, i9);
    }

    public static int encodedLength(boolean z, int i8) {
        return ASN1OutputStream.getLengthOfEncodingDL(z, i8);
    }

    public DLBitString(ASN1Encodable aSN1Encodable) {
        super(aSN1Encodable.toASN1Primitive().getEncoded(ASN1Encoding.DER), 0);
    }

    public static void encode(ASN1OutputStream aSN1OutputStream, boolean z, byte[] bArr, int i8, int i9) {
        aSN1OutputStream.writeEncodingDL(z, 3, bArr, i8, i9);
    }

    public DLBitString(byte[] bArr) {
        this(bArr, 0);
    }

    public DLBitString(byte[] bArr, int i8) {
        super(bArr, i8);
    }

    public DLBitString(byte[] bArr, boolean z) {
        super(bArr, z);
    }

    @Override // org.bouncycastle.asn1.ASN1BitString, org.bouncycastle.asn1.ASN1Primitive
    public ASN1Primitive toDLObject() {
        return this;
    }
}
