package org.bouncycastle.asn1.x509;

import a8.b;
import java.io.IOException;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1GeneralizedTime;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1UTCTime;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x500.X500Name;

/* loaded from: classes.dex */
public class V2TBSCertListGenerator {
    private static final ASN1Sequence[] reasons = {createReasonExtension(0), createReasonExtension(1), createReasonExtension(2), createReasonExtension(3), createReasonExtension(4), createReasonExtension(5), createReasonExtension(6), createReasonExtension(7), createReasonExtension(8), createReasonExtension(9), createReasonExtension(10)};
    private X500Name issuer;
    private AlgorithmIdentifier signature;
    private Time thisUpdate;
    private ASN1Integer version = new ASN1Integer(1);
    private Time nextUpdate = null;
    private Extensions extensions = null;
    private ASN1EncodableVector crlentries = new ASN1EncodableVector();

    private static ASN1Sequence createInvalidityDateExtension(ASN1GeneralizedTime aSN1GeneralizedTime) {
        try {
            return new DERSequence(Extension.invalidityDate, new DEROctetString(aSN1GeneralizedTime.getEncoded()));
        } catch (IOException e9) {
            throw new IllegalArgumentException("error encoding reason: " + e9);
        }
    }

    private static ASN1Sequence createReasonExtension(int i8) {
        try {
            return new DERSequence(Extension.reasonCode, new DEROctetString(CRLReason.lookup(i8).getEncoded()));
        } catch (IOException e9) {
            throw new IllegalArgumentException("error encoding reason: " + e9);
        }
    }

    private ASN1Sequence generateTBSCertStructure() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(7);
        aSN1EncodableVector.add(this.version);
        AlgorithmIdentifier algorithmIdentifier = this.signature;
        if (algorithmIdentifier != null) {
            aSN1EncodableVector.add(algorithmIdentifier);
        }
        aSN1EncodableVector.add(this.issuer);
        aSN1EncodableVector.add(this.thisUpdate);
        Time time = this.nextUpdate;
        if (time != null) {
            aSN1EncodableVector.add(time);
        }
        if (this.crlentries.size() != 0) {
            aSN1EncodableVector.add(new DERSequence(this.crlentries));
        }
        Extensions extensions = this.extensions;
        if (extensions != null) {
            aSN1EncodableVector.add(new DERTaggedObject(0, extensions));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    private void internalAddCRLEntry(ASN1Integer aSN1Integer, Time time, ASN1Sequence aSN1Sequence) {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(3);
        aSN1EncodableVector.add(aSN1Integer);
        aSN1EncodableVector.add(time);
        if (aSN1Sequence != null) {
            aSN1EncodableVector.add(aSN1Sequence);
        }
        addCRLEntry(new DERSequence(aSN1EncodableVector));
    }

    public void addCRLEntry(ASN1Integer aSN1Integer, ASN1UTCTime aSN1UTCTime, int i8) {
        addCRLEntry(aSN1Integer, new Time(aSN1UTCTime), i8);
    }

    public ASN1Sequence generatePreTBSCertList() {
        if (this.signature != null) {
            throw new IllegalStateException("signature should not be set in PreTBSCertList generator");
        }
        if (this.issuer == null || this.thisUpdate == null) {
            throw new IllegalStateException("not all mandatory fields set in V2 PreTBSCertList generator");
        }
        return generateTBSCertStructure();
    }

    public TBSCertList generateTBSCertList() {
        if (this.signature == null || this.issuer == null || this.thisUpdate == null) {
            throw new IllegalStateException("not all mandatory fields set in V2 TBSCertList generator");
        }
        return new TBSCertList(generateTBSCertStructure());
    }

    public void setExtensions(Extensions extensions) {
        this.extensions = extensions;
    }

    public void setIssuer(X500Name x500Name) {
        this.issuer = x500Name;
    }

    public void setNextUpdate(ASN1UTCTime aSN1UTCTime) {
        this.nextUpdate = new Time(aSN1UTCTime);
    }

    public void setSignature(AlgorithmIdentifier algorithmIdentifier) {
        this.signature = algorithmIdentifier;
    }

    public void setThisUpdate(ASN1UTCTime aSN1UTCTime) {
        this.thisUpdate = new Time(aSN1UTCTime);
    }

    public void addCRLEntry(ASN1Integer aSN1Integer, Time time, int i8) {
        addCRLEntry(aSN1Integer, time, i8, null);
    }

    @Deprecated
    public void setExtensions(X509Extensions x509Extensions) {
        setExtensions(Extensions.getInstance(x509Extensions));
    }

    public void setIssuer(X509Name x509Name) {
        this.issuer = X500Name.getInstance(x509Name.toASN1Primitive());
    }

    public void setNextUpdate(Time time) {
        this.nextUpdate = time;
    }

    public void setThisUpdate(Time time) {
        this.thisUpdate = time;
    }

    public void addCRLEntry(ASN1Integer aSN1Integer, Time time, int i8, ASN1GeneralizedTime aSN1GeneralizedTime) {
        if (i8 == 0) {
            if (aSN1GeneralizedTime != null) {
                internalAddCRLEntry(aSN1Integer, time, new DERSequence(createInvalidityDateExtension(aSN1GeneralizedTime)));
                return;
            } else {
                addCRLEntry(aSN1Integer, time, (Extensions) null);
                return;
            }
        }
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(2);
        ASN1Sequence[] aSN1SequenceArr = reasons;
        if (i8 >= aSN1SequenceArr.length) {
            aSN1EncodableVector.add(createReasonExtension(i8));
        } else {
            if (i8 < 0) {
                throw new IllegalArgumentException(b.j(i8, "invalid reason value: "));
            }
            aSN1EncodableVector.add(aSN1SequenceArr[i8]);
        }
        if (aSN1GeneralizedTime != null) {
            aSN1EncodableVector.add(createInvalidityDateExtension(aSN1GeneralizedTime));
        }
        internalAddCRLEntry(aSN1Integer, time, new DERSequence(aSN1EncodableVector));
    }

    public void addCRLEntry(ASN1Integer aSN1Integer, Time time, Extensions extensions) {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(3);
        aSN1EncodableVector.add(aSN1Integer);
        aSN1EncodableVector.add(time);
        if (extensions != null) {
            aSN1EncodableVector.add(extensions);
        }
        addCRLEntry(new DERSequence(aSN1EncodableVector));
    }

    public void addCRLEntry(ASN1Sequence aSN1Sequence) {
        this.crlentries.add(aSN1Sequence);
    }
}
