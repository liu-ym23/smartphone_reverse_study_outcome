package co.nstant.in.cbor.decoder;

import co.nstant.in.cbor.CborDecoder;
import co.nstant.in.cbor.CborException;
import co.nstant.in.cbor.model.DataItem;
import co.nstant.in.cbor.model.Map;
import co.nstant.in.cbor.model.Special;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class MapDecoder extends AbstractDecoder<Map> {
    @Override // co.nstant.in.cbor.decoder.AbstractDecoder
    public /* bridge */ /* synthetic */ Map decode(int r1) throws CborException {
        return decode(r1);
    }

    public MapDecoder(CborDecoder decoder, InputStream inputStream) {
        super(decoder, inputStream);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // co.nstant.in.cbor.decoder.AbstractDecoder
    public Map decode(int initialByte) throws CborException {
        long length = getLength(initialByte);
        if (length != (-1)) goto L7;
        return decodeInfinitiveLength();
    L7:
        return decodeFixedLength(length);
    }

    private Map decodeInfinitiveLength() throws CborException {
        Map map = new Map();
        map.setChunked(true);
        if (this.decoder.isAutoDecodeInfinitiveMaps() == false) goto L20;
    L4:
        DataItem key = this.decoder.decodeNext();
        if (Special.BREAK.equals(key) == true) goto L20;
        DataItem value = this.decoder.decodeNext();
        if (key == null) goto L19;
        if (value == null) goto L19;
        if (this.decoder.isRejectDuplicateKeys() == false) goto L17;
        if (map.get(key) == null) goto L17;
        throw new CborException("Duplicate key found in map");
    L17:
        map.put(key, value);
    L19:
        throw new CborException("Unexpected end of stream");
    L20:
        return map;
    }

    private Map decodeFixedLength(long length) throws CborException {
        Map map = new Map((int) length);
        long i = 0;
    L4:
        if (i >= length) goto L19;
        DataItem key = this.decoder.decodeNext();
        DataItem value = this.decoder.decodeNext();
        if (key == null) goto L17;
        if (value == null) goto L17;
        if (this.decoder.isRejectDuplicateKeys() == false) goto L15;
        if (map.get(key) == null) goto L15;
        throw new CborException("Duplicate key found in map");
    L15:
        map.put(key, value);
        i = i + 1;
    L17:
        throw new CborException("Unexpected end of stream");
    L19:
        return map;
    }
}
