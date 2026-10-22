package org.bouncycastle.asn1;

import java.io.IOException;
import java.io.InputStream;
import m0.f;

@Deprecated
/* loaded from: classes.dex */
public class DEROctetStringParser implements ASN1OctetStringParser {
    private DefiniteLengthInputStream stream;

    public DEROctetStringParser(DefiniteLengthInputStream definiteLengthInputStream) {
        this.stream = definiteLengthInputStream;
    }

    @Override // org.bouncycastle.asn1.InMemoryRepresentable
    public ASN1Primitive getLoadedObject() {
        return new DEROctetString(this.stream.toByteArray());
    }

    @Override // org.bouncycastle.asn1.ASN1OctetStringParser
    public InputStream getOctetStream() {
        return this.stream;
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        try {
            return getLoadedObject();
        } catch (IOException e9) {
            throw new ASN1ParsingException(f.a(e9, new StringBuilder("IOException converting stream to byte array: ")), e9);
        }
    }
}
