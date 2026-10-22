package co.nstant.in.cbor.decoder;

import co.nstant.in.cbor.CborDecoder;
import co.nstant.in.cbor.CborException;
import co.nstant.in.cbor.model.DoublePrecisionFloat;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class DoublePrecisionFloatDecoder extends AbstractDecoder<DoublePrecisionFloat> {
    @Override // co.nstant.in.cbor.decoder.AbstractDecoder
    public /* bridge */ /* synthetic */ DoublePrecisionFloat decode(int r1) throws CborException {
        return decode(r1);
    }

    public DoublePrecisionFloatDecoder(CborDecoder decoder, InputStream inputStream) {
        super(decoder, inputStream);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // co.nstant.in.cbor.decoder.AbstractDecoder
    public DoublePrecisionFloat decode(int initialByte) throws CborException {
        long bits = 0 | ((long) (nextSymbol() & 255));
        return new DoublePrecisionFloat(Double.longBitsToDouble((((((((((((((bits << 8) | ((long) (nextSymbol() & 255))) << 8) | ((long) (nextSymbol() & 255))) << 8) | ((long) (nextSymbol() & 255))) << 8) | ((long) (nextSymbol() & 255))) << 8) | ((long) (nextSymbol() & 255))) << 8) | ((long) (nextSymbol() & 255))) << 8) | ((long) (nextSymbol() & 255))));
    }
}
