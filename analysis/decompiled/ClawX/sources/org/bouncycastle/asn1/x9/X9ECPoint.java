package org.bouncycastle.asn1.x9;

import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.util.Arrays;
import p7.h;
import p7.r;

/* loaded from: classes.dex */
public class X9ECPoint extends ASN1Object {

    /* renamed from: c, reason: collision with root package name */
    private h f4371c;
    private final ASN1OctetString encoding;

    /* renamed from: p, reason: collision with root package name */
    private r f4372p;

    public X9ECPoint(h hVar, ASN1OctetString aSN1OctetString) {
        this(hVar, aSN1OctetString.getOctets());
    }

    public synchronized r getPoint() {
        try {
            if (this.f4372p == null) {
                this.f4372p = this.f4371c.g(this.encoding.getOctets()).o();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f4372p;
    }

    public byte[] getPointEncoding() {
        return Arrays.clone(this.encoding.getOctets());
    }

    public boolean isPointCompressed() {
        byte b9;
        byte[] octets = this.encoding.getOctets();
        return octets != null && octets.length > 0 && ((b9 = octets[0]) == 2 || b9 == 3);
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.encoding;
    }

    public X9ECPoint(h hVar, byte[] bArr) {
        this.f4371c = hVar;
        this.encoding = new DEROctetString(Arrays.clone(bArr));
    }

    public X9ECPoint(r rVar, boolean z) {
        this.f4372p = rVar.o();
        this.encoding = new DEROctetString(rVar.g(z));
    }
}
