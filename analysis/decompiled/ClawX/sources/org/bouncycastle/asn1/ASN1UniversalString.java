package org.bouncycastle.asn1;

import java.io.IOException;
import m0.f;
import org.bouncycastle.util.Arrays;

/* loaded from: classes.dex */
public abstract class ASN1UniversalString extends ASN1Primitive implements ASN1String {
    static final ASN1UniversalType TYPE = new ASN1UniversalType(ASN1UniversalString.class, 28) { // from class: org.bouncycastle.asn1.ASN1UniversalString.1
        @Override // org.bouncycastle.asn1.ASN1UniversalType
        public ASN1Primitive fromImplicitPrimitive(DEROctetString dEROctetString) {
            return ASN1UniversalString.createPrimitive(dEROctetString.getOctets());
        }
    };
    private static final char[] table = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    final byte[] contents;

    public ASN1UniversalString(byte[] bArr, boolean z) {
        this.contents = z ? Arrays.clone(bArr) : bArr;
    }

    public static ASN1UniversalString createPrimitive(byte[] bArr) {
        return new DERUniversalString(bArr, false);
    }

    private static void encodeHexByte(StringBuilder sb, int i8) {
        char[] cArr = table;
        sb.append(cArr[(i8 >>> 4) & 15]);
        sb.append(cArr[i8 & 15]);
    }

    private static void encodeHexDL(StringBuilder sb, int i8) {
        int i9;
        if (i8 < 128) {
            encodeHexByte(sb, i8);
            return;
        }
        byte[] bArr = new byte[5];
        int i10 = 5;
        while (true) {
            i9 = i10 - 1;
            bArr[i9] = (byte) i8;
            i8 >>>= 8;
            if (i8 == 0) {
                break;
            } else {
                i10 = i9;
            }
        }
        int i11 = i10 - 2;
        bArr[i11] = (byte) ((5 - i9) | 128);
        while (true) {
            int i12 = i11 + 1;
            encodeHexByte(sb, bArr[i11]);
            if (i12 >= 5) {
                return;
            } else {
                i11 = i12;
            }
        }
    }

    public static ASN1UniversalString getInstance(Object obj) {
        if (obj == null || (obj instanceof ASN1UniversalString)) {
            return (ASN1UniversalString) obj;
        }
        if (obj instanceof ASN1Encodable) {
            ASN1Primitive aSN1Primitive = ((ASN1Encodable) obj).toASN1Primitive();
            if (aSN1Primitive instanceof ASN1UniversalString) {
                return (ASN1UniversalString) aSN1Primitive;
            }
        }
        if (!(obj instanceof byte[])) {
            throw new IllegalArgumentException(f.b(obj, "illegal object in getInstance: "));
        }
        try {
            return (ASN1UniversalString) TYPE.fromByteArray((byte[]) obj);
        } catch (Exception e9) {
            throw new IllegalArgumentException("encoding error getInstance: " + e9.toString());
        }
    }

    public static ASN1UniversalString getTagged(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return (ASN1UniversalString) TYPE.getTagged(aSN1TaggedObject, z);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public final boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (aSN1Primitive instanceof ASN1UniversalString) {
            return Arrays.areEqual(this.contents, ((ASN1UniversalString) aSN1Primitive).contents);
        }
        return false;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public final void encode(ASN1OutputStream aSN1OutputStream, boolean z) throws IOException {
        aSN1OutputStream.writeEncodingDL(z, 28, this.contents);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public final boolean encodeConstructed() {
        return false;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public final int encodedLength(boolean z) {
        return ASN1OutputStream.getLengthOfEncodingDL(z, this.contents.length);
    }

    public final byte[] getOctets() {
        return Arrays.clone(this.contents);
    }

    @Override // org.bouncycastle.asn1.ASN1String
    public final String getString() {
        int length = this.contents.length;
        StringBuilder sb = new StringBuilder(((ASN1OutputStream.getLengthOfDL(length) + length) * 2) + 3);
        sb.append("#1C");
        encodeHexDL(sb, length);
        for (int i8 = 0; i8 < length; i8++) {
            encodeHexByte(sb, this.contents[i8]);
        }
        return sb.toString();
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive, org.bouncycastle.asn1.ASN1Object
    public final int hashCode() {
        return Arrays.hashCode(this.contents);
    }

    public String toString() {
        return getString();
    }

    public static ASN1UniversalString getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return (ASN1UniversalString) TYPE.getContextTagged(aSN1TaggedObject, z);
    }
}
