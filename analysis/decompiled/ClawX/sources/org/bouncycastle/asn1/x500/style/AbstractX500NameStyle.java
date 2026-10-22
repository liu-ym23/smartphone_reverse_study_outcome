package org.bouncycastle.asn1.x500.style;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1ParsingException;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DERUTF8String;
import org.bouncycastle.asn1.x500.AttributeTypeAndValue;
import org.bouncycastle.asn1.x500.RDN;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x500.X500NameStyle;

/* loaded from: classes.dex */
public abstract class AbstractX500NameStyle implements X500NameStyle {
    private int calcHashCode(ASN1Encodable aSN1Encodable) {
        return IETFUtils.canonicalString(aSN1Encodable).hashCode();
    }

    public static Hashtable copyHashTable(Hashtable hashtable) {
        Hashtable hashtable2 = new Hashtable();
        Enumeration enumerationKeys = hashtable.keys();
        while (enumerationKeys.hasMoreElements()) {
            Object objNextElement = enumerationKeys.nextElement();
            hashtable2.put(objNextElement, hashtable.get(objNextElement));
        }
        return hashtable2;
    }

    private boolean foundMatch(boolean z, RDN rdn, RDN[] rdnArr) {
        if (z) {
            for (int length = rdnArr.length - 1; length >= 0; length--) {
                RDN rdn2 = rdnArr[length];
                if (rdn2 != null && rdnAreEqual(rdn, rdn2)) {
                    rdnArr[length] = null;
                    return true;
                }
            }
        } else {
            for (int i8 = 0; i8 != rdnArr.length; i8++) {
                RDN rdn3 = rdnArr[i8];
                if (rdn3 != null && rdnAreEqual(rdn, rdn3)) {
                    rdnArr[i8] = null;
                    return true;
                }
            }
        }
        return false;
    }

    @Override // org.bouncycastle.asn1.x500.X500NameStyle
    public boolean areEqual(X500Name x500Name, X500Name x500Name2) {
        if (x500Name.size() != x500Name2.size()) {
            return false;
        }
        RDN[] rDNs = x500Name.getRDNs();
        RDN[] rDNs2 = x500Name2.getRDNs();
        boolean z = (rDNs[0].getFirst() == null || rDNs2[0].getFirst() == null) ? false : !r0.getType().equals((ASN1Primitive) r1.getType());
        for (int i8 = 0; i8 != rDNs.length; i8++) {
            if (!foundMatch(z, rDNs[i8], rDNs2)) {
                return false;
            }
        }
        return true;
    }

    @Override // org.bouncycastle.asn1.x500.X500NameStyle
    public int calculateHashCode(X500Name x500Name) {
        RDN[] rDNs = x500Name.getRDNs();
        int iHashCode = 0;
        for (int i8 = 0; i8 != rDNs.length; i8++) {
            if (rDNs[i8].isMultiValued()) {
                AttributeTypeAndValue[] typesAndValues = rDNs[i8].getTypesAndValues();
                for (int i9 = 0; i9 != typesAndValues.length; i9++) {
                    iHashCode = (iHashCode ^ typesAndValues[i9].getType().hashCode()) ^ calcHashCode(typesAndValues[i9].getValue());
                }
            } else {
                iHashCode = (iHashCode ^ rDNs[i8].getFirst().getType().hashCode()) ^ calcHashCode(rDNs[i8].getFirst().getValue());
            }
        }
        return iHashCode;
    }

    public ASN1Encodable encodeStringValue(ASN1ObjectIdentifier aSN1ObjectIdentifier, String str) {
        return new DERUTF8String(str);
    }

    public boolean rdnAreEqual(RDN rdn, RDN rdn2) {
        return IETFUtils.rDNAreEqual(rdn, rdn2);
    }

    @Override // org.bouncycastle.asn1.x500.X500NameStyle
    public ASN1Encodable stringToValue(ASN1ObjectIdentifier aSN1ObjectIdentifier, String str) {
        if (str.length() == 0 || str.charAt(0) != '#') {
            if (str.length() != 0 && str.charAt(0) == '\\') {
                str = str.substring(1);
            }
            return encodeStringValue(aSN1ObjectIdentifier, str);
        }
        try {
            return IETFUtils.valueFromHexString(str, 1);
        } catch (IOException unused) {
            throw new ASN1ParsingException("can't recode value for oid " + aSN1ObjectIdentifier.getId());
        }
    }
}
