package org.bouncycastle.asn1.x500;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSet;

/* loaded from: classes.dex */
public class RDN extends ASN1Object {
    private ASN1Set values;

    public RDN(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Encodable aSN1Encodable) {
        this(new AttributeTypeAndValue(aSN1ObjectIdentifier, aSN1Encodable));
    }

    public static RDN getInstance(Object obj) {
        if (obj instanceof RDN) {
            return (RDN) obj;
        }
        if (obj != null) {
            return new RDN(ASN1Set.getInstance(obj));
        }
        return null;
    }

    public int collectAttributeTypes(ASN1ObjectIdentifier[] aSN1ObjectIdentifierArr, int i8) {
        int size = this.values.size();
        for (int i9 = 0; i9 < size; i9++) {
            aSN1ObjectIdentifierArr[i8 + i9] = AttributeTypeAndValue.getInstance(this.values.getObjectAt(i9)).getType();
        }
        return size;
    }

    public boolean containsAttributeType(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        int size = this.values.size();
        for (int i8 = 0; i8 < size; i8++) {
            if (AttributeTypeAndValue.getInstance(this.values.getObjectAt(i8)).getType().equals((ASN1Primitive) aSN1ObjectIdentifier)) {
                return true;
            }
        }
        return false;
    }

    public AttributeTypeAndValue getFirst() {
        if (this.values.size() == 0) {
            return null;
        }
        return AttributeTypeAndValue.getInstance(this.values.getObjectAt(0));
    }

    public AttributeTypeAndValue[] getTypesAndValues() {
        int size = this.values.size();
        AttributeTypeAndValue[] attributeTypeAndValueArr = new AttributeTypeAndValue[size];
        for (int i8 = 0; i8 != size; i8++) {
            attributeTypeAndValueArr[i8] = AttributeTypeAndValue.getInstance(this.values.getObjectAt(i8));
        }
        return attributeTypeAndValueArr;
    }

    public boolean isMultiValued() {
        return this.values.size() > 1;
    }

    public int size() {
        return this.values.size();
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.values;
    }

    private RDN(ASN1Set aSN1Set) {
        this.values = aSN1Set;
    }

    public static RDN getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return new RDN(ASN1Set.getInstance(aSN1TaggedObject, z));
    }

    public RDN(AttributeTypeAndValue attributeTypeAndValue) {
        this.values = new DERSet(attributeTypeAndValue);
    }

    public RDN(AttributeTypeAndValue[] attributeTypeAndValueArr) {
        this.values = new DERSet(attributeTypeAndValueArr);
    }
}
