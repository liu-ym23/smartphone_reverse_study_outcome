package co.nstant.in.cbor.encoder;

import co.nstant.in.cbor.CborEncoder;
import co.nstant.in.cbor.CborException;
import co.nstant.in.cbor.model.MajorType;
import co.nstant.in.cbor.model.NegativeInteger;
import java.io.OutputStream;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes.dex */
public class NegativeIntegerEncoder extends AbstractEncoder<NegativeInteger> {
    private static final BigInteger MINUS_ONE = null;

    @Override // co.nstant.in.cbor.encoder.AbstractEncoder
    public /* bridge */ /* synthetic */ void encode(NegativeInteger r1) throws CborException {
        encode2(r1);
    }

    static {
        MINUS_ONE = BigInteger.valueOf(-1);
    }

    public NegativeIntegerEncoder(CborEncoder encoder, OutputStream outputStream) {
        super(encoder, outputStream);
    }

    /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
    public void encode2(NegativeInteger dataItem) throws CborException {
        encodeTypeAndLength(MajorType.NEGATIVE_INTEGER, MINUS_ONE.subtract(dataItem.getValue()).abs());
    }
}
