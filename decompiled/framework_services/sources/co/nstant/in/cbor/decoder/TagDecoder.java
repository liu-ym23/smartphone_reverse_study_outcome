package co.nstant.in.cbor.decoder;

import co.nstant.in.cbor.CborDecoder;
import co.nstant.in.cbor.CborException;
import co.nstant.in.cbor.model.Tag;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class TagDecoder extends AbstractDecoder<Tag> {
    @Override // co.nstant.in.cbor.decoder.AbstractDecoder
    public /* bridge */ /* synthetic */ Tag decode(int r1) throws CborException {
        return decode(r1);
    }

    public TagDecoder(CborDecoder decoder, InputStream inputStream) {
        super(decoder, inputStream);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // co.nstant.in.cbor.decoder.AbstractDecoder
    public Tag decode(int initialByte) throws CborException {
        return new Tag(getLength(initialByte));
    }
}
