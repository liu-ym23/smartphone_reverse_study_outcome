package org.bouncycastle.asn1;

import java.io.IOException;
import m0.f;

/* loaded from: classes.dex */
public class ASN1Boolean extends ASN1Primitive {
    private static final byte FALSE_VALUE = 0;
    private final byte value;
    static final ASN1UniversalType TYPE = new ASN1UniversalType(ASN1Boolean.class, 1) { // from class: org.bouncycastle.asn1.ASN1Boolean.1
        @Override // org.bouncycastle.asn1.ASN1UniversalType
        public ASN1Primitive fromImplicitPrimitive(DEROctetString dEROctetString) {
            return ASN1Boolean.createPrimitive(dEROctetString.getOctets());
        }
    };
    public static final ASN1Boolean FALSE = new ASN1Boolean((byte) 0);
    private static final byte TRUE_VALUE = -1;
    public static final ASN1Boolean TRUE = new ASN1Boolean(TRUE_VALUE);

    private ASN1Boolean(byte b9) {
        this.value = b9;
    }

    public static ASN1Boolean createPrimitive(byte[] bArr) {
        if (bArr.length != 1) {
            throw new IllegalArgumentException("BOOLEAN value should have 1 byte in it");
        }
        byte b9 = bArr[0];
        return b9 != -1 ? b9 != 0 ? new ASN1Boolean(b9) : FALSE : TRUE;
    }

    public static ASN1Boolean getInstance(int i8) {
        return i8 != 0 ? TRUE : FALSE;
    }

    public static ASN1Boolean getTagged(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return (ASN1Boolean) TYPE.getTagged(aSN1TaggedObject, z);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        return (aSN1Primitive instanceof ASN1Boolean) && isTrue() == ((ASN1Boolean) aSN1Primitive).isTrue();
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public void encode(ASN1OutputStream aSN1OutputStream, boolean z) throws IOException {
        aSN1OutputStream.writeEncodingDL(z, 1, this.value);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public boolean encodeConstructed() {
        return false;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public int encodedLength(boolean z) {
        return ASN1OutputStream.getLengthOfEncodingDL(z, 1);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive, org.bouncycastle.asn1.ASN1Object
    public int hashCode() {
        return isTrue() ? 1 : 0;
    }

    public boolean isTrue() {
        return this.value != 0;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public ASN1Primitive toDERObject() {
        return isTrue() ? TRUE : FALSE;
    }

    public String toString() {
        return isTrue() ? "TRUE" : "FALSE";
    }

    public static ASN1Boolean getInstance(Object obj) {
        if (obj == null || (obj instanceof ASN1Boolean)) {
            return (ASN1Boolean) obj;
        }
        if (!(obj instanceof byte[])) {
            throw new IllegalArgumentException(f.b(obj, "illegal object in getInstance: "));
        }
        try {
            return (ASN1Boolean) TYPE.fromByteArray((byte[]) obj);
        } catch (IOException e9) {
            throw new IllegalArgumentException(f.a(e9, new StringBuilder("failed to construct boolean from byte[]: ")));
        }
    }

    public static ASN1Boolean getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return (ASN1Boolean) TYPE.getContextTagged(aSN1TaggedObject, z);
    }

    public static ASN1Boolean getInstance(boolean z) {
        return z ? TRUE : FALSE;
    }
}
