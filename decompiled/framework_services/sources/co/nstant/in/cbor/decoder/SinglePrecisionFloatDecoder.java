package co.nstant.in.cbor.decoder;

import co.nstant.in.cbor.CborDecoder;
import co.nstant.in.cbor.CborException;
import co.nstant.in.cbor.model.SinglePrecisionFloat;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class SinglePrecisionFloatDecoder extends AbstractDecoder<SinglePrecisionFloat> {
    @Override // co.nstant.in.cbor.decoder.AbstractDecoder
    public /* bridge */ /* synthetic */ SinglePrecisionFloat decode(int r1) throws CborException {
        return decode(r1);
    }

    public SinglePrecisionFloatDecoder(CborDecoder decoder, InputStream inputStream) {
        super(decoder, inputStream);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // co.nstant.in.cbor.decoder.AbstractDecoder
    public SinglePrecisionFloat decode(int initialByte) throws CborException {
        int bits = 0 | (nextSymbol() & 255);
        return new SinglePrecisionFloat(Float.intBitsToFloat((((((bits << 8) | (nextSymbol() & 255)) << 8) | (nextSymbol() & 255)) << 8) | (nextSymbol() & 255)));
    }
}
