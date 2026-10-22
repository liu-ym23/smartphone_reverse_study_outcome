package org.bouncycastle.asn1.ua;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.util.Arrays;
import p7.d0;
import p7.h;
import w7.d;

/* loaded from: classes.dex */
public class DSTU4145ECBinary extends ASN1Object {

    /* renamed from: a, reason: collision with root package name */
    ASN1Integer f4350a;

    /* renamed from: b, reason: collision with root package name */
    ASN1OctetString f4351b;
    ASN1OctetString bp;

    /* renamed from: f, reason: collision with root package name */
    DSTU4145BinaryField f4352f;

    /* renamed from: n, reason: collision with root package name */
    ASN1Integer f4353n;
    BigInteger version;

    private DSTU4145ECBinary(ASN1Sequence aSN1Sequence) {
        this.version = BigInteger.valueOf(0L);
        int i8 = 0;
        if (aSN1Sequence.getObjectAt(0) instanceof ASN1TaggedObject) {
            ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) aSN1Sequence.getObjectAt(0);
            if (!aSN1TaggedObject.isExplicit() || aSN1TaggedObject.getTagNo() != 0) {
                throw new IllegalArgumentException("object parse error");
            }
            this.version = ASN1Integer.getInstance(aSN1TaggedObject.getLoadedObject()).getValue();
            i8 = 1;
        }
        this.f4352f = DSTU4145BinaryField.getInstance(aSN1Sequence.getObjectAt(i8));
        this.f4350a = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(i8 + 1));
        this.f4351b = ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(i8 + 2));
        this.f4353n = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(i8 + 3));
        this.bp = ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(i8 + 4));
    }

    public static DSTU4145ECBinary getInstance(Object obj) {
        if (obj instanceof DSTU4145ECBinary) {
            return (DSTU4145ECBinary) obj;
        }
        if (obj != null) {
            return new DSTU4145ECBinary(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public BigInteger getA() {
        return this.f4350a.getValue();
    }

    public byte[] getB() {
        return Arrays.clone(this.f4351b.getOctets());
    }

    public DSTU4145BinaryField getField() {
        return this.f4352f;
    }

    public byte[] getG() {
        return Arrays.clone(this.bp.getOctets());
    }

    public BigInteger getN() {
        return this.f4353n.getValue();
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(6);
        if (this.version.compareTo(BigInteger.valueOf(0L)) != 0) {
            aSN1EncodableVector.add(new DERTaggedObject(true, 0, (ASN1Encodable) new ASN1Integer(this.version)));
        }
        aSN1EncodableVector.add(this.f4352f);
        aSN1EncodableVector.add(this.f4350a);
        aSN1EncodableVector.add(this.f4351b);
        aSN1EncodableVector.add(this.f4353n);
        aSN1EncodableVector.add(this.bp);
        return new DERSequence(aSN1EncodableVector);
    }

    public DSTU4145ECBinary(ECDomainParameters eCDomainParameters) {
        DSTU4145BinaryField dSTU4145BinaryField;
        this.version = BigInteger.valueOf(0L);
        h curve = eCDomainParameters.getCurve();
        if (!d0.j(curve.f4797a)) {
            throw new IllegalArgumentException("only binary domain is possible");
        }
        int[] iArrClone = Arrays.clone(((d) curve.f4797a).f6228b.f6226a);
        if (iArrClone.length == 3) {
            dSTU4145BinaryField = new DSTU4145BinaryField(iArrClone[2], iArrClone[1]);
        } else {
            if (iArrClone.length != 5) {
                throw new IllegalArgumentException("curve must have a trinomial or pentanomial basis");
            }
            dSTU4145BinaryField = new DSTU4145BinaryField(iArrClone[4], iArrClone[1], iArrClone[2], iArrClone[3]);
        }
        this.f4352f = dSTU4145BinaryField;
        this.f4350a = new ASN1Integer(curve.f4798b.t());
        this.f4351b = new DEROctetString(curve.f4799c.e());
        this.f4353n = new ASN1Integer(eCDomainParameters.getN());
        this.bp = new DEROctetString(DSTU4145PointEncoder.encodePoint(eCDomainParameters.getG()));
    }
}
