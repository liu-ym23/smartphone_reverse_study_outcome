package org.bouncycastle.asn1.x9;

import a8.b;
import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.util.Arrays;
import p7.d0;
import p7.f;
import p7.g;
import p7.h;

/* loaded from: classes.dex */
public class X9Curve extends ASN1Object implements X9ObjectIdentifiers {
    private h curve;
    private ASN1ObjectIdentifier fieldIdentifier;
    private byte[] seed;

    public X9Curve(X9FieldID x9FieldID, BigInteger bigInteger, BigInteger bigInteger2, ASN1Sequence aSN1Sequence) {
        int iIntValueExact;
        int iIntValueExact2;
        int i8;
        this.fieldIdentifier = null;
        ASN1ObjectIdentifier identifier = x9FieldID.getIdentifier();
        this.fieldIdentifier = identifier;
        if (identifier.equals((ASN1Primitive) X9ObjectIdentifiers.prime_field)) {
            this.curve = new g(((ASN1Integer) x9FieldID.getParameters()).getValue(), new BigInteger(1, b.B(aSN1Sequence, 0)), new BigInteger(1, b.B(aSN1Sequence, 1)), bigInteger, bigInteger2, false);
        } else {
            if (!this.fieldIdentifier.equals((ASN1Primitive) X9ObjectIdentifiers.characteristic_two_field)) {
                throw new IllegalArgumentException("This type of ECCurve is not implemented");
            }
            ASN1Sequence aSN1Sequence2 = ASN1Sequence.getInstance(x9FieldID.getParameters());
            int iIntValueExact3 = ((ASN1Integer) aSN1Sequence2.getObjectAt(0)).intValueExact();
            ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) aSN1Sequence2.getObjectAt(1);
            if (aSN1ObjectIdentifier.equals((ASN1Primitive) X9ObjectIdentifiers.tpBasis)) {
                iIntValueExact2 = ASN1Integer.getInstance(aSN1Sequence2.getObjectAt(2)).intValueExact();
                i8 = 0;
                iIntValueExact = 0;
            } else {
                if (!aSN1ObjectIdentifier.equals((ASN1Primitive) X9ObjectIdentifiers.ppBasis)) {
                    throw new IllegalArgumentException("This type of EC basis is not implemented");
                }
                ASN1Sequence aSN1Sequence3 = ASN1Sequence.getInstance(aSN1Sequence2.getObjectAt(2));
                int iIntValueExact4 = ASN1Integer.getInstance(aSN1Sequence3.getObjectAt(0)).intValueExact();
                int iIntValueExact5 = ASN1Integer.getInstance(aSN1Sequence3.getObjectAt(1)).intValueExact();
                iIntValueExact = ASN1Integer.getInstance(aSN1Sequence3.getObjectAt(2)).intValueExact();
                iIntValueExact2 = iIntValueExact4;
                i8 = iIntValueExact5;
            }
            this.curve = new f(iIntValueExact3, iIntValueExact2, i8, iIntValueExact, new BigInteger(1, b.B(aSN1Sequence, 0)), new BigInteger(1, b.B(aSN1Sequence, 1)), bigInteger, bigInteger2);
        }
        if (aSN1Sequence.size() == 3) {
            this.seed = ((DERBitString) aSN1Sequence.getObjectAt(2)).getBytes();
        }
    }

    private void setFieldIdentifier() {
        ASN1ObjectIdentifier aSN1ObjectIdentifier;
        if (this.curve.f4797a.a() == 1) {
            aSN1ObjectIdentifier = X9ObjectIdentifiers.prime_field;
        } else {
            if (!d0.j(this.curve.f4797a)) {
                throw new IllegalArgumentException("This type of ECCurve is not implemented");
            }
            aSN1ObjectIdentifier = X9ObjectIdentifiers.characteristic_two_field;
        }
        this.fieldIdentifier = aSN1ObjectIdentifier;
    }

    public h getCurve() {
        return this.curve;
    }

    public byte[] getSeed() {
        return Arrays.clone(this.seed);
    }

    public boolean hasSeed() {
        return this.seed != null;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(3);
        if (this.fieldIdentifier.equals((ASN1Primitive) X9ObjectIdentifiers.prime_field) || this.fieldIdentifier.equals((ASN1Primitive) X9ObjectIdentifiers.characteristic_two_field)) {
            aSN1EncodableVector.add(new X9FieldElement(this.curve.f4798b).toASN1Primitive());
            X9FieldElement x9FieldElement = new X9FieldElement(this.curve.f4799c);
            aSN1EncodableVector.add(x9FieldElement.toASN1Primitive());
        }
        if (this.seed != null) {
            aSN1EncodableVector.add(new DERBitString(this.seed));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public X9Curve(h hVar) {
        this(hVar, null);
    }

    public X9Curve(h hVar, byte[] bArr) {
        this.fieldIdentifier = null;
        this.curve = hVar;
        this.seed = Arrays.clone(bArr);
        setFieldIdentifier();
    }
}
