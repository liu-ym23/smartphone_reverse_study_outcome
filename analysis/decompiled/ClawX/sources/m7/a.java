package m7;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

/* loaded from: classes.dex */
public final class a extends ASN1Object {
    public ASN1Integer d;

    /* renamed from: e, reason: collision with root package name */
    public ASN1Integer f3931e;

    public static a f(ASN1Encodable aSN1Encodable) {
        if (aSN1Encodable instanceof a) {
            return (a) aSN1Encodable;
        }
        if (aSN1Encodable == null) {
            return null;
        }
        ASN1Sequence aSN1Sequence = ASN1Sequence.getInstance(aSN1Encodable);
        a aVar = new a();
        Enumeration objects = aSN1Sequence.getObjects();
        aVar.d = (ASN1Integer) objects.nextElement();
        aVar.f3931e = (ASN1Integer) objects.nextElement();
        return aVar;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public final ASN1Primitive toASN1Primitive() {
        return new DERSequence(this.d, this.f3931e);
    }
}
