package co.nstant.in.cbor.encoder;

import co.nstant.in.cbor.CborEncoder;
import co.nstant.in.cbor.CborException;
import co.nstant.in.cbor.model.DoublePrecisionFloat;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public class DoublePrecisionFloatEncoder extends AbstractEncoder<DoublePrecisionFloat> {
    @Override // co.nstant.in.cbor.encoder.AbstractEncoder
    public /* bridge */ /* synthetic */ void encode(DoublePrecisionFloat r1) throws CborException {
        encode2(r1);
    }

    public DoublePrecisionFloatEncoder(CborEncoder encoder, OutputStream outputStream) {
        super(encoder, outputStream);
    }

    /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
    public void encode2(DoublePrecisionFloat dataItem) throws CborException {
        write(251);
        long bits = Double.doubleToRawLongBits(dataItem.getValue());
        write((int) ((bits >> 56) & 255));
        write((int) ((bits >> 48) & 255));
        write((int) ((bits >> 40) & 255));
        write((int) ((bits >> 32) & 255));
        write((int) ((bits >> 24) & 255));
        write((int) ((bits >> 16) & 255));
        write((int) ((bits >> 8) & 255));
        write((int) ((bits >> 0) & 255));
    }
}
