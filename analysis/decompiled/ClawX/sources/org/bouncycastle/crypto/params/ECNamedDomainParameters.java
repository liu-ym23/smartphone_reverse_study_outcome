package org.bouncycastle.crypto.params;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.x9.ECNamedCurveTable;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.crypto.ec.CustomNamedCurves;
import p7.a;
import p7.h;
import p7.r;

/* loaded from: classes.dex */
public class ECNamedDomainParameters extends ECDomainParameters {
    private ASN1ObjectIdentifier name;

    public ECNamedDomainParameters(ASN1ObjectIdentifier aSN1ObjectIdentifier, X9ECParameters x9ECParameters) {
        super(x9ECParameters);
        this.name = aSN1ObjectIdentifier;
    }

    public static ECNamedDomainParameters lookup(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        X9ECParameters byOID = CustomNamedCurves.getByOID(aSN1ObjectIdentifier);
        if (byOID == null) {
            byOID = ECNamedCurveTable.getByOID(aSN1ObjectIdentifier);
        }
        return new ECNamedDomainParameters(aSN1ObjectIdentifier, byOID);
    }

    public ASN1ObjectIdentifier getName() {
        return this.name;
    }

    public ECNamedDomainParameters(ASN1ObjectIdentifier aSN1ObjectIdentifier, ECDomainParameters eCDomainParameters) {
        super(eCDomainParameters.getCurve(), eCDomainParameters.getG(), eCDomainParameters.getN(), eCDomainParameters.getH(), eCDomainParameters.getSeed());
        this.name = aSN1ObjectIdentifier;
    }

    public ECNamedDomainParameters(ASN1ObjectIdentifier aSN1ObjectIdentifier, h hVar, r rVar, BigInteger bigInteger) {
        this(aSN1ObjectIdentifier, hVar, rVar, bigInteger, a.f4758b, null);
    }

    public ECNamedDomainParameters(ASN1ObjectIdentifier aSN1ObjectIdentifier, h hVar, r rVar, BigInteger bigInteger, BigInteger bigInteger2) {
        this(aSN1ObjectIdentifier, hVar, rVar, bigInteger, bigInteger2, null);
    }

    public ECNamedDomainParameters(ASN1ObjectIdentifier aSN1ObjectIdentifier, h hVar, r rVar, BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr) {
        super(hVar, rVar, bigInteger, bigInteger2, bArr);
        this.name = aSN1ObjectIdentifier;
    }
}
