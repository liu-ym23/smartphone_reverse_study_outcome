package org.bouncycastle.asn1;

import a8.b;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import m0.f;
import org.bouncycastle.util.Arrays;

/* loaded from: classes.dex */
public abstract class ASN1BitString extends ASN1Primitive implements ASN1String, ASN1BitStringParser {
    static final ASN1UniversalType TYPE = new ASN1UniversalType(ASN1BitString.class, 3) { // from class: org.bouncycastle.asn1.ASN1BitString.1
        @Override // org.bouncycastle.asn1.ASN1UniversalType
        public ASN1Primitive fromImplicitConstructed(ASN1Sequence aSN1Sequence) {
            return aSN1Sequence.toASN1BitString();
        }

        @Override // org.bouncycastle.asn1.ASN1UniversalType
        public ASN1Primitive fromImplicitPrimitive(DEROctetString dEROctetString) {
            return ASN1BitString.createPrimitive(dEROctetString.getOctets());
        }
    };
    private static final char[] table = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    final byte[] contents;

    public ASN1BitString(byte b9, int i8) {
        if (i8 > 7 || i8 < 0) {
            throw new IllegalArgumentException("pad bits cannot be greater than 7 or less than 0");
        }
        this.contents = new byte[]{(byte) i8, b9};
    }

    public static ASN1BitString createPrimitive(byte[] bArr) {
        int length = bArr.length;
        if (length < 1) {
            throw new IllegalArgumentException("truncated BIT STRING detected");
        }
        int i8 = bArr[0] & 255;
        if (i8 > 0) {
            if (i8 > 7 || length < 2) {
                throw new IllegalArgumentException("invalid pad bits detected");
            }
            byte b9 = bArr[length - 1];
            if (b9 != ((byte) ((255 << i8) & b9))) {
                return new DLBitString(bArr, false);
            }
        }
        return new DERBitString(bArr, false);
    }

    public static ASN1BitString getInstance(Object obj) {
        if (obj == null || (obj instanceof ASN1BitString)) {
            return (ASN1BitString) obj;
        }
        if (obj instanceof ASN1Encodable) {
            ASN1Primitive aSN1Primitive = ((ASN1Encodable) obj).toASN1Primitive();
            if (aSN1Primitive instanceof ASN1BitString) {
                return (ASN1BitString) aSN1Primitive;
            }
        } else if (obj instanceof byte[]) {
            try {
                return (ASN1BitString) TYPE.fromByteArray((byte[]) obj);
            } catch (IOException e9) {
                throw new IllegalArgumentException(f.a(e9, new StringBuilder("failed to construct BIT STRING from byte[]: ")));
            }
        }
        throw new IllegalArgumentException(f.b(obj, "illegal object in getInstance: "));
    }

    public static ASN1BitString getTagged(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return (ASN1BitString) TYPE.getTagged(aSN1TaggedObject, z);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof ASN1BitString)) {
            return false;
        }
        byte[] bArr = this.contents;
        byte[] bArr2 = ((ASN1BitString) aSN1Primitive).contents;
        int length = bArr.length;
        if (bArr2.length != length) {
            return false;
        }
        if (length == 1) {
            return true;
        }
        int i8 = length - 1;
        for (int i9 = 0; i9 < i8; i9++) {
            if (bArr[i9] != bArr2[i9]) {
                return false;
            }
        }
        int i10 = 255 << (bArr[0] & 255);
        return ((byte) (bArr[i8] & i10)) == ((byte) (bArr2[i8] & i10));
    }

    @Override // org.bouncycastle.asn1.ASN1BitStringParser
    public InputStream getBitStream() {
        byte[] bArr = this.contents;
        return new ByteArrayInputStream(bArr, 1, bArr.length - 1);
    }

    public byte[] getBytes() {
        byte[] bArr = this.contents;
        if (bArr.length == 1) {
            return ASN1OctetString.EMPTY_OCTETS;
        }
        int i8 = bArr[0] & 255;
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, 1, bArr.length);
        int length = bArrCopyOfRange.length - 1;
        bArrCopyOfRange[length] = (byte) (((byte) (255 << i8)) & bArrCopyOfRange[length]);
        return bArrCopyOfRange;
    }

    public int getBytesLength() {
        return this.contents.length - 1;
    }

    @Override // org.bouncycastle.asn1.InMemoryRepresentable
    public ASN1Primitive getLoadedObject() {
        return toASN1Primitive();
    }

    @Override // org.bouncycastle.asn1.ASN1BitStringParser
    public InputStream getOctetStream() throws IOException {
        int i8 = this.contents[0] & 255;
        if (i8 == 0) {
            return getBitStream();
        }
        throw new IOException(b.j(i8, "expected octet-aligned bitstring, but found padBits: "));
    }

    public byte[] getOctets() {
        byte[] bArr = this.contents;
        if (bArr[0] == 0) {
            return Arrays.copyOfRange(bArr, 1, bArr.length);
        }
        throw new IllegalStateException("attempt to get non-octet aligned data from BIT STRING");
    }

    @Override // org.bouncycastle.asn1.ASN1BitStringParser
    public int getPadBits() {
        return this.contents[0] & 255;
    }

    @Override // org.bouncycastle.asn1.ASN1String
    public String getString() {
        try {
            byte[] encoded = getEncoded();
            StringBuilder sb = new StringBuilder((encoded.length * 2) + 1);
            sb.append('#');
            for (int i8 = 0; i8 != encoded.length; i8++) {
                byte b9 = encoded[i8];
                char[] cArr = table;
                sb.append(cArr[(b9 >>> 4) & 15]);
                sb.append(cArr[b9 & 15]);
            }
            return sb.toString();
        } catch (IOException e9) {
            throw new ASN1ParsingException(f.a(e9, new StringBuilder("Internal error encoding BitString: ")), e9);
        }
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive, org.bouncycastle.asn1.ASN1Object
    public int hashCode() {
        byte[] bArr = this.contents;
        if (bArr.length < 2) {
            return 1;
        }
        int i8 = bArr[0] & 255;
        int length = bArr.length - 1;
        return (Arrays.hashCode(bArr, 0, length) * 257) ^ ((byte) ((255 << i8) & bArr[length]));
    }

    public int intValue() {
        int iMin = Math.min(5, this.contents.length - 1);
        int i8 = 0;
        for (int i9 = 1; i9 < iMin; i9++) {
            i8 |= (255 & this.contents[i9]) << ((i9 - 1) * 8);
        }
        if (1 > iMin || iMin >= 5) {
            return i8;
        }
        byte[] bArr = this.contents;
        return ((((byte) (bArr[iMin] & (255 << (bArr[0] & 255)))) & 255) << ((iMin - 1) * 8)) | i8;
    }

    public boolean isOctetAligned() {
        return getPadBits() == 0;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public ASN1Primitive toDERObject() {
        return new DERBitString(this.contents, false);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public ASN1Primitive toDLObject() {
        return new DLBitString(this.contents, false);
    }

    public String toString() {
        return getString();
    }

    public ASN1BitString(byte[] bArr, int i8) {
        if (bArr == null) {
            throw new NullPointerException("'data' cannot be null");
        }
        if (bArr.length == 0 && i8 != 0) {
            throw new IllegalArgumentException("zero length data with non-zero pad bits");
        }
        if (i8 > 7 || i8 < 0) {
            throw new IllegalArgumentException("pad bits cannot be greater than 7 or less than 0");
        }
        this.contents = Arrays.prepend(bArr, (byte) i8);
    }

    public static byte[] getBytes(int i8) {
        if (i8 == 0) {
            return new byte[0];
        }
        int i9 = 4;
        for (int i10 = 3; i10 >= 1 && ((255 << (i10 * 8)) & i8) == 0; i10--) {
            i9--;
        }
        byte[] bArr = new byte[i9];
        for (int i11 = 0; i11 < i9; i11++) {
            bArr[i11] = (byte) ((i8 >> (i11 * 8)) & 255);
        }
        return bArr;
    }

    public static int getPadBits(int i8) {
        int i9;
        int i10 = 3;
        while (true) {
            if (i10 < 0) {
                i9 = 0;
                break;
            }
            if (i10 != 0) {
                int i11 = i8 >> (i10 * 8);
                if (i11 != 0) {
                    i9 = i11 & 255;
                    break;
                }
                i10--;
            } else {
                if (i8 != 0) {
                    i9 = i8 & 255;
                    break;
                }
                i10--;
            }
        }
        if (i9 == 0) {
            return 0;
        }
        int i12 = 1;
        while (true) {
            i9 <<= 1;
            if ((i9 & 255) == 0) {
                return 8 - i12;
            }
            i12++;
        }
    }

    public ASN1BitString(byte[] bArr, boolean z) {
        if (z) {
            if (bArr == null) {
                throw new NullPointerException("'contents' cannot be null");
            }
            if (bArr.length < 1) {
                throw new IllegalArgumentException("'contents' cannot be empty");
            }
            int i8 = bArr[0] & 255;
            if (i8 > 0) {
                if (bArr.length < 2) {
                    throw new IllegalArgumentException("zero length data with non-zero pad bits");
                }
                if (i8 > 7) {
                    throw new IllegalArgumentException("pad bits cannot be greater than 7 or less than 0");
                }
            }
        }
        this.contents = bArr;
    }

    public static ASN1BitString getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return (ASN1BitString) TYPE.getContextTagged(aSN1TaggedObject, z);
    }

    public ASN1BitStringParser parser() {
        return this;
    }
}
