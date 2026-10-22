package co.nstant.in.cbor.encoder;

import co.nstant.in.cbor.CborEncoder;
import co.nstant.in.cbor.CborException;
import co.nstant.in.cbor.model.MajorType;
import co.nstant.in.cbor.model.Tag;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public class TagEncoder extends AbstractEncoder<Tag> {
    @Override // co.nstant.in.cbor.encoder.AbstractEncoder
    public /* bridge */ /* synthetic */ void encode(Tag r1) throws CborException {
        encode2(r1);
    }

    public TagEncoder(CborEncoder encoder, OutputStream outputStream) {
        super(encoder, outputStream);
    }

    /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
    public void encode2(Tag tag) throws CborException {
        encodeTypeAndLength(MajorType.TAG, tag.getValue());
    }
}
