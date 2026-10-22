package co.nstant.in.cbor.decoder;

import co.nstant.in.cbor.CborDecoder;
import co.nstant.in.cbor.CborException;
import co.nstant.in.cbor.model.UnsignedInteger;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class UnsignedIntegerDecoder extends AbstractDecoder<UnsignedInteger> {
    @Override // co.nstant.in.cbor.decoder.AbstractDecoder
    public /* bridge */ /* synthetic */ UnsignedInteger decode(int r1) throws CborException {
        return decode(r1);
    }

    public UnsignedIntegerDecoder(CborDecoder decoder, InputStream inputStream) {
        super(decoder, inputStream);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // co.nstant.in.cbor.decoder.AbstractDecoder
    public UnsignedInteger decode(int initialByte) throws CborException {
        return new UnsignedInteger(getLengthAsBigInteger(initialByte));
    }
}
