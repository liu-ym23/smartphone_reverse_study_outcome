package co.nstant.in.cbor.encoder;

import co.nstant.in.cbor.CborEncoder;
import co.nstant.in.cbor.CborException;
import co.nstant.in.cbor.model.SinglePrecisionFloat;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public class SinglePrecisionFloatEncoder extends AbstractEncoder<SinglePrecisionFloat> {
    @Override // co.nstant.in.cbor.encoder.AbstractEncoder
    public /* bridge */ /* synthetic */ void encode(SinglePrecisionFloat r1) throws CborException {
        encode2(r1);
    }

    public SinglePrecisionFloatEncoder(CborEncoder encoder, OutputStream outputStream) {
        super(encoder, outputStream);
    }

    /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
    public void encode2(SinglePrecisionFloat dataItem) throws CborException {
        write(250);
        int bits = Float.floatToRawIntBits(dataItem.getValue());
        write((bits >> 24) & 255);
        write((bits >> 16) & 255);
        write((bits >> 8) & 255);
        write((bits >> 0) & 255);
    }
}
