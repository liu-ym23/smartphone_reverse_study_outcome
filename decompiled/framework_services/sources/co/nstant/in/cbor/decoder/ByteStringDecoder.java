package co.nstant.in.cbor.decoder;

import co.nstant.in.cbor.CborDecoder;
import co.nstant.in.cbor.CborException;
import co.nstant.in.cbor.model.ByteString;
import co.nstant.in.cbor.model.DataItem;
import co.nstant.in.cbor.model.MajorType;
import co.nstant.in.cbor.model.Special;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class ByteStringDecoder extends AbstractDecoder<ByteString> {
    @Override // co.nstant.in.cbor.decoder.AbstractDecoder
    public /* bridge */ /* synthetic */ ByteString decode(int r1) throws CborException {
        return decode(r1);
    }

    public ByteStringDecoder(CborDecoder decoder, InputStream inputStream) {
        super(decoder, inputStream);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // co.nstant.in.cbor.decoder.AbstractDecoder
    public ByteString decode(int initialByte) throws CborException {
        long length = getLength(initialByte);
        if (length != (-1)) goto L11;
        if (this.decoder.isAutoDecodeInfinitiveByteStrings() == true) goto L7;
        ByteString byteString = new ByteString(null);
        byteString.setChunked(true);
        return byteString;
    L7:
        return decodeInfinitiveLength();
    L11:
        return decodeFixedLength(length);
    }

    private ByteString decodeInfinitiveLength() throws CborException {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
    L3:
        DataItem dataItem = this.decoder.decodeNext();
        if (dataItem == null) goto L18;
        MajorType majorType = dataItem.getMajorType();
        if (Special.BREAK.equals(dataItem) == true) goto L8;
        if (majorType != MajorType.BYTE_STRING) goto L16;
        ByteString byteString = (ByteString) dataItem;
        byte[] byteArray = byteString.getBytes();
        if (byteArray == null) goto L3;
        bytes.write(byteArray, 0, byteArray.length);
        goto L3
    L16:
        throw new CborException("Unexpected major type " + majorType);
    L8:
        return new ByteString(bytes.toByteArray());
    L18:
        throw new CborException("Unexpected end of stream");
    }

    private ByteString decodeFixedLength(long length) throws CborException {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream((int) length);
        long i = 0;
    L4:
        if (i >= length) goto L7;
        bytes.write(nextSymbol());
        i = i + 1;
        goto L4
    L7:
        return new ByteString(bytes.toByteArray());
    }
}
