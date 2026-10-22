package org.bouncycastle.asn1;

import java.io.IOException;
import java.io.InputStream;
import m0.f;
import org.bouncycastle.util.io.Streams;

@Deprecated
/* loaded from: classes.dex */
public class BEROctetStringParser implements ASN1OctetStringParser {
    private ASN1StreamParser _parser;

    public BEROctetStringParser(ASN1StreamParser aSN1StreamParser) {
        this._parser = aSN1StreamParser;
    }

    public static BEROctetString parse(ASN1StreamParser aSN1StreamParser) {
        return new BEROctetString(Streams.readAll(new ConstructedOctetStream(aSN1StreamParser)));
    }

    @Override // org.bouncycastle.asn1.InMemoryRepresentable
    public ASN1Primitive getLoadedObject() {
        return parse(this._parser);
    }

    @Override // org.bouncycastle.asn1.ASN1OctetStringParser
    public InputStream getOctetStream() {
        return new ConstructedOctetStream(this._parser);
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
