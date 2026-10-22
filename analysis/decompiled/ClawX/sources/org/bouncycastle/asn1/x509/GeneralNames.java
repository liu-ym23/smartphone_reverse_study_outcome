package org.bouncycastle.asn1.x509;

import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.util.Strings;

/* loaded from: classes.dex */
public class GeneralNames extends ASN1Object {
    private final GeneralName[] names;

    private GeneralNames(ASN1Sequence aSN1Sequence) {
        this.names = new GeneralName[aSN1Sequence.size()];
        for (int i8 = 0; i8 != aSN1Sequence.size(); i8++) {
            this.names[i8] = GeneralName.getInstance(aSN1Sequence.getObjectAt(i8));
        }
    }

    private static GeneralName[] copy(GeneralName[] generalNameArr) {
        GeneralName[] generalNameArr2 = new GeneralName[generalNameArr.length];
        System.arraycopy(generalNameArr, 0, generalNameArr2, 0, generalNameArr.length);
        return generalNameArr2;
    }

    public static GeneralNames fromExtensions(Extensions extensions, ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return getInstance(Extensions.getExtensionParsedValue(extensions, aSN1ObjectIdentifier));
    }

    public static GeneralNames getInstance(Object obj) {
        if (obj instanceof GeneralNames) {
            return (GeneralNames) obj;
        }
        if (obj != null) {
            return new GeneralNames(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public GeneralName[] getNames() {
        return copy(this.names);
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(this.names);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GeneralNames:");
        String strLineSeparator = Strings.lineSeparator();
        sb.append(strLineSeparator);
        for (int i8 = 0; i8 != this.names.length; i8++) {
            sb.append("    ");
            sb.append(this.names[i8]);
            sb.append(strLineSeparator);
        }
        return sb.toString();
    }

    public GeneralNames(GeneralName generalName) {
        this.names = new GeneralName[]{generalName};
    }

    public static GeneralNames getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return new GeneralNames(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public GeneralNames(GeneralName[] generalNameArr) {
        this.names = copy(generalNameArr);
    }
}
