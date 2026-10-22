package co.nstant.in.cbor.decoder;

import co.nstant.in.cbor.CborDecoder;
import co.nstant.in.cbor.CborException;
import co.nstant.in.cbor.model.Array;
import co.nstant.in.cbor.model.DataItem;
import co.nstant.in.cbor.model.Special;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class ArrayDecoder extends AbstractDecoder<Array> {
    @Override // co.nstant.in.cbor.decoder.AbstractDecoder
    public /* bridge */ /* synthetic */ Array decode(int r1) throws CborException {
        return decode(r1);
    }

    public ArrayDecoder(CborDecoder decoder, InputStream inputStream) {
        super(decoder, inputStream);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // co.nstant.in.cbor.decoder.AbstractDecoder
    public Array decode(int initialByte) throws CborException {
        long length = getLength(initialByte);
        if (length != (-1)) goto L7;
        return decodeInfinitiveLength();
    L7:
        return decodeFixedLength(length);
    }

    private Array decodeInfinitiveLength() throws CborException {
        Array array = new Array();
        array.setChunked(true);
        if (this.decoder.isAutoDecodeInfinitiveArrays() == false) goto L12;
    L4:
        DataItem dataItem = this.decoder.decodeNext();
        if (dataItem == null) goto L11;
        if (Special.BREAK.equals(dataItem) == true) goto L8;
        array.add(dataItem);
        goto L4
    L8:
        array.add(Special.BREAK);
        goto L12
    L11:
        throw new CborException("Unexpected end of stream");
    L12:
        return array;
    }

    private Array decodeFixedLength(long length) throws CborException {
        Array array = new Array();
        long i = 0;
    L4:
        if (i >= length) goto L11;
        DataItem dataItem = this.decoder.decodeNext();
        if (dataItem == null) goto L9;
        array.add(dataItem);
        i = i + 1;
        goto L4
    L9:
        throw new CborException("Unexpected end of stream");
    L11:
        return array;
    }
}
