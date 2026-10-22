package org.bouncycastle.asn1.x509;

import java.math.BigInteger;
import java.util.Enumeration;
import m0.f;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;

/* loaded from: classes.dex */
public class DSAParameter extends ASN1Object {

    /* renamed from: g, reason: collision with root package name */
    ASN1Integer f4357g;

    /* renamed from: p, reason: collision with root package name */
    ASN1Integer f4358p;

    /* renamed from: q, reason: collision with root package name */
    ASN1Integer f4359q;

    public DSAParameter(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this.f4358p = new ASN1Integer(bigInteger);
        this.f4359q = new ASN1Integer(bigInteger2);
        this.f4357g = new ASN1Integer(bigInteger3);
    }

    public static DSAParameter getInstance(Object obj) {
        if (obj instanceof DSAParameter) {
            return (DSAParameter) obj;
        }
        if (obj != null) {
            return new DSAParameter(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public BigInteger getG() {
        return this.f4357g.getPositiveValue();
    }

    public BigInteger getP() {
        return this.f4358p.getPositiveValue();
    }

    public BigInteger getQ() {
        return this.f4359q.getPositiveValue();
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(3);
        aSN1EncodableVector.add(this.f4358p);
        aSN1EncodableVector.add(this.f4359q);
        aSN1EncodableVector.add(this.f4357g);
        return new DERSequence(aSN1EncodableVector);
    }

    private DSAParameter(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() != 3) {
            throw new IllegalArgumentException(f.g(aSN1Sequence, new StringBuilder("Bad sequence size: ")));
        }
        Enumeration objects = aSN1Sequence.getObjects();
        this.f4358p = ASN1Integer.getInstance(objects.nextElement());
        this.f4359q = ASN1Integer.getInstance(objects.nextElement());
        this.f4357g = ASN1Integer.getInstance(objects.nextElement());
    }

    public static DSAParameter getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }
}
