package org.bouncycastle.asn1;

import java.io.IOException;
import java.math.BigInteger;
import m0.f;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Properties;

/* loaded from: classes.dex */
public class ASN1Integer extends ASN1Primitive {
    static final int SIGN_EXT_SIGNED = -1;
    static final int SIGN_EXT_UNSIGNED = 255;
    static final ASN1UniversalType TYPE = new ASN1UniversalType(ASN1Integer.class, 2) { // from class: org.bouncycastle.asn1.ASN1Integer.1
        @Override // org.bouncycastle.asn1.ASN1UniversalType
        public ASN1Primitive fromImplicitPrimitive(DEROctetString dEROctetString) {
            return ASN1Integer.createPrimitive(dEROctetString.getOctets());
        }
    };
    private final byte[] bytes;
    private final int start;

    public ASN1Integer(long j4) {
        this.bytes = BigInteger.valueOf(j4).toByteArray();
        this.start = 0;
    }

    public static ASN1Integer createPrimitive(byte[] bArr) {
        return new ASN1Integer(bArr, false);
    }

    public static ASN1Integer getInstance(Object obj) {
        if (obj == null || (obj instanceof ASN1Integer)) {
            return (ASN1Integer) obj;
        }
        if (!(obj instanceof byte[])) {
            throw new IllegalArgumentException(f.b(obj, "illegal object in getInstance: "));
        }
        try {
            return (ASN1Integer) TYPE.fromByteArray((byte[]) obj);
        } catch (Exception e9) {
            throw new IllegalArgumentException("encoding error in getInstance: " + e9.toString());
        }
    }

    public static ASN1Integer getTagged(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return (ASN1Integer) TYPE.getTagged(aSN1TaggedObject, z);
    }

    public static int intValue(byte[] bArr, int i8, int i9) {
        int length = bArr.length;
        int iMax = Math.max(i8, length - 4);
        int i10 = i9 & bArr[iMax];
        while (true) {
            iMax++;
            if (iMax >= length) {
                return i10;
            }
            i10 = (i10 << 8) | (bArr[iMax] & SIGN_EXT_UNSIGNED);
        }
    }

    public static boolean isMalformed(byte[] bArr) {
        int length = bArr.length;
        if (length != 0) {
            return (length == 1 || bArr[0] != (bArr[1] >> 7) || Properties.isOverrideSet("org.bouncycastle.asn1.allow_unsafe_integer")) ? false : true;
        }
        return true;
    }

    public static long longValue(byte[] bArr, int i8, int i9) {
        int length = bArr.length;
        int iMax = Math.max(i8, length - 8);
        long j4 = i9 & bArr[iMax];
        while (true) {
            iMax++;
            if (iMax >= length) {
                return j4;
            }
            j4 = (j4 << 8) | (bArr[iMax] & 255);
        }
    }

    public static int signBytesToSkip(byte[] bArr) {
        int length = bArr.length - 1;
        int i8 = 0;
        while (i8 < length) {
            int i9 = i8 + 1;
            if (bArr[i8] != (bArr[i9] >> 7)) {
                break;
            }
            i8 = i9;
        }
        return i8;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (aSN1Primitive instanceof ASN1Integer) {
            return Arrays.areEqual(this.bytes, ((ASN1Integer) aSN1Primitive).bytes);
        }
        return false;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public void encode(ASN1OutputStream aSN1OutputStream, boolean z) throws IOException {
        aSN1OutputStream.writeEncodingDL(z, 2, this.bytes);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public boolean encodeConstructed() {
        return false;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public int encodedLength(boolean z) {
        return ASN1OutputStream.getLengthOfEncodingDL(z, this.bytes.length);
    }

    public BigInteger getPositiveValue() {
        return new BigInteger(1, this.bytes);
    }

    public BigInteger getValue() {
        return new BigInteger(this.bytes);
    }

    public boolean hasValue(int i8) {
        byte[] bArr = this.bytes;
        int length = bArr.length;
        int i9 = this.start;
        return length - i9 <= 4 && intValue(bArr, i9, -1) == i8;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive, org.bouncycastle.asn1.ASN1Object
    public int hashCode() {
        return Arrays.hashCode(this.bytes);
    }

    public int intPositiveValueExact() {
        byte[] bArr = this.bytes;
        int length = bArr.length;
        int i8 = this.start;
        int i9 = length - i8;
        if (i9 > 4 || (i9 == 4 && (bArr[i8] & 128) != 0)) {
            throw new ArithmeticException("ASN.1 Integer out of positive int range");
        }
        return intValue(bArr, i8, SIGN_EXT_UNSIGNED);
    }

    public int intValueExact() {
        byte[] bArr = this.bytes;
        int length = bArr.length;
        int i8 = this.start;
        if (length - i8 <= 4) {
            return intValue(bArr, i8, -1);
        }
        throw new ArithmeticException("ASN.1 Integer out of int range");
    }

    public long longValueExact() {
        byte[] bArr = this.bytes;
        int length = bArr.length;
        int i8 = this.start;
        if (length - i8 <= 8) {
            return longValue(bArr, i8, -1);
        }
        throw new ArithmeticException("ASN.1 Integer out of long range");
    }

    public String toString() {
        return getValue().toString();
    }

    public ASN1Integer(BigInteger bigInteger) {
        this.bytes = bigInteger.toByteArray();
        this.start = 0;
    }

    public boolean hasValue(long j4) {
        byte[] bArr = this.bytes;
        int length = bArr.length;
        int i8 = this.start;
        return length - i8 <= 8 && longValue(bArr, i8, -1) == j4;
    }

    public ASN1Integer(byte[] bArr) {
        this(bArr, true);
    }

    public boolean hasValue(BigInteger bigInteger) {
        return bigInteger != null && intValue(this.bytes, this.start, -1) == bigInteger.intValue() && getValue().equals(bigInteger);
    }

    public ASN1Integer(byte[] bArr, boolean z) {
        if (isMalformed(bArr)) {
            throw new IllegalArgumentException("malformed integer");
        }
        this.bytes = z ? Arrays.clone(bArr) : bArr;
        this.start = signBytesToSkip(bArr);
    }

    public static ASN1Integer getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return (ASN1Integer) TYPE.getContextTagged(aSN1TaggedObject, z);
    }
}
