package co.nstant.in.cbor.encoder;

import co.nstant.in.cbor.CborEncoder;
import co.nstant.in.cbor.CborException;
import co.nstant.in.cbor.model.MajorType;
import co.nstant.in.cbor.model.UnsignedInteger;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public class UnsignedIntegerEncoder extends AbstractEncoder<UnsignedInteger> {
    @Override // co.nstant.in.cbor.encoder.AbstractEncoder
    public /* bridge */ /* synthetic */ void encode(UnsignedInteger r1) throws CborException {
        encode2(r1);
    }

    public UnsignedIntegerEncoder(CborEncoder encoder, OutputStream outputStream) {
        super(encoder, outputStream);
    }

    /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
    public void encode2(UnsignedInteger dataItem) throws CborException {
        encodeTypeAndLength(MajorType.UNSIGNED_INTEGER, dataItem.getValue());
    }
}
