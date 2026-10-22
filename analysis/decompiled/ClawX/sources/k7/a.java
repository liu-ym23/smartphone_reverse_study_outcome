package k7;

import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DERSequence;

/* loaded from: classes.dex */
public final class a extends ASN1Object {
    public ASN1Integer d;

    /* renamed from: e, reason: collision with root package name */
    public ASN1OctetString f3658e;

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public final ASN1Primitive toASN1Primitive() {
        return new DERSequence(this.f3658e, this.d);
    }
}
