package org.bouncycastle.asn1;

import java.io.IOException;

/* loaded from: classes.dex */
public class BEROctetString extends ASN1OctetString {
    private static final int DEFAULT_SEGMENT_LIMIT = 1000;
    private final ASN1OctetString[] elements;
    private final int segmentLimit;

    public BEROctetString(byte[] bArr) {
        this(bArr, DEFAULT_SEGMENT_LIMIT);
    }

    public static byte[] flattenOctetStrings(ASN1OctetString[] aSN1OctetStringArr) {
        int length = aSN1OctetStringArr.length;
        if (length == 0) {
            return ASN1OctetString.EMPTY_OCTETS;
        }
        if (length == 1) {
            return aSN1OctetStringArr[0].string;
        }
        int length2 = 0;
        for (ASN1OctetString aSN1OctetString : aSN1OctetStringArr) {
            length2 += aSN1OctetString.string.length;
        }
        byte[] bArr = new byte[length2];
        int length3 = 0;
        for (ASN1OctetString aSN1OctetString2 : aSN1OctetStringArr) {
            byte[] bArr2 = aSN1OctetString2.string;
            System.arraycopy(bArr2, 0, bArr, length3, bArr2.length);
            length3 += bArr2.length;
        }
        return bArr;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public void encode(ASN1OutputStream aSN1OutputStream, boolean z) throws IOException {
        aSN1OutputStream.writeIdentifier(z, 36);
        aSN1OutputStream.write(128);
        ASN1OctetString[] aSN1OctetStringArr = this.elements;
        if (aSN1OctetStringArr == null) {
            int i8 = 0;
            while (true) {
                byte[] bArr = this.string;
                if (i8 >= bArr.length) {
                    break;
                }
                int iMin = Math.min(bArr.length - i8, this.segmentLimit);
                DEROctetString.encode(aSN1OutputStream, true, this.string, i8, iMin);
                i8 += iMin;
            }
        } else {
            aSN1OutputStream.writePrimitives(aSN1OctetStringArr);
        }
        aSN1OutputStream.write(0);
        aSN1OutputStream.write(0);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public boolean encodeConstructed() {
        return true;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public int encodedLength(boolean z) {
        int iEncodedLength = z ? 4 : 3;
        if (this.elements == null) {
            int length = this.string.length;
            int i8 = this.segmentLimit;
            int i9 = length / i8;
            int iEncodedLength2 = (DEROctetString.encodedLength(true, i8) * i9) + iEncodedLength;
            int length2 = this.string.length - (i9 * this.segmentLimit);
            return length2 > 0 ? DEROctetString.encodedLength(true, length2) + iEncodedLength2 : iEncodedLength2;
        }
        int i10 = 0;
        while (true) {
            ASN1OctetString[] aSN1OctetStringArr = this.elements;
            if (i10 >= aSN1OctetStringArr.length) {
                return iEncodedLength;
            }
            iEncodedLength += aSN1OctetStringArr[i10].encodedLength(true);
            i10++;
        }
    }

    public BEROctetString(byte[] bArr, int i8) {
        this(bArr, null, i8);
    }

    private BEROctetString(byte[] bArr, ASN1OctetString[] aSN1OctetStringArr, int i8) {
        super(bArr);
        this.elements = aSN1OctetStringArr;
        this.segmentLimit = i8;
    }

    public BEROctetString(ASN1OctetString[] aSN1OctetStringArr) {
        this(aSN1OctetStringArr, DEFAULT_SEGMENT_LIMIT);
    }

    public BEROctetString(ASN1OctetString[] aSN1OctetStringArr, int i8) {
        this(flattenOctetStrings(aSN1OctetStringArr), aSN1OctetStringArr, i8);
    }
}
