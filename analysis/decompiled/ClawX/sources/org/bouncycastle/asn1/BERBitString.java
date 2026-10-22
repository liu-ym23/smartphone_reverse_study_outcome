package org.bouncycastle.asn1;

import java.io.IOException;

/* loaded from: classes.dex */
public class BERBitString extends ASN1BitString {
    private static final int DEFAULT_SEGMENT_LIMIT = 1000;
    private final ASN1BitString[] elements;
    private final int segmentLimit;

    public BERBitString(byte b9, int i8) {
        super(b9, i8);
        this.elements = null;
        this.segmentLimit = DEFAULT_SEGMENT_LIMIT;
    }

    public static byte[] flattenBitStrings(ASN1BitString[] aSN1BitStringArr) {
        int length = aSN1BitStringArr.length;
        if (length == 0) {
            return new byte[]{0};
        }
        if (length == 1) {
            return aSN1BitStringArr[0].contents;
        }
        int i8 = length - 1;
        int length2 = 0;
        for (int i9 = 0; i9 < i8; i9++) {
            byte[] bArr = aSN1BitStringArr[i9].contents;
            if (bArr[0] != 0) {
                throw new IllegalArgumentException("only the last nested bitstring can have padding");
            }
            length2 += bArr.length - 1;
        }
        byte[] bArr2 = aSN1BitStringArr[i8].contents;
        byte b9 = bArr2[0];
        byte[] bArr3 = new byte[length2 + bArr2.length];
        bArr3[0] = b9;
        int i10 = 1;
        for (ASN1BitString aSN1BitString : aSN1BitStringArr) {
            byte[] bArr4 = aSN1BitString.contents;
            int length3 = bArr4.length - 1;
            System.arraycopy(bArr4, 1, bArr3, i10, length3);
            i10 += length3;
        }
        return bArr3;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public void encode(ASN1OutputStream aSN1OutputStream, boolean z) throws IOException {
        ASN1OutputStream aSN1OutputStream2;
        if (!encodeConstructed()) {
            byte[] bArr = this.contents;
            DLBitString.encode(aSN1OutputStream, z, bArr, 0, bArr.length);
            return;
        }
        aSN1OutputStream.writeIdentifier(z, 35);
        aSN1OutputStream.write(128);
        ASN1BitString[] aSN1BitStringArr = this.elements;
        if (aSN1BitStringArr == null) {
            byte[] bArr2 = this.contents;
            if (bArr2.length >= 2) {
                byte b9 = bArr2[0];
                int length = bArr2.length;
                int i8 = length - 1;
                int i9 = this.segmentLimit - 1;
                while (i8 > i9) {
                    ASN1OutputStream aSN1OutputStream3 = aSN1OutputStream;
                    DLBitString.encode(aSN1OutputStream3, true, (byte) 0, this.contents, length - i8, i9);
                    i8 -= i9;
                    aSN1OutputStream = aSN1OutputStream3;
                }
                aSN1OutputStream2 = aSN1OutputStream;
                DLBitString.encode(aSN1OutputStream2, true, b9, this.contents, length - i8, i8);
            }
            aSN1OutputStream2.write(0);
            aSN1OutputStream2.write(0);
        }
        aSN1OutputStream.writePrimitives(aSN1BitStringArr);
        aSN1OutputStream2 = aSN1OutputStream;
        aSN1OutputStream2.write(0);
        aSN1OutputStream2.write(0);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public boolean encodeConstructed() {
        return this.elements != null || this.contents.length > this.segmentLimit;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public int encodedLength(boolean z) {
        if (!encodeConstructed()) {
            return DLBitString.encodedLength(z, this.contents.length);
        }
        int iEncodedLength = z ? 4 : 3;
        if (this.elements == null) {
            byte[] bArr = this.contents;
            if (bArr.length < 2) {
                return iEncodedLength;
            }
            int length = bArr.length - 2;
            int i8 = this.segmentLimit;
            int i9 = length / (i8 - 1);
            return DLBitString.encodedLength(true, this.contents.length - ((this.segmentLimit - 1) * i9)) + (DLBitString.encodedLength(true, i8) * i9) + iEncodedLength;
        }
        int i10 = 0;
        while (true) {
            ASN1BitString[] aSN1BitStringArr = this.elements;
            if (i10 >= aSN1BitStringArr.length) {
                return iEncodedLength;
            }
            iEncodedLength += aSN1BitStringArr[i10].encodedLength(true);
            i10++;
        }
    }

    public BERBitString(ASN1Encodable aSN1Encodable) {
        this(aSN1Encodable.toASN1Primitive().getEncoded(ASN1Encoding.DER), 0);
    }

    public BERBitString(byte[] bArr) {
        this(bArr, 0);
    }

    public BERBitString(byte[] bArr, int i8) {
        this(bArr, i8, DEFAULT_SEGMENT_LIMIT);
    }

    public BERBitString(byte[] bArr, int i8, int i9) {
        super(bArr, i8);
        this.elements = null;
        this.segmentLimit = i9;
    }

    public BERBitString(byte[] bArr, boolean z) {
        super(bArr, z);
        this.elements = null;
        this.segmentLimit = DEFAULT_SEGMENT_LIMIT;
    }

    public BERBitString(ASN1BitString[] aSN1BitStringArr) {
        this(aSN1BitStringArr, DEFAULT_SEGMENT_LIMIT);
    }

    public BERBitString(ASN1BitString[] aSN1BitStringArr, int i8) {
        super(flattenBitStrings(aSN1BitStringArr), false);
        this.elements = aSN1BitStringArr;
        this.segmentLimit = i8;
    }
}
