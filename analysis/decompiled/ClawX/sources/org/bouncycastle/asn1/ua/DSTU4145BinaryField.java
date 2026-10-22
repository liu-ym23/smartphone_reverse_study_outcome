package org.bouncycastle.asn1.ua;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

/* loaded from: classes.dex */
public class DSTU4145BinaryField extends ASN1Object {

    /* renamed from: j, reason: collision with root package name */
    private int f4346j;

    /* renamed from: k, reason: collision with root package name */
    private int f4347k;

    /* renamed from: l, reason: collision with root package name */
    private int f4348l;

    /* renamed from: m, reason: collision with root package name */
    private int f4349m;

    public DSTU4145BinaryField(int i8, int i9) {
        this(i8, i9, 0, 0);
    }

    public static DSTU4145BinaryField getInstance(Object obj) {
        if (obj instanceof DSTU4145BinaryField) {
            return (DSTU4145BinaryField) obj;
        }
        if (obj != null) {
            return new DSTU4145BinaryField(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public int getK1() {
        return this.f4347k;
    }

    public int getK2() {
        return this.f4346j;
    }

    public int getK3() {
        return this.f4348l;
    }

    public int getM() {
        return this.f4349m;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(2);
        aSN1EncodableVector.add(new ASN1Integer(this.f4349m));
        if (this.f4346j == 0) {
            aSN1EncodableVector.add(new ASN1Integer(this.f4347k));
        } else {
            ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector(3);
            aSN1EncodableVector2.add(new ASN1Integer(this.f4347k));
            aSN1EncodableVector2.add(new ASN1Integer(this.f4346j));
            aSN1EncodableVector2.add(new ASN1Integer(this.f4348l));
            aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector2));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public DSTU4145BinaryField(int i8, int i9, int i10, int i11) {
        this.f4349m = i8;
        this.f4347k = i9;
        this.f4346j = i10;
        this.f4348l = i11;
    }

    private DSTU4145BinaryField(ASN1Sequence aSN1Sequence) {
        this.f4349m = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(0)).intPositiveValueExact();
        if (aSN1Sequence.getObjectAt(1) instanceof ASN1Integer) {
            this.f4347k = ((ASN1Integer) aSN1Sequence.getObjectAt(1)).intPositiveValueExact();
        } else {
            if (!(aSN1Sequence.getObjectAt(1) instanceof ASN1Sequence)) {
                throw new IllegalArgumentException("object parse error");
            }
            ASN1Sequence aSN1Sequence2 = ASN1Sequence.getInstance(aSN1Sequence.getObjectAt(1));
            this.f4347k = ASN1Integer.getInstance(aSN1Sequence2.getObjectAt(0)).intPositiveValueExact();
            this.f4346j = ASN1Integer.getInstance(aSN1Sequence2.getObjectAt(1)).intPositiveValueExact();
            this.f4348l = ASN1Integer.getInstance(aSN1Sequence2.getObjectAt(2)).intPositiveValueExact();
        }
    }
}
