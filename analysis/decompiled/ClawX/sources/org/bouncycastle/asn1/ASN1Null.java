package org.bouncycastle.asn1;

import java.io.IOException;
import m0.f;

/* loaded from: classes.dex */
public abstract class ASN1Null extends ASN1Primitive {
    static final ASN1UniversalType TYPE = new ASN1UniversalType(ASN1Null.class, 5) { // from class: org.bouncycastle.asn1.ASN1Null.1
        @Override // org.bouncycastle.asn1.ASN1UniversalType
        public ASN1Primitive fromImplicitPrimitive(DEROctetString dEROctetString) {
            ASN1Null.checkContentsLength(dEROctetString.getOctetsLength());
            return ASN1Null.createPrimitive();
        }
    };

    public static void checkContentsLength(int i8) {
        if (i8 != 0) {
            throw new IllegalStateException("malformed NULL encoding encountered");
        }
    }

    public static ASN1Null createPrimitive() {
        return DERNull.INSTANCE;
    }

    public static ASN1Null getInstance(Object obj) {
        if (obj instanceof ASN1Null) {
            return (ASN1Null) obj;
        }
        if (obj == null) {
            return null;
        }
        try {
            return (ASN1Null) TYPE.fromByteArray((byte[]) obj);
        } catch (IOException e9) {
            throw new IllegalArgumentException(f.a(e9, new StringBuilder("failed to construct NULL from byte[]: ")));
        }
    }

    public static ASN1Null getTagged(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return (ASN1Null) TYPE.getTagged(aSN1TaggedObject, z);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        return aSN1Primitive instanceof ASN1Null;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive, org.bouncycastle.asn1.ASN1Object
    public int hashCode() {
        return -1;
    }

    public String toString() {
        return "NULL";
    }

    public static ASN1Null getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return (ASN1Null) TYPE.getContextTagged(aSN1TaggedObject, z);
    }
}
