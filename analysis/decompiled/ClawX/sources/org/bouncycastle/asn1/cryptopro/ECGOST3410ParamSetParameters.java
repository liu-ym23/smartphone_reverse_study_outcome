package org.bouncycastle.asn1.cryptopro;

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
public class ECGOST3410ParamSetParameters extends ASN1Object {

    /* renamed from: a, reason: collision with root package name */
    ASN1Integer f4335a;

    /* renamed from: b, reason: collision with root package name */
    ASN1Integer f4336b;

    /* renamed from: p, reason: collision with root package name */
    ASN1Integer f4337p;

    /* renamed from: q, reason: collision with root package name */
    ASN1Integer f4338q;

    /* renamed from: x, reason: collision with root package name */
    ASN1Integer f4339x;
    ASN1Integer y;

    public ECGOST3410ParamSetParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, int i8, BigInteger bigInteger5) {
        this.f4335a = new ASN1Integer(bigInteger);
        this.f4336b = new ASN1Integer(bigInteger2);
        this.f4337p = new ASN1Integer(bigInteger3);
        this.f4338q = new ASN1Integer(bigInteger4);
        this.f4339x = new ASN1Integer(i8);
        this.y = new ASN1Integer(bigInteger5);
    }

    public static ECGOST3410ParamSetParameters getInstance(Object obj) {
        if (obj == null || (obj instanceof ECGOST3410ParamSetParameters)) {
            return (ECGOST3410ParamSetParameters) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new ECGOST3410ParamSetParameters((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException(f.b(obj, "Invalid GOST3410Parameter: "));
    }

    public BigInteger getA() {
        return this.f4335a.getPositiveValue();
    }

    public BigInteger getP() {
        return this.f4337p.getPositiveValue();
    }

    public BigInteger getQ() {
        return this.f4338q.getPositiveValue();
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(6);
        aSN1EncodableVector.add(this.f4335a);
        aSN1EncodableVector.add(this.f4336b);
        aSN1EncodableVector.add(this.f4337p);
        aSN1EncodableVector.add(this.f4338q);
        aSN1EncodableVector.add(this.f4339x);
        aSN1EncodableVector.add(this.y);
        return new DERSequence(aSN1EncodableVector);
    }

    public ECGOST3410ParamSetParameters(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        this.f4335a = (ASN1Integer) objects.nextElement();
        this.f4336b = (ASN1Integer) objects.nextElement();
        this.f4337p = (ASN1Integer) objects.nextElement();
        this.f4338q = (ASN1Integer) objects.nextElement();
        this.f4339x = (ASN1Integer) objects.nextElement();
        this.y = (ASN1Integer) objects.nextElement();
    }

    public static ECGOST3410ParamSetParameters getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }
}
