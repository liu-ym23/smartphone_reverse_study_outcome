package g7;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;

/* loaded from: classes.dex */
public final class b extends ASN1Object {
    public byte[] d;

    /* renamed from: e, reason: collision with root package name */
    public int f2995e;

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public final ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(2);
        aSN1EncodableVector.add(new DEROctetString(this.d));
        int i8 = this.f2995e;
        if (i8 != 12) {
            aSN1EncodableVector.add(new ASN1Integer(i8));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
