package org.bouncycastle.asn1.x9;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.util.Arrays;
import p7.d0;
import p7.h;
import p7.r;
import w7.a;
import w7.d;

/* loaded from: classes.dex */
public class X9ECParameters extends ASN1Object implements X9ObjectIdentifiers {
    private static final BigInteger ONE = BigInteger.valueOf(1);
    private X9Curve curve;
    private X9FieldID fieldID;

    /* renamed from: g, reason: collision with root package name */
    private X9ECPoint f4368g;

    /* renamed from: h, reason: collision with root package name */
    private BigInteger f4369h;

    /* renamed from: n, reason: collision with root package name */
    private BigInteger f4370n;

    private X9ECParameters(ASN1Sequence aSN1Sequence) {
        if (!(aSN1Sequence.getObjectAt(0) instanceof ASN1Integer) || !((ASN1Integer) aSN1Sequence.getObjectAt(0)).hasValue(1)) {
            throw new IllegalArgumentException("bad version in X9ECParameters");
        }
        this.f4370n = ((ASN1Integer) aSN1Sequence.getObjectAt(4)).getValue();
        if (aSN1Sequence.size() == 6) {
            this.f4369h = ((ASN1Integer) aSN1Sequence.getObjectAt(5)).getValue();
        }
        X9FieldID x9FieldID = X9FieldID.getInstance(aSN1Sequence.getObjectAt(1));
        this.fieldID = x9FieldID;
        this.curve = new X9Curve(x9FieldID, this.f4370n, this.f4369h, ASN1Sequence.getInstance(aSN1Sequence.getObjectAt(2)));
        ASN1Encodable objectAt = aSN1Sequence.getObjectAt(3);
        if (objectAt instanceof X9ECPoint) {
            this.f4368g = (X9ECPoint) objectAt;
        } else {
            this.f4368g = new X9ECPoint(this.curve.getCurve(), (ASN1OctetString) objectAt);
        }
    }

    public static X9ECParameters getInstance(Object obj) {
        if (obj instanceof X9ECParameters) {
            return (X9ECParameters) obj;
        }
        if (obj != null) {
            return new X9ECParameters(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public X9ECPoint getBaseEntry() {
        return this.f4368g;
    }

    public h getCurve() {
        return this.curve.getCurve();
    }

    public X9Curve getCurveEntry() {
        return this.curve;
    }

    public X9FieldID getFieldIDEntry() {
        return this.fieldID;
    }

    public r getG() {
        return this.f4368g.getPoint();
    }

    public BigInteger getH() {
        return this.f4369h;
    }

    public BigInteger getN() {
        return this.f4370n;
    }

    public byte[] getSeed() {
        return this.curve.getSeed();
    }

    public boolean hasSeed() {
        return this.curve.hasSeed();
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(6);
        aSN1EncodableVector.add(new ASN1Integer(ONE));
        aSN1EncodableVector.add(this.fieldID);
        aSN1EncodableVector.add(this.curve);
        aSN1EncodableVector.add(this.f4368g);
        aSN1EncodableVector.add(new ASN1Integer(this.f4370n));
        if (this.f4369h != null) {
            aSN1EncodableVector.add(new ASN1Integer(this.f4369h));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public X9ECParameters(h hVar, X9ECPoint x9ECPoint, BigInteger bigInteger) {
        this(hVar, x9ECPoint, bigInteger, null, null);
    }

    public X9ECParameters(h hVar, X9ECPoint x9ECPoint, BigInteger bigInteger, BigInteger bigInteger2) {
        this(hVar, x9ECPoint, bigInteger, bigInteger2, null);
    }

    public X9ECParameters(h hVar, X9ECPoint x9ECPoint, BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr) {
        X9FieldID x9FieldID;
        this.curve = new X9Curve(hVar, bArr);
        this.f4368g = x9ECPoint;
        this.f4370n = bigInteger;
        this.f4369h = bigInteger2;
        a aVar = hVar.f4797a;
        if (aVar.a() == 1) {
            x9FieldID = new X9FieldID(aVar.b());
        } else {
            if (!d0.j(aVar)) {
                throw new IllegalArgumentException("'curve' is of an unsupported type");
            }
            int[] iArrClone = Arrays.clone(((d) aVar).f6228b.f6226a);
            if (iArrClone.length == 3) {
                x9FieldID = new X9FieldID(iArrClone[2], iArrClone[1]);
            } else {
                if (iArrClone.length != 5) {
                    throw new IllegalArgumentException("Only trinomial and pentomial curves are supported");
                }
                x9FieldID = new X9FieldID(iArrClone[4], iArrClone[1], iArrClone[2], iArrClone[3]);
            }
        }
        this.fieldID = x9FieldID;
    }
}
