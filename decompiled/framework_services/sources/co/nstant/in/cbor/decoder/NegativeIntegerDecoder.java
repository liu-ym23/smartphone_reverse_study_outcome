package co.nstant.in.cbor.decoder;

import co.nstant.in.cbor.CborDecoder;
import co.nstant.in.cbor.CborException;
import co.nstant.in.cbor.model.NegativeInteger;
import java.io.InputStream;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes.dex */
public class NegativeIntegerDecoder extends AbstractDecoder<NegativeInteger> {
    private static final BigInteger MINUS_ONE = null;

    @Override // co.nstant.in.cbor.decoder.AbstractDecoder
    public /* bridge */ /* synthetic */ NegativeInteger decode(int r1) throws CborException {
        return decode(r1);
    }

    static {
        MINUS_ONE = BigInteger.valueOf(-1);
    }

    public NegativeIntegerDecoder(CborDecoder decoder, InputStream inputStream) {
        super(decoder, inputStream);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // co.nstant.in.cbor.decoder.AbstractDecoder
    public NegativeInteger decode(int initialByte) throws CborException {
        return new NegativeInteger(MINUS_ONE.subtract(getLengthAsBigInteger(initialByte)));
    }
}
